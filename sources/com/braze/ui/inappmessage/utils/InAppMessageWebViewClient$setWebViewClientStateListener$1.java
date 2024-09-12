package com.braze.ui.inappmessage.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.braze.ui.inappmessage.utils.InAppMessageWebViewClient$setWebViewClientStateListener$1", f = "InAppMessageWebViewClient.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InAppMessageWebViewClient.kt */
final class InAppMessageWebViewClient$setWebViewClientStateListener$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InAppMessageWebViewClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessageWebViewClient$setWebViewClientStateListener$1(InAppMessageWebViewClient inAppMessageWebViewClient, Continuation<? super InAppMessageWebViewClient$setWebViewClientStateListener$1> continuation) {
        super(1, continuation);
        this.this$0 = inAppMessageWebViewClient;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new InAppMessageWebViewClient$setWebViewClientStateListener$1(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((InAppMessageWebViewClient$setWebViewClientStateListener$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.braze.ui.inappmessage.utils.InAppMessageWebViewClient$setWebViewClientStateListener$1$1", f = "InAppMessageWebViewClient.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.braze.ui.inappmessage.utils.InAppMessageWebViewClient$setWebViewClientStateListener$1$1  reason: invalid class name */
    /* compiled from: InAppMessageWebViewClient.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(inAppMessageWebViewClient, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                inAppMessageWebViewClient.markPageFinished();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final InAppMessageWebViewClient inAppMessageWebViewClient = this.this$0;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
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
