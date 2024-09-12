package com.braze.models;

import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u000f\bg\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011R\u0014\u0010\u0006\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Lcom/braze/models/IBrazeLocation;", "Lcom/braze/models/IPutIntoJson;", "Lorg/json/JSONObject;", "", "getLatitude", "()D", "latitude", "getLongitude", "longitude", "getAltitude", "()Ljava/lang/Double;", "altitude", "getAccuracy", "accuracy", "getVerticalAccuracy", "verticalAccuracy", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public interface IBrazeLocation extends IPutIntoJson<JSONObject> {
    public static final String ACCURACY = "ll_accuracy";
    public static final String ALTITUDE = "altitude";
    public static final a Companion = a.a;
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String VERTICAL_ACCURACY = "alt_accuracy";

    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    Double getAccuracy();

    Double getAltitude();

    double getLatitude();

    double getLongitude();

    Double getVerticalAccuracy();
}
