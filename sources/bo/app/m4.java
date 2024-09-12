package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

public final class m4 {
    public static final a b = new a((DefaultConstructorMarker) null);
    private static final long c = TimeUnit.DAYS.toSeconds(45);
    private final SharedPreferences a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ Map.Entry b;
        final /* synthetic */ long c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Map.Entry entry, long j) {
            super(0);
            this.b = entry;
            this.c = j;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Evicting push id key " + this.b + " based on cutoff: " + this.c;
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Push dedupe id is blank. Returning true.";
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Push dedupe id " + this.b + " has already been seen. Returning false.";
        }
    }

    public m4(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.braze.storage.push_identifier_storage" + StringUtils.getCacheFileSuffix(context, str2, str), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…y), Context.MODE_PRIVATE)");
        this.a = sharedPreferences;
        a();
    }

    public final List a(long j) {
        if (j <= 0) {
            return CollectionsKt.emptyList();
        }
        long nowInSeconds = DateTimeUtils.nowInSeconds() - j;
        ArrayList arrayList = new ArrayList();
        Map<String, ?> all = this.a.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "storagePrefs.all");
        for (Map.Entry next : all.entrySet()) {
            Long l = (Long) next.getValue();
            if (l != null && l.longValue() >= nowInSeconds) {
                Object key = next.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "it.key");
                arrayList.add(key);
            }
        }
        return arrayList;
    }

    public final boolean b(String str) {
        Intrinsics.checkNotNullParameter(str, "pushId");
        return this.a.contains(str);
    }

    public final boolean c(String str) {
        Intrinsics.checkNotNullParameter(str, "pushId");
        if (StringsKt.isBlank(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) c.b, 3, (Object) null);
            return true;
        } else if (b(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new d(str), 3, (Object) null);
            return false;
        } else {
            a();
            a(str);
            return true;
        }
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "pushId");
        this.a.edit().putLong(str, DateTimeUtils.nowInSeconds()).apply();
    }

    public final void a() {
        long nowInSeconds = DateTimeUtils.nowInSeconds() - c;
        SharedPreferences.Editor edit = this.a.edit();
        Map<String, ?> all = this.a.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "storagePrefs.all");
        for (Map.Entry next : all.entrySet()) {
            Long l = (Long) next.getValue();
            if (l == null || l.longValue() < nowInSeconds) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new b(next, nowInSeconds), 2, (Object) null);
                edit.remove((String) next.getKey());
            }
        }
        edit.apply();
    }
}
