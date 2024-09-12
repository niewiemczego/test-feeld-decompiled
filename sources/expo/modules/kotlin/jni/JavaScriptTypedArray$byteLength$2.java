package expo.modules.kotlin.jni;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: JavaScriptTypedArray.kt */
final class JavaScriptTypedArray$byteLength$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ JavaScriptTypedArray this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JavaScriptTypedArray$byteLength$2(JavaScriptTypedArray javaScriptTypedArray) {
        super(0);
        this.this$0 = javaScriptTypedArray;
    }

    public final Integer invoke() {
        return Integer.valueOf((int) this.this$0.getProperty("byteLength").getDouble());
    }
}
