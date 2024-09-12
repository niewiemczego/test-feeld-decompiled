package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class t3 {
    public static final a b = new a((DefaultConstructorMarker) null);
    private final SharedPreferences a;

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
            return "Stored user ID is longer than 997 bytes. Truncating. Original user ID: " + this.b;
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "userId is empty in updateLastUserId. Rejecting.";
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Offline user storage provider was given user ID longer than 997. Rejecting. User ID: " + this.b;
        }
    }

    public t3(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.offline.storagemap", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        this.a = sharedPreferences;
    }

    public final String a() {
        String str = "";
        String string = this.a.getString("last_user", str);
        if (string != null) {
            str = string;
        }
        if (StringUtils.getByteSize(str) <= 997) {
            return str;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new b(str), 2, (Object) null);
        String truncateToByteLength = StringUtils.truncateToByteLength(str, 997);
        a(truncateToByteLength);
        return truncateToByteLength;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        if (str.length() == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) c.b, 2, (Object) null);
        } else if (StringUtils.getByteSize(str) > 997) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new d(str), 2, (Object) null);
        } else {
            SharedPreferences.Editor edit = this.a.edit();
            edit.putString("last_user", str);
            edit.apply();
        }
    }
}
