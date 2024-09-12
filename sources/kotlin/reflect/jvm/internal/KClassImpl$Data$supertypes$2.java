package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$supertypes$2 extends Lambda implements Function0<List<? extends KTypeImpl>> {
    final /* synthetic */ KClassImpl<T>.Data this$0;
    final /* synthetic */ KClassImpl<T> this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KClassImpl$Data$supertypes$2(KClassImpl<T>.Data data, KClassImpl<T> kClassImpl) {
        super(0);
        this.this$0 = data;
        this.this$1 = kClassImpl;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<kotlin.reflect.jvm.internal.KTypeImpl> invoke() {
        /*
            r8 = this;
            kotlin.reflect.jvm.internal.KClassImpl<T>$Data r0 = r8.this$0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = r0.getDescriptor()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r0 = r0.getTypeConstructor()
            java.util.Collection r0 = r0.getSupertypes()
            java.lang.String r1 = "descriptor.typeConstructor.supertypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            r1.<init>(r2)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            kotlin.reflect.jvm.internal.KClassImpl<T>$Data r2 = r8.this$0
            kotlin.reflect.jvm.internal.KClassImpl<T> r3 = r8.this$1
            java.util.Iterator r0 = r0.iterator()
        L_0x0026:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x004a
            java.lang.Object r4 = r0.next()
            r5 = r1
            java.util.Collection r5 = (java.util.Collection) r5
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
            kotlin.reflect.jvm.internal.KTypeImpl r6 = new kotlin.reflect.jvm.internal.KTypeImpl
            java.lang.String r7 = "kotlinType"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            kotlin.reflect.jvm.internal.KClassImpl$Data$supertypes$2$1$1 r7 = new kotlin.reflect.jvm.internal.KClassImpl$Data$supertypes$2$1$1
            r7.<init>(r4, r2, r3)
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r6.<init>(r4, r7)
            r5.add(r6)
            goto L_0x0026
        L_0x004a:
            r0 = r1
            java.util.Collection r0 = (java.util.Collection) r0
            kotlin.reflect.jvm.internal.KClassImpl<T>$Data r2 = r8.this$0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = r2.getDescriptor()
            boolean r2 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isSpecialClassWithNoSupertypes(r2)
            if (r2 != 0) goto L_0x00c1
            r2 = r1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            boolean r3 = r2 instanceof java.util.Collection
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x006d
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x006d
        L_0x006b:
            r4 = r5
            goto L_0x009c
        L_0x006d:
            java.util.Iterator r2 = r2.iterator()
        L_0x0071:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x006b
            java.lang.Object r3 = r2.next()
            kotlin.reflect.jvm.internal.KTypeImpl r3 = (kotlin.reflect.jvm.internal.KTypeImpl) r3
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r3.getType()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getClassDescriptorForType(r3)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r3 = r3.getKind()
            java.lang.String r6 = "getClassDescriptorForType(it.type).kind"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r6 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE
            if (r3 == r6) goto L_0x0099
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r6 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS
            if (r3 != r6) goto L_0x0097
            goto L_0x0099
        L_0x0097:
            r3 = r4
            goto L_0x009a
        L_0x0099:
            r3 = r5
        L_0x009a:
            if (r3 != 0) goto L_0x0071
        L_0x009c:
            if (r4 == 0) goto L_0x00c1
            kotlin.reflect.jvm.internal.KTypeImpl r2 = new kotlin.reflect.jvm.internal.KTypeImpl
            kotlin.reflect.jvm.internal.KClassImpl<T>$Data r3 = r8.this$0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = r3.getDescriptor()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r3
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r3 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(r3)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r3.getAnyType()
            java.lang.String r4 = "descriptor.builtIns.anyType"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3
            kotlin.reflect.jvm.internal.KClassImpl$Data$supertypes$2$3 r4 = kotlin.reflect.jvm.internal.KClassImpl$Data$supertypes$2.AnonymousClass3.INSTANCE
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r2.<init>(r3, r4)
            r0.add(r2)
        L_0x00c1:
            java.util.List r0 = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KClassImpl$Data$supertypes$2.invoke():java.util.List");
    }
}
