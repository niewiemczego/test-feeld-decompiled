package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
final class zzlk extends zzls {
    private final /* synthetic */ zzlg zza;

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzli(this.zza);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzlk(zzlg zzlg) {
        super(zzlg);
        this.zza = zzlg;
    }
}
