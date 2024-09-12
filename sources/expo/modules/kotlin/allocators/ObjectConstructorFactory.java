package expo.modules.kotlin.allocators;

import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007J$\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0002J\"\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0002¨\u0006\n"}, d2 = {"Lexpo/modules/kotlin/allocators/ObjectConstructorFactory;", "", "()V", "get", "Lexpo/modules/kotlin/allocators/ObjectConstructor;", "T", "clazz", "Ljava/lang/Class;", "tryToUseDefaultConstructor", "useUnsafeAllocator", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ObjectConstructorFactory.kt */
public final class ObjectConstructorFactory {
    public final <T> ObjectConstructor<T> get(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        ObjectConstructor<T> tryToUseDefaultConstructor = tryToUseDefaultConstructor(cls);
        return tryToUseDefaultConstructor == null ? useUnsafeAllocator(cls) : tryToUseDefaultConstructor;
    }

    private final <T> ObjectConstructor<T> tryToUseDefaultConstructor(Class<T> cls) {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new ObjectConstructorFactory$$ExternalSyntheticLambda0(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            ObjectConstructor objectConstructor = null;
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: tryToUseDefaultConstructor$lambda-0  reason: not valid java name */
    public static final Object m779tryToUseDefaultConstructor$lambda0(Constructor constructor) {
        return constructor.newInstance(new Object[0]);
    }

    private final <T> ObjectConstructor<T> useUnsafeAllocator(Class<T> cls) {
        return new ObjectConstructorFactory$$ExternalSyntheticLambda1(UnsafeAllocator.Companion.createAllocator(cls));
    }

    /* access modifiers changed from: private */
    /* renamed from: useUnsafeAllocator$lambda-1  reason: not valid java name */
    public static final Object m780useUnsafeAllocator$lambda1(UnsafeAllocator unsafeAllocator) {
        Intrinsics.checkNotNullParameter(unsafeAllocator, "$allocator");
        return unsafeAllocator.newInstance();
    }
}
