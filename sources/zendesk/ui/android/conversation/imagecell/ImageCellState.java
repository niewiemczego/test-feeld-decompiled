package zendesk.ui.android.conversation.imagecell;

import android.net.Uri;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.conversation.actionbutton.ActionButton;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001IB\u0001\b\u0000\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b*J\u0012\u0010+\u001a\u0004\u0018\u00010\u000fHÀ\u0003¢\u0006\u0004\b,\u0010\u0017J\u0010\u0010-\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0002\b.J\u000e\u0010/\u001a\u00020\u0014HÀ\u0003¢\u0006\u0002\b0J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b2J\u0010\u00103\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0002\b4J\u0010\u00105\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0002\b6J\u000e\u00107\u001a\u00020\tHÀ\u0003¢\u0006\u0002\b8J\u000e\u00109\u001a\u00020\tHÀ\u0003¢\u0006\u0002\b:J\u0016\u0010;\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÀ\u0003¢\u0006\u0002\b<J\u0012\u0010=\u001a\u0004\u0018\u00010\u000fHÀ\u0003¢\u0006\u0004\b>\u0010\u0017J\u0012\u0010?\u001a\u0004\u0018\u00010\u000fHÀ\u0003¢\u0006\u0004\b@\u0010\u0017J\u0001\u0010A\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001¢\u0006\u0002\u0010BJ\u0013\u0010C\u001a\u00020\t2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\u000fHÖ\u0001J\u0006\u0010F\u001a\u00020GJ\t\u0010H\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001b\u0010\u0017R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010\n\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b'\u0010\u0017R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%¨\u0006J"}, d2 = {"Lzendesk/ui/android/conversation/imagecell/ImageCellState;", "", "uri", "Landroid/net/Uri;", "localUri", "imageType", "", "messageText", "isError", "", "isPending", "actions", "", "Lzendesk/ui/android/conversation/actionbutton/ActionButton;", "textColor", "", "backgroundColor", "actionColor", "errorText", "imageCellDirection", "Lzendesk/ui/android/conversation/imagecell/ImageCellDirection;", "(Landroid/net/Uri;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lzendesk/ui/android/conversation/imagecell/ImageCellDirection;)V", "getActionColor$zendesk_ui_ui_android", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getActions$zendesk_ui_ui_android", "()Ljava/util/List;", "getBackgroundColor$zendesk_ui_ui_android", "getErrorText$zendesk_ui_ui_android", "()Ljava/lang/String;", "getImageCellDirection$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/imagecell/ImageCellDirection;", "getImageType$zendesk_ui_ui_android", "isError$zendesk_ui_ui_android", "()Z", "isPending$zendesk_ui_ui_android", "getLocalUri$zendesk_ui_ui_android", "()Landroid/net/Uri;", "getMessageText$zendesk_ui_ui_android", "getTextColor$zendesk_ui_ui_android", "getUri$zendesk_ui_ui_android", "component1", "component1$zendesk_ui_ui_android", "component10", "component10$zendesk_ui_ui_android", "component11", "component11$zendesk_ui_ui_android", "component12", "component12$zendesk_ui_ui_android", "component2", "component2$zendesk_ui_ui_android", "component3", "component3$zendesk_ui_ui_android", "component4", "component4$zendesk_ui_ui_android", "component5", "component5$zendesk_ui_ui_android", "component6", "component6$zendesk_ui_ui_android", "component7", "component7$zendesk_ui_ui_android", "component8", "component8$zendesk_ui_ui_android", "component9", "component9$zendesk_ui_ui_android", "copy", "(Landroid/net/Uri;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lzendesk/ui/android/conversation/imagecell/ImageCellDirection;)Lzendesk/ui/android/conversation/imagecell/ImageCellState;", "equals", "other", "hashCode", "toBuilder", "Lzendesk/ui/android/conversation/imagecell/ImageCellState$Builder;", "toString", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageCellState.kt */
public final class ImageCellState {
    private final Integer actionColor;
    private final List<ActionButton> actions;
    private final Integer backgroundColor;
    private final String errorText;
    private final ImageCellDirection imageCellDirection;
    private final String imageType;
    private final boolean isError;
    private final boolean isPending;
    private final Uri localUri;
    private final String messageText;
    private final Integer textColor;
    private final Uri uri;

