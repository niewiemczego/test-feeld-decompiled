package com.adapty.utils;

import com.adapty.errors.AdaptyError;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/adapty/utils/ErrorCallback;", "Lcom/adapty/utils/Callback;", "Lcom/adapty/errors/AdaptyError;", "onResult", "", "result", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Callback.kt */
public interface ErrorCallback extends Callback<AdaptyError> {
    void onResult(AdaptyError adaptyError);
}
