package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/facebook/CustomTabMainActivity$onCreate$redirectReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CustomTabMainActivity.kt */
public final class CustomTabMainActivity$onCreate$redirectReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ CustomTabMainActivity this$0;

    CustomTabMainActivity$onCreate$redirectReceiver$1(CustomTabMainActivity customTabMainActivity) {
        this.this$0 = customTabMainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        Intent intent2 = new Intent(this.this$0, CustomTabMainActivity.class);
        intent2.setAction(CustomTabMainActivity.REFRESH_ACTION);
        intent2.putExtra(CustomTabMainActivity.EXTRA_URL, intent.getStringExtra(CustomTabMainActivity.EXTRA_URL));
        intent2.addFlags(603979776);
        this.this$0.startActivity(intent2);
    }
}
