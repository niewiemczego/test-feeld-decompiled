package com.facebook.login;

import android.os.Bundle;
import android.util.Base64;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.internal.ServerProtocol;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u0006H\u0007J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u000f"}, d2 = {"Lcom/facebook/login/PKCEUtil;", "", "()V", "createCodeExchangeRequest", "Lcom/facebook/GraphRequest;", "authorizationCode", "", "redirectUri", "codeVerifier", "generateCodeChallenge", "codeChallengeMethod", "Lcom/facebook/login/CodeChallengeMethod;", "generateCodeVerifier", "isValidCodeVerifier", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: PKCEUtil.kt */
public final class PKCEUtil {
    public static final PKCEUtil INSTANCE = new PKCEUtil();

    private PKCEUtil() {
    }

    @JvmStatic
    public static final boolean isValidCodeVerifier(String str) {
        CharSequence charSequence = str;
        if ((charSequence == null || charSequence.length() == 0) || str.length() < 43 || str.length() > 128) {
            return false;
        }
        return new Regex("^[-._~A-Za-z0-9]+$").matches(charSequence);
    }

    @JvmStatic
    public static final String generateCodeVerifier() {
        int random = RangesKt.random(new IntRange(43, 128), (Random) Random.Default);
        List plus = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(new CharRange('a', 'z'), new CharRange('A', 'Z')), new CharRange('0', '9')), '-'), '.'), '_'), '~');
        ArrayList arrayList = new ArrayList(random);
        for (int i = 0; i < random; i++) {
            arrayList.add(Character.valueOf(((Character) CollectionsKt.random(plus, Random.Default)).charValue()));
        }
        return CollectionsKt.joinToString$default(arrayList, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    @JvmStatic
    public static final String generateCodeChallenge(String str, CodeChallengeMethod codeChallengeMethod) throws FacebookException {
        Intrinsics.checkNotNullParameter(str, "codeVerifier");
        Intrinsics.checkNotNullParameter(codeChallengeMethod, "codeChallengeMethod");
        if (!isValidCodeVerifier(str)) {
            throw new FacebookException("Invalid Code Verifier.");
        } else if (codeChallengeMethod == CodeChallengeMethod.PLAIN) {
            return str;
        } else {
            try {
                byte[] bytes = str.getBytes(Charsets.US_ASCII);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
                instance.update(bytes, 0, bytes.length);
                String encodeToString = Base64.encodeToString(instance.digest(), 11);
                Intrinsics.checkNotNullExpressionValue(encodeToString, "{\n      // try to generate challenge with S256\n      val bytes: ByteArray = codeVerifier.toByteArray(Charsets.US_ASCII)\n      val messageDigest = MessageDigest.getInstance(\"SHA-256\")\n      messageDigest.update(bytes, 0, bytes.size)\n      val digest = messageDigest.digest()\n\n      Base64.encodeToString(digest, Base64.URL_SAFE or Base64.NO_PADDING or Base64.NO_WRAP)\n    }");
                return encodeToString;
            } catch (Exception e) {
                throw new FacebookException((Throwable) e);
            }
        }
    }

    @JvmStatic
    public static final GraphRequest createCodeExchangeRequest(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "authorizationCode");
        Intrinsics.checkNotNullParameter(str2, "redirectUri");
        Intrinsics.checkNotNullParameter(str3, "codeVerifier");
        Bundle bundle = new Bundle();
        bundle.putString("code", str);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        bundle.putString("client_id", FacebookSdk.getApplicationId());
        bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, str2);
        bundle.putString("code_verifier", str3);
        GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest((AccessToken) null, "oauth/access_token", (GraphRequest.Callback) null);
        newGraphPathRequest.setHttpMethod(HttpMethod.GET);
        newGraphPathRequest.setParameters(bundle);
        return newGraphPathRequest;
    }
}
