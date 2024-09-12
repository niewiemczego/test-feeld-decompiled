package com.google.android.gms.internal.auth;

import com.google.android.gms.internal.auth.zzes;
import com.google.android.gms.internal.auth.zzeu;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public abstract class zzeu<MessageType extends zzeu<MessageType, BuilderType>, BuilderType extends zzes<MessageType, BuilderType>> extends zzdp<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    protected zzgz zzc = zzgz.zza();

    static zzeu zza(Class cls) {
        Map map = zzb;
        zzeu zzeu = (zzeu) map.get(cls);
        if (zzeu == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzeu = (zzeu) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzeu == null) {
            zzeu = (zzeu) ((zzeu) zzhi.zze(cls)).zzi(6, (Object) null, (Object) null);
            if (zzeu != null) {
                map.put(cls, zzeu);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzeu;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        if (r2 != false) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static com.google.android.gms.internal.auth.zzeu zzb(com.google.android.gms.internal.auth.zzeu r4, byte[] r5) throws com.google.android.gms.internal.auth.zzfa {
        /*
            int r0 = r5.length
            com.google.android.gms.internal.auth.zzek r1 = com.google.android.gms.internal.auth.zzek.zza
            r2 = 0
            com.google.android.gms.internal.auth.zzeu r4 = zzj(r4, r5, r2, r0, r1)
            if (r4 == 0) goto L_0x004c
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            boolean r5 = r5.booleanValue()
            r0 = 1
            r1 = 0
            java.lang.Object r2 = r4.zzi(r0, r1, r1)
            java.lang.Byte r2 = (java.lang.Byte) r2
            byte r2 = r2.byteValue()
            if (r2 != r0) goto L_0x001f
            goto L_0x004c
        L_0x001f:
            if (r2 == 0) goto L_0x003f
            com.google.android.gms.internal.auth.zzge r2 = com.google.android.gms.internal.auth.zzge.zza()
            java.lang.Class r3 = r4.getClass()
            com.google.android.gms.internal.auth.zzgh r2 = r2.zzb(r3)
            boolean r2 = r2.zzi(r4)
            if (r5 == 0) goto L_0x003c
            if (r0 == r2) goto L_0x0037
            r5 = r1
            goto L_0x0038
        L_0x0037:
            r5 = r4
        L_0x0038:
            r0 = 2
            r4.zzi(r0, r5, r1)
        L_0x003c:
            if (r2 == 0) goto L_0x003f
            goto L_0x004c
        L_0x003f:
            com.google.android.gms.internal.auth.zzgx r5 = new com.google.android.gms.internal.auth.zzgx
            r5.<init>(r4)
            com.google.android.gms.internal.auth.zzfa r5 = r5.zza()
            r5.zze(r4)
            throw r5
        L_0x004c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzeu.zzb(com.google.android.gms.internal.auth.zzeu, byte[]):com.google.android.gms.internal.auth.zzeu");
    }

    protected static zzey zzc() {
        return zzgf.zze();
    }

    static Object zze(Method method, Object obj, Object... objArr) {
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

    protected static Object zzf(zzfw zzfw, String str, Object[] objArr) {
        return new zzgg(zzfw, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", objArr);
    }

    protected static void zzg(Class cls, zzeu zzeu) {
        zzb.put(cls, zzeu);
    }

    private static zzeu zzj(zzeu zzeu, byte[] bArr, int i, int i2, zzek zzek) throws zzfa {
        zzeu zzeu2 = (zzeu) zzeu.zzi(4, (Object) null, (Object) null);
        try {
            zzgh zzb2 = zzge.zza().zzb(zzeu2.getClass());
            zzb2.zzg(zzeu2, bArr, 0, i2, new zzds(zzek));
            zzb2.zze(zzeu2);
            if (zzeu2.zza == 0) {
                return zzeu2;
            }
            throw new RuntimeException();
        } catch (zzfa e) {
            e.zze(zzeu2);
            throw e;
        } catch (zzgx e2) {
            zzfa zza = e2.zza();
            zza.zze(zzeu2);
            throw zza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzfa) {
                throw ((zzfa) e3.getCause());
            }
            zzfa zzfa = new zzfa(e3);
            zzfa.zze(zzeu2);
            throw zzfa;
        } catch (IndexOutOfBoundsException unused) {
            zzfa zzf = zzfa.zzf();
            zzf.zze(zzeu2);
            throw zzf;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzge.zza().zzb(getClass()).zzh(this, (zzeu) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zza = zzge.zza().zzb(getClass()).zza(this);
        this.zza = zza;
        return zza;
    }

    public final String toString() {
        return zzfy.zza(this, super.toString());
    }

    public final /* synthetic */ zzfv zzd() {
        zzes zzes = (zzes) zzi(5, (Object) null, (Object) null);
        zzes.zze(this);
        return zzes;
    }

    public final /* synthetic */ zzfw zzh() {
        return (zzeu) zzi(6, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract Object zzi(int i, Object obj, Object obj2);
}
