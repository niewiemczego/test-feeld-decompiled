package zendesk.messaging.android.internal.conversationscreen;

import android.content.Intent;
import android.net.Uri;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.android.messaging.UrlSource;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationActivity.kt */
final class ConversationActivity$uriHandler$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UrlSource $source;
    final /* synthetic */ String $uri;
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationActivity$uriHandler$1$1(UrlSource urlSource, ConversationActivity conversationActivity, String str) {
        super(0);
        this.$source = urlSource;
        this.this$0 = conversationActivity;
        this.$uri = str;
    }

    public final void invoke() {
        if (this.$source == UrlSource.IMAGE) {
            ConversationActivity conversationActivity = this.this$0;
            Intent intent = conversationActivity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, SDKConstants.PARAM_INTENT);
            this.this$0.startActivity(new ImageViewerActivityIntentBuilder(conversationActivity, ConversationActivityKt.getCredentials(intent)).withUri(this.$uri).build());
            return;
        }
        this.this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.$uri)));
    }
}
