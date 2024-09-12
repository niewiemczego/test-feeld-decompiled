package zendesk.conversationkit.android.internal.app;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zendesk.conversationkit.android.model.User;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lzendesk/conversationkit/android/model/User;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.app.AppStorage$getUser$2", f = "AppStorage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AppStorage.kt */
final class AppStorage$getUser$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super User>, Object> {
    int label;
    final /* synthetic */ AppStorage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppStorage$getUser$2(AppStorage appStorage, Continuation<? super AppStorage$getUser$2> continuation) {
        super(2, continuation);
        this.this$0 = appStorage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppStorage$getUser$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super User> continuation) {
        return ((AppStorage$getUser$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.getPersistedUser();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
