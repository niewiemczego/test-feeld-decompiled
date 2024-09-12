package zendesk.ui.android.conversation.composer;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.internal.ColorExtKt;
import zendesk.ui.android.internal.ThrottledAfterTextChangedKt;
import zendesk.ui.android.internal.ThrottledOnClickListenerKt;
import zendesk.ui.android.internal.ViewKt;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 $2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001$B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\u0018H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lzendesk/ui/android/conversation/composer/MessageComposerView;", "Landroid/widget/FrameLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/composer/MessageComposerRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "attachButton", "Landroid/widget/ImageButton;", "composerContainer", "messageComposer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "rendering", "sendButton", "textField", "Landroid/widget/EditText;", "viewPropertyAnimator", "Landroid/view/ViewPropertyAnimator;", "render", "", "renderingUpdate", "Lkotlin/Function1;", "renderAttachButton", "enabled", "", "renderAttachMenu", "renderSendButton", "setEnabled", "setupAttachButtonBackgroundState", "setupMessageComposerFocusedState", "setupSendButtonBackgroundState", "Companion", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageComposerView.kt */
public final class MessageComposerView extends FrameLayout implements Renderer<MessageComposerRendering> {
    @Deprecated
    private static final int COMPOSER_MAX_LINES = 5;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final long SEND_BUTTON_HIDE_OPACITY_ANIMATION_DURATION = 200;
    @Deprecated
    private static final long SEND_BUTTON_HIDE_TRANSLATION_ANIMATION_DURATION = 300;
    @Deprecated
    private static final long SEND_BUTTON_SHOW_OPACITY_ANIMATION_DELAY = 100;
    @Deprecated
    private static final long SEND_BUTTON_SHOW_OPACITY_ANIMATION_DURATION = 200;
    @Deprecated
    private static final long SEND_BUTTON_SHOW_TRANSLATION_ANIMATION_DURATION = 300;
    private final ImageButton attachButton;
    private final FrameLayout composerContainer;
    private final ConstraintLayout messageComposer;
    /* access modifiers changed from: private */
    public MessageComposerRendering rendering;
    private final ImageButton sendButton;
    /* access modifiers changed from: private */
    public final EditText textField;
    private ViewPropertyAnimator viewPropertyAnimator;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MessageComposerView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MessageComposerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MessageComposerView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageComposerView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageComposerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new MessageComposerRendering();
        context.getTheme().applyStyle(R.style.ThemeOverlay_ZendeskComponents_MessageComposer, false);
        FrameLayout.inflate(context, R.layout.zuia_view_message_composer, this);
        View findViewById = findViewById(R.id.zuia_composer_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zuia_composer_container)");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        this.composerContainer = frameLayout;
        View findViewById2 = findViewById(R.id.zuia_attach_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.zuia_attach_button)");
        this.attachButton = (ImageButton) findViewById2;
        View findViewById3 = findViewById(R.id.zuia_text_field);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.zuia_text_field)");
        EditText editText = (EditText) findViewById3;
        this.textField = editText;
        View findViewById4 = findViewById(R.id.zuia_send_button);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.zuia_send_button)");
        this.sendButton = (ImageButton) findViewById4;
        View findViewById5 = findViewById(R.id.zuia_message_composer_view);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.zuia_message_composer_view)");
        this.messageComposer = (ConstraintLayout) findViewById5;
        context.getTheme().resolveAttribute(R.attr.colorOnSurface, new TypedValue(), true);
        ViewKt.outlinedBoxBackground$default(frameLayout, ColorExtKt.adjustAlpha(ColorExtKt.resolveColorAttr(context, R.attr.colorOnBackground), 0.55f), getResources().getDimension(R.dimen.zuia_message_composer_radius), 0.0f, 4, (Object) null);
        editText.addTextChangedListener(new MessageComposerView$special$$inlined$doOnTextChanged$1(this));
        editText.setHintTextColor(ColorExtKt.adjustAlpha(ColorExtKt.resolveColorAttr(context, R.attr.colorOnBackground), 0.55f));
        editText.addTextChangedListener(ThrottledAfterTextChangedKt.throttledAfterTextChangedListener$default(0, new Function1<Editable, Unit>(this) {
            final /* synthetic */ MessageComposerView this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Editable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Editable editable) {
                boolean z = false;
                if (editable != null && (!StringsKt.isBlank(editable))) {
                    z = true;
                }
                if (z) {
                    this.this$0.renderSendButton(true);
                }
                this.this$0.rendering.getOnTextChanged$zendesk_ui_ui_android().invoke(StringsKt.trim((CharSequence) String.valueOf(editable)).toString());
            }
        }, 1, (Object) null));
        render(AnonymousClass3.INSTANCE);
    }

    public void render(Function1<? super MessageComposerRendering, MessageComposerRendering> function1) {
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        MessageComposerRendering invoke = function1.invoke(this.rendering);
        this.rendering = invoke;
        setEnabled(invoke.getState$zendesk_ui_ui_android().getEnabled$zendesk_ui_ui_android());
        boolean z = false;
        this.textField.setFilters(this.rendering.getState$zendesk_ui_ui_android().getInputMaxLength$zendesk_ui_ui_android() < 0 ? (InputFilter[]) ((Object[]) new InputFilter[0]) : (InputFilter[]) new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(this.rendering.getState$zendesk_ui_ui_android().getInputMaxLength$zendesk_ui_ui_android())});
        Integer attachButtonColor$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getAttachButtonColor$zendesk_ui_ui_android();
        if (attachButtonColor$zendesk_ui_ui_android != null) {
            this.attachButton.setColorFilter(attachButtonColor$zendesk_ui_ui_android.intValue(), PorterDuff.Mode.SRC_IN);
        }
        Integer sendButtonColor$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getSendButtonColor$zendesk_ui_ui_android();
        this.sendButton.setColorFilter(sendButtonColor$zendesk_ui_ui_android != null ? sendButtonColor$zendesk_ui_ui_android.intValue() : ContextCompat.getColor(getContext(), R.color.colorActionDefault));
        this.sendButton.setContentDescription(getResources().getString(R.string.zuia_send_button_accessibility_label));
        this.sendButton.setOnClickListener(ThrottledOnClickListenerKt.throttledOnClickListener$default(0, new MessageComposerView$render$2(this), 1, (Object) null));
        setupAttachButtonBackgroundState();
        this.messageComposer.setVisibility(this.rendering.getState$zendesk_ui_ui_android().getVisibility$zendesk_ui_ui_android());
        this.attachButton.setOnClickListener(ThrottledOnClickListenerKt.throttledOnClickListener$default(0, new MessageComposerView$render$3(this), 1, (Object) null));
        CharSequence composerText$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getComposerText$zendesk_ui_ui_android();
        if (composerText$zendesk_ui_ui_android.length() > 0) {
            z = true;
        }
        if (z) {
            this.textField.setText(composerText$zendesk_ui_ui_android);
        }
        if (this.textField.hasFocus()) {
            EditText editText = this.textField;
            editText.setSelection(editText.getText().toString().length());
        }
        setupMessageComposerFocusedState();
    }

    private final void setupMessageComposerFocusedState() {
        this.textField.setOnFocusChangeListener(new MessageComposerView$$ExternalSyntheticLambda0(this));
        this.sendButton.setOnFocusChangeListener(new MessageComposerView$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupMessageComposerFocusedState$lambda-2  reason: not valid java name */
    public static final void m2772setupMessageComposerFocusedState$lambda2(MessageComposerView messageComposerView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(messageComposerView, "this$0");
        boolean z2 = true;
        if (messageComposerView.textField.hasFocus()) {
            messageComposerView.renderSendButton(true);
        } else if (!messageComposerView.sendButton.hasFocus()) {
            CharSequence text = messageComposerView.textField.getText();
            if (text != null && !StringsKt.isBlank(text)) {
                z2 = false;
            }
            if (z2) {
                messageComposerView.renderSendButton(false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setupMessageComposerFocusedState$lambda-3  reason: not valid java name */
    public static final void m2773setupMessageComposerFocusedState$lambda3(MessageComposerView messageComposerView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(messageComposerView, "this$0");
        boolean z2 = true;
        if (messageComposerView.sendButton.hasFocus()) {
            messageComposerView.renderSendButton(true);
        } else if (!messageComposerView.textField.hasFocus()) {
            CharSequence text = messageComposerView.textField.getText();
            if (text != null && !StringsKt.isBlank(text)) {
                z2 = false;
            }
            if (z2) {
                messageComposerView.renderSendButton(false);
            }
        }
    }

    private final void setupAttachButtonBackgroundState() {
        Integer sendButtonColor$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getSendButtonColor$zendesk_ui_ui_android();
        int intValue = sendButtonColor$zendesk_ui_ui_android != null ? sendButtonColor$zendesk_ui_ui_android.intValue() : ContextCompat.getColor(getContext(), R.color.colorActionDefault);
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.zuia_attachment_button_background);
        if (drawable != null) {
            GradientDrawable gradientDrawable = (GradientDrawable) drawable;
            gradientDrawable.mutate();
            gradientDrawable.setStroke(getResources().getDimensionPixelSize(R.dimen.zuia_attachment_button_stroke_width), intValue);
            stateListDrawable.addState(new int[]{16842908}, gradientDrawable);
            this.attachButton.setBackground(stateListDrawable);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        renderAttachButton(z);
        if (z) {
            this.textField.setEnabled(true);
            this.textField.setMaxLines(5);
            Editable text = this.textField.getText();
            Intrinsics.checkNotNullExpressionValue(text, "textField.text");
            renderSendButton(!StringsKt.isBlank(text));
            return;
        }
        this.textField.setEnabled(false);
        this.textField.setMaxLines(1);
        renderSendButton(false);
    }

    /* access modifiers changed from: private */
    public final void renderSendButton(boolean z) {
        ImageButton imageButton = this.sendButton;
        int i = 1;
        if ((imageButton.getVisibility() == 0) != z) {
            float height = ((float) imageButton.getHeight()) / 2.0f;
            if (this.sendButton.getLayoutDirection() == 1) {
                i = -1;
            }
            float f = height * ((float) i);
            ViewPropertyAnimator viewPropertyAnimator2 = this.viewPropertyAnimator;
            if (viewPropertyAnimator2 != null) {
                viewPropertyAnimator2.cancel();
            }
            if (z) {
                imageButton.setAlpha(0.0f);
                imageButton.setVisibility(0);
                imageButton.setTranslationX(f);
                ViewPropertyAnimator withEndAction = imageButton.animate().translationX(0.0f).setDuration(300).setInterpolator(new DecelerateInterpolator()).withStartAction(new MessageComposerView$$ExternalSyntheticLambda2(imageButton)).withEndAction(new MessageComposerView$$ExternalSyntheticLambda3(imageButton, this));
                withEndAction.start();
                this.viewPropertyAnimator = withEndAction;
            } else {
                imageButton.setTranslationX(0.0f);
                ViewPropertyAnimator withEndAction2 = imageButton.animate().translationX(f).setDuration(300).setInterpolator(new AccelerateInterpolator()).withStartAction(new MessageComposerView$$ExternalSyntheticLambda4(imageButton)).withEndAction(new MessageComposerView$$ExternalSyntheticLambda5(imageButton, this));
                withEndAction2.start();
                this.viewPropertyAnimator = withEndAction2;
            }
            setupSendButtonBackgroundState();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: renderSendButton$lambda-10$lambda-4  reason: not valid java name */
    public static final void m2768renderSendButton$lambda10$lambda4(ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "$this_apply");
        imageButton.animate().alpha(1.0f).setStartDelay(SEND_BUTTON_SHOW_OPACITY_ANIMATION_DELAY).setDuration(200).setInterpolator(new LinearInterpolator()).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: renderSendButton$lambda-10$lambda-5  reason: not valid java name */
    public static final void m2769renderSendButton$lambda10$lambda5(ImageButton imageButton, MessageComposerView messageComposerView) {
        Intrinsics.checkNotNullParameter(imageButton, "$this_apply");
        Intrinsics.checkNotNullParameter(messageComposerView, "this$0");
        imageButton.setVisibility(0);
        messageComposerView.viewPropertyAnimator = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: renderSendButton$lambda-10$lambda-7  reason: not valid java name */
    public static final void m2770renderSendButton$lambda10$lambda7(ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "$this_apply");
        imageButton.animate().alpha(0.0f).setDuration(200).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: renderSendButton$lambda-10$lambda-8  reason: not valid java name */
    public static final void m2771renderSendButton$lambda10$lambda8(ImageButton imageButton, MessageComposerView messageComposerView) {
        Intrinsics.checkNotNullParameter(imageButton, "$this_apply");
        Intrinsics.checkNotNullParameter(messageComposerView, "this$0");
        imageButton.setVisibility(8);
        messageComposerView.viewPropertyAnimator = null;
    }

    private final void setupSendButtonBackgroundState() {
        Integer sendButtonColor$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getSendButtonColor$zendesk_ui_ui_android();
        int intValue = sendButtonColor$zendesk_ui_ui_android != null ? sendButtonColor$zendesk_ui_ui_android.intValue() : ContextCompat.getColor(getContext(), R.color.colorActionDefault);
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.zuia_attachment_button_background);
        if (drawable != null) {
            GradientDrawable gradientDrawable = (GradientDrawable) drawable;
            gradientDrawable.mutate();
            gradientDrawable.setStroke(getResources().getDimensionPixelSize(R.dimen.zuia_attachment_button_stroke_width), intValue);
            stateListDrawable.addState(new int[]{16842908}, gradientDrawable);
            this.sendButton.setBackground(stateListDrawable);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    private final void renderAttachButton(boolean z) {
        int i = 0;
        if (z) {
            boolean z2 = true;
            this.attachButton.setEnabled(true);
            this.rendering.getState$zendesk_ui_ui_android().getShowAttachment$zendesk_ui_ui_android();
            View view = this.attachButton;
            if (!this.rendering.getState$zendesk_ui_ui_android().getGallerySupported$zendesk_ui_ui_android() && !this.rendering.getState$zendesk_ui_ui_android().getCameraSupported$zendesk_ui_ui_android()) {
                z2 = false;
            }
            if (!z2) {
                i = 8;
            }
            view.setVisibility(i);
            return;
        }
        this.attachButton.setEnabled(false);
    }

    /* access modifiers changed from: private */
    public final void renderAttachMenu() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        MessageComposerAttachmentMenu messageComposerAttachmentMenu = new MessageComposerAttachmentMenu(context);
        messageComposerAttachmentMenu.setGallerySupported(this.rendering.getState$zendesk_ui_ui_android().getGallerySupported$zendesk_ui_ui_android());
        messageComposerAttachmentMenu.setCameraSupported(this.rendering.getState$zendesk_ui_ui_android().getCameraSupported$zendesk_ui_ui_android());
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());
        messageComposerAttachmentMenu.setOnItemClickListener(new MessageComposerView$renderAttachMenu$1(this, bottomSheetDialog));
        bottomSheetDialog.getBehavior().setState(3);
        bottomSheetDialog.getBehavior().setSkipCollapsed(true);
        bottomSheetDialog.setContentView((View) messageComposerAttachmentMenu);
        bottomSheetDialog.show();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lzendesk/ui/android/conversation/composer/MessageComposerView$Companion;", "", "()V", "COMPOSER_MAX_LINES", "", "SEND_BUTTON_HIDE_OPACITY_ANIMATION_DURATION", "", "SEND_BUTTON_HIDE_TRANSLATION_ANIMATION_DURATION", "SEND_BUTTON_SHOW_OPACITY_ANIMATION_DELAY", "SEND_BUTTON_SHOW_OPACITY_ANIMATION_DURATION", "SEND_BUTTON_SHOW_TRANSLATION_ANIMATION_DURATION", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageComposerView.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
