package expo.modules.kotlin.exception;

import com.facebook.react.bridge.ReadableType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\n\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u000bB'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\f\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lexpo/modules/kotlin/exception/CollectionElementCastException;", "Lexpo/modules/kotlin/exception/DecoratedException;", "collectionType", "Lkotlin/reflect/KType;", "elementType", "providedType", "Lcom/facebook/react/bridge/ReadableType;", "cause", "Lexpo/modules/kotlin/exception/CodedException;", "(Lkotlin/reflect/KType;Lkotlin/reflect/KType;Lcom/facebook/react/bridge/ReadableType;Lexpo/modules/kotlin/exception/CodedException;)V", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KType;Lkotlin/reflect/KType;Lkotlin/reflect/KClass;Lexpo/modules/kotlin/exception/CodedException;)V", "", "(Lkotlin/reflect/KType;Lkotlin/reflect/KType;Ljava/lang/String;Lexpo/modules/kotlin/exception/CodedException;)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CodedException.kt */
public final class CollectionElementCastException extends DecoratedException {
    private CollectionElementCastException(KType kType, KType kType2, String str, CodedException codedException) {
        super("Cannot cast '" + str + "' to '" + kType2 + "' required by the collection of type: '" + kType + "'.", codedException);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CollectionElementCastException(KType kType, KType kType2, ReadableType readableType, CodedException codedException) {
        this(kType, kType2, readableType.name(), codedException);
        Intrinsics.checkNotNullParameter(kType, "collectionType");
        Intrinsics.checkNotNullParameter(kType2, "elementType");
        Intrinsics.checkNotNullParameter(readableType, "providedType");
        Intrinsics.checkNotNullParameter(codedException, "cause");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CollectionElementCastException(KType kType, KType kType2, KClass<?> kClass, CodedException codedException) {
        this(kType, kType2, kClass.toString(), codedException);
        Intrinsics.checkNotNullParameter(kType, "collectionType");
        Intrinsics.checkNotNullParameter(kType2, "elementType");
        Intrinsics.checkNotNullParameter(kClass, "providedType");
        Intrinsics.checkNotNullParameter(codedException, "cause");
    }
}
