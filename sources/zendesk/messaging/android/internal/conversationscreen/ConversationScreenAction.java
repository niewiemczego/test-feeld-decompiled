package zendesk.messaging.android.internal.conversationscreen;

import com.facebook.GraphRequest;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.ActivityData;
import zendesk.conversationkit.android.model.Field;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.messaging.android.internal.model.UploadFile;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\f\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000eB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\f\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction;", "", "()V", "HideDeniedPermission", "HideMessageComposer", "LoadMoreMessages", "PersistComposerText", "ResendFailedMessage", "RetryConnection", "SendActivityData", "SendFormResponse", "SendTextMessage", "ShowDeniedPermission", "ShowMessageComposer", "UploadFiles", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$SendTextMessage;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$UploadFiles;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$ResendFailedMessage;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$SendFormResponse;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$SendActivityData;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$RetryConnection;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$HideMessageComposer;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$ShowMessageComposer;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$ShowDeniedPermission;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$HideDeniedPermission;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$PersistComposerText;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$LoadMoreMessages;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenAction.kt */
public abstract class ConversationScreenAction {
    public /* synthetic */ ConversationScreenAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ConversationScreenAction() {
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003JA\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$SendTextMessage;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction;", "textMessage", "", "payload", "metadata", "", "", "conversationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "getMetadata", "()Ljava/util/Map;", "getPayload", "getTextMessage", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationScreenAction.kt */
    public static final class SendTextMessage extends ConversationScreenAction {
        private final String conversationId;
        private final Map<String, Object> metadata;
        private final String payload;
        private final String textMessage;

        public static /* synthetic */ SendTextMessage copy$default(SendTextMessage sendTextMessage, String str, String str2, Map<String, Object> map, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sendTextMessage.textMessage;
            }
            if ((i & 2) != 0) {
                str2 = sendTextMessage.payload;
            }
            if ((i & 4) != 0) {
                map = sendTextMessage.metadata;
            }
            if ((i & 8) != 0) {
                str3 = sendTextMessage.conversationId;
            }
            return sendTextMessage.copy(str, str2, map, str3);
        }

        public final String component1() {
            return this.textMessage;
        }

        public final String component2() {
            return this.payload;
        }

        public final Map<String, Object> component3() {
            return this.metadata;
        }

        public final String component4() {
            return this.conversationId;
        }

        public final SendTextMessage copy(String str, String str2, Map<String, ? extends Object> map, String str3) {
            Intrinsics.checkNotNullParameter(str, "textMessage");
            Intrinsics.checkNotNullParameter(str3, "conversationId");
            return new SendTextMessage(str, str2, map, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SendTextMessage)) {
                return false;
            }
            SendTextMessage sendTextMessage = (SendTextMessage) obj;
            return Intrinsics.areEqual((Object) this.textMessage, (Object) sendTextMessage.textMessage) && Intrinsics.areEqual((Object) this.payload, (Object) sendTextMessage.payload) && Intrinsics.areEqual((Object) this.metadata, (Object) sendTextMessage.metadata) && Intrinsics.areEqual((Object) this.conversationId, (Object) sendTextMessage.conversationId);
        }

        public int hashCode() {
            int hashCode = this.textMessage.hashCode() * 31;
            String str = this.payload;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Map<String, Object> map = this.metadata;
            if (map != null) {
                i = map.hashCode();
            }
            return ((hashCode2 + i) * 31) + this.conversationId.hashCode();
        }

        public String toString() {
            return "SendTextMessage(textMessage=" + this.textMessage + ", payload=" + this.payload + ", metadata=" + this.metadata + ", conversationId=" + this.conversationId + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SendTextMessage(String str, String str2, Map map, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : map, str3);
        }

        public final String getTextMessage() {
            return this.textMessage;
        }

        public final String getPayload() {
            return this.payload;
        }

