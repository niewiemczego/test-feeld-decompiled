package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public interface AuthResult extends SafeParcelable {
    AdditionalUserInfo getAdditionalUserInfo();

    AuthCredential getCredential();

    FirebaseUser getUser();
}
