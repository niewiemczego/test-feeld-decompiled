package com.google.android.gms.iid;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.gcm.zzj;
import java.util.ArrayDeque;
import java.util.Queue;

final class zzt implements ServiceConnection {
    int state;
    final Messenger zzch;
    zzy zzci;
    final Queue<zzz<?>> zzcj;
    final SparseArray<zzz<?>> zzck;
    final /* synthetic */ zzr zzcl;

    private zzt(zzr zzr) {
        this.zzcl = zzr;
        this.state = 0;
        this.zzch = new Messenger(new zzj(Looper.getMainLooper(), new zzu(this)));
        this.zzcj = new ArrayDeque();
        this.zzck = new SparseArray<>();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0098, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zze(com.google.android.gms.iid.zzz r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.state     // Catch:{ all -> 0x0099 }
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0043
            if (r0 == r3) goto L_0x003c
            if (r0 == r1) goto L_0x0032
            r6 = 3
            if (r0 == r6) goto L_0x0030
            r6 = 4
            if (r0 != r6) goto L_0x0013
            goto L_0x0030
        L_0x0013:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0099 }
            int r0 = r5.state     // Catch:{ all -> 0x0099 }
            r1 = 26
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
            r2.<init>(r1)     // Catch:{ all -> 0x0099 }
            java.lang.String r1 = "Unknown state: "
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ all -> 0x0099 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0099 }
            r6.<init>(r0)     // Catch:{ all -> 0x0099 }
            throw r6     // Catch:{ all -> 0x0099 }
        L_0x0030:
            monitor-exit(r5)
            return r2
        L_0x0032:
            java.util.Queue<com.google.android.gms.iid.zzz<?>> r0 = r5.zzcj     // Catch:{ all -> 0x0099 }
            r0.add(r6)     // Catch:{ all -> 0x0099 }
            r5.zzt()     // Catch:{ all -> 0x0099 }
            monitor-exit(r5)
            return r3
        L_0x003c:
            java.util.Queue<com.google.android.gms.iid.zzz<?>> r0 = r5.zzcj     // Catch:{ all -> 0x0099 }
            r0.add(r6)     // Catch:{ all -> 0x0099 }
            monitor-exit(r5)
            return r3
        L_0x0043:
            java.util.Queue<com.google.android.gms.iid.zzz<?>> r0 = r5.zzcj     // Catch:{ all -> 0x0099 }
            r0.add(r6)     // Catch:{ all -> 0x0099 }
            int r6 = r5.state     // Catch:{ all -> 0x0099 }
            if (r6 != 0) goto L_0x004e
            r6 = r3
            goto L_0x004f
        L_0x004e:
            r6 = r2
        L_0x004f:
            com.google.android.gms.common.internal.Preconditions.checkState(r6)     // Catch:{ all -> 0x0099 }
            java.lang.String r6 = "MessengerIpcClient"
            boolean r6 = android.util.Log.isLoggable(r6, r1)     // Catch:{ all -> 0x0099 }
            if (r6 == 0) goto L_0x0061
            java.lang.String r6 = "MessengerIpcClient"
            java.lang.String r0 = "Starting bind to GmsCore"
            android.util.Log.v(r6, r0)     // Catch:{ all -> 0x0099 }
        L_0x0061:
            r5.state = r3     // Catch:{ all -> 0x0099 }
            android.content.Intent r6 = new android.content.Intent     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = "com.google.android.c2dm.intent.REGISTER"
            r6.<init>(r0)     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = "com.google.android.gms"
            r6.setPackage(r0)     // Catch:{ all -> 0x0099 }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ all -> 0x0099 }
            com.google.android.gms.iid.zzr r1 = r5.zzcl     // Catch:{ all -> 0x0099 }
            android.content.Context r1 = r1.zzl     // Catch:{ all -> 0x0099 }
            boolean r6 = r0.bindService(r1, r6, r5, r3)     // Catch:{ all -> 0x0099 }
            if (r6 != 0) goto L_0x0085
            java.lang.String r6 = "Unable to bind to service"
            r5.zzd(r2, r6)     // Catch:{ all -> 0x0099 }
            goto L_0x0097
        L_0x0085:
            com.google.android.gms.iid.zzr r6 = r5.zzcl     // Catch:{ all -> 0x0099 }
            java.util.concurrent.ScheduledExecutorService r6 = r6.zzce     // Catch:{ all -> 0x0099 }
            com.google.android.gms.iid.zzv r0 = new com.google.android.gms.iid.zzv     // Catch:{ all -> 0x0099 }
            r0.<init>(r5)     // Catch:{ all -> 0x0099 }
            r1 = 30
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0099 }
            r6.schedule(r0, r1, r4)     // Catch:{ all -> 0x0099 }
        L_0x0097:
            monitor-exit(r5)
            return r3
        L_0x0099:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.zzt.zze(com.google.android.gms.iid.zzz):boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0056, code lost:
        r5 = r5.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0061, code lost:
        if (r5.getBoolean("unsupported", false) == false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0063, code lost:
        r1.zzd(new com.google.android.gms.iid.zzaa(4, "Not supported by GmsCore"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006f, code lost:
        r1.zzh(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0072, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzd(android.os.Message r5) {
        /*
            r4 = this;
            int r0 = r5.arg1
            java.lang.String r1 = "MessengerIpcClient"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)
            if (r1 == 0) goto L_0x0025
            java.lang.String r1 = "MessengerIpcClient"
            r2 = 41
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Received response to request: "
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r1, r2)
        L_0x0025:
            monitor-enter(r4)
            android.util.SparseArray<com.google.android.gms.iid.zzz<?>> r1 = r4.zzck     // Catch:{ all -> 0x0073 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0073 }
            com.google.android.gms.iid.zzz r1 = (com.google.android.gms.iid.zzz) r1     // Catch:{ all -> 0x0073 }
            r2 = 1
            if (r1 != 0) goto L_0x004d
            java.lang.String r5 = "MessengerIpcClient"
            r1 = 50
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
            r3.<init>(r1)     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = "Received response for unknown request: "
            java.lang.StringBuilder r1 = r3.append(r1)     // Catch:{ all -> 0x0073 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ all -> 0x0073 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0073 }
            android.util.Log.w(r5, r0)     // Catch:{ all -> 0x0073 }
            monitor-exit(r4)     // Catch:{ all -> 0x0073 }
            return r2
        L_0x004d:
            android.util.SparseArray<com.google.android.gms.iid.zzz<?>> r3 = r4.zzck     // Catch:{ all -> 0x0073 }
            r3.remove(r0)     // Catch:{ all -> 0x0073 }
            r4.zzu()     // Catch:{ all -> 0x0073 }
            monitor-exit(r4)     // Catch:{ all -> 0x0073 }
            android.os.Bundle r5 = r5.getData()
            java.lang.String r0 = "unsupported"
            r3 = 0
            boolean r0 = r5.getBoolean(r0, r3)
            if (r0 == 0) goto L_0x006f
            com.google.android.gms.iid.zzaa r5 = new com.google.android.gms.iid.zzaa
            r0 = 4
            java.lang.String r3 = "Not supported by GmsCore"
            r5.<init>(r0, r3)
            r1.zzd(r5)
            goto L_0x0072
        L_0x006f:
            r1.zzh(r5)
        L_0x0072:
            return r2
        L_0x0073:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0073 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.zzt.zzd(android.os.Message):boolean");
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        if (iBinder == null) {
            zzd(0, "Null service connection");
            return;
        }
        try {
            this.zzci = new zzy(iBinder);
            this.state = 2;
            zzt();
        } catch (RemoteException e) {
            zzd(0, e.getMessage());
        }
    }

    private final void zzt() {
        this.zzcl.zzce.execute(new zzw(this));
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        zzd(2, "Service disconnected");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzd(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        int i2 = this.state;
        if (i2 == 0) {
            throw new IllegalStateException();
        } else if (i2 == 1 || i2 == 2) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.state = 4;
            ConnectionTracker.getInstance().unbindService(this.zzcl.zzl, this);
            zzaa zzaa = new zzaa(i, str);
            for (zzz zzd : this.zzcj) {
                zzd.zzd(zzaa);
            }
            this.zzcj.clear();
            for (int i3 = 0; i3 < this.zzck.size(); i3++) {
                this.zzck.valueAt(i3).zzd(zzaa);
            }
            this.zzck.clear();
        } else if (i2 == 3) {
            this.state = 4;
        } else if (i2 != 4) {
            throw new IllegalStateException(new StringBuilder(26).append("Unknown state: ").append(this.state).toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzu() {
        if (this.state == 2 && this.zzcj.isEmpty() && this.zzck.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.state = 3;
            ConnectionTracker.getInstance().unbindService(this.zzcl.zzl, this);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzv() {
        if (this.state == 1) {
            zzd(1, "Timed out while binding");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzg(int i) {
        zzz zzz = this.zzck.get(i);
        if (zzz != null) {
            Log.w("MessengerIpcClient", new StringBuilder(31).append("Timing out request: ").append(i).toString());
            this.zzck.remove(i);
            zzz.zzd(new zzaa(3, "Timed out waiting for response"));
            zzu();
        }
    }
}
