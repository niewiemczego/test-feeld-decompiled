package com.yalantis.ucrop.util;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;

public class FileUtils {
    private static final String TAG = "FileUtils";

    private FileUtils() {
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r8 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        if (r8 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ IllegalArgumentException -> 0x0033, all -> 0x0031 }
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x0033, all -> 0x0031 }
            if (r8 == 0) goto L_0x002b
            boolean r9 = r8.moveToFirst()     // Catch:{ IllegalArgumentException -> 0x0029 }
            if (r9 == 0) goto L_0x002b
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch:{ IllegalArgumentException -> 0x0029 }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ IllegalArgumentException -> 0x0029 }
            if (r8 == 0) goto L_0x0028
            r8.close()
        L_0x0028:
            return r9
        L_0x0029:
            r9 = move-exception
            goto L_0x0035
        L_0x002b:
            if (r8 == 0) goto L_0x0051
        L_0x002d:
            r8.close()
            goto L_0x0051
        L_0x0031:
            r9 = move-exception
            goto L_0x0054
        L_0x0033:
            r9 = move-exception
            r8 = r7
        L_0x0035:
            java.lang.String r10 = "FileUtils"
            java.util.Locale r11 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = "getDataColumn: _data - [%s]"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0052 }
            r2 = 0
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x0052 }
            r1[r2] = r9     // Catch:{ all -> 0x0052 }
            java.lang.String r9 = java.lang.String.format(r11, r0, r1)     // Catch:{ all -> 0x0052 }
            android.util.Log.i(r10, r9)     // Catch:{ all -> 0x0052 }
            if (r8 == 0) goto L_0x0051
            goto L_0x002d
        L_0x0051:
            return r7
        L_0x0052:
            r9 = move-exception
            r7 = r8
        L_0x0054:
            if (r7 == 0) goto L_0x0059
            r7.close()
        L_0x0059:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.FileUtils.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static String getPath(Context context, Uri uri) {
        Uri uri2 = null;
        if (!(Build.VERSION.SDK_INT >= 19) || !DocumentsContract.isDocumentUri(context, uri)) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (isGooglePhotosUri(uri)) {
                    return uri.getLastPathSegment();
                }
                return getDataColumn(context, uri, (String) null, (String[]) null);
            } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        } else if (isExternalStorageDocument(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(CertificateUtil.DELIMITER);
            if ("primary".equalsIgnoreCase(split[0])) {
                return Environment.getExternalStorageDirectory() + "/" + split[1];
            }
        } else if (isDownloadsDocument(uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            if (!TextUtils.isEmpty(documentId)) {
                try {
                    return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), (String) null, (String[]) null);
                } catch (NumberFormatException e) {
                    Log.i(TAG, e.getMessage());
                    return null;
                }
            }
        } else if (isMediaDocument(uri)) {
            String[] split2 = DocumentsContract.getDocumentId(uri).split(CertificateUtil.DELIMITER);
            String str = split2[0];
            if ("image".equals(str)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyFile(java.lang.String r10, java.lang.String r11) throws java.io.IOException {
        /*
            boolean r0 = r10.equalsIgnoreCase(r11)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0042 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0042 }
            r2.<init>(r10)     // Catch:{ all -> 0x0042 }
            r1.<init>(r2)     // Catch:{ all -> 0x0042 }
            java.nio.channels.FileChannel r10 = r1.getChannel()     // Catch:{ all -> 0x0042 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x003d }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x003d }
            r2.<init>(r11)     // Catch:{ all -> 0x003d }
            r1.<init>(r2)     // Catch:{ all -> 0x003d }
            java.nio.channels.FileChannel r0 = r1.getChannel()     // Catch:{ all -> 0x003d }
            r4 = 0
            long r6 = r10.size()     // Catch:{ all -> 0x003d }
            r3 = r10
            r8 = r0
            r3.transferTo(r4, r6, r8)     // Catch:{ all -> 0x003d }
            r10.close()     // Catch:{ all -> 0x003d }
            if (r10 == 0) goto L_0x0037
            r10.close()
        L_0x0037:
            if (r0 == 0) goto L_0x003c
            r0.close()
        L_0x003c:
            return
        L_0x003d:
            r11 = move-exception
            r9 = r0
            r0 = r10
            r10 = r9
            goto L_0x0044
        L_0x0042:
            r11 = move-exception
            r10 = r0
        L_0x0044:
            if (r0 == 0) goto L_0x0049
            r0.close()
        L_0x0049:
            if (r10 == 0) goto L_0x004e
            r10.close()
        L_0x004e:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.FileUtils.copyFile(java.lang.String, java.lang.String):void");
    }
}
