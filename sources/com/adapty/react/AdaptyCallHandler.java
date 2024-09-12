package com.adapty.react;

import com.adapty.Adapty;
import com.adapty.errors.AdaptyError;
import com.adapty.models.AdaptyProfile;
import com.adapty.models.AdaptyPurchasedInfo;
import com.adapty.react.BridgeError;
import com.adapty.utils.AdaptyResult;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/adapty/react/AdaptyCallHandler;", "", "reactApplicationContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "onActivated", "Lkotlin/Function0;", "", "(Lcom/facebook/react/bridge/ReactApplicationContext;Lkotlin/jvm/functions/Function0;)V", "getOnActivated", "()Lkotlin/jvm/functions/Function0;", "handle", "ctx", "Lcom/adapty/react/AdaptyContext;", "handleActivate", "handleGetPaywall", "handleGetPaywallProducts", "handleGetProfile", "handleIdentify", "handleLogShowOnboarding", "handleLogShowPaywall", "handleLogout", "handleMakePurchase", "handleRestorePurchases", "handleSetFallbackPaywalls", "handleSetLogLevel", "handleSetVariationId", "handleUpdateAttribution", "handleUpdateProfile", "react-native-adapty_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdaptyCallHandler.kt */
public final class AdaptyCallHandler {
    private final Function0<Unit> onActivated;
    private final ReactApplicationContext reactApplicationContext;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AdaptyCallHandler.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MethodName.values().length];
            iArr[MethodName.ACTIVATE.ordinal()] = 1;
            iArr[MethodName.GET_PAYWALL.ordinal()] = 2;
            iArr[MethodName.GET_PAYWALL_PRODUCTS.ordinal()] = 3;
            iArr[MethodName.GET_PROFILE.ordinal()] = 4;
            iArr[MethodName.IDENTIFY.ordinal()] = 5;
            iArr[MethodName.LOGOUT.ordinal()] = 6;
            iArr[MethodName.LOG_SHOW_ONBOARDING.ordinal()] = 7;
            iArr[MethodName.LOG_SHOW_PAYWALL.ordinal()] = 8;
            iArr[MethodName.MAKE_PURCHASE.ordinal()] = 9;
            iArr[MethodName.RESTORE_PURCHASES.ordinal()] = 10;
            iArr[MethodName.SET_FALLBACK_PAYWALLS.ordinal()] = 11;
            iArr[MethodName.SET_LOG_LEVEL.ordinal()] = 12;
            iArr[MethodName.SET_VARIATION_ID.ordinal()] = 13;
            iArr[MethodName.UPDATE_ATTRIBUTION.ordinal()] = 14;
            iArr[MethodName.UPDATE_PROFILE.ordinal()] = 15;
            iArr[MethodName.NOT_IMPLEMENTED.ordinal()] = 16;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AdaptyCallHandler(ReactApplicationContext reactApplicationContext2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(reactApplicationContext2, "reactApplicationContext");
        Intrinsics.checkNotNullParameter(function0, "onActivated");
        this.reactApplicationContext = reactApplicationContext2;
        this.onActivated = function0;
    }

    public final Function0<Unit> getOnActivated() {
        return this.onActivated;
    }

    public final void handle(AdaptyContext adaptyContext) {
        Intrinsics.checkNotNullParameter(adaptyContext, "ctx");
        try {
            switch (WhenMappings.$EnumSwitchMapping$0[adaptyContext.getMethodName().ordinal()]) {
                case 1:
                    handleActivate(adaptyContext);
                    return;
                case 2:
                    handleGetPaywall(adaptyContext);
                    return;
                case 3:
                    handleGetPaywallProducts(adaptyContext);
                    return;
                case 4:
                    handleGetProfile(adaptyContext);
                    return;
                case 5:
                    handleIdentify(adaptyContext);
                    return;
                case 6:
                    handleLogout(adaptyContext);
                    return;
                case 7:
                    handleLogShowOnboarding(adaptyContext);
                    return;
                case 8:
                    handleLogShowPaywall(adaptyContext);
                    return;
                case 9:
                    handleMakePurchase(adaptyContext);
                    return;
                case 10:
                    handleRestorePurchases(adaptyContext);
                    return;
                case 11:
                    handleSetFallbackPaywalls(adaptyContext);
                    return;
                case 12:
                    handleSetLogLevel(adaptyContext);
                    return;
                case 13:
                    handleSetVariationId(adaptyContext);
                    return;
                case 14:
                    handleUpdateAttribution(adaptyContext);
                    return;
                case 15:
                    handleUpdateProfile(adaptyContext);
                    return;
                case 16:
                    throw BridgeError.MethodNotImplemented.INSTANCE;
                default:
                    return;
            }
        } catch (Error e) {
            adaptyContext.bridgeError(e);
        }
    }

    /* JADX WARNING: type inference failed for: r1v15, types: [java.lang.String] */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0070, code lost:
        if ((r0 instanceof java.lang.String) == false) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0113, code lost:
        if ((r0 instanceof java.lang.String) == false) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01a0, code lost:
        if ((r0 instanceof java.lang.String) == false) goto L_0x0161;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x026e  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleActivate(com.adapty.react.AdaptyContext r12) throws com.adapty.react.BridgeError.TypeMismatch {
        /*
            r11 = this;
            boolean r0 = com.adapty.react.AdaptyCallHandlerKt.getMEMO_ACTIVATE_ARGS()
            if (r0 == 0) goto L_0x000a
            r12.resovle()
            return
        L_0x000a:
            r0 = 1
            com.adapty.react.AdaptyCallHandlerKt.setMEMO_ACTIVATE_ARGS(r0)
            com.adapty.react.ParamMap r0 = r12.getParams()
            com.adapty.react.ParamKey r1 = com.adapty.react.ParamKey.SDK_KEY
            com.facebook.react.bridge.ReadableMap r2 = r0.getDict()
            java.lang.String r3 = r1.getValue()
            boolean r2 = r2.hasKey(r3)
            if (r2 == 0) goto L_0x027d
            java.lang.String r2 = r1.getValue()
            com.facebook.react.bridge.ReadableMap r3 = r0.getDict()
            boolean r3 = r3.hasKey(r2)
            r4 = 0
            if (r3 != 0) goto L_0x0034
            r7 = r4
            goto L_0x00aa
        L_0x0034:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            java.lang.Class r5 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x005a
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            boolean r0 = r0.getBoolean(r2)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x0057
            r0 = r4
        L_0x0057:
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x00a9
        L_0x005a:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0074
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            java.lang.String r0 = r0.getString(r2)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x00a9
        L_0x0072:
            r0 = r4
            goto L_0x00a9
        L_0x0074:
            java.lang.Class r5 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x008f
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            int r0 = r0.getInt(r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x00a9
        L_0x008f:
            java.lang.Class r5 = java.lang.Double.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x0072
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            double r2 = r0.getDouble(r2)
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            java.lang.String r0 = (java.lang.String) r0
        L_0x00a9:
            r7 = r0
        L_0x00aa:
            if (r7 != 0) goto L_0x00c0
            com.adapty.react.BridgeError$TypeMismatch r12 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x00bc
            java.lang.String r0 = "UnknownType"
        L_0x00bc:
            r12.<init>(r1, r0)
            throw r12
        L_0x00c0:
            com.adapty.react.ParamMap r0 = r12.getParams()
            com.adapty.react.ParamKey r1 = com.adapty.react.ParamKey.USER_ID
            java.lang.String r1 = r1.getValue()
            com.facebook.react.bridge.ReadableMap r2 = r0.getDict()
            boolean r2 = r2.hasKey(r1)
            if (r2 != 0) goto L_0x00d7
            r9 = r4
            goto L_0x014d
        L_0x00d7:
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            java.lang.Class r3 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x00fd
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            boolean r0 = r0.getBoolean(r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 != 0) goto L_0x00fa
            r0 = r4
        L_0x00fa:
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x014c
        L_0x00fd:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0117
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            java.lang.String r0 = r0.getString(r1)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 != 0) goto L_0x014c
        L_0x0115:
            r0 = r4
            goto L_0x014c
        L_0x0117:
            java.lang.Class r3 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0132
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            int r0 = r0.getInt(r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x014c
        L_0x0132:
            java.lang.Class r3 = java.lang.Double.TYPE
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0115
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            double r0 = r0.getDouble(r1)
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            java.lang.String r0 = (java.lang.String) r0
        L_0x014c:
            r9 = r0
        L_0x014d:
            com.adapty.react.ParamMap r0 = r12.getParams()
            com.adapty.react.ParamKey r1 = com.adapty.react.ParamKey.LOG_LEVEL
            java.lang.String r1 = r1.getValue()
            com.facebook.react.bridge.ReadableMap r2 = r0.getDict()
            boolean r2 = r2.hasKey(r1)
            if (r2 != 0) goto L_0x0164
        L_0x0161:
            r0 = r4
            goto L_0x01d8
        L_0x0164:
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            java.lang.Class r3 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x018a
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            boolean r0 = r0.getBoolean(r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 != 0) goto L_0x0187
            r0 = r4
        L_0x0187:
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x01d8
        L_0x018a:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x01a3
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            java.lang.String r0 = r0.getString(r1)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 != 0) goto L_0x01d8
            goto L_0x0161
        L_0x01a3:
            java.lang.Class r3 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x01be
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            int r0 = r0.getInt(r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x01d8
        L_0x01be:
            java.lang.Class r3 = java.lang.Double.TYPE
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0161
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            double r0 = r0.getDouble(r1)
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            java.lang.String r0 = (java.lang.String) r0
        L_0x01d8:
            com.adapty.react.ParamMap r1 = r12.getParams()
            com.adapty.react.ParamKey r2 = com.adapty.react.ParamKey.OBSERVER_MODE
            java.lang.String r2 = r2.getValue()
            com.facebook.react.bridge.ReadableMap r3 = r1.getDict()
            boolean r3 = r3.hasKey(r2)
            if (r3 != 0) goto L_0x01ef
        L_0x01ec:
            r8 = r4
            goto L_0x0262
        L_0x01ef:
            java.lang.Class<java.lang.Boolean> r3 = java.lang.Boolean.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            java.lang.Class r5 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x020f
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            boolean r1 = r1.getBoolean(r2)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
        L_0x020d:
            r4 = r1
            goto L_0x01ec
        L_0x020f:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x022c
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            java.lang.String r1 = r1.getString(r2)
            boolean r2 = r1 instanceof java.lang.Boolean
            if (r2 != 0) goto L_0x0228
            goto L_0x0229
        L_0x0228:
            r4 = r1
        L_0x0229:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            goto L_0x01ec
        L_0x022c:
            java.lang.Class r5 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0247
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            int r1 = r1.getInt(r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            goto L_0x020d
        L_0x0247:
            java.lang.Class r5 = java.lang.Double.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x01ec
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            double r1 = r1.getDouble(r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            goto L_0x020d
        L_0x0262:
            com.adapty.internal.crossplatform.CrossplatformHelper$Companion r1 = com.adapty.internal.crossplatform.CrossplatformHelper.Companion
            com.adapty.internal.crossplatform.CrossplatformHelper r1 = r1.getShared()
            com.adapty.utils.AdaptyLogLevel r0 = r1.toLogLevel(r0)
            if (r0 == 0) goto L_0x0271
            com.adapty.Adapty.setLogLevel(r0)
        L_0x0271:
            com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda9 r0 = new com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda9
            r5 = r0
            r6 = r11
            r10 = r12
            r5.<init>(r6, r7, r8, r9, r10)
            com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r0)
            return
        L_0x027d:
            com.adapty.react.BridgeError$MissingRequiredArgument r12 = new com.adapty.react.BridgeError$MissingRequiredArgument
            r12.<init>(r1)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.react.AdaptyCallHandler.handleActivate(com.adapty.react.AdaptyContext):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: handleActivate$lambda-1  reason: not valid java name */
    public static final void m107handleActivate$lambda1(AdaptyCallHandler adaptyCallHandler, String str, Boolean bool, String str2, AdaptyContext adaptyContext) {
        Intrinsics.checkNotNullParameter(adaptyCallHandler, "this$0");
        Intrinsics.checkNotNullParameter(str, "$apiKey");
        Intrinsics.checkNotNullParameter(adaptyContext, "$ctx");
        Adapty.activate(adaptyCallHandler.reactApplicationContext, str, bool != null ? bool.booleanValue() : false, str2);
        adaptyCallHandler.onActivated.invoke();
        adaptyContext.resovle();
    }

    /* JADX WARNING: type inference failed for: r3v20, types: [java.lang.Boolean] */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0056, code lost:
        if ((r1 instanceof java.lang.String) == false) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ef, code lost:
        if ((r2 instanceof java.lang.String) == false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01b3, code lost:
        if ((r3 instanceof java.lang.String) == false) goto L_0x01ee;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x013f A[SYNTHETIC, Splitter:B:47:0x013f] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0261  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleUpdateAttribution(com.adapty.react.AdaptyContext r11) throws com.adapty.react.BridgeError.TypeMismatch {
        /*
            r10 = this;
            java.lang.String r0 = "JSON-encoded "
            com.adapty.react.ParamMap r1 = r11.getParams()
            com.adapty.react.ParamKey r2 = com.adapty.react.ParamKey.NETWORK_USER_ID
            java.lang.String r2 = r2.getValue()
            com.facebook.react.bridge.ReadableMap r3 = r1.getDict()
            boolean r3 = r3.hasKey(r2)
            r4 = 0
            if (r3 != 0) goto L_0x001a
        L_0x0017:
            r1 = r4
            goto L_0x008e
        L_0x001a:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            java.lang.Class r5 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0040
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            boolean r1 = r1.getBoolean(r2)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 != 0) goto L_0x003d
            r1 = r4
        L_0x003d:
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x008e
        L_0x0040:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0059
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            java.lang.String r1 = r1.getString(r2)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 != 0) goto L_0x008e
            goto L_0x0017
        L_0x0059:
            java.lang.Class r5 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0074
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            int r1 = r1.getInt(r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x008e
        L_0x0074:
            java.lang.Class r5 = java.lang.Double.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x0017
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            double r1 = r1.getDouble(r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            java.lang.String r1 = (java.lang.String) r1
        L_0x008e:
            com.adapty.react.ParamMap r2 = r11.getParams()
            com.adapty.react.ParamKey r3 = com.adapty.react.ParamKey.ATTRIBUTION
            com.facebook.react.bridge.ReadableMap r5 = r2.getDict()
            java.lang.String r6 = r3.getValue()
            boolean r5 = r5.hasKey(r6)
            if (r5 == 0) goto L_0x0261
            java.lang.String r5 = r3.getValue()
            com.facebook.react.bridge.ReadableMap r6 = r2.getDict()
            boolean r6 = r6.hasKey(r5)
            if (r6 != 0) goto L_0x00b3
        L_0x00b0:
            r2 = r4
            goto L_0x0127
        L_0x00b3:
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            java.lang.Class r7 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x00d9
            com.facebook.react.bridge.ReadableMap r2 = r2.getDict()
            boolean r2 = r2.getBoolean(r5)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            boolean r5 = r2 instanceof java.lang.String
            if (r5 != 0) goto L_0x00d6
            r2 = r4
        L_0x00d6:
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x0127
        L_0x00d9:
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x00f2
            com.facebook.react.bridge.ReadableMap r2 = r2.getDict()
            java.lang.String r2 = r2.getString(r5)
            boolean r5 = r2 instanceof java.lang.String
            if (r5 != 0) goto L_0x0127
            goto L_0x00b0
        L_0x00f2:
            java.lang.Class r7 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x010d
            com.facebook.react.bridge.ReadableMap r2 = r2.getDict()
            int r2 = r2.getInt(r5)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x0127
        L_0x010d:
            java.lang.Class r7 = java.lang.Double.TYPE
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x00b0
            com.facebook.react.bridge.ReadableMap r2 = r2.getDict()
            double r5 = r2.getDouble(r5)
            java.lang.Double r2 = java.lang.Double.valueOf(r5)
            java.lang.String r2 = (java.lang.String) r2
        L_0x0127:
            java.lang.String r5 = "UnknownType"
            if (r2 != 0) goto L_0x013f
            com.adapty.react.BridgeError$TypeMismatch r11 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x013a
            goto L_0x013b
        L_0x013a:
            r5 = r0
        L_0x013b:
            r11.<init>(r3, r5)
            throw r11
        L_0x013f:
            com.adapty.internal.crossplatform.CrossplatformHelper$Companion r6 = com.adapty.internal.crossplatform.CrossplatformHelper.Companion     // Catch:{ Error -> 0x0240 }
            com.adapty.internal.crossplatform.CrossplatformHelper r6 = r6.getShared()     // Catch:{ Error -> 0x0240 }
            java.lang.Class<java.util.Map> r7 = java.util.Map.class
            java.lang.Object r2 = r6.fromJson(r2, r7)     // Catch:{ Error -> 0x0240 }
            java.lang.String r6 = "CrossplatformHelper.shar…n(jsonStr, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)     // Catch:{ Error -> 0x0240 }
            java.util.Map r2 = (java.util.Map) r2
            com.adapty.react.ParamMap r3 = r11.getParams()
            com.adapty.react.ParamKey r6 = com.adapty.react.ParamKey.SOURCE
            com.facebook.react.bridge.ReadableMap r7 = r3.getDict()
            java.lang.String r8 = r6.getValue()
            boolean r7 = r7.hasKey(r8)
            if (r7 == 0) goto L_0x023a
            java.lang.String r7 = r6.getValue()
            com.facebook.react.bridge.ReadableMap r8 = r3.getDict()
            boolean r8 = r8.hasKey(r7)
            if (r8 != 0) goto L_0x0176
            goto L_0x01ee
        L_0x0176:
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            kotlin.reflect.KClass r8 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r8)
            java.lang.Class r9 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r9 == 0) goto L_0x019d
            com.facebook.react.bridge.ReadableMap r3 = r3.getDict()
            boolean r3 = r3.getBoolean(r7)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            boolean r7 = r3 instanceof java.lang.String
            if (r7 != 0) goto L_0x0199
            goto L_0x019a
        L_0x0199:
            r4 = r3
        L_0x019a:
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01ee
        L_0x019d:
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r9 == 0) goto L_0x01b8
            com.facebook.react.bridge.ReadableMap r3 = r3.getDict()
            java.lang.String r3 = r3.getString(r7)
            boolean r7 = r3 instanceof java.lang.String
            if (r7 != 0) goto L_0x01b6
            goto L_0x01ee
        L_0x01b6:
            r4 = r3
            goto L_0x01ee
        L_0x01b8:
            java.lang.Class r9 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r9 == 0) goto L_0x01d3
            com.facebook.react.bridge.ReadableMap r3 = r3.getDict()
            int r3 = r3.getInt(r7)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x01b6
        L_0x01d3:
            java.lang.Class r9 = java.lang.Double.TYPE
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x01ee
            com.facebook.react.bridge.ReadableMap r3 = r3.getDict()
            double r3 = r3.getDouble(r7)
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x01b6
        L_0x01ee:
            if (r4 != 0) goto L_0x0204
            com.adapty.react.BridgeError$TypeMismatch r11 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x01ff
            goto L_0x0200
        L_0x01ff:
            r5 = r0
        L_0x0200:
            r11.<init>(r6, r5)
            throw r11
        L_0x0204:
            com.adapty.internal.crossplatform.CrossplatformHelper$Companion r3 = com.adapty.internal.crossplatform.CrossplatformHelper.Companion
            com.adapty.internal.crossplatform.CrossplatformHelper r3 = r3.getShared()
            com.adapty.models.AdaptyAttributionSource r3 = r3.toAttributionSourceType(r4)
            if (r3 == 0) goto L_0x0219
            com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda12 r0 = new com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda12
            r0.<init>(r11)
            com.adapty.Adapty.updateAttribution(r2, r3, r1, r0)
            return
        L_0x0219:
            com.adapty.react.BridgeError$TypeMismatch r11 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.Class<com.adapty.models.AdaptyAttributionSource> r1 = com.adapty.models.AdaptyAttributionSource.class
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            java.lang.String r1 = r1.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r11.<init>(r6, r0)
            throw r11
        L_0x023a:
            com.adapty.react.BridgeError$MissingRequiredArgument r11 = new com.adapty.react.BridgeError$MissingRequiredArgument
            r11.<init>(r6)
            throw r11
        L_0x0240:
            com.adapty.react.BridgeError$TypeMismatch r11 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.Class<java.util.Map> r1 = java.util.Map.class
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            java.lang.String r1 = r1.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r11.<init>(r3, r0)
            throw r11
        L_0x0261:
            com.adapty.react.BridgeError$MissingRequiredArgument r11 = new com.adapty.react.BridgeError$MissingRequiredArgument
            r11.<init>(r3)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.react.AdaptyCallHandler.handleUpdateAttribution(com.adapty.react.AdaptyContext):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: handleUpdateAttribution$lambda-3  reason: not valid java name */
    public static final void m119handleUpdateAttribution$lambda3(AdaptyContext adaptyContext, AdaptyError adaptyError) {
        Intrinsics.checkNotNullParameter(adaptyContext, "$ctx");
        adaptyContext.okOrForwardError(adaptyError);
    }

    /* JADX WARNING: type inference failed for: r3v22, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v25, types: [java.lang.Boolean] */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0062, code lost:
        if ((r0 instanceof java.lang.String) == false) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0105, code lost:
        if ((r1 instanceof java.lang.String) == false) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x019e, code lost:
        if ((r3 instanceof java.lang.String) == false) goto L_0x015f;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01ec A[SYNTHETIC, Splitter:B:74:0x01ec] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleGetPaywall(com.adapty.react.AdaptyContext r10) throws com.adapty.react.BridgeError.TypeMismatch {
        /*
            r9 = this;
            com.adapty.react.ParamMap r0 = r10.getParams()
            com.adapty.react.ParamKey r1 = com.adapty.react.ParamKey.PLACEMENT_ID
            com.facebook.react.bridge.ReadableMap r2 = r0.getDict()
            java.lang.String r3 = r1.getValue()
            boolean r2 = r2.hasKey(r3)
            if (r2 == 0) goto L_0x02ca
            java.lang.String r2 = r1.getValue()
            com.facebook.react.bridge.ReadableMap r3 = r0.getDict()
            boolean r3 = r3.hasKey(r2)
            r4 = 0
            if (r3 != 0) goto L_0x0026
        L_0x0023:
            r0 = r4
            goto L_0x009a
        L_0x0026:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            java.lang.Class r5 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x004c
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            boolean r0 = r0.getBoolean(r2)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x0049
            r0 = r4
        L_0x0049:
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x009a
        L_0x004c:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0065
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            java.lang.String r0 = r0.getString(r2)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x009a
            goto L_0x0023
        L_0x0065:
            java.lang.Class r5 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0080
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            int r0 = r0.getInt(r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x009a
        L_0x0080:
            java.lang.Class r5 = java.lang.Double.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x0023
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            double r2 = r0.getDouble(r2)
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            java.lang.String r0 = (java.lang.String) r0
        L_0x009a:
            java.lang.String r2 = "UnknownType"
            if (r0 != 0) goto L_0x00b2
            com.adapty.react.BridgeError$TypeMismatch r10 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r2 = r0
        L_0x00ae:
            r10.<init>(r1, r2)
            throw r10
        L_0x00b2:
            com.adapty.react.ParamMap r1 = r10.getParams()
            com.adapty.react.ParamKey r3 = com.adapty.react.ParamKey.LOCALE
            java.lang.String r3 = r3.getValue()
            com.facebook.react.bridge.ReadableMap r5 = r1.getDict()
            boolean r5 = r5.hasKey(r3)
            if (r5 != 0) goto L_0x00c9
        L_0x00c6:
            r1 = r4
            goto L_0x013d
        L_0x00c9:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            java.lang.Class r6 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x00ef
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            boolean r1 = r1.getBoolean(r3)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r3 = r1 instanceof java.lang.String
            if (r3 != 0) goto L_0x00ec
            r1 = r4
        L_0x00ec:
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x013d
        L_0x00ef:
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x0108
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            java.lang.String r1 = r1.getString(r3)
            boolean r3 = r1 instanceof java.lang.String
            if (r3 != 0) goto L_0x013d
            goto L_0x00c6
        L_0x0108:
            java.lang.Class r6 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x0123
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            int r1 = r1.getInt(r3)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x013d
        L_0x0123:
            java.lang.Class r6 = java.lang.Double.TYPE
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x00c6
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            double r5 = r1.getDouble(r3)
            java.lang.Double r1 = java.lang.Double.valueOf(r5)
            java.lang.String r1 = (java.lang.String) r1
        L_0x013d:
            com.adapty.react.ParamMap r3 = r10.getParams()
            com.adapty.react.ParamKey r5 = com.adapty.react.ParamKey.FETCH_POLICY
            com.facebook.react.bridge.ReadableMap r6 = r3.getDict()
            java.lang.String r7 = r5.getValue()
            boolean r6 = r6.hasKey(r7)
            if (r6 == 0) goto L_0x02c4
            java.lang.String r6 = r5.getValue()
            com.facebook.react.bridge.ReadableMap r7 = r3.getDict()
            boolean r7 = r7.hasKey(r6)
            if (r7 != 0) goto L_0x0162
        L_0x015f:
            r3 = r4
            goto L_0x01d6
        L_0x0162:
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            java.lang.Class r8 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r8 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r8)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r8 == 0) goto L_0x0188
            com.facebook.react.bridge.ReadableMap r3 = r3.getDict()
            boolean r3 = r3.getBoolean(r6)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            boolean r6 = r3 instanceof java.lang.String
            if (r6 != 0) goto L_0x0185
            r3 = r4
        L_0x0185:
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x01d6
        L_0x0188:
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            kotlin.reflect.KClass r8 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r8)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r8 == 0) goto L_0x01a1
            com.facebook.react.bridge.ReadableMap r3 = r3.getDict()
            java.lang.String r3 = r3.getString(r6)
            boolean r6 = r3 instanceof java.lang.String
            if (r6 != 0) goto L_0x01d6
            goto L_0x015f
        L_0x01a1:
            java.lang.Class r8 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r8 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r8)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r8 == 0) goto L_0x01bc
            com.facebook.react.bridge.ReadableMap r3 = r3.getDict()
            int r3 = r3.getInt(r6)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x01d6
        L_0x01bc:
            java.lang.Class r8 = java.lang.Double.TYPE
            kotlin.reflect.KClass r8 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r8)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x015f
            com.facebook.react.bridge.ReadableMap r3 = r3.getDict()
            double r6 = r3.getDouble(r6)
            java.lang.Double r3 = java.lang.Double.valueOf(r6)
            java.lang.String r3 = (java.lang.String) r3
        L_0x01d6:
            if (r3 != 0) goto L_0x01ec
            com.adapty.react.BridgeError$TypeMismatch r10 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x01e7
            goto L_0x01e8
        L_0x01e7:
            r2 = r0
        L_0x01e8:
            r10.<init>(r5, r2)
            throw r10
        L_0x01ec:
            com.adapty.internal.crossplatform.CrossplatformHelper$Companion r2 = com.adapty.internal.crossplatform.CrossplatformHelper.Companion     // Catch:{ Error -> 0x02a1 }
            com.adapty.internal.crossplatform.CrossplatformHelper r2 = r2.getShared()     // Catch:{ Error -> 0x02a1 }
            java.lang.Class<com.adapty.models.AdaptyPaywall$FetchPolicy> r6 = com.adapty.models.AdaptyPaywall.FetchPolicy.class
            java.lang.Object r2 = r2.fromJson(r3, r6)     // Catch:{ Error -> 0x02a1 }
            java.lang.String r3 = "CrossplatformHelper.shar…n(jsonStr, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ Error -> 0x02a1 }
            com.adapty.models.AdaptyPaywall$FetchPolicy r2 = (com.adapty.models.AdaptyPaywall.FetchPolicy) r2
            com.adapty.react.ParamMap r3 = r10.getParams()
            com.adapty.react.ParamKey r5 = com.adapty.react.ParamKey.LOAD_TIMEOUT
            java.lang.String r5 = r5.getValue()
            com.facebook.react.bridge.ReadableMap r6 = r3.getDict()
            boolean r6 = r6.hasKey(r5)
            if (r6 != 0) goto L_0x0215
            goto L_0x028e
        L_0x0215:
            java.lang.Class<java.lang.Double> r6 = java.lang.Double.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            java.lang.Class r7 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x023c
            com.facebook.react.bridge.ReadableMap r3 = r3.getDict()
            boolean r3 = r3.getBoolean(r5)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            boolean r5 = r3 instanceof java.lang.Double
            if (r5 != 0) goto L_0x0238
            goto L_0x0239
        L_0x0238:
            r4 = r3
        L_0x0239:
            java.lang.Double r4 = (java.lang.Double) r4
            goto L_0x028e
        L_0x023c:
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0259
            com.facebook.react.bridge.ReadableMap r3 = r3.getDict()
            java.lang.String r3 = r3.getString(r5)
            boolean r5 = r3 instanceof java.lang.Double
            if (r5 != 0) goto L_0x0255
            goto L_0x0256
        L_0x0255:
            r4 = r3
        L_0x0256:
            java.lang.Double r4 = (java.lang.Double) r4
            goto L_0x028e
        L_0x0259:
            java.lang.Class r7 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0275
            com.facebook.react.bridge.ReadableMap r3 = r3.getDict()
            int r3 = r3.getInt(r5)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Double r3 = (java.lang.Double) r3
        L_0x0273:
            r4 = r3
            goto L_0x028e
        L_0x0275:
            java.lang.Class r7 = java.lang.Double.TYPE
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x028e
            com.facebook.react.bridge.ReadableMap r3 = r3.getDict()
            double r3 = r3.getDouble(r5)
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            goto L_0x0273
        L_0x028e:
            if (r4 == 0) goto L_0x0296
            double r3 = r4.doubleValue()
            int r3 = (int) r3
            goto L_0x0298
        L_0x0296:
            r3 = 5000(0x1388, float:7.006E-42)
        L_0x0298:
            com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda4 r4 = new com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda4
            r4.<init>(r10)
            com.adapty.Adapty.getPaywall(r0, r1, r2, r3, r4)
            return
        L_0x02a1:
            com.adapty.react.BridgeError$TypeMismatch r10 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "JSON-encoded "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.Class<com.adapty.models.AdaptyPaywall$FetchPolicy> r1 = com.adapty.models.AdaptyPaywall.FetchPolicy.class
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            java.lang.String r1 = r1.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.<init>(r5, r0)
            throw r10
        L_0x02c4:
            com.adapty.react.BridgeError$MissingRequiredArgument r10 = new com.adapty.react.BridgeError$MissingRequiredArgument
            r10.<init>(r5)
            throw r10
        L_0x02ca:
            com.adapty.react.BridgeError$MissingRequiredArgument r10 = new com.adapty.react.BridgeError$MissingRequiredArgument
            r10.<init>(r1)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.react.AdaptyCallHandler.handleGetPaywall(com.adapty.react.AdaptyContext):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r0 = r0.getClass();
     */
    /* renamed from: handleGetPaywall$lambda-4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m108handleGetPaywall$lambda4(com.adapty.react.AdaptyContext r3, com.adapty.utils.AdaptyResult r4) {
        /*
            java.lang.String r0 = "$ctx"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r4 instanceof com.adapty.utils.AdaptyResult.Success
            if (r0 == 0) goto L_0x0069
            com.adapty.utils.AdaptyResult$Success r4 = (com.adapty.utils.AdaptyResult.Success) r4
            java.lang.Object r4 = r4.getValue()
            boolean r0 = r4 instanceof java.util.List
            java.lang.String r1 = "UnknownType"
            if (r0 == 0) goto L_0x0052
            r0 = r4
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            if (r0 == 0) goto L_0x002e
            java.lang.Class r0 = r0.getClass()
            if (r0 == 0) goto L_0x002e
            java.lang.String r0 = r0.getSimpleName()
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            if (r0 != 0) goto L_0x0032
            goto L_0x0038
        L_0x0032:
            java.lang.String r1 = "data.firstOrNull()?.java…mpleName ?: \"UnknownType\""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r1 = r0
        L_0x0038:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Array<"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = 62
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r0.toString()
            goto L_0x0060
        L_0x0052:
            java.lang.Class<com.adapty.models.AdaptyPaywall> r0 = com.adapty.models.AdaptyPaywall.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r1 = r0
        L_0x0060:
            com.adapty.react.AdaptyBridgeResult r0 = new com.adapty.react.AdaptyBridgeResult
            r0.<init>(r4, r1)
            r3.resolve(r0)
            goto L_0x0076
        L_0x0069:
            boolean r0 = r4 instanceof com.adapty.utils.AdaptyResult.Error
            if (r0 == 0) goto L_0x0076
            com.adapty.utils.AdaptyResult$Error r4 = (com.adapty.utils.AdaptyResult.Error) r4
            com.adapty.errors.AdaptyError r4 = r4.getError()
            r3.forwardError(r4)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.react.AdaptyCallHandler.m108handleGetPaywall$lambda4(com.adapty.react.AdaptyContext, com.adapty.utils.AdaptyResult):void");
    }

    /* JADX WARNING: type inference failed for: r0v26, types: [java.lang.Boolean] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0062, code lost:
        if ((r0 instanceof java.lang.String) == false) goto L_0x009d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleGetPaywallProducts(com.adapty.react.AdaptyContext r7) throws com.adapty.react.BridgeError.TypeMismatch {
        /*
            r6 = this;
            com.adapty.react.ParamMap r0 = r7.getParams()
            com.adapty.react.ParamKey r1 = com.adapty.react.ParamKey.PAYWALL
            com.facebook.react.bridge.ReadableMap r2 = r0.getDict()
            java.lang.String r3 = r1.getValue()
            boolean r2 = r2.hasKey(r3)
            if (r2 == 0) goto L_0x00f2
            java.lang.String r2 = r1.getValue()
            com.facebook.react.bridge.ReadableMap r3 = r0.getDict()
            boolean r3 = r3.hasKey(r2)
            r4 = 0
            if (r3 != 0) goto L_0x0025
            goto L_0x009d
        L_0x0025:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            java.lang.Class r5 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x004c
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            boolean r0 = r0.getBoolean(r2)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r4 = r0
        L_0x0049:
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x009d
        L_0x004c:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0067
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            java.lang.String r0 = r0.getString(r2)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x0065
            goto L_0x009d
        L_0x0065:
            r4 = r0
            goto L_0x009d
        L_0x0067:
            java.lang.Class r5 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0082
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            int r0 = r0.getInt(r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0065
        L_0x0082:
            java.lang.Class r5 = java.lang.Double.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x009d
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            double r2 = r0.getDouble(r2)
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0065
        L_0x009d:
            if (r4 != 0) goto L_0x00b3
            com.adapty.react.BridgeError$TypeMismatch r7 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x00af
            java.lang.String r0 = "UnknownType"
        L_0x00af:
            r7.<init>(r1, r0)
            throw r7
        L_0x00b3:
            com.adapty.internal.crossplatform.CrossplatformHelper$Companion r0 = com.adapty.internal.crossplatform.CrossplatformHelper.Companion     // Catch:{ Error -> 0x00cf }
            com.adapty.internal.crossplatform.CrossplatformHelper r0 = r0.getShared()     // Catch:{ Error -> 0x00cf }
            java.lang.Class<com.adapty.models.AdaptyPaywall> r2 = com.adapty.models.AdaptyPaywall.class
            java.lang.Object r0 = r0.fromJson(r4, r2)     // Catch:{ Error -> 0x00cf }
            java.lang.String r2 = "CrossplatformHelper.shar…n(jsonStr, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ Error -> 0x00cf }
            com.adapty.models.AdaptyPaywall r0 = (com.adapty.models.AdaptyPaywall) r0
            com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda10 r1 = new com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda10
            r1.<init>(r7)
            com.adapty.Adapty.getPaywallProducts(r0, r1)
            return
        L_0x00cf:
            com.adapty.react.BridgeError$TypeMismatch r7 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "JSON-encoded "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.Class<com.adapty.models.AdaptyPaywall> r2 = com.adapty.models.AdaptyPaywall.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            java.lang.String r2 = r2.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            r7.<init>(r1, r0)
            throw r7
        L_0x00f2:
            com.adapty.react.BridgeError$MissingRequiredArgument r7 = new com.adapty.react.BridgeError$MissingRequiredArgument
            r7.<init>(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.react.AdaptyCallHandler.handleGetPaywallProducts(com.adapty.react.AdaptyContext):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r0 = r0.getClass();
     */
    /* renamed from: handleGetPaywallProducts$lambda-5  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m109handleGetPaywallProducts$lambda5(com.adapty.react.AdaptyContext r3, com.adapty.utils.AdaptyResult r4) {
        /*
            java.lang.String r0 = "$ctx"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r4 instanceof com.adapty.utils.AdaptyResult.Success
            if (r0 == 0) goto L_0x0069
            com.adapty.utils.AdaptyResult$Success r4 = (com.adapty.utils.AdaptyResult.Success) r4
            java.lang.Object r4 = r4.getValue()
            boolean r0 = r4 instanceof java.util.List
            java.lang.String r1 = "UnknownType"
            if (r0 == 0) goto L_0x0052
            r0 = r4
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            if (r0 == 0) goto L_0x002e
            java.lang.Class r0 = r0.getClass()
            if (r0 == 0) goto L_0x002e
            java.lang.String r0 = r0.getSimpleName()
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            if (r0 != 0) goto L_0x0032
            goto L_0x0038
        L_0x0032:
            java.lang.String r1 = "data.firstOrNull()?.java…mpleName ?: \"UnknownType\""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r1 = r0
        L_0x0038:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Array<"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = 62
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r0.toString()
            goto L_0x0060
        L_0x0052:
            java.lang.Class<java.util.List> r0 = java.util.List.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r1 = r0
        L_0x0060:
            com.adapty.react.AdaptyBridgeResult r0 = new com.adapty.react.AdaptyBridgeResult
            r0.<init>(r4, r1)
            r3.resolve(r0)
            goto L_0x0076
        L_0x0069:
            boolean r0 = r4 instanceof com.adapty.utils.AdaptyResult.Error
            if (r0 == 0) goto L_0x0076
            com.adapty.utils.AdaptyResult$Error r4 = (com.adapty.utils.AdaptyResult.Error) r4
            com.adapty.errors.AdaptyError r4 = r4.getError()
            r3.forwardError(r4)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.react.AdaptyCallHandler.m109handleGetPaywallProducts$lambda5(com.adapty.react.AdaptyContext, com.adapty.utils.AdaptyResult):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0062, code lost:
        if ((r0 instanceof java.lang.String) == false) goto L_0x0023;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b0 A[SYNTHETIC, Splitter:B:27:0x00b0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleLogShowOnboarding(com.adapty.react.AdaptyContext r7) throws com.adapty.react.BridgeError.TypeMismatch {
        /*
            r6 = this;
            com.adapty.react.ParamMap r0 = r7.getParams()
            com.adapty.react.ParamKey r1 = com.adapty.react.ParamKey.ONBOARDING_PARAMS
            com.facebook.react.bridge.ReadableMap r2 = r0.getDict()
            java.lang.String r3 = r1.getValue()
            boolean r2 = r2.hasKey(r3)
            if (r2 == 0) goto L_0x012a
            java.lang.String r2 = r1.getValue()
            com.facebook.react.bridge.ReadableMap r3 = r0.getDict()
            boolean r3 = r3.hasKey(r2)
            r4 = 0
            if (r3 != 0) goto L_0x0026
        L_0x0023:
            r0 = r4
            goto L_0x009a
        L_0x0026:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            java.lang.Class r5 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x004c
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            boolean r0 = r0.getBoolean(r2)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x0049
            r0 = r4
        L_0x0049:
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x009a
        L_0x004c:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0065
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            java.lang.String r0 = r0.getString(r2)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x009a
            goto L_0x0023
        L_0x0065:
            java.lang.Class r5 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0080
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            int r0 = r0.getInt(r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x009a
        L_0x0080:
            java.lang.Class r5 = java.lang.Double.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x0023
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            double r2 = r0.getDouble(r2)
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            java.lang.String r0 = (java.lang.String) r0
        L_0x009a:
            if (r0 != 0) goto L_0x00b0
            com.adapty.react.BridgeError$TypeMismatch r7 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x00ac
            java.lang.String r0 = "UnknownType"
        L_0x00ac:
            r7.<init>(r1, r0)
            throw r7
        L_0x00b0:
            com.adapty.internal.crossplatform.CrossplatformHelper$Companion r2 = com.adapty.internal.crossplatform.CrossplatformHelper.Companion     // Catch:{ Error -> 0x0107 }
            com.adapty.internal.crossplatform.CrossplatformHelper r2 = r2.getShared()     // Catch:{ Error -> 0x0107 }
            java.lang.Class<java.util.HashMap> r3 = java.util.HashMap.class
            java.lang.Object r0 = r2.fromJson(r0, r3)     // Catch:{ Error -> 0x0107 }
            java.lang.String r2 = "CrossplatformHelper.shar…n(jsonStr, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ Error -> 0x0107 }
            java.util.HashMap r0 = (java.util.HashMap) r0
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r1 = "onboarding_screen_order"
            java.lang.Object r1 = r0.get(r1)
            boolean r2 = r1 instanceof java.lang.Number
            if (r2 == 0) goto L_0x00d2
            java.lang.Number r1 = (java.lang.Number) r1
            goto L_0x00d3
        L_0x00d2:
            r1 = r4
        L_0x00d3:
            if (r1 == 0) goto L_0x00fd
            int r1 = r1.intValue()
            java.lang.String r2 = "onboarding_name"
            java.lang.Object r2 = r0.get(r2)
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L_0x00e6
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x00e7
        L_0x00e6:
            r2 = r4
        L_0x00e7:
            java.lang.String r3 = "onboarding_screen_name"
            java.lang.Object r0 = r0.get(r3)
            boolean r3 = r0 instanceof java.lang.String
            if (r3 == 0) goto L_0x00f4
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4
        L_0x00f4:
            com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda5 r0 = new com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda5
            r0.<init>(r7)
            com.adapty.Adapty.logShowOnboarding(r2, r4, r1, r0)
            return
        L_0x00fd:
            com.adapty.react.BridgeError$TypeMismatch r7 = new com.adapty.react.BridgeError$TypeMismatch
            com.adapty.react.ParamKey r0 = com.adapty.react.ParamKey.ONBOARDING_PARAMS
            java.lang.String r1 = "onboarding_screen_order not a number"
            r7.<init>(r0, r1)
            throw r7
        L_0x0107:
            com.adapty.react.BridgeError$TypeMismatch r7 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "JSON-encoded "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.Class<java.util.HashMap> r2 = java.util.HashMap.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            java.lang.String r2 = r2.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            r7.<init>(r1, r0)
            throw r7
        L_0x012a:
            com.adapty.react.BridgeError$MissingRequiredArgument r7 = new com.adapty.react.BridgeError$MissingRequiredArgument
            r7.<init>(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.react.AdaptyCallHandler.handleLogShowOnboarding(com.adapty.react.AdaptyContext):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: handleLogShowOnboarding$lambda-7  reason: not valid java name */
    public static final void m112handleLogShowOnboarding$lambda7(AdaptyContext adaptyContext, AdaptyError adaptyError) {
        Intrinsics.checkNotNullParameter(adaptyContext, "$ctx");
        adaptyContext.okOrForwardError(adaptyError);
    }

    /* JADX WARNING: type inference failed for: r0v26, types: [java.lang.Boolean] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0062, code lost:
        if ((r0 instanceof java.lang.String) == false) goto L_0x009d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleLogShowPaywall(com.adapty.react.AdaptyContext r7) throws com.adapty.react.BridgeError.TypeMismatch {
        /*
            r6 = this;
            com.adapty.react.ParamMap r0 = r7.getParams()
            com.adapty.react.ParamKey r1 = com.adapty.react.ParamKey.PAYWALL
            com.facebook.react.bridge.ReadableMap r2 = r0.getDict()
            java.lang.String r3 = r1.getValue()
            boolean r2 = r2.hasKey(r3)
            if (r2 == 0) goto L_0x00f2
            java.lang.String r2 = r1.getValue()
            com.facebook.react.bridge.ReadableMap r3 = r0.getDict()
            boolean r3 = r3.hasKey(r2)
            r4 = 0
            if (r3 != 0) goto L_0x0025
            goto L_0x009d
        L_0x0025:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            java.lang.Class r5 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x004c
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            boolean r0 = r0.getBoolean(r2)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r4 = r0
        L_0x0049:
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x009d
        L_0x004c:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0067
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            java.lang.String r0 = r0.getString(r2)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x0065
            goto L_0x009d
        L_0x0065:
            r4 = r0
            goto L_0x009d
        L_0x0067:
            java.lang.Class r5 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0082
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            int r0 = r0.getInt(r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0065
        L_0x0082:
            java.lang.Class r5 = java.lang.Double.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x009d
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            double r2 = r0.getDouble(r2)
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0065
        L_0x009d:
            if (r4 != 0) goto L_0x00b3
            com.adapty.react.BridgeError$TypeMismatch r7 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x00af
            java.lang.String r0 = "UnknownType"
        L_0x00af:
            r7.<init>(r1, r0)
            throw r7
        L_0x00b3:
            com.adapty.internal.crossplatform.CrossplatformHelper$Companion r0 = com.adapty.internal.crossplatform.CrossplatformHelper.Companion     // Catch:{ Error -> 0x00cf }
            com.adapty.internal.crossplatform.CrossplatformHelper r0 = r0.getShared()     // Catch:{ Error -> 0x00cf }
            java.lang.Class<com.adapty.models.AdaptyPaywall> r2 = com.adapty.models.AdaptyPaywall.class
            java.lang.Object r0 = r0.fromJson(r4, r2)     // Catch:{ Error -> 0x00cf }
            java.lang.String r2 = "CrossplatformHelper.shar…n(jsonStr, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ Error -> 0x00cf }
            com.adapty.models.AdaptyPaywall r0 = (com.adapty.models.AdaptyPaywall) r0
            com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda2 r1 = new com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda2
            r1.<init>(r7)
            com.adapty.Adapty.logShowPaywall(r0, r1)
            return
        L_0x00cf:
            com.adapty.react.BridgeError$TypeMismatch r7 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "JSON-encoded "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.Class<com.adapty.models.AdaptyPaywall> r2 = com.adapty.models.AdaptyPaywall.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            java.lang.String r2 = r2.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            r7.<init>(r1, r0)
            throw r7
        L_0x00f2:
            com.adapty.react.BridgeError$MissingRequiredArgument r7 = new com.adapty.react.BridgeError$MissingRequiredArgument
            r7.<init>(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.react.AdaptyCallHandler.handleLogShowPaywall(com.adapty.react.AdaptyContext):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: handleLogShowPaywall$lambda-8  reason: not valid java name */
    public static final void m113handleLogShowPaywall$lambda8(AdaptyContext adaptyContext, AdaptyError adaptyError) {
        Intrinsics.checkNotNullParameter(adaptyContext, "$ctx");
        adaptyContext.okOrForwardError(adaptyError);
    }

    /* JADX WARNING: type inference failed for: r0v19, types: [java.lang.Boolean] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0062, code lost:
        if ((r0 instanceof java.lang.String) == false) goto L_0x009d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleSetFallbackPaywalls(com.adapty.react.AdaptyContext r7) throws com.adapty.react.BridgeError.TypeMismatch {
        /*
            r6 = this;
            com.adapty.react.ParamMap r0 = r7.getParams()
            com.adapty.react.ParamKey r1 = com.adapty.react.ParamKey.PAYWALLS
            com.facebook.react.bridge.ReadableMap r2 = r0.getDict()
            java.lang.String r3 = r1.getValue()
            boolean r2 = r2.hasKey(r3)
            if (r2 == 0) goto L_0x00bc
            java.lang.String r2 = r1.getValue()
            com.facebook.react.bridge.ReadableMap r3 = r0.getDict()
            boolean r3 = r3.hasKey(r2)
            r4 = 0
            if (r3 != 0) goto L_0x0025
            goto L_0x009d
        L_0x0025:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            java.lang.Class r5 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x004c
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            boolean r0 = r0.getBoolean(r2)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r4 = r0
        L_0x0049:
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x009d
        L_0x004c:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0067
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            java.lang.String r0 = r0.getString(r2)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x0065
            goto L_0x009d
        L_0x0065:
            r4 = r0
            goto L_0x009d
        L_0x0067:
            java.lang.Class r5 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0082
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            int r0 = r0.getInt(r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0065
        L_0x0082:
            java.lang.Class r5 = java.lang.Double.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x009d
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            double r2 = r0.getDouble(r2)
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0065
        L_0x009d:
            if (r4 != 0) goto L_0x00b3
            com.adapty.react.BridgeError$TypeMismatch r7 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x00af
            java.lang.String r0 = "UnknownType"
        L_0x00af:
            r7.<init>(r1, r0)
            throw r7
        L_0x00b3:
            com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda3 r0 = new com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda3
            r0.<init>(r7)
            com.adapty.Adapty.setFallbackPaywalls(r4, r0)
            return
        L_0x00bc:
            com.adapty.react.BridgeError$MissingRequiredArgument r7 = new com.adapty.react.BridgeError$MissingRequiredArgument
            r7.<init>(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.react.AdaptyCallHandler.handleSetFallbackPaywalls(com.adapty.react.AdaptyContext):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: handleSetFallbackPaywalls$lambda-9  reason: not valid java name */
    public static final void m117handleSetFallbackPaywalls$lambda9(AdaptyContext adaptyContext, AdaptyError adaptyError) {
        Intrinsics.checkNotNullParameter(adaptyContext, "$ctx");
        adaptyContext.okOrForwardError(adaptyError);
    }

    /* JADX WARNING: type inference failed for: r1v15, types: [java.lang.Boolean] */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0062, code lost:
        if ((r0 instanceof java.lang.String) == false) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0113, code lost:
        if ((r1 instanceof java.lang.String) == false) goto L_0x014e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b2  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleSetVariationId(com.adapty.react.AdaptyContext r9) throws com.adapty.react.BridgeError.TypeMismatch {
        /*
            r8 = this;
            com.adapty.react.ParamMap r0 = r9.getParams()
            com.adapty.react.ParamKey r1 = com.adapty.react.ParamKey.TRANSACTION_ID
            com.facebook.react.bridge.ReadableMap r2 = r0.getDict()
            java.lang.String r3 = r1.getValue()
            boolean r2 = r2.hasKey(r3)
            if (r2 == 0) goto L_0x0173
            java.lang.String r2 = r1.getValue()
            com.facebook.react.bridge.ReadableMap r3 = r0.getDict()
            boolean r3 = r3.hasKey(r2)
            r4 = 0
            if (r3 != 0) goto L_0x0026
        L_0x0023:
            r0 = r4
            goto L_0x009a
        L_0x0026:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            java.lang.Class r5 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x004c
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            boolean r0 = r0.getBoolean(r2)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x0049
            r0 = r4
        L_0x0049:
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x009a
        L_0x004c:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0065
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            java.lang.String r0 = r0.getString(r2)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x009a
            goto L_0x0023
        L_0x0065:
            java.lang.Class r5 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0080
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            int r0 = r0.getInt(r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x009a
        L_0x0080:
            java.lang.Class r5 = java.lang.Double.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x0023
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            double r2 = r0.getDouble(r2)
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            java.lang.String r0 = (java.lang.String) r0
        L_0x009a:
            java.lang.String r2 = "UnknownType"
            if (r0 != 0) goto L_0x00b2
            com.adapty.react.BridgeError$TypeMismatch r9 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r2 = r0
        L_0x00ae:
            r9.<init>(r1, r2)
            throw r9
        L_0x00b2:
            com.adapty.react.ParamMap r1 = r9.getParams()
            com.adapty.react.ParamKey r3 = com.adapty.react.ParamKey.VARIATION_ID
            com.facebook.react.bridge.ReadableMap r5 = r1.getDict()
            java.lang.String r6 = r3.getValue()
            boolean r5 = r5.hasKey(r6)
            if (r5 == 0) goto L_0x016d
            java.lang.String r5 = r3.getValue()
            com.facebook.react.bridge.ReadableMap r6 = r1.getDict()
            boolean r6 = r6.hasKey(r5)
            if (r6 != 0) goto L_0x00d6
            goto L_0x014e
        L_0x00d6:
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            java.lang.Class r7 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x00fd
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            boolean r1 = r1.getBoolean(r5)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r5 = r1 instanceof java.lang.String
            if (r5 != 0) goto L_0x00f9
            goto L_0x00fa
        L_0x00f9:
            r4 = r1
        L_0x00fa:
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x014e
        L_0x00fd:
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0118
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            java.lang.String r1 = r1.getString(r5)
            boolean r5 = r1 instanceof java.lang.String
            if (r5 != 0) goto L_0x0116
            goto L_0x014e
        L_0x0116:
            r4 = r1
            goto L_0x014e
        L_0x0118:
            java.lang.Class r7 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0133
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            int r1 = r1.getInt(r5)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0116
        L_0x0133:
            java.lang.Class r7 = java.lang.Double.TYPE
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x014e
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            double r4 = r1.getDouble(r5)
            java.lang.Double r1 = java.lang.Double.valueOf(r4)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0116
        L_0x014e:
            if (r4 != 0) goto L_0x0164
            com.adapty.react.BridgeError$TypeMismatch r9 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x015f
            goto L_0x0160
        L_0x015f:
            r2 = r0
        L_0x0160:
            r9.<init>(r3, r2)
            throw r9
        L_0x0164:
            com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda8 r1 = new com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda8
            r1.<init>(r9)
            com.adapty.Adapty.setVariationId(r0, r4, r1)
            return
        L_0x016d:
            com.adapty.react.BridgeError$MissingRequiredArgument r9 = new com.adapty.react.BridgeError$MissingRequiredArgument
            r9.<init>(r3)
            throw r9
        L_0x0173:
            com.adapty.react.BridgeError$MissingRequiredArgument r9 = new com.adapty.react.BridgeError$MissingRequiredArgument
            r9.<init>(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.react.AdaptyCallHandler.handleSetVariationId(com.adapty.react.AdaptyContext):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: handleSetVariationId$lambda-10  reason: not valid java name */
    public static final void m118handleSetVariationId$lambda10(AdaptyContext adaptyContext, AdaptyError adaptyError) {
        Intrinsics.checkNotNullParameter(adaptyContext, "$ctx");
        adaptyContext.okOrForwardError(adaptyError);
    }

    private final void handleGetProfile(AdaptyContext adaptyContext) {
        Adapty.getProfile(new AdaptyCallHandler$$ExternalSyntheticLambda11(adaptyContext));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r0 = r0.getClass();
     */
    /* renamed from: handleGetProfile$lambda-11  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m110handleGetProfile$lambda11(com.adapty.react.AdaptyContext r3, com.adapty.utils.AdaptyResult r4) {
        /*
            java.lang.String r0 = "$ctx"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r4 instanceof com.adapty.utils.AdaptyResult.Success
            if (r0 == 0) goto L_0x0069
            com.adapty.utils.AdaptyResult$Success r4 = (com.adapty.utils.AdaptyResult.Success) r4
            java.lang.Object r4 = r4.getValue()
            boolean r0 = r4 instanceof java.util.List
            java.lang.String r1 = "UnknownType"
            if (r0 == 0) goto L_0x0052
            r0 = r4
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            if (r0 == 0) goto L_0x002e
            java.lang.Class r0 = r0.getClass()
            if (r0 == 0) goto L_0x002e
            java.lang.String r0 = r0.getSimpleName()
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            if (r0 != 0) goto L_0x0032
            goto L_0x0038
        L_0x0032:
            java.lang.String r1 = "data.firstOrNull()?.java…mpleName ?: \"UnknownType\""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r1 = r0
        L_0x0038:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Array<"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = 62
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r0.toString()
            goto L_0x0060
        L_0x0052:
            java.lang.Class<com.adapty.models.AdaptyProfile> r0 = com.adapty.models.AdaptyProfile.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r1 = r0
        L_0x0060:
            com.adapty.react.AdaptyBridgeResult r0 = new com.adapty.react.AdaptyBridgeResult
            r0.<init>(r4, r1)
            r3.resolve(r0)
            goto L_0x0076
        L_0x0069:
            boolean r0 = r4 instanceof com.adapty.utils.AdaptyResult.Error
            if (r0 == 0) goto L_0x0076
            com.adapty.utils.AdaptyResult$Error r4 = (com.adapty.utils.AdaptyResult.Error) r4
            com.adapty.errors.AdaptyError r4 = r4.getError()
            r3.forwardError(r4)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.react.AdaptyCallHandler.m110handleGetProfile$lambda11(com.adapty.react.AdaptyContext, com.adapty.utils.AdaptyResult):void");
    }

    /* JADX WARNING: type inference failed for: r0v19, types: [java.lang.Boolean] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0062, code lost:
        if ((r0 instanceof java.lang.String) == false) goto L_0x009d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleIdentify(com.adapty.react.AdaptyContext r7) throws com.adapty.react.BridgeError.TypeMismatch {
        /*
            r6 = this;
            com.adapty.react.ParamMap r0 = r7.getParams()
            com.adapty.react.ParamKey r1 = com.adapty.react.ParamKey.USER_ID
            com.facebook.react.bridge.ReadableMap r2 = r0.getDict()
            java.lang.String r3 = r1.getValue()
            boolean r2 = r2.hasKey(r3)
            if (r2 == 0) goto L_0x00bc
            java.lang.String r2 = r1.getValue()
            com.facebook.react.bridge.ReadableMap r3 = r0.getDict()
            boolean r3 = r3.hasKey(r2)
            r4 = 0
            if (r3 != 0) goto L_0x0025
            goto L_0x009d
        L_0x0025:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            java.lang.Class r5 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x004c
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            boolean r0 = r0.getBoolean(r2)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r4 = r0
        L_0x0049:
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x009d
        L_0x004c:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0067
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            java.lang.String r0 = r0.getString(r2)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x0065
            goto L_0x009d
        L_0x0065:
            r4 = r0
            goto L_0x009d
        L_0x0067:
            java.lang.Class r5 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0082
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            int r0 = r0.getInt(r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0065
        L_0x0082:
            java.lang.Class r5 = java.lang.Double.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x009d
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            double r2 = r0.getDouble(r2)
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0065
        L_0x009d:
            if (r4 != 0) goto L_0x00b3
            com.adapty.react.BridgeError$TypeMismatch r7 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x00af
            java.lang.String r0 = "UnknownType"
        L_0x00af:
            r7.<init>(r1, r0)
            throw r7
        L_0x00b3:
            com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda0 r0 = new com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda0
            r0.<init>(r7)
            com.adapty.Adapty.identify(r4, r0)
            return
        L_0x00bc:
            com.adapty.react.BridgeError$MissingRequiredArgument r7 = new com.adapty.react.BridgeError$MissingRequiredArgument
            r7.<init>(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.react.AdaptyCallHandler.handleIdentify(com.adapty.react.AdaptyContext):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: handleIdentify$lambda-12  reason: not valid java name */
    public static final void m111handleIdentify$lambda12(AdaptyContext adaptyContext, AdaptyError adaptyError) {
        Intrinsics.checkNotNullParameter(adaptyContext, "$ctx");
        adaptyContext.okOrForwardError(adaptyError);
    }

    private final void handleLogout(AdaptyContext adaptyContext) {
        Adapty.logout(new AdaptyCallHandler$$ExternalSyntheticLambda13(adaptyContext));
    }

    /* access modifiers changed from: private */
    /* renamed from: handleLogout$lambda-13  reason: not valid java name */
    public static final void m114handleLogout$lambda13(AdaptyContext adaptyContext, AdaptyError adaptyError) {
        Intrinsics.checkNotNullParameter(adaptyContext, "$ctx");
        adaptyContext.okOrForwardError(adaptyError);
    }

    /* JADX WARNING: type inference failed for: r0v26, types: [java.lang.Boolean] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0062, code lost:
        if ((r0 instanceof java.lang.String) == false) goto L_0x009d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleUpdateProfile(com.adapty.react.AdaptyContext r7) throws com.adapty.react.BridgeError.TypeMismatch {
        /*
            r6 = this;
            com.adapty.react.ParamMap r0 = r7.getParams()
            com.adapty.react.ParamKey r1 = com.adapty.react.ParamKey.PARAMS
            com.facebook.react.bridge.ReadableMap r2 = r0.getDict()
            java.lang.String r3 = r1.getValue()
            boolean r2 = r2.hasKey(r3)
            if (r2 == 0) goto L_0x00f2
            java.lang.String r2 = r1.getValue()
            com.facebook.react.bridge.ReadableMap r3 = r0.getDict()
            boolean r3 = r3.hasKey(r2)
            r4 = 0
            if (r3 != 0) goto L_0x0025
            goto L_0x009d
        L_0x0025:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            java.lang.Class r5 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x004c
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            boolean r0 = r0.getBoolean(r2)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r4 = r0
        L_0x0049:
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x009d
        L_0x004c:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0067
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            java.lang.String r0 = r0.getString(r2)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x0065
            goto L_0x009d
        L_0x0065:
            r4 = r0
            goto L_0x009d
        L_0x0067:
            java.lang.Class r5 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0082
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            int r0 = r0.getInt(r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0065
        L_0x0082:
            java.lang.Class r5 = java.lang.Double.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x009d
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            double r2 = r0.getDouble(r2)
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0065
        L_0x009d:
            if (r4 != 0) goto L_0x00b3
            com.adapty.react.BridgeError$TypeMismatch r7 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x00af
            java.lang.String r0 = "UnknownType"
        L_0x00af:
            r7.<init>(r1, r0)
            throw r7
        L_0x00b3:
            com.adapty.internal.crossplatform.CrossplatformHelper$Companion r0 = com.adapty.internal.crossplatform.CrossplatformHelper.Companion     // Catch:{ Error -> 0x00cf }
            com.adapty.internal.crossplatform.CrossplatformHelper r0 = r0.getShared()     // Catch:{ Error -> 0x00cf }
            java.lang.Class<com.adapty.models.AdaptyProfileParameters> r2 = com.adapty.models.AdaptyProfileParameters.class
            java.lang.Object r0 = r0.fromJson(r4, r2)     // Catch:{ Error -> 0x00cf }
            java.lang.String r2 = "CrossplatformHelper.shar…n(jsonStr, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ Error -> 0x00cf }
            com.adapty.models.AdaptyProfileParameters r0 = (com.adapty.models.AdaptyProfileParameters) r0
            com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda7 r1 = new com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda7
            r1.<init>(r7)
            com.adapty.Adapty.updateProfile(r0, r1)
            return
        L_0x00cf:
            com.adapty.react.BridgeError$TypeMismatch r7 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "JSON-encoded "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.Class<com.adapty.models.AdaptyProfileParameters> r2 = com.adapty.models.AdaptyProfileParameters.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            java.lang.String r2 = r2.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            r7.<init>(r1, r0)
            throw r7
        L_0x00f2:
            com.adapty.react.BridgeError$MissingRequiredArgument r7 = new com.adapty.react.BridgeError$MissingRequiredArgument
            r7.<init>(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.react.AdaptyCallHandler.handleUpdateProfile(com.adapty.react.AdaptyContext):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: handleUpdateProfile$lambda-14  reason: not valid java name */
    public static final void m120handleUpdateProfile$lambda14(AdaptyContext adaptyContext, AdaptyError adaptyError) {
        Intrinsics.checkNotNullParameter(adaptyContext, "$ctx");
        adaptyContext.okOrForwardError(adaptyError);
    }

    /* JADX WARNING: type inference failed for: r2v14, types: [java.lang.String] */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0064, code lost:
        if ((r1 instanceof java.lang.String) == false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0118, code lost:
        if ((r2 instanceof java.lang.String) == false) goto L_0x00d9;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b2 A[SYNTHETIC, Splitter:B:27:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0154 A[SYNTHETIC, Splitter:B:50:0x0154] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleMakePurchase(com.adapty.react.AdaptyContext r9) {
        /*
            r8 = this;
            java.lang.String r0 = "JSON-encoded "
            com.adapty.react.ParamMap r1 = r9.getParams()
            com.adapty.react.ParamKey r2 = com.adapty.react.ParamKey.PRODUCT
            com.facebook.react.bridge.ReadableMap r3 = r1.getDict()
            java.lang.String r4 = r2.getValue()
            boolean r3 = r3.hasKey(r4)
            if (r3 == 0) goto L_0x0244
            java.lang.String r3 = r2.getValue()
            com.facebook.react.bridge.ReadableMap r4 = r1.getDict()
            boolean r4 = r4.hasKey(r3)
            r5 = 0
            if (r4 != 0) goto L_0x0028
        L_0x0025:
            r1 = r5
            goto L_0x009c
        L_0x0028:
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            java.lang.Class r6 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x004e
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            boolean r1 = r1.getBoolean(r3)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r3 = r1 instanceof java.lang.String
            if (r3 != 0) goto L_0x004b
            r1 = r5
        L_0x004b:
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x009c
        L_0x004e:
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x0067
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            java.lang.String r1 = r1.getString(r3)
            boolean r3 = r1 instanceof java.lang.String
            if (r3 != 0) goto L_0x009c
            goto L_0x0025
        L_0x0067:
            java.lang.Class r6 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x0082
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            int r1 = r1.getInt(r3)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x009c
        L_0x0082:
            java.lang.Class r6 = java.lang.Double.TYPE
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r4 == 0) goto L_0x0025
            com.facebook.react.bridge.ReadableMap r1 = r1.getDict()
            double r3 = r1.getDouble(r3)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            java.lang.String r1 = (java.lang.String) r1
        L_0x009c:
            if (r1 != 0) goto L_0x00b2
            com.adapty.react.BridgeError$TypeMismatch r9 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x00ae
            java.lang.String r0 = "UnknownType"
        L_0x00ae:
            r9.<init>(r2, r0)
            throw r9
        L_0x00b2:
            com.adapty.internal.crossplatform.CrossplatformHelper$Companion r3 = com.adapty.internal.crossplatform.CrossplatformHelper.Companion     // Catch:{ Error -> 0x0223 }
            com.adapty.internal.crossplatform.CrossplatformHelper r3 = r3.getShared()     // Catch:{ Error -> 0x0223 }
            java.lang.Class<com.adapty.models.AdaptyPaywallProduct> r4 = com.adapty.models.AdaptyPaywallProduct.class
            java.lang.Object r1 = r3.fromJson(r1, r4)     // Catch:{ Error -> 0x0223 }
            java.lang.String r3 = "CrossplatformHelper.shar…n(jsonStr, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ Error -> 0x0223 }
            com.adapty.models.AdaptyPaywallProduct r1 = (com.adapty.models.AdaptyPaywallProduct) r1
            com.adapty.react.ParamMap r2 = r9.getParams()
            com.adapty.react.ParamKey r3 = com.adapty.react.ParamKey.PARAMS
            java.lang.String r4 = r3.getValue()
            com.facebook.react.bridge.ReadableMap r6 = r2.getDict()
            boolean r6 = r6.hasKey(r4)
            if (r6 != 0) goto L_0x00dc
        L_0x00d9:
            r2 = r5
            goto L_0x0150
        L_0x00dc:
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            java.lang.Class r7 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0102
            com.facebook.react.bridge.ReadableMap r2 = r2.getDict()
            boolean r2 = r2.getBoolean(r4)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            boolean r4 = r2 instanceof java.lang.String
            if (r4 != 0) goto L_0x00ff
            r2 = r5
        L_0x00ff:
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x0150
        L_0x0102:
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x011b
            com.facebook.react.bridge.ReadableMap r2 = r2.getDict()
            java.lang.String r2 = r2.getString(r4)
            boolean r4 = r2 instanceof java.lang.String
            if (r4 != 0) goto L_0x0150
            goto L_0x00d9
        L_0x011b:
            java.lang.Class r7 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0136
            com.facebook.react.bridge.ReadableMap r2 = r2.getDict()
            int r2 = r2.getInt(r4)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x0150
        L_0x0136:
            java.lang.Class r7 = java.lang.Double.TYPE
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x00d9
            com.facebook.react.bridge.ReadableMap r2 = r2.getDict()
            double r6 = r2.getDouble(r4)
            java.lang.Double r2 = java.lang.Double.valueOf(r6)
            java.lang.String r2 = (java.lang.String) r2
        L_0x0150:
            if (r2 != 0) goto L_0x0154
            r0 = r5
            goto L_0x0160
        L_0x0154:
            com.adapty.internal.crossplatform.CrossplatformHelper$Companion r4 = com.adapty.internal.crossplatform.CrossplatformHelper.Companion     // Catch:{ Error -> 0x0202 }
            com.adapty.internal.crossplatform.CrossplatformHelper r4 = r4.getShared()     // Catch:{ Error -> 0x0202 }
            java.lang.Class<com.adapty.models.AdaptySubscriptionUpdateParameters> r6 = com.adapty.models.AdaptySubscriptionUpdateParameters.class
            java.lang.Object r0 = r4.fromJson(r2, r6)     // Catch:{ Error -> 0x0202 }
        L_0x0160:
            com.adapty.models.AdaptySubscriptionUpdateParameters r0 = (com.adapty.models.AdaptySubscriptionUpdateParameters) r0
            com.adapty.react.ParamMap r2 = r9.getParams()
            com.adapty.react.ParamKey r3 = com.adapty.react.ParamKey.IS_OFFER_PERSONALIZED
            java.lang.String r3 = r3.getValue()
            com.facebook.react.bridge.ReadableMap r4 = r2.getDict()
            boolean r4 = r4.hasKey(r3)
            if (r4 != 0) goto L_0x0178
            goto L_0x01eb
        L_0x0178:
            java.lang.Class<java.lang.Boolean> r4 = java.lang.Boolean.class
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            java.lang.Class r6 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x0198
            com.facebook.react.bridge.ReadableMap r2 = r2.getDict()
            boolean r2 = r2.getBoolean(r3)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
        L_0x0196:
            r5 = r2
            goto L_0x01eb
        L_0x0198:
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x01b5
            com.facebook.react.bridge.ReadableMap r2 = r2.getDict()
            java.lang.String r2 = r2.getString(r3)
            boolean r3 = r2 instanceof java.lang.Boolean
            if (r3 != 0) goto L_0x01b1
            goto L_0x01b2
        L_0x01b1:
            r5 = r2
        L_0x01b2:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            goto L_0x01eb
        L_0x01b5:
            java.lang.Class r6 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x01d0
            com.facebook.react.bridge.ReadableMap r2 = r2.getDict()
            int r2 = r2.getInt(r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            goto L_0x0196
        L_0x01d0:
            java.lang.Class r6 = java.lang.Double.TYPE
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r4 == 0) goto L_0x01eb
            com.facebook.react.bridge.ReadableMap r2 = r2.getDict()
            double r2 = r2.getDouble(r3)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            goto L_0x0196
        L_0x01eb:
            android.app.Activity r2 = r9.getActivity()
            if (r2 == 0) goto L_0x0201
            if (r5 == 0) goto L_0x01f8
            boolean r3 = r5.booleanValue()
            goto L_0x01f9
        L_0x01f8:
            r3 = 0
        L_0x01f9:
            com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda6 r4 = new com.adapty.react.AdaptyCallHandler$$ExternalSyntheticLambda6
            r4.<init>(r9)
            com.adapty.Adapty.makePurchase(r2, r1, r0, r3, r4)
        L_0x0201:
            return
        L_0x0202:
            com.adapty.react.BridgeError$TypeMismatch r9 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.Class<com.adapty.models.AdaptySubscriptionUpdateParameters> r1 = com.adapty.models.AdaptySubscriptionUpdateParameters.class
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            java.lang.String r1 = r1.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.<init>(r3, r0)
            throw r9
        L_0x0223:
            com.adapty.react.BridgeError$TypeMismatch r9 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.Class<com.adapty.models.AdaptyPaywallProduct> r1 = com.adapty.models.AdaptyPaywallProduct.class
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            java.lang.String r1 = r1.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.<init>(r2, r0)
            throw r9
        L_0x0244:
            com.adapty.react.BridgeError$MissingRequiredArgument r9 = new com.adapty.react.BridgeError$MissingRequiredArgument
            r9.<init>(r2)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.react.AdaptyCallHandler.handleMakePurchase(com.adapty.react.AdaptyContext):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: handleMakePurchase$lambda-17$lambda-16  reason: not valid java name */
    public static final void m115handleMakePurchase$lambda17$lambda16(AdaptyContext adaptyContext, AdaptyResult adaptyResult) {
        AdaptyProfile profile;
        Class<?> cls;
        Intrinsics.checkNotNullParameter(adaptyContext, "$ctx");
        Intrinsics.checkNotNullParameter(adaptyResult, "result");
        if (adaptyResult instanceof AdaptyResult.Success) {
            AdaptyPurchasedInfo adaptyPurchasedInfo = (AdaptyPurchasedInfo) ((AdaptyResult.Success) adaptyResult).getValue();
            String str = null;
            if (!(adaptyPurchasedInfo == null || (profile = adaptyPurchasedInfo.getProfile()) == null)) {
                String str2 = "UnknownType";
                if (profile instanceof List) {
                    Object firstOrNull = CollectionsKt.firstOrNull((List) profile);
                    if (!(firstOrNull == null || (cls = firstOrNull.getClass()) == null)) {
                        str = cls.getSimpleName();
                    }
                    if (str != null) {
                        Intrinsics.checkNotNullExpressionValue(str, "data.firstOrNull()?.java…mpleName ?: \"UnknownType\"");
                        str2 = str;
                    }
                    str2 = "Array<" + str2 + Typography.greater;
                } else {
                    String simpleName = Reflection.getOrCreateKotlinClass(AdaptyProfile.class).getSimpleName();
                    if (simpleName != null) {
                        str2 = simpleName;
                    }
                }
                adaptyContext.resolve(new AdaptyBridgeResult(profile, str2));
                str = Unit.INSTANCE;
            }
            if (str == null) {
                adaptyContext.resovle();
            }
        } else if (adaptyResult instanceof AdaptyResult.Error) {
            adaptyContext.forwardError(((AdaptyResult.Error) adaptyResult).getError());
        }
    }

    private final void handleRestorePurchases(AdaptyContext adaptyContext) {
        Adapty.restorePurchases(new AdaptyCallHandler$$ExternalSyntheticLambda1(adaptyContext));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r0 = r0.getClass();
     */
    /* renamed from: handleRestorePurchases$lambda-18  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m116handleRestorePurchases$lambda18(com.adapty.react.AdaptyContext r3, com.adapty.utils.AdaptyResult r4) {
        /*
            java.lang.String r0 = "$ctx"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r4 instanceof com.adapty.utils.AdaptyResult.Success
            if (r0 == 0) goto L_0x0069
            com.adapty.utils.AdaptyResult$Success r4 = (com.adapty.utils.AdaptyResult.Success) r4
            java.lang.Object r4 = r4.getValue()
            boolean r0 = r4 instanceof java.util.List
            java.lang.String r1 = "UnknownType"
            if (r0 == 0) goto L_0x0052
            r0 = r4
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            if (r0 == 0) goto L_0x002e
            java.lang.Class r0 = r0.getClass()
            if (r0 == 0) goto L_0x002e
            java.lang.String r0 = r0.getSimpleName()
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            if (r0 != 0) goto L_0x0032
            goto L_0x0038
        L_0x0032:
            java.lang.String r1 = "data.firstOrNull()?.java…mpleName ?: \"UnknownType\""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r1 = r0
        L_0x0038:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Array<"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = 62
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r0.toString()
            goto L_0x0060
        L_0x0052:
            java.lang.Class<com.adapty.models.AdaptyProfile> r0 = com.adapty.models.AdaptyProfile.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r1 = r0
        L_0x0060:
            com.adapty.react.AdaptyBridgeResult r0 = new com.adapty.react.AdaptyBridgeResult
            r0.<init>(r4, r1)
            r3.resolve(r0)
            goto L_0x0076
        L_0x0069:
            boolean r0 = r4 instanceof com.adapty.utils.AdaptyResult.Error
            if (r0 == 0) goto L_0x0076
            com.adapty.utils.AdaptyResult$Error r4 = (com.adapty.utils.AdaptyResult.Error) r4
            com.adapty.errors.AdaptyError r4 = r4.getError()
            r3.forwardError(r4)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.react.AdaptyCallHandler.m116handleRestorePurchases$lambda18(com.adapty.react.AdaptyContext, com.adapty.utils.AdaptyResult):void");
    }

    /* JADX WARNING: type inference failed for: r0v25, types: [java.lang.Boolean] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0062, code lost:
        if ((r0 instanceof java.lang.String) == false) goto L_0x009d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleSetLogLevel(com.adapty.react.AdaptyContext r7) throws com.adapty.react.BridgeError.TypeMismatch {
        /*
            r6 = this;
            com.adapty.react.ParamMap r0 = r7.getParams()
            com.adapty.react.ParamKey r1 = com.adapty.react.ParamKey.VALUE
            com.facebook.react.bridge.ReadableMap r2 = r0.getDict()
            java.lang.String r3 = r1.getValue()
            boolean r2 = r2.hasKey(r3)
            if (r2 == 0) goto L_0x00e9
            java.lang.String r2 = r1.getValue()
            com.facebook.react.bridge.ReadableMap r3 = r0.getDict()
            boolean r3 = r3.hasKey(r2)
            r4 = 0
            if (r3 != 0) goto L_0x0025
            goto L_0x009d
        L_0x0025:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            java.lang.Class r5 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x004c
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            boolean r0 = r0.getBoolean(r2)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r4 = r0
        L_0x0049:
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x009d
        L_0x004c:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0067
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            java.lang.String r0 = r0.getString(r2)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L_0x0065
            goto L_0x009d
        L_0x0065:
            r4 = r0
            goto L_0x009d
        L_0x0067:
            java.lang.Class r5 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0082
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            int r0 = r0.getInt(r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0065
        L_0x0082:
            java.lang.Class r5 = java.lang.Double.TYPE
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x009d
            com.facebook.react.bridge.ReadableMap r0 = r0.getDict()
            double r2 = r0.getDouble(r2)
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0065
        L_0x009d:
            if (r4 != 0) goto L_0x00b3
            com.adapty.react.BridgeError$TypeMismatch r7 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x00af
            java.lang.String r0 = "UnknownType"
        L_0x00af:
            r7.<init>(r1, r0)
            throw r7
        L_0x00b3:
            com.adapty.internal.crossplatform.CrossplatformHelper$Companion r0 = com.adapty.internal.crossplatform.CrossplatformHelper.Companion
            com.adapty.internal.crossplatform.CrossplatformHelper r0 = r0.getShared()
            com.adapty.utils.AdaptyLogLevel r0 = r0.toLogLevel(r4)
            if (r0 == 0) goto L_0x00c6
            com.adapty.Adapty.setLogLevel(r0)
            r7.resovle()
            return
        L_0x00c6:
            com.adapty.react.BridgeError$TypeMismatch r7 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "JSON-encoded "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.Class<com.adapty.utils.AdaptyLogLevel> r2 = com.adapty.utils.AdaptyLogLevel.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            java.lang.String r2 = r2.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            r7.<init>(r1, r0)
            throw r7
        L_0x00e9:
            com.adapty.react.BridgeError$MissingRequiredArgument r7 = new com.adapty.react.BridgeError$MissingRequiredArgument
            r7.<init>(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.react.AdaptyCallHandler.handleSetLogLevel(com.adapty.react.AdaptyContext):void");
    }
}
