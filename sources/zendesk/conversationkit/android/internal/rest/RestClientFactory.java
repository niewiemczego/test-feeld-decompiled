package zendesk.conversationkit.android.internal.rest;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;
import java.io.File;
import java.util.Date;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.commons.io.IOUtils;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import zendesk.conversationkit.android.internal.rest.model.SendFieldResponseDto;
import zendesk.conversationkit.android.internal.rest.model.SendMessageDto;
import zendesk.faye.internal.Bayeux;
import zendesk.okhttp.HeaderInterceptor;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$BJ\u00120\u0010\u0002\u001a,\u0012(\u0012&\u0012\u0004\u0012\u00020\u0005\u0012\u001c\u0012\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u00040\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005JG\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u000522\b\u0002\u0010\u001f\u001a,\u0012(\u0012&\u0012\u0004\u0012\u00020\u0005\u0012\u001c\u0012\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u00040\u0003H\u0002ø\u0001\u0000J&\u0010 \u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R;\u0010\u0002\u001a,\u0012(\u0012&\u0012\u0004\u0012\u00020\u0005\u0012\u001c\u0012\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u00040\u0003X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/RestClientFactory;", "", "defaultHeaders", "", "Lkotlin/Pair;", "", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "restClientFiles", "Lzendesk/conversationkit/android/internal/rest/RestClientFiles;", "cacheDir", "Ljava/io/File;", "(Ljava/util/Set;Lzendesk/conversationkit/android/internal/rest/RestClientFiles;Ljava/io/File;)V", "converterFactory", "Lretrofit2/converter/moshi/MoshiConverterFactory;", "buildOkHttpClient", "Lokhttp3/OkHttpClient;", "interceptors", "Lokhttp3/Interceptor;", "buildRetrofit", "Lretrofit2/Retrofit;", "baseUrl", "okHttpClient", "createAppRestClient", "Lzendesk/conversationkit/android/internal/rest/AppRestClient;", "appId", "createIntegrationRestClient", "Lzendesk/conversationkit/android/internal/rest/IntegrationRestClient;", "integrationId", "createSunshineConversationsApi", "Lzendesk/conversationkit/android/internal/rest/SunshineConversationsApi;", "headers", "createUserRestClient", "Lzendesk/conversationkit/android/internal/rest/UserRestClient;", "appUserId", "clientId", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RestClientFactory.kt */
public final class RestClientFactory {
    private static final long CACHE_SIZE = 20971520;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final File cacheDir;
    private final MoshiConverterFactory converterFactory;
    private final Set<Pair<String, Function1<Continuation<? super String>, Object>>> defaultHeaders;
    private final RestClientFiles restClientFiles;

    public RestClientFactory(Set<? extends Pair<String, ? extends Function1<? super Continuation<? super String>, ? extends Object>>> set, RestClientFiles restClientFiles2, File file) {
        Intrinsics.checkNotNullParameter(set, "defaultHeaders");
        Intrinsics.checkNotNullParameter(restClientFiles2, "restClientFiles");
        Intrinsics.checkNotNullParameter(file, "cacheDir");
        this.defaultHeaders = set;
        this.restClientFiles = restClientFiles2;
        this.cacheDir = file;
        MoshiConverterFactory create = MoshiConverterFactory.create(Companion.buildMoshi$zendesk_conversationkit_conversationkit_android());
        Intrinsics.checkNotNullExpressionValue(create, "create(buildMoshi())");
        this.converterFactory = create;
    }

    public final IntegrationRestClient createIntegrationRestClient(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "integrationId");
        Intrinsics.checkNotNullParameter(str2, "baseUrl");
        return new IntegrationRestClient(str, createSunshineConversationsApi$default(this, str2, (Set) null, 2, (Object) null));
    }

    public final AppRestClient createAppRestClient(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "baseUrl");
        return new AppRestClient(str, createSunshineConversationsApi(str2, SetsKt.setOf(TuplesKt.to("x-smooch-appid", new RestClientFactory$createAppRestClient$1(str, (Continuation<? super RestClientFactory$createAppRestClient$1>) null)))));
    }

    public final UserRestClient createUserRestClient(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "appUserId");
        Intrinsics.checkNotNullParameter(str3, "baseUrl");
        Intrinsics.checkNotNullParameter(str4, Bayeux.KEY_CLIENT_ID);
        return new UserRestClient(str, str2, createSunshineConversationsApi(str3, SetsKt.setOf(TuplesKt.to("x-smooch-appid", new RestClientFactory$createUserRestClient$1(str, (Continuation<? super RestClientFactory$createUserRestClient$1>) null)), TuplesKt.to("x-smooch-clientid", new RestClientFactory$createUserRestClient$2(str4, (Continuation<? super RestClientFactory$createUserRestClient$2>) null)))), this.restClientFiles);
    }

    static /* synthetic */ SunshineConversationsApi createSunshineConversationsApi$default(RestClientFactory restClientFactory, String str, Set set, int i, Object obj) {
        if ((i & 2) != 0) {
            set = SetsKt.emptySet();
        }
        return restClientFactory.createSunshineConversationsApi(str, set);
    }

    private final SunshineConversationsApi createSunshineConversationsApi(String str, Set<? extends Pair<String, ? extends Function1<? super Continuation<? super String>, ? extends Object>>> set) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        httpLoggingInterceptor.redactHeader("Authorization");
        Object create = buildRetrofit(str, buildOkHttpClient(SetsKt.setOf(new HeaderInterceptor(SetsKt.plus(this.defaultHeaders, set)), httpLoggingInterceptor))).create(SunshineConversationsApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "buildRetrofit(baseUrl, o…ersationsApi::class.java)");
        return (SunshineConversationsApi) create;
    }

    private final OkHttpClient buildOkHttpClient(Set<? extends Interceptor> set) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        for (Interceptor addInterceptor : set) {
            builder.addInterceptor(addInterceptor);
        }
        builder.cache(new Cache(this.cacheDir, 20971520));
        return builder.build();
    }

    private final Retrofit buildRetrofit(String str, OkHttpClient okHttpClient) {
        if (!StringsKt.endsWith$default(str, "/", false, 2, (Object) null)) {
            str = str + IOUtils.DIR_SEPARATOR_UNIX;
        }
        Retrofit build = new Retrofit.Builder().baseUrl(str).client(okHttpClient).addConverterFactory(this.converterFactory).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .b…ory)\n            .build()");
        return build;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/RestClientFactory$Companion;", "", "()V", "CACHE_SIZE", "", "buildMoshi", "Lcom/squareup/moshi/Moshi;", "buildMoshi$zendesk_conversationkit_conversationkit_android", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RestClientFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Moshi buildMoshi$zendesk_conversationkit_conversationkit_android() {
            Moshi build = new Moshi.Builder().add((JsonAdapter.Factory) PolymorphicJsonAdapterFactory.of(SendMessageDto.class, "type").withSubtype(SendMessageDto.Text.class, "text").withSubtype(SendMessageDto.FormResponse.class, "formResponse")).add((JsonAdapter.Factory) PolymorphicJsonAdapterFactory.of(SendFieldResponseDto.class, "type").withSubtype(SendFieldResponseDto.Text.class, "text").withSubtype(SendFieldResponseDto.Email.class, "email").withSubtype(SendFieldResponseDto.Select.class, "select")).add(Date.class, new Rfc3339DateJsonAdapter()).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .a…r())\n            .build()");
            return build;
        }
    }
}
