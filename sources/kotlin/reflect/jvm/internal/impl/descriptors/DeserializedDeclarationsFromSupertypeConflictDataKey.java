package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;

/* compiled from: descriptorUtil.kt */
public final class DeserializedDeclarationsFromSupertypeConflictDataKey implements CallableDescriptor.UserDataKey<CallableMemberDescriptor> {
    public static final DeserializedDeclarationsFromSupertypeConflictDataKey INSTANCE = new DeserializedDeclarationsFromSupertypeConflictDataKey();

    private DeserializedDeclarationsFromSupertypeConflictDataKey() {
    }
}
