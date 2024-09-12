package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.DefaultTypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

public class LazySubstitutingClassDescriptor extends ModuleAwareClassDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private List<TypeParameterDescriptor> declaredTypeParameters;
    private TypeSubstitutor newSubstitutor;
    private final ModuleAwareClassDescriptor original;
    private final TypeSubstitutor originalSubstitutor;
    private TypeConstructor typeConstructor;
    private List<TypeParameterDescriptor> typeConstructorParameters;

    /* JADX WARNING: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c8 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e5 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static /* synthetic */ void $$$reportNull$$$0(int r15) {
        /*
            r0 = 23
            r1 = 13
            r2 = 10
            r3 = 8
            r4 = 6
            r5 = 5
            r6 = 3
            r7 = 2
            if (r15 == r7) goto L_0x001f
            if (r15 == r6) goto L_0x001f
            if (r15 == r5) goto L_0x001f
            if (r15 == r4) goto L_0x001f
            if (r15 == r3) goto L_0x001f
            if (r15 == r2) goto L_0x001f
            if (r15 == r1) goto L_0x001f
            if (r15 == r0) goto L_0x001f
            java.lang.String r8 = "@NotNull method %s.%s must not return null"
            goto L_0x0021
        L_0x001f:
            java.lang.String r8 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
        L_0x0021:
            if (r15 == r7) goto L_0x0033
            if (r15 == r6) goto L_0x0033
            if (r15 == r5) goto L_0x0033
            if (r15 == r4) goto L_0x0033
            if (r15 == r3) goto L_0x0033
            if (r15 == r2) goto L_0x0033
            if (r15 == r1) goto L_0x0033
            if (r15 == r0) goto L_0x0033
            r9 = r7
            goto L_0x0034
        L_0x0033:
            r9 = r6
        L_0x0034:
            java.lang.Object[] r9 = new java.lang.Object[r9]
            java.lang.String r10 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor"
            r11 = 0
            if (r15 == r7) goto L_0x005c
            if (r15 == r6) goto L_0x0057
            if (r15 == r5) goto L_0x0051
            if (r15 == r4) goto L_0x0057
            if (r15 == r3) goto L_0x005c
            if (r15 == r2) goto L_0x0051
            if (r15 == r1) goto L_0x0057
            if (r15 == r0) goto L_0x004c
            r9[r11] = r10
            goto L_0x0061
        L_0x004c:
            java.lang.String r12 = "substitutor"
            r9[r11] = r12
            goto L_0x0061
        L_0x0051:
            java.lang.String r12 = "typeSubstitution"
            r9[r11] = r12
            goto L_0x0061
        L_0x0057:
            java.lang.String r12 = "kotlinTypeRefiner"
            r9[r11] = r12
            goto L_0x0061
        L_0x005c:
            java.lang.String r12 = "typeArguments"
            r9[r11] = r12
        L_0x0061:
            java.lang.String r11 = "substitute"
            java.lang.String r12 = "getUnsubstitutedMemberScope"
            java.lang.String r13 = "getMemberScope"
            r14 = 1
            switch(r15) {
                case 2: goto L_0x00c4;
                case 3: goto L_0x00c4;
                case 4: goto L_0x00c1;
                case 5: goto L_0x00c4;
                case 6: goto L_0x00c4;
                case 7: goto L_0x00c1;
                case 8: goto L_0x00c4;
                case 9: goto L_0x00c1;
                case 10: goto L_0x00c4;
                case 11: goto L_0x00c1;
                case 12: goto L_0x00be;
                case 13: goto L_0x00c4;
                case 14: goto L_0x00be;
                case 15: goto L_0x00b9;
                case 16: goto L_0x00b4;
                case 17: goto L_0x00af;
                case 18: goto L_0x00aa;
                case 19: goto L_0x00a5;
                case 20: goto L_0x00a0;
                case 21: goto L_0x009b;
                case 22: goto L_0x0096;
                case 23: goto L_0x00c4;
                case 24: goto L_0x0093;
                case 25: goto L_0x008e;
                case 26: goto L_0x0089;
                case 27: goto L_0x0084;
                case 28: goto L_0x007f;
                case 29: goto L_0x007a;
                case 30: goto L_0x0075;
                case 31: goto L_0x0070;
                default: goto L_0x006b;
            }
        L_0x006b:
            java.lang.String r10 = "getTypeConstructor"
            r9[r14] = r10
            goto L_0x00c6
        L_0x0070:
            java.lang.String r10 = "getSealedSubclasses"
            r9[r14] = r10
            goto L_0x00c6
        L_0x0075:
            java.lang.String r10 = "getDeclaredTypeParameters"
            r9[r14] = r10
            goto L_0x00c6
        L_0x007a:
            java.lang.String r10 = "getSource"
            r9[r14] = r10
            goto L_0x00c6
        L_0x007f:
            java.lang.String r10 = "getUnsubstitutedInnerClassesScope"
            r9[r14] = r10
            goto L_0x00c6
        L_0x0084:
            java.lang.String r10 = "getVisibility"
            r9[r14] = r10
            goto L_0x00c6
        L_0x0089:
            java.lang.String r10 = "getModality"
            r9[r14] = r10
            goto L_0x00c6
        L_0x008e:
            java.lang.String r10 = "getKind"
            r9[r14] = r10
            goto L_0x00c6
        L_0x0093:
            r9[r14] = r11
            goto L_0x00c6
        L_0x0096:
            java.lang.String r10 = "getContainingDeclaration"
            r9[r14] = r10
            goto L_0x00c6
        L_0x009b:
            java.lang.String r10 = "getOriginal"
            r9[r14] = r10
            goto L_0x00c6
        L_0x00a0:
            java.lang.String r10 = "getName"
            r9[r14] = r10
            goto L_0x00c6
        L_0x00a5:
            java.lang.String r10 = "getAnnotations"
            r9[r14] = r10
            goto L_0x00c6
        L_0x00aa:
            java.lang.String r10 = "getConstructors"
            r9[r14] = r10
            goto L_0x00c6
        L_0x00af:
            java.lang.String r10 = "getContextReceivers"
            r9[r14] = r10
            goto L_0x00c6
        L_0x00b4:
            java.lang.String r10 = "getDefaultType"
            r9[r14] = r10
            goto L_0x00c6
        L_0x00b9:
            java.lang.String r10 = "getStaticScope"
            r9[r14] = r10
            goto L_0x00c6
        L_0x00be:
            r9[r14] = r12
            goto L_0x00c6
        L_0x00c1:
            r9[r14] = r13
            goto L_0x00c6
        L_0x00c4:
            r9[r14] = r10
        L_0x00c6:
            if (r15 == r7) goto L_0x00dd
            if (r15 == r6) goto L_0x00dd
            if (r15 == r5) goto L_0x00dd
            if (r15 == r4) goto L_0x00dd
            if (r15 == r3) goto L_0x00dd
            if (r15 == r2) goto L_0x00dd
            if (r15 == r1) goto L_0x00da
            if (r15 == r0) goto L_0x00d7
            goto L_0x00df
        L_0x00d7:
            r9[r7] = r11
            goto L_0x00df
        L_0x00da:
            r9[r7] = r12
            goto L_0x00df
        L_0x00dd:
            r9[r7] = r13
        L_0x00df:
            java.lang.String r8 = java.lang.String.format(r8, r9)
            if (r15 == r7) goto L_0x00f9
            if (r15 == r6) goto L_0x00f9
            if (r15 == r5) goto L_0x00f9
            if (r15 == r4) goto L_0x00f9
            if (r15 == r3) goto L_0x00f9
            if (r15 == r2) goto L_0x00f9
            if (r15 == r1) goto L_0x00f9
            if (r15 == r0) goto L_0x00f9
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            r15.<init>(r8)
            goto L_0x00fe
        L_0x00f9:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            r15.<init>(r8)
        L_0x00fe:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.LazySubstitutingClassDescriptor.$$$reportNull$$$0(int):void");
    }

    public LazySubstitutingClassDescriptor(ModuleAwareClassDescriptor moduleAwareClassDescriptor, TypeSubstitutor typeSubstitutor) {
        this.original = moduleAwareClassDescriptor;
        this.originalSubstitutor = typeSubstitutor;
    }

    private TypeSubstitutor getSubstitutor() {
        if (this.newSubstitutor == null) {
            if (this.originalSubstitutor.isEmpty()) {
                this.newSubstitutor = this.originalSubstitutor;
            } else {
                List<TypeParameterDescriptor> parameters = this.original.getTypeConstructor().getParameters();
                this.typeConstructorParameters = new ArrayList(parameters.size());
                this.newSubstitutor = DescriptorSubstitutor.substituteTypeParameters(parameters, this.originalSubstitutor.getSubstitution(), this, this.typeConstructorParameters);
                this.declaredTypeParameters = CollectionsKt.filter(this.typeConstructorParameters, new Function1<TypeParameterDescriptor, Boolean>() {
                    public Boolean invoke(TypeParameterDescriptor typeParameterDescriptor) {
                        return Boolean.valueOf(!typeParameterDescriptor.isCapturedFromOuterDeclaration());
                    }
                });
            }
        }
        return this.newSubstitutor;
    }

    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor2 = this.original.getTypeConstructor();
        if (this.originalSubstitutor.isEmpty()) {
            if (typeConstructor2 == null) {
                $$$reportNull$$$0(0);
            }
            return typeConstructor2;
        }
        if (this.typeConstructor == null) {
            TypeSubstitutor substitutor = getSubstitutor();
            Collection<KotlinType> supertypes = typeConstructor2.getSupertypes();
            ArrayList arrayList = new ArrayList(supertypes.size());
            for (KotlinType substitute : supertypes) {
                arrayList.add(substitutor.substitute(substitute, Variance.INVARIANT));
            }
            this.typeConstructor = new ClassTypeConstructorImpl(this, this.typeConstructorParameters, arrayList, LockBasedStorageManager.NO_LOCKS);
        }
        TypeConstructor typeConstructor3 = this.typeConstructor;
        if (typeConstructor3 == null) {
            $$$reportNull$$$0(1);
        }
        return typeConstructor3;
    }

    public MemberScope getMemberScope(TypeSubstitution typeSubstitution, KotlinTypeRefiner kotlinTypeRefiner) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(5);
        }
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(6);
        }
        MemberScope memberScope = this.original.getMemberScope(typeSubstitution, kotlinTypeRefiner);
        if (!this.originalSubstitutor.isEmpty()) {
            return new SubstitutingScope(memberScope, getSubstitutor());
        }
        if (memberScope == null) {
            $$$reportNull$$$0(7);
        }
        return memberScope;
    }

    public MemberScope getMemberScope(TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(10);
        }
        MemberScope memberScope = getMemberScope(typeSubstitution, DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
        if (memberScope == null) {
            $$$reportNull$$$0(11);
        }
        return memberScope;
    }

    public MemberScope getUnsubstitutedMemberScope() {
        MemberScope unsubstitutedMemberScope = getUnsubstitutedMemberScope(DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this.original)));
        if (unsubstitutedMemberScope == null) {
            $$$reportNull$$$0(12);
        }
        return unsubstitutedMemberScope;
    }

    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(13);
        }
        MemberScope unsubstitutedMemberScope = this.original.getUnsubstitutedMemberScope(kotlinTypeRefiner);
        if (!this.originalSubstitutor.isEmpty()) {
            return new SubstitutingScope(unsubstitutedMemberScope, getSubstitutor());
        }
        if (unsubstitutedMemberScope == null) {
            $$$reportNull$$$0(14);
        }
        return unsubstitutedMemberScope;
    }

    public MemberScope getStaticScope() {
        MemberScope staticScope = this.original.getStaticScope();
        if (staticScope == null) {
            $$$reportNull$$$0(15);
        }
        return staticScope;
    }

    public SimpleType getDefaultType() {
        SimpleType simpleTypeWithNonTrivialMemberScope = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(DefaultTypeAttributeTranslator.INSTANCE.toAttributes(getAnnotations(), (TypeConstructor) null, (DeclarationDescriptor) null), getTypeConstructor(), TypeUtils.getDefaultTypeProjections(getTypeConstructor().getParameters()), false, getUnsubstitutedMemberScope());
        if (simpleTypeWithNonTrivialMemberScope == null) {
            $$$reportNull$$$0(16);
        }
        return simpleTypeWithNonTrivialMemberScope;
    }

    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        throw new UnsupportedOperationException();
    }

    public List<ReceiverParameterDescriptor> getContextReceivers() {
        List<ReceiverParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList == null) {
            $$$reportNull$$$0(17);
        }
        return emptyList;
    }

    public Collection<ClassConstructorDescriptor> getConstructors() {
        Collection<ClassConstructorDescriptor> constructors = this.original.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.size());
        for (ClassConstructorDescriptor next : constructors) {
            arrayList.add(((ClassConstructorDescriptor) next.newCopyBuilder().setOriginal(next.getOriginal()).setModality(next.getModality()).setVisibility(next.getVisibility()).setKind(next.getKind()).setCopyOverrides(false).build()).substitute(getSubstitutor()));
        }
        return arrayList;
    }

    public Annotations getAnnotations() {
        Annotations annotations = this.original.getAnnotations();
        if (annotations == null) {
            $$$reportNull$$$0(19);
        }
        return annotations;
    }

    public Name getName() {
        Name name = this.original.getName();
        if (name == null) {
            $$$reportNull$$$0(20);
        }
        return name;
    }

    public ClassDescriptor getOriginal() {
        ClassDescriptor original2 = this.original.getOriginal();
        if (original2 == null) {
            $$$reportNull$$$0(21);
        }
        return original2;
    }

    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor containingDeclaration = this.original.getContainingDeclaration();
        if (containingDeclaration == null) {
            $$$reportNull$$$0(22);
        }
        return containingDeclaration;
    }

    public ClassDescriptor substitute(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(23);
        }
        if (typeSubstitutor.isEmpty()) {
            return this;
        }
        return new LazySubstitutingClassDescriptor(this, TypeSubstitutor.createChainedSubstitutor(typeSubstitutor.getSubstitution(), getSubstitutor().getSubstitution()));
    }

    public ClassDescriptor getCompanionObjectDescriptor() {
        return this.original.getCompanionObjectDescriptor();
    }

    public ClassKind getKind() {
        ClassKind kind = this.original.getKind();
        if (kind == null) {
            $$$reportNull$$$0(25);
        }
        return kind;
    }

    public Modality getModality() {
        Modality modality = this.original.getModality();
        if (modality == null) {
            $$$reportNull$$$0(26);
        }
        return modality;
    }

    public DescriptorVisibility getVisibility() {
        DescriptorVisibility visibility = this.original.getVisibility();
        if (visibility == null) {
            $$$reportNull$$$0(27);
        }
        return visibility;
    }

    public boolean isInner() {
        return this.original.isInner();
    }

    public boolean isData() {
        return this.original.isData();
    }

    public boolean isInline() {
        return this.original.isInline();
    }

    public boolean isFun() {
        return this.original.isFun();
    }

    public boolean isValue() {
        return this.original.isValue();
    }

    public boolean isExternal() {
        return this.original.isExternal();
    }

    public boolean isCompanionObject() {
        return this.original.isCompanionObject();
    }

    public boolean isExpect() {
        return this.original.isExpect();
    }

    public boolean isActual() {
        return this.original.isActual();
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitClassDescriptor(this, d);
    }

    public MemberScope getUnsubstitutedInnerClassesScope() {
        MemberScope unsubstitutedInnerClassesScope = this.original.getUnsubstitutedInnerClassesScope();
        if (unsubstitutedInnerClassesScope == null) {
            $$$reportNull$$$0(28);
        }
        return unsubstitutedInnerClassesScope;
    }

    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return this.original.getUnsubstitutedPrimaryConstructor();
    }

    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        if (sourceElement == null) {
            $$$reportNull$$$0(29);
        }
        return sourceElement;
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        getSubstitutor();
        List<TypeParameterDescriptor> list = this.declaredTypeParameters;
        if (list == null) {
            $$$reportNull$$$0(30);
        }
        return list;
    }

    public Collection<ClassDescriptor> getSealedSubclasses() {
        Collection<ClassDescriptor> sealedSubclasses = this.original.getSealedSubclasses();
        if (sealedSubclasses == null) {
            $$$reportNull$$$0(31);
        }
        return sealedSubclasses;
    }

    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        ValueClassRepresentation<SimpleType> valueClassRepresentation = this.original.getValueClassRepresentation();
        if (valueClassRepresentation == null) {
            return null;
        }
        return valueClassRepresentation.mapUnderlyingType(new Function1<SimpleType, SimpleType>() {
            public SimpleType invoke(SimpleType simpleType) {
                return LazySubstitutingClassDescriptor.this.substituteSimpleType(simpleType);
            }
        });
    }

    /* access modifiers changed from: private */
    public SimpleType substituteSimpleType(SimpleType simpleType) {
        return (simpleType == null || this.originalSubstitutor.isEmpty()) ? simpleType : (SimpleType) getSubstitutor().substitute(simpleType, Variance.INVARIANT);
    }
}
