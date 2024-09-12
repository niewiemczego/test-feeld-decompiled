package zendesk.messaging.android.internal.conversationscreen;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.messaging.model.ColorTheme;
import zendesk.conversationkit.android.ConnectionStatus;
import zendesk.conversationkit.android.model.Conversation;
import zendesk.messaging.android.internal.model.LoadMoreStatus;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.messaging.android.internal.model.TypingUser;
import zendesk.ui.android.conversation.form.DisplayedField;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b9\b\b\u0018\u00002\u00020\u0001Bß\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010!\u001a\u00020\u0010¢\u0006\u0002\u0010\"J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u0010C\u001a\u00020\u0010HÆ\u0003J\t\u0010D\u001a\u00020\u0010HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\u0015\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001a0\u0019HÆ\u0003J\t\u0010G\u001a\u00020\u001cHÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0010HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010 HÆ\u0003J\t\u0010K\u001a\u00020\u0010HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\u000f\u0010O\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010R\u001a\u00020\u0010HÆ\u0003J\t\u0010S\u001a\u00020\u0012HÆ\u0003Jã\u0001\u0010T\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u00052\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001a0\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00102\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\u0010HÆ\u0001J\u0013\u0010U\u001a\u00020\u00102\b\u0010V\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010W\u001a\u00020\u0012HÖ\u0001J\t\u0010X\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0016\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0015\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b1\u0010$R\u0011\u0010\u001d\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010)R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010!\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b<\u0010$R\u0011\u0010\u001e\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b=\u0010$R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u0010)R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@¨\u0006Y"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenState;", "", "colorTheme", "Lzendesk/android/messaging/model/ColorTheme;", "title", "", "description", "logoUrl", "messageLog", "", "Lzendesk/messaging/android/internal/model/MessageLogEntry;", "conversation", "Lzendesk/conversationkit/android/model/Conversation;", "error", "", "blockChatInput", "", "messageComposerVisibility", "", "connectionStatus", "Lzendesk/conversationkit/android/ConnectionStatus;", "gallerySupported", "cameraSupported", "composerText", "mapOfDisplayedFields", "", "Lzendesk/ui/android/conversation/form/DisplayedField;", "typingUser", "Lzendesk/messaging/android/internal/model/TypingUser;", "initialText", "showDeniedPermission", "loadMoreStatus", "Lzendesk/messaging/android/internal/model/LoadMoreStatus;", "shouldAnnounceMessage", "(Lzendesk/android/messaging/model/ColorTheme;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lzendesk/conversationkit/android/model/Conversation;Ljava/lang/Throwable;ZILzendesk/conversationkit/android/ConnectionStatus;ZZLjava/lang/String;Ljava/util/Map;Lzendesk/messaging/android/internal/model/TypingUser;Ljava/lang/String;ZLzendesk/messaging/android/internal/model/LoadMoreStatus;Z)V", "getBlockChatInput", "()Z", "getCameraSupported", "getColorTheme", "()Lzendesk/android/messaging/model/ColorTheme;", "getComposerText", "()Ljava/lang/String;", "getConnectionStatus", "()Lzendesk/conversationkit/android/ConnectionStatus;", "getConversation", "()Lzendesk/conversationkit/android/model/Conversation;", "getDescription", "getError", "()Ljava/lang/Throwable;", "getGallerySupported", "getInitialText", "getLoadMoreStatus", "()Lzendesk/messaging/android/internal/model/LoadMoreStatus;", "getLogoUrl", "getMapOfDisplayedFields", "()Ljava/util/Map;", "getMessageComposerVisibility", "()I", "getMessageLog", "()Ljava/util/List;", "getShouldAnnounceMessage", "getShowDeniedPermission", "getTitle", "getTypingUser", "()Lzendesk/messaging/android/internal/model/TypingUser;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenState.kt */
public final class ConversationScreenState {
    private final boolean blockChatInput;
    private final boolean cameraSupported;
    private final ColorTheme colorTheme;
    private final String composerText;
    private final ConnectionStatus connectionStatus;
    private final Conversation conversation;
    private final String description;
    private final Throwable error;
    private final boolean gallerySupported;
    private final String initialText;
    private final LoadMoreStatus loadMoreStatus;
    private final String logoUrl;
    private final Map<Integer, DisplayedField> mapOfDisplayedFields;
    private final int messageComposerVisibility;
    private final List<MessageLogEntry> messageLog;
    private final boolean shouldAnnounceMessage;
    private final boolean showDeniedPermission;
    private final String title;
    private final TypingUser typingUser;

