package expo.modules.kotlin.objects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u00012\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "R", "P0", "it", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$Function$5"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: expo.modules.kotlin.objects.ObjectDefinitionBuilder$buildObject$lambda-2$$inlined$Function$2  reason: invalid class name */
/* compiled from: ObjectDefinitionBuilder.kt */
public final class ObjectDefinitionBuilder$buildObject$lambda2$$inlined$Function$2 extends Lambda implements Function1<Object[], Object> {
    public ObjectDefinitionBuilder$buildObject$lambda2$$inlined$Function$2() {
        super(1);
    }

    public final Object invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "it");
        Integer num = objArr[0];
        if (num != null) {
            num.intValue();
            return ObjectDefinitionBuilder$buildObject$1$2$1.INSTANCE;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
