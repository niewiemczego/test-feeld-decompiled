package com.swmansion.rnscreens;

import android.content.Context;
import android.graphics.Paint;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.events.HeaderHeightChangeEvent;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0005yz{|}B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020[0ZH\u0002J\u000e\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u000206J\u0016\u0010_\u001a\u00020]2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020a0`H\u0014J\u0016\u0010b\u001a\u00020]2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020a0`H\u0014J\u0010\u0010c\u001a\u00020\u001f2\u0006\u0010d\u001a\u00020eH\u0002J\u0010\u0010f\u001a\u00020]2\u0006\u0010g\u001a\u00020[H\u0002J0\u0010h\u001a\u00020]2\u0006\u0010i\u001a\u00020\u001f2\u0006\u0010j\u001a\u0002062\u0006\u0010k\u001a\u0002062\u0006\u0010l\u001a\u0002062\u0006\u0010m\u001a\u000206H\u0014J\u000e\u0010n\u001a\u00020]2\u0006\u0010\u0007\u001a\u00020\u0006J\u001a\u0010o\u001a\u00020]2\u0006\u0010p\u001a\u0002062\b\u0010q\u001a\u0004\u0018\u00010rH\u0016J\u0010\u0010s\u001a\u00020]2\b\u0010B\u001a\u0004\u0018\u00010TJ\u000e\u0010t\u001a\u00020]2\u0006\u0010u\u001a\u00020\u001fJ\u0018\u0010v\u001a\u00020]2\u0006\u0010w\u001a\u0002062\u0006\u0010x\u001a\u000206H\u0002R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R*\u0010$\u001a\u0004\u0018\u00010\u001f2\b\u0010#\u001a\u0004\u0018\u00010\u001f@FX\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010)\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R*\u0010,\u001a\u0004\u0018\u00010\u001f2\b\u0010+\u001a\u0004\u0018\u00010\u001f@FX\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R*\u0010/\u001a\u0004\u0018\u00010\u001f2\b\u0010.\u001a\u0004\u0018\u00010\u001f@FX\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b/\u0010%\"\u0004\b0\u0010'R\u000e\u00101\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R*\u00105\u001a\u0004\u0018\u0001062\b\u00105\u001a\u0004\u0018\u000106@FX\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010<\u001a\u00020=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010B\u001a\u0004\u0018\u0001062\b\u0010\u0005\u001a\u0004\u0018\u000106@BX\u000e¢\u0006\n\n\u0002\u0010;\u001a\u0004\bC\u00108R\u001a\u0010D\u001a\u00020EX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR*\u0010P\u001a\u0004\u0018\u0001062\b\u0010P\u001a\u0004\u0018\u000106@FX\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\bQ\u00108\"\u0004\bR\u0010:R(\u0010S\u001a\u0004\u0018\u00010T2\b\u0010S\u001a\u0004\u0018\u00010T@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010X¨\u0006~"}, d2 = {"Lcom/swmansion/rnscreens/Screen;", "Lcom/swmansion/rnscreens/FabricEnabledViewGroup;", "context", "Lcom/facebook/react/bridge/ReactContext;", "(Lcom/facebook/react/bridge/ReactContext;)V", "<set-?>", "Lcom/swmansion/rnscreens/Screen$ActivityState;", "activityState", "getActivityState", "()Lcom/swmansion/rnscreens/Screen$ActivityState;", "container", "Lcom/swmansion/rnscreens/ScreenContainer;", "getContainer", "()Lcom/swmansion/rnscreens/ScreenContainer;", "setContainer", "(Lcom/swmansion/rnscreens/ScreenContainer;)V", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "fragmentWrapper", "Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "getFragmentWrapper", "()Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "setFragmentWrapper", "(Lcom/swmansion/rnscreens/ScreenFragmentWrapper;)V", "headerConfig", "Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "getHeaderConfig", "()Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "isGestureEnabled", "", "()Z", "setGestureEnabled", "(Z)V", "navigationBarHidden", "isNavigationBarHidden", "()Ljava/lang/Boolean;", "setNavigationBarHidden", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isStatusBarAnimated", "setStatusBarAnimated", "statusBarHidden", "isStatusBarHidden", "setStatusBarHidden", "statusBarTranslucent", "isStatusBarTranslucent", "setStatusBarTranslucent", "isTransitioning", "nativeBackButtonDismissalEnabled", "getNativeBackButtonDismissalEnabled", "setNativeBackButtonDismissalEnabled", "navigationBarColor", "", "getNavigationBarColor", "()Ljava/lang/Integer;", "setNavigationBarColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "replaceAnimation", "Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;", "getReplaceAnimation", "()Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;", "setReplaceAnimation", "(Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;)V", "screenOrientation", "getScreenOrientation", "stackAnimation", "Lcom/swmansion/rnscreens/Screen$StackAnimation;", "getStackAnimation", "()Lcom/swmansion/rnscreens/Screen$StackAnimation;", "setStackAnimation", "(Lcom/swmansion/rnscreens/Screen$StackAnimation;)V", "stackPresentation", "Lcom/swmansion/rnscreens/Screen$StackPresentation;", "getStackPresentation", "()Lcom/swmansion/rnscreens/Screen$StackPresentation;", "setStackPresentation", "(Lcom/swmansion/rnscreens/Screen$StackPresentation;)V", "statusBarColor", "getStatusBarColor", "setStatusBarColor", "statusBarStyle", "", "getStatusBarStyle", "()Ljava/lang/String;", "setStatusBarStyle", "(Ljava/lang/String;)V", "calculateHeaderHeight", "Lkotlin/Pair;", "", "changeAccessibilityMode", "", "mode", "dispatchRestoreInstanceState", "Landroid/util/SparseArray;", "Landroid/os/Parcelable;", "dispatchSaveInstanceState", "hasWebView", "viewGroup", "Landroid/view/ViewGroup;", "notifyHeaderHeightChange", "headerHeight", "onLayout", "changed", "l", "t", "r", "b", "setActivityState", "setLayerType", "layerType", "paint", "Landroid/graphics/Paint;", "setScreenOrientation", "setTransitioning", "transitioning", "updateScreenSizePaper", "width", "height", "ActivityState", "ReplaceAnimation", "StackAnimation", "StackPresentation", "WindowTraits", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Screen.kt */
public final class Screen extends FabricEnabledViewGroup {
    private ActivityState activityState;
    private ScreenContainer container;
    private ScreenFragmentWrapper fragmentWrapper;
    private boolean isGestureEnabled = true;
    private Boolean isNavigationBarHidden;
    private Boolean isStatusBarAnimated;
    private Boolean isStatusBarHidden;
    private Boolean isStatusBarTranslucent;
    private boolean isTransitioning;
    private boolean nativeBackButtonDismissalEnabled;
    private Integer navigationBarColor;
    private ReplaceAnimation replaceAnimation = ReplaceAnimation.POP;
    private Integer screenOrientation;
    private StackAnimation stackAnimation = StackAnimation.DEFAULT;
    private StackPresentation stackPresentation = StackPresentation.PUSH;
    private Integer statusBarColor;
    private String statusBarStyle;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/swmansion/rnscreens/Screen$ActivityState;", "", "(Ljava/lang/String;I)V", "INACTIVE", "TRANSITIONING_OR_BELOW_TOP", "ON_TOP", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Screen.kt */
    public enum ActivityState {
        INACTIVE,
        TRANSITIONING_OR_BELOW_TOP,
        ON_TOP
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;", "", "(Ljava/lang/String;I)V", "PUSH", "POP", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Screen.kt */
    public enum ReplaceAnimation {
        PUSH,
        POP
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/swmansion/rnscreens/Screen$StackAnimation;", "", "(Ljava/lang/String;I)V", "DEFAULT", "NONE", "FADE", "SLIDE_FROM_BOTTOM", "SLIDE_FROM_RIGHT", "SLIDE_FROM_LEFT", "FADE_FROM_BOTTOM", "IOS", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Screen.kt */
    public enum StackAnimation {
        DEFAULT,
        NONE,
        FADE,
        SLIDE_FROM_BOTTOM,
        SLIDE_FROM_RIGHT,
        SLIDE_FROM_LEFT,
        FADE_FROM_BOTTOM,
        IOS
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/swmansion/rnscreens/Screen$StackPresentation;", "", "(Ljava/lang/String;I)V", "PUSH", "MODAL", "TRANSPARENT_MODAL", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Screen.kt */
    public enum StackPresentation {
        PUSH,
        MODAL,
        TRANSPARENT_MODAL
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/swmansion/rnscreens/Screen$WindowTraits;", "", "(Ljava/lang/String;I)V", "ORIENTATION", "COLOR", "STYLE", "TRANSLUCENT", "HIDDEN", "ANIMATED", "NAVIGATION_BAR_COLOR", "NAVIGATION_BAR_HIDDEN", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Screen.kt */
    public enum WindowTraits {
        ORIENTATION,
        COLOR,
        STYLE,
        TRANSLUCENT,
        HIDDEN,
        ANIMATED,
        NAVIGATION_BAR_COLOR,
        NAVIGATION_BAR_HIDDEN
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, TtmlNode.RUBY_CONTAINER);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, TtmlNode.RUBY_CONTAINER);
    }

