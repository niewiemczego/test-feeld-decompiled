package com.appsflyer.internal;

import android.app.Activity;
import android.content.Context;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\bf\u0018\u0000 \u00012\u00020\r:\u0002\u0001\fJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0003\u0010\nJ\u0017\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0003\u0010\u000b"}, d2 = {"Lcom/appsflyer/internal/AFb1gSDK;", "AFa1ySDK", "", "AFKeystoreWrapper", "()Z", "Landroid/content/Context;", "p0", "Lcom/appsflyer/internal/AFb1gSDK$AFa1zSDK;", "p1", "", "(Landroid/content/Context;Lcom/appsflyer/internal/AFb1gSDK$AFa1zSDK;)V", "(Landroid/content/Context;)V", "AFa1zSDK", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AFb1gSDK {
    public static final AFa1ySDK AFa1ySDK = AFa1ySDK.values;

    public interface AFa1zSDK {
        void AFInAppEventType(Activity activity);

        void AFInAppEventType(Context context);
    }

    void AFKeystoreWrapper(Context context);

    void AFKeystoreWrapper(Context context, AFa1zSDK aFa1zSDK);

    boolean AFKeystoreWrapper();

    public static final class AFa1ySDK {
        private static long AFInAppEventType = 500;
        static final /* synthetic */ AFa1ySDK values = new AFa1ySDK();

        private AFa1ySDK() {
        }

        public static long AFInAppEventType() {
            return AFInAppEventType;
        }
    }
}
