package io.invertase.firebase.dynamiclinks;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import io.invertase.firebase.common.ReactNativeFirebaseEvent;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import kotlin.text.Typography;

public class ReactNativeFirebaseDynamicLinksModule extends ReactNativeFirebaseModule implements ActivityEventListener, LifecycleEventListener {
    private static final String SHORT_LINK_TYPE_SHORT = "SHORT";
    private static final String SHORT_LINK_TYPE_UNGUESSABLE = "UNGUESSABLE";
    private static final String TAG = "DynamicLinks";
    private boolean gotInitialLink = false;
    private boolean hostResumed = false;
    private int initialLinkMinimumVersion = 0;
    private String initialLinkUrl = null;
    private Promise initialPromise = null;
    private boolean launchedFromHistory = false;

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
    }

    ReactNativeFirebaseDynamicLinksModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, TAG);
        getReactApplicationContext().addActivityEventListener(this);
        getReactApplicationContext().addLifecycleEventListener(this);
    }

    public void onCatalystInstanceDestroy() {
        getReactApplicationContext().removeActivityEventListener(this);
        getReactApplicationContext().addLifecycleEventListener(this);
        super.onCatalystInstanceDestroy();
    }

    @ReactMethod
    public void buildLink(ReadableMap readableMap, Promise promise) {
        Tasks.call(getExecutor(), new ReactNativeFirebaseDynamicLinksModule$$ExternalSyntheticLambda2(this, readableMap)).addOnCompleteListener((Executor) getExecutor(), new ReactNativeFirebaseDynamicLinksModule$$ExternalSyntheticLambda3(promise));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$buildLink$0$io-invertase-firebase-dynamiclinks-ReactNativeFirebaseDynamicLinksModule  reason: not valid java name */
    public /* synthetic */ String m860lambda$buildLink$0$ioinvertasefirebasedynamiclinksReactNativeFirebaseDynamicLinksModule(ReadableMap readableMap) throws Exception {
        return createDynamicLinkBuilder(readableMap).buildDynamicLink().getUri().toString();
    }

    static /* synthetic */ void lambda$buildLink$1(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
            return;
        }
        Log.e(TAG, "RNFB: Unknown error while building Dynamic Link ", task.getException());
        rejectPromiseWithCodeAndMessage(promise, "build-failed", task.getException().getMessage());
    }

    @ReactMethod
    public void buildShortLink(ReadableMap readableMap, String str, Promise promise) {
        Tasks.call(getExecutor(), new ReactNativeFirebaseDynamicLinksModule$$ExternalSyntheticLambda4(this, readableMap, str)).addOnCompleteListener((Executor) getExecutor(), new ReactNativeFirebaseDynamicLinksModule$$ExternalSyntheticLambda5(promise));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$buildShortLink$2$io-invertase-firebase-dynamiclinks-ReactNativeFirebaseDynamicLinksModule  reason: not valid java name */
    public /* synthetic */ ShortDynamicLink m861lambda$buildShortLink$2$ioinvertasefirebasedynamiclinksReactNativeFirebaseDynamicLinksModule(ReadableMap readableMap, String str) throws Exception {
        DynamicLink.Builder createDynamicLinkBuilder = createDynamicLinkBuilder(readableMap);
        if (SHORT_LINK_TYPE_SHORT.equals(str)) {
            return (ShortDynamicLink) Tasks.await(createDynamicLinkBuilder.buildShortDynamicLink(2));
        }
        if (SHORT_LINK_TYPE_UNGUESSABLE.equals(str)) {
            return (ShortDynamicLink) Tasks.await(createDynamicLinkBuilder.buildShortDynamicLink(1));
        }
        return (ShortDynamicLink) Tasks.await(createDynamicLinkBuilder.buildShortDynamicLink());
    }

    static /* synthetic */ void lambda$buildShortLink$3(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(((ShortDynamicLink) task.getResult()).getShortLink().toString());
            return;
        }
        Log.e(TAG, "RNFB: Unknown error while building Dynamic Link " + task.getException().getMessage());
        rejectPromiseWithCodeAndMessage(promise, "build-failed", task.getException().getMessage());
    }

    @ReactMethod
    public void getInitialLink(Promise promise) {
        if (this.gotInitialLink) {
            promise.resolve((Object) null);
        } else if (!this.hostResumed) {
            this.initialPromise = promise;
        } else {
            Activity currentActivity = getCurrentActivity();
            if (currentActivity == null) {
                promise.resolve((Object) null);
                return;
            }
            Intent intent = currentActivity.getIntent();
            if (intent == null) {
                promise.resolve((Object) null);
                return;
            }
            this.launchedFromHistory = (intent == null || (intent.getFlags() & 1048576) == 0) ? false : true;
            FirebaseDynamicLinks.getInstance().getDynamicLink(intent).addOnCompleteListener(new ReactNativeFirebaseDynamicLinksModule$$ExternalSyntheticLambda1(this, promise));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getInitialLink$4$io-invertase-firebase-dynamiclinks-ReactNativeFirebaseDynamicLinksModule  reason: not valid java name */
    public /* synthetic */ void m862lambda$getInitialLink$4$ioinvertasefirebasedynamiclinksReactNativeFirebaseDynamicLinksModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            this.gotInitialLink = true;
            PendingDynamicLinkData pendingDynamicLinkData = (PendingDynamicLinkData) task.getResult();
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            if (pendingDynamicLinkData != null) {
                this.initialLinkUrl = pendingDynamicLinkData.getLink().toString();
                this.initialLinkMinimumVersion = pendingDynamicLinkData.getMinimumAppVersion();
                writableNativeMap = Arguments.makeNativeMap(pendingDynamicLinkData.getUtmParameters());
            }
            String str = this.initialLinkUrl;
            if (str == null || this.launchedFromHistory) {
                promise.resolve((Object) null);
            } else {
                promise.resolve(dynamicLinkToWritableMap(str, this.initialLinkMinimumVersion, writableNativeMap));
            }
        } else {
            rejectPromiseWithCodeAndMessage(promise, "initial-link-error", task.getException().getMessage());
        }
    }

    @ReactMethod
    public void resolveLink(String str, Promise promise) {
        try {
            FirebaseDynamicLinks.getInstance().getDynamicLink(Uri.parse(str)).addOnCompleteListener(new ReactNativeFirebaseDynamicLinksModule$$ExternalSyntheticLambda6(this, promise));
        } catch (Exception unused) {
            rejectPromiseWithCodeAndMessage(promise, "resolve-link-error", "Unknown resolve failure");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$resolveLink$5$io-invertase-firebase-dynamiclinks-ReactNativeFirebaseDynamicLinksModule  reason: not valid java name */
    public /* synthetic */ void m864lambda$resolveLink$5$ioinvertasefirebasedynamiclinksReactNativeFirebaseDynamicLinksModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            PendingDynamicLinkData pendingDynamicLinkData = (PendingDynamicLinkData) task.getResult();
            if (pendingDynamicLinkData == null || pendingDynamicLinkData.getLink() == null || pendingDynamicLinkData.getLink().toString() == null) {
                rejectPromiseWithCodeAndMessage(promise, "not-found", "Dynamic link not found");
            } else {
                promise.resolve(dynamicLinkToWritableMap(pendingDynamicLinkData.getLink().toString(), pendingDynamicLinkData.getMinimumAppVersion(), Arguments.makeNativeMap(pendingDynamicLinkData.getUtmParameters())));
            }
        } else {
            rejectPromiseWithCodeAndMessage(promise, "resolve-link-error", task.getException().getMessage());
        }
    }

    private WritableMap dynamicLinkToWritableMap(String str, int i, WritableMap writableMap) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("url", str);
        if (i == 0) {
            createMap.putNull("minimumAppVersion");
        } else {
            createMap.putInt("minimumAppVersion", i);
        }
        createMap.putMap("utmParameters", writableMap);
        return createMap;
    }

    private DynamicLink.Builder createDynamicLinkBuilder(ReadableMap readableMap) {
        DynamicLink.Builder createDynamicLink = FirebaseDynamicLinks.getInstance().createDynamicLink();
        createDynamicLink.setLink(Uri.parse(readableMap.getString("link")));
        createDynamicLink.setDomainUriPrefix((String) Objects.requireNonNull(readableMap.getString(DynamicLink.Builder.KEY_DOMAIN_URI_PREFIX)));
        if (readableMap.hasKey("ios")) {
            buildIosParameters(readableMap.getMap("ios"), createDynamicLink);
        }
        if (readableMap.hasKey("itunes")) {
            buildItunesParameters(readableMap.getMap("itunes"), createDynamicLink);
        }
        if (readableMap.hasKey(NotificationCompat.CATEGORY_SOCIAL)) {
            buildSocialParameters(readableMap.getMap(NotificationCompat.CATEGORY_SOCIAL), createDynamicLink);
        }
        if (readableMap.hasKey("android")) {
            buildAndroidParameters(readableMap.getMap("android"), createDynamicLink);
        }
        if (readableMap.hasKey("analytics")) {
            buildAnalyticsParameters(readableMap.getMap("analytics"), createDynamicLink);
        }
        if (readableMap.hasKey(NotificationCompat.CATEGORY_NAVIGATION)) {
            buildNavigationParameters(readableMap.getMap(NotificationCompat.CATEGORY_NAVIGATION), createDynamicLink);
        }
        if (readableMap.hasKey("otherPlatform") && readableMap.getMap("otherPlatform").hasKey("fallbackUrl")) {
            createDynamicLink.setLongLink(Uri.parse(String.valueOf(createDynamicLink.buildDynamicLink().getUri()) + Typography.amp + "ofl" + '=' + readableMap.getMap("otherPlatform").getString("fallbackUrl")));
        }
        return createDynamicLink;
    }

    private void buildAnalyticsParameters(@Nullable ReadableMap readableMap, DynamicLink.Builder builder) {
        if (readableMap != null) {
            DynamicLink.GoogleAnalyticsParameters.Builder builder2 = new DynamicLink.GoogleAnalyticsParameters.Builder();
            if (readableMap.hasKey("campaign")) {
                builder2.setCampaign(readableMap.getString("campaign"));
            }
            if (readableMap.hasKey("content")) {
                builder2.setContent(readableMap.getString("content"));
            }
            if (readableMap.hasKey("medium")) {
                builder2.setMedium(readableMap.getString("medium"));
            }
            if (readableMap.hasKey("source")) {
                builder2.setSource(readableMap.getString("source"));
            }
            if (readableMap.hasKey(FirebaseAnalytics.Param.TERM)) {
                builder2.setTerm(readableMap.getString(FirebaseAnalytics.Param.TERM));
            }
            builder.setGoogleAnalyticsParameters(builder2.build());
        }
    }

    private void buildAndroidParameters(@Nullable ReadableMap readableMap, DynamicLink.Builder builder) {
        if (readableMap != null) {
            DynamicLink.AndroidParameters.Builder builder2 = new DynamicLink.AndroidParameters.Builder((String) Objects.requireNonNull(readableMap.getString("packageName")));
            if (readableMap.hasKey("fallbackUrl")) {
                builder2.setFallbackUrl(Uri.parse(readableMap.getString("fallbackUrl")));
            }
            if (readableMap.hasKey("minimumVersion")) {
                builder2.setMinimumVersion(Integer.parseInt((String) Objects.requireNonNull(readableMap.getString("minimumVersion"))));
            }
            builder.setAndroidParameters(builder2.build());
        }
    }

    private void buildIosParameters(@Nullable ReadableMap readableMap, DynamicLink.Builder builder) {
        if (readableMap != null) {
            DynamicLink.IosParameters.Builder builder2 = new DynamicLink.IosParameters.Builder((String) Objects.requireNonNull(readableMap.getString("bundleId")));
            if (readableMap.hasKey("appStoreId")) {
                builder2.setAppStoreId(readableMap.getString("appStoreId"));
            }
            if (readableMap.hasKey("customScheme")) {
                builder2.setCustomScheme(readableMap.getString("customScheme"));
            }
            if (readableMap.hasKey("fallbackUrl")) {
                builder2.setFallbackUrl(Uri.parse(readableMap.getString("fallbackUrl")));
            }
            if (readableMap.hasKey("iPadBundleId")) {
                builder2.setIpadBundleId(readableMap.getString("iPadBundleId"));
            }
            if (readableMap.hasKey("iPadFallbackUrl")) {
                builder2.setIpadFallbackUrl(Uri.parse(readableMap.getString("iPadFallbackUrl")));
            }
            if (readableMap.hasKey("minimumVersion")) {
                builder2.setMinimumVersion(readableMap.getString("minimumVersion"));
            }
            builder.setIosParameters(builder2.build());
        }
    }

    private void buildItunesParameters(@Nullable ReadableMap readableMap, DynamicLink.Builder builder) {
        if (readableMap != null) {
            DynamicLink.ItunesConnectAnalyticsParameters.Builder builder2 = new DynamicLink.ItunesConnectAnalyticsParameters.Builder();
            if (readableMap.hasKey("affiliateToken")) {
                builder2.setAffiliateToken(readableMap.getString("affiliateToken"));
            }
            if (readableMap.hasKey("campaignToken")) {
                builder2.setCampaignToken(readableMap.getString("campaignToken"));
            }
            if (readableMap.hasKey("providerToken")) {
                builder2.setProviderToken(readableMap.getString("providerToken"));
            }
            builder.setItunesConnectAnalyticsParameters(builder2.build());
        }
    }

    private void buildNavigationParameters(@Nullable ReadableMap readableMap, DynamicLink.Builder builder) {
        if (readableMap != null) {
            DynamicLink.NavigationInfoParameters.Builder builder2 = new DynamicLink.NavigationInfoParameters.Builder();
            if (readableMap.hasKey("forcedRedirectEnabled")) {
                builder2.setForcedRedirectEnabled(readableMap.getBoolean("forcedRedirectEnabled"));
            }
            builder.setNavigationInfoParameters(builder2.build());
        }
    }

    private void buildSocialParameters(@Nullable ReadableMap readableMap, DynamicLink.Builder builder) {
        if (readableMap != null) {
            DynamicLink.SocialMetaTagParameters.Builder builder2 = new DynamicLink.SocialMetaTagParameters.Builder();
            if (readableMap.hasKey("descriptionText")) {
                builder2.setDescription(readableMap.getString("descriptionText"));
            }
            if (readableMap.hasKey("imageUrl")) {
                builder2.setImageUrl(Uri.parse(readableMap.getString("imageUrl")));
            }
            if (readableMap.hasKey("title")) {
                builder2.setTitle(readableMap.getString("title"));
            }
            builder.setSocialMetaTagParameters(builder2.build());
        }
    }

    public void onHostDestroy() {
        this.initialLinkUrl = null;
        this.gotInitialLink = false;
        this.initialLinkMinimumVersion = 0;
        this.launchedFromHistory = false;
        this.initialPromise = null;
        this.hostResumed = false;
    }

    public void onNewIntent(Intent intent) {
        FirebaseDynamicLinks.getInstance().getDynamicLink(intent).addOnCompleteListener(new ReactNativeFirebaseDynamicLinksModule$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onNewIntent$6$io-invertase-firebase-dynamiclinks-ReactNativeFirebaseDynamicLinksModule  reason: not valid java name */
    public /* synthetic */ void m863lambda$onNewIntent$6$ioinvertasefirebasedynamiclinksReactNativeFirebaseDynamicLinksModule(Task task) {
        if (task.isSuccessful()) {
            PendingDynamicLinkData pendingDynamicLinkData = (PendingDynamicLinkData) task.getResult();
            if (pendingDynamicLinkData != null) {
                ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(new ReactNativeFirebaseEvent("dynamic_links_link_received", dynamicLinkToWritableMap(pendingDynamicLinkData.getLink().toString(), pendingDynamicLinkData.getMinimumAppVersion(), Arguments.makeNativeMap(pendingDynamicLinkData.getUtmParameters()))));
                return;
            }
            return;
        }
        Log.e(TAG, "RNFB: An unknown exception occurred calling getDynamicLink", task.getException());
    }

    public void onHostResume() {
        this.hostResumed = true;
        Promise promise = this.initialPromise;
        if (promise != null) {
            getInitialLink(promise);
            this.initialPromise = null;
        }
    }

    public void onHostPause() {
        this.hostResumed = false;
    }
}
