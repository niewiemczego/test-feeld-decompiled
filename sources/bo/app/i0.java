package bo.app;

import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.DeviceKey;
import com.braze.models.IPutIntoJson;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONObject;

public final class i0 implements IPutIntoJson, h2 {
    public static final b o = new b((DefaultConstructorMarker) null);
    private final BrazeConfigurationProvider b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final Boolean j;
    private final Boolean k;
    private final String l;
    private final Boolean m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f14n;

    public static final class a {
        private final BrazeConfigurationProvider a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private Boolean i;
        private Boolean j;
        private String k;
        private Boolean l;

        public a(BrazeConfigurationProvider brazeConfigurationProvider) {
            Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
            this.a = brazeConfigurationProvider;
        }

        public final a a(String str) {
            this.b = str;
            return this;
        }

        public final a b(String str) {
            if (!(str == null || StringsKt.isBlank(str))) {
                this.d = str;
            }
            return this;
        }

        public final a c(String str) {
            this.c = str;
            return this;
        }

        public final a d(String str) {
            this.k = str;
            return this;
        }

        public final a e(String str) {
            this.f = str;
            return this;
        }

        public final a f(String str) {
            this.e = str;
            return this;
        }

        public final a g(String str) {
            this.h = str;
            return this;
        }

        public final a h(String str) {
            this.g = str;
            return this;
        }

        public final a a(Boolean bool) {
            this.l = bool;
            return this;
        }

        public final a b(Boolean bool) {
            this.j = bool;
            return this;
        }

        public final a c(Boolean bool) {
            this.i = bool;
            return this;
        }

        public final i0 a() {
            return new i0(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
        }
    }

