package zendesk.ui.android.internal;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0016\u0010\u0004\u001a\u00020\u0001*\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0001H\u0001¨\u0006\u0007"}, d2 = {"adjustAlpha", "", "factor", "", "resolveColorAttr", "Landroid/content/Context;", "colorAttr", "zendesk.ui_ui-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ColorExt.kt */
public final class ColorExtKt {
    public static final int resolveColorAttr(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.data;
    }

    public static final int adjustAlpha(int i, float f) {
        return Color.argb(MathKt.roundToInt(((float) Color.alpha(i)) * f), Color.red(i), Color.green(i), Color.blue(i));
    }
}
