package expo.modules.kotlin.objects;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u00012\u0010\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "args", "", "", "promise", "Lexpo/modules/kotlin/Promise;", "invoke", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class ObjectDefinitionBuilder$AsyncFunction$8 extends Lambda implements Function2<Object[], Promise, Unit> {
    final /* synthetic */ Function2<P0, P1, R> $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ObjectDefinitionBuilder$AsyncFunction$8(Function2<? super P0, ? super P1, ? extends R> function2) {
        super(2);
        this.$body = function2;
    }

    public final void invoke(Object[] objArr, Promise promise) {
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Function2<P0, P1, R> function2 = this.$body;
        Object obj = objArr[0];
        Intrinsics.reifiedOperationMarker(1, "P0");
        Object obj2 = obj;
        Intrinsics.reifiedOperationMarker(1, "P1");
        function2.invoke(obj, promise);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Object[]) obj, (Promise) obj2);
        return Unit.INSTANCE;
    }
}
