package zendesk.ui.android.conversation.form;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"zendesk/ui/android/conversation/form/FormButtonView$animationLoopCallback$1", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "onAnimationEnd", "", "drawable", "Landroid/graphics/drawable/Drawable;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormButtonView.kt */
public final class FormButtonView$animationLoopCallback$1 extends Animatable2Compat.AnimationCallback {
    final /* synthetic */ FormButtonView this$0;

    FormButtonView$animationLoopCallback$1(FormButtonView formButtonView) {
        this.this$0 = formButtonView;
    }

    /* access modifiers changed from: private */
    /* renamed from: onAnimationEnd$lambda-0  reason: not valid java name */
    public static final void m2788onAnimationEnd$lambda0(FormButtonView formButtonView) {
        Intrinsics.checkNotNullParameter(formButtonView, "this$0");
        AnimatedVectorDrawableCompat access$getLoadingAnimation$p = formButtonView.loadingAnimation;
        if (access$getLoadingAnimation$p != null) {
            access$getLoadingAnimation$p.start();
        }
    }

    public void onAnimationEnd(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (this.this$0.rendering.getState$zendesk_ui_ui_android().isLoading$zendesk_ui_ui_android()) {
            new FormButtonView$animationLoopCallback$1$$ExternalSyntheticLambda0(this.this$0).run();
        }
    }
}
