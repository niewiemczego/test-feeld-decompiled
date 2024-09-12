package zendesk.android;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import zendesk.android.events.ZendeskEvent;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"eventFlow", "Lkotlinx/coroutines/flow/Flow;", "Lzendesk/android/events/ZendeskEvent;", "Lzendesk/android/Zendesk;", "getEventFlow", "(Lzendesk/android/Zendesk;)Lkotlinx/coroutines/flow/Flow;", "zendesk_zendesk-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ZendeskExtensions.kt */
public final class ZendeskExtensions {
    public static final Flow<ZendeskEvent> getEventFlow(Zendesk zendesk2) {
        Intrinsics.checkNotNullParameter(zendesk2, "<this>");
        return FlowKt.callbackFlow(new ZendeskExtensions$eventFlow$1(zendesk2, (Continuation<? super ZendeskExtensions$eventFlow$1>) null));
    }
}
