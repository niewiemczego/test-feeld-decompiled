package zendesk.core.android.internal.app;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import zendesk.core.android.internal.InternalZendeskApi;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\b¨\u0006\r"}, d2 = {"Lzendesk/core/android/internal/app/ProcessLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "_isInForeground", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isInForeground", "Lkotlinx/coroutines/flow/Flow;", "()Lkotlinx/coroutines/flow/Flow;", "onAppBackgrounded", "", "onAppForegrounded", "Companion", "zendesk.core_core-utilities"}, k = 1, mv = {1, 6, 0}, xi = 48)
@InternalZendeskApi
/* compiled from: ProcessLifecycleObserver.kt */
public final class ProcessLifecycleObserver implements LifecycleObserver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private MutableStateFlow<Boolean> _isInForeground = StateFlowKt.MutableStateFlow(false);

    public final Flow<Boolean> isInForeground() {
        return this._isInForeground;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onAppForegrounded() {
        this._isInForeground.setValue(true);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onAppBackgrounded() {
        this._isInForeground.setValue(false);
    }

    @InternalZendeskApi
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lzendesk/core/android/internal/app/ProcessLifecycleObserver$Companion;", "", "()V", "newInstance", "Lzendesk/core/android/internal/app/ProcessLifecycleObserver;", "processLifeCycleOwnerCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "zendesk.core_core-utilities"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProcessLifecycleObserver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ProcessLifecycleObserver newInstance() {
            ProcessLifecycleObserver processLifecycleObserver = new ProcessLifecycleObserver();
            ProcessLifecycleOwner.get().getLifecycle().addObserver(processLifecycleObserver);
            return processLifecycleObserver;
        }

        public final CoroutineScope processLifeCycleOwnerCoroutineScope() {
            LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.get();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "get()");
            return LifecycleOwnerKt.getLifecycleScope(lifecycleOwner);
        }
    }
}
