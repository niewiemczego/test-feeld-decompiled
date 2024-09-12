package expo.modules.adapters.react;

import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import expo.modules.core.Promise;
import java.util.List;
import javax.annotation.Nullable;

class PromiseWrapper implements Promise {
    private com.facebook.react.bridge.Promise mPromise;

    PromiseWrapper(com.facebook.react.bridge.Promise promise) {
        this.mPromise = promise;
    }

    public void resolve(@Nullable Object obj) {
        if (obj instanceof Bundle) {
            this.mPromise.resolve(Arguments.fromBundle((Bundle) obj));
        } else if (obj instanceof List) {
            this.mPromise.resolve(Arguments.fromList((List) obj));
        } else {
            this.mPromise.resolve(obj);
        }
    }

    public void reject(String str, String str2, Throwable th) {
        this.mPromise.reject(str, str2, th);
    }
}
