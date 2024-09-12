package zendesk.android.internal.di;

import android.content.Context;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import zendesk.android.events.internal.ZendeskEventDispatcher;
import zendesk.android.internal.di.ZendeskInitializedComponent;
import zendesk.android.internal.network.NetworkModule;
import zendesk.android.settings.internal.SettingsRepository;

@Singleton
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"Lzendesk/android/internal/di/ZendeskComponent;", "", "zendeskInitializedComponent", "Lzendesk/android/internal/di/ZendeskInitializedComponent$Builder;", "getZendeskInitializedComponent", "()Lzendesk/android/internal/di/ZendeskInitializedComponent$Builder;", "componentData", "Lzendesk/android/internal/di/ZendeskComponentConfig;", "context", "Landroid/content/Context;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "settingsRepository", "Lzendesk/android/settings/internal/SettingsRepository;", "zendeskEventDispatcher", "Lzendesk/android/events/internal/ZendeskEventDispatcher;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(modules = {ZendeskModule.class, NetworkModule.class, CoroutineDispatchersModule.class})
/* compiled from: ZendeskComponent.kt */
public interface ZendeskComponent {
    ZendeskComponentConfig componentData();

    Context context();

    ZendeskInitializedComponent.Builder getZendeskInitializedComponent();

    CoroutineScope mainScope();

    SettingsRepository settingsRepository();

    ZendeskEventDispatcher zendeskEventDispatcher();
}
