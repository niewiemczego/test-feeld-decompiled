package zendesk.ui.android.conversation.actionbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.internal.ThrottledOnClickListenerKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fH\u0016R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lzendesk/ui/android/conversation/actionbutton/ActionButtonView;", "Lcom/google/android/material/button/MaterialButton;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/actionbutton/ActionButtonRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "rendering", "render", "", "renderingUpdate", "Lkotlin/Function1;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActionButtonView.kt */
public final class ActionButtonView extends MaterialButton implements Renderer<ActionButtonRendering> {
    /* access modifiers changed from: private */
    public ActionButtonRendering rendering;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ActionButtonView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ActionButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActionButtonView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.actionButtonStyle : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActionButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new ActionButtonRendering();
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        render(AnonymousClass1.INSTANCE);
    }

    public void render(Function1<? super ActionButtonRendering, ActionButtonRendering> function1) {
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        ActionButtonRendering invoke = function1.invoke(this.rendering);
        this.rendering = invoke;
        setText(invoke.getState$zendesk_ui_ui_android().getText$zendesk_ui_ui_android());
        Integer backgroundColor$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getBackgroundColor$zendesk_ui_ui_android();
        if (backgroundColor$zendesk_ui_ui_android != null) {
            setBackgroundColor(backgroundColor$zendesk_ui_ui_android.intValue());
        }
        Integer textColor$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getTextColor$zendesk_ui_ui_android();
        if (textColor$zendesk_ui_ui_android != null) {
            setTextColor(textColor$zendesk_ui_ui_android.intValue());
        }
        if (this.rendering.getState$zendesk_ui_ui_android().isSupported$zendesk_ui_ui_android()) {
            setOnClickListener(ThrottledOnClickListenerKt.throttledOnClickListener$default(0, new ActionButtonView$render$3(this), 1, (Object) null));
        } else {
            setClickable(false);
        }
    }
}
