package kotlinx.coroutines.tasks;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u0001H\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "it", "Lcom/google/android/gms/tasks/Task;", "kotlin.jvm.PlatformType", "onComplete"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tasks.kt */
final class TasksKt$awaitImpl$2$1<TResult> implements OnCompleteListener {
    final /* synthetic */ CancellableContinuation<T> $cont;

    TasksKt$awaitImpl$2$1(CancellableContinuation<? super T> cancellableContinuation) {
        this.$cont = cancellableContinuation;
    }

    public final void onComplete(Task<T> task) {
        Exception exception = task.getException();
        if (exception != null) {
            Result.Companion companion = Result.Companion;
            this.$cont.resumeWith(Result.m983constructorimpl(ResultKt.createFailure(exception)));
        } else if (task.isCanceled()) {
            CancellableContinuation.DefaultImpls.cancel$default(this.$cont, (Throwable) null, 1, (Object) null);
        } else {
            Result.Companion companion2 = Result.Companion;
            this.$cont.resumeWith(Result.m983constructorimpl(task.getResult()));
        }
    }
}
