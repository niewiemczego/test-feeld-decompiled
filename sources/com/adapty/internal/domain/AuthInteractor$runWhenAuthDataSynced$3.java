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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "T", "result", "Lcom/adapty/internal/domain/models/ProfileRequestResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.AuthInteractor$runWhenAuthDataSynced$3", f = "AuthInteractor.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AuthInteractor.kt */
final class AuthInteractor$runWhenAuthDataSynced$3 extends SuspendLambda implements Function2<ProfileRequestResult, Continuation<? super T>, Object> {
    final /* synthetic */ Function1<Continuation<? super T>, Object> $call;
    final /* synthetic */ Function0<T> $switchIfProfileCreationFailed;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthInteractor$runWhenAuthDataSynced$3(Function0<? extends T> function0, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super AuthInteractor$runWhenAuthDataSynced$3> continuation) {
        super(2, continuation);
        this.$switchIfProfileCreationFailed = function0;
        this.$call = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AuthInteractor$runWhenAuthDataSynced$3 authInteractor$runWhenAuthDataSynced$3 = new AuthInteractor$runWhenAuthDataSynced$3(this.$switchIfProfileCreationFailed, this.$call, continuation);
        authInteractor$runWhenAuthDataSynced$3.L$0 = obj;
        return authInteractor$runWhenAuthDataSynced$3;
    }

    public final Object invoke(ProfileRequestResult profileRequestResult, Continuation<? super T> continuation) {
        return ((AuthInteractor$runWhenAuthDataSynced$3) create(profileRequestResult, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        T invoke;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProfileRequestResult profileRequestResult = (ProfileRequestResult) this.L$0;
            if (profileRequestResult instanceof ProfileRequestResult.ProfileNotCreated) {
                Function0<T> function0 = this.$switchIfProfileCreationFailed;
                if (function0 != null && (invoke = function0.invoke()) != null) {
                    return invoke;
                }
                throw ((ProfileRequestResult.ProfileNotCreated) profileRequestResult).getError();
            }
            Function1<Continuation<? super T>, Object> function1 = this.$call;
            this.label = 1;
            Object invoke2 = function1.invoke(this);
            return invoke2 == coroutine_suspended ? coroutine_suspended : invoke2;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
