package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: JavaToKotlinClassMapper.kt */
public final class JavaToKotlinClassMapper {
    public static final JavaToKotlinClassMapper INSTANCE = new JavaToKotlinClassMapper();

    private JavaToKotlinClassMapper() {
    }

    public final Collection<ClassDescriptor> mapPlatformClass(FqName fqName, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        ClassDescriptor mapJavaToKotlin$default = mapJavaToKotlin$default(this, fqName, kotlinBuiltIns, (Integer) null, 4, (Object) null);
        if (mapJavaToKotlin$default == null) {
            return SetsKt.emptySet();
        }
        FqName readOnlyToMutable = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtilsKt.getFqNameUnsafe(mapJavaToKotlin$default));
        if (readOnlyToMutable == null) {
            return SetsKt.setOf(mapJavaToKotlin$default);
        }
        ClassDescriptor builtInClassByFqName = kotlinBuiltIns.getBuiltInClassByFqName(readOnlyToMutable);
        Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "builtIns.getBuiltInClass…otlinMutableAnalogFqName)");
        return CollectionsKt.listOf(mapJavaToKotlin$default, builtInClassByFqName);
    }

    public static /* synthetic */ ClassDescriptor mapJavaToKotlin$default(JavaToKotlinClassMapper javaToKotlinClassMapper, FqName fqName, KotlinBuiltIns kotlinBuiltIns, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return javaToKotlinClassMapper.mapJavaToKotlin(fqName, kotlinBuiltIns, num);
    }

    public final ClassDescriptor mapJavaToKotlin(FqName fqName, KotlinBuiltIns kotlinBuiltIns, Integer num) {
        ClassId classId;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        if (num == null || !Intrinsics.areEqual((Object) fqName, (Object) JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME())) {
            classId = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(fqName);
        } else {
            classId = StandardNames.getFunctionClassId(num.intValue());
        }
        if (classId != null) {
            return kotlinBuiltIns.getBuiltInClassByFqName(classId.asSingleFqName());
        }
        return null;
    }

    public final boolean isMutable(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "mutable");
        return JavaToKotlinClassMap.INSTANCE.isMutable(DescriptorUtils.getFqName(classDescriptor));
    }

    public final boolean isReadOnly(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "readOnly");
        return JavaToKotlinClassMap.INSTANCE.isReadOnly(DescriptorUtils.getFqName(classDescriptor));
    }

    public final ClassDescriptor convertMutableToReadOnly(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "mutable");
        DeclarationDescriptor declarationDescriptor = classDescriptor;
        FqName mutableToReadOnly = JavaToKotlinClassMap.INSTANCE.mutableToReadOnly(DescriptorUtils.getFqName(declarationDescriptor));
        if (mutableToReadOnly != null) {
            ClassDescriptor builtInClassByFqName = DescriptorUtilsKt.getBuiltIns(declarationDescriptor).getBuiltInClassByFqName(mutableToReadOnly);
            Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Given class " + classDescriptor + " is not a " + "mutable" + " collection");
    }

    public final ClassDescriptor convertReadOnlyToMutable(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "readOnly");
        DeclarationDescriptor declarationDescriptor = classDescriptor;
        FqName readOnlyToMutable = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtils.getFqName(declarationDescriptor));
        if (readOnlyToMutable != null) {
            ClassDescriptor builtInClassByFqName = DescriptorUtilsKt.getBuiltIns(declarationDescriptor).getBuiltInClassByFqName(readOnlyToMutable);
            Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Given class " + classDescriptor + " is not a " + "read-only" + " collection");
    }
}
