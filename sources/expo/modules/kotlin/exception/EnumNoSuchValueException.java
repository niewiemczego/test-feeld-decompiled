package expo.modules.kotlin.exception;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lexpo/modules/kotlin/exception/EnumNoSuchValueException;", "Lexpo/modules/kotlin/exception/CodedException;", "enumType", "Lkotlin/reflect/KClass;", "", "enumConstants", "", "value", "", "(Lkotlin/reflect/KClass;[Ljava/lang/Enum;Ljava/lang/Object;)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CodedException.kt */
public final class EnumNoSuchValueException extends CodedException {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public EnumNoSuchValueException(kotlin.reflect.KClass<java.lang.Enum<?>> r11, java.lang.Enum<?>[] r12, java.lang.Object r13) {
        /*
            r10 = this;
            java.lang.String r0 = "enumType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "enumConstants"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r11 = r11.getSimpleName()
            java.lang.String r0 = ", "
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            expo.modules.kotlin.exception.EnumNoSuchValueException$1 r0 = expo.modules.kotlin.exception.EnumNoSuchValueException.AnonymousClass1.INSTANCE
            r7 = r0
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r8 = 30
            r9 = 0
            r1 = r12
            java.lang.String r12 = kotlin.collections.ArraysKt.joinToString$default((java.lang.Object[]) r1, (java.lang.CharSequence) r2, (java.lang.CharSequence) r3, (java.lang.CharSequence) r4, (int) r5, (java.lang.CharSequence) r6, (kotlin.jvm.functions.Function1) r7, (int) r8, (java.lang.Object) r9)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "'"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r13 = r0.append(r13)
            java.lang.String r0 = "' is not present in "
            java.lang.StringBuilder r13 = r13.append(r0)
            java.lang.StringBuilder r11 = r13.append(r11)
            java.lang.String r13 = " enum, it must be one of: "
            java.lang.StringBuilder r11 = r11.append(r13)
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r11 = r11.toString()
            r12 = 0
            r13 = 2
            r10.<init>(r11, r12, r13, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.exception.EnumNoSuchValueException.<init>(kotlin.reflect.KClass, java.lang.Enum[], java.lang.Object):void");
    }
}
