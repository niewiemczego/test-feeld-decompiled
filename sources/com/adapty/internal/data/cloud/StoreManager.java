package com.adapty.internal.data.cloud;

import android.app.Activity;
import android.content.Context;
import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.adapty.internal.data.cloud.AnalyticsTracker;
import com.adapty.internal.data.models.AnalyticsEvent;
import com.adapty.internal.data.models.PurchaseRecordModel;
import com.adapty.internal.domain.models.ProductType;
import com.adapty.internal.domain.models.PurchaseableProduct;
import com.adapty.internal.utils.Logger;
import com.adapty.internal.utils.Logger$log$1;
import com.adapty.internal.utils.ReplacementModeMapper;
import com.adapty.models.AdaptySubscriptionUpdateParameters;
import com.adapty.utils.AdaptyLogLevel;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u001a2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cJ \u0010\u001d\u001a\u00020\u001e2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0002J \u0010#\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002J0\u0010)\u001a\b\u0012\u0004\u0012\u0002H*0 \"\u0004\b\u0000\u0010*2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H*0 2\f\u0010,\u001a\b\u0012\u0004\u0012\u0002H*0 H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002J\u001e\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u001a2\u0006\u00101\u001a\u00020.2\u0006\u0010/\u001a\u00020.J\u001a\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030 0\u001a2\u0006\u0010(\u001a\u00020'J$\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030 0\u001a2\u0006\u0010/\u001a\u00020.2\u0006\u0010(\u001a\u00020'H\u0002J\u000e\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0\u001aJ`\u00106\u001a\u00020\u00132\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"2>\u0010:\u001a:\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\fj\u0002`\u0014J(\u0010;\u001a\b\u0012\u0004\u0012\u0002H*0\u001a\"\u0004\b\u0000\u0010*2\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H*0\u001a0=H\u0002JT\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u00020@2B\u0010:\u001a>\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\fj\u0004\u0018\u0001`\u0014H\u0002JT\u0010>\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020%2B\u0010:\u001a>\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\fj\u0004\u0018\u0001`\u0014H\u0002J \u0010A\u001a\u00020\u00132\u0006\u0010?\u001a\u00020@2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010CH\u0016J$\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0 0\u001a2\u0006\u0010/\u001a\u00020.2\u0006\u0010(\u001a\u00020'H\u0002J\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u001a2\u0006\u00101\u001a\u00020.2\u0006\u0010/\u001a\u00020.J(\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0 0\u001a2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020.0 2\u0006\u0010(\u001a\u00020'J2\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0 0\u001a2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020.0 2\u0006\u0010J\u001a\u00020.2\u0006\u0010(\u001a\u00020'H\u0002J\u000e\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00130\u001aH\u0002J(\u0010L\u001a\b\u0012\u0004\u0012\u0002H*0\u001a\"\u0004\b\u0000\u0010**\b\u0012\u0004\u0012\u0002H*0\u001a2\b\b\u0002\u0010(\u001a\u00020'H\u0002J\u0015\u0010M\u001a\u00020\u0013*\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010NR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000RJ\u0010\u000b\u001a>\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\fj\u0004\u0018\u0001`\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006O"}, d2 = {"Lcom/adapty/internal/data/cloud/StoreManager;", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "context", "Landroid/content/Context;", "replacementModeMapper", "Lcom/adapty/internal/utils/ReplacementModeMapper;", "analyticsTracker", "Lcom/adapty/internal/data/cloud/AnalyticsTracker;", "(Landroid/content/Context;Lcom/adapty/internal/utils/ReplacementModeMapper;Lcom/adapty/internal/data/cloud/AnalyticsTracker;)V", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "makePurchaseCallback", "Lkotlin/Function2;", "Lcom/android/billingclient/api/Purchase;", "Lkotlin/ParameterName;", "name", "purchase", "Lcom/adapty/errors/AdaptyError;", "error", "", "Lcom/adapty/internal/data/cloud/MakePurchaseCallback;", "startConnectionSemaphore", "Lkotlinx/coroutines/sync/Semaphore;", "storeHelper", "Lcom/adapty/internal/data/cloud/StoreHelper;", "acknowledgeOrConsume", "Lkotlinx/coroutines/flow/Flow;", "product", "Lcom/adapty/internal/domain/models/PurchaseableProduct;", "buildSubscriptionUpdateParams", "Lcom/android/billingclient/api/BillingFlowParams$SubscriptionUpdateParams;", "purchasesList", "", "subscriptionUpdateParams", "Lcom/adapty/models/AdaptySubscriptionUpdateParameters;", "canRetry", "", "", "attempt", "", "maxAttemptCount", "concatResults", "T", "list1", "list2", "extractGoogleType", "", "type", "findActivePurchaseForProduct", "productId", "getPurchaseHistoryDataToRestore", "Lcom/adapty/internal/data/models/PurchaseRecordModel;", "getPurchaseHistoryDataToRestoreForType", "getStoreCountry", "makePurchase", "activity", "Landroid/app/Activity;", "purchaseableProduct", "callback", "onConnected", "call", "Lkotlin/Function0;", "onError", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "onPurchasesUpdated", "purchases", "", "queryActivePurchasesForType", "queryInfoForProduct", "Lcom/android/billingclient/api/ProductDetails;", "queryProductDetails", "productList", "queryProductDetailsForType", "productType", "restoreConnection", "retryOnConnectionError", "startConnectionSync", "(Lcom/android/billingclient/api/BillingClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: StoreManager.kt */
public final class StoreManager implements PurchasesUpdatedListener {
    /* access modifiers changed from: private */
    public final AnalyticsTracker analyticsTracker;
    /* access modifiers changed from: private */
    public final BillingClient billingClient;
    /* access modifiers changed from: private */
    public Function2<? super Purchase, ? super AdaptyError, Unit> makePurchaseCallback;
    private final ReplacementModeMapper replacementModeMapper;
    /* access modifiers changed from: private */
    public final Semaphore startConnectionSemaphore = SemaphoreKt.Semaphore$default(1, 0, 2, (Object) null);
    /* access modifiers changed from: private */
    public final StoreHelper storeHelper;

