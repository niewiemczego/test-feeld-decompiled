package com.facebook.react.packagerconnection;

import com.facebook.common.logging.FLog;

public abstract class NotificationOnlyHandler implements RequestHandler {
    private static final String TAG = "JSPackagerClient";

    public abstract void onNotification(Object obj);

    static {
        Class<JSPackagerClient> cls = JSPackagerClient.class;
    }

    public final void onRequest(Object obj, Responder responder) {
        responder.error("Request is not supported");
        FLog.e(TAG, "Request is not supported");
    }
}
