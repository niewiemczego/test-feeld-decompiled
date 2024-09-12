package com.framgia.android.emulator;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmulatorDetectorConfig {
    boolean A;
    boolean B;
    String[] a;
    HashMap b;
    String[] c;
    Map d;
    Map e;
    String[] f;
    String[] g;
    String[] h;
    String[] i;
    String[] j;
    String[] k;
    String[] l;
    String[] m;

    /* renamed from: n  reason: collision with root package name */
    String[] f24n;
    String[] o;
    String[] p;
    String[] q;
    String[] r;
    String[] s;
    String[] t;
    String[] u;
    String[] v;
    String[] w;
    String[] x;
    String[] y;
    int z;

    private JSONArray a(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        if (objArr == null) {
            jSONArray.put(JSONObject.NULL);
            return jSONArray;
        }
        for (Object put : objArr) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    public String toString() {
        return a();
    }

    private Object a(Object obj) {
        if (obj instanceof HashMap) {
            JSONObject jSONObject = new JSONObject();
            HashMap hashMap = (HashMap) obj;
            for (Object next : hashMap.keySet()) {
                jSONObject.put(next.toString(), a(hashMap.get(next)));
            }
            return jSONObject;
        } else if (!(obj instanceof Iterable)) {
            return obj;
        } else {
            JSONArray jSONArray = new JSONArray();
            for (Object a2 : (Iterable) obj) {
                jSONArray.put(a(a2));
            }
            return jSONArray;
        }
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("processNames", (Object) a((Object[]) this.a));
            jSONObject.put("qemuDrivers", (Object) a((Object[]) this.c));
            jSONObject.put("propertiesWithSeekValues", a((Object) this.d));
            jSONObject.put("packageNames", (Object) a((Object[]) this.f));
            jSONObject.put("ipValues", (Object) a((Object[]) this.g));
            jSONObject.put("ssidValues", (Object) a((Object[]) this.h));
            jSONObject.put("buildFingerprintFilters", (Object) a((Object[]) this.i));
            jSONObject.put("buildModelFilters", (Object) a((Object[]) this.j));
            jSONObject.put("buildDeviceFilters", (Object) a((Object[]) this.k));
            jSONObject.put("buildManufacturerFilters", (Object) a((Object[]) this.l));
            jSONObject.put("buildDisplayFilters", (Object) a((Object[]) this.m));
            jSONObject.put("buildHardwareFilters", (Object) a((Object[]) this.f24n));
            jSONObject.put("buildProductFilters", (Object) a((Object[]) this.o));
            jSONObject.put("buildBoardFilters", (Object) a((Object[]) this.p));
            jSONObject.put("buildBootloaderFilters", (Object) a((Object[]) this.q));
            jSONObject.put("buildHostFilters", (Object) a((Object[]) this.r));
            jSONObject.put("buildRadioFilters", (Object) a((Object[]) this.s));
            jSONObject.put("buildBrandFilters", (Object) a((Object[]) this.t));
            jSONObject.put("buildFlavorFilters", (Object) a((Object[]) this.u));
            jSONObject.put("cpuTypes", (Object) a((Object[]) this.v));
            jSONObject.put("kernelArchitectures", (Object) a((Object[]) this.w));
            jSONObject.put("kernelVersions", (Object) a((Object[]) this.x));
            jSONObject.put("minPropertiesThreshold", this.z);
            jSONObject.put("checkTelephony", this.A);
            jSONObject.put("checkPackageNames", this.B);
            jSONObject.put("sensorNames", (Object) this.y);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
