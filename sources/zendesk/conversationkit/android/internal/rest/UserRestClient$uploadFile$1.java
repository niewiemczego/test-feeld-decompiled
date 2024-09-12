package zendesk.conversationkit.android.internal.rest;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import zendesk.conversationkit.android.internal.rest.model.UploadFileDto;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.rest.UserRestClient", f = "UserRestClient.kt", i = {0, 0}, l = {168}, m = "uploadFile", n = {"this", "uploadFileDto"}, s = {"L$0", "L$1"})
/* compiled from: UserRestClient.kt */
final class UserRestClient$uploadFile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserRestClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserRestClient$uploadFile$1(UserRestClient userRestClient, Continuation<? super UserRestClient$uploadFile$1> continuation) {
        super(continuation);
        this.this$0 = userRestClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.uploadFile((String) null, (String) null, (UploadFileDto) null, this);
    }
}
