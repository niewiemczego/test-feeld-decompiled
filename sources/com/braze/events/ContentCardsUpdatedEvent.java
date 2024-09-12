package com.braze.events;

import com.braze.models.cards.Card;
import com.braze.support.DateTimeUtils;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u001c\u001a\u00020\bH\u0007J\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\bJ\b\u0010\u001f\u001a\u00020\u0006H\u0016R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/braze/events/ContentCardsUpdatedEvent;", "", "contentCards", "", "Lcom/braze/models/cards/Card;", "userId", "", "timestampSeconds", "", "isFromOfflineStorage", "", "(Ljava/util/List;Ljava/lang/String;JZ)V", "allCards", "", "getAllCards", "()Ljava/util/List;", "cardCount", "", "getCardCount", "()I", "isEmpty", "()Z", "getTimestampSeconds", "()J", "unviewedCardCount", "getUnviewedCardCount", "getUserId", "()Ljava/lang/String;", "getLastUpdatedInSecondsFromEpoch", "isTimestampOlderThan", "ageSeconds", "toString", "Companion", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContentCardsUpdatedEvent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<Card> contentCards;
    private final boolean isFromOfflineStorage;
    private final long timestampSeconds;
    private final String userId;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/braze/events/ContentCardsUpdatedEvent$Companion;", "", "()V", "emptyUpdate", "Lcom/braze/events/ContentCardsUpdatedEvent;", "getEmptyUpdate$annotations", "getEmptyUpdate", "()Lcom/braze/events/ContentCardsUpdatedEvent;", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getEmptyUpdate$annotations() {
        }

        public final ContentCardsUpdatedEvent getEmptyUpdate() {
            return new ContentCardsUpdatedEvent(CollectionsKt.emptyList(), (String) null, DateTimeUtils.nowInSeconds(), true);
        }

        private Companion() {
        }
    }

    public ContentCardsUpdatedEvent(List<? extends Card> list, String str, long j, boolean z) {
        Intrinsics.checkNotNullParameter(list, "contentCards");
        this.contentCards = list;
        this.userId = str;
        this.timestampSeconds = j;
        this.isFromOfflineStorage = z;
    }

    public static final ContentCardsUpdatedEvent getEmptyUpdate() {
        return Companion.getEmptyUpdate();
    }

    public final List<Card> getAllCards() {
        return CollectionsKt.toMutableList(this.contentCards);
    }

    public final int getCardCount() {
        return this.contentCards.size();
    }

    @Deprecated(message = "Use getTimestampSeconds() (Java) or timestampSeconds (Kotlin)", replaceWith = @ReplaceWith(expression = "timestampSeconds", imports = {}))
    public final long getLastUpdatedInSecondsFromEpoch() {
        return this.timestampSeconds;
    }

    public final long getTimestampSeconds() {
        return this.timestampSeconds;
    }

    public final int getUnviewedCardCount() {
        List<Card> list = this.contentCards;
        if ((list instanceof Collection) && list.isEmpty()) {
            return 0;
        }
        int i = 0;
        for (Card card : list) {
            if ((!card.getViewed() && !card.isControl()) && (i = i + 1) < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        return i;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final boolean isEmpty() {
        return this.contentCards.isEmpty();
    }

    public final boolean isFromOfflineStorage() {
        return this.isFromOfflineStorage;
    }

    public final boolean isTimestampOlderThan(long j) {
        return TimeUnit.SECONDS.toMillis(this.timestampSeconds + j) < System.currentTimeMillis();
    }

    public String toString() {
        return "ContentCardsUpdatedEvent{userId='" + this.userId + "', timestampSeconds=" + this.timestampSeconds + ", isFromOfflineStorage=" + this.isFromOfflineStorage + ", card count=" + getCardCount() + '}';
    }
}
