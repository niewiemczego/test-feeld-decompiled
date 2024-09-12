package dev.geundung.zendesk.messaging;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.FailureCallback;
import zendesk.android.SuccessCallback;
import zendesk.android.Zendesk;
import zendesk.android.ZendeskUser;
import zendesk.android.events.ZendeskEventListener;
import zendesk.android.messaging.Messaging;
import zendesk.android.messaging.MessagingFactory;
import zendesk.android.pageviewevents.PageView;
import zendesk.messaging.android.push.PushNotifications;
import zendesk.messaging.android.push.PushResponsibility;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\r\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ8\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012J<\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ*\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\"\u0010 \u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0006\u0010!\u001a\u00020\u0004J*\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0015\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010)\u001a\u00020\bJ\u000e\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0010¨\u0006-"}, d2 = {"Ldev/geundung/zendesk/messaging/ZendeskNativeModule;", "", "()V", "addEventListener", "", "listener", "Lzendesk/android/events/ZendeskEventListener;", "getUnreadMessageCount", "", "()Ljava/lang/Integer;", "handleNotification", "", "context", "Landroid/content/Context;", "messageData", "", "", "callback", "Lkotlin/Function1;", "initialize", "channelKey", "successCallback", "Lzendesk/android/SuccessCallback;", "Lzendesk/android/Zendesk;", "failureCallback", "Lzendesk/android/FailureCallback;", "", "messagingFactory", "Lzendesk/android/messaging/MessagingFactory;", "loginUser", "token", "Lzendesk/android/ZendeskUser;", "logoutUser", "reset", "sendPageViewEvent", "pageView", "Lzendesk/android/pageviewevents/PageView;", "setNotificationSmallIconId", "resourceId", "(Ljava/lang/Integer;)V", "showMessaging", "intentFlags", "updatePushNotificationToken", "newToken", "Companion", "react-native-zendesk-messaging_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ZendeskNativeModule.kt */
public final class ZendeskNativeModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static ZendeskNativeModule instance;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ZendeskNativeModule.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PushResponsibility.values().length];
            iArr[PushResponsibility.MESSAGING_SHOULD_DISPLAY.ordinal()] = 1;
            iArr[PushResponsibility.MESSAGING_SHOULD_NOT_DISPLAY.ordinal()] = 2;
            iArr[PushResponsibility.NOT_FROM_MESSAGING.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ ZendeskNativeModule(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final ZendeskNativeModule getInstance() {
        return Companion.getInstance();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ldev/geundung/zendesk/messaging/ZendeskNativeModule$Companion;", "", "()V", "instance", "Ldev/geundung/zendesk/messaging/ZendeskNativeModule;", "getInstance", "react-native-zendesk-messaging_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ZendeskNativeModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ZendeskNativeModule getInstance() {
            ZendeskNativeModule access$getInstance$cp = ZendeskNativeModule.instance;
            if (access$getInstance$cp == null) {
                synchronized (this) {
                    access$getInstance$cp = ZendeskNativeModule.instance;
                    if (access$getInstance$cp == null) {
                        access$getInstance$cp = new ZendeskNativeModule((DefaultConstructorMarker) null);
                        Companion companion = ZendeskNativeModule.Companion;
                        ZendeskNativeModule.instance = access$getInstance$cp;
                    }
                }
            }
            return access$getInstance$cp;
        }
    }

    private ZendeskNativeModule() {
    }

    public final void initialize(Context context, String str, SuccessCallback<Zendesk> successCallback, FailureCallback<Throwable> failureCallback, MessagingFactory messagingFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "channelKey");
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        Intrinsics.checkNotNullParameter(failureCallback, "failureCallback");
        Zendesk.Companion.initialize(context, str, successCallback, failureCallback, messagingFactory);
    }

    public final void reset() {
        Zendesk.Companion.invalidate();
    }

    public final void addEventListener(ZendeskEventListener zendeskEventListener) {
        Intrinsics.checkNotNullParameter(zendeskEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Zendesk.Companion.getInstance().addEventListener(zendeskEventListener);
    }

    public final void loginUser(String str, SuccessCallback<ZendeskUser> successCallback, FailureCallback<Throwable> failureCallback) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        Intrinsics.checkNotNullParameter(failureCallback, "failureCallback");
        Zendesk.Companion.getInstance().loginUser(str, successCallback, failureCallback);
    }

    public final void logoutUser(SuccessCallback<Unit> successCallback, FailureCallback<Throwable> failureCallback) {
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        Intrinsics.checkNotNullParameter(failureCallback, "failureCallback");
        Zendesk.Companion.getInstance().logoutUser(successCallback, failureCallback);
    }

    public final void showMessaging(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Zendesk.Companion.getInstance().getMessaging().showMessaging(context, i);
    }

    public final void sendPageViewEvent(PageView pageView, SuccessCallback<Unit> successCallback, FailureCallback<Throwable> failureCallback) {
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        Intrinsics.checkNotNullParameter(failureCallback, "failureCallback");
        Zendesk.Companion.getInstance().sendPageView(pageView, successCallback, failureCallback);
    }

    public final void setNotificationSmallIconId(Integer num) {
        PushNotifications.setNotificationSmallIconId(num);
    }

    public final void updatePushNotificationToken(String str) {
        Intrinsics.checkNotNullParameter(str, "newToken");
        PushNotifications.updatePushNotificationToken(str);
    }

    public final Integer getUnreadMessageCount() {
        Messaging messaging;
        Zendesk instance2 = Zendesk.Companion.getInstance();
        if (instance2 == null || (messaging = instance2.getMessaging()) == null) {
            return null;
        }
        return Integer.valueOf(messaging.getUnreadMessageCount());
    }

    public final boolean handleNotification(Context context, Map<String, String> map, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(map, "messageData");
        int i = WhenMappings.$EnumSwitchMapping$0[PushNotifications.shouldBeDisplayed(map).ordinal()];
        if (i == 1) {
            PushNotifications.displayNotification(context, map);
            if (function1 != null) {
                function1.invoke("MESSAGING_SHOULD_DISPLAY");
            }
        } else if (i != 2) {
            if (i != 3) {
                if (function1 == null) {
                    return false;
                }
                function1.invoke("UNKNOWN");
                return false;
            } else if (function1 == null) {
                return false;
            } else {
                function1.invoke("NOT_FROM_MESSAGING");
                return false;
            }
        } else if (function1 != null) {
            function1.invoke("MESSAGING_SHOULD_NOT_DISPLAY");
        }
        return true;
    }
}
