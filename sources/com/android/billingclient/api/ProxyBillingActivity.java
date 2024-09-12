package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import com.google.android.gms.internal.play_billing.zzb;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public class ProxyBillingActivity extends ComponentActivity {
    static final String KEY_ALTERNATIVE_BILLING_ONLY_DIALOG_RESULT_RECEIVER = "alternative_billing_only_dialog_result_receiver";
    static final String KEY_IN_APP_MESSAGE_RESULT_RECEIVER = "in_app_message_result_receiver";
    static final String KEY_PRICE_CHANGE_RESULT_RECEIVER = "result_receiver";
    private static final String KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED = "send_cancelled_broadcast_if_finished";
    private static final int REQUEST_CODE_FIRST_PARTY_PURCHASE_FLOW = 110;
    private static final int REQUEST_CODE_IN_APP_MESSAGE_FLOW = 101;
    private static final int REQUEST_CODE_LAUNCH_ACTIVITY = 100;
    private static final String TAG = "ProxyBillingActivity";
    private ActivityResultLauncher<IntentSenderRequest> alternativeBillingOnlyDialogLauncher;
    private ResultReceiver alternativeBillingOnlyDialogResultReceiver;
    private ResultReceiver inAppMessageResultReceiver;
    private boolean isFlowFromFirstPartyClient;
    private ResultReceiver priceChangeResultReceiver;
    private boolean sendCancelledBroadcastIfFinished;

    private Intent makeAlternativeBillingIntent(String str) {
        Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", str);
        return intent;
    }

    private Intent makePurchasesUpdatedIntent() {
        getApplicationContext().getPackageName();
        Intent intent = new Intent("com.android.vending.billing.PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r9, int r10, android.content.Intent r11) {
        /*
            r8 = this;
            super.onActivityResult(r9, r10, r11)
            r0 = 0
            r1 = 0
            r2 = 110(0x6e, float:1.54E-43)
            java.lang.String r3 = "ProxyBillingActivity"
            r4 = 100
            if (r9 == r4) goto L_0x0043
            if (r9 != r2) goto L_0x0010
            goto L_0x0043
        L_0x0010:
            r10 = 101(0x65, float:1.42E-43)
            if (r9 != r10) goto L_0x0028
            int r9 = com.google.android.gms.internal.play_billing.zzb.zza(r11, r3)
            android.os.ResultReceiver r10 = r8.inAppMessageResultReceiver
            if (r10 == 0) goto L_0x00f2
            if (r11 != 0) goto L_0x001f
            goto L_0x0023
        L_0x001f:
            android.os.Bundle r0 = r11.getExtras()
        L_0x0023:
            r10.send(r9, r0)
            goto L_0x00f2
        L_0x0028:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Got onActivityResult with wrong requestCode: "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = "; skipping..."
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.google.android.gms.internal.play_billing.zzb.zzk(r3, r9)
            goto L_0x00f2
        L_0x0043:
            int r4 = com.google.android.gms.internal.play_billing.zzb.zzc(r11, r3)
            r5 = -1
            if (r10 != r5) goto L_0x0050
            if (r4 == 0) goto L_0x004e
            r10 = r5
            goto L_0x0050
        L_0x004e:
            r4 = r1
            goto L_0x006c
        L_0x0050:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Activity finished with resultCode "
            r5.append(r6)
            r5.append(r10)
            java.lang.String r10 = " and billing's responseCode: "
            r5.append(r10)
            r5.append(r4)
            java.lang.String r10 = r5.toString()
            com.google.android.gms.internal.play_billing.zzb.zzk(r3, r10)
        L_0x006c:
            android.os.ResultReceiver r10 = r8.priceChangeResultReceiver
            if (r10 == 0) goto L_0x007c
            if (r11 != 0) goto L_0x0073
            goto L_0x0077
        L_0x0073:
            android.os.Bundle r0 = r11.getExtras()
        L_0x0077:
            r10.send(r4, r0)
            goto L_0x00f2
        L_0x007c:
            if (r11 == 0) goto L_0x00e3
            android.os.Bundle r10 = r11.getExtras()
            java.lang.String r0 = "LAUNCH_BILLING_FLOW"
            java.lang.String r4 = "INTENT_SOURCE"
            if (r10 == 0) goto L_0x00ab
            android.os.Bundle r10 = r11.getExtras()
            java.lang.String r3 = "ALTERNATIVE_BILLING_USER_CHOICE_DATA"
            java.lang.String r10 = r10.getString(r3)
            if (r10 == 0) goto L_0x009c
            android.content.Intent r10 = r8.makeAlternativeBillingIntent(r10)
            r10.putExtra(r4, r0)
            goto L_0x00e7
        L_0x009c:
            android.content.Intent r10 = r8.makePurchasesUpdatedIntent()
            android.os.Bundle r11 = r11.getExtras()
            r10.putExtras(r11)
            r10.putExtra(r4, r0)
            goto L_0x00e7
        L_0x00ab:
            android.content.Intent r10 = r8.makePurchasesUpdatedIntent()
            java.lang.String r11 = "Got null bundle!"
            com.google.android.gms.internal.play_billing.zzb.zzk(r3, r11)
            java.lang.String r11 = "RESPONSE_CODE"
            r3 = 6
            r10.putExtra(r11, r3)
            java.lang.String r11 = "DEBUG_MESSAGE"
            java.lang.String r5 = "An internal error occurred."
            r10.putExtra(r11, r5)
            r11 = 22
            r6 = 2
            com.android.billingclient.api.BillingResult$Builder r7 = com.android.billingclient.api.BillingResult.newBuilder()
            r7.setResponseCode(r3)
            r7.setDebugMessage(r5)
            com.android.billingclient.api.BillingResult r3 = r7.build()
            com.google.android.gms.internal.play_billing.zzhy r11 = com.android.billingclient.api.zzbh.zza(r11, r6, r3)
            byte[] r11 = r11.zzc()
            java.lang.String r3 = "FAILURE_LOGGING_PAYLOAD"
            r10.putExtra(r3, r11)
            r10.putExtra(r4, r0)
            goto L_0x00e7
        L_0x00e3:
            android.content.Intent r10 = r8.makePurchasesUpdatedIntent()
        L_0x00e7:
            if (r9 != r2) goto L_0x00ef
            r9 = 1
            java.lang.String r11 = "IS_FIRST_PARTY_PURCHASE"
            r10.putExtra(r11, r9)
        L_0x00ef:
            r8.sendBroadcast(r10)
        L_0x00f2:
            r8.sendCancelledBroadcastIfFinished = r1
            r8.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.ProxyBillingActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    /* access modifiers changed from: package-private */
    public void onAlternativeBillingOnlyDialogResult(ActivityResult activityResult) {
        Bundle bundle;
        Intent data = activityResult.getData();
        int zzc = zzb.zzc(data, TAG);
        ResultReceiver resultReceiver = this.alternativeBillingOnlyDialogResultReceiver;
        if (resultReceiver != null) {
            if (data == null) {
                bundle = null;
            } else {
                bundle = data.getExtras();
            }
            resultReceiver.send(zzc, bundle);
        }
        if (!(activityResult.getResultCode() == -1 && zzc == 0)) {
            int resultCode = activityResult.getResultCode();
            zzb.zzk(TAG, "Alternative billing only dialog finished with resultCode " + resultCode + " and billing's responseCode: " + zzc);
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i;
        PendingIntent pendingIntent;
        int i2;
        super.onCreate(bundle);
        this.alternativeBillingOnlyDialogLauncher = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new zzcd(this));
        if (bundle == null) {
            zzb.zzj(TAG, "Launching Play Store billing flow");
            if (getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
                this.alternativeBillingOnlyDialogResultReceiver = (ResultReceiver) getIntent().getParcelableExtra(KEY_ALTERNATIVE_BILLING_ONLY_DIALOG_RESULT_RECEIVER);
                this.alternativeBillingOnlyDialogLauncher.launch(new IntentSenderRequest.Builder((PendingIntent) getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")).build());
                return;
            }
            if (getIntent().hasExtra("BUY_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
                if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                    this.isFlowFromFirstPartyClient = true;
                    i2 = 110;
                    i = i2;
                    this.sendCancelledBroadcastIfFinished = true;
                    startIntentSenderForResult(pendingIntent.getIntentSender(), i, new Intent(), 0, 0, 0);
                }
            } else if (getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
                this.priceChangeResultReceiver = (ResultReceiver) getIntent().getParcelableExtra(KEY_PRICE_CHANGE_RESULT_RECEIVER);
            } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
                this.inAppMessageResultReceiver = (ResultReceiver) getIntent().getParcelableExtra(KEY_IN_APP_MESSAGE_RESULT_RECEIVER);
                i2 = 101;
                i = i2;
                this.sendCancelledBroadcastIfFinished = true;
                startIntentSenderForResult(pendingIntent.getIntentSender(), i, new Intent(), 0, 0, 0);
            } else {
                i = 100;
                pendingIntent = null;
                this.sendCancelledBroadcastIfFinished = true;
                startIntentSenderForResult(pendingIntent.getIntentSender(), i, new Intent(), 0, 0, 0);
            }
            i = 100;
            try {
                this.sendCancelledBroadcastIfFinished = true;
                startIntentSenderForResult(pendingIntent.getIntentSender(), i, new Intent(), 0, 0, 0);
            } catch (IntentSender.SendIntentException e) {
                zzb.zzl(TAG, "Got exception while trying to start a purchase flow.", e);
                ResultReceiver resultReceiver = this.priceChangeResultReceiver;
                if (resultReceiver != null) {
                    resultReceiver.send(6, (Bundle) null);
                } else {
                    ResultReceiver resultReceiver2 = this.inAppMessageResultReceiver;
                    if (resultReceiver2 != null) {
                        resultReceiver2.send(0, (Bundle) null);
                    } else {
                        Intent makePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
                        if (this.isFlowFromFirstPartyClient) {
                            makePurchasesUpdatedIntent.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                        }
                        makePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 6);
                        makePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                        sendBroadcast(makePurchasesUpdatedIntent);
                    }
                }
                this.sendCancelledBroadcastIfFinished = false;
                finish();
            }
        } else {
            zzb.zzj(TAG, "Launching Play Store billing flow from savedInstanceState");
            this.sendCancelledBroadcastIfFinished = bundle.getBoolean(KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED, false);
            if (bundle.containsKey(KEY_PRICE_CHANGE_RESULT_RECEIVER)) {
                this.priceChangeResultReceiver = (ResultReceiver) bundle.getParcelable(KEY_PRICE_CHANGE_RESULT_RECEIVER);
            } else if (bundle.containsKey(KEY_IN_APP_MESSAGE_RESULT_RECEIVER)) {
                this.inAppMessageResultReceiver = (ResultReceiver) bundle.getParcelable(KEY_IN_APP_MESSAGE_RESULT_RECEIVER);
            } else if (bundle.containsKey(KEY_ALTERNATIVE_BILLING_ONLY_DIALOG_RESULT_RECEIVER)) {
                this.alternativeBillingOnlyDialogResultReceiver = (ResultReceiver) bundle.getParcelable(KEY_ALTERNATIVE_BILLING_ONLY_DIALOG_RESULT_RECEIVER);
            }
            this.isFlowFromFirstPartyClient = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.sendCancelledBroadcastIfFinished) {
            Intent makePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
            makePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 1);
            makePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            sendBroadcast(makePurchasesUpdatedIntent);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.priceChangeResultReceiver;
        if (resultReceiver != null) {
            bundle.putParcelable(KEY_PRICE_CHANGE_RESULT_RECEIVER, resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.inAppMessageResultReceiver;
        if (resultReceiver2 != null) {
            bundle.putParcelable(KEY_IN_APP_MESSAGE_RESULT_RECEIVER, resultReceiver2);
        }
        ResultReceiver resultReceiver3 = this.alternativeBillingOnlyDialogResultReceiver;
        if (resultReceiver3 != null) {
            bundle.putParcelable(KEY_ALTERNATIVE_BILLING_ONLY_DIALOG_RESULT_RECEIVER, resultReceiver3);
        }
        bundle.putBoolean(KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED, this.sendCancelledBroadcastIfFinished);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.isFlowFromFirstPartyClient);
    }
}
