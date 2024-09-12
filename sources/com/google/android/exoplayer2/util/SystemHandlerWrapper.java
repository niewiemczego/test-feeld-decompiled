package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.util.HandlerWrapper;
import java.util.ArrayList;
import java.util.List;

final class SystemHandlerWrapper implements HandlerWrapper {
    private static final int MAX_POOL_SIZE = 50;
    private static final List<SystemMessage> messagePool = new ArrayList(50);
    private final Handler handler;

    public SystemHandlerWrapper(Handler handler2) {
        this.handler = handler2;
    }

    public Looper getLooper() {
        return this.handler.getLooper();
    }

    public boolean hasMessages(int i) {
        return this.handler.hasMessages(i);
    }

    public HandlerWrapper.Message obtainMessage(int i) {
        return obtainSystemMessage().setMessage(this.handler.obtainMessage(i), this);
    }

    public HandlerWrapper.Message obtainMessage(int i, Object obj) {
        return obtainSystemMessage().setMessage(this.handler.obtainMessage(i, obj), this);
    }

    public HandlerWrapper.Message obtainMessage(int i, int i2, int i3) {
        return obtainSystemMessage().setMessage(this.handler.obtainMessage(i, i2, i3), this);
    }

    public HandlerWrapper.Message obtainMessage(int i, int i2, int i3, Object obj) {
        return obtainSystemMessage().setMessage(this.handler.obtainMessage(i, i2, i3, obj), this);
    }

    public boolean sendMessageAtFrontOfQueue(HandlerWrapper.Message message) {
        return ((SystemMessage) message).sendAtFrontOfQueue(this.handler);
    }

    public boolean sendEmptyMessage(int i) {
        return this.handler.sendEmptyMessage(i);
    }

    public boolean sendEmptyMessageDelayed(int i, int i2) {
        return this.handler.sendEmptyMessageDelayed(i, (long) i2);
    }

    public boolean sendEmptyMessageAtTime(int i, long j) {
        return this.handler.sendEmptyMessageAtTime(i, j);
    }

    public void removeMessages(int i) {
        this.handler.removeMessages(i);
    }

    public void removeCallbacksAndMessages(Object obj) {
        this.handler.removeCallbacksAndMessages(obj);
    }

    public boolean post(Runnable runnable) {
        return this.handler.post(runnable);
    }

    public boolean postDelayed(Runnable runnable, long j) {
        return this.handler.postDelayed(runnable, j);
    }

    public boolean postAtFrontOfQueue(Runnable runnable) {
        return this.handler.postAtFrontOfQueue(runnable);
    }

    private static SystemMessage obtainSystemMessage() {
        SystemMessage systemMessage;
        List<SystemMessage> list = messagePool;
        synchronized (list) {
            if (list.isEmpty()) {
                systemMessage = new SystemMessage();
            } else {
                systemMessage = list.remove(list.size() - 1);
            }
        }
        return systemMessage;
    }

    /* access modifiers changed from: private */
    public static void recycleMessage(SystemMessage systemMessage) {
        List<SystemMessage> list = messagePool;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(systemMessage);
            }
        }
    }

    private static final class SystemMessage implements HandlerWrapper.Message {
        private SystemHandlerWrapper handler;
        private Message message;

        private SystemMessage() {
        }

        public SystemMessage setMessage(Message message2, SystemHandlerWrapper systemHandlerWrapper) {
            this.message = message2;
            this.handler = systemHandlerWrapper;
            return this;
        }

        public boolean sendAtFrontOfQueue(Handler handler2) {
            boolean sendMessageAtFrontOfQueue = handler2.sendMessageAtFrontOfQueue((Message) Assertions.checkNotNull(this.message));
            recycle();
            return sendMessageAtFrontOfQueue;
        }

        public void sendToTarget() {
            ((Message) Assertions.checkNotNull(this.message)).sendToTarget();
            recycle();
        }

        public HandlerWrapper getTarget() {
            return (HandlerWrapper) Assertions.checkNotNull(this.handler);
        }

        private void recycle() {
            this.message = null;
            this.handler = null;
            SystemHandlerWrapper.recycleMessage(this);
        }
    }
}
