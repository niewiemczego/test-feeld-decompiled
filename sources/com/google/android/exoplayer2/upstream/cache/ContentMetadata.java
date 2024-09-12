package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;

public interface ContentMetadata {
    public static final String KEY_CONTENT_LENGTH = "exo_len";
    public static final String KEY_CUSTOM_PREFIX = "custom_";
    public static final String KEY_REDIRECTED_URI = "exo_redir";

    boolean contains(String str);

    long get(String str, long j);

    String get(String str, String str2);

    byte[] get(String str, byte[] bArr);

    static long getContentLength(ContentMetadata contentMetadata) {
        return contentMetadata.get(KEY_CONTENT_LENGTH, -1);
    }

    static Uri getRedirectedUri(ContentMetadata contentMetadata) {
        String str = null;
        String str2 = contentMetadata.get(KEY_REDIRECTED_URI, (String) null);
        if (str2 == null) {
            return null;
        }
        return Uri.parse(str2);
    }
}
