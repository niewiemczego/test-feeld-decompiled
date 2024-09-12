package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import io.sentry.protocol.SentryThread;
import java.util.Collection;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* compiled from: LazyJavaStaticClassScope.kt */
public final class LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2 extends DFS.AbstractNodeHandler<ClassDescriptor, Unit> {
    final /* synthetic */ Function1<MemberScope, Collection<R>> $onJavaStaticScope;
    final /* synthetic */ Set<R> $result;
    final /* synthetic */ ClassDescriptor $root;

    public void result() {
    }

    LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2(ClassDescriptor classDescriptor, Set<R> set, Function1<? super MemberScope, ? extends Collection<? extends R>> function1) {
        this.$root = classDescriptor;
        this.$result = set;
        this.$onJavaStaticScope = function1;
    }

    public boolean beforeChildren(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, SentryThread.JsonKeys.CURRENT);
        if (classDescriptor == this.$root) {
            return true;
        }
        MemberScope staticScope = classDescriptor.getStaticScope();
        Intrinsics.checkNotNullExpressionValue(staticScope, "current.staticScope");
        if (!(staticScope instanceof LazyJavaStaticScope)) {
            return true;
        }
        this.$result.addAll(this.$onJavaStaticScope.invoke(staticScope));
        return false;
    }
}
