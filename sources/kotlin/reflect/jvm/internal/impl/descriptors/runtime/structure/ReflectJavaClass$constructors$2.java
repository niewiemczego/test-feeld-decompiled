package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Constructor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: ReflectJavaClass.kt */
/* synthetic */ class ReflectJavaClass$constructors$2 extends FunctionReference implements Function1<Constructor<?>, ReflectJavaConstructor> {
    public static final ReflectJavaClass$constructors$2 INSTANCE = new ReflectJavaClass$constructors$2();

    ReflectJavaClass$constructors$2() {
        super(1);
    }

    public final String getName() {
        return "<init>";
    }

    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Constructor;)V";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ReflectJavaConstructor.class);
    }

    public final ReflectJavaConstructor invoke(Constructor<?> constructor) {
        Intrinsics.checkNotNullParameter(constructor, "p0");
        return new ReflectJavaConstructor(constructor);
    }
}
