package expo.modules.kotlin.events;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0013\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\rR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lexpo/modules/kotlin/events/EventListenerWithPayload;", "Payload", "Lexpo/modules/kotlin/events/EventListener;", "eventName", "Lexpo/modules/kotlin/events/EventName;", "body", "Lkotlin/Function1;", "", "(Lexpo/modules/kotlin/events/EventName;Lkotlin/jvm/functions/Function1;)V", "getBody", "()Lkotlin/jvm/functions/Function1;", "call", "sender", "(Ljava/lang/Object;)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: EventListener.kt */
public final class EventListenerWithPayload<Payload> extends EventListener {
    private final Function1<Payload, Unit> body;

    public final Function1<Payload, Unit> getBody() {
        return this.body;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EventListenerWithPayload(EventName eventName, Function1<? super Payload, Unit> function1) {
        super(eventName, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(function1, "body");
        this.body = function1;
    }

    public final void call(Payload payload) {
        this.body.invoke(payload);
    }
}
