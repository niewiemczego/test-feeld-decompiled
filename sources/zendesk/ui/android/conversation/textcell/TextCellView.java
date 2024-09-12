package zendesk.ui.android.conversation.textcell;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import io.sentry.protocol.SentryTransaction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.conversation.actionbutton.ActionButton;
import zendesk.ui.android.conversation.actionbutton.ActionButtonView;
import zendesk.ui.android.internal.ColorExtKt;
import zendesk.ui.android.internal.ThrottledOnClickListenerKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u001c\u0010\u0017\u001a\u00020\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u0015\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\tH\u0000¢\u0006\u0002\b\u001dJ\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\tH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lzendesk/ui/android/conversation/textcell/TextCellView;", "Landroid/widget/FrameLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/textcell/TextCellRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "actionButtonsContainer", "Landroid/widget/LinearLayout;", "messageText", "Landroid/widget/TextView;", "rendering", "buildActionButtonView", "Lzendesk/ui/android/conversation/actionbutton/ActionButtonView;", "actionButton", "Lzendesk/ui/android/conversation/actionbutton/ActionButton;", "prepareClickableElements", "", "render", "renderingUpdate", "Lkotlin/Function1;", "renderActionButtons", "setMessageTextGravity", "gravity", "setMessageTextGravity$zendesk_ui_ui_android", "setupMessageBackground", "updateFocusedBackgroundState", "textColor", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextCellView.kt */
public final class TextCellView extends FrameLayout implements Renderer<TextCellRendering> {
    private final LinearLayout actionButtonsContainer;
    /* access modifiers changed from: private */
    public final TextView messageText;
    /* access modifiers changed from: private */
    public TextCellRendering rendering;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TextCellView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TextCellView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TextCellView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextCellView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextCellView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new TextCellRendering();
        context.getTheme().applyStyle(R.style.ThemeOverlay_ZendeskComponents_TextCellStyle, false);
        FrameLayout.inflate(context, R.layout.zuia_view_text_cell, this);
        View findViewById = findViewById(R.id.zuia_message_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zuia_message_text)");
        this.messageText = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.zuia_action_buttons_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.zuia_action_buttons_container)");
        this.actionButtonsContainer = (LinearLayout) findViewById2;
        render(AnonymousClass1.INSTANCE);
    }

    public void render(Function1<? super TextCellRendering, TextCellRendering> function1) {
        int i;
        Integer backgroundColor$zendesk_ui_ui_android;
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        TextCellRendering invoke = function1.invoke(this.rendering);
        this.rendering = invoke;
        boolean z = true;
        this.messageText.setVisibility(invoke.getState$zendesk_ui_ui_android().getMessageText$zendesk_ui_ui_android().length() > 0 ? 0 : 8);
        if (this.messageText.getVisibility() != 0) {
            z = false;
        }
        if (z) {
            this.messageText.setText(this.rendering.getState$zendesk_ui_ui_android().getMessageText$zendesk_ui_ui_android());
        }
        Integer backgroundDrawable$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getBackgroundDrawable$zendesk_ui_ui_android();
        if (backgroundDrawable$zendesk_ui_ui_android != null) {
            setBackgroundResource(backgroundDrawable$zendesk_ui_ui_android.intValue());
        }
        if (!(getBackground() == null || (backgroundColor$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getBackgroundColor$zendesk_ui_ui_android()) == null)) {
            int intValue = backgroundColor$zendesk_ui_ui_android.intValue();
            Drawable background = getBackground();
            GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
            if (gradientDrawable != null) {
                gradientDrawable.setColor(intValue);
            }
        }
        Integer textColor$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getTextColor$zendesk_ui_ui_android();
        if (textColor$zendesk_ui_ui_android != null) {
            i = textColor$zendesk_ui_ui_android.intValue();
        } else {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            i = ColorExtKt.resolveColorAttr(context, 16842904);
        }
        setupMessageBackground();
        this.messageText.setTextColor(i);
        this.messageText.setLinkTextColor(i);
        updateFocusedBackgroundState(i);
        this.messageText.setOnClickListener(ThrottledOnClickListenerKt.throttledOnClickListener(600, new TextCellView$render$3(this)));
        prepareClickableElements();
        renderActionButtons();
    }

    private final void renderActionButtons() {
        this.actionButtonsContainer.removeAllViews();
        List<ActionButton> actions$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getActions$zendesk_ui_ui_android();
        if (actions$zendesk_ui_ui_android != null) {
            for (ActionButton buildActionButtonView : actions$zendesk_ui_ui_android) {
                LinearLayout linearLayout = this.actionButtonsContainer;
                View buildActionButtonView2 = buildActionButtonView(buildActionButtonView);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(getResources().getDimensionPixelSize(R.dimen.zuia_spacing_medium), (this.messageText.getVisibility() == 8 && this.actionButtonsContainer.getChildCount() == 0) ? getResources().getDimensionPixelSize(R.dimen.zuia_spacing_small) : 0, getResources().getDimensionPixelSize(R.dimen.zuia_spacing_medium), getResources().getDimensionPixelSize(R.dimen.zuia_spacing_small));
                Unit unit = Unit.INSTANCE;
                linearLayout.addView(buildActionButtonView2, layoutParams);
            }
        }
    }

    private final ActionButtonView buildActionButtonView(ActionButton actionButton) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ActionButtonView actionButtonView = new ActionButtonView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        actionButtonView.render(new TextCellView$buildActionButtonView$1$1(this, actionButton, actionButtonView));
        return actionButtonView;
    }

    private final void updateFocusedBackgroundState(int i) {
        this.messageText.setOnFocusChangeListener(new TextCellView$$ExternalSyntheticLambda0(this, i));
    }

    /* access modifiers changed from: private */
    /* renamed from: updateFocusedBackgroundState$lambda-6  reason: not valid java name */
    public static final void m2807updateFocusedBackgroundState$lambda6(TextCellView textCellView, int i, View view, boolean z) {
        Object obj;
        Intrinsics.checkNotNullParameter(textCellView, "this$0");
        if (z) {
            Number backgroundDrawable$zendesk_ui_ui_android = textCellView.rendering.getState$zendesk_ui_ui_android().getBackgroundDrawable$zendesk_ui_ui_android();
            GradientDrawable gradientDrawable = null;
            if (backgroundDrawable$zendesk_ui_ui_android != null) {
                obj = ContextCompat.getDrawable(textCellView.getContext(), backgroundDrawable$zendesk_ui_ui_android.intValue());
            } else {
                obj = null;
            }
            if (obj instanceof GradientDrawable) {
                gradientDrawable = (GradientDrawable) obj;
            }
            if (gradientDrawable != null) {
                gradientDrawable.mutate();
            }
            if (gradientDrawable != null) {
                gradientDrawable.setStroke(textCellView.getResources().getDimensionPixelSize(R.dimen.zuia_divider_size), i);
            }
            Number backgroundColor$zendesk_ui_ui_android = textCellView.rendering.getState$zendesk_ui_ui_android().getBackgroundColor$zendesk_ui_ui_android();
            if (backgroundColor$zendesk_ui_ui_android != null) {
                int intValue = backgroundColor$zendesk_ui_ui_android.intValue();
                if (gradientDrawable != null) {
                    gradientDrawable.setColor(intValue);
                }
            }
            textCellView.messageText.setBackground(gradientDrawable);
            return;
        }
        textCellView.setupMessageBackground();
    }

    private final void setupMessageBackground() {
        Object obj;
        Number backgroundDrawable$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getBackgroundDrawable$zendesk_ui_ui_android();
        if (backgroundDrawable$zendesk_ui_ui_android != null) {
            backgroundDrawable$zendesk_ui_ui_android.intValue();
            Number backgroundDrawable$zendesk_ui_ui_android2 = this.rendering.getState$zendesk_ui_ui_android().getBackgroundDrawable$zendesk_ui_ui_android();
            GradientDrawable gradientDrawable = null;
            if (backgroundDrawable$zendesk_ui_ui_android2 != null) {
                obj = ContextCompat.getDrawable(getContext(), backgroundDrawable$zendesk_ui_ui_android2.intValue());
            } else {
                obj = null;
            }
            if (obj instanceof GradientDrawable) {
                gradientDrawable = (GradientDrawable) obj;
            }
            if (gradientDrawable != null) {
                gradientDrawable.mutate();
            }
            Number backgroundColor$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getBackgroundColor$zendesk_ui_ui_android();
            if (backgroundColor$zendesk_ui_ui_android != null) {
                int intValue = backgroundColor$zendesk_ui_ui_android.intValue();
                if (gradientDrawable != null) {
                    gradientDrawable.setColor(intValue);
                }
            }
            this.messageText.setBackground(gradientDrawable);
        }
    }

    public final void setMessageTextGravity$zendesk_ui_ui_android(int i) {
        TextView textView = this.messageText;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = i;
        textView.setLayoutParams(layoutParams);
    }

    private final void prepareClickableElements() {
        CharSequence text = this.messageText.getText();
        SpannableString spannableString = text instanceof SpannableString ? (SpannableString) text : null;
        if (spannableString != null) {
            URLSpan[] uRLSpanArr = (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class);
            Intrinsics.checkNotNullExpressionValue(uRLSpanArr, SentryTransaction.JsonKeys.SPANS);
            for (URLSpan uRLSpan : uRLSpanArr) {
                int spanStart = spannableString.getSpanStart(uRLSpan);
                int spanEnd = spannableString.getSpanEnd(uRLSpan);
                spannableString.removeSpan(uRLSpan);
                spannableString.setSpan(new TextCellView$prepareClickableElements$1$1(this, uRLSpan.getURL()), spanStart, spanEnd, 0);
            }
        }
    }
}
