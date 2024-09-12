package zendesk.ui.android.conversation.imagecell;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lzendesk/ui/android/conversation/imagecell/ImageCellDirection;", "", "(Ljava/lang/String;I)V", "INBOUND_SINGLE", "INBOUND_TOP", "INBOUND_MIDDLE", "INBOUND_BOTTOM", "OUTBOUND_SINGLE", "OUTBOUND_TOP", "OUTBOUND_MIDDLE", "OUTBOUND_BOTTOM", "Companion", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageCellDirection.kt */
public enum ImageCellDirection {
    INBOUND_SINGLE,
    INBOUND_TOP,
    INBOUND_MIDDLE,
    INBOUND_BOTTOM,
    OUTBOUND_SINGLE,
    OUTBOUND_TOP,
    OUTBOUND_MIDDLE,
    OUTBOUND_BOTTOM;
    
    public static final Companion Companion = null;

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005¨\u0006\u0006"}, d2 = {"Lzendesk/ui/android/conversation/imagecell/ImageCellDirection$Companion;", "", "()V", "isInbound", "", "Lzendesk/ui/android/conversation/imagecell/ImageCellDirection;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageCellDirection.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isInbound(ImageCellDirection imageCellDirection) {
            Intrinsics.checkNotNullParameter(imageCellDirection, "<this>");
            return imageCellDirection == ImageCellDirection.INBOUND_SINGLE || imageCellDirection == ImageCellDirection.INBOUND_TOP || imageCellDirection == ImageCellDirection.INBOUND_MIDDLE || imageCellDirection == ImageCellDirection.INBOUND_BOTTOM;
        }
    }
}
