package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: AbstractTypeAliasDescriptor.kt */
final class AbstractTypeAliasDescriptor$isInner$1 extends Lambda implements Function1<UnwrappedType, Boolean> {
    final /* synthetic */ AbstractTypeAliasDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractTypeAliasDescriptor$isInner$1(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        super(1);
        this.this$0 = abstractTypeAliasDescriptor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        if (((r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) && !kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) ((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r5).getContainingDeclaration(), (java.lang.Object) r0)) != false) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke(kotlin.reflect.jvm.internal.impl.types.UnwrappedType r5) {
        /*
            r4 = this;
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            r0 = r5
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0
            boolean r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(r0)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0031
            kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor r0 = r4.this$0
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r5 = r5.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r5 = r5.getDeclarationDescriptor()
            boolean r3 = r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
            if (r3 == 0) goto L_0x002d
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r5
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r5 = r5.getContainingDeclaration()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r0)
            if (r5 != 0) goto L_0x002d
            r5 = r1
            goto L_0x002e
        L_0x002d:
            r5 = r2
        L_0x002e:
            if (r5 == 0) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r1 = r2
        L_0x0032:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$isInner$1.invoke(kotlin.reflect.jvm.internal.impl.types.UnwrappedType):java.lang.Boolean");
    }
}
