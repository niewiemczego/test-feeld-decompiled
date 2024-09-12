package com.adapty.internal.di;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.adapty.internal.AdaptyInternal;
import com.adapty.internal.data.cache.CacheRepository;
import com.adapty.internal.data.cache.PreferenceManager;
import com.adapty.internal.data.cache.ResponseCacheKeyProvider;
import com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher;
import com.adapty.internal.data.cloud.AnalyticsTracker;
import com.adapty.internal.data.cloud.CloudRepository;
import com.adapty.internal.data.cloud.HttpClient;
import com.adapty.internal.data.cloud.HttpResponseManager;
import com.adapty.internal.data.cloud.NetworkConnectionCreator;
import com.adapty.internal.data.cloud.RequestFactory;
import com.adapty.internal.data.cloud.ResponseBodyConverter;
import com.adapty.internal.data.cloud.StoreManager;
import com.adapty.internal.di.DIObject;
import com.adapty.internal.domain.AuthInteractor;
import com.adapty.internal.domain.ProductsInteractor;
import com.adapty.internal.domain.ProfileInteractor;
import com.adapty.internal.domain.PurchasesInteractor;
import com.adapty.internal.utils.AdIdRetriever;
import com.adapty.internal.utils.AdaptyUiMetaRetriever;
import com.adapty.internal.utils.AppSetIdRetriever;
import com.adapty.internal.utils.AttributionHelper;
import com.adapty.internal.utils.CrossplatformMetaRetriever;
import com.adapty.internal.utils.CurrencyHelper;
import com.adapty.internal.utils.CustomAttributeValidator;
import com.adapty.internal.utils.HashingHelper;
import com.adapty.internal.utils.IPv4Retriever;
import com.adapty.internal.utils.InstallationMetaCreator;
import com.adapty.internal.utils.LifecycleAwareRequestRunner;
import com.adapty.internal.utils.LifecycleManager;
import com.adapty.internal.utils.MetaInfoRetriever;
import com.adapty.internal.utils.PayloadProvider;
import com.adapty.internal.utils.PaywallMapper;
import com.adapty.internal.utils.PaywallPicker;
import com.adapty.internal.utils.ProductMapper;
import com.adapty.internal.utils.ProductPicker;
import com.adapty.internal.utils.ProfileMapper;
import com.adapty.internal.utils.ReplacementModeMapper;
import com.adapty.internal.utils.StoreCountryRetriever;
import com.adapty.internal.utils.UserAgentRetriever;
import com.adapty.internal.utils.ViewConfigurationMapper;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.gson.Gson;
import java.text.Format;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Semaphore;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018J(\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001a\"\u0006\b\u0000\u0010\u001b\u0018\u00012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\b¢\u0006\u0002\b\u001dJ\"\u0010\u001e\u001a\u0002H\u001b\"\u0006\b\u0000\u0010\u001b\u0018\u00012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\b¢\u0006\u0002\u0010\u001fJ:\u0010 \u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\r0\f\"\u0004\b\u0000\u0010\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001b0\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R^\u0010\t\u001aJ\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f0\nj$\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f`\u000e8@X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/adapty/internal/di/Dependencies;", "", "()V", "ANALYTICS", "", "BASE", "LOCAL", "RECORD_ONLY", "REMOTE", "map", "Ljava/util/HashMap;", "Ljava/lang/Class;", "", "Lcom/adapty/internal/di/DIObject;", "Lkotlin/collections/HashMap;", "getMap$adapty_release", "()Ljava/util/HashMap;", "init", "", "appContext", "Landroid/content/Context;", "apiKey", "observerMode", "", "init$adapty_release", "inject", "Lkotlin/Lazy;", "T", "named", "inject$adapty_release", "injectInternal", "(Ljava/lang/String;)Ljava/lang/Object;", "singleVariantDiObject", "initializer", "Lkotlin/Function0;", "initType", "Lcom/adapty/internal/di/DIObject$InitType;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
public final class Dependencies {
    private static final String ANALYTICS = "analytics";
    private static final String BASE = "base";
    public static final Dependencies INSTANCE = new Dependencies();
    private static final String LOCAL = "local";
    private static final String RECORD_ONLY = "record_only";
    private static final String REMOTE = "remote";
    private static final HashMap<Class<?>, Map<String, DIObject<?>>> map = new HashMap<>();

    private Dependencies() {
    }

    public static /* synthetic */ Lazy inject$adapty_release$default(Dependencies dependencies, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, new Dependencies$inject$1(str));
    }

    public final /* synthetic */ <T> Lazy<T> inject$adapty_release(String str) {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, new Dependencies$inject$1(str));
    }

    private final /* synthetic */ <T> T injectInternal(String str) {
        HashMap map$adapty_release = getMap$adapty_release();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Object obj = map$adapty_release.get(Object.class);
        Intrinsics.checkNotNull(obj);
        Object obj2 = ((Map) obj).get(str);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        return ((DIObject) obj2).provide();
    }

    static /* synthetic */ Object injectInternal$default(Dependencies dependencies, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        HashMap map$adapty_release = dependencies.getMap$adapty_release();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Object obj2 = map$adapty_release.get(Object.class);
        Intrinsics.checkNotNull(obj2);
        Object obj3 = ((Map) obj2).get(str);
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        return ((DIObject) obj3).provide();
    }

    public final /* synthetic */ HashMap getMap$adapty_release() {
        return map;
    }

    static /* synthetic */ Map singleVariantDiObject$default(Dependencies dependencies, Function0 function0, DIObject.InitType initType, int i, Object obj) {
        if ((i & 2) != 0) {
            initType = DIObject.InitType.SINGLETON;
        }
        return dependencies.singleVariantDiObject(function0, initType);
    }

    private final <T> Map<String, DIObject<T>> singleVariantDiObject(Function0<? extends T> function0, DIObject.InitType initType) {
        return MapsKt.mapOf(TuplesKt.to(null, new DIObject(function0, initType)));
    }

    public final /* synthetic */ void init$adapty_release(Context context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(str, DynamicLink.Builder.KEY_API_KEY);
        MapsKt.putAll(map, CollectionsKt.listOf(TuplesKt.to(Gson.class, MapsKt.mapOf(TuplesKt.to("base", new DIObject(Dependencies$init$1.INSTANCE, (DIObject.InitType) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(ANALYTICS, new DIObject(Dependencies$init$2.INSTANCE, (DIObject.InitType) null, 2, (DefaultConstructorMarker) null)))), TuplesKt.to(Format.class, singleVariantDiObject$default(this, Dependencies$init$3.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(PreferenceManager.class, singleVariantDiObject$default(this, new Dependencies$init$4(context), (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(CloudRepository.class, singleVariantDiObject$default(this, Dependencies$init$5.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(CacheRepository.class, singleVariantDiObject$default(this, Dependencies$init$6.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(HttpClient.class, MapsKt.mapOf(TuplesKt.to("base", new DIObject(Dependencies$init$7.INSTANCE, (DIObject.InitType) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(ANALYTICS, new DIObject(Dependencies$init$8.INSTANCE, (DIObject.InitType) null, 2, (DefaultConstructorMarker) null)))), TuplesKt.to(Semaphore.class, MapsKt.mapOf(TuplesKt.to("local", new DIObject(Dependencies$init$9.INSTANCE, (DIObject.InitType) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(REMOTE, new DIObject(Dependencies$init$10.INSTANCE, (DIObject.InitType) null, 2, (DefaultConstructorMarker) null)))), TuplesKt.to(AnalyticsEventQueueDispatcher.class, singleVariantDiObject$default(this, Dependencies$init$11.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(AnalyticsTracker.class, MapsKt.mapOf(TuplesKt.to("base", new DIObject(Dependencies$init$12.INSTANCE, (DIObject.InitType) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(RECORD_ONLY, new DIObject(Dependencies$init$13.INSTANCE, (DIObject.InitType) null, 2, (DefaultConstructorMarker) null)))), TuplesKt.to(NetworkConnectionCreator.class, singleVariantDiObject$default(this, Dependencies$init$14.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(HttpResponseManager.class, MapsKt.mapOf(TuplesKt.to("base", new DIObject(Dependencies$init$15.INSTANCE, (DIObject.InitType) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(ANALYTICS, new DIObject(Dependencies$init$16.INSTANCE, (DIObject.InitType) null, 2, (DefaultConstructorMarker) null)))), TuplesKt.to(ResponseBodyConverter.class, singleVariantDiObject$default(this, Dependencies$init$17.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(ResponseCacheKeyProvider.class, singleVariantDiObject$default(this, Dependencies$init$18.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(PayloadProvider.class, singleVariantDiObject$default(this, Dependencies$init$19.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(RequestFactory.class, singleVariantDiObject$default(this, new Dependencies$init$20(str, z), (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(InstallationMetaCreator.class, singleVariantDiObject$default(this, Dependencies$init$21.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(MetaInfoRetriever.class, singleVariantDiObject$default(this, new Dependencies$init$22(context), (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(CrossplatformMetaRetriever.class, singleVariantDiObject$default(this, Dependencies$init$23.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(AdaptyUiMetaRetriever.class, singleVariantDiObject$default(this, Dependencies$init$24.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(AdIdRetriever.class, singleVariantDiObject$default(this, new Dependencies$init$25(context), (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(AppSetIdRetriever.class, singleVariantDiObject$default(this, new Dependencies$init$26(context), (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(StoreCountryRetriever.class, singleVariantDiObject$default(this, Dependencies$init$27.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(UserAgentRetriever.class, singleVariantDiObject$default(this, new Dependencies$init$28(context), (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(IPv4Retriever.class, singleVariantDiObject$default(this, Dependencies$init$29.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(CustomAttributeValidator.class, singleVariantDiObject$default(this, Dependencies$init$30.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(PaywallPicker.class, singleVariantDiObject$default(this, Dependencies$init$31.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(ProductPicker.class, singleVariantDiObject$default(this, Dependencies$init$32.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(AttributionHelper.class, singleVariantDiObject$default(this, Dependencies$init$33.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(CurrencyHelper.class, singleVariantDiObject$default(this, Dependencies$init$34.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(HashingHelper.class, singleVariantDiObject$default(this, Dependencies$init$35.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(PaywallMapper.class, singleVariantDiObject$default(this, Dependencies$init$36.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(ProductMapper.class, singleVariantDiObject$default(this, new Dependencies$init$37(context), (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(ReplacementModeMapper.class, singleVariantDiObject$default(this, Dependencies$init$38.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(ProfileMapper.class, singleVariantDiObject$default(this, Dependencies$init$39.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(ViewConfigurationMapper.class, singleVariantDiObject$default(this, Dependencies$init$40.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(StoreManager.class, singleVariantDiObject$default(this, new Dependencies$init$41(context), (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(LifecycleAwareRequestRunner.class, singleVariantDiObject$default(this, Dependencies$init$42.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(LifecycleManager.class, singleVariantDiObject$default(this, Dependencies$init$43.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(ProductsInteractor.class, singleVariantDiObject$default(this, Dependencies$init$44.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(ProfileInteractor.class, singleVariantDiObject$default(this, Dependencies$init$45.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(PurchasesInteractor.class, singleVariantDiObject$default(this, Dependencies$init$46.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(AuthInteractor.class, singleVariantDiObject$default(this, Dependencies$init$47.INSTANCE, (DIObject.InitType) null, 2, (Object) null)), TuplesKt.to(AdaptyInternal.class, singleVariantDiObject$default(this, new Dependencies$init$48(z), (DIObject.InitType) null, 2, (Object) null))));
    }
}
