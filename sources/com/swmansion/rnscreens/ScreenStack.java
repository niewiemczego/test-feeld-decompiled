package com.swmansion.rnscreens;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.events.StackFinishTransitioningEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 F2\u00020\u0001:\u0002FGB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001dH\u0014J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0007J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020(H\u0002J\b\u0010.\u001a\u00020(H\u0002J \u0010/\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0014J\u0010\u00104\u001a\u00020(2\u0006\u00105\u001a\u000201H\u0016J\u0012\u00106\u001a\u00020\u00122\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020(H\u0014J\f\u0010:\u001a\u00060\nR\u00020\u0000H\u0002J\b\u0010;\u001a\u00020(H\u0016J\u0006\u0010<\u001a\u00020(J\u0014\u0010=\u001a\u00020(2\n\u0010>\u001a\u00060\nR\u00020\u0000H\u0002J\b\u0010?\u001a\u00020(H\u0016J\u0010\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020\u0019H\u0016J\u0010\u0010B\u001a\u00020(2\u0006\u00105\u001a\u000201H\u0016J\u0010\u0010C\u001a\u00020(2\u0006\u00105\u001a\u000201H\u0016J\u0012\u0010D\u001a\u00020(2\b\u0010E\u001a\u0004\u0018\u000108H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\b\u0012\u00060\nR\u00020\u00000\tX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\b\u0012\u00060\nR\u00020\u00000\tX\u000e¢\u0006\u0002\n\u0000R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\rj\b\u0012\u0004\u0012\u00020\u0007`\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00070\rj\b\u0012\u0004\u0012\u00020\u0007`\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\u0004\u0018\u00010\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001fR\u0010\u0010#\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStack;", "Lcom/swmansion/rnscreens/ScreenContainer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dismissedWrappers", "", "Lcom/swmansion/rnscreens/ScreenStackFragmentWrapper;", "drawingOpPool", "", "Lcom/swmansion/rnscreens/ScreenStack$DrawingOp;", "drawingOps", "fragments", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getFragments", "()Ljava/util/ArrayList;", "goingForward", "", "getGoingForward", "()Z", "setGoingForward", "(Z)V", "isDetachingCurrentScreen", "previousChildrenCount", "", "removalTransitionStarted", "reverseLastTwoChildren", "rootScreen", "Lcom/swmansion/rnscreens/Screen;", "getRootScreen", "()Lcom/swmansion/rnscreens/Screen;", "stack", "topScreen", "getTopScreen", "topScreenWrapper", "adapt", "Lcom/swmansion/rnscreens/ScreenStackFragment;", "screen", "dismiss", "", "screenFragment", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchOnFinishTransitioning", "drawAndRelease", "drawChild", "child", "Landroid/view/View;", "drawingTime", "", "endViewTransition", "view", "hasScreen", "screenFragmentWrapper", "Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "notifyContainerUpdate", "obtainDrawingOp", "onUpdate", "onViewAppearTransitionEnd", "performDraw", "op", "removeAllScreens", "removeScreenAt", "index", "removeView", "startViewTransition", "turnOffA11yUnderTransparentScreen", "visibleBottom", "Companion", "DrawingOp", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ScreenStack.kt */
public final class ScreenStack extends ScreenContainer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Set<ScreenStackFragmentWrapper> dismissedWrappers = new HashSet();
    private final List<DrawingOp> drawingOpPool = new ArrayList();
    private List<DrawingOp> drawingOps = new ArrayList();
    private boolean goingForward;
    private boolean isDetachingCurrentScreen;
    private int previousChildrenCount;
    private boolean removalTransitionStarted;
    private boolean reverseLastTwoChildren;
    private final ArrayList<ScreenStackFragmentWrapper> stack = new ArrayList<>();
    private ScreenStackFragmentWrapper topScreenWrapper;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ScreenStack.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Screen.StackAnimation.values().length];
            iArr[Screen.StackAnimation.DEFAULT.ordinal()] = 1;
            iArr[Screen.StackAnimation.NONE.ordinal()] = 2;
            iArr[Screen.StackAnimation.FADE.ordinal()] = 3;
            iArr[Screen.StackAnimation.SLIDE_FROM_RIGHT.ordinal()] = 4;
            iArr[Screen.StackAnimation.SLIDE_FROM_LEFT.ordinal()] = 5;
            iArr[Screen.StackAnimation.SLIDE_FROM_BOTTOM.ordinal()] = 6;
            iArr[Screen.StackAnimation.FADE_FROM_BOTTOM.ordinal()] = 7;
            iArr[Screen.StackAnimation.IOS.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ScreenStack(Context context) {
        super(context);
    }

    public final boolean getGoingForward() {
        return this.goingForward;
    }

    public final void setGoingForward(boolean z) {
        this.goingForward = z;
    }

    public final void dismiss(ScreenStackFragmentWrapper screenStackFragmentWrapper) {
        Intrinsics.checkNotNullParameter(screenStackFragmentWrapper, "screenFragment");
        this.dismissedWrappers.add(screenStackFragmentWrapper);
        performUpdatesNow();
    }

    public Screen getTopScreen() {
        ScreenStackFragmentWrapper screenStackFragmentWrapper = this.topScreenWrapper;
        if (screenStackFragmentWrapper != null) {
            return screenStackFragmentWrapper.getScreen();
        }
        return null;
    }

    public final ArrayList<ScreenStackFragmentWrapper> getFragments() {
        return this.stack;
    }

    public final Screen getRootScreen() {
        int screenCount = getScreenCount();
        for (int i = 0; i < screenCount; i++) {
            ScreenFragmentWrapper screenFragmentWrapperAt = getScreenFragmentWrapperAt(i);
            if (!CollectionsKt.contains(this.dismissedWrappers, screenFragmentWrapperAt)) {
                return screenFragmentWrapperAt.getScreen();
            }
        }
        throw new IllegalStateException("Stack has no root screen set");
    }

    /* access modifiers changed from: protected */
    public ScreenStackFragment adapt(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        return new ScreenStackFragment(screen);
    }

    public void startViewTransition(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.startViewTransition(view);
        this.removalTransitionStarted = true;
    }

    public void endViewTransition(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.endViewTransition(view);
        if (this.removalTransitionStarted) {
            this.removalTransitionStarted = false;
            dispatchOnFinishTransitioning();
        }
    }

    public final void onViewAppearTransitionEnd() {
        if (!this.removalTransitionStarted) {
            dispatchOnFinishTransitioning();
        }
    }

    private final void dispatchOnFinishTransitioning() {
        int surfaceId = UIManagerHelper.getSurfaceId((View) this);
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new StackFinishTransitioningEvent(surfaceId, getId()));
        }
    }

    public void removeScreenAt(int i) {
        TypeIntrinsics.asMutableCollection(this.dismissedWrappers).remove(getScreenFragmentWrapperAt(i));
        super.removeScreenAt(i);
    }

    public void removeAllScreens() {
        this.dismissedWrappers.clear();
        super.removeAllScreens();
    }

    public boolean hasScreen(ScreenFragmentWrapper screenFragmentWrapper) {
        return super.hasScreen(screenFragmentWrapper) && !CollectionsKt.contains(this.dismissedWrappers, screenFragmentWrapper);
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01e9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x022b A[LOOP:4: B:119:0x0225->B:121:0x022b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x019d A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onUpdate() {
        /*
            r9 = this;
            r0 = 0
            r9.isDetachingCurrentScreen = r0
            java.util.ArrayList r1 = r9.screenWrappers
            int r1 = r1.size()
            int r1 = r1 + -1
            r2 = 0
            r3 = r2
            r4 = r3
            if (r1 < 0) goto L_0x0033
        L_0x0010:
            int r5 = r1 + -1
            com.swmansion.rnscreens.ScreenFragmentWrapper r1 = r9.getScreenFragmentWrapperAt(r1)
            java.util.Set<com.swmansion.rnscreens.ScreenStackFragmentWrapper> r6 = r9.dismissedWrappers
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            boolean r6 = kotlin.collections.CollectionsKt.contains(r6, r1)
            if (r6 != 0) goto L_0x002e
            if (r3 != 0) goto L_0x0024
            r3 = r1
            goto L_0x0025
        L_0x0024:
            r4 = r1
        L_0x0025:
            com.swmansion.rnscreens.ScreenStack$Companion r6 = Companion
            boolean r1 = r6.isTransparent(r1)
            if (r1 != 0) goto L_0x002e
            goto L_0x0033
        L_0x002e:
            if (r5 >= 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r1 = r5
            goto L_0x0010
        L_0x0033:
            java.util.ArrayList<com.swmansion.rnscreens.ScreenStackFragmentWrapper> r1 = r9.stack
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r1 = kotlin.collections.CollectionsKt.contains(r1, r3)
            r5 = 1
            if (r1 != 0) goto L_0x0089
            com.swmansion.rnscreens.ScreenStackFragmentWrapper r1 = r9.topScreenWrapper
            if (r1 == 0) goto L_0x0080
            if (r3 == 0) goto L_0x0080
            if (r1 == 0) goto L_0x0050
            java.util.ArrayList r6 = r9.screenWrappers
            boolean r1 = r6.contains(r1)
            if (r1 != r5) goto L_0x0050
            r1 = r5
            goto L_0x0051
        L_0x0050:
            r1 = r0
        L_0x0051:
            com.swmansion.rnscreens.Screen r6 = r3.getScreen()
            com.swmansion.rnscreens.Screen$ReplaceAnimation r6 = r6.getReplaceAnimation()
            com.swmansion.rnscreens.Screen$ReplaceAnimation r7 = com.swmansion.rnscreens.Screen.ReplaceAnimation.PUSH
            if (r6 != r7) goto L_0x005f
            r6 = r5
            goto L_0x0060
        L_0x005f:
            r6 = r0
        L_0x0060:
            if (r1 != 0) goto L_0x0067
            if (r6 == 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r1 = r0
            goto L_0x0068
        L_0x0067:
            r1 = r5
        L_0x0068:
            if (r1 == 0) goto L_0x0073
            com.swmansion.rnscreens.Screen r6 = r3.getScreen()
        L_0x006e:
            com.swmansion.rnscreens.Screen$StackAnimation r6 = r6.getStackAnimation()
            goto L_0x00a8
        L_0x0073:
            com.swmansion.rnscreens.ScreenStackFragmentWrapper r6 = r9.topScreenWrapper
            if (r6 == 0) goto L_0x007e
            com.swmansion.rnscreens.Screen r6 = r6.getScreen()
            if (r6 == 0) goto L_0x007e
            goto L_0x006e
        L_0x007e:
            r6 = r2
            goto L_0x00a8
        L_0x0080:
            if (r1 != 0) goto L_0x00a6
            if (r3 == 0) goto L_0x00a6
            com.swmansion.rnscreens.Screen$StackAnimation r6 = com.swmansion.rnscreens.Screen.StackAnimation.NONE
            r9.goingForward = r5
            goto L_0x00a7
        L_0x0089:
            com.swmansion.rnscreens.ScreenStackFragmentWrapper r1 = r9.topScreenWrapper
            if (r1 == 0) goto L_0x00a6
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 != 0) goto L_0x00a6
            com.swmansion.rnscreens.ScreenStackFragmentWrapper r1 = r9.topScreenWrapper
            if (r1 == 0) goto L_0x00a3
            com.swmansion.rnscreens.Screen r1 = r1.getScreen()
            if (r1 == 0) goto L_0x00a3
            com.swmansion.rnscreens.Screen$StackAnimation r1 = r1.getStackAnimation()
            r6 = r1
            goto L_0x00a4
        L_0x00a3:
            r6 = r2
        L_0x00a4:
            r1 = r0
            goto L_0x00a8
        L_0x00a6:
            r6 = r2
        L_0x00a7:
            r1 = r5
        L_0x00a8:
            androidx.fragment.app.FragmentTransaction r7 = r9.createTransaction()
            if (r6 == 0) goto L_0x014c
            if (r1 == 0) goto L_0x0101
            int[] r8 = com.swmansion.rnscreens.ScreenStack.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r8[r6]
            switch(r6) {
                case 1: goto L_0x00f9;
                case 2: goto L_0x00f1;
                case 3: goto L_0x00e9;
                case 4: goto L_0x00e1;
                case 5: goto L_0x00d8;
                case 6: goto L_0x00cf;
                case 7: goto L_0x00c6;
                case 8: goto L_0x00bd;
                default: goto L_0x00bb;
            }
        L_0x00bb:
            goto L_0x014c
        L_0x00bd:
            int r6 = com.swmansion.rnscreens.R.anim.rns_slide_in_from_right_ios
            int r8 = com.swmansion.rnscreens.R.anim.rns_slide_out_to_left_ios
            r7.setCustomAnimations(r6, r8)
            goto L_0x014c
        L_0x00c6:
            int r6 = com.swmansion.rnscreens.R.anim.rns_fade_from_bottom
            int r8 = com.swmansion.rnscreens.R.anim.rns_no_animation_350
            r7.setCustomAnimations(r6, r8)
            goto L_0x014c
        L_0x00cf:
            int r6 = com.swmansion.rnscreens.R.anim.rns_slide_in_from_bottom
            int r8 = com.swmansion.rnscreens.R.anim.rns_no_animation_medium
            r7.setCustomAnimations(r6, r8)
            goto L_0x014c
        L_0x00d8:
            int r6 = com.swmansion.rnscreens.R.anim.rns_slide_in_from_left
            int r8 = com.swmansion.rnscreens.R.anim.rns_slide_out_to_right
            r7.setCustomAnimations(r6, r8)
            goto L_0x014c
        L_0x00e1:
            int r6 = com.swmansion.rnscreens.R.anim.rns_slide_in_from_right
            int r8 = com.swmansion.rnscreens.R.anim.rns_slide_out_to_left
            r7.setCustomAnimations(r6, r8)
            goto L_0x014c
        L_0x00e9:
            int r6 = com.swmansion.rnscreens.R.anim.rns_fade_in
            int r8 = com.swmansion.rnscreens.R.anim.rns_fade_out
            r7.setCustomAnimations(r6, r8)
            goto L_0x014c
        L_0x00f1:
            int r6 = com.swmansion.rnscreens.R.anim.rns_no_animation_20
            int r8 = com.swmansion.rnscreens.R.anim.rns_no_animation_20
            r7.setCustomAnimations(r6, r8)
            goto L_0x014c
        L_0x00f9:
            int r6 = com.swmansion.rnscreens.R.anim.rns_default_enter_in
            int r8 = com.swmansion.rnscreens.R.anim.rns_default_enter_out
            r7.setCustomAnimations(r6, r8)
            goto L_0x014c
        L_0x0101:
            int[] r8 = com.swmansion.rnscreens.ScreenStack.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r8[r6]
            switch(r6) {
                case 1: goto L_0x0145;
                case 2: goto L_0x013d;
                case 3: goto L_0x0135;
                case 4: goto L_0x012d;
                case 5: goto L_0x0125;
                case 6: goto L_0x011d;
                case 7: goto L_0x0115;
                case 8: goto L_0x010d;
                default: goto L_0x010c;
            }
        L_0x010c:
            goto L_0x014c
        L_0x010d:
            int r6 = com.swmansion.rnscreens.R.anim.rns_slide_in_from_left_ios
            int r8 = com.swmansion.rnscreens.R.anim.rns_slide_out_to_right_ios
            r7.setCustomAnimations(r6, r8)
            goto L_0x014c
        L_0x0115:
            int r6 = com.swmansion.rnscreens.R.anim.rns_no_animation_250
            int r8 = com.swmansion.rnscreens.R.anim.rns_fade_to_bottom
            r7.setCustomAnimations(r6, r8)
            goto L_0x014c
        L_0x011d:
            int r6 = com.swmansion.rnscreens.R.anim.rns_no_animation_medium
            int r8 = com.swmansion.rnscreens.R.anim.rns_slide_out_to_bottom
            r7.setCustomAnimations(r6, r8)
            goto L_0x014c
        L_0x0125:
            int r6 = com.swmansion.rnscreens.R.anim.rns_slide_in_from_right
            int r8 = com.swmansion.rnscreens.R.anim.rns_slide_out_to_left
            r7.setCustomAnimations(r6, r8)
            goto L_0x014c
        L_0x012d:
            int r6 = com.swmansion.rnscreens.R.anim.rns_slide_in_from_left
            int r8 = com.swmansion.rnscreens.R.anim.rns_slide_out_to_right
            r7.setCustomAnimations(r6, r8)
            goto L_0x014c
        L_0x0135:
            int r6 = com.swmansion.rnscreens.R.anim.rns_fade_in
            int r8 = com.swmansion.rnscreens.R.anim.rns_fade_out
            r7.setCustomAnimations(r6, r8)
            goto L_0x014c
        L_0x013d:
            int r6 = com.swmansion.rnscreens.R.anim.rns_no_animation_20
            int r8 = com.swmansion.rnscreens.R.anim.rns_no_animation_20
            r7.setCustomAnimations(r6, r8)
            goto L_0x014c
        L_0x0145:
            int r6 = com.swmansion.rnscreens.R.anim.rns_default_exit_in
            int r8 = com.swmansion.rnscreens.R.anim.rns_default_exit_out
            r7.setCustomAnimations(r6, r8)
        L_0x014c:
            r9.goingForward = r1
            if (r1 == 0) goto L_0x015e
            if (r3 == 0) goto L_0x015e
            com.swmansion.rnscreens.ScreenStack$Companion r1 = Companion
            boolean r1 = r1.needsDrawReordering(r3)
            if (r1 == 0) goto L_0x015e
            if (r4 != 0) goto L_0x015e
            r9.isDetachingCurrentScreen = r5
        L_0x015e:
            java.util.ArrayList<com.swmansion.rnscreens.ScreenStackFragmentWrapper> r1 = r9.stack
            java.util.Iterator r1 = r1.iterator()
        L_0x0164:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0188
            java.lang.Object r6 = r1.next()
            com.swmansion.rnscreens.ScreenStackFragmentWrapper r6 = (com.swmansion.rnscreens.ScreenStackFragmentWrapper) r6
            java.util.ArrayList r8 = r9.screenWrappers
            boolean r8 = r8.contains(r6)
            if (r8 == 0) goto L_0x0180
            java.util.Set<com.swmansion.rnscreens.ScreenStackFragmentWrapper> r8 = r9.dismissedWrappers
            boolean r8 = r8.contains(r6)
            if (r8 == 0) goto L_0x0164
        L_0x0180:
            androidx.fragment.app.Fragment r6 = r6.getFragment()
            r7.remove(r6)
            goto L_0x0164
        L_0x0188:
            java.util.ArrayList r1 = r9.screenWrappers
            java.util.Iterator r1 = r1.iterator()
        L_0x018e:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x01b1
            java.lang.Object r6 = r1.next()
            com.swmansion.rnscreens.ScreenFragmentWrapper r6 = (com.swmansion.rnscreens.ScreenFragmentWrapper) r6
            if (r6 != r4) goto L_0x019d
            goto L_0x01b1
        L_0x019d:
            if (r6 == r3) goto L_0x018e
            java.util.Set<com.swmansion.rnscreens.ScreenStackFragmentWrapper> r8 = r9.dismissedWrappers
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            boolean r8 = kotlin.collections.CollectionsKt.contains(r8, r6)
            if (r8 != 0) goto L_0x018e
            androidx.fragment.app.Fragment r6 = r6.getFragment()
            r7.remove(r6)
            goto L_0x018e
        L_0x01b1:
            if (r4 == 0) goto L_0x01e9
            androidx.fragment.app.Fragment r1 = r4.getFragment()
            boolean r1 = r1.isAdded()
            if (r1 != 0) goto L_0x01e9
            java.util.ArrayList r1 = r9.screenWrappers
            java.util.Iterator r1 = r1.iterator()
        L_0x01c3:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0200
            java.lang.Object r6 = r1.next()
            com.swmansion.rnscreens.ScreenFragmentWrapper r6 = (com.swmansion.rnscreens.ScreenFragmentWrapper) r6
            if (r5 == 0) goto L_0x01d4
            if (r6 != r4) goto L_0x01c3
            r5 = r0
        L_0x01d4:
            int r8 = r9.getId()
            androidx.fragment.app.Fragment r6 = r6.getFragment()
            androidx.fragment.app.FragmentTransaction r6 = r7.add((int) r8, (androidx.fragment.app.Fragment) r6)
            com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda0 r8 = new com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda0
            r8.<init>(r3)
            r6.runOnCommit(r8)
            goto L_0x01c3
        L_0x01e9:
            if (r3 == 0) goto L_0x0200
            androidx.fragment.app.Fragment r0 = r3.getFragment()
            boolean r0 = r0.isAdded()
            if (r0 != 0) goto L_0x0200
            int r0 = r9.getId()
            androidx.fragment.app.Fragment r1 = r3.getFragment()
            r7.add((int) r0, (androidx.fragment.app.Fragment) r1)
        L_0x0200:
            boolean r0 = r3 instanceof com.swmansion.rnscreens.ScreenStackFragmentWrapper
            if (r0 == 0) goto L_0x0207
            r2 = r3
            com.swmansion.rnscreens.ScreenStackFragmentWrapper r2 = (com.swmansion.rnscreens.ScreenStackFragmentWrapper) r2
        L_0x0207:
            r9.topScreenWrapper = r2
            java.util.ArrayList<com.swmansion.rnscreens.ScreenStackFragmentWrapper> r0 = r9.stack
            r0.clear()
            java.util.ArrayList<com.swmansion.rnscreens.ScreenStackFragmentWrapper> r0 = r9.stack
            java.util.ArrayList r1 = r9.screenWrappers
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r3)
            r2.<init>(r3)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r1 = r1.iterator()
        L_0x0225:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x023c
            java.lang.Object r3 = r1.next()
            com.swmansion.rnscreens.ScreenFragmentWrapper r3 = (com.swmansion.rnscreens.ScreenFragmentWrapper) r3
            java.lang.String r5 = "null cannot be cast to non-null type com.swmansion.rnscreens.ScreenStackFragmentWrapper"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r5)
            com.swmansion.rnscreens.ScreenStackFragmentWrapper r3 = (com.swmansion.rnscreens.ScreenStackFragmentWrapper) r3
            r2.add(r3)
            goto L_0x0225
        L_0x023c:
            java.util.List r2 = (java.util.List) r2
            java.util.Collection r2 = (java.util.Collection) r2
            r0.addAll(r2)
            r9.turnOffA11yUnderTransparentScreen(r4)
            r7.commitNowAllowingStateLoss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenStack.onUpdate():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onUpdate$lambda-3$lambda-1  reason: not valid java name */
    public static final void m652onUpdate$lambda3$lambda1(ScreenFragmentWrapper screenFragmentWrapper) {
        Screen screen;
        if (screenFragmentWrapper != null && (screen = screenFragmentWrapper.getScreen()) != null) {
            screen.bringToFront();
        }
    }

    private final void turnOffA11yUnderTransparentScreen(ScreenFragmentWrapper screenFragmentWrapper) {
        ScreenStackFragmentWrapper screenStackFragmentWrapper;
        if (this.screenWrappers.size() > 1 && screenFragmentWrapper != null && (screenStackFragmentWrapper = this.topScreenWrapper) != null && Companion.isTransparent(screenStackFragmentWrapper)) {
            for (ScreenFragmentWrapper screenFragmentWrapper2 : CollectionsKt.asReversed(CollectionsKt.slice(this.screenWrappers, RangesKt.until(0, this.screenWrappers.size() - 1)))) {
                screenFragmentWrapper2.getScreen().changeAccessibilityMode(4);
                if (Intrinsics.areEqual((Object) screenFragmentWrapper2, (Object) screenFragmentWrapper)) {
                    break;
                }
            }
        }
        Screen topScreen = getTopScreen();
        if (topScreen != null) {
            topScreen.changeAccessibilityMode(0);
        }
    }

    /* access modifiers changed from: protected */
    public void notifyContainerUpdate() {
        for (ScreenStackFragmentWrapper onContainerUpdate : this.stack) {
            onContainerUpdate.onContainerUpdate();
        }
    }

    public void removeView(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        if (this.isDetachingCurrentScreen) {
            this.isDetachingCurrentScreen = false;
            this.reverseLastTwoChildren = true;
        }
        super.removeView(view);
    }

    private final void drawAndRelease() {
        List<DrawingOp> list = this.drawingOps;
        this.drawingOps = new ArrayList();
        for (DrawingOp next : list) {
            next.draw();
            this.drawingOpPool.add(next);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.drawingOps.size() < this.previousChildrenCount) {
            this.reverseLastTwoChildren = false;
        }
        this.previousChildrenCount = this.drawingOps.size();
        if (this.reverseLastTwoChildren && this.drawingOps.size() >= 2) {
            List<DrawingOp> list = this.drawingOps;
            Collections.swap(list, list.size() - 1, this.drawingOps.size() - 2);
        }
        drawAndRelease();
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(view, "child");
        List<DrawingOp> list = this.drawingOps;
        DrawingOp obtainDrawingOp = obtainDrawingOp();
        obtainDrawingOp.setCanvas(canvas);
        obtainDrawingOp.setChild(view);
        obtainDrawingOp.setDrawingTime(j);
        list.add(obtainDrawingOp);
        return true;
    }

    /* access modifiers changed from: private */
    public final void performDraw(DrawingOp drawingOp) {
        Canvas canvas = drawingOp.getCanvas();
        Intrinsics.checkNotNull(canvas);
        super.drawChild(canvas, drawingOp.getChild(), drawingOp.getDrawingTime());
    }

    private final DrawingOp obtainDrawingOp() {
        return this.drawingOpPool.isEmpty() ? new DrawingOp() : (DrawingOp) CollectionsKt.removeLast(this.drawingOpPool);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStack$DrawingOp;", "", "(Lcom/swmansion/rnscreens/ScreenStack;)V", "canvas", "Landroid/graphics/Canvas;", "getCanvas", "()Landroid/graphics/Canvas;", "setCanvas", "(Landroid/graphics/Canvas;)V", "child", "Landroid/view/View;", "getChild", "()Landroid/view/View;", "setChild", "(Landroid/view/View;)V", "drawingTime", "", "getDrawingTime", "()J", "setDrawingTime", "(J)V", "draw", "", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ScreenStack.kt */
    private final class DrawingOp {
        private Canvas canvas;
        private View child;
        private long drawingTime;

        public DrawingOp() {
        }

        public final Canvas getCanvas() {
            return this.canvas;
        }

        public final void setCanvas(Canvas canvas2) {
            this.canvas = canvas2;
        }

        public final View getChild() {
            return this.child;
        }

        public final void setChild(View view) {
            this.child = view;
        }

        public final long getDrawingTime() {
            return this.drawingTime;
        }

        public final void setDrawingTime(long j) {
            this.drawingTime = j;
        }

        public final void draw() {
            ScreenStack.this.performDraw(this);
            this.canvas = null;
            this.child = null;
            this.drawingTime = 0;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\b"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStack$Companion;", "", "()V", "isTransparent", "", "fragmentWrapper", "Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "needsDrawReordering", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ScreenStack.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean isTransparent(ScreenFragmentWrapper screenFragmentWrapper) {
            return screenFragmentWrapper.getScreen().getStackPresentation() == Screen.StackPresentation.TRANSPARENT_MODAL;
        }

        /* access modifiers changed from: private */
        public final boolean needsDrawReordering(ScreenFragmentWrapper screenFragmentWrapper) {
            return Build.VERSION.SDK_INT >= 33 || screenFragmentWrapper.getScreen().getStackAnimation() == Screen.StackAnimation.SLIDE_FROM_BOTTOM || screenFragmentWrapper.getScreen().getStackAnimation() == Screen.StackAnimation.FADE_FROM_BOTTOM || screenFragmentWrapper.getScreen().getStackAnimation() == Screen.StackAnimation.IOS;
        }
    }
}
