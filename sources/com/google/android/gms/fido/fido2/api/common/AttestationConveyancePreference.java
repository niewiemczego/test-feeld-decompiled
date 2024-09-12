package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
public enum AttestationConveyancePreference implements Parcelable {
    NONE("none"),
    INDIRECT(DevicePublicKeyStringDef.INDIRECT),
    DIRECT(DevicePublicKeyStringDef.DIRECT);
    
    public static final Parcelable.Creator<AttestationConveyancePreference> CREATOR = null;
    private final String zzb;

    /* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
    public static class UnsupportedAttestationConveyancePreferenceException extends Exception {
        public UnsupportedAttestationConveyancePreferenceException(String str) {
            super(String.format("Attestation conveyance preference %s not supported", new Object[]{str}));
        }
    }

    static {
        CREATOR = new zzb();
    }

    private AttestationConveyancePreference(String str) {
        this.zzb = str;
    }

    public static AttestationConveyancePreference fromString(String str) throws UnsupportedAttestationConveyancePreferenceException {
        for (AttestationConveyancePreference attestationConveyancePreference : values()) {
            if (str.equals(attestationConveyancePreference.zzb)) {
                return attestationConveyancePreference;
            }
        }
        throw new UnsupportedAttestationConveyancePreferenceException(str);
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
