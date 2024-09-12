package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.CharConversionException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzlx {
    /* access modifiers changed from: private */
    public static final Object zza = new Object();
    /* access modifiers changed from: private */
    public static final String zzb = "zzlx";
    private final zzce zzc;
    private final zzbh zzd;
    private zzcc zze;

    public final synchronized zzby zza() throws GeneralSecurityException {
        return this.zze.zza();
    }

    static /* synthetic */ void zza(zzby zzby, zzce zzce, zzbh zzbh) {
        if (zzbh != null) {
            try {
                zzby.zza(zzce, zzbh);
            } catch (IOException e) {
                throw new GeneralSecurityException(e);
            }
        } else {
            zzbm.zza(zzby, zzce);
        }
    }

    private zzlx(zza zza2) {
        this.zzc = new zzmc(zza2.zza, zza2.zzb, zza2.zzc);
        this.zzd = zza2.zze;
        this.zze = zza2.zzi;
    }

    static /* synthetic */ boolean zzd() {
        return Build.VERSION.SDK_INT >= 23;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlx$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza {
        /* access modifiers changed from: private */
        public Context zza = null;
        /* access modifiers changed from: private */
        public String zzb = null;
        /* access modifiers changed from: private */
        public String zzc = null;
        private String zzd = null;
        /* access modifiers changed from: private */
        public zzbh zze = null;
        private boolean zzf = true;
        private zzbv zzg = null;
        private zzvd zzh = null;
        /* access modifiers changed from: private */
        public zzcc zzi;

        private final zzbh zzb() throws GeneralSecurityException {
            if (!zzlx.zzd()) {
                Log.w(zzlx.zzb, "Android Keystore requires at least Android M");
                return null;
            }
            zzma zzma = new zzma();
            try {
                boolean zzc2 = zzma.zzc(this.zzd);
                try {
                    return zzma.zza(this.zzd);
                } catch (GeneralSecurityException | ProviderException e) {
                    if (zzc2) {
                        Log.w(zzlx.zzb, "cannot use Android Keystore, it'll be disabled", e);
                        return null;
                    }
                    throw new KeyStoreException(String.format("the master key %s exists but is unusable", new Object[]{this.zzd}), e);
                }
            } catch (GeneralSecurityException | ProviderException e2) {
                Log.w(zzlx.zzb, "cannot use Android Keystore, it'll be disabled", e2);
                return null;
            }
        }

        private static zzcc zza(byte[] bArr) throws GeneralSecurityException, IOException {
            return zzcc.zza(zzbm.zza(zzbk.zza(bArr)));
        }

        private final zzcc zzb(byte[] bArr) throws GeneralSecurityException, IOException {
            try {
                this.zze = new zzma().zza(this.zzd);
                try {
                    return zzcc.zza(zzby.zza(zzbk.zza(bArr), this.zze));
                } catch (IOException | GeneralSecurityException e) {
                    try {
                        return zza(bArr);
                    } catch (IOException unused) {
                        throw e;
                    }
                }
            } catch (GeneralSecurityException | ProviderException e2) {
                try {
                    zzcc zza2 = zza(bArr);
                    Log.w(zzlx.zzb, "cannot use Android Keystore, it'll be disabled", e2);
                    return zza2;
                } catch (IOException unused2) {
                    throw e2;
                }
            }
        }

        public final zza zza(zzvd zzvd) {
            this.zzh = zzvd;
            return this;
        }

        public final zza zza(String str) {
            if (!str.startsWith("android-keystore://")) {
                throw new IllegalArgumentException("key URI must start with android-keystore://");
            } else if (this.zzf) {
                this.zzd = str;
                return this;
            } else {
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
        }

        public final zza zza(Context context, String str, String str2) throws IOException {
            if (context != null) {
                this.zza = context;
                this.zzb = str;
                this.zzc = str2;
                return this;
            }
            throw new IllegalArgumentException("need an Android context");
        }

        public final synchronized zzlx zza() throws GeneralSecurityException, IOException {
            zzlx zzlx;
            if (this.zzb != null) {
                zzvd zzvd = this.zzh;
                if (zzvd != null && this.zzg == null) {
                    this.zzg = zzbv.zza(zzcv.zza(zzvd.zzj()));
                }
                synchronized (zzlx.zza) {
                    byte[] zzb2 = zzb(this.zza, this.zzb, this.zzc);
                    if (zzb2 == null) {
                        if (this.zzd != null) {
                            this.zze = zzb();
                        }
                        if (this.zzg != null) {
                            zzcc zza2 = zzcc.zzb().zza(this.zzg);
                            zzcc zza3 = zza2.zza(zza2.zza().zzc().zza(0).zza());
                            zzlx.zza(zza3.zza(), new zzmc(this.zza, this.zzb, this.zzc), this.zze);
                            this.zzi = zza3;
                        } else {
                            throw new GeneralSecurityException("cannot read or generate keyset");
                        }
                    } else {
                        if (this.zzd != null) {
                            if (zzlx.zzd()) {
                                this.zzi = zzb(zzb2);
                            }
                        }
                        this.zzi = zza(zzb2);
                    }
                    zzlx = new zzlx(this);
                }
            } else {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
            return zzlx;
        }

        private static byte[] zzb(Context context, String str, String str2) throws IOException {
            SharedPreferences sharedPreferences;
            if (str != null) {
                Context applicationContext = context.getApplicationContext();
                if (str2 == null) {
                    sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
                } else {
                    sharedPreferences = applicationContext.getSharedPreferences(str2, 0);
                }
                try {
                    String string = sharedPreferences.getString(str, (String) null);
                    if (string == null) {
                        return null;
                    }
                    return zzxh.zza(string);
                } catch (ClassCastException | IllegalArgumentException unused) {
                    throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", new Object[]{str}));
                }
            } else {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
        }
    }
}
