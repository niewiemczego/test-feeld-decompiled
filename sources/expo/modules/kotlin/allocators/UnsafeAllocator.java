package expo.modules.kotlin.allocators;

import java.io.ObjectStreamClass;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\bæ\u0001\u0018\u0000 \u0005*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0005J\r\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lexpo/modules/kotlin/allocators/UnsafeAllocator;", "T", "", "newInstance", "()Ljava/lang/Object;", "Companion", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: UnsafeAllocator.kt */
public interface UnsafeAllocator<T> {
    public static final Companion Companion = Companion.$$INSTANCE;

    T newInstance() throws Exception;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/allocators/UnsafeAllocator$Companion;", "", "()V", "createAllocator", "Lexpo/modules/kotlin/allocators/UnsafeAllocator;", "T", "clazz", "Ljava/lang/Class;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: UnsafeAllocator.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final <T> UnsafeAllocator<T> createAllocator(Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "clazz");
            try {
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke((Object) null, new Object[]{Object.class});
                Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) invoke).intValue();
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                declaredMethod2.setAccessible(true);
                return new UnsafeAllocator$Companion$$ExternalSyntheticLambda0(declaredMethod2, cls, intValue);
            } catch (Throwable unused) {
                return new UnsafeAllocator$Companion$$ExternalSyntheticLambda2(cls);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: createAllocator$lambda-0  reason: not valid java name */
        public static final Object m782createAllocator$lambda0(Method method, Class cls, int i) {
            Intrinsics.checkNotNullParameter(cls, "$clazz");
            return method.invoke((Object) null, new Object[]{cls, Integer.valueOf(i)});
        }

        /* access modifiers changed from: private */
        /* renamed from: createAllocator$lambda-1  reason: not valid java name */
        public static final Object m783createAllocator$lambda1(Method method, Object obj, Class cls) {
            Intrinsics.checkNotNullParameter(cls, "$clazz");
            return method.invoke(obj, new Object[]{cls});
        }

        /* access modifiers changed from: private */
        /* renamed from: createAllocator$lambda-2  reason: not valid java name */
        public static final Object m784createAllocator$lambda2(Class cls) {
            Intrinsics.checkNotNullParameter(cls, "$clazz");
            throw new IllegalArgumentException("Cannot allocate " + cls);
        }
    }
}
