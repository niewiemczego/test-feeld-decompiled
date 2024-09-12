package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import androidx.browser.customtabs.CustomTabsService;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/facebook/internal/CustomTabUtils;", "", "()V", "CHROME_PACKAGES", "", "", "[Ljava/lang/String;", "getChromePackage", "getDefaultRedirectURI", "getValidRedirectURI", "developerDefinedRedirectURI", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CustomTabUtils.kt */
public final class CustomTabUtils {
    private static final String[] CHROME_PACKAGES = {"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};
    public static final CustomTabUtils INSTANCE = new CustomTabUtils();

    private CustomTabUtils() {
    }

    @JvmStatic
    public static final String getDefaultRedirectURI() {
        Class<CustomTabUtils> cls = CustomTabUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            return Intrinsics.stringPlus(Validate.CUSTOM_TAB_REDIRECT_URI_PREFIX, FacebookSdk.getApplicationContext().getPackageName());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final String getValidRedirectURI(String str) {
        Class<CustomTabUtils> cls = CustomTabUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(str, "developerDefinedRedirectURI");
            Validate validate = Validate.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext(), str)) {
                return str;
            }
            Validate validate2 = Validate.INSTANCE;
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            return Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext(), getDefaultRedirectURI()) ? getDefaultRedirectURI() : "";
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final String getChromePackage() {
        Class<CustomTabUtils> cls = CustomTabUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            List<ResolveInfo> queryIntentServices = applicationContext.getPackageManager().queryIntentServices(new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION), 0);
            Intrinsics.checkNotNullExpressionValue(queryIntentServices, "context.packageManager.queryIntentServices(serviceIntent, 0)");
            Set hashSet = ArraysKt.toHashSet((T[]) CHROME_PACKAGES);
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null && hashSet.contains(serviceInfo.packageName)) {
                    return serviceInfo.packageName;
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }
}
