package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DescriptorRenderer.kt */
public enum DescriptorRendererModifier {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true),
    FUN(true),
    VALUE(true);
    
    public static final Set<DescriptorRendererModifier> ALL = null;
    public static final Set<DescriptorRendererModifier> ALL_EXCEPT_ANNOTATIONS = null;
    public static final Companion Companion = null;
    private final boolean includeByDefault;

    private DescriptorRendererModifier(boolean z) {
        this.includeByDefault = z;
    }

    static {
        int i;
        Companion = new Companion((DefaultConstructorMarker) null);
        DescriptorRendererModifier[] values = values();
        Collection arrayList = new ArrayList();
        for (DescriptorRendererModifier descriptorRendererModifier : values) {
            if (descriptorRendererModifier.includeByDefault) {
                arrayList.add(descriptorRendererModifier);
            }
        }
        ALL_EXCEPT_ANNOTATIONS = CollectionsKt.toSet((List) arrayList);
        ALL = ArraysKt.toSet((T[]) values());
    }

    /* compiled from: DescriptorRenderer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
