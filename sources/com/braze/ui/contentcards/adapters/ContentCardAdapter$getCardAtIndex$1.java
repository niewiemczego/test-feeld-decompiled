package com.braze.ui.contentcards.adapters;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContentCardAdapter.kt */
final class ContentCardAdapter$getCardAtIndex$1 extends Lambda implements Function0<String> {
    final /* synthetic */ int $index;
    final /* synthetic */ ContentCardAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContentCardAdapter$getCardAtIndex$1(int i, ContentCardAdapter contentCardAdapter) {
        super(0);
        this.$index = i;
        this.this$0 = contentCardAdapter;
    }

    public final String invoke() {
        return "Cannot return card at index: " + this.$index + " in cards list of size: " + this.this$0.cardData.size();
    }
}
