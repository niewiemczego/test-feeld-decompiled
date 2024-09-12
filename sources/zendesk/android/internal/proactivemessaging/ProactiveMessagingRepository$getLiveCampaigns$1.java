package zendesk.android.internal.proactivemessaging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository", f = "ProactiveMessagingRepository.kt", i = {0}, l = {60, 66}, m = "getLiveCampaigns", n = {"this"}, s = {"L$0"})
/* compiled from: ProactiveMessagingRepository.kt */
final class ProactiveMessagingRepository$getLiveCampaigns$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProactiveMessagingRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProactiveMessagingRepository$getLiveCampaigns$1(ProactiveMessagingRepository proactiveMessagingRepository, Continuation<? super ProactiveMessagingRepository$getLiveCampaigns$1> continuation) {
        super(continuation);
        this.this$0 = proactiveMessagingRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getLiveCampaigns(this);
    }
}
