package zendesk.messaging.android.internal.conversationscreen.delegates;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.android.messaging.UrlSource;
import zendesk.messaging.android.internal.UriHandler;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "uri", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageContainerAdapterDelegate.kt */
final class MessageContainerAdapterDelegate$ViewHolder$renderContent$view$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ UriHandler $onUriClicked;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageContainerAdapterDelegate$ViewHolder$renderContent$view$1(UriHandler uriHandler) {
        super(1);
        this.$onUriClicked = uriHandler;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "uri");
        this.$onUriClicked.onUriClicked(str, UrlSource.FILE);
    }
}
