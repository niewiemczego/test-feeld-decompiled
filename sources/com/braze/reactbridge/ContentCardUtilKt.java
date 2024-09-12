package com.braze.reactbridge;

import com.braze.enums.CardType;
import com.braze.models.cards.CaptionedImageCard;
import com.braze.models.cards.Card;
import com.braze.models.cards.ImageOnlyCard;
import com.braze.models.cards.ShortNewsCard;
import com.braze.models.cards.TextAnnouncementCard;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u000e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b\u001a\u0014\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f\u001a\u000e\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e\u001a\u000e\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"captionedImageCardToWritableMap", "Lcom/facebook/react/bridge/WritableMap;", "card", "Lcom/braze/models/cards/CaptionedImageCard;", "controlCardToWritableMap", "imageOnlyCardToWritableMap", "Lcom/braze/models/cards/ImageOnlyCard;", "mapContentCard", "Lcom/braze/models/cards/Card;", "mapContentCards", "Lcom/facebook/react/bridge/WritableArray;", "cardsList", "", "shortNewsCardToWritableMap", "Lcom/braze/models/cards/ShortNewsCard;", "textAnnouncementCardToWritableMap", "Lcom/braze/models/cards/TextAnnouncementCard;", "braze_react-native-sdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ContentCardUtil.kt */
public final class ContentCardUtilKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ContentCardUtil.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardType.values().length];
            iArr[CardType.IMAGE.ordinal()] = 1;
            iArr[CardType.CAPTIONED_IMAGE.ordinal()] = 2;
            iArr[CardType.SHORT_NEWS.ordinal()] = 3;
            iArr[CardType.TEXT_ANNOUNCEMENT.ordinal()] = 4;
            iArr[CardType.CONTROL.ordinal()] = 5;
            iArr[CardType.DEFAULT.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final WritableArray mapContentCards(List<? extends Card> list) {
        Intrinsics.checkNotNullParameter(list, "cardsList");
        WritableArray createArray = Arguments.createArray();
        for (Card mapContentCard : (Card[]) list.toArray(new Card[0])) {
            createArray.pushMap(mapContentCard(mapContentCard));
        }
        Intrinsics.checkNotNullExpressionValue(createArray, "cards");
        return createArray;
    }

    public static final WritableMap mapContentCard(Card card) {
        Intrinsics.checkNotNullParameter(card, "card");
        WritableMap createMap = Arguments.createMap();
        createMap.putString("id", card.getId());
        createMap.putDouble("created", (double) card.getCreated());
        createMap.putDouble("expiresAt", (double) card.getExpiresAt());
        createMap.putBoolean("viewed", card.getViewed());
        createMap.putBoolean("clicked", card.isClicked());
        createMap.putBoolean("pinned", card.isPinned());
        createMap.putBoolean(UIManagerModuleConstants.ACTION_DISMISSED, card.isDismissed());
        createMap.putBoolean("dismissible", card.isDismissibleByUser());
        createMap.putString("url", card.getUrl());
        createMap.putBoolean("openURLInWebView", card.getOpenUriInWebView());
        createMap.putBoolean("isControl", card.isControl());
        WritableMap createMap2 = Arguments.createMap();
        for (Map.Entry next : card.getExtras().entrySet()) {
            createMap2.putString((String) next.getKey(), (String) next.getValue());
        }
        createMap.putMap("extras", createMap2);
        int i = WhenMappings.$EnumSwitchMapping$0[card.getCardType().ordinal()];
        if (i == 1) {
            createMap.merge(imageOnlyCardToWritableMap((ImageOnlyCard) card));
        } else if (i == 2) {
            createMap.merge(captionedImageCardToWritableMap((CaptionedImageCard) card));
        } else if (i == 3) {
            createMap.merge(shortNewsCardToWritableMap((ShortNewsCard) card));
        } else if (i == 4) {
            createMap.merge(textAnnouncementCardToWritableMap((TextAnnouncementCard) card));
        } else if (i == 5) {
            createMap.merge(controlCardToWritableMap());
        }
        Intrinsics.checkNotNullExpressionValue(createMap, "mappedCard");
        return createMap;
    }

    public static final WritableMap captionedImageCardToWritableMap(CaptionedImageCard captionedImageCard) {
        Intrinsics.checkNotNullParameter(captionedImageCard, "card");
        WritableMap createMap = Arguments.createMap();
        createMap.putString("image", captionedImageCard.getImageUrl());
        createMap.putDouble("imageAspectRatio", (double) captionedImageCard.getAspectRatio());
        createMap.putString("title", captionedImageCard.getTitle());
        createMap.putString("cardDescription", captionedImageCard.getDescription());
        createMap.putString(DynamicLink.Builder.KEY_DOMAIN, captionedImageCard.getDomain());
        createMap.putString("type", "Captioned");
        Intrinsics.checkNotNullExpressionValue(createMap, "mappedCard");
        return createMap;
    }

    public static final WritableMap shortNewsCardToWritableMap(ShortNewsCard shortNewsCard) {
        Intrinsics.checkNotNullParameter(shortNewsCard, "card");
        WritableMap createMap = Arguments.createMap();
        createMap.putString("image", shortNewsCard.getImageUrl());
        createMap.putString("title", shortNewsCard.getTitle());
        createMap.putString("cardDescription", shortNewsCard.getDescription());
        createMap.putString(DynamicLink.Builder.KEY_DOMAIN, shortNewsCard.getDomain());
        createMap.putString("type", "Classic");
        Intrinsics.checkNotNullExpressionValue(createMap, "mappedCard");
        return createMap;
    }

    public static final WritableMap textAnnouncementCardToWritableMap(TextAnnouncementCard textAnnouncementCard) {
        Intrinsics.checkNotNullParameter(textAnnouncementCard, "card");
        WritableMap createMap = Arguments.createMap();
        createMap.putString("title", textAnnouncementCard.getTitle());
        createMap.putString("cardDescription", textAnnouncementCard.getDescription());
        createMap.putString(DynamicLink.Builder.KEY_DOMAIN, textAnnouncementCard.getDomain());
        createMap.putString("type", "Classic");
        Intrinsics.checkNotNullExpressionValue(createMap, "mappedCard");
        return createMap;
    }

    public static final WritableMap imageOnlyCardToWritableMap(ImageOnlyCard imageOnlyCard) {
        Intrinsics.checkNotNullParameter(imageOnlyCard, "card");
        WritableMap createMap = Arguments.createMap();
        createMap.putString("image", imageOnlyCard.getImageUrl());
        createMap.putDouble("imageAspectRatio", (double) imageOnlyCard.getAspectRatio());
        createMap.putString(DynamicLink.Builder.KEY_DOMAIN, imageOnlyCard.getDomain());
        createMap.putString("type", "ImageOnly");
        Intrinsics.checkNotNullExpressionValue(createMap, "mappedCard");
        return createMap;
    }

    public static final WritableMap controlCardToWritableMap() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", "Control");
        Intrinsics.checkNotNullExpressionValue(createMap, "mappedCard");
        return createMap;
    }
}
