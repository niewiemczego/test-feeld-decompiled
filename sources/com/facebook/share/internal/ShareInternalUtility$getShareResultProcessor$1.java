package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.AppCall;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.Sharer;
import com.oblador.keychain.KeychainModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/facebook/share/internal/ShareInternalUtility$getShareResultProcessor$1", "Lcom/facebook/share/internal/ResultProcessor;", "onCancel", "", "appCall", "Lcom/facebook/internal/AppCall;", "onError", "error", "Lcom/facebook/FacebookException;", "onSuccess", "results", "Landroid/os/Bundle;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ShareInternalUtility.kt */
public final class ShareInternalUtility$getShareResultProcessor$1 extends ResultProcessor {
    final /* synthetic */ FacebookCallback<Sharer.Result> $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareInternalUtility$getShareResultProcessor$1(FacebookCallback<Sharer.Result> facebookCallback) {
        super(facebookCallback);
        this.$callback = facebookCallback;
    }

    public void onSuccess(AppCall appCall, Bundle bundle) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        if (bundle != null) {
            ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
            String nativeDialogCompletionGesture = ShareInternalUtility.getNativeDialogCompletionGesture(bundle);
            if (nativeDialogCompletionGesture == null || StringsKt.equals("post", nativeDialogCompletionGesture, true)) {
                ShareInternalUtility shareInternalUtility2 = ShareInternalUtility.INSTANCE;
                FacebookCallback<Sharer.Result> facebookCallback = this.$callback;
                ShareInternalUtility shareInternalUtility3 = ShareInternalUtility.INSTANCE;
                ShareInternalUtility.invokeOnSuccessCallback(facebookCallback, ShareInternalUtility.getShareDialogPostId(bundle));
            } else if (StringsKt.equals(KeychainModule.AuthPromptOptions.CANCEL, nativeDialogCompletionGesture, true)) {
                ShareInternalUtility shareInternalUtility4 = ShareInternalUtility.INSTANCE;
                ShareInternalUtility.invokeOnCancelCallback(this.$callback);
            } else {
                ShareInternalUtility shareInternalUtility5 = ShareInternalUtility.INSTANCE;
                ShareInternalUtility.invokeOnErrorCallback(this.$callback, new FacebookException(NativeProtocol.ERROR_UNKNOWN_ERROR));
            }
        }
    }

    public void onCancel(AppCall appCall) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        ShareInternalUtility.invokeOnCancelCallback(this.$callback);
    }

    public void onError(AppCall appCall, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(facebookException, "error");
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        ShareInternalUtility.invokeOnErrorCallback(this.$callback, facebookException);
    }
}
