package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class zzajj extends IOException {
    private zzakk zza = null;
    private boolean zzb;

    static zzaji zza() {
        return new zzaji("Protocol message tag had invalid wire type.");
    }

    static zzajj zzb() {
        return new zzajj("Protocol message end-group tag did not match expected tag.");
    }

    static zzajj zzc() {
        return new zzajj("Protocol message contained an invalid tag (zero).");
    }

    static zzajj zzd() {
        return new zzajj("Protocol message had invalid UTF-8.");
    }

    static zzajj zze() {
        return new zzajj("CodedInputStream encountered a malformed varint.");
    }

    static zzajj zzf() {
        return new zzajj("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzajj zzg() {
        return new zzajj("Failed to parse the message.");
    }

    public final zzajj zza(zzakk zzakk) {
        this.zza = zzakk;
        return this;
    }

    static zzajj zzh() {
        return new zzajj("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzajj zzi() {
        return new zzajj("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public zzajj(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public zzajj(String str) {
        super(str);
    }

    /* access modifiers changed from: package-private */
    public final void zzj() {
        this.zzb = true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzk() {
        return this.zzb;
    }
}
