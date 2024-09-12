package io.sentry.android.core.internal.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import io.sentry.IConnectionStatusProvider;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.android.core.BuildInfoProvider;
import java.util.HashMap;
import java.util.Map;

public final class AndroidConnectionStatusProvider implements IConnectionStatusProvider {
    private final BuildInfoProvider buildInfoProvider;
    private final Context context;
    private final ILogger logger;
    private final Map<IConnectionStatusProvider.IConnectionStatusObserver, ConnectivityManager.NetworkCallback> registeredCallbacks = new HashMap();

    public AndroidConnectionStatusProvider(Context context2, ILogger iLogger, BuildInfoProvider buildInfoProvider2) {
        this.context = context2;
        this.logger = iLogger;
        this.buildInfoProvider = buildInfoProvider2;
    }

    public IConnectionStatusProvider.ConnectionStatus getConnectionStatus() {
        ConnectivityManager connectivityManager = getConnectivityManager(this.context, this.logger);
        if (connectivityManager == null) {
            return IConnectionStatusProvider.ConnectionStatus.UNKNOWN;
        }
        return getConnectionStatus(this.context, connectivityManager, this.logger);
    }

    public String getConnectionType() {
        return getConnectionType(this.context, this.logger, this.buildInfoProvider);
    }

    public boolean addConnectionStatusObserver(final IConnectionStatusProvider.IConnectionStatusObserver iConnectionStatusObserver) {
        if (this.buildInfoProvider.getSdkInfoVersion() < 21) {
            this.logger.log(SentryLevel.DEBUG, "addConnectionStatusObserver requires Android 5+.", new Object[0]);
            return false;
        }
        AnonymousClass1 r0 = new ConnectivityManager.NetworkCallback() {
            public void onAvailable(Network network) {
                iConnectionStatusObserver.onConnectionStatusChanged(AndroidConnectionStatusProvider.this.getConnectionStatus());
            }

            public void onLosing(Network network, int i) {
                iConnectionStatusObserver.onConnectionStatusChanged(AndroidConnectionStatusProvider.this.getConnectionStatus());
            }

            public void onLost(Network network) {
                iConnectionStatusObserver.onConnectionStatusChanged(AndroidConnectionStatusProvider.this.getConnectionStatus());
            }

            public void onUnavailable() {
                iConnectionStatusObserver.onConnectionStatusChanged(AndroidConnectionStatusProvider.this.getConnectionStatus());
            }
        };
        this.registeredCallbacks.put(iConnectionStatusObserver, r0);
        return registerNetworkCallback(this.context, this.logger, this.buildInfoProvider, r0);
    }

    public void removeConnectionStatusObserver(IConnectionStatusProvider.IConnectionStatusObserver iConnectionStatusObserver) {
        ConnectivityManager.NetworkCallback remove = this.registeredCallbacks.remove(iConnectionStatusObserver);
        if (remove != null) {
            unregisterNetworkCallback(this.context, this.logger, this.buildInfoProvider, remove);
        }
    }

    private static IConnectionStatusProvider.ConnectionStatus getConnectionStatus(Context context2, ConnectivityManager connectivityManager, ILogger iLogger) {
        if (!Permissions.hasPermission(context2, "android.permission.ACCESS_NETWORK_STATE")) {
            iLogger.log(SentryLevel.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return IConnectionStatusProvider.ConnectionStatus.NO_PERMISSION;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                iLogger.log(SentryLevel.INFO, "NetworkInfo is null, there's no active network.", new Object[0]);
                return IConnectionStatusProvider.ConnectionStatus.DISCONNECTED;
            } else if (activeNetworkInfo.isConnected()) {
                return IConnectionStatusProvider.ConnectionStatus.CONNECTED;
            } else {
                return IConnectionStatusProvider.ConnectionStatus.DISCONNECTED;
            }
        } catch (Throwable th) {
            iLogger.log(SentryLevel.WARNING, "Could not retrieve Connection Status", th);
            return IConnectionStatusProvider.ConnectionStatus.UNKNOWN;
        }
    }

