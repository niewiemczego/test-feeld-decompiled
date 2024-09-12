package com.agontuk.RNFusedLocation;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.Random;

public class FusedLocationProvider implements LocationProvider {
    /* access modifiers changed from: private */
    public int activityRequestCode;
    /* access modifiers changed from: private */
    public final ReactApplicationContext context;
    /* access modifiers changed from: private */
    public final FusedLocationProviderClient fusedLocationProviderClient;
    /* access modifiers changed from: private */
    public boolean isSingleUpdate = false;
    /* access modifiers changed from: private */
    public final LocationCallback locationCallback = new LocationCallback() {
        public void onLocationResult(LocationResult locationResult) {
            FusedLocationProvider.this.locationChangeListener.onLocationChange(FusedLocationProvider.this, locationResult.getLastLocation());
            if (FusedLocationProvider.this.isSingleUpdate) {
                FusedLocationProvider.this.timeoutHandler.removeCallbacks(FusedLocationProvider.this.timeoutRunnable);
                FusedLocationProvider.this.fusedLocationProviderClient.removeLocationUpdates(FusedLocationProvider.this.locationCallback);
            }
        }

        public void onLocationAvailability(LocationAvailability locationAvailability) {
            if (!locationAvailability.isLocationAvailable() && !LocationUtils.isLocationEnabled(FusedLocationProvider.this.context)) {
                FusedLocationProvider.this.locationChangeListener.onLocationError(FusedLocationProvider.this, LocationError.POSITION_UNAVAILABLE, "Unable to retrieve location.");
            }
        }
    };
    /* access modifiers changed from: private */
    public final LocationChangeListener locationChangeListener;
    /* access modifiers changed from: private */
    public LocationOptions locationOptions;
    private LocationRequest locationRequest;
    private final SettingsClient settingsClient;
    /* access modifiers changed from: private */
    public final Handler timeoutHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final Runnable timeoutRunnable = new Runnable() {
        public void run() {
            FusedLocationProvider.this.locationChangeListener.onLocationError(FusedLocationProvider.this, LocationError.TIMEOUT, (String) null);
            FusedLocationProvider.this.fusedLocationProviderClient.removeLocationUpdates(FusedLocationProvider.this.locationCallback);
        }
    };

    public FusedLocationProvider(ReactApplicationContext reactApplicationContext, LocationChangeListener locationChangeListener2) {
        this.context = reactApplicationContext;
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient((Context) reactApplicationContext);
        this.locationChangeListener = locationChangeListener2;
        this.settingsClient = LocationServices.getSettingsClient((Context) reactApplicationContext);
    }

