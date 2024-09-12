package com.braze.ui.inappmessage;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.braze.Braze;
import com.braze.BrazeInternal;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.inappmessage.Orientation;
import com.braze.events.IEventSubscriber;
import com.braze.events.InAppMessageEvent;
import com.braze.events.SdkDataWipeEvent;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageHtml;
import com.braze.support.BrazeLogger;
import com.braze.ui.actions.brazeactions.BrazeActionUtils;
import com.braze.ui.inappmessage.listeners.DefaultInAppMessageViewLifecycleListener;
import com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener;
import com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import com.braze.ui.inappmessage.listeners.IWebViewClientStateListener;
import com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer;
import com.braze.ui.inappmessage.views.InAppMessageHtmlBaseView;
import com.braze.ui.support.ViewUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 >2\u00020\u0001:\u0001>B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015H\u0002J\u0018\u0010/\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00042\u0006\u00100\u001a\u00020 H\u0016J\u0010\u00101\u001a\u00020,2\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020 H\u0016J\u0010\u00105\u001a\u00020,2\u0006\u00106\u001a\u00020 H\u0016J\u0012\u00107\u001a\u00020,2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020 H\u0016J\b\u0010;\u001a\u00020,H\u0016J\u0012\u0010<\u001a\u00020,2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010=\u001a\u00020 2\u0006\u0010-\u001a\u00020\u0004H\u0017R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0002R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00178\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R\u0012\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0004\n\u0002\u0010$R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R&\u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b(\u0010\u0002\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\t¨\u0006?"}, d2 = {"Lcom/braze/ui/inappmessage/BrazeInAppMessageManager;", "Lcom/braze/ui/inappmessage/InAppMessageManagerBase;", "()V", "carryoverInAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "getCarryoverInAppMessage$annotations", "getCarryoverInAppMessage", "()Lcom/braze/models/inappmessage/IInAppMessage;", "setCarryoverInAppMessage", "(Lcom/braze/models/inappmessage/IInAppMessage;)V", "configurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "displayingInAppMessage", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getDisplayingInAppMessage$annotations", "inAppMessageEventMap", "", "Lcom/braze/events/InAppMessageEvent;", "getInAppMessageEventMap", "()Ljava/util/Map;", "inAppMessageEventSubscriber", "Lcom/braze/events/IEventSubscriber;", "inAppMessageStack", "Ljava/util/Stack;", "getInAppMessageStack$annotations", "getInAppMessageStack", "()Ljava/util/Stack;", "inAppMessageViewLifecycleListener", "Lcom/braze/ui/inappmessage/listeners/IInAppMessageViewLifecycleListener;", "inAppMessageViewWrapper", "Lcom/braze/ui/inappmessage/IInAppMessageViewWrapper;", "isCurrentlyDisplayingInAppMessage", "", "()Z", "originalOrientation", "", "Ljava/lang/Integer;", "sdkDataWipeEventSubscriber", "Lcom/braze/events/SdkDataWipeEvent;", "unregisteredInAppMessage", "getUnregisteredInAppMessage$annotations", "getUnregisteredInAppMessage", "setUnregisteredInAppMessage", "addInAppMessage", "", "inAppMessage", "createInAppMessageEventSubscriber", "displayInAppMessage", "isCarryOver", "ensureSubscribedToInAppMessageEvents", "context", "Landroid/content/Context;", "getIsCurrentlyDisplayingInAppMessage", "hideCurrentlyDisplayingInAppMessage", "dismissed", "registerInAppMessageManager", "activity", "Landroid/app/Activity;", "requestDisplayInAppMessage", "resetAfterInAppMessageClose", "unregisterInAppMessageManager", "verifyOrientationStatus", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeInAppMessageManager.kt */
public class BrazeInAppMessageManager extends InAppMessageManagerBase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static volatile BrazeInAppMessageManager instance;
    /* access modifiers changed from: private */
    public static final ReentrantLock instanceLock = new ReentrantLock();
    private IInAppMessage carryoverInAppMessage;
    private BrazeConfigurationProvider configurationProvider;
    public final AtomicBoolean displayingInAppMessage = new AtomicBoolean(false);
    private final Map<IInAppMessage, InAppMessageEvent> inAppMessageEventMap = new LinkedHashMap();
    private IEventSubscriber<InAppMessageEvent> inAppMessageEventSubscriber;
    private final Stack<IInAppMessage> inAppMessageStack = new Stack<>();
    private final IInAppMessageViewLifecycleListener inAppMessageViewLifecycleListener = new DefaultInAppMessageViewLifecycleListener();
    private IInAppMessageViewWrapper inAppMessageViewWrapper;
    private Integer originalOrientation;
    private IEventSubscriber<SdkDataWipeEvent> sdkDataWipeEventSubscriber;
    private IInAppMessage unregisteredInAppMessage;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BrazeInAppMessageManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.braze.ui.inappmessage.InAppMessageOperation[] r0 = com.braze.ui.inappmessage.InAppMessageOperation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.braze.ui.inappmessage.InAppMessageOperation r1 = com.braze.ui.inappmessage.InAppMessageOperation.DISPLAY_NOW     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.braze.ui.inappmessage.InAppMessageOperation r1 = com.braze.ui.inappmessage.InAppMessageOperation.DISPLAY_LATER     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.braze.ui.inappmessage.InAppMessageOperation r1 = com.braze.ui.inappmessage.InAppMessageOperation.DISCARD     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.braze.ui.inappmessage.InAppMessageOperation r1 = com.braze.ui.inappmessage.InAppMessageOperation.REENQUEUE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.ui.inappmessage.BrazeInAppMessageManager.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ void getCarryoverInAppMessage$annotations() {
    }

    public static /* synthetic */ void getDisplayingInAppMessage$annotations() {
    }

    public static /* synthetic */ void getInAppMessageStack$annotations() {
    }

    @JvmStatic
    public static final BrazeInAppMessageManager getInstance() {
        return Companion.getInstance();
    }

    public static /* synthetic */ void getUnregisteredInAppMessage$annotations() {
    }

    public final Stack<IInAppMessage> getInAppMessageStack() {
        return this.inAppMessageStack;
    }

    public final Map<IInAppMessage, InAppMessageEvent> getInAppMessageEventMap() {
        return this.inAppMessageEventMap;
    }

    public final IInAppMessage getCarryoverInAppMessage() {
        return this.carryoverInAppMessage;
    }

    public final void setCarryoverInAppMessage(IInAppMessage iInAppMessage) {
        this.carryoverInAppMessage = iInAppMessage;
    }

    public final IInAppMessage getUnregisteredInAppMessage() {
        return this.unregisteredInAppMessage;
    }

    public final void setUnregisteredInAppMessage(IInAppMessage iInAppMessage) {
        this.unregisteredInAppMessage = iInAppMessage;
    }

    public final boolean isCurrentlyDisplayingInAppMessage() {
        return this.displayingInAppMessage.get();
    }

    public void ensureSubscribedToInAppMessageEvents(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.inAppMessageEventSubscriber != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeInAppMessageManager$ensureSubscribedToInAppMessageEvents$1.INSTANCE, 3, (Object) null);
            Braze.Companion.getInstance(context).removeSingleSubscription(this.inAppMessageEventSubscriber, InAppMessageEvent.class);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeInAppMessageManager$ensureSubscribedToInAppMessageEvents$2.INSTANCE, 3, (Object) null);
        IEventSubscriber<InAppMessageEvent> createInAppMessageEventSubscriber = createInAppMessageEventSubscriber();
        Braze.Companion.getInstance(context).subscribeToNewInAppMessages(createInAppMessageEventSubscriber);
        this.inAppMessageEventSubscriber = createInAppMessageEventSubscriber;
        if (this.sdkDataWipeEventSubscriber != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) BrazeInAppMessageManager$ensureSubscribedToInAppMessageEvents$4.INSTANCE, 2, (Object) null);
            Braze.Companion.getInstance(context).removeSingleSubscription(this.sdkDataWipeEventSubscriber, SdkDataWipeEvent.class);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) BrazeInAppMessageManager$ensureSubscribedToInAppMessageEvents$5.INSTANCE, 2, (Object) null);
        BrazeInAppMessageManager$$ExternalSyntheticLambda0 brazeInAppMessageManager$$ExternalSyntheticLambda0 = new BrazeInAppMessageManager$$ExternalSyntheticLambda0(this);
        Braze.Companion.getInstance(context).addSingleSynchronousSubscription(brazeInAppMessageManager$$ExternalSyntheticLambda0, SdkDataWipeEvent.class);
        this.sdkDataWipeEventSubscriber = brazeInAppMessageManager$$ExternalSyntheticLambda0;
    }

    /* access modifiers changed from: private */
    public static final void ensureSubscribedToInAppMessageEvents$lambda$1(BrazeInAppMessageManager brazeInAppMessageManager, SdkDataWipeEvent sdkDataWipeEvent) {
        Intrinsics.checkNotNullParameter(brazeInAppMessageManager, "this$0");
        Intrinsics.checkNotNullParameter(sdkDataWipeEvent, "it");
        brazeInAppMessageManager.inAppMessageStack.clear();
        brazeInAppMessageManager.carryoverInAppMessage = null;
        brazeInAppMessageManager.unregisteredInAppMessage = null;
    }

    public void registerInAppMessageManager(Activity activity) {
        if (activity == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) BrazeInAppMessageManager$registerInAppMessageManager$1.INSTANCE, 2, (Object) null);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeInAppMessageManager$registerInAppMessageManager$2(activity), 2, (Object) null);
        this.mActivity = activity;
        if (this.mApplicationContext == null) {
            this.mApplicationContext = activity.getApplicationContext();
            if (this.mApplicationContext == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) BrazeInAppMessageManager$registerInAppMessageManager$3.INSTANCE, 2, (Object) null);
                return;
            }
        }
        if (this.configurationProvider == null) {
            Context context = this.mApplicationContext;
            this.configurationProvider = context != null ? new BrazeConfigurationProvider(context) : null;
        }
        IInAppMessage iInAppMessage = this.carryoverInAppMessage;
        if (iInAppMessage != null) {
            if (iInAppMessage != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeInAppMessageManager$registerInAppMessageManager$5$1.INSTANCE, 3, (Object) null);
                iInAppMessage.setAnimateIn(false);
                displayInAppMessage(iInAppMessage, true);
            }
            this.carryoverInAppMessage = null;
        } else {
            IInAppMessage iInAppMessage2 = this.unregisteredInAppMessage;
            if (iInAppMessage2 != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeInAppMessageManager$registerInAppMessageManager$6$1.INSTANCE, 3, (Object) null);
                addInAppMessage(iInAppMessage2);
                this.unregisteredInAppMessage = null;
            }
        }
        Context context2 = this.mApplicationContext;
        if (context2 != null) {
            ensureSubscribedToInAppMessageEvents(context2);
        }
    }

    public void unregisterInAppMessageManager(Activity activity) {
        IInAppMessage iInAppMessage;
        if (getShouldNextUnregisterBeSkipped()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeInAppMessageManager$unregisterInAppMessageManager$1(activity), 3, (Object) null);
            setShouldNextUnregisterBeSkipped(false);
            return;
        }
        if (activity == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) BrazeInAppMessageManager$unregisterInAppMessageManager$2.INSTANCE, 2, (Object) null);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeInAppMessageManager$unregisterInAppMessageManager$3(activity), 2, (Object) null);
        }
        IInAppMessageViewWrapper iInAppMessageViewWrapper = this.inAppMessageViewWrapper;
        if (iInAppMessageViewWrapper != null) {
            View inAppMessageView = iInAppMessageViewWrapper.getInAppMessageView();
            if (inAppMessageView instanceof InAppMessageHtmlBaseView) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeInAppMessageManager$unregisterInAppMessageManager$4.INSTANCE, 3, (Object) null);
                ((InAppMessageHtmlBaseView) inAppMessageView).setHtmlPageFinishedListener((IWebViewClientStateListener) null);
            }
            ViewUtils.removeViewFromParent(inAppMessageView);
            if (iInAppMessageViewWrapper.isAnimatingClose()) {
                this.inAppMessageViewLifecycleListener.afterClosed(iInAppMessageViewWrapper.getInAppMessage());
                iInAppMessage = null;
            } else {
                iInAppMessage = iInAppMessageViewWrapper.getInAppMessage();
            }
            this.carryoverInAppMessage = iInAppMessage;
            this.inAppMessageViewWrapper = null;
        } else {
            this.carryoverInAppMessage = null;
        }
        this.mActivity = null;
        this.displayingInAppMessage.set(false);
    }

    public void addInAppMessage(IInAppMessage iInAppMessage) {
        if (iInAppMessage != null) {
            this.inAppMessageStack.push(iInAppMessage);
            requestDisplayInAppMessage();
        }
    }

    public boolean requestDisplayInAppMessage() {
        InAppMessageOperation inAppMessageOperation;
        try {
            Activity activity = this.mActivity;
            if (activity == null) {
                if (!this.inAppMessageStack.empty()) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) BrazeInAppMessageManager$requestDisplayInAppMessage$1.INSTANCE, 2, (Object) null);
                    this.unregisteredInAppMessage = this.inAppMessageStack.pop();
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeInAppMessageManager$requestDisplayInAppMessage$2.INSTANCE, 3, (Object) null);
                }
                return false;
            } else if (this.displayingInAppMessage.get()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeInAppMessageManager$requestDisplayInAppMessage$3.INSTANCE, 3, (Object) null);
                return false;
            } else if (this.inAppMessageStack.isEmpty()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeInAppMessageManager$requestDisplayInAppMessage$4.INSTANCE, 3, (Object) null);
                return false;
            } else {
                IInAppMessage pop = this.inAppMessageStack.pop();
                if (!pop.isControl()) {
                    IInAppMessageManagerListener inAppMessageManagerListener = getInAppMessageManagerListener();
                    Intrinsics.checkNotNullExpressionValue(pop, "inAppMessage");
                    inAppMessageOperation = inAppMessageManagerListener.beforeInAppMessageDisplayed(pop);
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeInAppMessageManager$requestDisplayInAppMessage$inAppMessageOperation$1.INSTANCE, 3, (Object) null);
                    IInAppMessageManagerListener controlInAppMessageManagerListener = getControlInAppMessageManagerListener();
                    Intrinsics.checkNotNullExpressionValue(pop, "inAppMessage");
                    inAppMessageOperation = controlInAppMessageManagerListener.beforeInAppMessageDisplayed(pop);
                }
                int i = WhenMappings.$EnumSwitchMapping$0[inAppMessageOperation.ordinal()];
                if (i == 1) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeInAppMessageManager$requestDisplayInAppMessage$5.INSTANCE, 3, (Object) null);
                } else if (i == 2) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeInAppMessageManager$requestDisplayInAppMessage$6.INSTANCE, 3, (Object) null);
                    this.inAppMessageStack.push(pop);
                    return false;
                } else if (i == 3) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeInAppMessageManager$requestDisplayInAppMessage$7.INSTANCE, 3, (Object) null);
                    return false;
                } else if (i == 4) {
                    InAppMessageEvent inAppMessageEvent = this.inAppMessageEventMap.get(pop);
                    if (inAppMessageEvent != null) {
                        BrazeInternal brazeInternal = BrazeInternal.INSTANCE;
                        Context applicationContext = activity.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
                        brazeInternal.reenqueueInAppMessage(applicationContext, inAppMessageEvent);
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeInAppMessageManager$requestDisplayInAppMessage$8.INSTANCE, 3, (Object) null);
                    } else {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeInAppMessageManager$requestDisplayInAppMessage$9(pop), 3, (Object) null);
                    }
                    return false;
                }
                BackgroundInAppMessagePreparer.prepareInAppMessageForDisplay(pop);
                return true;
            }
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) BrazeInAppMessageManager$requestDisplayInAppMessage$10.INSTANCE);
            return false;
        }
    }

    public void hideCurrentlyDisplayingInAppMessage(boolean z) {
        setShouldNextUnregisterBeSkipped(false);
        IInAppMessageViewWrapper iInAppMessageViewWrapper = this.inAppMessageViewWrapper;
        if (iInAppMessageViewWrapper != null) {
            if (z) {
                this.inAppMessageViewLifecycleListener.onDismissed(iInAppMessageViewWrapper.getInAppMessageView(), iInAppMessageViewWrapper.getInAppMessage());
            }
            iInAppMessageViewWrapper.close();
        }
    }

    public void resetAfterInAppMessageClose() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) BrazeInAppMessageManager$resetAfterInAppMessageClose$1.INSTANCE, 2, (Object) null);
        this.inAppMessageViewWrapper = null;
        Activity activity = this.mActivity;
        Integer num = this.originalOrientation;
        this.displayingInAppMessage.set(false);
        if (activity != null && num != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeInAppMessageManager$resetAfterInAppMessageClose$2(num), 3, (Object) null);
            ViewUtils.setActivityRequestedOrientation(activity, num.intValue());
            this.originalOrientation = null;
        }
    }

    public boolean getIsCurrentlyDisplayingInAppMessage() {
        return this.displayingInAppMessage.get();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: com.braze.models.inappmessage.IInAppMessage} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v16, resolved type: com.braze.models.inappmessage.IInAppMessage} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void displayInAppMessage(com.braze.models.inappmessage.IInAppMessage r20, boolean r21) {
        /*
            r19 = this;
            r8 = r19
            r15 = r20
            java.lang.String r0 = "inAppMessage"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.V
            com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$1 r0 = new com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$1
            r0.<init>(r15)
            r5 = r0
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r4 = 0
            r6 = 2
            r7 = 0
            r2 = r19
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.displayingInAppMessage
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 != 0) goto L_0x003d
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            r3 = 0
            r4 = 0
            com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$2 r0 = com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$2.INSTANCE
            r5 = r0
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r6 = 3
            r7 = 0
            r2 = r19
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
            java.util.Stack<com.braze.models.inappmessage.IInAppMessage> r0 = r8.inAppMessageStack
            r0.push(r15)
            return
        L_0x003d:
            android.app.Activity r0 = r8.mActivity     // Catch:{ all -> 0x0279 }
            if (r0 == 0) goto L_0x026c
            if (r21 != 0) goto L_0x008a
            long r1 = r20.getExpirationTimestamp()     // Catch:{ all -> 0x0279 }
            r3 = 0
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0079
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0279 }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x0056
            goto L_0x009a
        L_0x0056:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x0279 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0279 }
            r5.<init>()     // Catch:{ all -> 0x0279 }
            java.lang.String r6 = "In-app message is expired. Doing nothing. Expiration: "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0279 }
            java.lang.StringBuilder r1 = r5.append(r1)     // Catch:{ all -> 0x0279 }
            java.lang.String r2 = ". Current time: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0279 }
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0279 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0279 }
            r0.<init>(r1)     // Catch:{ all -> 0x0279 }
            throw r0     // Catch:{ all -> 0x0279 }
        L_0x0079:
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x0279 }
            r3 = 0
            r4 = 0
            com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$3 r2 = com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$3.INSTANCE     // Catch:{ all -> 0x0279 }
            r5 = r2
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5     // Catch:{ all -> 0x0279 }
            r6 = 3
            r7 = 0
            r2 = r19
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0279 }
            goto L_0x009a
        L_0x008a:
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x0279 }
            r3 = 0
            r4 = 0
            com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$4 r2 = com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$4.INSTANCE     // Catch:{ all -> 0x0279 }
            r5 = r2
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5     // Catch:{ all -> 0x0279 }
            r6 = 3
            r7 = 0
            r2 = r19
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0279 }
        L_0x009a:
            boolean r1 = r19.verifyOrientationStatus(r20)     // Catch:{ all -> 0x0279 }
            if (r1 == 0) goto L_0x0263
            boolean r1 = r20.isControl()     // Catch:{ all -> 0x0279 }
            if (r1 == 0) goto L_0x00bd
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x0279 }
            r3 = 0
            r4 = 0
            com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$5 r0 = com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$5.INSTANCE     // Catch:{ all -> 0x0279 }
            r5 = r0
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5     // Catch:{ all -> 0x0279 }
            r6 = 3
            r7 = 0
            r2 = r19
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0279 }
            r20.logImpression()     // Catch:{ all -> 0x0279 }
            r19.resetAfterInAppMessageClose()     // Catch:{ all -> 0x0279 }
            return
        L_0x00bd:
            boolean r1 = com.braze.ui.actions.brazeactions.BrazeActionUtils.containsInvalidBrazeAction((com.braze.models.inappmessage.IInAppMessage) r20)     // Catch:{ all -> 0x0279 }
            java.lang.String r9 = "activity.applicationContext"
            if (r1 == 0) goto L_0x0100
            java.util.Map<com.braze.models.inappmessage.IInAppMessage, com.braze.events.InAppMessageEvent> r1 = r8.inAppMessageEventMap     // Catch:{ all -> 0x0279 }
            java.lang.Object r1 = r1.get(r15)     // Catch:{ all -> 0x0279 }
            r10 = r1
            com.braze.events.InAppMessageEvent r10 = (com.braze.events.InAppMessageEvent) r10     // Catch:{ all -> 0x0279 }
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x0279 }
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.I     // Catch:{ all -> 0x0279 }
            r4 = 0
            com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$6 r2 = com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$6.INSTANCE     // Catch:{ all -> 0x0279 }
            r5 = r2
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5     // Catch:{ all -> 0x0279 }
            r6 = 2
            r7 = 0
            r2 = r19
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0279 }
            if (r10 == 0) goto L_0x00fc
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x0279 }
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.I     // Catch:{ all -> 0x0279 }
            r4 = 0
            com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$7 r2 = com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$7.INSTANCE     // Catch:{ all -> 0x0279 }
            r5 = r2
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5     // Catch:{ all -> 0x0279 }
            r6 = 2
            r7 = 0
            r2 = r19
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0279 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x0279 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r9)     // Catch:{ all -> 0x0279 }
            com.braze.BrazeInternal.retryInAppMessage(r0, r10)     // Catch:{ all -> 0x0279 }
        L_0x00fc:
            r19.resetAfterInAppMessageClose()     // Catch:{ all -> 0x0279 }
            return
        L_0x0100:
            com.braze.ui.inappmessage.BrazeInAppMessageManager$Companion r1 = Companion     // Catch:{ all -> 0x0279 }
            boolean r1 = r1.containsPushPermissionPrompt(r15)     // Catch:{ all -> 0x0279 }
            if (r1 == 0) goto L_0x0149
            boolean r1 = com.braze.support.PermissionUtils.wouldPushPermissionPromptDisplay(r0)     // Catch:{ all -> 0x0279 }
            if (r1 != 0) goto L_0x0149
            java.util.Map<com.braze.models.inappmessage.IInAppMessage, com.braze.events.InAppMessageEvent> r1 = r8.inAppMessageEventMap     // Catch:{ all -> 0x0279 }
            java.lang.Object r1 = r1.get(r15)     // Catch:{ all -> 0x0279 }
            r10 = r1
            com.braze.events.InAppMessageEvent r10 = (com.braze.events.InAppMessageEvent) r10     // Catch:{ all -> 0x0279 }
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x0279 }
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.I     // Catch:{ all -> 0x0279 }
            r4 = 0
            com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$8 r2 = com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$8.INSTANCE     // Catch:{ all -> 0x0279 }
            r5 = r2
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5     // Catch:{ all -> 0x0279 }
            r6 = 2
            r7 = 0
            r2 = r19
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0279 }
            if (r10 == 0) goto L_0x0145
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x0279 }
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.I     // Catch:{ all -> 0x0279 }
            r4 = 0
            com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$9 r2 = com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$9.INSTANCE     // Catch:{ all -> 0x0279 }
            r5 = r2
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5     // Catch:{ all -> 0x0279 }
            r6 = 2
            r7 = 0
            r2 = r19
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0279 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x0279 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r9)     // Catch:{ all -> 0x0279 }
            com.braze.BrazeInternal.retryInAppMessage(r0, r10)     // Catch:{ all -> 0x0279 }
        L_0x0145:
            r19.resetAfterInAppMessageClose()     // Catch:{ all -> 0x0279 }
            return
        L_0x0149:
            com.braze.ui.inappmessage.IInAppMessageViewFactory r1 = r19.getInAppMessageViewFactory(r20)     // Catch:{ all -> 0x0279 }
            if (r1 == 0) goto L_0x025a
            android.view.View r14 = r1.createInAppMessageView(r0, r15)     // Catch:{ all -> 0x0279 }
            if (r14 == 0) goto L_0x0251
            android.view.ViewParent r1 = r14.getParent()     // Catch:{ all -> 0x0279 }
            if (r1 != 0) goto L_0x0248
            com.braze.configuration.BrazeConfigurationProvider r13 = r8.configurationProvider     // Catch:{ all -> 0x0279 }
            if (r13 == 0) goto L_0x023f
            com.braze.ui.inappmessage.IInAppMessageAnimationFactory r1 = r19.getInAppMessageAnimationFactory()     // Catch:{ all -> 0x0279 }
            android.view.animation.Animation r16 = r1.getOpeningAnimation(r15)     // Catch:{ all -> 0x0279 }
            com.braze.ui.inappmessage.IInAppMessageAnimationFactory r1 = r19.getInAppMessageAnimationFactory()     // Catch:{ all -> 0x0279 }
            android.view.animation.Animation r17 = r1.getClosingAnimation(r15)     // Catch:{ all -> 0x0279 }
            com.braze.ui.inappmessage.IInAppMessageViewWrapperFactory r9 = r19.getInAppMessageViewWrapperFactory()     // Catch:{ all -> 0x0279 }
            boolean r1 = r14 instanceof com.braze.ui.inappmessage.views.IInAppMessageImmersiveView     // Catch:{ all -> 0x0279 }
            if (r1 == 0) goto L_0x01b6
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x0279 }
            r3 = 0
            r4 = 0
            com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$10 r2 = com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$10.INSTANCE     // Catch:{ all -> 0x0279 }
            r5 = r2
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5     // Catch:{ all -> 0x0279 }
            r6 = 3
            r7 = 0
            r2 = r19
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0279 }
            r1 = r14
            com.braze.ui.inappmessage.views.IInAppMessageImmersiveView r1 = (com.braze.ui.inappmessage.views.IInAppMessageImmersiveView) r1     // Catch:{ all -> 0x0279 }
            r2 = r15
            com.braze.models.inappmessage.InAppMessageImmersiveBase r2 = (com.braze.models.inappmessage.InAppMessageImmersiveBase) r2     // Catch:{ all -> 0x0279 }
            java.util.List r2 = r2.getMessageButtons()     // Catch:{ all -> 0x0279 }
            int r2 = r2.size()     // Catch:{ all -> 0x0279 }
            com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener r12 = r8.inAppMessageViewLifecycleListener     // Catch:{ all -> 0x0279 }
            android.view.View r3 = r1.getMessageClickableView()     // Catch:{ all -> 0x0279 }
            java.util.List r2 = r1.getMessageButtonViews(r2)     // Catch:{ all -> 0x0279 }
            android.view.View r18 = r1.getMessageCloseButtonView()     // Catch:{ all -> 0x0279 }
            r10 = r14
            r11 = r20
            r7 = r14
            r14 = r16
            r6 = r15
            r15 = r17
            r16 = r3
            r17 = r2
            com.braze.ui.inappmessage.IInAppMessageViewWrapper r1 = r9.createInAppMessageViewWrapper(r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x023c }
            goto L_0x020e
        L_0x01b6:
            r7 = r14
            r6 = r15
            boolean r1 = r7 instanceof com.braze.ui.inappmessage.views.IInAppMessageView     // Catch:{ all -> 0x023c }
            if (r1 == 0) goto L_0x01e9
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x023c }
            r3 = 0
            r4 = 0
            com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$11 r2 = com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$11.INSTANCE     // Catch:{ all -> 0x023c }
            r5 = r2
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5     // Catch:{ all -> 0x023c }
            r10 = 3
            r11 = 0
            r2 = r19
            r15 = r6
            r6 = r10
            r14 = r7
            r7 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0279 }
            r1 = r14
            com.braze.ui.inappmessage.views.IInAppMessageView r1 = (com.braze.ui.inappmessage.views.IInAppMessageView) r1     // Catch:{ all -> 0x0279 }
            com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener r12 = r8.inAppMessageViewLifecycleListener     // Catch:{ all -> 0x0279 }
            android.view.View r1 = r1.getMessageClickableView()     // Catch:{ all -> 0x0279 }
            r10 = r14
            r11 = r20
            r7 = r14
            r14 = r16
            r6 = r15
            r15 = r17
            r16 = r1
            com.braze.ui.inappmessage.IInAppMessageViewWrapper r1 = r9.createInAppMessageViewWrapper(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x023c }
            goto L_0x020e
        L_0x01e9:
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x023c }
            r3 = 0
            r4 = 0
            com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$12 r2 = com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$12.INSTANCE     // Catch:{ all -> 0x023c }
            r5 = r2
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5     // Catch:{ all -> 0x023c }
            r10 = 3
            r11 = 0
            r2 = r19
            r15 = r6
            r6 = r10
            r14 = r7
            r7 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0279 }
            com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener r12 = r8.inAppMessageViewLifecycleListener     // Catch:{ all -> 0x0279 }
            r10 = r14
            r11 = r20
            r7 = r14
            r14 = r16
            r6 = r15
            r15 = r17
            r16 = r7
            com.braze.ui.inappmessage.IInAppMessageViewWrapper r1 = r9.createInAppMessageViewWrapper(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x023c }
        L_0x020e:
            r9 = r1
            r8.inAppMessageViewWrapper = r9     // Catch:{ all -> 0x023c }
            boolean r1 = r7 instanceof com.braze.ui.inappmessage.views.InAppMessageHtmlBaseView     // Catch:{ all -> 0x023c }
            if (r1 == 0) goto L_0x0235
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x023c }
            r3 = 0
            r4 = 0
            com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$13 r2 = com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$13.INSTANCE     // Catch:{ all -> 0x023c }
            r5 = r2
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5     // Catch:{ all -> 0x023c }
            r10 = 3
            r11 = 0
            r2 = r19
            r12 = r6
            r6 = r10
            r10 = r7
            r7 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0277 }
            r14 = r10
            com.braze.ui.inappmessage.views.InAppMessageHtmlBaseView r14 = (com.braze.ui.inappmessage.views.InAppMessageHtmlBaseView) r14     // Catch:{ all -> 0x0277 }
            com.braze.ui.inappmessage.BrazeInAppMessageManager$$ExternalSyntheticLambda1 r1 = new com.braze.ui.inappmessage.BrazeInAppMessageManager$$ExternalSyntheticLambda1     // Catch:{ all -> 0x0277 }
            r1.<init>(r9, r8, r0)     // Catch:{ all -> 0x0277 }
            r14.setHtmlPageFinishedListener(r1)     // Catch:{ all -> 0x0277 }
            goto L_0x028c
        L_0x0235:
            r12 = r6
            if (r9 == 0) goto L_0x028c
            r9.open(r0)     // Catch:{ all -> 0x0277 }
            goto L_0x028c
        L_0x023c:
            r0 = move-exception
            r12 = r6
            goto L_0x027b
        L_0x023f:
            r12 = r15
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x0277 }
            java.lang.String r1 = "configurationProvider is null. The in-app message will not be displayed and will not beput back on the stack."
            r0.<init>(r1)     // Catch:{ all -> 0x0277 }
            throw r0     // Catch:{ all -> 0x0277 }
        L_0x0248:
            r12 = r15
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x0277 }
            java.lang.String r1 = "The in-app message view returned from the IInAppMessageViewFactory already has a parent. This is a sign that the view is being reused. The IInAppMessageViewFactory method createInAppMessageViewmust return a new view without a parent. The in-app message will not be displayed and will not be put back on the stack."
            r0.<init>(r1)     // Catch:{ all -> 0x0277 }
            throw r0     // Catch:{ all -> 0x0277 }
        L_0x0251:
            r12 = r15
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x0277 }
            java.lang.String r1 = "The in-app message view returned from the IInAppMessageViewFactory was null. The in-app message will not be displayed and will not be put back on the stack."
            r0.<init>(r1)     // Catch:{ all -> 0x0277 }
            throw r0     // Catch:{ all -> 0x0277 }
        L_0x025a:
            r12 = r15
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x0277 }
            java.lang.String r1 = "ViewFactory from getInAppMessageViewFactory was null."
            r0.<init>(r1)     // Catch:{ all -> 0x0277 }
            throw r0     // Catch:{ all -> 0x0277 }
        L_0x0263:
            r12 = r15
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x0277 }
            java.lang.String r1 = "Current orientation did not match specified orientation for in-app message. Doing nothing."
            r0.<init>(r1)     // Catch:{ all -> 0x0277 }
            throw r0     // Catch:{ all -> 0x0277 }
        L_0x026c:
            r12 = r15
            r8.carryoverInAppMessage = r12     // Catch:{ all -> 0x0277 }
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x0277 }
            java.lang.String r1 = "No Activity is currently registered to receive in-app messages. Registering in-app message as carry-over in-app message. It will automatically be displayed when the next Activity registers to receive in-app messages."
            r0.<init>(r1)     // Catch:{ all -> 0x0277 }
            throw r0     // Catch:{ all -> 0x0277 }
        L_0x0277:
            r0 = move-exception
            goto L_0x027b
        L_0x0279:
            r0 = move-exception
            r12 = r15
        L_0x027b:
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.E
            com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$15 r3 = new com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$15
            r3.<init>(r12)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r1.brazelog((java.lang.Object) r8, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r0, (kotlin.jvm.functions.Function0<java.lang.String>) r3)
            r19.resetAfterInAppMessageClose()
        L_0x028c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.ui.inappmessage.BrazeInAppMessageManager.displayInAppMessage(com.braze.models.inappmessage.IInAppMessage, boolean):void");
    }

    /* access modifiers changed from: private */
    public static final void displayInAppMessage$lambda$7(IInAppMessageViewWrapper iInAppMessageViewWrapper, BrazeInAppMessageManager brazeInAppMessageManager, Activity activity) {
        Intrinsics.checkNotNullParameter(brazeInAppMessageManager, "this$0");
        if (iInAppMessageViewWrapper != null) {
            try {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) brazeInAppMessageManager, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeInAppMessageManager$displayInAppMessage$14$1.INSTANCE, 3, (Object) null);
                iInAppMessageViewWrapper.open(activity);
            } catch (Exception e) {
                BrazeLogger.INSTANCE.brazelog((Object) brazeInAppMessageManager, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) BrazeInAppMessageManager$displayInAppMessage$14$2.INSTANCE);
            }
        }
    }

    private final IEventSubscriber<InAppMessageEvent> createInAppMessageEventSubscriber() {
        return new BrazeInAppMessageManager$$ExternalSyntheticLambda2(this);
    }

    /* access modifiers changed from: private */
    public static final void createInAppMessageEventSubscriber$lambda$8(BrazeInAppMessageManager brazeInAppMessageManager, InAppMessageEvent inAppMessageEvent) {
        Intrinsics.checkNotNullParameter(brazeInAppMessageManager, "this$0");
        Intrinsics.checkNotNullParameter(inAppMessageEvent, "event");
        IInAppMessage inAppMessage = inAppMessageEvent.getInAppMessage();
        brazeInAppMessageManager.inAppMessageEventMap.put(inAppMessage, inAppMessageEvent);
        brazeInAppMessageManager.addInAppMessage(inAppMessage);
    }

    public boolean verifyOrientationStatus(IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Activity activity = this.mActivity;
        Orientation orientation = iInAppMessage.getOrientation();
        if (activity == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) BrazeInAppMessageManager$verifyOrientationStatus$1.INSTANCE, 2, (Object) null);
        } else if (ViewUtils.isRunningOnTablet(activity)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeInAppMessageManager$verifyOrientationStatus$2.INSTANCE, 3, (Object) null);
        } else if (orientation == Orientation.ANY) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeInAppMessageManager$verifyOrientationStatus$3.INSTANCE, 3, (Object) null);
        } else if (!ViewUtils.isCurrentOrientationValid(activity.getResources().getConfiguration().orientation, orientation)) {
            return false;
        } else {
            if (this.originalOrientation != null) {
                return true;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeInAppMessageManager$verifyOrientationStatus$4.INSTANCE, 3, (Object) null);
            this.originalOrientation = Integer.valueOf(activity.getRequestedOrientation());
            ViewUtils.setActivityRequestedOrientation(activity, 14);
            return true;
        }
        return true;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/braze/ui/inappmessage/BrazeInAppMessageManager$Companion;", "", "()V", "instance", "Lcom/braze/ui/inappmessage/BrazeInAppMessageManager;", "instanceLock", "Ljava/util/concurrent/locks/ReentrantLock;", "getInstance", "containsPushPermissionPrompt", "", "Lcom/braze/models/inappmessage/IInAppMessage;", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BrazeInAppMessageManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: finally extract failed */
        @JvmStatic
        public final BrazeInAppMessageManager getInstance() {
            if (BrazeInAppMessageManager.instance != null) {
                BrazeInAppMessageManager access$getInstance$cp = BrazeInAppMessageManager.instance;
                Intrinsics.checkNotNull(access$getInstance$cp, "null cannot be cast to non-null type com.braze.ui.inappmessage.BrazeInAppMessageManager");
                return access$getInstance$cp;
            }
            Lock access$getInstanceLock$cp = BrazeInAppMessageManager.instanceLock;
            access$getInstanceLock$cp.lock();
            try {
                if (BrazeInAppMessageManager.instance == null) {
                    Companion companion = BrazeInAppMessageManager.Companion;
                    BrazeInAppMessageManager.instance = new BrazeInAppMessageManager();
                }
                Unit unit = Unit.INSTANCE;
                access$getInstanceLock$cp.unlock();
                BrazeInAppMessageManager access$getInstance$cp2 = BrazeInAppMessageManager.instance;
                Intrinsics.checkNotNull(access$getInstance$cp2, "null cannot be cast to non-null type com.braze.ui.inappmessage.BrazeInAppMessageManager");
                return access$getInstance$cp2;
            } catch (Throwable th) {
                access$getInstanceLock$cp.unlock();
                throw th;
            }
        }

        /* access modifiers changed from: private */
        public final boolean containsPushPermissionPrompt(IInAppMessage iInAppMessage) {
            if (iInAppMessage instanceof InAppMessageHtml) {
                return ((InAppMessageHtml) iInAppMessage).isPushPrimer();
            }
            return BrazeActionUtils.containsAnyPushPermissionBrazeActions(iInAppMessage);
        }
    }
}
