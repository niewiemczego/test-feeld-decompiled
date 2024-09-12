package com.braze.push;

import android.content.Context;
import android.content.Intent;
import com.braze.push.BrazePushReceiver;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.braze.push.BrazePushReceiver$Companion$handleReceivedIntent$1", f = "BrazePushReceiver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BrazePushReceiver.kt */
final class BrazePushReceiver$Companion$handleReceivedIntent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Intent $intent;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrazePushReceiver$Companion$handleReceivedIntent$1(Context context, Intent intent, Continuation<? super BrazePushReceiver$Companion$handleReceivedIntent$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$intent = intent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrazePushReceiver$Companion$handleReceivedIntent$1(this.$context, this.$intent, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BrazePushReceiver$Companion$handleReceivedIntent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            BrazePushReceiver.Companion companion = BrazePushReceiver.Companion;
            Context applicationContext = this.$context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            companion.handlePush(applicationContext, this.$intent);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
