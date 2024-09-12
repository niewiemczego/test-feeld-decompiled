package bo.app;

import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p6 {
    public static final p6 a = new p6();
    private static final String b = BrazeLogger.getBrazeLogTag((Class<?>) p6.class);

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Templated message Json was null. Not de-serializing templated message.";
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received templated message Json with unknown type: " + this.b + ". Not parsing.";
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ JSONObject b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(JSONObject jSONObject) {
            super(0);
            this.b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Encountered exception processing templated message: " + this.b;
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received null or blank trigger condition Json. Not parsing.";
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
            return "Received triggered condition Json with unknown type: " + this.b + ". Not parsing.";
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received unknown trigger type: " + this.b;
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ JSONObject b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(JSONObject jSONObject) {
            super(0);
            this.b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to deserialize triggered action Json: " + this.b;
        }
    }

    static final class h extends Lambda implements Function0 {
        public static final h b = new h();

        h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Triggered actions Json array was null. Not de-serializing triggered actions.";
        }
    }

    static final class i extends Lambda implements Function0 {
        final /* synthetic */ JSONArray b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(JSONArray jSONArray) {
            super(0);
            this.b = jSONArray;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to deserialize triggered actions Json array: " + this.b;
        }
    }

    private p6() {
    }

    public final IInAppMessage a(JSONObject jSONObject, z1 z1Var) {
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
        if (jSONObject == null) {
            try {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, b, (BrazeLogger.Priority) null, (Throwable) null, (Function0) a.b, 6, (Object) null);
                return null;
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog(b, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new c(jSONObject));
                return null;
            }
        } else {
            String string = jSONObject.getString("type");
            if (Intrinsics.areEqual((Object) string, (Object) "inapp")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (jSONObject2 == null) {
                    return null;
                }
                return com.braze.support.h.a(jSONObject2, z1Var);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, b, BrazeLogger.Priority.W, (Throwable) null, (Function0) new b(string), 4, (Object) null);
            return null;
        }
    }

    public final z2 b(JSONObject jSONObject, z1 z1Var) {
        Intrinsics.checkNotNullParameter(jSONObject, "actionJson");
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
        try {
            String string = jSONObject.getString("type");
            if (Intrinsics.areEqual((Object) string, (Object) "inapp")) {
                return new f3(jSONObject, z1Var);
            }
            if (Intrinsics.areEqual((Object) string, (Object) "templated_iam")) {
                return new b6(jSONObject, z1Var);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new f(string), 2, (Object) null);
            return null;
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog(b, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new g(jSONObject));
        }
    }

    public final List a(JSONArray jSONArray, z1 z1Var) {
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
        if (jSONArray == null) {
            try {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, b, (BrazeLogger.Priority) null, (Throwable) null, (Function0) h.b, 6, (Object) null);
                return null;
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog(b, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new i(jSONArray));
                return null;
            }
        } else {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "actionJson");
                z2 b2 = b(jSONObject, z1Var);
                if (b2 != null) {
                    arrayList.add(b2);
                }
            }
            return arrayList;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List a(org.json.JSONArray r13) {
        /*
            r12 = this;
            java.lang.String r0 = "triggerConditionsJson"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r13.length()
            r2 = 0
        L_0x000f:
            if (r2 >= r1) goto L_0x00e3
            org.json.JSONObject r3 = r13.optJSONObject(r2)
            if (r3 != 0) goto L_0x0027
            com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r5 = b
            com.braze.support.BrazeLogger$Priority r6 = com.braze.support.BrazeLogger.Priority.W
            bo.app.p6$d r8 = bo.app.p6.d.b
            r7 = 0
            r9 = 4
            r10 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.String) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)
            goto L_0x00df
        L_0x0027:
            java.lang.String r4 = "type"
            java.lang.String r4 = r3.getString(r4)
            if (r4 == 0) goto L_0x00ce
            int r5 = r4.hashCode()
            switch(r5) {
                case -1679221933: goto L_0x00bc;
                case 3417674: goto L_0x00aa;
                case 3556498: goto L_0x0098;
                case 447503464: goto L_0x0086;
                case 717572172: goto L_0x0074;
                case 1512893214: goto L_0x0060;
                case 1743324417: goto L_0x004c;
                case 1926863907: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x00ce
        L_0x0038:
            java.lang.String r5 = "push_click"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x0042
            goto L_0x00ce
        L_0x0042:
            bo.app.g4 r4 = new bo.app.g4
            r4.<init>(r3)
            r0.add(r4)
            goto L_0x00df
        L_0x004c:
            java.lang.String r5 = "purchase"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x0056
            goto L_0x00ce
        L_0x0056:
            bo.app.c4 r4 = new bo.app.c4
            r4.<init>(r3)
            r0.add(r4)
            goto L_0x00df
        L_0x0060:
            java.lang.String r5 = "iam_click"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x006a
            goto L_0x00ce
        L_0x006a:
            bo.app.b3 r4 = new bo.app.b3
            r4.<init>(r3)
            r0.add(r4)
            goto L_0x00df
        L_0x0074:
            java.lang.String r5 = "custom_event"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x007d
            goto L_0x00ce
        L_0x007d:
            bo.app.c0 r4 = new bo.app.c0
            r4.<init>(r3)
            r0.add(r4)
            goto L_0x00df
        L_0x0086:
            java.lang.String r5 = "custom_event_property"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x008f
            goto L_0x00ce
        L_0x008f:
            bo.app.e0 r4 = new bo.app.e0
            r4.<init>(r3)
            r0.add(r4)
            goto L_0x00df
        L_0x0098:
            java.lang.String r3 = "test"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x00a1
            goto L_0x00ce
        L_0x00a1:
            bo.app.c6 r3 = new bo.app.c6
            r3.<init>()
            r0.add(r3)
            goto L_0x00df
        L_0x00aa:
            java.lang.String r3 = "open"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x00b3
            goto L_0x00ce
        L_0x00b3:
            bo.app.u3 r3 = new bo.app.u3
            r3.<init>()
            r0.add(r3)
            goto L_0x00df
        L_0x00bc:
            java.lang.String r5 = "purchase_property"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x00c5
            goto L_0x00ce
        L_0x00c5:
            bo.app.e4 r4 = new bo.app.e4
            r4.<init>(r3)
            r0.add(r4)
            goto L_0x00df
        L_0x00ce:
            com.braze.support.BrazeLogger r5 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r6 = b
            com.braze.support.BrazeLogger$Priority r7 = com.braze.support.BrazeLogger.Priority.W
            bo.app.p6$e r9 = new bo.app.p6$e
            r9.<init>(r4)
            r8 = 0
            r10 = 4
            r11 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r5, (java.lang.String) r6, (com.braze.support.BrazeLogger.Priority) r7, (java.lang.Throwable) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
        L_0x00df:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x00e3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.p6.a(org.json.JSONArray):java.util.List");
    }
}
