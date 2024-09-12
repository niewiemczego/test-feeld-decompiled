package com.swmansion.rnscreens;

import android.content.Context;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import io.sentry.protocol.Request;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0017J\b\u0010\u001a\u001a\u00020\u0017H\u0014J\b\u0010\u001b\u001a\u00020\u0017H\u0014J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0016J\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/swmansion/rnscreens/CustomSearchView;", "Landroidx/appcompat/widget/SearchView;", "context", "Landroid/content/Context;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;)V", "backPressOverrider", "Lcom/swmansion/rnscreens/FragmentBackPressOverrider;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "onCloseListener", "Landroidx/appcompat/widget/SearchView$OnCloseListener;", "onSearchClickedListener", "Landroid/view/View$OnClickListener;", "value", "", "overrideBackAction", "getOverrideBackAction", "()Z", "setOverrideBackAction", "(Z)V", "cancelSearch", "", "clearText", "focus", "onAttachedToWindow", "onDetachedFromWindow", "setOnCloseListener", "listener", "setOnSearchClickListener", "setText", "text", "", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CustomSearchView.kt */
public final class CustomSearchView extends SearchView {
    private final FragmentBackPressOverrider backPressOverrider;
    private OnBackPressedCallback onBackPressedCallback = new CustomSearchView$onBackPressedCallback$1(this);
    private SearchView.OnCloseListener onCloseListener;
    private View.OnClickListener onSearchClickedListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomSearchView(Context context, Fragment fragment) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragment, Request.JsonKeys.FRAGMENT);
        this.backPressOverrider = new FragmentBackPressOverrider(fragment, this.onBackPressedCallback);
        super.setOnSearchClickListener(new CustomSearchView$$ExternalSyntheticLambda0(this));
        super.setOnCloseListener(new CustomSearchView$$ExternalSyntheticLambda1(this));
        setMaxWidth(Integer.MAX_VALUE);
    }

    public final void setOverrideBackAction(boolean z) {
        this.backPressOverrider.setOverrideBackAction(z);
    }

    public final boolean getOverrideBackAction() {
        return this.backPressOverrider.getOverrideBackAction();
    }

    public final void focus() {
        setIconified(false);
        requestFocusFromTouch();
    }

    public final void clearText() {
        setQuery("", false);
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        setQuery(str, false);
    }

    public final void cancelSearch() {
        clearText();
        setIconified(true);
    }

    public void setOnCloseListener(SearchView.OnCloseListener onCloseListener2) {
        this.onCloseListener = onCloseListener2;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.onSearchClickedListener = onClickListener;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isIconified()) {
            this.backPressOverrider.maybeAddBackCallback();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.backPressOverrider.removeBackCallbackIfAdded();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m646_init_$lambda0(CustomSearchView customSearchView, View view) {
        Intrinsics.checkNotNullParameter(customSearchView, "this$0");
        View.OnClickListener onClickListener = customSearchView.onSearchClickedListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        customSearchView.backPressOverrider.maybeAddBackCallback();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final boolean m647_init_$lambda1(CustomSearchView customSearchView) {
        Intrinsics.checkNotNullParameter(customSearchView, "this$0");
        SearchView.OnCloseListener onCloseListener2 = customSearchView.onCloseListener;
        boolean onClose = onCloseListener2 != null ? onCloseListener2.onClose() : false;
        customSearchView.backPressOverrider.removeBackCallbackIfAdded();
        return onClose;
    }
}
