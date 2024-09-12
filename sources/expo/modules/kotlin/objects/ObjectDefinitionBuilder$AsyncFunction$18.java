package expo.modules.kotlin.objects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u0001\"\u0006\b\u0004\u0010\u0006\u0018\u0001\"\u0006\b\u0005\u0010\u0007\u0018\u00012\u0010\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\tH\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "P3", "P4", "it", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class ObjectDefinitionBuilder$AsyncFunction$18 extends Lambda implements Function1<Object[], Object> {
    final /* synthetic */ Function5<P0, P1, P2, P3, P4, R> $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ObjectDefinitionBuilder$AsyncFunction$18(Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> function5) {
        super(1);
        this.$body = function5;
    }

    public final Object invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "it");
        Function5<P0, P1, P2, P3, P4, R> function5 = this.$body;
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
        return function5.invoke(obj, obj3, obj5, obj7, obj9);
    }
}
