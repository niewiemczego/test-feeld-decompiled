package expo.modules.kotlin.allocators;

import expo.modules.kotlin.allocators.UnsafeAllocator;
import java.lang.reflect.Method;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UnsafeAllocator$Companion$$ExternalSyntheticLambda0 implements UnsafeAllocator {
    public final /* synthetic */ Method f$0;
    public final /* synthetic */ Class f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ UnsafeAllocator$Companion$$ExternalSyntheticLambda0(Method method, Class cls, int i) {
        this.f$0 = method;
        this.f$1 = cls;
        this.f$2 = i;
    }

    public final Object newInstance() {
        return UnsafeAllocator.Companion.m782createAllocator$lambda0(this.f$0, this.f$1, this.f$2);
    }
}
