package expo.modules.kotlin.functions;

import expo.modules.kotlin.jni.JavaScriptModuleObject;
import expo.modules.kotlin.jni.PromiseImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "expo.modules.kotlin.functions.SuspendFunctionComponent$attachToJSObject$2$1", f = "SuspendFunctionComponent.kt", i = {0}, l = {64}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: SuspendFunctionComponent.kt */
final class SuspendFunctionComponent$attachToJSObject$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object[] $args;
    final /* synthetic */ PromiseImpl $bridgePromise;
    final /* synthetic */ JavaScriptModuleObject $jsObject;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ SuspendFunctionComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuspendFunctionComponent$attachToJSObject$2$1(PromiseImpl promiseImpl, SuspendFunctionComponent suspendFunctionComponent, JavaScriptModuleObject javaScriptModuleObject, Object[] objArr, Continuation<? super SuspendFunctionComponent$attachToJSObject$2$1> continuation) {
        super(2, continuation);
        this.$bridgePromise = promiseImpl;
        this.this$0 = suspendFunctionComponent;
        this.$jsObject = javaScriptModuleObject;
        this.$args = objArr;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SuspendFunctionComponent$attachToJSObject$2$1 suspendFunctionComponent$attachToJSObject$2$1 = new SuspendFunctionComponent$attachToJSObject$2$1(this.$bridgePromise, this.this$0, this.$jsObject, this.$args, continuation);
        suspendFunctionComponent$attachToJSObject$2$1.L$0 = obj;
        return suspendFunctionComponent$attachToJSObject$2$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuspendFunctionComponent$attachToJSObject$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: kotlinx.coroutines.CoroutineScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L_0x002e
            if (r1 != r2) goto L_0x0026
            java.lang.Object r0 = r8.L$3
            expo.modules.kotlin.jni.PromiseImpl r0 = (expo.modules.kotlin.jni.PromiseImpl) r0
            java.lang.Object r1 = r8.L$2
            expo.modules.kotlin.jni.JavaScriptModuleObject r1 = (expo.modules.kotlin.jni.JavaScriptModuleObject) r1
            java.lang.Object r2 = r8.L$1
            expo.modules.kotlin.functions.SuspendFunctionComponent r2 = (expo.modules.kotlin.functions.SuspendFunctionComponent) r2
            java.lang.Object r3 = r8.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ CodedException -> 0x0023, CodedException -> 0x0021, all -> 0x001f }
            goto L_0x005b
        L_0x001f:
            r9 = move-exception
            goto L_0x006a
        L_0x0021:
            r9 = move-exception
            goto L_0x0084
        L_0x0023:
            r9 = move-exception
            goto L_0x00ad
        L_0x0026:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            r3 = r9
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            expo.modules.kotlin.functions.SuspendFunctionComponent r9 = r8.this$0     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            expo.modules.kotlin.jni.JavaScriptModuleObject r1 = r8.$jsObject     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            java.lang.Object[] r4 = r8.$args     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            expo.modules.kotlin.jni.PromiseImpl r5 = r8.$bridgePromise     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            kotlin.jvm.functions.Function3 r6 = r9.body     // Catch:{ CodedException -> 0x00aa, CodedException -> 0x0081, all -> 0x0067 }
            java.lang.Object[] r4 = r9.convertArgs((java.lang.Object[]) r4)     // Catch:{ CodedException -> 0x00aa, CodedException -> 0x0081, all -> 0x0067 }
            r8.L$0 = r3     // Catch:{ CodedException -> 0x00aa, CodedException -> 0x0081, all -> 0x0067 }
            r8.L$1 = r9     // Catch:{ CodedException -> 0x00aa, CodedException -> 0x0081, all -> 0x0067 }
            r8.L$2 = r1     // Catch:{ CodedException -> 0x00aa, CodedException -> 0x0081, all -> 0x0067 }
            r8.L$3 = r5     // Catch:{ CodedException -> 0x00aa, CodedException -> 0x0081, all -> 0x0067 }
            r8.label = r2     // Catch:{ CodedException -> 0x00aa, CodedException -> 0x0081, all -> 0x0067 }
            java.lang.Object r2 = r6.invoke(r3, r4, r8)     // Catch:{ CodedException -> 0x00aa, CodedException -> 0x0081, all -> 0x0067 }
            if (r2 != r0) goto L_0x0057
            return r0
        L_0x0057:
            r0 = r5
            r7 = r2
            r2 = r9
            r9 = r7
        L_0x005b:
            boolean r3 = kotlinx.coroutines.CoroutineScopeKt.isActive(r3)     // Catch:{ CodedException -> 0x0023, CodedException -> 0x0021, all -> 0x001f }
            if (r3 == 0) goto L_0x0064
            r0.resolve(r9)     // Catch:{ CodedException -> 0x0023, CodedException -> 0x0021, all -> 0x001f }
        L_0x0064:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ CodedException -> 0x0023, CodedException -> 0x0021, all -> 0x001f }
            goto L_0x00d1
        L_0x0067:
            r0 = move-exception
            r2 = r9
            r9 = r0
        L_0x006a:
            expo.modules.kotlin.exception.UnexpectedException r0 = new expo.modules.kotlin.exception.UnexpectedException     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            r0.<init>((java.lang.Throwable) r9)     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            expo.modules.kotlin.exception.CodedException r0 = (expo.modules.kotlin.exception.CodedException) r0     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            expo.modules.kotlin.exception.FunctionCallException r9 = new expo.modules.kotlin.exception.FunctionCallException     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            java.lang.String r2 = r2.getName()     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            java.lang.String r1 = r1.getName()     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            r9.<init>(r2, r1, r0)     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            throw r9     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
        L_0x0081:
            r0 = move-exception
            r2 = r9
            r9 = r0
        L_0x0084:
            expo.modules.kotlin.exception.CodedException r0 = new expo.modules.kotlin.exception.CodedException     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            java.lang.String r3 = r9.getCode()     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            java.lang.String r4 = "e.code"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            java.lang.String r4 = r9.getMessage()     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            java.lang.Throwable r9 = r9.getCause()     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            r0.<init>(r3, r4, r9)     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            expo.modules.kotlin.exception.FunctionCallException r9 = new expo.modules.kotlin.exception.FunctionCallException     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            java.lang.String r2 = r2.getName()     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            java.lang.String r1 = r1.getName()     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            r9.<init>(r2, r1, r0)     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            throw r9     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
        L_0x00aa:
            r0 = move-exception
            r2 = r9
            r9 = r0
        L_0x00ad:
            expo.modules.kotlin.exception.FunctionCallException r0 = new expo.modules.kotlin.exception.FunctionCallException     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            java.lang.String r2 = r2.getName()     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            java.lang.String r1 = r1.getName()     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            r0.<init>(r2, r1, r9)     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
            throw r0     // Catch:{ CodedException -> 0x00cb, all -> 0x00bd }
        L_0x00bd:
            r9 = move-exception
            expo.modules.kotlin.jni.PromiseImpl r0 = r8.$bridgePromise
            expo.modules.kotlin.exception.UnexpectedException r1 = new expo.modules.kotlin.exception.UnexpectedException
            r1.<init>((java.lang.Throwable) r9)
            expo.modules.kotlin.exception.CodedException r1 = (expo.modules.kotlin.exception.CodedException) r1
            r0.reject(r1)
            goto L_0x00d1
        L_0x00cb:
            r9 = move-exception
            expo.modules.kotlin.jni.PromiseImpl r0 = r8.$bridgePromise
            r0.reject(r9)
        L_0x00d1:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.SuspendFunctionComponent$attachToJSObject$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
