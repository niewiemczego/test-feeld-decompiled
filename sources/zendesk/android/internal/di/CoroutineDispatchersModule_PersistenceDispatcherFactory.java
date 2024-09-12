package zendesk.android.internal.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineDispatcher;

public final class CoroutineDispatchersModule_PersistenceDispatcherFactory implements Factory<CoroutineDispatcher> {
    private final CoroutineDispatchersModule module;

    public CoroutineDispatchersModule_PersistenceDispatcherFactory(CoroutineDispatchersModule coroutineDispatchersModule) {
        this.module = coroutineDispatchersModule;
    }

    public CoroutineDispatcher get() {
        return persistenceDispatcher(this.module);
    }

    public static CoroutineDispatchersModule_PersistenceDispatcherFactory create(CoroutineDispatchersModule coroutineDispatchersModule) {
        return new CoroutineDispatchersModule_PersistenceDispatcherFactory(coroutineDispatchersModule);
    }

    public static CoroutineDispatcher persistenceDispatcher(CoroutineDispatchersModule coroutineDispatchersModule) {
        return (CoroutineDispatcher) Preconditions.checkNotNullFromProvides(coroutineDispatchersModule.persistenceDispatcher());
    }
}