    public void setLayerType(int i, Paint paint) {
    }

    public Screen(ReactContext reactContext) {
        super(reactContext);
        setLayoutParams(new WindowManager.LayoutParams(2));
        this.nativeBackButtonDismissalEnabled = true;
    }

    public final Fragment getFragment() {
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            return screenFragmentWrapper.getFragment();
        }
        return null;
    }

    public final ScreenFragmentWrapper getFragmentWrapper() {
        return this.fragmentWrapper;
    }

    public final void setFragmentWrapper(ScreenFragmentWrapper screenFragmentWrapper) {
        this.fragmentWrapper = screenFragmentWrapper;
    }

    public final ScreenContainer getContainer() {
        return this.container;
    }

    public final void setContainer(ScreenContainer screenContainer) {
        this.container = screenContainer;
    }

    public final ActivityState getActivityState() {
        return this.activityState;
    }

    public final StackPresentation getStackPresentation() {
        return this.stackPresentation;
    }

    public final void setStackPresentation(StackPresentation stackPresentation2) {
        Intrinsics.checkNotNullParameter(stackPresentation2, "<set-?>");
        this.stackPresentation = stackPresentation2;
    }

    public final ReplaceAnimation getReplaceAnimation() {
        return this.replaceAnimation;
    }

    public final void setReplaceAnimation(ReplaceAnimation replaceAnimation2) {
        Intrinsics.checkNotNullParameter(replaceAnimation2, "<set-?>");
        this.replaceAnimation = replaceAnimation2;
    }

