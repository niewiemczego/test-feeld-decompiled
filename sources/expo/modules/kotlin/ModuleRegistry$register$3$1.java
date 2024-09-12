package expo.modules.kotlin;

import android.view.View;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KClass;
import kotlin.reflect.full.KClasses;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "expo.modules.kotlin.ModuleRegistry$register$3$1", f = "ModuleRegistry.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ModuleRegistry.kt */
final class ModuleRegistry$register$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KClass<? extends View> $viewType;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModuleRegistry$register$3$1(KClass<? extends View> kClass, Continuation<? super ModuleRegistry$register$3$1> continuation) {
        super(2, continuation);
        this.$viewType = kClass;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ModuleRegistry$register$3$1(this.$viewType, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ModuleRegistry$register$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            KClasses.getDeclaredMemberProperties(this.$viewType);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
