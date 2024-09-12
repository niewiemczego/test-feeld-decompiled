package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: SpecialTypes.kt */
public final class LazyWrappedType extends WrappedType {
    /* access modifiers changed from: private */
    public final Function0<KotlinType> computation;
    private final NotNullLazyValue<KotlinType> lazyValue;
    private final StorageManager storageManager;

    public LazyWrappedType(StorageManager storageManager2, Function0<? extends KotlinType> function0) {
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(function0, "computation");
        this.storageManager = storageManager2;
        this.computation = function0;
        this.lazyValue = storageManager2.createLazyValue(function0);
    }

    /* access modifiers changed from: protected */
    public KotlinType getDelegate() {
        return (KotlinType) this.lazyValue.invoke();
    }

    public boolean isComputed() {
        return this.lazyValue.isComputed();
    }

    public LazyWrappedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new LazyWrappedType(this.storageManager, new LazyWrappedType$refine$1(kotlinTypeRefiner, this));
    }
}
