package bo.app;

import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.support.JsonUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class e3 {
    public static final a h = new a((DefaultConstructorMarker) null);
    private final Integer a;
    private final Integer b;
    private final Integer c;
    private final Integer d;
    private final Integer e;
    private final Integer f;
    private final Integer g;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    private e3(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
        this.a = num;
        this.b = num2;
        this.c = num3;
        this.d = num4;
        this.e = num5;
        this.f = num6;
        this.g = num7;
    }

    public final Integer a() {
        return this.a;
    }

    public final Integer b() {
        return this.c;
    }

    public final Integer c() {
        return this.g;
    }

    public final Integer d() {
        return this.f;
    }

    public final Integer e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e3)) {
            return false;
        }
        e3 e3Var = (e3) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) e3Var.a) && Intrinsics.areEqual((Object) this.b, (Object) e3Var.b) && Intrinsics.areEqual((Object) this.c, (Object) e3Var.c) && Intrinsics.areEqual((Object) this.d, (Object) e3Var.d) && Intrinsics.areEqual((Object) this.e, (Object) e3Var.e) && Intrinsics.areEqual((Object) this.f, (Object) e3Var.f) && Intrinsics.areEqual((Object) this.g, (Object) e3Var.g);
    }

    public final Integer f() {
        return this.d;
    }

    public final Integer g() {
        return this.b;
    }

    public int hashCode() {
        Integer num = this.a;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.c;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.d;
        int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.e;
        int hashCode5 = (hashCode4 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.f;
        int hashCode6 = (hashCode5 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.g;
        if (num7 != null) {
            i = num7.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "InAppMessageTheme(backgroundColor=" + this.a + ", textColor=" + this.b + ", closeButtonColor=" + this.c + ", iconColor=" + this.d + ", iconBackgroundColor=" + this.e + ", headerTextColor=" + this.f + ", frameColor=" + this.g + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public e3(JSONObject jSONObject) {
        this(JsonUtils.getColorIntegerOrNull(jSONObject, InAppMessageBase.BG_COLOR), JsonUtils.getColorIntegerOrNull(jSONObject, InAppMessageBase.MESSAGE_TEXT_COLOR), JsonUtils.getColorIntegerOrNull(jSONObject, "close_btn_color"), JsonUtils.getColorIntegerOrNull(jSONObject, InAppMessageBase.ICON_COLOR), JsonUtils.getColorIntegerOrNull(jSONObject, InAppMessageBase.ICON_BG_COLOR), JsonUtils.getColorIntegerOrNull(jSONObject, "header_text_color"), JsonUtils.getColorIntegerOrNull(jSONObject, "frame_color"));
        Intrinsics.checkNotNullParameter(jSONObject, "messageThemeJson");
    }
}
