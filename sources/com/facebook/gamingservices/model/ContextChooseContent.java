package com.facebook.gamingservices.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\fH\u0016J\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\fH\u0016R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/facebook/gamingservices/model/ContextChooseContent;", "Lcom/facebook/share/model/ShareModel;", "builder", "Lcom/facebook/gamingservices/model/ContextChooseContent$Builder;", "(Lcom/facebook/gamingservices/model/ContextChooseContent$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "filters", "", "", "maxSize", "", "getMaxSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "minSize", "getMinSize", "describeContents", "getFilters", "writeToParcel", "", "out", "flags", "Builder", "CREATOR", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ContextChooseContent.kt */
public final class ContextChooseContent implements ShareModel {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private final List<String> filters;
    private final Integer maxSize;
    private final Integer minSize;

    public /* synthetic */ ContextChooseContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public int describeContents() {
        return 0;
    }

    public final Integer getMaxSize() {
        return this.maxSize;
    }

    public final Integer getMinSize() {
        return this.minSize;
    }

    private ContextChooseContent(Builder builder) {
        this.filters = builder.getFilters$facebook_gamingservices_release();
        this.maxSize = builder.getMaxSize$facebook_gamingservices_release();
        this.minSize = builder.getMinSize$facebook_gamingservices_release();
    }

    public ContextChooseContent(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.filters = parcel.createStringArrayList();
        this.maxSize = Integer.valueOf(parcel.readInt());
        this.minSize = Integer.valueOf(parcel.readInt());
    }

    public final List<String> getFilters() {
        List<String> list = this.filters;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeStringList(this.filters);
        Integer num = this.maxSize;
        int i2 = 0;
        parcel.writeInt(num == null ? 0 : num.intValue());
        Integer num2 = this.minSize;
        if (num2 != null) {
            i2 = num2.intValue();
        }
        parcel.writeInt(i2);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u0012\u0010\u0016\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\u001a\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u0015\u0010\u001b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u001cR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/facebook/gamingservices/model/ContextChooseContent$Builder;", "Lcom/facebook/share/model/ShareModelBuilder;", "Lcom/facebook/gamingservices/model/ContextChooseContent;", "()V", "filters", "", "", "getFilters$facebook_gamingservices_release", "()Ljava/util/List;", "setFilters$facebook_gamingservices_release", "(Ljava/util/List;)V", "maxSize", "", "getMaxSize$facebook_gamingservices_release", "()Ljava/lang/Integer;", "setMaxSize$facebook_gamingservices_release", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "minSize", "getMinSize$facebook_gamingservices_release", "setMinSize$facebook_gamingservices_release", "build", "readFrom", "parcel", "Landroid/os/Parcel;", "model", "setFilters", "setMaxSize", "(Ljava/lang/Integer;)Lcom/facebook/gamingservices/model/ContextChooseContent$Builder;", "setMinSize", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ContextChooseContent.kt */
    public static final class Builder implements ShareModelBuilder<ContextChooseContent, Builder> {
        private List<String> filters;
        private Integer maxSize;
        private Integer minSize;

        public final List<String> getFilters$facebook_gamingservices_release() {
            return this.filters;
        }

        public final void setFilters$facebook_gamingservices_release(List<String> list) {
            this.filters = list;
        }

        public final Integer getMaxSize$facebook_gamingservices_release() {
            return this.maxSize;
        }

        public final void setMaxSize$facebook_gamingservices_release(Integer num) {
            this.maxSize = num;
        }

        public final Integer getMinSize$facebook_gamingservices_release() {
            return this.minSize;
        }

        public final void setMinSize$facebook_gamingservices_release(Integer num) {
            this.minSize = num;
        }

        public final Builder setFilters(List<String> list) {
            this.filters = list;
            return this;
        }

        public final Builder setMaxSize(Integer num) {
            this.maxSize = num;
            return this;
        }

        public final Builder setMinSize(Integer num) {
            this.minSize = num;
            return this;
        }

        public ContextChooseContent build() {
            return new ContextChooseContent(this, (DefaultConstructorMarker) null);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:1:0x0003, code lost:
            r3 = setFilters(r3.getFilters()).setMaxSize(r3.getMaxSize()).setMinSize(r3.getMinSize());
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.facebook.gamingservices.model.ContextChooseContent.Builder readFrom(com.facebook.gamingservices.model.ContextChooseContent r3) {
            /*
                r2 = this;
                if (r3 != 0) goto L_0x0003
                goto L_0x001d
            L_0x0003:
                java.util.List r0 = r3.getFilters()
                com.facebook.gamingservices.model.ContextChooseContent$Builder r0 = r2.setFilters(r0)
                java.lang.Integer r1 = r3.getMaxSize()
                com.facebook.gamingservices.model.ContextChooseContent$Builder r0 = r0.setMaxSize(r1)
                java.lang.Integer r3 = r3.getMinSize()
                com.facebook.gamingservices.model.ContextChooseContent$Builder r3 = r0.setMinSize(r3)
                if (r3 != 0) goto L_0x001e
            L_0x001d:
                r3 = r2
            L_0x001e:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gamingservices.model.ContextChooseContent.Builder.readFrom(com.facebook.gamingservices.model.ContextChooseContent):com.facebook.gamingservices.model.ContextChooseContent$Builder");
        }

        public final Builder readFrom(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return readFrom((ContextChooseContent) parcel.readParcelable(ContextChooseContent.class.getClassLoader()));
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/model/ContextChooseContent$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/gamingservices/model/ContextChooseContent;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/gamingservices/model/ContextChooseContent;", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ContextChooseContent.kt */
    public static final class CREATOR implements Parcelable.Creator<ContextChooseContent> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public ContextChooseContent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ContextChooseContent(parcel);
        }

        public ContextChooseContent[] newArray(int i) {
            return new ContextChooseContent[i];
        }
    }
}
