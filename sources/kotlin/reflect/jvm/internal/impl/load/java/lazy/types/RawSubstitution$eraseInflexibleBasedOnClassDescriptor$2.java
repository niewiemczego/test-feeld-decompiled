package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: RawType.kt */
final class RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2 extends Lambda implements Function1<KotlinTypeRefiner, SimpleType> {
    final /* synthetic */ JavaTypeAttributes $attr;
    final /* synthetic */ ClassDescriptor $declaration;
    final /* synthetic */ SimpleType $type;
    final /* synthetic */ RawSubstitution this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2(ClassDescriptor classDescriptor, RawSubstitution rawSubstitution, SimpleType simpleType, JavaTypeAttributes javaTypeAttributes) {
        super(1);
        this.$declaration = classDescriptor;
        this.this$0 = rawSubstitution;
        this.$type = simpleType;
        this.$attr = javaTypeAttributes;
    }

    public final SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
        ClassId classId;
        ClassDescriptor findClassAcrossModuleDependencies;
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        ClassDescriptor classDescriptor = this.$declaration;
        if (!(classDescriptor instanceof ClassDescriptor)) {
            classDescriptor = null;
        }
        if (classDescriptor == null || (classId = DescriptorUtilsKt.getClassId(classDescriptor)) == null || (findClassAcrossModuleDependencies = kotlinTypeRefiner.findClassAcrossModuleDependencies(classId)) == null || Intrinsics.areEqual((Object) findClassAcrossModuleDependencies, (Object) this.$declaration)) {
            return null;
        }
        return (SimpleType) this.this$0.eraseInflexibleBasedOnClassDescriptor(this.$type, findClassAcrossModuleDependencies, this.$attr).getFirst();
    }
}
