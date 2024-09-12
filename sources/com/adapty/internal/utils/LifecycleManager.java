package com.adapty.internal.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\f\u001a\u00020\nH\u0002J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eJ\b\u0010\u000f\u001a\u00020\nH\u0007J\b\u0010\u0010\u001a\u00020\nH\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/adapty/internal/utils/LifecycleManager;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "isActivateAllowed", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isFirstStart", "stateCallback", "Lcom/adapty/internal/utils/LifecycleManager$StateCallback;", "allowActivate", "", "init", "initInternal", "onActivateAllowed", "Lkotlinx/coroutines/flow/Flow;", "onStart", "onStop", "StateCallback", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LifecycleManager.kt */
public final class LifecycleManager implements LifecycleObserver {
    private final MutableStateFlow<Boolean> isActivateAllowed = StateFlowKt.MutableStateFlow(false);
    private boolean isFirstStart = true;
    public /* synthetic */ StateCallback stateCallback;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/adapty/internal/utils/LifecycleManager$StateCallback;", "", "onGoBackground", "", "onGoForeground", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LifecycleManager.kt */
    public interface StateCallback {
        void onGoBackground();

        void onGoForeground();
    }

    public final /* synthetic */ void init() {
        if (Intrinsics.areEqual((Object) Thread.currentThread(), (Object) Looper.getMainLooper().getThread())) {
            initInternal();
        } else {
            new Handler(Looper.getMainLooper()).post(new LifecycleManager$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void init$lambda$0(LifecycleManager lifecycleManager) {
        Intrinsics.checkNotNullParameter(lifecycleManager, "this$0");
        lifecycleManager.initInternal();
    }

    private final void initInternal() {
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
        if (ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            allowActivate();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final /* synthetic */ void onStart() {
        if (this.isFirstStart) {
            allowActivate();
            this.isFirstStart = false;
        }
        StateCallback stateCallback2 = this.stateCallback;
        if (stateCallback2 != null) {
            stateCallback2.onGoForeground();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final /* synthetic */ void onStop() {
        StateCallback stateCallback2 = this.stateCallback;
        if (stateCallback2 != null) {
            stateCallback2.onGoBackground();
        }
    }

    public final /* synthetic */ Flow onActivateAllowed() {
        return FlowKt.take(new LifecycleManager$onActivateAllowed$$inlined$filter$1(this.isActivateAllowed), 1);
    }

    private final void allowActivate() {
        this.isActivateAllowed.setValue(true);
    }
}
