package com.adapty.internal.domain;

import com.adapty.internal.data.cloud.Request;
import com.adapty.internal.data.models.ProfileDto;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H@"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/adapty/internal/data/models/ProfileDto;", "Lcom/adapty/internal/data/cloud/Request$CurrentDataWhenSent;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.ProfileInteractor$getProfile$1", f = "ProfileInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProfileInteractor.kt */
final class ProfileInteractor$getProfile$1 extends SuspendLambda implements Function1<Continuation<? super Pair<? extends ProfileDto, ? extends Request.CurrentDataWhenSent>>, Object> {
    int label;
    final /* synthetic */ ProfileInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileInteractor$getProfile$1(ProfileInteractor profileInteractor, Continuation<? super ProfileInteractor$getProfile$1> continuation) {
        super(1, continuation);
        this.this$0 = profileInteractor;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ProfileInteractor$getProfile$1(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Pair<ProfileDto, Request.CurrentDataWhenSent>> continuation) {
        return ((ProfileInteractor$getProfile$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.cloudRepository.getProfile();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}