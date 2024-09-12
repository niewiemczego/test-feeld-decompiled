package com.facebook.appevents.ondeviceprocessing;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0007J\u001c\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/appevents/ondeviceprocessing/OnDeviceProcessingManager;", "", "()V", "ALLOWED_IMPLICIT_EVENTS", "", "", "isEventEligibleForOnDeviceProcessing", "", "event", "Lcom/facebook/appevents/AppEvent;", "isOnDeviceProcessingEnabled", "sendCustomEventAsync", "", "applicationId", "sendInstallEventAsync", "preferencesName", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: OnDeviceProcessingManager.kt */
public final class OnDeviceProcessingManager {
    private static final Set<String> ALLOWED_IMPLICIT_EVENTS = SetsKt.setOf(AppEventsConstants.EVENT_NAME_PURCHASED, AppEventsConstants.EVENT_NAME_START_TRIAL, AppEventsConstants.EVENT_NAME_SUBSCRIBE);
    public static final OnDeviceProcessingManager INSTANCE = new OnDeviceProcessingManager();

    private OnDeviceProcessingManager() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0026 A[Catch:{ all -> 0x0030 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isOnDeviceProcessingEnabled() {
        /*
            java.lang.Class<com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager> r0 = com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x0030 }
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x0030 }
            com.facebook.FacebookSdk r3 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x0030 }
            boolean r1 = com.facebook.FacebookSdk.getLimitEventAndDataUsage(r1)     // Catch:{ all -> 0x0030 }
            r3 = 1
            if (r1 != 0) goto L_0x0023
            com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x0030 }
            boolean r1 = com.facebook.internal.Utility.isDataProcessingRestricted()     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x0023
            r1 = r3
            goto L_0x0024
        L_0x0023:
            r1 = r2
        L_0x0024:
            if (r1 == 0) goto L_0x002f
            com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper r1 = com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper.INSTANCE     // Catch:{ all -> 0x0030 }
            boolean r0 = com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper.isServiceAvailable()     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x002f
            r2 = r3
        L_0x002f:
            return r2
        L_0x0030:
            r1 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager.isOnDeviceProcessingEnabled():boolean");
    }

    @JvmStatic
    public static final void sendInstallEventAsync(String str, String str2) {
        Class<OnDeviceProcessingManager> cls = OnDeviceProcessingManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                Context applicationContext = FacebookSdk.getApplicationContext();
                if (applicationContext != null && str != null && str2 != null) {
                    FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                    FacebookSdk.getExecutor().execute(new OnDeviceProcessingManager$$ExternalSyntheticLambda0(applicationContext, str2, str));
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sendInstallEventAsync$lambda-0  reason: not valid java name */
    public static final void m287sendInstallEventAsync$lambda0(Context context, String str, String str2) {
        Class<OnDeviceProcessingManager> cls = OnDeviceProcessingManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(context, "$context");
                SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
                String stringPlus = Intrinsics.stringPlus(str2, "pingForOnDevice");
                if (sharedPreferences.getLong(stringPlus, 0) == 0) {
                    RemoteServiceWrapper remoteServiceWrapper = RemoteServiceWrapper.INSTANCE;
                    RemoteServiceWrapper.sendInstallEvent(str2);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putLong(stringPlus, System.currentTimeMillis());
                    edit.apply();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final void sendCustomEventAsync(String str, AppEvent appEvent) {
        Class<OnDeviceProcessingManager> cls = OnDeviceProcessingManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(str, "applicationId");
                Intrinsics.checkNotNullParameter(appEvent, "event");
                if (INSTANCE.isEventEligibleForOnDeviceProcessing(appEvent)) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    FacebookSdk.getExecutor().execute(new OnDeviceProcessingManager$$ExternalSyntheticLambda1(str, appEvent));
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sendCustomEventAsync$lambda-1  reason: not valid java name */
    public static final void m286sendCustomEventAsync$lambda1(String str, AppEvent appEvent) {
        Class<OnDeviceProcessingManager> cls = OnDeviceProcessingManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(str, "$applicationId");
                Intrinsics.checkNotNullParameter(appEvent, "$event");
                RemoteServiceWrapper remoteServiceWrapper = RemoteServiceWrapper.INSTANCE;
                RemoteServiceWrapper.sendCustomEvents(str, CollectionsKt.listOf(appEvent));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final boolean isEventEligibleForOnDeviceProcessing(AppEvent appEvent) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            boolean z = appEvent.isImplicit() && ALLOWED_IMPLICIT_EVENTS.contains(appEvent.getName());
            if ((!appEvent.isImplicit()) || z) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
