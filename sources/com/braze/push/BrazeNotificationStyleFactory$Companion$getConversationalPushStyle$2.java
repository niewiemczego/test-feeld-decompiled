package com.braze.push;

import com.braze.models.push.BrazeNotificationPayload;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeNotificationStyleFactory.kt */
final class BrazeNotificationStyleFactory$Companion$getConversationalPushStyle$2 extends Lambda implements Function0<String> {
    final /* synthetic */ BrazeNotificationPayload.ConversationMessage $message;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrazeNotificationStyleFactory$Companion$getConversationalPushStyle$2(BrazeNotificationPayload.ConversationMessage conversationMessage) {
        super(0);
        this.$message = conversationMessage;
    }

    public final String invoke() {
        return "Message person does not exist in mapping. Not rendering a style. " + this.$message;
    }
}
