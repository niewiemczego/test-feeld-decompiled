package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
public abstract class zzct extends zzbx implements zzcu {
    public static zzcu asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (queryLocalInterface instanceof zzcu) {
            return (zzcu) queryLocalInterface;
        }
        return new zzcw(iBinder);
    }

    public zzct() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v9, types: [com.google.android.gms.internal.measurement.zzcv] */
    /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.gms.internal.measurement.zzcv] */
    /* JADX WARNING: type inference failed for: r3v22, types: [com.google.android.gms.internal.measurement.zzcv] */
    /* JADX WARNING: type inference failed for: r3v28, types: [com.google.android.gms.internal.measurement.zzcv] */
    /* JADX WARNING: type inference failed for: r3v33, types: [com.google.android.gms.internal.measurement.zzcv] */
    /* JADX WARNING: type inference failed for: r3v38, types: [com.google.android.gms.internal.measurement.zzdb] */
    /* JADX WARNING: type inference failed for: r3v43, types: [com.google.android.gms.internal.measurement.zzcv] */
    /* JADX WARNING: type inference failed for: r3v48, types: [com.google.android.gms.internal.measurement.zzcv] */
    /* JADX WARNING: type inference failed for: r3v53, types: [com.google.android.gms.internal.measurement.zzcv] */
    /* JADX WARNING: type inference failed for: r3v58, types: [com.google.android.gms.internal.measurement.zzcv] */
    /* JADX WARNING: type inference failed for: r3v64, types: [com.google.android.gms.internal.measurement.zzcv] */
    /* JADX WARNING: type inference failed for: r3v69, types: [com.google.android.gms.internal.measurement.zzcv] */
    /* JADX WARNING: type inference failed for: r3v76, types: [com.google.android.gms.internal.measurement.zzda] */
    /* JADX WARNING: type inference failed for: r3v81, types: [com.google.android.gms.internal.measurement.zzda] */
    /* JADX WARNING: type inference failed for: r3v86, types: [com.google.android.gms.internal.measurement.zzda] */
    /* JADX WARNING: type inference failed for: r3v91, types: [com.google.android.gms.internal.measurement.zzcv] */
    /* JADX WARNING: type inference failed for: r3v96, types: [com.google.android.gms.internal.measurement.zzcv] */
    /* JADX WARNING: type inference failed for: r3v101, types: [com.google.android.gms.internal.measurement.zzcv] */
    /* JADX WARNING: type inference failed for: r3v106 */
    /* JADX WARNING: type inference failed for: r3v107 */
    /* JADX WARNING: type inference failed for: r3v108 */
    /* JADX WARNING: type inference failed for: r3v109 */
    /* JADX WARNING: type inference failed for: r3v110 */
    /* JADX WARNING: type inference failed for: r3v111 */
    /* JADX WARNING: type inference failed for: r3v112 */
    /* JADX WARNING: type inference failed for: r3v113 */
    /* JADX WARNING: type inference failed for: r3v114 */
    /* JADX WARNING: type inference failed for: r3v115 */
    /* JADX WARNING: type inference failed for: r3v116 */
    /* JADX WARNING: type inference failed for: r3v117 */
    /* JADX WARNING: type inference failed for: r3v118 */
    /* JADX WARNING: type inference failed for: r3v119 */
    /* JADX WARNING: type inference failed for: r3v120 */
    /* JADX WARNING: type inference failed for: r3v121 */
    /* JADX WARNING: type inference failed for: r3v122 */
    /* JADX WARNING: type inference failed for: r3v123 */
    /* JADX WARNING: type inference failed for: r3v124 */
    /* JADX WARNING: type inference failed for: r3v125 */
    /* JADX WARNING: type inference failed for: r3v126 */
    /* JADX WARNING: type inference failed for: r3v127 */
    /* JADX WARNING: type inference failed for: r3v128 */
    /* JADX WARNING: type inference failed for: r3v129 */
    /* JADX WARNING: type inference failed for: r3v130 */
    /* JADX WARNING: type inference failed for: r3v131 */
    /* JADX WARNING: type inference failed for: r3v132 */
    /* JADX WARNING: type inference failed for: r3v133 */
    /* JADX WARNING: type inference failed for: r3v134 */
    /* JADX WARNING: type inference failed for: r3v135 */
    /* JADX WARNING: type inference failed for: r3v136 */
    /* JADX WARNING: type inference failed for: r3v137 */
    /* JADX WARNING: type inference failed for: r3v138 */
    /* JADX WARNING: type inference failed for: r3v139 */
    /* JADX WARNING: type inference failed for: r3v140 */
    /* JADX WARNING: type inference failed for: r3v141 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r11, android.os.Parcel r12, android.os.Parcel r13, int r14) throws android.os.RemoteException {
        /*
            r10 = this;
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IEventHandlerProxy"
            java.lang.String r2 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            r3 = 0
            switch(r11) {
                case 1: goto L_0x04b0;
                case 2: goto L_0x048c;
                case 3: goto L_0x0453;
                case 4: goto L_0x0432;
                case 5: goto L_0x0406;
                case 6: goto L_0x03e2;
                case 7: goto L_0x03d2;
                case 8: goto L_0x03be;
                case 9: goto L_0x03a6;
                case 10: goto L_0x037e;
                case 11: goto L_0x036e;
                case 12: goto L_0x0362;
                case 13: goto L_0x0356;
                case 14: goto L_0x034a;
                case 15: goto L_0x032d;
                case 16: goto L_0x030d;
                case 17: goto L_0x02ed;
                case 18: goto L_0x02cb;
                case 19: goto L_0x02ab;
                case 20: goto L_0x028b;
                case 21: goto L_0x026b;
                case 22: goto L_0x024b;
                case 23: goto L_0x023b;
                case 24: goto L_0x022b;
                case 25: goto L_0x0217;
                case 26: goto L_0x0203;
                case 27: goto L_0x01e7;
                case 28: goto L_0x01d3;
                case 29: goto L_0x01bf;
                case 30: goto L_0x01ab;
                case 31: goto L_0x017f;
                case 32: goto L_0x0153;
                case 33: goto L_0x012a;
                case 34: goto L_0x010a;
                case 35: goto L_0x00ea;
                case 36: goto L_0x00ca;
                case 37: goto L_0x00be;
                case 38: goto L_0x009a;
                case 39: goto L_0x008e;
                case 40: goto L_0x006e;
                case 41: goto L_0x0008;
                case 42: goto L_0x005e;
                case 43: goto L_0x0052;
                case 44: goto L_0x003e;
                case 45: goto L_0x002a;
                case 46: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            r0 = 0
            return r0
        L_0x000a:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            goto L_0x0022
        L_0x0011:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcv
            if (r3 == 0) goto L_0x001d
            r3 = r2
            com.google.android.gms.internal.measurement.zzcv r3 = (com.google.android.gms.internal.measurement.zzcv) r3
            goto L_0x0022
        L_0x001d:
            com.google.android.gms.internal.measurement.zzcx r3 = new com.google.android.gms.internal.measurement.zzcx
            r3.<init>(r1)
        L_0x0022:
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.getSessionId(r3)
            goto L_0x04ca
        L_0x002a:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.zzbw.zza((android.os.Parcel) r12, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.setConsentThirdParty(r1, r2)
            goto L_0x04ca
        L_0x003e:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.zzbw.zza((android.os.Parcel) r12, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.setConsent(r1, r2)
            goto L_0x04ca
        L_0x0052:
            long r1 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.clearMeasurementEnabled(r1)
            goto L_0x04ca
        L_0x005e:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.zzbw.zza((android.os.Parcel) r12, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.setDefaultEventParameters(r1)
            goto L_0x04ca
        L_0x006e:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x0075
            goto L_0x0086
        L_0x0075:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcv
            if (r3 == 0) goto L_0x0081
            r3 = r2
            com.google.android.gms.internal.measurement.zzcv r3 = (com.google.android.gms.internal.measurement.zzcv) r3
            goto L_0x0086
        L_0x0081:
            com.google.android.gms.internal.measurement.zzcx r3 = new com.google.android.gms.internal.measurement.zzcx
            r3.<init>(r1)
        L_0x0086:
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.isDataCollectionEnabled(r3)
            goto L_0x04ca
        L_0x008e:
            boolean r1 = com.google.android.gms.internal.measurement.zzbw.zzc(r12)
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.setDataCollectionEnabled(r1)
            goto L_0x04ca
        L_0x009a:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x00a1
            goto L_0x00b2
        L_0x00a1:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcv
            if (r3 == 0) goto L_0x00ad
            r3 = r2
            com.google.android.gms.internal.measurement.zzcv r3 = (com.google.android.gms.internal.measurement.zzcv) r3
            goto L_0x00b2
        L_0x00ad:
            com.google.android.gms.internal.measurement.zzcx r3 = new com.google.android.gms.internal.measurement.zzcx
            r3.<init>(r1)
        L_0x00b2:
            int r1 = r12.readInt()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.getTestFlag(r3, r1)
            goto L_0x04ca
        L_0x00be:
            java.util.HashMap r1 = com.google.android.gms.internal.measurement.zzbw.zza(r12)
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.initForTests(r1)
            goto L_0x04ca
        L_0x00ca:
            android.os.IBinder r2 = r12.readStrongBinder()
            if (r2 != 0) goto L_0x00d1
            goto L_0x00e2
        L_0x00d1:
            android.os.IInterface r1 = r2.queryLocalInterface(r1)
            boolean r3 = r1 instanceof com.google.android.gms.internal.measurement.zzda
            if (r3 == 0) goto L_0x00dd
            r3 = r1
            com.google.android.gms.internal.measurement.zzda r3 = (com.google.android.gms.internal.measurement.zzda) r3
            goto L_0x00e2
        L_0x00dd:
            com.google.android.gms.internal.measurement.zzdc r3 = new com.google.android.gms.internal.measurement.zzdc
            r3.<init>(r2)
        L_0x00e2:
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.unregisterOnMeasurementEventListener(r3)
            goto L_0x04ca
        L_0x00ea:
            android.os.IBinder r2 = r12.readStrongBinder()
            if (r2 != 0) goto L_0x00f1
            goto L_0x0102
        L_0x00f1:
            android.os.IInterface r1 = r2.queryLocalInterface(r1)
            boolean r3 = r1 instanceof com.google.android.gms.internal.measurement.zzda
            if (r3 == 0) goto L_0x00fd
            r3 = r1
            com.google.android.gms.internal.measurement.zzda r3 = (com.google.android.gms.internal.measurement.zzda) r3
            goto L_0x0102
        L_0x00fd:
            com.google.android.gms.internal.measurement.zzdc r3 = new com.google.android.gms.internal.measurement.zzdc
            r3.<init>(r2)
        L_0x0102:
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.registerOnMeasurementEventListener(r3)
            goto L_0x04ca
        L_0x010a:
            android.os.IBinder r2 = r12.readStrongBinder()
            if (r2 != 0) goto L_0x0111
            goto L_0x0122
        L_0x0111:
            android.os.IInterface r1 = r2.queryLocalInterface(r1)
            boolean r3 = r1 instanceof com.google.android.gms.internal.measurement.zzda
            if (r3 == 0) goto L_0x011d
            r3 = r1
            com.google.android.gms.internal.measurement.zzda r3 = (com.google.android.gms.internal.measurement.zzda) r3
            goto L_0x0122
        L_0x011d:
            com.google.android.gms.internal.measurement.zzdc r3 = new com.google.android.gms.internal.measurement.zzdc
            r3.<init>(r2)
        L_0x0122:
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.setEventInterceptor(r3)
            goto L_0x04ca
        L_0x012a:
            int r1 = r12.readInt()
            java.lang.String r2 = r12.readString()
            android.os.IBinder r3 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            android.os.IBinder r4 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r4)
            android.os.IBinder r5 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r5)
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r0 = r10
            r0.logHealthData(r1, r2, r3, r4, r5)
            goto L_0x04ca
        L_0x0153:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.zzbw.zza((android.os.Parcel) r12, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            android.os.IBinder r4 = r12.readStrongBinder()
            if (r4 != 0) goto L_0x0162
            goto L_0x0173
        L_0x0162:
            android.os.IInterface r2 = r4.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcv
            if (r3 == 0) goto L_0x016e
            r3 = r2
            com.google.android.gms.internal.measurement.zzcv r3 = (com.google.android.gms.internal.measurement.zzcv) r3
            goto L_0x0173
        L_0x016e:
            com.google.android.gms.internal.measurement.zzcx r3 = new com.google.android.gms.internal.measurement.zzcx
            r3.<init>(r4)
        L_0x0173:
            long r4 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.performAction(r1, r3, r4)
            goto L_0x04ca
        L_0x017f:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            android.os.IBinder r4 = r12.readStrongBinder()
            if (r4 != 0) goto L_0x018e
            goto L_0x019f
        L_0x018e:
            android.os.IInterface r2 = r4.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcv
            if (r3 == 0) goto L_0x019a
            r3 = r2
            com.google.android.gms.internal.measurement.zzcv r3 = (com.google.android.gms.internal.measurement.zzcv) r3
            goto L_0x019f
        L_0x019a:
            com.google.android.gms.internal.measurement.zzcx r3 = new com.google.android.gms.internal.measurement.zzcx
            r3.<init>(r4)
        L_0x019f:
            long r4 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.onActivitySaveInstanceState(r1, r3, r4)
            goto L_0x04ca
        L_0x01ab:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.onActivityResumed(r1, r2)
            goto L_0x04ca
        L_0x01bf:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.onActivityPaused(r1, r2)
            goto L_0x04ca
        L_0x01d3:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.onActivityDestroyed(r1, r2)
            goto L_0x04ca
        L_0x01e7:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.zzbw.zza((android.os.Parcel) r12, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            long r3 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.onActivityCreated(r1, r2, r3)
            goto L_0x04ca
        L_0x0203:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.onActivityStopped(r1, r2)
            goto L_0x04ca
        L_0x0217:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.onActivityStarted(r1, r2)
            goto L_0x04ca
        L_0x022b:
            java.lang.String r1 = r12.readString()
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.endAdUnitExposure(r1, r2)
            goto L_0x04ca
        L_0x023b:
            java.lang.String r1 = r12.readString()
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.beginAdUnitExposure(r1, r2)
            goto L_0x04ca
        L_0x024b:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x0252
            goto L_0x0263
        L_0x0252:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcv
            if (r3 == 0) goto L_0x025e
            r3 = r2
            com.google.android.gms.internal.measurement.zzcv r3 = (com.google.android.gms.internal.measurement.zzcv) r3
            goto L_0x0263
        L_0x025e:
            com.google.android.gms.internal.measurement.zzcx r3 = new com.google.android.gms.internal.measurement.zzcx
            r3.<init>(r1)
        L_0x0263:
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.generateEventId(r3)
            goto L_0x04ca
        L_0x026b:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x0272
            goto L_0x0283
        L_0x0272:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcv
            if (r3 == 0) goto L_0x027e
            r3 = r2
            com.google.android.gms.internal.measurement.zzcv r3 = (com.google.android.gms.internal.measurement.zzcv) r3
            goto L_0x0283
        L_0x027e:
            com.google.android.gms.internal.measurement.zzcx r3 = new com.google.android.gms.internal.measurement.zzcx
            r3.<init>(r1)
        L_0x0283:
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.getGmpAppId(r3)
            goto L_0x04ca
        L_0x028b:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x0292
            goto L_0x02a3
        L_0x0292:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcv
            if (r3 == 0) goto L_0x029e
            r3 = r2
            com.google.android.gms.internal.measurement.zzcv r3 = (com.google.android.gms.internal.measurement.zzcv) r3
            goto L_0x02a3
        L_0x029e:
            com.google.android.gms.internal.measurement.zzcx r3 = new com.google.android.gms.internal.measurement.zzcx
            r3.<init>(r1)
        L_0x02a3:
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.getAppInstanceId(r3)
            goto L_0x04ca
        L_0x02ab:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x02b2
            goto L_0x02c3
        L_0x02b2:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcv
            if (r3 == 0) goto L_0x02be
            r3 = r2
            com.google.android.gms.internal.measurement.zzcv r3 = (com.google.android.gms.internal.measurement.zzcv) r3
            goto L_0x02c3
        L_0x02be:
            com.google.android.gms.internal.measurement.zzcx r3 = new com.google.android.gms.internal.measurement.zzcx
            r3.<init>(r1)
        L_0x02c3:
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.getCachedAppInstanceId(r3)
            goto L_0x04ca
        L_0x02cb:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x02d2
            goto L_0x02e5
        L_0x02d2:
            java.lang.String r2 = "com.google.android.gms.measurement.api.internal.IStringProvider"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzdb
            if (r3 == 0) goto L_0x02e0
            r3 = r2
            com.google.android.gms.internal.measurement.zzdb r3 = (com.google.android.gms.internal.measurement.zzdb) r3
            goto L_0x02e5
        L_0x02e0:
            com.google.android.gms.internal.measurement.zzde r3 = new com.google.android.gms.internal.measurement.zzde
            r3.<init>(r1)
        L_0x02e5:
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.setInstanceIdProvider(r3)
            goto L_0x04ca
        L_0x02ed:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x02f4
            goto L_0x0305
        L_0x02f4:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcv
            if (r3 == 0) goto L_0x0300
            r3 = r2
            com.google.android.gms.internal.measurement.zzcv r3 = (com.google.android.gms.internal.measurement.zzcv) r3
            goto L_0x0305
        L_0x0300:
            com.google.android.gms.internal.measurement.zzcx r3 = new com.google.android.gms.internal.measurement.zzcx
            r3.<init>(r1)
        L_0x0305:
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.getCurrentScreenClass(r3)
            goto L_0x04ca
        L_0x030d:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x0314
            goto L_0x0325
        L_0x0314:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcv
            if (r3 == 0) goto L_0x0320
            r3 = r2
            com.google.android.gms.internal.measurement.zzcv r3 = (com.google.android.gms.internal.measurement.zzcv) r3
            goto L_0x0325
        L_0x0320:
            com.google.android.gms.internal.measurement.zzcx r3 = new com.google.android.gms.internal.measurement.zzcx
            r3.<init>(r1)
        L_0x0325:
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.getCurrentScreenName(r3)
            goto L_0x04ca
        L_0x032d:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            java.lang.String r2 = r12.readString()
            java.lang.String r3 = r12.readString()
            long r4 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r0 = r10
            r0.setCurrentScreen(r1, r2, r3, r4)
            goto L_0x04ca
        L_0x034a:
            long r1 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.setSessionTimeoutDuration(r1)
            goto L_0x04ca
        L_0x0356:
            long r1 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.setMinimumSessionDuration(r1)
            goto L_0x04ca
        L_0x0362:
            long r1 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.resetAnalyticsData(r1)
            goto L_0x04ca
        L_0x036e:
            boolean r1 = com.google.android.gms.internal.measurement.zzbw.zzc(r12)
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.setMeasurementEnabled(r1, r2)
            goto L_0x04ca
        L_0x037e:
            java.lang.String r1 = r12.readString()
            java.lang.String r4 = r12.readString()
            android.os.IBinder r5 = r12.readStrongBinder()
            if (r5 != 0) goto L_0x038d
            goto L_0x039e
        L_0x038d:
            android.os.IInterface r2 = r5.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcv
            if (r3 == 0) goto L_0x0399
            r3 = r2
            com.google.android.gms.internal.measurement.zzcv r3 = (com.google.android.gms.internal.measurement.zzcv) r3
            goto L_0x039e
        L_0x0399:
            com.google.android.gms.internal.measurement.zzcx r3 = new com.google.android.gms.internal.measurement.zzcx
            r3.<init>(r5)
        L_0x039e:
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.getConditionalUserProperties(r1, r4, r3)
            goto L_0x04ca
        L_0x03a6:
            java.lang.String r1 = r12.readString()
            java.lang.String r2 = r12.readString()
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.measurement.zzbw.zza((android.os.Parcel) r12, r3)
            android.os.Bundle r3 = (android.os.Bundle) r3
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.clearConditionalUserProperty(r1, r2, r3)
            goto L_0x04ca
        L_0x03be:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.zzbw.zza((android.os.Parcel) r12, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.setConditionalUserProperty(r1, r2)
            goto L_0x04ca
        L_0x03d2:
            java.lang.String r1 = r12.readString()
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.setUserId(r1, r2)
            goto L_0x04ca
        L_0x03e2:
            java.lang.String r1 = r12.readString()
            android.os.IBinder r4 = r12.readStrongBinder()
            if (r4 != 0) goto L_0x03ed
            goto L_0x03fe
        L_0x03ed:
            android.os.IInterface r2 = r4.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcv
            if (r3 == 0) goto L_0x03f9
            r3 = r2
            com.google.android.gms.internal.measurement.zzcv r3 = (com.google.android.gms.internal.measurement.zzcv) r3
            goto L_0x03fe
        L_0x03f9:
            com.google.android.gms.internal.measurement.zzcx r3 = new com.google.android.gms.internal.measurement.zzcx
            r3.<init>(r4)
        L_0x03fe:
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.getMaxUserProperties(r1, r3)
            goto L_0x04ca
        L_0x0406:
            java.lang.String r1 = r12.readString()
            java.lang.String r4 = r12.readString()
            boolean r5 = com.google.android.gms.internal.measurement.zzbw.zzc(r12)
            android.os.IBinder r6 = r12.readStrongBinder()
            if (r6 != 0) goto L_0x0419
            goto L_0x042a
        L_0x0419:
            android.os.IInterface r2 = r6.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcv
            if (r3 == 0) goto L_0x0425
            r3 = r2
            com.google.android.gms.internal.measurement.zzcv r3 = (com.google.android.gms.internal.measurement.zzcv) r3
            goto L_0x042a
        L_0x0425:
            com.google.android.gms.internal.measurement.zzcx r3 = new com.google.android.gms.internal.measurement.zzcx
            r3.<init>(r6)
        L_0x042a:
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.getUserProperties(r1, r4, r5, r3)
            goto L_0x04ca
        L_0x0432:
            java.lang.String r1 = r12.readString()
            java.lang.String r2 = r12.readString()
            android.os.IBinder r3 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            boolean r4 = com.google.android.gms.internal.measurement.zzbw.zzc(r12)
            long r5 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r0 = r10
            r0.setUserProperty(r1, r2, r3, r4, r5)
            goto L_0x04ca
        L_0x0453:
            java.lang.String r1 = r12.readString()
            java.lang.String r4 = r12.readString()
            android.os.Parcelable$Creator r5 = android.os.Bundle.CREATOR
            android.os.Parcelable r5 = com.google.android.gms.internal.measurement.zzbw.zza((android.os.Parcel) r12, r5)
            android.os.Bundle r5 = (android.os.Bundle) r5
            android.os.IBinder r6 = r12.readStrongBinder()
            if (r6 != 0) goto L_0x046b
            r6 = r3
            goto L_0x047c
        L_0x046b:
            android.os.IInterface r2 = r6.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcv
            if (r3 == 0) goto L_0x0476
            com.google.android.gms.internal.measurement.zzcv r2 = (com.google.android.gms.internal.measurement.zzcv) r2
            goto L_0x047b
        L_0x0476:
            com.google.android.gms.internal.measurement.zzcx r2 = new com.google.android.gms.internal.measurement.zzcx
            r2.<init>(r6)
        L_0x047b:
            r6 = r2
        L_0x047c:
            long r8 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r0 = r10
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r8
            r0.logEventAndBundle(r1, r2, r3, r4, r5)
            goto L_0x04ca
        L_0x048c:
            java.lang.String r1 = r12.readString()
            java.lang.String r2 = r12.readString()
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.measurement.zzbw.zza((android.os.Parcel) r12, r3)
            android.os.Bundle r3 = (android.os.Bundle) r3
            boolean r4 = com.google.android.gms.internal.measurement.zzbw.zzc(r12)
            boolean r5 = com.google.android.gms.internal.measurement.zzbw.zzc(r12)
            long r6 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r0 = r10
            r0.logEvent(r1, r2, r3, r4, r5, r6)
            goto L_0x04ca
        L_0x04b0:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.zzdd> r2 = com.google.android.gms.internal.measurement.zzdd.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.zzbw.zza((android.os.Parcel) r12, r2)
            com.google.android.gms.internal.measurement.zzdd r2 = (com.google.android.gms.internal.measurement.zzdd) r2
            long r3 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbw.zzb(r12)
            r10.initialize(r1, r2, r3)
        L_0x04ca:
            r13.writeNoException()
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzct.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
