package zendesk.messaging.android.internal;

import dagger.internal.Factory;

public final class CoroutinesDispatcherProvider_Factory implements Factory<CoroutinesDispatcherProvider> {
    public CoroutinesDispatcherProvider get() {
        return newInstance();
    }

    public static CoroutinesDispatcherProvider_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CoroutinesDispatcherProvider newInstance() {
        return new CoroutinesDispatcherProvider();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CoroutinesDispatcherProvider_Factory INSTANCE = new CoroutinesDispatcherProvider_Factory();

        private InstanceHolder() {
        }
    }
}
