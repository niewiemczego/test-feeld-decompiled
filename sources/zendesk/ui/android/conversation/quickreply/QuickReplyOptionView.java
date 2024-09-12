package zendesk.ui.android.conversation.quickreply;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.StateSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.internal.ColorExtKt;
import zendesk.ui.android.internal.ThrottledOnClickListenerKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001eB/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0014J\u0016\u0010\u0015\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0014J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0014H\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0014J\u001c\u0010\u0019\u001a\u00020\u00112\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\tH\u0002R\u000e\u0010\f\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionView;", "Landroid/widget/FrameLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "quickReplyOptionContainer", "quickReplyOptionTextView", "Landroid/widget/TextView;", "rendering", "dispatchRestoreInstanceState", "", "container", "Landroid/util/SparseArray;", "Landroid/os/Parcelable;", "dispatchSaveInstanceState", "onRestoreInstanceState", "state", "onSaveInstanceState", "render", "renderingUpdate", "Lkotlin/Function1;", "setupQuickReplyStateBackground", "backgroundColor", "SavedState", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: QuickReplyOptionView.kt */
public final class QuickReplyOptionView extends FrameLayout implements Renderer<QuickReplyOptionRendering> {
    private final FrameLayout quickReplyOptionContainer;
    private final TextView quickReplyOptionTextView;
    /* access modifiers changed from: private */
    public QuickReplyOptionRendering rendering;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public QuickReplyOptionView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public QuickReplyOptionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public QuickReplyOptionView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QuickReplyOptionView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QuickReplyOptionView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new QuickReplyOptionRendering();
        context.getTheme().applyStyle(R.style.ThemeOverlay_ZendeskComponents_QuickReplyOption, false);
        FrameLayout.inflate(context, R.layout.zuia_view_quick_reply_option, this);
        View findViewById = findViewById(R.id.zuia_quick_reply_options_view_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zuia_q…y_options_view_container)");
        this.quickReplyOptionContainer = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.zuia_quick_reply_options_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.zuia_quick_reply_options_view)");
        this.quickReplyOptionTextView = (TextView) findViewById2;
        render(AnonymousClass1.INSTANCE);
    }

    public void render(Function1<? super QuickReplyOptionRendering, QuickReplyOptionRendering> function1) {
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        QuickReplyOptionRendering invoke = function1.invoke(this.rendering);
        this.rendering = invoke;
        Integer color$zendesk_ui_ui_android = invoke.getState$zendesk_ui_ui_android().getColor$zendesk_ui_ui_android();
        int intValue = color$zendesk_ui_ui_android != null ? color$zendesk_ui_ui_android.intValue() : ContextCompat.getColor(getContext(), R.color.colorActionDefault);
        setupQuickReplyStateBackground(intValue);
        this.quickReplyOptionTextView.setText(this.rendering.getState$zendesk_ui_ui_android().getText$zendesk_ui_ui_android());
        this.quickReplyOptionTextView.setTextColor(intValue);
        this.quickReplyOptionContainer.setOnClickListener(ThrottledOnClickListenerKt.throttledOnClickListener$default(0, new QuickReplyOptionView$render$1(this), 1, (Object) null));
        this.quickReplyOptionContainer.setContentDescription(this.quickReplyOptionTextView.getText() + ". " + getResources().getString(R.string.zuia_quick_reply_button_accessibility_label));
        this.quickReplyOptionContainer.setOnFocusChangeListener(new QuickReplyOptionView$$ExternalSyntheticLambda0(this, intValue));
    }

    /* access modifiers changed from: private */
    /* renamed from: render$lambda-0  reason: not valid java name */
    public static final void m2796render$lambda0(QuickReplyOptionView quickReplyOptionView, int i, View view, boolean z) {
        Intrinsics.checkNotNullParameter(quickReplyOptionView, "this$0");
        if (z) {
            Drawable drawable = ContextCompat.getDrawable(quickReplyOptionView.getContext(), R.drawable.zuia_quick_reply_option_background);
            if (drawable != null) {
                GradientDrawable gradientDrawable = (GradientDrawable) drawable;
                gradientDrawable.mutate();
                gradientDrawable.setStroke(quickReplyOptionView.getResources().getDimensionPixelSize(R.dimen.zuia_message_composer_stroke_width), i);
                quickReplyOptionView.quickReplyOptionTextView.setBackground(gradientDrawable);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }
        quickReplyOptionView.setupQuickReplyStateBackground(i);
    }

    private final void setupQuickReplyStateBackground(int i) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.zuia_quick_reply_option_background);
        if (drawable != null) {
            GradientDrawable gradientDrawable = (GradientDrawable) drawable;
            gradientDrawable.setColor(ColorExtKt.adjustAlpha(i, 0.2f));
            gradientDrawable.setStroke(getResources().getDimensionPixelSize(R.dimen.zuia_quick_reply_options_width), i);
            Drawable drawable2 = gradientDrawable;
            stateListDrawable.addState(new int[]{16842912}, drawable2);
            stateListDrawable.addState(new int[]{16842919}, drawable2);
            Drawable drawable3 = ContextCompat.getDrawable(getContext(), R.drawable.zuia_quick_reply_option_background);
            if (drawable3 != null) {
                GradientDrawable gradientDrawable2 = (GradientDrawable) drawable3;
                gradientDrawable2.setColor(0);
                gradientDrawable2.setStroke(getResources().getDimensionPixelSize(R.dimen.zuia_quick_reply_options_width), i);
                stateListDrawable.addState(StateSet.WILD_CARD, gradientDrawable2);
                TextView textView = this.quickReplyOptionTextView;
                if (isSelected()) {
                    this.quickReplyOptionContainer.setEnabled(false);
                } else {
                    this.quickReplyOptionContainer.setEnabled(true);
                    drawable2 = stateListDrawable;
                }
                textView.setBackground(drawable2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.setSelected$zendesk_ui_ui_android(String.valueOf(isSelected()));
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "state");
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setSelected(Boolean.parseBoolean(savedState.isSelected$zendesk_ui_ui_android()));
            render(QuickReplyOptionView$onRestoreInstanceState$1.INSTANCE);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, TtmlNode.RUBY_CONTAINER);
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, TtmlNode.RUBY_CONTAINER);
        dispatchThawSelfOnly(sparseArray);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionView$SavedState;", "Landroid/view/View$BaseSavedState;", "superState", "Landroid/os/Parcelable;", "(Landroid/os/Parcelable;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "isSelected", "", "isSelected$zendesk_ui_ui_android", "()Ljava/lang/String;", "setSelected$zendesk_ui_ui_android", "(Ljava/lang/String;)V", "writeToParcel", "", "out", "flags", "", "Companion", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QuickReplyOptionView.kt */
    public static final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new QuickReplyOptionView$SavedState$Companion$CREATOR$1();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private String isSelected = Constants.CASEFIRST_FALSE;

        public final String isSelected$zendesk_ui_ui_android() {
            return this.isSelected;
        }

        public final void setSelected$zendesk_ui_ui_android(String str) {
            this.isSelected = str;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            Intrinsics.checkNotNullParameter(parcel, "source");
            this.isSelected = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            super.writeToParcel(parcel, i);
            parcel.writeString(this.isSelected);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002¨\u0006\u0007"}, d2 = {"Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionView$SavedState$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionView$SavedState;", "getCREATOR$annotations", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: QuickReplyOptionView.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ void getCREATOR$annotations() {
            }

            private Companion() {
            }
        }
    }
}
