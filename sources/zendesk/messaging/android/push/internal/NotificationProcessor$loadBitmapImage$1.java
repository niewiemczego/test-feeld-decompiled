package zendesk.messaging.android.push.internal;

import android.content.Context;
import coil.transform.Transformation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.push.internal.NotificationProcessor", f = "NotificationProcessor.kt", i = {}, l = {156}, m = "loadBitmapImage", n = {}, s = {})
/* compiled from: NotificationProcessor.kt */
final class NotificationProcessor$loadBitmapImage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationProcessor$loadBitmapImage$1(NotificationProcessor notificationProcessor, Continuation<? super NotificationProcessor$loadBitmapImage$1> continuation) {
        super(continuation);
        this.this$0 = notificationProcessor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadBitmapImage((Context) null, (String) null, (Transformation) null, this);
    }
}
