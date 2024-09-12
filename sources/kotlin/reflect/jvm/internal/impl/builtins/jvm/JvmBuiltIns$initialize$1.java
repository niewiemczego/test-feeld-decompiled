package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* compiled from: JvmBuiltIns.kt */
final class JvmBuiltIns$initialize$1 extends Lambda implements Function0<JvmBuiltIns.Settings> {
    final /* synthetic */ boolean $isAdditionalBuiltInsFeatureSupported;
    final /* synthetic */ ModuleDescriptor $moduleDescriptor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmBuiltIns$initialize$1(ModuleDescriptor moduleDescriptor, boolean z) {
        super(0);
        this.$moduleDescriptor = moduleDescriptor;
        this.$isAdditionalBuiltInsFeatureSupported = z;
    }

    public final JvmBuiltIns.Settings invoke() {
        return new JvmBuiltIns.Settings(this.$moduleDescriptor, this.$isAdditionalBuiltInsFeatureSupported);
    }
}
