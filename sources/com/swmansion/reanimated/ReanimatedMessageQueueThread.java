package com.swmansion.reanimated;

public class ReanimatedMessageQueueThread extends ReanimatedMessageQueueThreadBase {
    public boolean runOnQueue(Runnable runnable) {
        return this.messageQueueThread.runOnQueue(runnable);
    }
}
