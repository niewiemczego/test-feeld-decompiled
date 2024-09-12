package zendesk.ui.android.conversation.messageloadmore;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0002#$B5\b\u0000\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0004\b\u0015\u0010\rJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0004\b\u0017\u0010\rJ\u000e\u0010\u0018\u001a\u00020\bHÀ\u0003¢\u0006\u0002\b\u0019J<\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\u0006\u0010 \u001a\u00020!J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006%"}, d2 = {"Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreState;", "", "failedRetryText", "", "progressBarColor", "", "failedRetryTextColor", "status", "Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreState$MessageLoadMoreStatus;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreState$MessageLoadMoreStatus;)V", "getFailedRetryText$zendesk_ui_ui_android", "()Ljava/lang/String;", "getFailedRetryTextColor$zendesk_ui_ui_android", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProgressBarColor$zendesk_ui_ui_android", "getStatus$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreState$MessageLoadMoreStatus;", "component1", "component1$zendesk_ui_ui_android", "component2", "component2$zendesk_ui_ui_android", "component3", "component3$zendesk_ui_ui_android", "component4", "component4$zendesk_ui_ui_android", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreState$MessageLoadMoreStatus;)Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreState;", "equals", "", "other", "hashCode", "toBuilder", "Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreState$Builder;", "toString", "Builder", "MessageLoadMoreStatus", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLoadMoreState.kt */
public final class MessageLoadMoreState {
    private final String failedRetryText;
    private final Integer failedRetryTextColor;
    private final Integer progressBarColor;
    private final MessageLoadMoreStatus status;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreState$MessageLoadMoreStatus;", "", "(Ljava/lang/String;I)V", "LOADING", "FAILED", "NONE", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageLoadMoreState.kt */
    public enum MessageLoadMoreStatus {
        LOADING,
        FAILED,
        NONE
    }

    public MessageLoadMoreState() {
        this((String) null, (Integer) null, (Integer) null, (MessageLoadMoreStatus) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ MessageLoadMoreState copy$default(MessageLoadMoreState messageLoadMoreState, String str, Integer num, Integer num2, MessageLoadMoreStatus messageLoadMoreStatus, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messageLoadMoreState.failedRetryText;
        }
        if ((i & 2) != 0) {
            num = messageLoadMoreState.progressBarColor;
        }
        if ((i & 4) != 0) {
            num2 = messageLoadMoreState.failedRetryTextColor;
        }
        if ((i & 8) != 0) {
            messageLoadMoreStatus = messageLoadMoreState.status;
        }
        return messageLoadMoreState.copy(str, num, num2, messageLoadMoreStatus);
    }

    public final String component1$zendesk_ui_ui_android() {
        return this.failedRetryText;
    }

    public final Integer component2$zendesk_ui_ui_android() {
        return this.progressBarColor;
    }

    public final Integer component3$zendesk_ui_ui_android() {
        return this.failedRetryTextColor;
    }

    public final MessageLoadMoreStatus component4$zendesk_ui_ui_android() {
        return this.status;
    }

    public final MessageLoadMoreState copy(String str, Integer num, Integer num2, MessageLoadMoreStatus messageLoadMoreStatus) {
        Intrinsics.checkNotNullParameter(messageLoadMoreStatus, "status");
        return new MessageLoadMoreState(str, num, num2, messageLoadMoreStatus);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageLoadMoreState)) {
            return false;
        }
        MessageLoadMoreState messageLoadMoreState = (MessageLoadMoreState) obj;
        return Intrinsics.areEqual((Object) this.failedRetryText, (Object) messageLoadMoreState.failedRetryText) && Intrinsics.areEqual((Object) this.progressBarColor, (Object) messageLoadMoreState.progressBarColor) && Intrinsics.areEqual((Object) this.failedRetryTextColor, (Object) messageLoadMoreState.failedRetryTextColor) && this.status == messageLoadMoreState.status;
    }

    public int hashCode() {
        String str = this.failedRetryText;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.progressBarColor;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.failedRetryTextColor;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return ((hashCode2 + i) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "MessageLoadMoreState(failedRetryText=" + this.failedRetryText + ", progressBarColor=" + this.progressBarColor + ", failedRetryTextColor=" + this.failedRetryTextColor + ", status=" + this.status + ')';
    }

    public MessageLoadMoreState(String str, Integer num, Integer num2, MessageLoadMoreStatus messageLoadMoreStatus) {
        Intrinsics.checkNotNullParameter(messageLoadMoreStatus, "status");
        this.failedRetryText = str;
        this.progressBarColor = num;
        this.failedRetryTextColor = num2;
        this.status = messageLoadMoreStatus;
    }

    public final String getFailedRetryText$zendesk_ui_ui_android() {
        return this.failedRetryText;
    }

    public final Integer getProgressBarColor$zendesk_ui_ui_android() {
        return this.progressBarColor;
    }

    public final Integer getFailedRetryTextColor$zendesk_ui_ui_android() {
        return this.failedRetryTextColor;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageLoadMoreState(String str, Integer num, Integer num2, MessageLoadMoreStatus messageLoadMoreStatus, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? MessageLoadMoreStatus.LOADING : messageLoadMoreStatus);
    }

    public final MessageLoadMoreStatus getStatus$zendesk_ui_ui_android() {
        return this.status;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreState$Builder;", "", "state", "Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreState;", "(Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreState;)V", "()V", "build", "failedRetryText", "", "failedRetryTextColor", "color", "", "progressBarColor", "status", "Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreState$MessageLoadMoreStatus;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageLoadMoreState.kt */
    public static final class Builder {
        private MessageLoadMoreState state;

        public Builder() {
            this.state = new MessageLoadMoreState((String) null, (Integer) null, (Integer) null, (MessageLoadMoreStatus) null, 15, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(MessageLoadMoreState messageLoadMoreState) {
            this();
            Intrinsics.checkNotNullParameter(messageLoadMoreState, "state");
            this.state = messageLoadMoreState;
        }

        public final Builder status(MessageLoadMoreStatus messageLoadMoreStatus) {
            Intrinsics.checkNotNullParameter(messageLoadMoreStatus, "status");
            Builder builder = this;
            this.state = MessageLoadMoreState.copy$default(this.state, (String) null, (Integer) null, (Integer) null, messageLoadMoreStatus, 7, (Object) null);
            return this;
        }

        public final Builder failedRetryText(String str) {
            Intrinsics.checkNotNullParameter(str, "failedRetryText");
            Builder builder = this;
            this.state = MessageLoadMoreState.copy$default(this.state, str, (Integer) null, (Integer) null, (MessageLoadMoreStatus) null, 14, (Object) null);
            return this;
        }

        public final Builder progressBarColor(int i) {
            Builder builder = this;
            this.state = MessageLoadMoreState.copy$default(this.state, (String) null, Integer.valueOf(i), (Integer) null, (MessageLoadMoreStatus) null, 13, (Object) null);
            return this;
        }

        public final Builder failedRetryTextColor(int i) {
            Builder builder = this;
            this.state = MessageLoadMoreState.copy$default(this.state, (String) null, (Integer) null, Integer.valueOf(i), (MessageLoadMoreStatus) null, 11, (Object) null);
            return this;
        }

        public final MessageLoadMoreState build() {
            return this.state;
        }
    }
}
