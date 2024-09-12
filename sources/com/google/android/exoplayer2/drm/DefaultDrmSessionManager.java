package com.google.android.exoplayer2.drm;

import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public class DefaultDrmSessionManager implements DrmSessionManager {
    public static final long DEFAULT_SESSION_KEEPALIVE_MS = 300000;
    public static final int INITIAL_DRM_REQUEST_RETRY_COUNT = 3;
    public static final int MODE_DOWNLOAD = 2;
    public static final int MODE_PLAYBACK = 0;
    public static final int MODE_QUERY = 1;
    public static final int MODE_RELEASE = 3;
    public static final String PLAYREADY_CUSTOM_DATA_KEY = "PRCustomData";
    private static final String TAG = "DefaultDrmSessionMgr";
    private final MediaDrmCallback callback;
    private ExoMediaDrm exoMediaDrm;
    private final ExoMediaDrm.Provider exoMediaDrmProvider;
    /* access modifiers changed from: private */
    public final Set<DefaultDrmSession> keepaliveSessions;
    private final HashMap<String, String> keyRequestParameters;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    volatile MediaDrmHandler mediaDrmHandler;
    private int mode;
    private final boolean multiSession;
    /* access modifiers changed from: private */
    public DefaultDrmSession noMultiSessionDrmSession;
    private byte[] offlineLicenseKeySetId;
    /* access modifiers changed from: private */
    public DefaultDrmSession placeholderDrmSession;
    private final boolean playClearSamplesWithoutKeys;
    /* access modifiers changed from: private */
    public Handler playbackHandler;
    /* access modifiers changed from: private */
    public Looper playbackLooper;
    private PlayerId playerId;
    /* access modifiers changed from: private */
    public final Set<PreacquiredSessionReference> preacquiredSessionReferences;
    /* access modifiers changed from: private */
    public int prepareCallsCount;
    /* access modifiers changed from: private */
    public final ProvisioningManagerImpl provisioningManagerImpl;
    private final ReferenceCountListenerImpl referenceCountListener;
    /* access modifiers changed from: private */
    public final long sessionKeepaliveMs;
    /* access modifiers changed from: private */
    public final List<DefaultDrmSession> sessions;
    private final int[] useDrmSessionsForClearContentTrackTypes;
    private final UUID uuid;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public static final class Builder {
        private ExoMediaDrm.Provider exoMediaDrmProvider = FrameworkMediaDrm.DEFAULT_PROVIDER;
        private final HashMap<String, String> keyRequestParameters = new HashMap<>();
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        private boolean multiSession;
        private boolean playClearSamplesWithoutKeys;
        private long sessionKeepaliveMs = 300000;
        private int[] useDrmSessionsForClearContentTrackTypes = new int[0];
        private UUID uuid = C.WIDEVINE_UUID;

        public Builder setKeyRequestParameters(Map<String, String> map) {
            this.keyRequestParameters.clear();
            if (map != null) {
                this.keyRequestParameters.putAll(map);
            }
            return this;
        }

        public Builder setUuidAndExoMediaDrmProvider(UUID uuid2, ExoMediaDrm.Provider provider) {
            this.uuid = (UUID) Assertions.checkNotNull(uuid2);
            this.exoMediaDrmProvider = (ExoMediaDrm.Provider) Assertions.checkNotNull(provider);
            return this;
        }

        public Builder setMultiSession(boolean z) {
            this.multiSession = z;
            return this;
        }

        public Builder setUseDrmSessionsForClearContent(int... iArr) {
            for (int i : iArr) {
                boolean z = true;
                if (!(i == 2 || i == 1)) {
                    z = false;
                }
                Assertions.checkArgument(z);
            }
            this.useDrmSessionsForClearContentTrackTypes = (int[]) iArr.clone();
            return this;
        }

        public Builder setPlayClearSamplesWithoutKeys(boolean z) {
            this.playClearSamplesWithoutKeys = z;
            return this;
        }

        public Builder setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy2) {
            this.loadErrorHandlingPolicy = (LoadErrorHandlingPolicy) Assertions.checkNotNull(loadErrorHandlingPolicy2);
            return this;
        }

        public Builder setSessionKeepaliveMs(long j) {
            Assertions.checkArgument(j > 0 || j == C.TIME_UNSET);
            this.sessionKeepaliveMs = j;
            return this;
        }

        public DefaultDrmSessionManager build(MediaDrmCallback mediaDrmCallback) {
            return new DefaultDrmSessionManager(this.uuid, this.exoMediaDrmProvider, mediaDrmCallback, this.keyRequestParameters, this.multiSession, this.useDrmSessionsForClearContentTrackTypes, this.playClearSamplesWithoutKeys, this.loadErrorHandlingPolicy, this.sessionKeepaliveMs);
        }
    }

    public static final class MissingSchemeDataException extends Exception {
        private MissingSchemeDataException(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public DefaultDrmSessionManager(UUID uuid2, ExoMediaDrm exoMediaDrm2, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap) {
        this(uuid2, exoMediaDrm2, mediaDrmCallback, hashMap == null ? new HashMap<>() : hashMap, false, 3);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public DefaultDrmSessionManager(UUID uuid2, ExoMediaDrm exoMediaDrm2, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, boolean z) {
        this(uuid2, exoMediaDrm2, mediaDrmCallback, hashMap == null ? new HashMap<>() : hashMap, z, 3);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public DefaultDrmSessionManager(UUID uuid2, ExoMediaDrm exoMediaDrm2, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, boolean z, int i) {
        this(uuid2, new ExoMediaDrm.AppManagedProvider(exoMediaDrm2), mediaDrmCallback, hashMap == null ? new HashMap<>() : hashMap, z, new int[0], false, new DefaultLoadErrorHandlingPolicy(i), 300000);
        ExoMediaDrm exoMediaDrm3 = exoMediaDrm2;
    }

    private DefaultDrmSessionManager(UUID uuid2, ExoMediaDrm.Provider provider, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, boolean z, int[] iArr, boolean z2, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, long j) {
        Assertions.checkNotNull(uuid2);
        Assertions.checkArgument(!C.COMMON_PSSH_UUID.equals(uuid2), "Use C.CLEARKEY_UUID instead");
        this.uuid = uuid2;
        this.exoMediaDrmProvider = provider;
        this.callback = mediaDrmCallback;
        this.keyRequestParameters = hashMap;
        this.multiSession = z;
        this.useDrmSessionsForClearContentTrackTypes = iArr;
        this.playClearSamplesWithoutKeys = z2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.provisioningManagerImpl = new ProvisioningManagerImpl(this);
        this.referenceCountListener = new ReferenceCountListenerImpl();
        this.mode = 0;
        this.sessions = new ArrayList();
        this.preacquiredSessionReferences = Sets.newIdentityHashSet();
        this.keepaliveSessions = Sets.newIdentityHashSet();
        this.sessionKeepaliveMs = j;
    }

    public void setMode(int i, byte[] bArr) {
        Assertions.checkState(this.sessions.isEmpty());
        if (i == 1 || i == 3) {
            Assertions.checkNotNull(bArr);
        }
        this.mode = i;
        this.offlineLicenseKeySetId = bArr;
    }

    public final void prepare() {
        int i = this.prepareCallsCount;
        this.prepareCallsCount = i + 1;
        if (i == 0) {
            if (this.exoMediaDrm == null) {
                ExoMediaDrm acquireExoMediaDrm = this.exoMediaDrmProvider.acquireExoMediaDrm(this.uuid);
                this.exoMediaDrm = acquireExoMediaDrm;
                acquireExoMediaDrm.setOnEventListener(new MediaDrmEventListener());
            } else if (this.sessionKeepaliveMs != C.TIME_UNSET) {
                for (int i2 = 0; i2 < this.sessions.size(); i2++) {
                    this.sessions.get(i2).acquire((DrmSessionEventListener.EventDispatcher) null);
                }
            }
        }
    }

    public final void release() {
        int i = this.prepareCallsCount - 1;
        this.prepareCallsCount = i;
        if (i == 0) {
            if (this.sessionKeepaliveMs != C.TIME_UNSET) {
                ArrayList arrayList = new ArrayList(this.sessions);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    ((DefaultDrmSession) arrayList.get(i2)).release((DrmSessionEventListener.EventDispatcher) null);
                }
            }
            releaseAllPreacquiredSessions();
            maybeReleaseMediaDrm();
        }
    }

    public void setPlayer(Looper looper, PlayerId playerId2) {
        initPlaybackLooper(looper);
        this.playerId = playerId2;
    }

    public DrmSessionManager.DrmSessionReference preacquireSession(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        Assertions.checkState(this.prepareCallsCount > 0);
        Assertions.checkStateNotNull(this.playbackLooper);
        PreacquiredSessionReference preacquiredSessionReference = new PreacquiredSessionReference(eventDispatcher);
        preacquiredSessionReference.acquire(format);
        return preacquiredSessionReference;
    }

    public DrmSession acquireSession(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        Assertions.checkState(this.prepareCallsCount > 0);
        Assertions.checkStateNotNull(this.playbackLooper);
        return acquireSession(this.playbackLooper, eventDispatcher, format, true);
    }

    /* access modifiers changed from: private */
    public DrmSession acquireSession(Looper looper, DrmSessionEventListener.EventDispatcher eventDispatcher, Format format, boolean z) {
        List<DrmInitData.SchemeData> list;
        maybeCreateMediaDrmHandler(looper);
        if (format.drmInitData == null) {
            return maybeAcquirePlaceholderSession(MimeTypes.getTrackType(format.sampleMimeType), z);
        }
        DefaultDrmSession defaultDrmSession = null;
        if (this.offlineLicenseKeySetId == null) {
            list = getSchemeDatas((DrmInitData) Assertions.checkNotNull(format.drmInitData), this.uuid, false);
            if (list.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.uuid);
                Log.e(TAG, "DRM error", missingSchemeDataException);
                if (eventDispatcher != null) {
                    eventDispatcher.drmSessionManagerError(missingSchemeDataException);
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(missingSchemeDataException, PlaybackException.ERROR_CODE_DRM_CONTENT_ERROR));
            }
        } else {
            list = null;
        }
        if (this.multiSession) {
            Iterator<DefaultDrmSession> it = this.sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DefaultDrmSession next = it.next();
                if (Util.areEqual(next.schemeDatas, list)) {
                    defaultDrmSession = next;
                    break;
                }
            }
        } else {
            defaultDrmSession = this.noMultiSessionDrmSession;
        }
        if (defaultDrmSession == null) {
            defaultDrmSession = createAndAcquireSessionWithRetry(list, false, eventDispatcher, z);
            if (!this.multiSession) {
                this.noMultiSessionDrmSession = defaultDrmSession;
            }
            this.sessions.add(defaultDrmSession);
        } else {
            defaultDrmSession.acquire(eventDispatcher);
        }
        return defaultDrmSession;
    }

    public int getCryptoType(Format format) {
        int cryptoType = ((ExoMediaDrm) Assertions.checkNotNull(this.exoMediaDrm)).getCryptoType();
        if (format.drmInitData == null) {
            if (Util.linearSearch(this.useDrmSessionsForClearContentTrackTypes, MimeTypes.getTrackType(format.sampleMimeType)) != -1) {
                return cryptoType;
            }
            return 0;
        } else if (canAcquireSession(format.drmInitData)) {
            return cryptoType;
        } else {
            return 1;
        }
    }

    private DrmSession maybeAcquirePlaceholderSession(int i, boolean z) {
        ExoMediaDrm exoMediaDrm2 = (ExoMediaDrm) Assertions.checkNotNull(this.exoMediaDrm);
        if ((exoMediaDrm2.getCryptoType() == 2 && FrameworkCryptoConfig.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC) || Util.linearSearch(this.useDrmSessionsForClearContentTrackTypes, i) == -1 || exoMediaDrm2.getCryptoType() == 1) {
            return null;
        }
        DefaultDrmSession defaultDrmSession = this.placeholderDrmSession;
        if (defaultDrmSession == null) {
            DefaultDrmSession createAndAcquireSessionWithRetry = createAndAcquireSessionWithRetry(ImmutableList.of(), true, (DrmSessionEventListener.EventDispatcher) null, z);
            this.sessions.add(createAndAcquireSessionWithRetry);
            this.placeholderDrmSession = createAndAcquireSessionWithRetry;
        } else {
            defaultDrmSession.acquire((DrmSessionEventListener.EventDispatcher) null);
        }
        return this.placeholderDrmSession;
    }

    private boolean canAcquireSession(DrmInitData drmInitData) {
        if (this.offlineLicenseKeySetId != null) {
            return true;
        }
        if (getSchemeDatas(drmInitData, this.uuid, true).isEmpty()) {
            if (drmInitData.schemeDataCount != 1 || !drmInitData.get(0).matches(C.COMMON_PSSH_UUID)) {
                return false;
            }
            Log.w(TAG, "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.uuid);
        }
        String str = drmInitData.schemeType;
        if (str == null || C.CENC_TYPE_cenc.equals(str)) {
            return true;
        }
        if (C.CENC_TYPE_cbcs.equals(str)) {
            if (Util.SDK_INT >= 25) {
                return true;
            }
            return false;
        } else if (C.CENC_TYPE_cbc1.equals(str) || C.CENC_TYPE_cens.equals(str)) {
            return false;
        } else {
            return true;
        }
    }

    @EnsuresNonNull({"this.playbackLooper", "this.playbackHandler"})
    private synchronized void initPlaybackLooper(Looper looper) {
        Looper looper2 = this.playbackLooper;
        if (looper2 == null) {
            this.playbackLooper = looper;
            this.playbackHandler = new Handler(looper);
        } else {
            Assertions.checkState(looper2 == looper);
            Assertions.checkNotNull(this.playbackHandler);
        }
    }

    private void maybeCreateMediaDrmHandler(Looper looper) {
        if (this.mediaDrmHandler == null) {
            this.mediaDrmHandler = new MediaDrmHandler(looper);
        }
    }

    private DefaultDrmSession createAndAcquireSessionWithRetry(List<DrmInitData.SchemeData> list, boolean z, DrmSessionEventListener.EventDispatcher eventDispatcher, boolean z2) {
        DefaultDrmSession createAndAcquireSession = createAndAcquireSession(list, z, eventDispatcher);
        if (acquisitionFailedIndicatingResourceShortage(createAndAcquireSession) && !this.keepaliveSessions.isEmpty()) {
            releaseAllKeepaliveSessions();
            undoAcquisition(createAndAcquireSession, eventDispatcher);
            createAndAcquireSession = createAndAcquireSession(list, z, eventDispatcher);
        }
        if (!acquisitionFailedIndicatingResourceShortage(createAndAcquireSession) || !z2 || this.preacquiredSessionReferences.isEmpty()) {
            return createAndAcquireSession;
        }
        releaseAllPreacquiredSessions();
        if (!this.keepaliveSessions.isEmpty()) {
            releaseAllKeepaliveSessions();
        }
        undoAcquisition(createAndAcquireSession, eventDispatcher);
        return createAndAcquireSession(list, z, eventDispatcher);
    }

    private static boolean acquisitionFailedIndicatingResourceShortage(DrmSession drmSession) {
        if (drmSession.getState() != 1 || (Util.SDK_INT >= 19 && !(((DrmSession.DrmSessionException) Assertions.checkNotNull(drmSession.getError())).getCause() instanceof ResourceBusyException))) {
            return false;
        }
        return true;
    }

    private void undoAcquisition(DrmSession drmSession, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        drmSession.release(eventDispatcher);
        if (this.sessionKeepaliveMs != C.TIME_UNSET) {
            drmSession.release((DrmSessionEventListener.EventDispatcher) null);
        }
    }

    private void releaseAllKeepaliveSessions() {
        UnmodifiableIterator<DefaultDrmSession> it = ImmutableSet.copyOf(this.keepaliveSessions).iterator();
        while (it.hasNext()) {
            it.next().release((DrmSessionEventListener.EventDispatcher) null);
        }
    }

    private void releaseAllPreacquiredSessions() {
        UnmodifiableIterator<PreacquiredSessionReference> it = ImmutableSet.copyOf(this.preacquiredSessionReferences).iterator();
        while (it.hasNext()) {
            it.next().release();
        }
    }

    private DefaultDrmSession createAndAcquireSession(List<DrmInitData.SchemeData> list, boolean z, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        Assertions.checkNotNull(this.exoMediaDrm);
        List<DrmInitData.SchemeData> list2 = list;
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(this.uuid, this.exoMediaDrm, this.provisioningManagerImpl, this.referenceCountListener, list2, this.mode, this.playClearSamplesWithoutKeys | z, z, this.offlineLicenseKeySetId, this.keyRequestParameters, this.callback, (Looper) Assertions.checkNotNull(this.playbackLooper), this.loadErrorHandlingPolicy, (PlayerId) Assertions.checkNotNull(this.playerId));
        defaultDrmSession.acquire(eventDispatcher);
        if (this.sessionKeepaliveMs != C.TIME_UNSET) {
            defaultDrmSession.acquire((DrmSessionEventListener.EventDispatcher) null);
        }
        return defaultDrmSession;
    }

    /* access modifiers changed from: private */
    public void maybeReleaseMediaDrm() {
        if (this.exoMediaDrm != null && this.prepareCallsCount == 0 && this.sessions.isEmpty() && this.preacquiredSessionReferences.isEmpty()) {
            ((ExoMediaDrm) Assertions.checkNotNull(this.exoMediaDrm)).release();
            this.exoMediaDrm = null;
        }
    }

    private static List<DrmInitData.SchemeData> getSchemeDatas(DrmInitData drmInitData, UUID uuid2, boolean z) {
        ArrayList arrayList = new ArrayList(drmInitData.schemeDataCount);
        for (int i = 0; i < drmInitData.schemeDataCount; i++) {
            DrmInitData.SchemeData schemeData = drmInitData.get(i);
            if ((schemeData.matches(uuid2) || (C.CLEARKEY_UUID.equals(uuid2) && schemeData.matches(C.COMMON_PSSH_UUID))) && (schemeData.data != null || z)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    private class MediaDrmHandler extends Handler {
        public MediaDrmHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr != null) {
                for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.sessions) {
                    if (defaultDrmSession.hasSessionId(bArr)) {
                        defaultDrmSession.onMediaDrmEvent(message.what);
                        return;
                    }
                }
            }
        }
    }

    private class ProvisioningManagerImpl implements DefaultDrmSession.ProvisioningManager {
        private DefaultDrmSession provisioningSession;
        private final Set<DefaultDrmSession> sessionsAwaitingProvisioning = new HashSet();

        public ProvisioningManagerImpl(DefaultDrmSessionManager defaultDrmSessionManager) {
        }

        public void provisionRequired(DefaultDrmSession defaultDrmSession) {
            this.sessionsAwaitingProvisioning.add(defaultDrmSession);
            if (this.provisioningSession == null) {
                this.provisioningSession = defaultDrmSession;
                defaultDrmSession.provision();
            }
        }

        public void onProvisionCompleted() {
            this.provisioningSession = null;
            ImmutableList<DefaultDrmSession> copyOf = ImmutableList.copyOf(this.sessionsAwaitingProvisioning);
            this.sessionsAwaitingProvisioning.clear();
            UnmodifiableIterator<DefaultDrmSession> it = copyOf.iterator();
            while (it.hasNext()) {
                it.next().onProvisionCompleted();
            }
        }

        public void onProvisionError(Exception exc, boolean z) {
            this.provisioningSession = null;
            ImmutableList<DefaultDrmSession> copyOf = ImmutableList.copyOf(this.sessionsAwaitingProvisioning);
            this.sessionsAwaitingProvisioning.clear();
            UnmodifiableIterator<DefaultDrmSession> it = copyOf.iterator();
            while (it.hasNext()) {
                it.next().onProvisionError(exc, z);
            }
        }

        public void onSessionFullyReleased(DefaultDrmSession defaultDrmSession) {
            this.sessionsAwaitingProvisioning.remove(defaultDrmSession);
            if (this.provisioningSession == defaultDrmSession) {
                this.provisioningSession = null;
                if (!this.sessionsAwaitingProvisioning.isEmpty()) {
                    DefaultDrmSession next = this.sessionsAwaitingProvisioning.iterator().next();
                    this.provisioningSession = next;
                    next.provision();
                }
            }
        }
    }

    private class ReferenceCountListenerImpl implements DefaultDrmSession.ReferenceCountListener {
        private ReferenceCountListenerImpl() {
        }

        public void onReferenceCountIncremented(DefaultDrmSession defaultDrmSession, int i) {
            if (DefaultDrmSessionManager.this.sessionKeepaliveMs != C.TIME_UNSET) {
                DefaultDrmSessionManager.this.keepaliveSessions.remove(defaultDrmSession);
                ((Handler) Assertions.checkNotNull(DefaultDrmSessionManager.this.playbackHandler)).removeCallbacksAndMessages(defaultDrmSession);
            }
        }

        public void onReferenceCountDecremented(DefaultDrmSession defaultDrmSession, int i) {
            if (i == 1 && DefaultDrmSessionManager.this.prepareCallsCount > 0 && DefaultDrmSessionManager.this.sessionKeepaliveMs != C.TIME_UNSET) {
                DefaultDrmSessionManager.this.keepaliveSessions.add(defaultDrmSession);
                ((Handler) Assertions.checkNotNull(DefaultDrmSessionManager.this.playbackHandler)).postAtTime(new DefaultDrmSessionManager$ReferenceCountListenerImpl$$ExternalSyntheticLambda0(defaultDrmSession), defaultDrmSession, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.sessionKeepaliveMs);
            } else if (i == 0) {
                DefaultDrmSessionManager.this.sessions.remove(defaultDrmSession);
                if (DefaultDrmSessionManager.this.placeholderDrmSession == defaultDrmSession) {
                    DefaultDrmSession unused = DefaultDrmSessionManager.this.placeholderDrmSession = null;
                }
                if (DefaultDrmSessionManager.this.noMultiSessionDrmSession == defaultDrmSession) {
                    DefaultDrmSession unused2 = DefaultDrmSessionManager.this.noMultiSessionDrmSession = null;
                }
                DefaultDrmSessionManager.this.provisioningManagerImpl.onSessionFullyReleased(defaultDrmSession);
                if (DefaultDrmSessionManager.this.sessionKeepaliveMs != C.TIME_UNSET) {
                    ((Handler) Assertions.checkNotNull(DefaultDrmSessionManager.this.playbackHandler)).removeCallbacksAndMessages(defaultDrmSession);
                    DefaultDrmSessionManager.this.keepaliveSessions.remove(defaultDrmSession);
                }
            }
            DefaultDrmSessionManager.this.maybeReleaseMediaDrm();
        }
    }

    private class MediaDrmEventListener implements ExoMediaDrm.OnEventListener {
        private MediaDrmEventListener() {
        }

        public void onEvent(ExoMediaDrm exoMediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
            ((MediaDrmHandler) Assertions.checkNotNull(DefaultDrmSessionManager.this.mediaDrmHandler)).obtainMessage(i, bArr).sendToTarget();
        }
    }

    private class PreacquiredSessionReference implements DrmSessionManager.DrmSessionReference {
        private final DrmSessionEventListener.EventDispatcher eventDispatcher;
        private boolean isReleased;
        private DrmSession session;

        public PreacquiredSessionReference(DrmSessionEventListener.EventDispatcher eventDispatcher2) {
            this.eventDispatcher = eventDispatcher2;
        }

        public void acquire(Format format) {
            ((Handler) Assertions.checkNotNull(DefaultDrmSessionManager.this.playbackHandler)).post(new DefaultDrmSessionManager$PreacquiredSessionReference$$ExternalSyntheticLambda1(this, format));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$acquire$0$com-google-android-exoplayer2-drm-DefaultDrmSessionManager$PreacquiredSessionReference  reason: not valid java name */
        public /* synthetic */ void m480lambda$acquire$0$comgoogleandroidexoplayer2drmDefaultDrmSessionManager$PreacquiredSessionReference(Format format) {
            if (DefaultDrmSessionManager.this.prepareCallsCount != 0 && !this.isReleased) {
                DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
                this.session = defaultDrmSessionManager.acquireSession((Looper) Assertions.checkNotNull(defaultDrmSessionManager.playbackLooper), this.eventDispatcher, format, false);
                DefaultDrmSessionManager.this.preacquiredSessionReferences.add(this);
            }
        }

        public void release() {
            Util.postOrRun((Handler) Assertions.checkNotNull(DefaultDrmSessionManager.this.playbackHandler), new DefaultDrmSessionManager$PreacquiredSessionReference$$ExternalSyntheticLambda0(this));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$release$1$com-google-android-exoplayer2-drm-DefaultDrmSessionManager$PreacquiredSessionReference  reason: not valid java name */
        public /* synthetic */ void m481lambda$release$1$comgoogleandroidexoplayer2drmDefaultDrmSessionManager$PreacquiredSessionReference() {
            if (!this.isReleased) {
                DrmSession drmSession = this.session;
                if (drmSession != null) {
                    drmSession.release(this.eventDispatcher);
                }
                DefaultDrmSessionManager.this.preacquiredSessionReferences.remove(this);
                this.isReleased = true;
            }
        }
    }
}
