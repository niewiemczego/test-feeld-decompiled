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
import zendesk.conversationkit.android.internal.rest.model.AppUserRequestDto;
import zendesk.conversationkit.android.internal.rest.model.AppUserResponseDto;
import zendesk.conversationkit.android.internal.rest.model.ClientDto;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lzendesk/conversationkit/android/internal/rest/model/AppUserResponseDto;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.app.AppActionProcessor$createUser$result$user$1", f = "AppActionProcessor.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AppActionProcessor.kt */
final class AppActionProcessor$createUser$result$user$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AppUserResponseDto>, Object> {
    final /* synthetic */ AppUserRequestDto $appUserRequestDto;
    final /* synthetic */ ClientDto $client;
    int label;
    final /* synthetic */ AppActionProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppActionProcessor$createUser$result$user$1(AppActionProcessor appActionProcessor, ClientDto clientDto, AppUserRequestDto appUserRequestDto, Continuation<? super AppActionProcessor$createUser$result$user$1> continuation) {
        super(2, continuation);
        this.this$0 = appActionProcessor;
        this.$client = clientDto;
        this.$appUserRequestDto = appUserRequestDto;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppActionProcessor$createUser$result$user$1(this.this$0, this.$client, this.$appUserRequestDto, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AppUserResponseDto> continuation) {
        return ((AppActionProcessor$createUser$result$user$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.appRestClient.createAppUser(this.$client.getId(), this.$appUserRequestDto, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
