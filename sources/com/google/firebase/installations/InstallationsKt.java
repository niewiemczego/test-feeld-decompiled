package com.google.firebase.installations;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import io.sentry.protocol.App;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"installations", "Lcom/google/firebase/installations/FirebaseInstallations;", "Lcom/google/firebase/Firebase;", "getInstallations", "(Lcom/google/firebase/Firebase;)Lcom/google/firebase/installations/FirebaseInstallations;", "app", "Lcom/google/firebase/FirebaseApp;", "com.google.firebase-firebase-installations"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Installations.kt */
public final class InstallationsKt {
    public static final FirebaseInstallations getInstallations(Firebase firebase) {
        Intrinsics.checkNotNullParameter(firebase, "<this>");
        FirebaseInstallations instance = FirebaseInstallations.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    public static final FirebaseInstallations installations(Firebase firebase, FirebaseApp firebaseApp) {
        Intrinsics.checkNotNullParameter(firebase, "<this>");
        Intrinsics.checkNotNullParameter(firebaseApp, App.TYPE);
        FirebaseInstallations instance = FirebaseInstallations.getInstance(firebaseApp);
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(app)");
        return instance;
    }
}
