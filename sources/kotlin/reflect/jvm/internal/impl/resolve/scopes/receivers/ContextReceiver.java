package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: ContextReceiver.kt */
public final class ContextReceiver extends AbstractReceiverValue implements ImplicitReceiver {
    private final CallableDescriptor declarationDescriptor;

    public CallableDescriptor getDeclarationDescriptor() {
        return this.declarationDescriptor;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextReceiver(CallableDescriptor callableDescriptor, KotlinType kotlinType, ReceiverValue receiverValue) {
        super(kotlinType, receiverValue);
        Intrinsics.checkNotNullParameter(callableDescriptor, "declarationDescriptor");
        Intrinsics.checkNotNullParameter(kotlinType, "receiverType");
        this.declarationDescriptor = callableDescriptor;
    }

    public String toString() {
        return "Cxt { " + getDeclarationDescriptor() + " }";
    }
}
