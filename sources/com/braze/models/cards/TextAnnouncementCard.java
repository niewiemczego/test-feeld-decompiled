package com.braze.models.cards;

import bo.app.b2;
import bo.app.z1;
import com.braze.enums.CardKey;
import com.braze.enums.CardType;
import com.braze.storage.ICardStorageProvider;
import com.braze.support.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/braze/models/cards/TextAnnouncementCard;", "Lcom/braze/models/cards/Card;", "", "toString", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "title", "getTitle", "url", "getUrl", "domain", "getDomain", "Lcom/braze/enums/CardType;", "cardType", "Lcom/braze/enums/CardType;", "getCardType", "()Lcom/braze/enums/CardType;", "Lorg/json/JSONObject;", "jsonObject", "Lcom/braze/enums/CardKey$Provider;", "cardKeyProvider", "Lbo/app/z1;", "manager", "Lcom/braze/storage/ICardStorageProvider;", "cardStorageProvider", "Lbo/app/b2;", "cardAnalyticsProvider", "<init>", "(Lorg/json/JSONObject;Lcom/braze/enums/CardKey$Provider;Lbo/app/z1;Lcom/braze/storage/ICardStorageProvider;Lbo/app/b2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public final class TextAnnouncementCard extends Card {
    private final CardType cardType;
    private final String description;
    private final String domain;
    private final String title;
    private final String url;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TextAnnouncementCard(JSONObject jSONObject, CardKey.Provider provider) {
        this(jSONObject, provider, (z1) null, (ICardStorageProvider) null, (b2) null, 28, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
    }

    public CardType getCardType() {
        return this.cardType;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return StringsKt.trimIndent("\n            TextAnnouncementCard{description='" + this.description + "'\n            title='" + this.title + "'\n            url='" + getUrl() + "'\n            domain='" + this.domain + "'\n            " + super.toString() + "}\n\n        ");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TextAnnouncementCard(JSONObject jSONObject, CardKey.Provider provider, z1 z1Var) {
        this(jSONObject, provider, z1Var, (ICardStorageProvider) null, (b2) null, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TextAnnouncementCard(JSONObject jSONObject, CardKey.Provider provider, z1 z1Var, ICardStorageProvider<?> iCardStorageProvider) {
        this(jSONObject, provider, z1Var, iCardStorageProvider, (b2) null, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextAnnouncementCard(JSONObject jSONObject, CardKey.Provider provider, z1 z1Var, ICardStorageProvider iCardStorageProvider, b2 b2Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(jSONObject, provider, (i & 4) != 0 ? null : z1Var, (i & 8) != 0 ? null : iCardStorageProvider, (i & 16) != 0 ? null : b2Var);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextAnnouncementCard(JSONObject jSONObject, CardKey.Provider provider, z1 z1Var, ICardStorageProvider<?> iCardStorageProvider, b2 b2Var) {
        super(jSONObject, provider, z1Var, iCardStorageProvider, b2Var);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
        String string = jSONObject.getString(provider.getKey(CardKey.TEXT_ANNOUNCEMENT_DESCRIPTION));
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(car…NNOUNCEMENT_DESCRIPTION))");
        this.description = string;
        this.title = JsonUtils.getOptionalString(jSONObject, provider.getKey(CardKey.TEXT_ANNOUNCEMENT_TITLE));
        this.url = JsonUtils.getOptionalString(jSONObject, provider.getKey(CardKey.TEXT_ANNOUNCEMENT_URL));
        this.domain = JsonUtils.getOptionalString(jSONObject, provider.getKey(CardKey.TEXT_ANNOUNCEMENT_DOMAIN));
        this.cardType = CardType.TEXT_ANNOUNCEMENT;
    }
}
