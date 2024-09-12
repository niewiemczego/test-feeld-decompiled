package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class l0 implements e2 {
    public static final a b = new a((DefaultConstructorMarker) null);
    public final SharedPreferences a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return String.valueOf(722989291);
        }

        private a() {
        }
    }

    public l0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.device", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        this.a = sharedPreferences;
    }

    private final void a(String str) {
        this.a.edit().putString("device_id", str).putString("persistent_device_id", b.a()).apply();
    }

    public String getDeviceId() {
        String str = null;
        String string = this.a.getString("device_id", (String) null);
        if (!a()) {
            str = string;
        }
        if (str == null) {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            a(uuid);
            return uuid;
        } else if (this.a.contains("persistent_device_id")) {
            return str;
        } else {
            a(str);
            return str;
        }
    }

    private final boolean a() {
        if (this.a.contains("persistent_device_id")) {
            if (!Intrinsics.areEqual((Object) b.a(), (Object) this.a.getString("persistent_device_id", ""))) {
                return true;
            }
        }
        return false;
    }
}
