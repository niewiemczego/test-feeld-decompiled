package kotlin.reflect.jvm.internal.impl.resolve;

import com.braze.Constants;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: DescriptorEquivalenceForOverrides.kt */
public final class DescriptorEquivalenceForOverrides {
    public static final DescriptorEquivalenceForOverrides INSTANCE = new DescriptorEquivalenceForOverrides();

    public final boolean areTypeParametersEquivalent(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean z) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, Constants.BRAZE_PUSH_CONTENT_KEY);
        Intrinsics.checkNotNullParameter(typeParameterDescriptor2, "b");
        return areTypeParametersEquivalent$default(this, typeParameterDescriptor, typeParameterDescriptor2, z, (Function2) null, 8, (Object) null);
    }

    private DescriptorEquivalenceForOverrides() {
    }

    public static /* synthetic */ boolean areEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        return descriptorEquivalenceForOverrides.areEquivalent(declarationDescriptor, declarationDescriptor2, z, z2);
    }

    public final boolean areEquivalent(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, boolean z, boolean z2) {
        if ((declarationDescriptor instanceof ClassDescriptor) && (declarationDescriptor2 instanceof ClassDescriptor)) {
            return areClassesEquivalent((ClassDescriptor) declarationDescriptor, (ClassDescriptor) declarationDescriptor2);
        }
        if ((declarationDescriptor instanceof TypeParameterDescriptor) && (declarationDescriptor2 instanceof TypeParameterDescriptor)) {
            return areTypeParametersEquivalent$default(this, (TypeParameterDescriptor) declarationDescriptor, (TypeParameterDescriptor) declarationDescriptor2, z, (Function2) null, 8, (Object) null);
        } else if ((declarationDescriptor instanceof CallableDescriptor) && (declarationDescriptor2 instanceof CallableDescriptor)) {
            return areCallableDescriptorsEquivalent$default(this, (CallableDescriptor) declarationDescriptor, (CallableDescriptor) declarationDescriptor2, z, z2, false, KotlinTypeRefiner.Default.INSTANCE, 16, (Object) null);
        } else if (!(declarationDescriptor instanceof PackageFragmentDescriptor) || !(declarationDescriptor2 instanceof PackageFragmentDescriptor)) {
            return Intrinsics.areEqual((Object) declarationDescriptor, (Object) declarationDescriptor2);
        } else {
            return Intrinsics.areEqual((Object) ((PackageFragmentDescriptor) declarationDescriptor).getFqName(), (Object) ((PackageFragmentDescriptor) declarationDescriptor2).getFqName());
        }
    }

    private final boolean areClassesEquivalent(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        return Intrinsics.areEqual((Object) classDescriptor.getTypeConstructor(), (Object) classDescriptor2.getTypeConstructor());
    }

    public static /* synthetic */ boolean areTypeParametersEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 8) != 0) {
            function2 = DescriptorEquivalenceForOverrides$areTypeParametersEquivalent$1.INSTANCE;
        }
        return descriptorEquivalenceForOverrides.areTypeParametersEquivalent(typeParameterDescriptor, typeParameterDescriptor2, z, function2);
    }

    public final boolean areTypeParametersEquivalent(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean z, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> function2) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, Constants.BRAZE_PUSH_CONTENT_KEY);
        Intrinsics.checkNotNullParameter(typeParameterDescriptor2, "b");
        Intrinsics.checkNotNullParameter(function2, "equivalentCallables");
        if (Intrinsics.areEqual((Object) typeParameterDescriptor, (Object) typeParameterDescriptor2)) {
            return true;
        }
        if (Intrinsics.areEqual((Object) typeParameterDescriptor.getContainingDeclaration(), (Object) typeParameterDescriptor2.getContainingDeclaration()) || !ownersEquivalent(typeParameterDescriptor, typeParameterDescriptor2, function2, z)) {
            return false;
        }
        if (typeParameterDescriptor.getIndex() == typeParameterDescriptor2.getIndex()) {
            return true;
        }
        return false;
    }

    private final SourceElement singleSource(CallableDescriptor callableDescriptor) {
        while (callableDescriptor instanceof CallableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) callableDescriptor;
            if (callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
            CallableMemberDescriptor callableMemberDescriptor2 = (CallableMemberDescriptor) CollectionsKt.singleOrNull(overriddenDescriptors);
            if (callableMemberDescriptor2 == null) {
                return null;
            }
            callableDescriptor = callableMemberDescriptor2;
        }
        return callableDescriptor.getSource();
    }

    public static /* synthetic */ boolean areCallableDescriptorsEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z, boolean z2, boolean z3, KotlinTypeRefiner kotlinTypeRefiner, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            z3 = false;
        }
        return descriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent(callableDescriptor, callableDescriptor2, z, z4, z3, kotlinTypeRefiner);
    }

    public final boolean areCallableDescriptorsEquivalent(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z, boolean z2, boolean z3, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(callableDescriptor, Constants.BRAZE_PUSH_CONTENT_KEY);
        Intrinsics.checkNotNullParameter(callableDescriptor2, "b");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (Intrinsics.areEqual((Object) callableDescriptor, (Object) callableDescriptor2)) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) callableDescriptor.getName(), (Object) callableDescriptor2.getName())) {
            return false;
        }
        if (z2 && (callableDescriptor instanceof MemberDescriptor) && (callableDescriptor2 instanceof MemberDescriptor) && ((MemberDescriptor) callableDescriptor).isExpect() != ((MemberDescriptor) callableDescriptor2).isExpect()) {
            return false;
        }
        if (Intrinsics.areEqual((Object) callableDescriptor.getContainingDeclaration(), (Object) callableDescriptor2.getContainingDeclaration()) && (!z || !Intrinsics.areEqual((Object) singleSource(callableDescriptor), (Object) singleSource(callableDescriptor2)))) {
            return false;
        }
        DeclarationDescriptor declarationDescriptor = callableDescriptor;
        if (!DescriptorUtils.isLocal(declarationDescriptor)) {
            DeclarationDescriptor declarationDescriptor2 = callableDescriptor2;
            if (DescriptorUtils.isLocal(declarationDescriptor2) || !ownersEquivalent(declarationDescriptor, declarationDescriptor2, DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$1.INSTANCE, z)) {
                return false;
            }
            OverridingUtil create = OverridingUtil.create(kotlinTypeRefiner, new DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1(z, callableDescriptor, callableDescriptor2));
            Intrinsics.checkNotNullExpressionValue(create, "a: CallableDescriptor,\n …= a && y == b }\n        }");
            if (create.isOverridableBy(callableDescriptor, callableDescriptor2, (ClassDescriptor) null, !z3).getResult() == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE && create.isOverridableBy(callableDescriptor2, callableDescriptor, (ClassDescriptor) null, !z3).getResult() == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                return true;
            }
            return false;
        }
        return false;
    }

    private final boolean ownersEquivalent(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> function2, boolean z) {
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        DeclarationDescriptor containingDeclaration2 = declarationDescriptor2.getContainingDeclaration();
        if ((containingDeclaration instanceof CallableMemberDescriptor) || (containingDeclaration2 instanceof CallableMemberDescriptor)) {
            return function2.invoke(containingDeclaration, containingDeclaration2).booleanValue();
        }
        return areEquivalent$default(this, containingDeclaration, containingDeclaration2, z, false, 8, (Object) null);
    }
}
