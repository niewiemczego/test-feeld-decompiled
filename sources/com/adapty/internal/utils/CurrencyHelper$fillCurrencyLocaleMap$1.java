package com.adapty.internal.utils;

import java.util.Currency;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CurrencyHelper.kt */
final class CurrencyHelper$fillCurrencyLocaleMap$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CurrencyHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CurrencyHelper$fillCurrencyLocaleMap$1(CurrencyHelper currencyHelper) {
        super(0);
        this.this$0 = currencyHelper;
    }

    public final void invoke() {
        try {
            this.this$0.lock.writeLock().lock();
            Locale[] availableLocales = Locale.getAvailableLocales();
            Intrinsics.checkNotNullExpressionValue(availableLocales, "getAvailableLocales()");
            CurrencyHelper currencyHelper = this.this$0;
            for (Object obj : (Object[]) availableLocales) {
                Locale locale = (Locale) obj;
                try {
                    Currency instance = Currency.getInstance(locale);
                    Intrinsics.checkNotNullExpressionValue(instance, "getInstance(locale)");
                    Intrinsics.checkNotNullExpressionValue(locale, "locale");
                    currencyHelper.getCurrencyLocaleMap().put(instance, locale);
                } catch (Exception unused) {
                }
            }
        } finally {
            this.this$0.lock.writeLock().unlock();
        }
    }
}
