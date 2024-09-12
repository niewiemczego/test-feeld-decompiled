package com.adapty.internal.utils;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\b\u0001\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\n¨\u0006\u0012"}, d2 = {"Lcom/adapty/internal/utils/HashingHelper;", "", "()V", "hashString", "", "input", "algorithm", "charset", "Ljava/nio/charset/Charset;", "hmacSha256", "", "key", "data", "md5", "sha256", "toHexString", "byteArray", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HashingHelper.kt */
public final class HashingHelper {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String MAC_ALGORITHM = "HmacSHA256";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/adapty/internal/utils/HashingHelper$Companion;", "", "()V", "MAC_ALGORITHM", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: HashingHelper.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final byte[] hmacSha256(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "key");
        Intrinsics.checkNotNullParameter(str, "data");
        Mac instance = Mac.getInstance(MAC_ALGORITHM);
        instance.init(new SecretKeySpec(bArr, MAC_ALGORITHM));
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
        byte[] bytes = str.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] doFinal = instance.doFinal(bytes);
        Intrinsics.checkNotNullExpressionValue(doFinal, "sha256Hmac.doFinal(data.…eArray(charset(\"UTF-8\")))");
        return doFinal;
    }

    public final byte[] hmacSha256(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "data");
        Charset forName = Charset.forName("utf-8");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(\"utf-8\")");
        byte[] bytes = str.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return hmacSha256(bytes, str2);
    }

    public final String toHexString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "byteArray");
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[i])}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            sb = sb.append(format);
            Intrinsics.checkNotNullExpressionValue(sb, "sb.append(\"%02x\".format(it))");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "byteArray.fold(StringBui….format(it)) }.toString()");
        return sb2;
    }

    public final String sha256(String str) {
        Intrinsics.checkNotNullParameter(str, "input");
        return hashString$default(this, str, MessageDigestAlgorithms.SHA_256, (Charset) null, 4, (Object) null);
    }

    public final String md5(String str) {
        Intrinsics.checkNotNullParameter(str, "input");
        return hashString$default(this, str, MessageDigestAlgorithms.MD5, (Charset) null, 4, (Object) null);
    }

    static /* synthetic */ String hashString$default(HashingHelper hashingHelper, String str, String str2, Charset charset, int i, Object obj) {
        if ((i & 4) != 0) {
            charset = Charsets.UTF_8;
        }
        return hashingHelper.hashString(str, str2, charset);
    }

    private final String hashString(String str, String str2, Charset charset) {
        MessageDigest instance = MessageDigest.getInstance(str2);
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] digest = instance.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(digest, "getInstance(algorithm)\n …put.toByteArray(charset))");
        return toHexString(digest);
    }
}
