package zendesk.ui.android.internal;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"zendesk/ui/android/internal/ViewKt$requestLayoutOnKeyBoardShown$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: View.kt */
public final class ViewKt$requestLayoutOnKeyBoardShown$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ MaterialAutoCompleteTextView $this_requestLayoutOnKeyBoardShown;

    ViewKt$requestLayoutOnKeyBoardShown$1(MaterialAutoCompleteTextView materialAutoCompleteTextView) {
        this.$this_requestLayoutOnKeyBoardShown = materialAutoCompleteTextView;
    }

    public void onGlobalLayout() {
        MaterialAutoCompleteTextView materialAutoCompleteTextView = this.$this_requestLayoutOnKeyBoardShown;
        View view = materialAutoCompleteTextView;
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int height = view.getRootView().getHeight();
        if (((float) (height - rect.bottom)) > ((float) height) * 0.15f) {
            if (materialAutoCompleteTextView.isPopupShowing()) {
                materialAutoCompleteTextView.requestLayout();
            }
            materialAutoCompleteTextView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }
}
