package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Runnable.kt */
public final class OnTimeout$register$$inlined$Runnable$1 implements Runnable {
    final /* synthetic */ SelectInstance $select$inlined;
    final /* synthetic */ OnTimeout this$0;

    public OnTimeout$register$$inlined$Runnable$1(SelectInstance selectInstance, OnTimeout onTimeout) {
        this.$select$inlined = selectInstance;
        this.this$0 = onTimeout;
    }

    public final void run() {
        this.$select$inlined.trySelect(this.this$0, Unit.INSTANCE);
    }
}
