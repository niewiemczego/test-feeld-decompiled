package com.braze.ui.contentcards.adapters;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContentCardAdapter.kt */
final class ContentCardAdapter$markOnScreenCardsAsRead$1 extends Lambda implements Function0<String> {
    public static final ContentCardAdapter$markOnScreenCardsAsRead$1 INSTANCE = new ContentCardAdapter$markOnScreenCardsAsRead$1();

    ContentCardAdapter$markOnScreenCardsAsRead$1() {
        super(0);
    }

    public final String invoke() {
        return "Card list is empty. Not marking on-screen cards as read.";
    }
}
