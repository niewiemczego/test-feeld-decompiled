package zendesk.ui.android.conversation.header;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001'B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000e\u0010\u0014\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\u0017J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0002\b\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\bHÀ\u0003¢\u0006\u0004\b\u001b\u0010\fJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\bHÀ\u0003¢\u0006\u0004\b\u001d\u0010\fJH\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\bHÖ\u0001J\u0006\u0010$\u001a\u00020%J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006("}, d2 = {"Lzendesk/ui/android/conversation/header/ConversationHeaderState;", "", "title", "", "description", "logo", "Landroid/net/Uri;", "backgroundColor", "", "statusBarColor", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBackgroundColor$zendesk_ui_ui_android", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDescription$zendesk_ui_ui_android", "()Ljava/lang/String;", "getLogo$zendesk_ui_ui_android", "()Landroid/net/Uri;", "getStatusBarColor$zendesk_ui_ui_android", "getTitle$zendesk_ui_ui_android", "component1", "component1$zendesk_ui_ui_android", "component2", "component2$zendesk_ui_ui_android", "component3", "component3$zendesk_ui_ui_android", "component4", "component4$zendesk_ui_ui_android", "component5", "component5$zendesk_ui_ui_android", "copy", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/Integer;Ljava/lang/Integer;)Lzendesk/ui/android/conversation/header/ConversationHeaderState;", "equals", "", "other", "hashCode", "toBuilder", "Lzendesk/ui/android/conversation/header/ConversationHeaderState$Builder;", "toString", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationHeaderState.kt */
public final class ConversationHeaderState {
    private final Integer backgroundColor;
    private final String description;
    private final Uri logo;
    private final Integer statusBarColor;
    private final String title;

