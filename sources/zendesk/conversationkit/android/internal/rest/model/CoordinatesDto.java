package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/CoordinatesDto;", "", "lat", "", "long", "(DD)V", "getLat", "()D", "getLong", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageDto.kt */
public final class CoordinatesDto {
    private final double lat;

    /* renamed from: long  reason: not valid java name */
    private final double f7long;

    public static /* synthetic */ CoordinatesDto copy$default(CoordinatesDto coordinatesDto, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = coordinatesDto.lat;
        }
        if ((i & 2) != 0) {
            d2 = coordinatesDto.f7long;
        }
        return coordinatesDto.copy(d, d2);
    }

    public final double component1() {
        return this.lat;
    }

    public final double component2() {
        return this.f7long;
    }

    public final CoordinatesDto copy(double d, double d2) {
        return new CoordinatesDto(d, d2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CoordinatesDto)) {
            return false;
        }
        CoordinatesDto coordinatesDto = (CoordinatesDto) obj;
        return Intrinsics.areEqual((Object) Double.valueOf(this.lat), (Object) Double.valueOf(coordinatesDto.lat)) && Intrinsics.areEqual((Object) Double.valueOf(this.f7long), (Object) Double.valueOf(coordinatesDto.f7long));
    }

    public int hashCode() {
        return (Double.hashCode(this.lat) * 31) + Double.hashCode(this.f7long);
    }

    public String toString() {
        return "CoordinatesDto(lat=" + this.lat + ", long=" + this.f7long + ')';
    }

    public CoordinatesDto(double d, double d2) {
        this.lat = d;
        this.f7long = d2;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLong() {
        return this.f7long;
    }
}
