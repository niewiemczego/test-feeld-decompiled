package zendesk.android.internal.proactivemessaging.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lzendesk/android/internal/proactivemessaging/model/Trigger;", "", "type", "Lzendesk/android/internal/proactivemessaging/model/TriggerType;", "duration", "", "(Lzendesk/android/internal/proactivemessaging/model/TriggerType;Ljava/lang/Integer;)V", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "()Lzendesk/android/internal/proactivemessaging/model/TriggerType;", "component1", "component2", "copy", "(Lzendesk/android/internal/proactivemessaging/model/TriggerType;Ljava/lang/Integer;)Lzendesk/android/internal/proactivemessaging/model/Trigger;", "equals", "", "other", "hashCode", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Trigger.kt */
public final class Trigger {
    private final Integer duration;
    private final TriggerType type;

    public static /* synthetic */ Trigger copy$default(Trigger trigger, TriggerType triggerType, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            triggerType = trigger.type;
        }
        if ((i & 2) != 0) {
            num = trigger.duration;
        }
        return trigger.copy(triggerType, num);
    }

    public final TriggerType component1() {
        return this.type;
    }

    public final Integer component2() {
        return this.duration;
    }

    public final Trigger copy(TriggerType triggerType, Integer num) {
        Intrinsics.checkNotNullParameter(triggerType, "type");
        return new Trigger(triggerType, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Trigger)) {
            return false;
        }
        Trigger trigger = (Trigger) obj;
        return this.type == trigger.type && Intrinsics.areEqual((Object) this.duration, (Object) trigger.duration);
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        Integer num = this.duration;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "Trigger(type=" + this.type + ", duration=" + this.duration + ')';
    }

    public Trigger(TriggerType triggerType, Integer num) {
        Intrinsics.checkNotNullParameter(triggerType, "type");
        this.type = triggerType;
        this.duration = num;
    }

    public final TriggerType getType() {
        return this.type;
    }

    public final Integer getDuration() {
        return this.duration;
    }
}
