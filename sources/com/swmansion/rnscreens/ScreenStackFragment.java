package com.swmansion.rnscreens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import com.braze.Constants;
import com.facebook.react.uimanager.PixelUtil;
import com.google.android.material.appbar.AppBarLayout;
import com.swmansion.rnscreens.ScreenFragment;
import com.swmansion.rnscreens.ScreenStackHeaderSubview;
import com.swmansion.rnscreens.utils.DeviceUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u0002:\u0002;<B\u000f\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0007\b\u0016¢\u0006\u0002\u0010\u0006J\b\u0010\u001f\u001a\u00020\nH\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u0014H\u0016J\u0018\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J&\u0010)\u001a\u0004\u0018\u00010\r2\u0006\u0010'\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010/\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0016J\b\u00100\u001a\u00020\u0014H\u0016J\b\u00101\u001a\u00020\u0014H\u0016J\b\u00102\u001a\u00020\u0014H\u0016J\b\u00103\u001a\u00020\u0014H\u0016J\u0010\u00104\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u00020\nH\u0016J\u0010\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u00020\nH\u0016J\b\u00109\u001a\u00020\nH\u0002J\u0010\u0010:\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R7\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackFragment;", "Lcom/swmansion/rnscreens/ScreenFragment;", "Lcom/swmansion/rnscreens/ScreenStackFragmentWrapper;", "screenView", "Lcom/swmansion/rnscreens/Screen;", "(Lcom/swmansion/rnscreens/Screen;)V", "()V", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "isToolbarShadowHidden", "", "isToolbarTranslucent", "lastFocusedChild", "Landroid/view/View;", "onSearchViewCreate", "Lkotlin/Function1;", "Lcom/swmansion/rnscreens/CustomSearchView;", "Lkotlin/ParameterName;", "name", "searchView", "", "getOnSearchViewCreate", "()Lkotlin/jvm/functions/Function1;", "setOnSearchViewCreate", "(Lkotlin/jvm/functions/Function1;)V", "getSearchView", "()Lcom/swmansion/rnscreens/CustomSearchView;", "setSearchView", "(Lcom/swmansion/rnscreens/CustomSearchView;)V", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "canNavigateBack", "dismiss", "findLastFocusedChild", "notifyViewAppearTransitionEnd", "onContainerUpdate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPrepareOptionsMenu", "onStart", "onStop", "onViewAnimationEnd", "removeToolbar", "setToolbar", "setToolbarShadowHidden", "hidden", "setToolbarTranslucent", "translucent", "shouldShowSearchBar", "updateToolbarMenu", "ScreensAnimation", "ScreensCoordinatorLayout", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ScreenStackFragment.kt */
public final class ScreenStackFragment extends ScreenFragment implements ScreenStackFragmentWrapper {
    private AppBarLayout appBarLayout;
    private boolean isToolbarShadowHidden;
    private boolean isToolbarTranslucent;
    private View lastFocusedChild;
    private Function1<? super CustomSearchView, Unit> onSearchViewCreate;
    private CustomSearchView searchView;
    private Toolbar toolbar;

    public final CustomSearchView getSearchView() {
        return this.searchView;
    }

    public final void setSearchView(CustomSearchView customSearchView) {
        this.searchView = customSearchView;
    }

    public final Function1<CustomSearchView, Unit> getOnSearchViewCreate() {
        return this.onSearchViewCreate;
    }

