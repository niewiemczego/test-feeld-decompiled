package com.facebook.gamingservices.model;

import android.graphics.Bitmap;
import android.util.Base64;
import com.facebook.gamingservices.GamingContext;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017BG\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/facebook/gamingservices/model/CustomUpdateContent;", "", "contextTokenId", "", "text", "Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;", "cta", "image", "media", "Lcom/facebook/gamingservices/model/CustomUpdateMedia;", "data", "(Ljava/lang/String;Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;Ljava/lang/String;Lcom/facebook/gamingservices/model/CustomUpdateMedia;Ljava/lang/String;)V", "getContextTokenId", "()Ljava/lang/String;", "getCta", "()Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;", "getData", "getImage", "getMedia", "()Lcom/facebook/gamingservices/model/CustomUpdateMedia;", "getText", "toGraphRequestContent", "Lorg/json/JSONObject;", "Builder", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CustomUpdateContent.kt */
public final class CustomUpdateContent {
    private final String contextTokenId;
    private final CustomUpdateLocalizedText cta;
    private final String data;
    private final String image;
    private final CustomUpdateMedia media;
    private final CustomUpdateLocalizedText text;

    public /* synthetic */ CustomUpdateContent(String str, CustomUpdateLocalizedText customUpdateLocalizedText, CustomUpdateLocalizedText customUpdateLocalizedText2, String str2, CustomUpdateMedia customUpdateMedia, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, customUpdateLocalizedText, customUpdateLocalizedText2, str2, customUpdateMedia, str3);
    }

    private CustomUpdateContent(String str, CustomUpdateLocalizedText customUpdateLocalizedText, CustomUpdateLocalizedText customUpdateLocalizedText2, String str2, CustomUpdateMedia customUpdateMedia, String str3) {
        this.contextTokenId = str;
        this.text = customUpdateLocalizedText;
        this.cta = customUpdateLocalizedText2;
        this.image = str2;
        this.media = customUpdateMedia;
        this.data = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ CustomUpdateContent(String str, CustomUpdateLocalizedText customUpdateLocalizedText, CustomUpdateLocalizedText customUpdateLocalizedText2, String str2, CustomUpdateMedia customUpdateMedia, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, customUpdateLocalizedText, (i & 4) != 0 ? null : customUpdateLocalizedText2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : customUpdateMedia, (i & 32) != 0 ? null : str3);
    }

    public final String getContextTokenId() {
        return this.contextTokenId;
    }

    public final CustomUpdateLocalizedText getText() {
        return this.text;
    }

    public final CustomUpdateLocalizedText getCta() {
        return this.cta;
    }

    public final String getImage() {
        return this.image;
    }

    public final CustomUpdateMedia getMedia() {
        return this.media;
    }

    public final String getData() {
        return this.data;
    }

    public final JSONObject toGraphRequestContent() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("context_token_id", (Object) this.contextTokenId);
        jSONObject.put("text", (Object) this.text.toJSONObject().toString());
        CustomUpdateLocalizedText customUpdateLocalizedText = this.cta;
        if (customUpdateLocalizedText != null) {
            jSONObject.put(SDKConstants.PARAM_GAME_REQUESTS_CTA, (Object) customUpdateLocalizedText.toJSONObject().toString());
        }
        String str = this.image;
        if (str != null) {
            jSONObject.put("image", (Object) str);
        }
        CustomUpdateMedia customUpdateMedia = this.media;
        if (customUpdateMedia != null) {
            jSONObject.put("media", (Object) customUpdateMedia.toJSONObject().toString());
        }
        String str2 = this.data;
        if (str2 != null) {
            jSONObject.put("data", (Object) str2);
        }
        return jSONObject;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB-\b\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u0016\u001a\u0004\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\rR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/facebook/gamingservices/model/CustomUpdateContent$Builder;", "", "contextToken", "Lcom/facebook/gamingservices/GamingContext;", "text", "Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;", "image", "Landroid/graphics/Bitmap;", "(Lcom/facebook/gamingservices/GamingContext;Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;Landroid/graphics/Bitmap;)V", "media", "Lcom/facebook/gamingservices/model/CustomUpdateMedia;", "(Lcom/facebook/gamingservices/GamingContext;Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;Lcom/facebook/gamingservices/model/CustomUpdateMedia;)V", "contextTokenId", "", "(Ljava/lang/String;Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;Landroid/graphics/Bitmap;Lcom/facebook/gamingservices/model/CustomUpdateMedia;)V", "<set-?>", "cta", "getCta", "()Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;", "data", "getData", "()Ljava/lang/String;", "bitmapToBase64String", "bitmap", "build", "Lcom/facebook/gamingservices/model/CustomUpdateContent;", "setCta", "setData", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CustomUpdateContent.kt */
    public static final class Builder {
        private final String contextTokenId;
        private CustomUpdateLocalizedText cta;
        private String data;
        private final Bitmap image;
        private final CustomUpdateMedia media;
        private final CustomUpdateLocalizedText text;

        private Builder(String str, CustomUpdateLocalizedText customUpdateLocalizedText, Bitmap bitmap, CustomUpdateMedia customUpdateMedia) {
            this.contextTokenId = str;
            this.text = customUpdateLocalizedText;
            this.image = bitmap;
            this.media = customUpdateMedia;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(GamingContext gamingContext, CustomUpdateLocalizedText customUpdateLocalizedText, Bitmap bitmap) {
            this(gamingContext.getContextID(), customUpdateLocalizedText, bitmap, (CustomUpdateMedia) null);
            Intrinsics.checkNotNullParameter(gamingContext, SDKConstants.PARAM_CONTEXT_TOKEN);
            Intrinsics.checkNotNullParameter(customUpdateLocalizedText, "text");
            Intrinsics.checkNotNullParameter(bitmap, "image");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(GamingContext gamingContext, CustomUpdateLocalizedText customUpdateLocalizedText, CustomUpdateMedia customUpdateMedia) {
            this(gamingContext.getContextID(), customUpdateLocalizedText, (Bitmap) null, customUpdateMedia);
            Intrinsics.checkNotNullParameter(gamingContext, SDKConstants.PARAM_CONTEXT_TOKEN);
            Intrinsics.checkNotNullParameter(customUpdateLocalizedText, "text");
            Intrinsics.checkNotNullParameter(customUpdateMedia, "media");
        }

        public final CustomUpdateLocalizedText getCta() {
            return this.cta;
        }

        public final String getData() {
            return this.data;
        }

        public final Builder setCta(CustomUpdateLocalizedText customUpdateLocalizedText) {
            Intrinsics.checkNotNullParameter(customUpdateLocalizedText, SDKConstants.PARAM_GAME_REQUESTS_CTA);
            this.cta = customUpdateLocalizedText;
            return this;
        }

        public final Builder setData(String str) {
            Intrinsics.checkNotNullParameter(str, "data");
            this.data = str;
            return this;
        }

        public final CustomUpdateContent build() {
            CustomUpdateMedia customUpdateMedia = this.media;
            if (customUpdateMedia != null) {
                boolean z = true;
                boolean z2 = customUpdateMedia.getGif() != null;
                if (this.media.getVideo() == null) {
                    z = false;
                }
                if (!(z2 ^ z)) {
                    throw new IllegalArgumentException("Invalid CustomUpdateMedia, please set either gif or video");
                }
            }
            String bitmapToBase64String = bitmapToBase64String(this.image);
            if (this.contextTokenId != null) {
                return new CustomUpdateContent(this.contextTokenId, this.text, this.cta, bitmapToBase64String, this.media, this.data, (DefaultConstructorMarker) null);
            }
            throw new IllegalArgumentException("parameter contextToken must not be null");
        }

        private final String bitmapToBase64String(Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return Intrinsics.stringPlus("data:image/png;base64,", Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2));
        }
    }
}
