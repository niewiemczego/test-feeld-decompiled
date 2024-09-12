package expo.modules.image;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0003J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lexpo/modules/image/ResourceIdHelper;", "", "()V", "idMap", "", "", "", "getResourceRawId", "context", "Landroid/content/Context;", "name", "getResourceUri", "Landroid/net/Uri;", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ResourceIdHelper.kt */
public final class ResourceIdHelper {
    public static final ResourceIdHelper INSTANCE = new ResourceIdHelper();
    private static final Map<String, Integer> idMap = new LinkedHashMap();

    private ResourceIdHelper() {
    }

    private final int getResourceRawId(Context context, String str) {
        if (str.length() == 0) {
            return -1;
        }
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        String replace$default = StringsKt.replace$default(lowerCase, "-", "_", false, 4, (Object) null);
        synchronized (this) {
            Map<String, Integer> map = idMap;
            Integer num = map.get(replace$default);
            if (num != null) {
                int intValue = num.intValue();
                return intValue;
            }
            int identifier = context.getResources().getIdentifier(replace$default, "raw", context.getPackageName());
            map.put(replace$default, Integer.valueOf(identifier));
            return identifier;
        }
    }

    public final Uri getResourceUri(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        Uri resourceDrawableUri = ResourceDrawableIdHelper.getInstance().getResourceDrawableUri(context, str);
        if (resourceDrawableUri != null && !Intrinsics.areEqual((Object) resourceDrawableUri, (Object) Uri.EMPTY)) {
            return resourceDrawableUri;
        }
        int resourceRawId = getResourceRawId(context, str);
        if (resourceRawId > 0) {
            return new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(resourceRawId)).build();
        }
        Uri uri = null;
        return null;
    }
}
