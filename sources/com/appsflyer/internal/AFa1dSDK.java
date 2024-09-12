package com.appsflyer.internal;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.appsflyer.AFLogger;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class AFa1dSDK {
    private static final BitSet AFLogger;
    private static volatile AFa1dSDK afDebugLog;
    boolean AFInAppEventParameterName;
    final Handler AFInAppEventType;
    final Object AFKeystoreWrapper = new Object();
    /* access modifiers changed from: private */
    public final SensorManager AFLogger$LogLevel;
    /* access modifiers changed from: private */
    public boolean AFVersionDeclaration;
    /* access modifiers changed from: private */
    public final Map<AFa1jSDK, Map<String, Object>> afErrorLog;
    private long afErrorLogForExcManagerOnly;
    /* access modifiers changed from: private */
    public final Map<AFa1jSDK, AFa1jSDK> afInfoLog;
    final Runnable afRDLog;
    /* access modifiers changed from: private */
    public final Runnable afWarnLog;
    /* access modifiers changed from: private */
    public int getLevel;
    final Runnable valueOf;
    final Runnable values;

    static {
        BitSet bitSet = new BitSet(6);
        AFLogger = bitSet;
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(4);
    }

    private AFa1dSDK(SensorManager sensorManager, Handler handler) {
        BitSet bitSet = AFLogger;
        this.afInfoLog = new HashMap(bitSet.size());
        this.afErrorLog = new ConcurrentHashMap(bitSet.size());
        this.values = new Runnable() {
            public final void run() {
                synchronized (AFa1dSDK.this.AFKeystoreWrapper) {
                    AFa1dSDK aFa1dSDK = AFa1dSDK.this;
                    aFa1dSDK.AFInAppEventType.post(new Runnable() {
                        public final void run() {
                            try {
                                for (Sensor next : AFa1dSDK.this.AFLogger$LogLevel.getSensorList(-1)) {
                                    if (AFa1dSDK.AFKeystoreWrapper(next.getType())) {
                                        AFa1jSDK aFa1jSDK = new AFa1jSDK(next);
                                        if (!AFa1dSDK.this.afInfoLog.containsKey(aFa1jSDK)) {
                                            AFa1dSDK.this.afInfoLog.put(aFa1jSDK, aFa1jSDK);
                                        }
                                        AFa1dSDK.this.AFLogger$LogLevel.registerListener((SensorEventListener) AFa1dSDK.this.afInfoLog.get(aFa1jSDK), next, 0, AFa1dSDK.this.AFInAppEventType);
                                    }
                                }
                            } catch (Throwable th) {
                                AFLogger.afErrorLogForExcManagerOnly("registerListeners error", th);
                            }
                            boolean unused = AFa1dSDK.this.AFVersionDeclaration = true;
                        }
                    });
                    AFa1dSDK.this.AFInAppEventType.postDelayed(AFa1dSDK.this.afWarnLog, 100);
                    AFa1dSDK.this.AFInAppEventParameterName = true;
                }
            }
        };
        this.valueOf = new Runnable() {
            public final void run() {
                synchronized (AFa1dSDK.this.AFKeystoreWrapper) {
                    AFa1dSDK aFa1dSDK = AFa1dSDK.this;
                    aFa1dSDK.AFInAppEventType.post(new Runnable() {
                        public final void run() {
                            try {
                                if (!AFa1dSDK.this.afInfoLog.isEmpty()) {
                                    for (AFa1jSDK aFa1jSDK : AFa1dSDK.this.afInfoLog.values()) {
                                        AFa1dSDK.this.AFLogger$LogLevel.unregisterListener(aFa1jSDK);
                                        aFa1jSDK.AFInAppEventType(AFa1dSDK.this.afErrorLog, true);
                                    }
                                }
                            } catch (Throwable th) {
                                AFLogger.afErrorLogForExcManagerOnly("error while unregistering listeners", th);
                            }
                            int unused = AFa1dSDK.this.getLevel = 0;
                            boolean unused2 = AFa1dSDK.this.AFVersionDeclaration = false;
                        }
                    });
                }
            }
        };
        this.afRDLog = new Runnable() {
            public final void run() {
                synchronized (AFa1dSDK.this.AFKeystoreWrapper) {
                    if (AFa1dSDK.this.AFInAppEventParameterName) {
                        AFa1dSDK.this.AFInAppEventType.removeCallbacks(AFa1dSDK.this.values);
                        AFa1dSDK.this.AFInAppEventType.removeCallbacks(AFa1dSDK.this.valueOf);
                        AFa1dSDK aFa1dSDK = AFa1dSDK.this;
                        aFa1dSDK.AFInAppEventType.post(new Runnable() {
                            public final void run() {
                                try {
                                    if (!AFa1dSDK.this.afInfoLog.isEmpty()) {
                                        for (AFa1jSDK aFa1jSDK : AFa1dSDK.this.afInfoLog.values()) {
                                            AFa1dSDK.this.AFLogger$LogLevel.unregisterListener(aFa1jSDK);
                                            aFa1jSDK.AFInAppEventType(AFa1dSDK.this.afErrorLog, true);
                                        }
                                    }
                                } catch (Throwable th) {
                                    AFLogger.afErrorLogForExcManagerOnly("error while unregistering listeners", th);
                                }
                                int unused = AFa1dSDK.this.getLevel = 0;
                                boolean unused2 = AFa1dSDK.this.AFVersionDeclaration = false;
                            }
                        });
                        AFa1dSDK.this.AFInAppEventParameterName = false;
                    }
                }
            }
        };
        this.getLevel = 1;
        this.afErrorLogForExcManagerOnly = 0;
        this.afWarnLog = new Runnable() {
            public final void run() {
                synchronized (AFa1dSDK.this.AFKeystoreWrapper) {
                    if (AFa1dSDK.this.getLevel == 0) {
                        int unused = AFa1dSDK.this.getLevel = 1;
                    }
                    AFa1dSDK.this.AFInAppEventType.postDelayed(AFa1dSDK.this.valueOf, ((long) AFa1dSDK.this.getLevel) * 500);
                }
            }
        };
        this.AFLogger$LogLevel = sensorManager;
        this.AFInAppEventType = handler;
    }

    static AFa1dSDK AFInAppEventType(Context context) {
        if (afDebugLog != null) {
            return afDebugLog;
        }
        HandlerThread handlerThread = new HandlerThread("internal");
        handlerThread.start();
        return AFKeystoreWrapper((SensorManager) context.getApplicationContext().getSystemService("sensor"), new Handler(handlerThread.getLooper()));
    }

    private static AFa1dSDK AFKeystoreWrapper(SensorManager sensorManager, Handler handler) {
        if (afDebugLog == null) {
            synchronized (AFa1dSDK.class) {
                if (afDebugLog == null) {
                    afDebugLog = new AFa1dSDK(sensorManager, handler);
                }
            }
        }
        return afDebugLog;
    }

    /* access modifiers changed from: private */
    public static boolean AFKeystoreWrapper(int i) {
        return i >= 0 && AFLogger.get(i);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void AFInAppEventParameterName() {
        this.AFInAppEventType.post(this.afRDLog);
    }

    /* access modifiers changed from: package-private */
    public final List<Map<String, Object>> AFKeystoreWrapper() {
        for (AFa1jSDK AFInAppEventType2 : this.afInfoLog.values()) {
            AFInAppEventType2.AFInAppEventType(this.afErrorLog, true);
        }
        Map<AFa1jSDK, Map<String, Object>> map = this.afErrorLog;
        if (map == null || map.isEmpty()) {
            return new CopyOnWriteArrayList(Collections.emptyList());
        }
        return new CopyOnWriteArrayList(this.afErrorLog.values());
    }

    private List<Map<String, Object>> valueOf() {
        synchronized (this.AFKeystoreWrapper) {
            if (!this.afInfoLog.isEmpty() && this.AFVersionDeclaration) {
                for (AFa1jSDK AFInAppEventType2 : this.afInfoLog.values()) {
                    AFInAppEventType2.AFInAppEventType(this.afErrorLog, false);
                }
            }
            if (this.afErrorLog.isEmpty()) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(Collections.emptyList());
                return copyOnWriteArrayList;
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(this.afErrorLog.values());
            return copyOnWriteArrayList2;
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<String, Object> values() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        List<Map<String, Object>> valueOf2 = valueOf();
        if (!valueOf2.isEmpty()) {
            concurrentHashMap.put("sensors", valueOf2);
        } else {
            List<Map<String, Object>> AFKeystoreWrapper2 = AFKeystoreWrapper();
            if (!AFKeystoreWrapper2.isEmpty()) {
                concurrentHashMap.put("sensors", AFKeystoreWrapper2);
            }
        }
        return concurrentHashMap;
    }
}
