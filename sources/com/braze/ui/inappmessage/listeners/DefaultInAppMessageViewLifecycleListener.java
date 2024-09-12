package com.braze.ui.inappmessage.listeners;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.enums.Channel;
import com.braze.enums.inappmessage.ClickAction;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageHtml;
import com.braze.models.inappmessage.IInAppMessageImmersive;
import com.braze.models.inappmessage.MessageButton;
import com.braze.support.BrazeFunctionNotImplemented;
import com.braze.support.BrazeLogger;
import com.braze.support.BundleUtils;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.actions.NewsfeedAction;
import com.braze.ui.actions.UriAction;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.InAppMessageCloser;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016J2\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J \u0010 \u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\"\u001a\u00020\bH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006#"}, d2 = {"Lcom/braze/ui/inappmessage/listeners/DefaultInAppMessageViewLifecycleListener;", "Lcom/braze/ui/inappmessage/listeners/IInAppMessageViewLifecycleListener;", "()V", "inAppMessageManager", "Lcom/braze/ui/inappmessage/BrazeInAppMessageManager;", "getInAppMessageManager", "()Lcom/braze/ui/inappmessage/BrazeInAppMessageManager;", "afterClosed", "", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "afterOpened", "inAppMessageView", "Landroid/view/View;", "beforeClosed", "beforeOpened", "onButtonClicked", "inAppMessageCloser", "Lcom/braze/ui/inappmessage/InAppMessageCloser;", "messageButton", "Lcom/braze/models/inappmessage/MessageButton;", "inAppMessageImmersive", "Lcom/braze/models/inappmessage/IInAppMessageImmersive;", "onClicked", "onDismissed", "performClickAction", "clickAction", "Lcom/braze/enums/inappmessage/ClickAction;", "clickUri", "Landroid/net/Uri;", "openUriInWebview", "", "performInAppMessageButtonClicked", "performInAppMessageClicked", "startClearHtmlInAppMessageAssetsThread", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultInAppMessageViewLifecycleListener.kt */
public class DefaultInAppMessageViewLifecycleListener implements IInAppMessageViewLifecycleListener {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultInAppMessageViewLifecycleListener.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.braze.enums.inappmessage.ClickAction[] r0 = com.braze.enums.inappmessage.ClickAction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.braze.enums.inappmessage.ClickAction r1 = com.braze.enums.inappmessage.ClickAction.NEWS_FEED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.braze.enums.inappmessage.ClickAction r1 = com.braze.enums.inappmessage.ClickAction.URI     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.braze.enums.inappmessage.ClickAction r1 = com.braze.enums.inappmessage.ClickAction.NONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.ui.inappmessage.listeners.DefaultInAppMessageViewLifecycleListener.WhenMappings.<clinit>():void");
        }
    }

    private final BrazeInAppMessageManager getInAppMessageManager() {
        return BrazeInAppMessageManager.Companion.getInstance();
    }

    public void beforeOpened(View view, IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        getInAppMessageManager().getInAppMessageManagerListener().beforeInAppMessageViewOpened(view, iInAppMessage);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageViewLifecycleListener$beforeOpened$1.INSTANCE, 3, (Object) null);
        iInAppMessage.logImpression();
    }

    public void afterOpened(View view, IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageViewLifecycleListener$afterOpened$1.INSTANCE, 3, (Object) null);
        getInAppMessageManager().getInAppMessageManagerListener().afterInAppMessageViewOpened(view, iInAppMessage);
    }

    public void beforeClosed(View view, IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        getInAppMessageManager().getInAppMessageManagerListener().beforeInAppMessageViewClosed(view, iInAppMessage);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageViewLifecycleListener$beforeClosed$1.INSTANCE, 3, (Object) null);
    }

    public void afterClosed(IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageViewLifecycleListener$afterClosed$1.INSTANCE, 3, (Object) null);
        getInAppMessageManager().resetAfterInAppMessageClose();
        if (iInAppMessage instanceof IInAppMessageHtml) {
            startClearHtmlInAppMessageAssetsThread();
        }
        iInAppMessage.onAfterClosed();
        getInAppMessageManager().getInAppMessageManagerListener().afterInAppMessageViewClosed(iInAppMessage);
    }

    public void onClicked(InAppMessageCloser inAppMessageCloser, View view, IInAppMessage iInAppMessage) {
        boolean z;
        InAppMessageCloser inAppMessageCloser2 = inAppMessageCloser;
        IInAppMessage iInAppMessage2 = iInAppMessage;
        Intrinsics.checkNotNullParameter(inAppMessageCloser2, "inAppMessageCloser");
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessage2, "inAppMessage");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageViewLifecycleListener$onClicked$1.INSTANCE, 3, (Object) null);
        iInAppMessage.logClick();
        try {
            z = getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageClicked(iInAppMessage2, inAppMessageCloser2);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageViewLifecycleListener$onClicked$wasHandled$1.INSTANCE, 3, (Object) null);
        } catch (BrazeFunctionNotImplemented unused) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageViewLifecycleListener$onClicked$wasHandled$2.INSTANCE, 3, (Object) null);
            z = getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageClicked(iInAppMessage2);
        }
        if (!z) {
            performInAppMessageClicked(iInAppMessage2, inAppMessageCloser2);
        }
    }

    public void onButtonClicked(InAppMessageCloser inAppMessageCloser, MessageButton messageButton, IInAppMessageImmersive iInAppMessageImmersive) {
        boolean z;
        Intrinsics.checkNotNullParameter(inAppMessageCloser, "inAppMessageCloser");
        Intrinsics.checkNotNullParameter(messageButton, "messageButton");
        Intrinsics.checkNotNullParameter(iInAppMessageImmersive, "inAppMessageImmersive");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageViewLifecycleListener$onButtonClicked$1.INSTANCE, 3, (Object) null);
        iInAppMessageImmersive.logButtonClick(messageButton);
        try {
            z = getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageButtonClicked(iInAppMessageImmersive, messageButton, inAppMessageCloser);
        } catch (BrazeFunctionNotImplemented unused) {
            z = getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageButtonClicked(iInAppMessageImmersive, messageButton);
        }
        if (!z) {
            performInAppMessageButtonClicked(messageButton, iInAppMessageImmersive, inAppMessageCloser);
        }
    }

    public void onDismissed(View view, IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageViewLifecycleListener$onDismissed$1.INSTANCE, 3, (Object) null);
        getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageDismissed(iInAppMessage);
    }

    private final void performInAppMessageButtonClicked(MessageButton messageButton, IInAppMessage iInAppMessage, InAppMessageCloser inAppMessageCloser) {
        performClickAction(messageButton.getClickAction(), iInAppMessage, inAppMessageCloser, messageButton.getUri(), messageButton.getOpenUriInWebview());
    }

    private final void performInAppMessageClicked(IInAppMessage iInAppMessage, InAppMessageCloser inAppMessageCloser) {
        performClickAction(iInAppMessage.getClickAction(), iInAppMessage, inAppMessageCloser, iInAppMessage.getUri(), iInAppMessage.getOpenUriInWebView());
    }

    private final void performClickAction(ClickAction clickAction, IInAppMessage iInAppMessage, InAppMessageCloser inAppMessageCloser, Uri uri, boolean z) {
        Activity activity = getInAppMessageManager().getActivity();
        if (activity == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) DefaultInAppMessageViewLifecycleListener$performClickAction$1.INSTANCE, 2, (Object) null);
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[clickAction.ordinal()];
        if (i == 1) {
            inAppMessageCloser.close(false);
            BrazeDeeplinkHandler.Companion.getInstance().gotoNewsFeed(activity, new NewsfeedAction(BundleUtils.toBundle(iInAppMessage.getExtras()), Channel.INAPP_MESSAGE));
        } else if (i == 2) {
            inAppMessageCloser.close(false);
            if (uri == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageViewLifecycleListener$performClickAction$2.INSTANCE, 3, (Object) null);
                return;
            }
            UriAction createUriActionFromUri = BrazeDeeplinkHandler.Companion.getInstance().createUriActionFromUri(uri, BundleUtils.toBundle(iInAppMessage.getExtras()), z, Channel.INAPP_MESSAGE);
            Context applicationContext = getInAppMessageManager().getApplicationContext();
            if (applicationContext == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageViewLifecycleListener$performClickAction$3.INSTANCE, 3, (Object) null);
                return;
            }
            BrazeDeeplinkHandler.Companion.getInstance().gotoUri(applicationContext, createUriActionFromUri);
        } else if (i != 3) {
            inAppMessageCloser.close(false);
        } else {
            inAppMessageCloser.close(iInAppMessage.getAnimateOut());
        }
    }

    private final void startClearHtmlInAppMessageAssetsThread() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new DefaultInAppMessageViewLifecycleListener$startClearHtmlInAppMessageAssetsThread$1((Continuation<? super DefaultInAppMessageViewLifecycleListener$startClearHtmlInAppMessageAssetsThread$1>) null), 3, (Object) null);
    }
}
