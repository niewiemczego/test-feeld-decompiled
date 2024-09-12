package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzct;
import com.google.android.gms.internal.measurement.zzcv;
import com.google.android.gms.internal.measurement.zzda;
import com.google.android.gms.internal.measurement.zzdb;
import com.google.android.gms.internal.measurement.zzdd;
import io.sentry.protocol.App;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.5.0 */
public class AppMeasurementDynamiteService extends zzct {
    zzhf zza = null;
    private final Map<Integer, zzil> zzb = new ArrayMap();

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.5.0 */
    class zza implements zzim {
        private zzda zza;

        zza(zzda zzda) {
            this.zza = zzda;
        }

        public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                if (AppMeasurementDynamiteService.this.zza != null) {
                    AppMeasurementDynamiteService.this.zza.zzj().zzu().zza("Event interceptor threw exception", e);
                }
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.5.0 */
    class zzb implements zzil {
        private zzda zza;

        zzb(zzda zzda) {
            this.zza = zzda;
        }

        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                if (AppMeasurementDynamiteService.this.zza != null) {
                    AppMeasurementDynamiteService.this.zza.zzj().zzu().zza("Event listener threw exception", e);
                }
            }
        }
    }

    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zze().zza(str, j);
    }

    @EnsuresNonNull({"scion"})
    private final void zza() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zza();
        this.zza.zzp().zza(str, str2, bundle);
    }

    public void clearMeasurementEnabled(long j) throws RemoteException {
        zza();
        this.zza.zzp().zza((Boolean) null);
    }

    public void endAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zze().zzb(str, j);
    }

    public void generateEventId(zzcv zzcv) throws RemoteException {
        zza();
        long zzm = this.zza.zzt().zzm();
        zza();
        this.zza.zzt().zza(zzcv, zzm);
    }

    public void getAppInstanceId(zzcv zzcv) throws RemoteException {
        zza();
        this.zza.zzl().zzb((Runnable) new zzi(this, zzcv));
    }

    public void getCachedAppInstanceId(zzcv zzcv) throws RemoteException {
        zza();
        zza(zzcv, this.zza.zzp().zzae());
    }

    public void getConditionalUserProperties(String str, String str2, zzcv zzcv) throws RemoteException {
        zza();
        this.zza.zzl().zzb((Runnable) new zzl(this, zzcv, str, str2));
    }

    public void getCurrentScreenClass(zzcv zzcv) throws RemoteException {
        zza();
        zza(zzcv, this.zza.zzp().zzaf());
    }

    public void getCurrentScreenName(zzcv zzcv) throws RemoteException {
        zza();
        zza(zzcv, this.zza.zzp().zzag());
    }

    public void getGmpAppId(zzcv zzcv) throws RemoteException {
        zza();
        zza(zzcv, this.zza.zzp().zzah());
    }

    public void getMaxUserProperties(String str, zzcv zzcv) throws RemoteException {
        zza();
        this.zza.zzp();
        Preconditions.checkNotEmpty(str);
        zza();
        this.zza.zzt().zza(zzcv, 25);
    }

    public void getSessionId(zzcv zzcv) throws RemoteException {
        zza();
        zziq zzp = this.zza.zzp();
        zzp.zzl().zzb((Runnable) new zzjq(zzp, zzcv));
    }

    public void getTestFlag(zzcv zzcv, int i) throws RemoteException {
        zza();
        if (i == 0) {
            this.zza.zzt().zza(zzcv, this.zza.zzp().zzai());
        } else if (i == 1) {
            this.zza.zzt().zza(zzcv, this.zza.zzp().zzad().longValue());
        } else if (i == 2) {
            zznd zzt = this.zza.zzt();
            double doubleValue = this.zza.zzp().zzab().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                zzcv.zza(bundle);
            } catch (RemoteException e) {
                zzt.zzu.zzj().zzu().zza("Error returning double value to wrapper", e);
            }
        } else if (i == 3) {
            this.zza.zzt().zza(zzcv, this.zza.zzp().zzac().intValue());
        } else if (i == 4) {
            this.zza.zzt().zza(zzcv, this.zza.zzp().zzaa().booleanValue());
        }
    }

    public void getUserProperties(String str, String str2, boolean z, zzcv zzcv) throws RemoteException {
        zza();
        this.zza.zzl().zzb((Runnable) new zzj(this, zzcv, str, str2, z));
    }

    public void initForTests(Map map) throws RemoteException {
        zza();
    }

    public void initialize(IObjectWrapper iObjectWrapper, zzdd zzdd, long j) throws RemoteException {
        zzhf zzhf = this.zza;
        if (zzhf == null) {
            this.zza = zzhf.zza((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzdd, Long.valueOf(j));
        } else {
            zzhf.zzj().zzu().zza("Attempting to initialize multiple times");
        }
    }

    public void isDataCollectionEnabled(zzcv zzcv) throws RemoteException {
        zza();
        this.zza.zzl().zzb((Runnable) new zzn(this, zzcv));
    }

    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zza();
        this.zza.zzp().zza(str, str2, bundle, z, z2, j);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, zzcv zzcv, long j) throws RemoteException {
        Bundle bundle2;
        zza();
        Preconditions.checkNotEmpty(str2);
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", App.TYPE);
        this.zza.zzl().zzb((Runnable) new zzk(this, zzcv, new zzbg(str2, new zzbb(bundle), App.TYPE, j), str));
    }

    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Object obj;
        Object obj2;
        zza();
        Object obj3 = null;
        if (iObjectWrapper == null) {
            obj = null;
        } else {
            obj = ObjectWrapper.unwrap(iObjectWrapper);
        }
        if (iObjectWrapper2 == null) {
            obj2 = null;
        } else {
            obj2 = ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (iObjectWrapper3 != null) {
            obj3 = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.zza.zzj().zza(i, true, false, str, obj, obj2, obj3);
    }

    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zza();
        zzjx zzjx = this.zza.zzp().zza;
        if (zzjx != null) {
            this.zza.zzp().zzak();
            zzjx.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzjx zzjx = this.zza.zzp().zza;
        if (zzjx != null) {
            this.zza.zzp().zzak();
            zzjx.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzjx zzjx = this.zza.zzp().zza;
        if (zzjx != null) {
            this.zza.zzp().zzak();
            zzjx.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzjx zzjx = this.zza.zzp().zza;
        if (zzjx != null) {
            this.zza.zzp().zzak();
            zzjx.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcv zzcv, long j) throws RemoteException {
        zza();
        zzjx zzjx = this.zza.zzp().zza;
        Bundle bundle = new Bundle();
        if (zzjx != null) {
            this.zza.zzp().zzak();
            zzjx.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzcv.zza(bundle);
        } catch (RemoteException e) {
            this.zza.zzj().zzu().zza("Error returning bundle value to wrapper", e);
        }
    }

    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzjx zzjx = this.zza.zzp().zza;
        if (zzjx != null) {
            this.zza.zzp().zzak();
            zzjx.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzjx zzjx = this.zza.zzp().zza;
        if (zzjx != null) {
            this.zza.zzp().zzak();
            zzjx.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void performAction(Bundle bundle, zzcv zzcv, long j) throws RemoteException {
        zza();
        zzcv.zza((Bundle) null);
    }

    public void registerOnMeasurementEventListener(zzda zzda) throws RemoteException {
        zzil zzil;
        zza();
        synchronized (this.zzb) {
            zzil = this.zzb.get(Integer.valueOf(zzda.zza()));
            if (zzil == null) {
                zzil = new zzb(zzda);
                this.zzb.put(Integer.valueOf(zzda.zza()), zzil);
            }
        }
        this.zza.zzp().zza(zzil);
    }

    public void resetAnalyticsData(long j) throws RemoteException {
        zza();
        zziq zzp = this.zza.zzp();
        zzp.zza((String) null);
        zzp.zzl().zzb((Runnable) new zzjk(zzp, j));
    }

    private final void zza(zzcv zzcv, String str) {
        zza();
        this.zza.zzt().zza(zzcv, str);
    }

    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        zza();
        if (bundle == null) {
            this.zza.zzj().zzg().zza("Conditional user property must not be null");
        } else {
            this.zza.zzp().zza(bundle, j);
        }
    }

    public void setConsent(Bundle bundle, long j) throws RemoteException {
        zza();
        zziq zzp = this.zza.zzp();
        zzp.zzl().zzc((Runnable) new zziw(zzp, bundle, j));
    }

    public void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        zza();
        this.zza.zzp().zza(bundle, -20, j);
    }

    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        zza();
        this.zza.zzq().zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zza();
        zziq zzp = this.zza.zzp();
        zzp.zzu();
        zzp.zzl().zzb((Runnable) new zzjb(zzp, z));
    }

    public void setDefaultEventParameters(Bundle bundle) {
        Bundle bundle2;
        zza();
        zziq zzp = this.zza.zzp();
        if (bundle == null) {
            bundle2 = null;
        } else {
            bundle2 = new Bundle(bundle);
        }
        zzp.zzl().zzb((Runnable) new zzit(zzp, bundle2));
    }

    public void setEventInterceptor(zzda zzda) throws RemoteException {
        zza();
        zza zza2 = new zza(zzda);
        if (this.zza.zzl().zzg()) {
            this.zza.zzp().zza((zzim) zza2);
        } else {
            this.zza.zzl().zzb((Runnable) new zzm(this, zza2));
        }
    }

    public void setInstanceIdProvider(zzdb zzdb) throws RemoteException {
        zza();
    }

    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzp().zza(Boolean.valueOf(z));
    }

    public void setMinimumSessionDuration(long j) throws RemoteException {
        zza();
    }

    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zza();
        zziq zzp = this.zza.zzp();
        zzp.zzl().zzb((Runnable) new zzjd(zzp, j));
    }

    public void setUserId(String str, long j) throws RemoteException {
        zza();
        zziq zzp = this.zza.zzp();
        if (str == null || !TextUtils.isEmpty(str)) {
            zzp.zzl().zzb((Runnable) new zziy(zzp, str));
            zzp.zza((String) null, "_id", (Object) str, true, j);
            return;
        }
        zzp.zzu.zzj().zzu().zza("User ID must be non-empty or null");
    }

    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzp().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    public void unregisterOnMeasurementEventListener(zzda zzda) throws RemoteException {
        zzil remove;
        zza();
        synchronized (this.zzb) {
            remove = this.zzb.remove(Integer.valueOf(zzda.zza()));
        }
        if (remove == null) {
            remove = new zzb(zzda);
        }
        this.zza.zzp().zzb(remove);
    }
}
