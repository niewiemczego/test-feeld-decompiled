package app.notifee.core;

import app.notifee.core.interfaces.MethodCallResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Notifee$$ExternalSyntheticLambda6 implements OnCompleteListener {
    public final /* synthetic */ MethodCallResult f$0;

    public /* synthetic */ Notifee$$ExternalSyntheticLambda6(MethodCallResult methodCallResult) {
        this.f$0 = methodCallResult;
    }

    public final void onComplete(Task task) {
        Notifee.f(this.f$0, task);
    }
}
