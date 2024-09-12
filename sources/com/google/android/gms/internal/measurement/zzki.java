package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
final class zzki {
    private static final zzkg zza = zzc();
    private static final zzkg zzb = new zzkf();

    static zzkg zza() {
        return zza;
    }

    static zzkg zzb() {
        return zzb;
    }

    private static zzkg zzc() {
        try {
            return (zzkg) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
