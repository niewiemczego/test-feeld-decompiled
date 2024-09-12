package expo.modules.kotlin.events;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\n\u001a\u00020\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lexpo/modules/kotlin/events/BasicEventListener;", "Lexpo/modules/kotlin/events/EventListener;", "eventName", "Lexpo/modules/kotlin/events/EventName;", "body", "Lkotlin/Function0;", "", "(Lexpo/modules/kotlin/events/EventName;Lkotlin/jvm/functions/Function0;)V", "getBody", "()Lkotlin/jvm/functions/Function0;", "call", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: EventListener.kt */
public final class BasicEventListener extends EventListener {
    private final Function0<Unit> body;

    public final Function0<Unit> getBody() {
        return this.body;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BasicEventListener(EventName eventName, Function0<Unit> function0) {
        super(eventName, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(function0, "body");
        this.body = function0;
    }

    public final void call() {
        this.body.invoke();
    }
}
