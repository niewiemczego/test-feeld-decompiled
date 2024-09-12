package zendesk.android.internal.frontendevents;

import dagger.internal.Factory;
import javax.inject.Provider;
import zendesk.android.internal.di.ZendeskComponentConfig;
import zendesk.android.internal.network.NetworkData;
import zendesk.conversationkit.android.ConversationKit;

public final class FrontendEventsRepository_Factory implements Factory<FrontendEventsRepository> {
    private final Provider<ConversationKit> conversationKitProvider;
    private final Provider<FrontendEventsApi> frontendEventsApiProvider;
    private final Provider<FrontendEventsStorage> frontendEventsStorageProvider;
    private final Provider<NetworkData> networkDataProvider;
    private final Provider<ZendeskComponentConfig> zendeskComponentConfigProvider;

    public FrontendEventsRepository_Factory(Provider<FrontendEventsApi> provider, Provider<ZendeskComponentConfig> provider2, Provider<FrontendEventsStorage> provider3, Provider<ConversationKit> provider4, Provider<NetworkData> provider5) {
        this.frontendEventsApiProvider = provider;
        this.zendeskComponentConfigProvider = provider2;
        this.frontendEventsStorageProvider = provider3;
        this.conversationKitProvider = provider4;
        this.networkDataProvider = provider5;
    }

    public FrontendEventsRepository get() {
        return newInstance(this.frontendEventsApiProvider.get(), this.zendeskComponentConfigProvider.get(), this.frontendEventsStorageProvider.get(), this.conversationKitProvider.get(), this.networkDataProvider.get());
    }

    public static FrontendEventsRepository_Factory create(Provider<FrontendEventsApi> provider, Provider<ZendeskComponentConfig> provider2, Provider<FrontendEventsStorage> provider3, Provider<ConversationKit> provider4, Provider<NetworkData> provider5) {
        return new FrontendEventsRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static FrontendEventsRepository newInstance(FrontendEventsApi frontendEventsApi, ZendeskComponentConfig zendeskComponentConfig, FrontendEventsStorage frontendEventsStorage, ConversationKit conversationKit, NetworkData networkData) {
        return new FrontendEventsRepository(frontendEventsApi, zendeskComponentConfig, frontendEventsStorage, conversationKit, networkData);
    }
}
