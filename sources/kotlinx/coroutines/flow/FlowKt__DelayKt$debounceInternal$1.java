package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {221, 426}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
/* compiled from: Delay.kt */
final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T> $this_debounceInternal;
    final /* synthetic */ Function1<T, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounceInternal$1(Function1<? super T, Long> function1, Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.$timeoutMillisSelector = function1;
        this.$this_debounceInternal = flow;
    }

    public final Object invoke(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, continuation);
        flowKt__DelayKt$debounceInternal$1.L$0 = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.L$1 = flowCollector;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x012d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 0
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L_0x0048
            if (r2 == r7) goto L_0x0031
            if (r2 != r4) goto L_0x0029
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
            java.lang.Object r10 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
            kotlin.ResultKt.throwOnFailure(r18)
            r11 = r10
            r10 = r9
            r9 = r2
            r2 = r0
            goto L_0x0132
        L_0x0029:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0031:
            java.lang.Object r2 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r2 = (kotlin.jvm.internal.Ref.LongRef) r2
            java.lang.Object r9 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r11 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
            kotlin.ResultKt.throwOnFailure(r18)
            r12 = r2
            r2 = r0
            goto L_0x00c1
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r18)
            java.lang.Object r2 = r0.L$0
            r9 = r2
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            r10 = 0
            r11 = 0
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1 r12 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1
            kotlinx.coroutines.flow.Flow<T> r13 = r0.$this_debounceInternal
            r12.<init>(r13, r8)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r13 = 3
            r14 = 0
            kotlinx.coroutines.channels.ReceiveChannel r9 = kotlinx.coroutines.channels.ProduceKt.produce$default(r9, r10, r11, r12, r13, r14)
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r11 = r2
            r2 = r0
            r16 = r10
            r10 = r9
            r9 = r16
        L_0x0071:
            T r12 = r9.element
            kotlinx.coroutines.internal.Symbol r13 = kotlinx.coroutines.flow.internal.NullSurrogateKt.DONE
            if (r12 == r13) goto L_0x0136
            kotlin.jvm.internal.Ref$LongRef r12 = new kotlin.jvm.internal.Ref$LongRef
            r12.<init>()
            T r13 = r9.element
            if (r13 == 0) goto L_0x00c3
            kotlin.jvm.functions.Function1<T, java.lang.Long> r13 = r2.$timeoutMillisSelector
            kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL
            T r15 = r9.element
            if (r15 != r14) goto L_0x0089
            r15 = r8
        L_0x0089:
            java.lang.Object r13 = r13.invoke(r15)
            java.lang.Number r13 = (java.lang.Number) r13
            long r13 = r13.longValue()
            r12.element = r13
            long r13 = r12.element
            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r13 < 0) goto L_0x009d
            r13 = r7
            goto L_0x009e
        L_0x009d:
            r13 = r3
        L_0x009e:
            if (r13 == 0) goto L_0x00c9
            long r13 = r12.element
            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r13 != 0) goto L_0x00c3
            kotlinx.coroutines.internal.Symbol r13 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL
            T r14 = r9.element
            if (r14 != r13) goto L_0x00ad
            r14 = r8
        L_0x00ad:
            r13 = r2
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r2.L$0 = r11
            r2.L$1 = r10
            r2.L$2 = r9
            r2.L$3 = r12
            r2.label = r7
            java.lang.Object r13 = r11.emit(r14, r13)
            if (r13 != r1) goto L_0x00c1
            return r1
        L_0x00c1:
            r9.element = r8
        L_0x00c3:
            r16 = r9
            r9 = r2
            r2 = r16
            goto L_0x00d5
        L_0x00c9:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Debounce timeout should not be negative"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x00d5:
            boolean r13 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()
            if (r13 == 0) goto L_0x00f2
            T r13 = r2.element
            if (r13 == 0) goto L_0x00e8
            long r13 = r12.element
            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r13 <= 0) goto L_0x00e6
            goto L_0x00e8
        L_0x00e6:
            r13 = r3
            goto L_0x00e9
        L_0x00e8:
            r13 = r7
        L_0x00e9:
            if (r13 == 0) goto L_0x00ec
            goto L_0x00f2
        L_0x00ec:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x00f2:
            kotlinx.coroutines.selects.SelectImplementation r13 = new kotlinx.coroutines.selects.SelectImplementation
            kotlin.coroutines.CoroutineContext r14 = r9.getContext()
            r13.<init>(r14)
            r14 = r13
            kotlinx.coroutines.selects.SelectBuilder r14 = (kotlinx.coroutines.selects.SelectBuilder) r14
            T r15 = r2.element
            if (r15 == 0) goto L_0x010e
            long r5 = r12.element
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1 r12 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1
            r12.<init>(r11, r2, r8)
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            kotlinx.coroutines.selects.OnTimeoutKt.onTimeout(r14, r5, r12)
        L_0x010e:
            kotlinx.coroutines.selects.SelectClause1 r5 = r10.getOnReceiveCatching()
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2 r6 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2
            r6.<init>(r2, r11, r8)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r14.invoke(r5, r6)
            r9.L$0 = r11
            r9.L$1 = r10
            r9.L$2 = r2
            r9.L$3 = r8
            r9.label = r4
            java.lang.Object r5 = r13.doSelect(r9)
            if (r5 != r1) goto L_0x012d
            return r1
        L_0x012d:
            r16 = r9
            r9 = r2
            r2 = r16
        L_0x0132:
            r5 = 0
            goto L_0x0071
        L_0x0136:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
