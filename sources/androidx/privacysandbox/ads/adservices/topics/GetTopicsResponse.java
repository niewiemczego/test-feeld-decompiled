package androidx.privacysandbox.ads.adservices.topics;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/privacysandbox/ads/adservices/topics/GetTopicsResponse;", "", "topics", "", "Landroidx/privacysandbox/ads/adservices/topics/Topic;", "(Ljava/util/List;)V", "getTopics", "()Ljava/util/List;", "equals", "", "other", "hashCode", "", "toString", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GetTopicsResponse.kt */
public final class GetTopicsResponse {
    private final List<Topic> topics;

    public GetTopicsResponse(List<Topic> list) {
        Intrinsics.checkNotNullParameter(list, "topics");
        this.topics = list;
    }

    public final List<Topic> getTopics() {
        return this.topics;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTopicsResponse)) {
            return false;
        }
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
        if (this.topics.size() != getTopicsResponse.topics.size()) {
            return false;
        }
        return Intrinsics.areEqual((Object) new HashSet(this.topics), (Object) new HashSet(getTopicsResponse.topics));
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.topics});
    }

    public String toString() {
        return "Topics=" + this.topics;
    }
}
