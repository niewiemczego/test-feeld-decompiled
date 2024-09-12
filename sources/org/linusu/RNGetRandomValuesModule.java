package org.linusu;

import android.util.Base64;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class RNGetRandomValuesModule extends ReactContextBaseJavaModule {
    private final ReactApplicationContext reactContext;

    public String getName() {
        return "RNGetRandomValues";
    }

    public RNGetRandomValuesModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String getRandomBase64(int i) throws NoSuchAlgorithmException {
        byte[] bArr = new byte[i];
        new SecureRandom().nextBytes(bArr);
        return Base64.encodeToString(bArr, 2);
    }
}
