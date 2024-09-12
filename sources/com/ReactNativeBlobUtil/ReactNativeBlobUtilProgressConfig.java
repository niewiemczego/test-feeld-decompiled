package com.ReactNativeBlobUtil;

public class ReactNativeBlobUtilProgressConfig {
    private int count = -1;
    private boolean enable = false;
    private int interval = -1;
    private long lastTick = 0;
    private int tick = 0;
    private ReportType type;

    enum ReportType {
        Upload,
        Download
    }

    ReactNativeBlobUtilProgressConfig(boolean z, int i, int i2, ReportType reportType) {
        ReportType reportType2 = ReportType.Download;
        this.enable = z;
        this.interval = i;
        this.type = reportType;
        this.count = i2;
    }

    public boolean shouldReport(float f) {
        int i = this.count;
        boolean z = false;
        boolean z2 = i <= 0 || f <= 0.0f || Math.floor((double) (f * ((float) i))) > ((double) this.tick);
        if (System.currentTimeMillis() - this.lastTick > ((long) this.interval) && this.enable && z2) {
            z = true;
        }
        if (z) {
            this.tick++;
            this.lastTick = System.currentTimeMillis();
        }
        return z;
    }
}
