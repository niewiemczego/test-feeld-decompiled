package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ljava/lang/reflect/Type;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: KTypeImpl.kt */
final class KTypeImpl$arguments$2$parameterizedTypeArguments$2 extends Lambda implements Function0<List<? extends Type>> {
    final /* synthetic */ KTypeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KTypeImpl$arguments$2$parameterizedTypeArguments$2(KTypeImpl kTypeImpl) {
        super(0);
        this.this$0 = kTypeImpl;
    }

    public final List<Type> invoke() {
        Type javaType = this.this$0.getJavaType();
        Intrinsics.checkNotNull(javaType);
        return ReflectClassUtilKt.getParameterizedTypeArguments(javaType);
    }
}
