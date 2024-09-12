package com.facebook.bolts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00030\u0001J\u001e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/facebook/bolts/Task$Companion$whenAllResult$1", "Lcom/facebook/bolts/Continuation;", "Ljava/lang/Void;", "", "then", "task", "Lcom/facebook/bolts/Task;", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Task.kt */
public final class Task$Companion$whenAllResult$1 implements Continuation<Void, List<? extends TResult>> {
    final /* synthetic */ Collection<Task<TResult>> $tasks;

    Task$Companion$whenAllResult$1(Collection<Task<TResult>> collection) {
        this.$tasks = collection;
    }

    public List<TResult> then(Task<Void> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (this.$tasks.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List<TResult> arrayList = new ArrayList<>();
        for (Task<TResult> result : this.$tasks) {
            arrayList.add(result.getResult());
        }
        return arrayList;
    }
}
