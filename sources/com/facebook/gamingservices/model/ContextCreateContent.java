package com.facebook.gamingservices.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/facebook/gamingservices/model/ContextCreateContent;", "Lcom/facebook/share/model/ShareModel;", "builder", "Lcom/facebook/gamingservices/model/ContextCreateContent$Builder;", "(Lcom/facebook/gamingservices/model/ContextCreateContent$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "suggestedPlayerID", "", "getSuggestedPlayerID", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "out", "flags", "Builder", "CREATOR", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ContextCreateContent.kt */
public final class ContextCreateContent implements ShareModel {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private final String suggestedPlayerID;

    public /* synthetic */ ContextCreateContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public int describeContents() {
        return 0;
    }

    public final String getSuggestedPlayerID() {
        return this.suggestedPlayerID;
    }

    private ContextCreateContent(Builder builder) {
        this.suggestedPlayerID = builder.getSuggestedPlayerID$facebook_gamingservices_release();
    }

    public ContextCreateContent(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.suggestedPlayerID = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.suggestedPlayerID);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0002H\u0016J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000b\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/facebook/gamingservices/model/ContextCreateContent$Builder;", "Lcom/facebook/share/model/ShareModelBuilder;", "Lcom/facebook/gamingservices/model/ContextCreateContent;", "()V", "suggestedPlayerID", "", "getSuggestedPlayerID$facebook_gamingservices_release", "()Ljava/lang/String;", "setSuggestedPlayerID$facebook_gamingservices_release", "(Ljava/lang/String;)V", "build", "readFrom", "parcel", "Landroid/os/Parcel;", "model", "setSuggestedPlayerID", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ContextCreateContent.kt */
    public static final class Builder implements ShareModelBuilder<ContextCreateContent, Builder> {
        private String suggestedPlayerID;

        public final String getSuggestedPlayerID$facebook_gamingservices_release() {
            return this.suggestedPlayerID;
        }

        public final void setSuggestedPlayerID$facebook_gamingservices_release(String str) {
            this.suggestedPlayerID = str;
        }

        public final Builder setSuggestedPlayerID(String str) {
            this.suggestedPlayerID = str;
            return this;
        }

        public ContextCreateContent build() {
            return new ContextCreateContent(this, (DefaultConstructorMarker) null);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:1:0x0003, code lost:
            r1 = setSuggestedPlayerID(r1.getSuggestedPlayerID());
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.facebook.gamingservices.model.ContextCreateContent.Builder readFrom(com.facebook.gamingservices.model.ContextCreateContent r1) {
            /*
                r0 = this;
                if (r1 != 0) goto L_0x0003
                goto L_0x000d
            L_0x0003:
                java.lang.String r1 = r1.getSuggestedPlayerID()
                com.facebook.gamingservices.model.ContextCreateContent$Builder r1 = r0.setSuggestedPlayerID(r1)
                if (r1 != 0) goto L_0x000e
            L_0x000d:
                r1 = r0
            L_0x000e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gamingservices.model.ContextCreateContent.Builder.readFrom(com.facebook.gamingservices.model.ContextCreateContent):com.facebook.gamingservices.model.ContextCreateContent$Builder");
        }

        public final Builder readFrom(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return readFrom((ContextCreateContent) parcel.readParcelable(ContextCreateContent.class.getClassLoader()));
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/model/ContextCreateContent$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/gamingservices/model/ContextCreateContent;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/gamingservices/model/ContextCreateContent;", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ContextCreateContent.kt */
    public static final class CREATOR implements Parcelable.Creator<ContextCreateContent> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public ContextCreateContent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ContextCreateContent(parcel);
        }

        public ContextCreateContent[] newArray(int i) {
            return new ContextCreateContent[i];
        }
    }
}
