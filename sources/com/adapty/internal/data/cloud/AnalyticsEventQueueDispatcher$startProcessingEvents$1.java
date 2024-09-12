package com.adapty.internal.data.cloud;

import com.adapty.internal.data.models.AnalyticsEvent;
import java.util.List;
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
@DebugMetadata(c = "com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher$startProcessingEvents$1", f = "AnalyticsEventQueueDispatcher.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AnalyticsEventQueueDispatcher.kt */
final class AnalyticsEventQueueDispatcher$startProcessingEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AnalyticsEventQueueDispatcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnalyticsEventQueueDispatcher$startProcessingEvents$1(AnalyticsEventQueueDispatcher analyticsEventQueueDispatcher, Continuation<? super AnalyticsEventQueueDispatcher$startProcessingEvents$1> continuation) {
        super(2, continuation);
        this.this$0 = analyticsEventQueueDispatcher;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnalyticsEventQueueDispatcher$startProcessingEvents$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnalyticsEventQueueDispatcher$startProcessingEvents$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final AnalyticsEventQueueDispatcher analyticsEventQueueDispatcher = this.this$0;
            this.label = 1;
            if (FlowKt.collect(Intrinsics.checkNotNullParameter(FlowKt.flatMapConcat(this.this$0.eventFlow, new AnonymousClass1((Continuation<? super AnonymousClass1>) null)), "<this>"), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "", "event", "Lcom/adapty/internal/data/models/AnalyticsEvent;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher$startProcessingEvents$1$1", f = "AnalyticsEventQueueDispatcher.kt", i = {0}, l = {39}, m = "invokeSuspend", n = {"event"}, s = {"L$0"})
    /* renamed from: com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher$startProcessingEvents$1$1  reason: invalid class name */
    /* compiled from: AnalyticsEventQueueDispatcher.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<AnalyticsEvent, Continuation<? super Flow<? extends Unit>>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(analyticsEventQueueDispatcher, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AnalyticsEvent analyticsEvent, Continuation<? super Flow<Unit>> continuation) {
            return ((AnonymousClass1) create(analyticsEvent, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            final AnalyticsEvent analyticsEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnalyticsEvent analyticsEvent2 = (AnalyticsEvent) this.L$0;
                this.L$0 = analyticsEvent2;
                this.label = 1;
                if (analyticsEventQueueDispatcher.dataRemoteSemaphore.acquire(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                analyticsEvent = analyticsEvent2;
            } else if (i == 1) {
                analyticsEvent = (AnalyticsEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Flow onActivateAllowed = analyticsEventQueueDispatcher.lifecycleManager.onActivateAllowed();
            final AnalyticsEventQueueDispatcher analyticsEventQueueDispatcher = analyticsEventQueueDispatcher;
            Flow retryIfNecessary = Intrinsics.checkNotNullParameter(FlowKt.mapLatest(onActivateAllowed, new Function2<Boolean, Continuation<? super List<? extends String>>, Object>((Continuation<? super AnonymousClass1>) null) {
                int label;

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return 
                }
