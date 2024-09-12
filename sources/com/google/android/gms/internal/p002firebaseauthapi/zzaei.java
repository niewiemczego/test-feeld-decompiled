package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaei  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaei extends zzafx {
    private String zza;
    private String zzb;
    private String zzc;
    private zzaex zzd;
    private String zze;

    public final zzafx zza(String str) {
        if (str != null) {
            this.zze = str;
            return this;
        }
        throw new NullPointerException("Null idToken");
    }

    public final zzafx zzb(String str) {
        if (str != null) {
            this.zza = str;
            return this;
        }
        throw new NullPointerException("Null providerId");
    }

    public final zzafx zzc(String str) {
        this.zzb = str;
        return this;
    }

    public final zzafx zzd(String str) {
        if (str != null) {
            this.zzc = str;
            return this;
        }
        throw new NullPointerException("Null token");
    }

    public final zzafx zza(zzaex zzaex) {
        if (zzaex != null) {
            this.zzd = zzaex;
            return this;
        }
        throw new NullPointerException("Null tokenType");
    }

    public final zzafy zza() {
        if (this.zza != null && this.zzc != null && this.zzd != null && this.zze != null) {
            return new zzaef(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" providerId");
        }
        if (this.zzc == null) {
            sb.append(" token");
        }
        if (this.zzd == null) {
            sb.append(" tokenType");
        }
        if (this.zze == null) {
            sb.append(" idToken");
        }
        throw new IllegalStateException("Missing required properties:" + String.valueOf(sb));
    }

    zzaei() {
    }
}
