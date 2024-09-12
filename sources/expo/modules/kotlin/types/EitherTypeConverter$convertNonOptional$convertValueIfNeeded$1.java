package expo.modules.kotlin.types;

import expo.modules.kotlin.jni.SingleType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "Lexpo/modules/kotlin/types/Either;", "FirstType", "SecondType", "", "types", "", "Lexpo/modules/kotlin/jni/SingleType;", "converter", "Lexpo/modules/kotlin/types/TypeConverter;", "invoke", "([Lexpo/modules/kotlin/jni/SingleType;Lexpo/modules/kotlin/types/TypeConverter;)Lexpo/modules/kotlin/types/Either;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: EitherTypeConverter.kt */
final class EitherTypeConverter$convertNonOptional$convertValueIfNeeded$1 extends Lambda implements Function2<SingleType[], TypeConverter<?>, Either<FirstType, SecondType>> {
    final /* synthetic */ Object $value;
    final /* synthetic */ EitherTypeConverter<FirstType, SecondType> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EitherTypeConverter$convertNonOptional$convertValueIfNeeded$1(Object obj, EitherTypeConverter<FirstType, SecondType> eitherTypeConverter) {
        super(2);
        this.$value = obj;
        this.this$0 = eitherTypeConverter;
    }

    public final Either<FirstType, SecondType> invoke(SingleType[] singleTypeArr, TypeConverter<?> typeConverter) {
        Intrinsics.checkNotNullParameter(singleTypeArr, "types");
        Intrinsics.checkNotNullParameter(typeConverter, "converter");
        int length = singleTypeArr.length;
        int i = 0;
        while (i < length) {
            if (!singleTypeArr[i].getExpectedCppType$expo_modules_core_release().getClazz().isInstance(this.$value)) {
                i++;
            } else if (this.this$0.firstTypeConverter.isTrivial()) {
                return new Either<>(this.$value);
            } else {
                Object convert = typeConverter.convert(this.$value);
                Intrinsics.checkNotNull(convert);
                return new Either<>(convert);
            }
        }
        return null;
    }
}
