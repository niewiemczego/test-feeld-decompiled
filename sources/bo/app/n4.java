package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import com.google.firebase.dynamiclinks.DynamicLink;
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

public final class n4 {
    public static final b d = new b((DefaultConstructorMarker) null);
    private final l5 a;
    private final SharedPreferences b;
    private final SharedPreferences c;

    public static final class a {
        private final String a;
        private final long b;

        public a(String str, long j) {
            Intrinsics.checkNotNullParameter(str, "id");
            this.a = str;
            this.b = j;
        }

        public final String a() {
            return this.a;
        }

        public final long b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual((Object) this.a, (Object) aVar.a) && this.b == aVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Long.hashCode(this.b);
        }

        public String toString() {
            return "CampaignData(id=" + this.a + ", timestamp=" + this.b + ')';
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private b() {
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Adding push campaign to storage with uid " + this.b;
        }
    }

    public n4(Context context, String str, String str2, i2 i2Var, l5 l5Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, DynamicLink.Builder.KEY_API_KEY);
        Intrinsics.checkNotNullParameter(i2Var, "internalEventPublisher");
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        this.a = l5Var;
        this.b = context.getSharedPreferences("com.braze.storage.braze_push_max_storage" + StringUtils.getCacheFileSuffix(context, str2, str), 0);
        this.c = context.getSharedPreferences("com.braze.storage.braze_push_max_metadata" + StringUtils.getCacheFileSuffix(context, str2, str), 0);
        i2Var.c(o4.class, new n4$$ExternalSyntheticLambda0(this));
        c();
    }

    public final List a() {
        long b2 = b() - this.a.t();
        SharedPreferences sharedPreferences = this.b;
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "pushMaxPrefs");
        List a2 = a(sharedPreferences);
        ArrayList arrayList = new ArrayList();
        for (Object next : a2) {
            if (((a) next).b() > b2) {
                arrayList.add(next);
            }
        }
        return CollectionsKt.toList(arrayList);
    }

    public final long b() {
        return this.c.getLong("lastUpdateTime", -1);
    }

    public final void c() {
        long nowInSeconds = DateTimeUtils.nowInSeconds() - TimeUnit.DAYS.toSeconds(45);
        SharedPreferences sharedPreferences = this.b;
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "pushMaxPrefs");
        List<a> a2 = a(sharedPreferences);
        SharedPreferences.Editor edit = this.b.edit();
        for (a aVar : a2) {
            if (this.b.getLong(aVar.a(), 0) < nowInSeconds) {
                edit.remove(aVar.a());
            }
        }
        edit.apply();
    }

    public final void d() {
        this.b.edit().clear().apply();
        this.c.edit().clear().apply();
    }

    public final void a(long j) {
        this.c.edit().putLong("lastUpdateTime", j).apply();
    }

    /* access modifiers changed from: private */
    public static final void a(n4 n4Var, o4 o4Var) {
        Intrinsics.checkNotNullParameter(n4Var, "this$0");
        Intrinsics.checkNotNullParameter(o4Var, "it");
        n4Var.a(o4Var.a());
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "pushCampaign");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new c(str), 3, (Object) null);
        if (!StringsKt.isBlank(str)) {
            this.b.edit().putLong(str, DateTimeUtils.nowInSeconds()).apply();
        }
    }

    private final List a(SharedPreferences sharedPreferences) {
        ArrayList arrayList = new ArrayList();
        Map<String, ?> all = sharedPreferences.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "this.all");
        for (Map.Entry<String, ?> key : all.entrySet()) {
            String str = (String) key.getKey();
            Intrinsics.checkNotNullExpressionValue(str, "campaignId");
            arrayList.add(new a(str, sharedPreferences.getLong(str, 0)));
        }
        return CollectionsKt.toList(arrayList);
    }
}
