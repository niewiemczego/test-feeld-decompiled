package expo.modules.kotlin.types;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lexpo/modules/kotlin/types/TypeConverter;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AnyType.kt */
final class AnyType$converter$2 extends Lambda implements Function0<TypeConverter<?>> {
    final /* synthetic */ AnyType this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnyType$converter$2(AnyType anyType) {
        super(0);
        this.this$0 = anyType;
    }

    public final TypeConverter<?> invoke() {
        return TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(this.this$0.getKType());
    }
}
