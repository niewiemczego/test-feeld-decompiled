package com.adapty.internal.domain;

import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.adapty.internal.data.models.ProfileDto;
import com.adapty.models.AdaptyProfile;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/adapty/models/AdaptyProfile;", "error", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.ProfileInteractor$getProfile$3", f = "ProfileInteractor.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProfileInteractor.kt */
final class ProfileInteractor$getProfile$3 extends SuspendLambda implements Function3<FlowCollector<? super AdaptyProfile>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ ProfileInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileInteractor$getProfile$3(ProfileInteractor profileInteractor, Continuation<? super ProfileInteractor$getProfile$3> continuation) {
        super(3, continuation);
        this.this$0 = profileInteractor;
    }

    public final Object invoke(FlowCollector<? super AdaptyProfile> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        ProfileInteractor$getProfile$3 profileInteractor$getProfile$3 = new ProfileInteractor$getProfile$3(this.this$0, continuation);
        profileInteractor$getProfile$3.L$0 = flowCollector;
        profileInteractor$getProfile$3.L$1 = th;
        return profileInteractor$getProfile$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th = (Throwable) this.L$1;
            if (th instanceof AdaptyError) {
                AdaptyError adaptyError = (AdaptyError) th;
                if (adaptyError.getAdaptyErrorCode() == AdaptyErrorCode.SERVER_ERROR || (adaptyError.getOriginalError() instanceof IOException)) {
                    ProfileDto profile = this.this$0.cacheRepository.getProfile();
                    AdaptyProfile map = profile != null ? this.this$0.profileMapper.map(profile) : null;
                    if (map != null) {
                        this.L$0 = null;
                        this.label = 1;
                        if (FlowKt.emitAll(flowCollector, FlowKt.flowOf(map), (Continuation<? super Unit>) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        throw th;
                    }
                }
            }
            throw th;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
