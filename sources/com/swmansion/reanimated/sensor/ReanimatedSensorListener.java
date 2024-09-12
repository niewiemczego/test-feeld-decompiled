package com.swmansion.reanimated.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Display;
import com.facebook.imagepipeline.common.RotationOptions;
import com.swmansion.reanimated.nativeProxy.SensorSetter;

public class ReanimatedSensorListener implements SensorEventListener {
    private final Display display;
    private final double interval;
    private double lastRead = ((double) System.currentTimeMillis());
    private float[] orientation = new float[3];
    private float[] quaternion = new float[4];
    private float[] rotation = new float[9];
    private SensorSetter setter;

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    ReanimatedSensorListener(SensorSetter sensorSetter, double d, Display display2) {
        this.setter = sensorSetter;
        this.interval = d;
        this.display = display2;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        double currentTimeMillis = (double) System.currentTimeMillis();
        if (currentTimeMillis - this.lastRead >= this.interval) {
            int type = sensorEvent.sensor.getType();
            this.lastRead = currentTimeMillis;
            int rotation2 = this.display.getRotation();
            int i = rotation2 != 1 ? rotation2 != 2 ? rotation2 != 3 ? 0 : 270 : RotationOptions.ROTATE_180 : 90;
            if (type == 2 || type == 4) {
                this.setter.sensorSetter(new float[]{sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]}, i);
                return;
            }
            switch (type) {
                case 9:
                case 10:
                    this.setter.sensorSetter(new float[]{-sensorEvent.values[0], -sensorEvent.values[1], -sensorEvent.values[2]}, i);
                    return;
                case 11:
                    SensorManager.getQuaternionFromVector(this.quaternion, sensorEvent.values);
                    SensorManager.getRotationMatrixFromVector(this.rotation, sensorEvent.values);
                    SensorManager.getOrientation(this.rotation, this.orientation);
                    float[] fArr = this.quaternion;
                    float[] fArr2 = this.orientation;
                    this.setter.sensorSetter(new float[]{fArr[1], fArr[3], -fArr[2], fArr[0], -fArr2[0], -fArr2[1], fArr2[2]}, i);
                    return;
                default:
                    throw new IllegalArgumentException("[Reanimated] Unknown sensor type.");
            }
        }
    }
}
