package com.ReactNativeBlobUtil;

import android.content.res.AssetFileDescriptor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import androidx.work.Data;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

class ReactNativeBlobUtilFS {
    private DeviceEventManagerModule.RCTDeviceEventEmitter emitter;
    private ReactApplicationContext mCtx;

    ReactNativeBlobUtilFS(ReactApplicationContext reactApplicationContext) {
        this.mCtx = reactApplicationContext;
        this.emitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0072 A[Catch:{ all -> 0x008d, FileNotFoundException | Exception -> 0x0092 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0077 A[Catch:{ all -> 0x008d, FileNotFoundException | Exception -> 0x0092 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean writeFile(java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            r0 = 0
            java.lang.String r3 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r3)     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            r1.<init>(r3)     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            java.io.File r3 = r1.getParentFile()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            boolean r2 = r1.exists()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            if (r2 != 0) goto L_0x0030
            if (r3 == 0) goto L_0x0029
            boolean r2 = r3.exists()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            if (r2 != 0) goto L_0x0029
            boolean r2 = r3.mkdirs()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            if (r2 != 0) goto L_0x0029
            boolean r3 = r3.exists()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            if (r3 != 0) goto L_0x0029
            return r0
        L_0x0029:
            boolean r3 = r1.createNewFile()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            if (r3 != 0) goto L_0x0030
            return r0
        L_0x0030:
            java.lang.String r3 = "uri"
            boolean r3 = r4.equalsIgnoreCase(r3)     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            if (r3 == 0) goto L_0x007b
            java.lang.String r3 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r5)     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            java.io.File r4 = new java.io.File     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            r4.<init>(r3)     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            boolean r3 = r4.exists()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            if (r3 != 0) goto L_0x0048
            return r0
        L_0x0048:
            r3 = 10240(0x2800, float:1.4349E-41)
            byte[] r3 = new byte[r3]     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            r5 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x006e }
            r2.<init>(r4)     // Catch:{ all -> 0x006e }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x006a }
            r4.<init>(r1, r6)     // Catch:{ all -> 0x006a }
        L_0x0057:
            int r5 = r2.read(r3)     // Catch:{ all -> 0x0068 }
            if (r5 <= 0) goto L_0x0061
            r4.write(r3, r0, r5)     // Catch:{ all -> 0x0068 }
            goto L_0x0057
        L_0x0061:
            r2.close()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            r4.close()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            goto L_0x008b
        L_0x0068:
            r3 = move-exception
            goto L_0x006c
        L_0x006a:
            r3 = move-exception
            r4 = r5
        L_0x006c:
            r5 = r2
            goto L_0x0070
        L_0x006e:
            r3 = move-exception
            r4 = r5
        L_0x0070:
            if (r5 == 0) goto L_0x0075
            r5.close()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
        L_0x0075:
            if (r4 == 0) goto L_0x007a
            r4.close()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
        L_0x007a:
            throw r3     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
        L_0x007b:
            byte[] r3 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.stringToBytes(r5, r4)     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            r4.<init>(r1, r6)     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            r4.write(r3)     // Catch:{ all -> 0x008d }
            int r3 = r3.length     // Catch:{ all -> 0x008d }
            r4.close()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
        L_0x008b:
            r3 = 1
            return r3
        L_0x008d:
            r3 = move-exception
            r4.close()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            throw r3     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
        L_0x0092:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.writeFile(java.lang.String, java.lang.String, java.lang.String, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d2 A[Catch:{ all -> 0x0108, FileNotFoundException -> 0x0116, Exception -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d7 A[Catch:{ all -> 0x0108, FileNotFoundException -> 0x0116, Exception -> 0x010d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void writeFile(java.lang.String r6, java.lang.String r7, java.lang.String r8, boolean r9, boolean r10, com.facebook.react.bridge.Promise r11) {
        /*
            java.lang.String r0 = "EUNSPECIFIED"
            java.lang.String r1 = "File '"
            java.lang.String r2 = "ENOENT"
            java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            r3.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            java.io.File r4 = r3.getParentFile()     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            boolean r5 = r3.exists()     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            if (r5 != 0) goto L_0x0067
            if (r4 == 0) goto L_0x0046
            boolean r5 = r4.exists()     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            if (r5 != 0) goto L_0x0046
            boolean r5 = r4.mkdirs()     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            if (r5 != 0) goto L_0x0046
            boolean r4 = r4.exists()     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            if (r4 != 0) goto L_0x0046
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            r7.<init>()     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            java.lang.String r8 = "Failed to create parent directory of '"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            java.lang.StringBuilder r7 = r7.append(r6)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            java.lang.String r8 = "'"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            java.lang.String r7 = r7.toString()     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            r11.reject((java.lang.String) r0, (java.lang.String) r7)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            return
        L_0x0046:
            boolean r4 = r3.createNewFile()     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            if (r4 != 0) goto L_0x0067
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            r7.<init>()     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            java.lang.StringBuilder r7 = r7.append(r1)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            java.lang.StringBuilder r7 = r7.append(r6)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            java.lang.String r8 = "' does not exist and could not be created"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            java.lang.String r7 = r7.toString()     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            r11.reject((java.lang.String) r2, (java.lang.String) r7)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            return
        L_0x0067:
            java.lang.String r4 = "uri"
            boolean r4 = r7.equalsIgnoreCase(r4)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            if (r4 == 0) goto L_0x00db
            java.lang.String r7 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r8)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            java.io.File r8 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            r8.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            boolean r9 = r8.exists()     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            if (r9 != 0) goto L_0x00a5
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            java.lang.String r9 = "No such file '"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            java.lang.StringBuilder r8 = r8.append(r6)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            java.lang.String r9 = "' ('"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            java.lang.StringBuilder r7 = r8.append(r7)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            java.lang.String r8 = "')"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            java.lang.String r7 = r7.toString()     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            r11.reject((java.lang.String) r2, (java.lang.String) r7)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            return
        L_0x00a5:
            r7 = 10240(0x2800, float:1.4349E-41)
            byte[] r7 = new byte[r7]     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            r9 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x00ce }
            r4.<init>(r8)     // Catch:{ all -> 0x00ce }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ all -> 0x00ca }
            r8.<init>(r3, r10)     // Catch:{ all -> 0x00ca }
            r9 = 0
            r10 = r9
        L_0x00b6:
            int r3 = r4.read(r7)     // Catch:{ all -> 0x00c8 }
            if (r3 <= 0) goto L_0x00c1
            r8.write(r7, r9, r3)     // Catch:{ all -> 0x00c8 }
            int r10 = r10 + r3
            goto L_0x00b6
        L_0x00c1:
            r4.close()     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            r8.close()     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            goto L_0x0100
        L_0x00c8:
            r7 = move-exception
            goto L_0x00cc
        L_0x00ca:
            r7 = move-exception
            r8 = r9
        L_0x00cc:
            r9 = r4
            goto L_0x00d0
        L_0x00ce:
            r7 = move-exception
            r8 = r9
        L_0x00d0:
            if (r9 == 0) goto L_0x00d5
            r9.close()     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
        L_0x00d5:
            if (r8 == 0) goto L_0x00da
            r8.close()     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
        L_0x00da:
            throw r7     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
        L_0x00db:
            byte[] r7 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.stringToBytes(r8, r7)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            if (r9 == 0) goto L_0x00f4
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r8 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            if (r8 == 0) goto L_0x00ec
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r8 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            byte[] r7 = r8.onWriteFile(r7)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            goto L_0x00f4
        L_0x00ec:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            java.lang.String r8 = "Write file with transform was specified but the shared file transformer is not set"
            r7.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            throw r7     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
        L_0x00f4:
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            r8.<init>(r3, r10)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            r8.write(r7)     // Catch:{ all -> 0x0108 }
            int r10 = r7.length     // Catch:{ all -> 0x0108 }
            r8.close()     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
        L_0x0100:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r10)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            r11.resolve(r7)     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            goto L_0x0130
        L_0x0108:
            r7 = move-exception
            r8.close()     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
            throw r7     // Catch:{ FileNotFoundException -> 0x0116, Exception -> 0x010d }
        L_0x010d:
            r6 = move-exception
            java.lang.String r6 = r6.getLocalizedMessage()
            r11.reject((java.lang.String) r0, (java.lang.String) r6)
            goto L_0x0130
        L_0x0116:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.StringBuilder r7 = r7.append(r1)
            java.lang.StringBuilder r6 = r7.append(r6)
            java.lang.String r7 = "' does not exist and could not be created, or it is a directory"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            r11.reject((java.lang.String) r2, (java.lang.String) r6)
        L_0x0130:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.writeFile(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, com.facebook.react.bridge.Promise):void");
    }

    static void writeFile(String str, ReadableArray readableArray, boolean z, Promise promise) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!file.exists()) {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
                    promise.reject("ENOTDIR", "Failed to create parent directory of '" + str + "'");
                    return;
                } else if (!file.createNewFile()) {
                    promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            }
            fileOutputStream = new FileOutputStream(file, z);
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            promise.resolve(Integer.valueOf(readableArray.size()));
        } catch (FileNotFoundException unused) {
            promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x006b A[Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x008c A[Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void readFile(java.lang.String r7, java.lang.String r8, boolean r9, com.facebook.react.bridge.Promise r10) {
        /*
            java.lang.String r0 = "bundle-assets://"
            java.lang.String r1 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r7)
            if (r1 == 0) goto L_0x0009
            r7 = r1
        L_0x0009:
            java.lang.String r2 = "EUNSPECIFIED"
            r3 = 0
            if (r1 == 0) goto L_0x0032
            boolean r4 = r1.startsWith(r0)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            if (r4 == 0) goto L_0x0032
            java.lang.String r1 = ""
            java.lang.String r0 = r7.replace(r0, r1)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            com.facebook.react.bridge.ReactApplicationContext r1 = com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.RCTContext     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            java.io.InputStream r0 = r1.open(r0)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            int r1 = r0.available()     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            byte[] r4 = new byte[r1]     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            int r5 = r0.read(r4, r3, r1)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            r0.close()     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            goto L_0x0069
        L_0x0032:
            if (r1 != 0) goto L_0x0050
            com.facebook.react.bridge.ReactApplicationContext r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.RCTContext     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            android.net.Uri r1 = android.net.Uri.parse(r7)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            java.io.InputStream r0 = r0.openInputStream(r1)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            int r1 = r0.available()     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            byte[] r4 = new byte[r1]     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            int r5 = r0.read(r4)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            r0.close()     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            goto L_0x0069
        L_0x0050:
            java.io.File r0 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            r0.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            long r4 = r0.length()     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            int r1 = (int) r4     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            byte[] r4 = new byte[r1]     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            r5.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            int r0 = r5.read(r4)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            r5.close()     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            r5 = r0
        L_0x0069:
            if (r5 >= r1) goto L_0x008c
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            java.lang.String r9 = "Read only "
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            java.lang.StringBuilder r8 = r8.append(r5)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            java.lang.String r9 = " bytes of "
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            java.lang.StringBuilder r8 = r8.append(r1)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            java.lang.String r8 = r8.toString()     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            r10.reject((java.lang.String) r2, (java.lang.String) r8)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            return
        L_0x008c:
            if (r9 == 0) goto L_0x00a1
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r9 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            if (r9 == 0) goto L_0x0099
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r9 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            byte[] r4 = r9.onReadFile(r4)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            goto L_0x00a1
        L_0x0099:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            java.lang.String r9 = "Read file with transform was specified but the shared file transformer is not set"
            r8.<init>(r9)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            throw r8     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
        L_0x00a1:
            java.util.Locale r9 = java.util.Locale.ROOT     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            java.lang.String r8 = r8.toLowerCase(r9)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            r9 = -1
            int r0 = r8.hashCode()     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            r1 = -1396204209(0xffffffffacc79d4f, float:-5.673385E-12)
            r5 = 2
            r6 = 1
            if (r0 == r1) goto L_0x00d2
            r1 = 3600241(0x36ef71, float:5.045012E-39)
            if (r0 == r1) goto L_0x00c8
            r1 = 93106001(0x58caf51, float:1.3229938E-35)
            if (r0 == r1) goto L_0x00be
            goto L_0x00db
        L_0x00be:
            java.lang.String r0 = "ascii"
            boolean r8 = r8.equals(r0)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            if (r8 == 0) goto L_0x00db
            r9 = r6
            goto L_0x00db
        L_0x00c8:
            java.lang.String r0 = "utf8"
            boolean r8 = r8.equals(r0)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            if (r8 == 0) goto L_0x00db
            r9 = r5
            goto L_0x00db
        L_0x00d2:
            java.lang.String r0 = "base64"
            boolean r8 = r8.equals(r0)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            if (r8 == 0) goto L_0x00db
            r9 = r3
        L_0x00db:
            if (r9 == 0) goto L_0x0108
            if (r9 == r6) goto L_0x00f5
            if (r9 == r5) goto L_0x00eb
            java.lang.String r8 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            r8.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            r10.resolve(r8)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            goto L_0x0169
        L_0x00eb:
            java.lang.String r8 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            r8.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            r10.resolve(r8)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            goto L_0x0169
        L_0x00f5:
            com.facebook.react.bridge.WritableArray r8 = com.facebook.react.bridge.Arguments.createArray()     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            int r9 = r4.length     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
        L_0x00fa:
            if (r3 >= r9) goto L_0x0104
            byte r0 = r4[r3]     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            r8.pushInt(r0)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            int r3 = r3 + 1
            goto L_0x00fa
        L_0x0104:
            r10.resolve(r8)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            goto L_0x0169
        L_0x0108:
            java.lang.String r8 = android.util.Base64.encodeToString(r4, r5)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            r10.resolve(r8)     // Catch:{ FileNotFoundException -> 0x0119, Exception -> 0x0110 }
            goto L_0x0169
        L_0x0110:
            r7 = move-exception
            java.lang.String r7 = r7.getLocalizedMessage()
            r10.reject((java.lang.String) r2, (java.lang.String) r7)
            goto L_0x0169
        L_0x0119:
            r8 = move-exception
            java.lang.String r8 = r8.getLocalizedMessage()
            java.lang.String r9 = "EISDIR"
            boolean r0 = r8.contains(r9)
            if (r0 == 0) goto L_0x0147
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expecting a file but '"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r7 = r0.append(r7)
            java.lang.String r0 = "' is a directory; "
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            r10.reject((java.lang.String) r9, (java.lang.String) r7)
            goto L_0x0169
        L_0x0147:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "No such file '"
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.StringBuilder r7 = r9.append(r7)
            java.lang.String r9 = "'; "
            java.lang.StringBuilder r7 = r7.append(r9)
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "ENOENT"
            r10.reject((java.lang.String) r8, (java.lang.String) r7)
        L_0x0169:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.readFile(java.lang.String, java.lang.String, boolean, com.facebook.react.bridge.Promise):void");
    }

    static Map<String, Object> getSystemfolders(ReactApplicationContext reactApplicationContext) {
        HashMap hashMap = new HashMap();
        hashMap.put("DocumentDir", getFilesDirPath(reactApplicationContext));
        hashMap.put("CacheDir", getCacheDirPath(reactApplicationContext));
        hashMap.put("DCIMDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_DCIM));
        hashMap.put("PictureDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_PICTURES));
        hashMap.put("MusicDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_MUSIC));
        hashMap.put("DownloadDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_DOWNLOADS));
        hashMap.put("MovieDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_MOVIES));
        hashMap.put("RingtoneDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_RINGTONES));
        if (Environment.getExternalStorageState().equals("mounted")) {
            hashMap.put("SDCardDir", getExternalFilesDirPath(reactApplicationContext, (String) null));
            File externalFilesDir = reactApplicationContext.getExternalFilesDir((String) null);
            if (externalFilesDir == null || externalFilesDir.getParentFile() == null) {
                hashMap.put("SDCardApplicationDir", "");
            } else {
                hashMap.put("SDCardApplicationDir", externalFilesDir.getParentFile().getAbsolutePath());
            }
        } else {
            hashMap.put("SDCardDir", "");
            hashMap.put("SDCardApplicationDir", "");
        }
        hashMap.put("MainBundleDir", reactApplicationContext.getApplicationInfo().dataDir);
        hashMap.put("LibraryDir", "");
        hashMap.put("ApplicationSupportDir", "");
        return hashMap;
    }

    static Map<String, Object> getLegacySystemfolders(ReactApplicationContext reactApplicationContext) {
        HashMap hashMap = new HashMap();
        hashMap.put("LegacyDCIMDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath());
        hashMap.put("LegacyPictureDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
        hashMap.put("LegacyMusicDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath());
        hashMap.put("LegacyDownloadDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
        hashMap.put("LegacyMovieDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath());
        hashMap.put("LegacyRingtoneDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES).getAbsolutePath());
        if (Environment.getExternalStorageState().equals("mounted")) {
            hashMap.put("LegacySDCardDir", Environment.getExternalStorageDirectory().getAbsolutePath());
        } else {
            hashMap.put("LegacySDCardDir", "");
        }
        return hashMap;
    }

    static String getExternalFilesDirPath(ReactApplicationContext reactApplicationContext, String str) {
        File externalFilesDir = reactApplicationContext.getExternalFilesDir(str);
        return externalFilesDir != null ? externalFilesDir.getAbsolutePath() : "";
    }

    static String getFilesDirPath(ReactApplicationContext reactApplicationContext) {
        File filesDir = reactApplicationContext.getFilesDir();
        return filesDir != null ? filesDir.getAbsolutePath() : "";
    }

    static String getCacheDirPath(ReactApplicationContext reactApplicationContext) {
        File cacheDir = reactApplicationContext.getCacheDir();
        return cacheDir != null ? cacheDir.getAbsolutePath() : "";
    }

    public static void getSDCardDir(ReactApplicationContext reactApplicationContext, Promise promise) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                promise.resolve(reactApplicationContext.getExternalFilesDir((String) null).getAbsolutePath());
            } catch (Exception e) {
                promise.reject("ReactNativeBlobUtil.getSDCardDir", e.getLocalizedMessage());
            }
        } else {
            promise.reject("ReactNativeBlobUtil.getSDCardDir", "External storage not mounted");
        }
    }

    public static void getSDCardApplicationDir(ReactApplicationContext reactApplicationContext, Promise promise) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                promise.resolve(reactApplicationContext.getExternalFilesDir((String) null).getParentFile().getAbsolutePath());
            } catch (Exception e) {
                promise.reject("ReactNativeBlobUtil.getSDCardApplicationDir", e.getLocalizedMessage());
            }
        } else {
            promise.reject("ReactNativeBlobUtil.getSDCardApplicationDir", "External storage not mounted");
        }
    }

    static String getTmpPath(String str) {
        return ReactNativeBlobUtilImpl.RCTContext.getFilesDir() + "/ReactNativeBlobUtilTmp_" + str;
    }

    static void unlink(String str, Callback callback) {
        try {
            deleteRecursive(new File(ReactNativeBlobUtilUtils.normalizePath(str)));
            callback.invoke(null, true);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage(), false);
        }
    }

    private static void deleteRecursive(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File deleteRecursive : listFiles) {
                    deleteRecursive(deleteRecursive);
                }
            } else {
                throw new NullPointerException("Received null trying to list files of directory '" + file + "'");
            }
        }
        if (!file.delete()) {
            throw new IOException("Failed to delete '" + file + "'");
        }
    }

    static void mkdir(String str, Promise promise) {
        String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        File file = new File(normalizePath);
        if (file.exists()) {
            promise.reject("EEXIST", (file.isDirectory() ? "Folder" : "File") + " '" + normalizePath + "' already exists");
            return;
        }
        try {
            if (!file.mkdirs()) {
                promise.reject("EUNSPECIFIED", "mkdir failed to create some or all directories in '" + normalizePath + "'");
            } else {
                promise.resolve(true);
            }
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0101 A[SYNTHETIC, Splitter:B:53:0x0101] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0109 A[Catch:{ Exception -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0135 A[SYNTHETIC, Splitter:B:66:0x0135] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x013d A[Catch:{ Exception -> 0x0139 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void cp(java.lang.String r8, java.lang.String r9, com.facebook.react.bridge.Callback r10) {
        /*
            java.lang.String r0 = ""
            java.lang.String r9 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r9)
            r1 = 0
            r2 = 1
            r3 = 0
            java.io.InputStream r4 = inputStreamFromPath(r8)     // Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
            if (r4 != 0) goto L_0x004b
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r5.<init>()     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            java.lang.String r6 = "Source file at path`"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            java.lang.StringBuilder r8 = r5.append(r8)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            java.lang.String r5 = "` does not exist or can not be opened"
            java.lang.StringBuilder r8 = r8.append(r5)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r9[r3] = r8     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r10.invoke(r9)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            if (r4 == 0) goto L_0x004a
            r4.close()     // Catch:{ Exception -> 0x0035 }
            goto L_0x004a
        L_0x0035:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.String r8 = r8.getLocalizedMessage()
            java.lang.StringBuilder r8 = r9.append(r8)
            r8.toString()
        L_0x004a:
            return
        L_0x004b:
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            boolean r8 = r8.exists()     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            if (r8 != 0) goto L_0x009d
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            boolean r8 = r8.createNewFile()     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            if (r8 != 0) goto L_0x009d
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r5.<init>()     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            java.lang.String r6 = "Destination file at '"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            java.lang.StringBuilder r9 = r5.append(r9)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            java.lang.String r5 = "' already exists"
            java.lang.StringBuilder r9 = r9.append(r5)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r8[r3] = r9     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r10.invoke(r8)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            if (r4 == 0) goto L_0x009c
            r4.close()     // Catch:{ Exception -> 0x0087 }
            goto L_0x009c
        L_0x0087:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.String r8 = r8.getLocalizedMessage()
            java.lang.StringBuilder r8 = r9.append(r8)
            r8.toString()
        L_0x009c:
            return
        L_0x009d:
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r9 = 10240(0x2800, float:1.4349E-41)
            byte[] r9 = new byte[r9]     // Catch:{ Exception -> 0x00d7, all -> 0x00d0 }
        L_0x00a6:
            int r1 = r4.read(r9)     // Catch:{ Exception -> 0x00d7, all -> 0x00d0 }
            if (r1 <= 0) goto L_0x00b0
            r8.write(r9, r3, r1)     // Catch:{ Exception -> 0x00d7, all -> 0x00d0 }
            goto L_0x00a6
        L_0x00b0:
            if (r4 == 0) goto L_0x00b8
            r4.close()     // Catch:{ Exception -> 0x00b6 }
            goto L_0x00b8
        L_0x00b6:
            r8 = move-exception
            goto L_0x00be
        L_0x00b8:
            r8.close()     // Catch:{ Exception -> 0x00b6 }
            r8 = r0
            goto L_0x0122
        L_0x00be:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.String r8 = r8.getLocalizedMessage()
            java.lang.StringBuilder r8 = r9.append(r8)
            goto L_0x011e
        L_0x00d0:
            r9 = move-exception
            r1 = r4
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x0133
        L_0x00d7:
            r9 = move-exception
            r1 = r4
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x00ea
        L_0x00dd:
            r8 = move-exception
            r9 = r1
            r1 = r4
            goto L_0x0133
        L_0x00e1:
            r8 = move-exception
            r9 = r1
            r1 = r4
            goto L_0x00ea
        L_0x00e5:
            r8 = move-exception
            r9 = r1
            goto L_0x0133
        L_0x00e8:
            r8 = move-exception
            r9 = r1
        L_0x00ea:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0132 }
            r4.<init>()     // Catch:{ all -> 0x0132 }
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch:{ all -> 0x0132 }
            java.lang.String r8 = r8.getLocalizedMessage()     // Catch:{ all -> 0x0132 }
            java.lang.StringBuilder r8 = r4.append(r8)     // Catch:{ all -> 0x0132 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0132 }
            if (r1 == 0) goto L_0x0107
            r1.close()     // Catch:{ Exception -> 0x0105 }
            goto L_0x0107
        L_0x0105:
            r9 = move-exception
            goto L_0x010d
        L_0x0107:
            if (r9 == 0) goto L_0x0122
            r9.close()     // Catch:{ Exception -> 0x0105 }
            goto L_0x0122
        L_0x010d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r8 = r1.append(r8)
            java.lang.String r9 = r9.getLocalizedMessage()
            java.lang.StringBuilder r8 = r8.append(r9)
        L_0x011e:
            java.lang.String r8 = r8.toString()
        L_0x0122:
            if (r8 == r0) goto L_0x012c
            java.lang.Object[] r9 = new java.lang.Object[r2]
            r9[r3] = r8
            r10.invoke(r9)
            goto L_0x0131
        L_0x012c:
            java.lang.Object[] r8 = new java.lang.Object[r3]
            r10.invoke(r8)
        L_0x0131:
            return
        L_0x0132:
            r8 = move-exception
        L_0x0133:
            if (r1 == 0) goto L_0x013b
            r1.close()     // Catch:{ Exception -> 0x0139 }
            goto L_0x013b
        L_0x0139:
            r9 = move-exception
            goto L_0x0141
        L_0x013b:
            if (r9 == 0) goto L_0x0155
            r9.close()     // Catch:{ Exception -> 0x0139 }
            goto L_0x0155
        L_0x0141:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.StringBuilder r10 = r10.append(r0)
            java.lang.String r9 = r9.getLocalizedMessage()
            java.lang.StringBuilder r9 = r10.append(r9)
            r9.toString()
        L_0x0155:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.cp(java.lang.String, java.lang.String, com.facebook.react.bridge.Callback):void");
    }

    static void mv(String str, String str2, Callback callback) {
        String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        String normalizePath2 = ReactNativeBlobUtilUtils.normalizePath(str2);
        File file = new File(normalizePath);
        if (!file.exists()) {
            callback.invoke("Source file at path `" + normalizePath + "` does not exist");
            return;
        }
        try {
            File file2 = new File(normalizePath2);
            File parentFile = file2.getParentFile();
            if (parentFile == null || parentFile.exists()) {
                if (file2.exists()) {
                    file2.delete();
                }
                if (!file.renameTo(file2)) {
                    callback.invoke("mv failed for unknown reasons");
                    return;
                }
                callback.invoke(new Object[0]);
                return;
            }
            callback.invoke("mv failed because the destination directory doesn't exist");
        } catch (Exception e) {
            callback.invoke(e.toString());
        }
    }

    static void exists(String str, Callback callback) {
        if (isAsset(str)) {
            try {
                ReactNativeBlobUtilImpl.RCTContext.getAssets().openFd(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
                callback.invoke(true, false);
            } catch (IOException unused) {
                callback.invoke(false, false);
            }
        } else {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            if (normalizePath != null) {
                callback.invoke(Boolean.valueOf(new File(normalizePath).exists()), Boolean.valueOf(new File(normalizePath).isDirectory()));
                return;
            }
            callback.invoke(false, false);
        }
    }

    static void ls(String str, Promise promise) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(normalizePath);
            if (!file.exists()) {
                promise.reject("ENOENT", "No such file '" + normalizePath + "'");
            } else if (!file.isDirectory()) {
                promise.reject("ENOTDIR", "Not a directory '" + normalizePath + "'");
            } else {
                String[] list = new File(normalizePath).list();
                WritableArray createArray = Arguments.createArray();
                for (String pushString : list) {
                    createArray.pushString(pushString);
                }
                promise.resolve(createArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void slice(String str, String str2, int i, int i2, String str3, Promise promise) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str2);
            if (str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_CONTENT) || !new File(ReactNativeBlobUtilUtils.normalizePath(str)).isDirectory()) {
                InputStream inputStreamFromPath = inputStreamFromPath(str);
                if (inputStreamFromPath == null) {
                    promise.reject("ENOENT", "No such file '" + str + "'");
                    return;
                }
                FileOutputStream fileOutputStream = new FileOutputStream(new File(normalizePath));
                int skip = (int) inputStreamFromPath.skip((long) i);
                if (skip != i) {
                    promise.reject("EUNSPECIFIED", "Skipped " + skip + " instead of the specified " + i + " bytes");
                    return;
                }
                byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                int i3 = i2 - i;
                while (true) {
                    if (i3 <= 0) {
                        break;
                    }
                    int read = inputStreamFromPath.read(bArr, 0, Data.MAX_DATA_BYTES);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, Math.min(i3, read));
                    i3 -= read;
                }
                inputStreamFromPath.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                promise.resolve(normalizePath);
                return;
            }
            promise.reject("EISDIR", "Expecting a file but '" + str + "' is a directory");
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void lstat(String str, final Callback callback) {
        String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        new AsyncTask<String, Integer, Integer>() {
            /* access modifiers changed from: protected */
            public Integer doInBackground(String... strArr) {
                WritableArray createArray = Arguments.createArray();
                if (strArr[0] == null) {
                    Callback.this.invoke("the path specified for lstat is either `null` or `undefined`.");
                    return 0;
                }
                File file = new File(strArr[0]);
                if (!file.exists()) {
                    Callback.this.invoke("failed to lstat path `" + strArr[0] + "` because it does not exist or it is not a folder");
                    return 0;
                }
                if (file.isDirectory()) {
                    String[] list = file.list();
                    int length = list.length;
                    for (int i = 0; i < length; i++) {
                        createArray.pushMap(ReactNativeBlobUtilFS.statFile(file.getPath() + "/" + list[i]));
                    }
                } else {
                    createArray.pushMap(ReactNativeBlobUtilFS.statFile(file.getAbsolutePath()));
                }
                Callback.this.invoke(null, createArray);
                return 0;
            }
        }.execute(new String[]{normalizePath});
    }

    static void stat(String str, Callback callback) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            WritableMap statFile = statFile(normalizePath);
            if (statFile == null) {
                callback.invoke("failed to stat path `" + normalizePath + "` because it does not exist or it is not a folder", null);
                return;
            }
            callback.invoke(null, statFile);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static WritableMap statFile(String str) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            WritableMap createMap = Arguments.createMap();
            if (isAsset(normalizePath)) {
                String replace = normalizePath.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "");
                AssetFileDescriptor openFd = ReactNativeBlobUtilImpl.RCTContext.getAssets().openFd(replace);
                createMap.putString("filename", replace);
                createMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, normalizePath);
                createMap.putString("type", UriUtil.LOCAL_ASSET_SCHEME);
                createMap.putString("size", String.valueOf(openFd.getLength()));
                createMap.putInt("lastModified", 0);
            } else {
                File file = new File(normalizePath);
                if (!file.exists()) {
                    return null;
                }
                createMap.putString("filename", file.getName());
                createMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, file.getPath());
                createMap.putString("type", file.isDirectory() ? "directory" : "file");
                createMap.putString("size", String.valueOf(file.length()));
                createMap.putString("lastModified", String.valueOf(file.lastModified()));
            }
            return createMap;
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void scanFile(String[] strArr, String[] strArr2, final Callback callback) {
        try {
            MediaScannerConnection.scanFile(this.mCtx, strArr, strArr2, new MediaScannerConnection.OnScanCompletedListener() {
                public void onScanCompleted(String str, Uri uri) {
                    callback.invoke(null, true);
                }
            });
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage(), null);
        }
    }

    static void hash(String str, String str2, Promise promise) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("md5", MessageDigestAlgorithms.MD5);
            hashMap.put("sha1", MessageDigestAlgorithms.SHA_1);
            hashMap.put("sha224", "SHA-224");
            hashMap.put("sha256", MessageDigestAlgorithms.SHA_256);
            hashMap.put("sha384", MessageDigestAlgorithms.SHA_384);
            hashMap.put("sha512", MessageDigestAlgorithms.SHA_512);
            if (!hashMap.containsKey(str2)) {
                promise.reject("EINVAL", "Invalid algorithm '" + str2 + "', must be one of md5, sha1, sha224, sha256, sha384, sha512");
            } else if (str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_CONTENT) || !new File(ReactNativeBlobUtilUtils.normalizePath(str)).isDirectory()) {
                MessageDigest instance = MessageDigest.getInstance((String) hashMap.get(str2));
                InputStream inputStreamFromPath = inputStreamFromPath(str);
                if (inputStreamFromPath == null) {
                    promise.reject("ENOENT", "No such file '" + str + "'");
                    return;
                }
                byte[] bArr = new byte[1048576];
                while (true) {
                    int read = inputStreamFromPath.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                StringBuilder sb = new StringBuilder();
                byte[] digest = instance.digest();
                int length = digest.length;
                for (int i = 0; i < length; i++) {
                    sb.append(String.format("%02x", new Object[]{Byte.valueOf(digest[i])}));
                }
                promise.resolve(sb.toString());
            } else {
                promise.reject("EISDIR", "Expecting a file but '" + str + "' is a directory");
            }
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void createFile(String str, String str2, String str3, Promise promise) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(normalizePath);
            boolean createNewFile = file.createNewFile();
            if (str3.equals("uri")) {
                File file2 = new File(str2.replace(ReactNativeBlobUtilConst.FILE_PREFIX, ""));
                if (!file2.exists()) {
                    promise.reject("ENOENT", "Source file : " + str2 + " does not exist");
                    return;
                }
                FileInputStream fileInputStream = new FileInputStream(file2);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                for (int read = fileInputStream.read(bArr); read > 0; read = fileInputStream.read(bArr)) {
                    fileOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                fileOutputStream.close();
            } else if (!createNewFile) {
                promise.reject("EEXIST", "File `" + normalizePath + "` already exists");
                return;
            } else {
                new FileOutputStream(file).write(ReactNativeBlobUtilUtils.stringToBytes(str2, str3));
            }
            promise.resolve(normalizePath);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void createFileASCII(String str, ReadableArray readableArray, Promise promise) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(normalizePath);
            if (!file.createNewFile()) {
                promise.reject("EEXIST", "File at path `" + normalizePath + "` already exists");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            fileOutputStream.write(bArr);
            promise.resolve(normalizePath);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void df(Callback callback, ReactApplicationContext reactApplicationContext) {
        StatFs statFs = new StatFs(reactApplicationContext.getFilesDir().getPath());
        WritableMap createMap = Arguments.createMap();
        if (Build.VERSION.SDK_INT >= 18) {
            createMap.putString("internal_free", String.valueOf(statFs.getFreeBytes()));
            createMap.putString("internal_total", String.valueOf(statFs.getTotalBytes()));
            File externalFilesDir = reactApplicationContext.getExternalFilesDir((String) null);
            if (externalFilesDir != null) {
                StatFs statFs2 = new StatFs(externalFilesDir.getPath());
                createMap.putString("external_free", String.valueOf(statFs2.getFreeBytes()));
                createMap.putString("external_total", String.valueOf(statFs2.getTotalBytes()));
            } else {
                createMap.putString("external_free", "-1");
                createMap.putString("external_total", "-1");
            }
        }
        callback.invoke(null, createMap);
    }

    static void removeSession(ReadableArray readableArray, final Callback callback) {
        new AsyncTask<ReadableArray, Integer, Integer>() {
            /* access modifiers changed from: protected */
            public Integer doInBackground(ReadableArray... readableArrayArr) {
                try {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < readableArrayArr[0].size(); i++) {
                        String string = readableArrayArr[0].getString(i);
                        File file = new File(string);
                        if (file.exists() && !file.delete()) {
                            arrayList.add(string);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        Callback.this.invoke(null, true);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to delete: ");
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            sb.append((String) it.next()).append(", ");
                        }
                        Callback.this.invoke(sb.toString());
                    }
                } catch (Exception e) {
                    Callback.this.invoke(e.getLocalizedMessage());
                }
                return Integer.valueOf(readableArrayArr[0].size());
            }
        }.execute(new ReadableArray[]{readableArray});
    }

    private static InputStream inputStreamFromPath(String str) throws IOException {
        if (str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)) {
            return ReactNativeBlobUtilImpl.RCTContext.getAssets().open(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
        }
        if (str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_CONTENT)) {
            return ReactNativeBlobUtilImpl.RCTContext.getContentResolver().openInputStream(Uri.parse(str));
        }
        return new FileInputStream(new File(ReactNativeBlobUtilUtils.normalizePath(str)));
    }

    private static boolean isPathExists(String str) {
        if (!str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)) {
            return new File(str).exists();
        }
        try {
            ReactNativeBlobUtilImpl.RCTContext.getAssets().open(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    static boolean isAsset(String str) {
        return str != null && str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET);
    }
}
