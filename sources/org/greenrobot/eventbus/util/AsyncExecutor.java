package org.greenrobot.eventbus.util;

import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import org.greenrobot.eventbus.EventBus;

public class AsyncExecutor {
    private final EventBus eventBus;
    private final Constructor<?> failureEventConstructor;
    private final Object scope;
    private final Executor threadPool;

    public interface RunnableEx {
        void run() throws Exception;
    }

    public static class Builder {
        private EventBus eventBus;
        private Class<?> failureEventType;
        private Executor threadPool;

        private Builder() {
        }

        public Builder threadPool(Executor executor) {
            this.threadPool = executor;
            return this;
        }

        public Builder failureEventType(Class<?> cls) {
            this.failureEventType = cls;
            return this;
        }

        public Builder eventBus(EventBus eventBus2) {
            this.eventBus = eventBus2;
            return this;
        }

        public AsyncExecutor build() {
            return buildForScope((Object) null);
        }

        public AsyncExecutor buildForScope(Object obj) {
            if (this.eventBus == null) {
                this.eventBus = EventBus.getDefault();
            }
            if (this.threadPool == null) {
                this.threadPool = Executors.newCachedThreadPool();
            }
            if (this.failureEventType == null) {
                this.failureEventType = ThrowableFailureEvent.class;
            }
            return new AsyncExecutor(this.threadPool, this.eventBus, this.failureEventType, obj);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static AsyncExecutor create() {
        return new Builder().build();
    }

    private AsyncExecutor(Executor executor, EventBus eventBus2, Class<?> cls, Object obj) {
        this.threadPool = executor;
        this.eventBus = eventBus2;
        this.scope = obj;
        try {
            this.failureEventConstructor = cls.getConstructor(new Class[]{Throwable.class});
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", e);
        }
    }

    public void execute(RunnableEx runnableEx) {
        this.threadPool.execute(new AsyncExecutor$$ExternalSyntheticLambda0(this, runnableEx));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$execute$0$org-greenrobot-eventbus-util-AsyncExecutor  reason: not valid java name */
    public /* synthetic */ void m2744lambda$execute$0$orggreenroboteventbusutilAsyncExecutor(RunnableEx runnableEx) {
        try {
            runnableEx.run();
        } catch (Exception e) {
            try {
                Object newInstance = this.failureEventConstructor.newInstance(new Object[]{e});
                if (newInstance instanceof HasExecutionScope) {
                    ((HasExecutionScope) newInstance).setExecutionScope(this.scope);
                }
                this.eventBus.post(newInstance);
            } catch (Exception e2) {
                this.eventBus.getLogger().log(Level.SEVERE, "Original exception:", e);
                throw new RuntimeException("Could not create failure event", e2);
            }
        }
    }
}
