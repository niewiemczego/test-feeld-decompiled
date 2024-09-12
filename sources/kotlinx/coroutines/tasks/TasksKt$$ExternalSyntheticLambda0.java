package kotlinx.coroutines.tasks;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlinx.coroutines.CompletableDeferred;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TasksKt$$ExternalSyntheticLambda0 implements OnCompleteListener {
    public final /* synthetic */ CompletableDeferred f$0;

    public /* synthetic */ TasksKt$$ExternalSyntheticLambda0(CompletableDeferred completableDeferred) {
        this.f$0 = completableDeferred;
    }

    public final void onComplete(Task task) {
        TasksKt.asDeferredImpl$lambda$0(this.f$0, task);
    }
}
