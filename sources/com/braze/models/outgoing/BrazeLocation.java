package com.braze.models.outgoing;

import android.location.Location;
import android.os.Build;
import com.braze.models.IBrazeLocation;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import com.braze.support.ValidationUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\b\u0018\u0000 .2\u00020\u0001:\u0001/B=\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b'\u0010(B\u0011\b\u0016\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b'\u0010+B\u0011\b\u0016\u0012\u0006\u0010,\u001a\u00020\t¢\u0006\u0004\b'\u0010-J\t\u0010\u0003\u001a\u00020\u0002HÂ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÂ\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÂ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÂ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÂ\u0003¢\u0006\u0004\b\b\u0010\u0006J\b\u0010\n\u001a\u00020\tH\u0016JH\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001aR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001bR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0016\u0010\"\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0006R\u0016\u0010$\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0006R\u0016\u0010&\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0006¨\u00060"}, d2 = {"Lcom/braze/models/outgoing/BrazeLocation;", "Lcom/braze/models/IBrazeLocation;", "", "component1", "component2", "component3", "()Ljava/lang/Double;", "component4", "component5", "Lorg/json/JSONObject;", "forJsonPut", "_latitude", "_longitude", "_altitude", "_accuracy", "_verticalAccuracy", "copy", "(DDLjava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/braze/models/outgoing/BrazeLocation;", "", "toString", "", "hashCode", "", "other", "", "equals", "D", "Ljava/lang/Double;", "getLatitude", "()D", "latitude", "getLongitude", "longitude", "getAltitude", "altitude", "getAccuracy", "accuracy", "getVerticalAccuracy", "verticalAccuracy", "<init>", "(DDLjava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "Landroid/location/Location;", "location", "(Landroid/location/Location;)V", "jsonObject", "(Lorg/json/JSONObject;)V", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public final class BrazeLocation implements IBrazeLocation {
    private static final a Companion = new a((DefaultConstructorMarker) null);
    private final Double _accuracy;
    private final Double _altitude;
    private final double _latitude;
    private final double _longitude;
    private final Double _verticalAccuracy;

    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }

        /* access modifiers changed from: private */
        public final Double a(Location location) {
            if (Build.VERSION.SDK_INT < 26 || !location.hasVerticalAccuracy()) {
                return null;
            }
            return Double.valueOf((double) location.getVerticalAccuracyMeters());
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception creating location Json.";
        }
    }

    public BrazeLocation(double d, double d2) {
        this(d, d2, (Double) null, (Double) null, (Double) null, 28, (DefaultConstructorMarker) null);
    }

    private final double component1() {
        return this._latitude;
    }

    private final double component2() {
        return this._longitude;
    }

    private final Double component3() {
        return this._altitude;
    }

    private final Double component4() {
        return this._accuracy;
    }

    private final Double component5() {
        return this._verticalAccuracy;
    }

    public static /* synthetic */ BrazeLocation copy$default(BrazeLocation brazeLocation, double d, double d2, Double d3, Double d4, Double d5, int i, Object obj) {
        BrazeLocation brazeLocation2 = brazeLocation;
        return brazeLocation.copy((i & 1) != 0 ? brazeLocation2._latitude : d, (i & 2) != 0 ? brazeLocation2._longitude : d2, (i & 4) != 0 ? brazeLocation2._altitude : d3, (i & 8) != 0 ? brazeLocation2._accuracy : d4, (i & 16) != 0 ? brazeLocation2._verticalAccuracy : d5);
    }

    public final BrazeLocation copy(double d, double d2, Double d3, Double d4, Double d5) {
        return new BrazeLocation(d, d2, d3, d4, d5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrazeLocation)) {
            return false;
        }
        BrazeLocation brazeLocation = (BrazeLocation) obj;
        return Double.compare(this._latitude, brazeLocation._latitude) == 0 && Double.compare(this._longitude, brazeLocation._longitude) == 0 && Intrinsics.areEqual((Object) this._altitude, (Object) brazeLocation._altitude) && Intrinsics.areEqual((Object) this._accuracy, (Object) brazeLocation._accuracy) && Intrinsics.areEqual((Object) this._verticalAccuracy, (Object) brazeLocation._verticalAccuracy);
    }

    public Double getAccuracy() {
        return this._accuracy;
    }

    public Double getAltitude() {
        return this._altitude;
    }

    public double getLatitude() {
        return this._latitude;
    }

    public double getLongitude() {
        return this._longitude;
    }

    public Double getVerticalAccuracy() {
        return this._verticalAccuracy;
    }

    public int hashCode() {
        int hashCode = ((Double.hashCode(this._latitude) * 31) + Double.hashCode(this._longitude)) * 31;
        Double d = this._altitude;
        int i = 0;
        int hashCode2 = (hashCode + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this._accuracy;
        int hashCode3 = (hashCode2 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this._verticalAccuracy;
        if (d3 != null) {
            i = d3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "BrazeLocation(_latitude=" + this._latitude + ", _longitude=" + this._longitude + ", _altitude=" + this._altitude + ", _accuracy=" + this._accuracy + ", _verticalAccuracy=" + this._verticalAccuracy + ')';
    }

    public BrazeLocation(double d, double d2, Double d3) {
        this(d, d2, d3, (Double) null, (Double) null, 24, (DefaultConstructorMarker) null);
    }

    public JSONObject forJsonPut() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IBrazeLocation.LATITUDE, getLatitude());
            jSONObject.put(IBrazeLocation.LONGITUDE, getLongitude());
            if (getAltitude() != null) {
                jSONObject.put(IBrazeLocation.ALTITUDE, (Object) getAltitude());
            }
            if (getAccuracy() != null) {
                jSONObject.put(IBrazeLocation.ACCURACY, (Object) getAccuracy());
            }
            if (getVerticalAccuracy() != null) {
                jSONObject.put(IBrazeLocation.VERTICAL_ACCURACY, (Object) getVerticalAccuracy());
            }
        } catch (JSONException e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) b.b);
        }
        return jSONObject;
    }

    public BrazeLocation(double d, double d2, Double d3, Double d4) {
        this(d, d2, d3, d4, (Double) null, 16, (DefaultConstructorMarker) null);
    }

    public BrazeLocation(double d, double d2, Double d3, Double d4, Double d5) {
        this._latitude = d;
        this._longitude = d2;
        this._altitude = d3;
        this._accuracy = d4;
        this._verticalAccuracy = d5;
        if (!ValidationUtils.isValidLocation(getLatitude(), getLongitude())) {
            throw new IllegalArgumentException("Unable to create BrazeLocation. Latitude and longitude values are bounded by ±90 and ±180 respectively".toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BrazeLocation(double d, double d2, Double d3, Double d4, Double d5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, d2, (i & 4) != 0 ? null : d3, (i & 8) != 0 ? null : d4, (i & 16) != 0 ? null : d5);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BrazeLocation(Location location) {
        this(location.getLatitude(), location.getLongitude(), location.hasAltitude() ? Double.valueOf(location.getAltitude()) : null, location.hasAccuracy() ? Double.valueOf((double) location.getAccuracy()) : null, Companion.a(location));
        Intrinsics.checkNotNullParameter(location, FirebaseAnalytics.Param.LOCATION);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BrazeLocation(JSONObject jSONObject) {
        this(jSONObject.getDouble(IBrazeLocation.LATITUDE), jSONObject.getDouble(IBrazeLocation.LONGITUDE), JsonUtils.getDoubleOrNull(jSONObject, IBrazeLocation.ALTITUDE), JsonUtils.getDoubleOrNull(jSONObject, IBrazeLocation.ACCURACY), JsonUtils.getDoubleOrNull(jSONObject, IBrazeLocation.VERTICAL_ACCURACY));
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
    }
}
