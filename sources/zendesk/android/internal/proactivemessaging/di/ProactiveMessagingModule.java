package zendesk.android.internal.proactivemessaging.di;

import android.content.Context;
import com.squareup.moshi.Moshi;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;
import zendesk.android.internal.di.ZendeskInitializedComponentScope;
import zendesk.android.internal.proactivemessaging.ProactiveMessagingService;
import zendesk.android.internal.storage.ZendeskStorageSerializer;
import zendesk.storage.android.Storage;
import zendesk.storage.android.StorageFactory;
import zendesk.storage.android.StorageType;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000f"}, d2 = {"Lzendesk/android/internal/proactivemessaging/di/ProactiveMessagingModule;", "", "()V", "providesCampaignTriggerService", "Lzendesk/android/internal/proactivemessaging/ProactiveMessagingService;", "retrofit", "Lretrofit2/Retrofit;", "providesCurrentTimeProvider", "Lkotlin/Function0;", "", "providesProactiveMessagingStorage", "Lzendesk/storage/android/Storage;", "context", "Landroid/content/Context;", "Companion", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* compiled from: ProactiveMessagingModule.kt */
public final class ProactiveMessagingModule {
    public static final String CURRENT_TIME_PROVIDER = "CURRENT_TIME_PROVIDER";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PROACTIVE_MESSAGING_STORAGE = "PROACTIVE_MESSAGING_STORAGE";
    private static final String proactiveMessagingStorageNamespace = "zendesk.android.internal.proactivemessaging";

    @Provides
    @Named("PROACTIVE_MESSAGING_STORAGE")
    @ZendeskInitializedComponentScope
    public final Storage providesProactiveMessagingStorage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return StorageFactory.INSTANCE.create(proactiveMessagingStorageNamespace, context, new StorageType.Complex(new ZendeskStorageSerializer((Moshi) null, 1, (DefaultConstructorMarker) null)));
    }

    @Provides
    @ZendeskInitializedComponentScope
    public final ProactiveMessagingService providesCampaignTriggerService(Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object create = retrofit.create(ProactiveMessagingService.class);
        Intrinsics.checkNotNullExpressionValue(create, "retrofit.create(Proactiv…agingService::class.java)");
        return (ProactiveMessagingService) create;
    }

    @Named("CURRENT_TIME_PROVIDER")
    @ZendeskInitializedComponentScope
    @Provides
    public final Function0<Long> providesCurrentTimeProvider() {
        return ProactiveMessagingModule$providesCurrentTimeProvider$1.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lzendesk/android/internal/proactivemessaging/di/ProactiveMessagingModule$Companion;", "", "()V", "CURRENT_TIME_PROVIDER", "", "PROACTIVE_MESSAGING_STORAGE", "proactiveMessagingStorageNamespace", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProactiveMessagingModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
