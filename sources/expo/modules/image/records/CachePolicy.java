package expo.modules.image.records;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/image/records/CachePolicy;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NONE", "DISK", "MEMORY", "MEMORY_AND_DISK", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CachePolicy.kt */
public enum CachePolicy implements Enumerable {
    NONE("none"),
    DISK("disk"),
    MEMORY("memory"),
    MEMORY_AND_DISK("memory-disk");
    
    private final String value;

    private CachePolicy(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
