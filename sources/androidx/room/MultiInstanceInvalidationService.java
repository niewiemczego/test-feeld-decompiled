package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import androidx.room.IMultiInstanceInvalidationService;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ExperimentalRoomApi
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Landroidx/room/MultiInstanceInvalidationService;", "Landroid/app/Service;", "()V", "binder", "Landroidx/room/IMultiInstanceInvalidationService$Stub;", "callbackList", "Landroid/os/RemoteCallbackList;", "Landroidx/room/IMultiInstanceInvalidationCallback;", "getCallbackList$room_runtime_release", "()Landroid/os/RemoteCallbackList;", "clientNames", "", "", "", "getClientNames$room_runtime_release", "()Ljava/util/Map;", "maxClientId", "getMaxClientId$room_runtime_release", "()I", "setMaxClientId$room_runtime_release", "(I)V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MultiInstanceInvalidationService.kt */
public final class MultiInstanceInvalidationService extends Service {
    private final IMultiInstanceInvalidationService.Stub binder = new MultiInstanceInvalidationService$binder$1(this);
    private final RemoteCallbackList<IMultiInstanceInvalidationCallback> callbackList = new MultiInstanceInvalidationService$callbackList$1(this);
    private final Map<Integer, String> clientNames = new LinkedHashMap();
    private int maxClientId;

    public final int getMaxClientId$room_runtime_release() {
        return this.maxClientId;
    }

    public final void setMaxClientId$room_runtime_release(int i) {
        this.maxClientId = i;
    }

    public final Map<Integer, String> getClientNames$room_runtime_release() {
        return this.clientNames;
    }

    public final RemoteCallbackList<IMultiInstanceInvalidationCallback> getCallbackList$room_runtime_release() {
        return this.callbackList;
    }

    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        return this.binder;
    }
}
