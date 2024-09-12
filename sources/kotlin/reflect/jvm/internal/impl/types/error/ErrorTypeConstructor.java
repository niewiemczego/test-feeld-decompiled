package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: ErrorTypeConstructor.kt */
public final class ErrorTypeConstructor implements TypeConstructor {
    private final String debugText;
    private final String[] formatParams;
    private final ErrorTypeKind kind;

    public boolean isDenotable() {
        return false;
    }

    public ErrorTypeConstructor(ErrorTypeKind errorTypeKind, String... strArr) {
        Intrinsics.checkNotNullParameter(errorTypeKind, "kind");
        Intrinsics.checkNotNullParameter(strArr, "formatParams");
        this.kind = errorTypeKind;
        this.formatParams = strArr;
        String debugText2 = ErrorEntity.ERROR_TYPE.getDebugText();
        String debugMessage = errorTypeKind.getDebugMessage();
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length);
        String format = String.format(debugMessage, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        String format2 = String.format(debugText2, Arrays.copyOf(new Object[]{format}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
        this.debugText = format2;
    }

    public final ErrorTypeKind getKind() {
        return this.kind;
    }

    public final String getParam(int i) {
        return this.formatParams[i];
    }

    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    public Collection<KotlinType> getSupertypes() {
        return CollectionsKt.emptyList();
    }

    public ClassifierDescriptor getDeclarationDescriptor() {
        return ErrorUtils.INSTANCE.getErrorClass();
    }

    public KotlinBuiltIns getBuiltIns() {
        return DefaultBuiltIns.Companion.getInstance();
    }

    public String toString() {
        return this.debugText;
    }

    public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}
