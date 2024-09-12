package zendesk.messaging.android;

import android.content.Context;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.Zendesk;
import zendesk.android.internal.ZendeskError;
import zendesk.messaging.android.MessagingError;
import zendesk.messaging.android.internal.WrapperMessaging;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/messaging/android/Messaging;", "Lzendesk/android/messaging/Messaging;", "Companion", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Use Zendesk SDK to obtain an instance of Messaging", replaceWith = @ReplaceWith(expression = "Messaging", imports = {"zendesk.android.messaging.Messaging"}))
/* compiled from: Messaging.kt */
public interface Messaging extends zendesk.android.messaging.Messaging {
    public static final Companion Companion = Companion.$$INSTANCE;

    @JvmStatic
    @Deprecated(message = "Please use Zendesk.initialize instead", replaceWith = @ReplaceWith(expression = "Zendesk.initialize(context, channelKey, successCallback, failureCallback,\n DefaultMessagingFactory())", imports = {"zendesk.android.Zendesk"}))
    static void initialize(Context context, String str, SuccessCallback<Messaging> successCallback, FailureCallback<MessagingError> failureCallback) {
        Companion.initialize(context, str, successCallback, failureCallback);
    }

    @JvmStatic
    @Deprecated(message = "Please use Zendesk#messaging instead", replaceWith = @ReplaceWith(expression = "Zendesk.instance().messaging()", imports = {"zendesk.android.Zendesk"}))
    static Messaging instance() {
        return Companion.instance();
    }

    @JvmStatic
    @Deprecated(message = "Please use Zendesk.invalidate instead", replaceWith = @ReplaceWith(expression = "Zendesk.invalidate()", imports = {"zendesk.android.Zendesk"}))
    static void invalidate() {
        Companion.invalidate();
    }

    @JvmStatic
    @Deprecated(message = "Please use Messaging.setDelegate", replaceWith = @ReplaceWith(expression = "Messaging.setDelegate(messagingDelegate)", imports = {"zendesk.android.messaging.Messaging"}))
    static void setDelegate(MessagingDelegate messagingDelegate) {
        Companion.setDelegate(messagingDelegate);
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007J\b\u0010\u000f\u001a\u00020\u000bH\u0007J\b\u0010\u0010\u001a\u00020\u0004H\u0007J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¨\u0006\u0014"}, d2 = {"Lzendesk/messaging/android/Messaging$Companion;", "", "()V", "initialize", "", "context", "Landroid/content/Context;", "channelKey", "", "successCallback", "Lzendesk/messaging/android/SuccessCallback;", "Lzendesk/messaging/android/Messaging;", "failureCallback", "Lzendesk/messaging/android/FailureCallback;", "Lzendesk/messaging/android/MessagingError;", "instance", "invalidate", "setDelegate", "messagingDelegate", "Lzendesk/messaging/android/MessagingDelegate;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Messaging.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @JvmStatic
        @Deprecated(message = "Please use Zendesk.initialize instead", replaceWith = @ReplaceWith(expression = "Zendesk.initialize(context, channelKey, successCallback, failureCallback,\n DefaultMessagingFactory())", imports = {"zendesk.android.Zendesk"}))
        public final void initialize(Context context, String str, SuccessCallback<Messaging> successCallback, FailureCallback<MessagingError> failureCallback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "channelKey");
            Intrinsics.checkNotNullParameter(successCallback, "successCallback");
            Intrinsics.checkNotNullParameter(failureCallback, "failureCallback");
            Context context2 = context;
            String str2 = str;
            Zendesk.Companion.initialize(context2, str2, new Messaging$Companion$$ExternalSyntheticLambda0(successCallback), new Messaging$Companion$$ExternalSyntheticLambda1(failureCallback), new DefaultMessagingFactory());
        }

        /* access modifiers changed from: private */
        /* renamed from: initialize$lambda-0  reason: not valid java name */
        public static final void m141initialize$lambda0(SuccessCallback successCallback, Zendesk zendesk2) {
            Intrinsics.checkNotNullParameter(successCallback, "$successCallback");
            Intrinsics.checkNotNullParameter(zendesk2, "it");
            successCallback.onSuccess(new WrapperMessaging(zendesk2));
        }

        /* access modifiers changed from: private */
        /* renamed from: initialize$lambda-1  reason: not valid java name */
        public static final void m142initialize$lambda1(FailureCallback failureCallback, Throwable th) {
            MessagingError messagingError;
            Intrinsics.checkNotNullParameter(failureCallback, "$failureCallback");
            Intrinsics.checkNotNullParameter(th, "it");
            if (Intrinsics.areEqual((Object) th, (Object) ZendeskError.AccountNotFound.INSTANCE)) {
                messagingError = MessagingError.AccountNotFound.INSTANCE;
            } else if (th instanceof ZendeskError.FailedToInitialize) {
                messagingError = new MessagingError.FailedToInitialize(th.getCause());
            } else if (Intrinsics.areEqual((Object) th, (Object) ZendeskError.InvalidChannelKey.INSTANCE)) {
                messagingError = MessagingError.InvalidChannelKey.INSTANCE;
            } else if (Intrinsics.areEqual((Object) th, (Object) ZendeskError.MissingConfiguration.INSTANCE)) {
                messagingError = MessagingError.MissingConfiguration.INSTANCE;
            } else if (Intrinsics.areEqual((Object) th, (Object) ZendeskError.NotInitialized.INSTANCE)) {
                messagingError = MessagingError.NotInitialized.INSTANCE;
            } else {
                messagingError = Intrinsics.areEqual((Object) th, (Object) ZendeskError.SdkNotEnabled.INSTANCE) ? MessagingError.SdkNotEnabled.INSTANCE : null;
            }
            failureCallback.onFailure(messagingError);
        }

        @JvmStatic
        @Deprecated(message = "Please use Zendesk#messaging instead", replaceWith = @ReplaceWith(expression = "Zendesk.instance().messaging()", imports = {"zendesk.android.Zendesk"}))
        public final Messaging instance() {
            return new WrapperMessaging(Zendesk.Companion.getInstance());
        }

        @JvmStatic
        @Deprecated(message = "Please use Zendesk.invalidate instead", replaceWith = @ReplaceWith(expression = "Zendesk.invalidate()", imports = {"zendesk.android.Zendesk"}))
        public final void invalidate() {
            Zendesk.Companion.invalidate();
        }

        @JvmStatic
        @Deprecated(message = "Please use Messaging.setDelegate", replaceWith = @ReplaceWith(expression = "Messaging.setDelegate(messagingDelegate)", imports = {"zendesk.android.messaging.Messaging"}))
        public final void setDelegate(MessagingDelegate messagingDelegate) {
            zendesk.android.messaging.Messaging.Companion.setDelegate(messagingDelegate);
        }
    }
}
