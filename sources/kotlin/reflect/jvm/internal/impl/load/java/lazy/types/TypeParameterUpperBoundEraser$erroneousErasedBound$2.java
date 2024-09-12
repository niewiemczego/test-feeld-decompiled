package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* compiled from: TypeParameterUpperBoundEraser.kt */
final class TypeParameterUpperBoundEraser$erroneousErasedBound$2 extends Lambda implements Function0<ErrorType> {
    final /* synthetic */ TypeParameterUpperBoundEraser this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TypeParameterUpperBoundEraser$erroneousErasedBound$2(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser) {
        super(0);
        this.this$0 = typeParameterUpperBoundEraser;
    }

    public final ErrorType invoke() {
        return ErrorUtils.createErrorType(ErrorTypeKind.CANNOT_COMPUTE_ERASED_BOUND, this.this$0.toString());
    }
}
