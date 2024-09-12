package zendesk.ui.android.conversation.composer;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import app.notifee.core.event.LogEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"zendesk/ui/android/conversation/composer/MessageComposerAttachmentMenu$updateAccessibilityNodeInfo$1", "Landroid/view/View$AccessibilityDelegate;", "onInitializeAccessibilityNodeInfo", "", "host", "Landroid/view/View;", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageComposerAttachmentMenu.kt */
public final class MessageComposerAttachmentMenu$updateAccessibilityNodeInfo$1 extends View.AccessibilityDelegate {
    MessageComposerAttachmentMenu$updateAccessibilityNodeInfo$1() {
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        Intrinsics.checkNotNullParameter(view, "host");
        Intrinsics.checkNotNullParameter(accessibilityNodeInfo, LogEvent.LEVEL_INFO);
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }
}
