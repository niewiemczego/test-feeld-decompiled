package com.braze.ui.inappmessage.factories;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultInAppMessageSlideupViewFactory.kt */
final class DefaultInAppMessageSlideupViewFactory$createInAppMessageView$1 extends Lambda implements Function0<String> {
    public static final DefaultInAppMessageSlideupViewFactory$createInAppMessageView$1 INSTANCE = new DefaultInAppMessageSlideupViewFactory$createInAppMessageView$1();

    DefaultInAppMessageSlideupViewFactory$createInAppMessageView$1() {
        super(0);
    }

    public final String invoke() {
        return "The device is not currently in touch mode. This message requires user touch interaction to display properly.";
    }
}
