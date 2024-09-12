package com.adapty.internal.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.adapty.BuildConfig;
import com.adapty.internal.data.cache.CacheRepository;
import com.amplitude.reactnative.AndroidContextProvider;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0001\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0014\u0010\r\u001a\u00020\u000eXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R'\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00128FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0017\u001a\n \u0018*\u0004\u0018\u00010\u000e0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0010R'\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00128FX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001b\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R)\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00128FX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b\u001e\u0010\u0014R\u0019\u0010 \u001a\n \u0018*\u0004\u0018\u00010!0!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0013\u0010$\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b%\u0010\u0010R\u0011\u0010&\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0010R\u0011\u0010(\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b)\u0010\u0010R\u0019\u0010*\u001a\n \u0018*\u0004\u0018\u00010\u000e0\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0010R\u0014\u0010,\u001a\u00020\u000eXD¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0010R\u0014\u0010.\u001a\u00020\u000eXD¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0010R\u0019\u00100\u001a\n \u0018*\u0004\u0018\u00010\u000e0\u000e8F¢\u0006\u0006\u001a\u0004\b1\u0010\u0010R\u0013\u00102\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b3\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/adapty/internal/utils/MetaInfoRetriever;", "", "appContext", "Landroid/content/Context;", "crossplatformMetaRetriever", "Lcom/adapty/internal/utils/CrossplatformMetaRetriever;", "adaptyUiMetaRetriever", "Lcom/adapty/internal/utils/AdaptyUiMetaRetriever;", "userAgentRetriever", "Lcom/adapty/internal/utils/UserAgentRetriever;", "cacheRepository", "Lcom/adapty/internal/data/cache/CacheRepository;", "(Landroid/content/Context;Lcom/adapty/internal/utils/CrossplatformMetaRetriever;Lcom/adapty/internal/utils/AdaptyUiMetaRetriever;Lcom/adapty/internal/utils/UserAgentRetriever;Lcom/adapty/internal/data/cache/CacheRepository;)V", "adaptySdkVersion", "", "getAdaptySdkVersion", "()Ljava/lang/String;", "adaptyUiAndBuilderVersion", "Lkotlin/Pair;", "getAdaptyUiAndBuilderVersion", "()Lkotlin/Pair;", "adaptyUiAndBuilderVersion$delegate", "Lkotlin/Lazy;", "androidId", "kotlin.jvm.PlatformType", "getAndroidId", "appBuildAndVersion", "getAppBuildAndVersion", "appBuildAndVersion$delegate", "crossplatformNameAndVersion", "getCrossplatformNameAndVersion", "crossplatformNameAndVersion$delegate", "currentLocale", "Ljava/util/Locale;", "getCurrentLocale", "()Ljava/util/Locale;", "currentLocaleFormatted", "getCurrentLocaleFormatted", "deviceName", "getDeviceName", "installationMetaId", "getInstallationMetaId", "os", "getOs", "platform", "getPlatform", "store", "getStore", "timezone", "getTimezone", "userAgent", "getUserAgent", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MetaInfoRetriever.kt */
public final class MetaInfoRetriever {
    private final /* synthetic */ String adaptySdkVersion;
    private final Lazy adaptyUiAndBuilderVersion$delegate;
    /* access modifiers changed from: private */
    public final AdaptyUiMetaRetriever adaptyUiMetaRetriever;
    private final Lazy appBuildAndVersion$delegate = LazyKt.lazy(new MetaInfoRetriever$appBuildAndVersion$2(this));
    /* access modifiers changed from: private */
    public final Context appContext;
    private final CacheRepository cacheRepository;
    /* access modifiers changed from: private */
    public final CrossplatformMetaRetriever crossplatformMetaRetriever;
    private final Lazy crossplatformNameAndVersion$delegate;
    private final /* synthetic */ String deviceName;
    private final /* synthetic */ String os;
    private final /* synthetic */ String platform;
    private final /* synthetic */ String store;
    private final UserAgentRetriever userAgentRetriever;

