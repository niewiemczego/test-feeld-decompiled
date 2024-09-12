package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/RestRetryPolicyDto;", "", "intervals", "Lzendesk/conversationkit/android/internal/rest/model/RetryIntervalDto;", "backoffMultiplier", "", "maxRetries", "(Lzendesk/conversationkit/android/internal/rest/model/RetryIntervalDto;II)V", "getBackoffMultiplier", "()I", "getIntervals", "()Lzendesk/conversationkit/android/internal/rest/model/RetryIntervalDto;", "getMaxRetries", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RestRetryPolicyDto.kt */
public final class RestRetryPolicyDto {
    private final int backoffMultiplier;
    private final RetryIntervalDto intervals;
    private final int maxRetries;

    public static /* synthetic */ RestRetryPolicyDto copy$default(RestRetryPolicyDto restRetryPolicyDto, RetryIntervalDto retryIntervalDto, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            retryIntervalDto = restRetryPolicyDto.intervals;
        }
        if ((i3 & 2) != 0) {
            i = restRetryPolicyDto.backoffMultiplier;
        }
        if ((i3 & 4) != 0) {
            i2 = restRetryPolicyDto.maxRetries;
        }
        return restRetryPolicyDto.copy(retryIntervalDto, i, i2);
    }

    public final RetryIntervalDto component1() {
        return this.intervals;
    }

    public final int component2() {
        return this.backoffMultiplier;
    }

    public final int component3() {
        return this.maxRetries;
    }

    public final RestRetryPolicyDto copy(RetryIntervalDto retryIntervalDto, int i, int i2) {
        Intrinsics.checkNotNullParameter(retryIntervalDto, "intervals");
        return new RestRetryPolicyDto(retryIntervalDto, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RestRetryPolicyDto)) {
            return false;
        }
        RestRetryPolicyDto restRetryPolicyDto = (RestRetryPolicyDto) obj;
        return Intrinsics.areEqual((Object) this.intervals, (Object) restRetryPolicyDto.intervals) && this.backoffMultiplier == restRetryPolicyDto.backoffMultiplier && this.maxRetries == restRetryPolicyDto.maxRetries;
    }

    public int hashCode() {
        return (((this.intervals.hashCode() * 31) + Integer.hashCode(this.backoffMultiplier)) * 31) + Integer.hashCode(this.maxRetries);
    }

    public String toString() {
        return "RestRetryPolicyDto(intervals=" + this.intervals + ", backoffMultiplier=" + this.backoffMultiplier + ", maxRetries=" + this.maxRetries + ')';
    }

    public RestRetryPolicyDto(RetryIntervalDto retryIntervalDto, int i, int i2) {
        Intrinsics.checkNotNullParameter(retryIntervalDto, "intervals");
        this.intervals = retryIntervalDto;
        this.backoffMultiplier = i;
        this.maxRetries = i2;
    }

    public final RetryIntervalDto getIntervals() {
        return this.intervals;
    }

    public final int getBackoffMultiplier() {
        return this.backoffMultiplier;
    }

    public final int getMaxRetries() {
        return this.maxRetries;
    }
}