    public ConversationHeaderState() {
        this((String) null, (String) null, (Uri) null, (Integer) null, (Integer) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ConversationHeaderState copy$default(ConversationHeaderState conversationHeaderState, String str, String str2, Uri uri, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = conversationHeaderState.title;
        }
        if ((i & 2) != 0) {
            str2 = conversationHeaderState.description;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            uri = conversationHeaderState.logo;
        }
        Uri uri2 = uri;
        if ((i & 8) != 0) {
            num = conversationHeaderState.backgroundColor;
        }
        Integer num3 = num;
        if ((i & 16) != 0) {
            num2 = conversationHeaderState.statusBarColor;
        }
        return conversationHeaderState.copy(str, str3, uri2, num3, num2);
    }

    public final String component1$zendesk_ui_ui_android() {
        return this.title;
    }

    public final String component2$zendesk_ui_ui_android() {
        return this.description;
    }

    public final Uri component3$zendesk_ui_ui_android() {
        return this.logo;
    }

    public final Integer component4$zendesk_ui_ui_android() {
        return this.backgroundColor;
    }

    public final Integer component5$zendesk_ui_ui_android() {
        return this.statusBarColor;
    }

    public final ConversationHeaderState copy(String str, String str2, Uri uri, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new ConversationHeaderState(str, str2, uri, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConversationHeaderState)) {
            return false;
        }
        ConversationHeaderState conversationHeaderState = (ConversationHeaderState) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) conversationHeaderState.title) && Intrinsics.areEqual((Object) this.description, (Object) conversationHeaderState.description) && Intrinsics.areEqual((Object) this.logo, (Object) conversationHeaderState.logo) && Intrinsics.areEqual((Object) this.backgroundColor, (Object) conversationHeaderState.backgroundColor) && Intrinsics.areEqual((Object) this.statusBarColor, (Object) conversationHeaderState.statusBarColor);
    }

    public int hashCode() {
        int hashCode = this.title.hashCode() * 31;
        String str = this.description;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Uri uri = this.logo;
        int hashCode3 = (hashCode2 + (uri == null ? 0 : uri.hashCode())) * 31;
        Integer num = this.backgroundColor;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.statusBarColor;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "ConversationHeaderState(title=" + this.title + ", description=" + this.description + ", logo=" + this.logo + ", backgroundColor=" + this.backgroundColor + ", statusBarColor=" + this.statusBarColor + ')';
    }

    public ConversationHeaderState(String str, String str2, Uri uri, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.description = str2;
        this.logo = uri;
        this.backgroundColor = num;
        this.statusBarColor = num2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ConversationHeaderState(java.lang.String r4, java.lang.String r5, android.net.Uri r6, java.lang.Integer r7, java.lang.Integer r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0006
            java.lang.String r4 = ""
        L_0x0006:
            r10 = r9 & 2
            r0 = 0
            if (r10 == 0) goto L_0x000d
            r10 = r0
            goto L_0x000e
        L_0x000d:
            r10 = r5
        L_0x000e:
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0014
            r1 = r0
            goto L_0x0015
        L_0x0014:
            r1 = r6
        L_0x0015:
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001b
            r2 = r0
            goto L_0x001c
        L_0x001b:
            r2 = r7
        L_0x001c:
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r0 = r8
        L_0x0022:
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r1
            r9 = r2
            r10 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.ui.android.conversation.header.ConversationHeaderState.<init>(java.lang.String, java.lang.String, android.net.Uri, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getTitle$zendesk_ui_ui_android() {
        return this.title;
    }

    public final String getDescription$zendesk_ui_ui_android() {
        return this.description;
    }

    public final Uri getLogo$zendesk_ui_ui_android() {
        return this.logo;
    }

    public final Integer getBackgroundColor$zendesk_ui_ui_android() {
        return this.backgroundColor;
    }

    public final Integer getStatusBarColor$zendesk_ui_ui_android() {
        return this.statusBarColor;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0003J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u00002\b\b\u0001\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lzendesk/ui/android/conversation/header/ConversationHeaderState$Builder;", "", "state", "Lzendesk/ui/android/conversation/header/ConversationHeaderState;", "(Lzendesk/ui/android/conversation/header/ConversationHeaderState;)V", "()V", "backgroundColor", "color", "", "build", "description", "", "logo", "Landroid/net/Uri;", "statusBarColor", "title", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationHeaderState.kt */
    public static final class Builder {
        private ConversationHeaderState state;

        public Builder() {
            this.state = new ConversationHeaderState((String) null, (String) null, (Uri) null, (Integer) null, (Integer) null, 31, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(ConversationHeaderState conversationHeaderState) {
            this();
            Intrinsics.checkNotNullParameter(conversationHeaderState, "state");
            this.state = conversationHeaderState;
        }

        public final Builder title(String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            Builder builder = this;
            this.state = ConversationHeaderState.copy$default(this.state, str, (String) null, (Uri) null, (Integer) null, (Integer) null, 30, (Object) null);
            return this;
        }

        public final Builder description(String str) {
            Builder builder = this;
            this.state = ConversationHeaderState.copy$default(this.state, (String) null, str, (Uri) null, (Integer) null, (Integer) null, 29, (Object) null);
            return this;
        }

        public final Builder logo(Uri uri) {
            Builder builder = this;
            this.state = ConversationHeaderState.copy$default(this.state, (String) null, (String) null, uri, (Integer) null, (Integer) null, 27, (Object) null);
            return this;
        }

        public final Builder backgroundColor(int i) {
            Builder builder = this;
            this.state = ConversationHeaderState.copy$default(this.state, (String) null, (String) null, (Uri) null, Integer.valueOf(i), (Integer) null, 23, (Object) null);
            return this;
        }

        public final Builder statusBarColor(int i) {
            Builder builder = this;
            this.state = ConversationHeaderState.copy$default(this.state, (String) null, (String) null, (Uri) null, (Integer) null, Integer.valueOf(i), 15, (Object) null);
            return this;
        }

        public final ConversationHeaderState build() {
            return this.state;
        }
    }
}
