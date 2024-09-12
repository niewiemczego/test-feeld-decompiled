package zendesk.ui.android.conversation.form;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.internal.ColorExtKt;
import zendesk.ui.android.internal.ThrottledOnClickListenerKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013H\u0016J\r\u0010\u0014\u001a\u00020\u0011H\u0001¢\u0006\u0002\b\u0015R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lzendesk/ui/android/conversation/form/FormButtonView;", "Lcom/google/android/material/button/MaterialButton;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/form/FormButtonRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationLoopCallback", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "loadingAnimation", "Landroidx/vectordrawable/graphics/drawable/AnimatedVectorDrawableCompat;", "rendering", "render", "", "renderingUpdate", "Lkotlin/Function1;", "stopAnimation", "stopAnimation$zendesk_ui_ui_android", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormButtonView.kt */
public final class FormButtonView extends MaterialButton implements Renderer<FormButtonRendering> {
    private final Animatable2Compat.AnimationCallback animationLoopCallback;
    /* access modifiers changed from: private */
    public final AnimatedVectorDrawableCompat loadingAnimation;
    /* access modifiers changed from: private */
    public FormButtonRendering rendering;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FormButtonView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FormButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FormButtonView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.formButtonStyle : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FormButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.loadingAnimation = AnimatedVectorDrawableCompat.create(context, R.drawable.zuia_animation_loading_juggle);
        this.animationLoopCallback = new FormButtonView$animationLoopCallback$1(this);
        this.rendering = new FormButtonRendering();
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        render(AnonymousClass1.INSTANCE);
    }

    public void render(Function1<? super FormButtonRendering, FormButtonRendering> function1) {
        CharSequence charSequence;
        int i;
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        FormButtonRendering invoke = function1.invoke(this.rendering);
        this.rendering = invoke;
        if (!invoke.getState$zendesk_ui_ui_android().isLoading$zendesk_ui_ui_android()) {
            charSequence = this.rendering.getState$zendesk_ui_ui_android().getText$zendesk_ui_ui_android();
        }
        setText(charSequence);
        setOnClickListener(ThrottledOnClickListenerKt.throttledOnClickListener$default(0, new FormButtonView$render$1(this), 1, (Object) null));
        Integer backgroundColor$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getBackgroundColor$zendesk_ui_ui_android();
        if (backgroundColor$zendesk_ui_ui_android != null) {
            i = backgroundColor$zendesk_ui_ui_android.intValue();
        } else {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            i = ColorExtKt.resolveColorAttr(context, R.attr.colorAccent);
        }
        setBackgroundColor(i);
        setClickable(!this.rendering.getState$zendesk_ui_ui_android().isLoading$zendesk_ui_ui_android());
        if (this.loadingAnimation != null) {
            if (this.rendering.getState$zendesk_ui_ui_android().isLoading$zendesk_ui_ui_android() && this.loadingAnimation.isRunning()) {
                return;
            }
            if (this.rendering.getState$zendesk_ui_ui_android().isLoading$zendesk_ui_ui_android()) {
                setMinimumWidth(getWidth());
                setTextScaleX(0.0f);
                setContentDescription(getResources().getString(R.string.zuia_accessibility_loading_label));
                setIcon(this.loadingAnimation);
                this.loadingAnimation.registerAnimationCallback(this.animationLoopCallback);
                this.loadingAnimation.start();
                return;
            }
            setMinimumWidth(0);
            setTextScaleX(1.0f);
            setContentDescription((CharSequence) null);
            setIcon((Drawable) null);
            this.loadingAnimation.setCallback((Drawable.Callback) null);
            this.loadingAnimation.stop();
        }
    }

    public final void stopAnimation$zendesk_ui_ui_android() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.loadingAnimation;
        if (animatedVectorDrawableCompat != null) {
            animatedVectorDrawableCompat.setCallback((Drawable.Callback) null);
        }
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat2 = this.loadingAnimation;
        if (animatedVectorDrawableCompat2 != null) {
            animatedVectorDrawableCompat2.stop();
        }
    }
}
