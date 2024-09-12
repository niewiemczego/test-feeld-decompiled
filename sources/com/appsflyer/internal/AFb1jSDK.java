package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import com.appsflyer.AFLogger;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class AFb1jSDK<T> {
    public final AFc1vSDK AFInAppEventParameterName;
    private final String[] AFInAppEventType;
    public final Context AFKeystoreWrapper;
    public final String valueOf;
    public final FutureTask<T> values = new FutureTask<>(new Callable<T>() {
        public final T call() {
            if (AFb1jSDK.this.valueOf()) {
                return AFb1jSDK.this.AFInAppEventParameterName();
            }
            return null;
        }
    });

    /* access modifiers changed from: protected */
    public abstract T AFInAppEventParameterName();

    public AFb1jSDK(Context context, AFc1vSDK aFc1vSDK, String str, String... strArr) {
        this.AFKeystoreWrapper = context;
        this.valueOf = str;
        this.AFInAppEventType = strArr;
        this.AFInAppEventParameterName = aFc1vSDK;
    }

    public T values() {
        try {
            return this.values.get(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            AFLogger.afErrorLog(e.getMessage(), e);
            return null;
        }
    }

    public final boolean valueOf() {
        try {
            ProviderInfo resolveContentProvider = this.AFKeystoreWrapper.getPackageManager().resolveContentProvider(this.valueOf, 128);
            if (resolveContentProvider == null || !Arrays.asList(this.AFInAppEventType).contains(AFa1cSDK.values(this.AFKeystoreWrapper.getPackageManager(), resolveContentProvider.packageName))) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException | CertificateException e) {
            AFLogger.afErrorLog(e.getMessage(), e);
            return false;
        }
    }
}
