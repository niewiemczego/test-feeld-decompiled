package com.swmansion.rnscreens;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSScreenManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenManagerInterface;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.events.HeaderBackButtonClickedEvent;
import com.swmansion.rnscreens.events.HeaderHeightChangeEvent;
import com.swmansion.rnscreens.events.ScreenAppearEvent;
import com.swmansion.rnscreens.events.ScreenDisappearEvent;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import com.swmansion.rnscreens.events.ScreenTransitionProgressEvent;
import com.swmansion.rnscreens.events.ScreenWillAppearEvent;
import com.swmansion.rnscreens.events.ScreenWillDisappearEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 E2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001EB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0014J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0014J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0015H\u0007J\u001a\u0010\u0016\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0018H\u0017J\u001c\u0010\u001c\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u001f\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0018H\u0017J\u001f\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\u0015H\u0017¢\u0006\u0002\u0010$J\u0018\u0010%\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0018H\u0017J\u001a\u0010'\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010(\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010\rH\u0017J\u001a\u0010*\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010\rH\u0017J\u001a\u0010,\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010-\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u001a\u0010.\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010/\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u00100\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u00101\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010\rH\u0017J\u001a\u00102\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u00010\rH\u0017J\u001a\u00104\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u00010\rH\u0017J\u001f\u00106\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u00107\u001a\u0004\u0018\u00010\u0015H\u0017¢\u0006\u0002\u0010$J\u0018\u00108\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u0018H\u0017J\u001a\u0010:\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010;\u001a\u0004\u0018\u00010\rH\u0017J\u0018\u0010<\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0018H\u0017J\u001c\u0010>\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010?\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J&\u0010@\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/swmansion/rnscreens/ScreenViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/Screen;", "Lcom/facebook/react/viewmanagers/RNSScreenManagerInterface;", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getDelegate", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "setActivityState", "", "view", "activityState", "", "", "setCustomAnimationOnSwipe", "value", "", "setFullScreenSwipeEnabled", "setGestureEnabled", "gestureEnabled", "setGestureResponseDistance", "Lcom/facebook/react/bridge/ReadableMap;", "setHideKeyboardOnSwipe", "setHomeIndicatorHidden", "setNativeBackButtonDismissalEnabled", "nativeBackButtonDismissalEnabled", "setNavigationBarColor", "navigationBarColor", "(Lcom/swmansion/rnscreens/Screen;Ljava/lang/Integer;)V", "setNavigationBarHidden", "navigationBarHidden", "setPreventNativeDismiss", "setReplaceAnimation", "animation", "setScreenOrientation", "screenOrientation", "setSheetAllowedDetents", "setSheetCornerRadius", "setSheetExpandsWhenScrolledToEdge", "setSheetGrabberVisible", "setSheetLargestUndimmedDetent", "setStackAnimation", "setStackPresentation", "presentation", "setStatusBarAnimation", "statusBarAnimation", "setStatusBarColor", "statusBarColor", "setStatusBarHidden", "statusBarHidden", "setStatusBarStyle", "statusBarStyle", "setStatusBarTranslucent", "statusBarTranslucent", "setSwipeDirection", "setTransitionDuration", "updateState", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "Companion", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ReactModule(name = "RNSScreen")
/* compiled from: ScreenViewManager.kt */
public class ScreenViewManager extends ViewGroupManager<Screen> implements RNSScreenManagerInterface<Screen> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNSScreen";
    private final ViewManagerDelegate<Screen> delegate = new RNSScreenManagerDelegate(this);

    public String getName() {
        return REACT_CLASS;
    }

    public void setCustomAnimationOnSwipe(Screen screen, boolean z) {
    }

    public void setFullScreenSwipeEnabled(Screen screen, boolean z) {
    }

    public void setGestureResponseDistance(Screen screen, ReadableMap readableMap) {
    }

    public void setHideKeyboardOnSwipe(Screen screen, boolean z) {
    }

    public void setHomeIndicatorHidden(Screen screen, boolean z) {
    }

    public void setPreventNativeDismiss(Screen screen, boolean z) {
    }

    public void setSheetAllowedDetents(Screen screen, String str) {
        Intrinsics.checkNotNullParameter(screen, ViewHierarchyConstants.VIEW_KEY);
    }

    public void setSheetCornerRadius(Screen screen, float f) {
    }

    public void setSheetExpandsWhenScrolledToEdge(Screen screen, boolean z) {
    }

    public void setSheetGrabberVisible(Screen screen, boolean z) {
    }

    public void setSheetLargestUndimmedDetent(Screen screen, String str) {
        Intrinsics.checkNotNullParameter(screen, ViewHierarchyConstants.VIEW_KEY);
    }

    public void setSwipeDirection(Screen screen, String str) {
    }

    public void setTransitionDuration(Screen screen, int i) {
    }

    /* access modifiers changed from: protected */
    public Screen createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        return new Screen(themedReactContext);
    }

    public void setActivityState(Screen screen, float f) {
        Intrinsics.checkNotNullParameter(screen, ViewHierarchyConstants.VIEW_KEY);
        setActivityState(screen, (int) f);
    }

    public Object updateState(Screen screen, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(screen, ViewHierarchyConstants.VIEW_KEY);
        return super.updateState(screen, reactStylesDiffMap, stateWrapper);
    }

    @ReactProp(name = "activityState")
    public final void setActivityState(Screen screen, int i) {
        Intrinsics.checkNotNullParameter(screen, ViewHierarchyConstants.VIEW_KEY);
        if (i != -1) {
            if (i == 0) {
                screen.setActivityState(Screen.ActivityState.INACTIVE);
            } else if (i == 1) {
                screen.setActivityState(Screen.ActivityState.TRANSITIONING_OR_BELOW_TOP);
            } else if (i == 2) {
                screen.setActivityState(Screen.ActivityState.ON_TOP);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (r4.equals("containedModal") != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r4.equals("modal") != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r4 = com.swmansion.rnscreens.Screen.StackPresentation.MODAL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r4.equals("transparentModal") != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        r4 = com.swmansion.rnscreens.Screen.StackPresentation.TRANSPARENT_MODAL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
        r3.setStackPresentation(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r4.equals("formSheet") != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (r4.equals("fullScreenModal") != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
        if (r4.equals("containedTransparentModal") != false) goto L_0x0051;
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "stackPresentation")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setStackPresentation(com.swmansion.rnscreens.Screen r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            if (r4 == 0) goto L_0x0057
            int r0 = r4.hashCode()
            switch(r0) {
                case -76271493: goto L_0x0049;
                case 3452698: goto L_0x003e;
                case 104069805: goto L_0x0033;
                case 438078970: goto L_0x002a;
                case 955284238: goto L_0x0021;
                case 1171936146: goto L_0x0018;
                case 1798290171: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0057
        L_0x000f:
            java.lang.String r0 = "formSheet"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
            goto L_0x003b
        L_0x0018:
            java.lang.String r0 = "fullScreenModal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
            goto L_0x003b
        L_0x0021:
            java.lang.String r0 = "containedTransparentModal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
            goto L_0x0051
        L_0x002a:
            java.lang.String r0 = "containedModal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
            goto L_0x003b
        L_0x0033:
            java.lang.String r0 = "modal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
        L_0x003b:
            com.swmansion.rnscreens.Screen$StackPresentation r4 = com.swmansion.rnscreens.Screen.StackPresentation.MODAL
            goto L_0x0053
        L_0x003e:
            java.lang.String r0 = "push"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
            com.swmansion.rnscreens.Screen$StackPresentation r4 = com.swmansion.rnscreens.Screen.StackPresentation.PUSH
            goto L_0x0053
        L_0x0049:
            java.lang.String r0 = "transparentModal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
        L_0x0051:
            com.swmansion.rnscreens.Screen$StackPresentation r4 = com.swmansion.rnscreens.Screen.StackPresentation.TRANSPARENT_MODAL
        L_0x0053:
            r3.setStackPresentation(r4)
            return
        L_0x0057:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r3 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown presentation type "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r4 = r0.append(r4)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenViewManager.setStackPresentation(com.swmansion.rnscreens.Screen, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (r4.equals("flip") != false) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0077, code lost:
        if (r4.equals("simple_push") != false) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0092, code lost:
        throw new com.facebook.react.bridge.JSApplicationIllegalArgumentException("Unknown animation type " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (r4.equals(com.facebook.hermes.intl.Constants.COLLATION_DEFAULT) != false) goto L_0x0093;
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "stackAnimation")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setStackAnimation(com.swmansion.rnscreens.Screen r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            if (r4 == 0) goto L_0x0093
            int r0 = r4.hashCode()
            switch(r0) {
                case -1418955385: goto L_0x0071;
                case -427095442: goto L_0x0066;
                case -349395819: goto L_0x005b;
                case 104461: goto L_0x0050;
                case 3135100: goto L_0x0045;
                case 3145837: goto L_0x003c;
                case 3387192: goto L_0x0031;
                case 182437661: goto L_0x0026;
                case 1544803905: goto L_0x001c;
                case 1601504978: goto L_0x0010;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x007a
        L_0x0010:
            java.lang.String r0 = "slide_from_bottom"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x007a
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.SLIDE_FROM_BOTTOM
            goto L_0x0095
        L_0x001c:
            java.lang.String r0 = "default"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x007a
            goto L_0x0093
        L_0x0026:
            java.lang.String r0 = "fade_from_bottom"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x007a
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.FADE_FROM_BOTTOM
            goto L_0x0095
        L_0x0031:
            java.lang.String r0 = "none"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x007a
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.NONE
            goto L_0x0095
        L_0x003c:
            java.lang.String r0 = "flip"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x007a
            goto L_0x0093
        L_0x0045:
            java.lang.String r0 = "fade"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x007a
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.FADE
            goto L_0x0095
        L_0x0050:
            java.lang.String r0 = "ios"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x007a
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.IOS
            goto L_0x0095
        L_0x005b:
            java.lang.String r0 = "slide_from_right"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x007a
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.SLIDE_FROM_RIGHT
            goto L_0x0095
        L_0x0066:
            java.lang.String r0 = "slide_from_left"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x007a
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.SLIDE_FROM_LEFT
            goto L_0x0095
        L_0x0071:
            java.lang.String r0 = "simple_push"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x007a
            goto L_0x0093
        L_0x007a:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r3 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown animation type "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r4 = r0.append(r4)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L_0x0093:
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.DEFAULT
        L_0x0095:
            r3.setStackAnimation(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenViewManager.setStackAnimation(com.swmansion.rnscreens.Screen, java.lang.String):void");
    }

    @ReactProp(defaultBoolean = true, name = "gestureEnabled")
    public void setGestureEnabled(Screen screen, boolean z) {
        Intrinsics.checkNotNullParameter(screen, ViewHierarchyConstants.VIEW_KEY);
        screen.setGestureEnabled(z);
    }

    @ReactProp(name = "replaceAnimation")
    public void setReplaceAnimation(Screen screen, String str) {
        Screen.ReplaceAnimation replaceAnimation;
        Intrinsics.checkNotNullParameter(screen, ViewHierarchyConstants.VIEW_KEY);
        if (str == null ? true : Intrinsics.areEqual((Object) str, (Object) "pop")) {
            replaceAnimation = Screen.ReplaceAnimation.POP;
        } else if (Intrinsics.areEqual((Object) str, (Object) "push")) {
            replaceAnimation = Screen.ReplaceAnimation.PUSH;
        } else {
            throw new JSApplicationIllegalArgumentException("Unknown replace animation type " + str);
        }
        screen.setReplaceAnimation(replaceAnimation);
    }

    @ReactProp(name = "screenOrientation")
    public void setScreenOrientation(Screen screen, String str) {
        Intrinsics.checkNotNullParameter(screen, ViewHierarchyConstants.VIEW_KEY);
        screen.setScreenOrientation(str);
    }

    @ReactProp(name = "statusBarAnimation")
    public void setStatusBarAnimation(Screen screen, String str) {
        Intrinsics.checkNotNullParameter(screen, ViewHierarchyConstants.VIEW_KEY);
        screen.setStatusBarAnimated(Boolean.valueOf(str != null && !Intrinsics.areEqual((Object) "none", (Object) str)));
    }

    @ReactProp(customType = "Color", name = "statusBarColor")
    public void setStatusBarColor(Screen screen, Integer num) {
        Intrinsics.checkNotNullParameter(screen, ViewHierarchyConstants.VIEW_KEY);
        screen.setStatusBarColor(num);
    }

    @ReactProp(name = "statusBarStyle")
    public void setStatusBarStyle(Screen screen, String str) {
        Intrinsics.checkNotNullParameter(screen, ViewHierarchyConstants.VIEW_KEY);
        screen.setStatusBarStyle(str);
    }

    @ReactProp(name = "statusBarTranslucent")
    public void setStatusBarTranslucent(Screen screen, boolean z) {
        Intrinsics.checkNotNullParameter(screen, ViewHierarchyConstants.VIEW_KEY);
        screen.setStatusBarTranslucent(Boolean.valueOf(z));
    }

    @ReactProp(name = "statusBarHidden")
    public void setStatusBarHidden(Screen screen, boolean z) {
        Intrinsics.checkNotNullParameter(screen, ViewHierarchyConstants.VIEW_KEY);
        screen.setStatusBarHidden(Boolean.valueOf(z));
    }

    @ReactProp(customType = "Color", name = "navigationBarColor")
    public void setNavigationBarColor(Screen screen, Integer num) {
        Intrinsics.checkNotNullParameter(screen, ViewHierarchyConstants.VIEW_KEY);
        screen.setNavigationBarColor(num);
    }

    @ReactProp(name = "navigationBarHidden")
    public void setNavigationBarHidden(Screen screen, boolean z) {
        Intrinsics.checkNotNullParameter(screen, ViewHierarchyConstants.VIEW_KEY);
        screen.setNavigationBarHidden(Boolean.valueOf(z));
    }

    @ReactProp(name = "nativeBackButtonDismissalEnabled")
    public void setNativeBackButtonDismissalEnabled(Screen screen, boolean z) {
        Intrinsics.checkNotNullParameter(screen, ViewHierarchyConstants.VIEW_KEY);
        screen.setNativeBackButtonDismissalEnabled(z);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapsKt.mutableMapOf(TuplesKt.to(ScreenDismissedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onDismissed")), TuplesKt.to(ScreenWillAppearEvent.EVENT_NAME, MapBuilder.of("registrationName", "onWillAppear")), TuplesKt.to(ScreenAppearEvent.EVENT_NAME, MapBuilder.of("registrationName", "onAppear")), TuplesKt.to(ScreenWillDisappearEvent.EVENT_NAME, MapBuilder.of("registrationName", "onWillDisappear")), TuplesKt.to(ScreenDisappearEvent.EVENT_NAME, MapBuilder.of("registrationName", "onDisappear")), TuplesKt.to(HeaderHeightChangeEvent.EVENT_NAME, MapBuilder.of("registrationName", "onHeaderHeightChange")), TuplesKt.to(HeaderBackButtonClickedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onHeaderBackButtonClicked")), TuplesKt.to(ScreenTransitionProgressEvent.EVENT_NAME, MapBuilder.of("registrationName", "onTransitionProgress")));
    }

    /* access modifiers changed from: protected */
    public ViewManagerDelegate<Screen> getDelegate() {
        return this.delegate;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/swmansion/rnscreens/ScreenViewManager$Companion;", "", "()V", "REACT_CLASS", "", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ScreenViewManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