    public final StackAnimation getStackAnimation() {
        return this.stackAnimation;
    }

    public final void setStackAnimation(StackAnimation stackAnimation2) {
        Intrinsics.checkNotNullParameter(stackAnimation2, "<set-?>");
        this.stackAnimation = stackAnimation2;
    }

    public final boolean isGestureEnabled() {
        return this.isGestureEnabled;
    }

    public final void setGestureEnabled(boolean z) {
        this.isGestureEnabled = z;
    }

    public final Integer getScreenOrientation() {
        return this.screenOrientation;
    }

    public final Boolean isStatusBarAnimated() {
        return this.isStatusBarAnimated;
    }

    public final void setStatusBarAnimated(Boolean bool) {
        this.isStatusBarAnimated = bool;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if ((this.container instanceof ScreenStack) && z) {
            Pair<Double, Double> calculateHeaderHeight = calculateHeaderHeight();
            updateScreenSizePaper(i3 - i, i4 - i2);
            notifyHeaderHeightChange(calculateHeaderHeight.getFirst().doubleValue() + calculateHeaderHeight.getSecond().doubleValue());
        }
    }

    private final void updateScreenSizePaper(int i, int i2) {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        reactContext.runOnNativeModulesQueueThread(new Screen$updateScreenSizePaper$1(reactContext, this, i, i2));
    }

    public final ScreenStackHeaderConfig getHeaderConfig() {
        View view;
        Iterator<View> it = ViewGroupKt.getChildren(this).iterator();
        while (true) {
            if (!it.hasNext()) {
                view = null;
                break;
            }
            view = it.next();
            if (view instanceof ScreenStackHeaderConfig) {
                break;
            }
        }
        if (view instanceof ScreenStackHeaderConfig) {
            return (ScreenStackHeaderConfig) view;
        }
        return null;
    }

    public final void setTransitioning(boolean z) {
        if (this.isTransitioning != z) {
            this.isTransitioning = z;
            boolean hasWebView = hasWebView(this);
            int i = 2;
            if (!hasWebView || getLayerType() == 2) {
                if (!z || hasWebView) {
                    i = 0;
                }
                super.setLayerType(i, (Paint) null);
            }
        }
    }

