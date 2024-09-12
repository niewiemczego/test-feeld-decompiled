package io.seon.androidsdk.service;

import android.content.Context;
import io.seon.androidsdk.logger.Logger;

final class SeonImpl implements Seon {
    private Context a;
    private SeonEncrypt b;
    private String c;
    private final SeonFingerprint d = new SeonFingerprint(this);
    private final Probes e;

    SeonImpl(Context context, String str) {
        this.a = context;
        this.c = str;
        this.b = new SeonEncrypt(context);
        Probes probes = new Probes(this);
        this.e = probes;
        probes.a();
    }

    /* access modifiers changed from: package-private */
    public SeonEncrypt a() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public Probes c() {
        return this.e;
    }

    public Context getContext() {
        return this.a;
    }

    public void getFingerprintBase64(SeonCallback seonCallback) {
        this.d.a(this.c, seonCallback);
    }

    public String getSessionId() {
        return this.c;
    }

    public void setContext(Context context) {
        this.a = context;
        this.e.a();
        this.b = new SeonEncrypt(this.a);
    }

    public void setLoggingEnabled(Boolean bool) {
        Logger.LOGGING_ENABLED = bool;
    }

    public void setSessionId(String str) {
        this.c = str.replaceAll("[^a-zA-Z0-9-._~]", "");
        this.e.a();
    }

    public String version() {
        return "android-6.0.2";
    }

    public Seon withContext(Context context) {
        setContext(context);
        return this;
    }

    public Seon withSessionId(String str) {
        setSessionId(str);
        return this;
    }
}
