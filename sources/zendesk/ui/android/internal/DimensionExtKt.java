package zendesk.ui.android.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001¨\u0006\u0005"}, d2 = {"resolveDimensionAttr", "", "Landroid/content/Context;", "dimensionAttr", "", "zendesk.ui_ui-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DimensionExt.kt */
public final class DimensionExtKt {
    public static final int resolveDimensionAttr(Context context, int[] iArr) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "dimensionAttr");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, iArr);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(t…alue.data, dimensionAttr)");
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }
}
