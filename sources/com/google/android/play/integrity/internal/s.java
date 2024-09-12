package com.google.android.play.integrity.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
public final /* synthetic */ class s implements OnCompleteListener {
    public final /* synthetic */ ac a;
    public final /* synthetic */ TaskCompletionSource b;

    public /* synthetic */ s(ac acVar, TaskCompletionSource taskCompletionSource) {
        this.a = acVar;
        this.b = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        this.a.u(this.b, task);
    }
}
