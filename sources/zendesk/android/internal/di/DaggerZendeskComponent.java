package zendesk.android.internal.di;

import android.content.Context;
import com.squareup.moshi.Moshi;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.io.File;
import javax.inject.Provider;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import zendesk.android.Zendesk;
import zendesk.android.Zendesk_Factory;
import zendesk.android.events.internal.ZendeskEventDispatcher;
import zendesk.android.events.internal.ZendeskEventDispatcher_Factory;
import zendesk.android.internal.di.ZendeskInitializedComponent;
import zendesk.android.internal.frontendevents.FrontendEventsApi;
import zendesk.android.internal.frontendevents.FrontendEventsRepository;
import zendesk.android.internal.frontendevents.FrontendEventsRepository_Factory;
import zendesk.android.internal.frontendevents.FrontendEventsStorage;
import zendesk.android.internal.frontendevents.FrontendEventsStorage_Factory;
import zendesk.android.internal.frontendevents.analyticsevents.ProactiveMessagingAnalyticsManager;
import zendesk.android.internal.frontendevents.analyticsevents.ProactiveMessagingAnalyticsManager_Factory;
import zendesk.android.internal.frontendevents.di.FrontendEventsModule;
import zendesk.android.internal.frontendevents.di.FrontendEventsModule_ProvidesFrontendEventsApiFactory;
import zendesk.android.internal.frontendevents.di.FrontendEventsModule_ProvidesFrontendEventsStorageFactory;
import zendesk.android.internal.frontendevents.pageviewevents.DefaultPageViewEvents;
import zendesk.android.internal.frontendevents.pageviewevents.DefaultPageViewEvents_Factory;
import zendesk.android.internal.network.HeaderFactory;
import zendesk.android.internal.network.HeaderFactory_Factory;
import zendesk.android.internal.network.NetworkData;
import zendesk.android.internal.network.NetworkData_Factory;
import zendesk.android.internal.network.NetworkModule;
import zendesk.android.internal.network.NetworkModule_CacheDirFactory;
import zendesk.android.internal.network.NetworkModule_MoshiConverterFactoryFactory;
import zendesk.android.internal.network.NetworkModule_MoshiFactory;
import zendesk.android.internal.network.NetworkModule_OkHttpClientFactory;
import zendesk.android.internal.network.NetworkModule_RetrofitFactory;
import zendesk.android.internal.proactivemessaging.LocaleProvider;
import zendesk.android.internal.proactivemessaging.LocaleProvider_Factory;
import zendesk.android.internal.proactivemessaging.ProactiveMessagingManager;
import zendesk.android.internal.proactivemessaging.ProactiveMessagingManager_Factory;
import zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository;
import zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository_Factory;
import zendesk.android.internal.proactivemessaging.ProactiveMessagingService;
import zendesk.android.internal.proactivemessaging.ProactiveMessagingStorage;
import zendesk.android.internal.proactivemessaging.ProactiveMessagingStorage_Factory;
import zendesk.android.internal.proactivemessaging.VisitTypeProvider;
import zendesk.android.internal.proactivemessaging.VisitTypeProvider_Factory;
import zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.jwt.ProactiveMessageJwtDecoder;
import zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.jwt.ProactiveMessageJwtDecoder_Factory;
import zendesk.android.internal.proactivemessaging.di.ProactiveMessagingModule;
import zendesk.android.internal.proactivemessaging.di.ProactiveMessagingModule_ProvidesCampaignTriggerServiceFactory;
import zendesk.android.internal.proactivemessaging.di.ProactiveMessagingModule_ProvidesCurrentTimeProviderFactory;
import zendesk.android.internal.proactivemessaging.di.ProactiveMessagingModule_ProvidesProactiveMessagingStorageFactory;
import zendesk.android.messaging.Messaging;
import zendesk.android.settings.internal.SettingsApi;
import zendesk.android.settings.internal.SettingsRepository;
import zendesk.android.settings.internal.SettingsRepository_Factory;
import zendesk.android.settings.internal.SettingsRestClient;
import zendesk.android.settings.internal.SettingsRestClient_Factory;
import zendesk.conversationkit.android.ConversationKit;
import zendesk.core.android.internal.app.ProcessLifecycleObserver;
import zendesk.storage.android.Storage;

