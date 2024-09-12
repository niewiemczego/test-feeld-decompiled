package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: AdditionalClassPartsProvider.kt */
public interface AdditionalClassPartsProvider {
    Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor classDescriptor);

    Collection<SimpleFunctionDescriptor> getFunctions(Name name, ClassDescriptor classDescriptor);

    Collection<Name> getFunctionsNames(ClassDescriptor classDescriptor);

    Collection<KotlinType> getSupertypes(ClassDescriptor classDescriptor);

    /* compiled from: AdditionalClassPartsProvider.kt */
    public static final class None implements AdditionalClassPartsProvider {
        public static final None INSTANCE = new None();

        private None() {
        }

        public Collection<KotlinType> getSupertypes(ClassDescriptor classDescriptor) {
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            return CollectionsKt.emptyList();
        }

        public Collection<SimpleFunctionDescriptor> getFunctions(Name name, ClassDescriptor classDescriptor) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            return CollectionsKt.emptyList();
        }

        public Collection<Name> getFunctionsNames(ClassDescriptor classDescriptor) {
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            return CollectionsKt.emptyList();
        }

        public Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor classDescriptor) {
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            return CollectionsKt.emptyList();
        }
    }
}
