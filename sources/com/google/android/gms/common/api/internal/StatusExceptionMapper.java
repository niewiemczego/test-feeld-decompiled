package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
public interface StatusExceptionMapper {
    Exception getException(Status status);
}