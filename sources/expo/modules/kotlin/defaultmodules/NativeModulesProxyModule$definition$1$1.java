package expo.modules.kotlin.defaultmodules;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NativeModulesProxyModule.kt */
final class NativeModulesProxyModule$definition$1$1 extends Lambda implements Function0<Map<String, ? extends Object>> {
    final /* synthetic */ NativeModulesProxyModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NativeModulesProxyModule$definition$1$1(NativeModulesProxyModule nativeModulesProxyModule) {
        super(0);
        this.this$0 = nativeModulesProxyModule;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r0 = (expo.modules.adapters.react.NativeModulesProxy) r0.get();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.Object> invoke() {
        /*
            r1 = this;
            expo.modules.kotlin.defaultmodules.NativeModulesProxyModule r0 = r1.this$0
            expo.modules.kotlin.AppContext r0 = r0.getAppContext()
            java.lang.ref.WeakReference r0 = r0.getLegacyModulesProxyHolder$expo_modules_core_release()
            if (r0 == 0) goto L_0x0019
            java.lang.Object r0 = r0.get()
            expo.modules.adapters.react.NativeModulesProxy r0 = (expo.modules.adapters.react.NativeModulesProxy) r0
            if (r0 == 0) goto L_0x0019
            java.util.Map r0 = r0.getConstants()
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            if (r0 != 0) goto L_0x0020
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.defaultmodules.NativeModulesProxyModule$definition$1$1.invoke():java.util.Map");
    }
}
