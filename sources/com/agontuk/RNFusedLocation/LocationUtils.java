package com.agontuk.RNFusedLocation;

import android.content.ContentResolver;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.braze.models.IBrazeLocation;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.analytics.FirebaseAnalytics;

public class LocationUtils {
    public static long getLocationAge(Location location) {
        if (Build.VERSION.SDK_INT >= 17) {
            return (SystemClock.elapsedRealtimeNanos() - location.getElapsedRealtimeNanos()) / 1000000;
        }
        return System.currentTimeMillis() - location.getTime();
    }

    public static boolean hasLocationPermission(Context context) {
        return ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    public static boolean isGooglePlayServicesAvailable(Context context) {
        int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
        return isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 18;
    }

    public static boolean isOnAirplaneMode(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        if (Build.VERSION.SDK_INT >= 17) {
            if (Settings.Global.getInt(contentResolver, "airplane_mode_on", 0) != 0) {
                return true;
            }
            return false;
        } else if (Settings.System.getInt(contentResolver, "airplane_mode_on", 0) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isLocationEnabled(Context context) {
        if (Build.VERSION.SDK_INT < 19) {
            return !TextUtils.isEmpty(Settings.Secure.getString(context.getContentResolver(), "location_providers_allowed"));
        }
        if (Build.VERSION.SDK_INT != 19) {
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION);
                if (Build.VERSION.SDK_INT >= 28) {
                    return locationManager.isLocationEnabled();
                }
                if (locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps")) {
                    return true;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        } else if (Settings.Secure.getInt(context.getContentResolver(), "location_mode", 0) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isProviderEnabled(Context context, String str) {
        try {
            return ((LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION)).isProviderEnabled(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static WritableMap buildError(LocationError locationError, String str) {
        if (str == null) {
            str = getDefaultErrorMessage(locationError);
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("code", locationError.getValue());
        createMap.putString("message", str);
        return createMap;
    }

    public static WritableMap locationToMap(Location location) {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble(IBrazeLocation.LATITUDE, location.getLatitude());
        createMap2.putDouble(IBrazeLocation.LONGITUDE, location.getLongitude());
        createMap2.putDouble(IBrazeLocation.ALTITUDE, location.getAltitude());
        createMap2.putDouble("accuracy", (double) location.getAccuracy());
        createMap2.putDouble("heading", (double) location.getBearing());
        createMap2.putDouble("speed", (double) location.getSpeed());
        if (Build.VERSION.SDK_INT >= 26) {
            createMap2.putDouble("altitudeAccuracy", (double) location.getVerticalAccuracyMeters());
        }
        createMap.putMap("coords", createMap2);
        createMap.putString("provider", location.getProvider());
        createMap.putDouble("timestamp", (double) location.getTime());
        if (Build.VERSION.SDK_INT >= 18) {
            createMap.putBoolean("mocked", location.isFromMockProvider());
        }
        return createMap;
    }

    /* renamed from: com.agontuk.RNFusedLocation.LocationUtils$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$agontuk$RNFusedLocation$LocationError;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.agontuk.RNFusedLocation.LocationError[] r0 = com.agontuk.RNFusedLocation.LocationError.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$agontuk$RNFusedLocation$LocationError = r0
                com.agontuk.RNFusedLocation.LocationError r1 = com.agontuk.RNFusedLocation.LocationError.PERMISSION_DENIED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$agontuk$RNFusedLocation$LocationError     // Catch:{ NoSuchFieldError -> 0x001d }
                com.agontuk.RNFusedLocation.LocationError r1 = com.agontuk.RNFusedLocation.LocationError.POSITION_UNAVAILABLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$agontuk$RNFusedLocation$LocationError     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.agontuk.RNFusedLocation.LocationError r1 = com.agontuk.RNFusedLocation.LocationError.TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$agontuk$RNFusedLocation$LocationError     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.agontuk.RNFusedLocation.LocationError r1 = com.agontuk.RNFusedLocation.LocationError.PLAY_SERVICE_NOT_AVAILABLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$agontuk$RNFusedLocation$LocationError     // Catch:{ NoSuchFieldError -> 0x003e }
                com.agontuk.RNFusedLocation.LocationError r1 = com.agontuk.RNFusedLocation.LocationError.SETTINGS_NOT_SATISFIED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$agontuk$RNFusedLocation$LocationError     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.agontuk.RNFusedLocation.LocationError r1 = com.agontuk.RNFusedLocation.LocationError.INTERNAL_ERROR     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.agontuk.RNFusedLocation.LocationUtils.AnonymousClass1.<clinit>():void");
        }
    }

    private static String getDefaultErrorMessage(LocationError locationError) {
        int i = AnonymousClass1.$SwitchMap$com$agontuk$RNFusedLocation$LocationError[locationError.ordinal()];
        if (i == 1) {
            return "Location permission not granted.";
        }
        if (i == 2) {
            return "No location provider available.";
        }
        if (i == 3) {
            return "Location request timed out.";
        }
        if (i != 4) {
            return i != 5 ? "Internal error occurred" : "Location settings are not satisfied.";
        }
        return "Google play service is not available.";
    }
}
