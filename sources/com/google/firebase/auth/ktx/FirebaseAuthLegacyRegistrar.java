package com.google.firebase.auth.ktx;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/auth/ktx/FirebaseAuthLegacyRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "()V", "getComponents", "", "Lcom/google/firebase/components/Component;", "java.com.google.android.libraries.firebase.firebase_auth_ktx_granule"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: com.google.firebase:firebase-auth-ktx@@22.3.1 */
public final class FirebaseAuthLegacyRegistrar implements ComponentRegistrar {
    public final List<Component<?>> getComponents() {
        return CollectionsKt.listOf(LibraryVersionComponent.create(LoggingKt.LIBRARY_NAME, BuildConfig.VERSION_NAME));
    }
}
