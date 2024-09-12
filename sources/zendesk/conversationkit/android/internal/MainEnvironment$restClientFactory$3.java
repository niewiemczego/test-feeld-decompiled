package zendesk.conversationkit.android.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.apache.commons.io.IOUtils;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.MainEnvironment$restClientFactory$3", f = "Environment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Environment.kt */
final class MainEnvironment$restClientFactory$3 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    int label;
    final /* synthetic */ MainEnvironment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainEnvironment$restClientFactory$3(MainEnvironment mainEnvironment, Continuation<? super MainEnvironment$restClientFactory$3> continuation) {
        super(1, continuation);
        this.this$0 = mainEnvironment;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new MainEnvironment$restClientFactory$3(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super String> continuation) {
        return ((MainEnvironment$restClientFactory$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.getHostAppInfo().getAppName$zendesk_conversationkit_conversationkit_android() + IOUtils.DIR_SEPARATOR_UNIX + this.this$0.getHostAppInfo().getAppVersion$zendesk_conversationkit_conversationkit_android() + " (" + this.this$0.getHostAppInfo().getDeviceManufacturer$zendesk_conversationkit_conversationkit_android() + ' ' + this.this$0.getHostAppInfo().getDeviceModel$zendesk_conversationkit_conversationkit_android() + "; Android " + this.this$0.getHostAppInfo().getDeviceOperatingSystemVersion$zendesk_conversationkit_conversationkit_android() + ')';
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