    public static String getConnectionType(Context context2, ILogger iLogger, BuildInfoProvider buildInfoProvider2) {
        boolean z;
        ConnectivityManager connectivityManager = getConnectivityManager(context2, iLogger);
        if (connectivityManager == null) {
            return null;
        }
        boolean z2 = false;
        if (!Permissions.hasPermission(context2, "android.permission.ACCESS_NETWORK_STATE")) {
            iLogger.log(SentryLevel.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return null;
        }
        try {
            boolean z3 = true;
            if (buildInfoProvider2.getSdkInfoVersion() >= 23) {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork == null) {
                    iLogger.log(SentryLevel.INFO, "Network is null and cannot check network status", new Object[0]);
                    return null;
                }
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities == null) {
                    iLogger.log(SentryLevel.INFO, "NetworkCapabilities is null and cannot check network type", new Object[0]);
                    return null;
                }
                boolean hasTransport = networkCapabilities.hasTransport(3);
                z = networkCapabilities.hasTransport(1);
                z3 = networkCapabilities.hasTransport(0);
                z2 = hasTransport;
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    iLogger.log(SentryLevel.INFO, "NetworkInfo is null, there's no active network.", new Object[0]);
                    return null;
                }
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    z = false;
                } else if (type != 1) {
                    if (type != 9) {
                        z = false;
                    } else {
                        z = false;
                        z2 = true;
                    }
                    z3 = z;
                } else {
                    z = true;
                    z3 = false;
                }
            }
            if (z2) {
                return "ethernet";
            }
            if (z) {
                return "wifi";
            }
            if (z3) {
                return "cellular";
            }
            return null;
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Failed to retrieve network info", th);
        }
    }

    public static String getConnectionType(NetworkCapabilities networkCapabilities, BuildInfoProvider buildInfoProvider2) {
        if (buildInfoProvider2.getSdkInfoVersion() < 21) {
            return null;
        }
        if (networkCapabilities.hasTransport(3)) {
            return "ethernet";
        }
        if (networkCapabilities.hasTransport(1)) {
            return "wifi";
        }
        if (networkCapabilities.hasTransport(0)) {
            return "cellular";
        }
        return null;
    }

    private static ConnectivityManager getConnectivityManager(Context context2, ILogger iLogger) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
        if (connectivityManager == null) {
            iLogger.log(SentryLevel.INFO, "ConnectivityManager is null and cannot check network status", new Object[0]);
        }
        return connectivityManager;
    }

    public static boolean registerNetworkCallback(Context context2, ILogger iLogger, BuildInfoProvider buildInfoProvider2, ConnectivityManager.NetworkCallback networkCallback) {
        if (buildInfoProvider2.getSdkInfoVersion() < 24) {
            iLogger.log(SentryLevel.DEBUG, "NetworkCallbacks need Android N+.", new Object[0]);
            return false;
        }
        ConnectivityManager connectivityManager = getConnectivityManager(context2, iLogger);
        if (connectivityManager == null) {
            return false;
        }
        if (!Permissions.hasPermission(context2, "android.permission.ACCESS_NETWORK_STATE")) {
            iLogger.log(SentryLevel.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return false;
        }
        try {
            connectivityManager.registerDefaultNetworkCallback(networkCallback);
            return true;
        } catch (Throwable th) {
            iLogger.log(SentryLevel.WARNING, "registerDefaultNetworkCallback failed", th);
            return false;
        }
    }

    public static void unregisterNetworkCallback(Context context2, ILogger iLogger, BuildInfoProvider buildInfoProvider2, ConnectivityManager.NetworkCallback networkCallback) {
        ConnectivityManager connectivityManager;
        if (buildInfoProvider2.getSdkInfoVersion() >= 21 && (connectivityManager = getConnectivityManager(context2, iLogger)) != null) {
            try {
                connectivityManager.unregisterNetworkCallback(networkCallback);
            } catch (Throwable th) {
                iLogger.log(SentryLevel.WARNING, "unregisterNetworkCallback failed", th);
            }
        }
    }

    public Map<IConnectionStatusProvider.IConnectionStatusObserver, ConnectivityManager.NetworkCallback> getRegisteredCallbacks() {
        return this.registeredCallbacks;
    }
}
