package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* compiled from: KotlinTypePreparator.kt */
/* synthetic */ class KotlinTypePreparator$prepareType$1 extends FunctionReference implements Function1<KotlinTypeMarker, UnwrappedType> {
    KotlinTypePreparator$prepareType$1(Object obj) {
        super(1, obj);
    }

    public final String getName() {
        return "prepareType";
    }

    public final String getSignature() {
        return "prepareType(Lorg/jetbrains/kotlin/types/model/KotlinTypeMarker;)Lorg/jetbrains/kotlin/types/UnwrappedType;";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(KotlinTypePreparator.class);
    }

    public final UnwrappedType invoke(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "p0");
        return ((KotlinTypePreparator) this.receiver).prepareType(kotlinTypeMarker);
    }
}
