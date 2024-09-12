package com.google.firebase.auth.internal;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzn extends zzj {
    private final String zza;
    private final String zzb;
    private final String zzc;

    public final int hashCode() {
        String str = this.zza;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.zzb;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.zzc;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 ^ i;
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zza;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        return "AttestationResult{recaptchaV2Token=" + str + ", playIntegrityToken=" + str2 + ", recaptchaEnterpriseToken=" + this.zzc + "}";
    }

    private zzn(String str, String str2, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzj) {
            zzj zzj = (zzj) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzj.zzc()) : zzj.zzc() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzj.zza()) : zzj.zza() == null) {
                    String str3 = this.zzc;
                    return str3 != null ? str3.equals(zzj.zzb()) : zzj.zzb() == null;
                }
            }
        }
    }
}