    private final boolean hasWebView(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof WebView) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && hasWebView((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    public final void setActivityState(ActivityState activityState2) {
        Intrinsics.checkNotNullParameter(activityState2, "activityState");
        if (activityState2 != this.activityState) {
            this.activityState = activityState2;
            ScreenContainer screenContainer = this.container;
            if (screenContainer != null) {
                screenContainer.notifyChildUpdate();
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setScreenOrientation(java.lang.String r2) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x0006
            r2 = 0
            r1.screenOrientation = r2
            return
        L_0x0006:
            com.swmansion.rnscreens.ScreenWindowTraits r0 = com.swmansion.rnscreens.ScreenWindowTraits.INSTANCE
            r0.applyDidSetOrientation$react_native_screens_release()
            int r0 = r2.hashCode()
            switch(r0) {
                case -1894896954: goto L_0x0072;
                case 96673: goto L_0x0062;
                case 729267099: goto L_0x0053;
                case 1430647483: goto L_0x0044;
                case 1651658175: goto L_0x0035;
                case 1730732811: goto L_0x0025;
                case 2118770584: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0082
        L_0x0014:
            java.lang.String r0 = "landscape_right"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x001e
            goto L_0x0082
        L_0x001e:
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0087
        L_0x0025:
            java.lang.String r0 = "landscape_left"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x002e
            goto L_0x0082
        L_0x002e:
            r2 = 8
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0087
        L_0x0035:
            java.lang.String r0 = "portrait_up"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x003e
            goto L_0x0082
        L_0x003e:
            r2 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0087
        L_0x0044:
            java.lang.String r0 = "landscape"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x004d
            goto L_0x0082
        L_0x004d:
            r2 = 6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0087
        L_0x0053:
            java.lang.String r0 = "portrait"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x005c
            goto L_0x0082
        L_0x005c:
            r2 = 7
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0087
        L_0x0062:
            java.lang.String r0 = "all"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x006b
            goto L_0x0082
        L_0x006b:
            r2 = 10
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0087
        L_0x0072:
            java.lang.String r0 = "portrait_down"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x007b
            goto L_0x0082
        L_0x007b:
            r2 = 9
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0087
        L_0x0082:
            r2 = -1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x0087:
            r1.screenOrientation = r2
            com.swmansion.rnscreens.ScreenFragmentWrapper r2 = r1.fragmentWrapper
            if (r2 == 0) goto L_0x0096
            com.swmansion.rnscreens.ScreenWindowTraits r0 = com.swmansion.rnscreens.ScreenWindowTraits.INSTANCE
            android.app.Activity r2 = r2.tryGetActivity()
            r0.setOrientation$react_native_screens_release(r1, r2)
        L_0x0096:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.Screen.setScreenOrientation(java.lang.String):void");
    }

    public final void changeAccessibilityMode(int i) {
        setImportantForAccessibility(i);
        ScreenStackHeaderConfig headerConfig = getHeaderConfig();
        CustomToolbar toolbar = headerConfig != null ? headerConfig.getToolbar() : null;
        if (toolbar != null) {
            toolbar.setImportantForAccessibility(i);
        }
    }

    public final String getStatusBarStyle() {
        return this.statusBarStyle;
    }

    public final void setStatusBarStyle(String str) {
        if (str != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetStatusBarAppearance$react_native_screens_release();
        }
        this.statusBarStyle = str;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setStyle$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity(), screenFragmentWrapper.tryGetContext());
        }
    }

    public final Boolean isStatusBarHidden() {
        return this.isStatusBarHidden;
    }

    public final void setStatusBarHidden(Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetStatusBarAppearance$react_native_screens_release();
        }
        this.isStatusBarHidden = bool;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setHidden$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity());
        }
    }

    public final Boolean isStatusBarTranslucent() {
        return this.isStatusBarTranslucent;
    }

