package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
class Subscriber {
    private EventBus bus;
    private final Executor executor;
    private final Method method;
    final Object target;

    static Subscriber create(EventBus eventBus, Object obj, Method method2) {
        if (isDeclaredThreadSafe(method2)) {
            return new Subscriber(eventBus, obj, method2);
        }
        return new SynchronizedSubscriber(eventBus, obj, method2);
    }

    private Subscriber(EventBus eventBus, Object obj, Method method2) {
        this.bus = eventBus;
        this.target = Preconditions.checkNotNull(obj);
        this.method = method2;
        method2.setAccessible(true);
        this.executor = eventBus.executor();
    }

    /* access modifiers changed from: package-private */
    public final void dispatchEvent(Object obj) {
        this.executor.execute(new Subscriber$$ExternalSyntheticLambda0(this, obj));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$dispatchEvent$0$com-google-common-eventbus-Subscriber  reason: not valid java name */
    public /* synthetic */ void m437lambda$dispatchEvent$0$comgooglecommoneventbusSubscriber(Object obj) {
        try {
            invokeSubscriberMethod(obj);
        } catch (InvocationTargetException e) {
            this.bus.handleSubscriberException(e.getCause(), context(obj));
        }
    }

    /* access modifiers changed from: package-private */
    public void invokeSubscriberMethod(Object obj) throws InvocationTargetException {
        try {
            this.method.invoke(this.target, new Object[]{Preconditions.checkNotNull(obj)});
        } catch (IllegalArgumentException e) {
            String valueOf = String.valueOf(obj);
            throw new Error(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Method rejected target/argument: ").append(valueOf).toString(), e);
        } catch (IllegalAccessException e2) {
            String valueOf2 = String.valueOf(obj);
            throw new Error(new StringBuilder(String.valueOf(valueOf2).length() + 28).append("Method became inaccessible: ").append(valueOf2).toString(), e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof Error) {
                throw ((Error) e3.getCause());
            }
            throw e3;
        }
    }

    private SubscriberExceptionContext context(Object obj) {
        return new SubscriberExceptionContext(this.bus, obj, this.target, this.method);
    }

    public final int hashCode() {
        return ((this.method.hashCode() + 31) * 31) + System.identityHashCode(this.target);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Subscriber)) {
            return false;
        }
        Subscriber subscriber = (Subscriber) obj;
        if (this.target != subscriber.target || !this.method.equals(subscriber.method)) {
            return false;
        }
        return true;
    }

    private static boolean isDeclaredThreadSafe(Method method2) {
        return method2.getAnnotation(AllowConcurrentEvents.class) != null;
    }

    static final class SynchronizedSubscriber extends Subscriber {
        private SynchronizedSubscriber(EventBus eventBus, Object obj, Method method) {
            super(eventBus, obj, method);
        }

        /* access modifiers changed from: package-private */
        public void invokeSubscriberMethod(Object obj) throws InvocationTargetException {
            synchronized (this) {
                Subscriber.super.invokeSubscriberMethod(obj);
            }
        }
    }
}