    public ImageCellState() {
        this((Uri) null, (Uri) null, (String) null, (String) null, false, false, (List) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (ImageCellDirection) null, 4095, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ImageCellState copy$default(ImageCellState imageCellState, Uri uri2, Uri uri3, String str, String str2, boolean z, boolean z2, List list, Integer num, Integer num2, Integer num3, String str3, ImageCellDirection imageCellDirection2, int i, Object obj) {
        ImageCellState imageCellState2 = imageCellState;
        int i2 = i;
        return imageCellState.copy((i2 & 1) != 0 ? imageCellState2.uri : uri2, (i2 & 2) != 0 ? imageCellState2.localUri : uri3, (i2 & 4) != 0 ? imageCellState2.imageType : str, (i2 & 8) != 0 ? imageCellState2.messageText : str2, (i2 & 16) != 0 ? imageCellState2.isError : z, (i2 & 32) != 0 ? imageCellState2.isPending : z2, (i2 & 64) != 0 ? imageCellState2.actions : list, (i2 & 128) != 0 ? imageCellState2.textColor : num, (i2 & 256) != 0 ? imageCellState2.backgroundColor : num2, (i2 & 512) != 0 ? imageCellState2.actionColor : num3, (i2 & 1024) != 0 ? imageCellState2.errorText : str3, (i2 & 2048) != 0 ? imageCellState2.imageCellDirection : imageCellDirection2);
    }

    public final Uri component1$zendesk_ui_ui_android() {
        return this.uri;
    }

    public final Integer component10$zendesk_ui_ui_android() {
        return this.actionColor;
    }

    public final String component11$zendesk_ui_ui_android() {
        return this.errorText;
    }

    public final ImageCellDirection component12$zendesk_ui_ui_android() {
        return this.imageCellDirection;
    }

    public final Uri component2$zendesk_ui_ui_android() {
        return this.localUri;
    }

    public final String component3$zendesk_ui_ui_android() {
        return this.imageType;
    }

    public final String component4$zendesk_ui_ui_android() {
        return this.messageText;
    }

    public final boolean component5$zendesk_ui_ui_android() {
        return this.isError;
    }

    public final boolean component6$zendesk_ui_ui_android() {
        return this.isPending;
    }

    public final List<ActionButton> component7$zendesk_ui_ui_android() {
        return this.actions;
    }

    public final Integer component8$zendesk_ui_ui_android() {
        return this.textColor;
    }

    public final Integer component9$zendesk_ui_ui_android() {
        return this.backgroundColor;
    }

    public final ImageCellState copy(Uri uri2, Uri uri3, String str, String str2, boolean z, boolean z2, List<ActionButton> list, Integer num, Integer num2, Integer num3, String str3, ImageCellDirection imageCellDirection2) {
        ImageCellDirection imageCellDirection3 = imageCellDirection2;
        Intrinsics.checkNotNullParameter(imageCellDirection3, "imageCellDirection");
        return new ImageCellState(uri2, uri3, str, str2, z, z2, list, num, num2, num3, str3, imageCellDirection3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageCellState)) {
            return false;
        }
        ImageCellState imageCellState = (ImageCellState) obj;
        return Intrinsics.areEqual((Object) this.uri, (Object) imageCellState.uri) && Intrinsics.areEqual((Object) this.localUri, (Object) imageCellState.localUri) && Intrinsics.areEqual((Object) this.imageType, (Object) imageCellState.imageType) && Intrinsics.areEqual((Object) this.messageText, (Object) imageCellState.messageText) && this.isError == imageCellState.isError && this.isPending == imageCellState.isPending && Intrinsics.areEqual((Object) this.actions, (Object) imageCellState.actions) && Intrinsics.areEqual((Object) this.textColor, (Object) imageCellState.textColor) && Intrinsics.areEqual((Object) this.backgroundColor, (Object) imageCellState.backgroundColor) && Intrinsics.areEqual((Object) this.actionColor, (Object) imageCellState.actionColor) && Intrinsics.areEqual((Object) this.errorText, (Object) imageCellState.errorText) && this.imageCellDirection == imageCellState.imageCellDirection;
    }

    public int hashCode() {
        Uri uri2 = this.uri;
        int i = 0;
        int hashCode = (uri2 == null ? 0 : uri2.hashCode()) * 31;
        Uri uri3 = this.localUri;
        int hashCode2 = (hashCode + (uri3 == null ? 0 : uri3.hashCode())) * 31;
        String str = this.imageType;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.messageText;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z = this.isError;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode4 + (z ? 1 : 0)) * 31;
        boolean z3 = this.isPending;
        if (!z3) {
            z2 = z3;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        List<ActionButton> list = this.actions;
        int hashCode5 = (i3 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.textColor;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.backgroundColor;
        int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.actionColor;
        int hashCode8 = (hashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str3 = this.errorText;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((hashCode8 + i) * 31) + this.imageCellDirection.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImageCellState(uri=").append(this.uri).append(", localUri=").append(this.localUri).append(", imageType=").append(this.imageType).append(", messageText=").append(this.messageText).append(", isError=").append(this.isError).append(", isPending=").append(this.isPending).append(", actions=").append(this.actions).append(", textColor=").append(this.textColor).append(", backgroundColor=").append(this.backgroundColor).append(", actionColor=").append(this.actionColor).append(", errorText=").append(this.errorText).append(", imageCellDirection=");
        sb.append(this.imageCellDirection).append(')');
        return sb.toString();
    }

    public ImageCellState(Uri uri2, Uri uri3, String str, String str2, boolean z, boolean z2, List<ActionButton> list, Integer num, Integer num2, Integer num3, String str3, ImageCellDirection imageCellDirection2) {
        Intrinsics.checkNotNullParameter(imageCellDirection2, "imageCellDirection");
        this.uri = uri2;
        this.localUri = uri3;
        this.imageType = str;
        this.messageText = str2;
        this.isError = z;
        this.isPending = z2;
        this.actions = list;
        this.textColor = num;
        this.backgroundColor = num2;
        this.actionColor = num3;
        this.errorText = str3;
        this.imageCellDirection = imageCellDirection2;
    }

    public final Uri getUri$zendesk_ui_ui_android() {
        return this.uri;
    }

    public final Uri getLocalUri$zendesk_ui_ui_android() {
        return this.localUri;
    }

    public final String getImageType$zendesk_ui_ui_android() {
        return this.imageType;
    }

    public final String getMessageText$zendesk_ui_ui_android() {
        return this.messageText;
    }

    public final boolean isError$zendesk_ui_ui_android() {
        return this.isError;
    }

    public final boolean isPending$zendesk_ui_ui_android() {
        return this.isPending;
    }

    public final List<ActionButton> getActions$zendesk_ui_ui_android() {
        return this.actions;
    }

    public final Integer getTextColor$zendesk_ui_ui_android() {
        return this.textColor;
    }

    public final Integer getBackgroundColor$zendesk_ui_ui_android() {
        return this.backgroundColor;
    }

    public final Integer getActionColor$zendesk_ui_ui_android() {
        return this.actionColor;
    }

    public final String getErrorText$zendesk_ui_ui_android() {
        return this.errorText;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ImageCellState(android.net.Uri r14, android.net.Uri r15, java.lang.String r16, java.lang.String r17, boolean r18, boolean r19, java.util.List r20, java.lang.Integer r21, java.lang.Integer r22, java.lang.Integer r23, java.lang.String r24, zendesk.ui.android.conversation.imagecell.ImageCellDirection r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r14
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r15
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0019
        L_0x0017:
            r4 = r16
        L_0x0019:
            r5 = r0 & 8
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x0021
            r5 = r6
            goto L_0x0023
        L_0x0021:
            r5 = r17
        L_0x0023:
            r7 = r0 & 16
            r8 = 0
            if (r7 == 0) goto L_0x002a
            r7 = r8
            goto L_0x002c
        L_0x002a:
            r7 = r18
        L_0x002c:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r8 = r19
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0039
            r9 = r2
            goto L_0x003b
        L_0x0039:
            r9 = r20
        L_0x003b:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0041
            r10 = r2
            goto L_0x0043
        L_0x0041:
            r10 = r21
        L_0x0043:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0049
            r11 = r2
            goto L_0x004b
        L_0x0049:
            r11 = r22
        L_0x004b:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r2 = r23
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0057
            goto L_0x0059
        L_0x0057:
            r6 = r24
        L_0x0059:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0060
            zendesk.ui.android.conversation.imagecell.ImageCellDirection r0 = zendesk.ui.android.conversation.imagecell.ImageCellDirection.INBOUND_SINGLE
            goto L_0x0062
        L_0x0060:
            r0 = r25
        L_0x0062:
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r11
            r24 = r2
            r25 = r6
            r26 = r0
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.ui.android.conversation.imagecell.ImageCellState.<init>(android.net.Uri, android.net.Uri, java.lang.String, java.lang.String, boolean, boolean, java.util.List, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, zendesk.ui.android.conversation.imagecell.ImageCellDirection, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final ImageCellDirection getImageCellDirection$zendesk_ui_ui_android() {
        return this.imageCellDirection;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0010\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0003J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0015\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lzendesk/ui/android/conversation/imagecell/ImageCellState$Builder;", "", "state", "Lzendesk/ui/android/conversation/imagecell/ImageCellState;", "(Lzendesk/ui/android/conversation/imagecell/ImageCellState;)V", "()V", "actions", "", "Lzendesk/ui/android/conversation/actionbutton/ActionButton;", "backgroundColor", "color", "", "build", "errorText", "", "imageCellDirection", "Lzendesk/ui/android/conversation/imagecell/ImageCellDirection;", "imageType", "localUri", "Landroid/net/Uri;", "messageText", "textColor", "uri", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageCellState.kt */
    public static final class Builder {
        private ImageCellState state;

        public Builder() {
            this.state = new ImageCellState((Uri) null, (Uri) null, (String) null, (String) null, false, false, (List) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (ImageCellDirection) null, 4095, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(ImageCellState imageCellState) {
            this();
            Intrinsics.checkNotNullParameter(imageCellState, "state");
            this.state = imageCellState;
        }

        public final Builder uri(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, "uri");
            Builder builder = this;
            this.state = ImageCellState.copy$default(this.state, uri2, (Uri) null, (String) null, (String) null, false, false, (List) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (ImageCellDirection) null, 4094, (Object) null);
            return this;
        }

        public final Builder localUri(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, "localUri");
            Builder builder = this;
            this.state = ImageCellState.copy$default(this.state, (Uri) null, uri2, (String) null, (String) null, false, false, (List) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (ImageCellDirection) null, 4093, (Object) null);
            return this;
        }

        public final Builder imageType(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "imageType");
            Builder builder = this;
            this.state = ImageCellState.copy$default(this.state, (Uri) null, (Uri) null, str2, (String) null, false, false, (List) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (ImageCellDirection) null, 4091, (Object) null);
            return this;
        }

        public final Builder messageText(String str) {
            Builder builder = this;
            this.state = ImageCellState.copy$default(this.state, (Uri) null, (Uri) null, (String) null, str, false, false, (List) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (ImageCellDirection) null, 4087, (Object) null);
            return this;
        }

        public final Builder textColor(int i) {
            Builder builder = this;
            this.state = ImageCellState.copy$default(this.state, (Uri) null, (Uri) null, (String) null, (String) null, false, false, (List) null, Integer.valueOf(i), (Integer) null, (Integer) null, (String) null, (ImageCellDirection) null, 3967, (Object) null);
            return this;
        }

        public final Builder backgroundColor(int i) {
            Builder builder = this;
            this.state = ImageCellState.copy$default(this.state, (Uri) null, (Uri) null, (String) null, (String) null, false, false, (List) null, (Integer) null, Integer.valueOf(i), (Integer) null, (String) null, (ImageCellDirection) null, 3839, (Object) null);
            return this;
        }

        public final Builder errorText(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "errorText");
            Builder builder = this;
            this.state = ImageCellState.copy$default(this.state, (Uri) null, (Uri) null, (String) null, (String) null, false, false, (List) null, (Integer) null, (Integer) null, (Integer) null, str2, (ImageCellDirection) null, 3071, (Object) null);
            return this;
        }

        public final Builder imageCellDirection(ImageCellDirection imageCellDirection) {
            ImageCellDirection imageCellDirection2 = imageCellDirection;
            Intrinsics.checkNotNullParameter(imageCellDirection2, "imageCellDirection");
            Builder builder = this;
            this.state = ImageCellState.copy$default(this.state, (Uri) null, (Uri) null, (String) null, (String) null, false, false, (List) null, (Integer) null, (Integer) null, (Integer) null, (String) null, imageCellDirection2, 2047, (Object) null);
            return this;
        }

        public final Builder actions(List<ActionButton> list) {
            List<ActionButton> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "actions");
            Builder builder = this;
            this.state = ImageCellState.copy$default(this.state, (Uri) null, (Uri) null, (String) null, (String) null, false, false, list2, (Integer) null, (Integer) null, (Integer) null, (String) null, (ImageCellDirection) null, 4031, (Object) null);
            return this;
        }

        public final ImageCellState build() {
            return this.state;
        }
    }
}
