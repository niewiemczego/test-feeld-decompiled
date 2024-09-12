package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: KotlinTypeRefiner.kt */
public final class KotlinTypeRefinerKt {
    private static final ModuleCapability<Ref<TypeRefinementSupport>> REFINER_CAPABILITY = new ModuleCapability<>("KotlinTypeRefiner");

    public static final ModuleCapability<Ref<TypeRefinementSupport>> getREFINER_CAPABILITY() {
        return REFINER_CAPABILITY;
    }

    public static final List<KotlinType> refineTypes(KotlinTypeRefiner kotlinTypeRefiner, Iterable<? extends KotlinType> iterable) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "types");
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (KotlinType refineType : iterable) {
            arrayList.add(kotlinTypeRefiner.refineType(refineType));
        }
        return (List) arrayList;
    }
}
