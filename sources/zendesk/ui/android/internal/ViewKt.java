package zendesk.ui.android.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.TouchDelegate;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a<\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\t\u001a\u00020\u00072\b\b\u0003\u0010\n\u001a\u00020\u0007H\u0000\u001a\f\u0010\u000b\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a4\u0010\f\u001a\u00020\u0003*\u00020\u00042\b\b\u0003\u0010\r\u001a\u00020\u00072\b\b\u0003\u0010\u000e\u001a\u00020\u00012\b\b\u0003\u0010\u000f\u001a\u00020\u00012\b\b\u0003\u0010\u0010\u001a\u00020\u0001H\u0000\u001a&\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\b\b\u0000\u0010\u0013*\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\u0014\u001a\u00020\u0007H\u0000\u001a \u0010\u0015\u001a\u00020\u0003*\u00020\u00042\u000e\b\u0004\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017H\bø\u0001\u0000\u001a*\u0010\u0018\u001a\u00020\u0003*\u00020\u00042\b\b\u0003\u0010\r\u001a\u00020\u00072\b\b\u0003\u0010\u000e\u001a\u00020\u00012\b\b\u0003\u0010\u0019\u001a\u00020\u0001H\u0000\u001a\f\u0010\u001a\u001a\u00020\u0003*\u00020\u001bH\u0000\u001a\f\u0010\u001c\u001a\u00020\u0003*\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001d"}, d2 = {"KEYBOARD_HEIGHT_RATIO", "", "expandTouchArea", "", "Landroid/view/View;", "parent", "extraPaddingTop", "", "extraPaddingBottom", "extraPaddingStart", "extraPaddingEnd", "focusAndShowKeyboard", "glowingBoxBackground", "borderColor", "borderRadius", "outerStrokeWidth", "innerStrokeWidth", "lazyViewById", "Lkotlin/Lazy;", "T", "viewId", "onKeyboardShown", "performAction", "Lkotlin/Function0;", "outlinedBoxBackground", "borderWidth", "requestLayoutOnKeyBoardShown", "Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;", "showKeyboardNow", "zendesk.ui_ui-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: View.kt */
public final class ViewKt {
    public static final float KEYBOARD_HEIGHT_RATIO = 0.15f;

