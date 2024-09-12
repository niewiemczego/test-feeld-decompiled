package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\rJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/work/impl/StartStopTokens;", "", "()V", "lock", "runs", "", "Landroidx/work/impl/model/WorkGenerationalId;", "Landroidx/work/impl/StartStopToken;", "contains", "", "id", "remove", "spec", "Landroidx/work/impl/model/WorkSpec;", "", "workSpecId", "", "tokenFor", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: StartStopToken.kt */
public final class StartStopTokens {
    private final Object lock = new Object();
    private final Map<WorkGenerationalId, StartStopToken> runs = new LinkedHashMap();

    public final StartStopToken tokenFor(WorkGenerationalId workGenerationalId) {
        StartStopToken startStopToken;
        Intrinsics.checkNotNullParameter(workGenerationalId, "id");
        synchronized (this.lock) {
            Map<WorkGenerationalId, StartStopToken> map = this.runs;
            StartStopToken startStopToken2 = map.get(workGenerationalId);
            if (startStopToken2 == null) {
                startStopToken2 = new StartStopToken(workGenerationalId);
                map.put(workGenerationalId, startStopToken2);
            }
            startStopToken = startStopToken2;
        }
        return startStopToken;
    }

    public final StartStopToken remove(WorkGenerationalId workGenerationalId) {
        StartStopToken remove;
        Intrinsics.checkNotNullParameter(workGenerationalId, "id");
        synchronized (this.lock) {
            remove = this.runs.remove(workGenerationalId);
        }
        return remove;
    }

    public final List<StartStopToken> remove(String str) {
        List<StartStopToken> list;
        Intrinsics.checkNotNullParameter(str, "workSpecId");
        synchronized (this.lock) {
            Map<WorkGenerationalId, StartStopToken> map = this.runs;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : map.entrySet()) {
                if (Intrinsics.areEqual((Object) ((WorkGenerationalId) next.getKey()).getWorkSpecId(), (Object) str)) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            Map map2 = linkedHashMap;
            for (WorkGenerationalId remove : map2.keySet()) {
                this.runs.remove(remove);
            }
            list = CollectionsKt.toList(map2.values());
        }
        return list;
    }

    public final boolean contains(WorkGenerationalId workGenerationalId) {
        boolean containsKey;
        Intrinsics.checkNotNullParameter(workGenerationalId, "id");
        synchronized (this.lock) {
            containsKey = this.runs.containsKey(workGenerationalId);
        }
        return containsKey;
    }

    public final StartStopToken tokenFor(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter(workSpec, "spec");
        return tokenFor(WorkSpecKt.generationalId(workSpec));
    }

    public final StartStopToken remove(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter(workSpec, "spec");
        return remove(WorkSpecKt.generationalId(workSpec));
    }
}
