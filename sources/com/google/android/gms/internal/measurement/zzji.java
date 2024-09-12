package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
public class zzji extends IOException {
    private zzkj zza = null;

    static zzjh zza() {
        return new zzjh("Protocol message tag had invalid wire type.");
    }

    static zzji zzb() {
        return new zzji("Protocol message end-group tag did not match expected tag.");
    }

    static zzji zzc() {
        return new zzji("Protocol message contained an invalid tag (zero).");
    }

    static zzji zzd() {
        return new zzji("Protocol message had invalid UTF-8.");
    }

    static zzji zze() {
        return new zzji("CodedInputStream encountered a malformed varint.");
    }

    static zzji zzf() {
        return new zzji("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzji zzg() {
        return new zzji("Failed to parse the message.");
    }

    static zzji zzh() {
        return new zzji("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public zzji(String str) {
        super(str);
    }
}
