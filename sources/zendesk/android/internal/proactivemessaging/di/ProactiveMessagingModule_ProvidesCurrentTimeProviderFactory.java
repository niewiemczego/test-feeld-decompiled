package zendesk.android.internal.proactivemessaging.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlin.jvm.functions.Function0;

public final class ProactiveMessagingModule_ProvidesCurrentTimeProviderFactory implements Factory<Function0<Long>> {
    private final ProactiveMessagingModule module;

    public ProactiveMessagingModule_ProvidesCurrentTimeProviderFactory(ProactiveMessagingModule proactiveMessagingModule) {
        this.module = proactiveMessagingModule;
    }

    public Function0<Long> get() {
        return providesCurrentTimeProvider(this.module);
    }

    public static ProactiveMessagingModule_ProvidesCurrentTimeProviderFactory create(ProactiveMessagingModule proactiveMessagingModule) {
        return new ProactiveMessagingModule_ProvidesCurrentTimeProviderFactory(proactiveMessagingModule);
    }

    public static Function0<Long> providesCurrentTimeProvider(ProactiveMessagingModule proactiveMessagingModule) {
        return (Function0) Preconditions.checkNotNullFromProvides(proactiveMessagingModule.providesCurrentTimeProvider());
    }
}
