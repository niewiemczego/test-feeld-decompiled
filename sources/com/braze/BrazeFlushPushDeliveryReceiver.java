package com.braze;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.braze.support.BrazeLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\f"}, d2 = {"Lcom/braze/BrazeFlushPushDeliveryReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "<init>", "()V", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public class BrazeFlushPushDeliveryReceiver extends BroadcastReceiver {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String FLUSH_BRAZE_PUSH_DELIVERIES_ACTION = "com.braze.FLUSH_PUSH_DELIVERY";

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ Intent b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Intent intent) {
            super(0);
            this.b = intent;
        }

        /* renamed from: a */
        public final String invoke() {
            return "BrazeFlushPushDeliveryReceiver received intent: " + this.b.getAction();
        }
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new b(intent), 3, (Object) null);
        if (Intrinsics.areEqual((Object) intent.getAction(), (Object) FLUSH_BRAZE_PUSH_DELIVERIES_ACTION)) {
            BrazeInternal.INSTANCE.performPushDeliveryFlush(context);
        }
    }
}
