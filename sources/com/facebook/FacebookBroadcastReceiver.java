package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0014J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0014¨\u0006\u0010"}, d2 = {"Lcom/facebook/FacebookBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onFailedAppCall", "", "appCallId", "", "action", "extras", "Landroid/os/Bundle;", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "onSuccessfulAppCall", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FacebookBroadcastReceiver.kt */
public class FacebookBroadcastReceiver extends BroadcastReceiver {
    /* access modifiers changed from: protected */
    public void onFailedAppCall(String str, String str2, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "appCallId");
        Intrinsics.checkNotNullParameter(str2, "action");
        Intrinsics.checkNotNullParameter(bundle, "extras");
    }

    /* access modifiers changed from: protected */
    public void onSuccessfulAppCall(String str, String str2, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "appCallId");
        Intrinsics.checkNotNullParameter(str2, "action");
        Intrinsics.checkNotNullParameter(bundle, "extras");
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        String stringExtra = intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_CALL_ID);
        String stringExtra2 = intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_ACTION);
        Bundle extras = intent.getExtras();
        if (stringExtra != null && stringExtra2 != null && extras != null) {
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            if (NativeProtocol.isErrorResult(intent)) {
                onFailedAppCall(stringExtra, stringExtra2, extras);
            } else {
                onSuccessfulAppCall(stringExtra, stringExtra2, extras);
            }
        }
    }
}
