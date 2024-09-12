package expo.modules.kotlin.types;

import expo.modules.kotlin.jni.SingleType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u001c\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0006\"\b\b\u0001\u0010\u0003*\u00020\u0006\"\b\b\u0002\u0010\u0004*\u00020\u0006\"\b\b\u0003\u0010\u0005*\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"<anonymous>", "Lexpo/modules/kotlin/types/EitherOfFour;", "FirstType", "SecondType", "ThirdType", "FourthType", "", "types", "", "Lexpo/modules/kotlin/jni/SingleType;", "converter", "Lexpo/modules/kotlin/types/TypeConverter;", "invoke", "([Lexpo/modules/kotlin/jni/SingleType;Lexpo/modules/kotlin/types/TypeConverter;)Lexpo/modules/kotlin/types/EitherOfFour;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: EitherTypeConverter.kt */
final class EitherOfFourTypeConverter$convertNonOptional$convertValueIfNeeded$1 extends Lambda implements Function2<SingleType[], TypeConverter<?>, EitherOfFour<FirstType, SecondType, ThirdType, FourthType>> {
    final /* synthetic */ Object $value;
    final /* synthetic */ EitherOfFourTypeConverter<FirstType, SecondType, ThirdType, FourthType> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EitherOfFourTypeConverter$convertNonOptional$convertValueIfNeeded$1(Object obj, EitherOfFourTypeConverter<FirstType, SecondType, ThirdType, FourthType> eitherOfFourTypeConverter) {
        super(2);
        this.$value = obj;
        this.this$0 = eitherOfFourTypeConverter;
    }

    public final EitherOfFour<FirstType, SecondType, ThirdType, FourthType> invoke(SingleType[] singleTypeArr, TypeConverter<?> typeConverter) {
        Intrinsics.checkNotNullParameter(singleTypeArr, "types");
        Intrinsics.checkNotNullParameter(typeConverter, "converter");
        int length = singleTypeArr.length;
        int i = 0;
        while (i < length) {
            if (!singleTypeArr[i].getExpectedCppType$expo_modules_core_release().getClazz().isInstance(this.$value)) {
                i++;
            } else if (this.this$0.firstTypeConverter.isTrivial()) {
                return new EitherOfFour<>(this.$value);
            } else {
                Object convert = typeConverter.convert(this.$value);
                Intrinsics.checkNotNull(convert);
                return new EitherOfFour<>(convert);
            }
        }
        return null;
    }
}
