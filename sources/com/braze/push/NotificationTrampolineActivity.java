package com.braze.push;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.braze.Constants;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.push.BrazePushReceiver;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014¨\u0006\t"}, d2 = {"Lcom/braze/push/NotificationTrampolineActivity;", "Landroid/app/Activity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NotificationTrampolineActivity.kt */
public final class NotificationTrampolineActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) NotificationTrampolineActivity$onCreate$1.INSTANCE, 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        try {
            Intent intent = getIntent();
            if (intent == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) NotificationTrampolineActivity$onResume$1.INSTANCE, 3, (Object) null);
                finish();
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) NotificationTrampolineActivity$onResume$2.INSTANCE, 3, (Object) null);
                finish();
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new NotificationTrampolineActivity$onResume$3(intent), 2, (Object) null);
            Intent intent2 = new Intent(action).setClass(this, BrazeNotificationUtils.getNotificationReceiverClass());
            Intrinsics.checkNotNullExpressionValue(intent2, "Intent(action).setClass(…otificationReceiverClass)");
            Bundle extras = intent.getExtras();
            if (extras != null) {
                intent2.putExtras(extras);
            }
            if (Constants.isAmazonDevice()) {
                BrazePushReceiver.Companion.handleReceivedIntent$default(BrazePushReceiver.Companion, this, intent2, false, 4, (Object) null);
            } else {
                BrazePushReceiver.Companion.handleReceivedIntent(this, intent2, false);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) NotificationTrampolineActivity$onResume$6.INSTANCE, 2, (Object) null);
            BrazeCoroutineScope.launchDelayed$default(BrazeCoroutineScope.INSTANCE, (Number) 200, (CoroutineContext) null, new NotificationTrampolineActivity$onResume$7(this, (Continuation<? super NotificationTrampolineActivity$onResume$7>) null), 2, (Object) null);
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) NotificationTrampolineActivity$onResume$5.INSTANCE);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) NotificationTrampolineActivity$onPause$1.INSTANCE, 2, (Object) null);
        finish();
    }
}