        public final Map<String, Object> getMetadata() {
            return this.metadata;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SendTextMessage(String str, String str2, Map<String, ? extends Object> map, String str3) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "textMessage");
            Intrinsics.checkNotNullParameter(str3, "conversationId");
            this.textMessage = str;
            this.payload = str2;
            this.metadata = map;
            this.conversationId = str3;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$UploadFiles;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction;", "uploads", "", "Lzendesk/messaging/android/internal/model/UploadFile;", "conversationId", "", "(Ljava/util/List;Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "getUploads", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationScreenAction.kt */
    public static final class UploadFiles extends ConversationScreenAction {
        private final String conversationId;
        private final List<UploadFile> uploads;

        public static /* synthetic */ UploadFiles copy$default(UploadFiles uploadFiles, List<UploadFile> list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = uploadFiles.uploads;
            }
            if ((i & 2) != 0) {
                str = uploadFiles.conversationId;
            }
            return uploadFiles.copy(list, str);
        }

        public final List<UploadFile> component1() {
            return this.uploads;
        }

        public final String component2() {
            return this.conversationId;
        }

        public final UploadFiles copy(List<UploadFile> list, String str) {
            Intrinsics.checkNotNullParameter(list, "uploads");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            return new UploadFiles(list, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UploadFiles)) {
                return false;
            }
            UploadFiles uploadFiles = (UploadFiles) obj;
            return Intrinsics.areEqual((Object) this.uploads, (Object) uploadFiles.uploads) && Intrinsics.areEqual((Object) this.conversationId, (Object) uploadFiles.conversationId);
        }

        public int hashCode() {
            return (this.uploads.hashCode() * 31) + this.conversationId.hashCode();
        }

        public String toString() {
            return "UploadFiles(uploads=" + this.uploads + ", conversationId=" + this.conversationId + ')';
        }

