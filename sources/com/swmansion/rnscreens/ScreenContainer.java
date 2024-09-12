package com.swmansion.rnscreens;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0019H\u0014J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0012J\u0006\u0010!\u001a\u00020\u001fJ\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020$H\u0004J\u0006\u0010(\u001a\u00020\u001fJ\u0018\u0010)\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,H\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u0010H\u0002J\u000e\u00100\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0012J\u000e\u00101\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0012J\u0012\u00102\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010\u0010H\u0016J\u0006\u00103\u001a\u00020\u001fJ\b\u00104\u001a\u00020\u001fH\u0014J\u0006\u00105\u001a\u00020\u001fJ\b\u00106\u001a\u00020\u001fH\u0014J\b\u00107\u001a\u00020\u001fH\u0014J0\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u0012H\u0014J\u0018\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020\u0012H\u0014J\b\u0010A\u001a\u00020\u001fH\u0002J\b\u0010B\u001a\u00020\u001fH\u0016J\u0006\u0010C\u001a\u00020\u001fJ\b\u0010D\u001a\u00020\u001fH\u0004J\b\u0010E\u001a\u00020\u001fH\u0016J\u0010\u0010F\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010G\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0012H\u0016J\u0010\u0010H\u001a\u00020\u001f2\u0006\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020\u001fH\u0016J\u0010\u0010L\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\u0006H\u0002J\b\u0010N\u001a\u00020\u001fH\u0002R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0004@\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0016j\b\u0012\u0004\u0012\u00020\u0010`\u00178\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006O"}, d2 = {"Lcom/swmansion/rnscreens/ScreenContainer;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "isAttached", "", "isLayoutEnqueued", "isNested", "()Z", "layoutCallback", "Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;", "needsUpdate", "parentScreenWrapper", "Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "screenCount", "", "getScreenCount", "()I", "screenWrappers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "topScreen", "Lcom/swmansion/rnscreens/Screen;", "getTopScreen", "()Lcom/swmansion/rnscreens/Screen;", "adapt", "screen", "addScreen", "", "index", "attachBelowTop", "attachScreen", "transaction", "Landroidx/fragment/app/FragmentTransaction;", "fragment", "Landroidx/fragment/app/Fragment;", "createTransaction", "detachBelowTop", "detachScreen", "findFragmentManagerForReactRootView", "rootView", "Lcom/facebook/react/ReactRootView;", "getActivityState", "Lcom/swmansion/rnscreens/Screen$ActivityState;", "screenFragmentWrapper", "getScreenAt", "getScreenFragmentWrapperAt", "hasScreen", "notifyChildUpdate", "notifyContainerUpdate", "notifyTopDetached", "onAttachedToWindow", "onDetachedFromWindow", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onScreenChanged", "onUpdate", "performUpdates", "performUpdatesNow", "removeAllScreens", "removeMyFragments", "removeScreenAt", "removeView", "view", "Landroid/view/View;", "requestLayout", "setFragmentManager", "fm", "setupFragmentManager", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ScreenContainer.kt */
public class ScreenContainer extends ViewGroup {
    protected FragmentManager fragmentManager;
    private boolean isAttached;
    /* access modifiers changed from: private */
    public boolean isLayoutEnqueued;
    private final ChoreographerCompat.FrameCallback layoutCallback = new ScreenContainer$layoutCallback$1(this);
    private boolean needsUpdate;
    private ScreenFragmentWrapper parentScreenWrapper;
    protected final ArrayList<ScreenFragmentWrapper> screenWrappers = new ArrayList<>();

    public ScreenContainer(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).layout(0, 0, getWidth(), getHeight());
        }
    }

    public void removeView(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        if (view == getFocusedChild()) {
            Object systemService = getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(getWindowToken(), 2);
        }
        super.removeView(view);
    }

    public void requestLayout() {
        super.requestLayout();
        if (!this.isLayoutEnqueued && this.layoutCallback != null) {
            this.isLayoutEnqueued = true;
            ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.layoutCallback);
        }
    }

    public final boolean isNested() {
        return this.parentScreenWrapper != null;
    }

    public final void notifyChildUpdate() {
        performUpdatesNow();
    }

    /* access modifiers changed from: protected */
    public ScreenFragmentWrapper adapt(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        return new ScreenFragment(screen);
    }

    public final void addScreen(Screen screen, int i) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        ScreenFragmentWrapper adapt = adapt(screen);
        screen.setFragmentWrapper(adapt);
        this.screenWrappers.add(i, adapt);
        screen.setContainer(this);
        onScreenChanged();
    }

    public void removeScreenAt(int i) {
        this.screenWrappers.get(i).getScreen().setContainer((ScreenContainer) null);
        this.screenWrappers.remove(i);
        onScreenChanged();
    }

    public void removeAllScreens() {
        Iterator<ScreenFragmentWrapper> it = this.screenWrappers.iterator();
        while (it.hasNext()) {
            it.next().getScreen().setContainer((ScreenContainer) null);
        }
        this.screenWrappers.clear();
        onScreenChanged();
    }

    public final int getScreenCount() {
        return this.screenWrappers.size();
    }

    public final Screen getScreenAt(int i) {
        return this.screenWrappers.get(i).getScreen();
    }

    public final ScreenFragmentWrapper getScreenFragmentWrapperAt(int i) {
        ScreenFragmentWrapper screenFragmentWrapper = this.screenWrappers.get(i);
        Intrinsics.checkNotNullExpressionValue(screenFragmentWrapper, "screenWrappers[index]");
        return screenFragmentWrapper;
    }

    public Screen getTopScreen() {
        Object obj;
        boolean z;
        Iterator it = this.screenWrappers.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (getActivityState((ScreenFragmentWrapper) obj) == Screen.ActivityState.ON_TOP) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        ScreenFragmentWrapper screenFragmentWrapper = (ScreenFragmentWrapper) obj;
        if (screenFragmentWrapper != null) {
            return screenFragmentWrapper.getScreen();
        }
        return null;
    }

    private final void setFragmentManager(FragmentManager fragmentManager2) {
        this.fragmentManager = fragmentManager2;
        performUpdatesNow();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.fragment.app.FragmentManager findFragmentManagerForReactRootView(com.facebook.react.ReactRootView r4) {
        /*
            r3 = this;
            android.content.Context r0 = r4.getContext()
        L_0x0004:
            boolean r1 = r0 instanceof androidx.fragment.app.FragmentActivity
            if (r1 != 0) goto L_0x0013
            boolean r2 = r0 instanceof android.content.ContextWrapper
            if (r2 == 0) goto L_0x0013
            android.content.ContextWrapper r0 = (android.content.ContextWrapper) r0
            android.content.Context r0 = r0.getBaseContext()
            goto L_0x0004
        L_0x0013:
            if (r1 == 0) goto L_0x0044
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            androidx.fragment.app.FragmentManager r1 = r0.getSupportFragmentManager()
            java.util.List r1 = r1.getFragments()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x002f
            androidx.fragment.app.FragmentManager r4 = r0.getSupportFragmentManager()
            java.lang.String r0 = "{\n            // We are …FragmentManager\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            goto L_0x0043
        L_0x002f:
            android.view.View r4 = (android.view.View) r4     // Catch:{ IllegalStateException -> 0x003a }
            androidx.fragment.app.Fragment r4 = androidx.fragment.app.FragmentManager.findFragment(r4)     // Catch:{ IllegalStateException -> 0x003a }
            androidx.fragment.app.FragmentManager r4 = r4.getChildFragmentManager()     // Catch:{ IllegalStateException -> 0x003a }
            goto L_0x003e
        L_0x003a:
            androidx.fragment.app.FragmentManager r4 = r0.getSupportFragmentManager()
        L_0x003e:
            java.lang.String r0 = "{\n            // We are …r\n            }\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
        L_0x0043:
            return r4
        L_0x0044:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "In order to use RNScreens components your app's activity need to extend ReactActivity"
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenContainer.findFragmentManagerForReactRootView(com.facebook.react.ReactRootView):androidx.fragment.app.FragmentManager");
    }

    private final void setupFragmentManager() {
        boolean z;
        Unit unit;
        ViewParent viewParent = this;
        while (true) {
            z = viewParent instanceof ReactRootView;
            if (!z && !(viewParent instanceof Screen) && viewParent.getParent() != null) {
                viewParent = viewParent.getParent();
                Intrinsics.checkNotNullExpressionValue(viewParent, "parent.parent");
            }
        }
        if (viewParent instanceof Screen) {
            ScreenFragmentWrapper fragmentWrapper = ((Screen) viewParent).getFragmentWrapper();
            if (fragmentWrapper != null) {
                this.parentScreenWrapper = fragmentWrapper;
                fragmentWrapper.addChildScreenContainer(this);
                FragmentManager childFragmentManager = fragmentWrapper.getFragment().getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "fragmentWrapper.fragment.childFragmentManager");
                setFragmentManager(childFragmentManager);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                throw new IllegalStateException("Parent Screen does not have its Fragment attached".toString());
            }
        } else if (z) {
            setFragmentManager(findFragmentManagerForReactRootView((ReactRootView) viewParent));
        } else {
            throw new IllegalStateException("ScreenContainer is not attached under ReactRootView".toString());
        }
    }

    /* access modifiers changed from: protected */
    public final FragmentTransaction createTransaction() {
        FragmentManager fragmentManager2 = this.fragmentManager;
        if (fragmentManager2 != null) {
            FragmentTransaction reorderingAllowed = fragmentManager2.beginTransaction().setReorderingAllowed(true);
            Intrinsics.checkNotNullExpressionValue(reorderingAllowed, "requireNotNull(fragmentM…etReorderingAllowed(true)");
            return reorderingAllowed;
        }
        throw new IllegalArgumentException("fragment manager is null when creating transaction".toString());
    }

    private final void attachScreen(FragmentTransaction fragmentTransaction, Fragment fragment) {
        fragmentTransaction.add(getId(), fragment);
    }

    public final void attachBelowTop() {
        if (this.screenWrappers.size() >= 2) {
            FragmentTransaction createTransaction = createTransaction();
            Screen topScreen = getTopScreen();
            Intrinsics.checkNotNull(topScreen, "null cannot be cast to non-null type com.swmansion.rnscreens.Screen");
            Fragment fragment = topScreen.getFragment();
            Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            detachScreen(createTransaction, fragment);
            ArrayList<ScreenFragmentWrapper> arrayList = this.screenWrappers;
            attachScreen(createTransaction, arrayList.get(arrayList.size() - 2).getFragment());
            Fragment fragment2 = topScreen.getFragment();
            Intrinsics.checkNotNull(fragment2, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            attachScreen(createTransaction, fragment2);
            createTransaction.commitNowAllowingStateLoss();
            return;
        }
        throw new RuntimeException("[RNScreens] Unable to run transition for less than 2 screens.");
    }

    public final void detachBelowTop() {
        if (this.screenWrappers.size() >= 2) {
            FragmentTransaction createTransaction = createTransaction();
            ArrayList<ScreenFragmentWrapper> arrayList = this.screenWrappers;
            detachScreen(createTransaction, arrayList.get(arrayList.size() - 2).getFragment());
            createTransaction.commitNowAllowingStateLoss();
            return;
        }
        throw new RuntimeException("[RNScreens] Unable to run transition for less than 2 screens.");
    }

    public final void notifyTopDetached() {
        Screen topScreen = getTopScreen();
        Intrinsics.checkNotNull(topScreen, "null cannot be cast to non-null type com.swmansion.rnscreens.Screen");
        if (getContext() instanceof ReactContext) {
            int surfaceId = UIManagerHelper.getSurfaceId(getContext());
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, topScreen.getId());
            if (eventDispatcherForReactTag != null) {
                eventDispatcherForReactTag.dispatchEvent(new ScreenDismissedEvent(surfaceId, topScreen.getId()));
            }
        }
    }

    private final void detachScreen(FragmentTransaction fragmentTransaction, Fragment fragment) {
        fragmentTransaction.remove(fragment);
    }

    private final Screen.ActivityState getActivityState(ScreenFragmentWrapper screenFragmentWrapper) {
        return screenFragmentWrapper.getScreen().getActivityState();
    }

    public boolean hasScreen(ScreenFragmentWrapper screenFragmentWrapper) {
        return CollectionsKt.contains(this.screenWrappers, screenFragmentWrapper);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isAttached = true;
        setupFragmentManager();
    }

    private final void removeMyFragments(FragmentManager fragmentManager2) {
        FragmentTransaction beginTransaction = fragmentManager2.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
        boolean z = false;
        for (Fragment next : fragmentManager2.getFragments()) {
            if ((next instanceof ScreenFragment) && ((ScreenFragment) next).getScreen().getContainer() == this) {
                beginTransaction.remove(next);
                z = true;
            }
        }
        if (z) {
            beginTransaction.commitNowAllowingStateLoss();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        FragmentManager fragmentManager2 = this.fragmentManager;
        if (fragmentManager2 != null && !fragmentManager2.isDestroyed()) {
            removeMyFragments(fragmentManager2);
            fragmentManager2.executePendingTransactions();
        }
        ScreenFragmentWrapper screenFragmentWrapper = this.parentScreenWrapper;
        if (screenFragmentWrapper != null) {
            screenFragmentWrapper.removeChildScreenContainer(this);
        }
        this.parentScreenWrapper = null;
        super.onDetachedFromWindow();
        this.isAttached = false;
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 < childCount) {
                removeViewAt(childCount);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(i, i2);
        }
    }

    private final void onScreenChanged() {
        this.needsUpdate = true;
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        ((ThemedReactContext) context).getReactApplicationContext().runOnUiQueueThread(new ScreenContainer$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onScreenChanged$lambda-7  reason: not valid java name */
    public static final void m650onScreenChanged$lambda7(ScreenContainer screenContainer) {
        Intrinsics.checkNotNullParameter(screenContainer, "this$0");
        screenContainer.performUpdates();
    }

    /* access modifiers changed from: protected */
    public final void performUpdatesNow() {
        this.needsUpdate = true;
        performUpdates();
    }

    public final void performUpdates() {
        FragmentManager fragmentManager2;
        if (this.needsUpdate && this.isAttached && (fragmentManager2 = this.fragmentManager) != null) {
            boolean z = true;
            if (fragmentManager2 == null || !fragmentManager2.isDestroyed()) {
                z = false;
            }
            if (!z) {
                this.needsUpdate = false;
                onUpdate();
                notifyContainerUpdate();
            }
        }
    }

    public void onUpdate() {
        FragmentTransaction createTransaction = createTransaction();
        FragmentManager fragmentManager2 = this.fragmentManager;
        if (fragmentManager2 != null) {
            Set hashSet = new HashSet(fragmentManager2.getFragments());
            Iterator<ScreenFragmentWrapper> it = this.screenWrappers.iterator();
            while (it.hasNext()) {
                ScreenFragmentWrapper next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "fragmentWrapper");
                if (getActivityState(next) == Screen.ActivityState.INACTIVE && next.getFragment().isAdded()) {
                    detachScreen(createTransaction, next.getFragment());
                }
                hashSet.remove(next.getFragment());
            }
            Collection collection = hashSet;
            boolean z = false;
            if (!collection.isEmpty()) {
                Object[] array = collection.toArray(new Fragment[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                for (Fragment fragment : (Fragment[]) array) {
                    if ((fragment instanceof ScreenFragment) && ((ScreenFragment) fragment).getScreen().getContainer() == null) {
                        detachScreen(createTransaction, fragment);
                    }
                }
            }
            boolean z2 = getTopScreen() == null;
            ArrayList arrayList = new ArrayList();
            Iterator<ScreenFragmentWrapper> it2 = this.screenWrappers.iterator();
            while (it2.hasNext()) {
                ScreenFragmentWrapper next2 = it2.next();
                Intrinsics.checkNotNullExpressionValue(next2, "fragmentWrapper");
                Screen.ActivityState activityState = getActivityState(next2);
                if (activityState != Screen.ActivityState.INACTIVE && !next2.getFragment().isAdded()) {
                    attachScreen(createTransaction, next2.getFragment());
                    z = true;
                } else if (activityState != Screen.ActivityState.INACTIVE && z) {
                    detachScreen(createTransaction, next2.getFragment());
                    arrayList.add(next2);
                }
                next2.getScreen().setTransitioning(z2);
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                attachScreen(createTransaction, ((ScreenFragmentWrapper) it3.next()).getFragment());
            }
            createTransaction.commitNowAllowingStateLoss();
            return;
        }
        throw new IllegalArgumentException("fragment manager is null when performing update in ScreenContainer".toString());
    }

    /* access modifiers changed from: protected */
    public void notifyContainerUpdate() {
        ScreenFragmentWrapper fragmentWrapper;
        Screen topScreen = getTopScreen();
        if (topScreen != null && (fragmentWrapper = topScreen.getFragmentWrapper()) != null) {
            fragmentWrapper.onContainerUpdate();
        }
    }
}
