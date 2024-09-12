package org.apache.commons.lang3.time;

public class StopWatch {
    private static final long NANO_2_MILLIS = 1000000;
    private static final int STATE_RUNNING = 1;
    private static final int STATE_SPLIT = 11;
    private static final int STATE_STOPPED = 2;
    private static final int STATE_SUSPENDED = 3;
    private static final int STATE_UNSPLIT = 10;
    private static final int STATE_UNSTARTED = 0;
    private int runningState = 0;
    private int splitState = 10;
    private long startTime;
    private long startTimeMillis;
    private long stopTime;

    public void start() {
        int i = this.runningState;
        if (i == 2) {
            throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
        } else if (i == 0) {
            this.startTime = System.nanoTime();
            this.startTimeMillis = System.currentTimeMillis();
            this.runningState = 1;
        } else {
            throw new IllegalStateException("Stopwatch already started. ");
        }
    }

    public void stop() {
        int i = this.runningState;
        if (i == 1 || i == 3) {
            if (i == 1) {
                this.stopTime = System.nanoTime();
            }
            this.runningState = 2;
            return;
        }
        throw new IllegalStateException("Stopwatch is not running. ");
    }

    public void reset() {
        this.runningState = 0;
        this.splitState = 10;
    }

    public void split() {
        if (this.runningState == 1) {
            this.stopTime = System.nanoTime();
            this.splitState = 11;
            return;
        }
        throw new IllegalStateException("Stopwatch is not running. ");
    }

    public void unsplit() {
        if (this.splitState == 11) {
            this.splitState = 10;
            return;
        }
        throw new IllegalStateException("Stopwatch has not been split. ");
    }

    public void suspend() {
        if (this.runningState == 1) {
            this.stopTime = System.nanoTime();
            this.runningState = 3;
            return;
        }
        throw new IllegalStateException("Stopwatch must be running to suspend. ");
    }

    public void resume() {
        if (this.runningState == 3) {
            this.startTime += System.nanoTime() - this.stopTime;
            this.runningState = 1;
            return;
        }
        throw new IllegalStateException("Stopwatch must be suspended to resume. ");
    }

    public long getTime() {
        return getNanoTime() / 1000000;
    }

    public long getNanoTime() {
        long j;
        long j2;
        int i = this.runningState;
        if (i == 2 || i == 3) {
            j = this.stopTime;
            j2 = this.startTime;
        } else if (i == 0) {
            return 0;
        } else {
            if (i == 1) {
                j = System.nanoTime();
                j2 = this.startTime;
            } else {
                throw new RuntimeException("Illegal running state has occured. ");
            }
        }
        return j - j2;
    }

    public long getSplitTime() {
        return getSplitNanoTime() / 1000000;
    }

    public long getSplitNanoTime() {
        if (this.splitState == 11) {
            return this.stopTime - this.startTime;
        }
        throw new IllegalStateException("Stopwatch must be split to get the split time. ");
    }

    public long getStartTime() {
        if (this.runningState != 0) {
            return this.startTimeMillis;
        }
        throw new IllegalStateException("Stopwatch has not been started");
    }

    public String toString() {
        return DurationFormatUtils.formatDurationHMS(getTime());
    }

    public String toSplitString() {
        return DurationFormatUtils.formatDurationHMS(getSplitTime());
    }
}
