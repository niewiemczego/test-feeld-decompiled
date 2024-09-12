package expo.modules.kotlin.records;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.full.KClassifiers;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lexpo/modules/kotlin/records/IsCollectionNotEmptyBinder;", "Lexpo/modules/kotlin/records/ValidationBinder;", "()V", "bind", "Lexpo/modules/kotlin/records/FieldValidator;", "annotation", "", "fieldType", "Lkotlin/reflect/KType;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ValidationBinder.kt */
public final class IsCollectionNotEmptyBinder implements ValidationBinder {
    public FieldValidator<?> bind(Annotation annotation, KType kType) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        Intrinsics.checkNotNullParameter(kType, "fieldType");
        boolean z = annotation instanceof IsNotEmpty;
        if (Intrinsics.areEqual((Object) kType, (Object) KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(int[].class), (List) null, false, (List) null, 7, (Object) null))) {
            return new IsNotEmptyIntArrayValidator();
        }
        if (Intrinsics.areEqual((Object) kType, (Object) KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(double[].class), (List) null, false, (List) null, 7, (Object) null))) {
            return new IsNotEmptyDoubleArrayValidator();
        }
        if (Intrinsics.areEqual((Object) kType, (Object) KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(float[].class), (List) null, false, (List) null, 7, (Object) null))) {
            return new IsNotEmptyFloatArrayValidator();
        }
        KClassifier classifier = kType.getClassifier();
        Intrinsics.checkNotNull(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        KClass kClass = (KClass) classifier;
        if (KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(Object[].class)) || JvmClassMappingKt.getJavaClass(kClass).isArray()) {
            return new IsNotEmptyArrayValidator();
        }
        return new IsNotEmptyCollectionValidator();
    }
}
