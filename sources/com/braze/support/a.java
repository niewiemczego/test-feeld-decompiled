package com.braze.support;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import bo.app.q3;
import com.braze.support.BrazeLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class a {
    public static final a a = new a();

    /* renamed from: com.braze.support.a$a  reason: collision with other inner class name */
    static final class C0033a extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0033a(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unexpected system broadcast received [" + this.b + ']';
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get active network information. Ensure the permission android.permission.ACCESS_NETWORK_STATE is defined in your AndroidManifest.xml";
        }
    }

    private a() {
    }

    public static final q3 a(Intent intent, ConnectivityManager connectivityManager) {
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        Intrinsics.checkNotNullParameter(connectivityManager, "connectivityManager");
        String action = intent.getAction();
        if (Intrinsics.areEqual((Object) BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION, (Object) action)) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
                if (activeNetworkInfo == null || booleanExtra) {
                    return q3.NONE;
                }
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    int subtype = activeNetworkInfo.getSubtype();
                    if (subtype == 3) {
                        return q3.GOOD;
                    }
                    if (subtype == 13 || subtype == 20) {
                        return q3.GREAT;
                    }
                    return q3.BAD;
                } else if (type == 1 || type == 6) {
                    return q3.GREAT;
                } else {
                    if (type != 9) {
                        return q3.NONE;
                    }
                    return q3.GOOD;
                }
            } catch (SecurityException e) {
                BrazeLogger.INSTANCE.brazelog((Object) a, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) b.b);
                return q3.NONE;
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) a, BrazeLogger.Priority.W, (Throwable) null, (Function0) new C0033a(action), 2, (Object) null);
            return q3.NONE;
        }
    }

    public static final q3 a(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null) {
            return q3.NONE;
        }
        int min = Math.min(networkCapabilities.getLinkDownstreamBandwidthKbps(), networkCapabilities.getLinkUpstreamBandwidthKbps());
        if (min > 14000) {
            return q3.GREAT;
        }
        if (min > 4000) {
            return q3.GOOD;
        }
        return q3.BAD;
    }
}
