package zendesk.conversationkit.android.model;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lzendesk/conversationkit/android/model/RestRetryPolicy;", "", "regular", "", "aggressive", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "backoffMultiplier", "maxRetries", "(IILjava/util/concurrent/TimeUnit;II)V", "getAggressive", "()I", "getBackoffMultiplier", "getMaxRetries", "getRegular", "getTimeUnit", "()Ljava/util/concurrent/TimeUnit;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RestRetryPolicy.kt */
public final class RestRetryPolicy {
    private final int aggressive;
    private final int backoffMultiplier;
    private final int maxRetries;
    private final int regular;
    private final TimeUnit timeUnit;

    public RestRetryPolicy() {
        this(0, 0, (TimeUnit) null, 0, 0, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RestRetryPolicy copy$default(RestRetryPolicy restRetryPolicy, int i, int i2, TimeUnit timeUnit2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = restRetryPolicy.regular;
        }
        if ((i5 & 2) != 0) {
            i2 = restRetryPolicy.aggressive;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            timeUnit2 = restRetryPolicy.timeUnit;
        }
        TimeUnit timeUnit3 = timeUnit2;
        if ((i5 & 8) != 0) {
            i3 = restRetryPolicy.backoffMultiplier;
        }
        int i7 = i3;
        if ((i5 & 16) != 0) {
            i4 = restRetryPolicy.maxRetries;
        }
        return restRetryPolicy.copy(i, i6, timeUnit3, i7, i4);
    }

    public final int component1() {
        return this.regular;
    }

    public final int component2() {
        return this.aggressive;
    }

    public final TimeUnit component3() {
        return this.timeUnit;
    }

    public final int component4() {
        return this.backoffMultiplier;
    }

    public final int component5() {
        return this.maxRetries;
    }

    public final RestRetryPolicy copy(int i, int i2, TimeUnit timeUnit2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(timeUnit2, "timeUnit");
        return new RestRetryPolicy(i, i2, timeUnit2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RestRetryPolicy)) {
            return false;
        }
        RestRetryPolicy restRetryPolicy = (RestRetryPolicy) obj;
        return this.regular == restRetryPolicy.regular && this.aggressive == restRetryPolicy.aggressive && this.timeUnit == restRetryPolicy.timeUnit && this.backoffMultiplier == restRetryPolicy.backoffMultiplier && this.maxRetries == restRetryPolicy.maxRetries;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.regular) * 31) + Integer.hashCode(this.aggressive)) * 31) + this.timeUnit.hashCode()) * 31) + Integer.hashCode(this.backoffMultiplier)) * 31) + Integer.hashCode(this.maxRetries);
    }

    public String toString() {
        return "RestRetryPolicy(regular=" + this.regular + ", aggressive=" + this.aggressive + ", timeUnit=" + this.timeUnit + ", backoffMultiplier=" + this.backoffMultiplier + ", maxRetries=" + this.maxRetries + ')';
    }

    public RestRetryPolicy(int i, int i2, TimeUnit timeUnit2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(timeUnit2, "timeUnit");
        this.regular = i;
        this.aggressive = i2;
        this.timeUnit = timeUnit2;
        this.backoffMultiplier = i3;
        this.maxRetries = i4;
    }

    public final int getRegular() {
        return this.regular;
    }

    public final int getAggressive() {
        return this.aggressive;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RestRetryPolicy(int r4, int r5, java.util.concurrent.TimeUnit r6, int r7, int r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0006
            r4 = 60
        L_0x0006:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x000c
            r5 = 15
        L_0x000c:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0013
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS
        L_0x0013:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x0019
            r7 = 2
        L_0x0019:
            r1 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x001f
            r8 = 5
        L_0x001f:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.model.RestRetryPolicy.<init>(int, int, java.util.concurrent.TimeUnit, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final TimeUnit getTimeUnit() {
        return this.timeUnit;
    }

    public final int getBackoffMultiplier() {
        return this.backoffMultiplier;
    }

    public final int getMaxRetries() {
        return this.maxRetries;
    }
}
