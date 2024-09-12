package com.adapty.internal.domain;

import com.adapty.internal.data.models.InstallationMeta;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "Lcom/adapty/internal/data/models/InstallationMeta;", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.ProfileInteractor$updateProfile$1", f = "ProfileInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProfileInteractor.kt */
final class ProfileInteractor$updateProfile$1 extends SuspendLambda implements Function2<Unit, Continuation<? super Flow<? extends InstallationMeta>>, Object> {
    int label;
    final /* synthetic */ ProfileInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileInteractor$updateProfile$1(ProfileInteractor profileInteractor, Continuation<? super ProfileInteractor$updateProfile$1> continuation) {
        super(2, continuation);
        this.this$0 = profileInteractor;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileInteractor$updateProfile$1(this.this$0, continuation);
    }

    public final Object invoke(Unit unit, Continuation<? super Flow<InstallationMeta>> continuation) {
        return ((ProfileInteractor$updateProfile$1) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.authInteractor.createInstallationMeta(false);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
