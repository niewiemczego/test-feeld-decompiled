package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* compiled from: AbstractSignatureParts.kt */
public abstract class AbstractSignatureParts<TAnnotation> {
    public abstract AbstractAnnotationTypeQualifierResolver<TAnnotation> getAnnotationTypeQualifierResolver();

    public abstract Iterable<TAnnotation> getAnnotations(KotlinTypeMarker kotlinTypeMarker);

    public abstract Iterable<TAnnotation> getContainerAnnotations();

    public abstract AnnotationQualifierApplicabilityType getContainerApplicabilityType();

    public abstract JavaTypeQualifiersByElementType getContainerDefaultTypeQualifiers();

    public abstract boolean getContainerIsVarargParameter();

    public abstract boolean getEnableImprovementsInStrictMode();

    public abstract KotlinTypeMarker getEnhancedForWarnings(KotlinTypeMarker kotlinTypeMarker);

    public boolean getForceOnlyHeadTypeConstructor() {
        return false;
    }

    public abstract boolean getForceWarning(TAnnotation tannotation);

    public abstract FqNameUnsafe getFqNameUnsafe(KotlinTypeMarker kotlinTypeMarker);

    public abstract boolean getSkipRawTypeArguments();

    public abstract TypeSystemContext getTypeSystem();

    public abstract boolean isArrayOrPrimitiveArray(KotlinTypeMarker kotlinTypeMarker);

    public abstract boolean isCovariant();

    public abstract boolean isEqual(KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2);

    public abstract boolean isFromJava(TypeParameterMarker typeParameterMarker);

    public boolean isNotNullTypeParameterCompat(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return false;
    }

    private final NullabilityQualifier getNullabilityQualifier(KotlinTypeMarker kotlinTypeMarker) {
        TypeSystemContext typeSystem = getTypeSystem();
        if (typeSystem.isMarkedNullable(typeSystem.lowerBoundIfFlexible(kotlinTypeMarker))) {
            return NullabilityQualifier.NULLABLE;
        }
        if (!typeSystem.isMarkedNullable(typeSystem.upperBoundIfFlexible(kotlinTypeMarker))) {
            return NullabilityQualifier.NOT_NULL;
        }
        return null;
    }

