package zendesk.conversationkit.android.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.ConversationKitEvent;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001e\u0012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\n\u001a\u00020\u00042\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\t0\u000bJ/\u0010\n\u001a\u00020\u0004\"\u0004\b\u0000\u0010\f2\b\u0010\r\u001a\u0004\u0018\u0001H\f2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0002\u0010\u000eJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/internal/EventReceiver;", "", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "events", "", "Lzendesk/conversationkit/android/ConversationKitEvent;", "event", "Lkotlin/Function0;", "T", "data", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "toList", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EffectMapper.kt */
final class EventReceiver {
    private final List<ConversationKitEvent> events = new ArrayList();

    public EventReceiver(Function1<? super EventReceiver, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        function1.invoke(this);
    }

    public final void event(Function0<? extends ConversationKitEvent> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.events.add(function0.invoke());
    }

    public final <T> void event(T t, Function1<? super T, ? extends ConversationKitEvent> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        List<ConversationKitEvent> list = this.events;
        if (t != null) {
            list.add(function1.invoke(t));
        }
    }

    public final List<ConversationKitEvent> toList() {
        return CollectionsKt.toList(this.events);
    }
}
