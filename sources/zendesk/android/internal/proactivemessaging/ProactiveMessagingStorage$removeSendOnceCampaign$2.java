package zendesk.android.internal.proactivemessaging;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.internal.proactivemessaging.ProactiveMessagingStorage$removeSendOnceCampaign$2", f = "ProactiveMessagingStorage.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProactiveMessagingStorage.kt */
final class ProactiveMessagingStorage$removeSendOnceCampaign$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $campaignId;
    int label;
    final /* synthetic */ ProactiveMessagingStorage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProactiveMessagingStorage$removeSendOnceCampaign$2(ProactiveMessagingStorage proactiveMessagingStorage, String str, Continuation<? super ProactiveMessagingStorage$removeSendOnceCampaign$2> continuation) {
        super(2, continuation);
        this.this$0 = proactiveMessagingStorage;
        this.$campaignId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProactiveMessagingStorage$removeSendOnceCampaign$2(this.this$0, this.$campaignId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProactiveMessagingStorage$removeSendOnceCampaign$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getSendOnceCampaignIds(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str = this.$campaignId;
        Collection arrayList = new ArrayList();
        for (Object next : (Iterable) obj) {
            if (!Intrinsics.areEqual((Object) (String) next, (Object) str)) {
                arrayList.add(next);
            }
        }
        this.this$0.storage.set(ProactiveMessagingStorage.KEY_SEND_ONCE_CAMPAIGN_IDS, new SendOnceCampaignsStorage((List) arrayList), SendOnceCampaignsStorage.class);
        return Unit.INSTANCE;
    }
}
