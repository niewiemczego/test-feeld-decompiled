package com.th3rdwave.safeareacontext;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0002\u001a\u00020\u0005H\u0002\u001a\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0002\u001a\u00020\u0005H\u0002\u001a\u0012\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0002\u001a\u00020\u0005H\u0003\u001a\u0012\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0002\u001a\u00020\u0005H\u0003\u001a\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\f"}, d2 = {"getFrame", "Lcom/th3rdwave/safeareacontext/Rect;", "rootView", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "getRootWindowInsetsCompat", "Lcom/th3rdwave/safeareacontext/EdgeInsets;", "getRootWindowInsetsCompatBase", "getRootWindowInsetsCompatM", "getRootWindowInsetsCompatR", "getSafeAreaInsets", "react-native-safe-area-context_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SafeAreaUtils.kt */
public final class SafeAreaUtilsKt {
    private static final EdgeInsets getRootWindowInsetsCompatR(View view) {
        Insets insets;
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null || (insets = rootWindowInsets.getInsets(WindowInsets.Type.statusBars() | WindowInsets.Type.displayCutout() | WindowInsets.Type.navigationBars())) == null) {
            return null;
        }
        return new EdgeInsets((float) insets.top, (float) insets.right, (float) insets.bottom, (float) insets.left);
    }

    private static final EdgeInsets getRootWindowInsetsCompatM(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        return new EdgeInsets((float) rootWindowInsets.getSystemWindowInsetTop(), (float) rootWindowInsets.getSystemWindowInsetRight(), (float) Math.min(rootWindowInsets.getSystemWindowInsetBottom(), rootWindowInsets.getStableInsetBottom()), (float) rootWindowInsets.getSystemWindowInsetLeft());
    }

    private static final EdgeInsets getRootWindowInsetsCompatBase(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return new EdgeInsets((float) rect.top, (float) (view.getWidth() - rect.right), (float) (view.getHeight() - rect.bottom), (float) rect.left);
    }

    private static final EdgeInsets getRootWindowInsetsCompat(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return getRootWindowInsetsCompatR(view);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return getRootWindowInsetsCompatM(view);
        }
        return getRootWindowInsetsCompatBase(view);
    }

    public static final EdgeInsets getSafeAreaInsets(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        if (view.getHeight() == 0) {
            return null;
        }
        View rootView = view.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        EdgeInsets rootWindowInsetsCompat = getRootWindowInsetsCompat(rootView);
        if (rootWindowInsetsCompat == null) {
            return null;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return new EdgeInsets(Math.max(rootWindowInsetsCompat.getTop() - ((float) rect.top), 0.0f), Math.max(Math.min(((float) (rect.left + view.getWidth())) - ((float) rootView.getWidth()), 0.0f) + rootWindowInsetsCompat.getRight(), 0.0f), Math.max(Math.min(((float) (rect.top + view.getHeight())) - ((float) rootView.getHeight()), 0.0f) + rootWindowInsetsCompat.getBottom(), 0.0f), Math.max(rootWindowInsetsCompat.getLeft() - ((float) rect.left), 0.0f));
    }

    public static final Rect getFrame(ViewGroup viewGroup, View view) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        if (view.getParent() == null) {
            return null;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        try {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            return new Rect((float) rect.left, (float) rect.top, (float) view.getWidth(), (float) view.getHeight());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }
}
