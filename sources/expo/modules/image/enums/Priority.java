package expo.modules.image.enums;

import expo.modules.kotlin.types.Enumerable;
import io.sentry.ProfilingTraceData;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lexpo/modules/image/enums/Priority;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toGlidePriority", "Lcom/bumptech/glide/Priority;", "toGlidePriority$expo_image_release", "LOW", "NORMAL", "HIGH", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Priority.kt */
public enum Priority implements Enumerable {
    LOW("low"),
    NORMAL(ProfilingTraceData.TRUNCATION_REASON_NORMAL),
    HIGH("high");
    
    private final String value;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Priority.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] iArr = new int[Priority.values().length];
            iArr[Priority.LOW.ordinal()] = 1;
            iArr[Priority.NORMAL.ordinal()] = 2;
            iArr[Priority.HIGH.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private Priority(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final com.bumptech.glide.Priority toGlidePriority$expo_image_release() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return com.bumptech.glide.Priority.LOW;
        }
        if (i == 2) {
            return com.bumptech.glide.Priority.NORMAL;
        }
        if (i == 3) {
            return com.bumptech.glide.Priority.IMMEDIATE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
