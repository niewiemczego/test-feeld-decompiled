package zendesk.android;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.Zendesk", f = "Zendesk.kt", i = {}, l = {137}, m = "logoutUser", n = {}, s = {})
/* compiled from: Zendesk.kt */
final class Zendesk$logoutUser$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Zendesk this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Zendesk$logoutUser$1(Zendesk zendesk2, Continuation<? super Zendesk$logoutUser$1> continuation) {
        super(continuation);
        this.this$0 = zendesk2;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.logoutUser(this);
    }
}
