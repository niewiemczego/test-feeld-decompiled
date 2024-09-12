package androidx.room;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0016¢\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"androidx/room/MultiInstanceInvalidationService$binder$1", "Landroidx/room/IMultiInstanceInvalidationService$Stub;", "broadcastInvalidation", "", "clientId", "", "tables", "", "", "(I[Ljava/lang/String;)V", "registerCallback", "callback", "Landroidx/room/IMultiInstanceInvalidationCallback;", "name", "unregisterCallback", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MultiInstanceInvalidationService.kt */
public final class MultiInstanceInvalidationService$binder$1 extends IMultiInstanceInvalidationService.Stub {
    final /* synthetic */ MultiInstanceInvalidationService this$0;

    MultiInstanceInvalidationService$binder$1(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.this$0 = multiInstanceInvalidationService;
    }

    public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
        Intrinsics.checkNotNullParameter(iMultiInstanceInvalidationCallback, "callback");
        int i = 0;
        if (str == null) {
            return 0;
        }
        RemoteCallbackList<IMultiInstanceInvalidationCallback> callbackList$room_runtime_release = this.this$0.getCallbackList$room_runtime_release();
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
        synchronized (callbackList$room_runtime_release) {
            multiInstanceInvalidationService.setMaxClientId$room_runtime_release(multiInstanceInvalidationService.getMaxClientId$room_runtime_release() + 1);
            int maxClientId$room_runtime_release = multiInstanceInvalidationService.getMaxClientId$room_runtime_release();
            if (multiInstanceInvalidationService.getCallbackList$room_runtime_release().register(iMultiInstanceInvalidationCallback, Integer.valueOf(maxClientId$room_runtime_release))) {
                multiInstanceInvalidationService.getClientNames$room_runtime_release().put(Integer.valueOf(maxClientId$room_runtime_release), str);
                i = maxClientId$room_runtime_release;
            } else {
                multiInstanceInvalidationService.setMaxClientId$room_runtime_release(multiInstanceInvalidationService.getMaxClientId$room_runtime_release() - 1);
                multiInstanceInvalidationService.getMaxClientId$room_runtime_release();
            }
        }
        return i;
    }

    public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i) {
        Intrinsics.checkNotNullParameter(iMultiInstanceInvalidationCallback, "callback");
        RemoteCallbackList<IMultiInstanceInvalidationCallback> callbackList$room_runtime_release = this.this$0.getCallbackList$room_runtime_release();
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
        synchronized (callbackList$room_runtime_release) {
            multiInstanceInvalidationService.getCallbackList$room_runtime_release().unregister(iMultiInstanceInvalidationCallback);
            String remove = multiInstanceInvalidationService.getClientNames$room_runtime_release().remove(Integer.valueOf(i));
        }
    }

    public void broadcastInvalidation(int i, String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "tables");
        RemoteCallbackList<IMultiInstanceInvalidationCallback> callbackList$room_runtime_release = this.this$0.getCallbackList$room_runtime_release();
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
        synchronized (callbackList$room_runtime_release) {
            String str = multiInstanceInvalidationService.getClientNames$room_runtime_release().get(Integer.valueOf(i));
            if (str == null) {
                Log.w(Room.LOG_TAG, "Remote invalidation client ID not registered");
                return;
            }
            int beginBroadcast = multiInstanceInvalidationService.getCallbackList$room_runtime_release().beginBroadcast();
            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                try {
                    Object broadcastCookie = multiInstanceInvalidationService.getCallbackList$room_runtime_release().getBroadcastCookie(i2);
                    Intrinsics.checkNotNull(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                    int intValue = ((Integer) broadcastCookie).intValue();
                    String str2 = multiInstanceInvalidationService.getClientNames$room_runtime_release().get(Integer.valueOf(intValue));
                    if (i != intValue && Intrinsics.areEqual((Object) str, (Object) str2)) {
                        multiInstanceInvalidationService.getCallbackList$room_runtime_release().getBroadcastItem(i2).onInvalidation(strArr);
                    }
                } catch (RemoteException e) {
                    Log.w(Room.LOG_TAG, "Error invoking a remote callback", e);
                } catch (Throwable th) {
                    multiInstanceInvalidationService.getCallbackList$room_runtime_release().finishBroadcast();
                    throw th;
                }
            }
            multiInstanceInvalidationService.getCallbackList$room_runtime_release().finishBroadcast();
            Unit unit = Unit.INSTANCE;
        }
    }
}
