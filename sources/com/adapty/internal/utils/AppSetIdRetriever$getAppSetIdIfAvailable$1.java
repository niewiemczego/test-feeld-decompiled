package com.adapty.internal.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.utils.AppSetIdRetriever$getAppSetIdIfAvailable$1", f = "AppSetIdRetriever.kt", i = {1}, l = {30, 34, 37, 49}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* compiled from: AppSetIdRetriever.kt */
final class AppSetIdRetriever$getAppSetIdIfAvailable$1 extends SuspendLambda implements Function2<FlowCollector<? super String>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppSetIdRetriever this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppSetIdRetriever$getAppSetIdIfAvailable$1(AppSetIdRetriever appSetIdRetriever, Continuation<? super AppSetIdRetriever$getAppSetIdIfAvailable$1> continuation) {
        super(2, continuation);
        this.this$0 = appSetIdRetriever;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AppSetIdRetriever$getAppSetIdIfAvailable$1 appSetIdRetriever$getAppSetIdIfAvailable$1 = new AppSetIdRetriever$getAppSetIdIfAvailable$1(this.this$0, continuation);
        appSetIdRetriever$getAppSetIdIfAvailable$1.L$0 = obj;
        return appSetIdRetriever$getAppSetIdIfAvailable$1;
    }

    public final Object invoke(FlowCollector<? super String> flowCollector, Continuation<? super Unit> continuation) {
        return ((AppSetIdRetriever$getAppSetIdIfAvailable$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0081 A[SYNTHETIC, Splitter:B:29:0x0081] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 == r5) goto L_0x002d
            if (r1 == r4) goto L_0x0025
            if (r1 == r3) goto L_0x0021
            if (r1 != r2) goto L_0x0019
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x00bb
        L_0x0019:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x007e
        L_0x0025:
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0061
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004a
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            com.adapty.internal.utils.AppSetIdRetriever r7 = r6.this$0
            java.lang.String r7 = r7.cachedAppSetId
            if (r7 == 0) goto L_0x004d
            r6.label = r5
            java.lang.Object r7 = r1.emit(r7, r6)
            if (r7 != r0) goto L_0x004a
            return r0
        L_0x004a:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x004d:
            com.adapty.internal.utils.AppSetIdRetriever r7 = r6.this$0
            kotlinx.coroutines.sync.Semaphore r7 = r7.semaphore
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.L$0 = r1
            r6.label = r4
            java.lang.Object r7 = r7.acquire(r5)
            if (r7 != r0) goto L_0x0061
            return r0
        L_0x0061:
            com.adapty.internal.utils.AppSetIdRetriever r7 = r6.this$0
            java.lang.String r7 = r7.cachedAppSetId
            r4 = 0
            if (r7 == 0) goto L_0x0081
            com.adapty.internal.utils.AppSetIdRetriever r2 = r6.this$0
            kotlinx.coroutines.sync.Semaphore r2 = r2.semaphore
            r2.release()
            r6.L$0 = r4
            r6.label = r3
            java.lang.Object r7 = r1.emit(r7, r6)
            if (r7 != r0) goto L_0x007e
            return r0
        L_0x007e:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0081:
            com.adapty.internal.utils.AppSetIdRetriever r7 = r6.this$0     // Catch:{ Exception -> 0x009a }
            android.content.Context r7 = r7.appContext     // Catch:{ Exception -> 0x009a }
            com.google.android.gms.appset.AppSetIdClient r7 = com.google.android.gms.appset.AppSet.getClient(r7)     // Catch:{ Exception -> 0x009a }
            com.google.android.gms.tasks.Task r7 = r7.getAppSetIdInfo()     // Catch:{ Exception -> 0x009a }
            java.lang.Object r7 = com.google.android.gms.tasks.Tasks.await(r7)     // Catch:{ Exception -> 0x009a }
            com.google.android.gms.appset.AppSetIdInfo r7 = (com.google.android.gms.appset.AppSetIdInfo) r7     // Catch:{ Exception -> 0x009a }
            java.lang.String r7 = r7.getId()     // Catch:{ Exception -> 0x009a }
            goto L_0x009b
        L_0x009a:
            r7 = r4
        L_0x009b:
            com.adapty.internal.utils.AppSetIdRetriever r3 = r6.this$0
            r3.cachedAppSetId = r7
            com.adapty.internal.utils.AppSetIdRetriever r3 = r6.this$0
            kotlinx.coroutines.sync.Semaphore r3 = r3.semaphore
            r3.release()
            if (r7 != 0) goto L_0x00ad
            java.lang.String r7 = ""
        L_0x00ad:
            r3 = r6
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r6.L$0 = r4
            r6.label = r2
            java.lang.Object r7 = r1.emit(r7, r3)
            if (r7 != r0) goto L_0x00bb
            return r0
        L_0x00bb:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.AppSetIdRetriever$getAppSetIdIfAvailable$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
