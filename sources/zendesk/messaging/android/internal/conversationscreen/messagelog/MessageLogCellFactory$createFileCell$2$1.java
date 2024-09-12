package zendesk.messaging.android.internal.conversationscreen.messagelog;

import android.net.Uri;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import zendesk.conversationkit.android.model.MessageContent;
import zendesk.conversationkit.android.model.MessageStatus;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.model.MessageDirection;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.ui.android.conversation.file.FileRendering;
import zendesk.ui.android.conversation.file.FileState;
import zendesk.ui.android.conversation.file.FileView;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/file/FileRendering;", "fileRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogCellFactory.kt */
final class MessageLogCellFactory$createFileCell$2$1 extends Lambda implements Function1<FileRendering, FileRendering> {
    final /* synthetic */ MessageContent.File $fileContent;
    final /* synthetic */ MessageLogEntry.MessageContainer $item;
    final /* synthetic */ Function1<String, Unit> $onFileClicked;
    final /* synthetic */ Integer $outboundMessageColor;
    final /* synthetic */ FileView $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageLogCellFactory$createFileCell$2$1(Integer num, FileView fileView, MessageLogEntry.MessageContainer messageContainer, MessageContent.File file, Function1<? super String, Unit> function1) {
        super(1);
        this.$outboundMessageColor = num;
        this.$this_apply = fileView;
        this.$item = messageContainer;
        this.$fileContent = file;
        this.$onFileClicked = function1;
    }

    public final FileRendering invoke(FileRendering fileRendering) {
        int adjustAlpha$zendesk_messaging_messaging_android$default;
        Intrinsics.checkNotNullParameter(fileRendering, "fileRendering");
        Integer num = this.$outboundMessageColor;
        final int intValue = num != null ? num.intValue() : ContextCompat.getColor(this.$this_apply.getContext(), R.color.zma_color_message);
        if (this.$item.getDirection() == MessageDirection.INBOUND) {
            adjustAlpha$zendesk_messaging_messaging_android$default = ContextCompat.getColor(this.$this_apply.getContext(), R.color.zma_color_message_inbound_text);
        } else if (this.$item.getDirection() == MessageDirection.OUTBOUND && this.$item.getStatus() == MessageStatus.SENT) {
            adjustAlpha$zendesk_messaging_messaging_android$default = ContextCompat.getColor(this.$this_apply.getContext(), R.color.zma_color_message_outbound_text);
        } else {
            adjustAlpha$zendesk_messaging_messaging_android$default = MessageLogCellFactory.adjustAlpha$zendesk_messaging_messaging_android$default(MessageLogCellFactory.INSTANCE, ContextCompat.getColor(this.$this_apply.getContext(), R.color.zma_color_message_outbound_text), 0.0f, 1, (Object) null);
        }
        final int i = adjustAlpha$zendesk_messaging_messaging_android$default;
        FileRendering.Builder builder = fileRendering.toBuilder();
        final MessageContent.File file = this.$fileContent;
        final MessageLogEntry.MessageContainer messageContainer = this.$item;
        final FileView fileView = this.$this_apply;
        FileRendering.Builder state = builder.state(new Function1<FileState, FileState>() {

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogCellFactory$createFileCell$2$1$1$WhenMappings */
            /* compiled from: MessageLogCellFactory.kt */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[MessageStatus.values().length];
                    iArr[MessageStatus.PENDING.ordinal()] = 1;
                    iArr[MessageStatus.SENT.ordinal()] = 2;
                    iArr[MessageStatus.FAILED.ordinal()] = 3;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public final FileState invoke(FileState fileState) {
                int i;
                Intrinsics.checkNotNullParameter(fileState, "state");
                String substringAfterLast$default = StringsKt.substringAfterLast$default(file.getMediaUrl(), "/", (String) null, 2, (Object) null);
                try {
                    String queryParameter = Uri.parse(file.getMediaUrl()).getQueryParameter("name");
                    if (queryParameter != null) {
                        substringAfterLast$default = queryParameter;
                    }
                } catch (NullPointerException unused) {
                }
                String str = substringAfterLast$default;
                Intrinsics.checkNotNullExpressionValue(str, "try {\n                  …ame\n                    }");
                long mediaSize = file.getMediaSize();
                Integer valueOf = Integer.valueOf(i);
                Integer valueOf2 = Integer.valueOf(i);
                if (messageContainer.getDirection() == MessageDirection.INBOUND) {
                    i = ContextCompat.getColor(fileView.getContext(), R.color.zma_color_message_inbound_background);
                } else {
                    int i2 = WhenMappings.$EnumSwitchMapping$0[messageContainer.getStatus().ordinal()];
                    if (i2 == 1) {
                        i = MessageLogCellFactory.adjustAlpha$zendesk_messaging_messaging_android$default(MessageLogCellFactory.INSTANCE, intValue, 0.0f, 1, (Object) null);
                    } else if (i2 == 2) {
                        i = intValue;
                    } else if (i2 == 3) {
                        i = MessageLogCellFactory.adjustAlpha$zendesk_messaging_messaging_android$default(MessageLogCellFactory.INSTANCE, ContextCompat.getColor(fileView.getContext(), R.color.zma_color_alert), 0.0f, 1, (Object) null);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                return fileState.copy(str, mediaSize, valueOf, valueOf2, Integer.valueOf(i), Integer.valueOf(MessageLogCellFactory.INSTANCE.getCellDrawable(messageContainer.getShape(), messageContainer.getDirection())));
            }
        });
        final Function1<String, Unit> function1 = this.$onFileClicked;
        final MessageContent.File file2 = this.$fileContent;
        return state.onCellClicked(new Function0<Unit>() {
            public final void invoke() {
                function1.invoke(file2.getMediaUrl());
            }
        }).build();
    }
}
