package androidx.privacysandbox.ads.adservices.topics;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon", f = "TopicsManagerImplCommon.kt", i = {}, l = {22}, m = "getTopics$suspendImpl", n = {}, s = {})
/* compiled from: TopicsManagerImplCommon.kt */
final class TopicsManagerImplCommon$getTopics$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TopicsManagerImplCommon this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopicsManagerImplCommon$getTopics$1(TopicsManagerImplCommon topicsManagerImplCommon, Continuation<? super TopicsManagerImplCommon$getTopics$1> continuation) {
        super(continuation);
        this.this$0 = topicsManagerImplCommon;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TopicsManagerImplCommon.getTopics$suspendImpl(this.this$0, (GetTopicsRequest) null, this);
    }
}
