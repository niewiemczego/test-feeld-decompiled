package com.ReactNativeBlobUtil;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import com.ReactNativeBlobUtil.Utils.FileDescription;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

public class ReactNativeBlobUtilMediaCollection {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public enum MediaType {
        Audio,
        Image,
        Video,
        Download
    }

    private static Uri getMediaUri(MediaType mediaType) {
        if (mediaType == MediaType.Audio) {
            if (Build.VERSION.SDK_INT >= 29) {
                return MediaStore.Audio.Media.getContentUri("external_primary");
            }
            return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        } else if (mediaType == MediaType.Video) {
            if (Build.VERSION.SDK_INT >= 29) {
                return MediaStore.Video.Media.getContentUri("external_primary");
            }
            return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else if (mediaType == MediaType.Image) {
            if (Build.VERSION.SDK_INT >= 29) {
                return MediaStore.Images.Media.getContentUri("external_primary");
            }
            return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if (mediaType != MediaType.Download || Build.VERSION.SDK_INT < 29) {
            return null;
        } else {
            return MediaStore.Downloads.getContentUri("external_primary");
        }
    }

    private static String getRelativePath(MediaType mediaType, ReactApplicationContext reactApplicationContext) {
        if (Build.VERSION.SDK_INT >= 29) {
            if (mediaType == MediaType.Audio) {
                return Environment.DIRECTORY_MUSIC;
            }
            if (mediaType == MediaType.Video) {
                return Environment.DIRECTORY_MOVIES;
            }
            if (mediaType == MediaType.Image) {
                return Environment.DIRECTORY_PICTURES;
            }
            if (mediaType == MediaType.Download) {
                return Environment.DIRECTORY_DOWNLOADS;
            }
            return Environment.DIRECTORY_DOWNLOADS;
        } else if (mediaType == MediaType.Audio) {
            return ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyMusicDir").toString();
        } else {
            if (mediaType == MediaType.Video) {
                return ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyMovieDir").toString();
            }
            if (mediaType == MediaType.Image) {
                return ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyPictureDir").toString();
            }
            if (mediaType == MediaType.Download) {
                return ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyDownloadDir").toString();
            }
            return ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyDownloadDir").toString();
        }
    }

    public static Uri createNewMediaFile(FileDescription fileDescription, MediaType mediaType, ReactApplicationContext reactApplicationContext) {
        ContentResolver contentResolver = ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getContentResolver();
        ContentValues contentValues = new ContentValues();
        String relativePath = getRelativePath(mediaType, reactApplicationContext);
        String str = fileDescription.mimeType;
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("date_added", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("date_modified", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("mime_type", str);
            contentValues.put("_display_name", fileDescription.name);
            contentValues.put("relative_path", relativePath + IOUtils.DIR_SEPARATOR_UNIX + fileDescription.partentFolder);
            try {
                return contentResolver.insert(getMediaUri(mediaType), contentValues);
            } catch (Exception unused) {
                return null;
            }
        } else {
            File file = new File(relativePath + fileDescription.getFullPath());
            if (file.exists()) {
                return Uri.fromFile(file);
            }
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                return null;
            }
            try {
                file.createNewFile();
                return Uri.fromFile(file);
            } catch (IOException unused2) {
                return null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ce A[SYNTHETIC, Splitter:B:47:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d6 A[Catch:{ IOException -> 0x00da }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean writeToMediaFile(android.net.Uri r9, java.lang.String r10, boolean r11, com.facebook.react.bridge.Promise r12, com.facebook.react.bridge.ReactApplicationContext r13) {
        /*
            java.lang.String r0 = "Failed to get output stream."
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 0
            r3 = 29
            if (r1 < r3) goto L_0x00e2
            android.content.Context r13 = r13.getApplicationContext()     // Catch:{ IOException -> 0x00da }
            android.content.ContentResolver r1 = r13.getContentResolver()     // Catch:{ IOException -> 0x00da }
            r3 = 0
            android.content.ContentResolver r13 = r13.getContentResolver()     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r4 = "w"
            android.os.ParcelFileDescriptor r13 = r13.openFileDescriptor(r9, r4)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r10 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r10)     // Catch:{ Exception -> 0x00b5 }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x00b5 }
            r4.<init>(r10)     // Catch:{ Exception -> 0x00b5 }
            boolean r5 = r4.exists()     // Catch:{ Exception -> 0x00b5 }
            if (r5 != 0) goto L_0x004a
            java.lang.String r9 = "ENOENT"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b5 }
            r11.<init>()     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r13 = "No such file ('"
            java.lang.StringBuilder r11 = r11.append(r13)     // Catch:{ Exception -> 0x00b5 }
            java.lang.StringBuilder r10 = r11.append(r10)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r11 = "')"
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x00b5 }
            r12.reject((java.lang.String) r9, (java.lang.String) r10)     // Catch:{ Exception -> 0x00b5 }
            return r2
        L_0x004a:
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00b5 }
            r10.<init>(r4)     // Catch:{ Exception -> 0x00b5 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00b5 }
            java.io.FileDescriptor r6 = r13.getFileDescriptor()     // Catch:{ Exception -> 0x00b5 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00b5 }
            if (r11 == 0) goto L_0x007a
            long r6 = r4.length()     // Catch:{ Exception -> 0x00b5 }
            int r11 = (int) r6     // Catch:{ Exception -> 0x00b5 }
            byte[] r11 = new byte[r11]     // Catch:{ Exception -> 0x00b5 }
            r10.read(r11)     // Catch:{ Exception -> 0x00b5 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r4 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ Exception -> 0x00b5 }
            if (r4 == 0) goto L_0x0072
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r4 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ Exception -> 0x00b5 }
            byte[] r11 = r4.onWriteFile(r11)     // Catch:{ Exception -> 0x00b5 }
            r5.write(r11)     // Catch:{ Exception -> 0x00b5 }
            goto L_0x0088
        L_0x0072:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r10 = "Write to media file with transform was specified but the shared file transformer is not set"
            r9.<init>(r10)     // Catch:{ Exception -> 0x00b5 }
            throw r9     // Catch:{ Exception -> 0x00b5 }
        L_0x007a:
            r11 = 10240(0x2800, float:1.4349E-41)
            byte[] r11 = new byte[r11]     // Catch:{ Exception -> 0x00b5 }
        L_0x007e:
            int r4 = r10.read(r11)     // Catch:{ Exception -> 0x00b5 }
            if (r4 <= 0) goto L_0x0088
            r5.write(r11, r2, r4)     // Catch:{ Exception -> 0x00b5 }
            goto L_0x007e
        L_0x0088:
            r10.close()     // Catch:{ Exception -> 0x00b5 }
            r5.close()     // Catch:{ Exception -> 0x00b5 }
            r13.close()     // Catch:{ Exception -> 0x00b5 }
            java.io.OutputStream r9 = r1.openOutputStream(r9)     // Catch:{ IOException -> 0x00c4, all -> 0x00c2 }
            if (r9 != 0) goto L_0x00ae
            java.io.IOException r10 = new java.io.IOException     // Catch:{ IOException -> 0x00a9, all -> 0x00a5 }
            r10.<init>(r0)     // Catch:{ IOException -> 0x00a9, all -> 0x00a5 }
            r12.reject((java.lang.Throwable) r10)     // Catch:{ IOException -> 0x00a9, all -> 0x00a5 }
            if (r9 == 0) goto L_0x00a4
            r9.close()     // Catch:{ IOException -> 0x00da }
        L_0x00a4:
            return r2
        L_0x00a5:
            r10 = move-exception
            r3 = r9
            r9 = r10
            goto L_0x00d4
        L_0x00a9:
            r10 = move-exception
            r8 = r10
            r10 = r9
            r9 = r8
            goto L_0x00c6
        L_0x00ae:
            if (r9 == 0) goto L_0x00b3
            r9.close()     // Catch:{ IOException -> 0x00da }
        L_0x00b3:
            r9 = 1
            return r9
        L_0x00b5:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ IOException -> 0x00c4, all -> 0x00c2 }
            java.io.IOException r9 = new java.io.IOException     // Catch:{ IOException -> 0x00c4, all -> 0x00c2 }
            r9.<init>(r0)     // Catch:{ IOException -> 0x00c4, all -> 0x00c2 }
            r12.reject((java.lang.Throwable) r9)     // Catch:{ IOException -> 0x00c4, all -> 0x00c2 }
            return r2
        L_0x00c2:
            r9 = move-exception
            goto L_0x00d4
        L_0x00c4:
            r9 = move-exception
            r10 = r3
        L_0x00c6:
            r1.delete(r3, r3, r3)     // Catch:{ all -> 0x00d2 }
            r12.reject((java.lang.Throwable) r9)     // Catch:{ all -> 0x00d2 }
            if (r10 == 0) goto L_0x00d1
            r10.close()     // Catch:{ IOException -> 0x00da }
        L_0x00d1:
            return r2
        L_0x00d2:
            r9 = move-exception
            r3 = r10
        L_0x00d4:
            if (r3 == 0) goto L_0x00d9
            r3.close()     // Catch:{ IOException -> 0x00da }
        L_0x00d9:
            throw r9     // Catch:{ IOException -> 0x00da }
        L_0x00da:
            java.lang.String r9 = "ReactNativeBlobUtil.createMediaFile"
            java.lang.String r10 = "Cannot write to file, file might not exist"
            r12.reject((java.lang.String) r9, (java.lang.String) r10)
            return r2
        L_0x00e2:
            java.lang.String r9 = r9.toString()
            java.lang.String r9 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r9)
            java.lang.String r11 = "uri"
            boolean r9 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.writeFile((java.lang.String) r9, (java.lang.String) r11, (java.lang.String) r10, (boolean) r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilMediaCollection.writeToMediaFile(android.net.Uri, java.lang.String, boolean, com.facebook.react.bridge.Promise, com.facebook.react.bridge.ReactApplicationContext):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d5 A[SYNTHETIC, Splitter:B:52:0x00d5] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00df A[SYNTHETIC, Splitter:B:57:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00eb A[SYNTHETIC, Splitter:B:63:0x00eb] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f5 A[SYNTHETIC, Splitter:B:68:0x00f5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyToInternal(android.net.Uri r4, java.lang.String r5, com.facebook.react.bridge.Promise r6) {
        /*
            com.facebook.react.bridge.ReactApplicationContext r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.RCTContext
            android.content.Context r0 = r0.getApplicationContext()
            android.content.ContentResolver r0 = r0.getContentResolver()
            java.io.File r1 = new java.io.File
            r1.<init>(r5)
            boolean r2 = r1.exists()
            if (r2 != 0) goto L_0x007c
            java.io.File r2 = r1.getParentFile()     // Catch:{ IOException -> 0x0061 }
            if (r2 == 0) goto L_0x003e
            boolean r3 = r2.exists()     // Catch:{ IOException -> 0x0061 }
            if (r3 != 0) goto L_0x003e
            boolean r2 = r2.mkdirs()     // Catch:{ IOException -> 0x0061 }
            if (r2 != 0) goto L_0x003e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0061 }
            r1.<init>()     // Catch:{ IOException -> 0x0061 }
            java.lang.String r2 = "ReactNativeBlobUtil.copyToInternal: Cannot create parent folders<'"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ IOException -> 0x0061 }
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch:{ IOException -> 0x0061 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0061 }
            r6.reject((java.lang.String) r1)     // Catch:{ IOException -> 0x0061 }
            return
        L_0x003e:
            boolean r1 = r1.createNewFile()     // Catch:{ IOException -> 0x0061 }
            if (r1 != 0) goto L_0x007c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0061 }
            r1.<init>()     // Catch:{ IOException -> 0x0061 }
            java.lang.String r2 = "ReactNativeBlobUtil.copyToInternal: Destination file at '"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ IOException -> 0x0061 }
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch:{ IOException -> 0x0061 }
            java.lang.String r2 = "' already exists"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ IOException -> 0x0061 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0061 }
            r6.reject((java.lang.String) r1)     // Catch:{ IOException -> 0x0061 }
            return
        L_0x0061:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "ReactNativeBlobUtil.copyToInternal: Could not create file: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r1 = r1.getLocalizedMessage()
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            r6.reject((java.lang.String) r1)
        L_0x007c:
            r1 = 0
            java.io.InputStream r4 = r0.openInputStream(r4)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00b0, all -> 0x00ac }
            r0.<init>(r5)     // Catch:{ IOException -> 0x00b0, all -> 0x00ac }
            r5 = 10240(0x2800, float:1.4349E-41)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x00aa, all -> 0x00a8 }
        L_0x008a:
            int r1 = r4.read(r5)     // Catch:{ IOException -> 0x00aa, all -> 0x00a8 }
            if (r1 <= 0) goto L_0x0095
            r2 = 0
            r0.write(r5, r2, r1)     // Catch:{ IOException -> 0x00aa, all -> 0x00a8 }
            goto L_0x008a
        L_0x0095:
            if (r4 == 0) goto L_0x009f
            r4.close()     // Catch:{ IOException -> 0x009b }
            goto L_0x009f
        L_0x009b:
            r4 = move-exception
            r4.printStackTrace()
        L_0x009f:
            r0.close()     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00e2
        L_0x00a3:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x00e2
        L_0x00a8:
            r5 = move-exception
            goto L_0x00ae
        L_0x00aa:
            r5 = move-exception
            goto L_0x00b2
        L_0x00ac:
            r5 = move-exception
            r0 = r1
        L_0x00ae:
            r1 = r4
            goto L_0x00e9
        L_0x00b0:
            r5 = move-exception
            r0 = r1
        L_0x00b2:
            r1 = r4
            goto L_0x00b9
        L_0x00b4:
            r5 = move-exception
            r0 = r1
            goto L_0x00e9
        L_0x00b7:
            r5 = move-exception
            r0 = r1
        L_0x00b9:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e8 }
            r4.<init>()     // Catch:{ all -> 0x00e8 }
            java.lang.String r2 = "ReactNativeBlobUtil.copyToInternal:  Could not write data: "
            java.lang.StringBuilder r4 = r4.append(r2)     // Catch:{ all -> 0x00e8 }
            java.lang.String r5 = r5.getLocalizedMessage()     // Catch:{ all -> 0x00e8 }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x00e8 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00e8 }
            r6.reject((java.lang.String) r4)     // Catch:{ all -> 0x00e8 }
            if (r1 == 0) goto L_0x00dd
            r1.close()     // Catch:{ IOException -> 0x00d9 }
            goto L_0x00dd
        L_0x00d9:
            r4 = move-exception
            r4.printStackTrace()
        L_0x00dd:
            if (r0 == 0) goto L_0x00e2
            r0.close()     // Catch:{ IOException -> 0x00a3 }
        L_0x00e2:
            java.lang.String r4 = ""
            r6.resolve(r4)
            return
        L_0x00e8:
            r5 = move-exception
        L_0x00e9:
            if (r1 == 0) goto L_0x00f3
            r1.close()     // Catch:{ IOException -> 0x00ef }
            goto L_0x00f3
        L_0x00ef:
            r4 = move-exception
            r4.printStackTrace()
        L_0x00f3:
            if (r0 == 0) goto L_0x00fd
            r0.close()     // Catch:{ IOException -> 0x00f9 }
            goto L_0x00fd
        L_0x00f9:
            r4 = move-exception
            r4.printStackTrace()
        L_0x00fd:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilMediaCollection.copyToInternal(android.net.Uri, java.lang.String, com.facebook.react.bridge.Promise):void");
    }

    public static void getBlob(Uri uri, String str, Promise promise) {
        try {
            InputStream openInputStream = ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getContentResolver().openInputStream(uri);
            int available = openInputStream.available();
            byte[] bArr = new byte[available];
            int read = openInputStream.read(bArr);
            openInputStream.close();
            if (read < available) {
                promise.reject("EUNSPECIFIED", "Read only " + read + " bytes of " + available);
                return;
            }
            String lowerCase = str.toLowerCase();
            char c = 65535;
            int hashCode = lowerCase.hashCode();
            if (hashCode != -1396204209) {
                if (hashCode == 93106001) {
                    if (lowerCase.equals("ascii")) {
                        c = 1;
                    }
                }
            } else if (lowerCase.equals(ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64)) {
                c = 0;
            }
            if (c == 0) {
                promise.resolve(Base64.encodeToString(bArr, 2));
            } else if (c != 1) {
                promise.resolve(new String(bArr));
            } else {
                WritableArray createArray = Arguments.createArray();
                for (int i = 0; i < available; i++) {
                    createArray.pushInt(bArr[i]);
                }
                promise.resolve(createArray);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
