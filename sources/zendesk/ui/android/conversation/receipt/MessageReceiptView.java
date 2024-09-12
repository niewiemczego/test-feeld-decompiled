package zendesk.ui.android.conversation.receipt;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.internal.ColorExtKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001&B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J-\u0010\u0019\u001a\u00020\u00132\b\b\u0001\u0010\u001a\u001a\u00020\t2\u0019\b\u0002\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00130\u001c¢\u0006\u0002\b\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0003J\u001c\u0010!\u001a\u00020\u00132\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001cH\u0016J\b\u0010#\u001a\u00020\u0013H\u0002J\r\u0010$\u001a\u00020\u0013H\u0001¢\u0006\u0002\b%R\u000e\u0010\f\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lzendesk/ui/android/conversation/receipt/MessageReceiptView;", "Landroid/widget/LinearLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/receipt/MessageReceiptRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "container", "iconImage", "Landroid/widget/ImageView;", "labelText", "Landroid/widget/TextView;", "rendering", "animateIconScaleDown", "", "animateIconScaleUp", "animateTailDrop", "animateTextFadeIn", "announceFailedStatusForAccessibility", "buildLabelAndIconViews", "formatIconView", "imageResource", "containerBlock", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "getLabelColor", "position", "Lzendesk/ui/android/conversation/receipt/MessageReceiptPosition;", "render", "renderingUpdate", "startAnimation", "stopAnimation", "stopAnimation$zendesk_ui_ui_android", "Companion", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageReceiptView.kt */
public final class MessageReceiptView extends LinearLayout implements Renderer<MessageReceiptRendering> {
    @Deprecated
    private static final long ACCESSIBILITY_EVENT_DELAY = 500;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final float DOWN_START_TRANSLATION = -12.0f;
    @Deprecated
    private static final float DOWN_TRANSLATION = 0.0f;
    @Deprecated
    private static final long FADE_DURATION = 300;
    @Deprecated
    private static final long OPACITY_ANIMATION_DELAY = 100;
    @Deprecated
    private static final long OPACITY_ANIMATION_DURATION = 200;
    @Deprecated
    private static final long PULSE_DURATION = 600;
    @Deprecated
    private static final float SCALE_DOWN = 1.0f;
    @Deprecated
    private static final float SCALE_UP = 1.5f;
    @Deprecated
    private static final long TRANSLATION_DELAY = 300;
    @Deprecated
    private static final long TRANSLATION_DURATION = 300;
    private final LinearLayout container;
    /* access modifiers changed from: private */
    public final ImageView iconImage;
    /* access modifiers changed from: private */
    public final TextView labelText;
    /* access modifiers changed from: private */
    public MessageReceiptRendering rendering;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageReceiptView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageReceiptPosition.values().length];
            iArr[MessageReceiptPosition.NONE.ordinal()] = 1;
            iArr[MessageReceiptPosition.OUTBOUND_SENDING.ordinal()] = 2;
            iArr[MessageReceiptPosition.INBOUND.ordinal()] = 3;
            iArr[MessageReceiptPosition.OUTBOUND_SENT.ordinal()] = 4;
            iArr[MessageReceiptPosition.OUTBOUND_FAILED.ordinal()] = 5;
            iArr[MessageReceiptPosition.INBOUND_FAILED.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MessageReceiptView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MessageReceiptView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MessageReceiptView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageReceiptView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageReceiptView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new MessageReceiptRendering();
        context.getTheme().applyStyle(R.style.ThemeOverlay_ZendeskComponents_MessageReceipt, false);
        LinearLayout.inflate(context, R.layout.zuia_view_message_receipt, this);
        View findViewById = findViewById(R.id.zuia_message_receipt_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zuia_message_receipt_container)");
        this.container = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.zuia_icon_image);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.zuia_icon_image)");
        this.iconImage = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.zuia_label_text);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.zuia_label_text)");
        this.labelText = (TextView) findViewById3;
        render(AnonymousClass1.INSTANCE);
    }

    public void render(Function1<? super MessageReceiptRendering, MessageReceiptRendering> function1) {
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        MessageReceiptRendering invoke = function1.invoke(this.rendering);
        this.rendering = invoke;
        this.labelText.setVisibility(invoke.getState$zendesk_ui_ui_android().getShouldAnimateReceipt$zendesk_ui_ui_android() ? 4 : 0);
        this.labelText.setText(this.rendering.getState$zendesk_ui_ui_android().getLabel$zendesk_ui_ui_android());
        TextView textView = this.labelText;
        Integer labelColor$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getLabelColor$zendesk_ui_ui_android();
        textView.setTextColor(labelColor$zendesk_ui_ui_android != null ? labelColor$zendesk_ui_ui_android.intValue() : getLabelColor(this.rendering.getState$zendesk_ui_ui_android().getMessageReceiptPosition$zendesk_ui_ui_android()));
        buildLabelAndIconViews();
        startAnimation();
    }

    private final void startAnimation() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.rendering.getState$zendesk_ui_ui_android().getMessageReceiptPosition$zendesk_ui_ui_android().ordinal()];
        if (i == 2 || i == 3 || i == 4) {
            animateTailDrop();
        } else if (i == 5 || i == 6) {
            this.labelText.setVisibility(0);
        }
    }

    private final void animateTailDrop() {
        if (this.rendering.getState$zendesk_ui_ui_android().getShouldAnimateReceipt$zendesk_ui_ui_android()) {
            ImageView imageView = this.iconImage;
            imageView.animate().cancel();
            imageView.setAlpha(0.0f);
            imageView.setVisibility(4);
            imageView.setTranslationY(DOWN_START_TRANSLATION);
            imageView.animate().translationY(0.0f).setStartDelay(300).setDuration(300).setInterpolator(new AccelerateDecelerateInterpolator()).withStartAction(new MessageReceiptView$$ExternalSyntheticLambda3(imageView)).withEndAction(new MessageReceiptView$$ExternalSyntheticLambda4(imageView, this)).start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: animateTailDrop$lambda-3$lambda-0  reason: not valid java name */
    public static final void m2802animateTailDrop$lambda3$lambda0(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "$this_apply");
        imageView.animate().alpha(1.0f).setStartDelay(OPACITY_ANIMATION_DELAY).setDuration(OPACITY_ANIMATION_DURATION).setInterpolator(new LinearInterpolator()).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: animateTailDrop$lambda-3$lambda-1  reason: not valid java name */
    public static final void m2803animateTailDrop$lambda3$lambda1(ImageView imageView, MessageReceiptView messageReceiptView) {
        Intrinsics.checkNotNullParameter(imageView, "$this_apply");
        Intrinsics.checkNotNullParameter(messageReceiptView, "this$0");
        imageView.setVisibility(0);
        messageReceiptView.animateTextFadeIn();
        if (messageReceiptView.rendering.getState$zendesk_ui_ui_android().getMessageReceiptPosition$zendesk_ui_ui_android() == MessageReceiptPosition.OUTBOUND_SENDING) {
            messageReceiptView.animateIconScaleUp();
        } else {
            messageReceiptView.labelText.setVisibility(0);
        }
    }

    private final void animateIconScaleUp() {
        ImageView imageView = this.iconImage;
        imageView.setPivotX(SCALE_UP);
        imageView.setPivotY(1.0f);
        imageView.animate().scaleX(SCALE_UP).scaleY(SCALE_UP).setDuration(PULSE_DURATION).setInterpolator(new DecelerateInterpolator()).withEndAction(new MessageReceiptView$$ExternalSyntheticLambda1(this)).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: animateIconScaleUp$lambda-5$lambda-4  reason: not valid java name */
    public static final void m2801animateIconScaleUp$lambda5$lambda4(MessageReceiptView messageReceiptView) {
        Intrinsics.checkNotNullParameter(messageReceiptView, "this$0");
        messageReceiptView.animateIconScaleDown();
    }

    private final void animateIconScaleDown() {
        ImageView imageView = this.iconImage;
        imageView.setPivotX(SCALE_UP);
        imageView.setPivotY(1.0f);
        imageView.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(new AccelerateInterpolator()).setDuration(PULSE_DURATION).withEndAction(new MessageReceiptView$$ExternalSyntheticLambda0(this)).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: animateIconScaleDown$lambda-7$lambda-6  reason: not valid java name */
    public static final void m2800animateIconScaleDown$lambda7$lambda6(MessageReceiptView messageReceiptView) {
        Intrinsics.checkNotNullParameter(messageReceiptView, "this$0");
        messageReceiptView.animateIconScaleUp();
    }

    private final void animateTextFadeIn() {
        TextView textView = this.labelText;
        textView.animate().cancel();
        textView.setAlpha(0.0f);
        textView.setVisibility(4);
        textView.animate().alpha(1.0f).setDuration(300).withEndAction(new MessageReceiptView$$ExternalSyntheticLambda5(textView)).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: animateTextFadeIn$lambda-9$lambda-8  reason: not valid java name */
    public static final void m2804animateTextFadeIn$lambda9$lambda8(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "$this_apply");
        textView.setVisibility(0);
    }

    private final int getLabelColor(MessageReceiptPosition messageReceiptPosition) {
        switch (WhenMappings.$EnumSwitchMapping$0[messageReceiptPosition.ordinal()]) {
            case 1:
            case 3:
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                return ColorExtKt.resolveColorAttr(context, R.attr.messageReceiptInboundLabelColor);
            case 2:
            case 4:
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                return ColorExtKt.resolveColorAttr(context2, R.attr.messageReceiptOutboundLabelColor);
            case 5:
            case 6:
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                return ColorExtKt.resolveColorAttr(context3, R.attr.messageReceiptOutboundFailedLabelColor);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void buildLabelAndIconViews() {
        this.container.removeAllViews();
        int i = WhenMappings.$EnumSwitchMapping$0[this.rendering.getState$zendesk_ui_ui_android().getMessageReceiptPosition$zendesk_ui_ui_android().ordinal()];
        if (i == 2) {
            formatIconView$default(this, R.drawable.zuia_message_status_outbound_sending, (Function1) null, 2, (Object) null);
        } else if (i == 3) {
            formatIconView(R.drawable.zuia_message_status_inbound, new MessageReceiptView$buildLabelAndIconViews$1(this));
        } else if (i == 4) {
            formatIconView$default(this, R.drawable.zuia_message_status_outbound_sent, (Function1) null, 2, (Object) null);
        } else if (i == 5) {
            formatIconView$default(this, R.drawable.zuia_message_status_outbound_failed, (Function1) null, 2, (Object) null);
            announceFailedStatusForAccessibility();
        } else if (i == 6) {
            formatIconView(R.drawable.zuia_message_status_outbound_failed, new MessageReceiptView$buildLabelAndIconViews$2(this));
            announceFailedStatusForAccessibility();
        }
    }

    private final void announceFailedStatusForAccessibility() {
        this.labelText.postDelayed(new MessageReceiptView$$ExternalSyntheticLambda2(this), 500);
    }

    /* access modifiers changed from: private */
    /* renamed from: announceFailedStatusForAccessibility$lambda-10  reason: not valid java name */
    public static final void m2805announceFailedStatusForAccessibility$lambda10(MessageReceiptView messageReceiptView) {
        Intrinsics.checkNotNullParameter(messageReceiptView, "this$0");
        messageReceiptView.labelText.sendAccessibilityEvent(8);
    }

    static /* synthetic */ void formatIconView$default(MessageReceiptView messageReceiptView, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new MessageReceiptView$formatIconView$1(messageReceiptView);
        }
        messageReceiptView.formatIconView(i, function1);
    }

    private final void formatIconView(int i, Function1<? super LinearLayout, Unit> function1) {
        this.iconImage.setImageResource(i);
        Integer iconColor$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getIconColor$zendesk_ui_ui_android();
        if (iconColor$zendesk_ui_ui_android != null) {
            this.iconImage.setColorFilter(iconColor$zendesk_ui_ui_android.intValue(), PorterDuff.Mode.SRC_IN);
        }
        function1.invoke(this.container);
    }

    public final void stopAnimation$zendesk_ui_ui_android() {
        this.labelText.animate().cancel();
        this.labelText.setVisibility(0);
        this.iconImage.animate().cancel();
        this.iconImage.setVisibility(0);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lzendesk/ui/android/conversation/receipt/MessageReceiptView$Companion;", "", "()V", "ACCESSIBILITY_EVENT_DELAY", "", "DOWN_START_TRANSLATION", "", "DOWN_TRANSLATION", "FADE_DURATION", "OPACITY_ANIMATION_DELAY", "OPACITY_ANIMATION_DURATION", "PULSE_DURATION", "SCALE_DOWN", "SCALE_UP", "TRANSLATION_DELAY", "TRANSLATION_DURATION", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageReceiptView.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
