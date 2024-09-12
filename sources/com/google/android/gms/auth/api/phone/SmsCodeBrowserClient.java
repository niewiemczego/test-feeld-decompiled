package com.google.android.gms.auth.api.phone;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
public interface SmsCodeBrowserClient extends HasApiKey<Api.ApiOptions.NoOptions> {
    Task<Void> startSmsCodeRetriever();
}
