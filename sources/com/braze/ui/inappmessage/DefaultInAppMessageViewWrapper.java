package com.braze.ui.inappmessage;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.inappmessage.DismissType;
import com.braze.enums.inappmessage.SlideFrom;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageImmersive;
import com.braze.models.inappmessage.InAppMessageSlideup;
import com.braze.models.inappmessage.MessageButton;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import com.braze.ui.inappmessage.listeners.SwipeDismissTouchListener;
import com.braze.ui.inappmessage.listeners.TouchAwareSwipeDismissTouchListener;
import com.braze.ui.inappmessage.views.IInAppMessageImmersiveView;
import com.braze.ui.inappmessage.views.IInAppMessageView;
import com.braze.ui.inappmessage.views.InAppMessageHtmlBaseView;
import com.braze.ui.support.ViewUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 d2\u00020\u0001:\u0001dBc\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J\b\u0010H\u001a\u00020IH\u0016J(\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010L\u001a\u00020I2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010NH\u0016J\b\u0010O\u001a\u00020IH\u0016J\b\u0010P\u001a\u00020IH\u0016J\u0010\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u000208H\u0016J\b\u0010T\u001a\u00020IH\u0016J\b\u0010U\u001a\u00020VH\u0016J\b\u0010W\u001a\u00020VH\u0016J\b\u0010X\u001a\u00020YH\u0016J\b\u0010Z\u001a\u00020[H\u0016J \u0010\\\u001a\u00020I2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010]\u001a\u00020^2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010_\u001a\u00020!2\u0006\u0010`\u001a\u00020aH\u0016J\u0010\u0010b\u001a\u00020I2\u0006\u0010`\u001a\u00020aH\u0016J\u0010\u0010c\u001a\u00020I2\u0006\u0010S\u001a\u000208H\u0016R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u0016\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001a\u00107\u001a\u000208X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00109\"\u0004\b:\u0010;R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u001dR\u001c\u0010=\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0017\"\u0004\b?\u0010\u0019R6\u0010@\u001a\u001e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020B0Aj\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020B`CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006e"}, d2 = {"Lcom/braze/ui/inappmessage/DefaultInAppMessageViewWrapper;", "Lcom/braze/ui/inappmessage/IInAppMessageViewWrapper;", "inAppMessageView", "Landroid/view/View;", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "inAppMessageViewLifecycleListener", "Lcom/braze/ui/inappmessage/listeners/IInAppMessageViewLifecycleListener;", "configurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "openingAnimation", "Landroid/view/animation/Animation;", "closingAnimation", "clickableInAppMessageView", "buttonViews", "", "closeButton", "(Landroid/view/View;Lcom/braze/models/inappmessage/IInAppMessage;Lcom/braze/ui/inappmessage/listeners/IInAppMessageViewLifecycleListener;Lcom/braze/configuration/BrazeConfigurationProvider;Landroid/view/animation/Animation;Landroid/view/animation/Animation;Landroid/view/View;Ljava/util/List;Landroid/view/View;)V", "getButtonViews", "()Ljava/util/List;", "setButtonViews", "(Ljava/util/List;)V", "getClickableInAppMessageView", "()Landroid/view/View;", "setClickableInAppMessageView", "(Landroid/view/View;)V", "getCloseButton", "setCloseButton", "getClosingAnimation", "()Landroid/view/animation/Animation;", "getConfigurationProvider", "()Lcom/braze/configuration/BrazeConfigurationProvider;", "contentViewGroupParentLayout", "Landroid/view/ViewGroup;", "getContentViewGroupParentLayout", "()Landroid/view/ViewGroup;", "setContentViewGroupParentLayout", "(Landroid/view/ViewGroup;)V", "dismissRunnable", "Ljava/lang/Runnable;", "getDismissRunnable", "()Ljava/lang/Runnable;", "setDismissRunnable", "(Ljava/lang/Runnable;)V", "getInAppMessage", "()Lcom/braze/models/inappmessage/IInAppMessage;", "inAppMessageCloser", "Lcom/braze/ui/inappmessage/InAppMessageCloser;", "getInAppMessageCloser$annotations", "()V", "getInAppMessageCloser", "()Lcom/braze/ui/inappmessage/InAppMessageCloser;", "getInAppMessageView", "getInAppMessageViewLifecycleListener", "()Lcom/braze/ui/inappmessage/listeners/IInAppMessageViewLifecycleListener;", "isAnimatingClose", "", "()Z", "setAnimatingClose", "(Z)V", "getOpeningAnimation", "previouslyFocusedView", "getPreviouslyFocusedView", "setPreviouslyFocusedView", "viewAccessibilityFlagMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getViewAccessibilityFlagMap", "()Ljava/util/HashMap;", "setViewAccessibilityFlagMap", "(Ljava/util/HashMap;)V", "addDismissRunnable", "", "addInAppMessageViewToViewGroup", "parentViewGroup", "announceForAccessibilityIfNecessary", "fallbackAccessibilityMessage", "", "close", "closeInAppMessageView", "createAnimationListener", "Landroid/view/animation/Animation$AnimationListener;", "opening", "createButtonClickListeners", "createClickListener", "Landroid/view/View$OnClickListener;", "createCloseInAppMessageClickListener", "createDismissCallbacks", "Lcom/braze/ui/inappmessage/listeners/SwipeDismissTouchListener$DismissCallbacks;", "createTouchAwareListener", "Lcom/braze/ui/inappmessage/listeners/TouchAwareSwipeDismissTouchListener$ITouchListener;", "finalizeViewBeforeDisplay", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getParentViewGroup", "activity", "Landroid/app/Activity;", "open", "setAndStartAnimation", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultInAppMessageViewWrapper.kt */
public class DefaultInAppMessageViewWrapper implements IInAppMessageViewWrapper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private List<? extends View> buttonViews;
    private View clickableInAppMessageView;
    private View closeButton;
    private final Animation closingAnimation;
    private final BrazeConfigurationProvider configurationProvider;
    private ViewGroup contentViewGroupParentLayout;
    private Runnable dismissRunnable;
    private final IInAppMessage inAppMessage;
    private final InAppMessageCloser inAppMessageCloser;
    private final View inAppMessageView;
    private final IInAppMessageViewLifecycleListener inAppMessageViewLifecycleListener;
    private boolean isAnimatingClose;
    private final Animation openingAnimation;
    private View previouslyFocusedView;
    private HashMap<Integer, Integer> viewAccessibilityFlagMap;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultInAppMessageViewWrapper.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.braze.enums.inappmessage.MessageType[] r0 = com.braze.enums.inappmessage.MessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.braze.enums.inappmessage.MessageType r1 = com.braze.enums.inappmessage.MessageType.MODAL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.braze.enums.inappmessage.MessageType r1 = com.braze.enums.inappmessage.MessageType.FULL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.braze.enums.inappmessage.MessageType r1 = com.braze.enums.inappmessage.MessageType.HTML_FULL     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.braze.enums.inappmessage.MessageType r1 = com.braze.enums.inappmessage.MessageType.HTML     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper.WhenMappings.<clinit>():void");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DefaultInAppMessageViewWrapper(android.view.View r14, com.braze.models.inappmessage.IInAppMessage r15, com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener r16, com.braze.configuration.BrazeConfigurationProvider r17, android.view.animation.Animation r18, android.view.animation.Animation r19, android.view.View r20) {
        /*
            r13 = this;
            java.lang.String r0 = "inAppMessageView"
            r2 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "inAppMessage"
            r3 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "inAppMessageViewLifecycleListener"
            r4 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "configurationProvider"
            r5 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r9 = 0
            r10 = 0
            r11 = 384(0x180, float:5.38E-43)
            r12 = 0
            r1 = r13
            r6 = r18
            r7 = r19
            r8 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper.<init>(android.view.View, com.braze.models.inappmessage.IInAppMessage, com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener, com.braze.configuration.BrazeConfigurationProvider, android.view.animation.Animation, android.view.animation.Animation, android.view.View):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DefaultInAppMessageViewWrapper(android.view.View r14, com.braze.models.inappmessage.IInAppMessage r15, com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener r16, com.braze.configuration.BrazeConfigurationProvider r17, android.view.animation.Animation r18, android.view.animation.Animation r19, android.view.View r20, java.util.List<? extends android.view.View> r21) {
        /*
            r13 = this;
            java.lang.String r0 = "inAppMessageView"
            r2 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "inAppMessage"
            r3 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "inAppMessageViewLifecycleListener"
            r4 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "configurationProvider"
            r5 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r10 = 0
            r11 = 256(0x100, float:3.59E-43)
            r12 = 0
            r1 = r13
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper.<init>(android.view.View, com.braze.models.inappmessage.IInAppMessage, com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener, com.braze.configuration.BrazeConfigurationProvider, android.view.animation.Animation, android.view.animation.Animation, android.view.View, java.util.List):void");
    }

    public static /* synthetic */ void getInAppMessageCloser$annotations() {
    }

    public View.OnClickListener createCloseInAppMessageClickListener() {
        return new DefaultInAppMessageViewWrapper$$ExternalSyntheticLambda1();
    }

    public DefaultInAppMessageViewWrapper(View view, IInAppMessage iInAppMessage, IInAppMessageViewLifecycleListener iInAppMessageViewLifecycleListener, BrazeConfigurationProvider brazeConfigurationProvider, Animation animation, Animation animation2, View view2, List<? extends View> list, View view3) {
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(iInAppMessageViewLifecycleListener, "inAppMessageViewLifecycleListener");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        this.inAppMessageView = view;
        this.inAppMessage = iInAppMessage;
        this.inAppMessageViewLifecycleListener = iInAppMessageViewLifecycleListener;
        this.configurationProvider = brazeConfigurationProvider;
        this.openingAnimation = animation;
        this.closingAnimation = animation2;
        this.clickableInAppMessageView = view2;
        this.buttonViews = list;
        this.closeButton = view3;
        this.viewAccessibilityFlagMap = new HashMap<>();
        View clickableInAppMessageView2 = getClickableInAppMessageView();
        setClickableInAppMessageView(clickableInAppMessageView2 == null ? getInAppMessageView() : clickableInAppMessageView2);
        if (getInAppMessage() instanceof InAppMessageSlideup) {
            TouchAwareSwipeDismissTouchListener touchAwareSwipeDismissTouchListener = new TouchAwareSwipeDismissTouchListener(getInAppMessageView(), createDismissCallbacks());
            touchAwareSwipeDismissTouchListener.setTouchListener(createTouchAwareListener());
            View clickableInAppMessageView3 = getClickableInAppMessageView();
            if (clickableInAppMessageView3 != null) {
                clickableInAppMessageView3.setOnTouchListener(touchAwareSwipeDismissTouchListener);
            }
        }
        View clickableInAppMessageView4 = getClickableInAppMessageView();
        if (clickableInAppMessageView4 != null) {
            clickableInAppMessageView4.setOnClickListener(createClickListener());
        }
        this.inAppMessageCloser = new InAppMessageCloser(this);
        View closeButton2 = getCloseButton();
        if (closeButton2 != null) {
            closeButton2.setOnClickListener(createCloseInAppMessageClickListener());
        }
        createButtonClickListeners();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DefaultInAppMessageViewWrapper(android.view.View r14, com.braze.models.inappmessage.IInAppMessage r15, com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener r16, com.braze.configuration.BrazeConfigurationProvider r17, android.view.animation.Animation r18, android.view.animation.Animation r19, android.view.View r20, java.util.List r21, android.view.View r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 128(0x80, float:1.794E-43)
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r11 = r2
            goto L_0x000b
        L_0x0009:
            r11 = r21
        L_0x000b:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0011
            r12 = r2
            goto L_0x0013
        L_0x0011:
            r12 = r22
        L_0x0013:
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper.<init>(android.view.View, com.braze.models.inappmessage.IInAppMessage, com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener, com.braze.configuration.BrazeConfigurationProvider, android.view.animation.Animation, android.view.animation.Animation, android.view.View, java.util.List, android.view.View, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public View getInAppMessageView() {
        return this.inAppMessageView;
    }

    public IInAppMessage getInAppMessage() {
        return this.inAppMessage;
    }

    public IInAppMessageViewLifecycleListener getInAppMessageViewLifecycleListener() {
        return this.inAppMessageViewLifecycleListener;
    }

    public BrazeConfigurationProvider getConfigurationProvider() {
        return this.configurationProvider;
    }

    public Animation getOpeningAnimation() {
        return this.openingAnimation;
    }

    public Animation getClosingAnimation() {
        return this.closingAnimation;
    }

    public View getClickableInAppMessageView() {
        return this.clickableInAppMessageView;
    }

    public void setClickableInAppMessageView(View view) {
        this.clickableInAppMessageView = view;
    }

    public List<View> getButtonViews() {
        return this.buttonViews;
    }

    public void setButtonViews(List<? extends View> list) {
        this.buttonViews = list;
    }

    public View getCloseButton() {
        return this.closeButton;
    }

    public void setCloseButton(View view) {
        this.closeButton = view;
    }

    public InAppMessageCloser getInAppMessageCloser() {
        return this.inAppMessageCloser;
    }

    public boolean isAnimatingClose() {
        return this.isAnimatingClose;
    }

    public void setAnimatingClose(boolean z) {
        this.isAnimatingClose = z;
    }

    public Runnable getDismissRunnable() {
        return this.dismissRunnable;
    }

    public void setDismissRunnable(Runnable runnable) {
        this.dismissRunnable = runnable;
    }

    public View getPreviouslyFocusedView() {
        return this.previouslyFocusedView;
    }

    public void setPreviouslyFocusedView(View view) {
        this.previouslyFocusedView = view;
    }

    public HashMap<Integer, Integer> getViewAccessibilityFlagMap() {
        return this.viewAccessibilityFlagMap;
    }

    public void setViewAccessibilityFlagMap(HashMap<Integer, Integer> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.viewAccessibilityFlagMap = hashMap;
    }

    public ViewGroup getContentViewGroupParentLayout() {
        return this.contentViewGroupParentLayout;
    }

    public void setContentViewGroupParentLayout(ViewGroup viewGroup) {
        this.contentViewGroupParentLayout = viewGroup;
    }

    public void open(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) DefaultInAppMessageViewWrapper$open$1.INSTANCE, 2, (Object) null);
        ViewGroup parentViewGroup = getParentViewGroup(activity);
        int height = parentViewGroup.getHeight();
        if (getConfigurationProvider().isInAppMessageAccessibilityExclusiveModeEnabled()) {
            setContentViewGroupParentLayout(parentViewGroup);
            getViewAccessibilityFlagMap().clear();
            Companion.setAllViewGroupChildrenAsNonAccessibilityImportant(getContentViewGroupParentLayout(), getViewAccessibilityFlagMap());
        }
        setPreviouslyFocusedView(activity.getCurrentFocus());
        if (height == 0) {
            parentViewGroup.addOnLayoutChangeListener(new DefaultInAppMessageViewWrapper$open$2(parentViewGroup, this));
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new DefaultInAppMessageViewWrapper$open$3(height), 3, (Object) null);
        addInAppMessageViewToViewGroup(parentViewGroup, getInAppMessage(), getInAppMessageView(), getInAppMessageViewLifecycleListener());
    }

    public void close() {
        if (getConfigurationProvider().isInAppMessageAccessibilityExclusiveModeEnabled()) {
            Companion.resetAllViewGroupChildrenToPreviousAccessibilityFlagOrAuto(getContentViewGroupParentLayout(), getViewAccessibilityFlagMap());
        }
        getInAppMessageView().removeCallbacks(getDismissRunnable());
        getInAppMessageViewLifecycleListener().beforeClosed(getInAppMessageView(), getInAppMessage());
        if (getInAppMessage().getAnimateOut()) {
            setAnimatingClose(true);
            setAndStartAnimation(false);
            return;
        }
        closeInAppMessageView();
    }

    public ViewGroup getParentViewGroup(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View findViewById = activity.getWindow().getDecorView().findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "activity.window.decorVie…yId(android.R.id.content)");
        return (ViewGroup) findViewById;
    }

    public ViewGroup.LayoutParams getLayoutParams(IInAppMessage iInAppMessage) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (iInAppMessage instanceof InAppMessageSlideup) {
            layoutParams.gravity = ((InAppMessageSlideup) iInAppMessage).getSlideFrom() == SlideFrom.TOP ? 48 : 80;
        }
        return layoutParams;
    }

    public void addInAppMessageViewToViewGroup(ViewGroup viewGroup, IInAppMessage iInAppMessage, View view, IInAppMessageViewLifecycleListener iInAppMessageViewLifecycleListener) {
        Intrinsics.checkNotNullParameter(viewGroup, "parentViewGroup");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessageViewLifecycleListener, "inAppMessageViewLifecycleListener");
        iInAppMessageViewLifecycleListener.beforeOpened(view, iInAppMessage);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageViewWrapper$addInAppMessageViewToViewGroup$1.INSTANCE, 3, (Object) null);
        viewGroup.addView(view, getLayoutParams(iInAppMessage));
        if (view instanceof IInAppMessageView) {
            View view2 = viewGroup;
            ViewCompat.requestApplyInsets(view2);
            ViewCompat.setOnApplyWindowInsetsListener(view2, new DefaultInAppMessageViewWrapper$$ExternalSyntheticLambda0(view, this));
        }
        if (iInAppMessage.getAnimateIn()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageViewWrapper$addInAppMessageViewToViewGroup$3.INSTANCE, 3, (Object) null);
            setAndStartAnimation(true);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageViewWrapper$addInAppMessageViewToViewGroup$4.INSTANCE, 3, (Object) null);
        if (iInAppMessage.getDismissType() == DismissType.AUTO_DISMISS) {
            addDismissRunnable();
        }
        finalizeViewBeforeDisplay(iInAppMessage, view, iInAppMessageViewLifecycleListener);
    }

    /* access modifiers changed from: private */
    public static final WindowInsetsCompat addInAppMessageViewToViewGroup$lambda$0(View view, DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper, View view2, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(view, "$inAppMessageView");
        Intrinsics.checkNotNullParameter(defaultInAppMessageViewWrapper, "this$0");
        if (windowInsetsCompat == null) {
            return new WindowInsetsCompat(windowInsetsCompat);
        }
        IInAppMessageView iInAppMessageView = (IInAppMessageView) view;
        if (!iInAppMessageView.getHasAppliedWindowInsets()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) defaultInAppMessageViewWrapper, BrazeLogger.Priority.V, (Throwable) null, (Function0) DefaultInAppMessageViewWrapper$addInAppMessageViewToViewGroup$2$1.INSTANCE, 2, (Object) null);
            iInAppMessageView.applyWindowInsets(windowInsetsCompat);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) defaultInAppMessageViewWrapper, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageViewWrapper$addInAppMessageViewToViewGroup$2$2.INSTANCE, 3, (Object) null);
        }
        return windowInsetsCompat;
    }

    public static /* synthetic */ void announceForAccessibilityIfNecessary$default(DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "In app message displayed.";
            }
            defaultInAppMessageViewWrapper.announceForAccessibilityIfNecessary(str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: announceForAccessibilityIfNecessary");
    }

    public void announceForAccessibilityIfNecessary(String str) {
        if (getInAppMessageView() instanceof IInAppMessageImmersiveView) {
            String message = getInAppMessage().getMessage();
            if (getInAppMessage() instanceof IInAppMessageImmersive) {
                IInAppMessage inAppMessage2 = getInAppMessage();
                Intrinsics.checkNotNull(inAppMessage2, "null cannot be cast to non-null type com.braze.models.inappmessage.IInAppMessageImmersive");
                getInAppMessageView().announceForAccessibility(((IInAppMessageImmersive) inAppMessage2).getHeader() + " . " + message);
                return;
            }
            getInAppMessageView().announceForAccessibility(message);
        } else if (getInAppMessageView() instanceof InAppMessageHtmlBaseView) {
            getInAppMessageView().announceForAccessibility(str);
        }
    }

    public View.OnClickListener createClickListener() {
        return new DefaultInAppMessageViewWrapper$$ExternalSyntheticLambda4(this);
    }

    /* access modifiers changed from: private */
    public static final void createClickListener$lambda$1(DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper, View view) {
        List<MessageButton> messageButtons;
        Intrinsics.checkNotNullParameter(defaultInAppMessageViewWrapper, "this$0");
        IInAppMessage inAppMessage2 = defaultInAppMessageViewWrapper.getInAppMessage();
        IInAppMessageImmersive iInAppMessageImmersive = inAppMessage2 instanceof IInAppMessageImmersive ? (IInAppMessageImmersive) inAppMessage2 : null;
        boolean z = true;
        if (iInAppMessageImmersive == null || (messageButtons = iInAppMessageImmersive.getMessageButtons()) == null || !messageButtons.isEmpty()) {
            z = false;
        }
        if (z || !(defaultInAppMessageViewWrapper.getInAppMessage() instanceof IInAppMessageImmersive)) {
            defaultInAppMessageViewWrapper.getInAppMessageViewLifecycleListener().onClicked(defaultInAppMessageViewWrapper.getInAppMessageCloser(), defaultInAppMessageViewWrapper.getInAppMessageView(), defaultInAppMessageViewWrapper.getInAppMessage());
        }
    }

    public void createButtonClickListeners() {
        IInAppMessage inAppMessage2 = getInAppMessage();
        IInAppMessageImmersive iInAppMessageImmersive = inAppMessage2 instanceof IInAppMessageImmersive ? (IInAppMessageImmersive) inAppMessage2 : null;
        if (iInAppMessageImmersive == null) {
            return;
        }
        if (iInAppMessageImmersive.getMessageButtons().isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageViewWrapper$createButtonClickListeners$1$1.INSTANCE, 3, (Object) null);
            return;
        }
        List<View> buttonViews2 = getButtonViews();
        if (buttonViews2 != null) {
            int i = 0;
            for (Object next : buttonViews2) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                View view = (View) next;
                MessageButton messageButton = (MessageButton) CollectionsKt.getOrNull(iInAppMessageImmersive.getMessageButtons(), i);
                if (messageButton != null) {
                    view.setOnClickListener(new DefaultInAppMessageViewWrapper$$ExternalSyntheticLambda3(this, messageButton, iInAppMessageImmersive));
                }
                i = i2;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void createButtonClickListeners$lambda$5$lambda$4$lambda$3$lambda$2(DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper, MessageButton messageButton, IInAppMessageImmersive iInAppMessageImmersive, View view) {
        Intrinsics.checkNotNullParameter(defaultInAppMessageViewWrapper, "this$0");
        Intrinsics.checkNotNullParameter(messageButton, "$button");
        Intrinsics.checkNotNullParameter(iInAppMessageImmersive, "$immersiveMessage");
        defaultInAppMessageViewWrapper.getInAppMessageViewLifecycleListener().onButtonClicked(defaultInAppMessageViewWrapper.getInAppMessageCloser(), messageButton, iInAppMessageImmersive);
    }

    /* access modifiers changed from: private */
    public static final void createCloseInAppMessageClickListener$lambda$6(View view) {
        BrazeInAppMessageManager.Companion.getInstance().hideCurrentlyDisplayingInAppMessage(true);
    }

    public void addDismissRunnable() {
        if (getDismissRunnable() == null) {
            setDismissRunnable(new DefaultInAppMessageViewWrapper$$ExternalSyntheticLambda2());
            getInAppMessageView().postDelayed(getDismissRunnable(), (long) getInAppMessage().getDurationInMilliseconds());
        }
    }

    /* access modifiers changed from: private */
    public static final void addDismissRunnable$lambda$7() {
        BrazeInAppMessageManager.Companion.getInstance().hideCurrentlyDisplayingInAppMessage(true);
    }

    public void setAndStartAnimation(boolean z) {
        Animation animation;
        if (z) {
            animation = getOpeningAnimation();
        } else {
            animation = getClosingAnimation();
        }
        if (animation != null) {
            animation.setAnimationListener(createAnimationListener(z));
        }
        getInAppMessageView().clearAnimation();
        getInAppMessageView().setAnimation(animation);
        if (animation != null) {
            animation.startNow();
        }
        getInAppMessageView().invalidate();
    }

    public void closeInAppMessageView() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) DefaultInAppMessageViewWrapper$closeInAppMessageView$1.INSTANCE, 3, (Object) null);
        ViewUtils.removeViewFromParent(getInAppMessageView());
        View inAppMessageView2 = getInAppMessageView();
        InAppMessageHtmlBaseView inAppMessageHtmlBaseView = inAppMessageView2 instanceof InAppMessageHtmlBaseView ? (InAppMessageHtmlBaseView) inAppMessageView2 : null;
        if (inAppMessageHtmlBaseView != null) {
            inAppMessageHtmlBaseView.finishWebViewDisplay();
        }
        if (getPreviouslyFocusedView() != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new DefaultInAppMessageViewWrapper$closeInAppMessageView$2(this), 3, (Object) null);
            View previouslyFocusedView2 = getPreviouslyFocusedView();
            if (previouslyFocusedView2 != null) {
                previouslyFocusedView2.requestFocus();
            }
        }
        getInAppMessageViewLifecycleListener().afterClosed(getInAppMessage());
    }

    public void finalizeViewBeforeDisplay(IInAppMessage iInAppMessage, View view, IInAppMessageViewLifecycleListener iInAppMessageViewLifecycleListener) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessageViewLifecycleListener, "inAppMessageViewLifecycleListener");
        if (ViewUtils.isDeviceNotInTouchMode(view)) {
            int i = WhenMappings.$EnumSwitchMapping$0[iInAppMessage.getMessageType().ordinal()];
            if (!(i == 1 || i == 2 || i == 3 || i == 4)) {
                ViewUtils.setFocusableInTouchModeAndRequestFocus(view);
            }
        } else {
            ViewUtils.setFocusableInTouchModeAndRequestFocus(view);
        }
        announceForAccessibilityIfNecessary$default(this, (String) null, 1, (Object) null);
        iInAppMessageViewLifecycleListener.afterOpened(view, iInAppMessage);
    }

    public SwipeDismissTouchListener.DismissCallbacks createDismissCallbacks() {
        return new DefaultInAppMessageViewWrapper$createDismissCallbacks$1(this);
    }

    public TouchAwareSwipeDismissTouchListener.ITouchListener createTouchAwareListener() {
        return new DefaultInAppMessageViewWrapper$createTouchAwareListener$1();
    }

    public Animation.AnimationListener createAnimationListener(boolean z) {
        return z ? new DefaultInAppMessageViewWrapper$createAnimationListener$1(this) : new DefaultInAppMessageViewWrapper$createAnimationListener$2(this);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ$\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000b¨\u0006\f"}, d2 = {"Lcom/braze/ui/inappmessage/DefaultInAppMessageViewWrapper$Companion;", "", "()V", "resetAllViewGroupChildrenToPreviousAccessibilityFlagOrAuto", "", "viewGroup", "Landroid/view/ViewGroup;", "viewAccessibilityFlagMap", "", "", "setAllViewGroupChildrenAsNonAccessibilityImportant", "", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultInAppMessageViewWrapper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setAllViewGroupChildrenAsNonAccessibilityImportant(ViewGroup viewGroup, Map<Integer, Integer> map) {
            Intrinsics.checkNotNullParameter(map, "viewAccessibilityFlagMap");
            if (viewGroup == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) DefaultInAppMessageViewWrapper$Companion$setAllViewGroupChildrenAsNonAccessibilityImportant$1.INSTANCE, 2, (Object) null);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null) {
                    map.put(Integer.valueOf(childAt.getId()), Integer.valueOf(childAt.getImportantForAccessibility()));
                    ViewCompat.setImportantForAccessibility(childAt, 4);
                }
            }
        }

        public final void resetAllViewGroupChildrenToPreviousAccessibilityFlagOrAuto(ViewGroup viewGroup, Map<Integer, Integer> map) {
            Intrinsics.checkNotNullParameter(map, "viewAccessibilityFlagMap");
            if (viewGroup == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) DefaultInAppMessageViewWrapper$Companion$resetAllViewGroupChildrenToPreviousAccessibilityFlagOrAuto$1.INSTANCE, 2, (Object) null);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null) {
                    int id = childAt.getId();
                    if (map.containsKey(Integer.valueOf(id))) {
                        Integer num = map.get(Integer.valueOf(id));
                        if (num != null) {
                            ViewCompat.setImportantForAccessibility(childAt, num.intValue());
                        }
                    } else {
                        ViewCompat.setImportantForAccessibility(childAt, 0);
                    }
                }
            }
        }
    }
}