    public final void setOnSearchViewCreate(Function1<? super CustomSearchView, Unit> function1) {
        this.onSearchViewCreate = function1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScreenStackFragment(Screen screen) {
        super(screen);
        Intrinsics.checkNotNullParameter(screen, "screenView");
    }

    public ScreenStackFragment() {
        throw new IllegalStateException("ScreenStack fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }

    public void removeToolbar() {
        Toolbar toolbar2;
        AppBarLayout appBarLayout2 = this.appBarLayout;
        if (!(appBarLayout2 == null || (toolbar2 = this.toolbar) == null || toolbar2.getParent() != appBarLayout2)) {
            appBarLayout2.removeView(toolbar2);
        }
        this.toolbar = null;
    }

    public void setToolbar(Toolbar toolbar2) {
        Intrinsics.checkNotNullParameter(toolbar2, "toolbar");
        AppBarLayout appBarLayout2 = this.appBarLayout;
        if (appBarLayout2 != null) {
            appBarLayout2.addView(toolbar2);
        }
        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, -2);
        layoutParams.setScrollFlags(0);
        toolbar2.setLayoutParams(layoutParams);
        this.toolbar = toolbar2;
    }

    public void setToolbarShadowHidden(boolean z) {
        if (this.isToolbarShadowHidden != z) {
            AppBarLayout appBarLayout2 = this.appBarLayout;
            if (appBarLayout2 != null) {
                appBarLayout2.setTargetElevation(z ? 0.0f : PixelUtil.toPixelFromDIP(4.0f));
            }
            this.isToolbarShadowHidden = z;
        }
    }

    public void setToolbarTranslucent(boolean z) {
        CoordinatorLayout.Behavior behavior;
        if (this.isToolbarTranslucent != z) {
            ViewGroup.LayoutParams layoutParams = getScreen().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
            if (z) {
                behavior = null;
            } else {
                behavior = new AppBarLayout.ScrollingViewBehavior();
            }
            layoutParams2.setBehavior(behavior);
            this.isToolbarTranslucent = z;
        }
    }

    public void onContainerUpdate() {
        super.onContainerUpdate();
        ScreenStackHeaderConfig headerConfig = getScreen().getHeaderConfig();
        if (headerConfig != null) {
            headerConfig.onUpdate();
        }
    }

    public void onViewAnimationEnd() {
        super.onViewAnimationEnd();
        notifyViewAppearTransitionEnd();
    }

    private final void notifyViewAppearTransitionEnd() {
        View view = getView();
        ViewParent parent = view != null ? view.getParent() : null;
        if (parent instanceof ScreenStack) {
            ((ScreenStack) parent).onViewAppearTransitionEnd();
        }
    }

    public void onStart() {
        View view = this.lastFocusedChild;
        if (view != null) {
            view.requestFocus();
        }
        super.onStart();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppBarLayout appBarLayout2;
        AppBarLayout appBarLayout3;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Context context = getContext();
        AppBarLayout appBarLayout4 = null;
        ScreensCoordinatorLayout screensCoordinatorLayout = context != null ? new ScreensCoordinatorLayout(context, this) : null;
        Screen screen = getScreen();
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        layoutParams.setBehavior(this.isToolbarTranslucent ? null : new AppBarLayout.ScrollingViewBehavior());
        screen.setLayoutParams(layoutParams);
        if (screensCoordinatorLayout != null) {
            ScreenFragment.Companion companion = ScreenFragment.Companion;
            screensCoordinatorLayout.addView(ScreenFragment.recycleView(getScreen()));
        }
        Context context2 = getContext();
        if (context2 != null) {
            appBarLayout4 = new AppBarLayout(context2);
            appBarLayout4.setBackgroundColor(0);
            appBarLayout4.setLayoutParams(new AppBarLayout.LayoutParams(-1, -2));
        }
        this.appBarLayout = appBarLayout4;
        if (screensCoordinatorLayout != null) {
            screensCoordinatorLayout.addView(appBarLayout4);
        }
        if (this.isToolbarShadowHidden && (appBarLayout3 = this.appBarLayout) != null) {
            appBarLayout3.setTargetElevation(0.0f);
        }
        Toolbar toolbar2 = this.toolbar;
        if (!(toolbar2 == null || (appBarLayout2 = this.appBarLayout) == null)) {
            ScreenFragment.Companion companion2 = ScreenFragment.Companion;
            appBarLayout2.addView(ScreenFragment.recycleView(toolbar2));
        }
        setHasOptionsMenu(true);
        return screensCoordinatorLayout;
    }

    public void onStop() {
        if (DeviceUtils.INSTANCE.isPlatformAndroidTV(getContext())) {
            this.lastFocusedChild = findLastFocusedChild();
        }
        super.onStop();
    }

    public void onPrepareOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        updateToolbarMenu(menu);
        super.onPrepareOptionsMenu(menu);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        updateToolbarMenu(menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    private final boolean shouldShowSearchBar() {
        ScreenStackHeaderConfig headerConfig = getScreen().getHeaderConfig();
        int configSubviewsCount = headerConfig != null ? headerConfig.getConfigSubviewsCount() : 0;
        if (headerConfig != null && configSubviewsCount > 0) {
            for (int i = 0; i < configSubviewsCount; i++) {
                if (headerConfig.getConfigSubview(i).getType() == ScreenStackHeaderSubview.Type.SEARCH_BAR) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void updateToolbarMenu(Menu menu) {
        menu.clear();
        if (shouldShowSearchBar()) {
            Context context = getContext();
            if (this.searchView == null && context != null) {
                CustomSearchView customSearchView = new CustomSearchView(context, this);
                this.searchView = customSearchView;
                Function1<? super CustomSearchView, Unit> function1 = this.onSearchViewCreate;
                if (function1 != null) {
                    function1.invoke(customSearchView);
                }
            }
            MenuItem add = menu.add("");
            add.setShowAsAction(2);
            add.setActionView(this.searchView);
        }
    }

    private final View findLastFocusedChild() {
        for (View screen = getScreen(); screen != null; screen = screen instanceof ViewGroup ? ((ViewGroup) screen).getFocusedChild() : null) {
            if (screen.isFocused()) {
                return screen;
            }
        }
        return null;
    }

    public boolean canNavigateBack() {
        ScreenContainer container = getScreen().getContainer();
        if (!(container instanceof ScreenStack)) {
            throw new IllegalStateException("ScreenStackFragment added into a non-stack container".toString());
        } else if (!Intrinsics.areEqual((Object) ((ScreenStack) container).getRootScreen(), (Object) getScreen())) {
            return true;
        } else {
            Fragment parentFragment = getParentFragment();
            if (parentFragment instanceof ScreenStackFragment) {
                return ((ScreenStackFragment) parentFragment).canNavigateBack();
            }
            return false;
        }
    }

    public void dismiss() {
        ScreenContainer container = getScreen().getContainer();
        if (container instanceof ScreenStack) {
            ((ScreenStack) container).dismiss(this);
            return;
        }
        throw new IllegalStateException("ScreenStackFragment added into a non-stack container".toString());
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackFragment$ScreensCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "context", "Landroid/content/Context;", "mFragment", "Lcom/swmansion/rnscreens/ScreenFragment;", "(Landroid/content/Context;Lcom/swmansion/rnscreens/ScreenFragment;)V", "mAnimationListener", "Landroid/view/animation/Animation$AnimationListener;", "clearFocus", "", "startAnimation", "animation", "Landroid/view/animation/Animation;", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ScreenStackFragment.kt */
    private static final class ScreensCoordinatorLayout extends CoordinatorLayout {
        private final Animation.AnimationListener mAnimationListener = new ScreenStackFragment$ScreensCoordinatorLayout$mAnimationListener$1(this);
        /* access modifiers changed from: private */
        public final ScreenFragment mFragment;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ScreensCoordinatorLayout(Context context, ScreenFragment screenFragment) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(screenFragment, "mFragment");
            this.mFragment = screenFragment;
        }

        public void startAnimation(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ScreensAnimation screensAnimation = new ScreensAnimation(this.mFragment);
            screensAnimation.setDuration(animation.getDuration());
            if (!(animation instanceof AnimationSet) || this.mFragment.isRemoving()) {
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(animation);
                animationSet.addAnimation(screensAnimation);
                animationSet.setAnimationListener(this.mAnimationListener);
                super.startAnimation(animationSet);
                return;
            }
            AnimationSet animationSet2 = (AnimationSet) animation;
            animationSet2.addAnimation(screensAnimation);
            animationSet2.setAnimationListener(this.mAnimationListener);
            super.startAnimation(animationSet2);
        }

        public void clearFocus() {
            if (getVisibility() != 4) {
                super.clearFocus();
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackFragment$ScreensAnimation;", "Landroid/view/animation/Animation;", "mFragment", "Lcom/swmansion/rnscreens/ScreenFragment;", "(Lcom/swmansion/rnscreens/ScreenFragment;)V", "applyTransformation", "", "interpolatedTime", "", "t", "Landroid/view/animation/Transformation;", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ScreenStackFragment.kt */
    private static final class ScreensAnimation extends Animation {
        private final ScreenFragment mFragment;

        public ScreensAnimation(ScreenFragment screenFragment) {
            Intrinsics.checkNotNullParameter(screenFragment, "mFragment");
            this.mFragment = screenFragment;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            Intrinsics.checkNotNullParameter(transformation, Constants.BRAZE_PUSH_TITLE_KEY);
            super.applyTransformation(f, transformation);
            ScreenFragment screenFragment = this.mFragment;
            screenFragment.dispatchTransitionProgressEvent(f, !screenFragment.isResumed());
        }
    }
}
