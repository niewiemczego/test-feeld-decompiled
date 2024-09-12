package com.agontuk.RNFusedLocation;

import android.location.Location;

public interface LocationChangeListener {
    void onLocationChange(LocationProvider locationProvider, Location location);

    void onLocationError(LocationProvider locationProvider, LocationError locationError, String str);
}