    public MetaInfoRetriever(Context context, CrossplatformMetaRetriever crossplatformMetaRetriever2, AdaptyUiMetaRetriever adaptyUiMetaRetriever2, UserAgentRetriever userAgentRetriever2, CacheRepository cacheRepository2) {
        String str;
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(crossplatformMetaRetriever2, "crossplatformMetaRetriever");
        Intrinsics.checkNotNullParameter(adaptyUiMetaRetriever2, "adaptyUiMetaRetriever");
        Intrinsics.checkNotNullParameter(userAgentRetriever2, "userAgentRetriever");
        Intrinsics.checkNotNullParameter(cacheRepository2, "cacheRepository");
        this.appContext = context;
        this.crossplatformMetaRetriever = crossplatformMetaRetriever2;
        this.adaptyUiMetaRetriever = adaptyUiMetaRetriever2;
        this.userAgentRetriever = userAgentRetriever2;
        this.cacheRepository = cacheRepository2;
        String str2 = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str2, "MODEL");
        String str3 = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str3, "MANUFACTURER");
        String str4 = StringsKt.startsWith$default(str2, str3, false, 2, (Object) null) ? Build.MODEL : Build.MANUFACTURER + ' ' + Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str4, "if (Build.MODEL.startsWi…FACTURER} ${Build.MODEL}\"");
        if (str4.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char charAt = str4.charAt(0);
            if (Character.isLowerCase(charAt)) {
                Locale locale = Locale.ENGLISH;
                Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
                str = CharsKt.titlecase(charAt, locale);
            } else {
                str = String.valueOf(charAt);
            }
            StringBuilder append = sb.append(str);
            String substring = str4.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            str4 = append.append(substring).toString();
        }
        this.deviceName = str4;
        this.adaptySdkVersion = BuildConfig.VERSION_NAME;
        this.crossplatformNameAndVersion$delegate = LazyKt.lazy(new MetaInfoRetriever$crossplatformNameAndVersion$2(this));
        this.os = Build.VERSION.RELEASE;
        this.platform = AndroidContextProvider.PLATFORM;
        this.store = "play_store";
        this.adaptyUiAndBuilderVersion$delegate = LazyKt.lazy(new MetaInfoRetriever$adaptyUiAndBuilderVersion$2(this));
    }

    public final /* synthetic */ String getInstallationMetaId() {
        return this.cacheRepository.getInstallationMetaId();
    }

    public final /* synthetic */ Pair getAppBuildAndVersion() {
        return (Pair) this.appBuildAndVersion$delegate.getValue();
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getAdaptySdkVersion() {
        return this.adaptySdkVersion;
    }

    public final /* synthetic */ Pair getCrossplatformNameAndVersion() {
        return (Pair) this.crossplatformNameAndVersion$delegate.getValue();
    }

    public final /* synthetic */ Locale getCurrentLocale() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.appContext.getResources().getConfiguration().getLocales().get(0);
        }
        return this.appContext.getResources().getConfiguration().locale;
    }

    public final /* synthetic */ String getCurrentLocaleFormatted() {
        Locale currentLocale = getCurrentLocale();
        if (currentLocale == null) {
            return null;
        }
        CharSequence country = currentLocale.getCountry();
        return country == null || country.length() == 0 ? currentLocale.getLanguage() : currentLocale.getLanguage() + '-' + currentLocale.getCountry();
    }

    public final String getOs() {
        return this.os;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getStore() {
        return this.store;
    }

    public final /* synthetic */ String getUserAgent() {
        return this.userAgentRetriever.getUserAgent();
    }

    public final /* synthetic */ String getAndroidId() {
        return Settings.Secure.getString(this.appContext.getContentResolver(), "android_id");
    }

    public final /* synthetic */ String getTimezone() {
        return TimeZone.getDefault().getID();
    }

    public final /* synthetic */ Pair getAdaptyUiAndBuilderVersion() {
        return (Pair) this.adaptyUiAndBuilderVersion$delegate.getValue();
    }
}
