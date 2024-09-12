package com.braze;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bo.app.l;
import com.braze.support.BrazeLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0017\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u000e"}, d2 = {"Lcom/braze/BrazeBootReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "", "handleIncomingIntent", "<init>", "()V", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public class BrazeBootReceiver extends BroadcastReceiver {
    private static final String BOOT_COMPLETE_ACTION = "android.intent.action.BOOT_COMPLETED";
    public static final a Companion = new a((DefaultConstructorMarker) null);

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
            return "Received broadcast message. Message: " + this.b;
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Boot complete intent received. Initializing.";
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ Intent b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Intent intent) {
            super(0);
            this.b = intent;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unknown intent " + this.b + " received. Doing nothing.";
        }
    }

    public final boolean handleIncomingIntent(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.I;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, (Function0) new b(intent), 2, (Object) null);
        if (Intrinsics.areEqual((Object) BOOT_COMPLETE_ACTION, (Object) intent.getAction())) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, (Function0) c.b, 2, (Object) null);
            new l().a(context);
            Braze.Companion.getInstance(context);
            return true;
        }
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new d(intent), 2, (Object) null);
        return false;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        handleIncomingIntent(context, intent);
    }
}
