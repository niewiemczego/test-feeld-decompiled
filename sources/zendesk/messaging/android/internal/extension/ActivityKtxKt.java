package zendesk.messaging.android.internal.extension;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"hideKeyboard", "", "Landroidx/fragment/app/FragmentActivity;", "zendesk.messaging_messaging-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActivityKtx.kt */
public final class ActivityKtxKt {
    public static final void hideKeyboard(FragmentActivity fragmentActivity) {
        View currentFocus;
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Object systemService = fragmentActivity.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null && (currentFocus = fragmentActivity.getCurrentFocus()) != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }
}
