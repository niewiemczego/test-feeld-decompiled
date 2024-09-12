package zendesk.ui.android.conversation.form;

import io.sentry.protocol.Response;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u001b\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\nJ\u000e\u0010\u000b\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0017"}, d2 = {"Lzendesk/ui/android/conversation/form/FieldResponseState;", "", "title", "", "response", "(Ljava/lang/String;Ljava/lang/String;)V", "getResponse$zendesk_ui_ui_android", "()Ljava/lang/String;", "getTitle$zendesk_ui_ui_android", "component1", "component1$zendesk_ui_ui_android", "component2", "component2$zendesk_ui_ui_android", "copy", "equals", "", "other", "hashCode", "", "toBuilder", "Lzendesk/ui/android/conversation/form/FieldResponseState$Builder;", "toString", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FieldResponseState.kt */
public final class FieldResponseState {
    private final String response;
    private final String title;

    public FieldResponseState() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FieldResponseState copy$default(FieldResponseState fieldResponseState, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fieldResponseState.title;
        }
        if ((i & 2) != 0) {
            str2 = fieldResponseState.response;
        }
        return fieldResponseState.copy(str, str2);
    }

    public final String component1$zendesk_ui_ui_android() {
        return this.title;
    }

    public final String component2$zendesk_ui_ui_android() {
        return this.response;
    }

    public final FieldResponseState copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, Response.TYPE);
        return new FieldResponseState(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldResponseState)) {
            return false;
        }
        FieldResponseState fieldResponseState = (FieldResponseState) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) fieldResponseState.title) && Intrinsics.areEqual((Object) this.response, (Object) fieldResponseState.response);
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.response.hashCode();
    }

    public String toString() {
        return "FieldResponseState(title=" + this.title + ", response=" + this.response + ')';
    }

    public FieldResponseState(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, Response.TYPE);
        this.title = str;
        this.response = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FieldResponseState(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final String getTitle$zendesk_ui_ui_android() {
        return this.title;
    }

    public final String getResponse$zendesk_ui_ui_android() {
        return this.response;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lzendesk/ui/android/conversation/form/FieldResponseState$Builder;", "", "state", "Lzendesk/ui/android/conversation/form/FieldResponseState;", "(Lzendesk/ui/android/conversation/form/FieldResponseState;)V", "()V", "build", "response", "", "", "title", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FieldResponseState.kt */
    public static final class Builder {
        private FieldResponseState state;

        public Builder() {
            this.state = new FieldResponseState((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(FieldResponseState fieldResponseState) {
            this();
            Intrinsics.checkNotNullParameter(fieldResponseState, "state");
            this.state = fieldResponseState;
        }

        public final void title(String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.state = FieldResponseState.copy$default(this.state, str, (String) null, 2, (Object) null);
        }

        public final void response(String str) {
            Intrinsics.checkNotNullParameter(str, Response.TYPE);
            this.state = FieldResponseState.copy$default(this.state, (String) null, str, 1, (Object) null);
        }

        public final FieldResponseState build() {
            return this.state;
        }
    }
}
