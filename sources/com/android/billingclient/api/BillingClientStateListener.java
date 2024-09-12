package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public interface BillingClientStateListener {
    void onBillingServiceDisconnected();

    void onBillingSetupFinished(BillingResult billingResult);
}