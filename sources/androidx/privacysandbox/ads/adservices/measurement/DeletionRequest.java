package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import java.lang.annotation.RetentionPolicy;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dBI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\fJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u001e"}, d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/DeletionRequest;", "", "deletionMode", "", "matchBehavior", "start", "Ljava/time/Instant;", "end", "domainUris", "", "Landroid/net/Uri;", "originUris", "(IILjava/time/Instant;Ljava/time/Instant;Ljava/util/List;Ljava/util/List;)V", "getDeletionMode", "()I", "getDomainUris", "()Ljava/util/List;", "getEnd", "()Ljava/time/Instant;", "getMatchBehavior", "getOriginUris", "getStart", "equals", "", "other", "hashCode", "toString", "", "Builder", "Companion", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DeletionRequest.kt */
public final class DeletionRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DELETION_MODE_ALL = 0;
    public static final int DELETION_MODE_EXCLUDE_INTERNAL_DATA = 1;
    public static final int MATCH_BEHAVIOR_DELETE = 0;
    public static final int MATCH_BEHAVIOR_PRESERVE = 1;
    private final int deletionMode;
    private final List<Uri> domainUris;
    private final Instant end;
    private final int matchBehavior;
    private final List<Uri> originUris;
    private final Instant start;

    public DeletionRequest(int i, int i2, Instant instant, Instant instant2, List<? extends Uri> list, List<? extends Uri> list2) {
        Intrinsics.checkNotNullParameter(instant, "start");
        Intrinsics.checkNotNullParameter(instant2, "end");
        Intrinsics.checkNotNullParameter(list, "domainUris");
        Intrinsics.checkNotNullParameter(list2, "originUris");
        this.deletionMode = i;
        this.matchBehavior = i2;
        this.start = instant;
        this.end = instant2;
        this.domainUris = list;
        this.originUris = list2;
    }

    public final int getDeletionMode() {
        return this.deletionMode;
    }

    public final int getMatchBehavior() {
        return this.matchBehavior;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeletionRequest(int r8, int r9, java.time.Instant r10, java.time.Instant r11, java.util.List r12, java.util.List r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r15 = r14 & 4
            if (r15 == 0) goto L_0x000b
            java.time.Instant r10 = java.time.Instant.MIN
            java.lang.String r15 = "MIN"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r15)
        L_0x000b:
            r3 = r10
            r10 = r14 & 8
            if (r10 == 0) goto L_0x0017
            java.time.Instant r11 = java.time.Instant.MAX
            java.lang.String r10 = "MAX"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r10)
        L_0x0017:
            r4 = r11
            r10 = r14 & 16
            if (r10 == 0) goto L_0x0020
            java.util.List r12 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0020:
            r5 = r12
            r10 = r14 & 32
            if (r10 == 0) goto L_0x0029
            java.util.List r13 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0029:
            r6 = r13
            r0 = r7
            r1 = r8
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.measurement.DeletionRequest.<init>(int, int, java.time.Instant, java.time.Instant, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Instant getStart() {
        return this.start;
    }

    public final Instant getEnd() {
        return this.end;
    }

    public final List<Uri> getDomainUris() {
        return this.domainUris;
    }

    public final List<Uri> getOriginUris() {
        return this.originUris;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.deletionMode) * 31) + this.domainUris.hashCode()) * 31) + this.originUris.hashCode()) * 31) + this.start.hashCode()) * 31) + this.end.hashCode()) * 31) + Integer.hashCode(this.matchBehavior);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeletionRequest)) {
            return false;
        }
        DeletionRequest deletionRequest = (DeletionRequest) obj;
        if (this.deletionMode != deletionRequest.deletionMode || !Intrinsics.areEqual((Object) new HashSet(this.domainUris), (Object) new HashSet(deletionRequest.domainUris)) || !Intrinsics.areEqual((Object) new HashSet(this.originUris), (Object) new HashSet(deletionRequest.originUris)) || !Intrinsics.areEqual((Object) this.start, (Object) deletionRequest.start) || !Intrinsics.areEqual((Object) this.end, (Object) deletionRequest.end) || this.matchBehavior != deletionRequest.matchBehavior) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "DeletionRequest { DeletionMode=" + (this.deletionMode == 0 ? "DELETION_MODE_ALL" : "DELETION_MODE_EXCLUDE_INTERNAL_DATA") + ", MatchBehavior=" + (this.matchBehavior == 0 ? "MATCH_BEHAVIOR_DELETE" : "MATCH_BEHAVIOR_PRESERVE") + ", Start=" + this.start + ", End=" + this.end + ", DomainUris=" + this.domainUris + ", OriginUris=" + this.originUris + " }";
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/DeletionRequest$Companion;", "", "()V", "DELETION_MODE_ALL", "", "DELETION_MODE_EXCLUDE_INTERNAL_DATA", "MATCH_BEHAVIOR_DELETE", "MATCH_BEHAVIOR_PRESERVE", "DeletionMode", "MatchBehavior", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DeletionRequest.kt */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/DeletionRequest$Companion$DeletionMode;", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @Retention(AnnotationRetention.SOURCE)
        @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
        /* compiled from: DeletionRequest.kt */
        public @interface DeletionMode {
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/DeletionRequest$Companion$MatchBehavior;", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @Retention(AnnotationRetention.SOURCE)
        @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
        /* compiled from: DeletionRequest.kt */
        public @interface MatchBehavior {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u0011\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/DeletionRequest$Builder;", "", "deletionMode", "", "matchBehavior", "(II)V", "domainUris", "", "Landroid/net/Uri;", "end", "Ljava/time/Instant;", "originUris", "start", "build", "Landroidx/privacysandbox/ads/adservices/measurement/DeletionRequest;", "setDomainUris", "setEnd", "setOriginUris", "setStart", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DeletionRequest.kt */
    public static final class Builder {
        private final int deletionMode;
        private List<? extends Uri> domainUris = CollectionsKt.emptyList();
        private Instant end;
        private final int matchBehavior;
        private List<? extends Uri> originUris = CollectionsKt.emptyList();
        private Instant start;

        public Builder(int i, int i2) {
            this.deletionMode = i;
            this.matchBehavior = i2;
            Instant instant = Instant.MIN;
            Intrinsics.checkNotNullExpressionValue(instant, "MIN");
            this.start = instant;
            Instant instant2 = Instant.MAX;
            Intrinsics.checkNotNullExpressionValue(instant2, "MAX");
            this.end = instant2;
        }

        public final Builder setStart(Instant instant) {
            Intrinsics.checkNotNullParameter(instant, "start");
            Builder builder = this;
            this.start = instant;
            return this;
        }

        public final Builder setEnd(Instant instant) {
            Intrinsics.checkNotNullParameter(instant, "end");
            Builder builder = this;
            this.end = instant;
            return this;
        }

        public final Builder setDomainUris(List<? extends Uri> list) {
            Intrinsics.checkNotNullParameter(list, "domainUris");
            Builder builder = this;
            this.domainUris = list;
            return this;
        }

        public final Builder setOriginUris(List<? extends Uri> list) {
            Intrinsics.checkNotNullParameter(list, "originUris");
            Builder builder = this;
            this.originUris = list;
            return this;
        }

        public final DeletionRequest build() {
            return new DeletionRequest(this.deletionMode, this.matchBehavior, this.start, this.end, this.domainUris, this.originUris);
        }
    }
}
