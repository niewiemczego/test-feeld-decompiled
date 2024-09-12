package expo.modules.kotlin.objects;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "it", "", "", "invoke", "([Ljava/lang/Object;)V"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* compiled from: PropertyComponentBuilder.kt */
final class PropertyComponentBuilder$set$1$1 extends Lambda implements Function1<Object[], Unit> {
    final /* synthetic */ Function1<T, Unit> $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PropertyComponentBuilder$set$1$1(Function1<? super T, Unit> function1) {
        super(1);
        this.$body = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Object[]) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "it");
        Function1<T, Unit> function1 = this.$body;
        Object obj = objArr[0];
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        Object obj2 = obj;
        function1.invoke(obj);
    }
}
