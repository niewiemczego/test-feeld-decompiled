package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ErrorModuleDescriptor.kt */
public final class ErrorModuleDescriptor implements ModuleDescriptor {
    public static final ErrorModuleDescriptor INSTANCE = new ErrorModuleDescriptor();
    private static final List<ModuleDescriptor> allDependencyModules = CollectionsKt.emptyList();
    private static final Set<ModuleDescriptor> allExpectedByModules = SetsKt.emptySet();
    private static final KotlinBuiltIns builtIns = DefaultBuiltIns.Companion.getInstance();
    private static final List<ModuleDescriptor> expectedByModules = CollectionsKt.emptyList();
    private static final Name stableName;

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        Intrinsics.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
        return null;
    }

    public <T> T getCapability(ModuleCapability<T> moduleCapability) {
        Intrinsics.checkNotNullParameter(moduleCapability, "capability");
        return null;
    }

    public DeclarationDescriptor getContainingDeclaration() {
        return null;
    }

    public boolean shouldSeeInternalsOf(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "targetModule");
        return false;
    }

    private ErrorModuleDescriptor() {
    }

    static {
        Name special = Name.special(ErrorEntity.ERROR_MODULE.getDebugText());
        Intrinsics.checkNotNullExpressionValue(special, "special(ErrorEntity.ERROR_MODULE.debugText)");
        stableName = special;
    }

    public Name getStableName() {
        return stableName;
    }

    public List<ModuleDescriptor> getExpectedByModules() {
        return expectedByModules;
    }

    public Annotations getAnnotations() {
        return Annotations.Companion.getEMPTY();
    }

    public KotlinBuiltIns getBuiltIns() {
        return builtIns;
    }

    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return CollectionsKt.emptyList();
    }

    public Name getName() {
        return getStableName();
    }

    public PackageViewDescriptor getPackage(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        throw new IllegalStateException("Should not be called!");
    }

    public DeclarationDescriptor getOriginal() {
        return this;
    }
}
