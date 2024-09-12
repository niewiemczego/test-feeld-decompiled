package zendesk.ui.android.conversation.form;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.conversation.form.FieldRendering;
import zendesk.ui.android.conversation.form.FieldState;
import zendesk.ui.android.conversation.receipt.MessageReceiptView;
import zendesk.ui.android.internal.ColorExtKt;
import zendesk.ui.android.internal.Patterns;
import zendesk.ui.android.internal.ViewKt;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0014J\u0018\u0010\u001c\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0014J$\u0010\u001d\u001a\u00020\u00182\u001a\u0010\u001e\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0014\u0010$\u001a\u00020\u00182\n\u0010%\u001a\u0006\u0012\u0002\b\u00030&H\u0002J\u0014\u0010$\u001a\u00020\u00182\n\u0010%\u001a\u0006\u0012\u0002\b\u00030'H\u0002J\u0014\u0010$\u001a\u00020\u00182\n\u0010%\u001a\u0006\u0012\u0002\b\u00030(H\u0002J\b\u0010)\u001a\u00020!H\u0002J\u001a\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010.\u001a\u00020\u00182\b\b\u0002\u0010/\u001a\u00020!H\u0002J$\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\n\u0010%\u001a\u0006\u0012\u0002\b\u00030'H\u0002J\u0017\u00105\u001a\u00020!2\b\b\u0002\u00106\u001a\u00020!H\u0000¢\u0006\u0002\b7J\u0014\u00108\u001a\u00020\u0018*\u0002042\u0006\u00101\u001a\u000202H\u0002J\f\u00109\u001a\u00020\u0018*\u000204H\u0002J\u0018\u0010:\u001a\u00020\u0018*\u0006\u0012\u0002\b\u00030'2\u0006\u00101\u001a\u000202H\u0002J\u0014\u00105\u001a\u00020!*\u00020;2\u0006\u00106\u001a\u00020!H\u0002J\u0014\u00105\u001a\u00020!*\u00020<2\u0006\u00106\u001a\u00020!H\u0002J\u0014\u00105\u001a\u00020!*\u00020=2\u0006\u00106\u001a\u00020!H\u0002J\u0014\u00105\u001a\u00020!*\u00020>2\u0006\u00106\u001a\u00020!H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lzendesk/ui/android/conversation/form/FieldView;", "Landroid/widget/FrameLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/form/FieldRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "fieldInput", "Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;", "fieldLabel", "Landroid/widget/TextView;", "fieldLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "messageReceiptView", "Lzendesk/ui/android/conversation/receipt/MessageReceiptView;", "rendering", "textWatcher", "Landroid/text/TextWatcher;", "dispatchRestoreInstanceState", "", "container", "Landroid/util/SparseArray;", "Landroid/os/Parcelable;", "dispatchSaveInstanceState", "render", "renderingUpdate", "Lkotlin/Function1;", "renderError", "", "error", "", "renderFormField", "fieldRendering", "Lzendesk/ui/android/conversation/form/FieldRendering$Email;", "Lzendesk/ui/android/conversation/form/FieldRendering$Select;", "Lzendesk/ui/android/conversation/form/FieldRendering$Text;", "renderNoError", "requestFocus", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "updateBackground", "hasError", "updateInputFieldOption", "selectedOption", "Lzendesk/ui/android/conversation/form/SelectOption;", "arrayAdapter", "Lzendesk/ui/android/conversation/form/FieldInputArrayAdapter;", "validate", "includeFocus", "validate$zendesk_ui_ui_android", "updateCurrentSelectedOption", "updateInputFieldText", "updateStateOnSelection", "Lzendesk/ui/android/conversation/form/FieldState;", "Lzendesk/ui/android/conversation/form/FieldState$Email;", "Lzendesk/ui/android/conversation/form/FieldState$Select;", "Lzendesk/ui/android/conversation/form/FieldState$Text;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FieldView.kt */
public final class FieldView extends FrameLayout implements Renderer<FieldRendering<?>> {
    private final MaterialAutoCompleteTextView fieldInput;
    private final TextView fieldLabel;
    private final TextInputLayout fieldLayout;
    private final MessageReceiptView messageReceiptView;
    /* access modifiers changed from: private */
    public FieldRendering<?> rendering;
    private TextWatcher textWatcher;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FieldView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FieldView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FieldView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FieldView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FieldView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new FieldRendering.Text(new FieldState.Text((String) null, 0, 0, (String) null, (String) null, (Integer) null, 63, (DefaultConstructorMarker) null), (Function1) null, (Function1) null, FieldView$rendering$1.INSTANCE, (Function1) null, 22, (DefaultConstructorMarker) null);
        context.getTheme().applyStyle(R.style.ThemeOverlay_ZendeskComponents_Field, false);
        FrameLayout.inflate(context, R.layout.zuia_view_field, this);
        setClipToPadding(false);
        setClipChildren(false);
        View findViewById = findViewById(R.id.zuia_error_indicator);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zuia_error_indicator)");
        this.messageReceiptView = (MessageReceiptView) findViewById;
        View findViewById2 = findViewById(R.id.zuia_field_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.zuia_field_layout)");
        TextInputLayout textInputLayout = (TextInputLayout) findViewById2;
        this.fieldLayout = textInputLayout;
        textInputLayout.setBoxStrokeColorStateList(new ColorStateList(new int[][]{new int[]{16842908}, new int[]{16843623}, new int[0]}, new int[]{ColorExtKt.resolveColorAttr(context, R.attr.colorAccent), ColorExtKt.resolveColorAttr(context, R.attr.colorAccent), ColorExtKt.adjustAlpha(ColorExtKt.resolveColorAttr(context, R.attr.colorOnSurface), 0.55f)}));
        View findViewById3 = findViewById(R.id.zuia_field_label);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.zuia_field_label)");
        this.fieldLabel = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.zuia_field_input);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.zuia_field_input)");
        this.fieldInput = (MaterialAutoCompleteTextView) findViewById4;
        View findViewById5 = textInputLayout.findViewById(R.id.text_input_end_icon);
        int dimensionPixelSize = findViewById5.getResources().getDimensionPixelSize(R.dimen.zuia_control_min_size);
        findViewById5.setMinimumWidth(dimensionPixelSize);
        findViewById5.setMinimumHeight(dimensionPixelSize);
        findViewById5.requestLayout();
        this.textWatcher = null;
        render(new Function1<FieldRendering<?>, FieldRendering<?>>(this) {
            final /* synthetic */ FieldView this$0;

            {
                this.this$0 = r1;
            }

            public final FieldRendering<?> invoke(FieldRendering<?> fieldRendering) {
                Intrinsics.checkNotNullParameter(fieldRendering, "it");
                return this.this$0.rendering;
            }
        });
    }

    public boolean requestFocus(int i, Rect rect) {
        if (rect != null) {
            return this.fieldInput.requestFocus(i, rect);
        }
        return false;
    }

    public void render(Function1<? super FieldRendering<?>, ? extends FieldRendering<?>> function1) {
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        FieldRendering<?> fieldRendering = (FieldRendering) function1.invoke(this.rendering);
        this.rendering = fieldRendering;
        Integer borderColor$zendesk_ui_ui_android = fieldRendering.getState().getBorderColor$zendesk_ui_ui_android();
        if (borderColor$zendesk_ui_ui_android != null) {
            this.fieldLayout.setBoxStrokeColor(borderColor$zendesk_ui_ui_android.intValue());
        }
        this.fieldLayout.setErrorIconDrawable((Drawable) null);
        this.fieldLabel.setText(this.rendering.getState().getLabel$zendesk_ui_ui_android());
        View view = this.fieldLabel;
        CharSequence label$zendesk_ui_ui_android = this.rendering.getState().getLabel$zendesk_ui_ui_android();
        boolean z = true;
        int i = 0;
        view.setVisibility(label$zendesk_ui_ui_android == null || StringsKt.isBlank(label$zendesk_ui_ui_android) ? 8 : 0);
        this.fieldLabel.setContentDescription(getResources().getString(R.string.zuia_form_field_required_accessibility_label, new Object[]{this.fieldLabel.getText()}));
        ViewGroup.LayoutParams layoutParams = this.fieldLabel.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            CharSequence label$zendesk_ui_ui_android2 = this.rendering.getState().getLabel$zendesk_ui_ui_android();
            if (label$zendesk_ui_ui_android2 != null && !StringsKt.isBlank(label$zendesk_ui_ui_android2)) {
                z = false;
            }
            if (!z) {
                i = getResources().getDimensionPixelSize(R.dimen.zuia_spacing_xsmall);
            }
            marginLayoutParams.bottomMargin = i;
            this.fieldLabel.setLayoutParams(marginLayoutParams);
            this.fieldInput.removeTextChangedListener(this.textWatcher);
            this.fieldInput.setHint(this.rendering.getState().getPlaceholder$zendesk_ui_ui_android());
            this.fieldInput.setOnFocusChangeListener(new FieldView$$ExternalSyntheticLambda5(this));
            FieldRendering<?> fieldRendering2 = this.rendering;
            if (fieldRendering2 instanceof FieldRendering.Text) {
                renderFormField((FieldRendering.Text<?>) (FieldRendering.Text) fieldRendering2);
            } else if (fieldRendering2 instanceof FieldRendering.Email) {
                renderFormField((FieldRendering.Email<?>) (FieldRendering.Email) fieldRendering2);
            } else if (fieldRendering2 instanceof FieldRendering.Select) {
                renderFormField((FieldRendering.Select<?>) (FieldRendering.Select) fieldRendering2);
            }
            if (this.rendering instanceof FieldRendering.Select) {
                ViewKt.requestLayoutOnKeyBoardShown(this.fieldInput);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* access modifiers changed from: private */
    /* renamed from: render$lambda-2  reason: not valid java name */
    public static final void m2781render$lambda2(FieldView fieldView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(fieldView, "this$0");
        fieldView.validate(fieldView.rendering.getState(), true);
        updateBackground$default(fieldView, false, 1, (Object) null);
    }

    private final void renderFormField(FieldRendering.Select<?> select) {
        this.fieldInput.setInputType(176);
        this.fieldInput.setImeOptions(6);
        this.fieldLayout.setEndIconMode(3);
        this.fieldLayout.setEndIconCheckable(false);
        this.fieldLayout.setEndIconContentDescription((CharSequence) getResources().getString(R.string.zuia_form_dropdown_menu_accessibility_label, new Object[]{this.fieldLabel.getText()}));
        MaterialAutoCompleteTextView materialAutoCompleteTextView = this.fieldInput;
        MaterialShapeDrawable createWithElevationOverlay = MaterialShapeDrawable.createWithElevationOverlay(getContext());
        createWithElevationOverlay.setStrokeWidth(getResources().getDimension(R.dimen.zuia_divider_size));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        createWithElevationOverlay.setStrokeColor(ColorStateList.valueOf(ColorExtKt.adjustAlpha(ColorExtKt.resolveColorAttr(context, R.attr.colorOnSurface), 0.12f)));
        createWithElevationOverlay.setCornerSize(getResources().getDimension(R.dimen.zuia_message_cell_radius));
        materialAutoCompleteTextView.setDropDownBackgroundDrawable(createWithElevationOverlay);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        FieldInputArrayAdapter fieldInputArrayAdapter = new FieldInputArrayAdapter(context2, R.layout.zuia_item_field_option, select.getState().getOptions());
        this.fieldInput.setAdapter(fieldInputArrayAdapter);
        if (select.getState().getSelect().isEmpty()) {
            updateInputFieldOption(select.getState().getOptions().get(0), fieldInputArrayAdapter, select);
        } else {
            updateInputFieldOption((SelectOption) CollectionsKt.first(select.getState().getSelect()), fieldInputArrayAdapter, select);
        }
        this.fieldInput.setOnItemClickListener(new FieldView$$ExternalSyntheticLambda2(fieldInputArrayAdapter, this, select));
        this.fieldInput.setOnFocusChangeListener(new FieldView$$ExternalSyntheticLambda3(select, this, fieldInputArrayAdapter));
        this.fieldInput.setOnEditorActionListener(new FieldView$$ExternalSyntheticLambda4(this, fieldInputArrayAdapter, select));
        TextWatcher fieldView$renderFormField$$inlined$doAfterTextChanged$1 = new FieldView$renderFormField$$inlined$doAfterTextChanged$1(fieldInputArrayAdapter);
        this.fieldInput.addTextChangedListener(fieldView$renderFormField$$inlined$doAfterTextChanged$1);
        this.textWatcher = fieldView$renderFormField$$inlined$doAfterTextChanged$1;
    }

    /* access modifiers changed from: private */
    /* renamed from: renderFormField$lambda-4  reason: not valid java name */
    public static final void m2784renderFormField$lambda4(FieldInputArrayAdapter fieldInputArrayAdapter, FieldView fieldView, FieldRendering.Select select, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(fieldInputArrayAdapter, "$fieldInputAdapter");
        Intrinsics.checkNotNullParameter(fieldView, "this$0");
        Intrinsics.checkNotNullParameter(select, "$fieldRendering");
        fieldView.updateInputFieldOption(fieldInputArrayAdapter.getItem(i), fieldInputArrayAdapter, select);
    }

    /* access modifiers changed from: private */
    /* renamed from: renderFormField$lambda-5  reason: not valid java name */
    public static final void m2785renderFormField$lambda5(FieldRendering.Select select, FieldView fieldView, FieldInputArrayAdapter fieldInputArrayAdapter, View view, boolean z) {
        Intrinsics.checkNotNullParameter(select, "$fieldRendering");
        Intrinsics.checkNotNullParameter(fieldView, "this$0");
        Intrinsics.checkNotNullParameter(fieldInputArrayAdapter, "$fieldInputAdapter");
        select.getOnFieldFocusChanged$zendesk_ui_ui_android().invoke(Boolean.valueOf(z));
        fieldView.validate$zendesk_ui_ui_android(true);
        updateBackground$default(fieldView, false, 1, (Object) null);
        fieldView.updateInputFieldText(fieldInputArrayAdapter);
        if (z) {
            fieldView.fieldInput.showDropDown();
            ViewKt.requestLayoutOnKeyBoardShown(fieldView.fieldInput);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: renderFormField$lambda-6  reason: not valid java name */
    public static final boolean m2786renderFormField$lambda6(FieldView fieldView, FieldInputArrayAdapter fieldInputArrayAdapter, FieldRendering.Select select, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(fieldView, "this$0");
        Intrinsics.checkNotNullParameter(fieldInputArrayAdapter, "$fieldInputAdapter");
        Intrinsics.checkNotNullParameter(select, "$fieldRendering");
        CharSequence text = fieldView.fieldInput.getText();
        if (!(text == null || text.length() == 0) && fieldView.fieldInput.isPopupShowing() && fieldInputArrayAdapter.hasValidSuggestions$zendesk_ui_ui_android()) {
            fieldView.updateInputFieldOption(fieldInputArrayAdapter.getItem(0), fieldInputArrayAdapter, select);
        }
        select.getOnCheckMarkPressed$zendesk_ui_ui_android().invoke();
        return false;
    }

    private final void updateInputFieldOption(SelectOption selectOption, FieldInputArrayAdapter fieldInputArrayAdapter, FieldRendering.Select<?> select) {
        updateCurrentSelectedOption(fieldInputArrayAdapter, selectOption);
        updateStateOnSelection(select, selectOption);
        this.fieldInput.setText(selectOption.getLabel(), false);
        this.fieldInput.setSelection(selectOption.getLabel().length());
    }

    private final void updateStateOnSelection(FieldRendering.Select<?> select, SelectOption selectOption) {
        FieldRendering.Select copy$default = FieldRendering.Select.copy$default(select, FieldState.Select.copy$default(select.getState(), (List) null, CollectionsKt.listOf(selectOption), (String) null, (String) null, (Integer) null, 29, (Object) null), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function0) null, 62, (Object) null);
        this.rendering = copy$default;
        validate(copy$default.getState(), true);
        copy$default.getOnStateChanged().invoke(copy$default.getState());
        copy$default.getOnSelected$zendesk_ui_ui_android().invoke(copy$default.getState().getSelect());
    }

    private final void updateCurrentSelectedOption(FieldInputArrayAdapter fieldInputArrayAdapter, SelectOption selectOption) {
        fieldInputArrayAdapter.setCurrentSelectedOption$zendesk_ui_ui_android(selectOption);
        fieldInputArrayAdapter.resetInvalidTypedTextQuery$zendesk_ui_ui_android();
        fieldInputArrayAdapter.resetSuggestions$zendesk_ui_ui_android();
    }

    private final void updateInputFieldText(FieldInputArrayAdapter fieldInputArrayAdapter) {
        if (this.fieldInput.hasFocus()) {
            String invalidTypedTextQuery$zendesk_ui_ui_android = fieldInputArrayAdapter.getInvalidTypedTextQuery$zendesk_ui_ui_android();
            MaterialAutoCompleteTextView materialAutoCompleteTextView = this.fieldInput;
            if (invalidTypedTextQuery$zendesk_ui_ui_android == null) {
                invalidTypedTextQuery$zendesk_ui_ui_android = "";
            }
            materialAutoCompleteTextView.setText(invalidTypedTextQuery$zendesk_ui_ui_android, false);
            fieldInputArrayAdapter.performFilterOnInvalidTypedQuery$zendesk_ui_ui_android();
            return;
        }
        this.fieldInput.setText(fieldInputArrayAdapter.getCurrentSelectedOption$zendesk_ui_ui_android().getLabel(), false);
        fieldInputArrayAdapter.resetSuggestions$zendesk_ui_ui_android();
    }

    private final void renderFormField(FieldRendering.Text<?> text) {
        this.fieldInput.setInputType(8192);
        this.fieldInput.setText(text.getState().getText());
        this.fieldLayout.setEndIconVisible(false);
        TextWatcher fieldView$renderFormField$$inlined$doAfterTextChanged$2 = new FieldView$renderFormField$$inlined$doAfterTextChanged$2(text, this);
        this.fieldInput.addTextChangedListener(fieldView$renderFormField$$inlined$doAfterTextChanged$2);
        this.textWatcher = fieldView$renderFormField$$inlined$doAfterTextChanged$2;
        this.fieldInput.setOnFocusChangeListener(new FieldView$$ExternalSyntheticLambda0(text, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: renderFormField$lambda-11  reason: not valid java name */
    public static final void m2782renderFormField$lambda11(FieldRendering.Text text, FieldView fieldView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(text, "$fieldRendering");
        Intrinsics.checkNotNullParameter(fieldView, "this$0");
        text.getOnFieldFocusChanged$zendesk_ui_ui_android().invoke(Boolean.valueOf(z));
        updateBackground$default(fieldView, false, 1, (Object) null);
    }

    private final void renderFormField(FieldRendering.Email<?> email) {
        this.fieldInput.setInputType(33);
        this.fieldInput.setText(email.getState().getEmail());
        this.fieldLayout.setEndIconVisible(false);
        TextWatcher fieldView$renderFormField$$inlined$doAfterTextChanged$3 = new FieldView$renderFormField$$inlined$doAfterTextChanged$3(email, this);
        this.fieldInput.addTextChangedListener(fieldView$renderFormField$$inlined$doAfterTextChanged$3);
        this.textWatcher = fieldView$renderFormField$$inlined$doAfterTextChanged$3;
        this.fieldInput.setOnFocusChangeListener(new FieldView$$ExternalSyntheticLambda1(email, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: renderFormField$lambda-14  reason: not valid java name */
    public static final void m2783renderFormField$lambda14(FieldRendering.Email email, FieldView fieldView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(email, "$fieldRendering");
        Intrinsics.checkNotNullParameter(fieldView, "this$0");
        email.getOnFieldFocusChanged$zendesk_ui_ui_android().invoke(Boolean.valueOf(z));
        updateBackground$default(fieldView, false, 1, (Object) null);
    }

    static /* synthetic */ void updateBackground$default(FieldView fieldView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = !fieldView.validate$zendesk_ui_ui_android(true);
        }
        fieldView.updateBackground(z);
    }

    private final void updateBackground(boolean z) {
        int i;
        if (z) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ViewKt.outlinedBoxBackground$default(this.fieldLayout, ColorExtKt.resolveColorAttr(context, R.attr.colorError), 0.0f, 0.0f, 6, (Object) null);
        } else if (this.fieldInput.hasFocus()) {
            View view = this.fieldLayout;
            Integer borderColor$zendesk_ui_ui_android = this.rendering.getState().getBorderColor$zendesk_ui_ui_android();
            if (borderColor$zendesk_ui_ui_android != null) {
                i = borderColor$zendesk_ui_ui_android.intValue();
            } else {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                i = ColorExtKt.resolveColorAttr(context2, R.attr.colorAccent);
            }
            ViewKt.glowingBoxBackground$default(view, i, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            ViewKt.outlinedBoxBackground$default(this.fieldLayout, 0, 0.0f, 0.0f, 7, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public static /* synthetic */ boolean validate$zendesk_ui_ui_android$default(FieldView fieldView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return fieldView.validate$zendesk_ui_ui_android(z);
    }

    public final boolean validate$zendesk_ui_ui_android(boolean z) {
        return validate(this.rendering.getState(), z);
    }

    /* access modifiers changed from: private */
    public final boolean validate(FieldState fieldState, boolean z) {
        if (fieldState instanceof FieldState.Text) {
            return validate((FieldState.Text) fieldState, z);
        }
        if (fieldState instanceof FieldState.Email) {
            return validate((FieldState.Email) fieldState, z);
        }
        if (fieldState instanceof FieldState.Select) {
            return validate((FieldState.Select) fieldState, z);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean validate(FieldState.Text text, boolean z) {
        boolean hasFocus = this.fieldInput.hasFocus();
        String text2 = text.getText();
        if (text2 == null) {
            text2 = "";
        }
        int length = text2.length();
        if (length > text.getMaxLength$zendesk_ui_ui_android()) {
            String string = getResources().getString(R.string.zuia_form_field_max_character_error, new Object[]{Integer.valueOf(text.getMaxLength$zendesk_ui_ui_android())});
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…aracter_error, maxLength)");
            return renderError(string);
        } else if (z && hasFocus) {
            return renderNoError();
        } else {
            if (length == 0) {
                String string2 = getResources().getString(R.string.zuia_form_field_required_label);
                Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…orm_field_required_label)");
                return renderError(string2);
            } else if (length >= text.getMinLength$zendesk_ui_ui_android()) {
                return renderNoError();
            } else {
                String string3 = getResources().getString(R.string.zuia_form_field_min_character_error, new Object[]{Integer.valueOf(text.getMinLength$zendesk_ui_ui_android())});
                Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…aracter_error, minLength)");
                return renderError(string3);
            }
        }
    }

    private final boolean validate(FieldState.Email email, boolean z) {
        boolean hasFocus = this.fieldInput.hasFocus();
        if (z && hasFocus) {
            return renderNoError();
        }
        Regex email_regex = Patterns.INSTANCE.getEMAIL_REGEX();
        String email2 = email.getEmail();
        if (email2 == null) {
            email2 = "";
        }
        if (email_regex.matches(email2)) {
            return renderNoError();
        }
        CharSequence email3 = email.getEmail();
        if (email3 == null || StringsKt.isBlank(email3)) {
            String string = getResources().getString(R.string.zuia_form_field_required_label);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…orm_field_required_label)");
            return renderError(string);
        }
        String string2 = getResources().getString(R.string.zuia_form_field_invalid_email_error);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…ield_invalid_email_error)");
        return renderError(string2);
    }

    private final boolean validate(FieldState.Select select, boolean z) {
        boolean hasFocus = this.fieldInput.hasFocus();
        if (z && hasFocus) {
            return renderNoError();
        }
        if (!select.getSelect().isEmpty()) {
            return renderNoError();
        }
        String string = getResources().getString(R.string.zuia_form_field_required_label);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…orm_field_required_label)");
        return renderError(string);
    }

    private final boolean renderNoError() {
        this.messageReceiptView.render(FieldView$renderNoError$1.INSTANCE);
        updateBackground(false);
        return true;
    }

    private final boolean renderError(String str) {
        this.messageReceiptView.render(new FieldView$renderError$1(str));
        updateBackground(true);
        return false;
    }
}
