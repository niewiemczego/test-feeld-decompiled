package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u00109\u001a\u00020:R\u0016\u0010\r\u001a\n \u000e*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010/\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u00103\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u0011\u00105\u001a\u000206¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u0006;"}, d2 = {"Landroidx/room/MultiInstanceInvalidationClient;", "", "context", "Landroid/content/Context;", "name", "", "serviceIntent", "Landroid/content/Intent;", "invalidationTracker", "Landroidx/room/InvalidationTracker;", "executor", "Ljava/util/concurrent/Executor;", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroidx/room/InvalidationTracker;Ljava/util/concurrent/Executor;)V", "appContext", "kotlin.jvm.PlatformType", "callback", "Landroidx/room/IMultiInstanceInvalidationCallback;", "getCallback", "()Landroidx/room/IMultiInstanceInvalidationCallback;", "clientId", "", "getClientId", "()I", "setClientId", "(I)V", "getExecutor", "()Ljava/util/concurrent/Executor;", "getInvalidationTracker", "()Landroidx/room/InvalidationTracker;", "getName", "()Ljava/lang/String;", "observer", "Landroidx/room/InvalidationTracker$Observer;", "getObserver", "()Landroidx/room/InvalidationTracker$Observer;", "setObserver", "(Landroidx/room/InvalidationTracker$Observer;)V", "removeObserverRunnable", "Ljava/lang/Runnable;", "getRemoveObserverRunnable", "()Ljava/lang/Runnable;", "service", "Landroidx/room/IMultiInstanceInvalidationService;", "getService", "()Landroidx/room/IMultiInstanceInvalidationService;", "setService", "(Landroidx/room/IMultiInstanceInvalidationService;)V", "serviceConnection", "Landroid/content/ServiceConnection;", "getServiceConnection", "()Landroid/content/ServiceConnection;", "setUpRunnable", "getSetUpRunnable", "stopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getStopped", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "stop", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MultiInstanceInvalidationClient.kt */
public final class MultiInstanceInvalidationClient {
    private final Context appContext;
    private final IMultiInstanceInvalidationCallback callback = new MultiInstanceInvalidationClient$callback$1(this);
    private int clientId;
    private final Executor executor;
    private final InvalidationTracker invalidationTracker;
    private final String name;
    public InvalidationTracker.Observer observer;
    private final Runnable removeObserverRunnable;
    private IMultiInstanceInvalidationService service;
    private final ServiceConnection serviceConnection;
    private final Runnable setUpRunnable;
    private final AtomicBoolean stopped = new AtomicBoolean(false);

    public MultiInstanceInvalidationClient(Context context, String str, Intent intent, InvalidationTracker invalidationTracker2, Executor executor2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(intent, "serviceIntent");
        Intrinsics.checkNotNullParameter(invalidationTracker2, "invalidationTracker");
        Intrinsics.checkNotNullParameter(executor2, "executor");
        this.name = str;
        this.invalidationTracker = invalidationTracker2;
        this.executor = executor2;
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        ServiceConnection multiInstanceInvalidationClient$serviceConnection$1 = new MultiInstanceInvalidationClient$serviceConnection$1(this);
        this.serviceConnection = multiInstanceInvalidationClient$serviceConnection$1;
        this.setUpRunnable = new MultiInstanceInvalidationClient$$ExternalSyntheticLambda0(this);
        this.removeObserverRunnable = new MultiInstanceInvalidationClient$$ExternalSyntheticLambda1(this);
        Object[] array = invalidationTracker2.getTableIdLookup$room_runtime_release().keySet().toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        setObserver(new InvalidationTracker.Observer(this, (String[]) array) {
            final /* synthetic */ MultiInstanceInvalidationClient this$0;

            public boolean isRemote$room_runtime_release() {
                return true;
            }

            {
                this.this$0 = r1;
            }

            public void onInvalidated(Set<String> set) {
                Intrinsics.checkNotNullParameter(set, "tables");
                if (!this.this$0.getStopped().get()) {
                    try {
                        IMultiInstanceInvalidationService service = this.this$0.getService();
                        if (service != null) {
                            int clientId = this.this$0.getClientId();
                            Object[] array = set.toArray(new String[0]);
                            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            service.broadcastInvalidation(clientId, (String[]) array);
                        }
                    } catch (RemoteException e) {
                        Log.w(Room.LOG_TAG, "Cannot broadcast invalidation", e);
                    }
                }
            }
        });
        applicationContext.bindService(intent, multiInstanceInvalidationClient$serviceConnection$1, 1);
    }

    public final String getName() {
        return this.name;
    }

    public final InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    public final Executor getExecutor() {
        return this.executor;
    }

    public final int getClientId() {
        return this.clientId;
    }

    public final void setClientId(int i) {
        this.clientId = i;
    }

    public final InvalidationTracker.Observer getObserver() {
        InvalidationTracker.Observer observer2 = this.observer;
        if (observer2 != null) {
            return observer2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observer");
        return null;
    }

    public final void setObserver(InvalidationTracker.Observer observer2) {
        Intrinsics.checkNotNullParameter(observer2, "<set-?>");
        this.observer = observer2;
    }

    public final IMultiInstanceInvalidationService getService() {
        return this.service;
    }

    public final void setService(IMultiInstanceInvalidationService iMultiInstanceInvalidationService) {
        this.service = iMultiInstanceInvalidationService;
    }

    public final IMultiInstanceInvalidationCallback getCallback() {
        return this.callback;
    }

    public final AtomicBoolean getStopped() {
        return this.stopped;
    }

    public final ServiceConnection getServiceConnection() {
        return this.serviceConnection;
    }

    public final Runnable getSetUpRunnable() {
        return this.setUpRunnable;
    }

    /* access modifiers changed from: private */
    public static final void setUpRunnable$lambda$1(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        Intrinsics.checkNotNullParameter(multiInstanceInvalidationClient, "this$0");
        try {
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.service;
            if (iMultiInstanceInvalidationService != null) {
                multiInstanceInvalidationClient.clientId = iMultiInstanceInvalidationService.registerCallback(multiInstanceInvalidationClient.callback, multiInstanceInvalidationClient.name);
                multiInstanceInvalidationClient.invalidationTracker.addObserver(multiInstanceInvalidationClient.getObserver());
            }
        } catch (RemoteException e) {
            Log.w(Room.LOG_TAG, "Cannot register multi-instance invalidation callback", e);
        }
    }

    /* access modifiers changed from: private */
    public static final void removeObserverRunnable$lambda$2(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        Intrinsics.checkNotNullParameter(multiInstanceInvalidationClient, "this$0");
        multiInstanceInvalidationClient.invalidationTracker.removeObserver(multiInstanceInvalidationClient.getObserver());
    }

    public final Runnable getRemoveObserverRunnable() {
        return this.removeObserverRunnable;
    }

    public final void stop() {
        if (this.stopped.compareAndSet(false, true)) {
            this.invalidationTracker.removeObserver(getObserver());
            try {
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.service;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(this.callback, this.clientId);
                }
            } catch (RemoteException e) {
                Log.w(Room.LOG_TAG, "Cannot unregister multi-instance invalidation callback", e);
            }
            this.appContext.unbindService(this.serviceConnection);
        }
    }
}
