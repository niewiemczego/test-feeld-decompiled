package zendesk.ui.android.conversation.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lzendesk/ui/android/conversation/form/FieldResponseView;", "Landroid/widget/LinearLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/form/FieldResponseRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "itemHeader", "Landroid/widget/TextView;", "itemText", "rendering", "render", "", "renderingUpdate", "Lkotlin/Function1;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FieldResponseView.kt */
public final class FieldResponseView extends LinearLayout implements Renderer<FieldResponseRendering> {
    private final TextView itemHeader;
    private final TextView itemText;
    private FieldResponseRendering rendering;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FieldResponseView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FieldResponseView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FieldResponseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new FieldResponseRendering();
        LinearLayout.inflate(context, R.layout.zuia_view_field_response, this);
        setOrientation(1);
        View findViewById = findViewById(R.id.zuia_form_response_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zuia_form_response_title)");
        this.itemHeader = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.zuia_form_response_subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.zuia_form_response_subtitle)");
        this.itemText = (TextView) findViewById2;
        render(AnonymousClass1.INSTANCE);
    }

    public void render(Function1<? super FieldResponseRendering, FieldResponseRendering> function1) {
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        FieldResponseRendering invoke = function1.invoke(this.rendering);
        this.itemHeader.setText(invoke.getState$zendesk_ui_ui_android().getTitle$zendesk_ui_ui_android());
        this.itemText.setText(invoke.getState$zendesk_ui_ui_android().getResponse$zendesk_ui_ui_android());
        this.rendering = invoke;
    }
}
