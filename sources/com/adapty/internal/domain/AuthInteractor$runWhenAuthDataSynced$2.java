package com.adapty.internal.domain;

import com.adapty.internal.domain.models.ProfileRequestResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/adapty/internal/domain/models/ProfileRequestResult;", "error", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.AuthInteractor$runWhenAuthDataSynced$2", f = "AuthInteractor.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AuthInteractor.kt */
final class AuthInteractor$runWhenAuthDataSynced$2 extends SuspendLambda implements Function3<FlowCollector<? super ProfileRequestResult>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T> $switchIfProfileCreationFailed;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthInteractor$runWhenAuthDataSynced$2(Function0<? extends T> function0, Continuation<? super AuthInteractor$runWhenAuthDataSynced$2> continuation) {
        super(3, continuation);
        this.$switchIfProfileCreationFailed = function0;
    }

    public final Object invoke(FlowCollector<? super ProfileRequestResult> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        AuthInteractor$runWhenAuthDataSynced$2 authInteractor$runWhenAuthDataSynced$2 = new AuthInteractor$runWhenAuthDataSynced$2(this.$switchIfProfileCreationFailed, continuation);
        authInteractor$runWhenAuthDataSynced$2.L$0 = flowCollector;
        authInteractor$runWhenAuthDataSynced$2.L$1 = th;
        return authInteractor$runWhenAuthDataSynced$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th = (Throwable) this.L$1;
            if (this.$switchIfProfileCreationFailed != null) {
                this.L$0 = null;
                this.label = 1;
                if (flowCollector.emit(new ProfileRequestResult.ProfileNotCreated(th), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw th;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
