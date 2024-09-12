package io.sentry;

public class SpanOptions {
    private boolean isIdle = false;
    private boolean trimEnd = false;
    private boolean trimStart = false;

    public boolean isTrimStart() {
        return this.trimStart;
    }

    public boolean isTrimEnd() {
        return this.trimEnd;
    }

    public boolean isIdle() {
        return this.isIdle;
    }

    public void setTrimStart(boolean z) {
        this.trimStart = z;
    }

    public void setTrimEnd(boolean z) {
        this.trimEnd = z;
    }

    public void setIdle(boolean z) {
        this.isIdle = z;
    }
}
