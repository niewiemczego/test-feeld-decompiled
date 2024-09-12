package com.braze.ui.inappmessage.jsinterface;

import com.braze.support.BrazeLogger;
import com.braze.support.PermissionUtils;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.TimeoutKt;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.braze.ui.inappmessage.jsinterface.InAppMessageJavascriptInterface$requestPushPermission$1", f = "InAppMessageJavascriptInterface.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InAppMessageJavascriptInterface.kt */
final class InAppMessageJavascriptInterface$requestPushPermission$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InAppMessageJavascriptInterface this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessageJavascriptInterface$requestPushPermission$1(InAppMessageJavascriptInterface inAppMessageJavascriptInterface, Continuation<? super InAppMessageJavascriptInterface$requestPushPermission$1> continuation) {
        super(1, continuation);
        this.this$0 = inAppMessageJavascriptInterface;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new InAppMessageJavascriptInterface$requestPushPermission$1(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((InAppMessageJavascriptInterface$requestPushPermission$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.getWasCloseMessageCalled()) {
                this.label = 1;
                if (TimeoutKt.withTimeout(2500, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.this$0, BrazeLogger.Priority.V, (Throwable) null, (Function0) AnonymousClass2.INSTANCE, 2, (Object) null);
        PermissionUtils.requestPushPermissionPrompt(BrazeInAppMessageManager.Companion.getInstance().getActivity());
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.braze.ui.inappmessage.jsinterface.InAppMessageJavascriptInterface$requestPushPermission$1$1", f = "InAppMessageJavascriptInterface.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageJavascriptInterface$requestPushPermission$1$1  reason: invalid class name */
    /* compiled from: InAppMessageJavascriptInterface.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) (CoroutineScope) this.L$0, BrazeLogger.Priority.V, (Throwable) null, (Function0) AnonymousClass1.INSTANCE, 2, (Object) null);
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (BrazeInAppMessageManager.Companion.getInstance().isCurrentlyDisplayingInAppMessage()) {
                this.label = 1;
                if (DelayKt.delay(25, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }
}
