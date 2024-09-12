package com.adapty.internal;

import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.adapty.models.AdaptyProfile;
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
@DebugMetadata(c = "com.adapty.internal.AdaptyInternal$setupStartRequests$1$2$2$1", f = "AdaptyInternal.kt", i = {}, l = {400}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AdaptyInternal.kt */
final class AdaptyInternal$setupStartRequests$1$2$2$1 extends SuspendLambda implements Function3<FlowCollector<? super AdaptyProfile>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ AdaptyInternal this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdaptyInternal$setupStartRequests$1$2$2$1(AdaptyInternal adaptyInternal, Continuation<? super AdaptyInternal$setupStartRequests$1$2$2$1> continuation) {
        super(3, continuation);
        this.this$0 = adaptyInternal;
    }

    public final Object invoke(FlowCollector<? super AdaptyProfile> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        AdaptyInternal$setupStartRequests$1$2$2$1 adaptyInternal$setupStartRequests$1$2$2$1 = new AdaptyInternal$setupStartRequests$1$2$2$1(this.this$0, continuation);
        adaptyInternal$setupStartRequests$1$2$2$1.L$0 = flowCollector;
        adaptyInternal$setupStartRequests$1$2$2$1.L$1 = th;
        return adaptyInternal$setupStartRequests$1$2$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th = (Throwable) this.L$1;
            AdaptyError adaptyError = th instanceof AdaptyError ? (AdaptyError) th : null;
            if ((adaptyError != null ? adaptyError.getAdaptyErrorCode() : null) == AdaptyErrorCode.NO_PURCHASES_TO_RESTORE) {
                this.L$0 = null;
                this.label = 1;
                if (FlowKt.emitAll(flowCollector, FlowKt.m2547catch(this.this$0.profileInteractor.getProfileOnStart(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null)), (Continuation<? super Unit>) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/adapty/models/AdaptyProfile;", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.adapty.internal.AdaptyInternal$setupStartRequests$1$2$2$1$1", f = "AdaptyInternal.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.adapty.internal.AdaptyInternal$setupStartRequests$1$2$2$1$1  reason: invalid class name */
    /* compiled from: AdaptyInternal.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super AdaptyProfile>, Throwable, Continuation<? super Unit>, Object> {
        int label;

        public final Object invoke(FlowCollector<? super AdaptyProfile> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return new AnonymousClass1(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
