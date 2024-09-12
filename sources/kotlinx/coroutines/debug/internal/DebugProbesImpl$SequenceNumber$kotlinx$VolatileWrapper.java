package kotlinx.coroutines.debug.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DebugProbesImpl.kt */
final class DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper {
    /* access modifiers changed from: private */
    public static final AtomicLongFieldUpdater sequenceNumber$FU = AtomicLongFieldUpdater.newUpdater(DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper.class, "sequenceNumber");
    @Volatile
    private volatile long sequenceNumber;

    private DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper() {
    }

    public /* synthetic */ DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
