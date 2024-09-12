package zendesk.android.settings.internal.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lzendesk/android/settings/internal/model/RetryIntervalDto;", "", "regular", "", "aggressive", "(II)V", "getAggressive", "()I", "getRegular", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SunCoConfigDto.kt */
public final class RetryIntervalDto {
    private final int aggressive;
    private final int regular;

    public static /* synthetic */ RetryIntervalDto copy$default(RetryIntervalDto retryIntervalDto, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = retryIntervalDto.regular;
        }
        if ((i3 & 2) != 0) {
            i2 = retryIntervalDto.aggressive;
        }
        return retryIntervalDto.copy(i, i2);
    }

    public final int component1() {
        return this.regular;
    }

    public final int component2() {
        return this.aggressive;
    }

    public final RetryIntervalDto copy(int i, int i2) {
        return new RetryIntervalDto(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RetryIntervalDto)) {
            return false;
        }
        RetryIntervalDto retryIntervalDto = (RetryIntervalDto) obj;
        return this.regular == retryIntervalDto.regular && this.aggressive == retryIntervalDto.aggressive;
    }

    public int hashCode() {
        return (Integer.hashCode(this.regular) * 31) + Integer.hashCode(this.aggressive);
    }

    public String toString() {
        return "RetryIntervalDto(regular=" + this.regular + ", aggressive=" + this.aggressive + ')';
    }

    public RetryIntervalDto(int i, int i2) {
        this.regular = i;
        this.aggressive = i2;
    }

    public final int getRegular() {
        return this.regular;
    }

    public final int getAggressive() {
        return this.aggressive;
    }
}
