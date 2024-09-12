package zendesk.messaging.android.internal.conversationscreen.di;

import android.content.Context;
import android.os.Bundle;
import androidx.savedstate.SavedStateRegistryOwner;
import dagger.BindsInstance;
import dagger.Subcomponent;
import kotlin.Metadata;
import zendesk.messaging.android.internal.conversationscreen.ConversationActivity;

@Subcomponent(modules = {ConversationScreenModule.class, MessageLogModule.class})
@ConversationActivityScope
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/di/ConversationActivityComponent;", "", "inject", "", "conversationActivity", "Lzendesk/messaging/android/internal/conversationscreen/ConversationActivity;", "Factory", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationActivityComponent.kt */
public interface ConversationActivityComponent {
    void inject(ConversationActivity conversationActivity);

    @Subcomponent.Factory
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/di/ConversationActivityComponent$Factory;", "", "create", "Lzendesk/messaging/android/internal/conversationscreen/di/ConversationActivityComponent;", "context", "Landroid/content/Context;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "defaultArgs", "Landroid/os/Bundle;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationActivityComponent.kt */
    public interface Factory {
        ConversationActivityComponent create(@BindsInstance Context context, @BindsInstance SavedStateRegistryOwner savedStateRegistryOwner, @BindsInstance Bundle bundle);

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ConversationActivityComponent.kt */
        public static final class DefaultImpls {
            public static /* synthetic */ ConversationActivityComponent create$default(Factory factory, Context context, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle, int i, Object obj) {
                if (obj == null) {
                    if ((i & 4) != 0) {
                        bundle = null;
                    }
                    return factory.create(context, savedStateRegistryOwner, bundle);
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
            }
        }
    }
}
