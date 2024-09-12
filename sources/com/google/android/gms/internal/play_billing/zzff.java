package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public class zzff extends IOException {
    private zzgc zza = null;

    public zzff(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    static zzfe zza() {
        return new zzfe("Protocol message tag had invalid wire type.");
    }

    static zzff zzb() {
        return new zzff("Protocol message contained an invalid tag (zero).");
    }

    static zzff zzc() {
        return new zzff("Protocol message had invalid UTF-8.");
    }

    static zzff zzd() {
        return new zzff("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzff zze() {
        return new zzff("Failed to parse the message.");
    }

    static zzff zzg() {
        return new zzff("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final zzff zzf(zzgc zzgc) {
        this.zza = zzgc;
        return this;
    }

    public zzff(String str) {
        super(str);
    }
}
