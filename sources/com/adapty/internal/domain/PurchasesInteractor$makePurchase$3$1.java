package com.adapty.internal.domain;

import com.adapty.errors.AdaptyError;
import com.android.billingclient.api.Purchase;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "purchase", "Lcom/android/billingclient/api/Purchase;", "error", "Lcom/adapty/errors/AdaptyError;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PurchasesInteractor.kt */
final class PurchasesInteractor$makePurchase$3$1 extends Lambda implements Function2<Purchase, AdaptyError, Unit> {
    final /* synthetic */ CancellableContinuation<Purchase> $continuation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasesInteractor$makePurchase$3$1(CancellableContinuation<? super Purchase> cancellableContinuation) {
        super(2);
        this.$continuation = cancellableContinuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Purchase) obj, (AdaptyError) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(Purchase purchase, AdaptyError adaptyError) {
        if (adaptyError == null) {
            this.$continuation.resume(purchase, AnonymousClass1.INSTANCE);
            return;
        }
        Result.Companion companion = Result.Companion;
        this.$continuation.resumeWith(Result.m983constructorimpl(ResultKt.createFailure(adaptyError)));
    }
}
