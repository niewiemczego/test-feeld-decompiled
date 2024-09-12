package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;

/* compiled from: CapturedTypeConstructor.kt */
public final class CapturedType extends SimpleType implements CapturedTypeMarker {
    private final TypeAttributes attributes;
    private final CapturedTypeConstructor constructor;
    private final boolean isMarkedNullable;
    private final TypeProjection typeProjection;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CapturedType(TypeProjection typeProjection2, CapturedTypeConstructor capturedTypeConstructor, boolean z, TypeAttributes typeAttributes, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeProjection2, (i & 2) != 0 ? new CapturedTypeConstructorImpl(typeProjection2) : capturedTypeConstructor, (i & 4) != 0 ? false : z, (i & 8) != 0 ? TypeAttributes.Companion.getEmpty() : typeAttributes);
    }

    public CapturedTypeConstructor getConstructor() {
        return this.constructor;
    }

    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    public TypeAttributes getAttributes() {
        return this.attributes;
    }

    public CapturedType(TypeProjection typeProjection2, CapturedTypeConstructor capturedTypeConstructor, boolean z, TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeProjection2, "typeProjection");
        Intrinsics.checkNotNullParameter(capturedTypeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(typeAttributes, "attributes");
        this.typeProjection = typeProjection2;
        this.constructor = capturedTypeConstructor;
        this.isMarkedNullable = z;
        this.attributes = typeAttributes;
    }

    public List<TypeProjection> getArguments() {
        return CollectionsKt.emptyList();
    }

    public MemberScope getMemberScope() {
        return ErrorUtils.createErrorScope(ErrorScopeKind.CAPTURED_TYPE_SCOPE, true, new String[0]);
    }

    public String toString() {
        return "Captured(" + this.typeProjection + ')' + (isMarkedNullable() ? "?" : "");
    }

    public CapturedType makeNullableAsSpecified(boolean z) {
        if (z == isMarkedNullable()) {
            return this;
        }
        return new CapturedType(this.typeProjection, getConstructor(), z, getAttributes());
    }

    public SimpleType replaceAttributes(TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        return new CapturedType(this.typeProjection, getConstructor(), isMarkedNullable(), typeAttributes);
    }

    public CapturedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection refine = this.typeProjection.refine(kotlinTypeRefiner);
        Intrinsics.checkNotNullExpressionValue(refine, "typeProjection.refine(kotlinTypeRefiner)");
        return new CapturedType(refine, getConstructor(), isMarkedNullable(), getAttributes());
    }
}
