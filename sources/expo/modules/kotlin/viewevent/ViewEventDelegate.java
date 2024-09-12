package expo.modules.kotlin.viewevent;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BF\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012/\u0010\u0007\u001a+\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\r¢\u0006\u0002\u0010\u000eJ#\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\u0006\u0010\u001a\u001a\u00020\u00062\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0002R7\u0010\u0007\u001a+\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00060\u00060\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "T", "", "type", "Lkotlin/reflect/KType;", "view", "Landroid/view/View;", "coalescingKey", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "event", "", "Lexpo/modules/kotlin/viewevent/CoalescingKey;", "(Lkotlin/reflect/KType;Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "isValidated", "", "isValidated$expo_modules_core_release", "()Z", "setValidated$expo_modules_core_release", "(Z)V", "viewHolder", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getValue", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "thisRef", "property", "Lkotlin/reflect/KProperty;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ViewEventDelegate.kt */
public final class ViewEventDelegate<T> {
    private final Function1<T, Short> coalescingKey;
    private boolean isValidated;
    private final KType type;
    private final WeakReference<View> viewHolder;

    public ViewEventDelegate(KType kType, View view, Function1<? super T, Short> function1) {
        Intrinsics.checkNotNullParameter(kType, "type");
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        this.type = kType;
        this.coalescingKey = function1;
        this.viewHolder = new WeakReference<>(view);
    }

    public final boolean isValidated$expo_modules_core_release() {
        return this.isValidated;
    }

    public final void setValidated$expo_modules_core_release(boolean z) {
        this.isValidated = z;
    }

    public final ViewEventCallback<T> getValue(View view, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(view, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        if (this.isValidated) {
            View view2 = (View) this.viewHolder.get();
            if (view2 != null) {
                return new ViewEvent<>(kProperty.getName(), this.type, view2, this.coalescingKey);
            }
            throw new IllegalStateException("Can't send the '" + kProperty.getName() + "' event from the view that is deallocated");
        }
        throw new IllegalStateException("You have to export '" + kProperty.getName() + "' property as a event in the `View` component");
    }
}
