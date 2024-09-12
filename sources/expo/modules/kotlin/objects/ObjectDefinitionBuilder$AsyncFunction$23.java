package expo.modules.kotlin.objects;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u0001\"\u0006\b\u0004\u0010\u0006\u0018\u0001\"\u0006\b\u0005\u0010\u0007\u0018\u0001\"\u0006\b\u0006\u0010\b\u0018\u0001\"\u0006\b\u0007\u0010\t\u0018\u00012\u0010\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\n¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "P3", "P4", "P5", "P6", "args", "", "", "promise", "Lexpo/modules/kotlin/Promise;", "invoke", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class ObjectDefinitionBuilder$AsyncFunction$23 extends Lambda implements Function2<Object[], Promise, Unit> {
    final /* synthetic */ Function7<P0, P1, P2, P3, P4, P5, P6, R> $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ObjectDefinitionBuilder$AsyncFunction$23(Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> function7) {
        super(2);
        this.$body = function7;
    }

    public final void invoke(Object[] objArr, Promise promise) {
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Function7<P0, P1, P2, P3, P4, P5, P6, R> function7 = this.$body;
        Object obj = objArr[0];
        Intrinsics.reifiedOperationMarker(1, "P0");
        Object obj2 = obj;
        Object obj3 = objArr[1];
        Intrinsics.reifiedOperationMarker(1, "P1");
        Object obj4 = obj3;
        Object obj5 = objArr[2];
        Intrinsics.reifiedOperationMarker(1, "P2");
        Object obj6 = obj5;
        Object obj7 = objArr[3];
        Intrinsics.reifiedOperationMarker(1, "P3");
        Object obj8 = obj7;
        Object obj9 = objArr[4];
        Intrinsics.reifiedOperationMarker(1, "P4");
        Object obj10 = obj9;
        Object obj11 = objArr[5];
        Intrinsics.reifiedOperationMarker(1, "P5");
        Object obj12 = obj11;
        Intrinsics.reifiedOperationMarker(1, "P6");
        function7.invoke(obj, obj3, obj5, obj7, obj9, obj11, promise);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Object[]) obj, (Promise) obj2);
        return Unit.INSTANCE;
    }
}
