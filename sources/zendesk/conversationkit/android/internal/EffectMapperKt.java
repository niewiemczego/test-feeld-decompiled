package zendesk.conversationkit.android.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import zendesk.conversationkit.android.ConversationKitEvent;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0002¨\u0006\b"}, d2 = {"mapEvents", "", "Lzendesk/conversationkit/android/ConversationKitEvent;", "block", "Lkotlin/Function1;", "Lzendesk/conversationkit/android/internal/EventReceiver;", "", "Lkotlin/ExtensionFunctionType;", "zendesk.conversationkit_conversationkit-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: EffectMapper.kt */
public final class EffectMapperKt {
    /* access modifiers changed from: private */
    public static final List<ConversationKitEvent> mapEvents(Function1<? super EventReceiver, Unit> function1) {
        return new EventReceiver(function1).toList();
    }
}
