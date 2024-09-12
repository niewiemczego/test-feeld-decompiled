package io.seon.androidsdk.service;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.GnssCapabilities;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.braze.models.IBrazeLocation;
import com.facebook.hermes.intl.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.seon.androidsdk.logger.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GeolocationProbe extends AbstractSeonProbe implements LocationListener {
    private static boolean ENABLE_PREFETCH;
    private static final String FUSED = "fused";
    static final String[] KEYS = {IBrazeLocation.LATITUDE, IBrazeLocation.LONGITUDE, "accuracy", "is_cached", "status", "is_simulated"};
    private static long LOCATION_SERVICE_TIMEOUT_MS = TimeUnit.SECONDS.toMillis(3);
    private static final Logger LOG = Logger.withClass(GeolocationProbe.class);
    private static long MAX_LOCATION_CACHE_AGE_SEC = TimeUnit.MINUTES.toSeconds(10);
    private boolean mCanAccessFineLocation;
    private Context mContext;
    private Location mDefaultLocation;
    private boolean mIsActiveBackgroundFetching;
    private boolean mIsActiveRequest;
    private boolean mIsCachedLocation;
    private boolean mIsGpsEnabled;
    private boolean mIsOnPremise;
    private CountDownLatch mLatch;
    private Location mLocation;
    private LocationManager mLocationManager;
    private LocationStatus mLocationStatus;
    private PackageManager mPackageManager;
    private String mPreferredProvider;
    private final Map<String, Integer> providerScores = new HashMap();

    enum LocationStatus {
        UNKNOWN(-1),
        SUCCESS(0),
        FAIL(1),
        e(2),
        NO_PERMISSION(3),
        NO_PROVIDER(4),
        DISABLED(5),
        NO_SUPPORT(6);
        
        private final int a;

        private LocationStatus(int i) {
            this.a = i;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
    }

    /* access modifiers changed from: private */
    public float getAccuracy() {
        return getLocation(this.mPreferredProvider).getAccuracy();
    }

    /* access modifiers changed from: private */
    public double getAltitude() {
        return getLocation(this.mPreferredProvider).getAltitude();
    }

    /* access modifiers changed from: private */
    public float getBearing() {
        return getLocation(this.mPreferredProvider).getBearing();
    }

    /* access modifiers changed from: private */
    public float getBearingAccuracy() {
        if (Build.VERSION.SDK_INT < 26) {
            return -1.0f;
        }
        return getLocation(this.mPreferredProvider).getBearingAccuracyDegrees();
    }

    private Location getCachedLocation(String str) {
        Location lastKnownLocation = this.mLocationManager.getLastKnownLocation(str);
        if (!isValidLocation(lastKnownLocation)) {
            return null;
        }
        return lastKnownLocation;
    }

    private boolean getCurrentLocation(String str) {
        this.mLatch = new CountDownLatch(1);
        SeonUtil.b((Runnable) new GeolocationProbe$$ExternalSyntheticLambda24(this, str));
        try {
            if (this.mLatch.await(LOCATION_SERVICE_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                return true;
            }
            this.mLocationManager.removeUpdates(this);
            this.mLocationStatus = LocationStatus.e;
            return false;
        } catch (Exception unused) {
            this.mLocationManager.removeUpdates(this);
            this.mLocationStatus = LocationStatus.FAIL;
            return false;
        }
    }

    /* access modifiers changed from: private */
    public Map<String, Object> getExperimentalDeviceLocation() {
        HashMap hashMap = new HashMap();
        hashMap.put(IBrazeLocation.ALTITUDE, safeGet(new GeolocationProbe$$ExternalSyntheticLambda0(this)));
        hashMap.put("bearing", safeGet(new GeolocationProbe$$ExternalSyntheticLambda11(this)));
        hashMap.put("bearing_accuracy", safeGet(new GeolocationProbe$$ExternalSyntheticLambda22(this)));
        hashMap.put("extras", safeGet(new GeolocationProbe$$ExternalSyntheticLambda25(this)));
        hashMap.put("speed", safeGet(new GeolocationProbe$$ExternalSyntheticLambda26(this)));
        hashMap.put("speed_accuracy", safeGet(new GeolocationProbe$$ExternalSyntheticLambda27(this)));
        hashMap.put("vertical_accuracy", safeGet(new GeolocationProbe$$ExternalSyntheticLambda28(this)));
        hashMap.put("timestamp", safeGet(new GeolocationProbe$$ExternalSyntheticLambda29(this)));
        hashMap.put("provider", safeGet(new GeolocationProbe$$ExternalSyntheticLambda30(this)));
        return hashMap;
    }

    /* access modifiers changed from: private */
    public Map<String, Object> getExtras() {
        Bundle extras = getLocation(this.mPreferredProvider).getExtras();
        if (extras == null || extras.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : extras.keySet()) {
            hashMap.put(str, extras.get(str));
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public Map<String, Object> getGnssCapabilities() {
        if (Build.VERSION.SDK_INT < 30) {
            return null;
        }
        GnssCapabilities gnssCapabilities = this.mLocationManager.getGnssCapabilities();
        String gnssCapabilities2 = gnssCapabilities.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("has_antenna_info", safeGet(new GeolocationProbe$$ExternalSyntheticLambda8(this, gnssCapabilities)));
        hashMap.put("has_measurements", safeGet(new GeolocationProbe$$ExternalSyntheticLambda9(this, gnssCapabilities)));
        hashMap.put("has_navigation_messages", safeGet(new GeolocationProbe$$ExternalSyntheticLambda10(this, gnssCapabilities)));
        hashMap.put("has_scheduling", safeGet(new GeolocationProbe$$ExternalSyntheticLambda12(this, gnssCapabilities2)));
        hashMap.put("has_power_total", safeGet(new GeolocationProbe$$ExternalSyntheticLambda13(this, gnssCapabilities2)));
        hashMap.put("has_power_singleband_tracking", safeGet(new GeolocationProbe$$ExternalSyntheticLambda14(this, gnssCapabilities2)));
        hashMap.put("has_power_multiband_tracking", safeGet(new GeolocationProbe$$ExternalSyntheticLambda15(this, gnssCapabilities2)));
        hashMap.put("has_power_singleband_acquisition", safeGet(new GeolocationProbe$$ExternalSyntheticLambda16(this, gnssCapabilities2)));
        hashMap.put("has_power_multiband_acquisition", safeGet(new GeolocationProbe$$ExternalSyntheticLambda17(this, gnssCapabilities2)));
        hashMap.put("has_power_other_modes", safeGet(new GeolocationProbe$$ExternalSyntheticLambda18(this, gnssCapabilities2)));
        return hashMap;
    }

    /* access modifiers changed from: private */
    public String getGnssHardwareModelName() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.mLocationManager.getGnssHardwareModelName();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public int getGnssYearOfHardware() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.mLocationManager.getGnssYearOfHardware();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public boolean getIsCached() {
        return this.mIsCachedLocation;
    }

    /* access modifiers changed from: private */
    public boolean getIsMocked() {
        Location location = getLocation(this.mPreferredProvider);
        return Build.VERSION.SDK_INT < 31 ? location.isFromMockProvider() : location.isMock();
    }

    /* access modifiers changed from: private */
    public double getLatitude() {
        return getLocation(this.mPreferredProvider).getLatitude();
    }

    private Location getLocation(String str) {
        LocationStatus locationStatus;
        Location location = this.mLocation;
        if (location == this.mDefaultLocation) {
            return location;
        }
        if (isValidLocation(location)) {
            if (getLocationAge(this.mLocation) > 60) {
                this.mIsCachedLocation = true;
            }
            return this.mLocation;
        }
        this.mIsCachedLocation = false;
        this.mLocationStatus = LocationStatus.UNKNOWN;
        if (isSuitableEnvironment()) {
            if (str == null) {
                locationStatus = LocationStatus.NO_PROVIDER;
            } else {
                Location cachedLocation = getCachedLocation(str);
                if (cachedLocation != null) {
                    this.mIsCachedLocation = true;
                    this.mLocationStatus = LocationStatus.SUCCESS;
                    this.mLocation = cachedLocation;
                    return cachedLocation;
                } else if (getCurrentLocation(str)) {
                    return this.mLocation;
                } else {
                    locationStatus = LocationStatus.FAIL;
                }
            }
            this.mLocationStatus = locationStatus;
        }
        Location location2 = this.mDefaultLocation;
        this.mLocation = location2;
        return location2;
    }

    private long getLocationAge(Location location) {
        return TimeUnit.NANOSECONDS.toSeconds(SystemClock.elapsedRealtimeNanos() - location.getElapsedRealtimeNanos());
    }

    /* access modifiers changed from: private */
    public LocationStatus getLocationStatus() {
        return this.mLocationStatus;
    }

    /* access modifiers changed from: private */
    public double getLongitude() {
        return getLocation(this.mPreferredProvider).getLongitude();
    }

    private String getPreferredProvider() {
        LocationManager locationManager = this.mLocationManager;
        String str = FUSED;
        if (locationManager.isProviderEnabled(str)) {
            return str;
        }
        if (this.mLocationManager.isProviderEnabled("network")) {
            return "network";
        }
        return null;
    }

    /* access modifiers changed from: private */
    public String getProvider() {
        return getLocation(this.mPreferredProvider).getProvider();
    }

    /* access modifiers changed from: private */
    public float getSpeed() {
        return getLocation(this.mPreferredProvider).getSpeed();
    }

    /* access modifiers changed from: private */
    public float getSpeedAccuracy() {
        if (Build.VERSION.SDK_INT < 26) {
            return -1.0f;
        }
        return getLocation(this.mPreferredProvider).getSpeedAccuracyMetersPerSecond();
    }

    /* access modifiers changed from: private */
    public long getTimestamp() {
        return getLocation(this.mPreferredProvider).getTime();
    }

    /* access modifiers changed from: private */
    public float getVerticalAccuracy() {
        if (Build.VERSION.SDK_INT < 26) {
            return -1.0f;
        }
        return getLocation(this.mPreferredProvider).getVerticalAccuracyMeters();
    }

    private boolean gnssCapabilitiesHasAntennaInfo(GnssCapabilities gnssCapabilities) {
        if (Build.VERSION.SDK_INT >= 31) {
            return gnssCapabilities.hasAntennaInfo();
        }
        return false;
    }

    private boolean gnssCapabilitiesHasMeasurements(GnssCapabilities gnssCapabilities) {
        if (Build.VERSION.SDK_INT >= 31) {
            return gnssCapabilities.hasMeasurements();
        }
        return false;
    }

    private boolean gnssCapabilitiesHasNavigationMessages(GnssCapabilities gnssCapabilities) {
        if (Build.VERSION.SDK_INT >= 31) {
            return gnssCapabilities.hasNavigationMessages();
        }
        return false;
    }

    private boolean gnssCapabilitiesHasPowerMultibandAcquisition(String str) {
        return str.contains("MULTIBAND_ACQUISITION_POWER");
    }

    private boolean gnssCapabilitiesHasPowerMultibandTracking(String str) {
        return str.contains("MULTIBAND_TRACKING_POWER");
    }

    private boolean gnssCapabilitiesHasPowerOtherModes(String str) {
        return str.contains("OTHER_MODES_POWER");
    }

    private boolean gnssCapabilitiesHasPowerSinglebandAcquisition(String str) {
        return str.contains("SINGLEBAND_ACQUISITION_POWER");
    }

    private boolean gnssCapabilitiesHasPowerSinglebandTracking(String str) {
        return str.contains("SINGLEBAND_TRACKING_POWER");
    }

    private boolean gnssCapabilitiesHasPowerTotal(String str) {
        return str.contains("TOTAL_POWER");
    }

    private boolean gnssCapabilitiesHasScheduling(String str) {
        return str.contains("SCHEDULING");
    }

    private boolean isSuitableEnvironment() {
        LocationStatus locationStatus;
        if (!this.mPackageManager.hasSystemFeature("android.hardware.location")) {
            locationStatus = LocationStatus.NO_SUPPORT;
        } else if (Build.VERSION.SDK_INT >= 28 && !this.mLocationManager.isLocationEnabled()) {
            locationStatus = LocationStatus.DISABLED;
        } else if (SeonUtil.a(this.mContext, "android.permission.ACCESS_FINE_LOCATION")) {
            this.mCanAccessFineLocation = true;
            return true;
        } else if (SeonUtil.a(this.mContext, "android.permission.ACCESS_COARSE_LOCATION")) {
            this.mCanAccessFineLocation = false;
            return true;
        } else {
            locationStatus = LocationStatus.NO_PERMISSION;
        }
        this.mLocationStatus = locationStatus;
        return false;
    }

    private boolean isValidLocation(Location location) {
        if (location == null || getLocationAge(location) > MAX_LOCATION_CACHE_AGE_SEC) {
            return false;
        }
        return Build.VERSION.SDK_INT < 33 ? (location.getProvider() == null || !location.hasAccuracy() || location.getTime() == 0 || location.getElapsedRealtimeNanos() == 0) ? false : true : location.isComplete();
    }

    /* access modifiers changed from: private */
    public void registerActiveBackgroundListener() {
        try {
            boolean isSuitableEnvironment = isSuitableEnvironment();
            boolean z = this.mIsGpsEnabled && this.mCanAccessFineLocation;
            if (isSuitableEnvironment) {
                if (z || this.mPreferredProvider != null) {
                    String str = z ? "gps" : this.mPreferredProvider;
                    this.mIsActiveBackgroundFetching = true;
                    this.mIsActiveRequest = true;
                    this.mLocationManager.requestLocationUpdates(str, 1, 1.0f, this);
                    return;
                }
            }
            registerPassiveBackgroundListener();
        } catch (Exception unused) {
            registerPassiveBackgroundListener();
        }
    }

    /* access modifiers changed from: private */
    public void registerPassiveBackgroundListener() {
        try {
            if (!isSuitableEnvironment()) {
                return;
            }
            if (this.mLocationManager.isProviderEnabled("passive")) {
                this.mLocationManager.requestLocationUpdates("passive", 1, 1.0f, this);
            }
        } catch (Exception unused) {
        }
    }

    static void setLocationConfig(int i, int i2, boolean z) {
        MAX_LOCATION_CACHE_AGE_SEC = (long) i;
        LOCATION_SERVICE_TIMEOUT_MS = (long) i2;
        ENABLE_PREFETCH = z;
    }

    public void bootstrap(Context context) {
        try {
            this.mContext = context;
            this.mLocationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION);
            this.mDefaultLocation = new Location(Constants.COLLATION_DEFAULT);
            boolean z = true;
            this.providerScores.put("network", 1);
            this.providerScores.put(FUSED, 2);
            this.providerScores.put("gps", 3);
            if (this.mLocationManager == null) {
                this.mLocation = this.mDefaultLocation;
                this.mLocationStatus = LocationStatus.NO_SUPPORT;
                return;
            }
            this.mPackageManager = context.getPackageManager();
            if (isSuitableEnvironment()) {
                this.mPreferredProvider = getPreferredProvider();
                if (!this.mCanAccessFineLocation || !this.mLocationManager.isProviderEnabled("gps")) {
                    z = false;
                }
                this.mIsGpsEnabled = z;
                this.mLocationStatus = LocationStatus.UNKNOWN;
                if (!ENABLE_PREFETCH) {
                    registerPassiveBackgroundListener();
                } else {
                    registerActiveBackgroundListener();
                }
            }
        } catch (Exception unused) {
        }
    }

    public Map<String, Object> getExperimentalFields() {
        HashMap hashMap = new HashMap();
        hashMap.put("experimental_device_location", safeGet(new GeolocationProbe$$ExternalSyntheticLambda19(this)));
        hashMap.put("gnss_capabilities", safeGet(new GeolocationProbe$$ExternalSyntheticLambda20(this)));
        hashMap.put("gnss_hardware_model_name", safeGet(new GeolocationProbe$$ExternalSyntheticLambda21(this)));
        hashMap.put("gnss_year_of_hardware", safeGet(new GeolocationProbe$$ExternalSyntheticLambda23(this)));
        SeonUtil.b((this.mIsCachedLocation || !isValidLocation(this.mLocation)) ? new GeolocationProbe$$ExternalSyntheticLambda7(this) : new GeolocationProbe$$ExternalSyntheticLambda6(this));
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getCurrentLocation$10$io-seon-androidsdk-service-GeolocationProbe  reason: not valid java name */
    public /* synthetic */ void m955lambda$getCurrentLocation$10$ioseonandroidsdkserviceGeolocationProbe(String str) {
        this.mIsActiveRequest = true;
        this.mLocationManager.requestLocationUpdates(str, 1, 1.0f, this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getGnssCapabilities$0$io-seon-androidsdk-service-GeolocationProbe  reason: not valid java name */
    public /* synthetic */ Boolean m956lambda$getGnssCapabilities$0$ioseonandroidsdkserviceGeolocationProbe(GnssCapabilities gnssCapabilities) {
        return Boolean.valueOf(gnssCapabilitiesHasAntennaInfo(gnssCapabilities));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getGnssCapabilities$1$io-seon-androidsdk-service-GeolocationProbe  reason: not valid java name */
    public /* synthetic */ Boolean m957lambda$getGnssCapabilities$1$ioseonandroidsdkserviceGeolocationProbe(GnssCapabilities gnssCapabilities) {
        return Boolean.valueOf(gnssCapabilitiesHasMeasurements(gnssCapabilities));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getGnssCapabilities$2$io-seon-androidsdk-service-GeolocationProbe  reason: not valid java name */
    public /* synthetic */ Boolean m958lambda$getGnssCapabilities$2$ioseonandroidsdkserviceGeolocationProbe(GnssCapabilities gnssCapabilities) {
        return Boolean.valueOf(gnssCapabilitiesHasNavigationMessages(gnssCapabilities));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getGnssCapabilities$3$io-seon-androidsdk-service-GeolocationProbe  reason: not valid java name */
    public /* synthetic */ Boolean m959lambda$getGnssCapabilities$3$ioseonandroidsdkserviceGeolocationProbe(String str) {
        return Boolean.valueOf(gnssCapabilitiesHasScheduling(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getGnssCapabilities$4$io-seon-androidsdk-service-GeolocationProbe  reason: not valid java name */
    public /* synthetic */ Boolean m960lambda$getGnssCapabilities$4$ioseonandroidsdkserviceGeolocationProbe(String str) {
        return Boolean.valueOf(gnssCapabilitiesHasPowerTotal(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getGnssCapabilities$5$io-seon-androidsdk-service-GeolocationProbe  reason: not valid java name */
    public /* synthetic */ Boolean m961lambda$getGnssCapabilities$5$ioseonandroidsdkserviceGeolocationProbe(String str) {
        return Boolean.valueOf(gnssCapabilitiesHasPowerSinglebandTracking(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getGnssCapabilities$6$io-seon-androidsdk-service-GeolocationProbe  reason: not valid java name */
    public /* synthetic */ Boolean m962lambda$getGnssCapabilities$6$ioseonandroidsdkserviceGeolocationProbe(String str) {
        return Boolean.valueOf(gnssCapabilitiesHasPowerMultibandTracking(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getGnssCapabilities$7$io-seon-androidsdk-service-GeolocationProbe  reason: not valid java name */
    public /* synthetic */ Boolean m963lambda$getGnssCapabilities$7$ioseonandroidsdkserviceGeolocationProbe(String str) {
        return Boolean.valueOf(gnssCapabilitiesHasPowerSinglebandAcquisition(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getGnssCapabilities$8$io-seon-androidsdk-service-GeolocationProbe  reason: not valid java name */
    public /* synthetic */ Boolean m964lambda$getGnssCapabilities$8$ioseonandroidsdkserviceGeolocationProbe(String str) {
        return Boolean.valueOf(gnssCapabilitiesHasPowerMultibandAcquisition(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getGnssCapabilities$9$io-seon-androidsdk-service-GeolocationProbe  reason: not valid java name */
    public /* synthetic */ Boolean m965lambda$getGnssCapabilities$9$ioseonandroidsdkserviceGeolocationProbe(String str) {
        return Boolean.valueOf(gnssCapabilitiesHasPowerOtherModes(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        if (r0.intValue() < r2.intValue()) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLocationChanged(android.location.Location r5) {
        /*
            r4 = this;
            boolean r0 = r4.isValidLocation(r5)
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            android.location.Location r0 = r4.mLocation
            boolean r0 = r4.isValidLocation(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0038
            java.util.Map<java.lang.String, java.lang.Integer> r0 = r4.providerScores
            java.lang.String r2 = r5.getProvider()
            java.lang.Object r0 = r0.get(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            java.util.Map<java.lang.String, java.lang.Integer> r2 = r4.providerScores
            android.location.Location r3 = r4.mLocation
            java.lang.String r3 = r3.getProvider()
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 == 0) goto L_0x0038
            if (r0 == 0) goto L_0x0040
            int r0 = r0.intValue()
            int r2 = r2.intValue()
            if (r0 < r2) goto L_0x0040
        L_0x0038:
            r4.mLocation = r5
            r4.mIsCachedLocation = r1
            io.seon.androidsdk.service.GeolocationProbe$LocationStatus r5 = io.seon.androidsdk.service.GeolocationProbe.LocationStatus.SUCCESS
            r4.mLocationStatus = r5
        L_0x0040:
            java.util.concurrent.CountDownLatch r5 = r4.mLatch
            if (r5 == 0) goto L_0x0047
            r5.countDown()
        L_0x0047:
            boolean r5 = r4.mIsActiveRequest
            if (r5 == 0) goto L_0x0052
            android.location.LocationManager r5 = r4.mLocationManager
            r5.removeUpdates(r4)
            r4.mIsActiveRequest = r1
        L_0x0052:
            boolean r5 = r4.mIsActiveBackgroundFetching
            if (r5 == 0) goto L_0x005b
            r4.mIsActiveBackgroundFetching = r1
            r4.registerPassiveBackgroundListener()
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.seon.androidsdk.service.GeolocationProbe.onLocationChanged(android.location.Location):void");
    }

    public void onProviderDisabled(String str) {
        if (str.equals("gps")) {
            this.mIsGpsEnabled = false;
        } else if (Objects.equals(this.mPreferredProvider, str)) {
            if (isSuitableEnvironment()) {
                this.mPreferredProvider = getPreferredProvider();
            } else {
                this.mPreferredProvider = null;
            }
        }
    }

    public void onProviderEnabled(String str) {
        if (str.equals("gps")) {
            this.mIsGpsEnabled = isSuitableEnvironment() && this.mCanAccessFineLocation;
            return;
        }
        Integer num = this.providerScores.get(str);
        Integer num2 = this.providerScores.get(this.mPreferredProvider);
        if (num2 == null || (num != null && num.intValue() > num2.intValue())) {
            this.mPreferredProvider = str;
        }
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        boolean isSuitableEnvironment = isSuitableEnvironment();
        if (str.equals("gps")) {
            if (!isSuitableEnvironment || !this.mCanAccessFineLocation) {
                this.mIsGpsEnabled = false;
            } else {
                this.mIsGpsEnabled = this.mLocationManager.isProviderEnabled("gps");
            }
        } else if (!Objects.equals(this.mPreferredProvider, str)) {
            Integer num = this.providerScores.get(str);
            Integer num2 = this.providerScores.get(this.mPreferredProvider);
            if ((num2 == null || (num != null && num.intValue() > num2.intValue())) && i == 2) {
                this.mPreferredProvider = str;
            }
        } else if (isSuitableEnvironment) {
            if (!this.mLocationManager.isProviderEnabled(str)) {
                str = getPreferredProvider();
            }
            this.mPreferredProvider = str;
        } else {
            this.mPreferredProvider = null;
        }
    }

    public Map<String, Object> scan() {
        this.mLocationManager.removeUpdates(this);
        this.mIsActiveBackgroundFetching = false;
        this.mIsActiveRequest = false;
        HashMap hashMap = new HashMap();
        hashMap.put(IBrazeLocation.LATITUDE, safeGet(new GeolocationProbe$$ExternalSyntheticLambda31(this)));
        hashMap.put(IBrazeLocation.LONGITUDE, safeGet(new GeolocationProbe$$ExternalSyntheticLambda1(this)));
        hashMap.put("accuracy", safeGet(new GeolocationProbe$$ExternalSyntheticLambda2(this)));
        hashMap.put("is_cached", safeGet(new GeolocationProbe$$ExternalSyntheticLambda3(this)));
        hashMap.put("status", safeGet(new GeolocationProbe$$ExternalSyntheticLambda4(this)));
        hashMap.put("is_simulated", safeGet(new GeolocationProbe$$ExternalSyntheticLambda5(this)));
        if (this.mIsOnPremise) {
            SeonUtil.b((this.mIsCachedLocation || !isValidLocation(this.mLocation)) ? new GeolocationProbe$$ExternalSyntheticLambda7(this) : new GeolocationProbe$$ExternalSyntheticLambda6(this));
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public void setIsOnPremise(boolean z) {
        this.mIsOnPremise = z;
    }
}
