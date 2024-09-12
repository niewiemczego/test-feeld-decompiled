package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class q6 implements y2 {
    public static final a d = new a((DefaultConstructorMarker) null);
    private final SharedPreferences a;
    private final Map b = a();
    private final Map c = new LinkedHashMap();

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ z2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(z2 z2Var) {
            super(0);
            this.b = z2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Triggered action id " + this.b.getId() + " always eligible via configuration. Returning true for eligibility status";
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ z2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(z2 z2Var) {
            super(0);
            this.b = z2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Triggered action id " + this.b.getId() + " always eligible via never having been triggered. Returning true for eligibility status";
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ z2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(z2 z2Var) {
            super(0);
            this.b = z2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Triggered action id " + this.b.getId() + " no longer eligible due to having been triggered in the past and is only eligible once.";
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ long b;
        final /* synthetic */ m2 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(long j, m2 m2Var) {
            super(0);
            this.b = j;
            this.c = m2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Trigger action is re-eligible for display since " + (DateTimeUtils.nowInSeconds() - this.b) + " seconds have passed since the last time it was triggered (minimum interval: " + this.c.g() + ").";
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ long b;
        final /* synthetic */ m2 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(long j, m2 m2Var) {
            super(0);
            this.b = j;
            this.c = m2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Trigger action is not re-eligible for display since only " + (DateTimeUtils.nowInSeconds() - this.b) + " seconds have passed since the last time it was triggered (minimum interval: " + this.c.g() + ").";
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ z2 b;
        final /* synthetic */ long c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(z2 z2Var, long j) {
            super(0);
            this.b = z2Var;
            this.c = j;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Updating re-eligibility for action Id " + this.b.getId() + " to time " + this.c + '.';
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Deleting outdated triggered action id " + this.b + " from stored re-eligibility list. In-memory re-eligibility list is unchanged.";
        }
    }

    static final class i extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Retaining triggered action " + this.b + " in re-eligibility list.";
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ z2 b;
        final /* synthetic */ long c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(z2 z2Var, long j) {
            super(0);
            this.b = z2Var;
            this.c = j;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Resetting re-eligibility for action Id " + this.b.getId() + " to " + this.c;
        }
    }

    static final class k extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Retrieving triggered action id " + this.b + " eligibility information from local storage.";
        }
    }

    static final class l extends Lambda implements Function0 {
        public static final l b = new l();

        l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Encountered unexpected exception while parsing stored re-eligibility information.";
        }
    }

    public q6(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str2, DynamicLink.Builder.KEY_API_KEY);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.storage.triggers.re_eligibility" + StringUtils.getCacheFileSuffix(context, str, str2), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.a = sharedPreferences;
    }

    public void a(z2 z2Var, long j2) {
        Intrinsics.checkNotNullParameter(z2Var, "triggeredAction");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new g(z2Var, j2), 3, (Object) null);
        Map map = this.c;
        String id = z2Var.getId();
        Long l2 = (Long) this.b.get(z2Var.getId());
        map.put(id, Long.valueOf(l2 != null ? l2.longValue() : 0));
        this.b.put(z2Var.getId(), Long.valueOf(j2));
        this.a.edit().putLong(z2Var.getId(), j2).apply();
    }

    public boolean b(z2 z2Var) {
        Intrinsics.checkNotNullParameter(z2Var, "triggeredAction");
        m2 i2 = z2Var.n().i();
        if (i2.e()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new b(z2Var), 3, (Object) null);
            return true;
        } else if (!this.b.containsKey(z2Var.getId())) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new c(z2Var), 3, (Object) null);
            return true;
        } else if (i2.h()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new d(z2Var), 3, (Object) null);
            return false;
        } else {
            Long l2 = (Long) this.b.get(z2Var.getId());
            long longValue = l2 != null ? l2.longValue() : 0;
            long nowInSeconds = DateTimeUtils.nowInSeconds() + ((long) z2Var.n().o());
            Integer g2 = i2.g();
            if (nowInSeconds >= ((long) (g2 != null ? g2.intValue() : 0)) + longValue) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new e(longValue, i2), 3, (Object) null);
                return true;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new f(longValue, i2), 3, (Object) null);
            return false;
        }
    }

    public void c(z2 z2Var) {
        Intrinsics.checkNotNullParameter(z2Var, "triggeredAction");
        if (z2Var.n().i().h()) {
            this.b.remove(z2Var.getId());
            this.a.edit().remove(z2Var.getId()).apply();
            return;
        }
        Long l2 = (Long) this.c.get(z2Var.getId());
        long longValue = l2 != null ? l2.longValue() : 0;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new j(z2Var, longValue), 3, (Object) null);
        this.b.put(z2Var.getId(), Long.valueOf(longValue));
        this.a.edit().putLong(z2Var.getId(), longValue).apply();
    }

    private final Map a() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        try {
            for (String next : this.a.getAll().keySet()) {
                long j2 = this.a.getLong(next, 0);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new k(next), 3, (Object) null);
                Long valueOf = Long.valueOf(j2);
                Intrinsics.checkNotNullExpressionValue(next, "actionId");
                concurrentHashMap.put(next, valueOf);
            }
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) l.b);
        }
        return concurrentHashMap;
    }

    public void a(List list) {
        Intrinsics.checkNotNullParameter(list, "triggeredActions");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((z2) it.next()).getId());
        }
        SharedPreferences.Editor edit = this.a.edit();
        for (String str : CollectionsKt.toSet(this.b.keySet())) {
            if (!arrayList.contains(str)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new h(str), 3, (Object) null);
                edit.remove(str);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new i(str), 3, (Object) null);
            }
        }
        edit.apply();
    }
}
