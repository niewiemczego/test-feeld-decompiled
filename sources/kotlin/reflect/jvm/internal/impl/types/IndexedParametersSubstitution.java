package kotlin.reflect.jvm.internal.impl.types;

import com.google.firebase.dynamiclinks.DynamicLink;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: TypeSubstitution.kt */
public final class IndexedParametersSubstitution extends TypeSubstitution {
    private final boolean approximateContravariantCapturedTypes;
    private final TypeProjection[] arguments;
    private final TypeParameterDescriptor[] parameters;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IndexedParametersSubstitution(TypeParameterDescriptor[] typeParameterDescriptorArr, TypeProjection[] typeProjectionArr, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeParameterDescriptorArr, typeProjectionArr, (i & 4) != 0 ? false : z);
    }

    public final TypeParameterDescriptor[] getParameters() {
        return this.parameters;
    }

    public final TypeProjection[] getArguments() {
        return this.arguments;
    }

    public IndexedParametersSubstitution(TypeParameterDescriptor[] typeParameterDescriptorArr, TypeProjection[] typeProjectionArr, boolean z) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptorArr, DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS);
        Intrinsics.checkNotNullParameter(typeProjectionArr, "arguments");
        this.parameters = typeParameterDescriptorArr;
        this.arguments = typeProjectionArr;
        this.approximateContravariantCapturedTypes = z;
        int length = typeParameterDescriptorArr.length;
        int length2 = typeProjectionArr.length;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IndexedParametersSubstitution(java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> r9, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> r10) {
        /*
            r8 = this;
            java.lang.String r0 = "parameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "argumentsList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.util.Collection r9 = (java.util.Collection) r9
            r0 = 0
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[] r1 = new kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[r0]
            java.lang.Object[] r9 = r9.toArray(r1)
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9, r1)
            r3 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[] r3 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[]) r3
            java.util.Collection r10 = (java.util.Collection) r10
            kotlin.reflect.jvm.internal.impl.types.TypeProjection[] r9 = new kotlin.reflect.jvm.internal.impl.types.TypeProjection[r0]
            java.lang.Object[] r9 = r10.toArray(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9, r1)
            r4 = r9
            kotlin.reflect.jvm.internal.impl.types.TypeProjection[] r4 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection[]) r4
            r5 = 0
            r6 = 4
            r7 = 0
            r2 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution.<init>(java.util.List, java.util.List):void");
    }

    public boolean isEmpty() {
        return this.arguments.length == 0;
    }

    public boolean approximateContravariantCapturedTypes() {
        return this.approximateContravariantCapturedTypes;
    }

    public TypeProjection get(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "key");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        TypeParameterDescriptor typeParameterDescriptor = declarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) declarationDescriptor : null;
        if (typeParameterDescriptor == null) {
            return null;
        }
        int index = typeParameterDescriptor.getIndex();
        TypeParameterDescriptor[] typeParameterDescriptorArr = this.parameters;
        if (index >= typeParameterDescriptorArr.length || !Intrinsics.areEqual((Object) typeParameterDescriptorArr[index].getTypeConstructor(), (Object) typeParameterDescriptor.getTypeConstructor())) {
            return null;
        }
        return this.arguments[index];
    }
}
