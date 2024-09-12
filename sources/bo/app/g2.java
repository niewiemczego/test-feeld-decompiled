package bo.app;

import com.braze.support.BrazeLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

public interface g2 {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();

        /* renamed from: bo.app.g2$a$a  reason: collision with other inner class name */
        static final class C0011a extends Lambda implements Function0 {
            final /* synthetic */ JSONObject b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0011a(JSONObject jSONObject) {
                super(0);
                this.b = jSONObject;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse json. Returning unknown.\n" + this.b;
            }
        }

        private a() {
        }

        public final g2 a(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            if (Intrinsics.areEqual((Object) jSONObject.getString("type"), (Object) b.CONTENT_CARD_REFRESH.b())) {
                return new s0();
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new C0011a(jSONObject), 3, (Object) null);
            return new w0();
        }
    }

    public enum b {
        UNKNOWN(""),
        CONTENT_CARD_REFRESH("ccr");
        
        private final String b;

        private b(String str) {
            this.b = str;
        }

        public final String b() {
            return this.b;
        }
    }

    b a();
}
