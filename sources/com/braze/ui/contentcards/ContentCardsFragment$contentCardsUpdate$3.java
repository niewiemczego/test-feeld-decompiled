package com.braze.ui.contentcards;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContentCardsFragment.kt */
final class ContentCardsFragment$contentCardsUpdate$3 extends Lambda implements Function0<String> {
    public static final ContentCardsFragment$contentCardsUpdate$3 INSTANCE = new ContentCardsFragment$contentCardsUpdate$3();

    ContentCardsFragment$contentCardsUpdate$3() {
        super(0);
    }

    public final String invoke() {
        return "ContentCards received was older than the max time to live of 60 seconds, displaying it for now, but requesting an updated view from the server.";
    }
}
