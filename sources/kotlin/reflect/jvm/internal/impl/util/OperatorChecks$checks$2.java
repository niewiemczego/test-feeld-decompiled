package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* compiled from: modifierChecks.kt */
final class OperatorChecks$checks$2 extends Lambda implements Function1<FunctionDescriptor, String> {
    public static final OperatorChecks$checks$2 INSTANCE = new OperatorChecks$checks$2();

    OperatorChecks$checks$2() {
        super(1);
    }

    private static final boolean invoke$isAny(DeclarationDescriptor declarationDescriptor) {
        return (declarationDescriptor instanceof ClassDescriptor) && KotlinBuiltIns.isAny((ClassDescriptor) declarationDescriptor);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String invoke(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r5) {
        /*
            r4 = this;
            java.lang.String r0 = "$this$$receiver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.reflect.jvm.internal.impl.util.OperatorChecks r0 = kotlin.reflect.jvm.internal.impl.util.OperatorChecks.INSTANCE
            kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks r0 = (kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks) r0
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r5.getContainingDeclaration()
            java.lang.String r1 = "containingDeclaration"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r0 = invoke$isAny(r0)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0054
            java.util.Collection r5 = r5.getOverriddenDescriptors()
            java.lang.String r0 = "overriddenDescriptors"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            r0 = r5
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0030
        L_0x002e:
            r5 = r2
            goto L_0x0050
        L_0x0030:
            java.util.Iterator r5 = r5.iterator()
        L_0x0034:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x002e
            java.lang.Object r0 = r5.next()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r0.getContainingDeclaration()
            java.lang.String r3 = "it.containingDeclaration"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            boolean r0 = invoke$isAny(r0)
            if (r0 == 0) goto L_0x0034
            r5 = r1
        L_0x0050:
            if (r5 == 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r1 = r2
        L_0x0054:
            if (r1 != 0) goto L_0x0059
            java.lang.String r5 = "must override ''equals()'' in Any"
            goto L_0x005a
        L_0x0059:
            r5 = 0
        L_0x005a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$2.invoke(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor):java.lang.String");
    }
}
