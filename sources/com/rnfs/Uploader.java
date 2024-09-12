package com.rnfs;

import android.os.AsyncTask;
import android.webkit.MimeTypeMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class Uploader extends AsyncTask<UploadParams, int[], UploadResult> {
    private AtomicBoolean mAbort = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public UploadParams mParams;
    /* access modifiers changed from: private */
    public UploadResult res;

    /* access modifiers changed from: protected */
    public UploadResult doInBackground(UploadParams... uploadParamsArr) {
        this.mParams = uploadParamsArr[0];
        this.res = new UploadResult();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Uploader uploader = Uploader.this;
                    uploader.upload(uploader.mParams, Uploader.this.res);
                    Uploader.this.mParams.onUploadComplete.onUploadComplete(Uploader.this.res);
                } catch (Exception e) {
                    Uploader.this.res.exception = e;
                    Uploader.this.mParams.onUploadComplete.onUploadComplete(Uploader.this.res);
                }
            }
        }).start();
        return this.res;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:39|40) */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r23 = r15.getString(r3);
        r26 = r15.getString(r2);
        r8 = r1.getMimeType(r15.getString(r4));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0138 */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x03a2  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x03a7  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x03b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void upload(com.rnfs.UploadParams r37, com.rnfs.UploadResult r38) throws java.lang.Exception {
        /*
            r36 = this;
            r1 = r36
            r0 = r37
            java.lang.String r2 = "filename"
            java.lang.String r3 = "name"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "\r\n"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r6 = "--"
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r7 = "*****"
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.util.ArrayList<com.facebook.react.bridge.ReadableMap> r9 = r0.files     // Catch:{ all -> 0x039a }
            java.lang.Object[] r9 = r9.toArray()     // Catch:{ all -> 0x039a }
            boolean r10 = r0.binaryStreamOnly     // Catch:{ all -> 0x039a }
            java.net.URL r11 = r0.src     // Catch:{ all -> 0x039a }
            java.net.URLConnection r11 = r11.openConnection()     // Catch:{ all -> 0x039a }
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ all -> 0x039a }
            r12 = 1
            r11.setDoOutput(r12)     // Catch:{ all -> 0x0393 }
            com.facebook.react.bridge.ReadableMap r13 = r0.headers     // Catch:{ all -> 0x0393 }
            com.facebook.react.bridge.ReadableMapKeySetIterator r13 = r13.keySetIterator()     // Catch:{ all -> 0x0393 }
            java.lang.String r14 = r0.method     // Catch:{ all -> 0x0393 }
            r11.setRequestMethod(r14)     // Catch:{ all -> 0x0393 }
            if (r10 != 0) goto L_0x0064
            java.lang.String r14 = "Content-Type"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0393 }
            r15.<init>()     // Catch:{ all -> 0x0393 }
            java.lang.String r8 = "multipart/form-data;boundary="
            java.lang.StringBuilder r8 = r15.append(r8)     // Catch:{ all -> 0x0393 }
            java.lang.StringBuilder r8 = r8.append(r7)     // Catch:{ all -> 0x0393 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0393 }
            r11.setRequestProperty(r14, r8)     // Catch:{ all -> 0x0393 }
        L_0x0064:
            boolean r8 = r13.hasNextKey()     // Catch:{ all -> 0x0393 }
            if (r8 == 0) goto L_0x0078
            java.lang.String r8 = r13.nextKey()     // Catch:{ all -> 0x0393 }
            com.facebook.react.bridge.ReadableMap r14 = r0.headers     // Catch:{ all -> 0x0393 }
            java.lang.String r14 = r14.getString(r8)     // Catch:{ all -> 0x0393 }
            r11.setRequestProperty(r8, r14)     // Catch:{ all -> 0x0393 }
            goto L_0x0064
        L_0x0078:
            com.facebook.react.bridge.ReadableMap r8 = r0.fields     // Catch:{ all -> 0x0393 }
            com.facebook.react.bridge.ReadableMapKeySetIterator r8 = r8.keySetIterator()     // Catch:{ all -> 0x0393 }
            java.lang.String r13 = ""
            r14 = r13
        L_0x0081:
            boolean r15 = r8.hasNextKey()     // Catch:{ all -> 0x0393 }
            java.lang.String r12 = "\""
            r17 = r11
            java.lang.String r11 = "Content-Disposition: form-data; name=\""
            if (r15 == 0) goto L_0x00de
            java.lang.String r15 = r8.nextKey()     // Catch:{ all -> 0x00d8 }
            r18 = r8
            com.facebook.react.bridge.ReadableMap r8 = r0.fields     // Catch:{ all -> 0x00d8 }
            java.lang.String r8 = r8.getString(r15)     // Catch:{ all -> 0x00d8 }
            r19 = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r4.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.StringBuilder r4 = r4.append(r14)     // Catch:{ all -> 0x00d8 }
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch:{ all -> 0x00d8 }
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch:{ all -> 0x00d8 }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x00d8 }
            java.lang.StringBuilder r4 = r4.append(r11)     // Catch:{ all -> 0x00d8 }
            java.lang.StringBuilder r4 = r4.append(r15)     // Catch:{ all -> 0x00d8 }
            java.lang.StringBuilder r4 = r4.append(r12)     // Catch:{ all -> 0x00d8 }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x00d8 }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x00d8 }
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ all -> 0x00d8 }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x00d8 }
            java.lang.String r14 = r4.toString()     // Catch:{ all -> 0x00d8 }
            r11 = r17
            r8 = r18
            r4 = r19
            r12 = 1
            goto L_0x0081
        L_0x00d8:
            r0 = move-exception
            r2 = r1
        L_0x00da:
            r8 = r17
            goto L_0x0396
        L_0x00de:
            r19 = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x038e }
            r4.<init>()     // Catch:{ all -> 0x038e }
            java.lang.StringBuilder r4 = r4.append(r13)     // Catch:{ all -> 0x038e }
            java.lang.StringBuilder r4 = r4.append(r14)     // Catch:{ all -> 0x038e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x038e }
            int r8 = r9.length     // Catch:{ all -> 0x038e }
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ all -> 0x038e }
            java.util.ArrayList<com.facebook.react.bridge.ReadableMap> r15 = r0.files     // Catch:{ all -> 0x038e }
            java.util.Iterator r15 = r15.iterator()     // Catch:{ all -> 0x038e }
            r20 = 0
            r18 = r4
            r22 = r14
            r0 = 0
            r18 = r13
            r13 = r20
        L_0x0105:
            boolean r23 = r15.hasNext()     // Catch:{ all -> 0x038e }
            r24 = r4
            java.lang.String r4 = "filepath"
            if (r23 == 0) goto L_0x0210
            java.lang.Object r23 = r15.next()     // Catch:{ all -> 0x0206 }
            r25 = r15
            r15 = r23
            com.facebook.react.bridge.ReadableMap r15 = (com.facebook.react.bridge.ReadableMap) r15     // Catch:{ all -> 0x0206 }
            java.lang.String r23 = r15.getString(r3)     // Catch:{ NoSuchKeyException -> 0x0136 }
            java.lang.String r26 = r15.getString(r2)     // Catch:{ NoSuchKeyException -> 0x0136 }
            r27 = r8
            java.lang.String r8 = "filetype"
            java.lang.String r8 = r15.getString(r8)     // Catch:{ NoSuchKeyException -> 0x0138 }
        L_0x0129:
            r34 = r23
            r23 = r2
            r2 = r34
            r35 = r26
            r26 = r3
            r3 = r35
            goto L_0x0149
        L_0x0136:
            r27 = r8
        L_0x0138:
            java.lang.String r23 = r15.getString(r3)     // Catch:{ all -> 0x0206 }
            java.lang.String r26 = r15.getString(r2)     // Catch:{ all -> 0x0206 }
            java.lang.String r8 = r15.getString(r4)     // Catch:{ all -> 0x0206 }
            java.lang.String r8 = r1.getMimeType(r8)     // Catch:{ all -> 0x0206 }
            goto L_0x0129
        L_0x0149:
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0206 }
            java.lang.String r4 = r15.getString(r4)     // Catch:{ all -> 0x0206 }
            r1.<init>(r4)     // Catch:{ all -> 0x0206 }
            r15 = r0
            long r0 = r1.length()     // Catch:{ all -> 0x0206 }
            long r13 = r13 + r0
            if (r10 != 0) goto L_0x01f2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0206 }
            r4.<init>()     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r4 = r4.append(r11)     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r2 = r4.append(r2)     // Catch:{ all -> 0x0206 }
            java.lang.String r4 = "\"; filename=\""
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r2 = r2.append(r12)     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ all -> 0x0206 }
            java.lang.String r3 = "Content-Type: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ all -> 0x0206 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0206 }
            int r3 = r9.length     // Catch:{ all -> 0x0206 }
            r4 = 1
            int r3 = r3 - r4
            r8 = r15
            if (r3 != r8) goto L_0x01a5
            int r3 = r19.length()     // Catch:{ all -> 0x0206 }
            r15 = r5
            long r4 = (long) r3     // Catch:{ all -> 0x0206 }
            long r13 = r13 + r4
            goto L_0x01a6
        L_0x01a5:
            r15 = r5
        L_0x01a6:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0206 }
            r3.<init>()     // Catch:{ all -> 0x0206 }
            java.lang.String r4 = "Content-length: "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch:{ all -> 0x0206 }
            r1 = r15
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0206 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0206 }
            r3.<init>()     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r3 = r3.append(r2)     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r3 = r3.append(r0)     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch:{ all -> 0x0206 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0206 }
            r27[r8] = r3     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0206 }
            r3.<init>()     // Catch:{ all -> 0x0206 }
            r5 = r24
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0206 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0206 }
            r4 = r0
            goto L_0x01f7
        L_0x01f2:
            r1 = r5
            r8 = r15
            r5 = r24
            r4 = r5
        L_0x01f7:
            int r0 = r8 + 1
            r5 = r1
            r2 = r23
            r15 = r25
            r3 = r26
            r8 = r27
            r1 = r36
            goto L_0x0105
        L_0x0206:
            r0 = move-exception
            r1 = 0
            r3 = 0
            r4 = 0
            r2 = r36
            r8 = r17
            goto L_0x03a0
        L_0x0210:
            r2 = r1
            r1 = r5
            r27 = r8
            r5 = r24
            com.rnfs.UploadParams r0 = r2.mParams     // Catch:{ all -> 0x038c }
            com.rnfs.UploadParams$onUploadBegin r0 = r0.onUploadBegin     // Catch:{ all -> 0x038c }
            if (r0 == 0) goto L_0x0227
            com.rnfs.UploadParams r0 = r2.mParams     // Catch:{ all -> 0x0224 }
            com.rnfs.UploadParams$onUploadBegin r0 = r0.onUploadBegin     // Catch:{ all -> 0x0224 }
            r0.onUploadBegin()     // Catch:{ all -> 0x0224 }
            goto L_0x0227
        L_0x0224:
            r0 = move-exception
            goto L_0x00da
        L_0x0227:
            if (r10 != 0) goto L_0x0252
            int r0 = r5.length()     // Catch:{ all -> 0x038c }
            int r3 = r9.length     // Catch:{ all -> 0x038c }
            int r3 = r3 * 2
            int r0 = r0 + r3
            long r5 = (long) r0     // Catch:{ all -> 0x038c }
            long r5 = r5 + r13
            java.lang.String r0 = "Content-length"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x038c }
            r3.<init>()     // Catch:{ all -> 0x038c }
            r7 = r18
            java.lang.StringBuilder r3 = r3.append(r7)     // Catch:{ all -> 0x038c }
            int r5 = (int) r5     // Catch:{ all -> 0x038c }
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ all -> 0x038c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x038c }
            r11 = r17
            r11.setRequestProperty(r0, r3)     // Catch:{ all -> 0x038a }
            r11.setFixedLengthStreamingMode(r5)     // Catch:{ all -> 0x038a }
            goto L_0x0254
        L_0x0252:
            r11 = r17
        L_0x0254:
            r11.connect()     // Catch:{ all -> 0x038a }
            java.io.DataOutputStream r3 = new java.io.DataOutputStream     // Catch:{ all -> 0x038a }
            java.io.OutputStream r0 = r11.getOutputStream()     // Catch:{ all -> 0x038a }
            r3.<init>(r0)     // Catch:{ all -> 0x038a }
            java.nio.channels.WritableByteChannel r0 = java.nio.channels.Channels.newChannel(r3)     // Catch:{ all -> 0x0386 }
            if (r10 != 0) goto L_0x026b
            r5 = r22
            r3.writeBytes(r5)     // Catch:{ all -> 0x0386 }
        L_0x026b:
            r5 = r37
            java.util.ArrayList<com.facebook.react.bridge.ReadableMap> r5 = r5.files     // Catch:{ all -> 0x0386 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0386 }
            r6 = 0
            r7 = 0
        L_0x0275:
            boolean r8 = r5.hasNext()     // Catch:{ all -> 0x0386 }
            if (r8 == 0) goto L_0x02f5
            java.lang.Object r8 = r5.next()     // Catch:{ all -> 0x0386 }
            com.facebook.react.bridge.ReadableMap r8 = (com.facebook.react.bridge.ReadableMap) r8     // Catch:{ all -> 0x0386 }
            if (r10 != 0) goto L_0x0288
            r9 = r27[r6]     // Catch:{ all -> 0x0386 }
            r3.writeBytes(r9)     // Catch:{ all -> 0x0386 }
        L_0x0288:
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x0386 }
            java.lang.String r8 = r8.getString(r4)     // Catch:{ all -> 0x0386 }
            r9.<init>(r8)     // Catch:{ all -> 0x0386 }
            r8 = r4
            r37 = r5
            long r4 = r9.length()     // Catch:{ all -> 0x0386 }
            float r12 = (float) r4     // Catch:{ all -> 0x0386 }
            r15 = 1120403456(0x42c80000, float:100.0)
            float r12 = r12 / r15
            r15 = r7
            r16 = r8
            double r7 = (double) r12     // Catch:{ all -> 0x0386 }
            double r7 = java.lang.Math.ceil(r7)     // Catch:{ all -> 0x0386 }
            long r7 = (long) r7     // Catch:{ all -> 0x0386 }
            java.io.FileInputStream r12 = new java.io.FileInputStream     // Catch:{ all -> 0x0386 }
            r12.<init>(r9)     // Catch:{ all -> 0x0386 }
            java.nio.channels.FileChannel r9 = r12.getChannel()     // Catch:{ all -> 0x0386 }
            r17 = r20
        L_0x02b0:
            int r22 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r22 >= 0) goto L_0x02e1
            r28 = r9
            r29 = r17
            r31 = r7
            r33 = r0
            long r22 = r28.transferTo(r29, r31, r33)     // Catch:{ all -> 0x0386 }
            long r17 = r17 + r22
            r24 = r0
            com.rnfs.UploadParams r0 = r2.mParams     // Catch:{ all -> 0x0386 }
            com.rnfs.UploadParams$onUploadProgress r0 = r0.onUploadProgress     // Catch:{ all -> 0x0386 }
            if (r0 == 0) goto L_0x02da
            r25 = r4
            long r4 = (long) r15     // Catch:{ all -> 0x0386 }
            long r4 = r4 + r22
            int r0 = (int) r4     // Catch:{ all -> 0x0386 }
            com.rnfs.UploadParams r4 = r2.mParams     // Catch:{ all -> 0x0386 }
            com.rnfs.UploadParams$onUploadProgress r4 = r4.onUploadProgress     // Catch:{ all -> 0x0386 }
            int r5 = (int) r13     // Catch:{ all -> 0x0386 }
            r4.onUploadProgress(r5, r0)     // Catch:{ all -> 0x0386 }
            r15 = r0
            goto L_0x02dc
        L_0x02da:
            r25 = r4
        L_0x02dc:
            r0 = r24
            r4 = r25
            goto L_0x02b0
        L_0x02e1:
            r24 = r0
            if (r10 != 0) goto L_0x02e8
            r3.writeBytes(r1)     // Catch:{ all -> 0x0386 }
        L_0x02e8:
            int r6 = r6 + 1
            r12.close()     // Catch:{ all -> 0x0386 }
            r5 = r37
            r7 = r15
            r4 = r16
            r0 = r24
            goto L_0x0275
        L_0x02f5:
            if (r10 != 0) goto L_0x02fc
            r0 = r19
            r3.writeBytes(r0)     // Catch:{ all -> 0x0386 }
        L_0x02fc:
            r3.flush()     // Catch:{ all -> 0x0386 }
            r3.close()     // Catch:{ all -> 0x0386 }
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0386 }
            java.io.InputStream r0 = r11.getInputStream()     // Catch:{ all -> 0x0386 }
            r1.<init>(r0)     // Catch:{ all -> 0x0386 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x0383 }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ all -> 0x0383 }
            r0.<init>(r1)     // Catch:{ all -> 0x0383 }
            r4.<init>(r0)     // Catch:{ all -> 0x0383 }
            com.facebook.react.bridge.WritableMap r0 = com.facebook.react.bridge.Arguments.createMap()     // Catch:{ all -> 0x0380 }
            java.util.Map r5 = r11.getHeaderFields()     // Catch:{ all -> 0x0380 }
            java.util.Set r5 = r5.entrySet()     // Catch:{ all -> 0x0380 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0380 }
        L_0x0325:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0380 }
            if (r6 == 0) goto L_0x0348
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0380 }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ all -> 0x0380 }
            java.lang.Object r7 = r6.getKey()     // Catch:{ all -> 0x0380 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0380 }
            java.lang.Object r6 = r6.getValue()     // Catch:{ all -> 0x0380 }
            java.util.List r6 = (java.util.List) r6     // Catch:{ all -> 0x0380 }
            r8 = 0
            java.lang.Object r6 = r6.get(r8)     // Catch:{ all -> 0x0380 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0380 }
            r0.putString(r7, r6)     // Catch:{ all -> 0x0380 }
            goto L_0x0325
        L_0x0348:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0380 }
            r5.<init>()     // Catch:{ all -> 0x0380 }
        L_0x034d:
            java.lang.String r6 = r4.readLine()     // Catch:{ all -> 0x0380 }
            if (r6 == 0) goto L_0x035d
            java.lang.StringBuilder r6 = r5.append(r6)     // Catch:{ all -> 0x0380 }
            java.lang.String r7 = "\n"
            r6.append(r7)     // Catch:{ all -> 0x0380 }
            goto L_0x034d
        L_0x035d:
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0380 }
            int r6 = r11.getResponseCode()     // Catch:{ all -> 0x0380 }
            com.rnfs.UploadResult r7 = r2.res     // Catch:{ all -> 0x0380 }
            r7.headers = r0     // Catch:{ all -> 0x0380 }
            com.rnfs.UploadResult r0 = r2.res     // Catch:{ all -> 0x0380 }
            r0.body = r5     // Catch:{ all -> 0x0380 }
            com.rnfs.UploadResult r0 = r2.res     // Catch:{ all -> 0x0380 }
            r0.statusCode = r6     // Catch:{ all -> 0x0380 }
            if (r11 == 0) goto L_0x0376
            r11.disconnect()
        L_0x0376:
            r3.close()
            r1.close()
            r4.close()
            return
        L_0x0380:
            r0 = move-exception
            r8 = r11
            goto L_0x03a0
        L_0x0383:
            r0 = move-exception
            r8 = r11
            goto L_0x0398
        L_0x0386:
            r0 = move-exception
            r8 = r11
            r1 = 0
            goto L_0x0398
        L_0x038a:
            r0 = move-exception
            goto L_0x0395
        L_0x038c:
            r0 = move-exception
            goto L_0x0390
        L_0x038e:
            r0 = move-exception
            r2 = r1
        L_0x0390:
            r11 = r17
            goto L_0x0395
        L_0x0393:
            r0 = move-exception
            r2 = r1
        L_0x0395:
            r8 = r11
        L_0x0396:
            r1 = 0
            r3 = 0
        L_0x0398:
            r4 = 0
            goto L_0x03a0
        L_0x039a:
            r0 = move-exception
            r2 = r1
            r1 = 0
            r3 = 0
            r4 = 0
            r8 = 0
        L_0x03a0:
            if (r8 == 0) goto L_0x03a5
            r8.disconnect()
        L_0x03a5:
            if (r3 == 0) goto L_0x03aa
            r3.close()
        L_0x03aa:
            if (r1 == 0) goto L_0x03af
            r1.close()
        L_0x03af:
            if (r4 == 0) goto L_0x03b4
            r4.close()
        L_0x03b4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnfs.Uploader.upload(com.rnfs.UploadParams, com.rnfs.UploadResult):void");
    }

    /* access modifiers changed from: protected */
    public String getMimeType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        String mimeTypeFromExtension = fileExtensionFromUrl != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase()) : null;
        return mimeTypeFromExtension == null ? "*/*" : mimeTypeFromExtension;
    }

    /* access modifiers changed from: protected */
    public void stop() {
        this.mAbort.set(true);
    }
}
