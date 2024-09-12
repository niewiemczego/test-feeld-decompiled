package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;

/* compiled from: JavaNullabilityAnnotationSettings.kt */
public final class NullabilityAnnotationStatesImpl<T> implements NullabilityAnnotationStates<T> {
    private final MemoizedFunctionToNullable<FqName, T> cache;
    private final Map<FqName, T> states;
    private final LockBasedStorageManager storageManager;

    public NullabilityAnnotationStatesImpl(Map<FqName, ? extends T> map) {
        Intrinsics.checkNotNullParameter(map, "states");
        this.states = map;
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("Java nullability annotation states");
        this.storageManager = lockBasedStorageManager;
        MemoizedFunctionToNullable<FqName, T> createMemoizedFunctionWithNullableValues = lockBasedStorageManager.createMemoizedFunctionWithNullableValues(new NullabilityAnnotationStatesImpl$cache$1(this));
        Intrinsics.checkNotNullExpressionValue(createMemoizedFunctionWithNullableValues, "storageManager.createMem…cificFqname(states)\n    }");
        this.cache = createMemoizedFunctionWithNullableValues;
    }

    public final Map<FqName, T> getStates() {
        return this.states;
    }

    public T get(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return this.cache.invoke(fqName);
    }
}
