package com.braze.models.cards;

import bo.app.b2;
import bo.app.x1;
import bo.app.z1;
import com.braze.enums.CardCategory;
import com.braze.enums.CardKey;
import com.braze.enums.CardType;
import com.braze.enums.Channel;
import com.braze.models.IPutIntoJson;
import com.braze.storage.ICardStorageProvider;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.JsonUtils;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 l2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001mB9\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010g\u001a\u00020f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\f\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0018\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\bh\u0010iB\u0019\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010j\u001a\u00020f¢\u0006\u0004\bh\u0010kJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003J\u0014\u0010\t\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0007J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR#\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010#\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010(\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010,\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b,\u0010)\u001a\u0004\b-\u0010+R\u0017\u0010.\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+R4\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@BX\u000e¢\u0006\f\n\u0004\b\b\u00101\u001a\u0004\b2\u00103R\u0017\u00104\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b4\u00106R\u0017\u00107\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b7\u00105\u001a\u0004\b7\u00106R\"\u00108\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b8\u00105\u001a\u0004\b8\u00106\"\u0004\b9\u0010:R$\u0010;\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00038\u0006@BX\u000e¢\u0006\f\n\u0004\b;\u00105\u001a\u0004\b;\u00106R\u001d\u0010<\u001a\u00020\u00038\u0006¢\u0006\u0012\n\u0004\b<\u00105\u0012\u0004\b>\u0010?\u001a\u0004\b=\u00106R\"\u0010@\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b@\u00105\u001a\u0004\b@\u00106\"\u0004\bA\u0010:R\"\u0010B\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bB\u00105\u001a\u0004\bB\u00106\"\u0004\bC\u0010:R\u001c\u0010D\u001a\u0004\u0018\u00010\u000b8\u0016X\u0004¢\u0006\f\n\u0004\bD\u0010$\u001a\u0004\bE\u0010&R\u001a\u0010G\u001a\u00020F8\u0016X\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u00105R\u0016\u0010L\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u00105R\u0016\u0010M\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u00105R\u0017\u0010O\u001a\u00020N8\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR$\u0010T\u001a\u0004\u0018\u00010S8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010[\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020\u00038F@FX\u000e¢\u0006\f\u001a\u0004\b[\u00106\"\u0004\b\\\u0010:R*\u0010]\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u00038F@FX\u000e¢\u0006\u0012\u0012\u0004\b_\u0010?\u001a\u0004\b]\u00106\"\u0004\b^\u0010:R*\u0010`\u001a\u00020\u00032\u0006\u0010`\u001a\u00020\u00038F@FX\u000e¢\u0006\u0012\u0012\u0004\bc\u0010?\u001a\u0004\ba\u00106\"\u0004\bb\u0010:R\u0011\u0010d\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bd\u00106R\u0011\u0010e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\be\u00106¨\u0006n"}, d2 = {"Lcom/braze/models/cards/Card;", "Lcom/braze/models/IPutIntoJson;", "Lorg/json/JSONObject;", "", "logImpression", "logClick", "Ljava/util/EnumSet;", "Lcom/braze/enums/CardCategory;", "categories", "isInCategorySet", "forJsonPut", "", "toString", "isValidCard", "", "other", "equals", "", "hashCode", "jsonObject", "Lorg/json/JSONObject;", "Lbo/app/z1;", "brazeManager", "Lbo/app/z1;", "Lcom/braze/storage/ICardStorageProvider;", "cardStorage", "Lcom/braze/storage/ICardStorageProvider;", "Lbo/app/b2;", "cardAnalytics", "Lbo/app/b2;", "", "extras", "Ljava/util/Map;", "getExtras", "()Ljava/util/Map;", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "", "created", "J", "getCreated", "()J", "updated", "getUpdated", "expiresAt", "getExpiresAt", "<set-?>", "Ljava/util/EnumSet;", "getCategories", "()Ljava/util/EnumSet;", "isContentCard", "Z", "()Z", "isRemoved", "isPinned", "setPinned", "(Z)V", "isClicked", "openUriInWebView", "getOpenUriInWebView", "getOpenUriInWebView$annotations", "()V", "isDismissibleByUser", "setDismissibleByUser", "isTest", "setTest", "url", "getUrl", "Lcom/braze/enums/CardType;", "cardType", "Lcom/braze/enums/CardType;", "getCardType", "()Lcom/braze/enums/CardType;", "wasViewedInternal", "isIndicatorHighlightedInternal", "isDismissedInternal", "Lcom/braze/enums/Channel;", "channel", "Lcom/braze/enums/Channel;", "getChannel", "()Lcom/braze/enums/Channel;", "Lcom/braze/models/cards/ICardListener;", "listener", "Lcom/braze/models/cards/ICardListener;", "getListener", "()Lcom/braze/models/cards/ICardListener;", "setListener", "(Lcom/braze/models/cards/ICardListener;)V", "enabled", "isIndicatorHighlighted", "setIndicatorHighlighted", "isDismissed", "setDismissed", "isDismissed$annotations", "viewed", "getViewed", "setViewed", "getViewed$annotations", "isExpired", "isControl", "Lcom/braze/enums/CardKey$Provider;", "cardKeysProvider", "<init>", "(Lorg/json/JSONObject;Lcom/braze/enums/CardKey$Provider;Lbo/app/z1;Lcom/braze/storage/ICardStorageProvider;Lbo/app/b2;)V", "cardKeyProvider", "(Lorg/json/JSONObject;Lcom/braze/enums/CardKey$Provider;)V", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public class Card implements IPutIntoJson<JSONObject> {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final long DEFAULT_EXPIRES_AT_VALUE = -1;
    private final z1 brazeManager;
    private final b2 cardAnalytics;
    private final ICardStorageProvider<?> cardStorage;
    private final CardType cardType;
    private EnumSet<CardCategory> categories;
    private final Channel channel;
    private final long created;
    private final long expiresAt;
    private final Map<String, String> extras;
    private final String id;
    private boolean isClicked;
    private final boolean isContentCard;
    private boolean isDismissedInternal;
    private boolean isDismissibleByUser;
    private boolean isIndicatorHighlightedInternal;
    private boolean isPinned;
    private final boolean isRemoved;
    private boolean isTest;
    private final JSONObject jsonObject;
    private ICardListener listener;
    private final boolean openUriInWebView;
    private final long updated;
    private final String url;
    private boolean wasViewedInternal;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public static final class b extends Lambda implements Function1 {
        final /* synthetic */ JSONArray b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(JSONArray jSONArray) {
            super(1);
            this.b = jSONArray;
        }

        public final Boolean a(int i) {
            return Boolean.valueOf(this.b.opt(i) instanceof String);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public static final class c extends Lambda implements Function1 {
        final /* synthetic */ JSONArray b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(JSONArray jSONArray) {
            super(1);
            this.b = jSONArray;
        }

        public final Object a(int i) {
            Object obj = this.b.get(i);
            if (obj != null) {
                return (String) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot dismiss a card more than once. Doing nothing.";
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log card as dismissed.";
        }
    }

    static final class f extends Lambda implements Function0 {
        public static final f b = new f();

        f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to mark card indicator as highlighted.";
        }
    }

    static final class g extends Lambda implements Function0 {
        public static final g b = new g();

        g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Card ID cannot be null";
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ Card b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(Card card) {
            super(0);
            this.b = card;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Logged click for card with id: " + this.b.getId();
        }
    }

    static final class i extends Lambda implements Function0 {
        final /* synthetic */ Card b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(Card card) {
            super(0);
            this.b = card;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log card clicked for id: " + this.b.getId();
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ Card b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(Card card) {
            super(0);
            this.b = card;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log card as clicked for id: " + this.b.getId();
        }
    }

    static final class k extends Lambda implements Function0 {
        final /* synthetic */ Card b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(Card card) {
            super(0);
            this.b = card;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Logging impression event for card with id: " + this.b.getId();
        }
    }

    static final class l extends Lambda implements Function0 {
        final /* synthetic */ Card b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(Card card) {
            super(0);
            this.b = card;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Logging control impression event for card with id: " + this.b.getId();
        }
    }

    static final class m extends Lambda implements Function0 {
        final /* synthetic */ Card b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(Card card) {
            super(0);
            this.b = card;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log card impression for card id: " + this.b.getId();
        }
    }

    public Card(JSONObject jSONObject, CardKey.Provider provider, z1 z1Var, ICardStorageProvider<?> iCardStorageProvider, b2 b2Var) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeysProvider");
        this.jsonObject = jSONObject;
        this.brazeManager = z1Var;
        this.cardStorage = iCardStorageProvider;
        this.cardAnalytics = b2Var;
        this.extras = JsonUtils.convertJSONObjectToMap(jSONObject.optJSONObject(provider.getKey(CardKey.EXTRAS)));
        String string = jSONObject.getString(provider.getKey(CardKey.ID));
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(car…vider.getKey(CardKey.ID))");
        this.id = string;
        this.isContentCard = provider.isContentCardProvider();
        this.cardType = CardType.DEFAULT;
        this.channel = provider.isContentCardProvider() ? Channel.CONTENT_CARD : Channel.NEWS_FEED;
        this.wasViewedInternal = jSONObject.optBoolean(provider.getKey(CardKey.VIEWED));
        this.isDismissedInternal = jSONObject.optBoolean(provider.getKey(CardKey.DISMISSED), false);
        this.isPinned = jSONObject.optBoolean(provider.getKey(CardKey.PINNED), false);
        this.created = jSONObject.getLong(provider.getKey(CardKey.CREATED));
        this.expiresAt = jSONObject.optLong(provider.getKey(CardKey.EXPIRES_AT), -1);
        this.openUriInWebView = jSONObject.optBoolean(provider.getKey(CardKey.OPEN_URI_IN_WEBVIEW), false);
        this.isRemoved = jSONObject.optBoolean(provider.getKey(CardKey.REMOVED), false);
        JSONArray optJSONArray = jSONObject.optJSONArray(provider.getKey(CardKey.CATEGORIES));
        if (optJSONArray == null || optJSONArray.length() == 0) {
            this.categories = EnumSet.of(CardCategory.NO_CATEGORY);
        } else {
            EnumSet<CardCategory> noneOf = EnumSet.noneOf(CardCategory.class);
            for (String str : SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(RangesKt.until(0, optJSONArray.length())), new b(optJSONArray)), new c(optJSONArray))) {
                CardCategory cardCategory = CardCategory.get(str);
                if (cardCategory != null) {
                    Intrinsics.checkNotNullExpressionValue(cardCategory, "get(categoryString)");
                    noneOf.add(cardCategory);
                }
            }
            this.categories = noneOf;
        }
        this.updated = this.jsonObject.optLong(provider.getKey(CardKey.UPDATED), this.created);
        this.isDismissibleByUser = this.jsonObject.optBoolean(provider.getKey(CardKey.DISMISSIBLE), false);
        this.isIndicatorHighlightedInternal = this.jsonObject.optBoolean(provider.getKey(CardKey.READ), this.wasViewedInternal);
        this.isClicked = this.jsonObject.optBoolean(provider.getKey(CardKey.CLICKED), false);
        this.isTest = this.jsonObject.optBoolean(provider.getKey(CardKey.IS_TEST), false);
    }

    public static /* synthetic */ void getOpenUriInWebView$annotations() {
    }

    public static /* synthetic */ void getViewed$annotations() {
    }

    public static /* synthetic */ void isDismissed$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
            return false;
        }
        Card card = (Card) obj;
        if (this.updated != card.updated || !Intrinsics.areEqual((Object) this.id, (Object) card.id)) {
            return false;
        }
        return true;
    }

    public CardType getCardType() {
        return this.cardType;
    }

    public final EnumSet<CardCategory> getCategories() {
        return this.categories;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final long getCreated() {
        return this.created;
    }

    public final long getExpiresAt() {
        return this.expiresAt;
    }

    public final Map<String, String> getExtras() {
        return this.extras;
    }

    public final String getId() {
        return this.id;
    }

    public final ICardListener getListener() {
        return this.listener;
    }

    public final boolean getOpenUriInWebView() {
        return this.openUriInWebView;
    }

    public final long getUpdated() {
        return this.updated;
    }

    public String getUrl() {
        return this.url;
    }

    public final boolean getViewed() {
        return this.wasViewedInternal;
    }

    public int hashCode() {
        long j2 = this.updated;
        return (this.id.hashCode() * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public final boolean isClicked() {
        return this.isClicked;
    }

    public final boolean isContentCard() {
        return this.isContentCard;
    }

    public final boolean isControl() {
        return getCardType() == CardType.CONTROL;
    }

    public final boolean isDismissed() {
        return this.isDismissedInternal;
    }

    public final boolean isDismissibleByUser() {
        return this.isDismissibleByUser;
    }

    public final boolean isExpired() {
        long j2 = this.expiresAt;
        return j2 != -1 && j2 <= DateTimeUtils.nowInSeconds();
    }

    public final boolean isInCategorySet(EnumSet<CardCategory> enumSet) {
        Intrinsics.checkNotNullParameter(enumSet, "categories");
        EnumSet<CardCategory> enumSet2 = this.categories;
        if (enumSet2 == null) {
            return false;
        }
        Iterator<CardCategory> it = enumSet.iterator();
        while (it.hasNext()) {
            if (enumSet2.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean isIndicatorHighlighted() {
        return this.isIndicatorHighlightedInternal;
    }

    public final boolean isPinned() {
        return this.isPinned;
    }

    public final boolean isRemoved() {
        return this.isRemoved;
    }

    public final boolean isTest() {
        return this.isTest;
    }

    public final boolean isValidCard() {
        if (!StringsKt.isBlank(this.id)) {
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) g.b, 2, (Object) null);
        return false;
    }

    public final boolean logClick() {
        try {
            this.isClicked = true;
            if (this.brazeManager == null || this.cardAnalytics == null || this.cardStorage == null || !isValidCard()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new i(this), 2, (Object) null);
                return false;
            }
            x1 b2 = this.cardAnalytics.b(this.id);
            if (b2 != null) {
                this.brazeManager.a(b2);
            }
            this.cardStorage.markCardAsClicked(this.id);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new h(this), 3, (Object) null);
            return true;
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new j(this));
            return false;
        }
    }

    public final boolean logImpression() {
        try {
            if (this.brazeManager == null || this.cardAnalytics == null || this.cardStorage == null || !isValidCard()) {
                return false;
            }
            if (!isControl()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new k(this), 2, (Object) null);
                x1 d2 = this.cardAnalytics.d(this.id);
                if (d2 != null) {
                    this.brazeManager.a(d2);
                }
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new l(this), 2, (Object) null);
                x1 c2 = this.cardAnalytics.c(this.id);
                if (c2 != null) {
                    this.brazeManager.a(c2);
                }
            }
            this.cardStorage.markCardAsViewed(this.id);
            return true;
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new m(this));
            return false;
        }
    }

    public final void setDismissed(boolean z) {
        x1 a2;
        if (!this.isDismissedInternal || !z) {
            this.isDismissedInternal = z;
            ICardStorageProvider<?> iCardStorageProvider = this.cardStorage;
            if (iCardStorageProvider != null) {
                iCardStorageProvider.markCardAsDismissed(this.id);
            }
            if (z) {
                try {
                    if (this.brazeManager != null && this.cardAnalytics != null && isValidCard() && (a2 = this.cardAnalytics.a(this.id)) != null) {
                        this.brazeManager.a(a2);
                    }
                } catch (Exception e2) {
                    BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) e.b);
                }
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) d.b, 2, (Object) null);
        }
    }

    public final void setDismissibleByUser(boolean z) {
        this.isDismissibleByUser = z;
    }

    public final void setIndicatorHighlighted(boolean z) {
        ICardStorageProvider<?> iCardStorageProvider;
        this.isIndicatorHighlightedInternal = z;
        try {
            ICardListener iCardListener = this.listener;
            if (iCardListener != null) {
                iCardListener.onCardUpdate();
            }
        } catch (Exception unused) {
        }
        if (z && (iCardStorageProvider = this.cardStorage) != null) {
            try {
                iCardStorageProvider.markCardAsVisuallyRead(this.id);
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.D, (Throwable) e2, (Function0<String>) f.b);
            }
        }
    }

    public final void setListener(ICardListener iCardListener) {
        this.listener = iCardListener;
    }

    public final void setPinned(boolean z) {
        this.isPinned = z;
    }

    public final void setTest(boolean z) {
        this.isTest = z;
    }

    public final void setViewed(boolean z) {
        this.wasViewedInternal = z;
        ICardStorageProvider<?> iCardStorageProvider = this.cardStorage;
        if (iCardStorageProvider != null) {
            iCardStorageProvider.markCardAsViewed(this.id);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n            Card{\n            extras=").append(this.extras).append("\n            id='").append(this.id).append("'\n            created=").append(this.created).append("\n            updated=").append(this.updated).append("\n            expiresAt=").append(this.expiresAt).append("\n            categories=").append(this.categories).append("\n            isContentCard=").append(this.isContentCard).append("\n            viewed=").append(this.wasViewedInternal).append("\n            isRead=").append(this.isIndicatorHighlightedInternal).append("\n            isDismissed=").append(this.isDismissedInternal).append("\n            isRemoved=").append(this.isRemoved).append("\n            isPinned=");
        sb.append(this.isPinned).append("\n            isClicked=").append(this.isClicked).append("\n            openUriInWebview=").append(this.openUriInWebView).append("\n            isDismissibleByUser=").append(this.isDismissibleByUser).append("\n            isTest=").append(this.isTest).append("\n            json=").append(JsonUtils.getPrettyPrintedString(this.jsonObject)).append("\n            }\n\n        ");
        return StringsKt.trimIndent(sb.toString());
    }

    public JSONObject forJsonPut() {
        return this.jsonObject;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Card(JSONObject jSONObject, CardKey.Provider provider) {
        this(jSONObject, provider, (z1) null, (ICardStorageProvider<?>) null, (b2) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
    }
}
