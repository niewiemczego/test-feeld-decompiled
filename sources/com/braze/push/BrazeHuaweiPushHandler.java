package com.braze.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.braze.Constants;
import com.braze.push.BrazePushReceiver;
import com.braze.support.BrazeLogger;
import com.braze.support.BundleUtils;
import com.facebook.internal.ServerProtocol;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0007¨\u0006\n"}, d2 = {"Lcom/braze/push/BrazeHuaweiPushHandler;", "", "()V", "handleHmsRemoteMessageData", "", "context", "Landroid/content/Context;", "hmsRemoteMessageData", "", "", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeHuaweiPushHandler.kt */
public final class BrazeHuaweiPushHandler {
    public static final BrazeHuaweiPushHandler INSTANCE = new BrazeHuaweiPushHandler();

    private BrazeHuaweiPushHandler() {
    }

    @JvmStatic
    public static final boolean handleHmsRemoteMessageData(Context context, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(context, "context");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeHuaweiPushHandler brazeHuaweiPushHandler = INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) brazeHuaweiPushHandler, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeHuaweiPushHandler$handleHmsRemoteMessageData$1(map), 2, (Object) null);
        if (map == null || map.isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) brazeHuaweiPushHandler, BrazeLogger.Priority.W, (Throwable) null, (Function0) BrazeHuaweiPushHandler$handleHmsRemoteMessageData$2.INSTANCE, 2, (Object) null);
            return false;
        }
        Bundle bundle = BundleUtils.toBundle(map);
        if (!bundle.containsKey(Constants.BRAZE_PUSH_BRAZE_KEY) || !Intrinsics.areEqual((Object) ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, (Object) bundle.getString(Constants.BRAZE_PUSH_BRAZE_KEY))) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) brazeHuaweiPushHandler, BrazeLogger.Priority.I, (Throwable) null, (Function0) BrazeHuaweiPushHandler$handleHmsRemoteMessageData$3.INSTANCE, 2, (Object) null);
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) brazeHuaweiPushHandler, BrazeLogger.Priority.I, (Throwable) null, (Function0) new BrazeHuaweiPushHandler$handleHmsRemoteMessageData$4(bundle), 2, (Object) null);
        Intent intent = new Intent(BrazePushReceiver.HMS_PUSH_SERVICE_ROUTING_ACTION);
        intent.putExtras(bundle);
        BrazePushReceiver.Companion.handleReceivedIntent$default(BrazePushReceiver.Companion, context, intent, false, 4, (Object) null);
        return true;
    }
}
