package com.agontuk.RNFusedLocation;

import com.facebook.react.bridge.ReadableMap;
import io.sentry.ProfilingTraceData;

public class LocationOptions {
    private static final float DEFAULT_DISTANCE_FILTER = 100.0f;
    private static final long DEFAULT_FASTEST_INTERVAL = 5000;
    private static final long DEFAULT_INTERVAL = 10000;
    private final LocationAccuracy accuracy;
    private final float distanceFilter;
    private final long fastestInterval;
    private final boolean forceLocationManager;
    private final boolean forceRequestLocation;
    private final long interval;
    private final double maximumAge;
    private final boolean showLocationDialog;
    private final long timeout;

    private LocationOptions(LocationAccuracy locationAccuracy, long j, long j2, float f, long j3, double d, boolean z, boolean z2, boolean z3) {
        this.accuracy = locationAccuracy;
        this.interval = j;
        this.fastestInterval = j2;
        this.distanceFilter = f;
        this.timeout = j3;
        this.maximumAge = d;
        this.showLocationDialog = z;
        this.forceRequestLocation = z2;
        this.forceLocationManager = z3;
    }

    public static LocationOptions fromReadableMap(ReadableMap readableMap) {
        ReadableMap readableMap2 = readableMap;
        LocationAccuracy accuracy2 = getAccuracy(readableMap);
        long j = readableMap2.hasKey("interval") ? (long) readableMap2.getDouble("interval") : 10000;
        long j2 = readableMap2.hasKey("fastestInterval") ? (long) readableMap2.getDouble("fastestInterval") : 5000;
        float f = readableMap2.hasKey("distanceFilter") ? (float) readableMap2.getDouble("distanceFilter") : DEFAULT_DISTANCE_FILTER;
        long j3 = readableMap2.hasKey(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT) ? (long) readableMap2.getDouble(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT) : Long.MAX_VALUE;
        double d = readableMap2.hasKey("maximumAge") ? readableMap2.getDouble("maximumAge") : Double.POSITIVE_INFINITY;
        boolean z = false;
        boolean z2 = !readableMap2.hasKey("showLocationDialog") || readableMap2.getBoolean("showLocationDialog");
        boolean z3 = readableMap2.hasKey("forceRequestLocation") && readableMap2.getBoolean("forceRequestLocation");
        if (readableMap2.hasKey("forceLocationManager") && readableMap2.getBoolean("forceLocationManager")) {
            z = true;
        }
        return new LocationOptions(accuracy2, j, j2, f, j3, d, z2, z3, z);
    }

    public LocationAccuracy getAccuracy() {
        return this.accuracy;
    }

    public long getInterval() {
        return this.interval;
    }

    public long getFastestInterval() {
        return this.fastestInterval;
    }

    public float getDistanceFilter() {
        return this.distanceFilter;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public double getMaximumAge() {
        return this.maximumAge;
    }

    public boolean isShowLocationDialog() {
        return this.showLocationDialog;
    }

    public boolean isForceRequestLocation() {
        return this.forceRequestLocation;
    }

    public boolean isForceLocationManager() {
        return this.forceLocationManager;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006b, code lost:
        if (r6.equals("passive") == false) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.agontuk.RNFusedLocation.LocationAccuracy getAccuracy(com.facebook.react.bridge.ReadableMap r6) {
        /*
            java.lang.String r0 = "enableHighAccuracy"
            boolean r1 = r6.hasKey(r0)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0012
            boolean r0 = r6.getBoolean(r0)
            if (r0 == 0) goto L_0x0012
            r0 = r2
            goto L_0x0013
        L_0x0012:
            r0 = r3
        L_0x0013:
            java.lang.String r1 = "accuracy"
            boolean r4 = r6.hasKey(r1)
            if (r4 == 0) goto L_0x0040
            com.facebook.react.bridge.ReadableType r4 = r6.getType(r1)
            com.facebook.react.bridge.ReadableType r5 = com.facebook.react.bridge.ReadableType.Map
            if (r4 != r5) goto L_0x0040
            com.facebook.react.bridge.ReadableMap r6 = r6.getMap(r1)
            if (r6 == 0) goto L_0x0040
            java.lang.String r1 = "android"
            boolean r4 = r6.hasKey(r1)
            if (r4 == 0) goto L_0x0040
            com.facebook.react.bridge.ReadableType r4 = r6.getType(r1)
            com.facebook.react.bridge.ReadableType r5 = com.facebook.react.bridge.ReadableType.String
            if (r4 != r5) goto L_0x0040
            java.lang.String r6 = r6.getString(r1)
            if (r6 == 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            java.lang.String r6 = ""
        L_0x0042:
            r6.hashCode()
            r1 = -1
            int r4 = r6.hashCode()
            switch(r4) {
                case -1924829944: goto L_0x006e;
                case -792039641: goto L_0x0065;
                case 107348: goto L_0x005a;
                case 3202466: goto L_0x004f;
                default: goto L_0x004d;
            }
        L_0x004d:
            r2 = r1
            goto L_0x0078
        L_0x004f:
            java.lang.String r2 = "high"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x0058
            goto L_0x004d
        L_0x0058:
            r2 = 3
            goto L_0x0078
        L_0x005a:
            java.lang.String r2 = "low"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x0063
            goto L_0x004d
        L_0x0063:
            r2 = 2
            goto L_0x0078
        L_0x0065:
            java.lang.String r3 = "passive"
            boolean r6 = r6.equals(r3)
            if (r6 != 0) goto L_0x0078
            goto L_0x004d
        L_0x006e:
            java.lang.String r2 = "balanced"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x0077
            goto L_0x004d
        L_0x0077:
            r2 = r3
        L_0x0078:
            switch(r2) {
                case 0: goto L_0x008c;
                case 1: goto L_0x0089;
                case 2: goto L_0x0086;
                case 3: goto L_0x0083;
                default: goto L_0x007b;
            }
        L_0x007b:
            if (r0 == 0) goto L_0x0080
            com.agontuk.RNFusedLocation.LocationAccuracy r6 = com.agontuk.RNFusedLocation.LocationAccuracy.high
            goto L_0x0082
        L_0x0080:
            com.agontuk.RNFusedLocation.LocationAccuracy r6 = com.agontuk.RNFusedLocation.LocationAccuracy.balanced
        L_0x0082:
            return r6
        L_0x0083:
            com.agontuk.RNFusedLocation.LocationAccuracy r6 = com.agontuk.RNFusedLocation.LocationAccuracy.high
            return r6
        L_0x0086:
            com.agontuk.RNFusedLocation.LocationAccuracy r6 = com.agontuk.RNFusedLocation.LocationAccuracy.low
            return r6
        L_0x0089:
            com.agontuk.RNFusedLocation.LocationAccuracy r6 = com.agontuk.RNFusedLocation.LocationAccuracy.passive
            return r6
        L_0x008c:
            com.agontuk.RNFusedLocation.LocationAccuracy r6 = com.agontuk.RNFusedLocation.LocationAccuracy.balanced
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.agontuk.RNFusedLocation.LocationOptions.getAccuracy(com.facebook.react.bridge.ReadableMap):com.agontuk.RNFusedLocation.LocationAccuracy");
    }
}
