package zendesk.android.internal.proactivemessaging;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.CampaignPathDto;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository", f = "ProactiveMessagingRepository.kt", i = {}, l = {101}, m = "getProactiveMessage", n = {}, s = {})
/* compiled from: ProactiveMessagingRepository.kt */
final class ProactiveMessagingRepository$getProactiveMessage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProactiveMessagingRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProactiveMessagingRepository$getProactiveMessage$1(ProactiveMessagingRepository proactiveMessagingRepository, Continuation<? super ProactiveMessagingRepository$getProactiveMessage$1> continuation) {
        super(continuation);
        this.this$0 = proactiveMessagingRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getProactiveMessage((List<CampaignPathDto>) null, this);
    }
}
