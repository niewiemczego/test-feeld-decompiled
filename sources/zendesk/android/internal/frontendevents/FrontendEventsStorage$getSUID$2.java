package zendesk.android.internal.frontendevents;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.internal.frontendevents.FrontendEventsStorage$getSUID$2", f = "FrontendEventsStorage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FrontendEventsStorage.kt */
final class FrontendEventsStorage$getSUID$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;
    final /* synthetic */ FrontendEventsStorage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FrontendEventsStorage$getSUID$2(FrontendEventsStorage frontendEventsStorage, Continuation<? super FrontendEventsStorage$getSUID$2> continuation) {
        super(2, continuation);
        this.this$0 = frontendEventsStorage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FrontendEventsStorage$getSUID$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((FrontendEventsStorage$getSUID$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.this$0.storage.get(FrontendEventsStorage.KEY_SUID, String.class);
            Long l = (Long) this.this$0.storage.get(FrontendEventsStorage.KEY_SUID_TIMESTAMP, Long.TYPE);
            long longValue = l != null ? l.longValue() : 0;
            if (str == null) {
                String access$createNewSUID = this.this$0.createNewSUID();
                this.this$0.resetSUIDTimestamp();
                return access$createNewSUID;
            } else if (this.this$0.isOutOfDate(longValue)) {
                String access$createNewSUID2 = this.this$0.createNewSUID();
                this.this$0.resetSUIDTimestamp();
                return access$createNewSUID2;
            } else {
                this.this$0.resetSUIDTimestamp();
                return str;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
