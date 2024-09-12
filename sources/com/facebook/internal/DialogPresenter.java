package com.facebook.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import com.facebook.CallbackManager;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u00016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0007J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\"\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0007J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J$\u0010#\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010\u000f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0007J\u001a\u0010'\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010)H\u0007J \u0010*\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010-\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010.\u001a\u0004\u0018\u00010)H\u0007J$\u0010/\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0007J\"\u00100\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J*\u00101\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0007¨\u00067"}, d2 = {"Lcom/facebook/internal/DialogPresenter;", "", "()V", "canPresentNativeDialogWithFeature", "", "feature", "Lcom/facebook/internal/DialogFeature;", "canPresentWebFallbackDialogWithFeature", "getDialogWebFallbackUri", "Landroid/net/Uri;", "getProtocolVersionForNativeDialog", "Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "getVersionSpecForFeature", "", "applicationId", "", "actionName", "logDialogActivity", "", "context", "Landroid/content/Context;", "eventName", "outcome", "present", "appCall", "Lcom/facebook/internal/AppCall;", "activity", "Landroid/app/Activity;", "registry", "Landroidx/activity/result/ActivityResultRegistry;", "callbackManager", "Lcom/facebook/CallbackManager;", "fragmentWrapper", "Lcom/facebook/internal/FragmentWrapper;", "setupAppCallForCannotShowError", "setupAppCallForCustomTabDialog", "action", "parameters", "Landroid/os/Bundle;", "setupAppCallForErrorResult", "exception", "Lcom/facebook/FacebookException;", "setupAppCallForNativeDialog", "parameterProvider", "Lcom/facebook/internal/DialogPresenter$ParameterProvider;", "setupAppCallForValidationError", "validationError", "setupAppCallForWebDialog", "setupAppCallForWebFallbackDialog", "startActivityForResultWithAndroidX", "intent", "Landroid/content/Intent;", "requestCode", "", "ParameterProvider", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: DialogPresenter.kt */
public final class DialogPresenter {
    public static final DialogPresenter INSTANCE = new DialogPresenter();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/facebook/internal/DialogPresenter$ParameterProvider;", "", "legacyParameters", "Landroid/os/Bundle;", "getLegacyParameters", "()Landroid/os/Bundle;", "parameters", "getParameters", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: DialogPresenter.kt */
    public interface ParameterProvider {
        Bundle getLegacyParameters();

        Bundle getParameters();
    }

    private DialogPresenter() {
    }

    @JvmStatic
    public static final void setupAppCallForCannotShowError(AppCall appCall) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        setupAppCallForValidationError(appCall, new FacebookException("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14."));
    }

    @JvmStatic
    public static final void setupAppCallForValidationError(AppCall appCall, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        setupAppCallForErrorResult(appCall, facebookException);
    }

    @JvmStatic
    public static final void present(AppCall appCall, Activity activity) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.startActivityForResult(appCall.getRequestIntent(), appCall.getRequestCode());
        appCall.setPending();
    }

    @JvmStatic
    public static final void present(AppCall appCall, FragmentWrapper fragmentWrapper) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragmentWrapper");
        fragmentWrapper.startActivityForResult(appCall.getRequestIntent(), appCall.getRequestCode());
        appCall.setPending();
    }

    @JvmStatic
    public static final void present(AppCall appCall, ActivityResultRegistry activityResultRegistry, CallbackManager callbackManager) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(activityResultRegistry, "registry");
        Intent requestIntent = appCall.getRequestIntent();
        if (requestIntent != null) {
            startActivityForResultWithAndroidX(activityResultRegistry, callbackManager, requestIntent, appCall.getRequestCode());
            appCall.setPending();
        }
    }

    @JvmStatic
    public static final void startActivityForResultWithAndroidX(ActivityResultRegistry activityResultRegistry, CallbackManager callbackManager, Intent intent, int i) {
        Intrinsics.checkNotNullParameter(activityResultRegistry, "registry");
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = activityResultRegistry.register(Intrinsics.stringPlus("facebook-dialog-request-", Integer.valueOf(i)), new DialogPresenter$startActivityForResultWithAndroidX$1(), new DialogPresenter$$ExternalSyntheticLambda0(callbackManager, i, objectRef));
        ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) objectRef.element;
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(intent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startActivityForResultWithAndroidX$lambda-2  reason: not valid java name */
    public static final void m323startActivityForResultWithAndroidX$lambda2(CallbackManager callbackManager, int i, Ref.ObjectRef objectRef, Pair pair) {
        Intrinsics.checkNotNullParameter(objectRef, "$launcher");
        if (callbackManager == null) {
            callbackManager = new CallbackManagerImpl();
        }
        Object obj = pair.first;
        Intrinsics.checkNotNullExpressionValue(obj, "result.first");
        callbackManager.onActivityResult(i, ((Number) obj).intValue(), (Intent) pair.second);
        ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) objectRef.element;
        if (activityResultLauncher != null) {
            synchronized (activityResultLauncher) {
                activityResultLauncher.unregister();
                objectRef.element = null;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @JvmStatic
    public static final boolean canPresentNativeDialogWithFeature(DialogFeature dialogFeature) {
        Intrinsics.checkNotNullParameter(dialogFeature, "feature");
        return getProtocolVersionForNativeDialog(dialogFeature).getProtocolVersion() != -1;
    }

    @JvmStatic
    public static final boolean canPresentWebFallbackDialogWithFeature(DialogFeature dialogFeature) {
        Intrinsics.checkNotNullParameter(dialogFeature, "feature");
        return INSTANCE.getDialogWebFallbackUri(dialogFeature) != null;
    }

    @JvmStatic
    public static final void setupAppCallForErrorResult(AppCall appCall, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        if (facebookException != null) {
            Validate validate = Validate.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
            Intent intent = new Intent();
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
            intent.setAction(FacebookActivity.PASS_THROUGH_CANCEL_ACTION);
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            String uuid = appCall.getCallId().toString();
            NativeProtocol nativeProtocol2 = NativeProtocol.INSTANCE;
            int latestKnownVersion = NativeProtocol.getLatestKnownVersion();
            NativeProtocol nativeProtocol3 = NativeProtocol.INSTANCE;
            NativeProtocol.setupProtocolRequestIntent(intent, uuid, (String) null, latestKnownVersion, NativeProtocol.createBundleForException(facebookException));
            appCall.setRequestIntent(intent);
        }
    }

    @JvmStatic
    public static final void setupAppCallForWebDialog(AppCall appCall, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Validate validate = Validate.INSTANCE;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Validate validate2 = Validate.INSTANCE;
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        Bundle bundle2 = new Bundle();
        bundle2.putString("action", str);
        bundle2.putBundle("params", bundle);
        Intent intent = new Intent();
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        String uuid = appCall.getCallId().toString();
        NativeProtocol nativeProtocol2 = NativeProtocol.INSTANCE;
        NativeProtocol.setupProtocolRequestIntent(intent, uuid, str, NativeProtocol.getLatestKnownVersion(), bundle2);
        FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(FacebookDialogFragment.TAG);
        appCall.setRequestIntent(intent);
    }

    @JvmStatic
    public static final void setupAppCallForWebFallbackDialog(AppCall appCall, Bundle bundle, DialogFeature dialogFeature) {
        Uri uri;
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(dialogFeature, "feature");
        Validate validate = Validate.INSTANCE;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Validate validate2 = Validate.INSTANCE;
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        String name = dialogFeature.name();
        Uri dialogWebFallbackUri = INSTANCE.getDialogWebFallbackUri(dialogFeature);
        if (dialogWebFallbackUri != null) {
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            int latestKnownVersion = NativeProtocol.getLatestKnownVersion();
            ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
            String uuid = appCall.getCallId().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "appCall.callId.toString()");
            Bundle queryParamsForPlatformActivityIntentWebFallback = ServerProtocol.getQueryParamsForPlatformActivityIntentWebFallback(uuid, latestKnownVersion, bundle);
            if (queryParamsForPlatformActivityIntentWebFallback != null) {
                if (dialogWebFallbackUri.isRelative()) {
                    Utility utility = Utility.INSTANCE;
                    ServerProtocol serverProtocol2 = ServerProtocol.INSTANCE;
                    uri = Utility.buildUri(ServerProtocol.getDialogAuthority(), dialogWebFallbackUri.toString(), queryParamsForPlatformActivityIntentWebFallback);
                } else {
                    Utility utility2 = Utility.INSTANCE;
                    uri = Utility.buildUri(dialogWebFallbackUri.getAuthority(), dialogWebFallbackUri.getPath(), queryParamsForPlatformActivityIntentWebFallback);
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("url", uri.toString());
                bundle2.putBoolean(NativeProtocol.WEB_DIALOG_IS_FALLBACK, true);
                Intent intent = new Intent();
                NativeProtocol nativeProtocol2 = NativeProtocol.INSTANCE;
                String uuid2 = appCall.getCallId().toString();
                String action = dialogFeature.getAction();
                NativeProtocol nativeProtocol3 = NativeProtocol.INSTANCE;
                NativeProtocol.setupProtocolRequestIntent(intent, uuid2, action, NativeProtocol.getLatestKnownVersion(), bundle2);
                FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
                intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
                intent.setAction(FacebookDialogFragment.TAG);
                appCall.setRequestIntent(intent);
                return;
            }
            throw new FacebookException("Unable to fetch the app's key-hash");
        }
        throw new FacebookException("Unable to fetch the Url for the DialogFeature : '" + name + '\'');
    }

    @JvmStatic
    public static final void setupAppCallForNativeDialog(AppCall appCall, ParameterProvider parameterProvider, DialogFeature dialogFeature) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(parameterProvider, "parameterProvider");
        Intrinsics.checkNotNullParameter(dialogFeature, "feature");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        String action = dialogFeature.getAction();
        NativeProtocol.ProtocolVersionQueryResult protocolVersionForNativeDialog = getProtocolVersionForNativeDialog(dialogFeature);
        int protocolVersion = protocolVersionForNativeDialog.getProtocolVersion();
        if (protocolVersion != -1) {
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            if (NativeProtocol.isVersionCompatibleWithBucketedIntent(protocolVersion)) {
                bundle = parameterProvider.getParameters();
            } else {
                bundle = parameterProvider.getLegacyParameters();
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            NativeProtocol nativeProtocol2 = NativeProtocol.INSTANCE;
            Intent createPlatformActivityIntent = NativeProtocol.createPlatformActivityIntent(applicationContext, appCall.getCallId().toString(), action, protocolVersionForNativeDialog, bundle);
            if (createPlatformActivityIntent != null) {
                appCall.setRequestIntent(createPlatformActivityIntent);
                return;
            }
            throw new FacebookException("Unable to create Intent; this likely means theFacebook app is not installed.");
        }
        throw new FacebookException("Cannot present this dialog. This likely means that the Facebook app is not installed.");
    }

    @JvmStatic
    public static final void setupAppCallForCustomTabDialog(AppCall appCall, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Validate validate = Validate.INSTANCE;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        CustomTabUtils customTabUtils = CustomTabUtils.INSTANCE;
        Validate.hasCustomTabRedirectActivity(applicationContext, CustomTabUtils.getDefaultRedirectURI());
        Validate validate2 = Validate.INSTANCE;
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.EXTRA_ACTION, str);
        intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, bundle);
        String str2 = CustomTabMainActivity.EXTRA_CHROME_PACKAGE;
        CustomTabUtils customTabUtils2 = CustomTabUtils.INSTANCE;
        intent.putExtra(str2, CustomTabUtils.getChromePackage());
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        String uuid = appCall.getCallId().toString();
        NativeProtocol nativeProtocol2 = NativeProtocol.INSTANCE;
        NativeProtocol.setupProtocolRequestIntent(intent, uuid, str, NativeProtocol.getLatestKnownVersion(), (Bundle) null);
        appCall.setRequestIntent(intent);
    }

    private final Uri getDialogWebFallbackUri(DialogFeature dialogFeature) {
        String name = dialogFeature.name();
        String action = dialogFeature.getAction();
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        FetchedAppSettings.DialogFeatureConfig dialogFeatureConfig = FetchedAppSettings.Companion.getDialogFeatureConfig(FacebookSdk.getApplicationId(), action, name);
        if (dialogFeatureConfig != null) {
            return dialogFeatureConfig.getFallbackUrl();
        }
        return null;
    }

    @JvmStatic
    public static final NativeProtocol.ProtocolVersionQueryResult getProtocolVersionForNativeDialog(DialogFeature dialogFeature) {
        Intrinsics.checkNotNullParameter(dialogFeature, "feature");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        String action = dialogFeature.getAction();
        int[] versionSpecForFeature = INSTANCE.getVersionSpecForFeature(applicationId, action, dialogFeature);
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        return NativeProtocol.getLatestAvailableProtocolVersionForAction(action, versionSpecForFeature);
    }

    private final int[] getVersionSpecForFeature(String str, String str2, DialogFeature dialogFeature) {
        int[] iArr;
        FetchedAppSettings.DialogFeatureConfig dialogFeatureConfig = FetchedAppSettings.Companion.getDialogFeatureConfig(str, str2, dialogFeature.name());
        if (dialogFeatureConfig == null) {
            iArr = null;
        } else {
            iArr = dialogFeatureConfig.getVersionSpec();
        }
        if (iArr != null) {
            return iArr;
        }
        return new int[]{dialogFeature.getMinVersion()};
    }

    @JvmStatic
    public static final void logDialogActivity(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "outcome");
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(context);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME, str2);
        internalAppEventsLogger.logEventImplicitly(str, bundle);
    }
}
