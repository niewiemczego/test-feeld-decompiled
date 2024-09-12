package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: FunctionClassDescriptor.kt */
public final class FunctionClassDescriptor extends AbstractClassDescriptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ClassId functionClassId = new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, Name.identifier("Function"));
    /* access modifiers changed from: private */
    public static final ClassId kFunctionClassId = new ClassId(StandardNames.KOTLIN_REFLECT_FQ_NAME, Name.identifier("KFunction"));
    private final int arity;
    /* access modifiers changed from: private */
    public final PackageFragmentDescriptor containingDeclaration;
    private final FunctionClassKind functionKind;
    private final FunctionClassScope memberScope;
    /* access modifiers changed from: private */
    public final List<TypeParameterDescriptor> parameters;
    /* access modifiers changed from: private */
    public final StorageManager storageManager;
    private final FunctionTypeConstructor typeConstructor = new FunctionTypeConstructor();

    public Void getCompanionObjectDescriptor() {
        return null;
    }

    public Void getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        return null;
    }

    public boolean isActual() {
        return false;
    }

    public boolean isCompanionObject() {
        return false;
    }

    public boolean isData() {
        return false;
    }

    public boolean isExpect() {
        return false;
    }

    public boolean isExternal() {
        return false;
    }

    public boolean isFun() {
        return false;
    }

    public boolean isInline() {
        return false;
    }

    public boolean isInner() {
        return false;
    }

    public boolean isValue() {
        return false;
    }

    public final FunctionClassKind getFunctionKind() {
        return this.functionKind;
    }

    public final int getArity() {
        return this.arity;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionClassDescriptor(StorageManager storageManager2, PackageFragmentDescriptor packageFragmentDescriptor, FunctionClassKind functionClassKind, int i) {
        super(storageManager2, functionClassKind.numberedClassName(i));
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "containingDeclaration");
        Intrinsics.checkNotNullParameter(functionClassKind, "functionKind");
        this.storageManager = storageManager2;
        this.containingDeclaration = packageFragmentDescriptor;
        this.functionKind = functionClassKind;
        this.arity = i;
        this.memberScope = new FunctionClassScope(storageManager2, this);
        ArrayList arrayList = new ArrayList();
        Iterable intRange = new IntRange(1, i);
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator it = intRange.iterator();
        while (it.hasNext()) {
            _init_$typeParameter(arrayList, this, Variance.IN_VARIANCE, new StringBuilder().append('P').append(((IntIterator) it).nextInt()).toString());
            arrayList2.add(Unit.INSTANCE);
        }
        List list = (List) arrayList2;
        _init_$typeParameter(arrayList, this, Variance.OUT_VARIANCE, "R");
        this.parameters = CollectionsKt.toList(arrayList);
    }

    private static final void _init_$typeParameter(ArrayList<TypeParameterDescriptor> arrayList, FunctionClassDescriptor functionClassDescriptor, Variance variance, String str) {
        arrayList.add(TypeParameterDescriptorImpl.createWithDefaultBound(functionClassDescriptor, Annotations.Companion.getEMPTY(), false, variance, Name.identifier(str), arrayList.size(), functionClassDescriptor.storageManager));
    }

    public PackageFragmentDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    public MemberScope.Empty getStaticScope() {
        return MemberScope.Empty.INSTANCE;
    }

    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    /* access modifiers changed from: protected */
    public FunctionClassScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.memberScope;
    }

    public List<ClassConstructorDescriptor> getConstructors() {
        return CollectionsKt.emptyList();
    }

    public ClassKind getKind() {
        return ClassKind.INTERFACE;
    }

    public Modality getModality() {
        return Modality.ABSTRACT;
    }

    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = DescriptorVisibilities.PUBLIC;
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "PUBLIC");
        return descriptorVisibility;
    }

    public Annotations getAnnotations() {
        return Annotations.Companion.getEMPTY();
    }

    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        return sourceElement;
    }

    public List<ClassDescriptor> getSealedSubclasses() {
        return CollectionsKt.emptyList();
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.parameters;
    }

    /* compiled from: FunctionClassDescriptor.kt */
    private final class FunctionTypeConstructor extends AbstractClassTypeConstructor {

        /* compiled from: FunctionClassDescriptor.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FunctionClassKind.values().length];
                iArr[FunctionClassKind.Function.ordinal()] = 1;
                iArr[FunctionClassKind.KFunction.ordinal()] = 2;
                iArr[FunctionClassKind.SuspendFunction.ordinal()] = 3;
                iArr[FunctionClassKind.KSuspendFunction.ordinal()] = 4;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public boolean isDenotable() {
            return true;
        }

        public FunctionTypeConstructor() {
            super(FunctionClassDescriptor.this.storageManager);
        }

        /* access modifiers changed from: protected */
        public Collection<KotlinType> computeSupertypes() {
            List list;
            int i = WhenMappings.$EnumSwitchMapping$0[FunctionClassDescriptor.this.getFunctionKind().ordinal()];
            if (i == 1) {
                list = CollectionsKt.listOf(FunctionClassDescriptor.functionClassId);
            } else if (i == 2) {
                list = CollectionsKt.listOf(FunctionClassDescriptor.kFunctionClassId, new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, FunctionClassKind.Function.numberedClassName(FunctionClassDescriptor.this.getArity())));
            } else if (i == 3) {
                list = CollectionsKt.listOf(FunctionClassDescriptor.functionClassId);
            } else if (i == 4) {
                list = CollectionsKt.listOf(FunctionClassDescriptor.kFunctionClassId, new ClassId(StandardNames.COROUTINES_PACKAGE_FQ_NAME, FunctionClassKind.SuspendFunction.numberedClassName(FunctionClassDescriptor.this.getArity())));
            } else {
                throw new NoWhenBranchMatchedException();
            }
            ModuleDescriptor containingDeclaration = FunctionClassDescriptor.this.containingDeclaration.getContainingDeclaration();
            Iterable<ClassId> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (ClassId classId : iterable) {
                ClassDescriptor findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(containingDeclaration, classId);
                if (findClassAcrossModuleDependencies != null) {
                    Iterable<TypeParameterDescriptor> takeLast = CollectionsKt.takeLast(getParameters(), findClassAcrossModuleDependencies.getTypeConstructor().getParameters().size());
                    Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(takeLast, 10));
                    for (TypeParameterDescriptor defaultType : takeLast) {
                        arrayList2.add(new TypeProjectionImpl(defaultType.getDefaultType()));
                    }
                    arrayList.add(KotlinTypeFactory.simpleNotNullType(TypeAttributes.Companion.getEmpty(), findClassAcrossModuleDependencies, (List) arrayList2));
                } else {
                    throw new IllegalStateException(("Built-in class " + classId + " not found").toString());
                }
            }
            return CollectionsKt.toList((List) arrayList);
        }

        public List<TypeParameterDescriptor> getParameters() {
            return FunctionClassDescriptor.this.parameters;
        }

        public FunctionClassDescriptor getDeclarationDescriptor() {
            return FunctionClassDescriptor.this;
        }

        public String toString() {
            return getDeclarationDescriptor().toString();
        }

        /* access modifiers changed from: protected */
        public SupertypeLoopChecker getSupertypeLoopChecker() {
            return SupertypeLoopChecker.EMPTY.INSTANCE;
        }
    }

    public String toString() {
        String asString = getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        return asString;
    }

    /* compiled from: FunctionClassDescriptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
