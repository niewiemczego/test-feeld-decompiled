package expo.modules.kotlin;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J0\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"expo/modules/kotlin/PromiseKt$toBridgePromise$1", "Lcom/facebook/react/bridge/Promise;", "reject", "", "message", "", "code", "userInfo", "Lcom/facebook/react/bridge/WritableMap;", "throwable", "", "resolve", "value", "", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Promise.kt */
public final class PromiseKt$toBridgePromise$1 implements Promise {
    final /* synthetic */ Promise $expoPromise;
    final /* synthetic */ KFunction<Unit> $resolveMethod;

    PromiseKt$toBridgePromise$1(KFunction<Unit> kFunction, Promise promise) {
        this.$resolveMethod = kFunction;
        this.$expoPromise = promise;
    }

    public void resolve(Object obj) {
        ((Function1) this.$resolveMethod).invoke(obj);
    }

    public void reject(String str, String str2) {
        Promise promise = this.$expoPromise;
        if (str == null) {
            str = "UnknownCode";
        }
        promise.reject(str, str2, (Throwable) null);
    }

    public void reject(String str, Throwable th) {
        Promise promise = this.$expoPromise;
        if (str == null) {
            str = "UnknownCode";
        }
        promise.reject(str, (String) null, th);
    }

    public void reject(String str, String str2, Throwable th) {
        Promise promise = this.$expoPromise;
        if (str == null) {
            str = "UnknownCode";
        }
        promise.reject(str, str2, th);
    }

    public void reject(Throwable th) {
        this.$expoPromise.reject("UnknownCode", (String) null, th);
    }

    public void reject(Throwable th, WritableMap writableMap) {
        this.$expoPromise.reject("UnknownCode", (String) null, th);
    }

    public void reject(String str, WritableMap writableMap) {
        Intrinsics.checkNotNullParameter(writableMap, "userInfo");
        Promise promise = this.$expoPromise;
        if (str == null) {
            str = "UnknownCode";
        }
        promise.reject(str, (String) null, (Throwable) null);
    }

    public void reject(String str, Throwable th, WritableMap writableMap) {
        Promise promise = this.$expoPromise;
        if (str == null) {
            str = "UnknownCode";
        }
        promise.reject(str, (String) null, th);
    }

    public void reject(String str, String str2, WritableMap writableMap) {
        Intrinsics.checkNotNullParameter(writableMap, "userInfo");
        Promise promise = this.$expoPromise;
        if (str == null) {
            str = "UnknownCode";
        }
        promise.reject(str, str2, (Throwable) null);
    }

    public void reject(String str, String str2, Throwable th, WritableMap writableMap) {
        Promise promise = this.$expoPromise;
        if (str == null) {
            str = "UnknownCode";
        }
        promise.reject(str, str2, th);
    }

    public void reject(String str) {
        this.$expoPromise.reject("UnknownCode", str, (Throwable) null);
    }
}
