package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class c1 {
    public static final a b = new a((DefaultConstructorMarker) null);
    private static final long c = TimeUnit.DAYS.toMillis(7);
    private final SharedPreferences a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(x1 x1Var) {
            Intrinsics.checkNotNullParameter(x1Var, "event");
            return x1Var.a() + i4.j.a(x1Var);
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ Map.Entry b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Map.Entry entry) {
            super(0);
            this.b = entry;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get expiration time. Deleting entry: " + this.b;
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ x1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(x1 x1Var) {
            super(0);
            this.b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Event already seen in cache. Ignoring duplicate: " + this.b;
        }
    }

    public c1(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str2, DynamicLink.Builder.KEY_API_KEY);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.storage.event_data_validator" + StringUtils.getCacheFileSuffix(context, str, str2), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.a = sharedPreferences;
        a();
    }

    private final boolean b(String str) {
        return this.a.contains(str);
    }

    public boolean a(x1 x1Var) {
        Intrinsics.checkNotNullParameter(x1Var, "event");
        if (x1Var.a() != h1.PUSH_CLICKED) {
            return true;
        }
        a();
        String a2 = b.a(x1Var);
        if (b(a2)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new c(x1Var), 3, (Object) null);
            return false;
        }
        a(DateTimeUtils.nowInMilliseconds() + c, a2);
        return true;
    }

    private final void a(String str) {
        this.a.edit().remove(str).apply();
    }

    public final void a(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "eventKey");
        this.a.edit().putLong(str, j).apply();
    }

    public final void a() {
        long nowInMilliseconds = DateTimeUtils.nowInMilliseconds();
        for (Map.Entry next : this.a.getAll().entrySet()) {
            try {
                Object value = next.getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Long");
                if (nowInMilliseconds >= ((Long) value).longValue()) {
                    Object key = next.getKey();
                    Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                    a((String) key);
                }
            } catch (Exception e) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) new b(next));
                Object key2 = next.getKey();
                Intrinsics.checkNotNullExpressionValue(key2, "entry.key");
                a((String) key2);
            }
        }
    }
}
