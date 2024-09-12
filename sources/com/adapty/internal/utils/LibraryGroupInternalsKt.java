package com.adapty.internal.utils;

import com.adapty.BuildConfig;
import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.adapty.internal.domain.models.BackendProduct;
import com.adapty.models.AdaptyPaywall;
import com.adapty.utils.AdaptyLogLevel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0007\u001a\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0007\"\u001a\u0010\u0000\u001a\u00020\u00018FX\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0017"}, d2 = {"adaptySdkVersion", "", "getAdaptySdkVersion$annotations", "()V", "getAdaptySdkVersion", "()Ljava/lang/String;", "adaptyError", "Lcom/adapty/errors/AdaptyError;", "originalError", "", "message", "adaptyErrorCode", "Lcom/adapty/errors/AdaptyErrorCode;", "getOrderedOriginalProductIds", "", "paywall", "Lcom/adapty/models/AdaptyPaywall;", "log", "", "messageLogLevel", "Lcom/adapty/utils/AdaptyLogLevel;", "msg", "Lkotlin/Function0;", "adapty_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LibraryGroupInternals.kt */
public final class LibraryGroupInternalsKt {
    public static final /* synthetic */ String getAdaptySdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @InternalAdaptyApi
    public static /* synthetic */ void getAdaptySdkVersion$annotations() {
    }

    @InternalAdaptyApi
    public static final /* synthetic */ AdaptyError adaptyError(Throwable th, String str, AdaptyErrorCode adaptyErrorCode) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(adaptyErrorCode, "adaptyErrorCode");
        return new AdaptyError(th, str, adaptyErrorCode);
    }

    @InternalAdaptyApi
    public static final /* synthetic */ void log(AdaptyLogLevel adaptyLogLevel, Function0 function0) {
        Intrinsics.checkNotNullParameter(adaptyLogLevel, "messageLogLevel");
        Intrinsics.checkNotNullParameter(function0, "msg");
        Logger logger = Logger.INSTANCE;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, (String) function0.invoke()));
        }
    }

    @InternalAdaptyApi
    public static final /* synthetic */ List getOrderedOriginalProductIds(AdaptyPaywall adaptyPaywall) {
        Intrinsics.checkNotNullParameter(adaptyPaywall, "paywall");
        Iterable<BackendProduct> products$adapty_release = adaptyPaywall.getProducts$adapty_release();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(products$adapty_release, 10));
        for (BackendProduct id : products$adapty_release) {
            arrayList.add(id.getId());
        }
        return (List) arrayList;
    }
}
