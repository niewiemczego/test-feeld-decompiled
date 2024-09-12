package zendesk.android.internal.frontendevents.di;

import android.content.Context;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;
import zendesk.android.internal.di.ZendeskInitializedComponentScope;
import zendesk.android.internal.frontendevents.FrontendEventsApi;
import zendesk.android.internal.frontendevents.pageviewevents.DefaultPageViewEvents;
import zendesk.android.internal.frontendevents.pageviewevents.PageViewEvents;
import zendesk.storage.android.Storage;
import zendesk.storage.android.StorageFactory;
import zendesk.storage.android.StorageType;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \f2\u00020\u0001:\u0002\u000b\fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\r"}, d2 = {"Lzendesk/android/internal/frontendevents/di/FrontendEventsModule;", "", "()V", "providesFrontendEventsApi", "Lzendesk/android/internal/frontendevents/FrontendEventsApi;", "retrofit", "Lretrofit2/Retrofit;", "providesFrontendEventsStorage", "Lzendesk/storage/android/Storage;", "context", "Landroid/content/Context;", "BindsModule", "Companion", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {BindsModule.class})
/* compiled from: FrontendEventsModule.kt */
public final class FrontendEventsModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FRONTEND_EVENTS_STORAGE = "FRONTEND_EVENTS_STORAGE";
    private static final String PAGEVIEWS_STORAGE_NAMESPACE = "pageviews";

    @Module
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lzendesk/android/internal/frontendevents/di/FrontendEventsModule$BindsModule;", "", "providesPageViewEvents", "Lzendesk/android/internal/frontendevents/pageviewevents/PageViewEvents;", "defaultPageViewEvents", "Lzendesk/android/internal/frontendevents/pageviewevents/DefaultPageViewEvents;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FrontendEventsModule.kt */
    public interface BindsModule {
        @Binds
        @ZendeskInitializedComponentScope
        PageViewEvents providesPageViewEvents(DefaultPageViewEvents defaultPageViewEvents);
    }

    @Provides
    @ZendeskInitializedComponentScope
    public final FrontendEventsApi providesFrontendEventsApi(Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object create = retrofit.create(FrontendEventsApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "retrofit.create(FrontendEventsApi::class.java)");
        return (FrontendEventsApi) create;
    }

    @Provides
    @Named("FRONTEND_EVENTS_STORAGE")
    @ZendeskInitializedComponentScope
    public final Storage providesFrontendEventsStorage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return StorageFactory.INSTANCE.create(PAGEVIEWS_STORAGE_NAMESPACE, context, StorageType.Basic.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lzendesk/android/internal/frontendevents/di/FrontendEventsModule$Companion;", "", "()V", "FRONTEND_EVENTS_STORAGE", "", "PAGEVIEWS_STORAGE_NAMESPACE", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FrontendEventsModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
