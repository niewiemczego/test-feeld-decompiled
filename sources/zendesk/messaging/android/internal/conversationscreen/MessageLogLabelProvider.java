package zendesk.messaging.android.internal.conversationscreen;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.messaging.R;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/MessageLogLabelProvider;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "formSubmissionFailed", "", "justNow", "newMessages", "sending", "sentAt", "timestamp", "sentJustNow", "tapToRetry", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogLabelProvider.kt */
public final class MessageLogLabelProvider {
    private final Context context;

    public MessageLogLabelProvider(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final String newMessages() {
        String string = this.context.getString(R.string.zuia_conversation_message_label_new);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…sation_message_label_new)");
        return string;
    }

    public final String justNow() {
        String string = this.context.getString(R.string.zuia_conversation_message_label_just_now);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…n_message_label_just_now)");
        return string;
    }

    public final String sentAt(String str) {
        Intrinsics.checkNotNullParameter(str, "timestamp");
        String string = this.context.getString(R.string.zuia_conversation_message_label_sent_absolute, new Object[]{str});
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     …,\n        timestamp\n    )");
        return string;
    }

    public final String sentJustNow() {
        String string = this.context.getString(R.string.zuia_conversation_message_label_sent_relative);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…sage_label_sent_relative)");
        return string;
    }

    public final String sending() {
        String string = this.context.getString(R.string.zuia_conversation_message_label_sending);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…on_message_label_sending)");
        return string;
    }

    public final String tapToRetry() {
        String string = this.context.getString(R.string.zuia_conversation_message_label_tap_to_retry);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…ssage_label_tap_to_retry)");
        return string;
    }

    public final String formSubmissionFailed() {
        String string = this.context.getString(R.string.zma_form_submission_error);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…ma_form_submission_error)");
        return string;
    }
}
