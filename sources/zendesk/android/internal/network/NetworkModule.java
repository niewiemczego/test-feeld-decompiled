package zendesk.android.internal.network;

import android.content.Context;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.EnumJsonAdapter;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;
import dagger.Module;
import dagger.Provides;
import java.io.File;
import java.util.Date;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import zendesk.android.internal.di.ZendeskComponentConfig;
import zendesk.android.internal.proactivemessaging.model.ConditionFunction;
import zendesk.android.internal.proactivemessaging.model.ConditionType;
import zendesk.android.internal.proactivemessaging.model.ExpressionFunction;
import zendesk.android.internal.proactivemessaging.model.ExpressionTarget;
import zendesk.android.internal.proactivemessaging.model.ExpressionType;
import zendesk.android.internal.proactivemessaging.model.Frequency;
import zendesk.android.internal.proactivemessaging.model.Status;
import zendesk.android.internal.proactivemessaging.model.TriggerType;
import zendesk.android.internal.proactivemessaging.model.adapter.ExpressionAdapter;
import zendesk.okhttp.NetworkExtKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0007J\f\u0010\u0013\u001a\u00020\u0014*\u00020\u0014H\u0002¨\u0006\u0016"}, d2 = {"Lzendesk/android/internal/network/NetworkModule;", "", "()V", "cacheDir", "Ljava/io/File;", "context", "Landroid/content/Context;", "moshi", "Lcom/squareup/moshi/Moshi;", "moshiConverterFactory", "Lretrofit2/converter/moshi/MoshiConverterFactory;", "okHttpClient", "Lokhttp3/OkHttpClient;", "headerFactory", "Lzendesk/android/internal/network/HeaderFactory;", "retrofit", "Lretrofit2/Retrofit;", "componentConfig", "Lzendesk/android/internal/di/ZendeskComponentConfig;", "addProactiveMessagingUnknownFallback", "Lcom/squareup/moshi/Moshi$Builder;", "Companion", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* compiled from: NetworkModule.kt */
public final class NetworkModule {
    public static final long CACHE_SIZE = 20971520;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ZENDESK_ANDROID_DIR_NAME = "zendesk.android";

    @Singleton
    @Provides
    public final File cacheDir(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new File(context.getCacheDir(), ZENDESK_ANDROID_DIR_NAME);
    }

    @Singleton
    @Provides
    public final OkHttpClient okHttpClient(HeaderFactory headerFactory, File file) {
        Intrinsics.checkNotNullParameter(headerFactory, "headerFactory");
        Intrinsics.checkNotNullParameter(file, "cacheDir");
        return NetworkExtKt.addInterceptors(new OkHttpClient.Builder(), headerFactory.createHeaderInterceptor(), headerFactory.loggingInterceptor()).cache(new Cache(file, CACHE_SIZE)).build();
    }

    @Singleton
    @Provides
    public final Retrofit retrofit(ZendeskComponentConfig zendeskComponentConfig, OkHttpClient okHttpClient, MoshiConverterFactory moshiConverterFactory) {
        Intrinsics.checkNotNullParameter(zendeskComponentConfig, "componentConfig");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(moshiConverterFactory, "moshiConverterFactory");
        Retrofit build = new Retrofit.Builder().baseUrl(zendeskComponentConfig.getBaseUrl()).client(okHttpClient).addConverterFactory(moshiConverterFactory).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .b…ory)\n            .build()");
        return build;
    }

    @Singleton
    @Provides
    public final MoshiConverterFactory moshiConverterFactory(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        MoshiConverterFactory create = MoshiConverterFactory.create(moshi);
        Intrinsics.checkNotNullExpressionValue(create, "create(moshi)");
        return create;
    }

    @Singleton
    @Provides
    public final Moshi moshi() {
        Moshi.Builder add = new Moshi.Builder().add(Date.class, new Rfc3339DateJsonAdapter()).add((Object) new ExpressionAdapter());
        Intrinsics.checkNotNullExpressionValue(add, "Builder()\n        .add(D….add(ExpressionAdapter())");
        Moshi build = addProactiveMessagingUnknownFallback(add).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .add(D…llback()\n        .build()");
        return build;
    }

    private final Moshi.Builder addProactiveMessagingUnknownFallback(Moshi.Builder builder) {
        Moshi.Builder add = builder.add(ConditionType.class, EnumJsonAdapter.create(ConditionType.class).withUnknownFallback(ConditionType.UNKNOWN)).add(ConditionFunction.class, EnumJsonAdapter.create(ConditionFunction.class).withUnknownFallback(ConditionFunction.UNKNOWN)).add(TriggerType.class, EnumJsonAdapter.create(TriggerType.class).withUnknownFallback(TriggerType.UNKNOWN)).add(ExpressionFunction.class, EnumJsonAdapter.create(ExpressionFunction.class).withUnknownFallback(ExpressionFunction.UNKNOWN)).add(ExpressionTarget.class, EnumJsonAdapter.create(ExpressionTarget.class).withUnknownFallback(ExpressionTarget.UNKNOWN)).add(ExpressionType.class, EnumJsonAdapter.create(ExpressionType.class).withUnknownFallback(ExpressionType.UNKNOWN)).add(Status.class, EnumJsonAdapter.create(Status.class).withUnknownFallback(Status.UNKNOWN)).add(Frequency.class, EnumJsonAdapter.create(Frequency.class).withUnknownFallback(Frequency.UNKNOWN));
        Intrinsics.checkNotNullExpressionValue(add, "this.add(\n            Co…quency.UNKNOWN)\n        )");
        return add;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lzendesk/android/internal/network/NetworkModule$Companion;", "", "()V", "CACHE_SIZE", "", "ZENDESK_ANDROID_DIR_NAME", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NetworkModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
