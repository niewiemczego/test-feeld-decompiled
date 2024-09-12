package com.google.android.exoplayer2.drm;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Map;
import java.util.UUID;

public final class OfflineLicenseHelper {
    private static final Format FORMAT_WITH_EMPTY_DRM_INIT_DATA = new Format.Builder().setDrmInitData(new DrmInitData(new DrmInitData.SchemeData[0])).build();
    /* access modifiers changed from: private */
    public final ConditionVariable conditionVariable;
    private final DefaultDrmSessionManager drmSessionManager;
    private final DrmSessionEventListener.EventDispatcher eventDispatcher;
    private final HandlerThread handlerThread;

    public static OfflineLicenseHelper newWidevineInstance(String str, DataSource.Factory factory, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
        return newWidevineInstance(str, false, factory, eventDispatcher2);
    }

    public static OfflineLicenseHelper newWidevineInstance(String str, boolean z, DataSource.Factory factory, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
        return newWidevineInstance(str, z, factory, (Map<String, String>) null, eventDispatcher2);
    }

    public static OfflineLicenseHelper newWidevineInstance(String str, boolean z, DataSource.Factory factory, Map<String, String> map, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
        return new OfflineLicenseHelper(new DefaultDrmSessionManager.Builder().setKeyRequestParameters(map).build(new HttpMediaDrmCallback(str, z, factory)), eventDispatcher2);
    }

    @Deprecated
    public OfflineLicenseHelper(UUID uuid, ExoMediaDrm.Provider provider, MediaDrmCallback mediaDrmCallback, Map<String, String> map, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
        this(new DefaultDrmSessionManager.Builder().setUuidAndExoMediaDrmProvider(uuid, provider).setKeyRequestParameters(map).build(mediaDrmCallback), eventDispatcher2);
    }

    public OfflineLicenseHelper(DefaultDrmSessionManager defaultDrmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
        this.drmSessionManager = defaultDrmSessionManager;
        this.eventDispatcher = eventDispatcher2;
        HandlerThread handlerThread2 = new HandlerThread("ExoPlayer:OfflineLicenseHelper");
        this.handlerThread = handlerThread2;
        handlerThread2.start();
        this.conditionVariable = new ConditionVariable();
        eventDispatcher2.addEventListener(new Handler(handlerThread2.getLooper()), new DrmSessionEventListener() {
            public void onDrmKeysLoaded(int i, MediaSource.MediaPeriodId mediaPeriodId) {
                OfflineLicenseHelper.this.conditionVariable.open();
            }

            public void onDrmSessionManagerError(int i, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
                OfflineLicenseHelper.this.conditionVariable.open();
            }

            public void onDrmKeysRestored(int i, MediaSource.MediaPeriodId mediaPeriodId) {
                OfflineLicenseHelper.this.conditionVariable.open();
            }

            public void onDrmKeysRemoved(int i, MediaSource.MediaPeriodId mediaPeriodId) {
                OfflineLicenseHelper.this.conditionVariable.open();
            }
        });
    }

    public synchronized byte[] downloadLicense(Format format) throws DrmSession.DrmSessionException {
        Assertions.checkArgument(format.drmInitData != null);
        return blockingKeyRequest(2, (byte[]) null, format);
    }

    public synchronized byte[] renewLicense(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        return blockingKeyRequest(2, bArr, FORMAT_WITH_EMPTY_DRM_INIT_DATA);
    }

    public synchronized void releaseLicense(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        blockingKeyRequest(3, bArr, FORMAT_WITH_EMPTY_DRM_INIT_DATA);
    }

    public synchronized Pair<Long, Long> getLicenseDurationRemainingSec(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        this.drmSessionManager.setPlayer(this.handlerThread.getLooper(), PlayerId.UNSET);
        this.drmSessionManager.prepare();
        DrmSession openBlockingKeyRequest = openBlockingKeyRequest(1, bArr, FORMAT_WITH_EMPTY_DRM_INIT_DATA);
        DrmSession.DrmSessionException error = openBlockingKeyRequest.getError();
        Pair<Long, Long> licenseDurationRemainingSec = WidevineUtil.getLicenseDurationRemainingSec(openBlockingKeyRequest);
        openBlockingKeyRequest.release(this.eventDispatcher);
        this.drmSessionManager.release();
        if (error == null) {
            return (Pair) Assertions.checkNotNull(licenseDurationRemainingSec);
        } else if (error.getCause() instanceof KeysExpiredException) {
            return Pair.create(0L, 0L);
        } else {
            throw error;
        }
    }

    public void release() {
        this.handlerThread.quit();
    }

    private byte[] blockingKeyRequest(int i, byte[] bArr, Format format) throws DrmSession.DrmSessionException {
        this.drmSessionManager.setPlayer(this.handlerThread.getLooper(), PlayerId.UNSET);
        this.drmSessionManager.prepare();
        DrmSession openBlockingKeyRequest = openBlockingKeyRequest(i, bArr, format);
        DrmSession.DrmSessionException error = openBlockingKeyRequest.getError();
        byte[] offlineLicenseKeySetId = openBlockingKeyRequest.getOfflineLicenseKeySetId();
        openBlockingKeyRequest.release(this.eventDispatcher);
        this.drmSessionManager.release();
        if (error == null) {
            return (byte[]) Assertions.checkNotNull(offlineLicenseKeySetId);
        }
        throw error;
    }

    private DrmSession openBlockingKeyRequest(int i, byte[] bArr, Format format) {
        Assertions.checkNotNull(format.drmInitData);
        this.drmSessionManager.setMode(i, bArr);
        this.conditionVariable.close();
        DrmSession acquireSession = this.drmSessionManager.acquireSession(this.eventDispatcher, format);
        this.conditionVariable.block();
        return (DrmSession) Assertions.checkNotNull(acquireSession);
    }
}
