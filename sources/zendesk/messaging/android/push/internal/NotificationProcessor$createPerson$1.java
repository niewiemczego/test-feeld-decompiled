package zendesk.messaging.android.push.internal;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.push.internal.NotificationProcessor", f = "NotificationProcessor.kt", i = {0, 0, 0}, l = {122}, m = "createPerson", n = {"this", "builder", "personKey"}, s = {"L$0", "L$2", "I$0"})
/* compiled from: NotificationProcessor.kt */
final class NotificationProcessor$createPerson$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationProcessor$createPerson$1(NotificationProcessor notificationProcessor, Continuation<? super NotificationProcessor$createPerson$1> continuation) {
        super(continuation);
        this.this$0 = notificationProcessor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createPerson((Context) null, (String) null, (String) null, (String) null, this);
    }
}
