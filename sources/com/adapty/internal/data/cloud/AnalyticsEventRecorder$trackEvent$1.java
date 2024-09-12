package com.adapty.internal.data.cloud;

import com.adapty.internal.data.models.AnalyticsEvent;
import com.adapty.utils.ErrorCallback;
import java.util.Map;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.AnalyticsEventRecorder$trackEvent$1", f = "AnalyticsEventRecorder.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AnalyticsEventRecorder.kt */
final class AnalyticsEventRecorder$trackEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ErrorCallback $completion;
    final /* synthetic */ String $eventName;
    final /* synthetic */ Function2<AnalyticsEvent, Continuation<? super Unit>, Object> $onEventRegistered;
    final /* synthetic */ Map<String, Object> $subMap;
    int label;
    final /* synthetic */ AnalyticsEventRecorder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnalyticsEventRecorder$trackEvent$1(AnalyticsEventRecorder analyticsEventRecorder, String str, Map<String, ? extends Object> map, Function2<? super AnalyticsEvent, ? super Continuation<? super Unit>, ? extends Object> function2, ErrorCallback errorCallback, Continuation<? super AnalyticsEventRecorder$trackEvent$1> continuation) {
        super(2, continuation);
        this.this$0 = analyticsEventRecorder;
        this.$eventName = str;
        this.$subMap = map;
        this.$onEventRegistered = function2;
        this.$completion = errorCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnalyticsEventRecorder$trackEvent$1(this.this$0, this.$eventName, this.$subMap, this.$onEventRegistered, this.$completion, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnalyticsEventRecorder$trackEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.adapty.internal.data.cloud.AnalyticsEventRecorder$trackEvent$1$1", f = "AnalyticsEventRecorder.kt", i = {0, 0, 1}, l = {47, 48, 50}, m = "invokeSuspend", n = {"$this$flow", "event", "$this$flow"}, s = {"L$0", "L$1", "L$0"})
    /* renamed from: com.adapty.internal.data.cloud.AnalyticsEventRecorder$trackEvent$1$1  reason: invalid class name */
    /* compiled from: AnalyticsEventRecorder.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Unit>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(analyticsEventRecorder, str, map, function2, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(FlowCollector<? super Unit> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x008d A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L_0x0034
                if (r1 == r5) goto L_0x0027
                if (r1 == r4) goto L_0x001f
                if (r1 != r3) goto L_0x0017
                kotlin.ResultKt.throwOnFailure(r9)
                goto L_0x008e
            L_0x0017:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x001f:
                java.lang.Object r1 = r8.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r9)
                goto L_0x007d
            L_0x0027:
                java.lang.Object r1 = r8.L$1
                com.adapty.internal.data.models.AnalyticsEvent r1 = (com.adapty.internal.data.models.AnalyticsEvent) r1
                java.lang.Object r5 = r8.L$0
                kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                kotlin.ResultKt.throwOnFailure(r9)
                r9 = r5
                goto L_0x006d
            L_0x0034:
                kotlin.ResultKt.throwOnFailure(r9)
                java.lang.Object r9 = r8.L$0
                kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
                com.adapty.internal.data.cloud.AnalyticsEventRecorder r1 = r4
                com.adapty.internal.data.cache.CacheRepository r1 = r1.cacheRepository
                com.adapty.internal.data.models.AnalyticsConfig r1 = r1.getAnalyticsConfig()
                java.util.List r1 = r1.getDisabledEventTypes()
                java.lang.String r6 = r5
                boolean r1 = r1.contains(r6)
                if (r1 != 0) goto L_0x007e
                com.adapty.internal.data.cloud.AnalyticsEventRecorder r1 = r4
                java.lang.String r6 = r5
                java.util.Map<java.lang.String, java.lang.Object> r7 = r6
                com.adapty.internal.data.models.AnalyticsEvent r1 = r1.createEvent(r6, r7)
                com.adapty.internal.data.cloud.AnalyticsEventRecorder r6 = r4
                r7 = r8
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r8.L$0 = r9
                r8.L$1 = r1
                r8.label = r5
                java.lang.Object r5 = r6.retainEvent(r1, r7)
                if (r5 != r0) goto L_0x006d
                return r0
            L_0x006d:
                kotlin.jvm.functions.Function2<com.adapty.internal.data.models.AnalyticsEvent, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r5 = r7
                r8.L$0 = r9
                r8.L$1 = r2
                r8.label = r4
                java.lang.Object r1 = r5.invoke(r1, r8)
                if (r1 != r0) goto L_0x007c
                return r0
            L_0x007c:
                r1 = r9
            L_0x007d:
                r9 = r1
            L_0x007e:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                r4 = r8
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r8.L$0 = r2
                r8.label = r3
                java.lang.Object r9 = r9.emit(r1, r4)
                if (r9 != r0) goto L_0x008e
                return r0
            L_0x008e:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cloud.AnalyticsEventRecorder$trackEvent$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Flow flow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final AnalyticsEventRecorder analyticsEventRecorder = this.this$0;
            final String str = this.$eventName;
            final Map<String, Object> map = this.$subMap;
            final Function2<AnalyticsEvent, Continuation<? super Unit>, Object> function2 = this.$onEventRegistered;
            Flow flow2 = FlowKt.flow(new AnonymousClass1((Continuation<? super AnonymousClass1>) null));
            ErrorCallback errorCallback = this.$completion;
            if (errorCallback != null) {
                flow = Intrinsics.checkNotNullParameter(FlowKt.onEach(FlowKt.m2547catch(Intrinsics.checkNotNullParameter(flow2, "<this>"), new AnalyticsEventRecorder$trackEvent$1$2$1(errorCallback, (Continuation<? super AnalyticsEventRecorder$trackEvent$1$2$1>) null)), new AnalyticsEventRecorder$trackEvent$1$2$2(errorCallback, (Continuation<? super AnalyticsEventRecorder$trackEvent$1$2$2>) null)), "<this>");
            } else {
                flow = FlowKt.m2547catch(flow2, new AnalyticsEventRecorder$trackEvent$1$2$3((Continuation<? super AnalyticsEventRecorder$trackEvent$1$2$3>) null));
            }
            this.label = 1;
            if (FlowKt.collect(Intrinsics.checkNotNullParameter(flow, "<this>"), this) == coroutine_suspended) {
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
