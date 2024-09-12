package zendesk.android.internal.extension;

import android.content.Context;
import android.os.Build;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"getLanguageTag", "", "Landroid/content/Context;", "zendesk_zendesk-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidExt.kt */
public final class AndroidExtKt {
    public static final String getLanguageTag(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (Build.VERSION.SDK_INT >= 24) {
            String languageTag = context.getResources().getConfiguration().getLocales().get(0).toLanguageTag();
            Intrinsics.checkNotNullExpressionValue(languageTag, "{\n        resources.conf…[0].toLanguageTag()\n    }");
            return languageTag;
        }
        String languageTag2 = Locale.getDefault().toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag2, "{\n        Locale.getDefa…t().toLanguageTag()\n    }");
        return languageTag2;
    }
}
