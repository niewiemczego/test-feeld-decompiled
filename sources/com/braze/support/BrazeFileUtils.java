package com.braze.support;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.braze.support.BrazeLogger;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0007\u001aH\u0010\u000e\u001a \u0012\u0004\u0012\u00020\t\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010j\u0002`\u00110\u000f2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u001a\u0012\u0010\u0016\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001\u001a\n\u0010\u0019\u001a\u00020\u001a*\u00020\u001b\u001a\n\u0010\u001c\u001a\u00020\u001a*\u00020\u001b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"FILE_SCHEME", "", "REMOTE_SCHEMES", "", "SHARED_PREFERENCES_FILENAME_SUFFIX", "TAG", "deleteFileOrDirectory", "", "fileOrDirectory", "Ljava/io/File;", "deleteSharedPreferencesFile", "context", "Landroid/content/Context;", "file", "downloadFileToPath", "Lkotlin/Pair;", "", "Lcom/braze/communication/HttpHeaders;", "downloadDirectoryAbsolutePath", "remoteFileUrl", "outputFilename", "extension", "getAssetFileStringContents", "Landroid/content/res/AssetManager;", "assetPath", "isLocalUri", "", "Landroid/net/Uri;", "isRemoteUri", "android-sdk-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BrazeFileUtils {
    private static final String FILE_SCHEME = "file";
    public static final List<String> REMOTE_SCHEMES = CollectionsKt.listOf("http", "https", "ftp", "ftps", "about", "javascript");
    private static final String SHARED_PREFERENCES_FILENAME_SUFFIX = ".xml";
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("BrazeFileUtils");

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ File b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(File file) {
            super(0);
            this.b = file;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not recursively delete " + this.b.getName();
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ File b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(File file) {
            super(0);
            this.b = file;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot delete SharedPreferences that does not exist. Path: " + this.b.getAbsolutePath();
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ File b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(File file) {
            super(0);
            this.b = file;
        }

        /* renamed from: a */
        public final String invoke() {
            return "SharedPreferences file is expected to end in .xml. Path: " + this.b.getAbsolutePath();
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "SDK is offline. File not downloaded for url: " + this.b;
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Download directory null or blank. File not downloaded.";
        }
    }

    static final class f extends Lambda implements Function0 {
        public static final f b = new f();

        f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Zip file url null or blank. File not downloaded.";
        }
    }

    static final class g extends Lambda implements Function0 {
        public static final g b = new g();

        g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Output filename null or blank. File not downloaded.";
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(int i, String str) {
            super(0);
            this.b = i;
            this.c = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "HTTP response code was " + this.b + ". File with url " + this.c + " could not be downloaded.";
        }
    }

    static final class i extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Exception during download of file from url : " + this.b;
        }
    }

    static final class j extends Lambda implements Function0 {
        public static final j b = new j();

        j() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Null or blank Uri scheme.";
        }
    }

    public static final void deleteFileOrDirectory(File file) {
        Intrinsics.checkNotNullParameter(file, "fileOrDirectory");
        if (!FilesKt.deleteRecursively(file)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, (Function0) new a(file), 4, (Object) null);
        }
    }

    public static final void deleteSharedPreferencesFile(Context context, File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        if (!file.exists()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, (Function0) new b(file), 4, (Object) null);
            return;
        }
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "fileName");
        if (!StringsKt.endsWith$default(name, SHARED_PREFERENCES_FILENAME_SUFFIX, false, 2, (Object) null)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, (Function0) new c(file), 4, (Object) null);
            return;
        }
        String removeSuffix = StringsKt.removeSuffix(name, (CharSequence) SHARED_PREFERENCES_FILENAME_SUFFIX);
        if (Build.VERSION.SDK_INT >= 24) {
            context.deleteSharedPreferences(removeSuffix);
            return;
        }
        context.getSharedPreferences(removeSuffix, 0).edit().clear().commit();
        deleteFileOrDirectory(file);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a3, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00aa, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046 A[Catch:{ Exception -> 0x00ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006f A[Catch:{ Exception -> 0x00e8, all -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ab A[Catch:{ Exception -> 0x00e8, all -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0118  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.Pair<java.io.File, java.util.Map<java.lang.String, java.lang.String>> downloadFileToPath(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "downloadDirectoryAbsolutePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "remoteFileUrl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "outputFilename"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 1337(0x539, float:1.874E-42)
            android.net.TrafficStats.setThreadStatsTag(r0)
            com.braze.Braze$Companion r0 = com.braze.Braze.Companion
            boolean r0 = r0.getOutboundNetworkRequestsOffline()
            if (r0 != 0) goto L_0x015e
            boolean r0 = kotlin.text.StringsKt.isBlank(r8)
            if (r0 != 0) goto L_0x0148
            boolean r0 = kotlin.text.StringsKt.isBlank(r9)
            if (r0 != 0) goto L_0x0132
            boolean r0 = kotlin.text.StringsKt.isBlank(r10)
            if (r0 != 0) goto L_0x011c
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x00ee }
            r1.<init>(r8)     // Catch:{ Exception -> 0x00ee }
            r1.mkdirs()     // Catch:{ Exception -> 0x00ee }
            r1 = 0
            if (r11 == 0) goto L_0x0043
            boolean r2 = kotlin.text.StringsKt.isBlank(r11)     // Catch:{ Exception -> 0x00ee }
            if (r2 == 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r2 = r1
            goto L_0x0044
        L_0x0043:
            r2 = 1
        L_0x0044:
            if (r2 != 0) goto L_0x0057
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ee }
            r2.<init>()     // Catch:{ Exception -> 0x00ee }
            java.lang.StringBuilder r10 = r2.append(r10)     // Catch:{ Exception -> 0x00ee }
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ Exception -> 0x00ee }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x00ee }
        L_0x0057:
            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x00ee }
            r11.<init>(r8, r10)     // Catch:{ Exception -> 0x00ee }
            java.net.URL r8 = new java.net.URL     // Catch:{ Exception -> 0x00ee }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00ee }
            bo.app.v6 r10 = bo.app.v6.a     // Catch:{ Exception -> 0x00ee }
            java.net.HttpURLConnection r8 = r10.a(r8)     // Catch:{ Exception -> 0x00ee }
            int r10 = r8.getResponseCode()     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r10 != r2) goto L_0x00ab
            java.io.DataInputStream r10 = new java.io.DataInputStream     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            java.io.InputStream r2 = r8.getInputStream()     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            r10.<init>(r2)     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x00a4 }
            r2.<init>(r11)     // Catch:{ all -> 0x00a4 }
            r3 = 2
            kotlin.io.ByteStreamsKt.copyTo$default(r10, r2, r1, r3, r0)     // Catch:{ all -> 0x009d }
            kotlin.io.CloseableKt.closeFinally(r2, r0)     // Catch:{ all -> 0x00a4 }
            kotlin.io.CloseableKt.closeFinally(r10, r0)     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            java.util.Map r10 = r8.getHeaderFields()     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            java.lang.String r0 = "urlConnection.headerFields"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            java.util.Map r9 = com.braze.support.g.a((java.util.Map) r10)     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            r8.disconnect()
            kotlin.Pair r8 = new kotlin.Pair
            r8.<init>(r11, r9)
            return r8
        L_0x009d:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x009f }
        L_0x009f:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r11)     // Catch:{ all -> 0x00a4 }
            throw r0     // Catch:{ all -> 0x00a4 }
        L_0x00a4:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r10, r11)     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            throw r0     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
        L_0x00ab:
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            java.lang.String r1 = TAG     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            r2 = 0
            r3 = 0
            com.braze.support.BrazeFileUtils$h r4 = new com.braze.support.BrazeFileUtils$h     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            r4.<init>(r10, r9)     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            r5 = 6
            r6 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.String) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (kotlin.jvm.functions.Function0) r4, (int) r5, (java.lang.Object) r6)     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            java.lang.Exception r11 = new java.lang.Exception     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            r0.<init>()     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            java.lang.String r1 = "HTTP response code was "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            java.lang.StringBuilder r10 = r0.append(r10)     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            java.lang.String r0 = ". File with url "
            java.lang.StringBuilder r10 = r10.append(r0)     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            java.lang.StringBuilder r10 = r10.append(r9)     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            java.lang.String r0 = " could not be downloaded."
            java.lang.StringBuilder r10 = r10.append(r0)     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
            throw r11     // Catch:{ Exception -> 0x00e8, all -> 0x00e4 }
        L_0x00e4:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto L_0x0116
        L_0x00e8:
            r10 = move-exception
            r0 = r8
            r8 = r10
            goto L_0x00ef
        L_0x00ec:
            r8 = move-exception
            goto L_0x0116
        L_0x00ee:
            r8 = move-exception
        L_0x00ef:
            com.braze.support.BrazeLogger r10 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x00ec }
            java.lang.String r11 = TAG     // Catch:{ all -> 0x00ec }
            com.braze.support.BrazeLogger$Priority r1 = com.braze.support.BrazeLogger.Priority.E     // Catch:{ all -> 0x00ec }
            com.braze.support.BrazeFileUtils$i r2 = new com.braze.support.BrazeFileUtils$i     // Catch:{ all -> 0x00ec }
            r2.<init>(r9)     // Catch:{ all -> 0x00ec }
            r10.brazelog((java.lang.String) r11, (com.braze.support.BrazeLogger.Priority) r1, (java.lang.Throwable) r8, (kotlin.jvm.functions.Function0<java.lang.String>) r2)     // Catch:{ all -> 0x00ec }
            java.lang.Exception r8 = new java.lang.Exception     // Catch:{ all -> 0x00ec }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ec }
            r10.<init>()     // Catch:{ all -> 0x00ec }
            java.lang.String r11 = "Exception during download of file from url : "
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ all -> 0x00ec }
            java.lang.StringBuilder r9 = r10.append(r9)     // Catch:{ all -> 0x00ec }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00ec }
            r8.<init>(r9)     // Catch:{ all -> 0x00ec }
            throw r8     // Catch:{ all -> 0x00ec }
        L_0x0116:
            if (r0 == 0) goto L_0x011b
            r0.disconnect()
        L_0x011b:
            throw r8
        L_0x011c:
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r2 = TAG
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.I
            com.braze.support.BrazeFileUtils$g r5 = com.braze.support.BrazeFileUtils.g.b
            r4 = 0
            r6 = 4
            r7 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.String) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
            java.lang.Exception r8 = new java.lang.Exception
            java.lang.String r9 = "Output filename is blank. File not downloaded."
            r8.<init>(r9)
            throw r8
        L_0x0132:
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r1 = TAG
            com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.I
            com.braze.support.BrazeFileUtils$f r4 = com.braze.support.BrazeFileUtils.f.b
            r3 = 0
            r5 = 4
            r6 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.String) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (kotlin.jvm.functions.Function0) r4, (int) r5, (java.lang.Object) r6)
            java.lang.Exception r8 = new java.lang.Exception
            java.lang.String r9 = "Zip file url is blank. File not downloaded."
            r8.<init>(r9)
            throw r8
        L_0x0148:
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r1 = TAG
            com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.I
            com.braze.support.BrazeFileUtils$e r4 = com.braze.support.BrazeFileUtils.e.b
            r3 = 0
            r5 = 4
            r6 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.String) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (kotlin.jvm.functions.Function0) r4, (int) r5, (java.lang.Object) r6)
            java.lang.Exception r8 = new java.lang.Exception
            java.lang.String r9 = "Download directory is blank. File not downloaded."
            r8.<init>(r9)
            throw r8
        L_0x015e:
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r1 = TAG
            com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.I
            com.braze.support.BrazeFileUtils$d r4 = new com.braze.support.BrazeFileUtils$d
            r4.<init>(r9)
            r3 = 0
            r5 = 4
            r6 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.String) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (kotlin.jvm.functions.Function0) r4, (int) r5, (java.lang.Object) r6)
            java.lang.Exception r8 = new java.lang.Exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "SDK is offline. File not downloaded for url: "
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.StringBuilder r9 = r10.append(r9)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.support.BrazeFileUtils.downloadFileToPath(java.lang.String, java.lang.String, java.lang.String, java.lang.String):kotlin.Pair");
    }

    public static /* synthetic */ Pair downloadFileToPath$default(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str4 = null;
        }
        return downloadFileToPath(str, str2, str3, str4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getAssetFileStringContents(android.content.res.AssetManager r1, java.lang.String r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "assetPath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.io.InputStream r1 = r1.open(r2)
            java.lang.String r2 = "this.open(assetPath)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r1, r2)
            boolean r1 = r0 instanceof java.io.BufferedReader
            if (r1 == 0) goto L_0x0021
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0
            goto L_0x0029
        L_0x0021:
            java.io.BufferedReader r1 = new java.io.BufferedReader
            r2 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r0, r2)
            r0 = r1
        L_0x0029:
            r1 = 0
            java.lang.String r2 = kotlin.io.TextStreamsKt.readText(r0)     // Catch:{ all -> 0x0032 }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            return r2
        L_0x0032:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0034 }
        L_0x0034:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.support.BrazeFileUtils.getAssetFileStringContents(android.content.res.AssetManager, java.lang.String):java.lang.String");
    }

    public static final boolean isLocalUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        String scheme = uri.getScheme();
        if ((scheme == null || StringsKt.isBlank(scheme)) || Intrinsics.areEqual((Object) scheme, (Object) "file")) {
            return true;
        }
        return false;
    }

    public static final boolean isRemoteUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        String scheme = uri.getScheme();
        if (!(scheme == null || StringsKt.isBlank(scheme))) {
            return REMOTE_SCHEMES.contains(scheme);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.I, (Throwable) null, (Function0) j.b, 4, (Object) null);
        return false;
    }
}
