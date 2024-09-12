package com.google.android.exoplayer2.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;

public final class RequirementsWatcher {
    private final Context context;
    /* access modifiers changed from: private */
    public final Handler handler = Util.createHandlerForCurrentOrMainLooper();
    private final Listener listener;
    /* access modifiers changed from: private */
    public NetworkCallback networkCallback;
    private int notMetRequirements;
    private DeviceStatusChangeReceiver receiver;
    private final Requirements requirements;

    public interface Listener {
        void onRequirementsStateChanged(RequirementsWatcher requirementsWatcher, int i);
    }

    public RequirementsWatcher(Context context2, Listener listener2, Requirements requirements2) {
        this.context = context2.getApplicationContext();
        this.listener = listener2;
        this.requirements = requirements2;
    }

    public int start() {
        this.notMetRequirements = this.requirements.getNotMetRequirements(this.context);
        IntentFilter intentFilter = new IntentFilter();
        if (this.requirements.isNetworkRequired()) {
            if (Util.SDK_INT >= 24) {
                registerNetworkCallbackV24();
            } else {
                intentFilter.addAction(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION);
            }
        }
        if (this.requirements.isChargingRequired()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.requirements.isIdleRequired()) {
            if (Util.SDK_INT >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        if (this.requirements.isStorageNotLowRequired()) {
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        }
        DeviceStatusChangeReceiver deviceStatusChangeReceiver = new DeviceStatusChangeReceiver();
        this.receiver = deviceStatusChangeReceiver;
        this.context.registerReceiver(deviceStatusChangeReceiver, intentFilter, (String) null, this.handler);
        return this.notMetRequirements;
    }

    public void stop() {
        this.context.unregisterReceiver((BroadcastReceiver) Assertions.checkNotNull(this.receiver));
        this.receiver = null;
        if (Util.SDK_INT >= 24 && this.networkCallback != null) {
            unregisterNetworkCallbackV24();
        }
    }

    public Requirements getRequirements() {
        return this.requirements;
    }

    private void registerNetworkCallbackV24() {
        NetworkCallback networkCallback2 = new NetworkCallback();
        this.networkCallback = networkCallback2;
        ((ConnectivityManager) Assertions.checkNotNull((ConnectivityManager) this.context.getSystemService("connectivity"))).registerDefaultNetworkCallback(networkCallback2);
    }

    private void unregisterNetworkCallbackV24() {
        ((ConnectivityManager) Assertions.checkNotNull((ConnectivityManager) this.context.getSystemService("connectivity"))).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) Assertions.checkNotNull(this.networkCallback));
        this.networkCallback = null;
    }

    /* access modifiers changed from: private */
    public void checkRequirements() {
        int notMetRequirements2 = this.requirements.getNotMetRequirements(this.context);
        if (this.notMetRequirements != notMetRequirements2) {
            this.notMetRequirements = notMetRequirements2;
            this.listener.onRequirementsStateChanged(this, notMetRequirements2);
        }
    }

    /* access modifiers changed from: private */
    public void recheckNotMetNetworkRequirements() {
        if ((this.notMetRequirements & 3) != 0) {
            checkRequirements();
        }
    }

    private class DeviceStatusChangeReceiver extends BroadcastReceiver {
        private DeviceStatusChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!isInitialStickyBroadcast()) {
                RequirementsWatcher.this.checkRequirements();
            }
        }
    }

    private final class NetworkCallback extends ConnectivityManager.NetworkCallback {
        private boolean networkValidated;
        private boolean receivedCapabilitiesChange;

        private NetworkCallback() {
        }

        public void onAvailable(Network network) {
            postCheckRequirements();
        }

        public void onLost(Network network) {
            postCheckRequirements();
        }

        public void onBlockedStatusChanged(Network network, boolean z) {
            if (!z) {
                postRecheckNotMetNetworkRequirements();
            }
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            boolean hasCapability = networkCapabilities.hasCapability(16);
            if (!this.receivedCapabilitiesChange || this.networkValidated != hasCapability) {
                this.receivedCapabilitiesChange = true;
                this.networkValidated = hasCapability;
                postCheckRequirements();
            } else if (hasCapability) {
                postRecheckNotMetNetworkRequirements();
            }
        }

        private void postCheckRequirements() {
            RequirementsWatcher.this.handler.post(new RequirementsWatcher$NetworkCallback$$ExternalSyntheticLambda1(this));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$postCheckRequirements$0$com-google-android-exoplayer2-scheduler-RequirementsWatcher$NetworkCallback  reason: not valid java name */
        public /* synthetic */ void m500lambda$postCheckRequirements$0$comgoogleandroidexoplayer2schedulerRequirementsWatcher$NetworkCallback() {
            if (RequirementsWatcher.this.networkCallback != null) {
                RequirementsWatcher.this.checkRequirements();
            }
        }

        private void postRecheckNotMetNetworkRequirements() {
            RequirementsWatcher.this.handler.post(new RequirementsWatcher$NetworkCallback$$ExternalSyntheticLambda0(this));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$postRecheckNotMetNetworkRequirements$1$com-google-android-exoplayer2-scheduler-RequirementsWatcher$NetworkCallback  reason: not valid java name */
        public /* synthetic */ void m501lambda$postRecheckNotMetNetworkRequirements$1$comgoogleandroidexoplayer2schedulerRequirementsWatcher$NetworkCallback() {
            if (RequirementsWatcher.this.networkCallback != null) {
                RequirementsWatcher.this.recheckNotMetNetworkRequirements();
            }
        }
    }
}
