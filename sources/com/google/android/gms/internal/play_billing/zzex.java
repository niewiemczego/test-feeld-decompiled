package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzet;
import com.google.android.gms.internal.play_billing.zzex;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public abstract class zzex<MessageType extends zzex<MessageType, BuilderType>, BuilderType extends zzet<MessageType, BuilderType>> extends zzdg<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    protected zzhe zzc = zzhe.zzc();
    private int zzd = -1;

    static zzex zzh(Class cls) {
        Map map = zzb;
        zzex zzex = (zzex) map.get(cls);
        if (zzex == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzex = (zzex) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzex == null) {
            zzex = (zzex) ((zzex) zzhn.zze(cls)).zzu(6, (Object) null, (Object) null);
            if (zzex != null) {
                map.put(cls, zzex);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzex;
    }

    protected static zzex zzj(zzex zzex, byte[] bArr, zzej zzej) throws zzff {
        zzex zzw = zzw(zzex, bArr, 0, bArr.length, zzej);
        if (zzw == null || zzw.zzs()) {
            return zzw;
        }
        zzff zza = new zzhc(zzw).zza();
        zza.zzf(zzw);
        throw zza;
    }

    static Object zzl(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static Object zzm(zzgc zzgc, String str, Object[] objArr) {
        return new zzgl(zzgc, str, objArr);
    }

    protected static void zzp(Class cls, zzex zzex) {
        zzex.zzo();
        zzb.put(cls, zzex);
    }

    private final int zzv(zzgm zzgm) {
        return zzgk.zza().zzb(getClass()).zza(this);
    }

    private static zzex zzw(zzex zzex, byte[] bArr, int i, int i2, zzej zzej) throws zzff {
        zzex zzi = zzex.zzi();
        try {
            zzgm zzb2 = zzgk.zza().zzb(zzi.getClass());
            zzb2.zzh(zzi, bArr, 0, i2, new zzdj(zzej));
            zzb2.zzf(zzi);
            return zzi;
        } catch (zzff e) {
            e.zzf(zzi);
            throw e;
        } catch (zzhc e2) {
            zzff zza = e2.zza();
            zza.zzf(zzi);
            throw zza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzff) {
                throw ((zzff) e3.getCause());
            }
            zzff zzff = new zzff(e3);
            zzff.zzf(zzi);
            throw zzff;
        } catch (IndexOutOfBoundsException unused) {
            zzff zzg = zzff.zzg();
            zzg.zzf(zzi);
            throw zzg;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzgk.zza().zzb(getClass()).zzj(this, (zzex) obj);
    }

    public final int hashCode() {
        if (zzt()) {
            return zzd();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzd2 = zzd();
        this.zza = zzd2;
        return zzd2;
    }

    public final String toString() {
        return zzge.zza(this, super.toString());
    }

    /* access modifiers changed from: package-private */
    public final int zza(zzgm zzgm) {
        if (zzt()) {
            int zza = zzgm.zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zza2 = zzgm.zza(this);
        if (zza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
            return zza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
    }

    /* access modifiers changed from: package-private */
    public final int zzd() {
        return zzgk.zza().zzb(getClass()).zzb(this);
    }

    public final /* synthetic */ zzgc zzf() {
        return (zzex) zzu(6, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final zzet zzg() {
        return (zzet) zzu(5, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final zzex zzi() {
        return (zzex) zzu(4, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzgb zzk() {
        return (zzet) zzu(5, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final void zzn() {
        zzgk.zza().zzb(getClass()).zzf(this);
        zzo();
    }

    /* access modifiers changed from: package-private */
    public final void zzo() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final void zzq(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final void zzr(zzee zzee) throws IOException {
        zzgk.zza().zzb(getClass()).zzi(this, zzef.zza(zzee));
    }

    public final boolean zzs() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) zzu(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzgk.zza().zzb(getClass()).zzk(this);
        if (!booleanValue) {
            return zzk;
        }
        zzu(2, true != zzk ? null : this, (Object) null);
        return zzk;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzt() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    /* access modifiers changed from: protected */
    public abstract Object zzu(int i, Object obj, Object obj2);

    public final int zze() {
        int i;
        if (zzt()) {
            i = zzv((zzgm) null);
            if (i < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i);
            }
        } else {
            i = this.zzd & Integer.MAX_VALUE;
            if (i == Integer.MAX_VALUE) {
                i = zzv((zzgm) null);
                if (i >= 0) {
                    this.zzd = (this.zzd & Integer.MIN_VALUE) | i;
                } else {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i);
                }
            }
        }
        return i;
    }
}
