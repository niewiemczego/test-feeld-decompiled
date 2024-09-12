package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public interface zzaq {
    public static final zzaq zzc = new zzax();
    public static final zzaq zzd = new zzao();
    public static final zzaq zze = new zzaj("continue");
    public static final zzaq zzf = new zzaj("break");
    public static final zzaq zzg = new zzaj("return");
    public static final zzaq zzh = new zzag(Boolean.TRUE);
    public static final zzaq zzi = new zzag(Boolean.FALSE);
    public static final zzaq zzj = new zzas("");

    zzaq zza(String str, zzh zzh2, List<zzaq> list);

    zzaq zzc();

    Boolean zzd();

    Double zze();

    String zzf();

    Iterator<zzaq> zzh();
}
