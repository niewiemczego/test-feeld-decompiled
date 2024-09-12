package expo.modules;

import android.app.Application;
import android.content.res.Configuration;
import com.google.android.exoplayer2.util.MimeTypes;
import expo.modules.core.interfaces.ApplicationLifecycleListener;
import expo.modules.core.interfaces.Package;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/ApplicationLifecycleDispatcher;", "", "()V", "listeners", "", "Lexpo/modules/core/interfaces/ApplicationLifecycleListener;", "getCachedListeners", "application", "Landroid/app/Application;", "onApplicationCreate", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "expo_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ApplicationLifecycleDispatcher.kt */
public final class ApplicationLifecycleDispatcher {
    public static final ApplicationLifecycleDispatcher INSTANCE = new ApplicationLifecycleDispatcher();
    private static List<? extends ApplicationLifecycleListener> listeners;

    private ApplicationLifecycleDispatcher() {
    }

    private final List<ApplicationLifecycleListener> getCachedListeners(Application application) {
        List<? extends ApplicationLifecycleListener> list = listeners;
        if (list != null) {
            return list;
        }
        Collection arrayList = new ArrayList();
        for (Package createApplicationLifecycleListeners : ExpoModulesPackage.Companion.getPackageList()) {
            List<? extends ApplicationLifecycleListener> createApplicationLifecycleListeners2 = createApplicationLifecycleListeners.createApplicationLifecycleListeners(application);
            Intrinsics.checkNotNullExpressionValue(createApplicationLifecycleListeners2, "it.createApplicationLife…cleListeners(application)");
            CollectionsKt.addAll(arrayList, createApplicationLifecycleListeners2);
        }
        List<? extends ApplicationLifecycleListener> list2 = (List) arrayList;
        listeners = list2;
        return list2;
    }

    @JvmStatic
    public static final void onApplicationCreate(Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        for (ApplicationLifecycleListener onCreate : INSTANCE.getCachedListeners(application)) {
            onCreate.onCreate(application);
        }
    }

    @JvmStatic
    public static final void onConfigurationChanged(Application application, Configuration configuration) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        for (ApplicationLifecycleListener onConfigurationChanged : INSTANCE.getCachedListeners(application)) {
            onConfigurationChanged.onConfigurationChanged(configuration);
        }
    }
}
