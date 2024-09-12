package zendesk.android;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import zendesk.android.Zendesk;
import zendesk.android.messaging.MessagingFactory;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.Zendesk$Companion", f = "Zendesk.kt", i = {0, 0, 0, 0, 1}, l = {330, 299}, m = "initialize", n = {"context", "channelKey", "messagingFactory", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
/* compiled from: Zendesk.kt */
final class Zendesk$Companion$initialize$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Zendesk.Companion this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Zendesk$Companion$initialize$2(Zendesk.Companion companion, Continuation<? super Zendesk$Companion$initialize$2> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.initialize((Context) null, (String) null, (MessagingFactory) null, (Continuation) this);
    }
}
