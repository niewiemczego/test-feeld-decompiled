package com.adapty.internal;

import com.adapty.internal.data.cloud.AnalyticsTracker;
import com.adapty.internal.data.models.AnalyticsEvent;
import com.adapty.internal.domain.models.ProfileRequestResult;
import com.adapty.internal.utils.UtilsKt;
import com.adapty.utils.AdaptyResult;
import com.adapty.utils.ErrorCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.AdaptyInternal$activate$1", f = "AdaptyInternal.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AdaptyInternal.kt */
final class AdaptyInternal$activate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ErrorCallback $callback;
    final /* synthetic */ String $customerUserId;
    final /* synthetic */ boolean $isInitialActivation;
    final /* synthetic */ AnalyticsEvent.SDKMethodRequestData $requestEvent;
    int label;
    final /* synthetic */ AdaptyInternal this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdaptyInternal$activate$1(AdaptyInternal adaptyInternal, String str, AnalyticsEvent.SDKMethodRequestData sDKMethodRequestData, ErrorCallback errorCallback, boolean z, Continuation<? super AdaptyInternal$activate$1> continuation) {
        super(2, continuation);
        this.this$0 = adaptyInternal;
        this.$customerUserId = str;
        this.$requestEvent = sDKMethodRequestData;
        this.$callback = errorCallback;
        this.$isInitialActivation = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdaptyInternal$activate$1(this.this$0, this.$customerUserId, this.$requestEvent, this.$callback, this.$isInitialActivation, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdaptyInternal$activate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.authInteractor.prepareAuthDataToSync(this.$customerUserId);
            Flow activateOrIdentify = this.this$0.authInteractor.activateOrIdentify();
            final AdaptyInternal adaptyInternal = this.this$0;
            final AnalyticsEvent.SDKMethodRequestData sDKMethodRequestData = this.$requestEvent;
            final ErrorCallback errorCallback = this.$callback;
            final boolean z = this.$isInitialActivation;
            this.label = 1;
            if (FlowKt.collect(Intrinsics.checkNotNullParameter(UtilsKt.onSingleResult(activateOrIdentify, new AnonymousClass1((Continuation<? super AnonymousClass1>) null)), "<this>"), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"<anonymous>", "", "result", "Lcom/adapty/utils/AdaptyResult;", "Lcom/adapty/internal/domain/models/ProfileRequestResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.adapty.internal.AdaptyInternal$activate$1$1", f = "AdaptyInternal.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.adapty.internal.AdaptyInternal$activate$1$1  reason: invalid class name */
    /* compiled from: AdaptyInternal.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<AdaptyResult<? extends ProfileRequestResult>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(adaptyInternal, sDKMethodRequestData, errorCallback, z, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AdaptyResult<? extends ProfileRequestResult> adaptyResult, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(adaptyResult, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AdaptyResult adaptyResult = (AdaptyResult) this.L$0;
                AnalyticsTracker.DefaultImpls.trackSystemEvent$default(adaptyInternal.analyticsTracker, AnalyticsEvent.SDKMethodResponseData.Companion.create(sDKMethodRequestData, UtilsKt.errorOrNull(adaptyResult)), (Function2) null, 2, (Object) null);
                ErrorCallback errorCallback = errorCallback;
                if (errorCallback != null) {
                    errorCallback.onResult(UtilsKt.errorOrNull(adaptyResult));
                }
                if (z) {
                    adaptyInternal.setupStartRequests();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}