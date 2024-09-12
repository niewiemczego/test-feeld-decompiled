package expo.modules.kotlin.jni;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lexpo/modules/kotlin/jni/TypedArrayKind;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: JavaScriptTypedArray.kt */
final class JavaScriptTypedArray$kind$2 extends Lambda implements Function0<TypedArrayKind> {
    final /* synthetic */ JavaScriptTypedArray this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JavaScriptTypedArray$kind$2(JavaScriptTypedArray javaScriptTypedArray) {
        super(0);
        this.this$0 = javaScriptTypedArray;
    }

    public final TypedArrayKind invoke() {
        int access$getRawKind = this.this$0.getRawKind();
        for (TypedArrayKind typedArrayKind : TypedArrayKind.values()) {
            if (typedArrayKind.getValue() == access$getRawKind) {
                return typedArrayKind;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }
}
