package com.appsflyer.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

final class AFa1jSDK implements SensorEventListener {
    private final long[] AFInAppEventParameterName = new long[2];
    private final int AFInAppEventType;
    private final float[][] AFKeystoreWrapper = new float[2][];
    private double AFLogger;
    private Executor afDebugLog;
    private final int afErrorLog;
    private long afInfoLog;
    private final String valueOf;
    private final String values;

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    AFa1jSDK(Sensor sensor) {
        int type = sensor.getType();
        this.AFInAppEventType = type;
        String name = sensor.getName();
        String str = "";
        name = name == null ? str : name;
        this.valueOf = name;
        String vendor = sensor.getVendor();
        str = vendor != null ? vendor : str;
        this.values = str;
        this.afErrorLog = ((((type + 31) * 31) + name.hashCode()) * 31) + str.hashCode();
    }

    private synchronized Executor AFInAppEventType() {
        if (this.afDebugLog == null) {
            this.afDebugLog = Executors.newSingleThreadExecutor();
        }
        return this.afDebugLog;
    }

    private static double valueOf(float[] fArr, float[] fArr2) {
        int min = Math.min(fArr.length, fArr2.length);
        double d = 0.0d;
        for (int i = 0; i < min; i++) {
            d += StrictMath.pow((double) (fArr[i] - fArr2[i]), 2.0d);
        }
        return Math.sqrt(d);
    }

    private static List<Float> AFInAppEventParameterName(float[] fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float valueOf2 : fArr) {
            arrayList.add(Float.valueOf(valueOf2));
        }
        return arrayList;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AFInAppEventType().execute(new AFa1jSDK$$ExternalSyntheticLambda0(this, sensorEvent));
        } else {
            AFInAppEventType(sensorEvent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: valueOf */
    public void AFInAppEventType(SensorEvent sensorEvent) {
        long j = sensorEvent.timestamp;
        float[] fArr = sensorEvent.values;
        long currentTimeMillis = System.currentTimeMillis();
        float[][] fArr2 = this.AFKeystoreWrapper;
        float[] fArr3 = fArr2[0];
        if (fArr3 == null) {
            fArr2[0] = Arrays.copyOf(fArr, fArr.length);
            this.AFInAppEventParameterName[0] = currentTimeMillis;
            return;
        }
        float[] fArr4 = fArr2[1];
        if (fArr4 == null) {
            float[] copyOf = Arrays.copyOf(fArr, fArr.length);
            this.AFKeystoreWrapper[1] = copyOf;
            this.AFInAppEventParameterName[1] = currentTimeMillis;
            this.AFLogger = valueOf(fArr3, copyOf);
        } else if (50000000 <= j - this.afInfoLog) {
            this.afInfoLog = j;
            if (Arrays.equals(fArr4, fArr)) {
                this.AFInAppEventParameterName[1] = currentTimeMillis;
                return;
            }
            double valueOf2 = valueOf(fArr3, fArr);
            if (valueOf2 > this.AFLogger) {
                this.AFKeystoreWrapper[1] = Arrays.copyOf(fArr, fArr.length);
                this.AFInAppEventParameterName[1] = currentTimeMillis;
                this.AFLogger = valueOf2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void AFInAppEventType(Map<AFa1jSDK, Map<String, Object>> map, boolean z) {
        if (AFKeystoreWrapper()) {
            map.put(this, AFInAppEventParameterName());
            if (z) {
                int length = this.AFKeystoreWrapper.length;
                for (int i = 0; i < length; i++) {
                    this.AFKeystoreWrapper[i] = null;
                }
                int length2 = this.AFInAppEventParameterName.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    this.AFInAppEventParameterName[i2] = 0;
                }
                this.AFLogger = 0.0d;
                this.afInfoLog = 0;
            }
        } else if (!map.containsKey(this)) {
            map.put(this, AFInAppEventParameterName());
        }
    }

    private boolean valueOf(int i, String str, String str2) {
        return this.AFInAppEventType == i && this.valueOf.equals(str) && this.values.equals(str2);
    }

    private Map<String, Object> AFInAppEventParameterName() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(7);
        concurrentHashMap.put("sT", Integer.valueOf(this.AFInAppEventType));
        concurrentHashMap.put("sN", this.valueOf);
        concurrentHashMap.put("sV", this.values);
        float[] fArr = this.AFKeystoreWrapper[0];
        if (fArr != null) {
            concurrentHashMap.put("sVS", AFInAppEventParameterName(fArr));
        }
        float[] fArr2 = this.AFKeystoreWrapper[1];
        if (fArr2 != null) {
            concurrentHashMap.put("sVE", AFInAppEventParameterName(fArr2));
        }
        return concurrentHashMap;
    }

    private boolean AFKeystoreWrapper() {
        return this.AFKeystoreWrapper[0] != null;
    }

    public final int hashCode() {
        return this.afErrorLog;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AFa1jSDK)) {
            return false;
        }
        AFa1jSDK aFa1jSDK = (AFa1jSDK) obj;
        return valueOf(aFa1jSDK.AFInAppEventType, aFa1jSDK.valueOf, aFa1jSDK.values);
    }
}
