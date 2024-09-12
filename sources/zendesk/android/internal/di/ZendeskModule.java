package zendesk.android.internal.di;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Retrofit;
import zendesk.android.settings.internal.SettingsApi;
import zendesk.core.android.internal.app.ProcessLifecycleObserver;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\t\u001a\u00020\u0007H\u0001¢\u0006\u0002\b\nJ\r\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\b\u000bJ\r\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\b\fJ\r\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\b\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lzendesk/android/internal/di/ZendeskModule;", "", "context", "Landroid/content/Context;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "componentConfig", "Lzendesk/android/internal/di/ZendeskComponentConfig;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;Lzendesk/android/internal/di/ZendeskComponentConfig;)V", "componentData", "componentData$zendesk_zendesk_android", "context$zendesk_zendesk_android", "mainScope$zendesk_zendesk_android", "provideProcessLifecycleObserver", "Lzendesk/core/android/internal/app/ProcessLifecycleObserver;", "provideProcessLifecycleObserver$zendesk_zendesk_android", "settingsApi", "Lzendesk/android/settings/internal/SettingsApi;", "retrofit", "Lretrofit2/Retrofit;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(subcomponents = {ZendeskInitializedComponent.class})
/* compiled from: ZendeskModule.kt */
public final class ZendeskModule {
    private final ZendeskComponentConfig componentConfig;
    private final Context context;
    private final CoroutineScope mainScope;

    public ZendeskModule(Context context2, CoroutineScope coroutineScope, ZendeskComponentConfig zendeskComponentConfig) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(coroutineScope, "mainScope");
        Intrinsics.checkNotNullParameter(zendeskComponentConfig, "componentConfig");
        this.context = context2;
        this.mainScope = coroutineScope;
        this.componentConfig = zendeskComponentConfig;
    }

    @Singleton
    @Provides
    public final Context context$zendesk_zendesk_android() {
        return this.context;
    }

    @Singleton
    @Provides
    public final ZendeskComponentConfig componentData$zendesk_zendesk_android() {
        return this.componentConfig;
    }

    @Singleton
    @Provides
    public final CoroutineScope mainScope$zendesk_zendesk_android() {
        return this.mainScope;
    }

    @Singleton
    @Provides
    public final ProcessLifecycleObserver provideProcessLifecycleObserver$zendesk_zendesk_android() {
        return ProcessLifecycleObserver.Companion.newInstance();
    }

    @Singleton
    @Provides
    public final SettingsApi settingsApi(Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object create = retrofit.create(SettingsApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "retrofit.create(SettingsApi::class.java)");
        return (SettingsApi) create;
    }
}
