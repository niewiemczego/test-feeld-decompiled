package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.enums.GeofenceTransitionType;
import com.braze.models.BrazeGeofence;
import com.braze.support.BrazeLogger;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;

public final class m {
    public static final a i = new a((DefaultConstructorMarker) null);
    public final SharedPreferences a;
    public final SharedPreferences b;
    public final Map c;
    private final AtomicBoolean d = new AtomicBoolean(false);
    public long e;
    public long f;
    public int g;
    public int h;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(int i) {
            super(0);
            this.b = i;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Min time since last geofence request reset via server configuration: " + this.b + '.';
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(int i) {
            super(0);
            this.b = i;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Min time since last geofence report reset via server configuration: " + this.b + '.';
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ m b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(m mVar, String str) {
            super(0);
            this.b = mVar;
            this.c = str;
        }

        /* renamed from: a */
        public final String invoke() {
            StringBuilder append = new StringBuilder().append("Retrieving geofence id ");
            m mVar = this.b;
            String str = this.c;
            Intrinsics.checkNotNullExpressionValue(str, "reEligibilityId");
            return append.append(mVar.a(str)).append(" eligibility information from local storage.").toString();
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ long b;
        final /* synthetic */ m c;
        final /* synthetic */ String d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(long j, m mVar, String str) {
            super(0);
            this.b = j;
            this.c = mVar;
            this.d = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofence report suppressed since only " + this.b + " seconds have passed since the last time geofences were reported globally (minimum interval: " + this.c.h + "). id:" + this.d;
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ long b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ GeofenceTransitionType e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(long j, int i, String str, GeofenceTransitionType geofenceTransitionType) {
            super(0);
            this.b = j;
            this.c = i;
            this.d = str;
            this.e = geofenceTransitionType;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofence report suppressed since only " + this.b + " seconds have passed since the last time this geofence/transition combination was reported (minimum interval: " + this.c + "). id:" + this.d + " transition:" + this.e;
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ long b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ GeofenceTransitionType e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(long j, int i, String str, GeofenceTransitionType geofenceTransitionType) {
            super(0);
            this.b = j;
            this.c = i;
            this.d = str;
            this.e = geofenceTransitionType;
        }

        /* renamed from: a */
        public final String invoke() {
            return this.b + " seconds have passed since the last time this geofence/transition combination was reported (minimum interval: " + this.c + "). id:" + this.d + " transition:" + this.e;
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ GeofenceTransitionType c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(String str, GeofenceTransitionType geofenceTransitionType) {
            super(0);
            this.b = str;
            this.c = geofenceTransitionType;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofence report eligible since this geofence/transition combination has never been reported.id:" + this.b + " transition:" + this.c;
        }
    }

    static final class i extends Lambda implements Function0 {
        final /* synthetic */ long b;
        final /* synthetic */ m c;
        final /* synthetic */ String d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(long j, m mVar, String str) {
            super(0);
            this.b = j;
            this.c = mVar;
            this.d = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofence report eligible since " + this.b + " seconds have passed since the last time geofences were reported globally (minimum interval: " + this.c.h + "). id:" + this.d;
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ long b;
        final /* synthetic */ m c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(long j, m mVar) {
            super(0);
            this.b = j;
            this.c = mVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofence request suppressed since only " + this.b + " seconds have passed since the last time geofences were requested (minimum interval: " + this.c.g + ").";
        }
    }

    static final class k extends Lambda implements Function0 {
        final /* synthetic */ long b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(long j) {
            super(0);
            this.b = j;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Ignoring rate limit for this geofence request. Elapsed time since last request:" + this.b;
        }
    }

    static final class l extends Lambda implements Function0 {
        final /* synthetic */ long b;
        final /* synthetic */ m c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(long j, m mVar) {
            super(0);
            this.b = j;
            this.c = mVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return this.b + " seconds have passed since the last time geofences were requested (minimum interval: " + this.c.g + ").";
        }
    }

    /* renamed from: bo.app.m$m  reason: collision with other inner class name */
    static final class C0017m extends Lambda implements Function0 {
        public static final C0017m b = new C0017m();

        C0017m() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofences have not been requested for the current session yet. Request is eligible.";
        }
    }

    static final class n extends Lambda implements Function0 {
        public static final n b = new n();

        n() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofences have already been requested for the current session. Geofence request not eligible.";
        }
    }

    static final class o extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Exception trying to parse re-eligibility id: " + this.b;
        }
    }

    static final class p extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Deleting outdated id " + this.b + " from re-eligibility list.";
        }
    }

