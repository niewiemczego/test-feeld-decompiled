package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

/* compiled from: descriptorBasedTypeSignatureMapping.kt */
public final class DescriptorBasedTypeSignatureMappingKt {
    public static /* synthetic */ Object mapType$default(KotlinType kotlinType, JvmTypeFactory jvmTypeFactory, TypeMappingMode typeMappingMode, TypeMappingConfiguration typeMappingConfiguration, JvmDescriptorTypeWriter jvmDescriptorTypeWriter, Function3<Object, Object, Object, Unit> function3, int i, Object obj) {
        if ((i & 32) != 0) {
            function3 = FunctionsKt.getDO_NOTHING_3();
        }
        return mapType(kotlinType, jvmTypeFactory, typeMappingMode, typeMappingConfiguration, jvmDescriptorTypeWriter, function3);
    }

    /* JADX WARNING: type inference failed for: r12v6, types: [java.lang.Object, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T mapType(kotlin.reflect.jvm.internal.impl.types.KotlinType r8, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory<T> r9, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r10, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration<? extends T> r11, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmDescriptorTypeWriter<T> r12, kotlin.jvm.functions.Function3<? super kotlin.reflect.jvm.internal.impl.types.KotlinType, ? super T, ? super kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, kotlin.Unit> r13) {
        /*
            java.lang.String r0 = "kotlinType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "factory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "mode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "typeMappingConfiguration"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "writeGenericType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r11.preprocessType(r8)
            if (r1 == 0) goto L_0x002b
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            java.lang.Object r8 = mapType(r1, r2, r3, r4, r5, r6)
            return r8
        L_0x002b:
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.isSuspendFunctionType(r8)
            if (r0 == 0) goto L_0x0042
            kotlin.reflect.jvm.internal.impl.types.SimpleType r8 = kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt.transformSuspendFunctionToRuntimeFunctionType(r8)
            r0 = r8
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            java.lang.Object r8 = mapType(r0, r1, r2, r3, r4, r5)
            return r8
        L_0x0042:
            kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext r0 = kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext.INSTANCE
            kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext r0 = (kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext) r0
            r1 = r8
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r1 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r1
            java.lang.Object r0 = kotlin.reflect.jvm.internal.impl.load.kotlin.TypeSignatureMappingKt.mapBuiltInType(r0, r1, r9, r10)
            if (r0 == 0) goto L_0x005b
            boolean r11 = r10.getNeedPrimitiveBoxing()
            java.lang.Object r9 = kotlin.reflect.jvm.internal.impl.load.kotlin.TypeSignatureMappingKt.boxTypeIfNeeded(r9, r0, r11)
            r13.invoke(r8, r9, r10)
            return r9
        L_0x005b:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r0 = r8.getConstructor()
            boolean r2 = r0 instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            if (r2 == 0) goto L_0x0081
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r0 = (kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) r0
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = r0.getAlternativeType()
            if (r8 != 0) goto L_0x0073
            java.util.Collection r8 = r0.getSupertypes()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = r11.commonSupertype(r8)
        L_0x0073:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(r8)
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            java.lang.Object r8 = mapType(r0, r1, r2, r3, r4, r5)
            return r8
        L_0x0081:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r0 = r0.getDeclarationDescriptor()
            if (r0 == 0) goto L_0x0206
            r2 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r2
            boolean r3 = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.isError(r2)
            if (r3 == 0) goto L_0x00a1
            java.lang.String r10 = "error/NonExistentClass"
            java.lang.Object r9 = r9.createObjectType(r10)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            r11.processErrorType(r8, r0)
            if (r12 == 0) goto L_0x00a0
            r12.writeClass(r9)
        L_0x00a0:
            return r9
        L_0x00a1:
            boolean r3 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r3 == 0) goto L_0x0127
            boolean r4 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isArray(r8)
            if (r4 == 0) goto L_0x0127
            java.util.List r0 = r8.getArguments()
            int r0 = r0.size()
            r1 = 1
            if (r0 != r1) goto L_0x011f
            java.util.List r8 = r8.getArguments()
            r0 = 0
            java.lang.Object r8 = r8.get(r0)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r8 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r8
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r8.getType()
            java.lang.String r0 = "memberProjection.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            kotlin.reflect.jvm.internal.impl.types.Variance r0 = r8.getProjectionKind()
            kotlin.reflect.jvm.internal.impl.types.Variance r3 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE
            if (r0 != r3) goto L_0x00e4
            java.lang.String r8 = "java/lang/Object"
            java.lang.Object r8 = r9.createObjectType(r8)
            if (r12 == 0) goto L_0x0103
            r12.writeArrayType()
            r12.writeClass(r8)
            r12.writeArrayEnd()
            goto L_0x0103
        L_0x00e4:
            if (r12 == 0) goto L_0x00e9
            r12.writeArrayType()
        L_0x00e9:
            kotlin.reflect.jvm.internal.impl.types.Variance r8 = r8.getProjectionKind()
            java.lang.String r0 = "memberProjection.projectionKind"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r4 = r10.toGenericArgumentMode(r8, r1)
            r3 = r9
            r5 = r11
            r6 = r12
            r7 = r13
            java.lang.Object r8 = mapType(r2, r3, r4, r5, r6, r7)
            if (r12 == 0) goto L_0x0103
            r12.writeArrayEnd()
        L_0x0103:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r11 = 91
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.String r8 = r9.toString(r8)
            java.lang.StringBuilder r8 = r10.append(r8)
            java.lang.String r8 = r8.toString()
            java.lang.Object r8 = r9.createFromString(r8)
            return r8
        L_0x011f:
            java.lang.UnsupportedOperationException r8 = new java.lang.UnsupportedOperationException
            java.lang.String r9 = "arrays must have one type argument"
            r8.<init>(r9)
            throw r8
        L_0x0127:
            if (r3 == 0) goto L_0x019f
            boolean r2 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r2)
            if (r2 == 0) goto L_0x014f
            boolean r2 = r10.getNeedInlineClassWrapping()
            if (r2 != 0) goto L_0x014f
            kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext r2 = kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext.INSTANCE
            kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext r2 = (kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext) r2
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r1 = kotlin.reflect.jvm.internal.impl.types.ExpandedTypeUtilsKt.computeExpandedTypeForInlineClass(r2, r1)
            r2 = r1
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r2
            if (r2 == 0) goto L_0x014f
            kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r4 = r10.wrapInlineClassesMode()
            r3 = r9
            r5 = r11
            r6 = r12
            r7 = r13
            java.lang.Object r8 = mapType(r2, r3, r4, r5, r6, r7)
            return r8
        L_0x014f:
            boolean r12 = r10.isForAnnotationParameter()
            if (r12 == 0) goto L_0x0163
            r12 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r12 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r12
            boolean r12 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isKClass(r12)
            if (r12 == 0) goto L_0x0163
            java.lang.Object r9 = r9.getJavaLangClassType()
            goto L_0x019b
        L_0x0163:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r12 = r0.getOriginal()
            java.lang.String r1 = "descriptor.original"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r1)
            java.lang.Object r12 = r11.getPredefinedTypeForClass(r12)
            if (r12 != 0) goto L_0x019a
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r12 = r0.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r1 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_ENTRY
            if (r12 != r1) goto L_0x0188
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r12 = r0.getContainingDeclaration()
            java.lang.String r0 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r0)
            r0 = r12
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
        L_0x0188:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r12 = r0.getOriginal()
            java.lang.String r0 = "enumClassIfEnumEntry.original"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            java.lang.String r11 = computeInternalName(r12, r11)
            java.lang.Object r9 = r9.createObjectType(r11)
            goto L_0x019b
        L_0x019a:
            r9 = r12
        L_0x019b:
            r13.invoke(r8, r9, r10)
            return r9
        L_0x019f:
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
            if (r1 == 0) goto L_0x01d0
            r13 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r13 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r13
            kotlin.reflect.jvm.internal.impl.types.KotlinType r13 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getRepresentativeUpperBound(r13)
            boolean r8 = r8.isMarkedNullable()
            if (r8 == 0) goto L_0x01b4
            kotlin.reflect.jvm.internal.impl.types.KotlinType r13 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNullable(r13)
        L_0x01b4:
            r1 = r13
            kotlin.jvm.functions.Function3 r6 = kotlin.reflect.jvm.internal.impl.utils.FunctionsKt.getDO_NOTHING_3()
            r5 = 0
            r2 = r9
            r3 = r10
            r4 = r11
            java.lang.Object r8 = mapType(r1, r2, r3, r4, r5, r6)
            if (r12 == 0) goto L_0x01cf
            kotlin.reflect.jvm.internal.impl.name.Name r9 = r0.getName()
            java.lang.String r10 = "descriptor.getName()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            r12.writeTypeVariable(r9, r8)
        L_0x01cf:
            return r8
        L_0x01d0:
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
            if (r1 == 0) goto L_0x01ed
            boolean r1 = r10.getMapTypeAliases()
            if (r1 == 0) goto L_0x01ed
            kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) r0
            kotlin.reflect.jvm.internal.impl.types.SimpleType r8 = r0.getExpandedType()
            r0 = r8
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            java.lang.Object r8 = mapType(r0, r1, r2, r3, r4, r5)
            return r8
        L_0x01ed:
            java.lang.UnsupportedOperationException r9 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Unknown type "
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.StringBuilder r8 = r10.append(r8)
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        L_0x0206:
            java.lang.UnsupportedOperationException r9 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "no descriptor for type constructor of "
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.StringBuilder r8 = r10.append(r8)
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.DescriptorBasedTypeSignatureMappingKt.mapType(kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmDescriptorTypeWriter, kotlin.jvm.functions.Function3):java.lang.Object");
    }

    public static final boolean hasVoidReturnType(CallableDescriptor callableDescriptor) {
        Intrinsics.checkNotNullParameter(callableDescriptor, "descriptor");
        if (callableDescriptor instanceof ConstructorDescriptor) {
            return true;
        }
        KotlinType returnType = callableDescriptor.getReturnType();
        Intrinsics.checkNotNull(returnType);
        if (KotlinBuiltIns.isUnit(returnType)) {
            KotlinType returnType2 = callableDescriptor.getReturnType();
            Intrinsics.checkNotNull(returnType2);
            if (TypeUtils.isNullableType(returnType2) || (callableDescriptor instanceof PropertyGetterDescriptor)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static /* synthetic */ String computeInternalName$default(ClassDescriptor classDescriptor, TypeMappingConfiguration typeMappingConfiguration, int i, Object obj) {
        if ((i & 2) != 0) {
            typeMappingConfiguration = TypeMappingConfigurationImpl.INSTANCE;
        }
        return computeInternalName(classDescriptor, typeMappingConfiguration);
    }

