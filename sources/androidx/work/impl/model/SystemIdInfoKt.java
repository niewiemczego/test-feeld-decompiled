package androidx.work.impl.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"systemIdInfo", "Landroidx/work/impl/model/SystemIdInfo;", "generationalId", "Landroidx/work/impl/model/WorkGenerationalId;", "systemId", "", "work-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SystemIdInfo.kt */
public final class SystemIdInfoKt {
    public static final SystemIdInfo systemIdInfo(WorkGenerationalId workGenerationalId, int i) {
        Intrinsics.checkNotNullParameter(workGenerationalId, "generationalId");
        return new SystemIdInfo(workGenerationalId.getWorkSpecId(), workGenerationalId.getGeneration(), i);
    }
}
