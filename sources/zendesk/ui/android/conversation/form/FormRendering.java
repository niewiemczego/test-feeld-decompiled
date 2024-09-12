package zendesk.ui.android.conversation.form;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u00013B¡\u0001\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\n0\t\u0012\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\n0\t\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\t\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\t\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\u0010\u0013J\u000e\u0010\u001f\u001a\u00020\u0004HÀ\u0003¢\u0006\u0002\b J\u001a\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006HÀ\u0003¢\u0006\u0002\b\"J \u0010#\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\n0\tHÀ\u0003¢\u0006\u0002\b$J \u0010%\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\n0\tHÀ\u0003¢\u0006\u0002\b&J\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\tHÀ\u0003¢\u0006\u0002\b(J\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\tHÀ\u0003¢\u0006\u0002\b*J\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0011HÀ\u0003¢\u0006\u0002\b,J©\u0001\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00062\u001a\b\u0002\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\n0\t2\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\n0\t2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\t2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\t2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0011HÆ\u0001J\u0013\u0010.\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u00100\u001a\u00020\u0012HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R \u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R&\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R&\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00064"}, d2 = {"Lzendesk/ui/android/conversation/form/FormRendering;", "T", "", "state", "Lzendesk/ui/android/conversation/form/FormState;", "fieldRenderings", "", "Lzendesk/ui/android/conversation/form/FieldRendering;", "onFormCompleted", "Lkotlin/Function1;", "", "onFormChanged", "onFormFocusChanged", "", "onFormDisplayedFieldsChanged", "Lzendesk/ui/android/conversation/form/DisplayedField;", "mapOfDisplayedFields", "", "", "(Lzendesk/ui/android/conversation/form/FormState;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/util/Map;)V", "getFieldRenderings$zendesk_ui_ui_android", "()Ljava/util/List;", "getMapOfDisplayedFields$zendesk_ui_ui_android", "()Ljava/util/Map;", "getOnFormChanged$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function1;", "getOnFormCompleted$zendesk_ui_ui_android", "getOnFormDisplayedFieldsChanged$zendesk_ui_ui_android", "getOnFormFocusChanged$zendesk_ui_ui_android", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/form/FormState;", "component1", "component1$zendesk_ui_ui_android", "component2", "component2$zendesk_ui_ui_android", "component3", "component3$zendesk_ui_ui_android", "component4", "component4$zendesk_ui_ui_android", "component5", "component5$zendesk_ui_ui_android", "component6", "component6$zendesk_ui_ui_android", "component7", "component7$zendesk_ui_ui_android", "copy", "equals", "other", "hashCode", "toString", "", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormRendering.kt */
public final class FormRendering<T> {
    private final List<FieldRendering<T>> fieldRenderings;
    private final Map<Integer, DisplayedField> mapOfDisplayedFields;
    private final Function1<List<? extends T>, Unit> onFormChanged;
    private final Function1<List<? extends T>, Unit> onFormCompleted;
    private final Function1<DisplayedField, Unit> onFormDisplayedFieldsChanged;
    private final Function1<Boolean, Unit> onFormFocusChanged;
    private final FormState state;

    public FormRendering() {
        this((FormState) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Map) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FormRendering copy$default(FormRendering formRendering, FormState formState, List<FieldRendering<T>> list, Function1<List<? extends T>, Unit> function1, Function1<List<? extends T>, Unit> function12, Function1<Boolean, Unit> function13, Function1<DisplayedField, Unit> function14, Map<Integer, DisplayedField> map, int i, Object obj) {
        if ((i & 1) != 0) {
            formState = formRendering.state;
        }
        if ((i & 2) != 0) {
            list = formRendering.fieldRenderings;
        }
        List<FieldRendering<T>> list2 = list;
        if ((i & 4) != 0) {
            function1 = formRendering.onFormCompleted;
        }
        Function1<List<? extends T>, Unit> function15 = function1;
        if ((i & 8) != 0) {
            function12 = formRendering.onFormChanged;
        }
        Function1<List<? extends T>, Unit> function16 = function12;
        if ((i & 16) != 0) {
            function13 = formRendering.onFormFocusChanged;
        }
        Function1<Boolean, Unit> function17 = function13;
        if ((i & 32) != 0) {
            function14 = formRendering.onFormDisplayedFieldsChanged;
        }
        Function1<DisplayedField, Unit> function18 = function14;
        if ((i & 64) != 0) {
            map = formRendering.mapOfDisplayedFields;
        }
        return formRendering.copy(formState, list2, function15, function16, function17, function18, map);
    }

    public final FormState component1$zendesk_ui_ui_android() {
        return this.state;
    }

    public final List<FieldRendering<T>> component2$zendesk_ui_ui_android() {
        return this.fieldRenderings;
    }

    public final Function1<List<? extends T>, Unit> component3$zendesk_ui_ui_android() {
        return this.onFormCompleted;
    }

    public final Function1<List<? extends T>, Unit> component4$zendesk_ui_ui_android() {
        return this.onFormChanged;
    }

    public final Function1<Boolean, Unit> component5$zendesk_ui_ui_android() {
        return this.onFormFocusChanged;
    }

    public final Function1<DisplayedField, Unit> component6$zendesk_ui_ui_android() {
        return this.onFormDisplayedFieldsChanged;
    }

    public final Map<Integer, DisplayedField> component7$zendesk_ui_ui_android() {
        return this.mapOfDisplayedFields;
    }

    public final FormRendering<T> copy(FormState formState, List<? extends FieldRendering<T>> list, Function1<? super List<? extends T>, Unit> function1, Function1<? super List<? extends T>, Unit> function12, Function1<? super Boolean, Unit> function13, Function1<? super DisplayedField, Unit> function14, Map<Integer, DisplayedField> map) {
        Intrinsics.checkNotNullParameter(formState, "state");
        Intrinsics.checkNotNullParameter(list, "fieldRenderings");
        Intrinsics.checkNotNullParameter(function1, "onFormCompleted");
        Intrinsics.checkNotNullParameter(function12, "onFormChanged");
        Intrinsics.checkNotNullParameter(function13, "onFormFocusChanged");
        Intrinsics.checkNotNullParameter(function14, "onFormDisplayedFieldsChanged");
        Map<Integer, DisplayedField> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "mapOfDisplayedFields");
        return new FormRendering(formState, list, function1, function12, function13, function14, map2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormRendering)) {
            return false;
        }
        FormRendering formRendering = (FormRendering) obj;
        return Intrinsics.areEqual((Object) this.state, (Object) formRendering.state) && Intrinsics.areEqual((Object) this.fieldRenderings, (Object) formRendering.fieldRenderings) && Intrinsics.areEqual((Object) this.onFormCompleted, (Object) formRendering.onFormCompleted) && Intrinsics.areEqual((Object) this.onFormChanged, (Object) formRendering.onFormChanged) && Intrinsics.areEqual((Object) this.onFormFocusChanged, (Object) formRendering.onFormFocusChanged) && Intrinsics.areEqual((Object) this.onFormDisplayedFieldsChanged, (Object) formRendering.onFormDisplayedFieldsChanged) && Intrinsics.areEqual((Object) this.mapOfDisplayedFields, (Object) formRendering.mapOfDisplayedFields);
    }

    public int hashCode() {
        return (((((((((((this.state.hashCode() * 31) + this.fieldRenderings.hashCode()) * 31) + this.onFormCompleted.hashCode()) * 31) + this.onFormChanged.hashCode()) * 31) + this.onFormFocusChanged.hashCode()) * 31) + this.onFormDisplayedFieldsChanged.hashCode()) * 31) + this.mapOfDisplayedFields.hashCode();
    }

    public String toString() {
        return "FormRendering(state=" + this.state + ", fieldRenderings=" + this.fieldRenderings + ", onFormCompleted=" + this.onFormCompleted + ", onFormChanged=" + this.onFormChanged + ", onFormFocusChanged=" + this.onFormFocusChanged + ", onFormDisplayedFieldsChanged=" + this.onFormDisplayedFieldsChanged + ", mapOfDisplayedFields=" + this.mapOfDisplayedFields + ')';
    }

    public FormRendering(FormState formState, List<? extends FieldRendering<T>> list, Function1<? super List<? extends T>, Unit> function1, Function1<? super List<? extends T>, Unit> function12, Function1<? super Boolean, Unit> function13, Function1<? super DisplayedField, Unit> function14, Map<Integer, DisplayedField> map) {
        Intrinsics.checkNotNullParameter(formState, "state");
        Intrinsics.checkNotNullParameter(list, "fieldRenderings");
        Intrinsics.checkNotNullParameter(function1, "onFormCompleted");
        Intrinsics.checkNotNullParameter(function12, "onFormChanged");
        Intrinsics.checkNotNullParameter(function13, "onFormFocusChanged");
        Intrinsics.checkNotNullParameter(function14, "onFormDisplayedFieldsChanged");
        Intrinsics.checkNotNullParameter(map, "mapOfDisplayedFields");
        this.state = formState;
        this.fieldRenderings = list;
        this.onFormCompleted = function1;
        this.onFormChanged = function12;
        this.onFormFocusChanged = function13;
        this.onFormDisplayedFieldsChanged = function14;
        this.mapOfDisplayedFields = map;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FormRendering(zendesk.ui.android.conversation.form.FormState r8, java.util.List r9, kotlin.jvm.functions.Function1 r10, kotlin.jvm.functions.Function1 r11, kotlin.jvm.functions.Function1 r12, kotlin.jvm.functions.Function1 r13, java.util.Map r14, int r15, kotlin.jvm.internal.DefaultConstructorMarker r16) {
        /*
            r7 = this;
            r0 = r15 & 1
            if (r0 == 0) goto L_0x000d
            zendesk.ui.android.conversation.form.FormState r0 = new zendesk.ui.android.conversation.form.FormState
            r1 = 0
            r2 = 3
            r3 = 0
            r0.<init>(r3, r1, r2, r3)
            goto L_0x000e
        L_0x000d:
            r0 = r8
        L_0x000e:
            r1 = r15 & 2
            if (r1 == 0) goto L_0x0017
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0018
        L_0x0017:
            r1 = r9
        L_0x0018:
            r2 = r15 & 4
            if (r2 == 0) goto L_0x0021
            zendesk.ui.android.conversation.form.FormRendering$1 r2 = zendesk.ui.android.conversation.form.FormRendering.AnonymousClass1.INSTANCE
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            goto L_0x0022
        L_0x0021:
            r2 = r10
        L_0x0022:
            r3 = r15 & 8
            if (r3 == 0) goto L_0x002b
            zendesk.ui.android.conversation.form.FormRendering$2 r3 = zendesk.ui.android.conversation.form.FormRendering.AnonymousClass2.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            goto L_0x002c
        L_0x002b:
            r3 = r11
        L_0x002c:
            r4 = r15 & 16
            if (r4 == 0) goto L_0x0035
            zendesk.ui.android.conversation.form.FormRendering$3 r4 = zendesk.ui.android.conversation.form.FormRendering.AnonymousClass3.INSTANCE
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            goto L_0x0036
        L_0x0035:
            r4 = r12
        L_0x0036:
            r5 = r15 & 32
            if (r5 == 0) goto L_0x003f
            zendesk.ui.android.conversation.form.FormRendering$4 r5 = zendesk.ui.android.conversation.form.FormRendering.AnonymousClass4.INSTANCE
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            goto L_0x0040
        L_0x003f:
            r5 = r13
        L_0x0040:
            r6 = r15 & 64
            if (r6 == 0) goto L_0x004c
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.util.Map r6 = (java.util.Map) r6
            goto L_0x004d
        L_0x004c:
            r6 = r14
        L_0x004d:
            r8 = r7
            r9 = r0
            r10 = r1
            r11 = r2
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.ui.android.conversation.form.FormRendering.<init>(zendesk.ui.android.conversation.form.FormState, java.util.List, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final FormState getState$zendesk_ui_ui_android() {
        return this.state;
    }

    public final List<FieldRendering<T>> getFieldRenderings$zendesk_ui_ui_android() {
        return this.fieldRenderings;
    }

    public final Function1<List<? extends T>, Unit> getOnFormCompleted$zendesk_ui_ui_android() {
        return this.onFormCompleted;
    }

    public final Function1<List<? extends T>, Unit> getOnFormChanged$zendesk_ui_ui_android() {
        return this.onFormChanged;
    }

    public final Function1<Boolean, Unit> getOnFormFocusChanged$zendesk_ui_ui_android() {
        return this.onFormFocusChanged;
    }

    public final Function1<DisplayedField, Unit> getOnFormDisplayedFieldsChanged$zendesk_ui_ui_android() {
        return this.onFormDisplayedFieldsChanged;
    }

    public final Map<Integer, DisplayedField> getMapOfDisplayedFields$zendesk_ui_ui_android() {
        return this.mapOfDisplayedFields;
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005J1\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u001e\u0010\u0007\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00010\t0\b\"\b\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0002\u0010\nJ \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t0\u000bJ \u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rJ&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00020\u00120\u0011J&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0018\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00020\u00120\u0011J \u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\u0011J \u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u0011J \u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u0011R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lzendesk/ui/android/conversation/form/FormRendering$Builder;", "T", "", "()V", "rendering", "Lzendesk/ui/android/conversation/form/FormRendering;", "build", "fieldRenderings", "", "Lzendesk/ui/android/conversation/form/FieldRendering;", "([Lzendesk/ui/android/conversation/form/FieldRendering;)Lzendesk/ui/android/conversation/form/FormRendering$Builder;", "", "mapOfDisplayedFields", "", "", "Lzendesk/ui/android/conversation/form/DisplayedField;", "onFormChanged", "Lkotlin/Function1;", "", "onFormCompleted", "onFormDisplayedFieldsChanged", "onFormFocusChanged", "", "state", "stateUpdate", "Lzendesk/ui/android/conversation/form/FormState;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FormRendering.kt */
    public static final class Builder<T> {
        private FormRendering<T> rendering = new FormRendering((FormState) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Map) null, 127, (DefaultConstructorMarker) null);

        public final Builder<T> state(Function1<? super FormState, FormState> function1) {
            Intrinsics.checkNotNullParameter(function1, "stateUpdate");
            Builder builder = this;
            FormRendering<T> formRendering = this.rendering;
            this.rendering = FormRendering.copy$default(formRendering, function1.invoke(formRendering.getState$zendesk_ui_ui_android()), (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Map) null, 126, (Object) null);
            return this;
        }

        public final Builder<T> fieldRenderings(List<? extends FieldRendering<T>> list) {
            Intrinsics.checkNotNullParameter(list, "fieldRenderings");
            Builder builder = this;
            this.rendering = FormRendering.copy$default(this.rendering, (FormState) null, CollectionsKt.toList(list), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Map) null, 125, (Object) null);
            return this;
        }

        public final Builder<T> fieldRenderings(FieldRendering<T>... fieldRenderingArr) {
            Intrinsics.checkNotNullParameter(fieldRenderingArr, "fieldRenderings");
            Builder builder = this;
            this.rendering = FormRendering.copy$default(this.rendering, (FormState) null, ArraysKt.toList((T[]) fieldRenderingArr), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Map) null, 125, (Object) null);
            return this;
        }

        public final Builder<T> onFormCompleted(Function1<? super List<? extends T>, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onFormCompleted");
            Builder builder = this;
            this.rendering = FormRendering.copy$default(this.rendering, (FormState) null, (List) null, function1, (Function1) null, (Function1) null, (Function1) null, (Map) null, 123, (Object) null);
            return this;
        }

        public final Builder<T> onFormChanged(Function1<? super List<? extends T>, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onFormChanged");
            Builder builder = this;
            this.rendering = FormRendering.copy$default(this.rendering, (FormState) null, (List) null, (Function1) null, function1, (Function1) null, (Function1) null, (Map) null, 119, (Object) null);
            return this;
        }

        public final Builder<T> onFormFocusChanged(Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onFormFocusChanged");
            Builder builder = this;
            this.rendering = FormRendering.copy$default(this.rendering, (FormState) null, (List) null, (Function1) null, (Function1) null, function1, (Function1) null, (Map) null, 111, (Object) null);
            return this;
        }

        public final Builder<T> onFormDisplayedFieldsChanged(Function1<? super DisplayedField, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onFormDisplayedFieldsChanged");
            Builder builder = this;
            this.rendering = FormRendering.copy$default(this.rendering, (FormState) null, (List) null, (Function1) null, (Function1) null, (Function1) null, function1, (Map) null, 95, (Object) null);
            return this;
        }

        public final Builder<T> mapOfDisplayedFields(Map<Integer, DisplayedField> map) {
            Intrinsics.checkNotNullParameter(map, "mapOfDisplayedFields");
            Builder builder = this;
            this.rendering = FormRendering.copy$default(this.rendering, (FormState) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, map, 63, (Object) null);
            return this;
        }

        public final FormRendering<T> build() {
            return this.rendering;
        }
    }
}
