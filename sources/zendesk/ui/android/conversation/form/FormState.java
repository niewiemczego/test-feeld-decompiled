package zendesk.ui.android.conversation.form;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0019B\u001b\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0004\b\r\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u000fJ$\u0010\u0010\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lzendesk/ui/android/conversation/form/FormState;", "", "colorAccent", "", "pending", "", "(Ljava/lang/Integer;Z)V", "getColorAccent$zendesk_ui_ui_android", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPending$zendesk_ui_ui_android", "()Z", "component1", "component1$zendesk_ui_ui_android", "component2", "component2$zendesk_ui_ui_android", "copy", "(Ljava/lang/Integer;Z)Lzendesk/ui/android/conversation/form/FormState;", "equals", "other", "hashCode", "toBuilder", "Lzendesk/ui/android/conversation/form/FormState$Builder;", "toString", "", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormState.kt */
public final class FormState {
    private final Integer colorAccent;
    private final boolean pending;

    public FormState() {
        this((Integer) null, false, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FormState copy$default(FormState formState, Integer num, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            num = formState.colorAccent;
        }
        if ((i & 2) != 0) {
            z = formState.pending;
        }
        return formState.copy(num, z);
    }

    public final Integer component1$zendesk_ui_ui_android() {
        return this.colorAccent;
    }

    public final boolean component2$zendesk_ui_ui_android() {
        return this.pending;
    }

    public final FormState copy(Integer num, boolean z) {
        return new FormState(num, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormState)) {
            return false;
        }
        FormState formState = (FormState) obj;
        return Intrinsics.areEqual((Object) this.colorAccent, (Object) formState.colorAccent) && this.pending == formState.pending;
    }

    public int hashCode() {
        Integer num = this.colorAccent;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        boolean z = this.pending;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "FormState(colorAccent=" + this.colorAccent + ", pending=" + this.pending + ')';
    }

    public FormState(Integer num, boolean z) {
        this.colorAccent = num;
        this.pending = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FormState(Integer num, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? false : z);
    }

    public final Integer getColorAccent$zendesk_ui_ui_android() {
        return this.colorAccent;
    }

    public final boolean getPending$zendesk_ui_ui_android() {
        return this.pending;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lzendesk/ui/android/conversation/form/FormState$Builder;", "", "state", "Lzendesk/ui/android/conversation/form/FormState;", "(Lzendesk/ui/android/conversation/form/FormState;)V", "()V", "build", "pending", "", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FormState.kt */
    public static final class Builder {
        private FormState state;

        public Builder() {
            this.state = new FormState((Integer) null, false, 3, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(FormState formState) {
            this();
            Intrinsics.checkNotNullParameter(formState, "state");
            this.state = formState;
        }

        public final Builder pending(boolean z) {
            Builder builder = this;
            this.state = FormState.copy$default(this.state, (Integer) null, z, 1, (Object) null);
            return this;
        }

        public final FormState build() {
            return this.state;
        }
    }
}
