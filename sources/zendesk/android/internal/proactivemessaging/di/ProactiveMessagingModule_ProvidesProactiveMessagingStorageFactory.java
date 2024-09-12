package zendesk.android.internal.proactivemessaging.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import zendesk.storage.android.Storage;

public final class ProactiveMessagingModule_ProvidesProactiveMessagingStorageFactory implements Factory<Storage> {
    private final Provider<Context> contextProvider;
    private final ProactiveMessagingModule module;

    public ProactiveMessagingModule_ProvidesProactiveMessagingStorageFactory(ProactiveMessagingModule proactiveMessagingModule, Provider<Context> provider) {
        this.module = proactiveMessagingModule;
        this.contextProvider = provider;
    }

    public Storage get() {
        return providesProactiveMessagingStorage(this.module, this.contextProvider.get());
    }

    public static ProactiveMessagingModule_ProvidesProactiveMessagingStorageFactory create(ProactiveMessagingModule proactiveMessagingModule, Provider<Context> provider) {
        return new ProactiveMessagingModule_ProvidesProactiveMessagingStorageFactory(proactiveMessagingModule, provider);
    }

    public static Storage providesProactiveMessagingStorage(ProactiveMessagingModule proactiveMessagingModule, Context context) {
        return (Storage) Preconditions.checkNotNullFromProvides(proactiveMessagingModule.providesProactiveMessagingStorage(context));
    }
}
