package com.braze.ui.inappmessage.utils;

import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessageForDisplay$1", f = "BackgroundInAppMessagePreparer.kt", i = {0}, l = {42}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: BackgroundInAppMessagePreparer.kt */
final class BackgroundInAppMessagePreparer$prepareInAppMessageForDisplay$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IInAppMessage $inAppMessageToPrepare;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackgroundInAppMessagePreparer$prepareInAppMessageForDisplay$1(IInAppMessage iInAppMessage, Continuation<? super BackgroundInAppMessagePreparer$prepareInAppMessageForDisplay$1> continuation) {
        super(2, continuation);
        this.$inAppMessageToPrepare = iInAppMessage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BackgroundInAppMessagePreparer$prepareInAppMessageForDisplay$1 backgroundInAppMessagePreparer$prepareInAppMessageForDisplay$1 = new BackgroundInAppMessagePreparer$prepareInAppMessageForDisplay$1(this.$inAppMessageToPrepare, continuation);
        backgroundInAppMessagePreparer$prepareInAppMessageForDisplay$1.L$0 = obj;
        return backgroundInAppMessagePreparer$prepareInAppMessageForDisplay$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BackgroundInAppMessagePreparer$prepareInAppMessageForDisplay$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Exception e;
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            try {
                IInAppMessage access$prepareInAppMessage = BackgroundInAppMessagePreparer.INSTANCE.prepareInAppMessage(this.$inAppMessageToPrepare);
                if (access$prepareInAppMessage == null) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) coroutineScope2, BrazeLogger.Priority.W, (Throwable) null, (Function0) AnonymousClass1.INSTANCE, 2, (Object) null);
                } else {
                    this.L$0 = coroutineScope2;
                    this.label = 1;
                    if (BackgroundInAppMessagePreparer.INSTANCE.displayPreparedInAppMessage(access$prepareInAppMessage, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } catch (Exception e2) {
                Exception exc = e2;
                coroutineScope = coroutineScope2;
                e = exc;
                BrazeLogger.INSTANCE.brazelog((Object) coroutineScope, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) AnonymousClass2.INSTANCE);
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            coroutineScope = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e3) {
                e = e3;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
