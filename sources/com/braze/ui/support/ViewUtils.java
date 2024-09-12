package com.braze.ui.support;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.WindowInsetsCompat;
import com.braze.enums.inappmessage.Orientation;
import com.braze.support.BrazeLogger;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005\u001a\u000e\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b\u001a\u000e\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b\u001a\u000e\u0010\r\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b\u001a\u000e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b\u001a\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017\u001a\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0001\u001a\n\u0010\u001b\u001a\u00020\u0010*\u00020\u001c\u001a\f\u0010\u001d\u001a\u00020\u0019*\u0004\u0018\u00010\u0017\u001a\u0012\u0010\u001e\u001a\u00020\u0019*\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0001\u001a\n\u0010 \u001a\u00020\u0019*\u00020\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"TABLET_SMALLEST_WIDTH_DP", "", "TAG", "", "convertDpToPixels", "", "context", "Landroid/content/Context;", "valueInDp", "getMaxSafeBottomInset", "windowInsets", "Landroidx/core/view/WindowInsetsCompat;", "getMaxSafeLeftInset", "getMaxSafeRightInset", "getMaxSafeTopInset", "isCurrentOrientationValid", "", "currentScreenOrientation", "preferredOrientation", "Lcom/braze/enums/inappmessage/Orientation;", "isDeviceInNightMode", "isDeviceNotInTouchMode", "view", "Landroid/view/View;", "setHeightOnViewLayoutParams", "", "height", "isRunningOnTablet", "Landroid/app/Activity;", "removeViewFromParent", "setActivityRequestedOrientation", "requestedOrientation", "setFocusableInTouchModeAndRequestFocus", "android-sdk-ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewUtils.kt */
public final class ViewUtils {
    private static final int TABLET_SMALLEST_WIDTH_DP = 600;
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("ViewUtils");

    public static final void removeViewFromParent(View view) {
        if (view == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.D, (Throwable) null, (Function0) ViewUtils$removeViewFromParent$1.INSTANCE, 4, (Object) null);
        }
        if ((view != null ? view.getParent() : null) instanceof ViewGroup) {
            ViewParent parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.removeView(view);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.D, (Throwable) null, (Function0) new ViewUtils$removeViewFromParent$2(view, viewGroup), 4, (Object) null);
        }
    }

    public static final void setFocusableInTouchModeAndRequestFocus(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        try {
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog(TAG, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) ViewUtils$setFocusableInTouchModeAndRequestFocus$1.INSTANCE);
        }
    }

    public static final double convertDpToPixels(Context context, double d) {
        Intrinsics.checkNotNullParameter(context, "context");
        return d * ((double) context.getResources().getDisplayMetrics().density);
    }

    public static final boolean isRunningOnTablet(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        return activity.getResources().getConfiguration().smallestScreenWidthDp >= TABLET_SMALLEST_WIDTH_DP;
    }

    public static final void setActivityRequestedOrientation(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        try {
            activity.setRequestedOrientation(i);
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog(TAG, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) new ViewUtils$setActivityRequestedOrientation$1(i, activity));
        }
    }

    public static final void setHeightOnViewLayoutParams(View view, int i) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    public static final boolean isDeviceInNightMode(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static final boolean isCurrentOrientationValid(int i, Orientation orientation) {
        int i2 = i;
        Orientation orientation2 = orientation;
        Intrinsics.checkNotNullParameter(orientation2, "preferredOrientation");
        if (i2 == 2 && orientation2 == Orientation.LANDSCAPE) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.D, (Throwable) null, (Function0) ViewUtils$isCurrentOrientationValid$1.INSTANCE, 4, (Object) null);
            return true;
        } else if (i2 == 1 && orientation2 == Orientation.PORTRAIT) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.D, (Throwable) null, (Function0) ViewUtils$isCurrentOrientationValid$2.INSTANCE, 4, (Object) null);
            return true;
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.D, (Throwable) null, (Function0) new ViewUtils$isCurrentOrientationValid$3(i2, orientation2), 4, (Object) null);
            return false;
        }
    }

    public static final int getMaxSafeLeftInset(WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsets");
        DisplayCutoutCompat displayCutout = windowInsetsCompat.getDisplayCutout();
        return Math.max(displayCutout != null ? displayCutout.getSafeInsetLeft() : 0, windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).left);
    }

    public static final int getMaxSafeRightInset(WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsets");
        DisplayCutoutCompat displayCutout = windowInsetsCompat.getDisplayCutout();
        return Math.max(displayCutout != null ? displayCutout.getSafeInsetRight() : 0, windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).right);
    }

    public static final int getMaxSafeTopInset(WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsets");
        DisplayCutoutCompat displayCutout = windowInsetsCompat.getDisplayCutout();
        return Math.max(displayCutout != null ? displayCutout.getSafeInsetTop() : 0, windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).top);
    }

    public static final int getMaxSafeBottomInset(WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsets");
        DisplayCutoutCompat displayCutout = windowInsetsCompat.getDisplayCutout();
        return Math.max(displayCutout != null ? displayCutout.getSafeInsetBottom() : 0, windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
    }

    public static final boolean isDeviceNotInTouchMode(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        return !view.isInTouchMode();
    }
}
