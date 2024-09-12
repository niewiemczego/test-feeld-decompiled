package com.braze.ui;

import android.content.Context;
import android.net.Uri;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.braze.enums.Channel;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeLogger;
import com.braze.ui.actions.IAction;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0017¨\u0006\u0011"}, d2 = {"com/braze/ui/BrazeWebViewActivity$createWebViewClient$1", "Landroid/webkit/WebViewClient;", "handleUrlOverride", "", "context", "Landroid/content/Context;", "url", "", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Boolean;", "onRenderProcessGone", "view", "Landroid/webkit/WebView;", "detail", "Landroid/webkit/RenderProcessGoneDetail;", "shouldOverrideUrlLoading", "request", "Landroid/webkit/WebResourceRequest;", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeWebViewActivity.kt */
public final class BrazeWebViewActivity$createWebViewClient$1 extends WebViewClient {
    final /* synthetic */ BrazeWebViewActivity this$0;

    BrazeWebViewActivity$createWebViewClient$1(BrazeWebViewActivity brazeWebViewActivity) {
        this.this$0 = brazeWebViewActivity;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Intrinsics.checkNotNullParameter(webView, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(webResourceRequest, "request");
        Context context = webView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        String uri = webResourceRequest.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "request.url.toString()");
        Boolean handleUrlOverride = handleUrlOverride(context, uri);
        return handleUrlOverride != null ? handleUrlOverride.booleanValue() : super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @Deprecated(message = "Deprecated in Java")
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(str, "url");
        Context context = webView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Boolean handleUrlOverride = handleUrlOverride(context, str);
        return handleUrlOverride != null ? handleUrlOverride.booleanValue() : super.shouldOverrideUrlLoading(webView, str);
    }

    private final Boolean handleUrlOverride(Context context, String str) {
        try {
            if (CollectionsKt.contains(BrazeFileUtils.REMOTE_SCHEMES, Uri.parse(str).getScheme())) {
                return null;
            }
            IAction createUriActionFromUrlString = BrazeDeeplinkHandler.Companion.getInstance().createUriActionFromUrlString(str, this.this$0.getIntent().getExtras(), false, Channel.UNKNOWN);
            if (createUriActionFromUrlString == null) {
                return false;
            }
            createUriActionFromUrlString.execute(context);
            this.this$0.finish();
            return true;
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) new BrazeWebViewActivity$createWebViewClient$1$handleUrlOverride$1(str));
            return null;
        }
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        Intrinsics.checkNotNullParameter(webView, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(renderProcessGoneDetail, "detail");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) BrazeWebViewActivity$createWebViewClient$1$onRenderProcessGone$1.INSTANCE, 2, (Object) null);
        return true;
    }
}
