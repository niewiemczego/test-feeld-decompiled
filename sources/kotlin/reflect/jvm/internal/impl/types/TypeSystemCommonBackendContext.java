package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* compiled from: TypeSystemCommonBackendContext.kt */
public interface TypeSystemCommonBackendContext extends TypeSystemContext {
    FqNameUnsafe getClassFqNameUnsafe(TypeConstructorMarker typeConstructorMarker);

    PrimitiveType getPrimitiveArrayType(TypeConstructorMarker typeConstructorMarker);

    PrimitiveType getPrimitiveType(TypeConstructorMarker typeConstructorMarker);

    KotlinTypeMarker getRepresentativeUpperBound(TypeParameterMarker typeParameterMarker);

    KotlinTypeMarker getUnsubstitutedUnderlyingType(KotlinTypeMarker kotlinTypeMarker);

    boolean hasAnnotation(KotlinTypeMarker kotlinTypeMarker, FqName fqName);

    boolean isInlineClass(TypeConstructorMarker typeConstructorMarker);

    boolean isUnderKotlinPackage(TypeConstructorMarker typeConstructorMarker);

    KotlinTypeMarker makeNullable(KotlinTypeMarker kotlinTypeMarker);

    /* compiled from: TypeSystemCommonBackendContext.kt */
    public static final class DefaultImpls {
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
            r2 = r2.withNullability(r0, true);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker makeNullable(kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext r2, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3) {
            /*
                java.lang.String r0 = "$receiver"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r0 = r2.asSimpleType(r3)
                if (r0 == 0) goto L_0x0015
                r1 = 1
                kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r2 = r2.withNullability((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r0, (boolean) r1)
                if (r2 == 0) goto L_0x0015
                r3 = r2
                kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r3
            L_0x0015:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext.DefaultImpls.makeNullable(kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker):kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker");
        }
    }
}
