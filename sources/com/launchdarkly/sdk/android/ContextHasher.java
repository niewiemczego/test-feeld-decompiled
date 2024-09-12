package com.launchdarkly.sdk.android;

import android.util.Base64;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

class ContextHasher {
    ContextHasher() {
    }

    /* access modifiers changed from: package-private */
    public String hash(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            instance.reset();
            return Base64.encodeToString(instance.digest(str.getBytes(Charset.forName("UTF-8"))), 10);
        } catch (NoSuchAlgorithmException unused) {
            return "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=";
        }
    }
}
