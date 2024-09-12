package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/work/impl/constraints/trackers/BroadcastReceiverConstraintTracker$broadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BroadcastReceiverConstraintTracker.kt */
public final class BroadcastReceiverConstraintTracker$broadcastReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ BroadcastReceiverConstraintTracker<T> this$0;

    BroadcastReceiverConstraintTracker$broadcastReceiver$1(BroadcastReceiverConstraintTracker<T> broadcastReceiverConstraintTracker) {
        this.this$0 = broadcastReceiverConstraintTracker;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        this.this$0.onBroadcastReceive(intent);
    }
}
