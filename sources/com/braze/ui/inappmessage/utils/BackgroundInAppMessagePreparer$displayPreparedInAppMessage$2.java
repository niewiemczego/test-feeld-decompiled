package com.braze.ui.inappmessage.utils;

import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
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
@DebugMetadata(c = "com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$displayPreparedInAppMessage$2", f = "BackgroundInAppMessagePreparer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BackgroundInAppMessagePreparer.kt */
final class BackgroundInAppMessagePreparer$displayPreparedInAppMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IInAppMessage $inAppMessage;
    int label;
    final /* synthetic */ BackgroundInAppMessagePreparer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackgroundInAppMessagePreparer$displayPreparedInAppMessage$2(BackgroundInAppMessagePreparer backgroundInAppMessagePreparer, IInAppMessage iInAppMessage, Continuation<? super BackgroundInAppMessagePreparer$displayPreparedInAppMessage$2> continuation) {
        super(2, continuation);
        this.this$0 = backgroundInAppMessagePreparer;
        this.$inAppMessage = iInAppMessage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BackgroundInAppMessagePreparer$displayPreparedInAppMessage$2(this.this$0, this.$inAppMessage, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BackgroundInAppMessagePreparer$displayPreparedInAppMessage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.this$0, (BrazeLogger.Priority) null, (Throwable) null, (Function0) AnonymousClass1.INSTANCE, 3, (Object) null);
            BrazeInAppMessageManager.Companion.getInstance().displayInAppMessage(this.$inAppMessage, false);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
