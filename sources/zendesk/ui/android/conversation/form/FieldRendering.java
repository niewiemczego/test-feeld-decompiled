package zendesk.ui.android.conversation.form;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.conversation.form.FieldState;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\f\r\u000eB\u0017\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0005\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0001\u0003\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lzendesk/ui/android/conversation/form/FieldRendering;", "T", "", "state", "Lzendesk/ui/android/conversation/form/FieldState;", "normalizedState", "(Lzendesk/ui/android/conversation/form/FieldState;Ljava/lang/Object;)V", "getNormalizedState", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getState", "()Lzendesk/ui/android/conversation/form/FieldState;", "Email", "Select", "Text", "Lzendesk/ui/android/conversation/form/FieldRendering$Text;", "Lzendesk/ui/android/conversation/form/FieldRendering$Email;", "Lzendesk/ui/android/conversation/form/FieldRendering$Select;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FieldRendering.kt */
public abstract class FieldRendering<T> {
    private final T normalizedState;
    private final FieldState state;

    public /* synthetic */ FieldRendering(FieldState fieldState, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(fieldState, obj);
    }

    private FieldRendering(FieldState fieldState, T t) {
        this.state = fieldState;
        this.normalizedState = t;
    }

    public FieldState getState() {
        return this.state;
    }

