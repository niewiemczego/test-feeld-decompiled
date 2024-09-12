package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0015\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u001f\u0010\t\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/MetadataDto;", "", "metadata", "", "", "(Ljava/util/Map;)V", "getMetadata", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UploadFileDto.kt */
public final class MetadataDto {
    private final Map<String, Object> metadata;

    public static /* synthetic */ MetadataDto copy$default(MetadataDto metadataDto, Map<String, Object> map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = metadataDto.metadata;
        }
        return metadataDto.copy(map);
    }

    public final Map<String, Object> component1() {
        return this.metadata;
    }

    public final MetadataDto copy(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, TtmlNode.TAG_METADATA);
        return new MetadataDto(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MetadataDto) && Intrinsics.areEqual((Object) this.metadata, (Object) ((MetadataDto) obj).metadata);
    }

    public int hashCode() {
        return this.metadata.hashCode();
    }

    public String toString() {
        return "MetadataDto(metadata=" + this.metadata + ')';
    }

    public MetadataDto(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, TtmlNode.TAG_METADATA);
        this.metadata = map;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }
}
