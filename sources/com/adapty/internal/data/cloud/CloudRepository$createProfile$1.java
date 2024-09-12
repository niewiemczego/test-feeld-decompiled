package com.adapty.internal.data.cloud;

import com.adapty.internal.data.cloud.Response;
import com.adapty.internal.data.models.InstallationMeta;
import com.adapty.internal.data.models.ProfileDto;
import com.adapty.models.AdaptyProfileParameters;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/adapty/internal/data/models/ProfileDto;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.CloudRepository$createProfile$1", f = "CloudRepository.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CloudRepository.kt */
final class CloudRepository$createProfile$1 extends SuspendLambda implements Function2<FlowCollector<? super ProfileDto>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $customerUserId;
    final /* synthetic */ InstallationMeta $installationMeta;
    final /* synthetic */ AdaptyProfileParameters $params;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CloudRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudRepository$createProfile$1(CloudRepository cloudRepository, String str, InstallationMeta installationMeta, AdaptyProfileParameters adaptyProfileParameters, Continuation<? super CloudRepository$createProfile$1> continuation) {
        super(2, continuation);
        this.this$0 = cloudRepository;
        this.$customerUserId = str;
        this.$installationMeta = installationMeta;
        this.$params = adaptyProfileParameters;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CloudRepository$createProfile$1 cloudRepository$createProfile$1 = new CloudRepository$createProfile$1(this.this$0, this.$customerUserId, this.$installationMeta, this.$params, continuation);
        cloudRepository$createProfile$1.L$0 = obj;
        return cloudRepository$createProfile$1;
    }

    public final Object invoke(FlowCollector<? super ProfileDto> flowCollector, Continuation<? super Unit> continuation) {
        return ((CloudRepository$createProfile$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Response newCall = this.this$0.httpClient.newCall(this.this$0.requestFactory.createProfileRequest(this.$customerUserId, this.$installationMeta, this.$params), ProfileDto.class);
            if (newCall instanceof Response.Success) {
                this.label = 1;
                if (flowCollector.emit(((Response.Success) newCall).getBody(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (newCall instanceof Response.Error) {
                throw ((Response.Error) newCall).getError();
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
