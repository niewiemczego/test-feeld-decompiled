package com.google.android.exoplayer2;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.google.android.exoplayer2.util.Log;

final class WifiLockManager {
    private static final String TAG = "WifiLockManager";
    private static final String WIFI_LOCK_TAG = "ExoPlayer:WifiLockManager";
    private boolean enabled;
    private boolean stayAwake;
    private WifiManager.WifiLock wifiLock;
    private final WifiManager wifiManager;

    public WifiLockManager(Context context) {
        this.wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    public void setEnabled(boolean z) {
        if (z && this.wifiLock == null) {
            WifiManager wifiManager2 = this.wifiManager;
            if (wifiManager2 == null) {
                Log.w(TAG, "WifiManager is null, therefore not creating the WifiLock.");
                return;
            }
            WifiManager.WifiLock createWifiLock = wifiManager2.createWifiLock(3, WIFI_LOCK_TAG);
            this.wifiLock = createWifiLock;
            createWifiLock.setReferenceCounted(false);
        }
        this.enabled = z;
        updateWifiLock();
    }

    public void setStayAwake(boolean z) {
        this.stayAwake = z;
        updateWifiLock();
    }

    private void updateWifiLock() {
        WifiManager.WifiLock wifiLock2 = this.wifiLock;
        if (wifiLock2 != null) {
            if (!this.enabled || !this.stayAwake) {
                wifiLock2.release();
            } else {
                wifiLock2.acquire();
            }
        }
    }
}
