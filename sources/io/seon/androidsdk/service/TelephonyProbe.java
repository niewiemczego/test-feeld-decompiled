package io.seon.androidsdk.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import com.facebook.internal.AnalyticsEvents;
import io.seon.androidsdk.logger.Logger;
import java.util.HashMap;
import java.util.Map;

class TelephonyProbe extends AbstractSeonProbe {
    static final String[] c = {"carrier_name", "carrier_country", "device_id", "network_config", "is_on_call"};
    private static final Logger d = Logger.withClass(TelephonyProbe.class);
    private Context a;
    private TelephonyManager b;

    TelephonyProbe() {
    }

    /* access modifiers changed from: private */
    public String b() {
        TelephonyManager telephonyManager = this.b;
        if (telephonyManager == null || telephonyManager.getNetworkCountryIso().isEmpty()) {
            return null;
        }
        return this.b.getNetworkCountryIso().toUpperCase();
    }

    /* access modifiers changed from: private */
    public String c() {
        TelephonyManager telephonyManager = this.b;
        if (telephonyManager == null || telephonyManager.getNetworkOperatorName().isEmpty()) {
            return null;
        }
        return this.b.getNetworkOperatorName();
    }

    /* access modifiers changed from: private */
    public String d() {
        int i = Build.VERSION.SDK_INT;
        if (i > 28) {
            return MediaProbe.g();
        }
        if (this.b == null) {
            d.log("Failed to get TelephonyManager", 6);
            return "";
        }
        if (i >= 29 || !SeonUtil.a(this.a, "android.permission.READ_PHONE_STATE")) {
            d.log("There is no granted READ_PHONE_STATE permission", 6);
        } else if (this.b.getDeviceId() != null) {
            return this.b.getDeviceId();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public String f() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
        if (connectivityManager == null) {
            return "No wifi or cellular";
        }
        if (SeonUtil.a(this.a, "android.permission.ACCESS_NETWORK_STATE") && connectivityManager.getNetworkInfo(1).isConnected()) {
            return "WIFI";
        }
        if (this.b == null) {
            return "No wifi or cellular";
        }
        if (!SeonUtil.a(this.a, "android.permission.READ_PHONE_STATE")) {
            d.log("There is no granted READ_PHONE_STATE permission", 6);
            return "UNKNOWN";
        }
        switch (Build.VERSION.SDK_INT < 24 ? this.b.getNetworkType() : this.b.getDataNetworkType()) {
            case 0:
                return "UNKNOWN";
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            case 16:
                return "GSM";
            case 17:
                return "TD_SCDMA";
            case 18:
                return "IWLAN";
            case 20:
                return "NR";
            default:
                return "No wifi or cellular";
        }
    }

    private boolean k() {
        try {
            return this.a.getPackageManager().hasSystemFeature("android.hardware.telephony");
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean l() {
        if (!SeonUtil.a(this.a, "android.permission.READ_PHONE_STATE")) {
            return false;
        }
        return ((TelecomManager) this.a.getSystemService("telecom")).isInCall();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a() {
        /*
            r5 = this;
            r0 = -1
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0036 }
            r2 = 30
            if (r1 < r2) goto L_0x000e
            android.telephony.TelephonyManager r1 = r5.b     // Catch:{ Exception -> 0x0036 }
            int r0 = r1.getActiveModemCount()     // Catch:{ Exception -> 0x0036 }
            return r0
        L_0x000e:
            r2 = 23
            if (r1 < r2) goto L_0x0019
            android.telephony.TelephonyManager r1 = r5.b     // Catch:{ Exception -> 0x0036 }
            int r0 = r1.getPhoneCount()     // Catch:{ Exception -> 0x0036 }
            return r0
        L_0x0019:
            java.lang.String r1 = "android.telephony.TelephonyManager"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{  }
            java.lang.String r2 = "getSimCount"
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{  }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{  }
            android.telephony.TelephonyManager r2 = r5.b     // Catch:{  }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{  }
            java.lang.Object r1 = r1.invoke(r2, r3)     // Catch:{  }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{  }
            int r0 = r1.intValue()     // Catch:{  }
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.seon.androidsdk.service.TelephonyProbe.a():int");
    }

    public void bootstrap(Context context) {
        this.a = context;
        try {
            this.b = (TelephonyManager) context.getSystemService("phone");
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public String e() {
        return SeonUtil.a("gsm.operator.isroaming", this.a);
    }

    /* access modifiers changed from: package-private */
    public String g() {
        if (!k()) {
            return "N/A";
        }
        try {
            return this.b.getSimState() == 5 ? this.b.getSimOperator() : "Unavailable";
        } catch (Exception unused) {
            return null;
        }
    }

    public Map getExperimentalFields() {
        HashMap hashMap = new HashMap();
        hashMap.put("gsm_roaming_state", safeGet(new TelephonyProbe$$ExternalSyntheticLambda6(this)));
        hashMap.put("sim_operator_name", safeGet(new TelephonyProbe$$ExternalSyntheticLambda7(this)));
        hashMap.put("sim_operator_country", safeGet(new TelephonyProbe$$ExternalSyntheticLambda8(this)));
        hashMap.put("sim_operator_code", safeGet(new TelephonyProbe$$ExternalSyntheticLambda9(this)));
        hashMap.put("sim_state", safeGet(new TelephonyProbe$$ExternalSyntheticLambda10(this)));
        hashMap.put("sim_slot_count", safeGet(new TelephonyProbe$$ExternalSyntheticLambda1(this)));
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public String h() {
        if (!k()) {
            return "N/A";
        }
        try {
            return this.b.getSimState() == 5 ? this.b.getSimCountryIso() : "Unavailable";
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String i() {
        if (!k()) {
            return "N/A";
        }
        try {
            return this.b.getSimState() == 5 ? this.b.getSimOperatorName() : "Unavailable";
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String j() {
        if (!k()) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(1, "Absent");
            hashMap.put(4, "Network Locked");
            hashMap.put(2, "PIN Locked");
            hashMap.put(3, "PUK Locked");
            hashMap.put(5, "Ready");
            hashMap.put(0, "State Unknown");
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                hashMap.put(8, "IO Error");
                hashMap.put(9, "Restricted");
                hashMap.put(6, "Not Ready");
                hashMap.put(7, "Permanently Disabled");
            }
            int a2 = a();
            if (i < 26 || a2 <= 1) {
                String str = (String) hashMap.get(Integer.valueOf(this.b.getSimState()));
                return str != null ? str : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < a2; i2++) {
                sb.append((String) hashMap.getOrDefault(Integer.valueOf(this.b.getSimState(i2)), AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN));
                sb.append(";");
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public Map scan() {
        HashMap hashMap = new HashMap();
        hashMap.put("carrier_name", safeGet(new TelephonyProbe$$ExternalSyntheticLambda0(this)));
        hashMap.put("carrier_country", safeGet(new TelephonyProbe$$ExternalSyntheticLambda2(this)));
        hashMap.put("device_id", safeGet(new TelephonyProbe$$ExternalSyntheticLambda3(this)));
        hashMap.put("network_config", safeGet(new TelephonyProbe$$ExternalSyntheticLambda4(this)));
        hashMap.put("is_on_call", safeGet(new TelephonyProbe$$ExternalSyntheticLambda5(this)));
        return hashMap;
    }
}
