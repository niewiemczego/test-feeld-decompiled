package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import com.google.android.exoplayer2.source.rtsp.RtspMediaPeriod;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.rtsp.RtspMessageChannel;
import com.google.android.exoplayer2.source.rtsp.RtspMessageUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.SocketFactory;

final class RtspClient implements Closeable {
    private static final long DEFAULT_RTSP_KEEP_ALIVE_INTERVAL_MS = 30000;
    public static final int RTSP_STATE_INIT = 0;
    public static final int RTSP_STATE_PLAYING = 2;
    public static final int RTSP_STATE_READY = 1;
    public static final int RTSP_STATE_UNINITIALIZED = -1;
    private static final String TAG = "RtspClient";
    private final boolean debugLoggingEnabled;
    /* access modifiers changed from: private */
    public boolean hasPendingPauseRequest;
    /* access modifiers changed from: private */
    public boolean hasUpdatedTimelineAndTracks;
    /* access modifiers changed from: private */
    public KeepAliveMonitor keepAliveMonitor;
    /* access modifiers changed from: private */
    public RtspMessageChannel messageChannel;
    /* access modifiers changed from: private */
    public final MessageSender messageSender = new MessageSender();
    /* access modifiers changed from: private */
    public final SparseArray<RtspRequest> pendingRequests = new SparseArray<>();
    /* access modifiers changed from: private */
    public long pendingSeekPositionUs;
    private final ArrayDeque<RtspMediaPeriod.RtpLoadInfo> pendingSetupRtpLoadInfos = new ArrayDeque<>();
    /* access modifiers changed from: private */
    public final PlaybackEventListener playbackEventListener;
    /* access modifiers changed from: private */
    public boolean receivedAuthorizationRequest;
    /* access modifiers changed from: private */
    public RtspMessageUtil.RtspAuthUserInfo rtspAuthUserInfo;
    /* access modifiers changed from: private */
    public RtspAuthenticationInfo rtspAuthenticationInfo;
    /* access modifiers changed from: private */
    public int rtspState;
    /* access modifiers changed from: private */
    public String sessionId;
    /* access modifiers changed from: private */
    public final SessionInfoListener sessionInfoListener;
    private final SocketFactory socketFactory;
    /* access modifiers changed from: private */
    public Uri uri;
    /* access modifiers changed from: private */
    public final String userAgent;

    public interface PlaybackEventListener {
        void onPlaybackError(RtspMediaSource.RtspPlaybackException rtspPlaybackException);

        void onPlaybackStarted(long j, ImmutableList<RtspTrackTiming> immutableList);

        void onRtspSetupCompleted();
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RtspState {
    }

    public interface SessionInfoListener {
        void onSessionTimelineRequestFailed(String str, Throwable th);

        void onSessionTimelineUpdated(RtspSessionTiming rtspSessionTiming, ImmutableList<RtspMediaTrack> immutableList);
    }

    public RtspClient(SessionInfoListener sessionInfoListener2, PlaybackEventListener playbackEventListener2, String str, Uri uri2, SocketFactory socketFactory2, boolean z) {
        this.sessionInfoListener = sessionInfoListener2;
        this.playbackEventListener = playbackEventListener2;
        this.userAgent = str;
        this.socketFactory = socketFactory2;
        this.debugLoggingEnabled = z;
        this.uri = RtspMessageUtil.removeUserInfo(uri2);
        this.messageChannel = new RtspMessageChannel(new MessageListener());
        this.rtspAuthUserInfo = RtspMessageUtil.parseUserInfo(uri2);
        this.pendingSeekPositionUs = C.TIME_UNSET;
        this.rtspState = -1;
    }

    public void start() throws IOException {
        try {
            this.messageChannel.open(getSocket(this.uri));
            this.messageSender.sendOptionsRequest(this.uri, this.sessionId);
        } catch (IOException e) {
            Util.closeQuietly(this.messageChannel);
            throw e;
        }
    }

    public int getState() {
        return this.rtspState;
    }

    public void setupSelectedTracks(List<RtspMediaPeriod.RtpLoadInfo> list) {
        this.pendingSetupRtpLoadInfos.addAll(list);
        continueSetupRtspTrack();
    }

