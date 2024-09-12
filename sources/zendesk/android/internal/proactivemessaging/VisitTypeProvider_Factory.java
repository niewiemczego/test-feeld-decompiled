package zendesk.android.internal.proactivemessaging;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;
import zendesk.conversationkit.android.ConversationKit;

public final class VisitTypeProvider_Factory implements Factory<VisitTypeProvider> {
    private final Provider<ConversationKit> conversationKitProvider;
    private final Provider<CoroutineScope> coroutineScopeProvider;

    public VisitTypeProvider_Factory(Provider<ConversationKit> provider, Provider<CoroutineScope> provider2) {
        this.conversationKitProvider = provider;
        this.coroutineScopeProvider = provider2;
    }

    public VisitTypeProvider get() {
        return newInstance(this.conversationKitProvider.get(), this.coroutineScopeProvider.get());
    }

    public static VisitTypeProvider_Factory create(Provider<ConversationKit> provider, Provider<CoroutineScope> provider2) {
        return new VisitTypeProvider_Factory(provider, provider2);
    }

    public static VisitTypeProvider newInstance(ConversationKit conversationKit, CoroutineScope coroutineScope) {
        return new VisitTypeProvider(conversationKit, coroutineScope);
    }
}
