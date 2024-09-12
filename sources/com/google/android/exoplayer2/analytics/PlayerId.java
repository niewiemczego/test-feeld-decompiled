package com.google.android.exoplayer2.analytics;

import android.media.metrics.LogSessionId;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class PlayerId {
    public static final PlayerId UNSET = (Util.SDK_INT < 31 ? new PlayerId() : new PlayerId(LogSessionIdApi31.UNSET));
    private final LogSessionIdApi31 logSessionIdApi31;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PlayerId() {
        this((LogSessionIdApi31) null);
        LogSessionIdApi31 logSessionIdApi312 = null;
        Assertions.checkState(Util.SDK_INT < 31);
    }

    public PlayerId(LogSessionId logSessionId) {
        this(new LogSessionIdApi31(logSessionId));
    }

    private PlayerId(LogSessionIdApi31 logSessionIdApi312) {
        this.logSessionIdApi31 = logSessionIdApi312;
    }

    public LogSessionId getLogSessionId() {
        return ((LogSessionIdApi31) Assertions.checkNotNull(this.logSessionIdApi31)).logSessionId;
    }

    private static final class LogSessionIdApi31 {
        public static final LogSessionIdApi31 UNSET = new LogSessionIdApi31(LogSessionId.LOG_SESSION_ID_NONE);
        public final LogSessionId logSessionId;

        public LogSessionIdApi31(LogSessionId logSessionId2) {
            this.logSessionId = logSessionId2;
        }
    }
}
