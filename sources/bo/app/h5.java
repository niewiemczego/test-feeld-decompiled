package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.StringUtils;
import com.braze.support.c;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.EnumSet;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class h5 {
    public static final a b = new a((DefaultConstructorMarker) null);
    private final SharedPreferences a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public h5(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, DynamicLink.Builder.KEY_API_KEY);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.braze.storage.sdk_metadata_cache" + StringUtils.getCacheFileSuffix(context, str, str2), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…y), Context.MODE_PRIVATE)");
        this.a = sharedPreferences;
    }

    public final void a(EnumSet enumSet) {
        Intrinsics.checkNotNullParameter(enumSet, "sdkMetadata");
        this.a.edit().putStringSet("tags", c.a(enumSet)).apply();
    }

    public final EnumSet b(EnumSet enumSet) {
        Intrinsics.checkNotNullParameter(enumSet, "newSdkMetadata");
        if (Intrinsics.areEqual((Object) c.a(enumSet), (Object) this.a.getStringSet("tags", SetsKt.emptySet()))) {
            return null;
        }
        return enumSet;
    }
}
