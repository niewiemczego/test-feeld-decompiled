package com.facebook.react;

import agency.flexible.react.modules.email.EmailPackage;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import cl.json.RNSharePackage;
import com.BV.LinearGradient.LinearGradientPackage;
import com.RNAppleAuthentication.AppleAuthenticationAndroidPackage;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilPackage;
import com.SeonSdkReactNativeWrapper.SeonSdkReactNativeWrapperPackage;
import com.adapty.react.AdaptyPackage;
import com.agontuk.RNFusedLocation.RNFusedLocationPackage;
import com.airbnb.android.react.lottie.LottiePackage;
import com.amplitude.reactnative.AmplitudeReactNativePackage;
import com.appsflyer.reactnative.RNAppsFlyerPackage;
import com.braze.reactbridge.BrazeReactBridgePackage;
import com.facebook.react.shell.MainPackageConfig;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.reactnative.androidsdk.FBSDKPackage;
import com.horcrux.svg.SvgPackage;
import com.ibits.react_native_in_app_review.AppReviewPackage;
import com.launchdarkly.reactnative.LaunchdarklyReactNativeClientPackage;
import com.learnium.RNDeviceInfo.RNDeviceInfo;
import com.masteratul.exceptionhandler.ReactNativeExceptionHandlerPackage;
import com.mkuczera.RNReactNativeHapticFeedbackPackage;
import com.mvcpscrollviewmanager.MvcpScrollViewManagerPackage;
import com.oblador.keychain.KeychainPackage;
import com.reactcommunity.rndatetimepicker.RNDateTimePickerPackage;
import com.reactlibrary.createthumbnail.CreateThumbnailPackage;
import com.reactnative.ivpusic.imagepicker.PickerPackage;
import com.reactnativecommunity.asyncstorage.AsyncStoragePackage;
import com.reactnativecommunity.blurview.BlurViewPackage;
import com.reactnativecommunity.cameraroll.CameraRollPackage;
import com.reactnativecommunity.clipboard.ClipboardPackage;
import com.reactnativecommunity.netinfo.NetInfoPackage;
import com.reactnativecommunity.slider.ReactSliderPackage;
import com.reactnativecommunity.webview.RNCWebViewPackage;
import com.reactnativedocumentpicker.DocumentPickerPackage;
import com.reactnativepagerview.PagerViewPackage;
import com.rnfs.RNFSPackage;
import com.shopify.reactnative.flash_list.ReactNativeFlashListPackage;
import com.swmansion.gesturehandler.RNGestureHandlerPackage;
import com.swmansion.reanimated.ReanimatedPackage;
import com.swmansion.rnscreens.RNScreensPackage;
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;
import com.transparentvideo.TransparentVideoPackage;
import com.zoontek.rnbootsplash.RNBootSplashPackage;
import com.zoontek.rnlocalize.RNLocalizePackage;
import com.zoontek.rnpermissions.RNPermissionsPackage;
import dev.geundung.zendesk.messaging.ZendeskMessagingPackage;
import expo.modules.ExpoModulesPackage;
import fr.bamlab.rnimageresizer.ImageResizerPackage;
import io.invertase.firebase.app.ReactNativeFirebaseAppPackage;
import io.invertase.firebase.auth.ReactNativeFirebaseAuthPackage;
import io.invertase.firebase.dynamiclinks.ReactNativeFirebaseDynamicLinksPackage;
import io.invertase.firebase.installations.ReactNativeFirebaseInstallationsPackage;
import io.invertase.firebase.messaging.ReactNativeFirebaseMessagingPackage;
import io.invertase.notifee.NotifeePackage;
import io.sentry.react.RNSentryPackage;
import java.util.ArrayList;
import java.util.Arrays;
import org.linusu.RNGetRandomValuesPackage;

public class PackageList {
    private Application application;
    private MainPackageConfig mConfig;
    private ReactNativeHost reactNativeHost;

    public PackageList(ReactNativeHost reactNativeHost2) {
        this(reactNativeHost2, (MainPackageConfig) null);
    }

    public PackageList(Application application2) {
        this(application2, (MainPackageConfig) null);
    }

    public PackageList(ReactNativeHost reactNativeHost2, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = reactNativeHost2;
        this.mConfig = mainPackageConfig;
    }

    public PackageList(Application application2, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = null;
        this.application = application2;
        this.mConfig = mainPackageConfig;
    }

    private ReactNativeHost getReactNativeHost() {
        return this.reactNativeHost;
    }

    private Resources getResources() {
        return getApplication().getResources();
    }

    private Application getApplication() {
        ReactNativeHost reactNativeHost2 = this.reactNativeHost;
        if (reactNativeHost2 == null) {
            return this.application;
        }
        return reactNativeHost2.getApplication();
    }

    private Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    public ArrayList<ReactPackage> getPackages() {
        return new ArrayList<>(Arrays.asList(new ReactPackage[]{new MainReactPackage(this.mConfig), new AmplitudeReactNativePackage(), new BrazeReactBridgePackage(), new AppleAuthenticationAndroidPackage(), new NotifeePackage(), new CameraRollPackage(), new ClipboardPackage(), new AsyncStoragePackage(), new BlurViewPackage(), new RNDateTimePickerPackage(), new NetInfoPackage(), new ReactNativeFirebaseAppPackage(), new ReactNativeFirebaseAuthPackage(), new ReactNativeFirebaseDynamicLinksPackage(), new ReactNativeFirebaseInstallationsPackage(), new ReactNativeFirebaseMessagingPackage(), new RNSentryPackage(), new SeonSdkReactNativeWrapperPackage(), new ReactNativeFlashListPackage(), new TransparentVideoPackage(), new MvcpScrollViewManagerPackage(), new ExpoModulesPackage(), new LaunchdarklyReactNativeClientPackage(), new LottiePackage(), new AdaptyPackage(), new RNAppsFlyerPackage(), new ReactNativeBlobUtilPackage(), new RNBootSplashPackage(), new CreateThumbnailPackage(), new RNDeviceInfo(), new DocumentPickerPackage(), new EmailPackage(), new ReactNativeExceptionHandlerPackage(), new FBSDKPackage(), new RNFSPackage(), new RNFusedLocationPackage(), new RNGestureHandlerPackage(), new RNGetRandomValuesPackage(), new RNReactNativeHapticFeedbackPackage(), new PickerPackage(), new ImageResizerPackage(), new AppReviewPackage(), new KeychainPackage(), new LinearGradientPackage(), new RNLocalizePackage(), new PagerViewPackage(), new RNPermissionsPackage(), new ReanimatedPackage(), new SafeAreaContextPackage(), new RNScreensPackage(), new RNSharePackage(), new SvgPackage(), new RNCWebViewPackage(), new ZendeskMessagingPackage(), new ReactSliderPackage()}));
    }
}
