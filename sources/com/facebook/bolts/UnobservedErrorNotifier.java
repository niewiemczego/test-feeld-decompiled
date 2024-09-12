package com.facebook.bolts;

import com.facebook.bolts.Task;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/bolts/UnobservedErrorNotifier;", "", "task", "Lcom/facebook/bolts/Task;", "(Lcom/facebook/bolts/Task;)V", "finalize", "", "setObserved", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: UnobservedErrorNotifier.kt */
public final class UnobservedErrorNotifier {
    private Task<?> task;

    public UnobservedErrorNotifier(Task<?> task2) {
        this.task = task2;
    }

    public final void finalize() {
        Task.UnobservedExceptionHandler unobservedExceptionHandler;
        Task<?> task2 = this.task;
        if (task2 != null && (unobservedExceptionHandler = Task.Companion.getUnobservedExceptionHandler()) != null) {
            unobservedExceptionHandler.unobservedException(task2, new UnobservedTaskException(task2.getError()));
        }
    }

    public final void setObserved() {
        this.task = null;
    }
}
