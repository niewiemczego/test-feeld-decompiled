package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lzendesk/conversationkit/android/model/FieldOption;", "", "name", "", "label", "(Ljava/lang/String;Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Field.kt */
public final class FieldOption {
    private final String label;
    private final String name;

    public static /* synthetic */ FieldOption copy$default(FieldOption fieldOption, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fieldOption.name;
        }
        if ((i & 2) != 0) {
            str2 = fieldOption.label;
        }
        return fieldOption.copy(str, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.label;
    }

    public final FieldOption copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "label");
        return new FieldOption(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldOption)) {
            return false;
        }
        FieldOption fieldOption = (FieldOption) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) fieldOption.name) && Intrinsics.areEqual((Object) this.label, (Object) fieldOption.label);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.label.hashCode();
    }

    public String toString() {
        return "FieldOption(name=" + this.name + ", label=" + this.label + ')';
    }

    public FieldOption(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "label");
        this.name = str;
        this.label = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getLabel() {
        return this.label;
    }
}
