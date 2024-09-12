package com.swmansion.rnscreens;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.events.HeaderBackButtonClickedEvent;
import com.swmansion.rnscreens.events.ScreenAppearEvent;
import com.swmansion.rnscreens.events.ScreenDisappearEvent;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import com.swmansion.rnscreens.events.ScreenTransitionProgressEvent;
import com.swmansion.rnscreens.events.ScreenWillAppearEvent;
import com.swmansion.rnscreens.events.ScreenWillDisappearEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0003ABCB\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\fH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u001cH\u0016J\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0002H\u0016J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010%\u001a\u00020\u001cH\u0002J\b\u0010&\u001a\u00020\u001cH\u0002J\b\u0010'\u001a\u00020\u001cH\u0002J\b\u0010(\u001a\u00020\u001cH\u0002J\u0018\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\bH\u0016J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\bH\u0002J\b\u0010.\u001a\u00020\u001cH\u0016J&\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\b\u0010\u001d\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00106\u001a\u00020\u001cH\u0016J\b\u00107\u001a\u00020\u001cH\u0016J\b\u00108\u001a\u00020\u001cH\u0016J\b\u00109\u001a\u00020\u001cH\u0016J\u0010\u0010:\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\fH\u0016J\n\u0010;\u001a\u0004\u0018\u00010<H\u0016J\n\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0010\u0010?\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010@\u001a\u00020\u001cH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u00020\u0005X.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0006R\u000e\u0010\u0018\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/swmansion/rnscreens/ScreenFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "()V", "screenView", "Lcom/swmansion/rnscreens/Screen;", "(Lcom/swmansion/rnscreens/Screen;)V", "canDispatchAppear", "", "canDispatchWillAppear", "childScreenContainers", "", "Lcom/swmansion/rnscreens/ScreenContainer;", "getChildScreenContainers", "()Ljava/util/List;", "fragment", "getFragment", "()Landroidx/fragment/app/Fragment;", "isTransitioning", "screen", "getScreen$annotations", "getScreen", "()Lcom/swmansion/rnscreens/Screen;", "setScreen", "shouldUpdateOnResume", "transitionProgress", "", "addChildScreenContainer", "", "container", "canDispatchLifecycleEvent", "event", "Lcom/swmansion/rnscreens/ScreenFragment$ScreenLifecycleEvent;", "dispatchHeaderBackButtonClickedEvent", "dispatchLifecycleEvent", "fragmentWrapper", "dispatchLifecycleEventInChildContainers", "dispatchOnAppear", "dispatchOnDisappear", "dispatchOnWillAppear", "dispatchOnWillDisappear", "dispatchTransitionProgressEvent", "alpha", "closing", "dispatchViewAnimationEvent", "animationEnd", "onContainerUpdate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onViewAnimationEnd", "onViewAnimationStart", "removeChildScreenContainer", "tryGetActivity", "Landroid/app/Activity;", "tryGetContext", "Lcom/facebook/react/bridge/ReactContext;", "updateLastEventDispatched", "updateWindowTraits", "Companion", "ScreenLifecycleEvent", "ScreensFrameLayout", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ScreenFragment.kt */
public class ScreenFragment extends Fragment implements ScreenFragmentWrapper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private boolean canDispatchAppear = true;
    private boolean canDispatchWillAppear = true;
    private final List<ScreenContainer> childScreenContainers = new ArrayList();
    private boolean isTransitioning;
    public Screen screen;
    private boolean shouldUpdateOnResume;
    private float transitionProgress = -1.0f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/swmansion/rnscreens/ScreenFragment$ScreenLifecycleEvent;", "", "(Ljava/lang/String;I)V", "DID_APPEAR", "WILL_APPEAR", "DID_DISAPPEAR", "WILL_DISAPPEAR", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ScreenFragment.kt */
    public enum ScreenLifecycleEvent {
        DID_APPEAR,
        WILL_APPEAR,
        DID_DISAPPEAR,
        WILL_DISAPPEAR
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ScreenFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScreenLifecycleEvent.values().length];
            iArr[ScreenLifecycleEvent.WILL_APPEAR.ordinal()] = 1;
            iArr[ScreenLifecycleEvent.DID_APPEAR.ordinal()] = 2;
            iArr[ScreenLifecycleEvent.WILL_DISAPPEAR.ordinal()] = 3;
            iArr[ScreenLifecycleEvent.DID_DISAPPEAR.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getScreen$annotations() {
    }

    @JvmStatic
    protected static final View recycleView(View view) {
        return Companion.recycleView(view);
    }

    public Fragment getFragment() {
        return this;
    }

    public Screen getScreen() {
        Screen screen2 = this.screen;
        if (screen2 != null) {
            return screen2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("screen");
        return null;
    }

    public void setScreen(Screen screen2) {
        Intrinsics.checkNotNullParameter(screen2, "<set-?>");
        this.screen = screen2;
    }

    public List<ScreenContainer> getChildScreenContainers() {
        return this.childScreenContainers;
    }

    public ScreenFragment() {
        throw new IllegalStateException("Screen fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }

    public ScreenFragment(Screen screen2) {
        Intrinsics.checkNotNullParameter(screen2, "screenView");
        setScreen(screen2);
    }

    public void onResume() {
        super.onResume();
        if (this.shouldUpdateOnResume) {
            this.shouldUpdateOnResume = false;
            ScreenWindowTraits.INSTANCE.trySetWindowTraits$react_native_screens_release(getScreen(), tryGetActivity(), tryGetContext());
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ScreensFrameLayout screensFrameLayout;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        getScreen().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Context context = getContext();
        if (context != null) {
            screensFrameLayout = new ScreensFrameLayout(context);
            screensFrameLayout.addView(recycleView(getScreen()));
        } else {
            screensFrameLayout = null;
        }
        return screensFrameLayout;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/swmansion/rnscreens/ScreenFragment$ScreensFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clearFocus", "", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ScreenFragment.kt */
    private static final class ScreensFrameLayout extends FrameLayout {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ScreensFrameLayout(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        public void clearFocus() {
            if (getVisibility() != 4) {
                super.clearFocus();
            }
        }
    }

    public void onContainerUpdate() {
        updateWindowTraits();
    }

    private final void updateWindowTraits() {
        Activity activity = getActivity();
        if (activity == null) {
            this.shouldUpdateOnResume = true;
        } else {
            ScreenWindowTraits.INSTANCE.trySetWindowTraits$react_native_screens_release(getScreen(), activity, tryGetContext());
        }
    }

    public Activity tryGetActivity() {
        Fragment fragment;
        FragmentActivity activity;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            return activity2;
        }
        Context context = getScreen().getContext();
        if (context instanceof ReactContext) {
            ReactContext reactContext = (ReactContext) context;
            if (reactContext.getCurrentActivity() != null) {
                return reactContext.getCurrentActivity();
            }
        }
        for (ViewParent container = getScreen().getContainer(); container != null; container = container.getParent()) {
            if ((container instanceof Screen) && (fragment = ((Screen) container).getFragment()) != null && (activity = fragment.getActivity()) != null) {
                return activity;
            }
        }
        return null;
    }

    public ReactContext tryGetContext() {
        if (getContext() instanceof ReactContext) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            return (ReactContext) context;
        } else if (getScreen().getContext() instanceof ReactContext) {
            Context context2 = getScreen().getContext();
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            return (ReactContext) context2;
        } else {
            for (ViewParent container = getScreen().getContainer(); container != null; container = container.getParent()) {
                if (container instanceof Screen) {
                    Screen screen2 = (Screen) container;
                    if (screen2.getContext() instanceof ReactContext) {
                        Context context3 = screen2.getContext();
                        Intrinsics.checkNotNull(context3, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                        return (ReactContext) context3;
                    }
                }
            }
            return null;
        }
    }

    public boolean canDispatchLifecycleEvent(ScreenLifecycleEvent screenLifecycleEvent) {
        Intrinsics.checkNotNullParameter(screenLifecycleEvent, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[screenLifecycleEvent.ordinal()];
        if (i == 1) {
            return this.canDispatchWillAppear;
        }
        if (i == 2) {
            return this.canDispatchAppear;
        }
        if (i != 3) {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            } else if (this.canDispatchAppear) {
                return false;
            }
        } else if (this.canDispatchWillAppear) {
            return false;
        }
        return true;
    }

    public void updateLastEventDispatched(ScreenLifecycleEvent screenLifecycleEvent) {
        Intrinsics.checkNotNullParameter(screenLifecycleEvent, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[screenLifecycleEvent.ordinal()];
        if (i == 1) {
            this.canDispatchWillAppear = false;
        } else if (i == 2) {
            this.canDispatchAppear = false;
        } else if (i == 3) {
            this.canDispatchWillAppear = true;
        } else if (i == 4) {
            this.canDispatchAppear = true;
        }
    }

    private final void dispatchOnWillAppear() {
        dispatchLifecycleEvent(ScreenLifecycleEvent.WILL_APPEAR, this);
        dispatchTransitionProgressEvent(0.0f, false);
    }

    private final void dispatchOnAppear() {
        dispatchLifecycleEvent(ScreenLifecycleEvent.DID_APPEAR, this);
        dispatchTransitionProgressEvent(1.0f, false);
    }

    private final void dispatchOnWillDisappear() {
        dispatchLifecycleEvent(ScreenLifecycleEvent.WILL_DISAPPEAR, this);
        dispatchTransitionProgressEvent(0.0f, true);
    }

    private final void dispatchOnDisappear() {
        dispatchLifecycleEvent(ScreenLifecycleEvent.DID_DISAPPEAR, this);
        dispatchTransitionProgressEvent(1.0f, true);
    }

    public void dispatchLifecycleEvent(ScreenLifecycleEvent screenLifecycleEvent, ScreenFragmentWrapper screenFragmentWrapper) {
        Event event;
        Intrinsics.checkNotNullParameter(screenLifecycleEvent, "event");
        Intrinsics.checkNotNullParameter(screenFragmentWrapper, "fragmentWrapper");
        Fragment fragment = screenFragmentWrapper.getFragment();
        if (fragment instanceof ScreenStackFragment) {
            ScreenStackFragment screenStackFragment = (ScreenStackFragment) fragment;
            if (screenStackFragment.canDispatchLifecycleEvent(screenLifecycleEvent)) {
                Screen screen2 = screenStackFragment.getScreen();
                screenFragmentWrapper.updateLastEventDispatched(screenLifecycleEvent);
                int surfaceId = UIManagerHelper.getSurfaceId((View) screen2);
                int i = WhenMappings.$EnumSwitchMapping$0[screenLifecycleEvent.ordinal()];
                if (i == 1) {
                    event = new ScreenWillAppearEvent(surfaceId, screen2.getId());
                } else if (i == 2) {
                    event = new ScreenAppearEvent(surfaceId, screen2.getId());
                } else if (i == 3) {
                    event = new ScreenWillDisappearEvent(surfaceId, screen2.getId());
                } else if (i == 4) {
                    event = new ScreenDisappearEvent(surfaceId, screen2.getId());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                Context context = getScreen().getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, getScreen().getId());
                if (eventDispatcherForReactTag != null) {
                    eventDispatcherForReactTag.dispatchEvent(event);
                }
                screenFragmentWrapper.dispatchLifecycleEventInChildContainers(screenLifecycleEvent);
            }
        }
    }

    public void dispatchLifecycleEventInChildContainers(ScreenLifecycleEvent screenLifecycleEvent) {
        ScreenFragmentWrapper fragmentWrapper;
        Intrinsics.checkNotNullParameter(screenLifecycleEvent, "event");
        Collection arrayList = new ArrayList();
        for (Object next : getChildScreenContainers()) {
            if (((ScreenContainer) next).getScreenCount() > 0) {
                arrayList.add(next);
            }
        }
        for (ScreenContainer topScreen : (List) arrayList) {
            Screen topScreen2 = topScreen.getTopScreen();
            if (!(topScreen2 == null || (fragmentWrapper = topScreen2.getFragmentWrapper()) == null)) {
                dispatchLifecycleEvent(screenLifecycleEvent, fragmentWrapper);
            }
        }
    }

    public void dispatchHeaderBackButtonClickedEvent() {
        Context context = getScreen().getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        int surfaceId = UIManagerHelper.getSurfaceId((Context) reactContext);
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, getScreen().getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new HeaderBackButtonClickedEvent(surfaceId, getScreen().getId()));
        }
    }

    public void dispatchTransitionProgressEvent(float f, boolean z) {
        if (this instanceof ScreenStackFragment) {
            boolean z2 = false;
            if (!(this.transitionProgress == f)) {
                float max = Math.max(0.0f, Math.min(1.0f, f));
                this.transitionProgress = max;
                short coalescingKey = Companion.getCoalescingKey(max);
                ScreenContainer container = getScreen().getContainer();
                if (container instanceof ScreenStack) {
                    z2 = ((ScreenStack) container).getGoingForward();
                }
                boolean z3 = z2;
                Context context = getScreen().getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                ReactContext reactContext = (ReactContext) context;
                EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, getScreen().getId());
                if (eventDispatcherForReactTag != null) {
                    eventDispatcherForReactTag.dispatchEvent(new ScreenTransitionProgressEvent(UIManagerHelper.getSurfaceId((Context) reactContext), getScreen().getId(), this.transitionProgress, z, z3, coalescingKey));
                }
            }
        }
    }

    public void addChildScreenContainer(ScreenContainer screenContainer) {
        Intrinsics.checkNotNullParameter(screenContainer, TtmlNode.RUBY_CONTAINER);
        getChildScreenContainers().add(screenContainer);
    }

    public void removeChildScreenContainer(ScreenContainer screenContainer) {
        Intrinsics.checkNotNullParameter(screenContainer, TtmlNode.RUBY_CONTAINER);
        getChildScreenContainers().remove(screenContainer);
    }

    public void onViewAnimationStart() {
        dispatchViewAnimationEvent(false);
    }

    public void onViewAnimationEnd() {
        dispatchViewAnimationEvent(true);
    }

    private final void dispatchViewAnimationEvent(boolean z) {
        this.isTransitioning = !z;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (!(parentFragment instanceof ScreenFragment) || ((ScreenFragment) parentFragment).isTransitioning)) {
            return;
        }
        if (isResumed()) {
            UiThreadUtil.runOnUiThread(new ScreenFragment$$ExternalSyntheticLambda0(z, this));
        } else if (z) {
            dispatchOnDisappear();
        } else {
            dispatchOnWillDisappear();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dispatchViewAnimationEvent$lambda-8  reason: not valid java name */
    public static final void m651dispatchViewAnimationEvent$lambda8(boolean z, ScreenFragment screenFragment) {
        Intrinsics.checkNotNullParameter(screenFragment, "this$0");
        if (z) {
            screenFragment.dispatchOnAppear();
        } else {
            screenFragment.dispatchOnWillAppear();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ScreenContainer container = getScreen().getContainer();
        if (container == null || !container.hasScreen(this)) {
            Context context = getScreen().getContext();
            if (context instanceof ReactContext) {
                int surfaceId = UIManagerHelper.getSurfaceId(context);
                EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, getScreen().getId());
                if (eventDispatcherForReactTag != null) {
                    eventDispatcherForReactTag.dispatchEvent(new ScreenDismissedEvent(surfaceId, getScreen().getId()));
                }
            }
        }
        getChildScreenContainers().clear();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0005¨\u0006\n"}, d2 = {"Lcom/swmansion/rnscreens/ScreenFragment$Companion;", "", "()V", "getCoalescingKey", "", "progress", "", "recycleView", "Landroid/view/View;", "view", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ScreenFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final short getCoalescingKey(float f) {
            boolean z = false;
            int i = 1;
            if (!(f == 0.0f)) {
                if (f == 1.0f) {
                    z = true;
                }
                i = z ? 2 : 3;
            }
            return (short) i;
        }

        private Companion() {
        }

        /* access modifiers changed from: protected */
        @JvmStatic
        public final View recycleView(View view) {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            ViewParent parent = view.getParent();
            if (parent != null) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.endViewTransition(view);
                viewGroup.removeView(view);
            }
            view.setVisibility(0);
            return view;
        }
    }
}
