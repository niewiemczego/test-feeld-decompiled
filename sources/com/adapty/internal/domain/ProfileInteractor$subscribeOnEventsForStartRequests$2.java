package com.adapty.internal.domain;

import com.adapty.internal.data.models.ProfileDto;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0016\u0010\u0003\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0002H@"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/adapty/internal/data/models/ProfileDto;", "<name for destructuring parameter 0>", "currentProfile"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.ProfileInteractor$subscribeOnEventsForStartRequests$2", f = "ProfileInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProfileInteractor.kt */
final class ProfileInteractor$subscribeOnEventsForStartRequests$2 extends SuspendLambda implements Function3<Pair<? extends ProfileDto, ? extends ProfileDto>, ProfileDto, Continuation<? super Pair<? extends ProfileDto, ? extends ProfileDto>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    ProfileInteractor$subscribeOnEventsForStartRequests$2(Continuation<? super ProfileInteractor$subscribeOnEventsForStartRequests$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(Pair<ProfileDto, ProfileDto> pair, ProfileDto profileDto, Continuation<? super Pair<ProfileDto, ProfileDto>> continuation) {
        ProfileInteractor$subscribeOnEventsForStartRequests$2 profileInteractor$subscribeOnEventsForStartRequests$2 = new ProfileInteractor$subscribeOnEventsForStartRequests$2(continuation);
        profileInteractor$subscribeOnEventsForStartRequests$2.L$0 = pair;
        profileInteractor$subscribeOnEventsForStartRequests$2.L$1 = profileDto;
        return profileInteractor$subscribeOnEventsForStartRequests$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return TuplesKt.to((ProfileDto) ((Pair) this.L$0).component2(), (ProfileDto) this.L$1);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
