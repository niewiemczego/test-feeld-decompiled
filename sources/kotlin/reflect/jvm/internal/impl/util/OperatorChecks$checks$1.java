package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* compiled from: modifierChecks.kt */
final class OperatorChecks$checks$1 extends Lambda implements Function1<FunctionDescriptor, String> {
    public static final OperatorChecks$checks$1 INSTANCE = new OperatorChecks$checks$1();

    OperatorChecks$checks$1() {
        super(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
        if ((!kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.declaresOrInheritsDefaultValue(r4) && r4.getVarargElementType() == null) == true) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String invoke(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4) {
        /*
            r3 = this;
            java.lang.String r0 = "$this$$receiver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.List r4 = r4.getValueParameters()
            java.lang.String r0 = "valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            java.lang.Object r4 = kotlin.collections.CollectionsKt.lastOrNull(r4)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r4
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L_0x002b
            boolean r2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.declaresOrInheritsDefaultValue(r4)
            if (r2 != 0) goto L_0x0027
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r4.getVarargElementType()
            if (r4 != 0) goto L_0x0027
            r4 = r0
            goto L_0x0028
        L_0x0027:
            r4 = r1
        L_0x0028:
            if (r4 != r0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r0 = r1
        L_0x002c:
            kotlin.reflect.jvm.internal.impl.util.OperatorChecks r4 = kotlin.reflect.jvm.internal.impl.util.OperatorChecks.INSTANCE
            kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks r4 = (kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks) r4
            if (r0 != 0) goto L_0x0035
            java.lang.String r4 = "last parameter should not have a default value or be a vararg"
            goto L_0x0036
        L_0x0035:
            r4 = 0
        L_0x0036:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$1.invoke(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor):java.lang.String");
    }
}
