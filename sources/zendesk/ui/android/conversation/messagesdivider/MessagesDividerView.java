package zendesk.ui.android.conversation.messagesdivider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0015H\u0016R\u000e\u0010\f\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lzendesk/ui/android/conversation/messagesdivider/MessagesDividerView;", "Landroid/widget/FrameLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/messagesdivider/MessagesDividerRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "dividerView", "messageDivider", "Landroid/view/View;", "messageDividerText", "Landroid/widget/TextView;", "rendering", "render", "", "renderingUpdate", "Lkotlin/Function1;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessagesDividerView.kt */
public final class MessagesDividerView extends FrameLayout implements Renderer<MessagesDividerRendering> {
    private final FrameLayout dividerView;
    private final View messageDivider;
    private final TextView messageDividerText;
    private MessagesDividerRendering rendering;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MessagesDividerView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MessagesDividerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MessagesDividerView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessagesDividerView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessagesDividerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new MessagesDividerRendering();
        FrameLayout.inflate(context, R.layout.zuia_view_messages_divider, this);
        View findViewById = findViewById(R.id.zui_message_divider_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zui_message_divider_text)");
        this.messageDividerText = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.zui_divider_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.zui_divider_view)");
        this.messageDivider = findViewById2;
        View findViewById3 = findViewById(R.id.zui_message_divider);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.zui_message_divider)");
        this.dividerView = (FrameLayout) findViewById3;
        render(AnonymousClass1.INSTANCE);
    }

    public void render(Function1<? super MessagesDividerRendering, MessagesDividerRendering> function1) {
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        MessagesDividerRendering invoke = function1.invoke(this.rendering);
        this.rendering = invoke;
        this.messageDividerText.setText(invoke.getState$zendesk_ui_ui_android().getText());
        Integer textStyle = this.rendering.getState$zendesk_ui_ui_android().getTextStyle();
        if (textStyle != null) {
            TextViewCompat.setTextAppearance(this.messageDividerText, textStyle.intValue());
        }
        Integer textColor = this.rendering.getState$zendesk_ui_ui_android().getTextColor();
        if (textColor != null) {
            this.messageDividerText.setTextColor(textColor.intValue());
        }
        Integer dividerColor = this.rendering.getState$zendesk_ui_ui_android().getDividerColor();
        if (dividerColor != null) {
            this.messageDivider.setBackgroundColor(dividerColor.intValue());
        }
    }
}
