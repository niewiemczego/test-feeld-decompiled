package io.seon.androidsdk.service;

import android.content.Context;
import android.util.Log;

public class SeonBuilder {
    private Context mContext;
    private String mSession_id;

    public Seon build() {
        String str;
        if (this.mContext == null || (str = this.mSession_id) == null || str.isEmpty()) {
            Log.e("SEON", "Seon object should be configured first with a context and a session_id!");
        }
        return new SeonImpl(this.mContext, this.mSession_id);
    }

    public SeonBuilder withContext(Context context) {
        this.mContext = context;
        return this;
    }

    public SeonBuilder withSessionId(String str) {
        this.mSession_id = str;
        return this;
    }
}
