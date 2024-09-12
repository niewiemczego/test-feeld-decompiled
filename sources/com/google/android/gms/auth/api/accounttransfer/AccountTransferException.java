package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public class AccountTransferException extends ApiException {
    public AccountTransferException(Status status) {
        super(status);
    }
}
