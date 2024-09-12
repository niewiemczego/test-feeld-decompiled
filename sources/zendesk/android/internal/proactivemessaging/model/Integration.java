package zendesk.android.internal.proactivemessaging.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lzendesk/android/internal/proactivemessaging/model/Integration;", "", "id", "", "type", "Lzendesk/android/internal/proactivemessaging/model/IntegrationType;", "(Ljava/lang/String;Lzendesk/android/internal/proactivemessaging/model/IntegrationType;)V", "getId", "()Ljava/lang/String;", "getType", "()Lzendesk/android/internal/proactivemessaging/model/IntegrationType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Integration.kt */
public final class Integration {
    private final String id;
    private final IntegrationType type;

    public static /* synthetic */ Integration copy$default(Integration integration, String str, IntegrationType integrationType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = integration.id;
        }
        if ((i & 2) != 0) {
            integrationType = integration.type;
        }
        return integration.copy(str, integrationType);
    }

    public final String component1() {
        return this.id;
    }

    public final IntegrationType component2() {
        return this.type;
    }

    public final Integration copy(String str, IntegrationType integrationType) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(integrationType, "type");
        return new Integration(str, integrationType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Integration)) {
            return false;
        }
        Integration integration = (Integration) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) integration.id) && this.type == integration.type;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.type.hashCode();
    }

    public String toString() {
        return "Integration(id=" + this.id + ", type=" + this.type + ')';
    }

    public Integration(String str, IntegrationType integrationType) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(integrationType, "type");
        this.id = str;
        this.type = integrationType;
    }

    public final String getId() {
        return this.id;
    }

    public final IntegrationType getType() {
        return this.type;
    }
}
