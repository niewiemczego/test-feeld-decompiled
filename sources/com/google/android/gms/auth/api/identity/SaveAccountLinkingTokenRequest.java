package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public class SaveAccountLinkingTokenRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SaveAccountLinkingTokenRequest> CREATOR = new zbp();
    public static final String EXTRA_TOKEN = "extra_token";
    public static final String TOKEN_TYPE_AUTH_CODE = "auth_code";
    private final PendingIntent zba;
    private final String zbb;
    private final String zbc;
    private final List zbd;
    private final String zbe;
    private final int zbf;

    /* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
    public static final class Builder {
        private PendingIntent zba;
        private String zbb;
        private String zbc;
        private List zbd = new ArrayList();
        private String zbe;
        private int zbf;

        public SaveAccountLinkingTokenRequest build() {
            boolean z = false;
            Preconditions.checkArgument(this.zba != null, "Consent PendingIntent cannot be null");
            Preconditions.checkArgument(SaveAccountLinkingTokenRequest.TOKEN_TYPE_AUTH_CODE.equals(this.zbb), "Invalid tokenType");
            Preconditions.checkArgument(!TextUtils.isEmpty(this.zbc), "serviceId cannot be null or empty");
            if (this.zbd != null) {
                z = true;
            }
            Preconditions.checkArgument(z, "scopes cannot be null");
            return new SaveAccountLinkingTokenRequest(this.zba, this.zbb, this.zbc, this.zbd, this.zbe, this.zbf);
        }

        public Builder setConsentPendingIntent(PendingIntent pendingIntent) {
            this.zba = pendingIntent;
            return this;
        }

        public Builder setScopes(List<String> list) {
            this.zbd = list;
            return this;
        }

        public Builder setServiceId(String str) {
            this.zbc = str;
            return this;
        }

        public Builder setTokenType(String str) {
            this.zbb = str;
            return this;
        }

        public final Builder zba(String str) {
            this.zbe = str;
            return this;
        }

        public final Builder zbb(int i) {
            this.zbf = i;
            return this;
        }
    }

    SaveAccountLinkingTokenRequest(PendingIntent pendingIntent, String str, String str2, List list, String str3, int i) {
        this.zba = pendingIntent;
        this.zbb = str;
        this.zbc = str2;
        this.zbd = list;
        this.zbe = str3;
        this.zbf = i;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder zba(SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        Preconditions.checkNotNull(saveAccountLinkingTokenRequest);
        Builder builder = builder();
        builder.setScopes(saveAccountLinkingTokenRequest.getScopes());
        builder.setServiceId(saveAccountLinkingTokenRequest.getServiceId());
        builder.setConsentPendingIntent(saveAccountLinkingTokenRequest.getConsentPendingIntent());
        builder.setTokenType(saveAccountLinkingTokenRequest.getTokenType());
        builder.zbb(saveAccountLinkingTokenRequest.zbf);
        String str = saveAccountLinkingTokenRequest.zbe;
        if (!TextUtils.isEmpty(str)) {
            builder.zba(str);
        }
        return builder;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SaveAccountLinkingTokenRequest)) {
            return false;
        }
        SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest = (SaveAccountLinkingTokenRequest) obj;
        if (this.zbd.size() != saveAccountLinkingTokenRequest.zbd.size() || !this.zbd.containsAll(saveAccountLinkingTokenRequest.zbd) || !Objects.equal(this.zba, saveAccountLinkingTokenRequest.zba) || !Objects.equal(this.zbb, saveAccountLinkingTokenRequest.zbb) || !Objects.equal(this.zbc, saveAccountLinkingTokenRequest.zbc) || !Objects.equal(this.zbe, saveAccountLinkingTokenRequest.zbe) || this.zbf != saveAccountLinkingTokenRequest.zbf) {
            return false;
        }
        return true;
    }

    public PendingIntent getConsentPendingIntent() {
        return this.zba;
    }

    public List<String> getScopes() {
        return this.zbd;
    }

    public String getServiceId() {
        return this.zbc;
    }

    public String getTokenType() {
        return this.zbb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zba, this.zbb, this.zbc, this.zbd, this.zbe);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getConsentPendingIntent(), i, false);
        SafeParcelWriter.writeString(parcel, 2, getTokenType(), false);
        SafeParcelWriter.writeString(parcel, 3, getServiceId(), false);
        SafeParcelWriter.writeStringList(parcel, 4, getScopes(), false);
        SafeParcelWriter.writeString(parcel, 5, this.zbe, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zbf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