    public static final String computeInternalName(ClassDescriptor classDescriptor, TypeMappingConfiguration<?> typeMappingConfiguration) {
        Intrinsics.checkNotNullParameter(classDescriptor, "klass");
        Intrinsics.checkNotNullParameter(typeMappingConfiguration, "typeMappingConfiguration");
        String predefinedFullInternalNameForClass = typeMappingConfiguration.getPredefinedFullInternalNameForClass(classDescriptor);
        if (predefinedFullInternalNameForClass != null) {
            return predefinedFullInternalNameForClass;
        }
        DeclarationDescriptor containingDeclaration = classDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "klass.containingDeclaration");
        String identifier = SpecialNames.safeIdentifier(classDescriptor.getName()).getIdentifier();
        Intrinsics.checkNotNullExpressionValue(identifier, "safeIdentifier(klass.name).identifier");
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            FqName fqName = ((PackageFragmentDescriptor) containingDeclaration).getFqName();
            if (fqName.isRoot()) {
                return identifier;
            }
            StringBuilder sb = new StringBuilder();
            String asString = fqName.asString();
            Intrinsics.checkNotNullExpressionValue(asString, "fqName.asString()");
            return sb.append(StringsKt.replace$default(asString, '.', (char) IOUtils.DIR_SEPARATOR_UNIX, false, 4, (Object) null)).append(IOUtils.DIR_SEPARATOR_UNIX).append(identifier).toString();
        }
        ClassDescriptor classDescriptor2 = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor2 != null) {
            String predefinedInternalNameForClass = typeMappingConfiguration.getPredefinedInternalNameForClass(classDescriptor2);
            if (predefinedInternalNameForClass == null) {
                predefinedInternalNameForClass = computeInternalName(classDescriptor2, typeMappingConfiguration);
            }
            return predefinedInternalNameForClass + '$' + identifier;
        }
        throw new IllegalArgumentException("Unexpected container: " + containingDeclaration + " for " + classDescriptor);
    }
}