    public T getNormalizedState() {
        return this.normalizedState;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001$Bg\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\rJ\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0006HÀ\u0003¢\u0006\u0002\b\u0018J\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u0006HÀ\u0003¢\u0006\u0002\b\u001aJ\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u0006HÀ\u0003¢\u0006\u0002\b\u001cJq\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u00062\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u00062\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\tHÖ\u0001R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lzendesk/ui/android/conversation/form/FieldRendering$Text;", "T", "Lzendesk/ui/android/conversation/form/FieldRendering;", "state", "Lzendesk/ui/android/conversation/form/FieldState$Text;", "onStateChanged", "Lkotlin/Function1;", "", "onTextChanged", "", "normalize", "onFieldFocusChanged", "", "(Lzendesk/ui/android/conversation/form/FieldState$Text;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getNormalize$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function1;", "getOnFieldFocusChanged$zendesk_ui_ui_android", "getOnStateChanged", "getOnTextChanged$zendesk_ui_ui_android", "getState", "()Lzendesk/ui/android/conversation/form/FieldState$Text;", "component1", "component2", "component3", "component3$zendesk_ui_ui_android", "component4", "component4$zendesk_ui_ui_android", "component5", "component5$zendesk_ui_ui_android", "copy", "equals", "other", "", "hashCode", "", "toString", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FieldRendering.kt */
    public static final class Text<T> extends FieldRendering<T> {
        private final Function1<FieldState.Text, T> normalize;
        private final Function1<Boolean, Unit> onFieldFocusChanged;
        private final Function1<FieldState.Text, Unit> onStateChanged;
        private final Function1<String, Unit> onTextChanged;
        private final FieldState.Text state;

        public static /* synthetic */ Text copy$default(Text text, FieldState.Text text2, Function1<FieldState.Text, Unit> function1, Function1<String, Unit> function12, Function1<FieldState.Text, T> function13, Function1<Boolean, Unit> function14, int i, Object obj) {
            if ((i & 1) != 0) {
                text2 = text.getState();
            }
            if ((i & 2) != 0) {
                function1 = text.onStateChanged;
            }
            Function1<FieldState.Text, Unit> function15 = function1;
            if ((i & 4) != 0) {
                function12 = text.onTextChanged;
            }
            Function1<String, Unit> function16 = function12;
            if ((i & 8) != 0) {
                function13 = text.normalize;
            }
            Function1<FieldState.Text, T> function17 = function13;
            if ((i & 16) != 0) {
                function14 = text.onFieldFocusChanged;
            }
            return text.copy(text2, function15, function16, function17, function14);
        }

        public final FieldState.Text component1() {
            return getState();
        }

        public final Function1<FieldState.Text, Unit> component2() {
            return this.onStateChanged;
        }

        public final Function1<String, Unit> component3$zendesk_ui_ui_android() {
            return this.onTextChanged;
        }

        public final Function1<FieldState.Text, T> component4$zendesk_ui_ui_android() {
            return this.normalize;
        }

        public final Function1<Boolean, Unit> component5$zendesk_ui_ui_android() {
            return this.onFieldFocusChanged;
        }

        public final Text<T> copy(FieldState.Text text, Function1<? super FieldState.Text, Unit> function1, Function1<? super String, Unit> function12, Function1<? super FieldState.Text, ? extends T> function13, Function1<? super Boolean, Unit> function14) {
            Intrinsics.checkNotNullParameter(text, "state");
            Intrinsics.checkNotNullParameter(function1, "onStateChanged");
            Intrinsics.checkNotNullParameter(function12, "onTextChanged");
            Intrinsics.checkNotNullParameter(function13, "normalize");
            Intrinsics.checkNotNullParameter(function14, "onFieldFocusChanged");
            return new Text(text, function1, function12, function13, function14);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Text)) {
                return false;
            }
            Text text = (Text) obj;
            return Intrinsics.areEqual((Object) getState(), (Object) text.getState()) && Intrinsics.areEqual((Object) this.onStateChanged, (Object) text.onStateChanged) && Intrinsics.areEqual((Object) this.onTextChanged, (Object) text.onTextChanged) && Intrinsics.areEqual((Object) this.normalize, (Object) text.normalize) && Intrinsics.areEqual((Object) this.onFieldFocusChanged, (Object) text.onFieldFocusChanged);
        }

        public int hashCode() {
            return (((((((getState().hashCode() * 31) + this.onStateChanged.hashCode()) * 31) + this.onTextChanged.hashCode()) * 31) + this.normalize.hashCode()) * 31) + this.onFieldFocusChanged.hashCode();
        }

        public String toString() {
            return "Text(state=" + getState() + ", onStateChanged=" + this.onStateChanged + ", onTextChanged=" + this.onTextChanged + ", normalize=" + this.normalize + ", onFieldFocusChanged=" + this.onFieldFocusChanged + ')';
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Text(zendesk.ui.android.conversation.form.FieldState.Text r17, kotlin.jvm.functions.Function1 r18, kotlin.jvm.functions.Function1 r19, kotlin.jvm.functions.Function1 r20, kotlin.jvm.functions.Function1 r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
            /*
                r16 = this;
                r0 = r22 & 1
                if (r0 == 0) goto L_0x0015
                zendesk.ui.android.conversation.form.FieldState$Text r0 = new zendesk.ui.android.conversation.form.FieldState$Text
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 63
                r9 = 0
                r1 = r0
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
                r11 = r0
                goto L_0x0017
            L_0x0015:
                r11 = r17
            L_0x0017:
                r0 = r22 & 2
                if (r0 == 0) goto L_0x0021
                zendesk.ui.android.conversation.form.FieldRendering$Text$1 r0 = zendesk.ui.android.conversation.form.FieldRendering.Text.AnonymousClass1.INSTANCE
                kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
                r12 = r0
                goto L_0x0023
            L_0x0021:
                r12 = r18
            L_0x0023:
                r0 = r22 & 4
                if (r0 == 0) goto L_0x002d
                zendesk.ui.android.conversation.form.FieldRendering$Text$2 r0 = zendesk.ui.android.conversation.form.FieldRendering.Text.AnonymousClass2.INSTANCE
                kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
                r13 = r0
                goto L_0x002f
            L_0x002d:
                r13 = r19
            L_0x002f:
                r0 = r22 & 16
                if (r0 == 0) goto L_0x0039
                zendesk.ui.android.conversation.form.FieldRendering$Text$3 r0 = zendesk.ui.android.conversation.form.FieldRendering.Text.AnonymousClass3.INSTANCE
                kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
                r15 = r0
                goto L_0x003b
            L_0x0039:
                r15 = r21
            L_0x003b:
                r10 = r16
                r14 = r20
                r10.<init>(r11, r12, r13, r14, r15)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.ui.android.conversation.form.FieldRendering.Text.<init>(zendesk.ui.android.conversation.form.FieldState$Text, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public FieldState.Text getState() {
            return this.state;
        }

        public final Function1<FieldState.Text, Unit> getOnStateChanged() {
            return this.onStateChanged;
        }

        public final Function1<String, Unit> getOnTextChanged$zendesk_ui_ui_android() {
            return this.onTextChanged;
        }

        public final Function1<FieldState.Text, T> getNormalize$zendesk_ui_ui_android() {
            return this.normalize;
        }

        public final Function1<Boolean, Unit> getOnFieldFocusChanged$zendesk_ui_ui_android() {
            return this.onFieldFocusChanged;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Text(FieldState.Text text, Function1<? super FieldState.Text, Unit> function1, Function1<? super String, Unit> function12, Function1<? super FieldState.Text, ? extends T> function13, Function1<? super Boolean, Unit> function14) {
            super(text, function13.invoke(text), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(text, "state");
            Intrinsics.checkNotNullParameter(function1, "onStateChanged");
            Intrinsics.checkNotNullParameter(function12, "onTextChanged");
            Intrinsics.checkNotNullParameter(function13, "normalize");
            Intrinsics.checkNotNullParameter(function14, "onFieldFocusChanged");
            this.state = text;
            this.onStateChanged = function1;
            this.onTextChanged = function12;
            this.normalize = function13;
            this.onFieldFocusChanged = function14;
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0002\u0010\u0006J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\bJ \u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0004J \u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0004J \u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u0004J \u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lzendesk/ui/android/conversation/form/FieldRendering$Text$Builder;", "T", "", "normalize", "Lkotlin/Function1;", "Lzendesk/ui/android/conversation/form/FieldState$Text;", "(Lkotlin/jvm/functions/Function1;)V", "rendering", "Lzendesk/ui/android/conversation/form/FieldRendering$Text;", "build", "onFieldFocusChanged", "", "", "onStateChanged", "onTextChanged", "", "state", "stateUpdate", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: FieldRendering.kt */
        public static final class Builder<T> {
            private Text<T> rendering;

            public Builder(Function1<? super FieldState.Text, ? extends T> function1) {
                Intrinsics.checkNotNullParameter(function1, "normalize");
                this.rendering = new Text((FieldState.Text) null, (Function1) null, (Function1) null, function1, (Function1) null, 23, (DefaultConstructorMarker) null);
            }

            public final Builder<T> state(Function1<? super FieldState.Text, FieldState.Text> function1) {
                Intrinsics.checkNotNullParameter(function1, "stateUpdate");
                Builder builder = this;
                Text<T> text = this.rendering;
                this.rendering = Text.copy$default(text, function1.invoke(text.getState()), (Function1) null, (Function1) null, (Function1) null, (Function1) null, 30, (Object) null);
                return this;
            }

            public final Builder<T> onStateChanged(Function1<? super FieldState.Text, Unit> function1) {
                Intrinsics.checkNotNullParameter(function1, "onStateChanged");
                Builder builder = this;
                this.rendering = Text.copy$default(this.rendering, (FieldState.Text) null, function1, (Function1) null, (Function1) null, (Function1) null, 29, (Object) null);
                return this;
            }

            public final Builder<T> onFieldFocusChanged(Function1<? super Boolean, Unit> function1) {
                Intrinsics.checkNotNullParameter(function1, "onFieldFocusChanged");
                Builder builder = this;
                this.rendering = Text.copy$default(this.rendering, (FieldState.Text) null, (Function1) null, (Function1) null, (Function1) null, function1, 15, (Object) null);
                return this;
            }

            public final Builder<T> onTextChanged(Function1<? super String, Unit> function1) {
                Intrinsics.checkNotNullParameter(function1, "onTextChanged");
                Builder builder = this;
                this.rendering = Text.copy$default(this.rendering, (FieldState.Text) null, (Function1) null, function1, (Function1) null, (Function1) null, 27, (Object) null);
                return this;
            }

            public final Text<T> build() {
                return this.rendering;
            }
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001$Bg\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\rJ\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0006HÀ\u0003¢\u0006\u0002\b\u0018J\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u0006HÀ\u0003¢\u0006\u0002\b\u001aJ\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u0006HÀ\u0003¢\u0006\u0002\b\u001cJq\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u00062\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u00062\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\tHÖ\u0001R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lzendesk/ui/android/conversation/form/FieldRendering$Email;", "T", "Lzendesk/ui/android/conversation/form/FieldRendering;", "state", "Lzendesk/ui/android/conversation/form/FieldState$Email;", "onStateChanged", "Lkotlin/Function1;", "", "onEmailChanged", "", "normalize", "onFieldFocusChanged", "", "(Lzendesk/ui/android/conversation/form/FieldState$Email;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getNormalize$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function1;", "getOnEmailChanged$zendesk_ui_ui_android", "getOnFieldFocusChanged$zendesk_ui_ui_android", "getOnStateChanged", "getState", "()Lzendesk/ui/android/conversation/form/FieldState$Email;", "component1", "component2", "component3", "component3$zendesk_ui_ui_android", "component4", "component4$zendesk_ui_ui_android", "component5", "component5$zendesk_ui_ui_android", "copy", "equals", "other", "", "hashCode", "", "toString", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FieldRendering.kt */
    public static final class Email<T> extends FieldRendering<T> {
        private final Function1<FieldState.Email, T> normalize;
        private final Function1<String, Unit> onEmailChanged;
        private final Function1<Boolean, Unit> onFieldFocusChanged;
        private final Function1<FieldState.Email, Unit> onStateChanged;
        private final FieldState.Email state;

        public static /* synthetic */ Email copy$default(Email email, FieldState.Email email2, Function1<FieldState.Email, Unit> function1, Function1<String, Unit> function12, Function1<FieldState.Email, T> function13, Function1<Boolean, Unit> function14, int i, Object obj) {
            if ((i & 1) != 0) {
                email2 = email.getState();
            }
            if ((i & 2) != 0) {
                function1 = email.onStateChanged;
            }
            Function1<FieldState.Email, Unit> function15 = function1;
            if ((i & 4) != 0) {
                function12 = email.onEmailChanged;
            }
            Function1<String, Unit> function16 = function12;
            if ((i & 8) != 0) {
                function13 = email.normalize;
            }
            Function1<FieldState.Email, T> function17 = function13;
            if ((i & 16) != 0) {
                function14 = email.onFieldFocusChanged;
            }
            return email.copy(email2, function15, function16, function17, function14);
        }

        public final FieldState.Email component1() {
            return getState();
        }

        public final Function1<FieldState.Email, Unit> component2() {
            return this.onStateChanged;
        }

        public final Function1<String, Unit> component3$zendesk_ui_ui_android() {
            return this.onEmailChanged;
        }

        public final Function1<FieldState.Email, T> component4$zendesk_ui_ui_android() {
            return this.normalize;
        }

        public final Function1<Boolean, Unit> component5$zendesk_ui_ui_android() {
            return this.onFieldFocusChanged;
        }

        public final Email<T> copy(FieldState.Email email, Function1<? super FieldState.Email, Unit> function1, Function1<? super String, Unit> function12, Function1<? super FieldState.Email, ? extends T> function13, Function1<? super Boolean, Unit> function14) {
            Intrinsics.checkNotNullParameter(email, "state");
            Intrinsics.checkNotNullParameter(function1, "onStateChanged");
            Intrinsics.checkNotNullParameter(function12, "onEmailChanged");
            Intrinsics.checkNotNullParameter(function13, "normalize");
            Intrinsics.checkNotNullParameter(function14, "onFieldFocusChanged");
            return new Email(email, function1, function12, function13, function14);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Email)) {
                return false;
            }
            Email email = (Email) obj;
            return Intrinsics.areEqual((Object) getState(), (Object) email.getState()) && Intrinsics.areEqual((Object) this.onStateChanged, (Object) email.onStateChanged) && Intrinsics.areEqual((Object) this.onEmailChanged, (Object) email.onEmailChanged) && Intrinsics.areEqual((Object) this.normalize, (Object) email.normalize) && Intrinsics.areEqual((Object) this.onFieldFocusChanged, (Object) email.onFieldFocusChanged);
        }

        public int hashCode() {
            return (((((((getState().hashCode() * 31) + this.onStateChanged.hashCode()) * 31) + this.onEmailChanged.hashCode()) * 31) + this.normalize.hashCode()) * 31) + this.onFieldFocusChanged.hashCode();
        }

        public String toString() {
            return "Email(state=" + getState() + ", onStateChanged=" + this.onStateChanged + ", onEmailChanged=" + this.onEmailChanged + ", normalize=" + this.normalize + ", onFieldFocusChanged=" + this.onFieldFocusChanged + ')';
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Email(zendesk.ui.android.conversation.form.FieldState.Email r15, kotlin.jvm.functions.Function1 r16, kotlin.jvm.functions.Function1 r17, kotlin.jvm.functions.Function1 r18, kotlin.jvm.functions.Function1 r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
            /*
                r14 = this;
                r0 = r20 & 1
                if (r0 == 0) goto L_0x0013
                zendesk.ui.android.conversation.form.FieldState$Email r0 = new zendesk.ui.android.conversation.form.FieldState$Email
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 15
                r7 = 0
                r1 = r0
                r1.<init>(r2, r3, r4, r5, r6, r7)
                r9 = r0
                goto L_0x0014
            L_0x0013:
                r9 = r15
            L_0x0014:
                r0 = r20 & 2
                if (r0 == 0) goto L_0x001e
                zendesk.ui.android.conversation.form.FieldRendering$Email$1 r0 = zendesk.ui.android.conversation.form.FieldRendering.Email.AnonymousClass1.INSTANCE
                kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
                r10 = r0
                goto L_0x0020
            L_0x001e:
                r10 = r16
            L_0x0020:
                r0 = r20 & 4
                if (r0 == 0) goto L_0x002a
                zendesk.ui.android.conversation.form.FieldRendering$Email$2 r0 = zendesk.ui.android.conversation.form.FieldRendering.Email.AnonymousClass2.INSTANCE
                kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
                r11 = r0
                goto L_0x002c
            L_0x002a:
                r11 = r17
            L_0x002c:
                r0 = r20 & 16
                if (r0 == 0) goto L_0x0036
                zendesk.ui.android.conversation.form.FieldRendering$Email$3 r0 = zendesk.ui.android.conversation.form.FieldRendering.Email.AnonymousClass3.INSTANCE
                kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
                r13 = r0
                goto L_0x0038
            L_0x0036:
                r13 = r19
            L_0x0038:
                r8 = r14
                r12 = r18
                r8.<init>(r9, r10, r11, r12, r13)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.ui.android.conversation.form.FieldRendering.Email.<init>(zendesk.ui.android.conversation.form.FieldState$Email, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public FieldState.Email getState() {
            return this.state;
        }

        public final Function1<FieldState.Email, Unit> getOnStateChanged() {
            return this.onStateChanged;
        }

        public final Function1<String, Unit> getOnEmailChanged$zendesk_ui_ui_android() {
            return this.onEmailChanged;
        }

        public final Function1<FieldState.Email, T> getNormalize$zendesk_ui_ui_android() {
            return this.normalize;
        }

        public final Function1<Boolean, Unit> getOnFieldFocusChanged$zendesk_ui_ui_android() {
            return this.onFieldFocusChanged;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Email(FieldState.Email email, Function1<? super FieldState.Email, Unit> function1, Function1<? super String, Unit> function12, Function1<? super FieldState.Email, ? extends T> function13, Function1<? super Boolean, Unit> function14) {
            super(email, function13.invoke(email), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(email, "state");
            Intrinsics.checkNotNullParameter(function1, "onStateChanged");
            Intrinsics.checkNotNullParameter(function12, "onEmailChanged");
            Intrinsics.checkNotNullParameter(function13, "normalize");
            Intrinsics.checkNotNullParameter(function14, "onFieldFocusChanged");
            this.state = email;
            this.onStateChanged = function1;
            this.onEmailChanged = function12;
            this.normalize = function13;
            this.onFieldFocusChanged = function14;
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0002\u0010\u0006J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\bJ \u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0004J \u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0004J \u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\u0004J \u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lzendesk/ui/android/conversation/form/FieldRendering$Email$Builder;", "T", "", "normalize", "Lkotlin/Function1;", "Lzendesk/ui/android/conversation/form/FieldState$Email;", "(Lkotlin/jvm/functions/Function1;)V", "rendering", "Lzendesk/ui/android/conversation/form/FieldRendering$Email;", "build", "onFieldFocusChanged", "", "", "onStateChanged", "onTextChanged", "onEmailChanged", "", "state", "stateUpdate", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: FieldRendering.kt */
        public static final class Builder<T> {
            private Email<T> rendering;

            public Builder(Function1<? super FieldState.Email, ? extends T> function1) {
                Intrinsics.checkNotNullParameter(function1, "normalize");
                this.rendering = new Email((FieldState.Email) null, (Function1) null, (Function1) null, function1, (Function1) null, 23, (DefaultConstructorMarker) null);
            }

            public final Builder<T> state(Function1<? super FieldState.Email, FieldState.Email> function1) {
                Intrinsics.checkNotNullParameter(function1, "stateUpdate");
                Builder builder = this;
                Email<T> email = this.rendering;
                this.rendering = Email.copy$default(email, function1.invoke(email.getState()), (Function1) null, (Function1) null, (Function1) null, (Function1) null, 30, (Object) null);
                return this;
            }

            public final Builder<T> onStateChanged(Function1<? super FieldState.Email, Unit> function1) {
                Intrinsics.checkNotNullParameter(function1, "onStateChanged");
                Builder builder = this;
                this.rendering = Email.copy$default(this.rendering, (FieldState.Email) null, function1, (Function1) null, (Function1) null, (Function1) null, 29, (Object) null);
                return this;
            }

            public final Builder<T> onFieldFocusChanged(Function1<? super Boolean, Unit> function1) {
                Intrinsics.checkNotNullParameter(function1, "onFieldFocusChanged");
                Builder builder = this;
                this.rendering = Email.copy$default(this.rendering, (FieldState.Email) null, (Function1) null, (Function1) null, (Function1) null, function1, 15, (Object) null);
                return this;
            }

            public final Builder<T> onTextChanged(Function1<? super String, Unit> function1) {
                Intrinsics.checkNotNullParameter(function1, "onEmailChanged");
                Builder builder = this;
                this.rendering = Email.copy$default(this.rendering, (FieldState.Email) null, (Function1) null, function1, (Function1) null, (Function1) null, 27, (Object) null);
                return this;
            }

            public final Email<T> build() {
                return this.rendering;
            }
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001,B}\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\u0015\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J \u0010\u001c\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u00070\u0006HÀ\u0003¢\u0006\u0002\b\u001dJ\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u0006HÀ\u0003¢\u0006\u0002\b\u001fJ\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0006HÀ\u0003¢\u0006\u0002\b!J\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fHÀ\u0003¢\u0006\u0002\b#J\u0001\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\u001a\b\u0002\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u00070\u00062\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u00062\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fHÆ\u0001J\u0013\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R&\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006-"}, d2 = {"Lzendesk/ui/android/conversation/form/FieldRendering$Select;", "T", "Lzendesk/ui/android/conversation/form/FieldRendering;", "state", "Lzendesk/ui/android/conversation/form/FieldState$Select;", "onStateChanged", "Lkotlin/Function1;", "", "onSelected", "", "Lzendesk/ui/android/conversation/form/SelectOption;", "normalize", "onFieldFocusChanged", "", "onCheckMarkPressed", "Lkotlin/Function0;", "(Lzendesk/ui/android/conversation/form/FieldState$Select;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getNormalize$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function1;", "getOnCheckMarkPressed$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function0;", "getOnFieldFocusChanged$zendesk_ui_ui_android", "getOnSelected$zendesk_ui_ui_android", "getOnStateChanged", "getState", "()Lzendesk/ui/android/conversation/form/FieldState$Select;", "component1", "component2", "component3", "component3$zendesk_ui_ui_android", "component4", "component4$zendesk_ui_ui_android", "component5", "component5$zendesk_ui_ui_android", "component6", "component6$zendesk_ui_ui_android", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FieldRendering.kt */
    public static final class Select<T> extends FieldRendering<T> {
        private final Function1<FieldState.Select, T> normalize;
        private final Function0<Unit> onCheckMarkPressed;
        private final Function1<Boolean, Unit> onFieldFocusChanged;
        private final Function1<List<SelectOption>, Unit> onSelected;
        private final Function1<FieldState.Select, Unit> onStateChanged;
        private final FieldState.Select state;

        public static /* synthetic */ Select copy$default(Select select, FieldState.Select select2, Function1<FieldState.Select, Unit> function1, Function1<List<SelectOption>, Unit> function12, Function1<FieldState.Select, T> function13, Function1<Boolean, Unit> function14, Function0<Unit> function0, int i, Object obj) {
            if ((i & 1) != 0) {
                select2 = select.getState();
            }
            if ((i & 2) != 0) {
                function1 = select.onStateChanged;
            }
            Function1<FieldState.Select, Unit> function15 = function1;
            if ((i & 4) != 0) {
                function12 = select.onSelected;
            }
            Function1<List<SelectOption>, Unit> function16 = function12;
            if ((i & 8) != 0) {
                function13 = select.normalize;
            }
            Function1<FieldState.Select, T> function17 = function13;
            if ((i & 16) != 0) {
                function14 = select.onFieldFocusChanged;
            }
            Function1<Boolean, Unit> function18 = function14;
            if ((i & 32) != 0) {
                function0 = select.onCheckMarkPressed;
            }
            return select.copy(select2, function15, function16, function17, function18, function0);
        }

        public final FieldState.Select component1() {
            return getState();
        }

        public final Function1<FieldState.Select, Unit> component2() {
            return this.onStateChanged;
        }

        public final Function1<List<SelectOption>, Unit> component3$zendesk_ui_ui_android() {
            return this.onSelected;
        }

        public final Function1<FieldState.Select, T> component4$zendesk_ui_ui_android() {
            return this.normalize;
        }

        public final Function1<Boolean, Unit> component5$zendesk_ui_ui_android() {
            return this.onFieldFocusChanged;
        }

        public final Function0<Unit> component6$zendesk_ui_ui_android() {
            return this.onCheckMarkPressed;
        }

        public final Select<T> copy(FieldState.Select select, Function1<? super FieldState.Select, Unit> function1, Function1<? super List<SelectOption>, Unit> function12, Function1<? super FieldState.Select, ? extends T> function13, Function1<? super Boolean, Unit> function14, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(select, "state");
            Intrinsics.checkNotNullParameter(function1, "onStateChanged");
            Intrinsics.checkNotNullParameter(function12, "onSelected");
            Intrinsics.checkNotNullParameter(function13, "normalize");
            Intrinsics.checkNotNullParameter(function14, "onFieldFocusChanged");
            Intrinsics.checkNotNullParameter(function0, "onCheckMarkPressed");
            return new Select(select, function1, function12, function13, function14, function0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Select)) {
                return false;
            }
            Select select = (Select) obj;
            return Intrinsics.areEqual((Object) getState(), (Object) select.getState()) && Intrinsics.areEqual((Object) this.onStateChanged, (Object) select.onStateChanged) && Intrinsics.areEqual((Object) this.onSelected, (Object) select.onSelected) && Intrinsics.areEqual((Object) this.normalize, (Object) select.normalize) && Intrinsics.areEqual((Object) this.onFieldFocusChanged, (Object) select.onFieldFocusChanged) && Intrinsics.areEqual((Object) this.onCheckMarkPressed, (Object) select.onCheckMarkPressed);
        }

        public int hashCode() {
            return (((((((((getState().hashCode() * 31) + this.onStateChanged.hashCode()) * 31) + this.onSelected.hashCode()) * 31) + this.normalize.hashCode()) * 31) + this.onFieldFocusChanged.hashCode()) * 31) + this.onCheckMarkPressed.hashCode();
        }

        public String toString() {
            return "Select(state=" + getState() + ", onStateChanged=" + this.onStateChanged + ", onSelected=" + this.onSelected + ", normalize=" + this.normalize + ", onFieldFocusChanged=" + this.onFieldFocusChanged + ", onCheckMarkPressed=" + this.onCheckMarkPressed + ')';
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Select(zendesk.ui.android.conversation.form.FieldState.Select r17, kotlin.jvm.functions.Function1 r18, kotlin.jvm.functions.Function1 r19, kotlin.jvm.functions.Function1 r20, kotlin.jvm.functions.Function1 r21, kotlin.jvm.functions.Function0 r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
            /*
                r16 = this;
                r0 = r23 & 1
                if (r0 == 0) goto L_0x0014
                zendesk.ui.android.conversation.form.FieldState$Select r0 = new zendesk.ui.android.conversation.form.FieldState$Select
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 31
                r8 = 0
                r1 = r0
                r1.<init>(r2, r3, r4, r5, r6, r7, r8)
                r10 = r0
                goto L_0x0016
            L_0x0014:
                r10 = r17
            L_0x0016:
                r0 = r23 & 2
                if (r0 == 0) goto L_0x0020
                zendesk.ui.android.conversation.form.FieldRendering$Select$1 r0 = zendesk.ui.android.conversation.form.FieldRendering.Select.AnonymousClass1.INSTANCE
                kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
                r11 = r0
                goto L_0x0022
            L_0x0020:
                r11 = r18
            L_0x0022:
                r0 = r23 & 4
                if (r0 == 0) goto L_0x002c
                zendesk.ui.android.conversation.form.FieldRendering$Select$2 r0 = zendesk.ui.android.conversation.form.FieldRendering.Select.AnonymousClass2.INSTANCE
                kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
                r12 = r0
                goto L_0x002e
            L_0x002c:
                r12 = r19
            L_0x002e:
                r0 = r23 & 16
                if (r0 == 0) goto L_0x0038
                zendesk.ui.android.conversation.form.FieldRendering$Select$3 r0 = zendesk.ui.android.conversation.form.FieldRendering.Select.AnonymousClass3.INSTANCE
                kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
                r14 = r0
                goto L_0x003a
            L_0x0038:
                r14 = r21
            L_0x003a:
                r0 = r23 & 32
                if (r0 == 0) goto L_0x0044
                zendesk.ui.android.conversation.form.FieldRendering$Select$4 r0 = zendesk.ui.android.conversation.form.FieldRendering.Select.AnonymousClass4.INSTANCE
                kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
                r15 = r0
                goto L_0x0046
            L_0x0044:
                r15 = r22
            L_0x0046:
                r9 = r16
                r13 = r20
                r9.<init>(r10, r11, r12, r13, r14, r15)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.ui.android.conversation.form.FieldRendering.Select.<init>(zendesk.ui.android.conversation.form.FieldState$Select, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public FieldState.Select getState() {
            return this.state;
        }

        public final Function1<FieldState.Select, Unit> getOnStateChanged() {
            return this.onStateChanged;
        }

        public final Function1<List<SelectOption>, Unit> getOnSelected$zendesk_ui_ui_android() {
            return this.onSelected;
        }

        public final Function1<FieldState.Select, T> getNormalize$zendesk_ui_ui_android() {
            return this.normalize;
        }

        public final Function1<Boolean, Unit> getOnFieldFocusChanged$zendesk_ui_ui_android() {
            return this.onFieldFocusChanged;
        }

        public final Function0<Unit> getOnCheckMarkPressed$zendesk_ui_ui_android() {
            return this.onCheckMarkPressed;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Select(FieldState.Select select, Function1<? super FieldState.Select, Unit> function1, Function1<? super List<SelectOption>, Unit> function12, Function1<? super FieldState.Select, ? extends T> function13, Function1<? super Boolean, Unit> function14, Function0<Unit> function0) {
            super(select, function13.invoke(select), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(select, "state");
            Intrinsics.checkNotNullParameter(function1, "onStateChanged");
            Intrinsics.checkNotNullParameter(function12, "onSelected");
            Intrinsics.checkNotNullParameter(function13, "normalize");
            Intrinsics.checkNotNullParameter(function14, "onFieldFocusChanged");
            Intrinsics.checkNotNullParameter(function0, "onCheckMarkPressed");
            this.state = select;
            this.onStateChanged = function1;
            this.onSelected = function12;
            this.normalize = function13;
            this.onFieldFocusChanged = function14;
            this.onCheckMarkPressed = function0;
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0002\u0010\u0006J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\bJ \u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0004J&\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\f0\u0004J \u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0004J \u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lzendesk/ui/android/conversation/form/FieldRendering$Select$Builder;", "T", "", "normalize", "Lkotlin/Function1;", "Lzendesk/ui/android/conversation/form/FieldState$Select;", "(Lkotlin/jvm/functions/Function1;)V", "rendering", "Lzendesk/ui/android/conversation/form/FieldRendering$Select;", "build", "onFieldFocusChanged", "", "", "onSelected", "", "Lzendesk/ui/android/conversation/form/SelectOption;", "onStateChanged", "state", "stateUpdate", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: FieldRendering.kt */
        public static final class Builder<T> {
            private Select<T> rendering;

            public Builder(Function1<? super FieldState.Select, ? extends T> function1) {
                Intrinsics.checkNotNullParameter(function1, "normalize");
                this.rendering = new Select((FieldState.Select) null, (Function1) null, (Function1) null, function1, (Function1) null, (Function0) null, 55, (DefaultConstructorMarker) null);
            }

            public final Builder<T> state(Function1<? super FieldState.Select, FieldState.Select> function1) {
                Intrinsics.checkNotNullParameter(function1, "stateUpdate");
                Builder builder = this;
                Select<T> select = this.rendering;
                this.rendering = Select.copy$default(select, function1.invoke(select.getState()), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function0) null, 62, (Object) null);
                return this;
            }

            public final Builder<T> onStateChanged(Function1<? super FieldState.Select, Unit> function1) {
                Intrinsics.checkNotNullParameter(function1, "onStateChanged");
                Builder builder = this;
                this.rendering = Select.copy$default(this.rendering, (FieldState.Select) null, function1, (Function1) null, (Function1) null, (Function1) null, (Function0) null, 61, (Object) null);
                return this;
            }

            public final Builder<T> onSelected(Function1<? super List<SelectOption>, Unit> function1) {
                Intrinsics.checkNotNullParameter(function1, "onSelected");
                Builder builder = this;
                this.rendering = Select.copy$default(this.rendering, (FieldState.Select) null, (Function1) null, function1, (Function1) null, (Function1) null, (Function0) null, 59, (Object) null);
                return this;
            }

            public final Builder<T> onFieldFocusChanged(Function1<? super Boolean, Unit> function1) {
                Intrinsics.checkNotNullParameter(function1, "onFieldFocusChanged");
                Builder builder = this;
                this.rendering = Select.copy$default(this.rendering, (FieldState.Select) null, (Function1) null, (Function1) null, (Function1) null, function1, (Function0) null, 47, (Object) null);
                return this;
            }

            public final Select<T> build() {
                return this.rendering;
            }
        }
    }
}
