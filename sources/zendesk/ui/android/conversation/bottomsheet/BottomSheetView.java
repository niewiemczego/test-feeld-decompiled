package zendesk.ui.android.conversation.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.internal.ColorExtKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u001c\u0010\u0013\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lzendesk/ui/android/conversation/bottomsheet/BottomSheetView;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/bottomsheet/BottomSheetRendering;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actionText", "Landroid/widget/TextView;", "container", "Landroid/widget/LinearLayout;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "messageText", "rendering", "clearCoroutines", "", "dismiss", "onDetachedFromWindow", "render", "renderingUpdate", "Lkotlin/Function1;", "showBottomSheet", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomSheetView.kt */
public final class BottomSheetView extends BottomSheetDialog implements Renderer<BottomSheetRendering> {
    private final TextView actionText;
    private final LinearLayout container;
    private CoroutineScope coroutineScope;
    private final TextView messageText;
    /* access modifiers changed from: private */
    public BottomSheetRendering rendering = new BottomSheetRendering();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheetView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        context.getTheme().applyStyle(R.style.ThemeOverlay_ZendeskComponents_BottomSheetStyle, false);
        setContentView(R.layout.zuia_bottom_sheet_view);
        this.container = (LinearLayout) findViewById(R.id.zuia_bottom_sheet_container);
        this.messageText = (TextView) findViewById(R.id.zuia_bottom_sheet_message_text);
        this.actionText = (TextView) findViewById(R.id.zuia_bottom_sheet_actions_text);
        render(AnonymousClass1.INSTANCE);
        setCancelable(true);
    }

    public void render(Function1<? super BottomSheetRendering, BottomSheetRendering> function1) {
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        BottomSheetRendering invoke = function1.invoke(this.rendering);
        this.rendering = invoke;
        BottomSheetState state$zendesk_ui_ui_android = invoke.getState$zendesk_ui_ui_android();
        Integer backgroundColor = state$zendesk_ui_ui_android.getBackgroundColor();
        if (backgroundColor != null) {
            i = backgroundColor.intValue();
        } else {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            i = ColorExtKt.resolveColorAttr(context, R.attr.colorPrimary);
        }
        Integer messageTextColor = state$zendesk_ui_ui_android.getMessageTextColor();
        if (messageTextColor != null) {
            i2 = messageTextColor.intValue();
        } else {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            i2 = ColorExtKt.resolveColorAttr(context2, R.attr.bottomSheetMessageTextColor);
        }
        Integer actionTextColor = state$zendesk_ui_ui_android.getActionTextColor();
        if (actionTextColor != null) {
            i3 = actionTextColor.intValue();
        } else {
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            i3 = ColorExtKt.resolveColorAttr(context3, R.attr.bottomSheetActionTextColor);
        }
        LinearLayout linearLayout = this.container;
        if (linearLayout != null) {
            linearLayout.setBackgroundColor(i);
        }
        TextView textView = this.messageText;
        if (textView != null) {
            textView.setText(state$zendesk_ui_ui_android.getMessageText$zendesk_ui_ui_android());
        }
        TextView textView2 = this.messageText;
        if (textView2 != null) {
            textView2.setTextColor(i2);
        }
        TextView textView3 = this.actionText;
        if (textView3 != null) {
            textView3.setText(state$zendesk_ui_ui_android.getActionText$zendesk_ui_ui_android());
        }
        TextView textView4 = this.actionText;
        if (textView4 != null) {
            textView4.setTextColor(i3);
        }
        TextView textView5 = this.actionText;
        if (textView5 != null) {
            textView5.setOnClickListener(new BottomSheetView$$ExternalSyntheticLambda0(this));
        }
        setOnCancelListener(new BottomSheetView$$ExternalSyntheticLambda1(this));
        if (state$zendesk_ui_ui_android.getShowBottomSheet$zendesk_ui_ui_android()) {
            showBottomSheet();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: render$lambda-2$lambda-0  reason: not valid java name */
    public static final void m2759render$lambda2$lambda0(BottomSheetView bottomSheetView, View view) {
        Intrinsics.checkNotNullParameter(bottomSheetView, "this$0");
        bottomSheetView.rendering.getOnBottomSheetActionClicked$zendesk_ui_ui_android().invoke();
        bottomSheetView.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: render$lambda-2$lambda-1  reason: not valid java name */
    public static final void m2760render$lambda2$lambda1(BottomSheetView bottomSheetView, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(bottomSheetView, "this$0");
        bottomSheetView.rendering.getOnBottomSheetDismissed$zendesk_ui_ui_android().invoke();
    }

    private final void showBottomSheet() {
        if (!isShowing()) {
            show();
            CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BottomSheetView$showBottomSheet$1$1(this, (Continuation<? super BottomSheetView$showBottomSheet$1$1>) null), 3, (Object) null);
            this.coroutineScope = CoroutineScope;
        }
    }

    private final void clearCoroutines() {
        CoroutineScope coroutineScope2 = this.coroutineScope;
        if (coroutineScope2 != null) {
            CoroutineScopeKt.cancel$default(coroutineScope2, (CancellationException) null, 1, (Object) null);
        }
        this.coroutineScope = null;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearCoroutines();
    }

    public void dismiss() {
        super.dismiss();
        clearCoroutines();
    }
}
