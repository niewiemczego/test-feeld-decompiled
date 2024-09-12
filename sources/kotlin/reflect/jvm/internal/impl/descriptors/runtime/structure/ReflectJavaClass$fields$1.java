package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: ReflectJavaClass.kt */
/* synthetic */ class ReflectJavaClass$fields$1 extends FunctionReference implements Function1<Member, Boolean> {
    public static final ReflectJavaClass$fields$1 INSTANCE = new ReflectJavaClass$fields$1();

    ReflectJavaClass$fields$1() {
        super(1);
    }

    public final String getName() {
        return "isSynthetic";
    }

    public final String getSignature() {
        return "isSynthetic()Z";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(Member.class);
    }

    public final Boolean invoke(Member member) {
        Intrinsics.checkNotNullParameter(member, "p0");
        return Boolean.valueOf(member.isSynthetic());
    }
}
