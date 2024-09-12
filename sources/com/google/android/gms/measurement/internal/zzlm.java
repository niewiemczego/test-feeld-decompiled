package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzlm implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzkp zza;
    /* access modifiers changed from: private */
    public volatile boolean zzb;
    private volatile zzfs zzc;

    protected zzlm(zzkp zzkp) {
        this.zza = zzkp;
    }

    public final void zza(Intent intent) {
        this.zza.zzt();
        Context zza2 = this.zza.zza();
        ConnectionTracker instance = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzj().zzp().zza("Connection attempt already in progress");
                return;
            }
            this.zza.zzj().zzp().zza("Using local app measurement service");
            this.zzb = true;
            instance.bindService(zza2, intent, this.zza.zza, TsExtractor.TS_STREAM_TYPE_AC3);
        }
    }

    public final void zza() {
        this.zza.zzt();
        Context zza2 = this.zza.zza();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzj().zzp().zza("Connection attempt already in progress");
            } else if (this.zzc == null || (!this.zzc.isConnecting() && !this.zzc.isConnected())) {
                this.zzc = new zzfs(zza2, Looper.getMainLooper(), this, this);
                this.zza.zzj().zzp().zza("Connecting to remote service");
                this.zzb = true;
                Preconditions.checkNotNull(this.zzc);
                this.zzc.checkAvailabilityAndConnect();
            } else {
                this.zza.zzj().zzp().zza("Already awaiting connection attempt");
            }
        }
    }

    public final void zzb() {
        if (this.zzc != null && (this.zzc.isConnected() || this.zzc.isConnecting())) {
            this.zzc.disconnect();
        }
        this.zzc = null;
    }

    public final void onConnected(Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                Preconditions.checkNotNull(this.zzc);
                this.zza.zzl().zzb((Runnable) new zzln(this, (zzfk) this.zzc.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzc = null;
                this.zzb = false;
            }
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzfr zzm = this.zza.zzu.zzm();
        if (zzm != null) {
            zzm.zzu().zza("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzb = false;
            this.zzc = null;
        }
        this.zza.zzl().zzb((Runnable) new zzlp(this));
    }

    public final void onConnectionSuspended(int i) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zza.zzj().zzc().zza("Service connection suspended");
        this.zza.zzl().zzb((Runnable) new zzlq(this));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r3.zza.zzj().zzg().zza("Service connect failed to get IMeasurementService");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0062 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
        /*
            r3 = this;
            java.lang.String r4 = "MeasurementServiceConnection.onServiceConnected"
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r4)
            monitor-enter(r3)
            r4 = 0
            if (r5 != 0) goto L_0x001f
            r3.zzb = r4     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzkp r4 = r3.zza     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzj()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzft r4 = r4.zzg()     // Catch:{ all -> 0x001c }
            java.lang.String r5 = "Service connected with null binder"
            r4.zza(r5)     // Catch:{ all -> 0x001c }
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            return
        L_0x001c:
            r4 = move-exception
            goto L_0x0099
        L_0x001f:
            r0 = 0
            java.lang.String r1 = r5.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x0062 }
            java.lang.String r2 = "com.google.android.gms.measurement.internal.IMeasurementService"
            boolean r2 = r2.equals(r1)     // Catch:{ RemoteException -> 0x0062 }
            if (r2 == 0) goto L_0x0052
            if (r5 != 0) goto L_0x002f
            goto L_0x0042
        L_0x002f:
            java.lang.String r1 = "com.google.android.gms.measurement.internal.IMeasurementService"
            android.os.IInterface r1 = r5.queryLocalInterface(r1)     // Catch:{ RemoteException -> 0x0062 }
            boolean r2 = r1 instanceof com.google.android.gms.measurement.internal.zzfk     // Catch:{ RemoteException -> 0x0062 }
            if (r2 == 0) goto L_0x003c
            com.google.android.gms.measurement.internal.zzfk r1 = (com.google.android.gms.measurement.internal.zzfk) r1     // Catch:{ RemoteException -> 0x0062 }
            goto L_0x0041
        L_0x003c:
            com.google.android.gms.measurement.internal.zzfm r1 = new com.google.android.gms.measurement.internal.zzfm     // Catch:{ RemoteException -> 0x0062 }
            r1.<init>(r5)     // Catch:{ RemoteException -> 0x0062 }
        L_0x0041:
            r0 = r1
        L_0x0042:
            com.google.android.gms.measurement.internal.zzkp r5 = r3.zza     // Catch:{ RemoteException -> 0x0062 }
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzj()     // Catch:{ RemoteException -> 0x0062 }
            com.google.android.gms.measurement.internal.zzft r5 = r5.zzp()     // Catch:{ RemoteException -> 0x0062 }
            java.lang.String r1 = "Bound to IMeasurementService interface"
            r5.zza(r1)     // Catch:{ RemoteException -> 0x0062 }
            goto L_0x0071
        L_0x0052:
            com.google.android.gms.measurement.internal.zzkp r5 = r3.zza     // Catch:{ RemoteException -> 0x0062 }
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzj()     // Catch:{ RemoteException -> 0x0062 }
            com.google.android.gms.measurement.internal.zzft r5 = r5.zzg()     // Catch:{ RemoteException -> 0x0062 }
            java.lang.String r2 = "Got binder with a wrong descriptor"
            r5.zza(r2, r1)     // Catch:{ RemoteException -> 0x0062 }
            goto L_0x0071
        L_0x0062:
            com.google.android.gms.measurement.internal.zzkp r5 = r3.zza     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzj()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzft r5 = r5.zzg()     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "Service connect failed to get IMeasurementService"
            r5.zza(r1)     // Catch:{ all -> 0x001c }
        L_0x0071:
            if (r0 != 0) goto L_0x0089
            r3.zzb = r4     // Catch:{ all -> 0x001c }
            com.google.android.gms.common.stats.ConnectionTracker r4 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ IllegalArgumentException -> 0x0097 }
            com.google.android.gms.measurement.internal.zzkp r5 = r3.zza     // Catch:{ IllegalArgumentException -> 0x0097 }
            android.content.Context r5 = r5.zza()     // Catch:{ IllegalArgumentException -> 0x0097 }
            com.google.android.gms.measurement.internal.zzkp r0 = r3.zza     // Catch:{ IllegalArgumentException -> 0x0097 }
            com.google.android.gms.measurement.internal.zzlm r0 = r0.zza     // Catch:{ IllegalArgumentException -> 0x0097 }
            r4.unbindService(r5, r0)     // Catch:{ IllegalArgumentException -> 0x0097 }
            goto L_0x0097
        L_0x0089:
            com.google.android.gms.measurement.internal.zzkp r4 = r3.zza     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzgy r4 = r4.zzl()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzll r5 = new com.google.android.gms.measurement.internal.zzll     // Catch:{ all -> 0x001c }
            r5.<init>(r3, r0)     // Catch:{ all -> 0x001c }
            r4.zzb((java.lang.Runnable) r5)     // Catch:{ all -> 0x001c }
        L_0x0097:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            return
        L_0x0099:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlm.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zza.zzj().zzc().zza("Service disconnected");
        this.zza.zzl().zzb((Runnable) new zzlo(this, componentName));
    }
}
