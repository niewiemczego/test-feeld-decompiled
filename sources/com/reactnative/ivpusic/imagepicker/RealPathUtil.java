package com.reactnative.ivpusic.imagepicker;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.facebook.internal.security.CertificateUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

class RealPathUtil {
    RealPathUtil() {
    }

    static String getRealPathFromURI(Context context, Uri uri) throws IOException {
        Uri uri2 = null;
        if (!(Build.VERSION.SDK_INT == 19) || !DocumentsContract.isDocumentUri(context, uri)) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (isGooglePhotosUri(uri)) {
                    return uri.getLastPathSegment();
                }
                return getDataColumn(context, uri, (String) null, (String[]) null);
            } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        } else if (isExternalStorageDocument(uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            String[] split = documentId.split(CertificateUtil.DELIMITER);
            if ("primary".equalsIgnoreCase(split[0])) {
                return Environment.getExternalStorageDirectory() + "/" + split[1];
            }
            int indexOf = documentId.indexOf(58, 1);
            String substring = documentId.substring(0, indexOf);
            String substring2 = documentId.substring(indexOf + 1);
            String pathToNonPrimaryVolume = getPathToNonPrimaryVolume(context, substring);
            if (pathToNonPrimaryVolume != null) {
                String str = pathToNonPrimaryVolume + "/" + substring2;
                File file = new File(str);
                if (!file.exists() || !file.canRead()) {
                    return null;
                }
                return str;
            }
        } else if (isDownloadsDocument(uri)) {
            return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), (String) null, (String[]) null);
        } else if (isMediaDocument(uri)) {
            String[] split2 = DocumentsContract.getDocumentId(uri).split(CertificateUtil.DELIMITER);
            String str2 = split2[0];
            if ("image".equals(str2)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str2)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str2)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
        }
        return null;
    }

    private static File writeToFile(Context context, String str, Uri uri) {
        String str2 = context.getCacheDir() + "/react-native-image-crop-picker";
        Boolean.valueOf(new File(str2).mkdir());
        File file = new File(new File(str2), str.substring(str.lastIndexOf(47) + 1));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[8192];
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            while (true) {
                int read = openInputStream.read(bArr, 0, 8192);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
                fileOutputStream.flush();
            }
            fileOutputStream.close();
            openInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    /* JADX WARNING: type inference failed for: r8v4, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getDataColumn(android.content.Context r9, android.net.Uri r10, java.lang.String r11, java.lang.String[] r12) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String r1 = "_display_name"
            java.lang.String[] r4 = new java.lang.String[]{r0, r1}
            r8 = 0
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch:{ all -> 0x0053 }
            r7 = 0
            r3 = r10
            r5 = r11
            r6 = r12
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0053 }
            if (r11 == 0) goto L_0x004d
            boolean r12 = r11.moveToFirst()     // Catch:{ all -> 0x004a }
            if (r12 == 0) goto L_0x004d
            int r12 = r11.getColumnIndex(r0)     // Catch:{ all -> 0x004a }
            r0 = -1
            if (r12 <= r0) goto L_0x0028
            java.lang.String r8 = r11.getString(r12)     // Catch:{ all -> 0x004a }
        L_0x0028:
            if (r8 == 0) goto L_0x0034
            java.lang.String r9 = r11.getString(r12)     // Catch:{ all -> 0x004a }
            if (r11 == 0) goto L_0x0033
            r11.close()
        L_0x0033:
            return r9
        L_0x0034:
            int r12 = r11.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x004a }
            java.lang.String r12 = r11.getString(r12)     // Catch:{ all -> 0x004a }
            java.io.File r9 = writeToFile(r9, r12, r10)     // Catch:{ all -> 0x004a }
            java.lang.String r9 = r9.getAbsolutePath()     // Catch:{ all -> 0x004a }
            if (r11 == 0) goto L_0x0049
            r11.close()
        L_0x0049:
            return r9
        L_0x004a:
            r9 = move-exception
            r8 = r11
            goto L_0x0054
        L_0x004d:
            if (r11 == 0) goto L_0x0052
            r11.close()
        L_0x0052:
            return r8
        L_0x0053:
            r9 = move-exception
        L_0x0054:
            if (r8 == 0) goto L_0x0059
            r8.close()
        L_0x0059:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnative.ivpusic.imagepicker.RealPathUtil.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    private static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    private static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    private static String getPathToNonPrimaryVolume(Context context, String str) {
        String absolutePath;
        int indexOf;
        File[] externalCacheDirs = context.getExternalCacheDirs();
        if (externalCacheDirs == null) {
            return null;
        }
        for (File file : externalCacheDirs) {
            if (file != null && (absolutePath = file.getAbsolutePath()) != null && (indexOf = absolutePath.indexOf(str)) != -1) {
                return absolutePath.substring(0, indexOf) + str;
            }
        }
        return null;
    }
}
