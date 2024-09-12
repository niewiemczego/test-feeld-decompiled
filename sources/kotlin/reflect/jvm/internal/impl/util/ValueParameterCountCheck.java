package kotlin.reflect.jvm.internal.impl.util;

import com.braze.Constants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.Check;

/* compiled from: modifierChecks.kt */
public abstract class ValueParameterCountCheck implements Check {
    private final String description;

    public /* synthetic */ ValueParameterCountCheck(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    /* compiled from: modifierChecks.kt */
    public static final class NoValueParameters extends ValueParameterCountCheck {
        public static final NoValueParameters INSTANCE = new NoValueParameters();

        private NoValueParameters() {
            super("must have no value parameters", (DefaultConstructorMarker) null);
        }

        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().isEmpty();
        }
    }

    private ValueParameterCountCheck(String str) {
        this.description = str;
    }

    public String getDescription() {
        return this.description;
    }

    public String invoke(FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    /* compiled from: modifierChecks.kt */
    public static final class SingleValueParameter extends ValueParameterCountCheck {
        public static final SingleValueParameter INSTANCE = new SingleValueParameter();

        private SingleValueParameter() {
            super("must have a single value parameter", (DefaultConstructorMarker) null);
        }

        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() == 1;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class AtLeast extends ValueParameterCountCheck {

        /* renamed from: n  reason: collision with root package name */
        private final int f36n;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AtLeast(int i) {
            super("must have at least " + i + " value parameter" + (i > 1 ? Constants.BRAZE_PUSH_SUMMARY_TEXT_KEY : ""), (DefaultConstructorMarker) null);
            this.f36n = i;
        }

        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() >= this.f36n;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class Equals extends ValueParameterCountCheck {

        /* renamed from: n  reason: collision with root package name */
        private final int f37n;

        public Equals(int i) {
            super("must have exactly " + i + " value parameters", (DefaultConstructorMarker) null);
            this.f37n = i;
        }

        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() == this.f37n;
        }
    }
}
