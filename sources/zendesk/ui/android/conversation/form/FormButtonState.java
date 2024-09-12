package zendesk.ui.android.conversation.form;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u001eB'\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0010\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0011J\u000e\u0010\u0012\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÀ\u0003¢\u0006\u0004\b\u0015\u0010\nJ.\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lzendesk/ui/android/conversation/form/FormButtonState;", "", "text", "", "isLoading", "", "backgroundColor", "", "(Ljava/lang/String;ZLjava/lang/Integer;)V", "getBackgroundColor$zendesk_ui_ui_android", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "isLoading$zendesk_ui_ui_android", "()Z", "getText$zendesk_ui_ui_android", "()Ljava/lang/String;", "component1", "component1$zendesk_ui_ui_android", "component2", "component2$zendesk_ui_ui_android", "component3", "component3$zendesk_ui_ui_android", "copy", "(Ljava/lang/String;ZLjava/lang/Integer;)Lzendesk/ui/android/conversation/form/FormButtonState;", "equals", "other", "hashCode", "toBuilder", "Lzendesk/ui/android/conversation/form/FormButtonState$Builder;", "toString", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormButtonState.kt */
public final class FormButtonState {
    private final Integer backgroundColor;
    private final boolean isLoading;
    private final String text;

    public FormButtonState() {
        this((String) null, false, (Integer) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FormButtonState copy$default(FormButtonState formButtonState, String str, boolean z, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = formButtonState.text;
        }
        if ((i & 2) != 0) {
            z = formButtonState.isLoading;
        }
        if ((i & 4) != 0) {
            num = formButtonState.backgroundColor;
        }
        return formButtonState.copy(str, z, num);
    }

    public final String component1$zendesk_ui_ui_android() {
        return this.text;
    }

    public final boolean component2$zendesk_ui_ui_android() {
        return this.isLoading;
    }

    public final Integer component3$zendesk_ui_ui_android() {
        return this.backgroundColor;
    }

    public final FormButtonState copy(String str, boolean z, Integer num) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new FormButtonState(str, z, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormButtonState)) {
            return false;
        }
        FormButtonState formButtonState = (FormButtonState) obj;
        return Intrinsics.areEqual((Object) this.text, (Object) formButtonState.text) && this.isLoading == formButtonState.isLoading && Intrinsics.areEqual((Object) this.backgroundColor, (Object) formButtonState.backgroundColor);
    }

    public int hashCode() {
        int hashCode = this.text.hashCode() * 31;
        boolean z = this.isLoading;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        Integer num = this.backgroundColor;
        return i + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "FormButtonState(text=" + this.text + ", isLoading=" + this.isLoading + ", backgroundColor=" + this.backgroundColor + ')';
    }

    public FormButtonState(String str, boolean z, Integer num) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.text = str;
        this.isLoading = z;
        this.backgroundColor = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FormButtonState(String str, boolean z, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : num);
    }

    public final String getText$zendesk_ui_ui_android() {
        return this.text;
    }

    public final boolean isLoading$zendesk_ui_ui_android() {
        return this.isLoading;
    }

    public final Integer getBackgroundColor$zendesk_ui_ui_android() {
        return this.backgroundColor;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0003J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lzendesk/ui/android/conversation/form/FormButtonState$Builder;", "", "state", "Lzendesk/ui/android/conversation/form/FormButtonState;", "(Lzendesk/ui/android/conversation/form/FormButtonState;)V", "()V", "backgroundColor", "color", "", "build", "isLoading", "", "text", "", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FormButtonState.kt */
    public static final class Builder {
        private FormButtonState state;

        public Builder() {
            this.state = new FormButtonState((String) null, false, (Integer) null, 7, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(FormButtonState formButtonState) {
            this();
            Intrinsics.checkNotNullParameter(formButtonState, "state");
            this.state = formButtonState;
        }

        public final Builder text(String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            Builder builder = this;
            this.state = FormButtonState.copy$default(this.state, str, false, (Integer) null, 6, (Object) null);
            return this;
        }

        public final Builder isLoading(boolean z) {
            Builder builder = this;
            this.state = FormButtonState.copy$default(this.state, (String) null, z, (Integer) null, 5, (Object) null);
            return this;
        }

        public final Builder backgroundColor(int i) {
            Builder builder = this;
            this.state = FormButtonState.copy$default(this.state, (String) null, false, Integer.valueOf(i), 3, (Object) null);
            return this;
        }

        public final FormButtonState build() {
            return this.state;
        }
    }
}
