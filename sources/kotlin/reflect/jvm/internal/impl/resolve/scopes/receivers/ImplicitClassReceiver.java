package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: ImplicitClassReceiver.kt */
public class ImplicitClassReceiver implements ImplicitReceiver, ThisClassReceiver {
    private final ClassDescriptor classDescriptor;
    private final ClassDescriptor declarationDescriptor;
    private final ImplicitClassReceiver original;

    public ImplicitClassReceiver(ClassDescriptor classDescriptor2, ImplicitClassReceiver implicitClassReceiver) {
        Intrinsics.checkNotNullParameter(classDescriptor2, "classDescriptor");
        this.classDescriptor = classDescriptor2;
        this.original = implicitClassReceiver == null ? this : implicitClassReceiver;
        this.declarationDescriptor = classDescriptor2;
    }

    public final ClassDescriptor getClassDescriptor() {
        return this.classDescriptor;
    }

    public SimpleType getType() {
        SimpleType defaultType = this.classDescriptor.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "classDescriptor.defaultType");
        return defaultType;
    }

    public boolean equals(Object obj) {
        ClassDescriptor classDescriptor2 = this.classDescriptor;
        ClassDescriptor classDescriptor3 = null;
        ImplicitClassReceiver implicitClassReceiver = obj instanceof ImplicitClassReceiver ? (ImplicitClassReceiver) obj : null;
        if (implicitClassReceiver != null) {
            classDescriptor3 = implicitClassReceiver.classDescriptor;
        }
        return Intrinsics.areEqual((Object) classDescriptor2, (Object) classDescriptor3);
    }

    public int hashCode() {
        return this.classDescriptor.hashCode();
    }

    public String toString() {
        return "Class{" + getType() + '}';
    }
}
