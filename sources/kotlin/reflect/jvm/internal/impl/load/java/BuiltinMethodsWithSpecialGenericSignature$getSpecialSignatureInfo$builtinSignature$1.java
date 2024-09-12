package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* compiled from: specialBuiltinMembers.kt */
final class BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1 extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    public static final BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1 INSTANCE = new BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1();

    BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1() {
        super(1);
    }

    public final Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "it");
        return Boolean.valueOf((callableMemberDescriptor instanceof FunctionDescriptor) && BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getHasErasedValueParametersInJava(callableMemberDescriptor));
    }
}
