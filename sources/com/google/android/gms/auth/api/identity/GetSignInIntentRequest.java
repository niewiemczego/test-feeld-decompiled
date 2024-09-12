package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public class GetSignInIntentRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetSignInIntentRequest> CREATOR = new zbk();
    private final String zba;
    private final String zbb;
    private final String zbc;
    private final String zbd;
    private final boolean zbe;
    private final int zbf;

    /* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
    public static final class Builder {
        private String zba;
        private String zbb;
        private String zbc;
        private String zbd;
        private boolean zbe;
        private int zbf;

        public GetSignInIntentRequest build() {
            return new GetSignInIntentRequest(this.zba, this.zbb, this.zbc, this.zbd, this.zbe, this.zbf);
        }

        public Builder filterByHostedDomain(String str) {
            this.zbb = str;
            return this;
        }

        public Builder setNonce(String str) {
            this.zbd = str;
            return this;
        }

        @Deprecated
        public Builder setRequestVerifiedPhoneNumber(boolean z) {
            this.zbe = z;
            return this;
        }

        public Builder setServerClientId(String str) {
            Preconditions.checkNotNull(str);
            this.zba = str;
            return this;
        }

        public final Builder zba(String str) {
            this.zbc = str;
            return this;
        }

        public final Builder zbb(int i) {
            this.zbf = i;
            return this;
        }
    }

    GetSignInIntentRequest(String str, String str2, String str3, String str4, boolean z, int i) {
        Preconditions.checkNotNull(str);
        this.zba = str;
        this.zbb = str2;
        this.zbc = str3;
        this.zbd = str4;
        this.zbe = z;
        this.zbf = i;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder zba(GetSignInIntentRequest getSignInIntentRequest) {
        Preconditions.checkNotNull(getSignInIntentRequest);
        Builder builder = builder();
        builder.setServerClientId(getSignInIntentRequest.getServerClientId());
        builder.setNonce(getSignInIntentRequest.getNonce());
        builder.filterByHostedDomain(getSignInIntentRequest.getHostedDomainFilter());
        builder.setRequestVerifiedPhoneNumber(getSignInIntentRequest.zbe);
        builder.zbb(getSignInIntentRequest.zbf);
        String str = getSignInIntentRequest.zbc;
        if (str != null) {
            builder.zba(str);
        }
        return builder;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GetSignInIntentRequest)) {
            return false;
        }
        GetSignInIntentRequest getSignInIntentRequest = (GetSignInIntentRequest) obj;
        if (!Objects.equal(this.zba, getSignInIntentRequest.zba) || !Objects.equal(this.zbd, getSignInIntentRequest.zbd) || !Objects.equal(this.zbb, getSignInIntentRequest.zbb) || !Objects.equal(Boolean.valueOf(this.zbe), Boolean.valueOf(getSignInIntentRequest.zbe)) || this.zbf != getSignInIntentRequest.zbf) {
            return false;
        }
        return true;
    }

    public String getHostedDomainFilter() {
        return this.zbb;
    }

    public String getNonce() {
        return this.zbd;
    }

    public String getServerClientId() {
        return this.zba;
    }

    public int hashCode() {
        return Objects.hashCode(this.zba, this.zbb, this.zbd, Boolean.valueOf(this.zbe), Integer.valueOf(this.zbf));
    }

    @Deprecated
    public boolean requestVerifiedPhoneNumber() {
        return this.zbe;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 2, getHostedDomainFilter(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zbc, false);
        SafeParcelWriter.writeString(parcel, 4, getNonce(), false);
        SafeParcelWriter.writeBoolean(parcel, 5, requestVerifiedPhoneNumber());
        SafeParcelWriter.writeInt(parcel, 6, this.zbf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
