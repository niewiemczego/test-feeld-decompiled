package com.adapty.internal.utils;

import com.appsflyer.AppsFlyerProperties;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u000b*\u00020\u0005H\u0002R2\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00078BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005`\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/adapty/internal/utils/CurrencyHelper;", "", "()V", "currencyLocaleMap", "Ljava/util/HashMap;", "Ljava/util/Currency;", "Ljava/util/Locale;", "Lkotlin/collections/HashMap;", "getCurrencyLocaleMap", "()Ljava/util/HashMap;", "currencyMap", "", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "fillCurrencyLocaleMap", "", "getCurrencySymbol", "currencyCode", "getOnlySymbol", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CurrencyHelper.kt */
public final class CurrencyHelper {
    private HashMap<Currency, Locale> currencyLocaleMap = new HashMap<>();
    private final HashMap<String, Currency> currencyMap = new HashMap<>();
    /* access modifiers changed from: private */
    public final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public CurrencyHelper() {
        fillCurrencyLocaleMap();
    }

    /* access modifiers changed from: private */
    public final HashMap<Currency, Locale> getCurrencyLocaleMap() {
        try {
            this.lock.readLock().lock();
            return this.currencyLocaleMap;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public final /* synthetic */ String getCurrencySymbol(String str) {
        Intrinsics.checkNotNullParameter(str, AppsFlyerProperties.CURRENCY_CODE);
        Map map = this.currencyMap;
        Object obj = map.get(str);
        if (obj == null) {
            obj = Currency.getInstance(str);
            Intrinsics.checkNotNullExpressionValue(obj, "getInstance(currencyCode)");
            map.put(str, obj);
        }
        String onlySymbol = getOnlySymbol((Currency) obj);
        return onlySymbol == null ? str : onlySymbol;
    }

    private final String getOnlySymbol(Currency currency) {
        String ch;
        Character ch2 = null;
        if (!getCurrencyLocaleMap().containsKey(currency)) {
            return null;
        }
        String symbol = currency.getSymbol(getCurrencyLocaleMap().get(currency));
        Intrinsics.checkNotNullExpressionValue(symbol, "rawSign");
        CharSequence charSequence = symbol;
        int i = 0;
        while (true) {
            if (i >= charSequence.length()) {
                break;
            }
            char charAt = charSequence.charAt(i);
            CharRange charRange = new CharRange('A', 'Z');
            if (!(charAt <= charRange.getLast() && charRange.getFirst() <= charAt)) {
                ch2 = Character.valueOf(charAt);
                break;
            }
            i++;
        }
        return (ch2 == null || (ch = ch2.toString()) == null) ? symbol : ch;
    }

    private final void fillCurrencyLocaleMap() {
        ThreadsKt.thread$default(false, false, (ClassLoader) null, (String) null, 0, new CurrencyHelper$fillCurrencyLocaleMap$1(this), 31, (Object) null);
    }
}
