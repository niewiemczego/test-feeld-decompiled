package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.CallableId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: suspendFunctionTypeUtil.kt */
public final class SuspendFunctionTypeUtilKt {
    public static final FqName KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME = new FqName("kotlin.suspend");
    public static final CallableId KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME_CALLABLE_ID;

    static {
        FqName fqName = StandardNames.BUILT_INS_PACKAGE_FQ_NAME;
        Name identifier = Name.identifier("suspend");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"suspend\")");
        KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME_CALLABLE_ID = new CallableId(fqName, identifier);
    }
}
