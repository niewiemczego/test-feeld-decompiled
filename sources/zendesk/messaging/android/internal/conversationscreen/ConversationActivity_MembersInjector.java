package zendesk.messaging.android.internal.conversationscreen;

import dagger.MembersInjector;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;

public final class ConversationActivity_MembersInjector implements MembersInjector<ConversationActivity> {
    private final Provider<ConversationScreenViewModelFactory> conversationScreenViewModelFactoryProvider;
    private final Provider<CoroutineScope> sdkCoroutineScopeProvider;

    public ConversationActivity_MembersInjector(Provider<ConversationScreenViewModelFactory> provider, Provider<CoroutineScope> provider2) {
        this.conversationScreenViewModelFactoryProvider = provider;
        this.sdkCoroutineScopeProvider = provider2;
    }

    public static MembersInjector<ConversationActivity> create(Provider<ConversationScreenViewModelFactory> provider, Provider<CoroutineScope> provider2) {
        return new ConversationActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(ConversationActivity conversationActivity) {
        injectConversationScreenViewModelFactory(conversationActivity, this.conversationScreenViewModelFactoryProvider.get());
        injectSdkCoroutineScope(conversationActivity, this.sdkCoroutineScopeProvider.get());
    }

    public static void injectConversationScreenViewModelFactory(ConversationActivity conversationActivity, ConversationScreenViewModelFactory conversationScreenViewModelFactory) {
        conversationActivity.conversationScreenViewModelFactory = conversationScreenViewModelFactory;
    }

    public static void injectSdkCoroutineScope(ConversationActivity conversationActivity, CoroutineScope coroutineScope) {
        conversationActivity.sdkCoroutineScope = coroutineScope;
    }
}
