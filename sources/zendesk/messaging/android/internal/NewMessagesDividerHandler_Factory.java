package zendesk.messaging.android.internal;

import dagger.internal.Factory;

public final class NewMessagesDividerHandler_Factory implements Factory<NewMessagesDividerHandler> {
    public NewMessagesDividerHandler get() {
        return newInstance();
    }

    public static NewMessagesDividerHandler_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static NewMessagesDividerHandler newInstance() {
        return new NewMessagesDividerHandler();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final NewMessagesDividerHandler_Factory INSTANCE = new NewMessagesDividerHandler_Factory();

        private InstanceHolder() {
        }
    }
}
