package zendesk.android.internal.frontendevents.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import zendesk.storage.android.Storage;

public final class FrontendEventsModule_ProvidesFrontendEventsStorageFactory implements Factory<Storage> {
    private final Provider<Context> contextProvider;
    private final FrontendEventsModule module;

    public FrontendEventsModule_ProvidesFrontendEventsStorageFactory(FrontendEventsModule frontendEventsModule, Provider<Context> provider) {
        this.module = frontendEventsModule;
        this.contextProvider = provider;
    }

    public Storage get() {
        return providesFrontendEventsStorage(this.module, this.contextProvider.get());
    }

    public static FrontendEventsModule_ProvidesFrontendEventsStorageFactory create(FrontendEventsModule frontendEventsModule, Provider<Context> provider) {
        return new FrontendEventsModule_ProvidesFrontendEventsStorageFactory(frontendEventsModule, provider);
    }

    public static Storage providesFrontendEventsStorage(FrontendEventsModule frontendEventsModule, Context context) {
        return (Storage) Preconditions.checkNotNullFromProvides(frontendEventsModule.providesFrontendEventsStorage(context));
    }
}