    public static /* synthetic */ void outlinedBoxBackground$default(View view, int i, float f, float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            i = ColorExtKt.adjustAlpha(ColorExtKt.resolveColorAttr(context, R.attr.colorOnSurface), 0.12f);
        }
        if ((i2 & 2) != 0) {
            f = view.getResources().getDimension(R.dimen.zuia_message_cell_radius);
        }
        if ((i2 & 4) != 0) {
            f2 = view.getResources().getDimension(R.dimen.zuia_divider_size);
        }
        outlinedBoxBackground(view, i, f, f2);
    }

    public static final void outlinedBoxBackground(View view, int i, float f, float f2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        MaterialShapeDrawable createWithElevationOverlay = MaterialShapeDrawable.createWithElevationOverlay(view.getContext());
        createWithElevationOverlay.setStrokeWidth(f2);
        createWithElevationOverlay.setStrokeColor(ColorStateList.valueOf(i));
        createWithElevationOverlay.setCornerSize(f);
        view.setBackground(createWithElevationOverlay);
    }

    public static final void focusAndShowKeyboard(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.requestFocus();
        if (view.hasWindowFocus()) {
            showKeyboardNow(view);
        } else {
            view.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewKt$focusAndShowKeyboard$1(view));
        }
    }

    public static final void requestLayoutOnKeyBoardShown(MaterialAutoCompleteTextView materialAutoCompleteTextView) {
        Intrinsics.checkNotNullParameter(materialAutoCompleteTextView, "<this>");
        materialAutoCompleteTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewKt$requestLayoutOnKeyBoardShown$1(materialAutoCompleteTextView));
    }

    /* access modifiers changed from: private */
    public static final void showKeyboardNow(View view) {
        if (view.isFocused()) {
            view.post(new ViewKt$$ExternalSyntheticLambda0(view));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showKeyboardNow$lambda-1  reason: not valid java name */
    public static final void m2811showKeyboardNow$lambda1(View view) {
        Intrinsics.checkNotNullParameter(view, "$this_showKeyboardNow");
        Object systemService = view.getContext().getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).showSoftInput(view, 1);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public static /* synthetic */ void glowingBoxBackground$default(View view, int i, float f, float f2, float f3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            i = ColorExtKt.resolveColorAttr(context, R.attr.colorAccent);
        }
        if ((i2 & 2) != 0) {
            f = view.getResources().getDimension(R.dimen.zuia_message_cell_radius);
        }
        if ((i2 & 4) != 0) {
            f2 = view.getResources().getDimension(R.dimen.zuia_outer_stroke_width);
        }
        if ((i2 & 8) != 0) {
            f3 = view.getResources().getDimension(R.dimen.zuia_inner_stroke_width);
        }
        glowingBoxBackground(view, i, f, f2, f3);
    }

    public static final void glowingBoxBackground(View view, int i, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        MaterialShapeDrawable createWithElevationOverlay = MaterialShapeDrawable.createWithElevationOverlay(view.getContext());
        createWithElevationOverlay.setStrokeWidth(f2 + f3);
        createWithElevationOverlay.setStrokeColor(new ColorStateList(new int[][]{new int[0]}, new int[]{ColorExtKt.adjustAlpha(i, 0.35f)}));
        createWithElevationOverlay.setCornerSize(f);
        Unit unit = Unit.INSTANCE;
        MaterialShapeDrawable createWithElevationOverlay2 = MaterialShapeDrawable.createWithElevationOverlay(view.getContext());
        createWithElevationOverlay2.setStrokeWidth(f3);
        createWithElevationOverlay2.setStrokeColor(new ColorStateList(new int[][]{new int[0]}, new int[]{ColorExtKt.adjustAlpha(i, 0.55f)}));
        createWithElevationOverlay2.setCornerSize(f);
        Unit unit2 = Unit.INSTANCE;
        LayerDrawable layerDrawable = new LayerDrawable((Drawable[]) new MaterialShapeDrawable[]{createWithElevationOverlay, createWithElevationOverlay2});
        int i2 = ((int) f2) * -1;
        layerDrawable.setLayerInset(0, i2, i2, i2, i2);
        view.setBackground(layerDrawable);
    }

    public static final <T extends View> Lazy<T> lazyViewById(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return LazyKt.lazy(new ViewKt$lazyViewById$1(view, i));
    }

    public static final void onKeyboardShown(View view, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function0, "performAction");
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int height = view.getRootView().getHeight();
        if (((float) (height - rect.bottom)) > ((float) height) * 0.15f) {
            function0.invoke();
        }
    }

    public static /* synthetic */ void expandTouchArea$default(View view, View view2, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i = view.getResources().getDimensionPixelSize(R.dimen.zuia_default_expanded_touch_area);
        }
        int i6 = i;
        if ((i5 & 4) != 0) {
            i2 = view.getResources().getDimensionPixelSize(R.dimen.zuia_default_expanded_touch_area);
        }
        int i7 = i2;
        if ((i5 & 8) != 0) {
            i3 = view.getResources().getDimensionPixelSize(R.dimen.zuia_default_expanded_touch_area);
        }
        int i8 = i3;
        if ((i5 & 16) != 0) {
            i4 = view.getResources().getDimensionPixelSize(R.dimen.zuia_default_expanded_touch_area);
        }
        expandTouchArea(view, view2, i6, i7, i8, i4);
    }

    public static final void expandTouchArea(View view, View view2, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(view2, "parent");
        view2.post(new ViewKt$$ExternalSyntheticLambda1(view, i, i3, i4, i2, view2));
    }

    /* access modifiers changed from: private */
    /* renamed from: expandTouchArea$lambda-5  reason: not valid java name */
    public static final void m2810expandTouchArea$lambda5(View view, int i, int i2, int i3, int i4, View view2) {
        Intrinsics.checkNotNullParameter(view, "$this_expandTouchArea");
        Intrinsics.checkNotNullParameter(view2, "$parent");
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i;
        rect.left -= i2;
        rect.right += i3;
        rect.bottom += i4;
        view2.setTouchDelegate(new TouchDelegate(rect, view));
    }
}
