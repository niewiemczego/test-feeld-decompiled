package com.google.firebase.auth.internal;

import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzad extends FirebaseAuth {
    public zzad(FirebaseApp firebaseApp, Provider<InteropAppCheckTokenProvider> provider, Provider<HeartBeatController> provider2, Executor executor, Executor executor2, Executor executor3, ScheduledExecutorService scheduledExecutorService, Executor executor4) {
        super(firebaseApp, provider, provider2, executor, executor2, executor3, scheduledExecutorService, executor4);
    }
}
