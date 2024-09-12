package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;

/* compiled from: utils.kt */
public final class UtilsKt {
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType findCorrespondingSupertype(kotlin.reflect.jvm.internal.impl.types.KotlinType r9, kotlin.reflect.jvm.internal.impl.types.KotlinType r10, kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks r11) {
        /*
            java.lang.String r0 = "subtype"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "supertype"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "typeCheckingProcedureCallbacks"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.util.ArrayDeque r0 = new java.util.ArrayDeque
            r0.<init>()
            kotlin.reflect.jvm.internal.impl.types.checker.SubtypePathNode r1 = new kotlin.reflect.jvm.internal.impl.types.checker.SubtypePathNode
            r2 = 0
            r1.<init>(r9, r2)
            r0.add(r1)
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r9 = r10.getConstructor()
        L_0x0022:
            boolean r10 = r0.isEmpty()
            if (r10 != 0) goto L_0x0131
            java.lang.Object r10 = r0.poll()
            kotlin.reflect.jvm.internal.impl.types.checker.SubtypePathNode r10 = (kotlin.reflect.jvm.internal.impl.types.checker.SubtypePathNode) r10
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r10.getType()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r3 = r1.getConstructor()
            boolean r4 = r11.assertEqualTypeConstructors(r3, r9)
            if (r4 == 0) goto L_0x010f
            boolean r0 = r1.isMarkedNullable()
            kotlin.reflect.jvm.internal.impl.types.checker.SubtypePathNode r10 = r10.getPrevious()
        L_0x0044:
            if (r10 == 0) goto L_0x00c7
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r10.getType()
            java.util.List r4 = r3.getArguments()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            boolean r5 = r4 instanceof java.util.Collection
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x0061
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0061
        L_0x005f:
            r4 = r7
            goto L_0x007f
        L_0x0061:
            java.util.Iterator r4 = r4.iterator()
        L_0x0065:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x005f
            java.lang.Object r5 = r4.next()
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r5 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r5
            kotlin.reflect.jvm.internal.impl.types.Variance r5 = r5.getProjectionKind()
            kotlin.reflect.jvm.internal.impl.types.Variance r8 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
            if (r5 == r8) goto L_0x007b
            r5 = r6
            goto L_0x007c
        L_0x007b:
            r5 = r7
        L_0x007c:
            if (r5 == 0) goto L_0x0065
            r4 = r6
        L_0x007f:
            if (r4 == 0) goto L_0x009f
            kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution$Companion r4 = kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion
            kotlin.reflect.jvm.internal.impl.types.TypeSubstitution r4 = r4.create(r3)
            kotlin.reflect.jvm.internal.impl.types.TypeSubstitution r4 = kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(r4, r7, r6, r2)
            kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor r4 = r4.buildSubstitutor()
            kotlin.reflect.jvm.internal.impl.types.Variance r5 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r4.safeSubstitute(r1, r5)
            java.lang.String r4 = "TypeConstructorSubstitut…uted, Variance.INVARIANT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = approximate(r1)
            goto L_0x00b5
        L_0x009f:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution$Companion r4 = kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion
            kotlin.reflect.jvm.internal.impl.types.TypeSubstitution r4 = r4.create(r3)
            kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor r4 = r4.buildSubstitutor()
            kotlin.reflect.jvm.internal.impl.types.Variance r5 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r4.safeSubstitute(r1, r5)
            java.lang.String r4 = "{\n                    Ty…ARIANT)\n                }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
        L_0x00b5:
            if (r0 != 0) goto L_0x00c0
            boolean r0 = r3.isMarkedNullable()
            if (r0 == 0) goto L_0x00be
            goto L_0x00c0
        L_0x00be:
            r0 = r7
            goto L_0x00c1
        L_0x00c0:
            r0 = r6
        L_0x00c1:
            kotlin.reflect.jvm.internal.impl.types.checker.SubtypePathNode r10 = r10.getPrevious()
            goto L_0x0044
        L_0x00c7:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r10 = r1.getConstructor()
            boolean r2 = r11.assertEqualTypeConstructors(r10, r9)
            if (r2 == 0) goto L_0x00d6
            kotlin.reflect.jvm.internal.impl.types.KotlinType r9 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNullableAsSpecified(r1, r0)
            return r9
        L_0x00d6:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Type constructors should be equals!\nsubstitutedSuperType: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = debugInfo(r10)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = ", \n\nsupertype: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = debugInfo(r9)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " \n"
            java.lang.StringBuilder r1 = r1.append(r2)
            boolean r9 = r11.assertEqualTypeConstructors(r10, r9)
            java.lang.StringBuilder r9 = r1.append(r9)
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        L_0x010f:
            java.util.Collection r1 = r3.getSupertypes()
            java.util.Iterator r1 = r1.iterator()
        L_0x0117:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0022
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3
            kotlin.reflect.jvm.internal.impl.types.checker.SubtypePathNode r4 = new kotlin.reflect.jvm.internal.impl.types.checker.SubtypePathNode
            java.lang.String r5 = "immediateSupertype"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            r4.<init>(r3, r10)
            r0.add(r4)
            goto L_0x0117
        L_0x0131:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.checker.UtilsKt.findCorrespondingSupertype(kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks):kotlin.reflect.jvm.internal.impl.types.KotlinType");
    }

    private static final KotlinType approximate(KotlinType kotlinType) {
        return CapturedTypeApproximationKt.approximateCapturedTypes(kotlinType).getUpper();
    }

    private static final String debugInfo(TypeConstructor typeConstructor) {
        StringBuilder sb = new StringBuilder();
        m2274debugInfo$lambda1$unaryPlus("type: " + typeConstructor, sb);
        m2274debugInfo$lambda1$unaryPlus("hashCode: " + typeConstructor.hashCode(), sb);
        m2274debugInfo$lambda1$unaryPlus("javaClass: " + typeConstructor.getClass().getCanonicalName(), sb);
        for (DeclarationDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor(); declarationDescriptor != null; declarationDescriptor = declarationDescriptor.getContainingDeclaration()) {
            m2274debugInfo$lambda1$unaryPlus("fqName: " + DescriptorRenderer.FQ_NAMES_IN_TYPES.render(declarationDescriptor), sb);
            m2274debugInfo$lambda1$unaryPlus("javaClass: " + declarationDescriptor.getClass().getCanonicalName(), sb);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: debugInfo$lambda-1$unaryPlus  reason: not valid java name */
    private static final StringBuilder m2274debugInfo$lambda1$unaryPlus(String str, StringBuilder sb) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder append = sb.append(str);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        StringBuilder append2 = append.append(10);
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        return append2;
    }
}
