package com.braze.ui.inappmessage.views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zendesk.messaging.android.internal.KnownUriSchemes;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J,\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/braze/ui/inappmessage/views/InAppMessageHtmlBaseView$messageWebView$7", "Landroid/webkit/WebChromeClient;", "getDefaultVideoPoster", "Landroid/graphics/Bitmap;", "onConsoleMessage", "", "cm", "Landroid/webkit/ConsoleMessage;", "onCreateWindow", "view", "Landroid/webkit/WebView;", "isDialog", "isUserGesture", "resultMsg", "Landroid/os/Message;", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InAppMessageHtmlBaseView.kt */
public final class InAppMessageHtmlBaseView$messageWebView$7 extends WebChromeClient {
    final /* synthetic */ boolean $isLinkTargetSupported;
    final /* synthetic */ InAppMessageHtmlBaseView this$0;

    InAppMessageHtmlBaseView$messageWebView$7(InAppMessageHtmlBaseView inAppMessageHtmlBaseView, boolean z) {
        this.this$0 = inAppMessageHtmlBaseView;
        this.$isLinkTargetSupported = z;
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Intrinsics.checkNotNullParameter(consoleMessage, "cm");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.this$0, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new InAppMessageHtmlBaseView$messageWebView$7$onConsoleMessage$1(consoleMessage), 3, (Object) null);
        return true;
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        if (!this.$isLinkTargetSupported) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) InAppMessageHtmlBaseView$messageWebView$7$onCreateWindow$1.INSTANCE, 2, (Object) null);
            return super.onCreateWindow(webView, z, z2, message);
        } else if (webView == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) InAppMessageHtmlBaseView$messageWebView$7$onCreateWindow$2.INSTANCE, 2, (Object) null);
            return false;
        } else {
            WebView.HitTestResult hitTestResult = webView.getHitTestResult();
            Intrinsics.checkNotNullExpressionValue(hitTestResult, "view.hitTestResult");
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new InAppMessageHtmlBaseView$messageWebView$7$onCreateWindow$3(hitTestResult), 2, (Object) null);
            int type = hitTestResult.getType();
            if (type == 2) {
                this.this$0.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(KnownUriSchemes.PHONE_NUMBER + hitTestResult.getExtra())));
                return false;
            } else if (type == 4) {
                this.this$0.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("mailto:" + hitTestResult.getExtra())));
                return false;
            } else if (type != 7) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new InAppMessageHtmlBaseView$messageWebView$7$onCreateWindow$4(hitTestResult), 2, (Object) null);
                return false;
            } else {
                this.this$0.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(hitTestResult.getExtra())));
                return false;
            }
        }
    }

    public Bitmap getDefaultVideoPoster() {
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        return createBitmap;
    }
}