    static final class q extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Retaining id " + this.b + " in re-eligibility list.";
        }
    }

    static final class r extends Lambda implements Function0 {
        final /* synthetic */ long b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(long j) {
            super(0);
            this.b = j;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Updating the last successful location request time to: " + this.b;
        }
    }

    public m(Context context, String str, l5 l5Var, i2 i2Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, DynamicLink.Builder.KEY_API_KEY);
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        Intrinsics.checkNotNullParameter(i2Var, "internalIEventMessenger");
        i2Var.c(o5.class, new m$$ExternalSyntheticLambda0(this));
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.managers.geofences.eligibility.global." + str, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.a = sharedPreferences;
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.appboy.managers.geofences.eligibility.individual." + str, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.b = sharedPreferences2;
        this.c = a(sharedPreferences2);
        this.e = sharedPreferences.getLong("last_request_global", 0);
        this.f = sharedPreferences.getLong("last_report_global", 0);
        this.g = l5Var.s();
        this.h = l5Var.r();
    }

    /* access modifiers changed from: private */
    public static final void a(m mVar, o5 o5Var) {
        Intrinsics.checkNotNullParameter(mVar, "this$0");
        Intrinsics.checkNotNullParameter(o5Var, "it");
        mVar.d.set(false);
    }

    public final void a(List list) {
        Intrinsics.checkNotNullParameter(list, "brazeGeofenceList");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((BrazeGeofence) it.next()).getId());
        }
        HashSet hashSet = new HashSet(this.c.keySet());
        SharedPreferences.Editor edit = this.b.edit();
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            Intrinsics.checkNotNullExpressionValue(str, "reEligibilityId");
            if (!linkedHashSet.contains(a(str))) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new p(str), 3, (Object) null);
                this.c.remove(str);
                edit.remove(str);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new q(str), 3, (Object) null);
            }
        }
        edit.apply();
    }

    public final boolean a(long j2, BrazeGeofence brazeGeofence, GeofenceTransitionType geofenceTransitionType) {
        String str;
        long j3 = j2;
        GeofenceTransitionType geofenceTransitionType2 = geofenceTransitionType;
        Intrinsics.checkNotNullParameter(brazeGeofence, "geofence");
        Intrinsics.checkNotNullParameter(geofenceTransitionType2, "transitionType");
        String id = brazeGeofence.getId();
        long j4 = j3 - this.f;
        if (((long) this.h) > j4) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new e(j4, this, id), 3, (Object) null);
            return false;
        }
        String a2 = a(id, geofenceTransitionType2);
        int cooldownEnterSeconds = geofenceTransitionType2 == GeofenceTransitionType.ENTER ? brazeGeofence.getCooldownEnterSeconds() : brazeGeofence.getCooldownExitSeconds();
        if (this.c.containsKey(a2)) {
            Long l2 = (Long) this.c.get(a2);
            if (l2 != null) {
                long longValue = j3 - l2.longValue();
                str = a2;
                if (((long) cooldownEnterSeconds) > longValue) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new f(longValue, cooldownEnterSeconds, id, geofenceTransitionType), 3, (Object) null);
                    return false;
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new g(longValue, cooldownEnterSeconds, id, geofenceTransitionType), 3, (Object) null);
            } else {
                str = a2;
            }
        } else {
            str = a2;
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new h(id, geofenceTransitionType2), 3, (Object) null);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new i(j4, this, id), 3, (Object) null);
        String str2 = str;
        this.c.put(str2, Long.valueOf(j2));
        this.b.edit().putLong(str2, j3).apply();
        this.f = j3;
        this.a.edit().putLong("last_report_global", j3).apply();
        return true;
    }

    public final boolean a(boolean z, long j2) {
        long j3 = j2 - this.e;
        if (z || ((long) this.g) <= j3) {
            if (z) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new k(j3), 3, (Object) null);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new l(j3, this), 3, (Object) null);
            }
            if (this.d.compareAndSet(false, true)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) C0017m.b, 3, (Object) null);
                return true;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) n.b, 3, (Object) null);
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new j(j3, this), 3, (Object) null);
        return false;
    }

    public final void a(long j2) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new r(j2), 3, (Object) null);
        this.e = j2;
        this.a.edit().putLong("last_request_global", this.e).apply();
    }

    public final String a(String str) {
        Intrinsics.checkNotNullParameter(str, "reEligibilityId");
        try {
            return new Regex("_").split(str, 2).get(1);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new o(str));
            return null;
        }
    }

    public final String a(String str, GeofenceTransitionType geofenceTransitionType) {
        Intrinsics.checkNotNullParameter(str, "geofenceId");
        Intrinsics.checkNotNullParameter(geofenceTransitionType, "transitionType");
        StringBuilder sb = new StringBuilder();
        String obj = geofenceTransitionType.toString();
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, "US");
        String lowerCase = obj.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return sb.append(lowerCase).append('_').append(str).toString();
    }

    public final void a(j5 j5Var) {
        Intrinsics.checkNotNullParameter(j5Var, "serverConfig");
        int v = j5Var.v();
        if (v >= 0) {
            this.g = v;
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new b(v), 2, (Object) null);
        }
        int u = j5Var.u();
        if (u >= 0) {
            this.h = u;
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new c(u), 2, (Object) null);
        }
    }

    public final Map a(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Map<String, ?> all = sharedPreferences.getAll();
        if (all == null || all.isEmpty()) {
            return concurrentHashMap;
        }
        Set<String> keySet = all.keySet();
        if (keySet.isEmpty()) {
            return concurrentHashMap;
        }
        for (String next : keySet) {
            long j2 = sharedPreferences.getLong(next, 0);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new d(this, next), 3, (Object) null);
            Long valueOf = Long.valueOf(j2);
            Intrinsics.checkNotNullExpressionValue(next, "reEligibilityId");
            concurrentHashMap.put(next, valueOf);
        }
        return concurrentHashMap;
    }
}
