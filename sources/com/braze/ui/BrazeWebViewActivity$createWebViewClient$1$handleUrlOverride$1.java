package com.braze.ui;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeWebViewActivity.kt */
final class BrazeWebViewActivity$createWebViewClient$1$handleUrlOverride$1 extends Lambda implements Function0<String> {
    final /* synthetic */ String $url;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrazeWebViewActivity$createWebViewClient$1$handleUrlOverride$1(String str) {
        super(0);
        this.$url = str;
    }

    public final String invoke() {
        return "Unexpected exception while processing url " + this.$url + ". Passing url back to WebView.";
    }
}