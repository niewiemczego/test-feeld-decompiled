package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* compiled from: Delegates.kt */
public final class DescriptorRendererOptionsImpl$property$$inlined$vetoable$1 extends ObservableProperty<T> {
    final /* synthetic */ DescriptorRendererOptionsImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(Object obj, DescriptorRendererOptionsImpl descriptorRendererOptionsImpl) {
        super(obj);
        this.this$0 = descriptorRendererOptionsImpl;
    }

    /* access modifiers changed from: protected */
    public boolean beforeChange(KProperty<?> kProperty, T t, T t2) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        if (!this.this$0.isLocked()) {
            return true;
        }
        throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
    }
}
