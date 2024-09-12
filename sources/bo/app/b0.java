package bo.app;

import com.braze.support.BrazeLogger;
import com.braze.support.g;
import com.facebook.internal.ServerProtocol;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class b0 extends r {
    public static final a y = new a((DefaultConstructorMarker) null);
    private final long t;
    private final long u;
    private int v;
    private final boolean w;
    /* access modifiers changed from: private */
    public int x;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ long b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(long j) {
            super(0);
            this.b = j;
        }

        /* renamed from: a */
        public final String invoke() {
            return "ContentCardsSyncRequest scheduled for retry in " + this.b + " ms.";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "ContentCardsSyncRequest executed successfully.";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Experienced JSONException while creating Content Cards request. Returning null.";
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ b0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(b0 b0Var) {
            super(0);
            this.b = b0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Retrying Content Card refresh request. Retry count for this request attempt: " + this.b.x;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b0(l5 l5Var, String str, long j, long j2, String str2, int i) {
        super(new b5(str + "content_cards/sync"), str2, l5Var);
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        Intrinsics.checkNotNullParameter(str, "urlBase");
        this.t = j;
        this.u = j2;
        this.v = i;
    }

    public boolean c() {
        return this.w;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028 A[Catch:{ JSONException -> 0x0032 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject e() {
        /*
            r5 = this;
            org.json.JSONObject r0 = super.e()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.String r2 = "last_full_sync_at"
            long r3 = r5.u     // Catch:{ JSONException -> 0x0032 }
            r0.put((java.lang.String) r2, (long) r3)     // Catch:{ JSONException -> 0x0032 }
            java.lang.String r2 = "last_card_updated_at"
            long r3 = r5.t     // Catch:{ JSONException -> 0x0032 }
            r0.put((java.lang.String) r2, (long) r3)     // Catch:{ JSONException -> 0x0032 }
            java.lang.String r2 = r5.a()     // Catch:{ JSONException -> 0x0032 }
            if (r2 == 0) goto L_0x0025
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)     // Catch:{ JSONException -> 0x0032 }
            if (r2 == 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r2 = 0
            goto L_0x0026
        L_0x0025:
            r2 = 1
        L_0x0026:
            if (r2 != 0) goto L_0x0031
            java.lang.String r2 = "user_id"
            java.lang.String r3 = r5.a()     // Catch:{ JSONException -> 0x0032 }
            r0.put((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x0032 }
        L_0x0031:
            return r0
        L_0x0032:
            r0 = move-exception
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.W
            bo.app.b0$d r4 = bo.app.b0.d.b
            r2.brazelog((java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r0, (kotlin.jvm.functions.Function0<java.lang.String>) r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.b0.e():org.json.JSONObject");
    }

    public void a(i2 i2Var, i2 i2Var2, d dVar) {
        Map g;
        String str;
        Long a2;
        Intrinsics.checkNotNullParameter(i2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(i2Var2, "externalPublisher");
        if (dVar == null || (g = dVar.g()) == null || (str = (String) g.get("retry-after")) == null || (a2 = g.a(str)) == null) {
            i2Var.a((Object) new w(), w.class);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) c.b, 3, (Object) null);
            return;
        }
        long longValue = a2.longValue();
        i2Var.a((Object) new x(longValue, this.v + 1), x.class);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new b(longValue), 3, (Object) null);
    }

    public void a(Map map) {
        Intrinsics.checkNotNullParameter(map, "existingHeaders");
        super.a(map);
        map.put("X-Braze-DataRequest", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        map.put("X-Braze-ContentCardsRequest", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        map.put("BRAZE-SYNC-RETRY-COUNT", String.valueOf(this.v));
    }

    public boolean a(p2 p2Var) {
        Intrinsics.checkNotNullParameter(p2Var, "responseError");
        if (!(p2Var instanceof p3) && !(p2Var instanceof e5)) {
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new e(this), 3, (Object) null);
        int i = this.x + 1;
        this.x = i;
        if (i < 3) {
            return true;
        }
        return false;
    }
}
