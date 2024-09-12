package expo.modules.kotlin.types;

import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\b\b\u0002\u0010\u0004*\u00020\u00022\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00060\u0005B\u0015\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\"\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016R\u000e\u0010\f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lexpo/modules/kotlin/types/EitherOfThreeTypeConverter;", "FirstType", "", "SecondType", "ThirdType", "Lexpo/modules/kotlin/types/TypeConverter;", "Lexpo/modules/kotlin/types/EitherOfThree;", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "eitherType", "Lkotlin/reflect/KType;", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lkotlin/reflect/KType;)V", "firstJavaType", "firstType", "Lexpo/modules/kotlin/jni/ExpectedType;", "firstTypeConverter", "secondJavaType", "secondType", "secondTypeConverter", "thirdJavaType", "thirdType", "thirdTypeConverter", "convertNonOptional", "value", "getCppRequiredTypes", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: EitherTypeConverter.kt */
public final class EitherOfThreeTypeConverter<FirstType, SecondType, ThirdType> extends TypeConverter<EitherOfThree<FirstType, SecondType, ThirdType>> {
    private final KType firstJavaType;
    private final ExpectedType firstType;
    /* access modifiers changed from: private */
    public final TypeConverter<?> firstTypeConverter;
    private final KType secondJavaType;
    private final ExpectedType secondType;
    private final TypeConverter<?> secondTypeConverter;
    private final KType thirdJavaType;
    private final ExpectedType thirdType;
    private final TypeConverter<?> thirdTypeConverter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EitherOfThreeTypeConverter(TypeConverterProvider typeConverterProvider, KType kType) {
        super(kType.isMarkedNullable());
        Intrinsics.checkNotNullParameter(typeConverterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(kType, "eitherType");
        KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt.getOrNull(kType.getArguments(), 0);
        KType kType2 = null;
        KType type = kTypeProjection != null ? kTypeProjection.getType() : null;
        if (type != null) {
            this.firstJavaType = type;
            KTypeProjection kTypeProjection2 = (KTypeProjection) CollectionsKt.getOrNull(kType.getArguments(), 1);
            KType type2 = kTypeProjection2 != null ? kTypeProjection2.getType() : null;
            if (type2 != null) {
                this.secondJavaType = type2;
                KTypeProjection kTypeProjection3 = (KTypeProjection) CollectionsKt.getOrNull(kType.getArguments(), 2);
                kType2 = kTypeProjection3 != null ? kTypeProjection3.getType() : kType2;
                if (kType2 != null) {
                    this.thirdJavaType = kType2;
                    TypeConverter<?> obtainTypeConverter = typeConverterProvider.obtainTypeConverter(type);
                    this.firstTypeConverter = obtainTypeConverter;
                    TypeConverter<?> obtainTypeConverter2 = typeConverterProvider.obtainTypeConverter(type2);
                    this.secondTypeConverter = obtainTypeConverter2;
                    TypeConverter<?> obtainTypeConverter3 = typeConverterProvider.obtainTypeConverter(kType2);
                    this.thirdTypeConverter = obtainTypeConverter3;
                    this.firstType = obtainTypeConverter.getCppRequiredTypes();
                    this.secondType = obtainTypeConverter2.getCppRequiredTypes();
                    this.thirdType = obtainTypeConverter3.getCppRequiredTypes();
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: expo.modules.kotlin.types.EitherOfThree<FirstType, SecondType, ThirdType>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public expo.modules.kotlin.types.EitherOfThree<FirstType, SecondType, ThirdType> convertNonOptional(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            expo.modules.kotlin.types.EitherOfThreeTypeConverter$convertNonOptional$convertValueIfNeeded$1 r0 = new expo.modules.kotlin.types.EitherOfThreeTypeConverter$convertNonOptional$convertValueIfNeeded$1
            r0.<init>(r7, r6)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            expo.modules.kotlin.jni.ExpectedType r1 = r6.firstType
            expo.modules.kotlin.jni.SingleType[] r1 = r1.getPossibleTypes()
            expo.modules.kotlin.types.TypeConverter<?> r2 = r6.firstTypeConverter
            java.lang.Object r1 = r0.invoke(r1, r2)
            expo.modules.kotlin.types.EitherOfThree r1 = (expo.modules.kotlin.types.EitherOfThree) r1
            if (r1 != 0) goto L_0x0080
            expo.modules.kotlin.jni.ExpectedType r1 = r6.secondType
            expo.modules.kotlin.jni.SingleType[] r1 = r1.getPossibleTypes()
            expo.modules.kotlin.types.TypeConverter<?> r2 = r6.secondTypeConverter
            java.lang.Object r1 = r0.invoke(r1, r2)
            expo.modules.kotlin.types.EitherOfThree r1 = (expo.modules.kotlin.types.EitherOfThree) r1
            if (r1 != 0) goto L_0x0080
            expo.modules.kotlin.jni.ExpectedType r1 = r6.thirdType
            expo.modules.kotlin.jni.SingleType[] r1 = r1.getPossibleTypes()
            expo.modules.kotlin.types.TypeConverter<?> r2 = r6.thirdTypeConverter
            java.lang.Object r0 = r0.invoke(r1, r2)
            r1 = r0
            expo.modules.kotlin.types.EitherOfThree r1 = (expo.modules.kotlin.types.EitherOfThree) r1
            if (r1 == 0) goto L_0x003f
            goto L_0x0080
        L_0x003f:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            kotlin.reflect.KType r1 = r6.firstJavaType
            kotlin.reflect.KType r2 = r6.secondJavaType
            kotlin.reflect.KType r3 = r6.thirdJavaType
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Cannot cast '"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r7 = r4.append(r7)
            java.lang.String r4 = "' to 'EitherOfThree<"
            java.lang.StringBuilder r7 = r7.append(r4)
            java.lang.StringBuilder r7 = r7.append(r1)
            java.lang.String r1 = ", "
            java.lang.StringBuilder r7 = r7.append(r1)
            java.lang.StringBuilder r7 = r7.append(r2)
            java.lang.StringBuilder r7 = r7.append(r1)
            java.lang.StringBuilder r7 = r7.append(r3)
            java.lang.String r1 = ">'"
            java.lang.StringBuilder r7 = r7.append(r1)
            java.lang.String r7 = r7.toString()
            r0.<init>(r7)
            throw r0
        L_0x0080:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.types.EitherOfThreeTypeConverter.convertNonOptional(java.lang.Object):expo.modules.kotlin.types.EitherOfThree");
    }

    public ExpectedType getCppRequiredTypes() {
        return this.firstType.plus(this.secondType).plus(this.thirdType);
    }
}
