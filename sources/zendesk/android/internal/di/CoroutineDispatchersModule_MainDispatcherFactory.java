package zendesk.android.internal.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineDispatcher;

public final class CoroutineDispatchersModule_MainDispatcherFactory implements Factory<CoroutineDispatcher> {
    private final CoroutineDispatchersModule module;

    public CoroutineDispatchersModule_MainDispatcherFactory(CoroutineDispatchersModule coroutineDispatchersModule) {
        this.module = coroutineDispatchersModule;
    }

    public CoroutineDispatcher get() {
        return mainDispatcher(this.module);
    }

    public static CoroutineDispatchersModule_MainDispatcherFactory create(CoroutineDispatchersModule coroutineDispatchersModule) {
        return new CoroutineDispatchersModule_MainDispatcherFactory(coroutineDispatchersModule);
    }

    public static CoroutineDispatcher mainDispatcher(CoroutineDispatchersModule coroutineDispatchersModule) {
        return (CoroutineDispatcher) Preconditions.checkNotNullFromProvides(coroutineDispatchersModule.mainDispatcher());
    }
}
