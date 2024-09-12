package zendesk.conversationkit.android.model;

import com.facebook.GraphRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.FileExtKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0007\b\t\n\u000b\f\r\u000eB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\b\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lzendesk/conversationkit/android/model/MessageContent;", "", "type", "Lzendesk/conversationkit/android/model/MessageType;", "(Lzendesk/conversationkit/android/model/MessageType;)V", "getType", "()Lzendesk/conversationkit/android/model/MessageType;", "Carousel", "File", "FileUpload", "Form", "FormResponse", "Image", "Text", "Unsupported", "Lzendesk/conversationkit/android/model/MessageContent$Unsupported;", "Lzendesk/conversationkit/android/model/MessageContent$Text;", "Lzendesk/conversationkit/android/model/MessageContent$FileUpload;", "Lzendesk/conversationkit/android/model/MessageContent$File;", "Lzendesk/conversationkit/android/model/MessageContent$Form;", "Lzendesk/conversationkit/android/model/MessageContent$FormResponse;", "Lzendesk/conversationkit/android/model/MessageContent$Carousel;", "Lzendesk/conversationkit/android/model/MessageContent$Image;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Message.kt */
public abstract class MessageContent {
    private final MessageType type;

    public /* synthetic */ MessageContent(MessageType messageType, DefaultConstructorMarker defaultConstructorMarker) {
        this(messageType);
    }

    private MessageContent(MessageType messageType) {
        this.type = messageType;
    }

