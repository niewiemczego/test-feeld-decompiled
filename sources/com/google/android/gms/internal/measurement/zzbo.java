package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzbo extends zzay {
    public final zzaq zza(String str, zzh zzh, List<zzaq> list) {
        switch (zzbr.zza[zzg.zza(str).ordinal()]) {
            case 1:
                zzg.zza(zzbv.ADD, 2, list);
                zzaq zza = zzh.zza(list.get(0));
                zzaq zza2 = zzh.zza(list.get(1));
                if (!(zza instanceof zzak) && !(zza instanceof zzas) && !(zza2 instanceof zzak) && !(zza2 instanceof zzas)) {
                    return new zzai(Double.valueOf(zza.zze().doubleValue() + zza2.zze().doubleValue()));
                }
                String zzf = zza.zzf();
                return new zzas(zzf + zza2.zzf());
            case 2:
                zzg.zza(zzbv.DIVIDE, 2, list);
                return new zzai(Double.valueOf(zzh.zza(list.get(0)).zze().doubleValue() / zzh.zza(list.get(1)).zze().doubleValue()));
            case 3:
                zzg.zza(zzbv.MODULUS, 2, list);
                return new zzai(Double.valueOf(zzh.zza(list.get(0)).zze().doubleValue() % zzh.zza(list.get(1)).zze().doubleValue()));
            case 4:
                zzg.zza(zzbv.MULTIPLY, 2, list);
                return new zzai(Double.valueOf(zzh.zza(list.get(0)).zze().doubleValue() * zzh.zza(list.get(1)).zze().doubleValue()));
            case 5:
                zzg.zza(zzbv.NEGATE, 1, list);
                return new zzai(Double.valueOf(zzh.zza(list.get(0)).zze().doubleValue() * -1.0d));
            case 6:
            case 7:
                zzg.zza(str, 2, list);
                zzaq zza3 = zzh.zza(list.get(0));
                zzh.zza(list.get(1));
                return zza3;
            case 8:
            case 9:
                zzg.zza(str, 1, list);
                return zzh.zza(list.get(0));
            case 10:
                zzg.zza(zzbv.SUBTRACT, 2, list);
                return new zzai(Double.valueOf(zzh.zza(list.get(0)).zze().doubleValue() + new zzai(Double.valueOf(zzh.zza(list.get(1)).zze().doubleValue() * -1.0d)).zze().doubleValue()));
            default:
                return super.zza(str);
        }
    }

    protected zzbo() {
        this.zza.add(zzbv.ADD);
        this.zza.add(zzbv.DIVIDE);
        this.zza.add(zzbv.MODULUS);
        this.zza.add(zzbv.MULTIPLY);
        this.zza.add(zzbv.NEGATE);
        this.zza.add(zzbv.POST_DECREMENT);
        this.zza.add(zzbv.POST_INCREMENT);
        this.zza.add(zzbv.PRE_DECREMENT);
        this.zza.add(zzbv.PRE_INCREMENT);
        this.zza.add(zzbv.SUBTRACT);
    }
}
