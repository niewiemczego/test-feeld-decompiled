package zendesk.ui.android.internal;

import android.text.Editable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"zendesk/ui/android/internal/ThrottledAfterTextChangedKt$throttledAfterTextChangedListener$1", "Lzendesk/ui/android/internal/ThrottledAfterTextChanged;", "onDebouncedAfterTextChanged", "", "text", "Landroid/text/Editable;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ThrottledAfterTextChanged.kt */
public final class ThrottledAfterTextChangedKt$throttledAfterTextChangedListener$1 extends ThrottledAfterTextChanged {
    final /* synthetic */ Function1<Editable, Unit> $afterTextChanged;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ThrottledAfterTextChangedKt$throttledAfterTextChangedListener$1(long j, Function1<? super Editable, Unit> function1) {
        super(j);
        this.$afterTextChanged = function1;
    }

    public void onDebouncedAfterTextChanged(Editable editable) {
        this.$afterTextChanged.invoke(editable);
    }
}
