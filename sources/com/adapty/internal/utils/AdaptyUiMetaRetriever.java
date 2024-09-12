package com.adapty.internal.utils;

import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.adapty.utils.AdaptyLogLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J5\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R!\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/adapty/internal/utils/AdaptyUiMetaRetriever;", "", "()V", "adaptyUiAndBuilderVersion", "Lkotlin/Pair;", "", "getAdaptyUiAndBuilderVersion", "()Lkotlin/Pair;", "buildConfigClass", "Ljava/lang/Class;", "getBuildConfigClass", "()Ljava/lang/Class;", "buildConfigClass$delegate", "Lkotlin/Lazy;", "getDeclaredFieldOrNull", "T", "sourceClass", "name", "obj", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "throwWrongParamError", "", "message", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyUiMetaRetriever.kt */
public final class AdaptyUiMetaRetriever {
    private final Lazy buildConfigClass$delegate = LazyKt.lazy(AdaptyUiMetaRetriever$buildConfigClass$2.INSTANCE);

    private final Class<?> getBuildConfigClass() {
        return (Class) this.buildConfigClass$delegate.getValue();
    }

    public final /* synthetic */ Pair getAdaptyUiAndBuilderVersion() {
        String str = (String) getDeclaredFieldOrNull(getBuildConfigClass(), "VERSION_NAME", getBuildConfigClass());
        if (str != null) {
            String str2 = (String) getDeclaredFieldOrNull(getBuildConfigClass(), "BUILDER_VERSION", getBuildConfigClass());
            if (str2 == null) {
                str2 = "1";
            }
            return TuplesKt.to(str, str2);
        }
        throwWrongParamError("Unable to retrieve the version of Adapty UI. Please ensure that the dependency is added to the project.");
        throw new KotlinNothingValueException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> T getDeclaredFieldOrNull(java.lang.Class<?> r2, java.lang.String r3, java.lang.Object r4) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L_0x0012
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0017 }
            if (r2 == 0) goto L_0x0012
            r3 = 1
            r2.setAccessible(r3)     // Catch:{ Exception -> 0x0017 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0017 }
            goto L_0x0013
        L_0x0012:
            r2 = r0
        L_0x0013:
            if (r2 != 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r0 = r2
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.AdaptyUiMetaRetriever.getDeclaredFieldOrNull(java.lang.Class, java.lang.String, java.lang.Object):java.lang.Object");
    }

    private final Void throwWrongParamError(String str) {
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.ERROR;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, str));
        }
        throw new AdaptyError((Throwable) null, str, AdaptyErrorCode.WRONG_PARAMETER, 1, (DefaultConstructorMarker) null);
    }
}
