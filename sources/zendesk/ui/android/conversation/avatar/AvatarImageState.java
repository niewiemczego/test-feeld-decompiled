package zendesk.ui.android.conversation.avatar;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001%B=\b\u0000\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\nHÆ\u0003JD\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\u0006\u0010!\u001a\u00020\"J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006&"}, d2 = {"Lzendesk/ui/android/conversation/avatar/AvatarImageState;", "", "uri", "Landroid/net/Uri;", "shouldAnimate", "", "avatarSize", "", "backgroundColor", "mask", "Lzendesk/ui/android/conversation/avatar/AvatarMask;", "(Landroid/net/Uri;ZILjava/lang/Integer;Lzendesk/ui/android/conversation/avatar/AvatarMask;)V", "getAvatarSize", "()I", "getBackgroundColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMask", "()Lzendesk/ui/android/conversation/avatar/AvatarMask;", "getShouldAnimate", "()Z", "getUri", "()Landroid/net/Uri;", "component1", "component2", "component3", "component4", "component5", "copy", "(Landroid/net/Uri;ZILjava/lang/Integer;Lzendesk/ui/android/conversation/avatar/AvatarMask;)Lzendesk/ui/android/conversation/avatar/AvatarImageState;", "equals", "other", "hashCode", "toBuilder", "Lzendesk/ui/android/conversation/avatar/AvatarImageState$Builder;", "toString", "", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AvatarImageState.kt */
public final class AvatarImageState {
    private final int avatarSize;
    private final Integer backgroundColor;
    private final AvatarMask mask;
    private final boolean shouldAnimate;
    private final Uri uri;

    public AvatarImageState() {
        this((Uri) null, false, 0, (Integer) null, (AvatarMask) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AvatarImageState copy$default(AvatarImageState avatarImageState, Uri uri2, boolean z, int i, Integer num, AvatarMask avatarMask, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            uri2 = avatarImageState.uri;
        }
        if ((i2 & 2) != 0) {
            z = avatarImageState.shouldAnimate;
        }
        boolean z2 = z;
        if ((i2 & 4) != 0) {
            i = avatarImageState.avatarSize;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            num = avatarImageState.backgroundColor;
        }
        Integer num2 = num;
        if ((i2 & 16) != 0) {
            avatarMask = avatarImageState.mask;
        }
        return avatarImageState.copy(uri2, z2, i3, num2, avatarMask);
    }

    public final Uri component1() {
        return this.uri;
    }

    public final boolean component2() {
        return this.shouldAnimate;
    }

    public final int component3() {
        return this.avatarSize;
    }

    public final Integer component4() {
        return this.backgroundColor;
    }

    public final AvatarMask component5() {
        return this.mask;
    }

    public final AvatarImageState copy(Uri uri2, boolean z, int i, Integer num, AvatarMask avatarMask) {
        Intrinsics.checkNotNullParameter(avatarMask, "mask");
        return new AvatarImageState(uri2, z, i, num, avatarMask);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AvatarImageState)) {
            return false;
        }
        AvatarImageState avatarImageState = (AvatarImageState) obj;
        return Intrinsics.areEqual((Object) this.uri, (Object) avatarImageState.uri) && this.shouldAnimate == avatarImageState.shouldAnimate && this.avatarSize == avatarImageState.avatarSize && Intrinsics.areEqual((Object) this.backgroundColor, (Object) avatarImageState.backgroundColor) && this.mask == avatarImageState.mask;
    }

    public int hashCode() {
        Uri uri2 = this.uri;
        int i = 0;
        int hashCode = (uri2 == null ? 0 : uri2.hashCode()) * 31;
        boolean z = this.shouldAnimate;
        if (z) {
            z = true;
        }
        int hashCode2 = (((hashCode + (z ? 1 : 0)) * 31) + Integer.hashCode(this.avatarSize)) * 31;
        Integer num = this.backgroundColor;
        if (num != null) {
            i = num.hashCode();
        }
        return ((hashCode2 + i) * 31) + this.mask.hashCode();
    }

    public String toString() {
        return "AvatarImageState(uri=" + this.uri + ", shouldAnimate=" + this.shouldAnimate + ", avatarSize=" + this.avatarSize + ", backgroundColor=" + this.backgroundColor + ", mask=" + this.mask + ')';
    }

    public AvatarImageState(Uri uri2, boolean z, int i, Integer num, AvatarMask avatarMask) {
        Intrinsics.checkNotNullParameter(avatarMask, "mask");
        this.uri = uri2;
        this.shouldAnimate = z;
        this.avatarSize = i;
        this.backgroundColor = num;
        this.mask = avatarMask;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final boolean getShouldAnimate() {
        return this.shouldAnimate;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AvatarImageState(android.net.Uri r4, boolean r5, int r6, java.lang.Integer r7, zendesk.ui.android.conversation.avatar.AvatarMask r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            if (r10 == 0) goto L_0x0007
            r10 = r0
            goto L_0x0008
        L_0x0007:
            r10 = r4
        L_0x0008:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000d
            r5 = 1
        L_0x000d:
            r1 = r5
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0014
            int r6 = zendesk.ui.android.R.dimen.zuia_avatar_image_size
        L_0x0014:
            r2 = r6
            r4 = r9 & 8
            if (r4 == 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r0 = r7
        L_0x001b:
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0021
            zendesk.ui.android.conversation.avatar.AvatarMask r8 = zendesk.ui.android.conversation.avatar.AvatarMask.NONE
        L_0x0021:
            r9 = r8
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r2
            r8 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.ui.android.conversation.avatar.AvatarImageState.<init>(android.net.Uri, boolean, int, java.lang.Integer, zendesk.ui.android.conversation.avatar.AvatarMask, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getAvatarSize() {
        return this.avatarSize;
    }

    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    public final AvatarMask getMask() {
        return this.mask;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00002\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0003J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lzendesk/ui/android/conversation/avatar/AvatarImageState$Builder;", "", "state", "Lzendesk/ui/android/conversation/avatar/AvatarImageState;", "(Lzendesk/ui/android/conversation/avatar/AvatarImageState;)V", "()V", "avatarSize", "", "(Ljava/lang/Integer;)Lzendesk/ui/android/conversation/avatar/AvatarImageState$Builder;", "backgroundColor", "color", "build", "mask", "Lzendesk/ui/android/conversation/avatar/AvatarMask;", "shouldAnimate", "", "uri", "Landroid/net/Uri;", "", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AvatarImageState.kt */
    public static final class Builder {
        private AvatarImageState state;

        public Builder() {
            this.state = new AvatarImageState((Uri) null, false, 0, (Integer) null, (AvatarMask) null, 31, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(AvatarImageState avatarImageState) {
            this();
            Intrinsics.checkNotNullParameter(avatarImageState, "state");
            this.state = avatarImageState;
        }

        public final Builder uri(Uri uri) {
            Builder builder = this;
            this.state = AvatarImageState.copy$default(this.state, uri, false, 0, (Integer) null, (AvatarMask) null, 30, (Object) null);
            return this;
        }

        public final Builder uri(String str) {
            Uri uri;
            Builder builder = this;
            AvatarImageState avatarImageState = this.state;
            if (str != null) {
                uri = Uri.parse(str);
            } else {
                uri = null;
                Uri uri2 = null;
            }
            this.state = AvatarImageState.copy$default(avatarImageState, uri, false, 0, (Integer) null, (AvatarMask) null, 30, (Object) null);
            return this;
        }

        public final Builder shouldAnimate(boolean z) {
            Builder builder = this;
            this.state = AvatarImageState.copy$default(this.state, (Uri) null, z, 0, (Integer) null, (AvatarMask) null, 29, (Object) null);
            return this;
        }

        public final Builder avatarSize(Integer num) {
            Builder builder = this;
            this.state = AvatarImageState.copy$default(this.state, (Uri) null, false, num != null ? num.intValue() : R.dimen.zuia_avatar_image_size, (Integer) null, (AvatarMask) null, 27, (Object) null);
            return this;
        }

        public final Builder backgroundColor(int i) {
            Builder builder = this;
            this.state = AvatarImageState.copy$default(this.state, (Uri) null, false, 0, Integer.valueOf(i), (AvatarMask) null, 23, (Object) null);
            return this;
        }

        public final Builder mask(AvatarMask avatarMask) {
            Intrinsics.checkNotNullParameter(avatarMask, "mask");
            Builder builder = this;
            this.state = AvatarImageState.copy$default(this.state, (Uri) null, false, 0, (Integer) null, avatarMask, 15, (Object) null);
            return this;
        }

        public final AvatarImageState build() {
            return this.state;
        }
    }
}
