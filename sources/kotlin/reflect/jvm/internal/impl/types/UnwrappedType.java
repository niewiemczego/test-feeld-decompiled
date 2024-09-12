package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: KotlinType.kt */
public abstract class UnwrappedType extends KotlinType {
    public /* synthetic */ UnwrappedType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract UnwrappedType makeNullableAsSpecified(boolean z);

    public abstract UnwrappedType refine(KotlinTypeRefiner kotlinTypeRefiner);

    public abstract UnwrappedType replaceAttributes(TypeAttributes typeAttributes);

    public final UnwrappedType unwrap() {
        return this;
    }

    private UnwrappedType() {
        super((DefaultConstructorMarker) null);
    }
}
