package zendesk.android.internal.proactivemessaging.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lzendesk/android/internal/proactivemessaging/model/Schedule;", "", "frequency", "Lzendesk/android/internal/proactivemessaging/model/Frequency;", "(Lzendesk/android/internal/proactivemessaging/model/Frequency;)V", "getFrequency", "()Lzendesk/android/internal/proactivemessaging/model/Frequency;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Schedule.kt */
public final class Schedule {
    private final Frequency frequency;

    public static /* synthetic */ Schedule copy$default(Schedule schedule, Frequency frequency2, int i, Object obj) {
        if ((i & 1) != 0) {
            frequency2 = schedule.frequency;
        }
        return schedule.copy(frequency2);
    }

    public final Frequency component1() {
        return this.frequency;
    }

    public final Schedule copy(@Json(name = "frequency") Frequency frequency2) {
        Intrinsics.checkNotNullParameter(frequency2, "frequency");
        return new Schedule(frequency2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Schedule) && this.frequency == ((Schedule) obj).frequency;
    }

    public int hashCode() {
        return this.frequency.hashCode();
    }

    public String toString() {
        return "Schedule(frequency=" + this.frequency + ')';
    }

    public Schedule(@Json(name = "frequency") Frequency frequency2) {
        Intrinsics.checkNotNullParameter(frequency2, "frequency");
        this.frequency = frequency2;
    }

    public final Frequency getFrequency() {
        return this.frequency;
    }
}
