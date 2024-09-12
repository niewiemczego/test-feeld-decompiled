package com.swmansion.rnscreens;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import com.facebook.react.ReactApplication;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.text.ReactTypefaceUtils;
import com.swmansion.rnscreens.ScreenStackHeaderSubview;
import com.swmansion.rnscreens.events.HeaderAttachedEvent;
import com.swmansion.rnscreens.events.HeaderDetachedEvent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b(\u0018\u00002\u00020\u0001:\u0001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020\nJ\u0006\u0010B\u001a\u00020?J\u000e\u0010C\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020\nJ\b\u0010D\u001a\u00020?H\u0002J\b\u0010E\u001a\u00020?H\u0014J\b\u0010F\u001a\u00020?H\u0014J0\u0010G\u001a\u00020?2\u0006\u0010H\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\n2\u0006\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020\nH\u0014J\u0006\u0010M\u001a\u00020?J\u0006\u0010N\u001a\u00020?J\u000e\u0010O\u001a\u00020?2\u0006\u0010A\u001a\u00020\nJ\u000e\u0010P\u001a\u00020?2\u0006\u0010\u0005\u001a\u00020\u0006J\u0015\u0010Q\u001a\u00020?2\b\u0010R\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010SJ\u0010\u0010T\u001a\u00020?2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010U\u001a\u00020?2\u0006\u0010V\u001a\u00020\u0006J\u000e\u0010W\u001a\u00020?2\u0006\u0010X\u001a\u00020\u0006J\u000e\u0010Y\u001a\u00020?2\u0006\u0010Z\u001a\u00020\u0006J\u000e\u0010[\u001a\u00020?2\u0006\u0010R\u001a\u00020\nJ\u0010\u0010\\\u001a\u00020?2\b\u00100\u001a\u0004\u0018\u00010\u0016J\u000e\u0010]\u001a\u00020?2\u0006\u0010R\u001a\u00020\nJ\u0010\u0010^\u001a\u00020?2\b\u00102\u001a\u0004\u0018\u00010\u0016J\u000e\u0010_\u001a\u00020?2\u0006\u00103\u001a\u000204J\u0010\u0010`\u001a\u00020?2\b\u0010a\u001a\u0004\u0018\u00010\u0016J\u000e\u0010b\u001a\u00020?2\u0006\u0010c\u001a\u00020\u0006J\u000e\u0010d\u001a\u00020?2\u0006\u0010e\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u000e\u0010!\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\u0004\u0018\u00010$8BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0013\u0010'\u001a\u0004\u0018\u00010(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010+\u001a\u0004\u0018\u00010,8BX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u00106\u001a\u0004\u0018\u0001078BX\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0011\u0010:\u001a\u00020;¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=¨\u0006g"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "backButtonInCustomView", "", "backClickListener", "Landroid/view/View$OnClickListener;", "backgroundColor", "", "Ljava/lang/Integer;", "configSubviews", "Ljava/util/ArrayList;", "Lcom/swmansion/rnscreens/ScreenStackHeaderSubview;", "Lkotlin/collections/ArrayList;", "configSubviewsCount", "getConfigSubviewsCount", "()I", "defaultStartInset", "defaultStartInsetWithNavigation", "direction", "", "headerTopInset", "isAttachedToWindow", "isBackButtonHidden", "isDestroyed", "isHeaderHidden", "()Z", "setHeaderHidden", "(Z)V", "isHeaderTranslucent", "setHeaderTranslucent", "isShadowHidden", "isTopInsetEnabled", "screen", "Lcom/swmansion/rnscreens/Screen;", "getScreen", "()Lcom/swmansion/rnscreens/Screen;", "screenFragment", "Lcom/swmansion/rnscreens/ScreenStackFragment;", "getScreenFragment", "()Lcom/swmansion/rnscreens/ScreenStackFragment;", "screenStack", "Lcom/swmansion/rnscreens/ScreenStack;", "getScreenStack", "()Lcom/swmansion/rnscreens/ScreenStack;", "tintColor", "title", "titleColor", "titleFontFamily", "titleFontSize", "", "titleFontWeight", "titleTextView", "Landroid/widget/TextView;", "getTitleTextView", "()Landroid/widget/TextView;", "toolbar", "Lcom/swmansion/rnscreens/CustomToolbar;", "getToolbar", "()Lcom/swmansion/rnscreens/CustomToolbar;", "addConfigSubview", "", "child", "index", "destroy", "getConfigSubview", "maybeUpdate", "onAttachedToWindow", "onDetachedFromWindow", "onLayout", "changed", "l", "t", "r", "b", "onUpdate", "removeAllConfigSubviews", "removeConfigSubview", "setBackButtonInCustomView", "setBackgroundColor", "color", "(Ljava/lang/Integer;)V", "setDirection", "setHidden", "hidden", "setHideBackButton", "hideBackButton", "setHideShadow", "hideShadow", "setTintColor", "setTitle", "setTitleColor", "setTitleFontFamily", "setTitleFontSize", "setTitleFontWeight", "fontWeightString", "setTopInsetEnabled", "topInsetEnabled", "setTranslucent", "translucent", "DebugMenuToolbar", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ScreenStackHeaderConfig.kt */
public final class ScreenStackHeaderConfig extends ViewGroup {
    private boolean backButtonInCustomView;
    private final View.OnClickListener backClickListener = new ScreenStackHeaderConfig$$ExternalSyntheticLambda0(this);
    private Integer backgroundColor;
    private final ArrayList<ScreenStackHeaderSubview> configSubviews = new ArrayList<>(3);
    private final int defaultStartInset;
    private final int defaultStartInsetWithNavigation;
    private String direction;
    private Integer headerTopInset;
    private boolean isAttachedToWindow;
    private boolean isBackButtonHidden;
    private boolean isDestroyed;
    private boolean isHeaderHidden;
    private boolean isHeaderTranslucent;
    private boolean isShadowHidden;
    private boolean isTopInsetEnabled = true;
    private int tintColor;
    private String title;
    private int titleColor;
    private String titleFontFamily;
    private float titleFontSize;
    private int titleFontWeight;
    private final CustomToolbar toolbar;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ScreenStackHeaderConfig.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScreenStackHeaderSubview.Type.values().length];
            iArr[ScreenStackHeaderSubview.Type.LEFT.ordinal()] = 1;
            iArr[ScreenStackHeaderSubview.Type.RIGHT.ordinal()] = 2;
            iArr[ScreenStackHeaderSubview.Type.CENTER.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScreenStackHeaderConfig(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setVisibility(8);
        CustomToolbar customToolbar = new CustomToolbar(context, this);
        this.toolbar = customToolbar;
        this.defaultStartInset = customToolbar.getContentInsetStart();
        this.defaultStartInsetWithNavigation = customToolbar.getContentInsetStartWithNavigation();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16843827, typedValue, true)) {
            customToolbar.setBackgroundColor(typedValue.data);
        }
        customToolbar.setClipChildren(false);
    }

    public final CustomToolbar getToolbar() {
        return this.toolbar;
    }

    public final boolean isHeaderHidden() {
        return this.isHeaderHidden;
    }

    public final void setHeaderHidden(boolean z) {
        this.isHeaderHidden = z;
    }

    public final boolean isHeaderTranslucent() {
        return this.isHeaderTranslucent;
    }

    public final void setHeaderTranslucent(boolean z) {
        this.isHeaderTranslucent = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: backClickListener$lambda-1  reason: not valid java name */
    public static final void m653backClickListener$lambda1(ScreenStackHeaderConfig screenStackHeaderConfig, View view) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "this$0");
        ScreenStackFragment screenFragment = screenStackHeaderConfig.getScreenFragment();
        if (screenFragment != null) {
            ScreenStack screenStack = screenStackHeaderConfig.getScreenStack();
            if (screenStack != null && Intrinsics.areEqual((Object) screenStack.getRootScreen(), (Object) screenFragment.getScreen())) {
                Fragment parentFragment = screenFragment.getParentFragment();
                if (parentFragment instanceof ScreenStackFragment) {
                    ScreenStackFragment screenStackFragment = (ScreenStackFragment) parentFragment;
                    if (screenStackFragment.getScreen().getNativeBackButtonDismissalEnabled()) {
                        screenStackFragment.dismiss();
                    } else {
                        screenStackFragment.dispatchHeaderBackButtonClickedEvent();
                    }
                }
            } else if (screenFragment.getScreen().getNativeBackButtonDismissalEnabled()) {
                screenFragment.dismiss();
            } else {
                screenFragment.dispatchHeaderBackButtonClickedEvent();
            }
        }
    }

    public final void destroy() {
        this.isDestroyed = true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        Integer num;
        super.onAttachedToWindow();
        this.isAttachedToWindow = true;
        int surfaceId = UIManagerHelper.getSurfaceId((View) this);
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new HeaderAttachedEvent(surfaceId, getId()));
        }
        if (this.headerTopInset == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                num = Integer.valueOf(getRootWindowInsets().getSystemWindowInsetTop());
            } else {
                num = Integer.valueOf((int) (((float) 25) * getResources().getDisplayMetrics().density));
            }
            this.headerTopInset = num;
        }
        onUpdate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        int surfaceId = UIManagerHelper.getSurfaceId((View) this);
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new HeaderDetachedEvent(surfaceId, getId()));
        }
    }

    private final Screen getScreen() {
        ViewParent parent = getParent();
        if (parent instanceof Screen) {
            return (Screen) parent;
        }
        return null;
    }

    private final ScreenStack getScreenStack() {
        Screen screen = getScreen();
        ViewParent container = screen != null ? screen.getContainer() : null;
        if (container instanceof ScreenStack) {
            return (ScreenStack) container;
        }
        return null;
    }

    public final ScreenStackFragment getScreenFragment() {
        ViewParent parent = getParent();
        if (!(parent instanceof Screen)) {
            return null;
        }
        Fragment fragment = ((Screen) parent).getFragment();
        if (fragment instanceof ScreenStackFragment) {
            return (ScreenStackFragment) fragment;
        }
        return null;
    }

    public final void onUpdate() {
        Drawable navigationIcon;
        ScreenStackFragment screenFragment;
        ScreenStackFragment screenFragment2;
        ReactContext reactContext;
        ScreenStack screenStack = getScreenStack();
        boolean z = screenStack == null || Intrinsics.areEqual((Object) screenStack.getTopScreen(), (Object) getParent());
        if (this.isAttachedToWindow && z && !this.isDestroyed) {
            ScreenStackFragment screenFragment3 = getScreenFragment();
            AppCompatActivity appCompatActivity = (AppCompatActivity) (screenFragment3 != null ? screenFragment3.getActivity() : null);
            if (appCompatActivity != null) {
                String str = this.direction;
                if (str != null) {
                    if (Intrinsics.areEqual((Object) str, (Object) "rtl")) {
                        this.toolbar.setLayoutDirection(1);
                    } else if (Intrinsics.areEqual((Object) this.direction, (Object) "ltr")) {
                        this.toolbar.setLayoutDirection(0);
                    }
                }
                Screen screen = getScreen();
                if (screen != null) {
                    if (getContext() instanceof ReactContext) {
                        Context context = getContext();
                        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                        reactContext = (ReactContext) context;
                    } else {
                        ScreenFragmentWrapper fragmentWrapper = screen.getFragmentWrapper();
                        reactContext = fragmentWrapper != null ? fragmentWrapper.tryGetContext() : null;
                    }
                    ScreenWindowTraits.INSTANCE.trySetWindowTraits$react_native_screens_release(screen, appCompatActivity, reactContext);
                }
                if (!this.isHeaderHidden) {
                    if (this.toolbar.getParent() == null && (screenFragment = getScreenFragment()) != null) {
                        screenFragment.setToolbar(this.toolbar);
                    }
                    if (this.isTopInsetEnabled) {
                        Integer num = this.headerTopInset;
                        this.toolbar.setPadding(0, num != null ? num.intValue() : 0, 0, 0);
                    } else if (this.toolbar.getPaddingTop() > 0) {
                        this.toolbar.setPadding(0, 0, 0, 0);
                    }
                    appCompatActivity.setSupportActionBar(this.toolbar);
                    ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
                    if (supportActionBar != null) {
                        Intrinsics.checkNotNullExpressionValue(supportActionBar, "requireNotNull(activity.supportActionBar)");
                        this.toolbar.setContentInsetStartWithNavigation(this.defaultStartInsetWithNavigation);
                        CustomToolbar customToolbar = this.toolbar;
                        int i = this.defaultStartInset;
                        customToolbar.setContentInsetsRelative(i, i);
                        ScreenStackFragment screenFragment4 = getScreenFragment();
                        supportActionBar.setDisplayHomeAsUpEnabled((screenFragment4 != null && screenFragment4.canNavigateBack()) && !this.isBackButtonHidden);
                        this.toolbar.setNavigationOnClickListener(this.backClickListener);
                        ScreenStackFragment screenFragment5 = getScreenFragment();
                        if (screenFragment5 != null) {
                            screenFragment5.setToolbarShadowHidden(this.isShadowHidden);
                        }
                        ScreenStackFragment screenFragment6 = getScreenFragment();
                        if (screenFragment6 != null) {
                            screenFragment6.setToolbarTranslucent(this.isHeaderTranslucent);
                        }
                        supportActionBar.setTitle((CharSequence) this.title);
                        if (TextUtils.isEmpty(this.title)) {
                            this.toolbar.setContentInsetStartWithNavigation(0);
                        }
                        TextView titleTextView = getTitleTextView();
                        int i2 = this.titleColor;
                        if (i2 != 0) {
                            this.toolbar.setTitleTextColor(i2);
                        }
                        if (titleTextView != null) {
                            String str2 = this.titleFontFamily;
                            if (str2 != null || this.titleFontWeight > 0) {
                                Typeface applyStyles = ReactTypefaceUtils.applyStyles((Typeface) null, 0, this.titleFontWeight, str2, getContext().getAssets());
                                Intrinsics.checkNotNullExpressionValue(applyStyles, "applyStyles(\n           ….assets\n                )");
                                titleTextView.setTypeface(applyStyles);
                            }
                            float f = this.titleFontSize;
                            if (f > 0.0f) {
                                titleTextView.setTextSize(f);
                            }
                        }
                        Integer num2 = this.backgroundColor;
                        if (num2 != null) {
                            this.toolbar.setBackgroundColor(num2.intValue());
                        }
                        if (!(this.tintColor == 0 || (navigationIcon = this.toolbar.getNavigationIcon()) == null)) {
                            navigationIcon.setColorFilter(this.tintColor, PorterDuff.Mode.SRC_ATOP);
                        }
                        for (int childCount = this.toolbar.getChildCount() - 1; -1 < childCount; childCount--) {
                            if (this.toolbar.getChildAt(childCount) instanceof ScreenStackHeaderSubview) {
                                this.toolbar.removeViewAt(childCount);
                            }
                        }
                        int size = this.configSubviews.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            ScreenStackHeaderSubview screenStackHeaderSubview = this.configSubviews.get(i3);
                            Intrinsics.checkNotNullExpressionValue(screenStackHeaderSubview, "configSubviews[i]");
                            ScreenStackHeaderSubview screenStackHeaderSubview2 = screenStackHeaderSubview;
                            ScreenStackHeaderSubview.Type type = screenStackHeaderSubview2.getType();
                            if (type == ScreenStackHeaderSubview.Type.BACK) {
                                View childAt = screenStackHeaderSubview2.getChildAt(0);
                                ImageView imageView = childAt instanceof ImageView ? (ImageView) childAt : null;
                                if (imageView != null) {
                                    supportActionBar.setHomeAsUpIndicator(imageView.getDrawable());
                                } else {
                                    throw new JSApplicationIllegalArgumentException("Back button header config view should have Image as first child");
                                }
                            } else {
                                Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-2, -1);
                                int i4 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                                if (i4 == 1) {
                                    if (!this.backButtonInCustomView) {
                                        this.toolbar.setNavigationIcon((Drawable) null);
                                    }
                                    this.toolbar.setTitle((CharSequence) null);
                                    layoutParams.gravity = GravityCompat.START;
                                } else if (i4 == 2) {
                                    layoutParams.gravity = GravityCompat.END;
                                } else if (i4 == 3) {
                                    layoutParams.width = -1;
                                    layoutParams.gravity = 1;
                                    this.toolbar.setTitle((CharSequence) null);
                                }
                                screenStackHeaderSubview2.setLayoutParams(layoutParams);
                                this.toolbar.addView(screenStackHeaderSubview2);
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                } else if (this.toolbar.getParent() != null && (screenFragment2 = getScreenFragment()) != null) {
                    screenFragment2.removeToolbar();
                }
            }
        }
    }

    private final void maybeUpdate() {
        if (getParent() != null && !this.isDestroyed) {
            onUpdate();
        }
    }

    public final ScreenStackHeaderSubview getConfigSubview(int i) {
        ScreenStackHeaderSubview screenStackHeaderSubview = this.configSubviews.get(i);
        Intrinsics.checkNotNullExpressionValue(screenStackHeaderSubview, "configSubviews[index]");
        return screenStackHeaderSubview;
    }

    public final int getConfigSubviewsCount() {
        return this.configSubviews.size();
    }

    public final void removeConfigSubview(int i) {
        this.configSubviews.remove(i);
        maybeUpdate();
    }

    public final void removeAllConfigSubviews() {
        this.configSubviews.clear();
        maybeUpdate();
    }

    public final void addConfigSubview(ScreenStackHeaderSubview screenStackHeaderSubview, int i) {
        Intrinsics.checkNotNullParameter(screenStackHeaderSubview, "child");
        this.configSubviews.add(i, screenStackHeaderSubview);
        maybeUpdate();
    }

    private final TextView getTitleTextView() {
        int childCount = this.toolbar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.toolbar.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (Intrinsics.areEqual((Object) textView.getText(), (Object) this.toolbar.getTitle())) {
                    return textView;
                }
            }
        }
        return null;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setTitleFontFamily(String str) {
        this.titleFontFamily = str;
    }

    public final void setTitleFontWeight(String str) {
        this.titleFontWeight = ReactTypefaceUtils.parseFontWeight(str);
    }

    public final void setTitleFontSize(float f) {
        this.titleFontSize = f;
    }

    public final void setTitleColor(int i) {
        this.titleColor = i;
    }

    public final void setTintColor(int i) {
        this.tintColor = i;
    }

    public final void setTopInsetEnabled(boolean z) {
        this.isTopInsetEnabled = z;
    }

    public final void setBackgroundColor(Integer num) {
        this.backgroundColor = num;
    }

    public final void setHideShadow(boolean z) {
        this.isShadowHidden = z;
    }

    public final void setHideBackButton(boolean z) {
        this.isBackButtonHidden = z;
    }

    public final void setHidden(boolean z) {
        this.isHeaderHidden = z;
    }

    public final void setTranslucent(boolean z) {
        this.isHeaderTranslucent = z;
    }

    public final void setBackButtonInCustomView(boolean z) {
        this.backButtonInCustomView = z;
    }

    public final void setDirection(String str) {
        this.direction = str;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackHeaderConfig$DebugMenuToolbar;", "Lcom/swmansion/rnscreens/CustomToolbar;", "context", "Landroid/content/Context;", "config", "Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "(Landroid/content/Context;Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;)V", "showOverflowMenu", "", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ScreenStackHeaderConfig.kt */
    private static final class DebugMenuToolbar extends CustomToolbar {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DebugMenuToolbar(Context context, ScreenStackHeaderConfig screenStackHeaderConfig) {
            super(context, screenStackHeaderConfig);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        }

        public boolean showOverflowMenu() {
            Context applicationContext = getContext().getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.facebook.react.ReactApplication");
            ((ReactApplication) applicationContext).getReactNativeHost().getReactInstanceManager().showDevOptionsDialog();
            return true;
        }
    }
}
