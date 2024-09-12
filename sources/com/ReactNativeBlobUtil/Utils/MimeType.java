package com.ReactNativeBlobUtil.Utils;

import android.webkit.MimeTypeMap;
import org.apache.commons.lang3.StringUtils;

public class MimeType {
    static String APPLICATION = "application/*";
    static String AUDIO = "audio/*";
    static String BINARY_FILE = "application/octet-stream";
    static String CHEMICAL = "chemical/*";
    static String FONT = "font/*";
    static String IMAGE = "image/*";
    static String MODEL = "model/*";
    static String TEXT = "text/*";
    static String UNKNOWN = "*/*";
    static String VIDEO = "video/*";

    public static String getFullFileName(String str, String str2) {
        String extensionFromMimeType = getExtensionFromMimeType(str2);
        if (extensionFromMimeType == null || extensionFromMimeType.isEmpty() || str.endsWith("." + extensionFromMimeType)) {
            return str;
        }
        String str3 = str + "." + extensionFromMimeType;
        return str3.endsWith(".") ? StringUtils.stripEnd(str3, ".") : str3;
    }

    public static String getExtensionFromMimeType(String str) {
        if (str == null) {
            return "";
        }
        if (str.equals(BINARY_FILE)) {
            return "bin";
        }
        return MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
    }

    public static String getExtensionFromMimeTypeOrFileName(String str, String str2) {
        if (str == null || str.equals(UNKNOWN)) {
            return StringUtils.substringAfterLast(str2, ".");
        }
        return getExtensionFromMimeType(str);
    }

    public static String getMimeTypeFromExtension(String str) {
        if (str.equals("bin")) {
            return BINARY_FILE;
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        if (mimeTypeFromExtension != null) {
            return mimeTypeFromExtension;
        }
        return UNKNOWN;
    }
}
