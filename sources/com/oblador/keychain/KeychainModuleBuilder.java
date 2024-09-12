package com.oblador.keychain;

import com.facebook.react.bridge.ReactApplicationContext;

public class KeychainModuleBuilder {
    public static final boolean DEFAULT_USE_WARM_UP = true;
    private ReactApplicationContext reactContext;
    private boolean useWarmUp = true;

    public KeychainModuleBuilder withReactContext(ReactApplicationContext reactApplicationContext) {
        this.reactContext = reactApplicationContext;
        return this;
    }

    public KeychainModuleBuilder usingWarmUp() {
        this.useWarmUp = true;
        return this;
    }

    public KeychainModuleBuilder withoutWarmUp() {
        this.useWarmUp = false;
        return this;
    }

    public KeychainModule build() {
        validate();
        if (this.useWarmUp) {
            return KeychainModule.withWarming(this.reactContext);
        }
        return new KeychainModule(this.reactContext);
    }

    private void validate() {
        if (this.reactContext == null) {
            throw new Error("React Context was not provided");
        }
    }
}
