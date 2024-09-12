package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1 extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ SimpleFunctionDescriptor $function;
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1(SimpleFunctionDescriptor simpleFunctionDescriptor, LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(1);
        this.$function = simpleFunctionDescriptor;
        this.this$0 = lazyJavaClassMemberScope;
    }

    public final Collection<SimpleFunctionDescriptor> invoke(Name name) {
        Intrinsics.checkNotNullParameter(name, "accessorName");
        if (Intrinsics.areEqual((Object) this.$function.getName(), (Object) name)) {
            return CollectionsKt.listOf(this.$function);
        }
        return CollectionsKt.plus(this.this$0.searchMethodsByNameWithoutBuiltinMagic(name), this.this$0.searchMethodsInSupertypesWithoutBuiltinMagic(name));
    }
}
