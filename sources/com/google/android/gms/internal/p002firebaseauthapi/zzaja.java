package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;
import com.google.android.gms.internal.p002firebaseauthapi.zzaja.zzb;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaja  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class zzaja<MessageType extends zzaja<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzahd<MessageType, BuilderType> {
    private static Map<Object, zzaja<?, ?>> zzc = new ConcurrentHashMap();
    protected zzame zzb = zzame.zzc();
    private int zzd = -1;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaja$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    protected static class zza<T extends zzaja<T, ?>> extends zzahh<T> {
        private final T zza;

        public zza(T t) {
            this.zza = t;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaja$zzc */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    static final class zzc implements zzaiu<zzc> {
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        public final int zza() {
            throw new NoSuchMethodError();
        }

        public final zzakn zza(zzakn zzakn, zzakk zzakk) {
            throw new NoSuchMethodError();
        }

        public final zzakt zza(zzakt zzakt, zzakt zzakt2) {
            throw new NoSuchMethodError();
        }

        public final zzamo zzb() {
            throw new NoSuchMethodError();
        }

        public final zzamy zzc() {
            throw new NoSuchMethodError();
        }

        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        public final boolean zze() {
            throw new NoSuchMethodError();
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaja$zzd */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzaja<MessageType, BuilderType> implements zzakm {
        protected zzais<zzc> zzc = zzais.zzb();

        /* access modifiers changed from: package-private */
        public final zzais<zzc> zza() {
            if (this.zzc.zzf()) {
                this.zzc = (zzais) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaja$zzf */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static class zzf<ContainingType extends zzakk, Type> extends zzaim<ContainingType, Type> {
    }

    private final int zza() {
        return zzaky.zza().zza(this).zzb(this);
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaja$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static abstract class zzb<MessageType extends zzaja<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzahf<MessageType, BuilderType> {
        protected MessageType zza;
        private final MessageType zzb;

        public final /* synthetic */ zzahf zzc() {
            return (zzb) clone();
        }

        public final BuilderType zza(MessageType messagetype) {
            MessageType messagetype2 = this.zzb;
            zzaja zzaja = (zzaja) messagetype2;
            if (messagetype2.equals(messagetype)) {
                return this;
            }
            if (!this.zza.zzv()) {
                zzi();
            }
            zza(this.zza, messagetype);
            return this;
        }

        /* renamed from: zzd */
        public final MessageType zzf() {
            MessageType messagetype = (zzaja) zzg();
            if (messagetype.zzu()) {
                return messagetype;
            }
            throw new zzamc(messagetype);
        }

        /* renamed from: zze */
        public MessageType zzg() {
            if (!this.zza.zzv()) {
                return this.zza;
            }
            this.zza.zzs();
            return this.zza;
        }

        public final /* synthetic */ zzakk zzr() {
            return this.zzb;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            MessageType messagetype = this.zzb;
            zzaja zzaja = (zzaja) messagetype;
            zzb zzb2 = (zzb) messagetype.zza(zze.zze, (Object) null, (Object) null);
            zzb2.zza = (zzaja) zzg();
            return zzb2;
        }

        protected zzb(MessageType messagetype) {
            this.zzb = messagetype;
            if (!messagetype.zzv()) {
                this.zza = messagetype.zzn();
                return;
            }
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        /* access modifiers changed from: protected */
        public final void zzh() {
            if (!this.zza.zzv()) {
                zzi();
            }
        }

        /* access modifiers changed from: protected */
        public void zzi() {
            MessageType zzn = this.zzb.zzn();
            zza(zzn, this.zza);
            this.zza = zzn;
        }

        private static <MessageType> void zza(MessageType messagetype, MessageType messagetype2) {
            zzaky.zza().zza(messagetype).zza(messagetype, messagetype2);
        }

        public final boolean zzu() {
            return zzaja.zza(this.zza, false);
        }
    }

    private final int zzb(zzalc<?> zzalc) {
        if (zzalc == null) {
            return zzaky.zza().zza(this).zza(this);
        }
        return zzalc.zza(this);
    }

    /* access modifiers changed from: package-private */
    public final int zzh() {
        return this.zzd & Integer.MAX_VALUE;
    }

    public final int zzk() {
        return zza((zzalc) null);
    }

    /* 'enum' modifier removed */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaja$zze */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    /* access modifiers changed from: package-private */
    public final int zza(zzalc zzalc) {
        if (zzv()) {
            int zzb2 = zzb((zzalc<?>) zzalc);
            if (zzb2 >= 0) {
                return zzb2;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zzb2);
        } else if (zzh() != Integer.MAX_VALUE) {
            return zzh();
        } else {
            int zzb3 = zzb((zzalc<?>) zzalc);
            zzb(zzb3);
            return zzb3;
        }
    }

    public int hashCode() {
        if (zzv()) {
            return zza();
        }
        if (this.zza == 0) {
            this.zza = zza();
        }
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzaja<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzl() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    public final BuilderType zzm() {
        return ((zzb) zza(zze.zze, (Object) null, (Object) null)).zza(this);
    }

    private static <T extends zzaja<T, ?>> T zza(T t) throws zzajj {
        if (t == null || t.zzu()) {
            return t;
        }
        throw new zzamc(t).zza().zza(t);
    }

    static <T extends zzaja<?, ?>> T zza(Class<T> cls) {
        T t = (zzaja) zzc.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzaja) zzc.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzaja) ((zzaja) zzamh.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
            if (t != null) {
                zzc.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    /* access modifiers changed from: package-private */
    public final MessageType zzn() {
        return (zzaja) zza(zze.zzd, (Object) null, (Object) null);
    }

    protected static <T extends zzaja<T, ?>> T zza(T t, zzahm zzahm, zzaip zzaip) throws zzajj {
        return zza(zzb(t, zzahm, zzaip));
    }

    protected static <T extends zzaja<T, ?>> T zza(T t, InputStream inputStream, zzaip zzaip) throws zzajj {
        zzaib zzaib;
        if (inputStream == null) {
            byte[] bArr = zzajc.zzb;
            zzaib = zzaib.zza(bArr, 0, bArr.length, false);
        } else {
            zzaib = new zzaic(inputStream);
        }
        return zza(zza(t, zzaib, zzaip));
    }

    protected static <T extends zzaja<T, ?>> T zza(T t, byte[] bArr, zzaip zzaip) throws zzajj {
        return zza(zza(t, bArr, 0, bArr.length, zzaip));
    }

    private static <T extends zzaja<T, ?>> T zzb(T t, zzahm zzahm, zzaip zzaip) throws zzajj {
        zzaib zzc2 = zzahm.zzc();
        T zza2 = zza(t, zzc2, zzaip);
        try {
            zzc2.zzb(0);
            return zza2;
        } catch (zzajj e) {
            throw e.zza(zza2);
        }
    }

    private static <T extends zzaja<T, ?>> T zza(T t, zzaib zzaib, zzaip zzaip) throws zzajj {
        T zzn = t.zzn();
        try {
            zzalc zza2 = zzaky.zza().zza(zzn);
            zza2.zza(zzn, zzaig.zza(zzaib), zzaip);
            zza2.zzc(zzn);
            return zzn;
        } catch (zzajj e) {
            e = e;
            if (e.zzk()) {
                e = new zzajj((IOException) e);
            }
            throw e.zza(zzn);
        } catch (zzamc e2) {
            throw e2.zza().zza(zzn);
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzajj) {
                throw ((zzajj) e3.getCause());
            }
            throw new zzajj(e3).zza(zzn);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzajj) {
                throw ((zzajj) e4.getCause());
            }
            throw e4;
        }
    }

    private static <T extends zzaja<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzaip zzaip) throws zzajj {
        T zzn = t.zzn();
        try {
            zzalc zza2 = zzaky.zza().zza(zzn);
            zza2.zza(zzn, bArr, 0, i2, new zzahl(zzaip));
            zza2.zzc(zzn);
            return zzn;
        } catch (zzajj e) {
            e = e;
            if (e.zzk()) {
                e = new zzajj((IOException) e);
            }
            throw e.zza(zzn);
        } catch (zzamc e2) {
            throw e2.zza().zza(zzn);
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzajj) {
                throw ((zzajj) e3.getCause());
            }
            throw new zzajj(e3).zza(zzn);
        } catch (IndexOutOfBoundsException unused) {
            throw zzajj.zzi().zza(zzn);
        }
    }

    protected static <E> zzajg<E> zzo() {
        return zzalb.zzd();
    }

    protected static <E> zzajg<E> zza(zzajg<E> zzajg) {
        int size = zzajg.size();
        return zzajg.zza(size == 0 ? 10 : size << 1);
    }

    public final /* synthetic */ zzakn zzp() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzakn zzq() {
        return ((zzb) zza(zze.zze, (Object) null, (Object) null)).zza(this);
    }

    public final /* synthetic */ zzakk zzr() {
        return (zzaja) zza(zze.zzf, (Object) null, (Object) null);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
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

    protected static Object zza(zzakk zzakk, String str, Object[] objArr) {
        return new zzala(zzakk, str, objArr);
    }

    public String toString() {
        return zzakp.zza((zzakk) this, super.toString());
    }

    /* access modifiers changed from: protected */
    public final void zzs() {
        zzaky.zza().zza(this).zzc(this);
        zzt();
    }

    /* access modifiers changed from: package-private */
    public final void zzt() {
        this.zzd &= Integer.MAX_VALUE;
    }

    protected static <T extends zzaja<?, ?>> void zza(Class<T> cls, T t) {
        t.zzt();
        zzc.put(cls, t);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i) {
        if (i >= 0) {
            this.zzd = (i & Integer.MAX_VALUE) | (this.zzd & Integer.MIN_VALUE);
            return;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + i);
    }

    public final void zza(zzaii zzaii) throws IOException {
        zzaky.zza().zza(this).zza(this, (zzanb) zzaik.zza(zzaii));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzaky.zza().zza(this).zzb(this, (zzaja) obj);
        }
        return false;
    }

    public final boolean zzu() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    protected static final <T extends zzaja<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zza, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzaky.zza().zza(t).zzd(t);
        if (z) {
            t.zza(zze.zzb, (Object) zzd2 ? t : null, (Object) null);
        }
        return zzd2;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzv() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }
}
