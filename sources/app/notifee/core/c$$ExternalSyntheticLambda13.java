package app.notifee.core;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.work.Data;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class c$$ExternalSyntheticLambda13 implements Continuation {
    public final /* synthetic */ Data f$0;
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$1;

    public /* synthetic */ c$$ExternalSyntheticLambda13(Data data, CallbackToFutureAdapter.Completer completer) {
        this.f$0 = data;
        this.f$1 = completer;
    }

    public final Object then(Task task) {
        return c.a(this.f$0, this.f$1, task);
    }
}
