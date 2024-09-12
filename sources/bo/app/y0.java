package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.DateTimeUtils;
import com.facebook.react.uimanager.events.TouchesHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class y0 {
    public static final a b = new a((DefaultConstructorMarker) null);
    private final SharedPreferences a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public y0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("persistent.com.braze.requests.metadata.last_req_at", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…LE, Context.MODE_PRIVATE)");
        this.a = sharedPreferences;
    }

    private final long a(boolean z) {
        return z ? 2 : 1;
    }

    public final void b(b5 b5Var, boolean z) {
        Intrinsics.checkNotNullParameter(b5Var, TouchesHelper.TARGET_KEY);
        this.a.edit().putLong(a(b5Var.c()), a(z)).apply();
    }

    public final long a(b5 b5Var) {
        Intrinsics.checkNotNullParameter(b5Var, TouchesHelper.TARGET_KEY);
        String str = "uri-" + b5Var.c().hashCode();
        long j = this.a.getLong(str, 0);
        long nowInMilliseconds = DateTimeUtils.nowInMilliseconds();
        this.a.edit().putLong(str, nowInMilliseconds).apply();
        return Math.min(nowInMilliseconds - j, 7200000);
    }

    public final long a(b5 b5Var, boolean z) {
        Intrinsics.checkNotNullParameter(b5Var, TouchesHelper.TARGET_KEY);
        String a2 = a(b5Var.c());
        long j = this.a.getLong(a2, a(z));
        this.a.edit().putLong(a2, 1 + j).apply();
        return j;
    }

    private final String a(String str) {
        return "uri-at-" + str.hashCode();
    }
}
