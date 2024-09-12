package expo.modules;

import expo.modules.core.interfaces.ReactNativeHostHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Lexpo/modules/core/interfaces/ReactNativeHostHandler;", "kotlin.jvm.PlatformType", "invoke", "(Lexpo/modules/core/interfaces/ReactNativeHostHandler;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReactNativeHostWrapperBase.kt */
final class ReactNativeHostWrapperBase$getUseDeveloperSupport$1 extends Lambda implements Function1<ReactNativeHostHandler, Boolean> {
    public static final ReactNativeHostWrapperBase$getUseDeveloperSupport$1 INSTANCE = new ReactNativeHostWrapperBase$getUseDeveloperSupport$1();

    ReactNativeHostWrapperBase$getUseDeveloperSupport$1() {
        super(1);
    }

    public final Boolean invoke(ReactNativeHostHandler reactNativeHostHandler) {
        return reactNativeHostHandler.getUseDeveloperSupport();
    }
}
