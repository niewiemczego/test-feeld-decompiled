package com.SeonSdkReactNativeWrapper;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import io.seon.androidsdk.service.Seon;
import io.seon.androidsdk.service.SeonBuilder;
import java.util.Objects;
import java.util.UUID;

@ReactModule(name = "SeonSdkReactNativeWrapper")
public class SeonSdkReactNativeWrapper extends ReactContextBaseJavaModule {
    public static final String NAME = "SeonSdkReactNativeWrapper";
    private Seon m_seon;

    public String getName() {
        return NAME;
    }

    public SeonSdkReactNativeWrapper(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.m_seon = new SeonBuilder().withContext(reactApplicationContext.getApplicationContext()).withSessionId(UUID.randomUUID().toString()).build();
    }

    public SeonSdkReactNativeWrapper(ReactApplicationContext reactApplicationContext, String str) {
        super(reactApplicationContext);
        this.m_seon = new SeonBuilder().withContext(reactApplicationContext.getApplicationContext()).withSessionId(str).build();
    }

    @ReactMethod
    public void setSessionId(String str, Promise promise) {
        this.m_seon.setSessionId(str);
        promise.resolve(true);
    }

    @ReactMethod
    public void setLoggingEnabled(boolean z, Promise promise) {
        this.m_seon.setLoggingEnabled(Boolean.valueOf(z));
        promise.resolve(true);
    }

    @ReactMethod
    public void getFingerprintBase64(Promise promise) {
        try {
            Seon seon = this.m_seon;
            Objects.requireNonNull(promise);
            seon.getFingerprintBase64(new SeonSdkReactNativeWrapper$$ExternalSyntheticLambda0(promise));
        } catch (Exception e) {
            promise.reject((Throwable) e);
        }
    }
}
