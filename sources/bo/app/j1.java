package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.events.FeatureFlagsUpdatedEvent;
import com.braze.models.FeatureFlag;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;

public final class j1 {
    public static final a k = new a((DefaultConstructorMarker) null);
    private i2 a;
    private i2 b;
    private final l5 c;
    private final z1 d;
    private List e = CollectionsKt.emptyList();
    private AtomicBoolean f = new AtomicBoolean(false);
    private final SharedPreferences g;
    private final SharedPreferences h;
    private final SharedPreferences i;
    private final AtomicInteger j;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Did not find stored Feature Flags.";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to find stored Feature Flag keys.";
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
            return "Received null or blank serialized Feature Flag string for Feature Flag id " + this.b + " from shared preferences. Not parsing.";
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Encountered unexpected exception while parsing stored feature flags: " + this.b;
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ FeatureFlag b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FeatureFlag featureFlag) {
            super(0);
            this.b = featureFlag;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not logging a Feature Flag impression for Feature Flag with id " + this.b.getId() + ". The Feature Flag already had an impression logged in the current session";
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not logging a Feature Flag impression for Feature Flag with id " + this.b + ". The Feature Flag was not part of any matching campaign";
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ j1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(j1 j1Var) {
            super(0);
            this.b = j1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not refreshing Feature Flags since another " + this.b.b().get() + " request is currently in-flight.";
        }
    }

    static final class i extends Lambda implements Function0 {
        final /* synthetic */ j1 b;
        final /* synthetic */ long c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(j1 j1Var, long j) {
            super(0);
            this.b = j1Var;
            this.c = j;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not enough time has passed since last Feature Flags refresh. Not refreshing Feature Flags. " + ((this.b.e() - this.c) + ((long) this.b.d().m())) + " seconds remaining until next available flush.";
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ FeatureFlag b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(FeatureFlag featureFlag) {
            super(0);
            this.b = featureFlag;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error storing Feature Flag: " + this.b + '.';
        }
    }

    static final class k extends Lambda implements Function0 {
        public static final k b = new k();

        k() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Added new Feature Flags to local storage.";
        }
    }

    static final class l extends Lambda implements Function0 {
        final /* synthetic */ long b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(long j) {
            super(0);
            this.b = j;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Updating last Feature Flags refresh time: " + this.b;
        }
    }

    public j1(Context context, String str, String str2, i2 i2Var, i2 i2Var2, l5 l5Var, z1 z1Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, DynamicLink.Builder.KEY_API_KEY);
        Intrinsics.checkNotNullParameter(i2Var, "internalEventPublisher");
        Intrinsics.checkNotNullParameter(i2Var2, "externalEventPublisher");
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
        this.a = i2Var;
        this.b = i2Var2;
        this.c = l5Var;
        this.d = z1Var;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.braze.managers.featureflags.eligibility" + StringUtils.getCacheFileSuffix(context, str2, str), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.g = sharedPreferences;
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.braze.managers.featureflags.storage" + StringUtils.getCacheFileSuffix(context, str2, str), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.h = sharedPreferences2;
        SharedPreferences sharedPreferences3 = context.getSharedPreferences("com.braze.managers.featureflags.impressions" + StringUtils.getCacheFileSuffix(context, str2, str), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences3, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.i = sharedPreferences3;
        this.j = new AtomicInteger(0);
        f();
        this.a.c(w4.class, new j1$$ExternalSyntheticLambda0(this));
        this.a.c(v4.class, new j1$$ExternalSyntheticLambda1(this));
        this.a.c(m1.class, new j1$$ExternalSyntheticLambda2(this));
        this.a.c(l1.class, new j1$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    public final long e() {
        return this.g.getLong("last_refresh", 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072 A[Catch:{ Exception -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0083 A[Catch:{ Exception -> 0x006d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void f() {
        /*
            r15 = this;
            android.content.SharedPreferences r0 = r15.h
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map r0 = r0.getAll()
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0018
            boolean r4 = r0.isEmpty()
            if (r4 == 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r4 = r2
            goto L_0x0019
        L_0x0018:
            r4 = r3
        L_0x0019:
            if (r4 == 0) goto L_0x002e
            com.braze.support.BrazeLogger r5 = com.braze.support.BrazeLogger.INSTANCE
            bo.app.j1$b r9 = bo.app.j1.b.b
            r7 = 0
            r8 = 0
            r10 = 3
            r11 = 0
            r6 = r15
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r5, (java.lang.Object) r6, (com.braze.support.BrazeLogger.Priority) r7, (java.lang.Throwable) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r15.e = r0
            return
        L_0x002e:
            java.util.Set r4 = r0.keySet()
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x004c
            com.braze.support.BrazeLogger r6 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r8 = com.braze.support.BrazeLogger.Priority.W
            bo.app.j1$c r10 = bo.app.j1.c.b
            r9 = 0
            r11 = 2
            r12 = 0
            r7 = r15
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r6, (java.lang.Object) r7, (com.braze.support.BrazeLogger.Priority) r8, (java.lang.Throwable) r9, (kotlin.jvm.functions.Function0) r10, (int) r11, (java.lang.Object) r12)
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r15.e = r0
            return
        L_0x004c:
            java.util.Iterator r4 = r4.iterator()
        L_0x0050:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00a1
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r0.get(r5)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x006f
            boolean r7 = kotlin.text.StringsKt.isBlank(r6)     // Catch:{ Exception -> 0x006d }
            if (r7 == 0) goto L_0x006b
            goto L_0x006f
        L_0x006b:
            r7 = r2
            goto L_0x0070
        L_0x006d:
            r5 = move-exception
            goto L_0x0094
        L_0x006f:
            r7 = r3
        L_0x0070:
            if (r7 == 0) goto L_0x0083
            com.braze.support.BrazeLogger r8 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x006d }
            com.braze.support.BrazeLogger$Priority r10 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x006d }
            r11 = 0
            bo.app.j1$d r12 = new bo.app.j1$d     // Catch:{ Exception -> 0x006d }
            r12.<init>(r5)     // Catch:{ Exception -> 0x006d }
            r13 = 2
            r14 = 0
            r9 = r15
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r8, (java.lang.Object) r9, (com.braze.support.BrazeLogger.Priority) r10, (java.lang.Throwable) r11, (kotlin.jvm.functions.Function0) r12, (int) r13, (java.lang.Object) r14)     // Catch:{ Exception -> 0x006d }
            goto L_0x0050
        L_0x0083:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x006d }
            r5.<init>((java.lang.String) r6)     // Catch:{ Exception -> 0x006d }
            com.braze.support.d r7 = com.braze.support.d.a     // Catch:{ Exception -> 0x006d }
            com.braze.models.FeatureFlag r5 = r7.a((org.json.JSONObject) r5)     // Catch:{ Exception -> 0x006d }
            if (r5 == 0) goto L_0x0050
            r1.add(r5)     // Catch:{ Exception -> 0x006d }
            goto L_0x0050
        L_0x0094:
            com.braze.support.BrazeLogger r7 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r8 = com.braze.support.BrazeLogger.Priority.E
            bo.app.j1$e r9 = new bo.app.j1$e
            r9.<init>(r6)
            r7.brazelog((java.lang.Object) r15, (com.braze.support.BrazeLogger.Priority) r8, (java.lang.Throwable) r5, (kotlin.jvm.functions.Function0<java.lang.String>) r9)
            goto L_0x0050
        L_0x00a1:
            r15.e = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.j1.f():void");
    }

    private final void j() {
        long nowInSeconds = DateTimeUtils.nowInSeconds();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new l(nowInSeconds), 2, (Object) null);
        this.g.edit().putLong("last_refresh", nowInSeconds).apply();
    }

    public final AtomicInteger b() {
        return this.j;
    }

    public final List c() {
        List<FeatureFlag> list = this.e;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (FeatureFlag deepcopy$android_sdk_base_release : list) {
            arrayList.add(deepcopy$android_sdk_base_release.deepcopy$android_sdk_base_release());
        }
        return arrayList;
    }

    public final l5 d() {
        return this.c;
    }

    public final void g() {
        if (this.f.get()) {
            this.b.a((Object) new FeatureFlagsUpdatedEvent(c()), FeatureFlagsUpdatedEvent.class);
        }
    }

    public final void h() {
        if (this.j.get() > 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new h(this), 3, (Object) null);
            return;
        }
        long nowInSeconds = DateTimeUtils.nowInSeconds();
        if (nowInSeconds - e() < ((long) this.c.m())) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new i(this, nowInSeconds), 2, (Object) null);
            this.a.a((Object) new l1(), l1.class);
            return;
        }
        a();
    }

    public final void i() {
        this.i.edit().clear().apply();
    }

    /* access modifiers changed from: private */
    public static final void a(j1 j1Var, w4 w4Var) {
        Intrinsics.checkNotNullParameter(j1Var, "this$0");
        Intrinsics.checkNotNullParameter(w4Var, "it");
        if (w4Var.a() instanceof n1) {
            j1Var.j.incrementAndGet();
        }
    }

    public final List b(String str) {
        List<FeatureFlag> list;
        if (str != null) {
            List list2 = this.e;
            list = new ArrayList<>();
            for (Object next : list2) {
                if (Intrinsics.areEqual((Object) ((FeatureFlag) next).getId(), (Object) str)) {
                    list.add(next);
                }
            }
        } else {
            list = this.e;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (FeatureFlag deepcopy$android_sdk_base_release : list) {
            arrayList.add(deepcopy$android_sdk_base_release.deepcopy$android_sdk_base_release());
        }
        return arrayList;
    }

    public final boolean d(String str) {
        Set<String> keySet;
        Intrinsics.checkNotNullParameter(str, "id");
        Map<String, ?> all = this.i.getAll();
        if (all == null || (keySet = all.keySet()) == null) {
            return false;
        }
        return keySet.contains(str);
    }

    /* access modifiers changed from: private */
    public static final void a(j1 j1Var, v4 v4Var) {
        Intrinsics.checkNotNullParameter(j1Var, "this$0");
        Intrinsics.checkNotNullParameter(v4Var, "it");
        if (v4Var.a() instanceof n1) {
            j1Var.j.decrementAndGet();
        }
    }

    /* access modifiers changed from: private */
    public static final void a(j1 j1Var, m1 m1Var) {
        Intrinsics.checkNotNullParameter(j1Var, "this$0");
        Intrinsics.checkNotNullParameter(m1Var, "it");
        j1Var.f.set(true);
        j1Var.j();
    }

    /* access modifiers changed from: private */
    public static final void a(j1 j1Var, l1 l1Var) {
        Intrinsics.checkNotNullParameter(j1Var, "this$0");
        Intrinsics.checkNotNullParameter(l1Var, "it");
        j1Var.f.set(true);
        j1Var.g();
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        FeatureFlag featureFlag = (FeatureFlag) CollectionsKt.firstOrNull(b(str));
        if ((featureFlag != null ? featureFlag.getTrackingString$android_sdk_base_release() : null) == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new g(str), 2, (Object) null);
        } else if (!d(featureFlag.getId())) {
            x1 a2 = j.h.a(featureFlag);
            if (a2 != null) {
                this.d.a(a2);
            }
            c(featureFlag.getId());
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new f(featureFlag), 2, (Object) null);
        }
    }

    public final void a() {
        this.d.refreshFeatureFlags();
    }

    public final FeatureFlagsUpdatedEvent a(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "featureFlagsData");
        this.e = com.braze.support.d.a.a(jSONArray);
        SharedPreferences.Editor edit = this.h.edit();
        edit.clear();
        for (FeatureFlag featureFlag : this.e) {
            try {
                edit.putString(featureFlag.getId(), featureFlag.forJsonPut().toString());
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new j(featureFlag));
            }
        }
        edit.apply();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) k.b, 3, (Object) null);
        return new FeatureFlagsUpdatedEvent(c());
    }

    public static /* synthetic */ List a(j1 j1Var, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return j1Var.b(str);
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.i.edit().putBoolean(str, true).apply();
    }
}
