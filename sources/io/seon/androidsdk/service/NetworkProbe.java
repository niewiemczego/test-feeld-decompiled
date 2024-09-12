package io.seon.androidsdk.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ProxyInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.facebook.internal.security.CertificateUtil;
import io.seon.androidsdk.logger.Logger;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class NetworkProbe extends AbstractSeonProbe {
    static final String[] c = {"wifi_mac_address", "wifi_ssid"};
    private static final Logger d = Logger.withClass(NetworkProbe.class);
    private Context a;
    ConnectivityManager b;

    enum NetworkEnum {
        UNKNOWN,
        VPN_CONNECTED,
        VPN_NOT_CONNECTED,
        PROXY_CONNECTED,
        PROXY_NOT_CONNECTED
    }

    NetworkProbe() {
    }

    /* access modifiers changed from: private */
    public String d() {
        try {
            for (T t : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (t.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = t.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return null;
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            d.withCause(e, 6);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public String e() {
        String ssid;
        WifiManager wifiManager = (WifiManager) this.a.getApplicationContext().getSystemService("wifi");
        if (SeonUtil.a(this.a, "android.permission.ACCESS_WIFI_STATE")) {
            WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
            if (!(connectionInfo == null || (ssid = connectionInfo.getSSID()) == null || ssid.toLowerCase().contains("unknown"))) {
                String replace = ssid.replace("\"", "");
                if (replace.equals("0x")) {
                    return null;
                }
                return replace;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f() {
        this.b = (ConnectivityManager) this.a.getSystemService("connectivity");
    }

    /* access modifiers changed from: package-private */
    public String a() {
        ConnectivityManager connectivityManager;
        ProxyInfo defaultProxy;
        try {
            if (Build.VERSION.SDK_INT < 23 || (connectivityManager = this.b) == null || (defaultProxy = connectivityManager.getDefaultProxy()) == null) {
                return null;
            }
            return defaultProxy.getHost() + CertificateUtil.DELIMITER + defaultProxy.getPort();
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public NetworkEnum b() {
        ConnectivityManager connectivityManager;
        try {
            if (Build.VERSION.SDK_INT >= 23 && (connectivityManager = this.b) != null) {
                return connectivityManager.getDefaultProxy() != null ? NetworkEnum.PROXY_CONNECTED : NetworkEnum.PROXY_NOT_CONNECTED;
            }
        } catch (Exception unused) {
        }
        return NetworkEnum.UNKNOWN;
    }

    public void bootstrap(Context context) {
        this.a = context;
        SeonUtil.a((Runnable) new NetworkProbe$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: package-private */
    public NetworkEnum c() {
        ConnectivityManager connectivityManager;
        try {
            if (Build.VERSION.SDK_INT >= 23 && (connectivityManager = this.b) != null) {
                return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()).hasTransport(4) ? NetworkEnum.VPN_CONNECTED : NetworkEnum.VPN_NOT_CONNECTED;
            }
        } catch (Exception unused) {
        }
        return NetworkEnum.UNKNOWN;
    }

    public Map getExperimentalFields() {
        HashMap hashMap = new HashMap();
        hashMap.put("vpn_state", safeGet(new NetworkProbe$$ExternalSyntheticLambda0(this)));
        hashMap.put("proxy_state", safeGet(new NetworkProbe$$ExternalSyntheticLambda1(this)));
        hashMap.put("proxy_address", safeGet(new NetworkProbe$$ExternalSyntheticLambda2(this)));
        return hashMap;
    }

    public Map scan() {
        HashMap hashMap = new HashMap();
        hashMap.put("wifi_mac_address", safeGet(new NetworkProbe$$ExternalSyntheticLambda4(this)));
        hashMap.put("wifi_ssid", safeGet(new NetworkProbe$$ExternalSyntheticLambda5(this)));
        return hashMap;
    }
}
