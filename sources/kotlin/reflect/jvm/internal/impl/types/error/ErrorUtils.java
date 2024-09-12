package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* compiled from: ErrorUtils.kt */
public final class ErrorUtils {
    public static final ErrorUtils INSTANCE = new ErrorUtils();
    private static final ErrorClassDescriptor errorClass;
    private static final ModuleDescriptor errorModule = ErrorModuleDescriptor.INSTANCE;
    private static final PropertyDescriptor errorProperty;
    private static final Set<PropertyDescriptor> errorPropertyGroup;
    private static final KotlinType errorPropertyType = createErrorType(ErrorTypeKind.ERROR_PROPERTY_TYPE, new String[0]);
    private static final KotlinType errorTypeForLoopInSupertypes = createErrorType(ErrorTypeKind.CYCLIC_SUPERTYPES, new String[0]);

    private ErrorUtils() {
    }

    static {
        String format = String.format(ErrorEntity.ERROR_CLASS.getDebugText(), Arrays.copyOf(new Object[]{"unknown class"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        Name special = Name.special(format);
        Intrinsics.checkNotNullExpressionValue(special, "special(ErrorEntity.ERRO….format(\"unknown class\"))");
        errorClass = new ErrorClassDescriptor(special);
        PropertyDescriptor errorPropertyDescriptor = new ErrorPropertyDescriptor();
        errorProperty = errorPropertyDescriptor;
        errorPropertyGroup = SetsKt.setOf(errorPropertyDescriptor);
    }

    public final ModuleDescriptor getErrorModule() {
        return errorModule;
    }

    public final ErrorClassDescriptor getErrorClass() {
        return errorClass;
    }

    public final KotlinType getErrorTypeForLoopInSupertypes() {
        return errorTypeForLoopInSupertypes;
    }

    public final KotlinType getErrorPropertyType() {
        return errorPropertyType;
    }

    public final Set<PropertyDescriptor> getErrorPropertyGroup() {
        return errorPropertyGroup;
    }

    @JvmStatic
    public static final ErrorScope createErrorScope(ErrorScopeKind errorScopeKind, String... strArr) {
        Intrinsics.checkNotNullParameter(errorScopeKind, "kind");
        Intrinsics.checkNotNullParameter(strArr, "formatParams");
        return createErrorScope(errorScopeKind, false, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @JvmStatic
    public static final ErrorScope createErrorScope(ErrorScopeKind errorScopeKind, boolean z, String... strArr) {
        Intrinsics.checkNotNullParameter(errorScopeKind, "kind");
        Intrinsics.checkNotNullParameter(strArr, "formatParams");
        return z ? new ThrowingScope(errorScopeKind, (String[]) Arrays.copyOf(strArr, strArr.length)) : new ErrorScope(errorScopeKind, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @JvmStatic
    public static final ErrorType createErrorType(ErrorTypeKind errorTypeKind, String... strArr) {
        Intrinsics.checkNotNullParameter(errorTypeKind, "kind");
        Intrinsics.checkNotNullParameter(strArr, "formatParams");
        return INSTANCE.createErrorTypeWithArguments(errorTypeKind, CollectionsKt.emptyList(), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final ErrorType createErrorType(ErrorTypeKind errorTypeKind, TypeConstructor typeConstructor, String... strArr) {
        Intrinsics.checkNotNullParameter(errorTypeKind, "kind");
        Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
        Intrinsics.checkNotNullParameter(strArr, "formatParams");
        return createErrorTypeWithArguments(errorTypeKind, CollectionsKt.emptyList(), typeConstructor, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final ErrorType createErrorTypeWithArguments(ErrorTypeKind errorTypeKind, List<? extends TypeProjection> list, String... strArr) {
        Intrinsics.checkNotNullParameter(errorTypeKind, "kind");
        Intrinsics.checkNotNullParameter(list, "arguments");
        Intrinsics.checkNotNullParameter(strArr, "formatParams");
        return createErrorTypeWithArguments(errorTypeKind, list, createErrorTypeConstructor(errorTypeKind, (String[]) Arrays.copyOf(strArr, strArr.length)), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final ErrorType createErrorTypeWithArguments(ErrorTypeKind errorTypeKind, List<? extends TypeProjection> list, TypeConstructor typeConstructor, String... strArr) {
        Intrinsics.checkNotNullParameter(errorTypeKind, "kind");
        Intrinsics.checkNotNullParameter(list, "arguments");
        Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
        Intrinsics.checkNotNullParameter(strArr, "formatParams");
        return new ErrorType(typeConstructor, createErrorScope(ErrorScopeKind.ERROR_TYPE_SCOPE, typeConstructor.toString()), errorTypeKind, list, false, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final ErrorTypeConstructor createErrorTypeConstructor(ErrorTypeKind errorTypeKind, String... strArr) {
        Intrinsics.checkNotNullParameter(errorTypeKind, "kind");
        Intrinsics.checkNotNullParameter(strArr, "formatParams");
        return new ErrorTypeConstructor(errorTypeKind, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @JvmStatic
    public static final boolean isError(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            ErrorUtils errorUtils = INSTANCE;
            if (errorUtils.isErrorClass(declarationDescriptor) || errorUtils.isErrorClass(declarationDescriptor.getContainingDeclaration()) || declarationDescriptor == errorModule) {
                return true;
            }
        }
        return false;
    }

    private final boolean isErrorClass(DeclarationDescriptor declarationDescriptor) {
        return declarationDescriptor instanceof ErrorClassDescriptor;
    }

    @JvmStatic
    public static final boolean isUninferredTypeVariable(KotlinType kotlinType) {
        if (kotlinType == null) {
            return false;
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (!(constructor instanceof ErrorTypeConstructor) || ((ErrorTypeConstructor) constructor).getKind() != ErrorTypeKind.UNINFERRED_TYPE_VARIABLE) {
            return false;
        }
        return true;
    }
}
