package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzn extends zzap {
    private final zzac zza;

    public final zzaq zza(String str, zzh zzh, List<zzaq> list) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 21624207:
                if (str.equals("getEventName")) {
                    c = 0;
                    break;
                }
                break;
            case 45521504:
                if (str.equals("getTimestamp")) {
                    c = 1;
                    break;
                }
                break;
            case 146575578:
                if (str.equals("getParamValue")) {
                    c = 2;
                    break;
                }
                break;
            case 700587132:
                if (str.equals("getParams")) {
                    c = 3;
                    break;
                }
                break;
            case 920706790:
                if (str.equals("setParamValue")) {
                    c = 4;
                    break;
                }
                break;
            case 1570616835:
                if (str.equals("setEventName")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                zzg.zza("getEventName", 0, list);
                return new zzas(this.zza.zzb().zzb());
            case 1:
                zzg.zza("getTimestamp", 0, list);
                return new zzai(Double.valueOf((double) this.zza.zzb().zza()));
            case 2:
                zzg.zza("getParamValue", 1, list);
                return zzj.zza(this.zza.zzb().zza(zzh.zza(list.get(0)).zzf()));
            case 3:
                zzg.zza("getParams", 0, list);
                Map<String, Object> zzc = this.zza.zzb().zzc();
                zzap zzap = new zzap();
                for (String next : zzc.keySet()) {
                    zzap.zza(next, zzj.zza(zzc.get(next)));
                }
                return zzap;
            case 4:
                zzg.zza("setParamValue", 2, list);
                String zzf = zzh.zza(list.get(0)).zzf();
                zzaq zza2 = zzh.zza(list.get(1));
                this.zza.zzb().zza(zzf, zzg.zza(zza2));
                return zza2;
            case 5:
                zzg.zza("setEventName", 1, list);
                zzaq zza3 = zzh.zza(list.get(0));
                if (zzc.equals(zza3) || zzd.equals(zza3)) {
                    throw new IllegalArgumentException("Illegal event name");
                }
                this.zza.zzb().zzb(zza3.zzf());
                return new zzas(zza3.zzf());
            default:
                return super.zza(str, zzh, list);
        }
    }

    public zzn(zzac zzac) {
        this.zza = zzac;
    }
}
