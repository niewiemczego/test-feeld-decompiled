package com.braze.ui.support;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: UriUtils.kt */
final class UriUtils$getQueryParameters$2 extends Lambda implements Function0<String> {
    final /* synthetic */ Ref.ObjectRef<Uri> $uri;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UriUtils$getQueryParameters$2(Ref.ObjectRef<Uri> objectRef) {
        super(0);
        this.$uri = objectRef;
    }

    public final String invoke() {
        return "Failed to map the query parameters of Uri: " + this.$uri.element;
    }
}
