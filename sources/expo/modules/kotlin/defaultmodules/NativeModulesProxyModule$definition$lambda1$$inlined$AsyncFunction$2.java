package expo.modules.kotlin.defaultmodules;

import com.facebook.react.bridge.ReadableArray;
import expo.modules.adapters.react.NativeModulesProxy;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.PromiseKt;
import expo.modules.kotlin.exception.UnexpectedException;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u0001\"\u0006\b\u0004\u0010\u0006\u0018\u00012\u0010\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\bH\n¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "P3", "it", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$15"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: expo.modules.kotlin.defaultmodules.NativeModulesProxyModule$definition$lambda-1$$inlined$AsyncFunction$2  reason: invalid class name */
/* compiled from: ObjectDefinitionBuilder.kt */
public final class NativeModulesProxyModule$definition$lambda1$$inlined$AsyncFunction$2 extends Lambda implements Function1<Object[], Object> {
    final /* synthetic */ NativeModulesProxyModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NativeModulesProxyModule$definition$lambda1$$inlined$AsyncFunction$2(NativeModulesProxyModule nativeModulesProxyModule) {
        super(1);
        this.this$0 = nativeModulesProxyModule;
    }

    public final Object invoke(Object[] objArr) {
        NativeModulesProxy nativeModulesProxy;
        Intrinsics.checkNotNullParameter(objArr, "it");
        String str = objArr[0];
        if (str != null) {
            String str2 = str;
            String str3 = objArr[1];
            if (str3 != null) {
                String str4 = str3;
                ReadableArray readableArray = objArr[2];
                if (readableArray != null) {
                    ReadableArray readableArray2 = readableArray;
                    Promise promise = objArr[3];
                    if (promise != null) {
                        com.facebook.react.bridge.Promise bridgePromise = PromiseKt.toBridgePromise(promise);
                        WeakReference<NativeModulesProxy> legacyModulesProxyHolder$expo_modules_core_release = this.this$0.getAppContext().getLegacyModulesProxyHolder$expo_modules_core_release();
                        if (legacyModulesProxyHolder$expo_modules_core_release == null || (nativeModulesProxy = (NativeModulesProxy) legacyModulesProxyHolder$expo_modules_core_release.get()) == null) {
                            throw new UnexpectedException("The legacy modules proxy holder has been lost");
                        }
                        Intrinsics.checkNotNullExpressionValue(nativeModulesProxy, "appContext.legacyModules…xy holder has been lost\")");
                        nativeModulesProxy.callMethod(str2, str4, readableArray2, bridgePromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.react.bridge.ReadableArray");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }
}
