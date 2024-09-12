package expo.modules.kotlin.events;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001b\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001¢\u0006\u0002\u0010\u000fR#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lexpo/modules/kotlin/events/EventListenerWithSenderAndPayload;", "Sender", "Payload", "Lexpo/modules/kotlin/events/EventListener;", "eventName", "Lexpo/modules/kotlin/events/EventName;", "body", "Lkotlin/Function2;", "", "(Lexpo/modules/kotlin/events/EventName;Lkotlin/jvm/functions/Function2;)V", "getBody", "()Lkotlin/jvm/functions/Function2;", "call", "sender", "payload", "(Ljava/lang/Object;Ljava/lang/Object;)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: EventListener.kt */
public final class EventListenerWithSenderAndPayload<Sender, Payload> extends EventListener {
    private final Function2<Sender, Payload, Unit> body;

    public final Function2<Sender, Payload, Unit> getBody() {
        return this.body;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EventListenerWithSenderAndPayload(EventName eventName, Function2<? super Sender, ? super Payload, Unit> function2) {
        super(eventName, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(function2, "body");
        this.body = function2;
    }

    public final void call(Sender sender, Payload payload) {
        this.body.invoke(sender, payload);
    }
}
