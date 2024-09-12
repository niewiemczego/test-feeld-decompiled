package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: TypeParameterUpperBoundEraser.kt */
final class TypeParameterUpperBoundEraser$getErasedUpperBound$1 extends Lambda implements Function1<TypeParameterUpperBoundEraser.DataToEraseUpperBound, KotlinType> {
    final /* synthetic */ TypeParameterUpperBoundEraser this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TypeParameterUpperBoundEraser$getErasedUpperBound$1(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser) {
        super(1);
        this.this$0 = typeParameterUpperBoundEraser;
    }

    public final KotlinType invoke(TypeParameterUpperBoundEraser.DataToEraseUpperBound dataToEraseUpperBound) {
        return this.this$0.getErasedUpperBoundInternal(dataToEraseUpperBound.getTypeParameter(), dataToEraseUpperBound.isRaw(), dataToEraseUpperBound.getTypeAttr());
    }
}