    private final JavaTypeQualifiers extractQualifiers(KotlinTypeMarker kotlinTypeMarker) {
        NullabilityQualifier nullabilityQualifier;
        NullabilityQualifier nullabilityQualifier2 = getNullabilityQualifier(kotlinTypeMarker);
        MutabilityQualifier mutabilityQualifier = null;
        if (nullabilityQualifier2 == null) {
            KotlinTypeMarker enhancedForWarnings = getEnhancedForWarnings(kotlinTypeMarker);
            nullabilityQualifier = enhancedForWarnings != null ? getNullabilityQualifier(enhancedForWarnings) : null;
        } else {
            nullabilityQualifier = nullabilityQualifier2;
        }
        TypeSystemContext typeSystem = getTypeSystem();
        if (JavaToKotlinClassMap.INSTANCE.isReadOnly(getFqNameUnsafe(typeSystem.lowerBoundIfFlexible(kotlinTypeMarker)))) {
            mutabilityQualifier = MutabilityQualifier.READ_ONLY;
        } else if (JavaToKotlinClassMap.INSTANCE.isMutable(getFqNameUnsafe(typeSystem.upperBoundIfFlexible(kotlinTypeMarker)))) {
            mutabilityQualifier = MutabilityQualifier.MUTABLE;
        }
        boolean z = false;
        boolean z2 = getTypeSystem().isDefinitelyNotNullType(kotlinTypeMarker) || isNotNullTypeParameterCompat(kotlinTypeMarker);
        if (nullabilityQualifier != nullabilityQualifier2) {
            z = true;
        }
        return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, z2, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0138, code lost:
        if ((r0 != null && r0.getDefinitelyNotNull()) != false) goto L_0x013d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0162  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers extractQualifiersFromAnnotations(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers r12) {
        /*
            r11 = this;
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r0 = r12.getType()
            r1 = 0
            if (r0 != 0) goto L_0x0022
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r0 = r11.getTypeSystem()
            kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r2 = r12.getTypeParameterForArgument()
            if (r2 == 0) goto L_0x0016
            kotlin.reflect.jvm.internal.impl.types.model.TypeVariance r0 = r0.getVariance((kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker) r2)
            goto L_0x0017
        L_0x0016:
            r0 = r1
        L_0x0017:
            kotlin.reflect.jvm.internal.impl.types.model.TypeVariance r2 = kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.IN
            if (r0 != r2) goto L_0x0022
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers$Companion r12 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers.Companion
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r12 = r12.getNONE()
            return r12
        L_0x0022:
            kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r0 = r12.getTypeParameterForArgument()
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x002c
            r0 = r2
            goto L_0x002d
        L_0x002c:
            r0 = r3
        L_0x002d:
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r4 = r12.getType()
            if (r4 == 0) goto L_0x0039
            java.lang.Iterable r4 = r11.getAnnotations(r4)
            if (r4 != 0) goto L_0x003f
        L_0x0039:
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
        L_0x003f:
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r5 = r11.getTypeSystem()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r6 = r12.getType()
            if (r6 == 0) goto L_0x0054
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r6 = r5.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r6)
            if (r6 == 0) goto L_0x0054
            kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r5 = r5.getTypeParameterClassifier(r6)
            goto L_0x0055
        L_0x0054:
            r5 = r1
        L_0x0055:
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r6 = r11.getContainerApplicabilityType()
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r7 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS
            if (r6 != r7) goto L_0x005f
            r6 = r2
            goto L_0x0060
        L_0x005f:
            r6 = r3
        L_0x0060:
            if (r0 != 0) goto L_0x0063
            goto L_0x00b9
        L_0x0063:
            if (r6 != 0) goto L_0x00af
            boolean r7 = r11.getEnableImprovementsInStrictMode()
            if (r7 == 0) goto L_0x00af
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r7 = r12.getType()
            if (r7 == 0) goto L_0x0079
            boolean r7 = r11.isArrayOrPrimitiveArray(r7)
            if (r7 != r2) goto L_0x0079
            r7 = r2
            goto L_0x007a
        L_0x0079:
            r7 = r3
        L_0x007a:
            if (r7 == 0) goto L_0x00af
            java.lang.Iterable r7 = r11.getContainerAnnotations()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x008b:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00a4
            java.lang.Object r9 = r7.next()
            kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver r10 = r11.getAnnotationTypeQualifierResolver()
            boolean r10 = r10.isTypeUseAnnotation(r9)
            r10 = r10 ^ r2
            if (r10 == 0) goto L_0x008b
            r8.add(r9)
            goto L_0x008b
        L_0x00a4:
            java.util.List r8 = (java.util.List) r8
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.List r4 = kotlin.collections.CollectionsKt.plus(r8, r4)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            goto L_0x00b9
        L_0x00af:
            java.lang.Iterable r7 = r11.getContainerAnnotations()
            java.util.List r4 = kotlin.collections.CollectionsKt.plus(r7, r4)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
        L_0x00b9:
            kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver r7 = r11.getAnnotationTypeQualifierResolver()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r7 = r7.extractMutability(r4)
            kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver r8 = r11.getAnnotationTypeQualifierResolver()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$extractQualifiersFromAnnotations$annotationsNullability$1 r9 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$extractQualifiersFromAnnotations$annotationsNullability$1
            r9.<init>(r11)
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r4 = r8.extractNullability(r4, r9)
            if (r4 == 0) goto L_0x00ec
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r12 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r0 = r4.getQualifier()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r1 = r4.getQualifier()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            if (r1 != r6) goto L_0x00e3
            if (r5 == 0) goto L_0x00e3
            goto L_0x00e4
        L_0x00e3:
            r2 = r3
        L_0x00e4:
            boolean r1 = r4.isForWarningOnly()
            r12.<init>(r0, r7, r2, r1)
            return r12
        L_0x00ec:
            if (r0 != 0) goto L_0x00f4
            if (r6 == 0) goto L_0x00f1
            goto L_0x00f4
        L_0x00f1:
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r0 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.TYPE_USE
            goto L_0x00f8
        L_0x00f4:
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r0 = r11.getContainerApplicabilityType()
        L_0x00f8:
            kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType r4 = r12.getDefaultQualifiers()
            if (r4 == 0) goto L_0x0103
            kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers r0 = r4.get(r0)
            goto L_0x0104
        L_0x0103:
            r0 = r1
        L_0x0104:
            if (r5 == 0) goto L_0x010b
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r4 = r11.getBoundsNullability(r5)
            goto L_0x010c
        L_0x010b:
            r4 = r1
        L_0x010c:
            r6 = 2
            if (r4 == 0) goto L_0x0117
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r8 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r8 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus.copy$default(r4, r8, r3, r6, r1)
            if (r8 != 0) goto L_0x011f
        L_0x0117:
            if (r0 == 0) goto L_0x011e
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r8 = r0.getNullabilityQualifier()
            goto L_0x011f
        L_0x011e:
            r8 = r1
        L_0x011f:
            if (r4 == 0) goto L_0x0126
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r4 = r4.getQualifier()
            goto L_0x0127
        L_0x0126:
            r4 = r1
        L_0x0127:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r9 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            if (r4 == r9) goto L_0x013d
            if (r5 == 0) goto L_0x013b
            if (r0 == 0) goto L_0x0137
            boolean r0 = r0.getDefinitelyNotNull()
            if (r0 != r2) goto L_0x0137
            r0 = r2
            goto L_0x0138
        L_0x0137:
            r0 = r3
        L_0x0138:
            if (r0 == 0) goto L_0x013b
            goto L_0x013d
        L_0x013b:
            r0 = r3
            goto L_0x013e
        L_0x013d:
            r0 = r2
        L_0x013e:
            kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r12 = r12.getTypeParameterForArgument()
            if (r12 == 0) goto L_0x0159
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r12 = r11.getBoundsNullability(r12)
            if (r12 == 0) goto L_0x0159
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r4 = r12.getQualifier()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            if (r4 != r5) goto L_0x015a
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r4 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r12 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus.copy$default(r12, r4, r3, r6, r1)
            goto L_0x015a
        L_0x0159:
            r12 = r1
        L_0x015a:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r12 = r11.mostSpecific(r12, r8)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r4 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers
            if (r12 == 0) goto L_0x0166
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r1 = r12.getQualifier()
        L_0x0166:
            if (r12 == 0) goto L_0x016f
            boolean r12 = r12.isForWarningOnly()
            if (r12 != r2) goto L_0x016f
            goto L_0x0170
        L_0x016f:
            r2 = r3
        L_0x0170:
            r4.<init>(r1, r7, r0, r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.extractQualifiersFromAnnotations(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$TypeAndDefaultQualifiers):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers");
    }

    private final NullabilityQualifierWithMigrationStatus mostSpecific(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2) {
        if (nullabilityQualifierWithMigrationStatus == null) {
            return nullabilityQualifierWithMigrationStatus2;
        }
        if (nullabilityQualifierWithMigrationStatus2 == null) {
            return nullabilityQualifierWithMigrationStatus;
        }
        if (nullabilityQualifierWithMigrationStatus.isForWarningOnly() && !nullabilityQualifierWithMigrationStatus2.isForWarningOnly()) {
            return nullabilityQualifierWithMigrationStatus2;
        }
        if (nullabilityQualifierWithMigrationStatus.isForWarningOnly() || !nullabilityQualifierWithMigrationStatus2.isForWarningOnly()) {
            return (nullabilityQualifierWithMigrationStatus.getQualifier().compareTo(nullabilityQualifierWithMigrationStatus2.getQualifier()) >= 0 && nullabilityQualifierWithMigrationStatus.getQualifier().compareTo(nullabilityQualifierWithMigrationStatus2.getQualifier()) > 0) ? nullabilityQualifierWithMigrationStatus : nullabilityQualifierWithMigrationStatus2;
        }
        return nullabilityQualifierWithMigrationStatus;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00f2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00c9 A[EDGE_INSN: B:86:0x00c9->B:56:0x00c9 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus getBoundsNullability(kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r9) {
        /*
            r8 = this;
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r0 = r8.getTypeSystem()
            boolean r1 = r8.isFromJava(r9)
            r2 = 0
            if (r1 != 0) goto L_0x000c
            return r2
        L_0x000c:
            java.util.List r9 = r0.getUpperBounds(r9)
            r1 = r9
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r3 = r1 instanceof java.util.Collection
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0024
            r6 = r1
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x0024
        L_0x0022:
            r6 = r5
            goto L_0x003b
        L_0x0024:
            java.util.Iterator r6 = r1.iterator()
        L_0x0028:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0022
            java.lang.Object r7 = r6.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r7 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r7
            boolean r7 = r0.isError(r7)
            if (r7 != 0) goto L_0x0028
            r6 = r4
        L_0x003b:
            if (r6 == 0) goto L_0x003e
            return r2
        L_0x003e:
            if (r3 == 0) goto L_0x004b
            r6 = r1
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x004b
        L_0x0049:
            r6 = r4
            goto L_0x0067
        L_0x004b:
            java.util.Iterator r6 = r1.iterator()
        L_0x004f:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0049
            java.lang.Object r7 = r6.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r7 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r7
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r7 = r8.getNullabilityQualifier(r7)
            if (r7 == 0) goto L_0x0063
            r7 = r5
            goto L_0x0064
        L_0x0063:
            r7 = r4
        L_0x0064:
            if (r7 == 0) goto L_0x004f
            r6 = r5
        L_0x0067:
            if (r6 == 0) goto L_0x006b
            r2 = r9
            goto L_0x00b9
        L_0x006b:
            if (r3 == 0) goto L_0x0078
            r3 = r1
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0078
        L_0x0076:
            r3 = r4
            goto L_0x0094
        L_0x0078:
            java.util.Iterator r3 = r1.iterator()
        L_0x007c:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x0076
            java.lang.Object r6 = r3.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r6 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r6
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r6 = r8.getEnhancedForWarnings(r6)
            if (r6 == 0) goto L_0x0090
            r6 = r5
            goto L_0x0091
        L_0x0090:
            r6 = r4
        L_0x0091:
            if (r6 == 0) goto L_0x007c
            r3 = r5
        L_0x0094:
            if (r3 == 0) goto L_0x00f2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r1 = r1.iterator()
        L_0x00a1:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00b7
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r3
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3 = r8.getEnhancedForWarnings(r3)
            if (r3 == 0) goto L_0x00a1
            r2.add(r3)
            goto L_0x00a1
        L_0x00b7:
            java.util.List r2 = (java.util.List) r2
        L_0x00b9:
            r1 = r2
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r3 = r1 instanceof java.util.Collection
            if (r3 == 0) goto L_0x00cb
            r3 = r1
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x00cb
        L_0x00c9:
            r0 = r5
            goto L_0x00e2
        L_0x00cb:
            java.util.Iterator r1 = r1.iterator()
        L_0x00cf:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00c9
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r3
            boolean r3 = r0.isNullableType(r3)
            if (r3 != 0) goto L_0x00cf
            r0 = r4
        L_0x00e2:
            if (r0 == 0) goto L_0x00e7
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            goto L_0x00e9
        L_0x00e7:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
        L_0x00e9:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r1 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
            if (r2 == r9) goto L_0x00ee
            r4 = r5
        L_0x00ee:
            r1.<init>(r0, r4)
            return r1
        L_0x00f2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.getBoundsNullability(kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006a, code lost:
        if (r10 != false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a9, code lost:
        r8 = r8.getType();
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> computeIndexedQualifiers(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r10, java.lang.Iterable<? extends kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> r11, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo r12, boolean r13) {
        /*
            r9 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "overrides"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.util.List r0 = r9.toIndexed(r10)
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r11, r2)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r2 = r11.iterator()
        L_0x001f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0033
            java.lang.Object r3 = r2.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r3
            java.util.List r3 = r9.toIndexed(r3)
            r1.add(r3)
            goto L_0x001f
        L_0x0033:
            java.util.List r1 = (java.util.List) r1
            boolean r2 = r9.getForceOnlyHeadTypeConstructor()
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L_0x006f
            boolean r2 = r9.isCovariant()
            if (r2 == 0) goto L_0x006d
            boolean r2 = r11 instanceof java.util.Collection
            if (r2 == 0) goto L_0x0052
            r2 = r11
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0052
        L_0x0050:
            r10 = r3
            goto L_0x006a
        L_0x0052:
            java.util.Iterator r11 = r11.iterator()
        L_0x0056:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L_0x0050
            java.lang.Object r2 = r11.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r2 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r2
            boolean r2 = r9.isEqual(r10, r2)
            r2 = r2 ^ r4
            if (r2 == 0) goto L_0x0056
            r10 = r4
        L_0x006a:
            if (r10 == 0) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r10 = r3
            goto L_0x0070
        L_0x006f:
            r10 = r4
        L_0x0070:
            if (r10 == 0) goto L_0x0074
            r10 = r4
            goto L_0x0078
        L_0x0074:
            int r10 = r0.size()
        L_0x0078:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers[] r11 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers[r10]
            r2 = r3
        L_0x007b:
            if (r2 >= r10) goto L_0x00de
            java.lang.Object r5 = r0.get(r2)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$TypeAndDefaultQualifiers r5 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers) r5
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r5 = r9.extractQualifiersFromAnnotations(r5)
            r6 = r1
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r6 = r6.iterator()
        L_0x0095:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x00bb
            java.lang.Object r8 = r6.next()
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r8 = kotlin.collections.CollectionsKt.getOrNull(r8, r2)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$TypeAndDefaultQualifiers r8 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers) r8
            if (r8 == 0) goto L_0x00b4
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r8 = r8.getType()
            if (r8 == 0) goto L_0x00b4
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r8 = r9.extractQualifiers(r8)
            goto L_0x00b5
        L_0x00b4:
            r8 = 0
        L_0x00b5:
            if (r8 == 0) goto L_0x0095
            r7.add(r8)
            goto L_0x0095
        L_0x00bb:
            java.util.List r7 = (java.util.List) r7
            java.util.Collection r7 = (java.util.Collection) r7
            if (r2 != 0) goto L_0x00c9
            boolean r6 = r9.isCovariant()
            if (r6 == 0) goto L_0x00c9
            r6 = r4
            goto L_0x00ca
        L_0x00c9:
            r6 = r3
        L_0x00ca:
            if (r2 != 0) goto L_0x00d4
            boolean r8 = r9.getContainerIsVarargParameter()
            if (r8 == 0) goto L_0x00d4
            r8 = r4
            goto L_0x00d5
        L_0x00d4:
            r8 = r3
        L_0x00d5:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt.computeQualifiersForOverride(r5, r7, r6, r8, r13)
            r11[r2] = r5
            int r2 = r2 + 1
            goto L_0x007b
        L_0x00de:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$computeIndexedQualifiers$1 r10 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$computeIndexedQualifiers$1
            r10.<init>(r12, r11)
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.computeIndexedQualifiers(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker, java.lang.Iterable, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo, boolean):kotlin.jvm.functions.Function1");
    }

    private final <T> void flattenTree(T t, List<T> list, Function1<? super T, ? extends Iterable<? extends T>> function1) {
        list.add(t);
        Iterable<Object> iterable = (Iterable) function1.invoke(t);
        if (iterable != null) {
            for (Object flattenTree : iterable) {
                flattenTree(flattenTree, list, function1);
            }
        }
    }

    private final <T> List<T> flattenTree(T t, Function1<? super T, ? extends Iterable<? extends T>> function1) {
        List<T> arrayList = new ArrayList<>(1);
        flattenTree(t, arrayList, function1);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(KotlinTypeMarker kotlinTypeMarker, JavaTypeQualifiersByElementType javaTypeQualifiersByElementType) {
        return getAnnotationTypeQualifierResolver().extractAndMergeDefaultQualifiers(javaTypeQualifiersByElementType, getAnnotations(kotlinTypeMarker));
    }

    private final List<TypeAndDefaultQualifiers> toIndexed(KotlinTypeMarker kotlinTypeMarker) {
        return flattenTree(new TypeAndDefaultQualifiers(kotlinTypeMarker, extractAndMergeDefaultQualifiers(kotlinTypeMarker, getContainerDefaultTypeQualifiers()), (TypeParameterMarker) null), new AbstractSignatureParts$toIndexed$1$1(this, getTypeSystem()));
    }

    /* compiled from: AbstractSignatureParts.kt */
    private static final class TypeAndDefaultQualifiers {
        private final JavaTypeQualifiersByElementType defaultQualifiers;
        private final KotlinTypeMarker type;
        private final TypeParameterMarker typeParameterForArgument;

        public TypeAndDefaultQualifiers(KotlinTypeMarker kotlinTypeMarker, JavaTypeQualifiersByElementType javaTypeQualifiersByElementType, TypeParameterMarker typeParameterMarker) {
            this.type = kotlinTypeMarker;
            this.defaultQualifiers = javaTypeQualifiersByElementType;
            this.typeParameterForArgument = typeParameterMarker;
        }

        public final KotlinTypeMarker getType() {
            return this.type;
        }

        public final JavaTypeQualifiersByElementType getDefaultQualifiers() {
            return this.defaultQualifiers;
        }

        public final TypeParameterMarker getTypeParameterForArgument() {
            return this.typeParameterForArgument;
        }
    }
}
