package zendesk.ui.android.internal;

import android.text.Editable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a7\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00012#\u0010\u0005\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"DEFAULT_DEBOUNCE_MINIMUM_INTERVAL_MILLIS", "", "throttledAfterTextChangedListener", "Lzendesk/ui/android/internal/ThrottledAfterTextChanged;", "minimumIntervalMillis", "afterTextChanged", "Lkotlin/Function1;", "Landroid/text/Editable;", "Lkotlin/ParameterName;", "name", "text", "", "zendesk.ui_ui-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ThrottledAfterTextChanged.kt */
public final class ThrottledAfterTextChangedKt {
    private static final long DEFAULT_DEBOUNCE_MINIMUM_INTERVAL_MILLIS = 20;

    public static /* synthetic */ ThrottledAfterTextChanged throttledAfterTextChangedListener$default(long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 20;
        }
        return throttledAfterTextChangedListener(j, function1);
    }

    public static final ThrottledAfterTextChanged throttledAfterTextChangedListener(long j, Function1<? super Editable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "afterTextChanged");
        return new ThrottledAfterTextChangedKt$throttledAfterTextChangedListener$1(j, function1);
    }
}
