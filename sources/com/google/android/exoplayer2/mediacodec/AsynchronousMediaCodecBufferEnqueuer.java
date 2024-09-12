package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

class AsynchronousMediaCodecBufferEnqueuer {
    private static final ArrayDeque<MessageParams> MESSAGE_PARAMS_INSTANCE_POOL = new ArrayDeque<>();
    private static final int MSG_OPEN_CV = 2;
    private static final int MSG_QUEUE_INPUT_BUFFER = 0;
    private static final int MSG_QUEUE_SECURE_INPUT_BUFFER = 1;
    private static final Object QUEUE_SECURE_LOCK = new Object();
    private final MediaCodec codec;
    private final ConditionVariable conditionVariable;
    private Handler handler;
    private final HandlerThread handlerThread;
    private final AtomicReference<RuntimeException> pendingRuntimeException;
    private boolean started;

    public AsynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec, HandlerThread handlerThread2) {
        this(mediaCodec, handlerThread2, new ConditionVariable());
    }

    AsynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec, HandlerThread handlerThread2, ConditionVariable conditionVariable2) {
        this.codec = mediaCodec;
        this.handlerThread = handlerThread2;
        this.conditionVariable = conditionVariable2;
        this.pendingRuntimeException = new AtomicReference<>();
    }

    public void start() {
        if (!this.started) {
            this.handlerThread.start();
            this.handler = new Handler(this.handlerThread.getLooper()) {
                public void handleMessage(Message message) {
                    AsynchronousMediaCodecBufferEnqueuer.this.doHandleMessage(message);
                }
            };
            this.started = true;
        }
    }

    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        maybeThrowException();
        MessageParams messageParams = getMessageParams();
        messageParams.setQueueParams(i, i2, i3, j, i4);
        ((Handler) Util.castNonNull(this.handler)).obtainMessage(0, messageParams).sendToTarget();
    }

    public void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) {
        maybeThrowException();
        MessageParams messageParams = getMessageParams();
        messageParams.setQueueParams(i, i2, 0, j, i3);
        copy(cryptoInfo, messageParams.cryptoInfo);
        ((Handler) Util.castNonNull(this.handler)).obtainMessage(1, messageParams).sendToTarget();
    }

    public void flush() {
        if (this.started) {
            try {
                flushHandlerThread();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    public void shutdown() {
        if (this.started) {
            flush();
            this.handlerThread.quit();
        }
        this.started = false;
    }

    public void waitUntilQueueingComplete() throws InterruptedException {
        blockUntilHandlerThreadIsIdle();
    }

    private void maybeThrowException() {
        RuntimeException andSet = this.pendingRuntimeException.getAndSet((Object) null);
        if (andSet != null) {
            throw andSet;
        }
    }

    private void flushHandlerThread() throws InterruptedException {
        ((Handler) Assertions.checkNotNull(this.handler)).removeCallbacksAndMessages((Object) null);
        blockUntilHandlerThreadIsIdle();
    }

    private void blockUntilHandlerThreadIsIdle() throws InterruptedException {
        this.conditionVariable.close();
        ((Handler) Assertions.checkNotNull(this.handler)).obtainMessage(2).sendToTarget();
        this.conditionVariable.block();
    }

    /* access modifiers changed from: package-private */
    public void setPendingRuntimeException(RuntimeException runtimeException) {
        this.pendingRuntimeException.set(runtimeException);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doHandleMessage(android.os.Message r10) {
        /*
            r9 = this;
            int r0 = r10.what
            r1 = 0
            if (r0 == 0) goto L_0x0036
            r2 = 1
            if (r0 == r2) goto L_0x0022
            r2 = 2
            if (r0 == r2) goto L_0x001c
            java.util.concurrent.atomic.AtomicReference<java.lang.RuntimeException> r0 = r9.pendingRuntimeException
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            int r10 = r10.what
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r2.<init>(r10)
            androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(r0, r1, r2)
            goto L_0x0049
        L_0x001c:
            com.google.android.exoplayer2.util.ConditionVariable r10 = r9.conditionVariable
            r10.open()
            goto L_0x0049
        L_0x0022:
            java.lang.Object r10 = r10.obj
            r1 = r10
            com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams r1 = (com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams) r1
            int r3 = r1.index
            int r4 = r1.offset
            android.media.MediaCodec$CryptoInfo r5 = r1.cryptoInfo
            long r6 = r1.presentationTimeUs
            int r8 = r1.flags
            r2 = r9
            r2.doQueueSecureInputBuffer(r3, r4, r5, r6, r8)
            goto L_0x0049
        L_0x0036:
            java.lang.Object r10 = r10.obj
            r1 = r10
            com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams r1 = (com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams) r1
            int r3 = r1.index
            int r4 = r1.offset
            int r5 = r1.size
            long r6 = r1.presentationTimeUs
            int r8 = r1.flags
            r2 = r9
            r2.doQueueInputBuffer(r3, r4, r5, r6, r8)
        L_0x0049:
            if (r1 == 0) goto L_0x004e
            recycleMessageParams(r1)
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.doHandleMessage(android.os.Message):void");
    }

    private void doQueueInputBuffer(int i, int i2, int i3, long j, int i4) {
        try {
            this.codec.queueInputBuffer(i, i2, i3, j, i4);
        } catch (RuntimeException e) {
            LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.pendingRuntimeException, (Object) null, e);
        }
    }

    private void doQueueSecureInputBuffer(int i, int i2, MediaCodec.CryptoInfo cryptoInfo, long j, int i3) {
        try {
            synchronized (QUEUE_SECURE_LOCK) {
                this.codec.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
            }
        } catch (RuntimeException e) {
            LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.pendingRuntimeException, (Object) null, e);
        }
    }

    private static MessageParams getMessageParams() {
        ArrayDeque<MessageParams> arrayDeque = MESSAGE_PARAMS_INSTANCE_POOL;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                MessageParams messageParams = new MessageParams();
                return messageParams;
            }
            MessageParams removeFirst = arrayDeque.removeFirst();
            return removeFirst;
        }
    }

    private static void recycleMessageParams(MessageParams messageParams) {
        ArrayDeque<MessageParams> arrayDeque = MESSAGE_PARAMS_INSTANCE_POOL;
        synchronized (arrayDeque) {
            arrayDeque.add(messageParams);
        }
    }

    private static class MessageParams {
        public final MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        public int flags;
        public int index;
        public int offset;
        public long presentationTimeUs;
        public int size;

        MessageParams() {
        }

        public void setQueueParams(int i, int i2, int i3, long j, int i4) {
            this.index = i;
            this.offset = i2;
            this.size = i3;
            this.presentationTimeUs = j;
            this.flags = i4;
        }
    }

    private static void copy(CryptoInfo cryptoInfo, MediaCodec.CryptoInfo cryptoInfo2) {
        cryptoInfo2.numSubSamples = cryptoInfo.numSubSamples;
        cryptoInfo2.numBytesOfClearData = copy(cryptoInfo.numBytesOfClearData, cryptoInfo2.numBytesOfClearData);
        cryptoInfo2.numBytesOfEncryptedData = copy(cryptoInfo.numBytesOfEncryptedData, cryptoInfo2.numBytesOfEncryptedData);
        cryptoInfo2.key = (byte[]) Assertions.checkNotNull(copy(cryptoInfo.key, cryptoInfo2.key));
        cryptoInfo2.iv = (byte[]) Assertions.checkNotNull(copy(cryptoInfo.iv, cryptoInfo2.iv));
        cryptoInfo2.mode = cryptoInfo.mode;
        if (Util.SDK_INT >= 24) {
            cryptoInfo2.setPattern(new MediaCodec.CryptoInfo.Pattern(cryptoInfo.encryptedBlocks, cryptoInfo.clearBlocks));
        }
    }

    private static int[] copy(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    private static byte[] copy(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
