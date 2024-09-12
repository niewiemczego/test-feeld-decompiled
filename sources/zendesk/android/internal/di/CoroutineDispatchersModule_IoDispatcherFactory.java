package zendesk.android.internal.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineDispatcher;

public final class CoroutineDispatchersModule_IoDispatcherFactory implements Factory<CoroutineDispatcher> {
    private final CoroutineDispatchersModule module;

    public CoroutineDispatchersModule_IoDispatcherFactory(CoroutineDispatchersModule coroutineDispatchersModule) {
        this.module = coroutineDispatchersModule;
    }

    public CoroutineDispatcher get() {
        return ioDispatcher(this.module);
    }

    public static CoroutineDispatchersModule_IoDispatcherFactory create(CoroutineDispatchersModule coroutineDispatchersModule) {
        return new CoroutineDispatchersModule_IoDispatcherFactory(coroutineDispatchersModule);
    }

    public static CoroutineDispatcher ioDispatcher(CoroutineDispatchersModule coroutineDispatchersModule) {
        return (CoroutineDispatcher) Preconditions.checkNotNullFromProvides(coroutineDispatchersModule.ioDispatcher());
    }
}
