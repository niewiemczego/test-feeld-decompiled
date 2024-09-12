package bo.app;

import com.braze.support.BrazeLogger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j5 {
    public static final a B = new a((DefaultConstructorMarker) null);
    private int A;
    private long a;
    private Set b;
    private Set c;
    private Set d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;
    private long k;
    private boolean l;
    private boolean m;

    /* renamed from: n  reason: collision with root package name */
    private int f15n;
    private boolean o;
    private int p;
    private int q;
    private boolean r;
    private long s;
    private boolean t;
    private int u;
    private int v;
    private boolean w;
    private long x;
    private int y;
    private int z;

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
            return "Error getting required content cards fields. Using defaults.";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error getting Content Card rate limit fields. Using defaults.";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error getting required DUST enabled field. Using default of false.";
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error getting required ephemeral events fields. Using defaults.";
        }
    }

    static final class f extends Lambda implements Function0 {
        public static final f b = new f();

        f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error getting required feature flag fields. Disabling feature flags.";
        }
    }

    static final class g extends Lambda implements Function0 {
        public static final g b = new g();

        g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error getting required geofence fields. Using defaults.";
        }
    }

    static final class h extends Lambda implements Function0 {
        public static final h b = new h();

        h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error getting required push max fields. Disabling push max.";
        }
    }

    public static final class i extends Lambda implements Function1 {
        final /* synthetic */ JSONArray b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(JSONArray jSONArray) {
            super(1);
            this.b = jSONArray;
        }

        public final Boolean a(int i) {
            return Boolean.valueOf(this.b.opt(i) instanceof String);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public static final class j extends Lambda implements Function1 {
        final /* synthetic */ JSONArray b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(JSONArray jSONArray) {
            super(1);
            this.b = jSONArray;
        }

        public final Object a(int i) {
            Object obj = this.b.get(i);
            if (obj != null) {
                return (String) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public j5(long j2, Set set, Set set2, Set set3, int i2, int i3, int i4, boolean z2, boolean z3, boolean z4, long j3, boolean z5, boolean z6, int i5, boolean z7, int i6, int i7, boolean z8, long j4, boolean z9, int i8, int i9, boolean z10, long j5, int i10, int i11, int i12) {
        this.a = j2;
        this.b = set;
        this.c = set2;
        this.d = set3;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = z2;
        this.i = z3;
        this.j = z4;
        this.k = j3;
        this.l = z5;
        this.m = z6;
        this.f15n = i5;
        this.o = z7;
        this.p = i6;
        this.q = i7;
        this.r = z8;
        this.s = j4;
        this.t = z9;
        this.u = i8;
        this.v = i9;
        this.w = z10;
        this.x = j5;
        this.y = i10;
        this.z = i11;
        this.A = i12;
    }

    public final boolean A() {
        return this.w;
    }

    public final void a(long j2) {
        this.a = j2;
    }

    public final Set b() {
        return this.b;
    }

    public final Set c() {
        return this.d;
    }

    public final long d() {
        return this.a;
    }

    public final void e(boolean z2) {
        this.m = z2;
    }

    public final void f(boolean z2) {
        this.i = z2;
    }

    public final void g(boolean z2) {
        this.h = z2;
    }

    public final void h(boolean z2) {
        this.t = z2;
    }

    public final void i(int i2) {
        this.g = i2;
    }

    public final void j(int i2) {
        this.f = i2;
    }

    public final void k(int i2) {
        this.e = i2;
    }

    public final boolean l() {
        return this.m;
    }

    public final int m() {
        return this.f15n;
    }

    public final boolean n() {
        return this.i;
    }

    public final boolean o() {
        return this.h;
    }

    public final int p() {
        return this.v;
    }

    public final int q() {
        return this.u;
    }

    public final boolean r() {
        return this.t;
    }

    public final int s() {
        return this.g;
    }

    public final long t() {
        return this.k;
    }

    public final int u() {
        return this.f;
    }

    public final int v() {
        return this.e;
    }

    public final boolean w() {
        return this.r;
    }

    public final long x() {
        return this.s;
    }

    public final long y() {
        return this.x;
    }

    public final boolean z() {
        return this.j;
    }

    public final Set a() {
        return this.c;
    }

    public final void b(Set set) {
        this.b = set;
    }

    public final void c(Set set) {
        this.d = set;
    }

    public final void d(boolean z2) {
        this.l = z2;
    }

    public final int e() {
        return this.q;
    }

    public final void f(int i2) {
        this.f15n = i2;
    }

    public final boolean g() {
        return this.o;
    }

    public final void h(int i2) {
        this.u = i2;
    }

    public final void i(boolean z2) {
        this.r = z2;
    }

    public final int j() {
        return this.A;
    }

    public final boolean k() {
        return this.l;
    }

    public final void a(Set set) {
        this.c = set;
    }

    public final void b(boolean z2) {
        this.j = z2;
    }

    public final void c(long j2) {
        this.s = j2;
    }

    public final void d(long j2) {
        this.x = j2;
    }

    public final void e(int i2) {
        this.A = i2;
    }

    public final int f() {
        return this.p;
    }

    public final void g(int i2) {
        this.v = i2;
    }

    public final int h() {
        return this.z;
    }

    public final int i() {
        return this.y;
    }

    private final void e(JSONObject jSONObject) {
        boolean z2;
        JSONObject optJSONObject = jSONObject.optJSONObject("ephemeral_events");
        if (optJSONObject != null) {
            try {
                z2 = optJSONObject.getBoolean("enabled");
            } catch (JSONException e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) e.b);
                z2 = false;
            }
            this.l = z2;
        }
    }

    private final void f(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("feature_flags");
        if (optJSONObject != null) {
            try {
                this.m = optJSONObject.optBoolean("enabled");
                this.f15n = optJSONObject.getInt("refresh_rate_limit");
            } catch (JSONException e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) f.b);
                this.m = false;
            }
        }
    }

    private final void g(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("geofences");
        if (optJSONObject != null) {
            try {
                this.e = optJSONObject.getInt("min_time_since_last_request");
                this.f = optJSONObject.getInt("min_time_since_last_report");
                this.i = optJSONObject.getBoolean("enabled");
                this.h = true;
                this.g = optJSONObject.optInt("max_num_to_register", 20);
            } catch (JSONException e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) g.b);
                this.e = -1;
                this.f = -1;
                this.g = -1;
                this.i = false;
                this.h = false;
            }
        }
    }

    private final void h(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("global_request_rate_limit");
        if (optJSONObject == null) {
            return;
        }
        if (!optJSONObject.getBoolean("enabled")) {
            this.t = false;
            return;
        }
        int i2 = optJSONObject.getInt("refill_rate");
        int i3 = optJSONObject.getInt("capacity");
        if (i3 > 0 && i2 > 0) {
            this.t = true;
            this.v = i3;
            this.u = i2;
        }
    }

    private final void i(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("push_max");
        if (optJSONObject != null) {
            try {
                this.r = optJSONObject.optBoolean("enabled");
                this.s = optJSONObject.optLong("redeliver_buffer", 86400);
                this.x = optJSONObject.optLong("redeliver_dedupe_buffer", -1);
            } catch (JSONException e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) h.b);
                this.r = false;
                this.s = 0;
                this.x = -1;
            }
        }
    }

    public final void a(boolean z2) {
        this.o = z2;
    }

    public final void b(long j2) {
        this.k = j2;
    }

    public final void c(boolean z2) {
        this.w = z2;
    }

    public final void d(int i2) {
        this.y = i2;
    }

    private final void d(JSONObject jSONObject) {
        boolean z2;
        JSONObject optJSONObject = jSONObject.optJSONObject("dust");
        if (optJSONObject != null) {
            try {
                z2 = optJSONObject.getBoolean("enabled");
            } catch (JSONException e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) d.b);
                z2 = false;
            }
            this.w = z2;
        }
    }

    public final void a(int i2) {
        this.q = i2;
    }

    public final void b(int i2) {
        this.p = i2;
    }

    public final void c(int i2) {
        this.z = i2;
    }

    private final void a(JSONObject jSONObject) {
        this.b = a(jSONObject, "events_blacklist");
        this.c = a(jSONObject, "attributes_blacklist");
        this.d = a(jSONObject, "purchases_blacklist");
    }

    private final void b(JSONObject jSONObject) {
        boolean z2;
        JSONObject optJSONObject = jSONObject.optJSONObject("content_cards");
        if (optJSONObject != null) {
            try {
                z2 = optJSONObject.getBoolean("enabled");
            } catch (JSONException e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) b.b);
                z2 = false;
            }
            this.j = z2;
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rate_limit");
            if (optJSONObject2 != null) {
                try {
                    this.o = optJSONObject2.getBoolean("enabled");
                    this.p = optJSONObject2.getInt("refill_rate");
                    this.q = optJSONObject2.getInt("capacity");
                } catch (JSONException e3) {
                    BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e3, (Function0<String>) c.b);
                    this.o = false;
                    this.p = -1;
                    this.q = -1;
                }
            }
        }
    }

    private final void c(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("request_backoff");
        if (optJSONObject != null) {
            this.y = optJSONObject.optInt("min_sleep_duration_ms", this.y);
            this.z = optJSONObject.optInt("max_sleep_duration_ms", this.z);
            this.A = optJSONObject.optInt("scale_factor", this.A);
        }
    }

    private final Set a(JSONObject jSONObject, String str) {
        Iterator it;
        HashSet hashSet = new HashSet();
        if (jSONObject.has(str)) {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray == null) {
                it = CollectionsKt.emptyList().iterator();
            } else {
                it = SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(RangesKt.until(0, optJSONArray.length())), new i(optJSONArray)), new j(optJSONArray)).iterator();
            }
            while (it.hasNext()) {
                hashSet.add((String) it.next());
            }
        }
        return hashSet;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ j5(long r33, java.util.Set r35, java.util.Set r36, java.util.Set r37, int r38, int r39, int r40, boolean r41, boolean r42, boolean r43, long r44, boolean r46, boolean r47, int r48, boolean r49, int r50, int r51, boolean r52, long r53, boolean r55, int r56, int r57, boolean r58, long r59, int r61, int r62, int r63, int r64, kotlin.jvm.internal.DefaultConstructorMarker r65) {
        /*
            r32 = this;
            r0 = r64
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x000b
        L_0x0009:
            r1 = r33
        L_0x000b:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0012
            r3 = r4
            goto L_0x0014
        L_0x0012:
            r3 = r35
        L_0x0014:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001a
            r5 = r4
            goto L_0x001c
        L_0x001a:
            r5 = r36
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r4 = r37
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = -1
            goto L_0x002b
        L_0x0029:
            r6 = r38
        L_0x002b:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0031
            r8 = -1
            goto L_0x0033
        L_0x0031:
            r8 = r39
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0039
            r9 = -1
            goto L_0x003b
        L_0x0039:
            r9 = r40
        L_0x003b:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0041
            r10 = 0
            goto L_0x0043
        L_0x0041:
            r10 = r41
        L_0x0043:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x0049
            r12 = 0
            goto L_0x004b
        L_0x0049:
            r12 = r42
        L_0x004b:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0051
            r13 = 0
            goto L_0x0053
        L_0x0051:
            r13 = r43
        L_0x0053:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x005a
            r17 = -1
            goto L_0x005c
        L_0x005a:
            r17 = r44
        L_0x005c:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0062
            r14 = 0
            goto L_0x0064
        L_0x0062:
            r14 = r46
        L_0x0064:
            r7 = r0 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x006a
            r7 = 0
            goto L_0x006c
        L_0x006a:
            r7 = r47
        L_0x006c:
            r11 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r11 == 0) goto L_0x0072
            r11 = -1
            goto L_0x0074
        L_0x0072:
            r11 = r48
        L_0x0074:
            r15 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r15 == 0) goto L_0x007a
            r15 = 0
            goto L_0x007c
        L_0x007a:
            r15 = r49
        L_0x007c:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0086
            r16 = -1
            goto L_0x0088
        L_0x0086:
            r16 = r50
        L_0x0088:
            r19 = 65536(0x10000, float:9.18355E-41)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x0091
            r19 = -1
            goto L_0x0093
        L_0x0091:
            r19 = r51
        L_0x0093:
            r20 = 131072(0x20000, float:1.83671E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x009c
            r20 = 0
            goto L_0x009e
        L_0x009c:
            r20 = r52
        L_0x009e:
            r21 = 262144(0x40000, float:3.67342E-40)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00a8
            r21 = 86400(0x15180, double:4.26873E-319)
            goto L_0x00aa
        L_0x00a8:
            r21 = r53
        L_0x00aa:
            r23 = 524288(0x80000, float:7.34684E-40)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00b3
            r23 = 1
            goto L_0x00b5
        L_0x00b3:
            r23 = r55
        L_0x00b5:
            r24 = 1048576(0x100000, float:1.469368E-39)
            r24 = r0 & r24
            r25 = 30
            if (r24 == 0) goto L_0x00c0
            r24 = r25
            goto L_0x00c2
        L_0x00c0:
            r24 = r56
        L_0x00c2:
            r26 = 2097152(0x200000, float:2.938736E-39)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00c9
            goto L_0x00cb
        L_0x00c9:
            r25 = r57
        L_0x00cb:
            r26 = 4194304(0x400000, float:5.877472E-39)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00d4
            r26 = 0
            goto L_0x00d6
        L_0x00d4:
            r26 = r58
        L_0x00d6:
            r27 = 8388608(0x800000, float:1.17549435E-38)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00df
            r27 = -1
            goto L_0x00e1
        L_0x00df:
            r27 = r59
        L_0x00e1:
            r29 = 16777216(0x1000000, float:2.3509887E-38)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x00ee
            bo.app.l5$b r29 = bo.app.l5.e
            int r29 = r29.b()
            goto L_0x00f0
        L_0x00ee:
            r29 = r61
        L_0x00f0:
            r30 = 33554432(0x2000000, float:9.403955E-38)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x00fd
            bo.app.l5$b r30 = bo.app.l5.e
            int r30 = r30.a()
            goto L_0x00ff
        L_0x00fd:
            r30 = r62
        L_0x00ff:
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            r0 = r0 & r31
            if (r0 == 0) goto L_0x0107
            r0 = 3
            goto L_0x0109
        L_0x0107:
            r0 = r63
        L_0x0109:
            r33 = r32
            r34 = r1
            r36 = r3
            r37 = r5
            r38 = r4
            r39 = r6
            r40 = r8
            r41 = r9
            r42 = r10
            r43 = r12
            r44 = r13
            r45 = r17
            r47 = r14
            r48 = r7
            r49 = r11
            r50 = r15
            r51 = r16
            r52 = r19
            r53 = r20
            r54 = r21
            r56 = r23
            r57 = r24
            r58 = r25
            r59 = r26
            r60 = r27
            r62 = r29
            r63 = r30
            r64 = r0
            r33.<init>(r34, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r47, r48, r49, r50, r51, r52, r53, r54, r56, r57, r58, r59, r60, r62, r63, r64)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.j5.<init>(long, java.util.Set, java.util.Set, java.util.Set, int, int, int, boolean, boolean, boolean, long, boolean, boolean, int, boolean, int, int, boolean, long, boolean, int, int, boolean, long, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public j5(JSONObject jSONObject) {
        this(0, (Set) null, (Set) null, (Set) null, 0, 0, 0, false, false, false, 0, false, false, 0, false, 0, 0, false, 0, false, 0, 0, false, 0, 0, 0, 0, 134217727, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "configJson");
        JSONObject jSONObject2 = jSONObject;
        this.a = jSONObject2.optLong("time", 0);
        this.k = jSONObject2.optLong("messaging_session_timeout", -1);
        a(jSONObject);
        b(jSONObject);
        g(jSONObject);
        e(jSONObject);
        f(jSONObject);
        i(jSONObject);
        h(jSONObject);
        d(jSONObject);
        c(jSONObject);
    }
}