    public final MessageType getType() {
        return this.type;
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\bJ\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/model/MessageContent$Unsupported;", "Lzendesk/conversationkit/android/model/MessageContent;", "id", "", "(Ljava/lang/String;)V", "getId$zendesk_conversationkit_conversationkit_android", "()Ljava/lang/String;", "component1", "component1$zendesk_conversationkit_conversationkit_android", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Message.kt */
    public static final class Unsupported extends MessageContent {
        private final String id;

        public Unsupported() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Unsupported copy$default(Unsupported unsupported, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unsupported.id;
            }
            return unsupported.copy(str);
        }

        public final String component1$zendesk_conversationkit_conversationkit_android() {
            return this.id;
        }

        public final Unsupported copy(String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            return new Unsupported(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Unsupported) && Intrinsics.areEqual((Object) this.id, (Object) ((Unsupported) obj).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "Unsupported(id=" + this.id + ')';
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Unsupported(java.lang.String r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
            /*
                r0 = this;
                r2 = r2 & 1
                if (r2 == 0) goto L_0x0011
                java.util.UUID r1 = java.util.UUID.randomUUID()
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "randomUUID().toString()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            L_0x0011:
                r0.<init>(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.model.MessageContent.Unsupported.<init>(java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getId$zendesk_conversationkit_conversationkit_android() {
            return this.id;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Unsupported(String str) {
            super(MessageType.UNSUPPORTED, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            this.id = str;
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lzendesk/conversationkit/android/model/MessageContent$Text;", "Lzendesk/conversationkit/android/model/MessageContent;", "text", "", "actions", "", "Lzendesk/conversationkit/android/model/MessageAction;", "(Ljava/lang/String;Ljava/util/List;)V", "getActions", "()Ljava/util/List;", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Message.kt */
    public static final class Text extends MessageContent {
        private final List<MessageAction> actions;
        private final String text;

        public static /* synthetic */ Text copy$default(Text text2, String str, List<MessageAction> list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = text2.text;
            }
            if ((i & 2) != 0) {
                list = text2.actions;
            }
            return text2.copy(str, list);
        }

        public final String component1() {
            return this.text;
        }

        public final List<MessageAction> component2() {
            return this.actions;
        }

        public final Text copy(String str, List<? extends MessageAction> list) {
            Intrinsics.checkNotNullParameter(str, "text");
            return new Text(str, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Text)) {
                return false;
            }
            Text text2 = (Text) obj;
            return Intrinsics.areEqual((Object) this.text, (Object) text2.text) && Intrinsics.areEqual((Object) this.actions, (Object) text2.actions);
        }

        public int hashCode() {
            int hashCode = this.text.hashCode() * 31;
            List<MessageAction> list = this.actions;
            return hashCode + (list == null ? 0 : list.hashCode());
        }

        public String toString() {
            return "Text(text=" + this.text + ", actions=" + this.actions + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Text(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : list);
        }

        public final String getText() {
            return this.text;
        }

        public final List<MessageAction> getActions() {
            return this.actions;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Text(String str, List<? extends MessageAction> list) {
            super(MessageType.TEXT, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "text");
            this.text = str;
            this.actions = list;
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0006\u0010\u001a\u001a\u00020\u0015J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lzendesk/conversationkit/android/model/MessageContent$FileUpload;", "Lzendesk/conversationkit/android/model/MessageContent;", "uri", "", "name", "size", "", "mimeType", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getMimeType", "()Ljava/lang/String;", "getName", "getSize", "()J", "getUri", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "isImageMimeType", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Message.kt */
    public static final class FileUpload extends MessageContent {
        private final String mimeType;
        private final String name;
        private final long size;
        private final String uri;

        public static /* synthetic */ FileUpload copy$default(FileUpload fileUpload, String str, String str2, long j, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fileUpload.uri;
            }
            if ((i & 2) != 0) {
                str2 = fileUpload.name;
            }
            String str4 = str2;
            if ((i & 4) != 0) {
                j = fileUpload.size;
            }
            long j2 = j;
            if ((i & 8) != 0) {
                str3 = fileUpload.mimeType;
            }
            return fileUpload.copy(str, str4, j2, str3);
        }

        public final String component1() {
            return this.uri;
        }

        public final String component2() {
            return this.name;
        }

        public final long component3() {
            return this.size;
        }

        public final String component4() {
            return this.mimeType;
        }

        public final FileUpload copy(String str, String str2, long j, String str3) {
            Intrinsics.checkNotNullParameter(str, "uri");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "mimeType");
            return new FileUpload(str, str2, j, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FileUpload)) {
                return false;
            }
            FileUpload fileUpload = (FileUpload) obj;
            return Intrinsics.areEqual((Object) this.uri, (Object) fileUpload.uri) && Intrinsics.areEqual((Object) this.name, (Object) fileUpload.name) && this.size == fileUpload.size && Intrinsics.areEqual((Object) this.mimeType, (Object) fileUpload.mimeType);
        }

        public int hashCode() {
            return (((((this.uri.hashCode() * 31) + this.name.hashCode()) * 31) + Long.hashCode(this.size)) * 31) + this.mimeType.hashCode();
        }

        public String toString() {
            return "FileUpload(uri=" + this.uri + ", name=" + this.name + ", size=" + this.size + ", mimeType=" + this.mimeType + ')';
        }

        public final String getUri() {
            return this.uri;
        }

        public final String getName() {
            return this.name;
        }

        public final long getSize() {
            return this.size;
        }

        public final String getMimeType() {
            return this.mimeType;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FileUpload(String str, String str2, long j, String str3) {
            super(MessageType.FILE_UPLOAD, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "uri");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "mimeType");
            this.uri = str;
            this.name = str2;
            this.size = j;
            this.mimeType = str3;
        }

        public final boolean isImageMimeType() {
            return FileExtKt.isImageMimeType(this.mimeType);
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lzendesk/conversationkit/android/model/MessageContent$File;", "Lzendesk/conversationkit/android/model/MessageContent;", "text", "", "altText", "mediaUrl", "mediaType", "mediaSize", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getAltText", "()Ljava/lang/String;", "getMediaSize", "()J", "getMediaType", "getMediaUrl", "getText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Message.kt */
    public static final class File extends MessageContent {
        private final String altText;
        private final long mediaSize;
        private final String mediaType;
        private final String mediaUrl;
        private final String text;

        public static /* synthetic */ File copy$default(File file, String str, String str2, String str3, String str4, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = file.text;
            }
            if ((i & 2) != 0) {
                str2 = file.altText;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                str3 = file.mediaUrl;
            }
            String str6 = str3;
            if ((i & 8) != 0) {
                str4 = file.mediaType;
            }
            String str7 = str4;
            if ((i & 16) != 0) {
                j = file.mediaSize;
            }
            return file.copy(str, str5, str6, str7, j);
        }

        public final String component1() {
            return this.text;
        }

        public final String component2() {
            return this.altText;
        }

        public final String component3() {
            return this.mediaUrl;
        }

        public final String component4() {
            return this.mediaType;
        }

        public final long component5() {
            return this.mediaSize;
        }

        public final File copy(String str, String str2, String str3, String str4, long j) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(str2, "altText");
            Intrinsics.checkNotNullParameter(str3, "mediaUrl");
            Intrinsics.checkNotNullParameter(str4, "mediaType");
            return new File(str, str2, str3, str4, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof File)) {
                return false;
            }
            File file = (File) obj;
            return Intrinsics.areEqual((Object) this.text, (Object) file.text) && Intrinsics.areEqual((Object) this.altText, (Object) file.altText) && Intrinsics.areEqual((Object) this.mediaUrl, (Object) file.mediaUrl) && Intrinsics.areEqual((Object) this.mediaType, (Object) file.mediaType) && this.mediaSize == file.mediaSize;
        }

        public int hashCode() {
            return (((((((this.text.hashCode() * 31) + this.altText.hashCode()) * 31) + this.mediaUrl.hashCode()) * 31) + this.mediaType.hashCode()) * 31) + Long.hashCode(this.mediaSize);
        }

        public String toString() {
            return "File(text=" + this.text + ", altText=" + this.altText + ", mediaUrl=" + this.mediaUrl + ", mediaType=" + this.mediaType + ", mediaSize=" + this.mediaSize + ')';
        }

        public final String getText() {
            return this.text;
        }

        public final String getAltText() {
            return this.altText;
        }

        public final String getMediaUrl() {
            return this.mediaUrl;
        }

        public final String getMediaType() {
            return this.mediaType;
        }

        public final long getMediaSize() {
            return this.mediaSize;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public File(String str, String str2, String str3, String str4, long j) {
            super(MessageType.FILE, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(str2, "altText");
            Intrinsics.checkNotNullParameter(str3, "mediaUrl");
            Intrinsics.checkNotNullParameter(str4, "mediaType");
            this.text = str;
            this.altText = str2;
            this.mediaUrl = str3;
            this.mediaType = str4;
            this.mediaSize = j;
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lzendesk/conversationkit/android/model/MessageContent$Form;", "Lzendesk/conversationkit/android/model/MessageContent;", "fields", "", "Lzendesk/conversationkit/android/model/Field;", "blockChatInput", "", "(Ljava/util/List;Z)V", "getBlockChatInput", "()Z", "getFields", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Message.kt */
    public static final class Form extends MessageContent {
        private final boolean blockChatInput;
        private final List<Field> fields;

        public static /* synthetic */ Form copy$default(Form form, List<Field> list, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                list = form.fields;
            }
            if ((i & 2) != 0) {
                z = form.blockChatInput;
            }
            return form.copy(list, z);
        }

        public final List<Field> component1() {
            return this.fields;
        }

        public final boolean component2() {
            return this.blockChatInput;
        }

        public final Form copy(List<? extends Field> list, boolean z) {
            Intrinsics.checkNotNullParameter(list, GraphRequest.FIELDS_PARAM);
            return new Form(list, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Form)) {
                return false;
            }
            Form form = (Form) obj;
            return Intrinsics.areEqual((Object) this.fields, (Object) form.fields) && this.blockChatInput == form.blockChatInput;
        }

        public int hashCode() {
            int hashCode = this.fields.hashCode() * 31;
            boolean z = this.blockChatInput;
            if (z) {
                z = true;
            }
            return hashCode + (z ? 1 : 0);
        }

        public String toString() {
            return "Form(fields=" + this.fields + ", blockChatInput=" + this.blockChatInput + ')';
        }

        public final List<Field> getFields() {
            return this.fields;
        }

        public final boolean getBlockChatInput() {
            return this.blockChatInput;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Form(List<? extends Field> list, boolean z) {
            super(MessageType.FORM, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, GraphRequest.FIELDS_PARAM);
            this.fields = list;
            this.blockChatInput = z;
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lzendesk/conversationkit/android/model/MessageContent$FormResponse;", "Lzendesk/conversationkit/android/model/MessageContent;", "quotedMessageId", "", "fields", "", "Lzendesk/conversationkit/android/model/Field;", "(Ljava/lang/String;Ljava/util/List;)V", "getFields", "()Ljava/util/List;", "getQuotedMessageId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Message.kt */
    public static final class FormResponse extends MessageContent {
        private final List<Field> fields;
        private final String quotedMessageId;

        public static /* synthetic */ FormResponse copy$default(FormResponse formResponse, String str, List<Field> list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = formResponse.quotedMessageId;
            }
            if ((i & 2) != 0) {
                list = formResponse.fields;
            }
            return formResponse.copy(str, list);
        }

        public final String component1() {
            return this.quotedMessageId;
        }

        public final List<Field> component2() {
            return this.fields;
        }

        public final FormResponse copy(String str, List<? extends Field> list) {
            Intrinsics.checkNotNullParameter(str, "quotedMessageId");
            Intrinsics.checkNotNullParameter(list, GraphRequest.FIELDS_PARAM);
            return new FormResponse(str, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FormResponse)) {
                return false;
            }
            FormResponse formResponse = (FormResponse) obj;
            return Intrinsics.areEqual((Object) this.quotedMessageId, (Object) formResponse.quotedMessageId) && Intrinsics.areEqual((Object) this.fields, (Object) formResponse.fields);
        }

        public int hashCode() {
            return (this.quotedMessageId.hashCode() * 31) + this.fields.hashCode();
        }

        public String toString() {
            return "FormResponse(quotedMessageId=" + this.quotedMessageId + ", fields=" + this.fields + ')';
        }

        public final String getQuotedMessageId() {
            return this.quotedMessageId;
        }

        public final List<Field> getFields() {
            return this.fields;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FormResponse(String str, List<? extends Field> list) {
            super(MessageType.FORM_RESPONSE, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "quotedMessageId");
            Intrinsics.checkNotNullParameter(list, GraphRequest.FIELDS_PARAM);
            this.quotedMessageId = str;
            this.fields = list;
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lzendesk/conversationkit/android/model/MessageContent$Carousel;", "Lzendesk/conversationkit/android/model/MessageContent;", "items", "", "Lzendesk/conversationkit/android/model/MessageItem;", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Message.kt */
    public static final class Carousel extends MessageContent {
        private final List<MessageItem> items;

        public static /* synthetic */ Carousel copy$default(Carousel carousel, List<MessageItem> list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = carousel.items;
            }
            return carousel.copy(list);
        }

        public final List<MessageItem> component1() {
            return this.items;
        }

        public final Carousel copy(List<MessageItem> list) {
            Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
            return new Carousel(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Carousel) && Intrinsics.areEqual((Object) this.items, (Object) ((Carousel) obj).items);
        }

        public int hashCode() {
            return this.items.hashCode();
        }

        public String toString() {
            return "Carousel(items=" + this.items + ')';
        }

        public final List<MessageItem> getItems() {
            return this.items;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Carousel(List<MessageItem> list) {
            super(MessageType.CAROUSEL, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
            this.items = list;
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006$"}, d2 = {"Lzendesk/conversationkit/android/model/MessageContent$Image;", "Lzendesk/conversationkit/android/model/MessageContent;", "text", "", "mediaUrl", "localUri", "mediaType", "mediaSize", "", "actions", "", "Lzendesk/conversationkit/android/model/MessageAction;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "getActions", "()Ljava/util/List;", "getLocalUri", "()Ljava/lang/String;", "getMediaSize", "()J", "getMediaType", "getMediaUrl", "getText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Message.kt */
    public static final class Image extends MessageContent {
        private final List<MessageAction> actions;
        private final String localUri;
        private final long mediaSize;
        private final String mediaType;
        private final String mediaUrl;
        private final String text;

        public static /* synthetic */ Image copy$default(Image image, String str, String str2, String str3, String str4, long j, List<MessageAction> list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = image.text;
            }
            if ((i & 2) != 0) {
                str2 = image.mediaUrl;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                str3 = image.localUri;
            }
            String str6 = str3;
            if ((i & 8) != 0) {
                str4 = image.mediaType;
            }
            String str7 = str4;
            if ((i & 16) != 0) {
                j = image.mediaSize;
            }
            long j2 = j;
            if ((i & 32) != 0) {
                list = image.actions;
            }
            return image.copy(str, str5, str6, str7, j2, list);
        }

        public final String component1() {
            return this.text;
        }

        public final String component2() {
            return this.mediaUrl;
        }

        public final String component3() {
            return this.localUri;
        }

        public final String component4() {
            return this.mediaType;
        }

        public final long component5() {
            return this.mediaSize;
        }

        public final List<MessageAction> component6() {
            return this.actions;
        }

        public final Image copy(String str, String str2, String str3, String str4, long j, List<? extends MessageAction> list) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(str2, "mediaUrl");
            Intrinsics.checkNotNullParameter(str4, "mediaType");
            return new Image(str, str2, str3, str4, j, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Image)) {
                return false;
            }
            Image image = (Image) obj;
            return Intrinsics.areEqual((Object) this.text, (Object) image.text) && Intrinsics.areEqual((Object) this.mediaUrl, (Object) image.mediaUrl) && Intrinsics.areEqual((Object) this.localUri, (Object) image.localUri) && Intrinsics.areEqual((Object) this.mediaType, (Object) image.mediaType) && this.mediaSize == image.mediaSize && Intrinsics.areEqual((Object) this.actions, (Object) image.actions);
        }

        public int hashCode() {
            int hashCode = ((this.text.hashCode() * 31) + this.mediaUrl.hashCode()) * 31;
            String str = this.localUri;
            int i = 0;
            int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.mediaType.hashCode()) * 31) + Long.hashCode(this.mediaSize)) * 31;
            List<MessageAction> list = this.actions;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "Image(text=" + this.text + ", mediaUrl=" + this.mediaUrl + ", localUri=" + this.localUri + ", mediaType=" + this.mediaType + ", mediaSize=" + this.mediaSize + ", actions=" + this.actions + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Image(String str, String str2, String str3, String str4, long j, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, j, (i & 32) != 0 ? null : list);
        }

        public final String getText() {
            return this.text;
        }

        public final String getMediaUrl() {
            return this.mediaUrl;
        }

        public final String getLocalUri() {
            return this.localUri;
        }

        public final String getMediaType() {
            return this.mediaType;
        }

        public final long getMediaSize() {
            return this.mediaSize;
        }

        public final List<MessageAction> getActions() {
            return this.actions;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Image(String str, String str2, String str3, String str4, long j, List<? extends MessageAction> list) {
            super(MessageType.IMAGE, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(str2, "mediaUrl");
            Intrinsics.checkNotNullParameter(str4, "mediaType");
            this.text = str;
            this.mediaUrl = str2;
            this.localUri = str3;
            this.mediaType = str4;
            this.mediaSize = j;
            this.actions = list;
        }
    }
}
