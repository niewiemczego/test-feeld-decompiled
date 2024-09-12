package com.google.firebase.auth;

import android.net.Uri;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public interface UserInfo {
    String getDisplayName();

    String getEmail();

    String getPhoneNumber();

    Uri getPhotoUrl();

    String getProviderId();

    String getUid();

    boolean isEmailVerified();
}
