package zendesk.android.events.internal;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class ZendeskEventDispatcher_Factory implements Factory<ZendeskEventDispatcher> {
    private final Provider<CoroutineDispatcher> mainDispatcherProvider;

    public ZendeskEventDispatcher_Factory(Provider<CoroutineDispatcher> provider) {
        this.mainDispatcherProvider = provider;
    }

    public ZendeskEventDispatcher get() {
        return newInstance(this.mainDispatcherProvider.get());
    }

    public static ZendeskEventDispatcher_Factory create(Provider<CoroutineDispatcher> provider) {
        return new ZendeskEventDispatcher_Factory(provider);
    }

    public static ZendeskEventDispatcher newInstance(CoroutineDispatcher coroutineDispatcher) {
        return new ZendeskEventDispatcher(coroutineDispatcher);
    }
}
