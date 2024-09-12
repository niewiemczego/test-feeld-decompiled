package zendesk.android.internal.proactivemessaging.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;
import zendesk.android.internal.proactivemessaging.ProactiveMessagingService;

public final class ProactiveMessagingModule_ProvidesCampaignTriggerServiceFactory implements Factory<ProactiveMessagingService> {
    private final ProactiveMessagingModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ProactiveMessagingModule_ProvidesCampaignTriggerServiceFactory(ProactiveMessagingModule proactiveMessagingModule, Provider<Retrofit> provider) {
        this.module = proactiveMessagingModule;
        this.retrofitProvider = provider;
    }

    public ProactiveMessagingService get() {
        return providesCampaignTriggerService(this.module, this.retrofitProvider.get());
    }

    public static ProactiveMessagingModule_ProvidesCampaignTriggerServiceFactory create(ProactiveMessagingModule proactiveMessagingModule, Provider<Retrofit> provider) {
        return new ProactiveMessagingModule_ProvidesCampaignTriggerServiceFactory(proactiveMessagingModule, provider);
    }

    public static ProactiveMessagingService providesCampaignTriggerService(ProactiveMessagingModule proactiveMessagingModule, Retrofit retrofit) {
        return (ProactiveMessagingService) Preconditions.checkNotNullFromProvides(proactiveMessagingModule.providesCampaignTriggerService(retrofit));
    }
}
