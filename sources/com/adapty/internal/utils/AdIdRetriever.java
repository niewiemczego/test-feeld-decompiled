package com.adapty.internal.utils;

import android.content.Context;
import com.adapty.internal.data.cache.CacheRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/adapty/internal/utils/AdIdRetriever;", "", "appContext", "Landroid/content/Context;", "cacheRepository", "Lcom/adapty/internal/data/cache/CacheRepository;", "(Landroid/content/Context;Lcom/adapty/internal/data/cache/CacheRepository;)V", "adIdSemaphore", "Lkotlinx/coroutines/sync/Semaphore;", "cachedAdvertisingId", "", "getAdIdIfAvailable", "Lkotlinx/coroutines/flow/Flow;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdIdRetriever.kt */
public final class AdIdRetriever {
    /* access modifiers changed from: private */
    public final Semaphore adIdSemaphore = SemaphoreKt.Semaphore$default(1, 0, 2, (Object) null);
    /* access modifiers changed from: private */
    public final Context appContext;
    /* access modifiers changed from: private */
    public final CacheRepository cacheRepository;
    /* access modifiers changed from: private */
    public volatile String cachedAdvertisingId;

    public AdIdRetriever(Context context, CacheRepository cacheRepository2) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(cacheRepository2, "cacheRepository");
        this.appContext = context;
        this.cacheRepository = cacheRepository2;
        Job unused = Intrinsics.checkNotNullParameter(new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), "block");
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.adapty.internal.utils.AdIdRetriever$1", f = "AdIdRetriever.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.adapty.internal.utils.AdIdRetriever$1  reason: invalid class name */
    /* compiled from: AdIdRetriever.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AdIdRetriever this$0;

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
                if (FlowKt.collect(FlowKt.m2547catch(this.this$0.getAdIdIfAvailable(), new Function3<FlowCollector<? super String>, Throwable, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    private /* synthetic */ Object L$0;
                    int label;

                    public final Object invoke(FlowCollector<? super String> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                        AnonymousClass1 r2 = 

                        public final Flow<String> getAdIdIfAvailable() {
                            return Intrinsics.checkNotNullParameter(FlowKt.flow(new AdIdRetriever$getAdIdIfAvailable$1(this, (Continuation<? super AdIdRetriever$getAdIdIfAvailable$1>) null)), "<this>");
                        }
                    }
