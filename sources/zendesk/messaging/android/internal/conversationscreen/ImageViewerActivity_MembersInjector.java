package zendesk.messaging.android.internal.conversationscreen;

import dagger.MembersInjector;
import javax.inject.Provider;

public final class ImageViewerActivity_MembersInjector implements MembersInjector<ImageViewerActivity> {
    private final Provider<ConversationScreenViewModelFactory> conversationScreenViewModelFactoryProvider;

    public ImageViewerActivity_MembersInjector(Provider<ConversationScreenViewModelFactory> provider) {
        this.conversationScreenViewModelFactoryProvider = provider;
    }

    public static MembersInjector<ImageViewerActivity> create(Provider<ConversationScreenViewModelFactory> provider) {
        return new ImageViewerActivity_MembersInjector(provider);
    }

    public void injectMembers(ImageViewerActivity imageViewerActivity) {
        injectConversationScreenViewModelFactory(imageViewerActivity, this.conversationScreenViewModelFactoryProvider.get());
    }

    public static void injectConversationScreenViewModelFactory(ImageViewerActivity imageViewerActivity, ConversationScreenViewModelFactory conversationScreenViewModelFactory) {
        imageViewerActivity.conversationScreenViewModelFactory = conversationScreenViewModelFactory;
    }
}
