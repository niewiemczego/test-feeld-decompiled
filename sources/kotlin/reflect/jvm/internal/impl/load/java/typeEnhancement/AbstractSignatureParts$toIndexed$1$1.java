package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* compiled from: AbstractSignatureParts.kt */
final class AbstractSignatureParts$toIndexed$1$1 extends Lambda implements Function1<AbstractSignatureParts.TypeAndDefaultQualifiers, Iterable<? extends AbstractSignatureParts.TypeAndDefaultQualifiers>> {
    final /* synthetic */ TypeSystemContext $this_with;
    final /* synthetic */ AbstractSignatureParts<TAnnotation> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractSignatureParts$toIndexed$1$1(AbstractSignatureParts<TAnnotation> abstractSignatureParts, TypeSystemContext typeSystemContext) {
        super(1);
        this.this$0 = abstractSignatureParts;
        this.$this_with = typeSystemContext;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = r10.$this_with.asFlexibleType(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Iterable<kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers> invoke(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers r11) {
        /*
            r10 = this;
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts<TAnnotation> r0 = r10.this$0
            boolean r0 = r0.getSkipRawTypeArguments()
            r1 = 0
            if (r0 == 0) goto L_0x0027
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r0 = r11.getType()
            if (r0 == 0) goto L_0x0023
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r2 = r10.$this_with
            kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker r0 = r2.asFlexibleType(r0)
            if (r0 == 0) goto L_0x0023
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r2 = r10.$this_with
            kotlin.reflect.jvm.internal.impl.types.model.RawTypeMarker r0 = r2.asRawType(r0)
            goto L_0x0024
        L_0x0023:
            r0 = r1
        L_0x0024:
            if (r0 == 0) goto L_0x0027
            return r1
        L_0x0027:
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r0 = r11.getType()
            if (r0 == 0) goto L_0x00ab
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r2 = r10.$this_with
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r0 = r2.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r0)
            if (r0 == 0) goto L_0x00ab
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r2 = r10.$this_with
            java.util.List r0 = r2.getParameters(r0)
            if (r0 == 0) goto L_0x00ab
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r2 = r10.$this_with
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3 = r11.getType()
            java.util.List r2 = r2.getArguments(r3)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r3 = r10.$this_with
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts<TAnnotation> r4 = r10.this$0
            java.util.Iterator r5 = r0.iterator()
            java.util.Iterator r6 = r2.iterator()
            java.util.ArrayList r7 = new java.util.ArrayList
            r8 = 10
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r8)
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r8)
            int r0 = java.lang.Math.min(r0, r2)
            r7.<init>(r0)
        L_0x006a:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x00a8
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x00a8
            java.lang.Object r0 = r5.next()
            java.lang.Object r2 = r6.next()
            kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker r2 = (kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker) r2
            kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r0 = (kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker) r0
            boolean r8 = r3.isStarProjection(r2)
            if (r8 == 0) goto L_0x0092
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$TypeAndDefaultQualifiers r2 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$TypeAndDefaultQualifiers
            kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType r8 = r11.getDefaultQualifiers()
            r2.<init>(r1, r8, r0)
            goto L_0x00a4
        L_0x0092:
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r2 = r3.getType(r2)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$TypeAndDefaultQualifiers r8 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$TypeAndDefaultQualifiers
            kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType r9 = r11.getDefaultQualifiers()
            kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType r9 = r4.extractAndMergeDefaultQualifiers(r2, r9)
            r8.<init>(r2, r9, r0)
            r2 = r8
        L_0x00a4:
            r7.add(r2)
            goto L_0x006a
        L_0x00a8:
            r1 = r7
            java.util.List r1 = (java.util.List) r1
        L_0x00ab:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$toIndexed$1$1.invoke(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$TypeAndDefaultQualifiers):java.lang.Iterable");
    }
}
