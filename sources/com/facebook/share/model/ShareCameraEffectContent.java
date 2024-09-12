package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.CameraEffectArguments;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareContent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/facebook/share/model/ShareCameraEffectContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/model/ShareCameraEffectContent$Builder;", "builder", "(Lcom/facebook/share/model/ShareCameraEffectContent$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "<set-?>", "Lcom/facebook/share/model/CameraEffectArguments;", "arguments", "getArguments", "()Lcom/facebook/share/model/CameraEffectArguments;", "", "effectId", "getEffectId", "()Ljava/lang/String;", "Lcom/facebook/share/model/CameraEffectTextures;", "textures", "getTextures", "()Lcom/facebook/share/model/CameraEffectTextures;", "writeToParcel", "", "out", "flags", "", "Builder", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ShareCameraEffectContent.kt */
public final class ShareCameraEffectContent extends ShareContent<ShareCameraEffectContent, Builder> {
    public static final Parcelable.Creator<ShareCameraEffectContent> CREATOR = new ShareCameraEffectContent$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private CameraEffectArguments arguments;
    private String effectId;
    private CameraEffectTextures textures;

    public /* synthetic */ ShareCameraEffectContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public final String getEffectId() {
        return this.effectId;
    }

    public final CameraEffectArguments getArguments() {
        return this.arguments;
    }

    public final CameraEffectTextures getTextures() {
        return this.textures;
    }

    private ShareCameraEffectContent(Builder builder) {
        super(builder);
        this.effectId = builder.getEffectId$facebook_common_release();
        this.arguments = builder.getArguments$facebook_common_release();
        this.textures = builder.getTextures$facebook_common_release();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShareCameraEffectContent(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.effectId = parcel.readString();
        this.arguments = new CameraEffectArguments.Builder().readFrom(parcel).build();
        this.textures = new CameraEffectTextures.Builder().readFrom(parcel).build();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        super.writeToParcel(parcel, i);
        parcel.writeString(this.effectId);
        parcel.writeParcelable(this.arguments, 0);
        parcel.writeParcelable(this.textures, 0);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0012\u0010\u0017\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/facebook/share/model/ShareCameraEffectContent$Builder;", "Lcom/facebook/share/model/ShareContent$Builder;", "Lcom/facebook/share/model/ShareCameraEffectContent;", "()V", "arguments", "Lcom/facebook/share/model/CameraEffectArguments;", "getArguments$facebook_common_release", "()Lcom/facebook/share/model/CameraEffectArguments;", "setArguments$facebook_common_release", "(Lcom/facebook/share/model/CameraEffectArguments;)V", "effectId", "", "getEffectId$facebook_common_release", "()Ljava/lang/String;", "setEffectId$facebook_common_release", "(Ljava/lang/String;)V", "textures", "Lcom/facebook/share/model/CameraEffectTextures;", "getTextures$facebook_common_release", "()Lcom/facebook/share/model/CameraEffectTextures;", "setTextures$facebook_common_release", "(Lcom/facebook/share/model/CameraEffectTextures;)V", "build", "readFrom", "model", "setArguments", "setEffectId", "setTextures", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareCameraEffectContent.kt */
    public static final class Builder extends ShareContent.Builder<ShareCameraEffectContent, Builder> {
        private CameraEffectArguments arguments;
        private String effectId;
        private CameraEffectTextures textures;

        public final String getEffectId$facebook_common_release() {
            return this.effectId;
        }

        public final void setEffectId$facebook_common_release(String str) {
            this.effectId = str;
        }

        public final CameraEffectArguments getArguments$facebook_common_release() {
            return this.arguments;
        }

        public final void setArguments$facebook_common_release(CameraEffectArguments cameraEffectArguments) {
            this.arguments = cameraEffectArguments;
        }

        public final CameraEffectTextures getTextures$facebook_common_release() {
            return this.textures;
        }

        public final void setTextures$facebook_common_release(CameraEffectTextures cameraEffectTextures) {
            this.textures = cameraEffectTextures;
        }

        public final Builder setEffectId(String str) {
            this.effectId = str;
            return this;
        }

        public final Builder setArguments(CameraEffectArguments cameraEffectArguments) {
            this.arguments = cameraEffectArguments;
            return this;
        }

        public final Builder setTextures(CameraEffectTextures cameraEffectTextures) {
            this.textures = cameraEffectTextures;
            return this;
        }

        public ShareCameraEffectContent build() {
            return new ShareCameraEffectContent(this, (DefaultConstructorMarker) null);
        }

        public Builder readFrom(ShareCameraEffectContent shareCameraEffectContent) {
            if (shareCameraEffectContent == null) {
                return this;
            }
            return ((Builder) super.readFrom(shareCameraEffectContent)).setEffectId(shareCameraEffectContent.getEffectId()).setArguments(shareCameraEffectContent.getArguments()).setTextures(shareCameraEffectContent.getTextures());
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/ShareCameraEffectContent$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/ShareCameraEffectContent;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareCameraEffectContent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
