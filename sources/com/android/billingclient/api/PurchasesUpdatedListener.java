package com.android.billingclient.api;

import java.util.List;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public interface PurchasesUpdatedListener {
    void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list);
}