    public ConversationScreenState() {
        this((ColorTheme) null, (String) null, (String) null, (String) null, (List) null, (Conversation) null, (Throwable) null, false, 0, (ConnectionStatus) null, false, false, (String) null, (Map) null, (TypingUser) null, (String) null, false, (LoadMoreStatus) null, false, 524287, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ConversationScreenState copy$default(ConversationScreenState conversationScreenState, ColorTheme colorTheme2, String str, String str2, String str3, List list, Conversation conversation2, Throwable th, boolean z, int i, ConnectionStatus connectionStatus2, boolean z2, boolean z3, String str4, Map map, TypingUser typingUser2, String str5, boolean z4, LoadMoreStatus loadMoreStatus2, boolean z5, int i2, Object obj) {
        ConversationScreenState conversationScreenState2 = conversationScreenState;
        int i3 = i2;
        return conversationScreenState.copy((i3 & 1) != 0 ? conversationScreenState2.colorTheme : colorTheme2, (i3 & 2) != 0 ? conversationScreenState2.title : str, (i3 & 4) != 0 ? conversationScreenState2.description : str2, (i3 & 8) != 0 ? conversationScreenState2.logoUrl : str3, (i3 & 16) != 0 ? conversationScreenState2.messageLog : list, (i3 & 32) != 0 ? conversationScreenState2.conversation : conversation2, (i3 & 64) != 0 ? conversationScreenState2.error : th, (i3 & 128) != 0 ? conversationScreenState2.blockChatInput : z, (i3 & 256) != 0 ? conversationScreenState2.messageComposerVisibility : i, (i3 & 512) != 0 ? conversationScreenState2.connectionStatus : connectionStatus2, (i3 & 1024) != 0 ? conversationScreenState2.gallerySupported : z2, (i3 & 2048) != 0 ? conversationScreenState2.cameraSupported : z3, (i3 & 4096) != 0 ? conversationScreenState2.composerText : str4, (i3 & 8192) != 0 ? conversationScreenState2.mapOfDisplayedFields : map, (i3 & 16384) != 0 ? conversationScreenState2.typingUser : typingUser2, (i3 & 32768) != 0 ? conversationScreenState2.initialText : str5, (i3 & 65536) != 0 ? conversationScreenState2.showDeniedPermission : z4, (i3 & 131072) != 0 ? conversationScreenState2.loadMoreStatus : loadMoreStatus2, (i3 & 262144) != 0 ? conversationScreenState2.shouldAnnounceMessage : z5);
    }

    public final ColorTheme component1() {
        return this.colorTheme;
    }

    public final ConnectionStatus component10() {
        return this.connectionStatus;
    }

    public final boolean component11() {
        return this.gallerySupported;
    }

    public final boolean component12() {
        return this.cameraSupported;
    }

    public final String component13() {
        return this.composerText;
    }

    public final Map<Integer, DisplayedField> component14() {
        return this.mapOfDisplayedFields;
    }

    public final TypingUser component15() {
        return this.typingUser;
    }

    public final String component16() {
        return this.initialText;
    }

    public final boolean component17() {
        return this.showDeniedPermission;
    }

    public final LoadMoreStatus component18() {
        return this.loadMoreStatus;
    }

    public final boolean component19() {
        return this.shouldAnnounceMessage;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.logoUrl;
    }

    public final List<MessageLogEntry> component5() {
        return this.messageLog;
    }

    public final Conversation component6() {
        return this.conversation;
    }

    public final Throwable component7() {
        return this.error;
    }

    public final boolean component8() {
        return this.blockChatInput;
    }

    public final int component9() {
        return this.messageComposerVisibility;
    }

    public final ConversationScreenState copy(ColorTheme colorTheme2, String str, String str2, String str3, List<? extends MessageLogEntry> list, Conversation conversation2, Throwable th, boolean z, int i, ConnectionStatus connectionStatus2, boolean z2, boolean z3, String str4, Map<Integer, DisplayedField> map, TypingUser typingUser2, String str5, boolean z4, LoadMoreStatus loadMoreStatus2, boolean z5) {
        ColorTheme colorTheme3 = colorTheme2;
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "logoUrl");
        Intrinsics.checkNotNullParameter(list, "messageLog");
        Intrinsics.checkNotNullParameter(str4, "composerText");
        Intrinsics.checkNotNullParameter(map, "mapOfDisplayedFields");
        Intrinsics.checkNotNullParameter(typingUser2, "typingUser");
        Intrinsics.checkNotNullParameter(str5, "initialText");
        return new ConversationScreenState(colorTheme2, str, str2, str3, list, conversation2, th, z, i, connectionStatus2, z2, z3, str4, map, typingUser2, str5, z4, loadMoreStatus2, z5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConversationScreenState)) {
            return false;
        }
        ConversationScreenState conversationScreenState = (ConversationScreenState) obj;
        return Intrinsics.areEqual((Object) this.colorTheme, (Object) conversationScreenState.colorTheme) && Intrinsics.areEqual((Object) this.title, (Object) conversationScreenState.title) && Intrinsics.areEqual((Object) this.description, (Object) conversationScreenState.description) && Intrinsics.areEqual((Object) this.logoUrl, (Object) conversationScreenState.logoUrl) && Intrinsics.areEqual((Object) this.messageLog, (Object) conversationScreenState.messageLog) && Intrinsics.areEqual((Object) this.conversation, (Object) conversationScreenState.conversation) && Intrinsics.areEqual((Object) this.error, (Object) conversationScreenState.error) && this.blockChatInput == conversationScreenState.blockChatInput && this.messageComposerVisibility == conversationScreenState.messageComposerVisibility && this.connectionStatus == conversationScreenState.connectionStatus && this.gallerySupported == conversationScreenState.gallerySupported && this.cameraSupported == conversationScreenState.cameraSupported && Intrinsics.areEqual((Object) this.composerText, (Object) conversationScreenState.composerText) && Intrinsics.areEqual((Object) this.mapOfDisplayedFields, (Object) conversationScreenState.mapOfDisplayedFields) && Intrinsics.areEqual((Object) this.typingUser, (Object) conversationScreenState.typingUser) && Intrinsics.areEqual((Object) this.initialText, (Object) conversationScreenState.initialText) && this.showDeniedPermission == conversationScreenState.showDeniedPermission && this.loadMoreStatus == conversationScreenState.loadMoreStatus && this.shouldAnnounceMessage == conversationScreenState.shouldAnnounceMessage;
    }

