package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0019H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000b¨\u0006 "}, d2 = {"Lcom/facebook/share/internal/ShareFeedContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/internal/ShareFeedContent$Builder;", "builder", "(Lcom/facebook/share/internal/ShareFeedContent$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "link", "", "getLink", "()Ljava/lang/String;", "linkCaption", "getLinkCaption", "linkDescription", "getLinkDescription", "linkName", "getLinkName", "mediaSource", "getMediaSource", "picture", "getPicture", "toId", "getToId", "describeContents", "", "writeToParcel", "", "out", "flags", "Builder", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ShareFeedContent.kt */
public final class ShareFeedContent extends ShareContent<ShareFeedContent, Builder> {
    public static final Parcelable.Creator<ShareFeedContent> CREATOR = new ShareFeedContent$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String link;
    private final String linkCaption;
    private final String linkDescription;
    private final String linkName;
    private final String mediaSource;
    private final String picture;
    private final String toId;

    public /* synthetic */ ShareFeedContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public int describeContents() {
        return 0;
    }

    public final String getToId() {
        return this.toId;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getLinkName() {
        return this.linkName;
    }

    public final String getLinkCaption() {
        return this.linkCaption;
    }

    public final String getLinkDescription() {
        return this.linkDescription;
    }

    public final String getPicture() {
        return this.picture;
    }

    public final String getMediaSource() {
        return this.mediaSource;
    }

    private ShareFeedContent(Builder builder) {
        super(builder);
        this.toId = builder.getToId$facebook_common_release();
        this.link = builder.getLink$facebook_common_release();
        this.linkName = builder.getLinkName$facebook_common_release();
        this.linkCaption = builder.getLinkCaption$facebook_common_release();
        this.linkDescription = builder.getLinkDescription$facebook_common_release();
        this.picture = builder.getPicture$facebook_common_release();
        this.mediaSource = builder.getMediaSource$facebook_common_release();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShareFeedContent(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.toId = parcel.readString();
        this.link = parcel.readString();
        this.linkName = parcel.readString();
        this.linkCaption = parcel.readString();
        this.linkDescription = parcel.readString();
        this.picture = parcel.readString();
        this.mediaSource = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        super.writeToParcel(parcel, i);
        parcel.writeString(this.toId);
        parcel.writeString(this.link);
        parcel.writeString(this.linkName);
        parcel.writeString(this.linkCaption);
        parcel.writeString(this.linkDescription);
        parcel.writeString(this.picture);
        parcel.writeString(this.mediaSource);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b!\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0012\u0010\u001d\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010 \u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0010\u0010!\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\"\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0010\u0010#\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005J\u0010\u0010$\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005J\u0010\u0010%\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006&"}, d2 = {"Lcom/facebook/share/internal/ShareFeedContent$Builder;", "Lcom/facebook/share/model/ShareContent$Builder;", "Lcom/facebook/share/internal/ShareFeedContent;", "()V", "link", "", "getLink$facebook_common_release", "()Ljava/lang/String;", "setLink$facebook_common_release", "(Ljava/lang/String;)V", "linkCaption", "getLinkCaption$facebook_common_release", "setLinkCaption$facebook_common_release", "linkDescription", "getLinkDescription$facebook_common_release", "setLinkDescription$facebook_common_release", "linkName", "getLinkName$facebook_common_release", "setLinkName$facebook_common_release", "mediaSource", "getMediaSource$facebook_common_release", "setMediaSource$facebook_common_release", "picture", "getPicture$facebook_common_release", "setPicture$facebook_common_release", "toId", "getToId$facebook_common_release", "setToId$facebook_common_release", "build", "readFrom", "content", "setLink", "setLinkCaption", "setLinkDescription", "setLinkName", "setMediaSource", "setPicture", "setToId", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareFeedContent.kt */
    public static final class Builder extends ShareContent.Builder<ShareFeedContent, Builder> {
        private String link;
        private String linkCaption;
        private String linkDescription;
        private String linkName;
        private String mediaSource;
        private String picture;
        private String toId;

        public final String getToId$facebook_common_release() {
            return this.toId;
        }

        public final void setToId$facebook_common_release(String str) {
            this.toId = str;
        }

        public final String getLink$facebook_common_release() {
            return this.link;
        }

        public final void setLink$facebook_common_release(String str) {
            this.link = str;
        }

        public final String getLinkName$facebook_common_release() {
            return this.linkName;
        }

        public final void setLinkName$facebook_common_release(String str) {
            this.linkName = str;
        }

        public final String getLinkCaption$facebook_common_release() {
            return this.linkCaption;
        }

        public final void setLinkCaption$facebook_common_release(String str) {
            this.linkCaption = str;
        }

        public final String getLinkDescription$facebook_common_release() {
            return this.linkDescription;
        }

        public final void setLinkDescription$facebook_common_release(String str) {
            this.linkDescription = str;
        }

        public final String getPicture$facebook_common_release() {
            return this.picture;
        }

        public final void setPicture$facebook_common_release(String str) {
            this.picture = str;
        }

        public final String getMediaSource$facebook_common_release() {
            return this.mediaSource;
        }

        public final void setMediaSource$facebook_common_release(String str) {
            this.mediaSource = str;
        }

        public final Builder setToId(String str) {
            this.toId = str;
            return this;
        }

        public final Builder setLink(String str) {
            this.link = str;
            return this;
        }

        public final Builder setLinkName(String str) {
            this.linkName = str;
            return this;
        }

        public final Builder setLinkCaption(String str) {
            this.linkCaption = str;
            return this;
        }

        public final Builder setLinkDescription(String str) {
            this.linkDescription = str;
            return this;
        }

        public final Builder setPicture(String str) {
            this.picture = str;
            return this;
        }

        public final Builder setMediaSource(String str) {
            this.mediaSource = str;
            return this;
        }

        public ShareFeedContent build() {
            return new ShareFeedContent(this, (DefaultConstructorMarker) null);
        }

        public Builder readFrom(ShareFeedContent shareFeedContent) {
            if (shareFeedContent == null) {
                return this;
            }
            return ((Builder) super.readFrom(shareFeedContent)).setToId(shareFeedContent.getToId()).setLink(shareFeedContent.getLink()).setLinkName(shareFeedContent.getLinkName()).setLinkCaption(shareFeedContent.getLinkCaption()).setLinkDescription(shareFeedContent.getLinkDescription()).setPicture(shareFeedContent.getPicture()).setMediaSource(shareFeedContent.getMediaSource());
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/internal/ShareFeedContent$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/internal/ShareFeedContent;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareFeedContent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
