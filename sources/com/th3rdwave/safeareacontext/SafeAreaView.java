package com.th3rdwave.safeareacontext;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000bJ\u0010\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/th3rdwave/safeareacontext/SafeAreaView;", "Lcom/facebook/react/views/view/ReactViewGroup;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mEdges", "Lcom/th3rdwave/safeareacontext/SafeAreaViewEdges;", "mInsets", "Lcom/th3rdwave/safeareacontext/EdgeInsets;", "mMode", "Lcom/th3rdwave/safeareacontext/SafeAreaViewMode;", "mProviderView", "Landroid/view/View;", "mStateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "findProvider", "getStateWrapper", "maybeUpdateInsets", "", "onAttachedToWindow", "", "onDetachedFromWindow", "onPreDraw", "setEdges", "edges", "setMode", "mode", "setStateWrapper", "stateWrapper", "updateInsets", "waitForReactLayout", "react-native-safe-area-context_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SafeAreaView.kt */
public final class SafeAreaView extends ReactViewGroup implements ViewTreeObserver.OnPreDrawListener {
    private SafeAreaViewEdges mEdges;
    private EdgeInsets mInsets;
    private SafeAreaViewMode mMode = SafeAreaViewMode.PADDING;
    private View mProviderView;
    private StateWrapper mStateWrapper;

    public SafeAreaView(Context context) {
        super(context);
    }

    public final StateWrapper getStateWrapper() {
        return this.mStateWrapper;
    }

    public final void setStateWrapper(StateWrapper stateWrapper) {
        this.mStateWrapper = stateWrapper;
    }

    private final void updateInsets() {
        EdgeInsets edgeInsets = this.mInsets;
        if (edgeInsets != null) {
            SafeAreaViewEdges safeAreaViewEdges = this.mEdges;
            if (safeAreaViewEdges == null) {
                safeAreaViewEdges = new SafeAreaViewEdges(SafeAreaViewEdgeModes.ADDITIVE, SafeAreaViewEdgeModes.ADDITIVE, SafeAreaViewEdgeModes.ADDITIVE, SafeAreaViewEdgeModes.ADDITIVE);
            }
            StateWrapper stateWrapper = getStateWrapper();
            if (stateWrapper != null) {
                WritableMap createMap = Arguments.createMap();
                createMap.putMap("insets", SerializationUtilsKt.edgeInsetsToJsMap(edgeInsets));
                stateWrapper.updateState(createMap);
                return;
            }
            SafeAreaViewLocalData safeAreaViewLocalData = new SafeAreaViewLocalData(edgeInsets, this.mMode, safeAreaViewEdges);
            ReactContext reactContext = UIManagerHelperCompatKt.getReactContext(this);
            UIManagerModule uIManagerModule = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
            if (uIManagerModule != null) {
                uIManagerModule.setViewLocalData(getId(), safeAreaViewLocalData);
                reactContext.runOnNativeModulesQueueThread(new SafeAreaView$$ExternalSyntheticLambda0(uIManagerModule));
                waitForReactLayout();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateInsets$lambda-0  reason: not valid java name */
    public static final void m668updateInsets$lambda0(UIManagerModule uIManagerModule) {
        uIManagerModule.getUIImplementation().dispatchViewUpdates(-1);
    }

    private final void waitForReactLayout() {
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        long nanoTime = System.nanoTime();
        UIManagerHelperCompatKt.getReactContext(this).runOnNativeModulesQueueThread(new SafeAreaView$$ExternalSyntheticLambda1(reentrantLock, booleanRef, newCondition));
        Lock lock = reentrantLock;
        lock.lock();
        long j = 0;
        while (!booleanRef.element && j < 500000000) {
            try {
                newCondition.awaitNanos(500000000);
            } catch (InterruptedException unused) {
                booleanRef.element = true;
            } catch (Throwable th) {
                lock.unlock();
                throw th;
            }
            j += System.nanoTime() - nanoTime;
        }
        Unit unit = Unit.INSTANCE;
        lock.unlock();
        if (j >= 500000000) {
            Log.w("SafeAreaView", "Timed out waiting for layout.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: waitForReactLayout$lambda-2  reason: not valid java name */
    public static final void m669waitForReactLayout$lambda2(ReentrantLock reentrantLock, Ref.BooleanRef booleanRef, Condition condition) {
        Intrinsics.checkNotNullParameter(reentrantLock, "$lock");
        Intrinsics.checkNotNullParameter(booleanRef, "$done");
        Lock lock = reentrantLock;
        lock.lock();
        try {
            if (!booleanRef.element) {
                booleanRef.element = true;
                condition.signal();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    public final void setMode(SafeAreaViewMode safeAreaViewMode) {
        Intrinsics.checkNotNullParameter(safeAreaViewMode, "mode");
        this.mMode = safeAreaViewMode;
        updateInsets();
    }

    public final void setEdges(SafeAreaViewEdges safeAreaViewEdges) {
        Intrinsics.checkNotNullParameter(safeAreaViewEdges, "edges");
        this.mEdges = safeAreaViewEdges;
        updateInsets();
    }

    private final boolean maybeUpdateInsets() {
        EdgeInsets safeAreaInsets;
        View view = this.mProviderView;
        if (view == null || (safeAreaInsets = SafeAreaUtilsKt.getSafeAreaInsets(view)) == null || Intrinsics.areEqual((Object) this.mInsets, (Object) safeAreaInsets)) {
            return false;
        }
        this.mInsets = safeAreaInsets;
        updateInsets();
        return true;
    }

    private final View findProvider() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof SafeAreaProvider) {
                return (View) parent;
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        ViewTreeObserver viewTreeObserver;
        super.onAttachedToWindow();
        View findProvider = findProvider();
        this.mProviderView = findProvider;
        if (!(findProvider == null || (viewTreeObserver = findProvider.getViewTreeObserver()) == null)) {
            viewTreeObserver.addOnPreDrawListener(this);
        }
        maybeUpdateInsets();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewTreeObserver viewTreeObserver;
        super.onDetachedFromWindow();
        View view = this.mProviderView;
        if (!(view == null || (viewTreeObserver = view.getViewTreeObserver()) == null)) {
            viewTreeObserver.removeOnPreDrawListener(this);
        }
        this.mProviderView = null;
    }

    public boolean onPreDraw() {
        boolean maybeUpdateInsets = maybeUpdateInsets();
        if (maybeUpdateInsets) {
            requestLayout();
        }
        return !maybeUpdateInsets;
    }
}
