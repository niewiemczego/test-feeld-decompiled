package zendesk.ui.android.conversation.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.core.android.internal.AccessibilityExtKt;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.internal.ViewKt;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 1*\u0004\b\u0000\u0010\u00012\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003:\u00011B/\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\nH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u001e\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0$H\u0002J\u001e\u0010%\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\n2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001a0$H\u0002J(\u0010'\u001a\u00020\u001a2\u001e\u0010(\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040)H\u0016J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020 H\u0002J\b\u0010,\u001a\u00020\u001aH\u0002J\u0018\u0010-\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nH\u0002J\u0010\u0010/\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\nH\u0002J\f\u00100\u001a\u00020\u001a*\u00020\u0012H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lzendesk/ui/android/conversation/form/FormView;", "T", "Landroid/widget/FrameLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/form/FormRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "fieldCounterLabel", "Landroid/widget/TextView;", "fieldStates", "", "fieldViews", "Lzendesk/ui/android/conversation/form/FieldView;", "fieldsContainer", "Landroid/widget/LinearLayout;", "formLayout", "rendering", "submitButton", "Lzendesk/ui/android/conversation/form/FormButtonView;", "addFieldView", "", "currentIndex", "displayedField", "Lzendesk/ui/android/conversation/form/DisplayedField;", "numberOfFields", "arePreviousFieldsValid", "", "displayNextFieldView", "index", "displayFieldView", "Lkotlin/Function0;", "nextActionButtonClicked", "progressToNextFieldView", "render", "renderingUpdate", "Lkotlin/Function1;", "sendActionButtonClicked", "enableSendActionButton", "setDoneActionListener", "updateFieldCounterLabel", "size", "updateMapOfDisplayedFields", "requestViewFocus", "Companion", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormView.kt */
public final class FormView<T> extends FrameLayout implements Renderer<FormRendering<T>> {
    private static final long ACCESSIBILITY_EVENT_DELAY = 500;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final TextView fieldCounterLabel;
    /* access modifiers changed from: private */
    public final List<T> fieldStates;
    /* access modifiers changed from: private */
    public final List<FieldView> fieldViews;
    private final LinearLayout fieldsContainer;
    private final LinearLayout formLayout;
    /* access modifiers changed from: private */
    public FormRendering<T> rendering;
    private final FormButtonView submitButton;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FormView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FormView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FormView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FormView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new FormRendering((FormState) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Map) null, 127, (DefaultConstructorMarker) null);
        this.fieldStates = new ArrayList();
        this.fieldViews = new ArrayList();
        FrameLayout.inflate(context, R.layout.zuia_view_form, this);
        View findViewById = findViewById(R.id.zuia_form_fields_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zuia_form_fields_container)");
        this.fieldsContainer = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.zuia_submit_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.zuia_submit_button)");
        this.submitButton = (FormButtonView) findViewById2;
        View findViewById3 = findViewById(R.id.zuia_form_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.zuia_form_layout)");
        LinearLayout linearLayout = (LinearLayout) findViewById3;
        this.formLayout = linearLayout;
        View findViewById4 = findViewById(R.id.zuia_form_field_counter_label);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.zuia_form_field_counter_label)");
        this.fieldCounterLabel = (TextView) findViewById4;
        ViewKt.outlinedBoxBackground$default(linearLayout, 0, 0.0f, 0.0f, 7, (Object) null);
        AccessibilityExtKt.postDelayRequestFocusWhenAccessibilityRunning(linearLayout, context, 500);
    }

    public void render(Function1<? super FormRendering<T>, FormRendering<T>> function1) {
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        this.rendering = function1.invoke(this.rendering);
        this.submitButton.render(new FormView$render$1(this));
        this.fieldsContainer.removeAllViews();
        this.fieldViews.clear();
        this.fieldStates.clear();
        List<T> list = this.fieldStates;
        Iterable<FieldRendering> fieldRenderings$zendesk_ui_ui_android = this.rendering.getFieldRenderings$zendesk_ui_ui_android();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fieldRenderings$zendesk_ui_ui_android, 10));
        for (FieldRendering normalizedState : fieldRenderings$zendesk_ui_ui_android) {
            arrayList.add(normalizedState.getNormalizedState());
        }
        list.addAll((List) arrayList);
        if (this.rendering.getMapOfDisplayedFields$zendesk_ui_ui_android().isEmpty()) {
            addFieldView$default(this, 0, (DisplayedField) null, this.rendering.getFieldRenderings$zendesk_ui_ui_android().size(), 2, (Object) null);
            return;
        }
        for (Map.Entry next : this.rendering.getMapOfDisplayedFields$zendesk_ui_ui_android().entrySet()) {
            addFieldView(((DisplayedField) next.getValue()).getIndex(), (DisplayedField) next.getValue(), this.rendering.getFieldRenderings$zendesk_ui_ui_android().size());
        }
        for (FieldView validate$zendesk_ui_ui_android$default : this.fieldViews) {
            FieldView.validate$zendesk_ui_ui_android$default(validate$zendesk_ui_ui_android$default, false, 1, (Object) null);
        }
    }

    static /* synthetic */ void addFieldView$default(FormView formView, int i, DisplayedField displayedField, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            displayedField = null;
        }
        formView.addFieldView(i, displayedField, i2);
    }

    private final void addFieldView(int i, DisplayedField displayedField, int i2) {
        if (CollectionsKt.getOrNull(this.fieldViews, i) == null && i < i2) {
            int i3 = i + 1;
            boolean z = i == i2 + -1;
            LinearLayout linearLayout = this.fieldsContainer;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FieldView fieldView = new FieldView(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
            fieldView.render(new FormView$addFieldView$1$1(this, i, displayedField, i3, z, i2));
            this.fieldViews.add(fieldView);
            View view = fieldView;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.zuia_vertical_spacing_xlarge);
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(view, layoutParams);
            nextActionButtonClicked(i, new FormView$addFieldView$3(this, i3, i2));
            sendActionButtonClicked(z);
            updateFieldCounterLabel(i, i2);
            updateMapOfDisplayedFields(i);
        }
    }

    private final void nextActionButtonClicked(int i, Function0<Unit> function0) {
        EditText editText;
        FieldView fieldView = (FieldView) CollectionsKt.getOrNull(this.fieldViews, i);
        if (!(fieldView == null || (editText = (EditText) fieldView.findViewById(R.id.zuia_field_input)) == null || editText.getInputType() == 176)) {
            editText.setImeOptions(5);
            editText.setOnEditorActionListener(new FormView$$ExternalSyntheticLambda1(this, function0));
        }
        this.submitButton.render(new FormView$nextActionButtonClicked$2(this, function0));
    }

    /* access modifiers changed from: private */
    /* renamed from: nextActionButtonClicked$lambda-6$lambda-5  reason: not valid java name */
    public static final boolean m2790nextActionButtonClicked$lambda6$lambda5(FormView formView, Function0 function0, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(formView, "this$0");
        Intrinsics.checkNotNullParameter(function0, "$progressToNextFieldView");
        if (i == 5 && formView.arePreviousFieldsValid()) {
            function0.invoke();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean arePreviousFieldsValid() {
        Collection arrayList = new ArrayList();
        for (Object next : this.fieldViews) {
            if (FieldView.validate$zendesk_ui_ui_android$default((FieldView) next, false, 1, (Object) null)) {
                arrayList.add(next);
            }
        }
        return ((List) arrayList).containsAll(this.fieldViews);
    }

    private final void sendActionButtonClicked(boolean z) {
        if (z) {
            this.submitButton.render(new FormView$sendActionButtonClicked$1(this));
            setDoneActionListener();
        }
    }

    private final void setDoneActionListener() {
        EditText editText = (EditText) ((FieldView) CollectionsKt.last(this.fieldViews)).findViewById(R.id.zuia_field_input);
        if (editText.getInputType() != 176) {
            editText.setImeOptions(4);
            editText.setOnEditorActionListener(new FormView$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setDoneActionListener$lambda-9$lambda-8  reason: not valid java name */
    public static final boolean m2791setDoneActionListener$lambda9$lambda8(FormView formView, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(formView, "this$0");
        if (i != 4) {
            return false;
        }
        formView.submitButton.performClick();
        return true;
    }

    private final void updateFieldCounterLabel(int i, int i2) {
        this.fieldCounterLabel.setText(getResources().getString(R.string.zuia_form_field_counter_label, new Object[]{Integer.valueOf(i + 1), Integer.valueOf(i2)}));
    }

    /* access modifiers changed from: private */
    public final void displayNextFieldView(int i, Function0<Unit> function0) {
        function0.invoke();
        FieldView fieldView = (FieldView) CollectionsKt.getOrNull(this.fieldViews, i);
        if (fieldView != null) {
            requestViewFocus(fieldView);
        }
    }

    private final void updateMapOfDisplayedFields(int i) {
        if (this.rendering.getMapOfDisplayedFields$zendesk_ui_ui_android().get(Integer.valueOf(i)) == null) {
            this.rendering.getOnFormDisplayedFieldsChanged$zendesk_ui_ui_android().invoke(new DisplayedField(i, (String) null, 2, (DefaultConstructorMarker) null));
        }
    }

    /* access modifiers changed from: private */
    public final void requestViewFocus(FieldView fieldView) {
        EditText editText = (EditText) fieldView.findViewById(R.id.zuia_field_input);
        if (editText != null) {
            ViewKt.focusAndShowKeyboard(editText);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/ui/android/conversation/form/FormView$Companion;", "", "()V", "ACCESSIBILITY_EVENT_DELAY", "", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FormView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