public final class DaggerZendeskComponent {
    private DaggerZendeskComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private CoroutineDispatchersModule coroutineDispatchersModule;
        private NetworkModule networkModule;
        private ZendeskModule zendeskModule;

        private Builder() {
        }

        public Builder zendeskModule(ZendeskModule zendeskModule2) {
            this.zendeskModule = (ZendeskModule) Preconditions.checkNotNull(zendeskModule2);
            return this;
        }

        public Builder networkModule(NetworkModule networkModule2) {
            this.networkModule = (NetworkModule) Preconditions.checkNotNull(networkModule2);
            return this;
        }

        public Builder coroutineDispatchersModule(CoroutineDispatchersModule coroutineDispatchersModule2) {
            this.coroutineDispatchersModule = (CoroutineDispatchersModule) Preconditions.checkNotNull(coroutineDispatchersModule2);
            return this;
        }

        public ZendeskComponent build() {
            Preconditions.checkBuilderRequirement(this.zendeskModule, ZendeskModule.class);
            if (this.networkModule == null) {
                this.networkModule = new NetworkModule();
            }
            if (this.coroutineDispatchersModule == null) {
                this.coroutineDispatchersModule = new CoroutineDispatchersModule();
            }
            return new ZendeskComponentImpl(this.zendeskModule, this.networkModule, this.coroutineDispatchersModule);
        }
    }

    private static final class ZendeskInitializedComponentBuilder implements ZendeskInitializedComponent.Builder {
        private final ZendeskComponentImpl zendeskComponentImpl;
        private ZendeskInitializedModule zendeskInitializedModule;

        private ZendeskInitializedComponentBuilder(ZendeskComponentImpl zendeskComponentImpl2) {
            this.zendeskComponentImpl = zendeskComponentImpl2;
        }

        public ZendeskInitializedComponentBuilder zendeskInitializedModule(ZendeskInitializedModule zendeskInitializedModule2) {
            this.zendeskInitializedModule = (ZendeskInitializedModule) Preconditions.checkNotNull(zendeskInitializedModule2);
            return this;
        }

        public ZendeskInitializedComponent build() {
            Preconditions.checkBuilderRequirement(this.zendeskInitializedModule, ZendeskInitializedModule.class);
            return new ZendeskInitializedComponentImpl(this.zendeskComponentImpl, this.zendeskInitializedModule, new ProactiveMessagingModule(), new FrontendEventsModule());
        }
    }

    private static final class ZendeskInitializedComponentImpl implements ZendeskInitializedComponent {
        private Provider<DefaultPageViewEvents> defaultPageViewEventsProvider;
        private Provider<FrontendEventsRepository> frontendEventsRepositoryProvider;
        private Provider<FrontendEventsStorage> frontendEventsStorageProvider;
        private Provider<LocaleProvider> localeProvider;
        private Provider<ProactiveMessageJwtDecoder> proactiveMessageJwtDecoderProvider;
        private Provider<ProactiveMessagingAnalyticsManager> proactiveMessagingAnalyticsManagerProvider;
        private Provider<ProactiveMessagingManager> proactiveMessagingManagerProvider;
        private Provider<ProactiveMessagingRepository> proactiveMessagingRepositoryProvider;
        private Provider<ProactiveMessagingStorage> proactiveMessagingStorageProvider;
        private Provider<ProactiveMessagingService> providesCampaignTriggerServiceProvider;
        private Provider<ConversationKit> providesConversationKitProvider;
        private Provider<Function0<Long>> providesCurrentTimeProvider;
        private Provider<FrontendEventsApi> providesFrontendEventsApiProvider;
        private Provider<Storage> providesFrontendEventsStorageProvider;
        private Provider<Messaging> providesMessagingProvider;
        private Provider<Storage> providesProactiveMessagingStorageProvider;
        private Provider<VisitTypeProvider> visitTypeProvider;
        private final ZendeskComponentImpl zendeskComponentImpl;
        private final ZendeskInitializedComponentImpl zendeskInitializedComponentImpl;
        private Provider<Zendesk> zendeskProvider;

        private ZendeskInitializedComponentImpl(ZendeskComponentImpl zendeskComponentImpl2, ZendeskInitializedModule zendeskInitializedModule, ProactiveMessagingModule proactiveMessagingModule, FrontendEventsModule frontendEventsModule) {
            this.zendeskInitializedComponentImpl = this;
            this.zendeskComponentImpl = zendeskComponentImpl2;
            initialize(zendeskInitializedModule, proactiveMessagingModule, frontendEventsModule);
        }

        private void initialize(ZendeskInitializedModule zendeskInitializedModule, ProactiveMessagingModule proactiveMessagingModule, FrontendEventsModule frontendEventsModule) {
            this.providesConversationKitProvider = DoubleCheck.provider(ZendeskInitializedModule_ProvidesConversationKitFactory.create(zendeskInitializedModule));
            this.providesMessagingProvider = DoubleCheck.provider(ZendeskInitializedModule_ProvidesMessagingFactory.create(zendeskInitializedModule));
            this.providesFrontendEventsApiProvider = DoubleCheck.provider(FrontendEventsModule_ProvidesFrontendEventsApiFactory.create(frontendEventsModule, this.zendeskComponentImpl.retrofitProvider));
            Provider<Storage> provider = DoubleCheck.provider(FrontendEventsModule_ProvidesFrontendEventsStorageFactory.create(frontendEventsModule, this.zendeskComponentImpl.context$zendesk_zendesk_androidProvider));
            this.providesFrontendEventsStorageProvider = provider;
            this.frontendEventsStorageProvider = DoubleCheck.provider(FrontendEventsStorage_Factory.create(provider, this.zendeskComponentImpl.persistenceDispatcherProvider));
            this.frontendEventsRepositoryProvider = DoubleCheck.provider(FrontendEventsRepository_Factory.create(this.providesFrontendEventsApiProvider, this.zendeskComponentImpl.componentData$zendesk_zendesk_androidProvider, this.frontendEventsStorageProvider, this.providesConversationKitProvider, this.zendeskComponentImpl.networkDataProvider));
            this.localeProvider = LocaleProvider_Factory.create(this.zendeskComponentImpl.context$zendesk_zendesk_androidProvider);
            this.visitTypeProvider = DoubleCheck.provider(VisitTypeProvider_Factory.create(this.providesConversationKitProvider, this.zendeskComponentImpl.mainScope$zendesk_zendesk_androidProvider));
            Provider<Storage> provider2 = DoubleCheck.provider(ProactiveMessagingModule_ProvidesProactiveMessagingStorageFactory.create(proactiveMessagingModule, this.zendeskComponentImpl.context$zendesk_zendesk_androidProvider));
            this.providesProactiveMessagingStorageProvider = provider2;
            this.proactiveMessagingStorageProvider = DoubleCheck.provider(ProactiveMessagingStorage_Factory.create(provider2, this.zendeskComponentImpl.persistenceDispatcherProvider));
            this.proactiveMessageJwtDecoderProvider = ProactiveMessageJwtDecoder_Factory.create(this.zendeskComponentImpl.moshiProvider);
            this.providesCampaignTriggerServiceProvider = DoubleCheck.provider(ProactiveMessagingModule_ProvidesCampaignTriggerServiceFactory.create(proactiveMessagingModule, this.zendeskComponentImpl.retrofitProvider));
            this.proactiveMessagingRepositoryProvider = DoubleCheck.provider(ProactiveMessagingRepository_Factory.create(this.zendeskComponentImpl.settingsRepositoryProvider, this.proactiveMessagingStorageProvider, this.proactiveMessageJwtDecoderProvider, this.providesCampaignTriggerServiceProvider, this.zendeskComponentImpl.mainScope$zendesk_zendesk_androidProvider));
            this.providesCurrentTimeProvider = DoubleCheck.provider(ProactiveMessagingModule_ProvidesCurrentTimeProviderFactory.create(proactiveMessagingModule));
            this.proactiveMessagingAnalyticsManagerProvider = DoubleCheck.provider(ProactiveMessagingAnalyticsManager_Factory.create(this.frontendEventsRepositoryProvider, this.zendeskComponentImpl.mainScope$zendesk_zendesk_androidProvider, this.providesConversationKitProvider));
            this.proactiveMessagingManagerProvider = DoubleCheck.provider(ProactiveMessagingManager_Factory.create(this.zendeskComponentImpl.provideProcessLifecycleObserver$zendesk_zendesk_androidProvider, this.zendeskComponentImpl.mainScope$zendesk_zendesk_androidProvider, this.localeProvider, this.visitTypeProvider, this.providesConversationKitProvider, this.proactiveMessagingRepositoryProvider, this.providesCurrentTimeProvider, this.proactiveMessagingAnalyticsManagerProvider));
            this.defaultPageViewEventsProvider = DoubleCheck.provider(DefaultPageViewEvents_Factory.create(this.frontendEventsRepositoryProvider, this.zendeskComponentImpl.ioDispatcherProvider, this.proactiveMessagingManagerProvider));
            this.zendeskProvider = DoubleCheck.provider(Zendesk_Factory.create(this.providesMessagingProvider, this.zendeskComponentImpl.mainScope$zendesk_zendesk_androidProvider, this.zendeskComponentImpl.zendeskEventDispatcherProvider, this.providesConversationKitProvider, this.defaultPageViewEventsProvider));
        }

        public ConversationKit conversationKit() {
            return this.providesConversationKitProvider.get();
        }

        public Messaging messaging() {
            return this.providesMessagingProvider.get();
        }

        public Zendesk zendesk() {
            return this.zendeskProvider.get();
        }
    }

    private static final class ZendeskComponentImpl implements ZendeskComponent {
        private Provider<File> cacheDirProvider;
        /* access modifiers changed from: private */
        public Provider<ZendeskComponentConfig> componentData$zendesk_zendesk_androidProvider;
        /* access modifiers changed from: private */
        public Provider<Context> context$zendesk_zendesk_androidProvider;
        private Provider<HeaderFactory> headerFactoryProvider;
        /* access modifiers changed from: private */
        public Provider<CoroutineDispatcher> ioDispatcherProvider;
        private Provider<CoroutineDispatcher> mainDispatcherProvider;
        /* access modifiers changed from: private */
        public Provider<CoroutineScope> mainScope$zendesk_zendesk_androidProvider;
        private Provider<MoshiConverterFactory> moshiConverterFactoryProvider;
        /* access modifiers changed from: private */
        public Provider<Moshi> moshiProvider;
        /* access modifiers changed from: private */
        public Provider<NetworkData> networkDataProvider;
        private Provider<OkHttpClient> okHttpClientProvider;
        /* access modifiers changed from: private */
        public Provider<CoroutineDispatcher> persistenceDispatcherProvider;
        /* access modifiers changed from: private */
        public Provider<ProcessLifecycleObserver> provideProcessLifecycleObserver$zendesk_zendesk_androidProvider;
        /* access modifiers changed from: private */
        public Provider<Retrofit> retrofitProvider;
        private Provider<SettingsApi> settingsApiProvider;
        /* access modifiers changed from: private */
        public Provider<SettingsRepository> settingsRepositoryProvider;
        private Provider<SettingsRestClient> settingsRestClientProvider;
        private final ZendeskComponentImpl zendeskComponentImpl;
        /* access modifiers changed from: private */
        public Provider<ZendeskEventDispatcher> zendeskEventDispatcherProvider;

        private ZendeskComponentImpl(ZendeskModule zendeskModule, NetworkModule networkModule, CoroutineDispatchersModule coroutineDispatchersModule) {
            this.zendeskComponentImpl = this;
            initialize(zendeskModule, networkModule, coroutineDispatchersModule);
        }

        private void initialize(ZendeskModule zendeskModule, NetworkModule networkModule, CoroutineDispatchersModule coroutineDispatchersModule) {
            this.componentData$zendesk_zendesk_androidProvider = DoubleCheck.provider(ZendeskModule_ComponentData$zendesk_zendesk_androidFactory.create(zendeskModule));
            Provider<Context> provider = DoubleCheck.provider(ZendeskModule_Context$zendesk_zendesk_androidFactory.create(zendeskModule));
            this.context$zendesk_zendesk_androidProvider = provider;
            NetworkData_Factory create = NetworkData_Factory.create(provider, this.componentData$zendesk_zendesk_androidProvider);
            this.networkDataProvider = create;
            this.headerFactoryProvider = DoubleCheck.provider(HeaderFactory_Factory.create(this.componentData$zendesk_zendesk_androidProvider, create));
            Provider<File> provider2 = DoubleCheck.provider(NetworkModule_CacheDirFactory.create(networkModule, this.context$zendesk_zendesk_androidProvider));
            this.cacheDirProvider = provider2;
            this.okHttpClientProvider = DoubleCheck.provider(NetworkModule_OkHttpClientFactory.create(networkModule, this.headerFactoryProvider, provider2));
            Provider<Moshi> provider3 = DoubleCheck.provider(NetworkModule_MoshiFactory.create(networkModule));
            this.moshiProvider = provider3;
            Provider<MoshiConverterFactory> provider4 = DoubleCheck.provider(NetworkModule_MoshiConverterFactoryFactory.create(networkModule, provider3));
            this.moshiConverterFactoryProvider = provider4;
            Provider<Retrofit> provider5 = DoubleCheck.provider(NetworkModule_RetrofitFactory.create(networkModule, this.componentData$zendesk_zendesk_androidProvider, this.okHttpClientProvider, provider4));
            this.retrofitProvider = provider5;
            Provider<SettingsApi> provider6 = DoubleCheck.provider(ZendeskModule_SettingsApiFactory.create(zendeskModule, provider5));
            this.settingsApiProvider = provider6;
            Provider<SettingsRestClient> provider7 = DoubleCheck.provider(SettingsRestClient_Factory.create(provider6, this.moshiProvider, this.componentData$zendesk_zendesk_androidProvider));
            this.settingsRestClientProvider = provider7;
            this.settingsRepositoryProvider = DoubleCheck.provider(SettingsRepository_Factory.create(provider7));
            Provider<CoroutineDispatcher> provider8 = DoubleCheck.provider(CoroutineDispatchersModule_MainDispatcherFactory.create(coroutineDispatchersModule));
            this.mainDispatcherProvider = provider8;
            this.zendeskEventDispatcherProvider = DoubleCheck.provider(ZendeskEventDispatcher_Factory.create(provider8));
            this.mainScope$zendesk_zendesk_androidProvider = DoubleCheck.provider(ZendeskModule_MainScope$zendesk_zendesk_androidFactory.create(zendeskModule));
            this.persistenceDispatcherProvider = DoubleCheck.provider(CoroutineDispatchersModule_PersistenceDispatcherFactory.create(coroutineDispatchersModule));
            this.ioDispatcherProvider = DoubleCheck.provider(CoroutineDispatchersModule_IoDispatcherFactory.create(coroutineDispatchersModule));
            this.provideProcessLifecycleObserver$zendesk_zendesk_androidProvider = DoubleCheck.provider(ZendeskModule_ProvideProcessLifecycleObserver$zendesk_zendesk_androidFactory.create(zendeskModule));
        }

        public ZendeskInitializedComponent.Builder getZendeskInitializedComponent() {
            return new ZendeskInitializedComponentBuilder(this.zendeskComponentImpl);
        }

        public SettingsRepository settingsRepository() {
            return this.settingsRepositoryProvider.get();
        }

        public ZendeskEventDispatcher zendeskEventDispatcher() {
            return this.zendeskEventDispatcherProvider.get();
        }

        public CoroutineScope mainScope() {
            return this.mainScope$zendesk_zendesk_androidProvider.get();
        }

        public Context context() {
            return this.context$zendesk_zendesk_androidProvider.get();
        }

        public ZendeskComponentConfig componentData() {
            return this.componentData$zendesk_zendesk_androidProvider.get();
        }
    }
}