    public void startPlayback(long j) {
        this.messageSender.sendPlayRequest(this.uri, j, (String) Assertions.checkNotNull(this.sessionId));
    }

    public void seekToUs(long j) {
        if (this.rtspState == 2 && !this.hasPendingPauseRequest) {
            this.messageSender.sendPauseRequest(this.uri, (String) Assertions.checkNotNull(this.sessionId));
        }
        this.pendingSeekPositionUs = j;
    }

    public void close() throws IOException {
        KeepAliveMonitor keepAliveMonitor2 = this.keepAliveMonitor;
        if (keepAliveMonitor2 != null) {
            keepAliveMonitor2.close();
            this.keepAliveMonitor = null;
            this.messageSender.sendTeardownRequest(this.uri, (String) Assertions.checkNotNull(this.sessionId));
        }
        this.messageChannel.close();
    }

    public void retryWithRtpTcp() {
        try {
            close();
            RtspMessageChannel rtspMessageChannel = new RtspMessageChannel(new MessageListener());
            this.messageChannel = rtspMessageChannel;
            rtspMessageChannel.open(getSocket(this.uri));
            this.sessionId = null;
            this.receivedAuthorizationRequest = false;
            this.rtspAuthenticationInfo = null;
        } catch (IOException e) {
            this.playbackEventListener.onPlaybackError(new RtspMediaSource.RtspPlaybackException((Throwable) e));
        }
    }

    public void registerInterleavedDataChannel(int i, RtspMessageChannel.InterleavedBinaryDataListener interleavedBinaryDataListener) {
        this.messageChannel.registerInterleavedBinaryDataListener(i, interleavedBinaryDataListener);
    }

    /* access modifiers changed from: private */
    public void continueSetupRtspTrack() {
        RtspMediaPeriod.RtpLoadInfo pollFirst = this.pendingSetupRtpLoadInfos.pollFirst();
        if (pollFirst == null) {
            this.playbackEventListener.onRtspSetupCompleted();
        } else {
            this.messageSender.sendSetupRequest(pollFirst.getTrackUri(), pollFirst.getTransport(), this.sessionId);
        }
    }

    /* access modifiers changed from: private */
    public void maybeLogMessage(List<String> list) {
        if (this.debugLoggingEnabled) {
            Log.d(TAG, Joiner.on("\n").join((Iterable<? extends Object>) list));
        }
    }

    private Socket getSocket(Uri uri2) throws IOException {
        Assertions.checkArgument(uri2.getHost() != null);
        return this.socketFactory.createSocket((String) Assertions.checkNotNull(uri2.getHost()), uri2.getPort() > 0 ? uri2.getPort() : RtspMessageChannel.DEFAULT_RTSP_PORT);
    }

    /* access modifiers changed from: private */
    public void dispatchRtspError(Throwable th) {
        RtspMediaSource.RtspPlaybackException rtspPlaybackException;
        if (th instanceof RtspMediaSource.RtspPlaybackException) {
            rtspPlaybackException = (RtspMediaSource.RtspPlaybackException) th;
        } else {
            rtspPlaybackException = new RtspMediaSource.RtspPlaybackException(th);
        }
        if (this.hasUpdatedTimelineAndTracks) {
            this.playbackEventListener.onPlaybackError(rtspPlaybackException);
        } else {
            this.sessionInfoListener.onSessionTimelineRequestFailed(Strings.nullToEmpty(th.getMessage()), th);
        }
    }

    /* access modifiers changed from: private */
    public static boolean serverSupportsDescribe(List<Integer> list) {
        return list.isEmpty() || list.contains(2);
    }

