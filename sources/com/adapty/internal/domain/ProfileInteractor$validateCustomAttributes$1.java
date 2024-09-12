package com.adapty.internal.domain;

import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.ProfileInteractor$validateCustomAttributes$1", f = "ProfileInteractor.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProfileInteractor.kt */
final class ProfileInteractor$validateCustomAttributes$1 extends SuspendLambda implements Function2<FlowCollector<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Object> $attrs;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProfileInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileInteractor$validateCustomAttributes$1(Map<String, ? extends Object> map, ProfileInteractor profileInteractor, Continuation<? super ProfileInteractor$validateCustomAttributes$1> continuation) {
        super(2, continuation);
        this.$attrs = map;
        this.this$0 = profileInteractor;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProfileInteractor$validateCustomAttributes$1 profileInteractor$validateCustomAttributes$1 = new ProfileInteractor$validateCustomAttributes$1(this.$attrs, this.this$0, continuation);
        profileInteractor$validateCustomAttributes$1.L$0 = obj;
        return profileInteractor$validateCustomAttributes$1;
    }

    public final Object invoke(FlowCollector<? super Unit> flowCollector, Continuation<? super Unit> continuation) {
        return ((ProfileInteractor$validateCustomAttributes$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Map<String, Object> map = this.$attrs;
            if (map != null) {
                this.this$0.customAttributeValidator.validate(map);
            }
            this.label = 1;
            if (flowCollector.emit(Unit.INSTANCE, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
