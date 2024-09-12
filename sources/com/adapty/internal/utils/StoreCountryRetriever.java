package com.adapty.internal.utils;

import com.adapty.internal.data.cloud.StoreManager;
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
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/adapty/internal/utils/StoreCountryRetriever;", "", "storeManager", "Lcom/adapty/internal/data/cloud/StoreManager;", "(Lcom/adapty/internal/data/cloud/StoreManager;)V", "cachedStoreCountry", "", "semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "getStoreCountryIfAvailable", "Lkotlinx/coroutines/flow/Flow;", "forceUpdate", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: StoreCountryRetriever.kt */
public final class StoreCountryRetriever {
    /* access modifiers changed from: private */
    public volatile String cachedStoreCountry;
    /* access modifiers changed from: private */
    public final Semaphore semaphore = SemaphoreKt.Semaphore$default(1, 0, 2, (Object) null);
    /* access modifiers changed from: private */
    public final StoreManager storeManager;

    public StoreCountryRetriever(StoreManager storeManager2) {
        Intrinsics.checkNotNullParameter(storeManager2, "storeManager");
        this.storeManager = storeManager2;
        Job unused = Intrinsics.checkNotNullParameter(new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), "block");
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.adapty.internal.utils.StoreCountryRetriever$1", f = "StoreCountryRetriever.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.adapty.internal.utils.StoreCountryRetriever$1  reason: invalid class name */
    /* compiled from: StoreCountryRetriever.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ StoreCountryRetriever this$0;

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
                if (FlowKt.collect(this.this$0.getStoreCountryIfAvailable(true), this) == coroutine_suspended) {
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

    public final Flow<String> getStoreCountryIfAvailable(boolean z) {
        return Intrinsics.checkNotNullParameter(FlowKt.flow(new StoreCountryRetriever$getStoreCountryIfAvailable$1(z, this, (Continuation<? super StoreCountryRetriever$getStoreCountryIfAvailable$1>) null)), "<this>");
    }
}
