package zendesk.ui.android.conversation.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.internal.ViewKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0011H\u0016R\u000e\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\t8\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lzendesk/ui/android/conversation/form/FormResponseView;", "Landroid/widget/LinearLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/form/FormResponseRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "rendering", "spacing", "render", "", "renderingUpdate", "Lkotlin/Function1;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormResponseView.kt */
public final class FormResponseView extends LinearLayout implements Renderer<FormResponseRendering> {
    private FormResponseRendering rendering;
    private final int spacing;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FormResponseView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FormResponseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FormResponseView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FormResponseView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FormResponseView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new FormResponseRendering();
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.zuia_spacing_xsmall);
        this.spacing = dimensionPixelOffset;
        View view = this;
        view.setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        setClipChildren(true);
        setOrientation(1);
        ViewKt.outlinedBoxBackground$default(view, 0, 0.0f, 0.0f, 7, (Object) null);
        render(AnonymousClass1.INSTANCE);
    }

    public void render(Function1<? super FormResponseRendering, FormResponseRendering> function1) {
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        this.rendering = function1.invoke(this.rendering);
        removeAllViews();
        for (FieldResponse formResponseView$render$1$1 : this.rendering.getState$zendesk_ui_ui_android().getFieldResponses$zendesk_ui_ui_android()) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FieldResponseView fieldResponseView = new FieldResponseView(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
            fieldResponseView.render(new FormResponseView$render$1$1(formResponseView$render$1$1));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int i = this.spacing;
            layoutParams.setMargins(i, i, i, i);
            Unit unit = Unit.INSTANCE;
            addView(fieldResponseView, layoutParams);
        }
    }
}
