package okhttp3.internal.ws;

import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: okhttp3.internal.ws.RealWebSocket$writeOneFrame$lambda-8$$inlined$execute$default$1  reason: invalid class name */
/* compiled from: TaskQueue.kt */
public final class RealWebSocket$writeOneFrame$lambda8$$inlined$execute$default$1 extends Task {
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ String $name;
    final /* synthetic */ RealWebSocket this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealWebSocket$writeOneFrame$lambda8$$inlined$execute$default$1(String str, boolean z, RealWebSocket realWebSocket) {
        super(str, z);
        this.$name = str;
        this.$cancelable = z;
        this.this$0 = realWebSocket;
    }

    public long runOnce() {
        this.this$0.cancel();
        return -1;
    }
}
