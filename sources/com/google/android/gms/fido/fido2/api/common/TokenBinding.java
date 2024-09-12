package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fido.zzal;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
public class TokenBinding extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TokenBinding> CREATOR = new zzau();
    public static final TokenBinding NOT_SUPPORTED = new TokenBinding(TokenBindingStatus.NOT_SUPPORTED.toString(), (String) null);
    public static final TokenBinding SUPPORTED = new TokenBinding(TokenBindingStatus.SUPPORTED.toString(), (String) null);
    private final TokenBindingStatus zza;
    private final String zzb;

    /* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
    public enum TokenBindingStatus implements Parcelable {
        PRESENT("present"),
        SUPPORTED("supported"),
        NOT_SUPPORTED("not-supported");
        
        public static final Parcelable.Creator<TokenBindingStatus> CREATOR = null;
        private final String zzb;

        static {
            CREATOR = new zzat();
        }

        private TokenBindingStatus(String str) {
            this.zzb = str;
        }

        public static TokenBindingStatus fromString(String str) throws UnsupportedTokenBindingStatusException {
            for (TokenBindingStatus tokenBindingStatus : values()) {
                if (str.equals(tokenBindingStatus.zzb)) {
                    return tokenBindingStatus;
                }
            }
            throw new UnsupportedTokenBindingStatusException(str);
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return this.zzb;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.zzb);
        }
    }

    /* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
    public static class UnsupportedTokenBindingStatusException extends Exception {
        public UnsupportedTokenBindingStatusException(String str) {
            super(String.format("TokenBindingStatus %s not supported", new Object[]{str}));
        }
    }

    public TokenBinding(String str) {
        this(TokenBindingStatus.PRESENT.toString(), (String) Preconditions.checkNotNull(str));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenBinding)) {
            return false;
        }
        TokenBinding tokenBinding = (TokenBinding) obj;
        if (!zzal.zza(this.zza, tokenBinding.zza) || !zzal.zza(this.zzb, tokenBinding.zzb)) {
            return false;
        }
        return true;
    }

    public String getTokenBindingId() {
        return this.zzb;
    }

    public String getTokenBindingStatusAsString() {
        return this.zza.toString();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public JSONObject toJsonObject() throws JSONException {
        try {
            return new JSONObject().put("status", (Object) this.zza).put("id", (Object) this.zzb);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getTokenBindingStatusAsString(), false);
        SafeParcelWriter.writeString(parcel, 3, getTokenBindingId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    TokenBinding(String str, String str2) {
        Preconditions.checkNotNull(str);
        try {
            this.zza = TokenBindingStatus.fromString(str);
            this.zzb = str2;
        } catch (UnsupportedTokenBindingStatusException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
