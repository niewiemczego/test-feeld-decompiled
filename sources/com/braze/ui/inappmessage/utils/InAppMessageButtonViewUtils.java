package com.braze.ui.inappmessage.utils;

import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.Button;
import com.braze.models.inappmessage.MessageButton;
import com.braze.ui.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nH\u0007J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007J$\u0010\u0015\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0007¨\u0006\u001a"}, d2 = {"Lcom/braze/ui/inappmessage/utils/InAppMessageButtonViewUtils;", "", "()V", "getButtonDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "messageButton", "Lcom/braze/models/inappmessage/MessageButton;", "newStrokeWidth", "", "strokeFocusedWidth", "isFocused", "", "getDrawable", "drawableId", "setButton", "", "button", "Landroid/widget/Button;", "strokeWidth", "setButtons", "buttonViews", "", "Landroid/view/View;", "messageButtons", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InAppMessageButtonViewUtils.kt */
public final class InAppMessageButtonViewUtils {
    public static final InAppMessageButtonViewUtils INSTANCE = new InAppMessageButtonViewUtils();

    private InAppMessageButtonViewUtils() {
    }

    @JvmStatic
    public static final void setButtons(List<? extends View> list, List<? extends MessageButton> list2) {
        Intrinsics.checkNotNullParameter(list, "buttonViews");
        Intrinsics.checkNotNullParameter(list2, "messageButtons");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            View view = (View) list.get(i);
            MessageButton messageButton = (MessageButton) list2.get(i);
            int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(R.dimen.com_braze_inappmessage_button_border_stroke);
            int dimensionPixelSize2 = view.getContext().getResources().getDimensionPixelSize(R.dimen.com_braze_inappmessage_button_border_stroke_focused);
            if (list2.size() <= i) {
                view.setVisibility(8);
            } else if (view instanceof Button) {
                setButton((Button) view, messageButton, dimensionPixelSize, dimensionPixelSize2);
            }
        }
    }

    @JvmStatic
    public static final void setButton(Button button, MessageButton messageButton, int i, int i2) {
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(messageButton, "messageButton");
        button.setText(messageButton.getText());
        button.setContentDescription(messageButton.getText());
        InAppMessageViewUtils.setTextViewColor(button, messageButton.getTextColor());
        StateListDrawable stateListDrawable = new StateListDrawable();
        button.setStateListAnimator((StateListAnimator) null);
        Context context = button.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "button.context");
        Drawable buttonDrawable = getButtonDrawable(context, messageButton, i, i2, false);
        Context context2 = button.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "button.context");
        Drawable buttonDrawable2 = getButtonDrawable(context2, messageButton, i, i2, true);
        stateListDrawable.addState(new int[]{16842908}, buttonDrawable2);
        stateListDrawable.addState(new int[]{16842910}, buttonDrawable);
        button.setBackground(stateListDrawable);
    }

    @JvmStatic
    public static final Drawable getDrawable(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = context.getResources().getDrawable(i, (Resources.Theme) null);
        Intrinsics.checkNotNullExpressionValue(drawable, "context.resources.getDrawable(drawableId, null)");
        return drawable;
    }

    @JvmStatic
    public static final Drawable getButtonDrawable(Context context, MessageButton messageButton, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(messageButton, "messageButton");
        Drawable drawable = getDrawable(context, R.drawable.com_braze_inappmessage_button_background);
        drawable.mutate();
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.RippleDrawable");
        Drawable findDrawableByLayerId = ((RippleDrawable) drawable).findDrawableByLayerId(R.id.com_braze_inappmessage_button_background_ripple_internal_gradient);
        Intrinsics.checkNotNull(findDrawableByLayerId, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) findDrawableByLayerId;
        if (z) {
            i = i2;
        }
        gradientDrawable.setStroke(i, messageButton.getBorderColor());
        gradientDrawable.setColor(messageButton.getBackgroundColor());
        return drawable;
    }
}
