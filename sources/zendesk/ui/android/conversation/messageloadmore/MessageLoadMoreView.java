package zendesk.ui.android.conversation.messageloadmore;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.conversation.messageloadmore.MessageLoadMoreState;
import zendesk.ui.android.internal.ColorExtKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0018H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreView;", "Landroid/widget/FrameLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "failedRetryText", "Landroidx/appcompat/widget/AppCompatTextView;", "progressBar", "Landroid/widget/ProgressBar;", "rendering", "retryButton", "Landroidx/appcompat/widget/AppCompatImageButton;", "retryContainerView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "render", "", "renderingUpdate", "Lkotlin/Function1;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLoadMoreView.kt */
public final class MessageLoadMoreView extends FrameLayout implements Renderer<MessageLoadMoreRendering> {
    private final AppCompatTextView failedRetryText;
    private final ProgressBar progressBar;
    private MessageLoadMoreRendering rendering;
    private final AppCompatImageButton retryButton;
    private final ConstraintLayout retryContainerView;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageLoadMoreView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageLoadMoreState.MessageLoadMoreStatus.values().length];
            iArr[MessageLoadMoreState.MessageLoadMoreStatus.LOADING.ordinal()] = 1;
            iArr[MessageLoadMoreState.MessageLoadMoreStatus.FAILED.ordinal()] = 2;
            iArr[MessageLoadMoreState.MessageLoadMoreStatus.NONE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MessageLoadMoreView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MessageLoadMoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MessageLoadMoreView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageLoadMoreView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageLoadMoreView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new MessageLoadMoreRendering();
        context.getTheme().applyStyle(R.style.ThemeOverlay_ZendeskComponents_MessageLoadMoreStyle, false);
        FrameLayout.inflate(context, R.layout.zuia_view_message_load_more, this);
        View findViewById = findViewById(R.id.zuia_message_load_more_progress_indicator);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zuia_m…_more_progress_indicator)");
        this.progressBar = (ProgressBar) findViewById;
        View findViewById2 = findViewById(R.id.zuia_message_load_retry_container_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.zuia_m…oad_retry_container_view)");
        this.retryContainerView = (ConstraintLayout) findViewById2;
        View findViewById3 = findViewById(R.id.zuia_message_load_retry_label);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.zuia_message_load_retry_label)");
        this.failedRetryText = (AppCompatTextView) findViewById3;
        View findViewById4 = findViewById(R.id.zuia_message_load_retry_button);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.zuia_message_load_retry_button)");
        this.retryButton = (AppCompatImageButton) findViewById4;
        render(AnonymousClass1.INSTANCE);
    }

    public void render(Function1<? super MessageLoadMoreRendering, MessageLoadMoreRendering> function1) {
        int i;
        int i2;
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        MessageLoadMoreRendering invoke = function1.invoke(this.rendering);
        this.rendering = invoke;
        Integer progressBarColor$zendesk_ui_ui_android = invoke.getState$zendesk_ui_ui_android().getProgressBarColor$zendesk_ui_ui_android();
        if (progressBarColor$zendesk_ui_ui_android != null) {
            i = progressBarColor$zendesk_ui_ui_android.intValue();
        } else {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            i = ColorExtKt.resolveColorAttr(context, R.attr.messageLoadMoreProgressBarColor);
        }
        Integer failedRetryTextColor$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getFailedRetryTextColor$zendesk_ui_ui_android();
        if (failedRetryTextColor$zendesk_ui_ui_android != null) {
            i2 = failedRetryTextColor$zendesk_ui_ui_android.intValue();
        } else {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            i2 = ColorExtKt.resolveColorAttr(context2, R.attr.messageLoadMoreFailedRetryTextColor);
        }
        CharSequence failedRetryText$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getFailedRetryText$zendesk_ui_ui_android();
        if (failedRetryText$zendesk_ui_ui_android == null || failedRetryText$zendesk_ui_ui_android.length() == 0) {
            charSequence = getContext().getText(R.string.zuia_load_more_messages_failed_to_load);
        } else {
            charSequence = this.rendering.getState$zendesk_ui_ui_android().getFailedRetryText$zendesk_ui_ui_android();
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.rendering.getState$zendesk_ui_ui_android().getStatus$zendesk_ui_ui_android().ordinal()];
        if (i3 == 1) {
            ProgressBar progressBar2 = this.progressBar;
            if (Build.VERSION.SDK_INT >= 29) {
                progressBar2.getIndeterminateDrawable().setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(i, BlendModeCompat.SRC_ATOP));
            } else {
                progressBar2.setProgressTintList(ColorStateList.valueOf(i));
            }
            progressBar2.setVisibility(0);
            this.retryContainerView.setVisibility(8);
        } else if (i3 == 2) {
            this.failedRetryText.setTextColor(i2);
            this.failedRetryText.setText(charSequence);
            this.retryButton.getDrawable().setTint(i2);
            this.retryButton.setOnClickListener(new MessageLoadMoreView$$ExternalSyntheticLambda0(this));
            this.progressBar.setVisibility(8);
            this.retryContainerView.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: render$lambda-1  reason: not valid java name */
    public static final void m2794render$lambda1(MessageLoadMoreView messageLoadMoreView, View view) {
        Intrinsics.checkNotNullParameter(messageLoadMoreView, "this$0");
        messageLoadMoreView.rendering.getOnRetryClicked$zendesk_ui_ui_android().invoke();
    }
}
