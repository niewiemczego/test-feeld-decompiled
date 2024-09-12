package com.adapty.internal.utils;

import com.adapty.internal.data.cloud.CloudRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0007@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/adapty/internal/utils/IPv4Retriever;", "", "cloudRepository", "Lcom/adapty/internal/data/cloud/CloudRepository;", "(Lcom/adapty/internal/data/cloud/CloudRepository;)V", "onValueReceived", "Lkotlin/Function1;", "", "", "getOnValueReceived", "()Lkotlin/jvm/functions/Function1;", "setOnValueReceived", "(Lkotlin/jvm/functions/Function1;)V", "value", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "getIPv4", "Lkotlinx/coroutines/flow/Flow;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IPv4Retriever.kt */
public final class IPv4Retriever {
    /* access modifiers changed from: private */
    public final CloudRepository cloudRepository;
    private Function1<? super String, Unit> onValueReceived;
    private volatile String value;

    public IPv4Retriever(CloudRepository cloudRepository2) {
        Intrinsics.checkNotNullParameter(cloudRepository2, "cloudRepository");
        this.cloudRepository = cloudRepository2;
        Job unused = Intrinsics.checkNotNullParameter(new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), "block");
    }

    public final String getValue() {
        return this.value;
    }

    /* access modifiers changed from: private */
    public final void setValue(String str) {
        Function1<? super String, Unit> function1;
        this.value = str;
        if (str != null && (function1 = this.onValueReceived) != null) {
            function1.invoke(str);
        }
    }

    public final Function1<String, Unit> getOnValueReceived() {
        return this.onValueReceived;
    }

    public final void setOnValueReceived(Function1<? super String, Unit> function1) {
        this.onValueReceived = function1;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.adapty.internal.utils.IPv4Retriever$1", f = "IPv4Retriever.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.adapty.internal.utils.IPv4Retriever$1  reason: invalid class name */
    /* compiled from: IPv4Retriever.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ IPv4Retriever this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collect(FlowKt.m2547catch(FlowKt.retryWhen(this.this$0.getIPv4(), new Function4<FlowCollector<? super String>, Throwable, Long, Continuation<? super Boolean>, Object>((Continuation<? super AnonymousClass1>) null) {
                    int label;

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke((FlowCollector<? super String>) (FlowCollector) obj, (Throwable) obj2, ((Number) obj3).longValue(), (Continuation<? super Boolean>) (Continuation) obj4);
                    }

                    public final Object invoke(FlowCollector<? super String> flowCollector, Throwable th, long j, Continuation<? super Boolean> continuation) {
                        return 

                        /* access modifiers changed from: private */
                        public final Flow<String> getIPv4() {
                            return Intrinsics.checkNotNullParameter(FlowKt.flow(new IPv4Retriever$getIPv4$1(this, (Continuation<? super IPv4Retriever$getIPv4$1>) null)), "<this>");
                        }
                    }