    public StoreManager(Context context, ReplacementModeMapper replacementModeMapper2, AnalyticsTracker analyticsTracker2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(replacementModeMapper2, "replacementModeMapper");
        Intrinsics.checkNotNullParameter(analyticsTracker2, "analyticsTracker");
        this.replacementModeMapper = replacementModeMapper2;
        this.analyticsTracker = analyticsTracker2;
        BillingClient build = BillingClient.newBuilder(context).enablePendingPurchases().setListener(this).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder(context)\n    …er(this)\n        .build()");
        this.billingClient = build;
        this.storeHelper = new StoreHelper(build, analyticsTracker2);
    }

    public final /* synthetic */ Flow getPurchaseHistoryDataToRestore(long j) {
        return FlowKt.flatMapConcat(getPurchaseHistoryDataToRestoreForType("subs", j), new StoreManager$getPurchaseHistoryDataToRestore$1(this, j, (Continuation<? super StoreManager$getPurchaseHistoryDataToRestore$1>) null));
    }

    /* access modifiers changed from: private */
    public final Flow<List<PurchaseRecordModel>> getPurchaseHistoryDataToRestoreForType(String str, long j) {
        return retryOnConnectionError(onConnected(new StoreManager$getPurchaseHistoryDataToRestoreForType$1(this, str)), j);
    }

    public final /* synthetic */ Flow queryProductDetails(List list, long j) {
        Intrinsics.checkNotNullParameter(list, "productList");
        return FlowKt.flatMapConcat(queryProductDetailsForType(list, "subs", j), new StoreManager$queryProductDetails$1(this, list, j, (Continuation<? super StoreManager$queryProductDetails$1>) null));
    }

    /* access modifiers changed from: private */
    public final Flow<List<ProductDetails>> queryProductDetailsForType(List<String> list, String str, long j) {
        return retryOnConnectionError(onConnected(new StoreManager$queryProductDetailsForType$1(this, list, str)), j);
    }

