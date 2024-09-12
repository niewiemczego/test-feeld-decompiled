package zendesk.android.internal.proactivemessaging;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;
import zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.jwt.ProactiveMessageJwtDecoder;
import zendesk.android.settings.internal.SettingsRepository;

public final class ProactiveMessagingRepository_Factory implements Factory<ProactiveMessagingRepository> {
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<ProactiveMessageJwtDecoder> proactiveMessageJwtDecoderProvider;
    private final Provider<ProactiveMessagingService> proactiveMessagingServiceProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;
    private final Provider<ProactiveMessagingStorage> storageProvider;

    public ProactiveMessagingRepository_Factory(Provider<SettingsRepository> provider, Provider<ProactiveMessagingStorage> provider2, Provider<ProactiveMessageJwtDecoder> provider3, Provider<ProactiveMessagingService> provider4, Provider<CoroutineScope> provider5) {
        this.settingsRepositoryProvider = provider;
        this.storageProvider = provider2;
        this.proactiveMessageJwtDecoderProvider = provider3;
        this.proactiveMessagingServiceProvider = provider4;
        this.coroutineScopeProvider = provider5;
    }

    public ProactiveMessagingRepository get() {
        return newInstance(this.settingsRepositoryProvider.get(), this.storageProvider.get(), this.proactiveMessageJwtDecoderProvider.get(), this.proactiveMessagingServiceProvider.get(), this.coroutineScopeProvider.get());
    }

    public static ProactiveMessagingRepository_Factory create(Provider<SettingsRepository> provider, Provider<ProactiveMessagingStorage> provider2, Provider<ProactiveMessageJwtDecoder> provider3, Provider<ProactiveMessagingService> provider4, Provider<CoroutineScope> provider5) {
        return new ProactiveMessagingRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ProactiveMessagingRepository newInstance(SettingsRepository settingsRepository, ProactiveMessagingStorage proactiveMessagingStorage, ProactiveMessageJwtDecoder proactiveMessageJwtDecoder, ProactiveMessagingService proactiveMessagingService, CoroutineScope coroutineScope) {
        return new ProactiveMessagingRepository(settingsRepository, proactiveMessagingStorage, proactiveMessageJwtDecoder, proactiveMessagingService, coroutineScope);
    }
}
