package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.internal.Validate;
import com.facebook.internal.security.OidcSecurityUtil;
import java.io.IOException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u000f\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u000f\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0016J(\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0002J\r\u0010%\u001a\u00020\nH\u0000¢\u0006\u0002\b&J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u001aH\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006,"}, d2 = {"Lcom/facebook/AuthenticationToken;", "Landroid/os/Parcelable;", "token", "", "expectedNonce", "(Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "claims", "Lcom/facebook/AuthenticationTokenClaims;", "getClaims", "()Lcom/facebook/AuthenticationTokenClaims;", "getExpectedNonce", "()Ljava/lang/String;", "header", "Lcom/facebook/AuthenticationTokenHeader;", "getHeader", "()Lcom/facebook/AuthenticationTokenHeader;", "signature", "getSignature", "getToken", "describeContents", "", "equals", "", "other", "", "hashCode", "isValidSignature", "headerString", "claimsString", "sigString", "kid", "toJSONObject", "toJSONObject$facebook_core_release", "writeToParcel", "", "dest", "flags", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AuthenticationToken.kt */
public final class AuthenticationToken implements Parcelable {
    public static final String AUTHENTICATION_TOKEN_KEY = "id_token";
    private static final String CLAIMS_KEY = "claims";
    public static final Parcelable.Creator<AuthenticationToken> CREATOR = new AuthenticationToken$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXPECTED_NONCE_KEY = "expected_nonce";
    private static final String HEADER_KEY = "header";
    private static final String SIGNATURE_KEY = "signature";
    private static final String TOKEN_STRING_KEY = "token_string";
    private final AuthenticationTokenClaims claims;
    private final String expectedNonce;
    private final AuthenticationTokenHeader header;
    private final String signature;
    private final String token;

    @JvmStatic
    public static final AuthenticationToken getCurrentAuthenticationToken() {
        return Companion.getCurrentAuthenticationToken();
    }

    @JvmStatic
    public static final void setCurrentAuthenticationToken(AuthenticationToken authenticationToken) {
        Companion.setCurrentAuthenticationToken(authenticationToken);
    }

    public int describeContents() {
        return 0;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getExpectedNonce() {
        return this.expectedNonce;
    }

    public final AuthenticationTokenHeader getHeader() {
        return this.header;
    }

    public final AuthenticationTokenClaims getClaims() {
        return this.claims;
    }

    public final String getSignature() {
        return this.signature;
    }

    public AuthenticationToken(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(str2, "expectedNonce");
        Validate validate = Validate.INSTANCE;
        Validate.notEmpty(str, "token");
        Validate validate2 = Validate.INSTANCE;
        Validate.notEmpty(str2, "expectedNonce");
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null);
        if (split$default.size() == 3) {
            String str3 = (String) split$default.get(0);
            String str4 = (String) split$default.get(1);
            String str5 = (String) split$default.get(2);
            this.token = str;
            this.expectedNonce = str2;
            AuthenticationTokenHeader authenticationTokenHeader = new AuthenticationTokenHeader(str3);
            this.header = authenticationTokenHeader;
            this.claims = new AuthenticationTokenClaims(str4, str2);
            if (isValidSignature(str3, str4, str5, authenticationTokenHeader.getKid())) {
                this.signature = str5;
                return;
            }
            throw new IllegalArgumentException("Invalid Signature".toString());
        }
        throw new IllegalArgumentException("Invalid IdToken string".toString());
    }

    public AuthenticationToken(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        Validate validate = Validate.INSTANCE;
        this.token = Validate.notNullOrEmpty(readString, "token");
        String readString2 = parcel.readString();
        Validate validate2 = Validate.INSTANCE;
        this.expectedNonce = Validate.notNullOrEmpty(readString2, "expectedNonce");
        Parcelable readParcelable = parcel.readParcelable(AuthenticationTokenHeader.class.getClassLoader());
        if (readParcelable != null) {
            this.header = (AuthenticationTokenHeader) readParcelable;
            Parcelable readParcelable2 = parcel.readParcelable(AuthenticationTokenClaims.class.getClassLoader());
            if (readParcelable2 != null) {
                this.claims = (AuthenticationTokenClaims) readParcelable2;
                String readString3 = parcel.readString();
                Validate validate3 = Validate.INSTANCE;
                this.signature = Validate.notNullOrEmpty(readString3, SIGNATURE_KEY);
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public AuthenticationToken(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        String string = jSONObject.getString(TOKEN_STRING_KEY);
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(TOKEN_STRING_KEY)");
        this.token = string;
        String string2 = jSONObject.getString(EXPECTED_NONCE_KEY);
        Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(EXPECTED_NONCE_KEY)");
        this.expectedNonce = string2;
        String string3 = jSONObject.getString(SIGNATURE_KEY);
        Intrinsics.checkNotNullExpressionValue(string3, "jsonObject.getString(SIGNATURE_KEY)");
        this.signature = string3;
        JSONObject jSONObject2 = jSONObject.getJSONObject(HEADER_KEY);
        JSONObject jSONObject3 = jSONObject.getJSONObject(CLAIMS_KEY);
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "headerJSONObject");
        this.header = new AuthenticationTokenHeader(jSONObject2);
        AuthenticationTokenClaims.Companion companion = AuthenticationTokenClaims.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "claimsJSONObject");
        this.claims = companion.createFromJSONObject$facebook_core_release(jSONObject3);
    }

    public final JSONObject toJSONObject$facebook_core_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TOKEN_STRING_KEY, (Object) this.token);
        jSONObject.put(EXPECTED_NONCE_KEY, (Object) this.expectedNonce);
        jSONObject.put(HEADER_KEY, (Object) this.header.toJSONObject$facebook_core_release());
        jSONObject.put(CLAIMS_KEY, (Object) this.claims.toJSONObject$facebook_core_release());
        jSONObject.put(SIGNATURE_KEY, (Object) this.signature);
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationToken)) {
            return false;
        }
        AuthenticationToken authenticationToken = (AuthenticationToken) obj;
        if (!Intrinsics.areEqual((Object) this.token, (Object) authenticationToken.token) || !Intrinsics.areEqual((Object) this.expectedNonce, (Object) authenticationToken.expectedNonce) || !Intrinsics.areEqual((Object) this.header, (Object) authenticationToken.header) || !Intrinsics.areEqual((Object) this.claims, (Object) authenticationToken.claims) || !Intrinsics.areEqual((Object) this.signature, (Object) authenticationToken.signature)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((527 + this.token.hashCode()) * 31) + this.expectedNonce.hashCode()) * 31) + this.header.hashCode()) * 31) + this.claims.hashCode()) * 31) + this.signature.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.token);
        parcel.writeString(this.expectedNonce);
        parcel.writeParcelable(this.header, i);
        parcel.writeParcelable(this.claims, i);
        parcel.writeString(this.signature);
    }

    private final boolean isValidSignature(String str, String str2, String str3, String str4) {
        try {
            OidcSecurityUtil oidcSecurityUtil = OidcSecurityUtil.INSTANCE;
            String rawKeyFromEndPoint = OidcSecurityUtil.getRawKeyFromEndPoint(str4);
            if (rawKeyFromEndPoint == null) {
                return false;
            }
            OidcSecurityUtil oidcSecurityUtil2 = OidcSecurityUtil.INSTANCE;
            PublicKey publicKeyFromString = OidcSecurityUtil.getPublicKeyFromString(rawKeyFromEndPoint);
            OidcSecurityUtil oidcSecurityUtil3 = OidcSecurityUtil.INSTANCE;
            return OidcSecurityUtil.verify(publicKeyFromString, str + '.' + str2, str3);
        } catch (IOException | InvalidKeySpecException unused) {
            return false;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/AuthenticationToken$Companion;", "", "()V", "AUTHENTICATION_TOKEN_KEY", "", "CLAIMS_KEY", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/AuthenticationToken;", "EXPECTED_NONCE_KEY", "HEADER_KEY", "SIGNATURE_KEY", "TOKEN_STRING_KEY", "getCurrentAuthenticationToken", "setCurrentAuthenticationToken", "", "authenticationToken", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AuthenticationToken.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AuthenticationToken getCurrentAuthenticationToken() {
            return AuthenticationTokenManager.Companion.getInstance().getCurrentAuthenticationToken();
        }

        @JvmStatic
        public final void setCurrentAuthenticationToken(AuthenticationToken authenticationToken) {
            AuthenticationTokenManager.Companion.getInstance().setCurrentAuthenticationToken(authenticationToken);
        }
    }
}
