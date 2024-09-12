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

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00158\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lcom/braze/models/cards/CaptionedImageCard;", "Lcom/braze/models/cards/Card;", "", "toString", "imageUrl", "Ljava/lang/String;", "getImageUrl", "()Ljava/lang/String;", "title", "getTitle", "description", "getDescription", "url", "getUrl", "domain", "getDomain", "", "aspectRatio", "F", "getAspectRatio", "()F", "Lcom/braze/enums/CardType;", "cardType", "Lcom/braze/enums/CardType;", "getCardType", "()Lcom/braze/enums/CardType;", "Lorg/json/JSONObject;", "jsonObject", "Lcom/braze/enums/CardKey$Provider;", "cardKeyProvider", "Lbo/app/z1;", "manager", "Lcom/braze/storage/ICardStorageProvider;", "cardStorageProvider", "Lbo/app/b2;", "cardAnalyticsProvider", "<init>", "(Lorg/json/JSONObject;Lcom/braze/enums/CardKey$Provider;Lbo/app/z1;Lcom/braze/storage/ICardStorageProvider;Lbo/app/b2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public final class CaptionedImageCard extends Card {
    private final float aspectRatio;
    private final CardType cardType;
    private final String description;
    private final String domain;
    private final String imageUrl;
    private final String title;
    private final String url;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CaptionedImageCard(JSONObject jSONObject, CardKey.Provider provider) {
        this(jSONObject, provider, (z1) null, (ICardStorageProvider) null, (b2) null, 28, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
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

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return StringsKt.trimIndent("\n            CaptionedImageCard{imageUrl='" + this.imageUrl + "'\n            title='" + this.title + "'\n            description='" + this.description + "'\n            url='" + getUrl() + "'\n            domain='" + this.domain + "'\n            aspectRatio=" + this.aspectRatio + "\n            " + super.toString() + "}\n\n        ");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CaptionedImageCard(JSONObject jSONObject, CardKey.Provider provider, z1 z1Var) {
        this(jSONObject, provider, z1Var, (ICardStorageProvider) null, (b2) null, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CaptionedImageCard(JSONObject jSONObject, CardKey.Provider provider, z1 z1Var, ICardStorageProvider<?> iCardStorageProvider) {
        this(jSONObject, provider, z1Var, iCardStorageProvider, (b2) null, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CaptionedImageCard(JSONObject jSONObject, CardKey.Provider provider, z1 z1Var, ICardStorageProvider iCardStorageProvider, b2 b2Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(jSONObject, provider, (i & 4) != 0 ? null : z1Var, (i & 8) != 0 ? null : iCardStorageProvider, (i & 16) != 0 ? null : b2Var);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CaptionedImageCard(JSONObject jSONObject, CardKey.Provider provider, z1 z1Var, ICardStorageProvider<?> iCardStorageProvider, b2 b2Var) {
        super(jSONObject, provider, z1Var, iCardStorageProvider, b2Var);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
        String string = jSONObject.getString(provider.getKey(CardKey.CAPTIONED_IMAGE_IMAGE));
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(car…y.CAPTIONED_IMAGE_IMAGE))");
        this.imageUrl = string;
        String string2 = jSONObject.getString(provider.getKey(CardKey.CAPTIONED_IMAGE_TITLE));
        Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(car…y.CAPTIONED_IMAGE_TITLE))");
        this.title = string2;
        String string3 = jSONObject.getString(provider.getKey(CardKey.CAPTIONED_IMAGE_DESCRIPTION));
        Intrinsics.checkNotNullExpressionValue(string3, "jsonObject.getString(car…IONED_IMAGE_DESCRIPTION))");
        this.description = string3;
        this.url = JsonUtils.getOptionalString(jSONObject, provider.getKey(CardKey.CAPTIONED_IMAGE_URL));
        this.domain = JsonUtils.getOptionalString(jSONObject, provider.getKey(CardKey.CAPTIONED_IMAGE_DOMAIN));
        this.aspectRatio = (float) jSONObject.optDouble(provider.getKey(CardKey.CAPTIONED_IMAGE_ASPECT_RATIO), 0.0d);
        this.cardType = CardType.CAPTIONED_IMAGE;
    }
}
