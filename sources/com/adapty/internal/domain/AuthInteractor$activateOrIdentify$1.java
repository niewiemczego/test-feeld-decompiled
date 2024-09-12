package com.adapty.internal.domain;

import com.adapty.internal.domain.models.ProfileRequestResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "Lcom/adapty/internal/domain/models/ProfileRequestResult;", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.AuthInteractor$activateOrIdentify$1", f = "AuthInteractor.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AuthInteractor.kt */
final class AuthInteractor$activateOrIdentify$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Flow<? extends ProfileRequestResult>>, Object> {
    int label;
    final /* synthetic */ AuthInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthInteractor$activateOrIdentify$1(AuthInteractor authInteractor, Continuation<? super AuthInteractor$activateOrIdentify$1> continuation) {
        super(2, continuation);
        this.this$0 = authInteractor;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthInteractor$activateOrIdentify$1(this.this$0, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Flow<? extends ProfileRequestResult>>) (Continuation) obj2);
    }

    public final Object invoke(boolean z, Continuation<? super Flow<? extends ProfileRequestResult>> continuation) {
        return ((AuthInteractor$activateOrIdentify$1) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.createProfileIfNeeded(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
