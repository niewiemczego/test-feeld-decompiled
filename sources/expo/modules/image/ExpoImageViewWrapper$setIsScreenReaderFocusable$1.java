package expo.modules.image;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import app.notifee.core.event.LogEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"expo/modules/image/ExpoImageViewWrapper$setIsScreenReaderFocusable$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "onInitializeAccessibilityNodeInfo", "", "host", "Landroid/view/View;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoImageViewWrapper.kt */
public final class ExpoImageViewWrapper$setIsScreenReaderFocusable$1 extends AccessibilityDelegateCompat {
    final /* synthetic */ boolean $value;

    ExpoImageViewWrapper$setIsScreenReaderFocusable$1(boolean z) {
        this.$value = z;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Intrinsics.checkNotNullParameter(view, "host");
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, LogEvent.LEVEL_INFO);
        accessibilityNodeInfoCompat.setScreenReaderFocusable(this.$value);
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
    }
}
