package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: findClassInModule.kt */
final class FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2 extends Lambda implements Function1<ClassId, Integer> {
    public static final FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2 INSTANCE = new FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2();

    FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2() {
        super(1);
    }

    public final Integer invoke(ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "it");
        return 0;
    }
}
