package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: NewCapturedType.kt */
final class NewCapturedTypeConstructor$boundSupertypes$2 extends Lambda implements Function0<List<? extends UnwrappedType>> {
    final /* synthetic */ NewCapturedTypeConstructor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewCapturedTypeConstructor$boundSupertypes$2(NewCapturedTypeConstructor newCapturedTypeConstructor) {
        super(0);
        this.this$0 = newCapturedTypeConstructor;
    }

    public final List<UnwrappedType> invoke() {
        Function0 access$getSupertypesComputation$p = this.this$0.supertypesComputation;
        if (access$getSupertypesComputation$p != null) {
            return (List) access$getSupertypesComputation$p.invoke();
        }
        return null;
    }
}
