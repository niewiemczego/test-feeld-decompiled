package zendesk.ui.android.conversation.quickreply;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import com.google.android.material.chip.ChipGroup;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u001c\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0017H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lzendesk/ui/android/conversation/quickreply/QuickReplyView;", "Landroid/widget/FrameLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/quickreply/QuickReplyRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "quickReplyChipGroup", "Lcom/google/android/material/chip/ChipGroup;", "rendering", "addQuickReplyOption", "Landroid/view/View;", "id", "", "text", "render", "", "renderingUpdate", "Lkotlin/Function1;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: QuickReplyView.kt */
public final class QuickReplyView extends FrameLayout implements Renderer<QuickReplyRendering> {
    /* access modifiers changed from: private */
    public final ChipGroup quickReplyChipGroup;
    /* access modifiers changed from: private */
    public QuickReplyRendering rendering;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public QuickReplyView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public QuickReplyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public QuickReplyView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QuickReplyView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QuickReplyView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new QuickReplyRendering();
        FrameLayout.inflate(context, R.layout.zuia_view_quick_reply, this);
        View findViewById = findViewById(R.id.zuia_quick_reply_chip_group);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zuia_quick_reply_chip_group)");
        ChipGroup chipGroup = (ChipGroup) findViewById;
        this.quickReplyChipGroup = chipGroup;
        ViewGroup.LayoutParams layoutParams = chipGroup.getLayoutParams();
        if (layoutParams != null) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = GravityCompat.END;
            render(AnonymousClass1.INSTANCE);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public void render(Function1<? super QuickReplyRendering, QuickReplyRendering> function1) {
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        this.rendering = function1.invoke(this.rendering);
        this.quickReplyChipGroup.removeAllViews();
        for (QuickReplyOption quickReplyOption : this.rendering.getState$zendesk_ui_ui_android().getQuickReplyOptions$zendesk_ui_ui_android()) {
            this.quickReplyChipGroup.addView(addQuickReplyOption(quickReplyOption.getId(), quickReplyOption.getText()));
        }
    }

    private final View addQuickReplyOption(String str, String str2) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QuickReplyOptionView quickReplyOptionView = new QuickReplyOptionView(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        quickReplyOptionView.render(new QuickReplyView$addQuickReplyOption$1$1(str, str2, this));
        return quickReplyOptionView;
    }
}
