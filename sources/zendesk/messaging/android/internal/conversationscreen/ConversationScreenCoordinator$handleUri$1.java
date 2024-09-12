package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import zendesk.android.messaging.Messaging;
import zendesk.android.messaging.UrlSource;
import zendesk.logger.Logger;
import zendesk.messaging.android.internal.KnownUriSchemes;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ConversationScreenCoordinator$handleUri$1", f = "ConversationScreenCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConversationScreenCoordinator.kt */
final class ConversationScreenCoordinator$handleUri$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $launchIntent;
    final /* synthetic */ String $uri;
    final /* synthetic */ UrlSource $urlSource;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenCoordinator$handleUri$1(String str, Function0<Unit> function0, UrlSource urlSource, Continuation<? super ConversationScreenCoordinator$handleUri$1> continuation) {
        super(2, continuation);
        this.$uri = str;
        this.$launchIntent = function0;
        this.$urlSource = urlSource;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationScreenCoordinator$handleUri$1(this.$uri, this.$launchIntent, this.$urlSource, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConversationScreenCoordinator$handleUri$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (StringsKt.startsWith$default(this.$uri, KnownUriSchemes.PHONE_NUMBER, false, 2, (Object) null)) {
                this.$launchIntent.invoke();
            } else if (StringsKt.startsWith$default(this.$uri, "mailto:", false, 2, (Object) null)) {
                this.$launchIntent.invoke();
            } else if (Messaging.Companion.getDelegate().shouldHandleUrl(this.$uri, this.$urlSource)) {
                this.$launchIntent.invoke();
            } else if (this.$urlSource == UrlSource.IMAGE) {
                this.$launchIntent.invoke();
            } else {
                Logger.i("ConversationScreenCoordinator", "MessagingDelegate.shouldHandleUrl returned false, ignoring " + this.$uri + " from " + this.$urlSource, new Object[0]);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
