package com.reactnativecommunity.cameraroll;

import android.webkit.MimeTypeMap;

public class Utils {
    public static String getMimeType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    public static String getExtension(String str) {
        return MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
    }
}
