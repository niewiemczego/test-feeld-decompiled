package io.sentry.android.core;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import io.sentry.Breadcrumb;
import io.sentry.Hint;
import io.sentry.IHub;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.TypeCheckHint;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.io.IOException;

public final class TempSensorBreadcrumbsIntegration implements Integration, Closeable, SensorEventListener {
    private final Context context;
    private IHub hub;
    private boolean isClosed = false;
    private SentryAndroidOptions options;
    SensorManager sensorManager;
    private final Object startLock = new Object();

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public TempSensorBreadcrumbsIntegration(Context context2) {
        this.context = (Context) Objects.requireNonNull(context2, "Context is required");
    }

    public void register(IHub iHub, SentryOptions sentryOptions) {
        this.hub = (IHub) Objects.requireNonNull(iHub, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) Objects.requireNonNull(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.options = sentryAndroidOptions;
        sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, "enableSystemEventsBreadcrumbs enabled: %s", Boolean.valueOf(this.options.isEnableSystemEventBreadcrumbs()));
        if (this.options.isEnableSystemEventBreadcrumbs()) {
            try {
                sentryOptions.getExecutorService().submit((Runnable) new TempSensorBreadcrumbsIntegration$$ExternalSyntheticLambda0(this, sentryOptions));
            } catch (Throwable th) {
                sentryOptions.getLogger().log(SentryLevel.DEBUG, "Failed to start TempSensorBreadcrumbsIntegration on executor thread.", th);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$register$0$io-sentry-android-core-TempSensorBreadcrumbsIntegration  reason: not valid java name */
    public /* synthetic */ void m905lambda$register$0$iosentryandroidcoreTempSensorBreadcrumbsIntegration(SentryOptions sentryOptions) {
        synchronized (this.startLock) {
            if (!this.isClosed) {
                startSensorListener(sentryOptions);
            }
        }
    }

    private void startSensorListener(SentryOptions sentryOptions) {
        try {
            SensorManager sensorManager2 = (SensorManager) this.context.getSystemService("sensor");
            this.sensorManager = sensorManager2;
            if (sensorManager2 != null) {
                Sensor defaultSensor = sensorManager2.getDefaultSensor(13);
                if (defaultSensor != null) {
                    this.sensorManager.registerListener(this, defaultSensor, 3);
                    sentryOptions.getLogger().log(SentryLevel.DEBUG, "TempSensorBreadcrumbsIntegration installed.", new Object[0]);
                    IntegrationUtils.addIntegrationToSdkVersion(getClass());
                    return;
                }
                sentryOptions.getLogger().log(SentryLevel.INFO, "TYPE_AMBIENT_TEMPERATURE is not available.", new Object[0]);
                return;
            }
            sentryOptions.getLogger().log(SentryLevel.INFO, "SENSOR_SERVICE is not available.", new Object[0]);
        } catch (Throwable th) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, th, "Failed to init. the SENSOR_SERVICE.", new Object[0]);
        }
    }

    public void close() throws IOException {
        synchronized (this.startLock) {
            this.isClosed = true;
        }
        SensorManager sensorManager2 = this.sensorManager;
        if (sensorManager2 != null) {
            sensorManager2.unregisterListener(this);
            this.sensorManager = null;
            SentryAndroidOptions sentryAndroidOptions = this.options;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, "TempSensorBreadcrumbsIntegration removed.", new Object[0]);
            }
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr != null && fArr.length != 0 && fArr[0] != 0.0f && this.hub != null) {
            Breadcrumb breadcrumb = new Breadcrumb();
            breadcrumb.setType("system");
            breadcrumb.setCategory("device.event");
            breadcrumb.setData("action", "TYPE_AMBIENT_TEMPERATURE");
            breadcrumb.setData("accuracy", Integer.valueOf(sensorEvent.accuracy));
            breadcrumb.setData("timestamp", Long.valueOf(sensorEvent.timestamp));
            breadcrumb.setLevel(SentryLevel.INFO);
            breadcrumb.setData("degree", Float.valueOf(sensorEvent.values[0]));
            Hint hint = new Hint();
            hint.set(TypeCheckHint.ANDROID_SENSOR_EVENT, sensorEvent);
            this.hub.addBreadcrumb(breadcrumb, hint);
        }
    }
}
