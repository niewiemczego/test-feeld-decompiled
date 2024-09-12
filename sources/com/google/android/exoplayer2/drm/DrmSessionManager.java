package com.google.android.exoplayer2.drm;

import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public interface DrmSessionManager {
    public static final DrmSessionManager DRM_UNSUPPORTED;
    @Deprecated
    public static final DrmSessionManager DUMMY;

    public interface DrmSessionReference {
        public static final DrmSessionReference EMPTY = new DrmSessionManager$DrmSessionReference$$ExternalSyntheticLambda0();

        static /* synthetic */ void lambda$static$0() {
        }

        void release();
    }

    DrmSession acquireSession(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format);

    int getCryptoType(Format format);

    void prepare() {
    }

    void release() {
    }

    void setPlayer(Looper looper, PlayerId playerId);

    static {
        AnonymousClass1 r0 = new DrmSessionManager() {
            public void setPlayer(Looper looper, PlayerId playerId) {
            }

            public DrmSession acquireSession(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
                if (format.drmInitData == null) {
                    return null;
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), PlaybackException.ERROR_CODE_DRM_SCHEME_UNSUPPORTED));
            }

            public int getCryptoType(Format format) {
                return format.drmInitData != null ? 1 : 0;
            }
        };
        DRM_UNSUPPORTED = r0;
        DUMMY = r0;
    }

    @Deprecated
    static DrmSessionManager getDummyDrmSessionManager() {
        return DRM_UNSUPPORTED;
    }

    DrmSessionReference preacquireSession(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        return DrmSessionReference.EMPTY;
    }
}
