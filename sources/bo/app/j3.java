package bo.app;

import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import com.braze.support.g;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONObject;

public final class j3 implements j2 {
    private final j2 a;

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ Lazy b;
        final /* synthetic */ b5 c;
        final /* synthetic */ j3 d;
        final /* synthetic */ Map e;
        final /* synthetic */ JSONObject f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Lazy lazy, b5 b5Var, j3 j3Var, Map map, JSONObject jSONObject) {
            super(0);
            this.b = lazy;
            this.c = b5Var;
            this.d = j3Var;
            this.e = map;
            this.f = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return StringsKt.trimMargin$default("\n                |Making request with id => \"" + ((String) this.b.getValue()) + "\"\n                |to url: " + this.c + "\n                \n                |with headers:\n                " + this.d.a(this.e) + "\n                |\n                |" + (this.f == null ? "" : "and JSON :\n" + JsonUtils.getPrettyPrintedString(this.f)) + "\n                ", (String) null, 1, (Object) null);
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Exception while logging request: ";
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ Lazy b;
        final /* synthetic */ b5 c;
        final /* synthetic */ long d;
        final /* synthetic */ j3 e;
        final /* synthetic */ Map f;
        final /* synthetic */ JSONObject g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Lazy lazy, b5 b5Var, long j, j3 j3Var, Map map, JSONObject jSONObject) {
            super(0);
            this.b = lazy;
            this.c = b5Var;
            this.d = j;
            this.e = j3Var;
            this.f = map;
            this.g = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return StringsKt.trimMargin$default("\n                |Made request with id => \"" + ((String) this.b.getValue()) + "\"\n                |to url: " + this.c + "\n                |took: " + this.d + "ms\n                \n                |with response headers:\n                " + this.e.a(this.f) + "\n                |\n                |and response JSON:\n                |" + JsonUtils.getPrettyPrintedString(this.g) + "\n                ", (String) null, 1, (Object) null);
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Exception while logging result: ";
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ b5 b;
        final /* synthetic */ Map c;
        final /* synthetic */ JSONObject d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(b5 b5Var, Map map, JSONObject jSONObject) {
            super(0);
            this.b = b5Var;
            this.c = map;
            this.d = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return g.a(this.b, this.c, this.d);
        }
    }

    public j3(j2 j2Var) {
        Intrinsics.checkNotNullParameter(j2Var, "httpConnector");
        this.a = j2Var;
    }

    public Pair a(b5 b5Var, Map map, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(b5Var, "requestTarget");
        Intrinsics.checkNotNullParameter(map, "requestHeaders");
        Intrinsics.checkNotNullParameter(jSONObject, "payload");
        Lazy lazy = LazyKt.lazy(new e(b5Var, map, jSONObject));
        a(b5Var, map, lazy, jSONObject);
        long currentTimeMillis = System.currentTimeMillis();
        Pair a2 = this.a.a(b5Var, map, jSONObject);
        b5 b5Var2 = b5Var;
        a(lazy, b5Var2, (Map) a2.getSecond(), (JSONObject) a2.getFirst(), System.currentTimeMillis() - currentTimeMillis);
        return a2;
    }

    private final void a(b5 b5Var, Map map, Lazy lazy, JSONObject jSONObject) {
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new a(lazy, b5Var, this, map, jSONObject), 3, (Object) null);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) b.b);
        }
    }

    private final void a(Lazy lazy, b5 b5Var, Map map, JSONObject jSONObject, long j) {
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new c(lazy, b5Var, j, this, map, jSONObject), 3, (Object) null);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) d.b);
        }
    }

    /* access modifiers changed from: private */
    public final String a(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add("|\"" + ((String) entry.getKey()) + "\" => \"" + ((String) entry.getValue()) + Typography.quote);
        }
        return CollectionsKt.joinToString$default(arrayList, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}
