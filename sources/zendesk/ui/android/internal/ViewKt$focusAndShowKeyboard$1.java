package zendesk.ui.android.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"zendesk/ui/android/internal/ViewKt$focusAndShowKeyboard$1", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "onWindowFocusChanged", "", "hasFocus", "", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: View.kt */
public final class ViewKt$focusAndShowKeyboard$1 implements ViewTreeObserver.OnWindowFocusChangeListener {
    final /* synthetic */ View $this_focusAndShowKeyboard;

    ViewKt$focusAndShowKeyboard$1(View view) {
        this.$this_focusAndShowKeyboard = view;
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            this.$this_focusAndShowKeyboard.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
            ViewKt.showKeyboardNow(this.$this_focusAndShowKeyboard);
        }
    }
}
