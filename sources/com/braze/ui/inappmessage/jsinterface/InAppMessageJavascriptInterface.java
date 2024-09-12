package com.braze.ui.inappmessage.jsinterface;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.braze.Braze;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.models.inappmessage.IInAppMessageHtml;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 (2\u00020\u0001:\u0001(B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0007J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0007J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0007J\b\u0010\u0019\u001a\u00020\u0012H\u0007J\u001c\u0010\u001a\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015H\u0007J6\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u00152\u0006\u0010\"\u001a\u00020#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015H\u0007J\u0014\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015H\u0007J\b\u0010&\u001a\u00020\u0012H\u0007J\b\u0010'\u001a\u00020\u0012H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u00020\b8G¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006)"}, d2 = {"Lcom/braze/ui/inappmessage/jsinterface/InAppMessageJavascriptInterface;", "", "context", "Landroid/content/Context;", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessageHtml;", "(Landroid/content/Context;Lcom/braze/models/inappmessage/IInAppMessageHtml;)V", "user", "Lcom/braze/ui/inappmessage/jsinterface/InAppMessageUserJavascriptInterface;", "getUser", "()Lcom/braze/ui/inappmessage/jsinterface/InAppMessageUserJavascriptInterface;", "wasCloseMessageCalled", "", "getWasCloseMessageCalled", "()Z", "setWasCloseMessageCalled", "(Z)V", "beforeMessageClosed", "", "changeUser", "userId", "", "sdkAuthSignature", "logButtonClick", "buttonId", "logClick", "logCustomEventWithJSON", "eventName", "propertiesJSON", "logPurchaseWithJSON", "productId", "price", "", "currencyCode", "quantity", "", "parseProperties", "Lcom/braze/models/outgoing/BrazeProperties;", "requestImmediateDataFlush", "requestPushPermission", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InAppMessageJavascriptInterface.kt */
public final class InAppMessageJavascriptInterface {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long PUSH_PROMPT_INITIAL_DELAY_MS = 75;
    private static final long PUSH_PROMPT_WAIT_DELAY_TIMEOUT_MS = 25;
    private static final long PUSH_PROMPT_WAIT_FOR_DISPLAY_TIMEOUT_MS = 2500;
    private final Context context;
    private final IInAppMessageHtml inAppMessage;
    private final InAppMessageUserJavascriptInterface user;
    private boolean wasCloseMessageCalled;

    public InAppMessageJavascriptInterface(Context context2, IInAppMessageHtml iInAppMessageHtml) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(iInAppMessageHtml, "inAppMessage");
        this.context = context2;
        this.inAppMessage = iInAppMessageHtml;
        this.user = new InAppMessageUserJavascriptInterface(context2);
    }

    @JavascriptInterface
    public final InAppMessageUserJavascriptInterface getUser() {
        return this.user;
    }

    public final boolean getWasCloseMessageCalled() {
        return this.wasCloseMessageCalled;
    }

    public final void setWasCloseMessageCalled(boolean z) {
        this.wasCloseMessageCalled = z;
    }

    @JavascriptInterface
    public final void changeUser(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Braze.Companion.getInstance(this.context).changeUser(str, str2);
    }

    @JavascriptInterface
    public final void requestImmediateDataFlush() {
        Braze.Companion.getInstance(this.context).requestImmediateDataFlush();
    }

    @JavascriptInterface
    public final void logCustomEventWithJSON(String str, String str2) {
        Braze.Companion.getInstance(this.context).logCustomEvent(str, parseProperties(str2));
    }

    @JavascriptInterface
    public final void logPurchaseWithJSON(String str, double d, String str2, int i, String str3) {
        String str4 = str;
        String str5 = str2;
        Braze.Companion.getInstance(this.context).logPurchase(str4, str5, new BigDecimal(String.valueOf(d)), i, parseProperties(str3));
    }

    @JavascriptInterface
    public final void logButtonClick(String str) {
        if (str != null) {
            this.inAppMessage.logButtonClick(str);
        }
    }

    @JavascriptInterface
    public final void logClick() {
        this.inAppMessage.logClick();
    }

    @JavascriptInterface
    public final void beforeMessageClosed() {
        this.wasCloseMessageCalled = true;
    }

    @JavascriptInterface
    public final void requestPushPermission() {
        BrazeInAppMessageManager.Companion.getInstance().setShouldNextUnregisterBeSkipped(true);
        BrazeCoroutineScope.launchDelayed$default(BrazeCoroutineScope.INSTANCE, (Number) 75, (CoroutineContext) null, new InAppMessageJavascriptInterface$requestPushPermission$1(this, (Continuation<? super InAppMessageJavascriptInterface$requestPushPermission$1>) null), 2, (Object) null);
    }

    public final BrazeProperties parseProperties(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (Intrinsics.areEqual((Object) str, (Object) "undefined") || Intrinsics.areEqual((Object) str, (Object) "null")) {
                return null;
            }
            return new BrazeProperties(new JSONObject(str));
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) new InAppMessageJavascriptInterface$parseProperties$1(str));
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/braze/ui/inappmessage/jsinterface/InAppMessageJavascriptInterface$Companion;", "", "()V", "PUSH_PROMPT_INITIAL_DELAY_MS", "", "PUSH_PROMPT_WAIT_DELAY_TIMEOUT_MS", "PUSH_PROMPT_WAIT_FOR_DISPLAY_TIMEOUT_MS", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: InAppMessageJavascriptInterface.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
