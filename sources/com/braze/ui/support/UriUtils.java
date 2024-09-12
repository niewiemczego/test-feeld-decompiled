package com.braze.ui.support;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.support.BrazeLogger;
import com.braze.ui.BrazeDeeplinkHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0001\u001a\u0016\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\f*\u00020\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"TAG", "", "getMainActivityIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "extras", "Landroid/os/Bundle;", "isActivityRegisteredInManifest", "", "className", "getQueryParameters", "", "Landroid/net/Uri;", "android-sdk-ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: UriUtils.kt */
public final class UriUtils {
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("UriUtils");

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bf A[Catch:{ Exception -> 0x00c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Map<java.lang.String, java.lang.String> getQueryParameters(android.net.Uri r8) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r0.element = r8
            T r8 = r0.element
            android.net.Uri r8 = (android.net.Uri) r8
            java.lang.String r8 = r8.getEncodedQuery()
            if (r8 != 0) goto L_0x002f
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r2 = TAG
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.V
            r4 = 0
            com.braze.ui.support.UriUtils$getQueryParameters$1 r8 = new com.braze.ui.support.UriUtils$getQueryParameters$1
            r8.<init>(r0)
            r5 = r8
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r6 = 4
            r7 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.String) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
            java.util.Map r8 = kotlin.collections.MapsKt.emptyMap()
            return r8
        L_0x002f:
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.util.Map r1 = (java.util.Map) r1
            T r2 = r0.element     // Catch:{ Exception -> 0x00c8 }
            android.net.Uri r2 = (android.net.Uri) r2     // Catch:{ Exception -> 0x00c8 }
            boolean r2 = r2.isOpaque()     // Catch:{ Exception -> 0x00c8 }
            if (r2 == 0) goto L_0x0059
            java.lang.String r2 = "://"
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x00c8 }
            android.net.Uri$Builder r2 = r2.buildUpon()     // Catch:{ Exception -> 0x00c8 }
            android.net.Uri$Builder r8 = r2.encodedQuery(r8)     // Catch:{ Exception -> 0x00c8 }
            android.net.Uri r8 = r8.build()     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r2 = "parse(\"://\")\n           …\n                .build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)     // Catch:{ Exception -> 0x00c8 }
            r0.element = r8     // Catch:{ Exception -> 0x00c8 }
        L_0x0059:
            T r8 = r0.element     // Catch:{ Exception -> 0x00c8 }
            android.net.Uri r8 = (android.net.Uri) r8     // Catch:{ Exception -> 0x00c8 }
            java.util.Set r8 = r8.getQueryParameterNames()     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r2 = "uri.queryParameterNames"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)     // Catch:{ Exception -> 0x00c8 }
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch:{ Exception -> 0x00c8 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x00c8 }
            r2.<init>()     // Catch:{ Exception -> 0x00c8 }
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ Exception -> 0x00c8 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x00c8 }
        L_0x0073:
            boolean r3 = r8.hasNext()     // Catch:{ Exception -> 0x00c8 }
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0094
            java.lang.Object r3 = r8.next()     // Catch:{ Exception -> 0x00c8 }
            r6 = r3
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x00c8 }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x00c8 }
            if (r6 == 0) goto L_0x008c
            int r6 = r6.length()     // Catch:{ Exception -> 0x00c8 }
            if (r6 != 0) goto L_0x008d
        L_0x008c:
            r4 = r5
        L_0x008d:
            r4 = r4 ^ r5
            if (r4 == 0) goto L_0x0073
            r2.add(r3)     // Catch:{ Exception -> 0x00c8 }
            goto L_0x0073
        L_0x0094:
            java.util.List r2 = (java.util.List) r2     // Catch:{ Exception -> 0x00c8 }
            java.util.Iterator r8 = r2.iterator()     // Catch:{ Exception -> 0x00c8 }
        L_0x009a:
            boolean r2 = r8.hasNext()     // Catch:{ Exception -> 0x00c8 }
            if (r2 == 0) goto L_0x00db
            java.lang.Object r2 = r8.next()     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x00c8 }
            T r3 = r0.element     // Catch:{ Exception -> 0x00c8 }
            android.net.Uri r3 = (android.net.Uri) r3     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r3 = r3.getQueryParameter(r2)     // Catch:{ Exception -> 0x00c8 }
            r6 = r3
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x00c8 }
            if (r6 == 0) goto L_0x00bc
            int r6 = r6.length()     // Catch:{ Exception -> 0x00c8 }
            if (r6 != 0) goto L_0x00ba
            goto L_0x00bc
        L_0x00ba:
            r6 = r4
            goto L_0x00bd
        L_0x00bc:
            r6 = r5
        L_0x00bd:
            if (r6 != 0) goto L_0x009a
            java.lang.String r6 = "queryParameterKey"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)     // Catch:{ Exception -> 0x00c8 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x00c8 }
            goto L_0x009a
        L_0x00c8:
            r8 = move-exception
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r3 = TAG
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.E
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            com.braze.ui.support.UriUtils$getQueryParameters$2 r5 = new com.braze.ui.support.UriUtils$getQueryParameters$2
            r5.<init>(r0)
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r2.brazelog((java.lang.String) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r8, (kotlin.jvm.functions.Function0<java.lang.String>) r5)
        L_0x00db:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.ui.support.UriUtils.getQueryParameters(android.net.Uri):java.util.Map");
    }

    public static /* synthetic */ Intent getMainActivityIntent$default(Context context, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        return getMainActivityIntent(context, bundle);
    }

    public static final Intent getMainActivityIntent(Context context, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setFlags(BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.URI_UTILS_GET_MAIN_ACTIVITY_INTENT));
        }
        if (!(bundle == null || launchIntentForPackage == null)) {
            launchIntentForPackage.putExtras(bundle);
        }
        return launchIntentForPackage;
    }

    public static final boolean isActivityRegisteredInManifest(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "className");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                context.getPackageManager().getActivityInfo(new ComponentName(context, str), PackageManager.ComponentInfoFlags.of(0));
            } else {
                context.getPackageManager().getActivityInfo(new ComponentName(context, str), 0);
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            BrazeLogger.INSTANCE.brazelog(TAG, BrazeLogger.Priority.W, (Throwable) e, (Function0<String>) new UriUtils$isActivityRegisteredInManifest$1(str));
            return false;
        }
    }
}