    public static final class b {

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|25) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
            /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
            /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
            static {
                /*
                    com.braze.enums.DeviceKey[] r0 = com.braze.enums.DeviceKey.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.braze.enums.DeviceKey r1 = com.braze.enums.DeviceKey.TIMEZONE     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.braze.enums.DeviceKey r1 = com.braze.enums.DeviceKey.CARRIER     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    com.braze.enums.DeviceKey r1 = com.braze.enums.DeviceKey.ANDROID_VERSION     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    com.braze.enums.DeviceKey r1 = com.braze.enums.DeviceKey.RESOLUTION     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    com.braze.enums.DeviceKey r1 = com.braze.enums.DeviceKey.LOCALE     // Catch:{ NoSuchFieldError -> 0x0034 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                    r2 = 5
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
                L_0x0034:
                    com.braze.enums.DeviceKey r1 = com.braze.enums.DeviceKey.BRAND     // Catch:{ NoSuchFieldError -> 0x003d }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                    r2 = 6
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
                L_0x003d:
                    com.braze.enums.DeviceKey r1 = com.braze.enums.DeviceKey.MODEL     // Catch:{ NoSuchFieldError -> 0x0046 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                    r2 = 7
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
                L_0x0046:
                    com.braze.enums.DeviceKey r1 = com.braze.enums.DeviceKey.NOTIFICATIONS_ENABLED     // Catch:{ NoSuchFieldError -> 0x0050 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                    r2 = 8
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
                L_0x0050:
                    com.braze.enums.DeviceKey r1 = com.braze.enums.DeviceKey.IS_BACKGROUND_RESTRICTED     // Catch:{ NoSuchFieldError -> 0x005a }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                    r2 = 9
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
                L_0x005a:
                    com.braze.enums.DeviceKey r1 = com.braze.enums.DeviceKey.GOOGLE_ADVERTISING_ID     // Catch:{ NoSuchFieldError -> 0x0064 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                    r2 = 10
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
                L_0x0064:
                    com.braze.enums.DeviceKey r1 = com.braze.enums.DeviceKey.AD_TRACKING_ENABLED     // Catch:{ NoSuchFieldError -> 0x006e }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                    r2 = 11
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
                L_0x006e:
                    a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: bo.app.i0.b.a.<clinit>():void");
            }
        }

        /* renamed from: bo.app.i0$b$b  reason: collision with other inner class name */
        static final class C0012b extends Lambda implements Function0 {
            final /* synthetic */ DeviceKey b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0012b(DeviceKey deviceKey) {
                super(0);
                this.b = deviceKey;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Not adding device key <" + this.b + "> to export due to allowlist restrictions.";
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i0 a(BrazeConfigurationProvider brazeConfigurationProvider, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
            Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
            a aVar = new a(brazeConfigurationProvider);
            for (DeviceKey deviceKey : DeviceKey.values()) {
                String key = deviceKey.getKey();
                switch (a.a[deviceKey.ordinal()]) {
                    case 1:
                        aVar.h(JsonUtils.getOptionalString(jSONObject, key));
                        break;
                    case 2:
                        aVar.c(JsonUtils.getOptionalString(jSONObject, key));
                        break;
                    case 3:
                        aVar.a(JsonUtils.getOptionalString(jSONObject, key));
                        break;
                    case 4:
                        aVar.g(JsonUtils.getOptionalString(jSONObject, key));
                        break;
                    case 5:
                        aVar.e(JsonUtils.getOptionalString(jSONObject, key));
                        break;
                    case 6:
                        aVar.b(JsonUtils.getOptionalString(jSONObject, key));
                        break;
                    case 7:
                        aVar.f(JsonUtils.getOptionalString(jSONObject, key));
                        break;
                    case 8:
                        if (!jSONObject.has(key)) {
                            break;
                        } else {
                            aVar.c(Boolean.valueOf(jSONObject.optBoolean(key, true)));
                            break;
                        }
                    case 9:
                        if (!jSONObject.has(key)) {
                            break;
                        } else {
                            aVar.b(Boolean.valueOf(jSONObject.optBoolean(key, false)));
                            break;
                        }
                    case 10:
                        aVar.d(JsonUtils.getOptionalString(jSONObject, key));
                        break;
                    case 11:
                        if (!jSONObject.has(key)) {
                            break;
                        } else {
                            aVar.a(Boolean.valueOf(jSONObject.optBoolean(key)));
                            break;
                        }
                }
            }
            return aVar.a();
        }

        private b() {
        }

        public final void a(BrazeConfigurationProvider brazeConfigurationProvider, JSONObject jSONObject, DeviceKey deviceKey, Object obj) {
            Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
            Intrinsics.checkNotNullParameter(jSONObject, "deviceExport");
            Intrinsics.checkNotNullParameter(deviceKey, "exportKey");
            if (!brazeConfigurationProvider.isDeviceObjectAllowlistEnabled() || brazeConfigurationProvider.getDeviceObjectAllowlist().contains(deviceKey)) {
                jSONObject.putOpt(deviceKey.getKey(), obj);
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new C0012b(deviceKey), 2, (Object) null);
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception creating device Json.";
        }
    }

    public i0(BrazeConfigurationProvider brazeConfigurationProvider, String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, Boolean bool2, String str8, Boolean bool3) {
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        this.b = brazeConfigurationProvider;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.i = str7;
        this.j = bool;
        this.k = bool2;
        this.l = str8;
        this.m = bool3;
    }

    public final void a(boolean z) {
        this.f14n = z;
    }

    public boolean isEmpty() {
        return forJsonPut().length() == 0;
    }

    public final boolean u() {
        return forJsonPut().has(DeviceKey.NOTIFICATIONS_ENABLED.getKey());
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0061 A[Catch:{ JSONException -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006e A[Catch:{ JSONException -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0082 A[Catch:{ JSONException -> 0x008c }] */
    /* renamed from: v */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject forJsonPut() {
        /*
            r7 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            bo.app.i0$b r1 = o     // Catch:{ JSONException -> 0x008c }
            com.braze.configuration.BrazeConfigurationProvider r2 = r7.b     // Catch:{ JSONException -> 0x008c }
            com.braze.enums.DeviceKey r3 = com.braze.enums.DeviceKey.ANDROID_VERSION     // Catch:{ JSONException -> 0x008c }
            java.lang.String r4 = r7.c     // Catch:{ JSONException -> 0x008c }
            r1.a(r2, r0, r3, r4)     // Catch:{ JSONException -> 0x008c }
            com.braze.configuration.BrazeConfigurationProvider r2 = r7.b     // Catch:{ JSONException -> 0x008c }
            com.braze.enums.DeviceKey r3 = com.braze.enums.DeviceKey.CARRIER     // Catch:{ JSONException -> 0x008c }
            java.lang.String r4 = r7.d     // Catch:{ JSONException -> 0x008c }
            r1.a(r2, r0, r3, r4)     // Catch:{ JSONException -> 0x008c }
            com.braze.configuration.BrazeConfigurationProvider r2 = r7.b     // Catch:{ JSONException -> 0x008c }
            com.braze.enums.DeviceKey r3 = com.braze.enums.DeviceKey.BRAND     // Catch:{ JSONException -> 0x008c }
            java.lang.String r4 = r7.e     // Catch:{ JSONException -> 0x008c }
            r1.a(r2, r0, r3, r4)     // Catch:{ JSONException -> 0x008c }
            com.braze.configuration.BrazeConfigurationProvider r2 = r7.b     // Catch:{ JSONException -> 0x008c }
            com.braze.enums.DeviceKey r3 = com.braze.enums.DeviceKey.MODEL     // Catch:{ JSONException -> 0x008c }
            java.lang.String r4 = r7.f     // Catch:{ JSONException -> 0x008c }
            r1.a(r2, r0, r3, r4)     // Catch:{ JSONException -> 0x008c }
            com.braze.configuration.BrazeConfigurationProvider r2 = r7.b     // Catch:{ JSONException -> 0x008c }
            com.braze.enums.DeviceKey r3 = com.braze.enums.DeviceKey.RESOLUTION     // Catch:{ JSONException -> 0x008c }
            java.lang.String r4 = r7.i     // Catch:{ JSONException -> 0x008c }
            r1.a(r2, r0, r3, r4)     // Catch:{ JSONException -> 0x008c }
            com.braze.configuration.BrazeConfigurationProvider r2 = r7.b     // Catch:{ JSONException -> 0x008c }
            com.braze.enums.DeviceKey r3 = com.braze.enums.DeviceKey.LOCALE     // Catch:{ JSONException -> 0x008c }
            java.lang.String r4 = r7.g     // Catch:{ JSONException -> 0x008c }
            r1.a(r2, r0, r3, r4)     // Catch:{ JSONException -> 0x008c }
            com.braze.configuration.BrazeConfigurationProvider r2 = r7.b     // Catch:{ JSONException -> 0x008c }
            com.braze.enums.DeviceKey r3 = com.braze.enums.DeviceKey.NOTIFICATIONS_ENABLED     // Catch:{ JSONException -> 0x008c }
            java.lang.Boolean r4 = r7.j     // Catch:{ JSONException -> 0x008c }
            r1.a(r2, r0, r3, r4)     // Catch:{ JSONException -> 0x008c }
            com.braze.configuration.BrazeConfigurationProvider r2 = r7.b     // Catch:{ JSONException -> 0x008c }
            com.braze.enums.DeviceKey r3 = com.braze.enums.DeviceKey.IS_BACKGROUND_RESTRICTED     // Catch:{ JSONException -> 0x008c }
            java.lang.Boolean r4 = r7.k     // Catch:{ JSONException -> 0x008c }
            r1.a(r2, r0, r3, r4)     // Catch:{ JSONException -> 0x008c }
            java.lang.String r2 = r7.l     // Catch:{ JSONException -> 0x008c }
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x005e
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)     // Catch:{ JSONException -> 0x008c }
            if (r2 == 0) goto L_0x005c
            goto L_0x005e
        L_0x005c:
            r2 = r3
            goto L_0x005f
        L_0x005e:
            r2 = r4
        L_0x005f:
            if (r2 != 0) goto L_0x006a
            com.braze.configuration.BrazeConfigurationProvider r2 = r7.b     // Catch:{ JSONException -> 0x008c }
            com.braze.enums.DeviceKey r5 = com.braze.enums.DeviceKey.GOOGLE_ADVERTISING_ID     // Catch:{ JSONException -> 0x008c }
            java.lang.String r6 = r7.l     // Catch:{ JSONException -> 0x008c }
            r1.a(r2, r0, r5, r6)     // Catch:{ JSONException -> 0x008c }
        L_0x006a:
            java.lang.Boolean r2 = r7.m     // Catch:{ JSONException -> 0x008c }
            if (r2 == 0) goto L_0x0075
            com.braze.configuration.BrazeConfigurationProvider r5 = r7.b     // Catch:{ JSONException -> 0x008c }
            com.braze.enums.DeviceKey r6 = com.braze.enums.DeviceKey.AD_TRACKING_ENABLED     // Catch:{ JSONException -> 0x008c }
            r1.a(r5, r0, r6, r2)     // Catch:{ JSONException -> 0x008c }
        L_0x0075:
            java.lang.String r2 = r7.h     // Catch:{ JSONException -> 0x008c }
            if (r2 == 0) goto L_0x007f
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)     // Catch:{ JSONException -> 0x008c }
            if (r2 == 0) goto L_0x0080
        L_0x007f:
            r3 = r4
        L_0x0080:
            if (r3 != 0) goto L_0x0096
            com.braze.configuration.BrazeConfigurationProvider r2 = r7.b     // Catch:{ JSONException -> 0x008c }
            com.braze.enums.DeviceKey r3 = com.braze.enums.DeviceKey.TIMEZONE     // Catch:{ JSONException -> 0x008c }
            java.lang.String r4 = r7.h     // Catch:{ JSONException -> 0x008c }
            r1.a(r2, r0, r3, r4)     // Catch:{ JSONException -> 0x008c }
            goto L_0x0096
        L_0x008c:
            r1 = move-exception
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.E
            bo.app.i0$c r4 = bo.app.i0.c.b
            r2.brazelog((java.lang.Object) r7, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r1, (kotlin.jvm.functions.Function0<java.lang.String>) r4)
        L_0x0096:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.i0.forJsonPut():org.json.JSONObject");
    }

    public final boolean w() {
        return this.f14n;
    }
}