    public final void setStatusBarTranslucent(Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetStatusBarAppearance$react_native_screens_release();
        }
        this.isStatusBarTranslucent = bool;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setTranslucent$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity(), screenFragmentWrapper.tryGetContext());
        }
    }

    public final Integer getStatusBarColor() {
        return this.statusBarColor;
    }

    public final void setStatusBarColor(Integer num) {
        if (num != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetStatusBarAppearance$react_native_screens_release();
        }
        this.statusBarColor = num;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setColor$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity(), screenFragmentWrapper.tryGetContext());
        }
    }

    public final Integer getNavigationBarColor() {
        return this.navigationBarColor;
    }

    public final void setNavigationBarColor(Integer num) {
        if (num != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetNavigationBarAppearance$react_native_screens_release();
        }
        this.navigationBarColor = num;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setNavigationBarColor$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity());
        }
    }

    public final Boolean isNavigationBarHidden() {
        return this.isNavigationBarHidden;
    }

    public final void setNavigationBarHidden(Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetNavigationBarAppearance$react_native_screens_release();
        }
        this.isNavigationBarHidden = bool;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setNavigationBarHidden$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity());
        }
    }

    public final boolean getNativeBackButtonDismissalEnabled() {
        return this.nativeBackButtonDismissalEnabled;
    }

    public final void setNativeBackButtonDismissalEnabled(boolean z) {
        this.nativeBackButtonDismissalEnabled = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.Pair<java.lang.Double, java.lang.Double> calculateHeaderHeight() {
        /*
            r11 = this;
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r1 = r11.getContext()
            android.content.res.Resources$Theme r1 = r1.getTheme()
            r2 = 16843499(0x10102eb, float:2.3695652E-38)
            r3 = 1
            boolean r1 = r1.resolveAttribute(r2, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r2 = r11.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2 = r0
            java.lang.Number r2 = (java.lang.Number) r2
            r2.intValue()
            r2 = 0
            if (r1 == 0) goto L_0x0054
            com.swmansion.rnscreens.ScreenStackHeaderConfig r1 = r11.getHeaderConfig()
            if (r1 == 0) goto L_0x003e
            boolean r1 = r1.isHeaderHidden()
            if (r1 != r3) goto L_0x003e
            r1 = r3
            goto L_0x003f
        L_0x003e:
            r1 = r2
        L_0x003f:
            if (r1 != 0) goto L_0x0054
            com.swmansion.rnscreens.ScreenStackHeaderConfig r1 = r11.getHeaderConfig()
            if (r1 == 0) goto L_0x004f
            boolean r1 = r1.isHeaderTranslucent()
            if (r1 != r3) goto L_0x004f
            r1 = r3
            goto L_0x0050
        L_0x004f:
            r1 = r2
        L_0x0050:
            if (r1 != 0) goto L_0x0054
            r1 = r3
            goto L_0x0055
        L_0x0054:
            r1 = r2
        L_0x0055:
            r4 = 0
            if (r1 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r0 = r4
        L_0x005a:
            r5 = 0
            if (r0 == 0) goto L_0x006b
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            float r0 = (float) r0
            float r0 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r0)
            double r0 = (double) r0
            goto L_0x006c
        L_0x006b:
            r0 = r5
        L_0x006c:
            android.content.Context r7 = r11.getContext()
            android.content.res.Resources r7 = r7.getResources()
            java.lang.String r8 = "status_bar_height"
            java.lang.String r9 = "dimen"
            java.lang.String r10 = "android"
            int r7 = r7.getIdentifier(r8, r9, r10)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r8 = r7
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            if (r8 <= 0) goto L_0x009c
            java.lang.Boolean r8 = r11.isStatusBarHidden
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r3)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 != 0) goto L_0x009c
            int r8 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r8 <= 0) goto L_0x009c
            goto L_0x009d
        L_0x009c:
            r3 = r2
        L_0x009d:
            if (r3 == 0) goto L_0x00a0
            r4 = r7
        L_0x00a0:
            if (r4 == 0) goto L_0x00ba
            java.lang.Number r4 = (java.lang.Number) r4
            int r2 = r4.intValue()
            android.content.Context r3 = r11.getContext()
            android.content.res.Resources r3 = r3.getResources()
            int r2 = r3.getDimensionPixelSize(r2)
            float r2 = (float) r2
            float r2 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r2)
            double r5 = (double) r2
        L_0x00ba:
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            java.lang.Double r1 = java.lang.Double.valueOf(r5)
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.Screen.calculateHeaderHeight():kotlin.Pair");
    }

    private final void notifyHeaderHeightChange(double d) {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        int surfaceId = UIManagerHelper.getSurfaceId((Context) reactContext);
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new HeaderHeightChangeEvent(surfaceId, getId(), d));
        }
    }
}