    /* access modifiers changed from: private */
    public static ImmutableList<RtspMediaTrack> buildTrackList(SessionDescription sessionDescription, Uri uri2) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i = 0; i < sessionDescription.mediaDescriptionList.size(); i++) {
            MediaDescription mediaDescription = (MediaDescription) sessionDescription.mediaDescriptionList.get(i);
            if (RtpPayloadFormat.isFormatSupported(mediaDescription)) {
                builder.add((Object) new RtspMediaTrack(mediaDescription, uri2));
            }
        }
        return builder.build();
    }

    private final class MessageSender {
        private int cSeq;
        private RtspRequest lastRequest;

        private MessageSender() {
        }

        public void sendOptionsRequest(Uri uri, String str) {
            sendRequest(getRequestWithCommonHeaders(4, str, ImmutableMap.of(), uri));
        }

        public void sendDescribeRequest(Uri uri, String str) {
            sendRequest(getRequestWithCommonHeaders(2, str, ImmutableMap.of(), uri));
        }

        public void sendSetupRequest(Uri uri, String str, String str2) {
            int unused = RtspClient.this.rtspState = 0;
            sendRequest(getRequestWithCommonHeaders(10, str2, ImmutableMap.of(RtspHeaders.TRANSPORT, str), uri));
        }

        public void sendPlayRequest(Uri uri, long j, String str) {
            boolean z = true;
            if (!(RtspClient.this.rtspState == 1 || RtspClient.this.rtspState == 2)) {
                z = false;
            }
            Assertions.checkState(z);
            sendRequest(getRequestWithCommonHeaders(6, str, ImmutableMap.of("Range", RtspSessionTiming.getOffsetStartTimeTiming(j)), uri));
        }

        public void sendTeardownRequest(Uri uri, String str) {
            if (RtspClient.this.rtspState != -1 && RtspClient.this.rtspState != 0) {
                int unused = RtspClient.this.rtspState = 0;
                sendRequest(getRequestWithCommonHeaders(12, str, ImmutableMap.of(), uri));
            }
        }

        public void sendPauseRequest(Uri uri, String str) {
            Assertions.checkState(RtspClient.this.rtspState == 2);
            sendRequest(getRequestWithCommonHeaders(5, str, ImmutableMap.of(), uri));
            boolean unused = RtspClient.this.hasPendingPauseRequest = true;
        }

        public void retryLastRequest() {
            Assertions.checkStateNotNull(this.lastRequest);
            ImmutableListMultimap<String, String> asMultiMap = this.lastRequest.headers.asMultiMap();
            HashMap hashMap = new HashMap();
            for (String next : asMultiMap.keySet()) {
                if (!next.equals(RtspHeaders.CSEQ) && !next.equals("User-Agent") && !next.equals(RtspHeaders.SESSION) && !next.equals("Authorization")) {
                    hashMap.put(next, (String) Iterables.getLast(asMultiMap.get(next)));
                }
            }
            sendRequest(getRequestWithCommonHeaders(this.lastRequest.method, RtspClient.this.sessionId, hashMap, this.lastRequest.uri));
        }

        public void sendMethodNotAllowedResponse(int i) {
            sendResponse(new RtspResponse(405, new RtspHeaders.Builder(RtspClient.this.userAgent, RtspClient.this.sessionId, i).build()));
            this.cSeq = Math.max(this.cSeq, i + 1);
        }

        private RtspRequest getRequestWithCommonHeaders(int i, String str, Map<String, String> map, Uri uri) {
            String access$400 = RtspClient.this.userAgent;
            int i2 = this.cSeq;
            this.cSeq = i2 + 1;
            RtspHeaders.Builder builder = new RtspHeaders.Builder(access$400, str, i2);
            if (RtspClient.this.rtspAuthenticationInfo != null) {
                Assertions.checkStateNotNull(RtspClient.this.rtspAuthUserInfo);
                try {
                    builder.add("Authorization", RtspClient.this.rtspAuthenticationInfo.getAuthorizationHeaderValue(RtspClient.this.rtspAuthUserInfo, uri, i));
                } catch (ParserException e) {
                    RtspClient.this.dispatchRtspError(new RtspMediaSource.RtspPlaybackException((Throwable) e));
                }
            }
            builder.addAll(map);
            return new RtspRequest(uri, i, builder.build(), "");
        }

        private void sendRequest(RtspRequest rtspRequest) {
            int parseInt = Integer.parseInt((String) Assertions.checkNotNull(rtspRequest.headers.get(RtspHeaders.CSEQ)));
            Assertions.checkState(RtspClient.this.pendingRequests.get(parseInt) == null);
            RtspClient.this.pendingRequests.append(parseInt, rtspRequest);
            ImmutableList<String> serializeRequest = RtspMessageUtil.serializeRequest(rtspRequest);
            RtspClient.this.maybeLogMessage(serializeRequest);
            RtspClient.this.messageChannel.send(serializeRequest);
            this.lastRequest = rtspRequest;
        }

        private void sendResponse(RtspResponse rtspResponse) {
            ImmutableList<String> serializeResponse = RtspMessageUtil.serializeResponse(rtspResponse);
            RtspClient.this.maybeLogMessage(serializeResponse);
            RtspClient.this.messageChannel.send(serializeResponse);
        }
    }

    private final class MessageListener implements RtspMessageChannel.MessageListener {
        private final Handler messageHandler = Util.createHandlerForCurrentLooper();

        public MessageListener() {
        }

        public void onRtspMessageReceived(List<String> list) {
            this.messageHandler.post(new RtspClient$MessageListener$$ExternalSyntheticLambda0(this, list));
        }

        /* access modifiers changed from: private */
        /* renamed from: handleRtspMessage */
        public void m524lambda$onRtspMessageReceived$0$comgoogleandroidexoplayer2sourcertspRtspClient$MessageListener(List<String> list) {
            RtspClient.this.maybeLogMessage(list);
            if (RtspMessageUtil.isRtspResponse(list)) {
                handleRtspResponse(list);
            } else {
                handleRtspRequest(list);
            }
        }

        private void handleRtspRequest(List<String> list) {
            RtspClient.this.messageSender.sendMethodNotAllowedResponse(Integer.parseInt((String) Assertions.checkNotNull(RtspMessageUtil.parseRequest(list).headers.get(RtspHeaders.CSEQ))));
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(2:56|57) */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            r1 = com.google.common.collect.ImmutableList.of();
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x0174 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void handleRtspResponse(java.util.List<java.lang.String> r6) {
            /*
                r5 = this;
                com.google.android.exoplayer2.source.rtsp.RtspResponse r6 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.parseResponse(r6)
                com.google.android.exoplayer2.source.rtsp.RtspHeaders r0 = r6.headers
                java.lang.String r1 = "CSeq"
                java.lang.String r0 = r0.get(r1)
                java.lang.Object r0 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r0)
                java.lang.String r0 = (java.lang.String) r0
                int r0 = java.lang.Integer.parseInt(r0)
                com.google.android.exoplayer2.source.rtsp.RtspClient r1 = com.google.android.exoplayer2.source.rtsp.RtspClient.this
                android.util.SparseArray r1 = r1.pendingRequests
                java.lang.Object r1 = r1.get(r0)
                com.google.android.exoplayer2.source.rtsp.RtspRequest r1 = (com.google.android.exoplayer2.source.rtsp.RtspRequest) r1
                if (r1 != 0) goto L_0x0025
                return
            L_0x0025:
                com.google.android.exoplayer2.source.rtsp.RtspClient r2 = com.google.android.exoplayer2.source.rtsp.RtspClient.this
                android.util.SparseArray r2 = r2.pendingRequests
                r2.remove(r0)
                int r0 = r1.method
                int r1 = r6.status     // Catch:{ ParserException -> 0x01b3 }
                r2 = 200(0xc8, float:2.8E-43)
                r3 = 0
                if (r1 == r2) goto L_0x0117
                r2 = 401(0x191, float:5.62E-43)
                r4 = 0
                if (r1 == r2) goto L_0x0096
                r2 = 301(0x12d, float:4.22E-43)
                if (r1 == r2) goto L_0x0046
                r2 = 302(0x12e, float:4.23E-43)
                if (r1 == r2) goto L_0x0046
                goto L_0x00ef
            L_0x0046:
                com.google.android.exoplayer2.source.rtsp.RtspClient r0 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x01b3 }
                int r0 = r0.rtspState     // Catch:{ ParserException -> 0x01b3 }
                r1 = -1
                if (r0 == r1) goto L_0x0054
                com.google.android.exoplayer2.source.rtsp.RtspClient r0 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x01b3 }
                int unused = r0.rtspState = r4     // Catch:{ ParserException -> 0x01b3 }
            L_0x0054:
                com.google.android.exoplayer2.source.rtsp.RtspHeaders r6 = r6.headers     // Catch:{ ParserException -> 0x01b3 }
                java.lang.String r0 = "Location"
                java.lang.String r6 = r6.get(r0)     // Catch:{ ParserException -> 0x01b3 }
                if (r6 != 0) goto L_0x006a
                com.google.android.exoplayer2.source.rtsp.RtspClient r6 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspClient$SessionInfoListener r6 = r6.sessionInfoListener     // Catch:{ ParserException -> 0x01b3 }
                java.lang.String r0 = "Redirection without new location."
                r6.onSessionTimelineRequestFailed(r0, r3)     // Catch:{ ParserException -> 0x01b3 }
                goto L_0x0095
            L_0x006a:
                android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspClient r0 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x01b3 }
                android.net.Uri r1 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.removeUserInfo(r6)     // Catch:{ ParserException -> 0x01b3 }
                android.net.Uri unused = r0.uri = r1     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspClient r0 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspMessageUtil$RtspAuthUserInfo r6 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.parseUserInfo(r6)     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.RtspAuthUserInfo unused = r0.rtspAuthUserInfo = r6     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspClient r6 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspClient$MessageSender r6 = r6.messageSender     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspClient r0 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x01b3 }
                android.net.Uri r0 = r0.uri     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspClient r1 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x01b3 }
                java.lang.String r1 = r1.sessionId     // Catch:{ ParserException -> 0x01b3 }
                r6.sendDescribeRequest(r0, r1)     // Catch:{ ParserException -> 0x01b3 }
            L_0x0095:
                return
            L_0x0096:
                com.google.android.exoplayer2.source.rtsp.RtspClient r1 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspMessageUtil$RtspAuthUserInfo r1 = r1.rtspAuthUserInfo     // Catch:{ ParserException -> 0x01b3 }
                if (r1 == 0) goto L_0x00ef
                com.google.android.exoplayer2.source.rtsp.RtspClient r1 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x01b3 }
                boolean r1 = r1.receivedAuthorizationRequest     // Catch:{ ParserException -> 0x01b3 }
                if (r1 != 0) goto L_0x00ef
                com.google.android.exoplayer2.source.rtsp.RtspHeaders r6 = r6.headers     // Catch:{ ParserException -> 0x01b3 }
                java.lang.String r0 = "WWW-Authenticate"
                com.google.common.collect.ImmutableList r6 = r6.values(r0)     // Catch:{ ParserException -> 0x01b3 }
                boolean r0 = r6.isEmpty()     // Catch:{ ParserException -> 0x01b3 }
                if (r0 != 0) goto L_0x00e8
            L_0x00b4:
                int r0 = r6.size()     // Catch:{ ParserException -> 0x01b3 }
                if (r4 >= r0) goto L_0x00d8
                com.google.android.exoplayer2.source.rtsp.RtspClient r0 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x01b3 }
                java.lang.Object r1 = r6.get(r4)     // Catch:{ ParserException -> 0x01b3 }
                java.lang.String r1 = (java.lang.String) r1     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspAuthenticationInfo r1 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.parseWwwAuthenticateHeader(r1)     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspAuthenticationInfo unused = r0.rtspAuthenticationInfo = r1     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspClient r0 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspAuthenticationInfo r0 = r0.rtspAuthenticationInfo     // Catch:{ ParserException -> 0x01b3 }
                int r0 = r0.authenticationMechanism     // Catch:{ ParserException -> 0x01b3 }
                r1 = 2
                if (r0 != r1) goto L_0x00d5
                goto L_0x00d8
            L_0x00d5:
                int r4 = r4 + 1
                goto L_0x00b4
            L_0x00d8:
                com.google.android.exoplayer2.source.rtsp.RtspClient r6 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspClient$MessageSender r6 = r6.messageSender     // Catch:{ ParserException -> 0x01b3 }
                r6.retryLastRequest()     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspClient r6 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x01b3 }
                r0 = 1
                boolean unused = r6.receivedAuthorizationRequest = r0     // Catch:{ ParserException -> 0x01b3 }
                return
            L_0x00e8:
                java.lang.String r6 = "Missing WWW-Authenticate header in a 401 response."
                com.google.android.exoplayer2.ParserException r6 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r6, r3)     // Catch:{ ParserException -> 0x01b3 }
                throw r6     // Catch:{ ParserException -> 0x01b3 }
            L_0x00ef:
                com.google.android.exoplayer2.source.rtsp.RtspClient r1 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspMediaSource$RtspPlaybackException r2 = new com.google.android.exoplayer2.source.rtsp.RtspMediaSource$RtspPlaybackException     // Catch:{ ParserException -> 0x01b3 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ParserException -> 0x01b3 }
                r3.<init>()     // Catch:{ ParserException -> 0x01b3 }
                java.lang.String r0 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.toMethodString(r0)     // Catch:{ ParserException -> 0x01b3 }
                java.lang.StringBuilder r0 = r3.append(r0)     // Catch:{ ParserException -> 0x01b3 }
                java.lang.String r3 = " "
                java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ ParserException -> 0x01b3 }
                int r6 = r6.status     // Catch:{ ParserException -> 0x01b3 }
                java.lang.StringBuilder r6 = r0.append(r6)     // Catch:{ ParserException -> 0x01b3 }
                java.lang.String r6 = r6.toString()     // Catch:{ ParserException -> 0x01b3 }
                r2.<init>((java.lang.String) r6)     // Catch:{ ParserException -> 0x01b3 }
                r1.dispatchRtspError(r2)     // Catch:{ ParserException -> 0x01b3 }
                return
            L_0x0117:
                switch(r0) {
                    case 1: goto L_0x01be;
                    case 2: goto L_0x019e;
                    case 3: goto L_0x01be;
                    case 4: goto L_0x0187;
                    case 5: goto L_0x0183;
                    case 6: goto L_0x0149;
                    case 7: goto L_0x01be;
                    case 8: goto L_0x01be;
                    case 9: goto L_0x01be;
                    case 10: goto L_0x011e;
                    case 11: goto L_0x01be;
                    case 12: goto L_0x01be;
                    default: goto L_0x011a;
                }     // Catch:{ ParserException -> 0x01b3 }
            L_0x011a:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ ParserException -> 0x01b3 }
                goto L_0x01af
            L_0x011e:
                com.google.android.exoplayer2.source.rtsp.RtspHeaders r0 = r6.headers     // Catch:{ ParserException -> 0x01b3 }
                java.lang.String r1 = "Session"
                java.lang.String r0 = r0.get(r1)     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspHeaders r1 = r6.headers     // Catch:{ ParserException -> 0x01b3 }
                java.lang.String r2 = "Transport"
                java.lang.String r1 = r1.get(r2)     // Catch:{ ParserException -> 0x01b3 }
                if (r0 == 0) goto L_0x0142
                if (r1 == 0) goto L_0x0142
                com.google.android.exoplayer2.source.rtsp.RtspMessageUtil$RtspSessionHeader r0 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.parseSessionHeader(r0)     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspSetupResponse r2 = new com.google.android.exoplayer2.source.rtsp.RtspSetupResponse     // Catch:{ ParserException -> 0x01b3 }
                int r6 = r6.status     // Catch:{ ParserException -> 0x01b3 }
                r2.<init>(r6, r0, r1)     // Catch:{ ParserException -> 0x01b3 }
                r5.onSetupResponseReceived(r2)     // Catch:{ ParserException -> 0x01b3 }
                goto L_0x01be
            L_0x0142:
                java.lang.String r6 = "Missing mandatory session or transport header"
                com.google.android.exoplayer2.ParserException r6 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r6, r3)     // Catch:{ ParserException -> 0x01b3 }
                throw r6     // Catch:{ ParserException -> 0x01b3 }
            L_0x0149:
                com.google.android.exoplayer2.source.rtsp.RtspHeaders r0 = r6.headers     // Catch:{ ParserException -> 0x01b3 }
                java.lang.String r1 = "Range"
                java.lang.String r0 = r0.get(r1)     // Catch:{ ParserException -> 0x01b3 }
                if (r0 != 0) goto L_0x0156
                com.google.android.exoplayer2.source.rtsp.RtspSessionTiming r0 = com.google.android.exoplayer2.source.rtsp.RtspSessionTiming.DEFAULT     // Catch:{ ParserException -> 0x01b3 }
                goto L_0x015a
            L_0x0156:
                com.google.android.exoplayer2.source.rtsp.RtspSessionTiming r0 = com.google.android.exoplayer2.source.rtsp.RtspSessionTiming.parseTiming(r0)     // Catch:{ ParserException -> 0x01b3 }
            L_0x015a:
                com.google.android.exoplayer2.source.rtsp.RtspHeaders r1 = r6.headers     // Catch:{ ParserException -> 0x0174 }
                java.lang.String r2 = "RTP-Info"
                java.lang.String r1 = r1.get(r2)     // Catch:{ ParserException -> 0x0174 }
                if (r1 != 0) goto L_0x0169
                com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.of()     // Catch:{ ParserException -> 0x0174 }
                goto L_0x0178
            L_0x0169:
                com.google.android.exoplayer2.source.rtsp.RtspClient r2 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x0174 }
                android.net.Uri r2 = r2.uri     // Catch:{ ParserException -> 0x0174 }
                com.google.common.collect.ImmutableList r1 = com.google.android.exoplayer2.source.rtsp.RtspTrackTiming.parseTrackTiming(r1, r2)     // Catch:{ ParserException -> 0x0174 }
                goto L_0x0178
            L_0x0174:
                com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.of()     // Catch:{ ParserException -> 0x01b3 }
            L_0x0178:
                com.google.android.exoplayer2.source.rtsp.RtspPlayResponse r2 = new com.google.android.exoplayer2.source.rtsp.RtspPlayResponse     // Catch:{ ParserException -> 0x01b3 }
                int r6 = r6.status     // Catch:{ ParserException -> 0x01b3 }
                r2.<init>(r6, r0, r1)     // Catch:{ ParserException -> 0x01b3 }
                r5.onPlayResponseReceived(r2)     // Catch:{ ParserException -> 0x01b3 }
                goto L_0x01be
            L_0x0183:
                r5.onPauseResponseReceived()     // Catch:{ ParserException -> 0x01b3 }
                goto L_0x01be
            L_0x0187:
                com.google.android.exoplayer2.source.rtsp.RtspOptionsResponse r0 = new com.google.android.exoplayer2.source.rtsp.RtspOptionsResponse     // Catch:{ ParserException -> 0x01b3 }
                int r1 = r6.status     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.RtspHeaders r6 = r6.headers     // Catch:{ ParserException -> 0x01b3 }
                java.lang.String r2 = "Public"
                java.lang.String r6 = r6.get(r2)     // Catch:{ ParserException -> 0x01b3 }
                com.google.common.collect.ImmutableList r6 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.parsePublicHeader(r6)     // Catch:{ ParserException -> 0x01b3 }
                r0.<init>(r1, r6)     // Catch:{ ParserException -> 0x01b3 }
                r5.onOptionsResponseReceived(r0)     // Catch:{ ParserException -> 0x01b3 }
                goto L_0x01be
            L_0x019e:
                com.google.android.exoplayer2.source.rtsp.RtspDescribeResponse r0 = new com.google.android.exoplayer2.source.rtsp.RtspDescribeResponse     // Catch:{ ParserException -> 0x01b3 }
                int r1 = r6.status     // Catch:{ ParserException -> 0x01b3 }
                java.lang.String r6 = r6.messageBody     // Catch:{ ParserException -> 0x01b3 }
                com.google.android.exoplayer2.source.rtsp.SessionDescription r6 = com.google.android.exoplayer2.source.rtsp.SessionDescriptionParser.parse(r6)     // Catch:{ ParserException -> 0x01b3 }
                r0.<init>(r1, r6)     // Catch:{ ParserException -> 0x01b3 }
                r5.onDescribeResponseReceived(r0)     // Catch:{ ParserException -> 0x01b3 }
                goto L_0x01be
            L_0x01af:
                r6.<init>()     // Catch:{ ParserException -> 0x01b3 }
                throw r6     // Catch:{ ParserException -> 0x01b3 }
            L_0x01b3:
                r6 = move-exception
                com.google.android.exoplayer2.source.rtsp.RtspClient r0 = com.google.android.exoplayer2.source.rtsp.RtspClient.this
                com.google.android.exoplayer2.source.rtsp.RtspMediaSource$RtspPlaybackException r1 = new com.google.android.exoplayer2.source.rtsp.RtspMediaSource$RtspPlaybackException
                r1.<init>((java.lang.Throwable) r6)
                r0.dispatchRtspError(r1)
            L_0x01be:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.rtsp.RtspClient.MessageListener.handleRtspResponse(java.util.List):void");
        }

        private void onOptionsResponseReceived(RtspOptionsResponse rtspOptionsResponse) {
            if (RtspClient.this.keepAliveMonitor == null) {
                if (RtspClient.serverSupportsDescribe(rtspOptionsResponse.supportedMethods)) {
                    RtspClient.this.messageSender.sendDescribeRequest(RtspClient.this.uri, RtspClient.this.sessionId);
                } else {
                    RtspClient.this.sessionInfoListener.onSessionTimelineRequestFailed("DESCRIBE not supported.", (Throwable) null);
                }
            }
        }

        private void onDescribeResponseReceived(RtspDescribeResponse rtspDescribeResponse) {
            RtspSessionTiming rtspSessionTiming = RtspSessionTiming.DEFAULT;
            String str = rtspDescribeResponse.sessionDescription.attributes.get(SessionDescription.ATTR_RANGE);
            if (str != null) {
                try {
                    rtspSessionTiming = RtspSessionTiming.parseTiming(str);
                } catch (ParserException e) {
                    RtspClient.this.sessionInfoListener.onSessionTimelineRequestFailed("SDP format error.", e);
                    return;
                }
            }
            ImmutableList access$1700 = RtspClient.buildTrackList(rtspDescribeResponse.sessionDescription, RtspClient.this.uri);
            if (access$1700.isEmpty()) {
                RtspClient.this.sessionInfoListener.onSessionTimelineRequestFailed("No playable track.", (Throwable) null);
                return;
            }
            RtspClient.this.sessionInfoListener.onSessionTimelineUpdated(rtspSessionTiming, access$1700);
            boolean unused = RtspClient.this.hasUpdatedTimelineAndTracks = true;
        }

        private void onSetupResponseReceived(RtspSetupResponse rtspSetupResponse) {
            Assertions.checkState(RtspClient.this.rtspState != -1);
            int unused = RtspClient.this.rtspState = 1;
            String unused2 = RtspClient.this.sessionId = rtspSetupResponse.sessionHeader.sessionId;
            RtspClient.this.continueSetupRtspTrack();
        }

        private void onPlayResponseReceived(RtspPlayResponse rtspPlayResponse) {
            boolean z = true;
            if (RtspClient.this.rtspState != 1) {
                z = false;
            }
            Assertions.checkState(z);
            int unused = RtspClient.this.rtspState = 2;
            if (RtspClient.this.keepAliveMonitor == null) {
                KeepAliveMonitor unused2 = RtspClient.this.keepAliveMonitor = new KeepAliveMonitor(30000);
                RtspClient.this.keepAliveMonitor.start();
            }
            long unused3 = RtspClient.this.pendingSeekPositionUs = C.TIME_UNSET;
            RtspClient.this.playbackEventListener.onPlaybackStarted(Util.msToUs(rtspPlayResponse.sessionTiming.startTimeMs), rtspPlayResponse.trackTimingList);
        }

        private void onPauseResponseReceived() {
            Assertions.checkState(RtspClient.this.rtspState == 2);
            int unused = RtspClient.this.rtspState = 1;
            boolean unused2 = RtspClient.this.hasPendingPauseRequest = false;
            if (RtspClient.this.pendingSeekPositionUs != C.TIME_UNSET) {
                RtspClient rtspClient = RtspClient.this;
                rtspClient.startPlayback(Util.usToMs(rtspClient.pendingSeekPositionUs));
            }
        }
    }

    private final class KeepAliveMonitor implements Runnable, Closeable {
        private final long intervalMs;
        private boolean isStarted;
        private final Handler keepAliveHandler = Util.createHandlerForCurrentLooper();

        public KeepAliveMonitor(long j) {
            this.intervalMs = j;
        }

        public void start() {
            if (!this.isStarted) {
                this.isStarted = true;
                this.keepAliveHandler.postDelayed(this, this.intervalMs);
            }
        }

        public void run() {
            RtspClient.this.messageSender.sendOptionsRequest(RtspClient.this.uri, RtspClient.this.sessionId);
            this.keepAliveHandler.postDelayed(this, this.intervalMs);
        }

        public void close() {
            this.isStarted = false;
            this.keepAliveHandler.removeCallbacks(this);
        }
    }
}
