package zendesk.android.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import zendesk.android.internal.di.ZendeskComponent;
import zendesk.android.messaging.MessagingFactory;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.internal.ZendeskFactory", f = "ZendeskFactory.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {25, 33}, m = "create", n = {"zendeskComponent", "messagingFactory", "scope", "zendeskComponent", "messagingFactory", "scope", "settings"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
/* compiled from: ZendeskFactory.kt */
final class ZendeskFactory$create$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZendeskFactory this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ZendeskFactory$create$1(ZendeskFactory zendeskFactory, Continuation<? super ZendeskFactory$create$1> continuation) {
        super(continuation);
        this.this$0 = zendeskFactory;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.create((ZendeskComponent) null, (MessagingFactory) null, this);
    }
}
