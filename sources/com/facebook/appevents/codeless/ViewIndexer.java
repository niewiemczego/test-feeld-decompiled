package com.facebook.appevents.codeless;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u0006\u0010\u0015\u001a\u00020\u000eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/appevents/codeless/ViewIndexer;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activityReference", "Ljava/lang/ref/WeakReference;", "indexingTimer", "Ljava/util/Timer;", "previousDigest", "", "uiThreadHandler", "Landroid/os/Handler;", "processRequest", "", "request", "Lcom/facebook/GraphRequest;", "currentDigest", "schedule", "sendToServer", "tree", "unschedule", "Companion", "ScreenshotTaker", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ViewIndexer.kt */
public final class ViewIndexer {
    private static final String APP_VERSION_PARAM = "app_version";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PLATFORM_PARAM = "platform";
    private static final String REQUEST_TYPE = "request_type";
    private static final String SUCCESS = "success";
    private static final String TAG;
    private static final String TREE_PARAM = "tree";
    private static ViewIndexer instance;
    private final WeakReference<Activity> activityReference;
    private Timer indexingTimer;
    private String previousDigest = null;
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());

    @JvmStatic
    public static final GraphRequest buildAppIndexingRequest(String str, AccessToken accessToken, String str2, String str3) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return Companion.buildAppIndexingRequest(str, accessToken, str2, str3);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final void sendToServerUnityInstance(String str) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Companion.sendToServerUnityInstance(str);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public ViewIndexer(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityReference = new WeakReference<>(activity);
        instance = this;
    }

    public static final /* synthetic */ WeakReference access$getActivityReference$p(ViewIndexer viewIndexer) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return viewIndexer.activityReference;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ ViewIndexer access$getInstance$cp() {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return instance;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Handler access$getUiThreadHandler$p(ViewIndexer viewIndexer) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return viewIndexer.uiThreadHandler;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void access$sendToServer(ViewIndexer viewIndexer, String str) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                viewIndexer.sendToServer(str);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final void schedule() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                TimerTask viewIndexer$schedule$indexingTask$1 = new ViewIndexer$schedule$indexingTask$1(this);
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk.getExecutor().execute(new ViewIndexer$$ExternalSyntheticLambda0(this, viewIndexer$schedule$indexingTask$1));
            } catch (RejectedExecutionException e) {
                Log.e(TAG, "Error scheduling indexing job", e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: schedule$lambda-0  reason: not valid java name */
    public static final void m259schedule$lambda0(ViewIndexer viewIndexer, TimerTask timerTask) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(viewIndexer, "this$0");
                Intrinsics.checkNotNullParameter(timerTask, "$indexingTask");
                Timer timer = viewIndexer.indexingTimer;
                if (timer != null) {
                    timer.cancel();
                }
                viewIndexer.previousDigest = null;
                Timer timer2 = new Timer();
                timer2.scheduleAtFixedRate(timerTask, 0, 1000);
                viewIndexer.indexingTimer = timer2;
            } catch (Exception e) {
                Log.e(TAG, "Error scheduling indexing job", e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final void unschedule() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (((Activity) this.activityReference.get()) != null) {
                    Timer timer = this.indexingTimer;
                    if (timer != null) {
                        timer.cancel();
                    }
                    this.indexingTimer = null;
                }
            } catch (Exception e) {
                Log.e(TAG, "Error unscheduling indexing job", e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void sendToServer(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk.getExecutor().execute(new ViewIndexer$$ExternalSyntheticLambda1(str, this));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sendToServer$lambda-1  reason: not valid java name */
    public static final void m260sendToServer$lambda1(String str, ViewIndexer viewIndexer) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(str, "$tree");
                Intrinsics.checkNotNullParameter(viewIndexer, "this$0");
                Utility utility = Utility.INSTANCE;
                String md5hash = Utility.md5hash(str);
                AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
                if (md5hash == null || !Intrinsics.areEqual((Object) md5hash, (Object) viewIndexer.previousDigest)) {
                    Companion companion = Companion;
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    viewIndexer.processRequest(companion.buildAppIndexingRequest(str, currentAccessToken, FacebookSdk.getApplicationId(), Constants.APP_INDEXING), md5hash);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final void processRequest(GraphRequest graphRequest, String str) {
        if (!CrashShieldHandler.isObjectCrashing(this) && graphRequest != null) {
            try {
                GraphResponse executeAndWait = graphRequest.executeAndWait();
                JSONObject jSONObject = executeAndWait.getJSONObject();
                if (jSONObject != null) {
                    if (Intrinsics.areEqual((Object) ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, (Object) jSONObject.optString("success"))) {
                        Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "Successfully send UI component tree to server");
                        this.previousDigest = str;
                    }
                    if (jSONObject.has(Constants.APP_INDEXING_ENABLED)) {
                        boolean z = jSONObject.getBoolean(Constants.APP_INDEXING_ENABLED);
                        CodelessManager codelessManager = CodelessManager.INSTANCE;
                        CodelessManager.updateAppIndexing$facebook_core_release(z);
                        return;
                    }
                    return;
                }
                Log.e(TAG, Intrinsics.stringPlus("Error sending UI component tree to Facebook: ", executeAndWait.getError()));
            } catch (JSONException e) {
                Log.e(TAG, "Error decoding server response.", e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0007\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/codeless/ViewIndexer$ScreenshotTaker;", "Ljava/util/concurrent/Callable;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "Ljava/lang/ref/WeakReference;", "call", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ViewIndexer.kt */
    private static final class ScreenshotTaker implements Callable<String> {
        private final WeakReference<View> rootView;

        public ScreenshotTaker(View view) {
            Intrinsics.checkNotNullParameter(view, "rootView");
            this.rootView = new WeakReference<>(view);
        }

        public String call() {
            View view = (View) this.rootView.get();
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                return "";
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
            String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(outputStream.toByteArray(), Base64.NO_WRAP)");
            return encodeToString;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/appevents/codeless/ViewIndexer$Companion;", "", "()V", "APP_VERSION_PARAM", "", "PLATFORM_PARAM", "REQUEST_TYPE", "SUCCESS", "TAG", "TREE_PARAM", "instance", "Lcom/facebook/appevents/codeless/ViewIndexer;", "buildAppIndexingRequest", "Lcom/facebook/GraphRequest;", "appIndex", "accessToken", "Lcom/facebook/AccessToken;", "appId", "requestType", "sendToServerUnityInstance", "", "tree", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ViewIndexer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void sendToServerUnityInstance(String str) {
            Intrinsics.checkNotNullParameter(str, ViewIndexer.TREE_PARAM);
            ViewIndexer access$getInstance$cp = ViewIndexer.access$getInstance$cp();
            if (access$getInstance$cp != null) {
                ViewIndexer.access$sendToServer(access$getInstance$cp, str);
            }
        }

        @JvmStatic
        public final GraphRequest buildAppIndexingRequest(String str, AccessToken accessToken, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str3, "requestType");
            if (str == null) {
                return null;
            }
            GraphRequest.Companion companion = GraphRequest.Companion;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, "%s/app_indexing", Arrays.copyOf(new Object[]{str2}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            GraphRequest newPostRequest = companion.newPostRequest(accessToken, format, (JSONObject) null, (GraphRequest.Callback) null);
            Bundle parameters = newPostRequest.getParameters();
            if (parameters == null) {
                parameters = new Bundle();
            }
            parameters.putString(ViewIndexer.TREE_PARAM, str);
            AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
            parameters.putString("app_version", AppEventUtility.getAppVersion());
            parameters.putString("platform", "android");
            parameters.putString(ViewIndexer.REQUEST_TYPE, str3);
            if (Intrinsics.areEqual((Object) str3, (Object) Constants.APP_INDEXING)) {
                CodelessManager codelessManager = CodelessManager.INSTANCE;
                parameters.putString(Constants.DEVICE_SESSION_ID, CodelessManager.getCurrentDeviceSessionID$facebook_core_release());
            }
            newPostRequest.setParameters(parameters);
            newPostRequest.setCallback(new ViewIndexer$Companion$$ExternalSyntheticLambda0());
            return newPostRequest;
        }

        /* access modifiers changed from: private */
        /* renamed from: buildAppIndexingRequest$lambda-0  reason: not valid java name */
        public static final void m262buildAppIndexingRequest$lambda0(GraphResponse graphResponse) {
            Intrinsics.checkNotNullParameter(graphResponse, "it");
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, ViewIndexer.access$getTAG$cp(), "App index sent to FB!");
        }
    }

    static {
        String canonicalName = ViewIndexer.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "";
        }
        TAG = canonicalName;
    }
}
