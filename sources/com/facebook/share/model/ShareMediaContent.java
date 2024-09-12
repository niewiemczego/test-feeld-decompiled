package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u001f\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/facebook/share/model/ShareMediaContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/model/ShareMediaContent$Builder;", "builder", "(Lcom/facebook/share/model/ShareMediaContent$Builder;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "media", "", "Lcom/facebook/share/model/ShareMedia;", "getMedia", "()Ljava/util/List;", "describeContents", "", "writeToParcel", "", "out", "flags", "Builder", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ShareMediaContent.kt */
public final class ShareMediaContent extends ShareContent<ShareMediaContent, Builder> {
    public static final Parcelable.Creator<ShareMediaContent> CREATOR = new ShareMediaContent$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<ShareMedia<?, ?>> media;

    public /* synthetic */ ShareMediaContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public int describeContents() {
        return 0;
    }

    public final List<ShareMedia<?, ?>> getMedia() {
        return this.media;
    }

    private ShareMediaContent(Builder builder) {
        super(builder);
        this.media = CollectionsKt.toList(builder.getMedia$facebook_common_release());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.util.List<com.facebook.share.model.ShareMedia<?, ?>>} */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ShareMediaContent(android.os.Parcel r5) {
        /*
            r4 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r4.<init>((android.os.Parcel) r5)
            java.lang.Class<com.facebook.share.model.ShareMedia> r0 = com.facebook.share.model.ShareMedia.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable[] r5 = r5.readParcelableArray(r0)
            if (r5 != 0) goto L_0x0016
            r5 = 0
            goto L_0x0030
        L_0x0016:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            int r1 = r5.length
            r2 = 0
        L_0x001f:
            if (r2 >= r1) goto L_0x002d
            r3 = r5[r2]
            com.facebook.share.model.ShareMedia r3 = (com.facebook.share.model.ShareMedia) r3
            if (r3 == 0) goto L_0x002a
            r0.add(r3)
        L_0x002a:
            int r2 = r2 + 1
            goto L_0x001f
        L_0x002d:
            r5 = r0
            java.util.List r5 = (java.util.List) r5
        L_0x0030:
            if (r5 != 0) goto L_0x0036
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0036:
            r4.media = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.model.ShareMediaContent.<init>(android.os.Parcel):void");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        super.writeToParcel(parcel, i);
        Object[] array = this.media.toArray(new ShareMedia[0]);
        if (array != null) {
            parcel.writeParcelableArray((Parcelable[]) array, i);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0018\u00010\nJ\u0018\u0010\u000b\u001a\u00020\u00002\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0006J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\u001e\u0010\u0010\u001a\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0018\u00010\nR\"\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/facebook/share/model/ShareMediaContent$Builder;", "Lcom/facebook/share/model/ShareContent$Builder;", "Lcom/facebook/share/model/ShareMediaContent;", "()V", "media", "", "Lcom/facebook/share/model/ShareMedia;", "getMedia$facebook_common_release", "()Ljava/util/List;", "addMedia", "", "addMedium", "medium", "build", "readFrom", "content", "setMedia", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareMediaContent.kt */
    public static final class Builder extends ShareContent.Builder<ShareMediaContent, Builder> {
        private final List<ShareMedia<?, ?>> media = new ArrayList();

        public final List<ShareMedia<?, ?>> getMedia$facebook_common_release() {
            return this.media;
        }

        public final Builder addMedium(ShareMedia<?, ?> shareMedia) {
            ShareMedia shareMedia2;
            if (shareMedia != null) {
                if (shareMedia instanceof SharePhoto) {
                    shareMedia2 = new SharePhoto.Builder().readFrom((SharePhoto) shareMedia).build();
                } else if (shareMedia instanceof ShareVideo) {
                    shareMedia2 = new ShareVideo.Builder().readFrom((ShareVideo) shareMedia).build();
                } else {
                    throw new IllegalArgumentException("medium must be either a SharePhoto or ShareVideo");
                }
                this.media.add(shareMedia2);
            }
            return this;
        }

        public final Builder addMedia(List<? extends ShareMedia<?, ?>> list) {
            if (list != null) {
                for (ShareMedia addMedium : list) {
                    addMedium(addMedium);
                }
            }
            return this;
        }

        public ShareMediaContent build() {
            return new ShareMediaContent(this, (DefaultConstructorMarker) null);
        }

        public Builder readFrom(ShareMediaContent shareMediaContent) {
            return shareMediaContent == null ? this : ((Builder) super.readFrom(shareMediaContent)).addMedia(shareMediaContent.getMedia());
        }

        public final Builder setMedia(List<? extends ShareMedia<?, ?>> list) {
            this.media.clear();
            addMedia(list);
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/ShareMediaContent$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/ShareMediaContent;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareMediaContent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
