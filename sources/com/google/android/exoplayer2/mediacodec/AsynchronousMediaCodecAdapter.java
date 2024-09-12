package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PersistableBundle;
import android.view.Surface;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.common.base.Supplier;
import java.nio.ByteBuffer;

final class AsynchronousMediaCodecAdapter implements MediaCodecAdapter {
    private static final int STATE_CREATED = 0;
    private static final int STATE_INITIALIZED = 1;
    private static final int STATE_SHUT_DOWN = 2;
    private final AsynchronousMediaCodecCallback asynchronousMediaCodecCallback;
    private final AsynchronousMediaCodecBufferEnqueuer bufferEnqueuer;
    private final MediaCodec codec;
    private boolean codecReleased;
    private int state;
    private final boolean synchronizeCodecInteractionsWithQueueing;

    public boolean needsReconfiguration() {
        return false;
    }

    public static final class Factory implements MediaCodecAdapter.Factory {
        private final Supplier<HandlerThread> callbackThreadSupplier;
        private final Supplier<HandlerThread> queueingThreadSupplier;
        private final boolean synchronizeCodecInteractionsWithQueueing;

        public Factory(int i, boolean z) {
            this(new AsynchronousMediaCodecAdapter$Factory$$ExternalSyntheticLambda0(i), new AsynchronousMediaCodecAdapter$Factory$$ExternalSyntheticLambda1(i), z);
        }

        static /* synthetic */ HandlerThread lambda$new$0(int i) {
            return new HandlerThread(AsynchronousMediaCodecAdapter.createCallbackThreadLabel(i));
        }

        static /* synthetic */ HandlerThread lambda$new$1(int i) {
            return new HandlerThread(AsynchronousMediaCodecAdapter.createQueueingThreadLabel(i));
        }

        Factory(Supplier<HandlerThread> supplier, Supplier<HandlerThread> supplier2, boolean z) {
            this.callbackThreadSupplier = supplier;
            this.queueingThreadSupplier = supplier2;
            this.synchronizeCodecInteractionsWithQueueing = z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter createAdapter(com.google.android.exoplayer2.mediacodec.MediaCodecAdapter.Configuration r10) throws java.io.IOException {
            /*
                r9 = this;
                com.google.android.exoplayer2.mediacodec.MediaCodecInfo r0 = r10.codecInfo
                java.lang.String r0 = r0.name
                r1 = 0
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004f }
                r2.<init>()     // Catch:{ Exception -> 0x004f }
                java.lang.String r3 = "createCodec:"
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x004f }
                java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ Exception -> 0x004f }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x004f }
                com.google.android.exoplayer2.util.TraceUtil.beginSection(r2)     // Catch:{ Exception -> 0x004f }
                android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r0)     // Catch:{ Exception -> 0x004f }
                com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter r2 = new com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter     // Catch:{ Exception -> 0x004d }
                com.google.common.base.Supplier<android.os.HandlerThread> r3 = r9.callbackThreadSupplier     // Catch:{ Exception -> 0x004d }
                java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x004d }
                r5 = r3
                android.os.HandlerThread r5 = (android.os.HandlerThread) r5     // Catch:{ Exception -> 0x004d }
                com.google.common.base.Supplier<android.os.HandlerThread> r3 = r9.queueingThreadSupplier     // Catch:{ Exception -> 0x004d }
                java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x004d }
                r6 = r3
                android.os.HandlerThread r6 = (android.os.HandlerThread) r6     // Catch:{ Exception -> 0x004d }
                boolean r7 = r9.synchronizeCodecInteractionsWithQueueing     // Catch:{ Exception -> 0x004d }
                r8 = 0
                r3 = r2
                r4 = r0
                r3.<init>(r4, r5, r6, r7)     // Catch:{ Exception -> 0x004d }
                com.google.android.exoplayer2.util.TraceUtil.endSection()     // Catch:{ Exception -> 0x004a }
                android.media.MediaFormat r1 = r10.mediaFormat     // Catch:{ Exception -> 0x004a }
                android.view.Surface r3 = r10.surface     // Catch:{ Exception -> 0x004a }
                android.media.MediaCrypto r4 = r10.crypto     // Catch:{ Exception -> 0x004a }
                int r10 = r10.flags     // Catch:{ Exception -> 0x004a }
                r2.initialize(r1, r3, r4, r10)     // Catch:{ Exception -> 0x004a }
                return r2
            L_0x004a:
                r10 = move-exception
                r1 = r2
                goto L_0x0051
            L_0x004d:
                r10 = move-exception
                goto L_0x0051
            L_0x004f:
                r10 = move-exception
                r0 = r1
            L_0x0051:
                if (r1 != 0) goto L_0x0059
                if (r0 == 0) goto L_0x005c
                r0.release()
                goto L_0x005c
            L_0x0059:
                r1.release()
            L_0x005c:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter.Factory.createAdapter(com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$Configuration):com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter");
        }
    }

    private AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z) {
        this.codec = mediaCodec;
        this.asynchronousMediaCodecCallback = new AsynchronousMediaCodecCallback(handlerThread);
        this.bufferEnqueuer = new AsynchronousMediaCodecBufferEnqueuer(mediaCodec, handlerThread2);
        this.synchronizeCodecInteractionsWithQueueing = z;
        this.state = 0;
    }

    /* access modifiers changed from: private */
    public void initialize(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        this.asynchronousMediaCodecCallback.initialize(this.codec);
        TraceUtil.beginSection("configureCodec");
        this.codec.configure(mediaFormat, surface, mediaCrypto, i);
        TraceUtil.endSection();
        this.bufferEnqueuer.start();
        TraceUtil.beginSection("startCodec");
        this.codec.start();
        TraceUtil.endSection();
        this.state = 1;
    }

    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.bufferEnqueuer.queueInputBuffer(i, i2, i3, j, i4);
    }

    public void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) {
        this.bufferEnqueuer.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
    }

