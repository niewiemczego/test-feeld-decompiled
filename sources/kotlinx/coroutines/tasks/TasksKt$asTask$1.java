package kotlinx.coroutines.tasks;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tasks.kt */
final class TasksKt$asTask$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CancellationTokenSource $cancellation;
    final /* synthetic */ TaskCompletionSource<T> $source;
    final /* synthetic */ Deferred<T> $this_asTask;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TasksKt$asTask$1(CancellationTokenSource cancellationTokenSource, Deferred<? extends T> deferred, TaskCompletionSource<T> taskCompletionSource) {
        super(1);
        this.$cancellation = cancellationTokenSource;
        this.$this_asTask = deferred;
        this.$source = taskCompletionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        if (th instanceof CancellationException) {
            this.$cancellation.cancel();
            return;
        }
        Throwable completionExceptionOrNull = this.$this_asTask.getCompletionExceptionOrNull();
        if (completionExceptionOrNull == null) {
            this.$source.setResult(this.$this_asTask.getCompleted());
            return;
        }
        TaskCompletionSource<T> taskCompletionSource = this.$source;
        Exception exc = completionExceptionOrNull instanceof Exception ? (Exception) completionExceptionOrNull : null;
        if (exc == null) {
            exc = new RuntimeExecutionException(completionExceptionOrNull);
        }
        taskCompletionSource.setException(exc);
    }
}
