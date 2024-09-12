package zendesk.ui.android.conversation.bottomsheet;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.ui.android.conversation.bottomsheet.BottomSheetView$showBottomSheet$1$1", f = "BottomSheetView.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BottomSheetView.kt */
final class BottomSheetView$showBottomSheet$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BottomSheetView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetView$showBottomSheet$1$1(BottomSheetView bottomSheetView, Continuation<? super BottomSheetView$showBottomSheet$1$1> continuation) {
        super(2, continuation);
        this.this$0 = bottomSheetView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BottomSheetView$showBottomSheet$1$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BottomSheetView$showBottomSheet$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(this.this$0.rendering.getState$zendesk_ui_ui_android().getDuration$zendesk_ui_ui_android(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (this.this$0.isShowing()) {
            this.this$0.cancel();
        }
        return Unit.INSTANCE;
    }
}
