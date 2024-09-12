package com.adapty.errors;

import com.google.android.exoplayer2.PlaybackException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b!\b\u0001\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001#B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006$"}, d2 = {"Lcom/adapty/errors/AdaptyErrorCode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue$adapty_release", "()I", "UNKNOWN", "USER_CANCELED", "ITEM_UNAVAILABLE", "ADAPTY_NOT_INITIALIZED", "PRODUCT_NOT_FOUND", "INVALID_JSON", "CURRENT_SUBSCRIPTION_TO_UPDATE_NOT_FOUND_IN_HISTORY", "PENDING_PURCHASE", "BILLING_SERVICE_TIMEOUT", "FEATURE_NOT_SUPPORTED", "BILLING_SERVICE_DISCONNECTED", "BILLING_SERVICE_UNAVAILABLE", "BILLING_UNAVAILABLE", "DEVELOPER_ERROR", "BILLING_ERROR", "ITEM_ALREADY_OWNED", "ITEM_NOT_OWNED", "BILLING_NETWORK_ERROR", "NO_PRODUCT_IDS_FOUND", "NO_PURCHASES_TO_RESTORE", "AUTHENTICATION_ERROR", "BAD_REQUEST", "SERVER_ERROR", "REQUEST_FAILED", "DECODING_FAILED", "ANALYTICS_DISABLED", "WRONG_PARAMETER", "UNSUPPORTED_DATA", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyErrorCode.kt */
public enum AdaptyErrorCode {
    UNKNOWN(0),
    USER_CANCELED(2),
    ITEM_UNAVAILABLE(5),
    ADAPTY_NOT_INITIALIZED(20),
    PRODUCT_NOT_FOUND(22),
    INVALID_JSON(23),
    CURRENT_SUBSCRIPTION_TO_UPDATE_NOT_FOUND_IN_HISTORY(24),
    PENDING_PURCHASE(25),
    BILLING_SERVICE_TIMEOUT(97),
    FEATURE_NOT_SUPPORTED(98),
    BILLING_SERVICE_DISCONNECTED(99),
    BILLING_SERVICE_UNAVAILABLE(102),
    BILLING_UNAVAILABLE(103),
    DEVELOPER_ERROR(105),
    BILLING_ERROR(106),
    ITEM_ALREADY_OWNED(107),
    ITEM_NOT_OWNED(108),
    BILLING_NETWORK_ERROR(112),
    NO_PRODUCT_IDS_FOUND(1000),
    NO_PURCHASES_TO_RESTORE(1004),
    AUTHENTICATION_ERROR(PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT),
    BAD_REQUEST(PlaybackException.ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE),
    SERVER_ERROR(PlaybackException.ERROR_CODE_IO_BAD_HTTP_STATUS),
    REQUEST_FAILED(PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND),
    DECODING_FAILED(PlaybackException.ERROR_CODE_IO_NO_PERMISSION),
    ANALYTICS_DISABLED(3000),
    WRONG_PARAMETER(3001),
    UNSUPPORTED_DATA(3007);
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final List<AdaptyErrorCode> billingErrors = null;
    private final int value;

    private AdaptyErrorCode(int i) {
        this.value = i;
    }

    static {
        AdaptyErrorCode adaptyErrorCode;
        AdaptyErrorCode adaptyErrorCode2;
        AdaptyErrorCode adaptyErrorCode3;
        AdaptyErrorCode adaptyErrorCode4;
        AdaptyErrorCode adaptyErrorCode5;
        AdaptyErrorCode adaptyErrorCode6;
        AdaptyErrorCode adaptyErrorCode7;
        AdaptyErrorCode adaptyErrorCode8;
        AdaptyErrorCode adaptyErrorCode9;
        AdaptyErrorCode adaptyErrorCode10;
        AdaptyErrorCode adaptyErrorCode11;
        AdaptyErrorCode adaptyErrorCode12;
        Companion = new Companion((DefaultConstructorMarker) null);
        billingErrors = CollectionsKt.listOf(adaptyErrorCode3, adaptyErrorCode4, adaptyErrorCode5, adaptyErrorCode, adaptyErrorCode6, adaptyErrorCode7, adaptyErrorCode2, adaptyErrorCode8, adaptyErrorCode9, adaptyErrorCode10, adaptyErrorCode11, adaptyErrorCode12);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\bH\u0000¢\u0006\u0002\b\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/adapty/errors/AdaptyErrorCode$Companion;", "", "()V", "billingErrors", "", "Lcom/adapty/errors/AdaptyErrorCode;", "fromBilling", "value", "", "fromBilling$adapty_release", "fromNetwork", "responseCode", "fromNetwork$adapty_release", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyErrorCode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ AdaptyErrorCode fromNetwork$adapty_release(int i) {
            boolean z = false;
            if (i == 429 || (500 <= i && i < 600)) {
                return AdaptyErrorCode.SERVER_ERROR;
            }
            if (i == 401 || i == 403) {
                return AdaptyErrorCode.AUTHENTICATION_ERROR;
            }
            if (400 <= i && i < 500) {
                z = true;
            }
            if (z) {
                return AdaptyErrorCode.BAD_REQUEST;
            }
            return AdaptyErrorCode.REQUEST_FAILED;
        }

        public final /* synthetic */ AdaptyErrorCode fromBilling$adapty_release(int i) {
            Object obj;
            boolean z;
            if (i == 1) {
                return AdaptyErrorCode.USER_CANCELED;
            }
            if (i == 4) {
                return AdaptyErrorCode.ITEM_UNAVAILABLE;
            }
            int i2 = i + 100;
            Iterator it = AdaptyErrorCode.billingErrors.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((AdaptyErrorCode) obj).getValue$adapty_release() == i2) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            AdaptyErrorCode adaptyErrorCode = (AdaptyErrorCode) obj;
            if (adaptyErrorCode == null) {
                return AdaptyErrorCode.BILLING_ERROR;
            }
            return adaptyErrorCode;
        }
    }
}
