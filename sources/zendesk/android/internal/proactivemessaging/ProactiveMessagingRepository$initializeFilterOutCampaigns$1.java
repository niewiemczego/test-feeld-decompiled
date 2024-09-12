package zendesk.android.internal.proactivemessaging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository", f = "ProactiveMessagingRepository.kt", i = {0, 0, 1, 1}, l = {51, 53, 56}, m = "initializeFilterOutCampaigns", n = {"this", "availableOnlyOnceCampaigns", "this", "availableOnlyOnceCampaigns"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: ProactiveMessagingRepository.kt */
final class ProactiveMessagingRepository$initializeFilterOutCampaigns$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProactiveMessagingRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProactiveMessagingRepository$initializeFilterOutCampaigns$1(ProactiveMessagingRepository proactiveMessagingRepository, Continuation<? super ProactiveMessagingRepository$initializeFilterOutCampaigns$1> continuation) {
        super(continuation);
        this.this$0 = proactiveMessagingRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.initializeFilterOutCampaigns(this);
    }
}
