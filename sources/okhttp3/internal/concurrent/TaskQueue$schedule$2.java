package okhttp3.internal.concurrent;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$schedule$2", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 176)
/* compiled from: TaskQueue.kt */
public final class TaskQueue$schedule$2 extends Task {
    final /* synthetic */ Function0<Long> $block;
    final /* synthetic */ String $name;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaskQueue$schedule$2(String str, Function0<Long> function0) {
        super(str, false, 2, (DefaultConstructorMarker) null);
        this.$name = str;
        this.$block = function0;
    }

    public long runOnce() {
        return this.$block.invoke().longValue();
    }
}
