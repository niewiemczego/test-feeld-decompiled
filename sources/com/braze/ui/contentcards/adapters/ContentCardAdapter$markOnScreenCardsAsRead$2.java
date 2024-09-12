package com.braze.ui.contentcards.adapters;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContentCardAdapter.kt */
final class ContentCardAdapter$markOnScreenCardsAsRead$2 extends Lambda implements Function0<String> {
    final /* synthetic */ int $firstVisibleIndex;
    final /* synthetic */ int $lastVisibleIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContentCardAdapter$markOnScreenCardsAsRead$2(int i, int i2) {
        super(0);
        this.$firstVisibleIndex = i;
        this.$lastVisibleIndex = i2;
    }

    public final String invoke() {
        return "Not marking all on-screen cards as read. Either the first or last index is negative. First visible: " + this.$firstVisibleIndex + " . Last visible: " + this.$lastVisibleIndex;
    }
}
