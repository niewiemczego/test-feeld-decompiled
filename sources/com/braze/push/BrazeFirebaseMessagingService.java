package com.braze.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.braze.Braze;
import com.braze.BrazeInternal;
import com.braze.Constants;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.push.BrazePushReceiver;
import com.braze.support.BrazeLogger;
import com.braze.support.ReflectionUtils;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/braze/push/BrazeFirebaseMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "onMessageReceived", "", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "newToken", "", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeFirebaseMessagingService.kt */
public class BrazeFirebaseMessagingService extends FirebaseMessagingService {
    private static final String CONTEXT_ATTACH_METHOD = "attachBaseContext";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FCM_SERVICE_OMR_METHOD = "onMessageReceived";

    @JvmStatic
    public static final boolean handleBrazeRemoteMessage(Context context, RemoteMessage remoteMessage) {
        return Companion.handleBrazeRemoteMessage(context, remoteMessage);
    }

    @JvmStatic
    public static final boolean isBrazePushNotification(RemoteMessage remoteMessage) {
        return Companion.isBrazePushNotification(remoteMessage);
    }

    public void onNewToken(String str) {
        Intrinsics.checkNotNullParameter(str, "newToken");
        super.onNewToken(str);
        Context context = this;
        BrazeInternal.applyPendingRuntimeConfiguration(context);
        BrazeConfigurationProvider brazeConfigurationProvider = new BrazeConfigurationProvider(context);
        CharSequence configuredApiKey = Braze.Companion.getConfiguredApiKey(brazeConfigurationProvider);
        if (configuredApiKey == null || configuredApiKey.length() == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeFirebaseMessagingService$onNewToken$1(str), 2, (Object) null);
        } else if (!brazeConfigurationProvider.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeFirebaseMessagingService$onNewToken$2(str), 2, (Object) null);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeFirebaseMessagingService$onNewToken$3(str), 2, (Object) null);
            Braze.Companion.getInstance(context).setRegisteredPushToken(str);
        }
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        super.onMessageReceived(remoteMessage);
        Companion.handleBrazeRemoteMessage(this, remoteMessage);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J%\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\u000fJ\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/braze/push/BrazeFirebaseMessagingService$Companion;", "", "()V", "CONTEXT_ATTACH_METHOD", "", "FCM_SERVICE_OMR_METHOD", "handleBrazeRemoteMessage", "", "context", "Landroid/content/Context;", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "invokeFallbackFirebaseService", "", "classpath", "invokeFallbackFirebaseService$android_sdk_ui_release", "isBrazePushNotification", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BrazeFirebaseMessagingService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean handleBrazeRemoteMessage(Context context, RemoteMessage remoteMessage) {
            Context context2 = context;
            RemoteMessage remoteMessage2 = remoteMessage;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(remoteMessage2, "remoteMessage");
            if (!isBrazePushNotification(remoteMessage2)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$1(remoteMessage2), 2, (Object) null);
                BrazeConfigurationProvider brazeConfigurationProvider = new BrazeConfigurationProvider(context);
                if (!brazeConfigurationProvider.isFallbackFirebaseMessagingServiceEnabled()) {
                    return false;
                }
                String fallbackFirebaseMessagingServiceClasspath = brazeConfigurationProvider.getFallbackFirebaseMessagingServiceClasspath();
                if (fallbackFirebaseMessagingServiceClasspath != null) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$2(fallbackFirebaseMessagingServiceClasspath), 2, (Object) null);
                    invokeFallbackFirebaseService$android_sdk_ui_release(fallbackFirebaseMessagingServiceClasspath, remoteMessage2, context);
                    return false;
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$3.INSTANCE, 3, (Object) null);
                return false;
            }
            Map<String, String> data = remoteMessage.getData();
            Intrinsics.checkNotNullExpressionValue(data, "remoteMessage.data");
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$4(data), 2, (Object) null);
            Intent intent = new Intent(BrazePushReceiver.FIREBASE_MESSAGING_SERVICE_ROUTING_ACTION);
            Bundle bundle = new Bundle();
            for (Map.Entry next : data.entrySet()) {
                String str = (String) next.getKey();
                String str2 = (String) next.getValue();
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$5(str, str2), 2, (Object) null);
                bundle.putString(str, str2);
            }
            intent.putExtras(bundle);
            BrazePushReceiver.Companion.handleReceivedIntent$default(BrazePushReceiver.Companion, context, intent, false, 4, (Object) null);
            return true;
        }

        @JvmStatic
        public final boolean isBrazePushNotification(RemoteMessage remoteMessage) {
            Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
            Map<String, String> data = remoteMessage.getData();
            Intrinsics.checkNotNullExpressionValue(data, "remoteMessage.data");
            return Intrinsics.areEqual((Object) ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, (Object) data.get(Constants.BRAZE_PUSH_BRAZE_KEY));
        }

        public final void invokeFallbackFirebaseService$android_sdk_ui_release(String str, RemoteMessage remoteMessage, Context context) {
            String str2 = str;
            RemoteMessage remoteMessage2 = remoteMessage;
            Context context2 = context;
            Intrinsics.checkNotNullParameter(str2, "classpath");
            Intrinsics.checkNotNullParameter(remoteMessage2, "remoteMessage");
            Intrinsics.checkNotNullParameter(context2, "context");
            Object constructObjectQuietly$default = ReflectionUtils.constructObjectQuietly$default(ReflectionUtils.INSTANCE, str, (List) null, (List) null, 6, (Object) null);
            if (constructObjectQuietly$default == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeFirebaseMessagingService$Companion$invokeFallbackFirebaseService$1(str2), 3, (Object) null);
                return;
            }
            Method declaredMethodQuietly = ReflectionUtils.INSTANCE.getDeclaredMethodQuietly(str2, BrazeFirebaseMessagingService.CONTEXT_ATTACH_METHOD, (Class<?>[]) new Class[]{Context.class});
            if (declaredMethodQuietly != null) {
                declaredMethodQuietly.setAccessible(true);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeFirebaseMessagingService$Companion$invokeFallbackFirebaseService$2(str2), 3, (Object) null);
                if (!ReflectionUtils.invokeMethodQuietly(constructObjectQuietly$default, declaredMethodQuietly, context2).getFirst().booleanValue()) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeFirebaseMessagingService$Companion$invokeFallbackFirebaseService$3(str2), 3, (Object) null);
                    return;
                }
                Method methodQuietly = ReflectionUtils.getMethodQuietly(str2, BrazeFirebaseMessagingService.FCM_SERVICE_OMR_METHOD, (Class<?>[]) new Class[]{RemoteMessage.class});
                if (methodQuietly == null) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeFirebaseMessagingService$Companion$invokeFallbackFirebaseService$5(str2), 3, (Object) null);
                    return;
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeFirebaseMessagingService$Companion$invokeFallbackFirebaseService$6(str2), 3, (Object) null);
                if (!ReflectionUtils.invokeMethodQuietly(constructObjectQuietly$default, methodQuietly, remoteMessage2).getFirst().booleanValue()) {
                    "Failure invoking " + str2 + ".onMessageReceived.";
                    return;
                }
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeFirebaseMessagingService$Companion$invokeFallbackFirebaseService$4.INSTANCE, 3, (Object) null);
        }
    }
}
