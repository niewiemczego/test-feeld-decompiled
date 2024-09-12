package io.seon.androidsdk.service;

import android.content.Context;

public interface Seon {
    Context getContext();

    void getFingerprintBase64(SeonCallback seonCallback);

    String getSessionId();

    void setContext(Context context);

    void setLoggingEnabled(Boolean bool);

    void setSessionId(String str);

    String version();

    Seon withContext(Context context);

    Seon withSessionId(String str);
}
