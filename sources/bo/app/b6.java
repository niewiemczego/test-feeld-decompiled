package bo.app;

import android.content.Context;
import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

public final class b6 extends t6 {
    public static final b m = new b((DefaultConstructorMarker) null);
    private z1 i;
    private String j;
    private final List k = new ArrayList();
    private long l = -1;

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ JSONObject b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(JSONObject jSONObject) {
            super(0);
            this.b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Parsing templated triggered action with JSON: " + JsonUtils.getPrettyPrintedString(this.b);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private b() {
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                bo.app.t4[] r0 = bo.app.t4.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                bo.app.t4 r1 = bo.app.t4.IMAGE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                bo.app.t4 r1 = bo.app.t4.ZIP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                bo.app.t4 r1 = bo.app.t4.FILE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.b6.c.<clinit>():void");
        }
    }

    public static final class d extends Lambda implements Function1 {
        final /* synthetic */ JSONArray b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(JSONArray jSONArray) {
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

    public static final class e extends Lambda implements Function1 {
        final /* synthetic */ JSONArray b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(JSONArray jSONArray) {
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

    static final class f extends Lambda implements Function0 {
        public static final f b = new f();

        f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not convert TemplatedTriggeredAction to JSON";
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ b6 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(b6 b6Var) {
            super(0);
            this.b = b6Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Posting templating request after delay of " + this.b.n().o() + " seconds.";
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b6(JSONObject jSONObject, z1 z1Var) {
        super(jSONObject);
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new a(jSONObject), 3, (Object) null);
        this.i = z1Var;
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        String string = jSONObject2.getString(InAppMessageBase.TRIGGER_ID);
        Intrinsics.checkNotNullExpressionValue(string, "dataObject.getString(TRIGGER_ID)");
        this.j = string;
        JSONArray optJSONArray = jSONObject2.optJSONArray("prefetch_image_urls");
        if (optJSONArray != null) {
            a(optJSONArray, t4.IMAGE);
        }
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("prefetch_zip_urls");
        if (optJSONArray2 != null) {
            a(optJSONArray2, t4.ZIP);
        }
        JSONArray optJSONArray3 = jSONObject2.optJSONArray("prefetch_file_urls");
        if (optJSONArray3 != null) {
            a(optJSONArray3, t4.FILE);
        }
    }

    public final long A() {
        return this.l;
    }

    public void a(Context context, i2 i2Var, u2 u2Var, long j2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(i2Var, "internalEventPublisher");
        Intrinsics.checkNotNullParameter(u2Var, "triggerEvent");
        this.l = j2;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new g(this), 3, (Object) null);
        this.i.a(this, u2Var);
    }

    public List l() {
        return new ArrayList(this.k);
    }

    /* renamed from: u */
    public JSONObject forJsonPut() {
        try {
            JSONObject u = super.u();
            if (u == null) {
                return null;
            }
            u.put("type", (Object) "templated_iam");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(InAppMessageBase.TRIGGER_ID, (Object) this.j);
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            JSONArray jSONArray3 = new JSONArray();
            for (s4 s4Var : this.k) {
                int i2 = c.a[s4Var.a().ordinal()];
                if (i2 == 1) {
                    jSONArray.put((Object) s4Var.b());
                } else if (i2 == 2) {
                    jSONArray2.put((Object) s4Var.b());
                } else if (i2 == 3) {
                    jSONArray3.put((Object) s4Var.b());
                }
            }
            jSONObject.put("prefetch_image_urls", (Object) jSONArray);
            jSONObject.put("prefetch_zip_urls", (Object) jSONArray2);
            jSONObject.put("prefetch_file_urls", (Object) jSONArray3);
            u.put("data", (Object) jSONObject);
            return u;
        } catch (JSONException e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) f.b);
            return null;
        }
    }

    public final String z() {
        return this.j;
    }

    private final void a(JSONArray jSONArray, t4 t4Var) {
        Iterator it;
        if (jSONArray == null) {
            it = CollectionsKt.emptyList().iterator();
        } else {
            it = SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(RangesKt.until(0, jSONArray.length())), new d(jSONArray)), new e(jSONArray)).iterator();
        }
        while (it.hasNext()) {
            this.k.add(new s4(t4Var, (String) it.next()));
        }
    }
}
