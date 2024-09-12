package com.facebook.appevents.codeless;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/codeless/ViewIndexingTrigger;", "Landroid/hardware/SensorEventListener;", "()V", "onShakeListener", "Lcom/facebook/appevents/codeless/ViewIndexingTrigger$OnShakeListener;", "onAccuracyChanged", "", "sensor", "Landroid/hardware/Sensor;", "accuracy", "", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "setOnShakeListener", "listener", "Companion", "OnShakeListener", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ViewIndexingTrigger.kt */
public final class ViewIndexingTrigger implements SensorEventListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final double SHAKE_THRESHOLD_GRAVITY = 2.3d;
    private OnShakeListener onShakeListener;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/facebook/appevents/codeless/ViewIndexingTrigger$OnShakeListener;", "", "onShake", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ViewIndexingTrigger.kt */
    public interface OnShakeListener {
        void onShake();
    }

    public final void setOnShakeListener(OnShakeListener onShakeListener2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.onShakeListener = onShakeListener2;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(sensorEvent, "event");
                OnShakeListener onShakeListener2 = this.onShakeListener;
                if (onShakeListener2 != null) {
                    float f = sensorEvent.values[0];
                    double d = (double) (f / 9.80665f);
                    double d2 = (double) (sensorEvent.values[1] / 9.80665f);
                    double d3 = (double) (sensorEvent.values[2] / 9.80665f);
                    if (Math.sqrt((d * d) + (d2 * d2) + (d3 * d3)) > SHAKE_THRESHOLD_GRAVITY) {
                        onShakeListener2.onShake();
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(sensor, "sensor");
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/codeless/ViewIndexingTrigger$Companion;", "", "()V", "SHAKE_THRESHOLD_GRAVITY", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ViewIndexingTrigger.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
