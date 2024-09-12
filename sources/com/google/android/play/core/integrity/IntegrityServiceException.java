package com.google.android.play.core.integrity;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.play.core.integrity.model.a;
import java.util.Locale;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
public class IntegrityServiceException extends ApiException {
    private final Throwable a;

    IntegrityServiceException(int i, Throwable th) {
        super(new Status(i, String.format(Locale.ROOT, "Integrity API error (%d): %s.", new Object[]{Integer.valueOf(i), a.a(i)})));
        if (i != 0) {
            this.a = th;
            return;
        }
        throw new IllegalArgumentException("ErrorCode should not be 0.");
    }

    public final synchronized Throwable getCause() {
        return this.a;
    }

    public int getErrorCode() {
        return super.getStatusCode();
    }
}
