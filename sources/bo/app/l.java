package bo.app;

import android.app.PendingIntent;
import android.content.Context;
import com.braze.location.IBrazeGeofenceApi;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public final class l {
    private IBrazeGeofenceApi a;

    public l() {
        IBrazeGeofenceApi iBrazeGeofenceApi;
        try {
            Object newInstance = Class.forName("com.braze.location.BrazeInternalGeofenceApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.braze.location.IBrazeGeofenceApi");
            iBrazeGeofenceApi = (IBrazeGeofenceApi) newInstance;
        } catch (Exception unused) {
            iBrazeGeofenceApi = null;
        }
        this.a = iBrazeGeofenceApi;
    }

    public final boolean a() {
        return this.a != null;
    }

    public final PendingIntent b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IBrazeGeofenceApi iBrazeGeofenceApi = this.a;
        if (iBrazeGeofenceApi != null) {
            return iBrazeGeofenceApi.getGeofenceTransitionPendingIntent(context);
        }
        return null;
    }

    public final void a(Context context, PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        Intrinsics.checkNotNullParameter(pendingIntent, SDKConstants.PARAM_INTENT);
        IBrazeGeofenceApi iBrazeGeofenceApi = this.a;
        if (iBrazeGeofenceApi != null) {
            iBrazeGeofenceApi.teardownGeofences(context, pendingIntent);
        }
    }

    public final void a(Context context, List list, PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "geofenceList");
        Intrinsics.checkNotNullParameter(pendingIntent, "geofenceRequestIntent");
        IBrazeGeofenceApi iBrazeGeofenceApi = this.a;
        if (iBrazeGeofenceApi != null) {
            iBrazeGeofenceApi.registerGeofences(context, list, pendingIntent);
        }
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IBrazeGeofenceApi iBrazeGeofenceApi = this.a;
        if (iBrazeGeofenceApi != null) {
            iBrazeGeofenceApi.deleteRegisteredGeofenceCache(context);
        }
    }
}
