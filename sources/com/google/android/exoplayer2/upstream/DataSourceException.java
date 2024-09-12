package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public class DataSourceException extends IOException {
    @Deprecated
    public static final int POSITION_OUT_OF_RANGE = 2008;
    public final int reason;

    public static boolean isCausedByPositionOutOfRange(IOException iOException) {
        Throwable th;
        while (th != null) {
            if ((th instanceof DataSourceException) && ((DataSourceException) th).reason == 2008) {
                return true;
            }
            Throwable cause = th.getCause();
            th = iOException;
            th = cause;
        }
        return false;
    }

    public DataSourceException(int i) {
        this.reason = i;
    }

    public DataSourceException(Throwable th, int i) {
        super(th);
        this.reason = i;
    }

    public DataSourceException(String str, int i) {
        super(str);
        this.reason = i;
    }

    public DataSourceException(String str, Throwable th, int i) {
        super(str, th);
        this.reason = i;
    }
}
