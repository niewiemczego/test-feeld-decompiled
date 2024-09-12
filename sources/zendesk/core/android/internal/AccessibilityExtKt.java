package zendesk.core.android.internal;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u001c\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"isAccessibilityServiceRunning", "", "Landroid/content/Context;", "postDelayRequestFocusWhenAccessibilityRunning", "", "Landroid/view/View;", "context", "eventDelay", "", "zendesk.core_core-utilities"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccessibilityExt.kt */
public final class AccessibilityExtKt {
    @InternalZendeskApi
    public static final boolean isAccessibilityServiceRunning(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("accessibility");
        if (systemService != null) {
            List<AccessibilityServiceInfo> enabledAccessibilityServiceList = ((AccessibilityManager) systemService).getEnabledAccessibilityServiceList(-1);
            Intrinsics.checkNotNullExpressionValue(enabledAccessibilityServiceList, "accessibilityManager\n   …lityEvent.TYPES_ALL_MASK)");
            return !enabledAccessibilityServiceList.isEmpty();
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
    }

    @InternalZendeskApi
    public static final void postDelayRequestFocusWhenAccessibilityRunning(View view, Context context, long j) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isAccessibilityServiceRunning(context)) {
            view.postDelayed(new AccessibilityExtKt$$ExternalSyntheticLambda0(view), j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: postDelayRequestFocusWhenAccessibilityRunning$lambda-0  reason: not valid java name */
    public static final void m2757postDelayRequestFocusWhenAccessibilityRunning$lambda0(View view) {
        Intrinsics.checkNotNullParameter(view, "$this_postDelayRequestFocusWhenAccessibilityRunning");
        view.sendAccessibilityEvent(8);
        view.requestFocusFromTouch();
    }
}
