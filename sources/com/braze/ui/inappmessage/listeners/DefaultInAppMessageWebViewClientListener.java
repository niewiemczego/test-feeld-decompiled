package com.braze.ui.inappmessage.listeners;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.braze.Braze;
import com.braze.enums.Channel;
import com.braze.enums.inappmessage.MessageType;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageHtml;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.BundleUtils;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.actions.NewsfeedAction;
import com.braze.ui.actions.UriAction;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.utils.InAppMessageWebViewClient;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/braze/ui/inappmessage/listeners/DefaultInAppMessageWebViewClientListener;", "Lcom/braze/ui/inappmessage/listeners/IInAppMessageWebViewClientListener;", "()V", "inAppMessageManager", "Lcom/braze/ui/inappmessage/BrazeInAppMessageManager;", "getInAppMessageManager", "()Lcom/braze/ui/inappmessage/BrazeInAppMessageManager;", "onCloseAction", "", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "url", "", "queryBundle", "Landroid/os/Bundle;", "onCustomEventAction", "onNewsfeedAction", "onOtherUrlAction", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultInAppMessageWebViewClientListener.kt */
public class DefaultInAppMessageWebViewClientListener implements IInAppMessageWebViewClientListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String HTML_IN_APP_MESSAGE_CUSTOM_EVENT_NAME_KEY = "name";

    @JvmStatic
    public static final void logHtmlInAppMessageClick(IInAppMessage iInAppMessage, Bundle bundle) {
        Companion.logHtmlInAppMessageClick(iInAppMessage, bundle);
    }

    @JvmStatic
    public static final String parseCustomEventNameFromQueryBundle(Bundle bundle) {
        return Companion.parseCustomEventNameFromQueryBundle(bundle);
    }

    @JvmStatic
    public static final BrazeProperties parsePropertiesFromQueryBundle(Bundle bundle) {
        return Companion.parsePropertiesFromQueryBundle(bundle);
    }

    @JvmStatic
    public static final boolean parseUseWebViewFromQueryBundle(IInAppMessage iInAppMessage, Bundle bundle) {
        return Companion.parseUseWebViewFromQueryBundle(iInAppMessage, bundle);
    }

    private final BrazeInAppMessageManager getInAppMessageManager() {
        return BrazeInAppMessageManager.Companion.getInstance();
    }

    public void onCloseAction(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(bundle, "queryBundle");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageWebViewClientListener$onCloseAction$1.INSTANCE, 3, (Object) null);
        Companion.logHtmlInAppMessageClick(iInAppMessage, bundle);
        getInAppMessageManager().hideCurrentlyDisplayingInAppMessage(true);
        getInAppMessageManager().getHtmlInAppMessageActionListener().onCloseClicked(iInAppMessage, str, bundle);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageWebViewClientListener$onCloseAction$2.INSTANCE, 3, (Object) null);
    }

    public void onNewsfeedAction(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(bundle, "queryBundle");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageWebViewClientListener$onNewsfeedAction$1.INSTANCE, 3, (Object) null);
        if (getInAppMessageManager().getActivity() == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) DefaultInAppMessageWebViewClientListener$onNewsfeedAction$2.INSTANCE, 2, (Object) null);
            return;
        }
        Companion.logHtmlInAppMessageClick(iInAppMessage, bundle);
        if (!getInAppMessageManager().getHtmlInAppMessageActionListener().onNewsfeedClicked(iInAppMessage, str, bundle)) {
            iInAppMessage.setAnimateOut(false);
            getInAppMessageManager().hideCurrentlyDisplayingInAppMessage(false);
            NewsfeedAction newsfeedAction = new NewsfeedAction(BundleUtils.toBundle(iInAppMessage.getExtras()), Channel.INAPP_MESSAGE);
            Activity activity = getInAppMessageManager().getActivity();
            if (activity != null) {
                BrazeDeeplinkHandler.Companion.getInstance().gotoNewsFeed(activity, newsfeedAction);
            }
        }
    }

    public void onCustomEventAction(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(bundle, "queryBundle");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageWebViewClientListener$onCustomEventAction$1.INSTANCE, 3, (Object) null);
        if (getInAppMessageManager().getActivity() == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) DefaultInAppMessageWebViewClientListener$onCustomEventAction$2.INSTANCE, 2, (Object) null);
        } else if (!getInAppMessageManager().getHtmlInAppMessageActionListener().onCustomEventFired(iInAppMessage, str, bundle)) {
            Companion companion = Companion;
            String parseCustomEventNameFromQueryBundle = companion.parseCustomEventNameFromQueryBundle(bundle);
            CharSequence charSequence = parseCustomEventNameFromQueryBundle;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                BrazeProperties parsePropertiesFromQueryBundle = companion.parsePropertiesFromQueryBundle(bundle);
                Activity activity = getInAppMessageManager().getActivity();
                if (activity != null) {
                    Braze.Companion.getInstance(activity).logCustomEvent(parseCustomEventNameFromQueryBundle, parsePropertiesFromQueryBundle);
                }
            }
        }
    }

    public void onOtherUrlAction(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(bundle, "queryBundle");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageWebViewClientListener$onOtherUrlAction$1.INSTANCE, 3, (Object) null);
        if (getInAppMessageManager().getActivity() == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new DefaultInAppMessageWebViewClientListener$onOtherUrlAction$2(str), 2, (Object) null);
            return;
        }
        Companion companion = Companion;
        companion.logHtmlInAppMessageClick(iInAppMessage, bundle);
        if (getInAppMessageManager().getHtmlInAppMessageActionListener().onOtherUrlAction(iInAppMessage, str, bundle)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new DefaultInAppMessageWebViewClientListener$onOtherUrlAction$3(str), 2, (Object) null);
            return;
        }
        boolean parseUseWebViewFromQueryBundle = companion.parseUseWebViewFromQueryBundle(iInAppMessage, bundle);
        Bundle bundle2 = BundleUtils.toBundle(iInAppMessage.getExtras());
        bundle2.putAll(bundle);
        UriAction createUriActionFromUrlString = BrazeDeeplinkHandler.Companion.getInstance().createUriActionFromUrlString(str, bundle2, parseUseWebViewFromQueryBundle, Channel.INAPP_MESSAGE);
        if (createUriActionFromUrlString == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new DefaultInAppMessageWebViewClientListener$onOtherUrlAction$4(str), 2, (Object) null);
            return;
        }
        Uri uri = createUriActionFromUrlString.getUri();
        if (BrazeFileUtils.isLocalUri(uri)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new DefaultInAppMessageWebViewClientListener$onOtherUrlAction$5(uri, str), 2, (Object) null);
            return;
        }
        iInAppMessage.setAnimateOut(false);
        getInAppMessageManager().hideCurrentlyDisplayingInAppMessage(false);
        Activity activity = getInAppMessageManager().getActivity();
        if (activity != null) {
            BrazeDeeplinkHandler.Companion.getInstance().gotoUri(activity, createUriActionFromUrlString);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/braze/ui/inappmessage/listeners/DefaultInAppMessageWebViewClientListener$Companion;", "", "()V", "HTML_IN_APP_MESSAGE_CUSTOM_EVENT_NAME_KEY", "", "logHtmlInAppMessageClick", "", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "queryBundle", "Landroid/os/Bundle;", "parseCustomEventNameFromQueryBundle", "parsePropertiesFromQueryBundle", "Lcom/braze/models/outgoing/BrazeProperties;", "parseUseWebViewFromQueryBundle", "", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultInAppMessageWebViewClientListener.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean parseUseWebViewFromQueryBundle(IInAppMessage iInAppMessage, Bundle bundle) {
            boolean z;
            boolean z2;
            boolean z3;
            Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
            Intrinsics.checkNotNullParameter(bundle, "queryBundle");
            boolean z4 = true;
            if (bundle.containsKey(InAppMessageWebViewClient.QUERY_NAME_DEEPLINK)) {
                z2 = Boolean.parseBoolean(bundle.getString(InAppMessageWebViewClient.QUERY_NAME_DEEPLINK));
                z = true;
            } else {
                z2 = false;
                z = false;
            }
            if (bundle.containsKey(InAppMessageWebViewClient.QUERY_NAME_EXTERNAL_OPEN)) {
                z3 = Boolean.parseBoolean(bundle.getString(InAppMessageWebViewClient.QUERY_NAME_EXTERNAL_OPEN));
                z = true;
            } else {
                z3 = false;
            }
            boolean openUriInWebView = iInAppMessage.getOpenUriInWebView();
            if (!z) {
                return openUriInWebView;
            }
            if (z2 || z3) {
                z4 = false;
            }
            return z4;
        }

        @JvmStatic
        public final void logHtmlInAppMessageClick(IInAppMessage iInAppMessage, Bundle bundle) {
            Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
            Intrinsics.checkNotNullParameter(bundle, "queryBundle");
            if (bundle.containsKey(InAppMessageWebViewClient.QUERY_NAME_BUTTON_ID)) {
                IInAppMessageHtml iInAppMessageHtml = (IInAppMessageHtml) iInAppMessage;
                String string = bundle.getString(InAppMessageWebViewClient.QUERY_NAME_BUTTON_ID);
                if (string != null) {
                    iInAppMessageHtml.logButtonClick(string);
                }
            } else if (iInAppMessage.getMessageType() == MessageType.HTML_FULL) {
                iInAppMessage.logClick();
            }
        }

        @JvmStatic
        public final String parseCustomEventNameFromQueryBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "queryBundle");
            return bundle.getString("name");
        }

        @JvmStatic
        public final BrazeProperties parsePropertiesFromQueryBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "queryBundle");
            BrazeProperties brazeProperties = new BrazeProperties();
            for (String str : bundle.keySet()) {
                if (!Intrinsics.areEqual((Object) str, (Object) "name")) {
                    String string = bundle.getString(str, (String) null);
                    CharSequence charSequence = string;
                    if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                        Intrinsics.checkNotNullExpressionValue(str, "key");
                        brazeProperties.addProperty(str, string);
                    }
                }
            }
            return brazeProperties;
        }
    }
}
