package zendesk.conversationkit.android.internal.noaccess;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import zendesk.conversationkit.android.internal.Action;
import zendesk.conversationkit.android.internal.ActionProcessor;
import zendesk.conversationkit.android.internal.Effect;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lzendesk/conversationkit/android/internal/noaccess/NoAccessActionProcessor;", "Lzendesk/conversationkit/android/internal/ActionProcessor;", "()V", "process", "Lzendesk/conversationkit/android/internal/Effect;", "action", "Lzendesk/conversationkit/android/internal/Action;", "(Lzendesk/conversationkit/android/internal/Action;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NoAccessActionProcessor.kt */
public final class NoAccessActionProcessor implements ActionProcessor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "NoAccessActionProcessor";

    public Object process(Action action, Continuation<? super Effect> continuation) {
        if (action instanceof Action.Setup) {
            return new Effect.SettingsReceived(((Action.Setup) action).getConversationKitSettings());
        }
        if (action instanceof Action.SetupWithConfig) {
            Action.SetupWithConfig setupWithConfig = (Action.SetupWithConfig) action;
            return new Effect.SettingsAndConfigReceived(setupWithConfig.getConversationKitSettings(), setupWithConfig.getConfig());
        }
        Logger.w(LOG_TAG, action + " cannot processed.", new Object[0]);
        return Effect.IncorrectAccessLevel.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/conversationkit/android/internal/noaccess/NoAccessActionProcessor$Companion;", "", "()V", "LOG_TAG", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NoAccessActionProcessor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
