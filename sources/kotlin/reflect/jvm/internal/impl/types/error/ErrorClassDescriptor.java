package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: ErrorClassDescriptor.kt */
public final class ErrorClassDescriptor extends ClassDescriptorImpl {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ErrorClassDescriptor(Name name) {
        super(ErrorUtils.INSTANCE.getErrorModule(), name, Modality.OPEN, ClassKind.CLASS, CollectionsKt.emptyList(), SourceElement.NO_SOURCE, false, LockBasedStorageManager.NO_LOCKS);
        Intrinsics.checkNotNullParameter(name, "name");
        ClassConstructorDescriptorImpl create = ClassConstructorDescriptorImpl.create(this, Annotations.Companion.getEMPTY(), true, SourceElement.NO_SOURCE);
        create.initialize(CollectionsKt.emptyList(), DescriptorVisibilities.INTERNAL);
        Intrinsics.checkNotNullExpressionValue(create, "create(this, Annotations…          )\n            }");
        ErrorScopeKind errorScopeKind = ErrorScopeKind.SCOPE_FOR_ERROR_CLASS;
        String name2 = create.getName().toString();
        Intrinsics.checkNotNullExpressionValue(name2, "errorConstructor.name.toString()");
        MemberScope createErrorScope = ErrorUtils.createErrorScope(errorScopeKind, name2, "");
        create.setReturnType(new ErrorType(ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.ERROR_CLASS, new String[0]), createErrorScope, ErrorTypeKind.ERROR_CLASS, (List) null, false, new String[0], 24, (DefaultConstructorMarker) null));
        initialize(createErrorScope, SetsKt.setOf(create), create);
    }

    public ClassDescriptor substitute(TypeSubstitutor typeSubstitutor) {
        Intrinsics.checkNotNullParameter(typeSubstitutor, "substitutor");
        return this;
    }

    public MemberScope getMemberScope(TypeSubstitution typeSubstitution, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(typeSubstitution, "typeSubstitution");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        ErrorScopeKind errorScopeKind = ErrorScopeKind.SCOPE_FOR_ERROR_CLASS;
        String name = getName().toString();
        Intrinsics.checkNotNullExpressionValue(name, "name.toString()");
        return ErrorUtils.createErrorScope(errorScopeKind, name, typeSubstitution.toString());
    }

    public String toString() {
        String asString = getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        return asString;
    }
}
