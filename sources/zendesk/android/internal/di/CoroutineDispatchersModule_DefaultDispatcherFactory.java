package zendesk.android.internal.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineDispatcher;

public final class CoroutineDispatchersModule_DefaultDispatcherFactory implements Factory<CoroutineDispatcher> {
    private final CoroutineDispatchersModule module;

    public CoroutineDispatchersModule_DefaultDispatcherFactory(CoroutineDispatchersModule coroutineDispatchersModule) {
        this.module = coroutineDispatchersModule;
    }

    public CoroutineDispatcher get() {
        return defaultDispatcher(this.module);
    }

    public static CoroutineDispatchersModule_DefaultDispatcherFactory create(CoroutineDispatchersModule coroutineDispatchersModule) {
        return new CoroutineDispatchersModule_DefaultDispatcherFactory(coroutineDispatchersModule);
    }

    public static CoroutineDispatcher defaultDispatcher(CoroutineDispatchersModule coroutineDispatchersModule) {
        return (CoroutineDispatcher) Preconditions.checkNotNullFromProvides(coroutineDispatchersModule.defaultDispatcher());
    }
}
