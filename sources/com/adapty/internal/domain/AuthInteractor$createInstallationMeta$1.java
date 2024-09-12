package com.adapty.internal.domain;

import com.adapty.internal.data.models.InstallationMeta;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "Lcom/adapty/internal/data/models/InstallationMeta;", "adId", "", "storeCountry", "appSetId"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.AuthInteractor$createInstallationMeta$1", f = "AuthInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AuthInteractor.kt */
final class AuthInteractor$createInstallationMeta$1 extends SuspendLambda implements Function4<String, String, String, Continuation<? super InstallationMeta>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;
    final /* synthetic */ AuthInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthInteractor$createInstallationMeta$1(AuthInteractor authInteractor, Continuation<? super AuthInteractor$createInstallationMeta$1> continuation) {
        super(4, continuation);
        this.this$0 = authInteractor;
    }

    public final Object invoke(String str, String str2, String str3, Continuation<? super InstallationMeta> continuation) {
        AuthInteractor$createInstallationMeta$1 authInteractor$createInstallationMeta$1 = new AuthInteractor$createInstallationMeta$1(this.this$0, continuation);
        authInteractor$createInstallationMeta$1.L$0 = str;
        authInteractor$createInstallationMeta$1.L$1 = str2;
        authInteractor$createInstallationMeta$1.L$2 = str3;
        return authInteractor$createInstallationMeta$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$2;
            return this.this$0.installationMetaCreator.create((String) this.L$0, str, (String) this.L$1);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
