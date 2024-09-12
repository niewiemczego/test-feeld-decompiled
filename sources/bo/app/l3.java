package bo.app;

import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.support.JsonUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class l3 {
    public static final a d = new a((DefaultConstructorMarker) null);
    private final Integer a;
    private final Integer b;
    private final Integer c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    private l3(Integer num, Integer num2, Integer num3) {
        this.a = num;
        this.b = num2;
        this.c = num3;
    }

    public final Integer a() {
        return this.a;
    }

    public final Integer b() {
        return this.c;
    }

    public final Integer c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l3)) {
            return false;
        }
        l3 l3Var = (l3) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) l3Var.a) && Intrinsics.areEqual((Object) this.b, (Object) l3Var.b) && Intrinsics.areEqual((Object) this.c, (Object) l3Var.c);
    }

    public int hashCode() {
        Integer num = this.a;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.c;
        if (num3 != null) {
            i = num3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "MessageButtonTheme(backgroundColor=" + this.a + ", textColor=" + this.b + ", borderColor=" + this.c + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public l3(JSONObject jSONObject) {
        this(JsonUtils.getColorIntegerOrNull(jSONObject, InAppMessageBase.BG_COLOR), JsonUtils.getColorIntegerOrNull(jSONObject, InAppMessageBase.MESSAGE_TEXT_COLOR), JsonUtils.getColorIntegerOrNull(jSONObject, "border_color"));
        Intrinsics.checkNotNullParameter(jSONObject, "buttonThemeJson");
    }
}
