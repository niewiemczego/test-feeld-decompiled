package com.adapty.internal.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.AuthInteractor", f = "AuthInteractor.kt", i = {0}, l = {42}, m = "createProfileIfNeeded", n = {"this"}, s = {"L$0"})
/* compiled from: AuthInteractor.kt */
final class AuthInteractor$createProfileIfNeeded$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthInteractor$createProfileIfNeeded$1(AuthInteractor authInteractor, Continuation<? super AuthInteractor$createProfileIfNeeded$1> continuation) {
        super(continuation);
        this.this$0 = authInteractor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createProfileIfNeeded(this);
    }
}
