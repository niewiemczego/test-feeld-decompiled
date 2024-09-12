package com.braze.ui.inappmessage.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackgroundInAppMessagePreparer.kt */
final class BackgroundInAppMessagePreparer$prepareInAppMessageWithHtml$2 extends Lambda implements Function0<String> {
    public static final BackgroundInAppMessagePreparer$prepareInAppMessageWithHtml$2 INSTANCE = new BackgroundInAppMessagePreparer$prepareInAppMessageWithHtml$2();

    BackgroundInAppMessagePreparer$prepareInAppMessageWithHtml$2() {
        super(0);
    }

    public final String invoke() {
        return "HTML in-app message does not have message. Not performing any substitutions.";
    }
}
