package com.braze.ui.contentcards.handlers;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import com.braze.enums.CardType;
import com.braze.models.cards.Card;
import com.braze.ui.contentcards.view.BaseContentCardView;
import com.braze.ui.contentcards.view.CaptionedImageContentCardView;
import com.braze.ui.contentcards.view.ContentCardViewHolder;
import com.braze.ui.contentcards.view.DefaultContentCardView;
import com.braze.ui.contentcards.view.ImageOnlyContentCardView;
import com.braze.ui.contentcards.view.ShortNewsContentCardView;
import com.braze.ui.contentcards.view.TextAnnouncementContentCardView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0007J&\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\bH\u0016J.\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\bH\u0016J.\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/braze/ui/contentcards/handlers/DefaultContentCardsViewBindingHandler;", "Lcom/braze/ui/contentcards/handlers/IContentCardsViewBindingHandler;", "()V", "contentCardViewCache", "", "Lcom/braze/enums/CardType;", "Lcom/braze/ui/contentcards/view/BaseContentCardView;", "describeContents", "", "getContentCardsViewFromCache", "context", "Landroid/content/Context;", "cardType", "getItemViewType", "cards", "", "Lcom/braze/models/cards/Card;", "adapterPosition", "onBindViewHolder", "", "viewHolder", "Lcom/braze/ui/contentcards/view/ContentCardViewHolder;", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultContentCardsViewBindingHandler.kt */
public class DefaultContentCardsViewBindingHandler implements IContentCardsViewBindingHandler {
    public static final Parcelable.Creator<DefaultContentCardsViewBindingHandler> CREATOR = new DefaultContentCardsViewBindingHandler$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Map<CardType, BaseContentCardView<?>> contentCardViewCache = new LinkedHashMap();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultContentCardsViewBindingHandler.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.braze.enums.CardType[] r0 = com.braze.enums.CardType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.braze.enums.CardType r1 = com.braze.enums.CardType.IMAGE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.braze.enums.CardType r1 = com.braze.enums.CardType.CAPTIONED_IMAGE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.braze.enums.CardType r1 = com.braze.enums.CardType.SHORT_NEWS     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.braze.enums.CardType r1 = com.braze.enums.CardType.TEXT_ANNOUNCEMENT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.ui.contentcards.handlers.DefaultContentCardsViewBindingHandler.WhenMappings.<clinit>():void");
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
    }

    public ContentCardViewHolder onCreateViewHolder(Context context, List<? extends Card> list, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "cards");
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        return getContentCardsViewFromCache(context, CardType.Companion.fromValue(i)).createViewHolder(viewGroup);
    }

    public void onBindViewHolder(Context context, List<? extends Card> list, ContentCardViewHolder contentCardViewHolder, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "cards");
        Intrinsics.checkNotNullParameter(contentCardViewHolder, "viewHolder");
        if (i >= 0 && i < list.size()) {
            Card card = (Card) list.get(i);
            getContentCardsViewFromCache(context, card.getCardType()).bindViewHolder(contentCardViewHolder, card);
        }
    }

    public int getItemViewType(Context context, List<? extends Card> list, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "cards");
        if (i < 0 || i >= list.size()) {
            return -1;
        }
        return ((Card) list.get(i)).getCardType().getValue();
    }

    public final BaseContentCardView<?> getContentCardsViewFromCache(Context context, CardType cardType) {
        BaseContentCardView baseContentCardView;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        if (!this.contentCardViewCache.containsKey(cardType) || this.contentCardViewCache.get(cardType) == null) {
            int i = WhenMappings.$EnumSwitchMapping$0[cardType.ordinal()];
            if (i == 1) {
                baseContentCardView = new ImageOnlyContentCardView(context);
            } else if (i == 2) {
                baseContentCardView = new CaptionedImageContentCardView(context);
            } else if (i == 3) {
                baseContentCardView = new ShortNewsContentCardView(context);
            } else if (i != 4) {
                baseContentCardView = new DefaultContentCardView(context);
            } else {
                baseContentCardView = new TextAnnouncementContentCardView(context);
            }
            this.contentCardViewCache.put(cardType, baseContentCardView);
        }
        BaseContentCardView<?> baseContentCardView2 = this.contentCardViewCache.get(cardType);
        return baseContentCardView2 == null ? new DefaultContentCardView(context) : baseContentCardView2;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/braze/ui/contentcards/handlers/DefaultContentCardsViewBindingHandler$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/braze/ui/contentcards/handlers/DefaultContentCardsViewBindingHandler;", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultContentCardsViewBindingHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
