package com.facebook.gamingservices;

import android.media.Image;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.internal.DateFormatter;
import com.facebook.gamingservices.internal.TournamentScoreType;
import com.facebook.gamingservices.internal.TournamentSortOrder;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0002$%B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u001fH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013¨\u0006&"}, d2 = {"Lcom/facebook/gamingservices/TournamentConfig;", "Lcom/facebook/share/model/ShareModel;", "builder", "Lcom/facebook/gamingservices/TournamentConfig$Builder;", "(Lcom/facebook/gamingservices/TournamentConfig$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "endTime", "Ljava/time/Instant;", "getEndTime", "()Ljava/time/Instant;", "image", "Landroid/media/Image;", "getImage", "()Landroid/media/Image;", "payload", "", "getPayload", "()Ljava/lang/String;", "scoreType", "Lcom/facebook/gamingservices/internal/TournamentScoreType;", "getScoreType", "()Lcom/facebook/gamingservices/internal/TournamentScoreType;", "sortOrder", "Lcom/facebook/gamingservices/internal/TournamentSortOrder;", "getSortOrder", "()Lcom/facebook/gamingservices/internal/TournamentSortOrder;", "title", "getTitle", "describeContents", "", "writeToParcel", "", "out", "flags", "Builder", "CREATOR", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: TournamentConfig.kt */
public final class TournamentConfig implements ShareModel {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private final Instant endTime;
    private final Image image;
    private final String payload;
    private final TournamentScoreType scoreType;
    private final TournamentSortOrder sortOrder;
    private final String title;

    public /* synthetic */ TournamentConfig(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public int describeContents() {
        return 0;
    }

    public final String getTitle() {
        return this.title;
    }

    public final TournamentSortOrder getSortOrder() {
        return this.sortOrder;
    }

    public final TournamentScoreType getScoreType() {
        return this.scoreType;
    }

    public final Instant getEndTime() {
        return this.endTime;
    }

    public final Image getImage() {
        return this.image;
    }

    public final String getPayload() {
        return this.payload;
    }

    private TournamentConfig(Builder builder) {
        this.title = builder.getTitle();
        this.sortOrder = builder.getSortOrder();
        this.scoreType = builder.getScoreType();
        this.endTime = builder.getEndTime();
        this.image = builder.getImage();
        this.payload = builder.getPayload();
    }

    public TournamentConfig(Parcel parcel) {
        TournamentSortOrder tournamentSortOrder;
        TournamentScoreType tournamentScoreType;
        Instant instant;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.title = parcel.readString();
        TournamentSortOrder[] values = TournamentSortOrder.values();
        int length = values.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                tournamentSortOrder = null;
                break;
            }
            tournamentSortOrder = values[i2];
            if (Intrinsics.areEqual((Object) tournamentSortOrder.name(), (Object) parcel.readString())) {
                break;
            }
            i2++;
        }
        this.sortOrder = tournamentSortOrder;
        TournamentScoreType[] values2 = TournamentScoreType.values();
        int length2 = values2.length;
        while (true) {
            if (i >= length2) {
                tournamentScoreType = null;
                break;
            }
            tournamentScoreType = values2[i];
            if (Intrinsics.areEqual((Object) tournamentScoreType.name(), (Object) parcel.readString())) {
                break;
            }
            i++;
        }
        this.scoreType = tournamentScoreType;
        if (Build.VERSION.SDK_INT >= 26) {
            String readString = parcel.readString();
            if (readString != null) {
                instant = Instant.from(DateFormatter.INSTANCE.format$facebook_gamingservices_release(readString));
                this.endTime = instant;
                this.payload = parcel.readString();
                this.image = null;
            }
        } else {
            Instant instant2 = null;
        }
        instant = null;
        this.endTime = instant;
        this.payload = parcel.readString();
        this.image = null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(String.valueOf(this.sortOrder));
        parcel.writeString(String.valueOf(this.scoreType));
        parcel.writeString(String.valueOf(this.endTime));
        parcel.writeString(this.title);
        parcel.writeString(this.payload);
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010%\u001a\u00020\u0002H\u0016J\u0015\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\b)J\u0012\u0010&\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010,\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010-\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u00100\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015¨\u00061"}, d2 = {"Lcom/facebook/gamingservices/TournamentConfig$Builder;", "Lcom/facebook/share/model/ShareModelBuilder;", "Lcom/facebook/gamingservices/TournamentConfig;", "()V", "endTime", "Ljava/time/Instant;", "getEndTime", "()Ljava/time/Instant;", "setEndTime", "(Ljava/time/Instant;)V", "image", "Landroid/media/Image;", "getImage", "()Landroid/media/Image;", "setImage", "(Landroid/media/Image;)V", "payload", "", "getPayload", "()Ljava/lang/String;", "setPayload", "(Ljava/lang/String;)V", "scoreType", "Lcom/facebook/gamingservices/internal/TournamentScoreType;", "getScoreType", "()Lcom/facebook/gamingservices/internal/TournamentScoreType;", "setScoreType", "(Lcom/facebook/gamingservices/internal/TournamentScoreType;)V", "sortOrder", "Lcom/facebook/gamingservices/internal/TournamentSortOrder;", "getSortOrder", "()Lcom/facebook/gamingservices/internal/TournamentSortOrder;", "setSortOrder", "(Lcom/facebook/gamingservices/internal/TournamentSortOrder;)V", "title", "getTitle", "setTitle", "build", "readFrom", "parcel", "Landroid/os/Parcel;", "readFrom$facebook_gamingservices_release", "model", "setTournamentEndTime", "setTournamentImage", "setTournamentPayload", "setTournamentScoreType", "setTournamentSortOrder", "setTournamentTitle", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: TournamentConfig.kt */
    public static final class Builder implements ShareModelBuilder<TournamentConfig, Builder> {
        private Instant endTime;
        private Image image;
        private String payload;
        private TournamentScoreType scoreType;
        private TournamentSortOrder sortOrder;
        private String title;

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final TournamentSortOrder getSortOrder() {
            return this.sortOrder;
        }

        public final void setSortOrder(TournamentSortOrder tournamentSortOrder) {
            this.sortOrder = tournamentSortOrder;
        }

        public final TournamentScoreType getScoreType() {
            return this.scoreType;
        }

        public final void setScoreType(TournamentScoreType tournamentScoreType) {
            this.scoreType = tournamentScoreType;
        }

        public final Instant getEndTime() {
            return this.endTime;
        }

        public final void setEndTime(Instant instant) {
            this.endTime = instant;
        }

        public final Image getImage() {
            return this.image;
        }

        public final void setImage(Image image2) {
            this.image = image2;
        }

        public final String getPayload() {
            return this.payload;
        }

        public final void setPayload(String str) {
            this.payload = str;
        }

        public final Builder setTournamentTitle(String str) {
            this.title = str;
            return this;
        }

        public final Builder setTournamentSortOrder(TournamentSortOrder tournamentSortOrder) {
            Intrinsics.checkNotNullParameter(tournamentSortOrder, SDKConstants.PARAM_SORT_ORDER);
            this.sortOrder = tournamentSortOrder;
            return this;
        }

        public final Builder setTournamentScoreType(TournamentScoreType tournamentScoreType) {
            Intrinsics.checkNotNullParameter(tournamentScoreType, "scoreType");
            this.scoreType = tournamentScoreType;
            return this;
        }

        public final Builder setTournamentEndTime(Instant instant) {
            Intrinsics.checkNotNullParameter(instant, SDKConstants.PARAM_END_TIME);
            this.endTime = instant;
            return this;
        }

        public final Builder setTournamentImage(Image image2) {
            this.image = image2;
            return this;
        }

        public final Builder setTournamentPayload(String str) {
            this.payload = str;
            return this;
        }

        public TournamentConfig build() {
            return new TournamentConfig(this, (DefaultConstructorMarker) null);
        }

        public final Builder readFrom$facebook_gamingservices_release(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return readFrom((TournamentConfig) parcel.readParcelable(TournamentConfig.class.getClassLoader()));
        }

        public Builder readFrom(TournamentConfig tournamentConfig) {
            if (tournamentConfig == null) {
                return this;
            }
            TournamentSortOrder sortOrder2 = tournamentConfig.getSortOrder();
            if (sortOrder2 != null) {
                setTournamentSortOrder(sortOrder2);
            }
            TournamentScoreType scoreType2 = tournamentConfig.getScoreType();
            if (scoreType2 != null) {
                setTournamentScoreType(scoreType2);
            }
            Instant endTime2 = tournamentConfig.getEndTime();
            if (endTime2 != null) {
                setTournamentEndTime(endTime2);
            }
            String title2 = tournamentConfig.getTitle();
            if (title2 != null) {
                setTournamentTitle(title2);
            }
            setTournamentPayload(tournamentConfig.getPayload());
            return this;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/TournamentConfig$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/gamingservices/TournamentConfig;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/gamingservices/TournamentConfig;", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: TournamentConfig.kt */
    public static final class CREATOR implements Parcelable.Creator<TournamentConfig> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public TournamentConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TournamentConfig(parcel);
        }

        public TournamentConfig[] newArray(int i) {
            return new TournamentConfig[i];
        }
    }
}
