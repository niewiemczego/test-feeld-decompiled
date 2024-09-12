package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class f5 {
    public static final a e = new a((DefaultConstructorMarker) null);
    private final Context a;
    private final String b;
    private final String c;
    private final SharedPreferences d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
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
            return "Setting signature to: " + this.b;
        }
    }

    public f5(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
        this.b = str;
        this.c = str2;
        this.d = context.getSharedPreferences("com.braze.storage.sdk_auth_cache" + StringUtils.getCacheFileSuffix(context, str, str2), 0);
    }

    public final String a() {
        return this.d.getString("auth_signature", (String) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f5)) {
            return false;
        }
        f5 f5Var = (f5) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) f5Var.a) && Intrinsics.areEqual((Object) this.b, (Object) f5Var.b) && Intrinsics.areEqual((Object) this.c, (Object) f5Var.c);
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "SdkAuthenticationCache(context=" + this.a + ", userId=" + this.b + ", apiKey=" + this.c + ')';
    }

    public final void a(String str) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new b(str), 2, (Object) null);
        this.d.edit().putString("auth_signature", str).apply();
    }
}
