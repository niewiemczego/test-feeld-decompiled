package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: SpecialTypes.kt */
public final class AbbreviatedType extends DelegatingSimpleType {
    private final SimpleType abbreviation;
    private final SimpleType delegate;

    public AbbreviatedType(SimpleType simpleType, SimpleType simpleType2) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        Intrinsics.checkNotNullParameter(simpleType2, "abbreviation");
        this.delegate = simpleType;
        this.abbreviation = simpleType2;
    }

    public final SimpleType getAbbreviation() {
        return this.abbreviation;
    }

    /* access modifiers changed from: protected */
    public SimpleType getDelegate() {
        return this.delegate;
    }

    public final SimpleType getExpandedType() {
        return getDelegate();
    }

    public SimpleType replaceAttributes(TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        return new AbbreviatedType(getDelegate().replaceAttributes(typeAttributes), this.abbreviation);
    }

    public AbbreviatedType makeNullableAsSpecified(boolean z) {
        return new AbbreviatedType(getDelegate().makeNullableAsSpecified(z), this.abbreviation.makeNullableAsSpecified(z));
    }

    public AbbreviatedType replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new AbbreviatedType(simpleType, this.abbreviation);
    }

    public AbbreviatedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        KotlinType refineType = kotlinTypeRefiner.refineType(getDelegate());
        Intrinsics.checkNotNull(refineType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType refineType2 = kotlinTypeRefiner.refineType(this.abbreviation);
        Intrinsics.checkNotNull(refineType2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new AbbreviatedType((SimpleType) refineType, (SimpleType) refineType2);
    }
}
