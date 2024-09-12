package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLoadingKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;

/* compiled from: DeclaredMemberIndex.kt */
final class ClassDeclaredMemberIndex$methodFilter$1 extends Lambda implements Function1<JavaMethod, Boolean> {
    final /* synthetic */ ClassDeclaredMemberIndex this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClassDeclaredMemberIndex$methodFilter$1(ClassDeclaredMemberIndex classDeclaredMemberIndex) {
        super(1);
        this.this$0 = classDeclaredMemberIndex;
    }

    public final Boolean invoke(JavaMethod javaMethod) {
        Intrinsics.checkNotNullParameter(javaMethod, "m");
        return Boolean.valueOf(((Boolean) this.this$0.memberFilter.invoke(javaMethod)).booleanValue() && !JavaLoadingKt.isObjectMethodInInterface(javaMethod));
    }
}
