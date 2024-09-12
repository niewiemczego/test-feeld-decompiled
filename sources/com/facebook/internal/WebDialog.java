package com.facebook.internal;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.AccessToken;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.common.R;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginTargetApp;
import com.google.firebase.dynamiclinks.DynamicLink;
import io.sentry.protocol.Response;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\f\b\u0016\u0018\u0000 N2\u00020\u0001:\u0006MNOPQRB\u0017\b\u0014\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB=\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020-H\u0002J\b\u0010/\u001a\u00020-H\u0016J(\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\bH\u0002J\b\u00106\u001a\u00020-H\u0016J\u0012\u00107\u001a\u00020-2\b\u00108\u001a\u0004\u0018\u00010\fH\u0014J\b\u00109\u001a\u00020-H\u0016J\u0018\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020-H\u0014J\b\u0010?\u001a\u00020-H\u0014J\u0010\u0010@\u001a\u00020-2\u0006\u0010A\u001a\u00020+H\u0016J\u0012\u0010B\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010\u0005H\u0017J\u0006\u0010D\u001a\u00020-J\u0012\u0010E\u001a\u00020-2\b\u0010F\u001a\u0004\u0018\u00010GH\u0004J\u0012\u0010H\u001a\u00020-2\b\u0010I\u001a\u0004\u0018\u00010\fH\u0004J\u0010\u0010J\u001a\u00020-2\u0006\u0010\u0016\u001a\u00020\u0005H\u0004J\u0010\u0010K\u001a\u00020-2\u0006\u0010L\u001a\u00020\bH\u0003R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0018\u00010%R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\"\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\u0019\u001a\u0004\u0018\u00010&@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/facebook/internal/WebDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "url", "", "(Landroid/content/Context;Ljava/lang/String;)V", "theme", "", "(Landroid/content/Context;Ljava/lang/String;I)V", "action", "parameters", "Landroid/os/Bundle;", "targetApp", "Lcom/facebook/login/LoginTargetApp;", "listener", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;ILcom/facebook/login/LoginTargetApp;Lcom/facebook/internal/WebDialog$OnCompleteListener;)V", "contentFrameLayout", "Landroid/widget/FrameLayout;", "crossImageView", "Landroid/widget/ImageView;", "expectedRedirectUrl", "isDetached", "", "<set-?>", "isListenerCalled", "()Z", "isPageFinished", "onCompleteListener", "getOnCompleteListener", "()Lcom/facebook/internal/WebDialog$OnCompleteListener;", "setOnCompleteListener", "(Lcom/facebook/internal/WebDialog$OnCompleteListener;)V", "spinner", "Landroid/app/ProgressDialog;", "uploadTask", "Lcom/facebook/internal/WebDialog$UploadStagingResourcesTask;", "Landroid/webkit/WebView;", "webView", "getWebView", "()Landroid/webkit/WebView;", "windowParams", "Landroid/view/WindowManager$LayoutParams;", "cancel", "", "createCrossImage", "dismiss", "getScaledSize", "screenSize", "density", "", "noPaddingSize", "maxPaddingSize", "onAttachedToWindow", "onCreate", "savedInstanceState", "onDetachedFromWindow", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onStart", "onStop", "onWindowAttributesChanged", "params", "parseResponseUri", "urlString", "resize", "sendErrorToListener", "error", "", "sendSuccessToListener", "values", "setExpectedRedirectUrl", "setUpWebView", "margin", "Builder", "Companion", "DialogWebViewClient", "InitCallback", "OnCompleteListener", "UploadStagingResourcesTask", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: WebDialog.kt */
public class WebDialog extends Dialog {
    private static final int API_EC_DIALOG_CANCEL = 4201;
    private static final int BACKGROUND_GRAY = -872415232;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int DEFAULT_THEME = R.style.com_facebook_activity_theme;
    public static final boolean DISABLE_SSL_CHECK_FOR_TESTING = false;
    private static final String DISPLAY_TOUCH = "touch";
    private static final String LOG_TAG = "FacebookSDK.WebDialog";
    private static final int MAX_PADDING_SCREEN_HEIGHT = 1280;
    private static final int MAX_PADDING_SCREEN_WIDTH = 800;
    private static final double MIN_SCALE_FACTOR = 0.5d;
    private static final int NO_PADDING_SCREEN_HEIGHT = 800;
    private static final int NO_PADDING_SCREEN_WIDTH = 480;
    private static final String PLATFORM_DIALOG_PATH_REGEX = "^/(v\\d+\\.\\d+/)??dialog/.*";
    /* access modifiers changed from: private */
    public static InitCallback initCallback;
    /* access modifiers changed from: private */
    public static volatile int webDialogTheme;
    /* access modifiers changed from: private */
    public FrameLayout contentFrameLayout;
    /* access modifiers changed from: private */
    public ImageView crossImageView;
    /* access modifiers changed from: private */
    public String expectedRedirectUrl;
    /* access modifiers changed from: private */
    public boolean isDetached;
    private boolean isListenerCalled;
    /* access modifiers changed from: private */
    public boolean isPageFinished;
    private OnCompleteListener onCompleteListener;
    /* access modifiers changed from: private */
    public ProgressDialog spinner;
    private UploadStagingResourcesTask uploadTask;
    /* access modifiers changed from: private */
    public String url;
    private WebView webView;
    private WindowManager.LayoutParams windowParams;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/WebDialog$InitCallback;", "", "onInit", "", "webView", "Landroid/webkit/WebView;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: WebDialog.kt */
    public interface InitCallback {
        void onInit(WebView webView);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/facebook/internal/WebDialog$OnCompleteListener;", "", "onComplete", "", "values", "Landroid/os/Bundle;", "error", "Lcom/facebook/FacebookException;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: WebDialog.kt */
    public interface OnCompleteListener {
        void onComplete(Bundle bundle, FacebookException facebookException);
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: WebDialog.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoginTargetApp.values().length];
            iArr[LoginTargetApp.INSTAGRAM.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ WebDialog(Context context, String str, Bundle bundle, int i, LoginTargetApp loginTargetApp, OnCompleteListener onCompleteListener2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, bundle, i, loginTargetApp, onCompleteListener2);
    }

    private final int getScaledSize(int i, float f, int i2, int i3) {
        int i4 = (int) (((float) i) / f);
        double d = 0.5d;
        if (i4 <= i2) {
            d = 1.0d;
        } else if (i4 < i3) {
            d = 0.5d + ((((double) (i3 - i4)) / ((double) (i3 - i2))) * 0.5d);
        }
        return (int) (((double) i) * d);
    }

    @JvmStatic
    public static final int getWebDialogTheme() {
        return Companion.getWebDialogTheme();
    }

    @JvmStatic
    protected static final void initDefaultTheme(Context context) {
        Companion.initDefaultTheme(context);
    }

    @JvmStatic
    public static final WebDialog newInstance(Context context, String str, Bundle bundle, int i, OnCompleteListener onCompleteListener2) {
        return Companion.newInstance(context, str, bundle, i, onCompleteListener2);
    }

    @JvmStatic
    public static final WebDialog newInstance(Context context, String str, Bundle bundle, int i, LoginTargetApp loginTargetApp, OnCompleteListener onCompleteListener2) {
        return Companion.newInstance(context, str, bundle, i, loginTargetApp, onCompleteListener2);
    }

    @JvmStatic
    public static final void setInitCallback(InitCallback initCallback2) {
        Companion.setInitCallback(initCallback2);
    }

    @JvmStatic
    public static final void setWebDialogTheme(int i) {
        Companion.setWebDialogTheme(i);
    }

    public final OnCompleteListener getOnCompleteListener() {
        return this.onCompleteListener;
    }

    public final void setOnCompleteListener(OnCompleteListener onCompleteListener2) {
        this.onCompleteListener = onCompleteListener2;
    }

    /* access modifiers changed from: protected */
    public final WebView getWebView() {
        return this.webView;
    }

    /* access modifiers changed from: protected */
    public final boolean isListenerCalled() {
        return this.isListenerCalled;
    }

    /* access modifiers changed from: protected */
    public final boolean isPageFinished() {
        return this.isPageFinished;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    protected WebDialog(Context context, String str) {
        this(context, str, Companion.getWebDialogTheme());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private WebDialog(Context context, String str, int i) {
        super(context, i == 0 ? Companion.getWebDialogTheme() : i);
        this.expectedRedirectUrl = ServerProtocol.DIALOG_REDIRECT_URI;
        this.url = str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private WebDialog(Context context, String str, Bundle bundle, int i, LoginTargetApp loginTargetApp, OnCompleteListener onCompleteListener2) {
        super(context, i == 0 ? Companion.getWebDialogTheme() : i);
        Uri uri;
        String str2 = ServerProtocol.DIALOG_REDIRECT_URI;
        this.expectedRedirectUrl = str2;
        bundle = bundle == null ? new Bundle() : bundle;
        Utility utility = Utility.INSTANCE;
        str2 = Utility.isChromeOS(context) ? ServerProtocol.DIALOG_REDIRECT_CHROME_OS_URI : str2;
        this.expectedRedirectUrl = str2;
        bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, str2);
        bundle.putString("display", "touch");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        bundle.putString("client_id", FacebookSdk.getApplicationId());
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.ROOT;
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        String format = String.format(locale, "android-%s", Arrays.copyOf(new Object[]{FacebookSdk.getSdkVersion()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
        bundle.putString("sdk", format);
        this.onCompleteListener = onCompleteListener2;
        if (!Intrinsics.areEqual((Object) str, (Object) "share") || !bundle.containsKey("media")) {
            if (WhenMappings.$EnumSwitchMapping$0[loginTargetApp.ordinal()] == 1) {
                Utility utility2 = Utility.INSTANCE;
                ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
                uri = Utility.buildUri(ServerProtocol.getInstagramDialogAuthority(), ServerProtocol.INSTAGRAM_OAUTH_PATH, bundle);
            } else {
                Utility utility3 = Utility.INSTANCE;
                ServerProtocol serverProtocol2 = ServerProtocol.INSTANCE;
                String dialogAuthority = ServerProtocol.getDialogAuthority();
                StringBuilder sb = new StringBuilder();
                FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
                uri = Utility.buildUri(dialogAuthority, sb.append(FacebookSdk.getGraphApiVersion()).append("/dialog/").append(str).toString(), bundle);
            }
            this.url = uri.toString();
            return;
        }
        this.uploadTask = new UploadStagingResourcesTask(this, str, bundle);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        if (i == 4) {
            WebView webView2 = this.webView;
            if (webView2 != null) {
                if (Intrinsics.areEqual((Object) webView2 == null ? null : Boolean.valueOf(webView2.canGoBack()), (Object) true)) {
                    WebView webView3 = this.webView;
                    if (webView3 != null) {
                        webView3.goBack();
                    }
                    return true;
                }
            }
            cancel();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void dismiss() {
        ProgressDialog progressDialog;
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.stopLoading();
        }
        if (!this.isDetached && (progressDialog = this.spinner) != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        super.dismiss();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        UploadStagingResourcesTask uploadStagingResourcesTask = this.uploadTask;
        if (uploadStagingResourcesTask != null) {
            if ((uploadStagingResourcesTask == null ? null : uploadStagingResourcesTask.getStatus()) == AsyncTask.Status.PENDING) {
                UploadStagingResourcesTask uploadStagingResourcesTask2 = this.uploadTask;
                if (uploadStagingResourcesTask2 != null) {
                    uploadStagingResourcesTask2.execute(new Void[0]);
                }
                ProgressDialog progressDialog = this.spinner;
                if (progressDialog != null) {
                    progressDialog.show();
                    return;
                }
                return;
            }
        }
        resize();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        UploadStagingResourcesTask uploadStagingResourcesTask = this.uploadTask;
        if (uploadStagingResourcesTask != null) {
            uploadStagingResourcesTask.cancel(true);
            ProgressDialog progressDialog = this.spinner;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
        super.onStop();
    }

    public void onDetachedFromWindow() {
        this.isDetached = true;
        super.onDetachedFromWindow();
    }

    public void onAttachedToWindow() {
        WindowManager.LayoutParams layoutParams;
        IBinder iBinder;
        WindowManager.LayoutParams attributes;
        this.isDetached = false;
        Utility utility = Utility.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (Utility.mustFixWindowParamsForAutofill(context) && (layoutParams = this.windowParams) != null) {
            IBinder iBinder2 = null;
            if (layoutParams == null) {
                iBinder = null;
            } else {
                iBinder = layoutParams.token;
            }
            if (iBinder == null) {
                WindowManager.LayoutParams layoutParams2 = this.windowParams;
                if (layoutParams2 != null) {
                    Activity ownerActivity = getOwnerActivity();
                    Window window = ownerActivity == null ? null : ownerActivity.getWindow();
                    layoutParams2.token = (window == null || (attributes = window.getAttributes()) == null) ? null : attributes.token;
                }
                Utility utility2 = Utility.INSTANCE;
                WindowManager.LayoutParams layoutParams3 = this.windowParams;
                if (layoutParams3 != null) {
                    iBinder2 = layoutParams3.token;
                }
                Utility.logd(LOG_TAG, Intrinsics.stringPlus("Set token on onAttachedToWindow(): ", iBinder2));
            }
        }
        super.onAttachedToWindow();
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "params");
        if (layoutParams.token == null) {
            this.windowParams = layoutParams;
        }
        super.onWindowAttributesChanged(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        this.spinner = progressDialog;
        progressDialog.requestWindowFeature(1);
        ProgressDialog progressDialog2 = this.spinner;
        if (progressDialog2 != null) {
            progressDialog2.setMessage(getContext().getString(R.string.com_facebook_loading));
        }
        ProgressDialog progressDialog3 = this.spinner;
        if (progressDialog3 != null) {
            progressDialog3.setCanceledOnTouchOutside(false);
        }
        ProgressDialog progressDialog4 = this.spinner;
        if (progressDialog4 != null) {
            progressDialog4.setOnCancelListener(new WebDialog$$ExternalSyntheticLambda0(this));
        }
        requestWindowFeature(1);
        this.contentFrameLayout = new FrameLayout(getContext());
        resize();
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(16);
        }
        createCrossImage();
        if (this.url != null) {
            ImageView imageView = this.crossImageView;
            if (imageView != null) {
                setUpWebView((imageView.getDrawable().getIntrinsicWidth() / 2) + 1);
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        FrameLayout frameLayout = this.contentFrameLayout;
        if (frameLayout != null) {
            frameLayout.addView(this.crossImageView, new ViewGroup.LayoutParams(-2, -2));
        }
        FrameLayout frameLayout2 = this.contentFrameLayout;
        if (frameLayout2 != null) {
            setContentView(frameLayout2);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-4  reason: not valid java name */
    public static final void m349onCreate$lambda4(WebDialog webDialog, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(webDialog, "this$0");
        webDialog.cancel();
    }

    /* access modifiers changed from: protected */
    public final void setExpectedRedirectUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "expectedRedirectUrl");
        this.expectedRedirectUrl = str;
    }

    public Bundle parseResponseUri(String str) {
        Uri parse = Uri.parse(str);
        Utility utility = Utility.INSTANCE;
        Bundle parseUrlQueryString = Utility.parseUrlQueryString(parse.getQuery());
        Utility utility2 = Utility.INSTANCE;
        parseUrlQueryString.putAll(Utility.parseUrlQueryString(parse.getFragment()));
        return parseUrlQueryString;
    }

    public final void resize() {
        int i;
        int i2;
        Object systemService = getContext().getSystemService("window");
        if (systemService != null) {
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
                i = displayMetrics.widthPixels;
            } else {
                i = displayMetrics.heightPixels;
            }
            if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
                i2 = displayMetrics.heightPixels;
            } else {
                i2 = displayMetrics.widthPixels;
            }
            int min = Math.min(getScaledSize(i, displayMetrics.density, NO_PADDING_SCREEN_WIDTH, 800), displayMetrics.widthPixels);
            int min2 = Math.min(getScaledSize(i2, displayMetrics.density, 800, MAX_PADDING_SCREEN_HEIGHT), displayMetrics.heightPixels);
            Window window = getWindow();
            if (window != null) {
                window.setLayout(min, min2);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    /* access modifiers changed from: protected */
    public final void sendSuccessToListener(Bundle bundle) {
        OnCompleteListener onCompleteListener2 = this.onCompleteListener;
        if (onCompleteListener2 != null && !this.isListenerCalled) {
            this.isListenerCalled = true;
            if (onCompleteListener2 != null) {
                onCompleteListener2.onComplete(bundle, (FacebookException) null);
            }
            dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public final void sendErrorToListener(Throwable th) {
        FacebookException facebookException;
        if (this.onCompleteListener != null && !this.isListenerCalled) {
            this.isListenerCalled = true;
            if (th instanceof FacebookException) {
                facebookException = (FacebookException) th;
            } else {
                facebookException = new FacebookException(th);
            }
            OnCompleteListener onCompleteListener2 = this.onCompleteListener;
            if (onCompleteListener2 != null) {
                onCompleteListener2.onComplete((Bundle) null, facebookException);
            }
            dismiss();
        }
    }

    public void cancel() {
        if (this.onCompleteListener != null && !this.isListenerCalled) {
            sendErrorToListener(new FacebookOperationCanceledException());
        }
    }

    private final void createCrossImage() {
        ImageView imageView = new ImageView(getContext());
        this.crossImageView = imageView;
        imageView.setOnClickListener(new WebDialog$$ExternalSyntheticLambda1(this));
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.com_facebook_close);
        ImageView imageView2 = this.crossImageView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
        ImageView imageView3 = this.crossImageView;
        if (imageView3 != null) {
            imageView3.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: createCrossImage$lambda-5  reason: not valid java name */
    public static final void m348createCrossImage$lambda5(WebDialog webDialog, View view) {
        Intrinsics.checkNotNullParameter(webDialog, "this$0");
        webDialog.cancel();
    }

    /* access modifiers changed from: private */
    public final void setUpWebView(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.webView = new WebDialog$setUpWebView$1(getContext());
        InitCallback initCallback2 = initCallback;
        if (initCallback2 != null) {
            initCallback2.onInit(getWebView());
        }
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.setVerticalScrollBarEnabled(false);
        }
        WebView webView3 = this.webView;
        if (webView3 != null) {
            webView3.setHorizontalScrollBarEnabled(false);
        }
        WebView webView4 = this.webView;
        if (webView4 != null) {
            webView4.setWebViewClient(new DialogWebViewClient(this));
        }
        WebView webView5 = this.webView;
        WebSettings webSettings = null;
        WebSettings settings = webView5 == null ? null : webView5.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
        }
        WebView webView6 = this.webView;
        if (webView6 != null) {
            String str = this.url;
            if (str != null) {
                webView6.loadUrl(str);
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        WebView webView7 = this.webView;
        if (webView7 != null) {
            webView7.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        WebView webView8 = this.webView;
        if (webView8 != null) {
            webView8.setVisibility(4);
        }
        WebView webView9 = this.webView;
        WebSettings settings2 = webView9 == null ? null : webView9.getSettings();
        if (settings2 != null) {
            settings2.setSavePassword(false);
        }
        WebView webView10 = this.webView;
        if (webView10 != null) {
            webSettings = webView10.getSettings();
        }
        if (webSettings != null) {
            webSettings.setSaveFormData(false);
        }
        WebView webView11 = this.webView;
        if (webView11 != null) {
            webView11.setFocusable(true);
        }
        WebView webView12 = this.webView;
        if (webView12 != null) {
            webView12.setFocusableInTouchMode(true);
        }
        WebView webView13 = this.webView;
        if (webView13 != null) {
            webView13.setOnTouchListener(new WebDialog$$ExternalSyntheticLambda2());
        }
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.webView);
        linearLayout.setBackgroundColor(BACKGROUND_GRAY);
        FrameLayout frameLayout = this.contentFrameLayout;
        if (frameLayout != null) {
            frameLayout.addView(linearLayout);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpWebView$lambda-7  reason: not valid java name */
    public static final boolean m350setUpWebView$lambda7(View view, MotionEvent motionEvent) {
        if (view.hasFocus()) {
            return false;
        }
        view.requestFocus();
        return false;
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u0018"}, d2 = {"Lcom/facebook/internal/WebDialog$DialogWebViewClient;", "Landroid/webkit/WebViewClient;", "(Lcom/facebook/internal/WebDialog;)V", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "errorCode", "", "description", "failingUrl", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "shouldOverrideUrlLoading", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: WebDialog.kt */
    private final class DialogWebViewClient extends WebViewClient {
        final /* synthetic */ WebDialog this$0;

        public DialogWebViewClient(WebDialog webDialog) {
            Intrinsics.checkNotNullParameter(webDialog, "this$0");
            this.this$0 = webDialog;
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x008b  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00ad  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00b3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean shouldOverrideUrlLoading(android.webkit.WebView r6, java.lang.String r7) {
            /*
                r5 = this;
                java.lang.String r0 = "view"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r6 = "url"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r6)
                com.facebook.internal.Utility r6 = com.facebook.internal.Utility.INSTANCE
                java.lang.String r6 = "Redirect URL: "
                java.lang.String r6 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r7)
                java.lang.String r0 = "FacebookSDK.WebDialog"
                com.facebook.internal.Utility.logd((java.lang.String) r0, (java.lang.String) r6)
                android.net.Uri r6 = android.net.Uri.parse(r7)
                java.lang.String r0 = r6.getPath()
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x0033
                java.lang.String r6 = r6.getPath()
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                java.lang.String r0 = "^/(v\\d+\\.\\d+/)??dialog/.*"
                boolean r6 = java.util.regex.Pattern.matches(r0, r6)
                if (r6 == 0) goto L_0x0033
                r6 = r1
                goto L_0x0034
            L_0x0033:
                r6 = r2
            L_0x0034:
                com.facebook.internal.WebDialog r0 = r5.this$0
                java.lang.String r0 = r0.expectedRedirectUrl
                r3 = 2
                r4 = 0
                boolean r0 = kotlin.text.StringsKt.startsWith$default(r7, r0, r2, r3, r4)
                if (r0 == 0) goto L_0x00cf
                com.facebook.internal.WebDialog r6 = r5.this$0
                android.os.Bundle r6 = r6.parseResponseUri(r7)
                java.lang.String r7 = "error"
                java.lang.String r7 = r6.getString(r7)
                if (r7 != 0) goto L_0x0056
                java.lang.String r7 = "error_type"
                java.lang.String r7 = r6.getString(r7)
            L_0x0056:
                java.lang.String r0 = "error_msg"
                java.lang.String r0 = r6.getString(r0)
                if (r0 != 0) goto L_0x0064
                java.lang.String r0 = "error_message"
                java.lang.String r0 = r6.getString(r0)
            L_0x0064:
                if (r0 != 0) goto L_0x006c
                java.lang.String r0 = "error_description"
                java.lang.String r0 = r6.getString(r0)
            L_0x006c:
                java.lang.String r2 = "error_code"
                java.lang.String r2 = r6.getString(r2)
                r3 = -1
                if (r2 == 0) goto L_0x0082
                com.facebook.internal.Utility r4 = com.facebook.internal.Utility.INSTANCE
                boolean r4 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r2)
                if (r4 != 0) goto L_0x0082
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x0082 }
                goto L_0x0083
            L_0x0082:
                r2 = r3
            L_0x0083:
                com.facebook.internal.Utility r4 = com.facebook.internal.Utility.INSTANCE
                boolean r4 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r7)
                if (r4 == 0) goto L_0x009b
                com.facebook.internal.Utility r4 = com.facebook.internal.Utility.INSTANCE
                boolean r4 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r0)
                if (r4 == 0) goto L_0x009b
                if (r2 != r3) goto L_0x009b
                com.facebook.internal.WebDialog r7 = r5.this$0
                r7.sendSuccessToListener(r6)
                goto L_0x00ce
            L_0x009b:
                if (r7 == 0) goto L_0x00b3
                java.lang.String r6 = "access_denied"
                boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r6)
                if (r6 != 0) goto L_0x00ad
                java.lang.String r6 = "OAuthAccessDeniedException"
                boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r6)
                if (r6 == 0) goto L_0x00b3
            L_0x00ad:
                com.facebook.internal.WebDialog r6 = r5.this$0
                r6.cancel()
                goto L_0x00ce
            L_0x00b3:
                r6 = 4201(0x1069, float:5.887E-42)
                if (r2 != r6) goto L_0x00bd
                com.facebook.internal.WebDialog r6 = r5.this$0
                r6.cancel()
                goto L_0x00ce
            L_0x00bd:
                com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
                r6.<init>(r2, r7, r0)
                com.facebook.internal.WebDialog r7 = r5.this$0
                com.facebook.FacebookServiceException r2 = new com.facebook.FacebookServiceException
                r2.<init>(r6, r0)
                java.lang.Throwable r2 = (java.lang.Throwable) r2
                r7.sendErrorToListener(r2)
            L_0x00ce:
                return r1
            L_0x00cf:
                java.lang.String r0 = "fbconnect://cancel"
                boolean r0 = kotlin.text.StringsKt.startsWith$default(r7, r0, r2, r3, r4)
                if (r0 == 0) goto L_0x00dd
                com.facebook.internal.WebDialog r6 = r5.this$0
                r6.cancel()
                return r1
            L_0x00dd:
                if (r6 != 0) goto L_0x0104
                r6 = r7
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                java.lang.String r0 = "touch"
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r6 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r6, (java.lang.CharSequence) r0, (boolean) r2, (int) r3, (java.lang.Object) r4)
                if (r6 == 0) goto L_0x00ed
                goto L_0x0104
            L_0x00ed:
                com.facebook.internal.WebDialog r6 = r5.this$0     // Catch:{ ActivityNotFoundException -> 0x0102 }
                android.content.Context r6 = r6.getContext()     // Catch:{ ActivityNotFoundException -> 0x0102 }
                android.content.Intent r0 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x0102 }
                java.lang.String r3 = "android.intent.action.VIEW"
                android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ ActivityNotFoundException -> 0x0102 }
                r0.<init>(r3, r7)     // Catch:{ ActivityNotFoundException -> 0x0102 }
                r6.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x0102 }
                goto L_0x0103
            L_0x0102:
                r1 = r2
            L_0x0103:
                return r1
            L_0x0104:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.WebDialog.DialogWebViewClient.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(webView, ViewHierarchyConstants.VIEW_KEY);
            Intrinsics.checkNotNullParameter(str, "description");
            Intrinsics.checkNotNullParameter(str2, "failingUrl");
            super.onReceivedError(webView, i, str, str2);
            this.this$0.sendErrorToListener(new FacebookDialogException(str, i, str2));
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Intrinsics.checkNotNullParameter(webView, ViewHierarchyConstants.VIEW_KEY);
            Intrinsics.checkNotNullParameter(sslErrorHandler, "handler");
            Intrinsics.checkNotNullParameter(sslError, "error");
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslErrorHandler.cancel();
            this.this$0.sendErrorToListener(new FacebookDialogException((String) null, -11, (String) null));
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            ProgressDialog access$getSpinner$p;
            Intrinsics.checkNotNullParameter(webView, ViewHierarchyConstants.VIEW_KEY);
            Intrinsics.checkNotNullParameter(str, "url");
            Utility utility = Utility.INSTANCE;
            Utility.logd(WebDialog.LOG_TAG, Intrinsics.stringPlus("Webview loading URL: ", str));
            super.onPageStarted(webView, str, bitmap);
            if (!this.this$0.isDetached && (access$getSpinner$p = this.this$0.spinner) != null) {
                access$getSpinner$p.show();
            }
        }

        public void onPageFinished(WebView webView, String str) {
            ProgressDialog access$getSpinner$p;
            Intrinsics.checkNotNullParameter(webView, ViewHierarchyConstants.VIEW_KEY);
            Intrinsics.checkNotNullParameter(str, "url");
            super.onPageFinished(webView, str);
            if (!this.this$0.isDetached && (access$getSpinner$p = this.this$0.spinner) != null) {
                access$getSpinner$p.dismiss();
            }
            FrameLayout access$getContentFrameLayout$p = this.this$0.contentFrameLayout;
            if (access$getContentFrameLayout$p != null) {
                access$getContentFrameLayout$p.setBackgroundColor(0);
            }
            WebView webView2 = this.this$0.getWebView();
            if (webView2 != null) {
                webView2.setVisibility(0);
            }
            ImageView access$getCrossImageView$p = this.this$0.crossImageView;
            if (access$getCrossImageView$p != null) {
                access$getCrossImageView$p.setVisibility(0);
            }
            this.this$0.isPageFinished = true;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J$\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010 \u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0012@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/facebook/internal/WebDialog$Builder;", "", "context", "Landroid/content/Context;", "action", "", "parameters", "Landroid/os/Bundle;", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V", "applicationId", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "accessToken", "Lcom/facebook/AccessToken;", "<set-?>", "getApplicationId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", "listener", "getListener", "()Lcom/facebook/internal/WebDialog$OnCompleteListener;", "getParameters", "()Landroid/os/Bundle;", "", "theme", "getTheme", "()I", "build", "Lcom/facebook/internal/WebDialog;", "finishInit", "", "setOnCompleteListener", "setTheme", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: WebDialog.kt */
    public static class Builder {
        private AccessToken accessToken;
        private String action;
        private String applicationId;
        private Context context;
        private OnCompleteListener listener;
        private Bundle parameters;
        private int theme;

        public final Context getContext() {
            return this.context;
        }

        public final String getApplicationId() {
            return this.applicationId;
        }

        public final int getTheme() {
            return this.theme;
        }

        public final OnCompleteListener getListener() {
            return this.listener;
        }

        public final Bundle getParameters() {
            return this.parameters;
        }

        public Builder(Context context2, String str, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(str, "action");
            this.accessToken = AccessToken.Companion.getCurrentAccessToken();
            if (!AccessToken.Companion.isCurrentAccessTokenActive()) {
                Utility utility = Utility.INSTANCE;
                String metadataApplicationId = Utility.getMetadataApplicationId(context2);
                if (metadataApplicationId != null) {
                    this.applicationId = metadataApplicationId;
                } else {
                    throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
                }
            }
            finishInit(context2, str, bundle);
        }

        public Builder(Context context2, String str, String str2, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(str2, "action");
            if (str == null) {
                Utility utility = Utility.INSTANCE;
                str = Utility.getMetadataApplicationId(context2);
            }
            Validate validate = Validate.INSTANCE;
            this.applicationId = Validate.notNullOrEmpty(str, "applicationId");
            finishInit(context2, str2, bundle);
        }

        public final Builder setTheme(int i) {
            this.theme = i;
            return this;
        }

        public final Builder setOnCompleteListener(OnCompleteListener onCompleteListener) {
            this.listener = onCompleteListener;
            return this;
        }

        public WebDialog build() {
            AccessToken accessToken2 = this.accessToken;
            if (accessToken2 != null) {
                Bundle bundle = this.parameters;
                String str = null;
                if (bundle != null) {
                    bundle.putString("app_id", accessToken2 == null ? null : accessToken2.getApplicationId());
                }
                Bundle bundle2 = this.parameters;
                if (bundle2 != null) {
                    AccessToken accessToken3 = this.accessToken;
                    if (accessToken3 != null) {
                        str = accessToken3.getToken();
                    }
                    bundle2.putString("access_token", str);
                }
            } else {
                Bundle bundle3 = this.parameters;
                if (bundle3 != null) {
                    bundle3.putString("app_id", this.applicationId);
                }
            }
            Companion companion = WebDialog.Companion;
            Context context2 = this.context;
            if (context2 != null) {
                return companion.newInstance(context2, this.action, this.parameters, this.theme, this.listener);
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        private final void finishInit(Context context2, String str, Bundle bundle) {
            this.context = context2;
            this.action = str;
            if (bundle != null) {
                this.parameters = bundle;
            } else {
                this.parameters = new Bundle();
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ+\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0003\"\u00020\u0002H\u0014¢\u0006\u0002\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0010\u0012\f\u0012\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b0\u0003X\u000e¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/internal/WebDialog$UploadStagingResourcesTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "", "action", "parameters", "Landroid/os/Bundle;", "(Lcom/facebook/internal/WebDialog;Ljava/lang/String;Landroid/os/Bundle;)V", "exceptions", "Ljava/lang/Exception;", "Lkotlin/Exception;", "[Ljava/lang/Exception;", "doInBackground", "p0", "([Ljava/lang/Void;)[Ljava/lang/String;", "onPostExecute", "", "results", "([Ljava/lang/String;)V", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: WebDialog.kt */
    private final class UploadStagingResourcesTask extends AsyncTask<Void, Void, String[]> {
        private final String action;
        private Exception[] exceptions = new Exception[0];
        private final Bundle parameters;
        final /* synthetic */ WebDialog this$0;

        public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return null;
                }
                return doInBackground((Void[]) objArr);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    if (!CrashShieldHandler.isObjectCrashing(this)) {
                        onPostExecute((String[]) obj);
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }

        public UploadStagingResourcesTask(WebDialog webDialog, String str, Bundle bundle) {
            Intrinsics.checkNotNullParameter(webDialog, "this$0");
            Intrinsics.checkNotNullParameter(str, "action");
            Intrinsics.checkNotNullParameter(bundle, DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS);
            this.this$0 = webDialog;
            this.action = str;
            this.parameters = bundle;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:33|34|(2:37|35)|49|38) */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r12 = r3.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x009c, code lost:
            if (r12.hasNext() != false) goto L_0x009e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x009e, code lost:
            ((com.facebook.GraphRequestAsyncTask) r12.next()).cancel(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a8, code lost:
            return null;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0094 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String[] doInBackground(java.lang.Void... r12) {
            /*
                r11 = this;
                boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r11)
                r1 = 0
                if (r0 == 0) goto L_0x0008
                return r1
            L_0x0008:
                boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r11)     // Catch:{ all -> 0x00ae }
                if (r0 == 0) goto L_0x000f
                return r1
            L_0x000f:
                java.lang.String r0 = "p0"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)     // Catch:{ all -> 0x00a9 }
                android.os.Bundle r12 = r11.parameters     // Catch:{ all -> 0x00a9 }
                java.lang.String r0 = "media"
                java.lang.String[] r12 = r12.getStringArray(r0)     // Catch:{ all -> 0x00a9 }
                if (r12 != 0) goto L_0x001f
                return r1
            L_0x001f:
                int r0 = r12.length     // Catch:{ all -> 0x00a9 }
                java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ all -> 0x00a9 }
                int r2 = r12.length     // Catch:{ all -> 0x00a9 }
                java.lang.Exception[] r2 = new java.lang.Exception[r2]     // Catch:{ all -> 0x00a9 }
                r11.exceptions = r2     // Catch:{ all -> 0x00a9 }
                java.util.concurrent.CountDownLatch r2 = new java.util.concurrent.CountDownLatch     // Catch:{ all -> 0x00a9 }
                int r3 = r12.length     // Catch:{ all -> 0x00a9 }
                r2.<init>(r3)     // Catch:{ all -> 0x00a9 }
                java.util.concurrent.ConcurrentLinkedQueue r3 = new java.util.concurrent.ConcurrentLinkedQueue     // Catch:{ all -> 0x00a9 }
                r3.<init>()     // Catch:{ all -> 0x00a9 }
                com.facebook.AccessToken$Companion r4 = com.facebook.AccessToken.Companion     // Catch:{ all -> 0x00a9 }
                com.facebook.AccessToken r4 = r4.getCurrentAccessToken()     // Catch:{ all -> 0x00a9 }
                r5 = 0
                r6 = 1
                int r7 = r12.length     // Catch:{ Exception -> 0x0094 }
                int r7 = r7 + -1
                if (r7 < 0) goto L_0x0090
            L_0x003f:
                int r8 = r5 + 1
                boolean r9 = r11.isCancelled()     // Catch:{ Exception -> 0x0094 }
                if (r9 == 0) goto L_0x005c
                java.util.Iterator r12 = r3.iterator()     // Catch:{ Exception -> 0x0094 }
            L_0x004b:
                boolean r0 = r12.hasNext()     // Catch:{ Exception -> 0x0094 }
                if (r0 == 0) goto L_0x005b
                java.lang.Object r0 = r12.next()     // Catch:{ Exception -> 0x0094 }
                com.facebook.GraphRequestAsyncTask r0 = (com.facebook.GraphRequestAsyncTask) r0     // Catch:{ Exception -> 0x0094 }
                r0.cancel(r6)     // Catch:{ Exception -> 0x0094 }
                goto L_0x004b
            L_0x005b:
                return r1
            L_0x005c:
                r9 = r12[r5]     // Catch:{ Exception -> 0x0094 }
                android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch:{ Exception -> 0x0094 }
                com.facebook.internal.Utility r10 = com.facebook.internal.Utility.INSTANCE     // Catch:{ Exception -> 0x0094 }
                boolean r10 = com.facebook.internal.Utility.isWebUri(r9)     // Catch:{ Exception -> 0x0094 }
                if (r10 == 0) goto L_0x0074
                java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0094 }
                r0[r5] = r9     // Catch:{ Exception -> 0x0094 }
                r2.countDown()     // Catch:{ Exception -> 0x0094 }
                goto L_0x008b
            L_0x0074:
                com.facebook.internal.WebDialog$UploadStagingResourcesTask$$ExternalSyntheticLambda0 r10 = new com.facebook.internal.WebDialog$UploadStagingResourcesTask$$ExternalSyntheticLambda0     // Catch:{ Exception -> 0x0094 }
                r10.<init>(r0, r5, r11, r2)     // Catch:{ Exception -> 0x0094 }
                com.facebook.share.internal.ShareInternalUtility r5 = com.facebook.share.internal.ShareInternalUtility.INSTANCE     // Catch:{ Exception -> 0x0094 }
                java.lang.String r5 = "uri"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r5)     // Catch:{ Exception -> 0x0094 }
                com.facebook.GraphRequest r5 = com.facebook.share.internal.ShareInternalUtility.newUploadStagingResourceWithImageRequest((com.facebook.AccessToken) r4, (android.net.Uri) r9, (com.facebook.GraphRequest.Callback) r10)     // Catch:{ Exception -> 0x0094 }
                com.facebook.GraphRequestAsyncTask r5 = r5.executeAsync()     // Catch:{ Exception -> 0x0094 }
                r3.add(r5)     // Catch:{ Exception -> 0x0094 }
            L_0x008b:
                if (r8 <= r7) goto L_0x008e
                goto L_0x0090
            L_0x008e:
                r5 = r8
                goto L_0x003f
            L_0x0090:
                r2.await()     // Catch:{ Exception -> 0x0094 }
                return r0
            L_0x0094:
                java.util.Iterator r12 = r3.iterator()     // Catch:{ all -> 0x00a9 }
            L_0x0098:
                boolean r0 = r12.hasNext()     // Catch:{ all -> 0x00a9 }
                if (r0 == 0) goto L_0x00a8
                java.lang.Object r0 = r12.next()     // Catch:{ all -> 0x00a9 }
                com.facebook.GraphRequestAsyncTask r0 = (com.facebook.GraphRequestAsyncTask) r0     // Catch:{ all -> 0x00a9 }
                r0.cancel(r6)     // Catch:{ all -> 0x00a9 }
                goto L_0x0098
            L_0x00a8:
                return r1
            L_0x00a9:
                r12 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r12, r11)     // Catch:{ all -> 0x00ae }
                return r1
            L_0x00ae:
                r12 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r12, r11)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.WebDialog.UploadStagingResourcesTask.doInBackground(java.lang.Void[]):java.lang.String[]");
        }

        /* access modifiers changed from: private */
        /* renamed from: doInBackground$lambda-0  reason: not valid java name */
        public static final void m351doInBackground$lambda0(String[] strArr, int i, UploadStagingResourcesTask uploadStagingResourcesTask, CountDownLatch countDownLatch, GraphResponse graphResponse) {
            Intrinsics.checkNotNullParameter(strArr, "$results");
            Intrinsics.checkNotNullParameter(uploadStagingResourcesTask, "this$0");
            Intrinsics.checkNotNullParameter(countDownLatch, "$latch");
            Intrinsics.checkNotNullParameter(graphResponse, Response.TYPE);
            try {
                FacebookRequestError error = graphResponse.getError();
                String str = "Error staging photo.";
                if (error != null) {
                    String errorMessage = error.getErrorMessage();
                    if (errorMessage != null) {
                        str = errorMessage;
                    }
                    throw new FacebookGraphResponseException(graphResponse, str);
                }
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject != null) {
                    String optString = jSONObject.optString("uri");
                    if (optString != null) {
                        strArr[i] = optString;
                        countDownLatch.countDown();
                        return;
                    }
                    throw new FacebookException(str);
                }
                throw new FacebookException(str);
            } catch (Exception e) {
                uploadStagingResourcesTask.exceptions[i] = e;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String[] strArr) {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    if (!CrashShieldHandler.isObjectCrashing(this)) {
                        ProgressDialog access$getSpinner$p = this.this$0.spinner;
                        if (access$getSpinner$p != null) {
                            access$getSpinner$p.dismiss();
                        }
                        Exception[] excArr = this.exceptions;
                        int i = 0;
                        int length = excArr.length;
                        while (i < length) {
                            Exception exc = excArr[i];
                            i++;
                            if (exc != null) {
                                this.this$0.sendErrorToListener(exc);
                                return;
                            }
                        }
                        if (strArr == null) {
                            this.this$0.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                            return;
                        }
                        List asList = ArraysKt.asList((T[]) strArr);
                        if (asList.contains((Object) null)) {
                            this.this$0.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                            return;
                        }
                        Utility utility = Utility.INSTANCE;
                        Utility.putJSONValueInBundle(this.parameters, "media", new JSONArray((Collection<?>) asList));
                        Utility utility2 = Utility.INSTANCE;
                        ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
                        String dialogAuthority = ServerProtocol.getDialogAuthority();
                        StringBuilder sb = new StringBuilder();
                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                        this.this$0.url = Utility.buildUri(dialogAuthority, sb.append(FacebookSdk.getGraphApiVersion()).append("/dialog/").append(this.action).toString(), this.parameters).toString();
                        ImageView access$getCrossImageView$p = this.this$0.crossImageView;
                        if (access$getCrossImageView$p != null) {
                            this.this$0.setUpWebView((access$getCrossImageView$p.getDrawable().getIntrinsicWidth() / 2) + 1);
                            return;
                        }
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0007J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0005J6\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\"H\u0007J>\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0012\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\u0014H\u0007J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/facebook/internal/WebDialog$Companion;", "", "()V", "API_EC_DIALOG_CANCEL", "", "BACKGROUND_GRAY", "DEFAULT_THEME", "DISABLE_SSL_CHECK_FOR_TESTING", "", "DISPLAY_TOUCH", "", "LOG_TAG", "MAX_PADDING_SCREEN_HEIGHT", "MAX_PADDING_SCREEN_WIDTH", "MIN_SCALE_FACTOR", "", "NO_PADDING_SCREEN_HEIGHT", "NO_PADDING_SCREEN_WIDTH", "PLATFORM_DIALOG_PATH_REGEX", "initCallback", "Lcom/facebook/internal/WebDialog$InitCallback;", "webDialogTheme", "getWebDialogTheme", "initDefaultTheme", "", "context", "Landroid/content/Context;", "newInstance", "Lcom/facebook/internal/WebDialog;", "action", "parameters", "Landroid/os/Bundle;", "theme", "listener", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", "targetApp", "Lcom/facebook/login/LoginTargetApp;", "setInitCallback", "callback", "setWebDialogTheme", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: WebDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: protected */
        @JvmStatic
        public final void initDefaultTheme(Context context) {
            Bundle bundle;
            if (context != null) {
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo == null) {
                        bundle = null;
                    } else {
                        bundle = applicationInfo.metaData;
                    }
                    if (bundle != null && WebDialog.webDialogTheme == 0) {
                        setWebDialogTheme(applicationInfo.metaData.getInt(FacebookSdk.WEB_DIALOG_THEME));
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
        }

        @JvmStatic
        public final WebDialog newInstance(Context context, String str, Bundle bundle, int i, OnCompleteListener onCompleteListener) {
            Intrinsics.checkNotNullParameter(context, "context");
            WebDialog.initDefaultTheme(context);
            return new WebDialog(context, str, bundle, i, LoginTargetApp.FACEBOOK, onCompleteListener, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final WebDialog newInstance(Context context, String str, Bundle bundle, int i, LoginTargetApp loginTargetApp, OnCompleteListener onCompleteListener) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(loginTargetApp, "targetApp");
            WebDialog.initDefaultTheme(context);
            return new WebDialog(context, str, bundle, i, loginTargetApp, onCompleteListener, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final int getWebDialogTheme() {
            Validate validate = Validate.INSTANCE;
            Validate.sdkInitialized();
            return WebDialog.webDialogTheme;
        }

        @JvmStatic
        public final void setWebDialogTheme(int i) {
            if (i == 0) {
                i = WebDialog.DEFAULT_THEME;
            }
            WebDialog.webDialogTheme = i;
        }

        @JvmStatic
        public final void setInitCallback(InitCallback initCallback) {
            WebDialog.initCallback = initCallback;
        }
    }
}
