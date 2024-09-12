package expo.modules.kotlin.types;

import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00050\u0004B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lexpo/modules/kotlin/types/EitherTypeConverter;", "FirstType", "", "SecondType", "Lexpo/modules/kotlin/types/TypeConverter;", "Lexpo/modules/kotlin/types/Either;", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "eitherType", "Lkotlin/reflect/KType;", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lkotlin/reflect/KType;)V", "firstJavaType", "firstType", "Lexpo/modules/kotlin/jni/ExpectedType;", "firstTypeConverter", "secondJavaType", "secondType", "secondTypeConverter", "convertNonOptional", "value", "getCppRequiredTypes", "isTrivial", "", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: EitherTypeConverter.kt */
public final class EitherTypeConverter<FirstType, SecondType> extends TypeConverter<Either<FirstType, SecondType>> {
    private final KType firstJavaType;
    private final ExpectedType firstType;
    /* access modifiers changed from: private */
    public final TypeConverter<?> firstTypeConverter;
    private final KType secondJavaType;
    private final ExpectedType secondType;
    private final TypeConverter<?> secondTypeConverter;

    public boolean isTrivial() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EitherTypeConverter(TypeConverterProvider typeConverterProvider, KType kType) {
        super(kType.isMarkedNullable());
        Intrinsics.checkNotNullParameter(typeConverterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(kType, "eitherType");
        KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt.getOrNull(kType.getArguments(), 0);
        KType kType2 = null;
        KType type = kTypeProjection != null ? kTypeProjection.getType() : null;
        if (type != null) {
            this.firstJavaType = type;
            KTypeProjection kTypeProjection2 = (KTypeProjection) CollectionsKt.getOrNull(kType.getArguments(), 1);
            kType2 = kTypeProjection2 != null ? kTypeProjection2.getType() : kType2;
            if (kType2 != null) {
                this.secondJavaType = kType2;
                TypeConverter<?> obtainTypeConverter = typeConverterProvider.obtainTypeConverter(type);
                this.firstTypeConverter = obtainTypeConverter;
                TypeConverter<?> obtainTypeConverter2 = typeConverterProvider.obtainTypeConverter(kType2);
                this.secondTypeConverter = obtainTypeConverter2;
                this.firstType = obtainTypeConverter.getCppRequiredTypes();
                this.secondType = obtainTypeConverter2.getCppRequiredTypes();
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: expo.modules.kotlin.types.Either<FirstType, SecondType>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public expo.modules.kotlin.types.Either<FirstType, SecondType> convertNonOptional(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            expo.modules.kotlin.types.EitherTypeConverter$convertNonOptional$convertValueIfNeeded$1 r0 = new expo.modules.kotlin.types.EitherTypeConverter$convertNonOptional$convertValueIfNeeded$1
            r0.<init>(r6, r5)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            expo.modules.kotlin.jni.ExpectedType r1 = r5.firstType
            expo.modules.kotlin.jni.SingleType[] r1 = r1.getPossibleTypes()
            expo.modules.kotlin.types.TypeConverter<?> r2 = r5.firstTypeConverter
            java.lang.Object r1 = r0.invoke(r1, r2)
            expo.modules.kotlin.types.Either r1 = (expo.modules.kotlin.types.Either) r1
            if (r1 != 0) goto L_0x0066
            expo.modules.kotlin.jni.ExpectedType r1 = r5.secondType
            expo.modules.kotlin.jni.SingleType[] r1 = r1.getPossibleTypes()
            expo.modules.kotlin.types.TypeConverter<?> r2 = r5.secondTypeConverter
            java.lang.Object r0 = r0.invoke(r1, r2)
            r1 = r0
            expo.modules.kotlin.types.Either r1 = (expo.modules.kotlin.types.Either) r1
            if (r1 == 0) goto L_0x002f
            goto L_0x0066
        L_0x002f:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            kotlin.reflect.KType r1 = r5.firstJavaType
            kotlin.reflect.KType r2 = r5.secondJavaType
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Cannot cast '"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r6 = r3.append(r6)
            java.lang.String r3 = "' to 'Either<"
            java.lang.StringBuilder r6 = r6.append(r3)
            java.lang.StringBuilder r6 = r6.append(r1)
            java.lang.String r1 = ", "
            java.lang.StringBuilder r6 = r6.append(r1)
            java.lang.StringBuilder r6 = r6.append(r2)
            java.lang.String r1 = ">'"
            java.lang.StringBuilder r6 = r6.append(r1)
            java.lang.String r6 = r6.toString()
            r0.<init>(r6)
            throw r0
        L_0x0066:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.types.EitherTypeConverter.convertNonOptional(java.lang.Object):expo.modules.kotlin.types.Either");
    }

    public ExpectedType getCppRequiredTypes() {
        return this.firstType.plus(this.secondType);
    }
}