    public int hashCode() {
        ColorTheme colorTheme2 = this.colorTheme;
        int i = 0;
        int hashCode = (((((((((colorTheme2 == null ? 0 : colorTheme2.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.logoUrl.hashCode()) * 31) + this.messageLog.hashCode()) * 31;
        Conversation conversation2 = this.conversation;
        int hashCode2 = (hashCode + (conversation2 == null ? 0 : conversation2.hashCode())) * 31;
        Throwable th = this.error;
        int hashCode3 = (hashCode2 + (th == null ? 0 : th.hashCode())) * 31;
        boolean z = this.blockChatInput;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int hashCode4 = (((hashCode3 + (z ? 1 : 0)) * 31) + Integer.hashCode(this.messageComposerVisibility)) * 31;
        ConnectionStatus connectionStatus2 = this.connectionStatus;
        int hashCode5 = (hashCode4 + (connectionStatus2 == null ? 0 : connectionStatus2.hashCode())) * 31;
        boolean z3 = this.gallerySupported;
        if (z3) {
            z3 = true;
        }
        int i2 = (hashCode5 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.cameraSupported;
        if (z4) {
            z4 = true;
        }
        int hashCode6 = (((((((((i2 + (z4 ? 1 : 0)) * 31) + this.composerText.hashCode()) * 31) + this.mapOfDisplayedFields.hashCode()) * 31) + this.typingUser.hashCode()) * 31) + this.initialText.hashCode()) * 31;
        boolean z5 = this.showDeniedPermission;
        if (z5) {
            z5 = true;
        }
        int i3 = (hashCode6 + (z5 ? 1 : 0)) * 31;
        LoadMoreStatus loadMoreStatus2 = this.loadMoreStatus;
        if (loadMoreStatus2 != null) {
            i = loadMoreStatus2.hashCode();
        }
        int i4 = (i3 + i) * 31;
        boolean z6 = this.shouldAnnounceMessage;
        if (!z6) {
            z2 = z6;
        }
        return i4 + (z2 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConversationScreenState(colorTheme=").append(this.colorTheme).append(", title=").append(this.title).append(", description=").append(this.description).append(", logoUrl=").append(this.logoUrl).append(", messageLog=").append(this.messageLog).append(", conversation=").append(this.conversation).append(", error=").append(this.error).append(", blockChatInput=").append(this.blockChatInput).append(", messageComposerVisibility=").append(this.messageComposerVisibility).append(", connectionStatus=").append(this.connectionStatus).append(", gallerySupported=").append(this.gallerySupported).append(", cameraSupported=");
        sb.append(this.cameraSupported).append(", composerText=").append(this.composerText).append(", mapOfDisplayedFields=").append(this.mapOfDisplayedFields).append(", typingUser=").append(this.typingUser).append(", initialText=").append(this.initialText).append(", showDeniedPermission=").append(this.showDeniedPermission).append(", loadMoreStatus=").append(this.loadMoreStatus).append(", shouldAnnounceMessage=").append(this.shouldAnnounceMessage).append(')');
        return sb.toString();
    }

    public ConversationScreenState(ColorTheme colorTheme2, String str, String str2, String str3, List<? extends MessageLogEntry> list, Conversation conversation2, Throwable th, boolean z, int i, ConnectionStatus connectionStatus2, boolean z2, boolean z3, String str4, Map<Integer, DisplayedField> map, TypingUser typingUser2, String str5, boolean z4, LoadMoreStatus loadMoreStatus2, boolean z5) {
        String str6 = str4;
        Map<Integer, DisplayedField> map2 = map;
        TypingUser typingUser3 = typingUser2;
        String str7 = str5;
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "logoUrl");
        Intrinsics.checkNotNullParameter(list, "messageLog");
        Intrinsics.checkNotNullParameter(str6, "composerText");
        Intrinsics.checkNotNullParameter(map2, "mapOfDisplayedFields");
        Intrinsics.checkNotNullParameter(typingUser3, "typingUser");
        Intrinsics.checkNotNullParameter(str7, "initialText");
        this.colorTheme = colorTheme2;
        this.title = str;
        this.description = str2;
        this.logoUrl = str3;
        this.messageLog = list;
        this.conversation = conversation2;
        this.error = th;
        this.blockChatInput = z;
        this.messageComposerVisibility = i;
        this.connectionStatus = connectionStatus2;
        this.gallerySupported = z2;
        this.cameraSupported = z3;
        this.composerText = str6;
        this.mapOfDisplayedFields = map2;
        this.typingUser = typingUser3;
        this.initialText = str7;
        this.showDeniedPermission = z4;
        this.loadMoreStatus = loadMoreStatus2;
        this.shouldAnnounceMessage = z5;
    }

    public final ColorTheme getColorTheme() {
        return this.colorTheme;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ConversationScreenState(zendesk.android.messaging.model.ColorTheme r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.util.List r25, zendesk.conversationkit.android.model.Conversation r26, java.lang.Throwable r27, boolean r28, int r29, zendesk.conversationkit.android.ConnectionStatus r30, boolean r31, boolean r32, java.lang.String r33, java.util.Map r34, zendesk.messaging.android.internal.model.TypingUser r35, java.lang.String r36, boolean r37, zendesk.messaging.android.internal.model.LoadMoreStatus r38, boolean r39, int r40, kotlin.jvm.internal.DefaultConstructorMarker r41) {
        /*
            r20 = this;
            r0 = r40
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r21
        L_0x000a:
            r3 = r0 & 2
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0012
            r3 = r4
            goto L_0x0014
        L_0x0012:
            r3 = r22
        L_0x0014:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001a
            r5 = r4
            goto L_0x001c
        L_0x001a:
            r5 = r23
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0022
            r6 = r4
            goto L_0x0024
        L_0x0022:
            r6 = r24
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002d
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x002f
        L_0x002d:
            r7 = r25
        L_0x002f:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0035
            r8 = 0
            goto L_0x0037
        L_0x0035:
            r8 = r26
        L_0x0037:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003d
            r9 = 0
            goto L_0x003f
        L_0x003d:
            r9 = r27
        L_0x003f:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0045
            r10 = 0
            goto L_0x0047
        L_0x0045:
            r10 = r28
        L_0x0047:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x004d
            r12 = 0
            goto L_0x004f
        L_0x004d:
            r12 = r29
        L_0x004f:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0055
            r13 = 0
            goto L_0x0057
        L_0x0055:
            r13 = r30
        L_0x0057:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            r15 = 1
            if (r14 == 0) goto L_0x005e
            r14 = r15
            goto L_0x0060
        L_0x005e:
            r14 = r31
        L_0x0060:
            r2 = r0 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r15 = r32
        L_0x0067:
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x006d
            r2 = r4
            goto L_0x006f
        L_0x006d:
            r2 = r33
        L_0x006f:
            r11 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r11 == 0) goto L_0x007b
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            java.util.Map r11 = (java.util.Map) r11
            goto L_0x007d
        L_0x007b:
            r11 = r34
        L_0x007d:
            r16 = r4
            r4 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x0088
            zendesk.messaging.android.internal.model.TypingUser$None r4 = zendesk.messaging.android.internal.model.TypingUser.None.INSTANCE
            zendesk.messaging.android.internal.model.TypingUser r4 = (zendesk.messaging.android.internal.model.TypingUser) r4
            goto L_0x008a
        L_0x0088:
            r4 = r35
        L_0x008a:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0092
            goto L_0x0094
        L_0x0092:
            r16 = r36
        L_0x0094:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x009d
            r17 = 0
            goto L_0x009f
        L_0x009d:
            r17 = r37
        L_0x009f:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x00a8
            r18 = 0
            goto L_0x00aa
        L_0x00a8:
            r18 = r38
        L_0x00aa:
            r19 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r19
            if (r0 == 0) goto L_0x00b2
            r0 = 0
            goto L_0x00b4
        L_0x00b2:
            r0 = r39
        L_0x00b4:
            r21 = r20
            r22 = r1
            r23 = r3
            r24 = r5
            r25 = r6
            r26 = r7
            r27 = r8
            r28 = r9
            r29 = r10
            r30 = r12
            r31 = r13
            r32 = r14
            r33 = r15
            r34 = r2
            r35 = r11
            r36 = r4
            r37 = r16
            r38 = r17
            r39 = r18
            r40 = r0
            r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.ConversationScreenState.<init>(zendesk.android.messaging.model.ColorTheme, java.lang.String, java.lang.String, java.lang.String, java.util.List, zendesk.conversationkit.android.model.Conversation, java.lang.Throwable, boolean, int, zendesk.conversationkit.android.ConnectionStatus, boolean, boolean, java.lang.String, java.util.Map, zendesk.messaging.android.internal.model.TypingUser, java.lang.String, boolean, zendesk.messaging.android.internal.model.LoadMoreStatus, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<MessageLogEntry> getMessageLog() {
        return this.messageLog;
    }

    public final Conversation getConversation() {
        return this.conversation;
    }

    public final Throwable getError() {
        return this.error;
    }

    public final boolean getBlockChatInput() {
        return this.blockChatInput;
    }

    public final int getMessageComposerVisibility() {
        return this.messageComposerVisibility;
    }

    public final ConnectionStatus getConnectionStatus() {
        return this.connectionStatus;
    }

    public final boolean getGallerySupported() {
        return this.gallerySupported;
    }

    public final boolean getCameraSupported() {
        return this.cameraSupported;
    }

    public final String getComposerText() {
        return this.composerText;
    }

    public final Map<Integer, DisplayedField> getMapOfDisplayedFields() {
        return this.mapOfDisplayedFields;
    }

    public final TypingUser getTypingUser() {
        return this.typingUser;
    }

    public final String getInitialText() {
        return this.initialText;
    }

    public final boolean getShowDeniedPermission() {
        return this.showDeniedPermission;
    }

    public final LoadMoreStatus getLoadMoreStatus() {
        return this.loadMoreStatus;
    }

    public final boolean getShouldAnnounceMessage() {
        return this.shouldAnnounceMessage;
    }
}