    public void getCurrentLocation(final LocationOptions locationOptions2) {
        this.isSingleUpdate = true;
        this.locationOptions = locationOptions2;
        this.locationRequest = buildLocationRequest(locationOptions2);
        this.fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            public void onSuccess(Location location) {
                if (location == null || ((double) LocationUtils.getLocationAge(location)) >= locationOptions2.getMaximumAge()) {
                    FusedLocationProvider.this.checkLocationSettings();
                    return;
                }
                Log.i(RNFusedLocationModule.TAG, "returning cached location.");
                FusedLocationProvider.this.locationChangeListener.onLocationChange(FusedLocationProvider.this, location);
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(Exception exc) {
                FusedLocationProvider.this.checkLocationSettings();
            }
        });
    }

    public boolean onActivityResult(int i, int i2) {
        if (i != this.activityRequestCode) {
            return false;
        }
        if (i2 == -1) {
            startLocationUpdates();
            return true;
        }
        boolean isForceRequestLocation = this.locationOptions.isForceRequestLocation();
        boolean isLocationEnabled = LocationUtils.isLocationEnabled(this.context);
        if (!isForceRequestLocation || !isLocationEnabled) {
            this.locationChangeListener.onLocationError(this, isLocationEnabled ? LocationError.SETTINGS_NOT_SATISFIED : LocationError.POSITION_UNAVAILABLE, (String) null);
        } else {
            startLocationUpdates();
        }
        return true;
    }

    public void requestLocationUpdates(LocationOptions locationOptions2) {
        this.isSingleUpdate = false;
        this.locationOptions = locationOptions2;
        this.locationRequest = buildLocationRequest(locationOptions2);
        checkLocationSettings();
    }

    public void removeLocationUpdates() {
        this.fusedLocationProviderClient.removeLocationUpdates(this.locationCallback);
    }

    private LocationRequest buildLocationRequest(LocationOptions locationOptions2) {
        LocationRequest locationRequest2 = new LocationRequest();
        locationRequest2.setPriority(getLocationPriority(locationOptions2.getAccuracy())).setInterval(locationOptions2.getInterval()).setFastestInterval(locationOptions2.getFastestInterval()).setSmallestDisplacement(this.isSingleUpdate ? 0.0f : locationOptions2.getDistanceFilter());
        return locationRequest2;
    }

    /* access modifiers changed from: private */
    public void checkLocationSettings() {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(this.locationRequest);
        this.settingsClient.checkLocationSettings(builder.build()).addOnSuccessListener(new OnSuccessListener<LocationSettingsResponse>() {
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                FusedLocationProvider.this.startLocationUpdates();
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(Exception exc) {
                ApiException apiException = (ApiException) exc;
                int statusCode = apiException.getStatusCode();
                if (statusCode == 6) {
                    boolean isShowLocationDialog = FusedLocationProvider.this.locationOptions.isShowLocationDialog();
                    boolean isForceRequestLocation = FusedLocationProvider.this.locationOptions.isForceRequestLocation();
                    boolean isLocationEnabled = LocationUtils.isLocationEnabled(FusedLocationProvider.this.context);
                    if (isShowLocationDialog) {
                        try {
                            ResolvableApiException resolvableApiException = (ResolvableApiException) apiException;
                            Activity currentActivity = FusedLocationProvider.this.context.getCurrentActivity();
                            if (currentActivity == null) {
                                FusedLocationProvider.this.locationChangeListener.onLocationError(FusedLocationProvider.this, LocationError.INTERNAL_ERROR, "Tried to open location dialog while not attached to an Activity.");
                                return;
                            }
                            FusedLocationProvider fusedLocationProvider = FusedLocationProvider.this;
                            int unused = fusedLocationProvider.activityRequestCode = fusedLocationProvider.getActivityRequestCode();
                            resolvableApiException.startResolutionForResult(currentActivity, FusedLocationProvider.this.activityRequestCode);
                        } catch (IntentSender.SendIntentException | ClassCastException unused2) {
                            FusedLocationProvider.this.locationChangeListener.onLocationError(FusedLocationProvider.this, LocationError.INTERNAL_ERROR, (String) null);
                        }
                    } else if (!isForceRequestLocation || !isLocationEnabled) {
                        FusedLocationProvider.this.locationChangeListener.onLocationError(FusedLocationProvider.this, isLocationEnabled ? LocationError.SETTINGS_NOT_SATISFIED : LocationError.POSITION_UNAVAILABLE, (String) null);
                    } else {
                        FusedLocationProvider.this.startLocationUpdates();
                    }
                } else if (statusCode == 8502 && LocationUtils.isOnAirplaneMode(FusedLocationProvider.this.context) && LocationUtils.isProviderEnabled(FusedLocationProvider.this.context, "gps")) {
                    FusedLocationProvider.this.startLocationUpdates();
                } else {
                    FusedLocationProvider.this.locationChangeListener.onLocationError(FusedLocationProvider.this, LocationError.SETTINGS_NOT_SATISFIED, (String) null);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public int getActivityRequestCode() {
        return new Random().nextInt(10000);
    }

    /* renamed from: com.agontuk.RNFusedLocation.FusedLocationProvider$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$agontuk$RNFusedLocation$LocationAccuracy;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.agontuk.RNFusedLocation.LocationAccuracy[] r0 = com.agontuk.RNFusedLocation.LocationAccuracy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$agontuk$RNFusedLocation$LocationAccuracy = r0
                com.agontuk.RNFusedLocation.LocationAccuracy r1 = com.agontuk.RNFusedLocation.LocationAccuracy.high     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$agontuk$RNFusedLocation$LocationAccuracy     // Catch:{ NoSuchFieldError -> 0x001d }
                com.agontuk.RNFusedLocation.LocationAccuracy r1 = com.agontuk.RNFusedLocation.LocationAccuracy.balanced     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$agontuk$RNFusedLocation$LocationAccuracy     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.agontuk.RNFusedLocation.LocationAccuracy r1 = com.agontuk.RNFusedLocation.LocationAccuracy.low     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$agontuk$RNFusedLocation$LocationAccuracy     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.agontuk.RNFusedLocation.LocationAccuracy r1 = com.agontuk.RNFusedLocation.LocationAccuracy.passive     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.agontuk.RNFusedLocation.FusedLocationProvider.AnonymousClass7.<clinit>():void");
        }
    }

    private int getLocationPriority(LocationAccuracy locationAccuracy) {
        int i = AnonymousClass7.$SwitchMap$com$agontuk$RNFusedLocation$LocationAccuracy[locationAccuracy.ordinal()];
        if (i == 1) {
            return 100;
        }
        if (i == 2) {
            return 102;
        }
        if (i == 3) {
            return 104;
        }
        if (i == 4) {
            return 105;
        }
        throw new IllegalStateException("Unexpected value: " + locationAccuracy);
    }

    /* access modifiers changed from: private */
    public void startLocationUpdates() {
        this.fusedLocationProviderClient.requestLocationUpdates(this.locationRequest, this.locationCallback, Looper.getMainLooper());
        if (this.isSingleUpdate) {
            long timeout = this.locationOptions.getTimeout();
            if (timeout > 0 && timeout != Long.MAX_VALUE) {
                this.timeoutHandler.postDelayed(this.timeoutRunnable, timeout);
            }
        }
    }
}
