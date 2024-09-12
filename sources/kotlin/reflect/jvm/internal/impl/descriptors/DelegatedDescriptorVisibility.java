package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: DescriptorVisibility.kt */
public abstract class DelegatedDescriptorVisibility extends DescriptorVisibility {
    private final Visibility delegate;

    public DelegatedDescriptorVisibility(Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "delegate");
        this.delegate = visibility;
    }

    public Visibility getDelegate() {
        return this.delegate;
    }

    public String getInternalDisplayName() {
        return getDelegate().getInternalDisplayName();
    }

    public DescriptorVisibility normalize() {
        DescriptorVisibility descriptorVisibility = DescriptorVisibilities.toDescriptorVisibility(getDelegate().normalize());
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(delegate.normalize())");
        return descriptorVisibility;
    }
}
