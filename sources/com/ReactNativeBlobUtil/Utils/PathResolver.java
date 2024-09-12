package com.ReactNativeBlobUtil.Utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils;
import com.facebook.internal.security.CertificateUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class PathResolver {
    public static String getRealPathFromURI(Context context, Uri uri) {
        String contentName;
        Long l;
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
                File externalFilesDir = context.getExternalFilesDir((String) null);
                return externalFilesDir != null ? externalFilesDir + "/" + split[1] : "";
            }
        } else if (isDownloadsDocument(uri)) {
            try {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (documentId != null && documentId.startsWith("raw:/")) {
                    return Uri.parse(documentId).getPath();
                }
                if (documentId == null || !documentId.startsWith("msf:")) {
                    l = Long.valueOf(documentId);
                } else {
                    l = Long.valueOf(documentId.split(CertificateUtil.DELIMITER)[1]);
                }
                return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), l.longValue()), (String) null, (String[]) null);
            } catch (Exception unused) {
                return null;
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
        } else if (!"content".equalsIgnoreCase(uri.getScheme())) {
            try {
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                if (!(openInputStream == null || (contentName = getContentName(context.getContentResolver(), uri)) == null)) {
                    File file = new File(context.getCacheDir(), contentName);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[1024];
                    while (openInputStream.read(bArr) > 0) {
                        fileOutputStream.write(bArr);
                    }
                    fileOutputStream.close();
                    openInputStream.close();
                    return file.getAbsolutePath();
                }
            } catch (Exception e) {
                ReactNativeBlobUtilUtils.emitWarningEvent(e.toString());
                return null;
            }
        } else if (isGooglePhotosUri(uri)) {
            return uri.getLastPathSegment();
        } else {
            return getDataColumn(context, uri, (String) null, (String[]) null);
        }
        return null;
    }

    private static String getContentName(ContentResolver contentResolver, Uri uri) {
        Cursor query = contentResolver.query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
        query.moveToFirst();
        int columnIndex = query.getColumnIndex("_display_name");
        if (columnIndex < 0) {
            return null;
        }
        String string = query.getString(columnIndex);
        query.close();
        return string;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x002e, all -> 0x002c }
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x002e, all -> 0x002c }
            if (r8 == 0) goto L_0x0026
            boolean r9 = r8.moveToFirst()     // Catch:{ Exception -> 0x0024 }
            if (r9 == 0) goto L_0x0026
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0024 }
            java.lang.String r7 = r8.getString(r9)     // Catch:{ Exception -> 0x0024 }
            goto L_0x0026
        L_0x0024:
            r9 = move-exception
            goto L_0x0030
        L_0x0026:
            if (r8 == 0) goto L_0x002b
            r8.close()
        L_0x002b:
            return r7
        L_0x002c:
            r9 = move-exception
            goto L_0x003b
        L_0x002e:
            r9 = move-exception
            r8 = r7
        L_0x0030:
            r9.printStackTrace()     // Catch:{ all -> 0x0039 }
            if (r8 == 0) goto L_0x0038
            r8.close()
        L_0x0038:
            return r7
        L_0x0039:
            r9 = move-exception
            r7 = r8
        L_0x003b:
            if (r7 == 0) goto L_0x0040
            r7.close()
        L_0x0040:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.Utils.PathResolver.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
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
}
