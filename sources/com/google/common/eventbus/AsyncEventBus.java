package com.google.common.eventbus;

import com.facebook.hermes.intl.Constants;
import com.google.common.eventbus.EventBus;
import java.util.concurrent.Executor;

@ElementTypesAreNonnullByDefault
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(String str, Executor executor) {
        super(str, executor, Dispatcher.legacyAsync(), EventBus.LoggingHandler.INSTANCE);
    }

    public AsyncEventBus(Executor executor, SubscriberExceptionHandler subscriberExceptionHandler) {
        super(Constants.COLLATION_DEFAULT, executor, Dispatcher.legacyAsync(), subscriberExceptionHandler);
    }

    public AsyncEventBus(Executor executor) {
        super(Constants.COLLATION_DEFAULT, executor, Dispatcher.legacyAsync(), EventBus.LoggingHandler.INSTANCE);
    }
}
