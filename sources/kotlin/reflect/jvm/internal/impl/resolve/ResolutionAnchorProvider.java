package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* compiled from: ResolutionAnchorProvider.kt */
public interface ResolutionAnchorProvider {
    ModuleDescriptor getResolutionAnchor(ModuleDescriptor moduleDescriptor);
}
