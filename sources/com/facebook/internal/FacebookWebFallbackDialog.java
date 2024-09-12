package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.braze.ui.inappmessage.utils.InAppMessageWebViewClient;
import com.facebook.internal.WebDialog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/internal/FacebookWebFallbackDialog;", "Lcom/facebook/internal/WebDialog;", "context", "Landroid/content/Context;", "url", "", "expectedRedirectUrl", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "waitingForDialogToClose", "", "cancel", "", "parseResponseUri", "Landroid/os/Bundle;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FacebookWebFallbackDialog.kt */
public final class FacebookWebFallbackDialog extends WebDialog {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int OS_BACK_BUTTON_RESPONSE_TIMEOUT_MILLISECONDS = 1500;
    private static final String TAG = FacebookWebFallbackDialog.class.getName();
    private boolean waitingForDialogToClose;

    public /* synthetic */ FacebookWebFallbackDialog(Context context, String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2);
    }

    @JvmStatic
    public static final FacebookWebFallbackDialog newInstance(Context context, String str, String str2) {
        return Companion.newInstance(context, str, str2);
    }

    private FacebookWebFallbackDialog(Context context, String str, String str2) {
        super(context, str);
        setExpectedRedirectUrl(str2);
    }

    public Bundle parseResponseUri(String str) {
        Uri parse = Uri.parse(str);
        Utility utility = Utility.INSTANCE;
        Bundle parseUrlQueryString = Utility.parseUrlQueryString(parse.getQuery());
        String string = parseUrlQueryString.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_BRIDGE_ARGS);
        parseUrlQueryString.remove(ServerProtocol.FALLBACK_DIALOG_PARAM_BRIDGE_ARGS);
        Utility utility2 = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                BundleJSONConverter bundleJSONConverter = BundleJSONConverter.INSTANCE;
                parseUrlQueryString.putBundle(NativeProtocol.EXTRA_PROTOCOL_BRIDGE_ARGS, BundleJSONConverter.convertToBundle(jSONObject));
            } catch (JSONException e) {
                Utility utility3 = Utility.INSTANCE;
                Utility.logd(TAG, "Unable to parse bridge_args JSON", e);
            }
        }
        String string2 = parseUrlQueryString.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_METHOD_RESULTS);
        parseUrlQueryString.remove(ServerProtocol.FALLBACK_DIALOG_PARAM_METHOD_RESULTS);
        Utility utility4 = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(string2)) {
            try {
                JSONObject jSONObject2 = new JSONObject(string2);
                BundleJSONConverter bundleJSONConverter2 = BundleJSONConverter.INSTANCE;
                parseUrlQueryString.putBundle(NativeProtocol.EXTRA_PROTOCOL_METHOD_RESULTS, BundleJSONConverter.convertToBundle(jSONObject2));
            } catch (JSONException e2) {
                Utility utility5 = Utility.INSTANCE;
                Utility.logd(TAG, "Unable to parse bridge_args JSON", e2);
            }
        }
        parseUrlQueryString.remove("version");
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        parseUrlQueryString.putInt(NativeProtocol.EXTRA_PROTOCOL_VERSION, NativeProtocol.getLatestKnownVersion());
        return parseUrlQueryString;
    }

    public void cancel() {
        WebView webView = getWebView();
        if (!isPageFinished() || isListenerCalled() || webView == null || !webView.isShown()) {
            super.cancel();
        } else if (!this.waitingForDialogToClose) {
            this.waitingForDialogToClose = true;
            webView.loadUrl(Intrinsics.stringPlus(InAppMessageWebViewClient.JAVASCRIPT_PREFIX, "(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();"));
            new Handler(Looper.getMainLooper()).postDelayed(new FacebookWebFallbackDialog$$ExternalSyntheticLambda0(this), 1500);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: cancel$lambda-0  reason: not valid java name */
    public static final void m327cancel$lambda0(FacebookWebFallbackDialog facebookWebFallbackDialog) {
        Intrinsics.checkNotNullParameter(facebookWebFallbackDialog, "this$0");
        super.cancel();
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/internal/FacebookWebFallbackDialog$Companion;", "", "()V", "OS_BACK_BUTTON_RESPONSE_TIMEOUT_MILLISECONDS", "", "TAG", "", "kotlin.jvm.PlatformType", "newInstance", "Lcom/facebook/internal/FacebookWebFallbackDialog;", "context", "Landroid/content/Context;", "url", "expectedRedirectUrl", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: FacebookWebFallbackDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FacebookWebFallbackDialog newInstance(Context context, String str, String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(str2, "expectedRedirectUrl");
            WebDialog.Companion companion = WebDialog.Companion;
            WebDialog.initDefaultTheme(context);
            return new FacebookWebFallbackDialog(context, str, str2, (DefaultConstructorMarker) null);
        }
    }
}
