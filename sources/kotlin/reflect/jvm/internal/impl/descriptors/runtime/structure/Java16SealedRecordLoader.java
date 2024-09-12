package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReflectJavaClass.kt */
final class Java16SealedRecordLoader {
    public static final Java16SealedRecordLoader INSTANCE = new Java16SealedRecordLoader();
    private static Cache _cache;

    /* compiled from: ReflectJavaClass.kt */
    public static final class Cache {
        private final Method getPermittedSubclasses;
        private final Method getRecordComponents;
        private final Method isRecord;
        private final Method isSealed;

        public Cache(Method method, Method method2, Method method3, Method method4) {
            this.isSealed = method;
            this.getPermittedSubclasses = method2;
            this.isRecord = method3;
            this.getRecordComponents = method4;
        }

        public final Method isSealed() {
            return this.isSealed;
        }

        public final Method getGetPermittedSubclasses() {
            return this.getPermittedSubclasses;
        }

        public final Method isRecord() {
            return this.isRecord;
        }

        public final Method getGetRecordComponents() {
            return this.getRecordComponents;
        }
    }

    private Java16SealedRecordLoader() {
    }

    private final Cache buildCache() {
        Class<Class> cls = Class.class;
        try {
            return new Cache(cls.getMethod("isSealed", new Class[0]), cls.getMethod("getPermittedSubclasses", new Class[0]), cls.getMethod("isRecord", new Class[0]), cls.getMethod("getRecordComponents", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new Cache((Method) null, (Method) null, (Method) null, (Method) null);
        }
    }

    private final Cache initCache() {
        Cache cache = _cache;
        if (cache != null) {
            return cache;
        }
        Cache buildCache = buildCache();
        _cache = buildCache;
        return buildCache;
    }

    public final Boolean loadIsSealed(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Method isSealed = initCache().isSealed();
        if (isSealed == null) {
            return null;
        }
        Object invoke = isSealed.invoke(cls, new Object[0]);
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) invoke;
    }

    public final Class<?>[] loadGetPermittedSubclasses(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Method getPermittedSubclasses = initCache().getGetPermittedSubclasses();
        if (getPermittedSubclasses == null) {
            return null;
        }
        Object invoke = getPermittedSubclasses.invoke(cls, new Object[0]);
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
        return (Class[]) invoke;
    }

    public final Boolean loadIsRecord(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Method isRecord = initCache().isRecord();
        if (isRecord == null) {
            return null;
        }
        Object invoke = isRecord.invoke(cls, new Object[0]);
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) invoke;
    }

    public final Object[] loadGetRecordComponents(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Method getRecordComponents = initCache().getGetRecordComponents();
        if (getRecordComponents == null) {
            return null;
        }
        return (Object[]) getRecordComponents.invoke(cls, new Object[0]);
    }
}
