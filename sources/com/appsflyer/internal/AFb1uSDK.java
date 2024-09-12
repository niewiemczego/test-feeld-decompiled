package com.appsflyer.internal;

import com.appsflyer.AFLogger;

@Deprecated
public final class AFb1uSDK implements AFa1zSDK {
    private final AFa1zSDK values = this;

    interface AFa1zSDK {
        Class<?> AFInAppEventParameterName(String str) throws ClassNotFoundException;
    }

    public final String AFKeystoreWrapper() {
        for (AFa1vSDK aFa1vSDK : AFa1vSDK.values()) {
            if (AFKeystoreWrapper(aFa1vSDK.onInstallConversionDataLoadedNative)) {
                return aFa1vSDK.AFLogger$LogLevel;
            }
        }
        return AFa1vSDK.DEFAULT.AFLogger$LogLevel;
    }

    private boolean AFKeystoreWrapper(String str) {
        try {
            this.values.AFInAppEventParameterName(str);
            AFLogger.afRDLog(new StringBuilder("Class: ").append(str).append(" is found.").toString());
            return true;
        } catch (ClassNotFoundException e) {
            AFLogger.afErrorLogForExcManagerOnly(new StringBuilder("Class: ").append(str).append(" is  not found. (Platform extension)").toString(), e, true);
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return false;
        }
    }

    enum AFa1vSDK {
        ADOBE_AIR("android_adobe_air", "com.appsflyer.adobeair.AppsFlyerExtension"),
        ADOBE_MOBILE_SDK("android_adobe_mobile", "com.appsflyer.adobeextension.AppsFlyerAdobeExtension"),
        COCOS2DX("android_cocos2dx", "org.cocos2dx.lib.Cocos2dxActivity"),
        CORDOVA("android_cordova", "com.appsflyer.cordova.plugin.AppsFlyerPlugin"),
        DEFAULT("android_native", "android_native"),
        FLUTTER("android_flutter", "com.appsflyer.appsflyersdk.AppsflyerSdkPlugin"),
        M_PARTICLE("android_mparticle", "com.mparticle.kits.AppsFlyerKit"),
        NATIVE_SCRIPT("android_native_script", "com.tns.NativeScriptActivity"),
        EXPO("android_expo", "expo.modules.devmenu.react.DevMenuAwareReactActivity"),
        REACT_NATIVE("android_reactNative", "com.appsflyer.reactnative.RNAppsFlyerModule"),
        UNITY("android_unity", "com.appsflyer.unity.AppsFlyerAndroidWrapper"),
        UNREAL_ENGINE("android_unreal", "com.epicgames.ue4.GameActivity"),
        XAMARIN("android_xamarin", "mono.android.Runtime"),
        CAPACITOR("android_capacitor", "capacitor.plugin.appsflyer.sdk.AppsFlyerPlugin");
        
        /* access modifiers changed from: private */
        public final String AFLogger$LogLevel;
        /* access modifiers changed from: private */
        public final String onInstallConversionDataLoadedNative;

        private AFa1vSDK(String str, String str2) {
            this.AFLogger$LogLevel = str;
            this.onInstallConversionDataLoadedNative = str2;
        }
    }

    public final Class<?> AFInAppEventParameterName(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }
}
