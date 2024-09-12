package com.swmansion.reanimated.sensor;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.swmansion.reanimated.nativeProxy.SensorSetter;
import java.lang.ref.WeakReference;

public class ReanimatedSensor {
    private static final int DEFAULT_INTERVAL = 8;
    int interval;
    ReanimatedSensorListener listener;
    Sensor sensor;
    SensorManager sensorManager;
    ReanimatedSensorType sensorType;

    ReanimatedSensor(WeakReference<ReactApplicationContext> weakReference, ReanimatedSensorType reanimatedSensorType, int i, SensorSetter sensorSetter) {
        this.listener = new ReanimatedSensorListener(sensorSetter, (double) i, ((WindowManager) ((ReactApplicationContext) weakReference.get()).getSystemService("window")).getDefaultDisplay());
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) weakReference.get();
        this.sensorManager = (SensorManager) ((ReactApplicationContext) weakReference.get()).getSystemService("sensor");
        this.sensorType = reanimatedSensorType;
        if (i == -1) {
            this.interval = 8;
        } else {
            this.interval = i;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean initialize() {
        Sensor defaultSensor = this.sensorManager.getDefaultSensor(this.sensorType.getType());
        this.sensor = defaultSensor;
        if (defaultSensor == null) {
            return false;
        }
        this.sensorManager.registerListener(this.listener, defaultSensor, this.interval * 1000);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        this.sensorManager.unregisterListener(this.listener, this.sensor);
    }
}
