package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzec extends IOException {
    zzec() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    zzec(String str, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th);
    }

    zzec(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
