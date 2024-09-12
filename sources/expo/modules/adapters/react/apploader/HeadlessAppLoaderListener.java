package expo.modules.adapters.react.apploader;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lexpo/modules/adapters/react/apploader/HeadlessAppLoaderListener;", "", "appDestroyed", "", "appScopeKey", "", "appLoaded", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HeadlessAppLoaderNotifier.kt */
public interface HeadlessAppLoaderListener {
    void appDestroyed(String str);

    void appLoaded(String str);
}