    public void releaseOutputBuffer(int i, boolean z) {
        this.codec.releaseOutputBuffer(i, z);
    }

    public void releaseOutputBuffer(int i, long j) {
        this.codec.releaseOutputBuffer(i, j);
    }

    public int dequeueInputBufferIndex() {
        return this.asynchronousMediaCodecCallback.dequeueInputBufferIndex();
    }

    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        return this.asynchronousMediaCodecCallback.dequeueOutputBufferIndex(bufferInfo);
    }

    public MediaFormat getOutputFormat() {
        return this.asynchronousMediaCodecCallback.getOutputFormat();
    }

    public ByteBuffer getInputBuffer(int i) {
        return this.codec.getInputBuffer(i);
    }

    public ByteBuffer getOutputBuffer(int i) {
        return this.codec.getOutputBuffer(i);
    }

    public void flush() {
        this.bufferEnqueuer.flush();
        this.codec.flush();
        this.asynchronousMediaCodecCallback.flush();
        this.codec.start();
    }

    public void release() {
        try {
            if (this.state == 1) {
                this.bufferEnqueuer.shutdown();
                this.asynchronousMediaCodecCallback.shutdown();
            }
            this.state = 2;
        } finally {
            if (!this.codecReleased) {
                this.codec.release();
                this.codecReleased = true;
            }
        }
    }

    public void setOnFrameRenderedListener(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        maybeBlockOnQueueing();
        this.codec.setOnFrameRenderedListener(new AsynchronousMediaCodecAdapter$$ExternalSyntheticLambda0(this, onFrameRenderedListener), handler);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setOnFrameRenderedListener$0$com-google-android-exoplayer2-mediacodec-AsynchronousMediaCodecAdapter  reason: not valid java name */
    public /* synthetic */ void m492lambda$setOnFrameRenderedListener$0$comgoogleandroidexoplayer2mediacodecAsynchronousMediaCodecAdapter(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, MediaCodec mediaCodec, long j, long j2) {
        onFrameRenderedListener.onFrameRendered(this, j, j2);
    }

    public void setOutputSurface(Surface surface) {
        maybeBlockOnQueueing();
        this.codec.setOutputSurface(surface);
    }

    public void setParameters(Bundle bundle) {
        maybeBlockOnQueueing();
        this.codec.setParameters(bundle);
    }

    public void setVideoScalingMode(int i) {
        maybeBlockOnQueueing();
        this.codec.setVideoScalingMode(i);
    }

    public PersistableBundle getMetrics() {
        maybeBlockOnQueueing();
        return this.codec.getMetrics();
    }

    /* access modifiers changed from: package-private */
    public void onError(MediaCodec.CodecException codecException) {
        this.asynchronousMediaCodecCallback.onError(this.codec, codecException);
    }

    /* access modifiers changed from: package-private */
    public void onOutputFormatChanged(MediaFormat mediaFormat) {
        this.asynchronousMediaCodecCallback.onOutputFormatChanged(this.codec, mediaFormat);
    }

    private void maybeBlockOnQueueing() {
        if (this.synchronizeCodecInteractionsWithQueueing) {
            try {
                this.bufferEnqueuer.waitUntilQueueingComplete();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static String createCallbackThreadLabel(int i) {
        return createThreadLabel(i, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    /* access modifiers changed from: private */
    public static String createQueueingThreadLabel(int i) {
        return createThreadLabel(i, "ExoPlayer:MediaCodecQueueingThread:");
    }

    private static String createThreadLabel(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(").append(i).append(")");
        }
        return sb.toString();
    }
}
