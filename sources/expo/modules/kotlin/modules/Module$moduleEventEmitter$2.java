package expo.modules.kotlin.modules;

import expo.modules.kotlin.events.EventEmitter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lexpo/modules/kotlin/events/EventEmitter;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Module.kt */
final class Module$moduleEventEmitter$2 extends Lambda implements Function0<EventEmitter> {
    final /* synthetic */ Module this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Module$moduleEventEmitter$2(Module module) {
        super(0);
        this.this$0 = module;
    }

    public final EventEmitter invoke() {
        return this.this$0.getAppContext().eventEmitter(this.this$0);
    }
}
