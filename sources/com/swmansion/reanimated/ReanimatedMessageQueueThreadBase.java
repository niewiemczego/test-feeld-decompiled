package com.swmansion.reanimated;

import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.bridge.queue.MessageQueueThreadImpl;
import com.facebook.react.bridge.queue.MessageQueueThreadPerfStats;
import com.facebook.react.bridge.queue.MessageQueueThreadSpec;
import java.lang.reflect.Field;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public abstract class ReanimatedMessageQueueThreadBase implements MessageQueueThread {
    protected final MessageQueueThreadImpl messageQueueThread = MessageQueueThreadImpl.create(MessageQueueThreadSpec.mainThreadSpec(), new ReanimatedMessageQueueThreadBase$$ExternalSyntheticLambda0());

    static /* synthetic */ void lambda$new$0(Exception exc) {
        throw new RuntimeException(exc);
    }

    public <T> Future<T> callOnQueue(Callable<T> callable) {
        return this.messageQueueThread.callOnQueue(callable);
    }

    public boolean isOnThread() {
        return this.messageQueueThread.isOnThread();
    }

    public void assertIsOnThread() {
        this.messageQueueThread.assertIsOnThread();
    }

    public void assertIsOnThread(String str) {
        this.messageQueueThread.assertIsOnThread(str);
    }

    public void quitSynchronous() {
        try {
            Field declaredField = this.messageQueueThread.getClass().getDeclaredField("mIsFinished");
            declaredField.setAccessible(true);
            declaredField.set(this.messageQueueThread, true);
            declaredField.setAccessible(false);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public MessageQueueThreadPerfStats getPerfStats() {
        return this.messageQueueThread.getPerfStats();
    }

    public void resetPerfStats() {
        this.messageQueueThread.resetPerfStats();
    }
}
