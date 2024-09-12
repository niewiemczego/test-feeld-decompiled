package com.facebook.appevents.iap;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B=\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ$\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0011R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper;", "", "skuDetailsParamsClazz", "Ljava/lang/Class;", "builderClazz", "newBuilderMethod", "Ljava/lang/reflect/Method;", "setTypeMethod", "setSkusListMethod", "buildMethod", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getSkuDetailsParamsClazz", "()Ljava/lang/Class;", "getSkuDetailsParams", "skuType", "", "skuIDs", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InAppPurchaseSkuDetailsWrapper.kt */
public final class InAppPurchaseSkuDetailsWrapper {
    private static final String CLASSNAME_SKU_DETAILS_PARAMS = "com.android.billingclient.api.SkuDetailsParams";
    private static final String CLASSNAME_SKU_DETAILS_PARAMS_BUILDER = "com.android.billingclient.api.SkuDetailsParams$Builder";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String METHOD_BUILD = "build";
    private static final String METHOD_NEW_BUILDER = "newBuilder";
    private static final String METHOD_SET_SKU_LIST = "setSkusList";
    private static final String METHOD_SET_TYPE = "setType";
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static InAppPurchaseSkuDetailsWrapper instance;
    private final Method buildMethod;
    private final Class<?> builderClazz;
    private final Method newBuilderMethod;
    private final Method setSkusListMethod;
    private final Method setTypeMethod;
    private final Class<?> skuDetailsParamsClazz;

    @JvmStatic
    public static final InAppPurchaseSkuDetailsWrapper getOrCreateInstance() {
        Class<InAppPurchaseSkuDetailsWrapper> cls = InAppPurchaseSkuDetailsWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return Companion.getOrCreateInstance();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public InAppPurchaseSkuDetailsWrapper(Class<?> cls, Class<?> cls2, Method method, Method method2, Method method3, Method method4) {
        Intrinsics.checkNotNullParameter(cls, "skuDetailsParamsClazz");
        Intrinsics.checkNotNullParameter(cls2, "builderClazz");
        Intrinsics.checkNotNullParameter(method, "newBuilderMethod");
        Intrinsics.checkNotNullParameter(method2, "setTypeMethod");
        Intrinsics.checkNotNullParameter(method3, "setSkusListMethod");
        Intrinsics.checkNotNullParameter(method4, "buildMethod");
        this.skuDetailsParamsClazz = cls;
        this.builderClazz = cls2;
        this.newBuilderMethod = method;
        this.setTypeMethod = method2;
        this.setSkusListMethod = method3;
        this.buildMethod = method4;
    }

    public static final /* synthetic */ AtomicBoolean access$getInitialized$cp() {
        Class<InAppPurchaseSkuDetailsWrapper> cls = InAppPurchaseSkuDetailsWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return initialized;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ InAppPurchaseSkuDetailsWrapper access$getInstance$cp() {
        Class<InAppPurchaseSkuDetailsWrapper> cls = InAppPurchaseSkuDetailsWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return instance;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void access$setInstance$cp(InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper) {
        Class<InAppPurchaseSkuDetailsWrapper> cls = InAppPurchaseSkuDetailsWrapper.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                instance = inAppPurchaseSkuDetailsWrapper;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final Class<?> getSkuDetailsParamsClazz() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.skuDetailsParamsClazz;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final Object getSkuDetailsParams(String str, List<String> list) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            Object invokeMethod = InAppPurchaseUtils.invokeMethod(this.skuDetailsParamsClazz, this.newBuilderMethod, (Object) null, new Object[0]);
            if (invokeMethod == null) {
                return null;
            }
            InAppPurchaseUtils inAppPurchaseUtils2 = InAppPurchaseUtils.INSTANCE;
            Object invokeMethod2 = InAppPurchaseUtils.invokeMethod(this.builderClazz, this.setTypeMethod, invokeMethod, str);
            if (invokeMethod2 == null) {
                return null;
            }
            InAppPurchaseUtils inAppPurchaseUtils3 = InAppPurchaseUtils.INSTANCE;
            Object invokeMethod3 = InAppPurchaseUtils.invokeMethod(this.builderClazz, this.setSkusListMethod, invokeMethod2, list);
            if (invokeMethod3 == null) {
                return null;
            }
            InAppPurchaseUtils inAppPurchaseUtils4 = InAppPurchaseUtils.INSTANCE;
            return InAppPurchaseUtils.invokeMethod(this.builderClazz, this.buildMethod, invokeMethod3, new Object[0]);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper$Companion;", "", "()V", "CLASSNAME_SKU_DETAILS_PARAMS", "", "CLASSNAME_SKU_DETAILS_PARAMS_BUILDER", "METHOD_BUILD", "METHOD_NEW_BUILDER", "METHOD_SET_SKU_LIST", "METHOD_SET_TYPE", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "instance", "Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper;", "createInstance", "", "getOrCreateInstance", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: InAppPurchaseSkuDetailsWrapper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final InAppPurchaseSkuDetailsWrapper getOrCreateInstance() {
            if (InAppPurchaseSkuDetailsWrapper.access$getInitialized$cp().get()) {
                return InAppPurchaseSkuDetailsWrapper.access$getInstance$cp();
            }
            createInstance();
            InAppPurchaseSkuDetailsWrapper.access$getInitialized$cp().set(true);
            return InAppPurchaseSkuDetailsWrapper.access$getInstance$cp();
        }

        private final void createInstance() {
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            Class<?> cls = InAppPurchaseUtils.getClass(InAppPurchaseSkuDetailsWrapper.CLASSNAME_SKU_DETAILS_PARAMS);
            InAppPurchaseUtils inAppPurchaseUtils2 = InAppPurchaseUtils.INSTANCE;
            Class<?> cls2 = InAppPurchaseUtils.getClass(InAppPurchaseSkuDetailsWrapper.CLASSNAME_SKU_DETAILS_PARAMS_BUILDER);
            if (cls != null && cls2 != null) {
                InAppPurchaseUtils inAppPurchaseUtils3 = InAppPurchaseUtils.INSTANCE;
                Method method = InAppPurchaseUtils.getMethod(cls, InAppPurchaseSkuDetailsWrapper.METHOD_NEW_BUILDER, new Class[0]);
                InAppPurchaseUtils inAppPurchaseUtils4 = InAppPurchaseUtils.INSTANCE;
                Method method2 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseSkuDetailsWrapper.METHOD_SET_TYPE, String.class);
                InAppPurchaseUtils inAppPurchaseUtils5 = InAppPurchaseUtils.INSTANCE;
                Method method3 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseSkuDetailsWrapper.METHOD_SET_SKU_LIST, List.class);
                InAppPurchaseUtils inAppPurchaseUtils6 = InAppPurchaseUtils.INSTANCE;
                Method method4 = InAppPurchaseUtils.getMethod(cls2, "build", new Class[0]);
                if (method != null && method2 != null && method3 != null && method4 != null) {
                    InAppPurchaseSkuDetailsWrapper.access$setInstance$cp(new InAppPurchaseSkuDetailsWrapper(cls, cls2, method, method2, method3, method4));
                }
            }
        }
    }
}
