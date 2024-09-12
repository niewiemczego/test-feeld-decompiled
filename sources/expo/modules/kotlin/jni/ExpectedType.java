package expo.modules.kotlin.jni;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\b\u0016\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\u0012\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0003\"\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\nH\u0007J\b\u0010\u000f\u001a\u00020\u0007H\u0007J\u0015\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0003H\u0007¢\u0006\u0002\u0010\u0011J\u0011\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000H\u0002R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0015"}, d2 = {"Lexpo/modules/kotlin/jni/ExpectedType;", "", "expectedTypes", "", "Lexpo/modules/kotlin/jni/CppType;", "([Lexpo/modules/kotlin/jni/CppType;)V", "innerPossibleTypes", "Lexpo/modules/kotlin/jni/SingleType;", "([Lexpo/modules/kotlin/jni/SingleType;)V", "innerCombinedTypes", "", "getInnerCombinedTypes", "()I", "[Lexpo/modules/kotlin/jni/SingleType;", "getCombinedTypes", "getFirstType", "getPossibleTypes", "()[Lexpo/modules/kotlin/jni/SingleType;", "plus", "other", "Companion", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpectedType.kt */
public final class ExpectedType {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int innerCombinedTypes;
    private final SingleType[] innerPossibleTypes;

    public ExpectedType(SingleType... singleTypeArr) {
        Intrinsics.checkNotNullParameter(singleTypeArr, "innerPossibleTypes");
        this.innerPossibleTypes = singleTypeArr;
        int i = 0;
        for (SingleType cppType : singleTypeArr) {
            i |= cppType.getCppType();
        }
        this.innerCombinedTypes = i;
    }

    public final int getInnerCombinedTypes() {
        return this.innerCombinedTypes;
    }

    public final int getCombinedTypes() {
        return this.innerCombinedTypes;
    }

    public final SingleType[] getPossibleTypes() {
        return this.innerPossibleTypes;
    }

    public final SingleType getFirstType() {
        return (SingleType) ArraysKt.first((T[]) this.innerPossibleTypes);
    }

    public final ExpectedType plus(ExpectedType expectedType) {
        Intrinsics.checkNotNullParameter(expectedType, "other");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.addSpread(this.innerPossibleTypes);
        spreadBuilder.addSpread(expectedType.innerPossibleTypes);
        return new ExpectedType((SingleType[]) spreadBuilder.toArray(new SingleType[spreadBuilder.size()]));
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/jni/ExpectedType$Companion;", "", "()V", "forAny", "Lexpo/modules/kotlin/jni/ExpectedType;", "forEnum", "forList", "parameterType", "Lexpo/modules/kotlin/jni/CppType;", "forMap", "valueType", "forPrimitiveArray", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ExpectedType.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ExpectedType forPrimitiveArray(CppType cppType) {
            Intrinsics.checkNotNullParameter(cppType, "parameterType");
            return new ExpectedType(new SingleType(CppType.PRIMITIVE_ARRAY, new ExpectedType[]{new ExpectedType(cppType)}));
        }

        public final ExpectedType forPrimitiveArray(ExpectedType expectedType) {
            Intrinsics.checkNotNullParameter(expectedType, "parameterType");
            return new ExpectedType(new SingleType(CppType.PRIMITIVE_ARRAY, new ExpectedType[]{expectedType}));
        }

        public final ExpectedType forAny() {
            return new ExpectedType(CppType.READABLE_MAP, CppType.READABLE_ARRAY, CppType.STRING, CppType.BOOLEAN, CppType.DOUBLE);
        }

        public final ExpectedType forEnum() {
            return new ExpectedType(CppType.STRING, CppType.INT);
        }

        public final ExpectedType forList(CppType cppType) {
            Intrinsics.checkNotNullParameter(cppType, "parameterType");
            return new ExpectedType(new SingleType(CppType.LIST, new ExpectedType[]{new ExpectedType(cppType)}));
        }

        public final ExpectedType forList(ExpectedType expectedType) {
            Intrinsics.checkNotNullParameter(expectedType, "parameterType");
            return new ExpectedType(new SingleType(CppType.LIST, new ExpectedType[]{expectedType}));
        }

        public final ExpectedType forMap(CppType cppType) {
            Intrinsics.checkNotNullParameter(cppType, "valueType");
            return new ExpectedType(new SingleType(CppType.MAP, new ExpectedType[]{new ExpectedType(cppType)}));
        }

        public final ExpectedType forMap(ExpectedType expectedType) {
            Intrinsics.checkNotNullParameter(expectedType, "valueType");
            return new ExpectedType(new SingleType(CppType.MAP, new ExpectedType[]{expectedType}));
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExpectedType(expo.modules.kotlin.jni.CppType... r9) {
        /*
            r8 = this;
            java.lang.String r0 = "expectedTypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r9.length
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            int r1 = r9.length
            r2 = 0
            r3 = r2
        L_0x0010:
            if (r3 >= r1) goto L_0x0021
            r4 = r9[r3]
            expo.modules.kotlin.jni.SingleType r5 = new expo.modules.kotlin.jni.SingleType
            r6 = 2
            r7 = 0
            r5.<init>(r4, r7, r6, r7)
            r0.add(r5)
            int r3 = r3 + 1
            goto L_0x0010
        L_0x0021:
            java.util.List r0 = (java.util.List) r0
            java.util.Collection r0 = (java.util.Collection) r0
            expo.modules.kotlin.jni.SingleType[] r9 = new expo.modules.kotlin.jni.SingleType[r2]
            java.lang.Object[] r9 = r0.toArray(r9)
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9, r0)
            expo.modules.kotlin.jni.SingleType[] r9 = (expo.modules.kotlin.jni.SingleType[]) r9
            int r0 = r9.length
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r0)
            expo.modules.kotlin.jni.SingleType[] r9 = (expo.modules.kotlin.jni.SingleType[]) r9
            r8.<init>((expo.modules.kotlin.jni.SingleType[]) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.jni.ExpectedType.<init>(expo.modules.kotlin.jni.CppType[]):void");
    }
}
