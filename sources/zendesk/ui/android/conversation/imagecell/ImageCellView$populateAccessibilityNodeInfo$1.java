package zendesk.ui.android.conversation.imagecell;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import app.notifee.core.event.LogEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"zendesk/ui/android/conversation/imagecell/ImageCellView$populateAccessibilityNodeInfo$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "onInitializeAccessibilityNodeInfo", "", "host", "Landroid/view/View;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageCellView.kt */
public final class ImageCellView$populateAccessibilityNodeInfo$1 extends AccessibilityDelegateCompat {
    final /* synthetic */ ImageCellView this$0;

    ImageCellView$populateAccessibilityNodeInfo$1(ImageCellView imageCellView) {
        this.this$0 = imageCellView;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Intrinsics.checkNotNullParameter(view, "host");
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, LogEvent.LEVEL_INFO);
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName((CharSequence) null);
        accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, this.this$0.getResources().getString(R.string.zuia_image_thumbnail_accessibility_action_label)));
    }
}
