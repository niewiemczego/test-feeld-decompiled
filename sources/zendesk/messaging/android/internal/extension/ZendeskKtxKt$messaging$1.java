package zendesk.messaging.android.internal.extension;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import zendesk.android.Zendesk;
import zendesk.android.ZendeskCredentials;
import zendesk.android.messaging.MessagingFactory;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.extension.ZendeskKtxKt", f = "ZendeskKtx.kt", i = {}, l = {28}, m = "messaging", n = {}, s = {})
/* compiled from: ZendeskKtx.kt */
final class ZendeskKtxKt$messaging$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    ZendeskKtxKt$messaging$1(Continuation<? super ZendeskKtxKt$messaging$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ZendeskKtxKt.messaging((Zendesk.Companion) null, (Context) null, (ZendeskCredentials) null, (MessagingFactory) null, this);
    }
}
