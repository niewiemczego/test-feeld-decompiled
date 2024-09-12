package androidx.privacysandbox.ads.adservices.topics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000fB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0010"}, d2 = {"Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest;", "", "adsSdkName", "", "shouldRecordObservation", "", "(Ljava/lang/String;Z)V", "getAdsSdkName", "()Ljava/lang/String;", "()Z", "equals", "other", "hashCode", "", "toString", "Builder", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GetTopicsRequest.kt */
public final class GetTopicsRequest {
    private final String adsSdkName;
    private final boolean shouldRecordObservation;

    public GetTopicsRequest() {
        this((String) null, false, 3, (DefaultConstructorMarker) null);
    }

    public GetTopicsRequest(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "adsSdkName");
        this.adsSdkName = str;
        this.shouldRecordObservation = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetTopicsRequest(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z);
    }

    public final String getAdsSdkName() {
        return this.adsSdkName;
    }

    public final boolean shouldRecordObservation() {
        return this.shouldRecordObservation;
    }

    public String toString() {
        return "GetTopicsRequest: adsSdkName=" + this.adsSdkName + ", shouldRecordObservation=" + this.shouldRecordObservation;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTopicsRequest)) {
            return false;
        }
        GetTopicsRequest getTopicsRequest = (GetTopicsRequest) obj;
        if (!Intrinsics.areEqual((Object) this.adsSdkName, (Object) getTopicsRequest.adsSdkName) || this.shouldRecordObservation != getTopicsRequest.shouldRecordObservation) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.adsSdkName.hashCode() * 31) + Boolean.hashCode(this.shouldRecordObservation);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest$Builder;", "", "()V", "adsSdkName", "", "shouldRecordObservation", "", "build", "Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest;", "setAdsSdkName", "setShouldRecordObservation", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: GetTopicsRequest.kt */
    public static final class Builder {
        private String adsSdkName = "";
        private boolean shouldRecordObservation = true;

        public final Builder setAdsSdkName(String str) {
            Intrinsics.checkNotNullParameter(str, "adsSdkName");
            Builder builder = this;
            this.adsSdkName = str;
            return this;
        }

        public final Builder setShouldRecordObservation(boolean z) {
            Builder builder = this;
            this.shouldRecordObservation = z;
            return this;
        }

        public final GetTopicsRequest build() {
            if (this.adsSdkName.length() > 0) {
                return new GetTopicsRequest(this.adsSdkName, this.shouldRecordObservation);
            }
            throw new IllegalStateException("adsSdkName must be set".toString());
        }
    }
}
