package com.adapty.react;

import android.app.Activity;
import com.adapty.errors.AdaptyError;
import com.adapty.internal.crossplatform.CrossplatformHelper;
import com.adapty.react.BridgeError;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001aJ \u0010\u001d\u001a\u00020\u0016\"\b\b\u0000\u0010\u001e*\u00020\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0 H\u0002J\"\u0010!\u001a\u00020\u0016\"\n\b\u0000\u0010\u001e\u0018\u0001*\u00020\u00012\u0006\u0010\"\u001a\u0002H\u001eH\b¢\u0006\u0002\u0010#J\u001e\u0010!\u001a\u00020\u0016\"\b\b\u0000\u0010\u001e*\u00020\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0 J\u0006\u0010$\u001a\u00020\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lcom/adapty/react/AdaptyContext;", "", "methodString", "", "args", "Lcom/facebook/react/bridge/ReadableMap;", "__promise", "Lcom/facebook/react/bridge/Promise;", "activity", "Landroid/app/Activity;", "(Ljava/lang/String;Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/bridge/Promise;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "methodName", "Lcom/adapty/react/MethodName;", "getMethodName", "()Lcom/adapty/react/MethodName;", "params", "Lcom/adapty/react/ParamMap;", "getParams", "()Lcom/adapty/react/ParamMap;", "bridgeError", "", "error", "", "forwardError", "Lcom/adapty/errors/AdaptyError;", "okOrForwardError", "maybeErr", "reject", "T", "result", "Lcom/adapty/react/AdaptyBridgeResult;", "resolve", "data", "(Ljava/lang/Object;)V", "resovle", "react-native-adapty_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdaptyContext.kt */
public final class AdaptyContext {
    private final Promise __promise;
    private final Activity activity;
    private final MethodName methodName;
    private final ParamMap params;

    public AdaptyContext(String str, ReadableMap readableMap, Promise promise, Activity activity2) {
        Intrinsics.checkNotNullParameter(str, "methodString");
        Intrinsics.checkNotNullParameter(readableMap, StepData.ARGS);
        Intrinsics.checkNotNullParameter(promise, "__promise");
        this.__promise = promise;
        this.activity = activity2;
        this.methodName = MethodName.Companion.fromString(str);
        this.params = new ParamMap(readableMap);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final MethodName getMethodName() {
        return this.methodName;
    }

    public final ParamMap getParams() {
        return this.params;
    }

    public final <T> void resolve(AdaptyBridgeResult<T> adaptyBridgeResult) {
        Intrinsics.checkNotNullParameter(adaptyBridgeResult, "result");
        try {
            this.__promise.resolve(CrossplatformHelper.Companion.getShared().toJson(adaptyBridgeResult));
        } catch (Exception e) {
            bridgeError(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = r0.getClass();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ <T> void resolve(T r4) {
        /*
            r3 = this;
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r4 instanceof java.util.List
            java.lang.String r1 = "UnknownType"
            if (r0 == 0) goto L_0x003e
            r0 = r4
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            if (r0 == 0) goto L_0x001f
            java.lang.Class r0 = r0.getClass()
            if (r0 == 0) goto L_0x001f
            java.lang.String r0 = r0.getSimpleName()
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            if (r0 != 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r1 = r0
        L_0x0024:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Array<"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = 62
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r0.toString()
            goto L_0x0052
        L_0x003e:
            r0 = 4
            java.lang.String r2 = "T"
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r0, r2)
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            if (r0 != 0) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r1 = r0
        L_0x0052:
            com.adapty.react.AdaptyBridgeResult r0 = new com.adapty.react.AdaptyBridgeResult
            r0.<init>(r4, r1)
            r3.resolve(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.react.AdaptyContext.resolve(java.lang.Object):void");
    }

    public final void resovle() {
        resolve(new AdaptyBridgeResult(new NullEncodable(), "null"));
    }

    private final <T> void reject(AdaptyBridgeResult<T> adaptyBridgeResult) {
        try {
            this.__promise.reject("adapty_rn_bridge_error", CrossplatformHelper.Companion.getShared().toJson(adaptyBridgeResult));
        } catch (Exception e) {
            bridgeError(e);
        }
    }

    public final void forwardError(AdaptyError adaptyError) {
        Intrinsics.checkNotNullParameter(adaptyError, "error");
        String simpleName = AdaptyError.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "AdaptyError::class.java.simpleName");
        reject(new AdaptyBridgeResult(adaptyError, simpleName));
    }

    public final void bridgeError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        if (th instanceof BridgeError) {
            String json = ((BridgeError) th).toJson();
            Class<BridgeError> cls = BridgeError.class;
            Intrinsics.checkNotNullExpressionValue("BridgeError", "BridgeError::class.java.simpleName");
            reject(new AdaptyBridgeResult(json, "BridgeError"));
            return;
        }
        BridgeError.UnexpectedError unexpectedError = new BridgeError.UnexpectedError(th);
        Class<BridgeError> cls2 = BridgeError.class;
        Intrinsics.checkNotNullExpressionValue("BridgeError", "BridgeError::class.java.simpleName");
        reject(new AdaptyBridgeResult(unexpectedError, "BridgeError"));
    }

    public final void okOrForwardError(AdaptyError adaptyError) {
        if (adaptyError == null) {
            resovle();
        } else {
            forwardError(adaptyError);
        }
    }
}