        public final List<UploadFile> getUploads() {
            return this.uploads;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UploadFiles(List<UploadFile> list, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "uploads");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.uploads = list;
            this.conversationId = str;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$ResendFailedMessage;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction;", "failedMessageContainer", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "conversationId", "", "(Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "getFailedMessageContainer", "()Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationScreenAction.kt */
    public static final class ResendFailedMessage extends ConversationScreenAction {
        private final String conversationId;
        private final MessageLogEntry.MessageContainer failedMessageContainer;

        public static /* synthetic */ ResendFailedMessage copy$default(ResendFailedMessage resendFailedMessage, MessageLogEntry.MessageContainer messageContainer, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                messageContainer = resendFailedMessage.failedMessageContainer;
            }
            if ((i & 2) != 0) {
                str = resendFailedMessage.conversationId;
            }
            return resendFailedMessage.copy(messageContainer, str);
        }

        public final MessageLogEntry.MessageContainer component1() {
            return this.failedMessageContainer;
        }

        public final String component2() {
            return this.conversationId;
        }

        public final ResendFailedMessage copy(MessageLogEntry.MessageContainer messageContainer, String str) {
            Intrinsics.checkNotNullParameter(messageContainer, "failedMessageContainer");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            return new ResendFailedMessage(messageContainer, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResendFailedMessage)) {
                return false;
            }
            ResendFailedMessage resendFailedMessage = (ResendFailedMessage) obj;
            return Intrinsics.areEqual((Object) this.failedMessageContainer, (Object) resendFailedMessage.failedMessageContainer) && Intrinsics.areEqual((Object) this.conversationId, (Object) resendFailedMessage.conversationId);
        }

        public int hashCode() {
            return (this.failedMessageContainer.hashCode() * 31) + this.conversationId.hashCode();
        }

        public String toString() {
            return "ResendFailedMessage(failedMessageContainer=" + this.failedMessageContainer + ", conversationId=" + this.conversationId + ')';
        }

        public final MessageLogEntry.MessageContainer getFailedMessageContainer() {
            return this.failedMessageContainer;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ResendFailedMessage(MessageLogEntry.MessageContainer messageContainer, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(messageContainer, "failedMessageContainer");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.failedMessageContainer = messageContainer;
            this.conversationId = str;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$SendFormResponse;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction;", "fields", "", "Lzendesk/conversationkit/android/model/Field;", "formMessageContainer", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "conversationId", "", "(Ljava/util/List;Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "getFields", "()Ljava/util/List;", "getFormMessageContainer", "()Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationScreenAction.kt */
    public static final class SendFormResponse extends ConversationScreenAction {
        private final String conversationId;
        private final List<Field> fields;
        private final MessageLogEntry.MessageContainer formMessageContainer;

        public static /* synthetic */ SendFormResponse copy$default(SendFormResponse sendFormResponse, List<Field> list, MessageLogEntry.MessageContainer messageContainer, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = sendFormResponse.fields;
            }
            if ((i & 2) != 0) {
                messageContainer = sendFormResponse.formMessageContainer;
            }
            if ((i & 4) != 0) {
                str = sendFormResponse.conversationId;
            }
            return sendFormResponse.copy(list, messageContainer, str);
        }

        public final List<Field> component1() {
            return this.fields;
        }

        public final MessageLogEntry.MessageContainer component2() {
            return this.formMessageContainer;
        }

        public final String component3() {
            return this.conversationId;
        }

        public final SendFormResponse copy(List<? extends Field> list, MessageLogEntry.MessageContainer messageContainer, String str) {
            Intrinsics.checkNotNullParameter(list, GraphRequest.FIELDS_PARAM);
            Intrinsics.checkNotNullParameter(messageContainer, "formMessageContainer");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            return new SendFormResponse(list, messageContainer, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SendFormResponse)) {
                return false;
            }
            SendFormResponse sendFormResponse = (SendFormResponse) obj;
            return Intrinsics.areEqual((Object) this.fields, (Object) sendFormResponse.fields) && Intrinsics.areEqual((Object) this.formMessageContainer, (Object) sendFormResponse.formMessageContainer) && Intrinsics.areEqual((Object) this.conversationId, (Object) sendFormResponse.conversationId);
        }

        public int hashCode() {
            return (((this.fields.hashCode() * 31) + this.formMessageContainer.hashCode()) * 31) + this.conversationId.hashCode();
        }

        public String toString() {
            return "SendFormResponse(fields=" + this.fields + ", formMessageContainer=" + this.formMessageContainer + ", conversationId=" + this.conversationId + ')';
        }

        public final List<Field> getFields() {
            return this.fields;
        }

        public final MessageLogEntry.MessageContainer getFormMessageContainer() {
            return this.formMessageContainer;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SendFormResponse(List<? extends Field> list, MessageLogEntry.MessageContainer messageContainer, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, GraphRequest.FIELDS_PARAM);
            Intrinsics.checkNotNullParameter(messageContainer, "formMessageContainer");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.fields = list;
            this.formMessageContainer = messageContainer;
            this.conversationId = str;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$SendActivityData;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction;", "activityData", "Lzendesk/conversationkit/android/model/ActivityData;", "conversationId", "", "(Lzendesk/conversationkit/android/model/ActivityData;Ljava/lang/String;)V", "getActivityData", "()Lzendesk/conversationkit/android/model/ActivityData;", "getConversationId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationScreenAction.kt */
    public static final class SendActivityData extends ConversationScreenAction {
        private final ActivityData activityData;
        private final String conversationId;

        public static /* synthetic */ SendActivityData copy$default(SendActivityData sendActivityData, ActivityData activityData2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                activityData2 = sendActivityData.activityData;
            }
            if ((i & 2) != 0) {
                str = sendActivityData.conversationId;
            }
            return sendActivityData.copy(activityData2, str);
        }

        public final ActivityData component1() {
            return this.activityData;
        }

        public final String component2() {
            return this.conversationId;
        }

        public final SendActivityData copy(ActivityData activityData2, String str) {
            Intrinsics.checkNotNullParameter(activityData2, "activityData");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            return new SendActivityData(activityData2, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SendActivityData)) {
                return false;
            }
            SendActivityData sendActivityData = (SendActivityData) obj;
            return this.activityData == sendActivityData.activityData && Intrinsics.areEqual((Object) this.conversationId, (Object) sendActivityData.conversationId);
        }

        public int hashCode() {
            return (this.activityData.hashCode() * 31) + this.conversationId.hashCode();
        }

        public String toString() {
            return "SendActivityData(activityData=" + this.activityData + ", conversationId=" + this.conversationId + ')';
        }

        public final ActivityData getActivityData() {
            return this.activityData;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SendActivityData(ActivityData activityData2, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(activityData2, "activityData");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.activityData = activityData2;
            this.conversationId = str;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$RetryConnection;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction;", "()V", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationScreenAction.kt */
    public static final class RetryConnection extends ConversationScreenAction {
        public static final RetryConnection INSTANCE = new RetryConnection();

        private RetryConnection() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$HideMessageComposer;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction;", "()V", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationScreenAction.kt */
    public static final class HideMessageComposer extends ConversationScreenAction {
        public static final HideMessageComposer INSTANCE = new HideMessageComposer();

        private HideMessageComposer() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$ShowMessageComposer;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction;", "()V", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationScreenAction.kt */
    public static final class ShowMessageComposer extends ConversationScreenAction {
        public static final ShowMessageComposer INSTANCE = new ShowMessageComposer();

        private ShowMessageComposer() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$ShowDeniedPermission;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction;", "()V", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationScreenAction.kt */
    public static final class ShowDeniedPermission extends ConversationScreenAction {
        public static final ShowDeniedPermission INSTANCE = new ShowDeniedPermission();

        private ShowDeniedPermission() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$HideDeniedPermission;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction;", "()V", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationScreenAction.kt */
    public static final class HideDeniedPermission extends ConversationScreenAction {
        public static final HideDeniedPermission INSTANCE = new HideDeniedPermission();

        private HideDeniedPermission() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$PersistComposerText;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction;", "conversationId", "", "composerText", "(Ljava/lang/String;Ljava/lang/String;)V", "getComposerText", "()Ljava/lang/String;", "getConversationId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationScreenAction.kt */
    public static final class PersistComposerText extends ConversationScreenAction {
        private final String composerText;
        private final String conversationId;

        public static /* synthetic */ PersistComposerText copy$default(PersistComposerText persistComposerText, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = persistComposerText.conversationId;
            }
            if ((i & 2) != 0) {
                str2 = persistComposerText.composerText;
            }
            return persistComposerText.copy(str, str2);
        }

        public final String component1() {
            return this.conversationId;
        }

        public final String component2() {
            return this.composerText;
        }

        public final PersistComposerText copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "conversationId");
            Intrinsics.checkNotNullParameter(str2, "composerText");
            return new PersistComposerText(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PersistComposerText)) {
                return false;
            }
            PersistComposerText persistComposerText = (PersistComposerText) obj;
            return Intrinsics.areEqual((Object) this.conversationId, (Object) persistComposerText.conversationId) && Intrinsics.areEqual((Object) this.composerText, (Object) persistComposerText.composerText);
        }

        public int hashCode() {
            return (this.conversationId.hashCode() * 31) + this.composerText.hashCode();
        }

        public String toString() {
            return "PersistComposerText(conversationId=" + this.conversationId + ", composerText=" + this.composerText + ')';
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        public final String getComposerText() {
            return this.composerText;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PersistComposerText(String str, String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "conversationId");
            Intrinsics.checkNotNullParameter(str2, "composerText");
            this.conversationId = str;
            this.composerText = str2;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$LoadMoreMessages;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction;", "conversationId", "", "beforeTimestamp", "", "(Ljava/lang/String;D)V", "getBeforeTimestamp", "()D", "getConversationId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationScreenAction.kt */
    public static final class LoadMoreMessages extends ConversationScreenAction {
        private final double beforeTimestamp;
        private final String conversationId;

        public static /* synthetic */ LoadMoreMessages copy$default(LoadMoreMessages loadMoreMessages, String str, double d, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadMoreMessages.conversationId;
            }
            if ((i & 2) != 0) {
                d = loadMoreMessages.beforeTimestamp;
            }
            return loadMoreMessages.copy(str, d);
        }

        public final String component1() {
            return this.conversationId;
        }

        public final double component2() {
            return this.beforeTimestamp;
        }

        public final LoadMoreMessages copy(String str, double d) {
            Intrinsics.checkNotNullParameter(str, "conversationId");
            return new LoadMoreMessages(str, d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LoadMoreMessages)) {
                return false;
            }
            LoadMoreMessages loadMoreMessages = (LoadMoreMessages) obj;
            return Intrinsics.areEqual((Object) this.conversationId, (Object) loadMoreMessages.conversationId) && Intrinsics.areEqual((Object) Double.valueOf(this.beforeTimestamp), (Object) Double.valueOf(loadMoreMessages.beforeTimestamp));
        }

        public int hashCode() {
            return (this.conversationId.hashCode() * 31) + Double.hashCode(this.beforeTimestamp);
        }

        public String toString() {
            return "LoadMoreMessages(conversationId=" + this.conversationId + ", beforeTimestamp=" + this.beforeTimestamp + ')';
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        public final double getBeforeTimestamp() {
            return this.beforeTimestamp;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadMoreMessages(String str, double d) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.conversationId = str;
            this.beforeTimestamp = d;
        }
    }
}
