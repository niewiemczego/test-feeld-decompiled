package com.google.android.recaptcha.internal;

import java.io.IOException;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public class zzje extends IOException {
    private zzke zza = null;
    private boolean zzb;

    public zzje(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    static zzjd zza() {
        return new zzjd("Protocol message tag had invalid wire type.");
    }

    static zzje zzb() {
        return new zzje("Protocol message end-group tag did not match expected tag.");
    }

    static zzje zzc() {
        return new zzje("Protocol message contained an invalid tag (zero).");
    }

    static zzje zzd() {
        return new zzje("Protocol message had invalid UTF-8.");
    }

    static zzje zze() {
        return new zzje("CodedInputStream encountered a malformed varint.");
    }

    static zzje zzf() {
        return new zzje("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzje zzg() {
        return new zzje("Failed to parse the message.");
    }

    static zzje zzi() {
        return new zzje("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzje zzj() {
        return new zzje("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final zzje zzh(zzke zzke) {
        this.zza = zzke;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zzk() {
        this.zzb = true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzl() {
        return this.zzb;
    }

    public zzje(String str) {
        super(str);
    }
}
