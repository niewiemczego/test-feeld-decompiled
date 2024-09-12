package com.braze.support;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.braze.support.BrazeLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import java.util.Random;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0007J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\b\u0010\u0014\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/braze/support/IntentUtils;", "", "()V", "REQUEST_CODE_MAX", "", "REQUEST_CODE_MIN", "random", "Ljava/util/Random;", "getRandom", "()Ljava/util/Random;", "random$delegate", "Lkotlin/Lazy;", "addComponentAndSendBroadcast", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "getImmutablePendingIntentFlags", "getMutablePendingIntentFlags", "getRequestCode", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntentUtils {
    public static final IntentUtils INSTANCE = new IntentUtils();
    private static final int REQUEST_CODE_MAX = 1073741823;
    private static final int REQUEST_CODE_MIN = 100000;
    private static final Lazy random$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, b.b);

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ ComponentName b;
        final /* synthetic */ Intent c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ComponentName componentName, Intent intent) {
            super(0);
            this.b = componentName;
            this.c = intent;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Sent intent with component " + this.b + " and explicit intent " + this.c;
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final Random invoke() {
            return new Random();
        }
    }

    private IntentUtils() {
    }

    @JvmStatic
    public static final void addComponentAndSendBroadcast(Context context, Intent intent) {
        List<ResolveInfo> list;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        if (Build.VERSION.SDK_INT >= 33) {
            list = context.getPackageManager().queryBroadcastReceivers(intent, PackageManager.ResolveInfoFlags.of(0));
        } else {
            list = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        }
        Intrinsics.checkNotNullExpressionValue(list, "if (Build.VERSION.SDK_IN…vers(intent, 0)\n        }");
        for (ResolveInfo resolveInfo : list) {
            Intent intent2 = new Intent(intent);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
            intent2.setComponent(componentName);
            context.sendBroadcast(intent2);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.V, (Throwable) null, (Function0) new a(componentName, intent2), 2, (Object) null);
        }
    }

    @JvmStatic
    public static final int getImmutablePendingIntentFlags() {
        return Build.VERSION.SDK_INT >= 23 ? 67108864 : 0;
    }

    @JvmStatic
    public static final int getMutablePendingIntentFlags() {
        return Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
    }

    private final Random getRandom() {
        return (Random) random$delegate.getValue();
    }

    @JvmStatic
    public static final int getRequestCode() {
        return INSTANCE.getRandom().nextInt(1073741823) + 100000;
    }
}
