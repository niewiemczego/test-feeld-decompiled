package com.braze.push;

import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.braze.push.NotificationTrampolineActivity$onResume$7", f = "NotificationTrampolineActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationTrampolineActivity.kt */
final class NotificationTrampolineActivity$onResume$7 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ NotificationTrampolineActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationTrampolineActivity$onResume$7(NotificationTrampolineActivity notificationTrampolineActivity, Continuation<? super NotificationTrampolineActivity$onResume$7> continuation) {
        super(1, continuation);
        this.this$0 = notificationTrampolineActivity;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new NotificationTrampolineActivity$onResume$7(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((NotificationTrampolineActivity$onResume$7) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.this$0, BrazeLogger.Priority.V, (Throwable) null, (Function0) AnonymousClass1.INSTANCE, 2, (Object) null);
            this.this$0.finish();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
