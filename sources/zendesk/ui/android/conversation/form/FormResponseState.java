package zendesk.ui.android.conversation.form;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0017\b\u0000\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÀ\u0003¢\u0006\u0002\b\tJ\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lzendesk/ui/android/conversation/form/FormResponseState;", "", "fieldResponses", "", "Lzendesk/ui/android/conversation/form/FieldResponse;", "(Ljava/util/List;)V", "getFieldResponses$zendesk_ui_ui_android", "()Ljava/util/List;", "component1", "component1$zendesk_ui_ui_android", "copy", "equals", "", "other", "hashCode", "", "toBuilder", "Lzendesk/ui/android/conversation/form/FormResponseState$Builder;", "toString", "", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormResponseState.kt */
public final class FormResponseState {
    private final List<FieldResponse> fieldResponses;

    public FormResponseState() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FormResponseState copy$default(FormResponseState formResponseState, List<FieldResponse> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = formResponseState.fieldResponses;
        }
        return formResponseState.copy(list);
    }

    public final List<FieldResponse> component1$zendesk_ui_ui_android() {
        return this.fieldResponses;
    }

    public final FormResponseState copy(List<FieldResponse> list) {
        Intrinsics.checkNotNullParameter(list, "fieldResponses");
        return new FormResponseState(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FormResponseState) && Intrinsics.areEqual((Object) this.fieldResponses, (Object) ((FormResponseState) obj).fieldResponses);
    }

    public int hashCode() {
        return this.fieldResponses.hashCode();
    }

    public String toString() {
        return "FormResponseState(fieldResponses=" + this.fieldResponses + ')';
    }

    public FormResponseState(List<FieldResponse> list) {
        Intrinsics.checkNotNullParameter(list, "fieldResponses");
        this.fieldResponses = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FormResponseState(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<FieldResponse> getFieldResponses$zendesk_ui_ui_android() {
        return this.fieldResponses;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0003J\u0014\u0010\u0007\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lzendesk/ui/android/conversation/form/FormResponseState$Builder;", "", "state", "Lzendesk/ui/android/conversation/form/FormResponseState;", "(Lzendesk/ui/android/conversation/form/FormResponseState;)V", "()V", "build", "fieldResponses", "", "Lzendesk/ui/android/conversation/form/FieldResponse;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FormResponseState.kt */
    public static final class Builder {
        private FormResponseState state;

        public Builder() {
            this.state = new FormResponseState((List) null, 1, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(FormResponseState formResponseState) {
            this();
            Intrinsics.checkNotNullParameter(formResponseState, "state");
            this.state = formResponseState;
        }

        public final Builder fieldResponses(List<FieldResponse> list) {
            Intrinsics.checkNotNullParameter(list, "fieldResponses");
            Builder builder = this;
            this.state = this.state.copy(list);
            return this;
        }

        public final FormResponseState build() {
            return this.state;
        }
    }
}
