package zendesk.android.internal.proactivemessaging;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import zendesk.android.internal.frontendevents.analyticsevents.ProactiveMessagingAnalyticsManager;
import zendesk.conversationkit.android.ConversationKit;
import zendesk.core.android.internal.app.ProcessLifecycleObserver;

public final class ProactiveMessagingManager_Factory implements Factory<ProactiveMessagingManager> {
    private final Provider<ConversationKit> conversationKitProvider;
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<Function0<Long>> currentTimeProvider;
    private final Provider<LocaleProvider> localeProvider;
    private final Provider<ProactiveMessagingAnalyticsManager> proactiveMessagingAnalyticsManagerProvider;
    private final Provider<ProactiveMessagingRepository> proactiveMessagingRepositoryProvider;
    private final Provider<ProcessLifecycleObserver> processLifecycleObserverProvider;
    private final Provider<VisitTypeProvider> visitTypeProvider;

    public ProactiveMessagingManager_Factory(Provider<ProcessLifecycleObserver> provider, Provider<CoroutineScope> provider2, Provider<LocaleProvider> provider3, Provider<VisitTypeProvider> provider4, Provider<ConversationKit> provider5, Provider<ProactiveMessagingRepository> provider6, Provider<Function0<Long>> provider7, Provider<ProactiveMessagingAnalyticsManager> provider8) {
        this.processLifecycleObserverProvider = provider;
        this.coroutineScopeProvider = provider2;
        this.localeProvider = provider3;
        this.visitTypeProvider = provider4;
        this.conversationKitProvider = provider5;
        this.proactiveMessagingRepositoryProvider = provider6;
        this.currentTimeProvider = provider7;
        this.proactiveMessagingAnalyticsManagerProvider = provider8;
    }

    public ProactiveMessagingManager get() {
        return newInstance(this.processLifecycleObserverProvider.get(), this.coroutineScopeProvider.get(), this.localeProvider.get(), this.visitTypeProvider.get(), this.conversationKitProvider.get(), this.proactiveMessagingRepositoryProvider.get(), this.currentTimeProvider.get(), this.proactiveMessagingAnalyticsManagerProvider.get());
    }

    public static ProactiveMessagingManager_Factory create(Provider<ProcessLifecycleObserver> provider, Provider<CoroutineScope> provider2, Provider<LocaleProvider> provider3, Provider<VisitTypeProvider> provider4, Provider<ConversationKit> provider5, Provider<ProactiveMessagingRepository> provider6, Provider<Function0<Long>> provider7, Provider<ProactiveMessagingAnalyticsManager> provider8) {
        return new ProactiveMessagingManager_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static ProactiveMessagingManager newInstance(ProcessLifecycleObserver processLifecycleObserver, CoroutineScope coroutineScope, LocaleProvider localeProvider2, VisitTypeProvider visitTypeProvider2, ConversationKit conversationKit, ProactiveMessagingRepository proactiveMessagingRepository, Function0<Long> function0, ProactiveMessagingAnalyticsManager proactiveMessagingAnalyticsManager) {
        return new ProactiveMessagingManager(processLifecycleObserver, coroutineScope, localeProvider2, visitTypeProvider2, conversationKit, proactiveMessagingRepository, function0, proactiveMessagingAnalyticsManager);
    }
}
