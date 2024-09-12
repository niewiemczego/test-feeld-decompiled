package kotlin.reflect.jvm.internal.impl.types;

/* compiled from: TypeCapabilities.kt */
public interface CustomTypeParameter {
    boolean isTypeParameter();

    KotlinType substitutionResult(KotlinType kotlinType);
}
