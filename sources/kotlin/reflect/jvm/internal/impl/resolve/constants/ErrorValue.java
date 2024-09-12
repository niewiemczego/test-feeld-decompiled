package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* compiled from: constantValues.kt */
public abstract class ErrorValue extends ConstantValue<Unit> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public ErrorValue() {
        super(Unit.INSTANCE);
    }

    public Unit getValue() {
        throw new UnsupportedOperationException();
    }

    /* compiled from: constantValues.kt */
    public static final class ErrorValueWithMessage extends ErrorValue {
        private final String message;

        public ErrorValueWithMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        public ErrorType getType(ModuleDescriptor moduleDescriptor) {
            Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
            return ErrorUtils.createErrorType(ErrorTypeKind.ERROR_CONSTANT_VALUE, this.message);
        }

        public String toString() {
            return this.message;
        }
    }

    /* compiled from: constantValues.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ErrorValue create(String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new ErrorValueWithMessage(str);
        }
    }
}
