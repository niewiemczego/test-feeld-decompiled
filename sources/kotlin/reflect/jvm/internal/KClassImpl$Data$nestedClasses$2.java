package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a6\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u0002 \u0004*\u001a\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "", "kotlin.jvm.PlatformType", "T", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$nestedClasses$2 extends Lambda implements Function0<List<? extends KClassImpl<? extends Object>>> {
    final /* synthetic */ KClassImpl<T>.Data this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KClassImpl$Data$nestedClasses$2(KClassImpl<T>.Data data) {
        super(0);
        this.this$0 = data;
    }

    public final List<KClassImpl<? extends Object>> invoke() {
        MemberScope unsubstitutedInnerClassesScope = this.this$0.getDescriptor().getUnsubstitutedInnerClassesScope();
        Intrinsics.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "descriptor.unsubstitutedInnerClassesScope");
        Collection arrayList = new ArrayList();
        for (Object next : ResolutionScope.DefaultImpls.getContributedDescriptors$default(unsubstitutedInnerClassesScope, (DescriptorKindFilter) null, (Function1) null, 3, (Object) null)) {
            if (!DescriptorUtils.isEnumEntry((DeclarationDescriptor) next)) {
                arrayList.add(next);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (DeclarationDescriptor declarationDescriptor : (List) arrayList) {
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            Class<?> javaClass = classDescriptor != null ? UtilKt.toJavaClass(classDescriptor) : null;
            KClassImpl kClassImpl = javaClass != null ? new KClassImpl(javaClass) : null;
            if (kClassImpl != null) {
                arrayList2.add(kClassImpl);
            }
        }
        return (List) arrayList2;
    }
}