    /* access modifiers changed from: private */
    public final <T> List<T> concatResults(List<? extends T> list, List<? extends T> list2) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.addAll(list2);
        return arrayList;
    }

    private final void onError(BillingResult billingResult, Function2<? super Purchase, ? super AdaptyError, Unit> function2) {
        String errorMessageFromBillingResult = this.storeHelper.errorMessageFromBillingResult(billingResult, "on purchases updated");
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.ERROR;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, errorMessageFromBillingResult));
        }
        if (function2 != null) {
            function2.invoke(null, new AdaptyError((Throwable) null, errorMessageFromBillingResult, AdaptyErrorCode.Companion.fromBilling$adapty_release(billingResult.getResponseCode()), 1, (DefaultConstructorMarker) null));
        }
    }

    /* access modifiers changed from: private */
    public final void onError(Throwable th, Function2<? super Purchase, ? super AdaptyError, Unit> function2) {
        String message = th.getMessage();
        if (message == null) {
            message = th.getLocalizedMessage();
        }
        if (message == null) {
            message = "Unknown billing error occured";
        }
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.ERROR;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, message));
        }
        if (function2 != null) {
            AdaptyError adaptyError = th instanceof AdaptyError ? (AdaptyError) th : null;
            if (adaptyError == null) {
                adaptyError = new AdaptyError(th, message, AdaptyErrorCode.UNKNOWN);
            }
            function2.invoke(null, adaptyError);
        }
    }

    public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        int responseCode = billingResult.getResponseCode();
        if (responseCode != 0) {
            if (responseCode != 1) {
                onError(billingResult, this.makePurchaseCallback);
                return;
            }
            Function2<? super Purchase, ? super AdaptyError, Unit> function2 = this.makePurchaseCallback;
            if (function2 != null) {
                function2.invoke(null, new AdaptyError((Throwable) null, "Purchase: USER_CANCELED", AdaptyErrorCode.USER_CANCELED, 1, (DefaultConstructorMarker) null));
            }
        } else if (list == null) {
            Function2<? super Purchase, ? super AdaptyError, Unit> function22 = this.makePurchaseCallback;
            if (function22 != null) {
                function22.invoke(null, null);
            }
        } else {
            for (Purchase next : list) {
                if (next.getPurchaseState() == 1) {
                    Function2<? super Purchase, ? super AdaptyError, Unit> function23 = this.makePurchaseCallback;
                    if (function23 != null) {
                        function23.invoke(next, null);
                    }
                } else {
                    Function2<? super Purchase, ? super AdaptyError, Unit> function24 = this.makePurchaseCallback;
                    if (function24 != null) {
                        function24.invoke(next, new AdaptyError((Throwable) null, "Purchase: PENDING_PURCHASE", AdaptyErrorCode.PENDING_PURCHASE, 1, (DefaultConstructorMarker) null));
                    }
                }
            }
        }
    }

    public final /* synthetic */ Flow queryInfoForProduct(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "productId");
        Intrinsics.checkNotNullParameter(str2, "type");
        return new StoreManager$queryInfoForProduct$$inlined$map$1(onConnected(new StoreManager$queryInfoForProduct$1(this, str, str2)), str);
    }

    public final /* synthetic */ void makePurchase(Activity activity, PurchaseableProduct purchaseableProduct, AdaptySubscriptionUpdateParameters adaptySubscriptionUpdateParameters, Function2 function2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(purchaseableProduct, "purchaseableProduct");
        Intrinsics.checkNotNullParameter(function2, "callback");
        AnalyticsEvent.GoogleAPIRequestData.MakePurchase create = AnalyticsEvent.GoogleAPIRequestData.MakePurchase.Companion.create(purchaseableProduct, adaptySubscriptionUpdateParameters);
        AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.analyticsTracker, create, (Function2) null, 2, (Object) null);
        Job unused = Intrinsics.checkNotNullParameter(new StoreManager$makePurchase$1(adaptySubscriptionUpdateParameters, this, purchaseableProduct, create, function2, activity, (Continuation<? super StoreManager$makePurchase$1>) null), "block");
    }

    /* access modifiers changed from: private */
    public final BillingFlowParams.SubscriptionUpdateParams buildSubscriptionUpdateParams(List<? extends Purchase> list, AdaptySubscriptionUpdateParameters adaptySubscriptionUpdateParameters) {
        Object obj;
        BillingFlowParams.SubscriptionUpdateParams subscriptionUpdateParams = null;
        if (list != null) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                List<String> products = ((Purchase) obj).getProducts();
                Intrinsics.checkNotNullExpressionValue(products, "it.products");
                if (Intrinsics.areEqual(CollectionsKt.firstOrNull(products), (Object) adaptySubscriptionUpdateParameters.getOldSubVendorProductId())) {
                    break;
                }
            }
            Purchase purchase = (Purchase) obj;
            if (purchase != null) {
                subscriptionUpdateParams = BillingFlowParams.SubscriptionUpdateParams.newBuilder().setOldPurchaseToken(purchase.getPurchaseToken()).setSubscriptionReplacementMode(this.replacementModeMapper.map(adaptySubscriptionUpdateParameters.getReplacementMode())).build();
            }
        }
        if (subscriptionUpdateParams != null) {
            return subscriptionUpdateParams;
        }
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.ERROR;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "Can't launch flow to change subscription. Either subscription to change is inactive, or it was purchased from different Google account or from iOS"));
        }
        throw new AdaptyError((Throwable) null, "Can't launch flow to change subscription. Either subscription to change is inactive, or it was purchased from different Google account or from iOS", AdaptyErrorCode.CURRENT_SUBSCRIPTION_TO_UPDATE_NOT_FOUND_IN_HISTORY, 1, (DefaultConstructorMarker) null);
    }

    public final /* synthetic */ Flow acknowledgeOrConsume(Purchase purchase, PurchaseableProduct purchaseableProduct) {
        Intrinsics.checkNotNullParameter(purchase, FirebaseAnalytics.Event.PURCHASE);
        Intrinsics.checkNotNullParameter(purchaseableProduct, "product");
        return Intrinsics.checkNotNullParameter(retryOnConnectionError(onConnected(new StoreManager$acknowledgeOrConsume$1(purchaseableProduct, this, purchase)), 3), "<this>");
    }

    public final /* synthetic */ Flow getStoreCountry() {
        return Intrinsics.checkNotNullParameter(new StoreManager$getStoreCountry$$inlined$map$1(FlowKt.m2547catch(onConnected(new StoreManager$getStoreCountry$1(this)), new StoreManager$getStoreCountry$2((Continuation<? super StoreManager$getStoreCountry$2>) null))), "<this>");
    }

    public final /* synthetic */ Flow findActivePurchaseForProduct(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "productId");
        Intrinsics.checkNotNullParameter(str2, "type");
        return new StoreManager$findActivePurchaseForProduct$$inlined$map$1(queryActivePurchasesForType(extractGoogleType(str2), 3), str);
    }

    private final Flow<List<Purchase>> queryActivePurchasesForType(String str, long j) {
        return Intrinsics.checkNotNullParameter(retryOnConnectionError(onConnected(new StoreManager$queryActivePurchasesForType$1(this, str)), j), "<this>");
    }

    /* access modifiers changed from: private */
    public final String extractGoogleType(String str) {
        return Intrinsics.areEqual((Object) str, (Object) ProductType.Subscription.Companion.getNAME()) ? "subs" : "inapp";
    }

    /* access modifiers changed from: private */
    public final <T> Flow<T> onConnected(Function0<? extends Flow<? extends T>> function0) {
        return FlowKt.transformLatest(restoreConnection(), new StoreManager$onConnected$$inlined$flatMapLatest$1((Continuation) null, function0));
    }

    private final Flow<Unit> restoreConnection() {
        return FlowKt.take(FlowKt.flow(new StoreManager$restoreConnection$1(this, (Continuation<? super StoreManager$restoreConnection$1>) null)), 1);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object startConnectionSync(com.android.billingclient.api.BillingClient r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.adapty.internal.data.cloud.StoreManager$startConnectionSync$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.adapty.internal.data.cloud.StoreManager$startConnectionSync$1 r0 = (com.adapty.internal.data.cloud.StoreManager$startConnectionSync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.adapty.internal.data.cloud.StoreManager$startConnectionSync$1 r0 = new com.adapty.internal.data.cloud.StoreManager$startConnectionSync$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0049
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r7 = r0.L$1
            com.android.billingclient.api.BillingClient r7 = (com.android.billingclient.api.BillingClient) r7
            java.lang.Object r7 = r0.L$0
            com.adapty.internal.data.cloud.StoreManager r7 = (com.adapty.internal.data.cloud.StoreManager) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0090
        L_0x0035:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003d:
            java.lang.Object r7 = r0.L$1
            com.android.billingclient.api.BillingClient r7 = (com.android.billingclient.api.BillingClient) r7
            java.lang.Object r2 = r0.L$0
            com.adapty.internal.data.cloud.StoreManager r2 = (com.adapty.internal.data.cloud.StoreManager) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005c
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.sync.Semaphore r8 = r6.startConnectionSemaphore
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r8.acquire(r0)
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r2 = r6
        L_0x005c:
            r0.L$0 = r2
            r0.L$1 = r7
            r0.label = r3
            kotlinx.coroutines.CancellableContinuationImpl r8 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r8.<init>(r3, r4)
            r8.initCancellability()
            r3 = r8
            kotlinx.coroutines.CancellableContinuation r3 = (kotlinx.coroutines.CancellableContinuation) r3
            kotlin.jvm.internal.Ref$BooleanRef r4 = new kotlin.jvm.internal.Ref$BooleanRef
            r4.<init>()
            com.adapty.internal.data.cloud.StoreManager$startConnectionSync$2$1 r5 = new com.adapty.internal.data.cloud.StoreManager$startConnectionSync$2$1
            r5.<init>(r4, r3, r2)
            com.android.billingclient.api.BillingClientStateListener r5 = (com.android.billingclient.api.BillingClientStateListener) r5
            r7.startConnection(r5)
            java.lang.Object r7 = r8.getResult()
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r7 != r8) goto L_0x008d
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x008d:
            if (r7 != r1) goto L_0x0090
            return r1
        L_0x0090:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cloud.StoreManager.startConnectionSync(com.android.billingclient.api.BillingClient, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Flow retryOnConnectionError$default(StoreManager storeManager, Flow flow, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = -1;
        }
        return storeManager.retryOnConnectionError(flow, j);
    }

    private final <T> Flow<T> retryOnConnectionError(Flow<? extends T> flow, long j) {
        return FlowKt.retryWhen(flow, new StoreManager$retryOnConnectionError$1(this, j, (Continuation<? super StoreManager$retryOnConnectionError$1>) null));
    }

    /* access modifiers changed from: private */
    public final boolean canRetry(Throwable th, long j, long j2) {
        if (!(0 <= j2 && j2 <= j)) {
            if (!(th instanceof AdaptyError)) {
                return true;
            }
            AdaptyError adaptyError = (AdaptyError) th;
            if (adaptyError.getOriginalError() instanceof IOException) {
                return true;
            }
            if (ArraysKt.contains((T[]) new AdaptyErrorCode[]{AdaptyErrorCode.BILLING_SERVICE_DISCONNECTED, AdaptyErrorCode.BILLING_SERVICE_UNAVAILABLE, AdaptyErrorCode.BILLING_NETWORK_ERROR}, adaptyError.getAdaptyErrorCode())) {
                return true;
            }
            if (adaptyError.getAdaptyErrorCode() == AdaptyErrorCode.BILLING_ERROR) {
                Long valueOf = Long.valueOf(j2);
                long longValue = valueOf.longValue();
                if (!(0 <= longValue && longValue < 4)) {
                    valueOf = null;
                }
                if ((valueOf != null ? valueOf.longValue() : 3) > j) {
                    return true;
                }
            }
        }
        return false;
    }
}
