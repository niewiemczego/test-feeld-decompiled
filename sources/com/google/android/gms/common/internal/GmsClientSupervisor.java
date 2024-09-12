package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
public abstract class GmsClientSupervisor {
    static HandlerThread zza = null;
    private static final Object zzb = new Object();
    private static zzs zzc = null;
    private static Executor zzd = null;
    private static boolean zze = false;

    public static int getDefaultBindFlags() {
        return 4225;
    }

    public static GmsClientSupervisor getInstance(Context context) {
        Looper looper;
        synchronized (zzb) {
            if (zzc == null) {
                Context applicationContext = context.getApplicationContext();
                if (zze) {
                    looper = getOrStartHandlerThread().getLooper();
                } else {
                    looper = context.getMainLooper();
                }
                zzc = new zzs(applicationContext, looper, zzd);
            }
        }
        return zzc;
    }

    public static HandlerThread getOrStartHandlerThread() {
        synchronized (zzb) {
            HandlerThread handlerThread = zza;
            if (handlerThread != null) {
                return handlerThread;
            }
            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
            zza = handlerThread2;
            handlerThread2.start();
            HandlerThread handlerThread3 = zza;
            return handlerThread3;
        }
    }

    public static void setDefaultBindExecutor(Executor executor) {
        synchronized (zzb) {
            zzs zzs = zzc;
            if (zzs != null) {
                zzs.zzi(executor);
            }
            zzd = executor;
        }
    }

    public static void setUseHandlerThreadForCallbacks() {
        synchronized (zzb) {
            zzs zzs = zzc;
            if (zzs != null && !zze) {
                zzs.zzj(getOrStartHandlerThread().getLooper());
            }
            zze = true;
        }
    }

    public boolean bindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zzc(new zzo(componentName, 4225), serviceConnection, str, (Executor) null);
    }

    public void unbindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zza(new zzo(componentName, 4225), serviceConnection, str);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzo zzo, ServiceConnection serviceConnection, String str);

    public final void zzb(String str, String str2, int i, ServiceConnection serviceConnection, String str3, boolean z) {
        zza(new zzo(str, str2, 4225, z), serviceConnection, str3);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzc(zzo zzo, ServiceConnection serviceConnection, String str, Executor executor);

    public boolean bindService(ComponentName componentName, ServiceConnection serviceConnection, String str, Executor executor) {
        return zzc(new zzo(componentName, 4225), serviceConnection, str, executor);
    }

    public void unbindService(String str, ServiceConnection serviceConnection, String str2) {
        zza(new zzo(str, 4225, false), serviceConnection, str2);
    }

    @ResultIgnorabilityUnspecified
    public boolean bindService(String str, ServiceConnection serviceConnection, String str2) {
        return zzc(new zzo(str, 4225, false), serviceConnection, str2, (Executor) null);
    }
}
