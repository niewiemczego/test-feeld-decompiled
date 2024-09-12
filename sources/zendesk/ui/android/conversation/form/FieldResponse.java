package zendesk.ui.android.conversation.form;

import io.sentry.protocol.Response;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lzendesk/ui/android/conversation/form/FieldResponse;", "", "label", "", "response", "(Ljava/lang/String;Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getResponse", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FieldResponse.kt */
public final class FieldResponse {
    private final String label;
    private final String response;

    public static /* synthetic */ FieldResponse copy$default(FieldResponse fieldResponse, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fieldResponse.label;
        }
        if ((i & 2) != 0) {
            str2 = fieldResponse.response;
        }
        return fieldResponse.copy(str, str2);
    }

    public final String component1() {
        return this.label;
    }

    public final String component2() {
        return this.response;
    }

    public final FieldResponse copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "label");
        Intrinsics.checkNotNullParameter(str2, Response.TYPE);
        return new FieldResponse(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldResponse)) {
            return false;
        }
        FieldResponse fieldResponse = (FieldResponse) obj;
        return Intrinsics.areEqual((Object) this.label, (Object) fieldResponse.label) && Intrinsics.areEqual((Object) this.response, (Object) fieldResponse.response);
    }

    public int hashCode() {
        return (this.label.hashCode() * 31) + this.response.hashCode();
    }

    public String toString() {
        return "FieldResponse(label=" + this.label + ", response=" + this.response + ')';
    }

    public FieldResponse(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "label");
        Intrinsics.checkNotNullParameter(str2, Response.TYPE);
        this.label = str;
        this.response = str2;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getResponse() {
        return this.response;
    }
}
