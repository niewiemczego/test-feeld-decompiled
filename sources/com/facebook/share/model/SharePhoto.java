package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareMedia;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\"#B\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u001dH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Lcom/facebook/share/model/SharePhoto;", "Lcom/facebook/share/model/ShareMedia;", "Lcom/facebook/share/model/SharePhoto$Builder;", "builder", "(Lcom/facebook/share/model/SharePhoto$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "caption", "", "getCaption", "()Ljava/lang/String;", "imageUrl", "Landroid/net/Uri;", "getImageUrl", "()Landroid/net/Uri;", "mediaType", "Lcom/facebook/share/model/ShareMedia$Type;", "getMediaType", "()Lcom/facebook/share/model/ShareMedia$Type;", "userGenerated", "", "getUserGenerated", "()Z", "describeContents", "", "writeToParcel", "", "out", "flags", "Builder", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SharePhoto.kt */
public final class SharePhoto extends ShareMedia<SharePhoto, Builder> {
    public static final Parcelable.Creator<SharePhoto> CREATOR = new SharePhoto$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Bitmap bitmap;
    private final String caption;
    private final Uri imageUrl;
    private final ShareMedia.Type mediaType;
    private final boolean userGenerated;

    public /* synthetic */ SharePhoto(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public int describeContents() {
        return 0;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final Uri getImageUrl() {
        return this.imageUrl;
    }

    public final boolean getUserGenerated() {
        return this.userGenerated;
    }

    public final String getCaption() {
        return this.caption;
    }

    private SharePhoto(Builder builder) {
        super(builder);
        this.mediaType = ShareMedia.Type.PHOTO;
        this.bitmap = builder.getBitmap$facebook_common_release();
        this.imageUrl = builder.getImageUrl$facebook_common_release();
        this.userGenerated = builder.getUserGenerated$facebook_common_release();
        this.caption = builder.getCaption$facebook_common_release();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharePhoto(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.mediaType = ShareMedia.Type.PHOTO;
        this.bitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.userGenerated = parcel.readByte() != 0;
        this.caption = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.bitmap, 0);
        parcel.writeParcelable(this.imageUrl, 0);
        parcel.writeByte(this.userGenerated ? (byte) 1 : 0);
        parcel.writeString(this.caption);
    }

    public ShareMedia.Type getMediaType() {
        return this.mediaType;
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\u0012\u0010\u0016\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/facebook/share/model/SharePhoto$Builder;", "Lcom/facebook/share/model/ShareMedia$Builder;", "Lcom/facebook/share/model/SharePhoto;", "()V", "<set-?>", "Landroid/graphics/Bitmap;", "bitmap", "getBitmap$facebook_common_release", "()Landroid/graphics/Bitmap;", "", "caption", "getCaption$facebook_common_release", "()Ljava/lang/String;", "Landroid/net/Uri;", "imageUrl", "getImageUrl$facebook_common_release", "()Landroid/net/Uri;", "", "userGenerated", "getUserGenerated$facebook_common_release", "()Z", "build", "readFrom", "parcel", "Landroid/os/Parcel;", "readFrom$facebook_common_release", "model", "setBitmap", "setCaption", "setImageUrl", "setUserGenerated", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: SharePhoto.kt */
    public static final class Builder extends ShareMedia.Builder<SharePhoto, Builder> {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private Bitmap bitmap;
        private String caption;
        private Uri imageUrl;
        private boolean userGenerated;

        public final Bitmap getBitmap$facebook_common_release() {
            return this.bitmap;
        }

        public final Uri getImageUrl$facebook_common_release() {
            return this.imageUrl;
        }

        public final boolean getUserGenerated$facebook_common_release() {
            return this.userGenerated;
        }

        public final String getCaption$facebook_common_release() {
            return this.caption;
        }

        public final Builder setBitmap(Bitmap bitmap2) {
            this.bitmap = bitmap2;
            return this;
        }

        public final Builder setImageUrl(Uri uri) {
            this.imageUrl = uri;
            return this;
        }

        public final Builder setUserGenerated(boolean z) {
            this.userGenerated = z;
            return this;
        }

        public final Builder setCaption(String str) {
            this.caption = str;
            return this;
        }

        public SharePhoto build() {
            return new SharePhoto(this, (DefaultConstructorMarker) null);
        }

        public Builder readFrom(SharePhoto sharePhoto) {
            if (sharePhoto == null) {
                return this;
            }
            return ((Builder) super.readFrom(sharePhoto)).setBitmap(sharePhoto.getBitmap()).setImageUrl(sharePhoto.getImageUrl()).setUserGenerated(sharePhoto.getUserGenerated()).setCaption(sharePhoto.getCaption());
        }

        public final Builder readFrom$facebook_common_release(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return readFrom((SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader()));
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\bJ+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/facebook/share/model/SharePhoto$Builder$Companion;", "", "()V", "readPhotoListFrom", "", "Lcom/facebook/share/model/SharePhoto;", "parcel", "Landroid/os/Parcel;", "readPhotoListFrom$facebook_common_release", "writePhotoListTo", "", "out", "parcelFlags", "", "photos", "writePhotoListTo$facebook_common_release", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: SharePhoto.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final void writePhotoListTo$facebook_common_release(Parcel parcel, int i, List<SharePhoto> list) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                Intrinsics.checkNotNullParameter(list, "photos");
                Object[] array = list.toArray(new SharePhoto[0]);
                if (array != null) {
                    parcel.writeParcelableArray((Parcelable[]) ((SharePhoto[]) array), i);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }

            public final List<SharePhoto> readPhotoListFrom$facebook_common_release(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Collection arrayList = new ArrayList();
                for (Object next : ShareMedia.Builder.Companion.readListFrom$facebook_common_release(parcel)) {
                    if (next instanceof SharePhoto) {
                        arrayList.add(next);
                    }
                }
                return (List) arrayList;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/SharePhoto$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/SharePhoto;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: SharePhoto.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
