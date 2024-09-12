package com.braze.support;

import android.content.Context;
import com.braze.support.BrazeLogger;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.apache.commons.io.IOUtils;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004H\u0007J$\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\bH\u0007J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/braze/support/WebContentUtils;", "", "()V", "FILE_URI_SCHEME_PREFIX", "", "HTML_INAPP_MESSAGES_FOLDER", "ZIP_EXTENSION", "getHtmlInAppMessageAssetCacheDirectory", "Ljava/io/File;", "context", "Landroid/content/Context;", "getLocalHtmlUrlFromRemoteUrl", "localDirectory", "remoteZipUrl", "replacePrefetchedUrlsWithLocalAssets", "originalString", "remoteToLocalAssetMap", "", "unpackZipIntoDirectory", "", "unpackDirectory", "zipFile", "validateChildFileExistsUnderParent", "intendedParentDirectory", "childFilePath", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebContentUtils {
    private static final String FILE_URI_SCHEME_PREFIX = "file://";
    public static final String HTML_INAPP_MESSAGES_FOLDER = "braze-html-inapp-messages";
    public static final WebContentUtils INSTANCE = new WebContentUtils();
    private static final String ZIP_EXTENSION = ".zip";

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Remote zip url is empty. No local URL will be created.";
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, String str2) {
            super(0);
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Starting download of url: " + this.b + " to " + this.c;
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not download zip file to local storage. " + this.b;
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, String str2) {
            super(0);
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Html content zip downloaded. " + this.b + " to " + this.c;
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error during the zip unpack.";
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Html content zip unpacked to to " + this.b + '.';
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ Ref.ObjectRef b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(Ref.ObjectRef objectRef) {
            super(0);
            this.b = objectRef;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot find local asset file at path: " + ((String) this.b.element);
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Ref.ObjectRef c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(String str, Ref.ObjectRef objectRef) {
            super(0);
            this.b = str;
            this.c = objectRef;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Replacing remote url \"" + this.b + "\" with local uri \"" + ((String) this.c.element) + Typography.quote;
        }
    }

    static final class i extends Lambda implements Function0 {
        public static final i b = new i();

        i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unpack directory is blank. Zip file not unpacked.";
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ Ref.ObjectRef b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(Ref.ObjectRef objectRef) {
            super(0);
            this.b = objectRef;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error creating parent directory " + ((String) this.b.element);
        }
    }

    static final class k extends Lambda implements Function0 {
        final /* synthetic */ Ref.ObjectRef b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(Ref.ObjectRef objectRef) {
            super(0);
            this.b = objectRef;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error unpacking zipEntry " + ((String) this.b.element);
        }
    }

    static final class l extends Lambda implements Function0 {
        final /* synthetic */ File b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(File file, String str) {
            super(0);
            this.b = file;
            this.c = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error during unpack of zip file " + this.b.getAbsolutePath() + " to " + this.c + '.';
        }
    }

    private WebContentUtils() {
    }

    @JvmStatic
    public static final File getHtmlInAppMessageAssetCacheDirectory(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new File(context.getCacheDir().getPath() + "/braze-html-inapp-messages");
    }

    @JvmStatic
    public static final String getLocalHtmlUrlFromRemoteUrl(File file, String str) {
        Intrinsics.checkNotNullParameter(file, "localDirectory");
        Intrinsics.checkNotNullParameter(str, "remoteZipUrl");
        if (StringsKt.isBlank(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, (Function0) a.b, 2, (Object) null);
            return null;
        }
        String absolutePath = file.getAbsolutePath();
        String valueOf = String.valueOf(IntentUtils.getRequestCode());
        String str2 = absolutePath + IOUtils.DIR_SEPARATOR_UNIX + valueOf;
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        WebContentUtils webContentUtils = INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) webContentUtils, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new b(str, str2), 3, (Object) null);
        try {
            BrazeLogger.brazelog$default(brazeLogger, (Object) webContentUtils, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new d(str, str2), 3, (Object) null);
            if (!unpackZipIntoDirectory(str2, BrazeFileUtils.downloadFileToPath(str2, str, valueOf, ZIP_EXTENSION).component1())) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) webContentUtils, BrazeLogger.Priority.W, (Throwable) null, (Function0) e.b, 2, (Object) null);
                BrazeFileUtils.deleteFileOrDirectory(new File(str2));
                return null;
            }
            BrazeLogger.brazelog$default(brazeLogger, (Object) webContentUtils, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new f(str2), 3, (Object) null);
            return str2;
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new c(str));
            BrazeFileUtils.deleteFileOrDirectory(new File(str2));
            return null;
        }
    }

    @JvmStatic
    public static final String replacePrefetchedUrlsWithLocalAssets(String str, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "originalString");
        Intrinsics.checkNotNullParameter(map, "remoteToLocalAssetMap");
        String str2 = str;
        for (Map.Entry next : map.entrySet()) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = next.getValue();
            if (!new File((String) objectRef.element).exists()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, (Function0) new g(objectRef), 2, (Object) null);
            } else {
                objectRef.element = StringsKt.startsWith$default((String) objectRef.element, FILE_URI_SCHEME_PREFIX, false, 2, (Object) null) ? (String) objectRef.element : FILE_URI_SCHEME_PREFIX + ((String) objectRef.element);
                String str3 = (String) next.getKey();
                if (StringsKt.contains$default((CharSequence) str2, (CharSequence) str3, false, 2, (Object) null)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new h(str3, objectRef), 3, (Object) null);
                    str2 = StringsKt.replace$default(str2, str3, (String) objectRef.element, false, 4, (Object) null);
                }
            }
        }
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c1, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c5, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e7, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00eb, code lost:
        throw r3;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean unpackZipIntoDirectory(java.lang.String r11, java.io.File r12) {
        /*
            java.lang.String r0 = "unpackDirectory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "zipFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            boolean r0 = kotlin.text.StringsKt.isBlank(r11)
            r1 = 0
            if (r0 == 0) goto L_0x0020
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.WebContentUtils r3 = INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.I
            com.braze.support.WebContentUtils$i r6 = com.braze.support.WebContentUtils.i.b
            r5 = 0
            r7 = 2
            r8 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
            return r1
        L_0x0020:
            java.io.File r0 = new java.io.File
            r0.<init>(r11)
            r0.mkdirs()
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x00ec }
            r0.<init>()     // Catch:{ all -> 0x00ec }
            java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream     // Catch:{ all -> 0x00ec }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x00ec }
            r3.<init>(r12)     // Catch:{ all -> 0x00ec }
            r2.<init>(r3)     // Catch:{ all -> 0x00ec }
            java.util.zip.ZipEntry r3 = r2.getNextEntry()     // Catch:{ all -> 0x00e5 }
        L_0x003b:
            r4 = 0
            if (r3 == 0) goto L_0x00de
            java.lang.String r5 = r3.getName()     // Catch:{ all -> 0x00e5 }
            java.lang.String r6 = "zipEntry.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ all -> 0x00e5 }
            r0.element = r5     // Catch:{ all -> 0x00e5 }
            java.util.Locale r6 = java.util.Locale.US     // Catch:{ all -> 0x00e5 }
            java.lang.String r7 = "US"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch:{ all -> 0x00e5 }
            java.lang.String r5 = r5.toLowerCase(r6)     // Catch:{ all -> 0x00e5 }
            java.lang.String r6 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ all -> 0x00e5 }
            java.lang.String r6 = "__macosx"
            r7 = 2
            boolean r5 = kotlin.text.StringsKt.startsWith$default(r5, r6, r1, r7, r4)     // Catch:{ all -> 0x00e5 }
            if (r5 != 0) goto L_0x00d5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c6 }
            r5.<init>()     // Catch:{ Exception -> 0x00c6 }
            java.lang.StringBuilder r5 = r5.append(r11)     // Catch:{ Exception -> 0x00c6 }
            r6 = 47
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x00c6 }
            T r6 = r0.element     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x00c6 }
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r5 = validateChildFileExistsUnderParent(r11, r5)     // Catch:{ Exception -> 0x00c6 }
            boolean r3 = r3.isDirectory()     // Catch:{ Exception -> 0x00c6 }
            if (r3 == 0) goto L_0x0090
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00c6 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x00c6 }
            r3.mkdirs()     // Catch:{ Exception -> 0x00c6 }
            goto L_0x00d5
        L_0x0090:
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x009f }
            r3.<init>(r5)     // Catch:{ Exception -> 0x009f }
            java.io.File r3 = r3.getParentFile()     // Catch:{ Exception -> 0x009f }
            if (r3 == 0) goto L_0x00ae
            r3.mkdirs()     // Catch:{ Exception -> 0x009f }
            goto L_0x00ae
        L_0x009f:
            r3 = move-exception
            com.braze.support.BrazeLogger r6 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x00c6 }
            com.braze.support.WebContentUtils r8 = INSTANCE     // Catch:{ Exception -> 0x00c6 }
            com.braze.support.BrazeLogger$Priority r9 = com.braze.support.BrazeLogger.Priority.E     // Catch:{ Exception -> 0x00c6 }
            com.braze.support.WebContentUtils$j r10 = new com.braze.support.WebContentUtils$j     // Catch:{ Exception -> 0x00c6 }
            r10.<init>(r0)     // Catch:{ Exception -> 0x00c6 }
            r6.brazelog((java.lang.Object) r8, (com.braze.support.BrazeLogger.Priority) r9, (java.lang.Throwable) r3, (kotlin.jvm.functions.Function0<java.lang.String>) r10)     // Catch:{ Exception -> 0x00c6 }
        L_0x00ae:
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x00c6 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00c6 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x00c6 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x00c6 }
            kotlin.io.ByteStreamsKt.copyTo$default(r2, r3, r1, r7, r4)     // Catch:{ all -> 0x00bf }
            kotlin.io.CloseableKt.closeFinally(r3, r4)     // Catch:{ Exception -> 0x00c6 }
            goto L_0x00d5
        L_0x00bf:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x00c1 }
        L_0x00c1:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r4)     // Catch:{ Exception -> 0x00c6 }
            throw r5     // Catch:{ Exception -> 0x00c6 }
        L_0x00c6:
            r3 = move-exception
            com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x00e5 }
            com.braze.support.WebContentUtils r5 = INSTANCE     // Catch:{ all -> 0x00e5 }
            com.braze.support.BrazeLogger$Priority r6 = com.braze.support.BrazeLogger.Priority.E     // Catch:{ all -> 0x00e5 }
            com.braze.support.WebContentUtils$k r7 = new com.braze.support.WebContentUtils$k     // Catch:{ all -> 0x00e5 }
            r7.<init>(r0)     // Catch:{ all -> 0x00e5 }
            r4.brazelog((java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r3, (kotlin.jvm.functions.Function0<java.lang.String>) r7)     // Catch:{ all -> 0x00e5 }
        L_0x00d5:
            r2.closeEntry()     // Catch:{ all -> 0x00e5 }
            java.util.zip.ZipEntry r3 = r2.getNextEntry()     // Catch:{ all -> 0x00e5 }
            goto L_0x003b
        L_0x00de:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e5 }
            kotlin.io.CloseableKt.closeFinally(r2, r4)     // Catch:{ all -> 0x00ec }
            r1 = 1
            goto L_0x00fb
        L_0x00e5:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00e7 }
        L_0x00e7:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r0)     // Catch:{ all -> 0x00ec }
            throw r3     // Catch:{ all -> 0x00ec }
        L_0x00ec:
            r0 = move-exception
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.WebContentUtils r3 = INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.E
            com.braze.support.WebContentUtils$l r5 = new com.braze.support.WebContentUtils$l
            r5.<init>(r12, r11)
            r2.brazelog((java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r0, (kotlin.jvm.functions.Function0<java.lang.String>) r5)
        L_0x00fb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.support.WebContentUtils.unpackZipIntoDirectory(java.lang.String, java.io.File):boolean");
    }

    @JvmStatic
    public static final String validateChildFileExistsUnderParent(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "intendedParentDirectory");
        Intrinsics.checkNotNullParameter(str2, "childFilePath");
        String canonicalPath = new File(str).getCanonicalPath();
        String canonicalPath2 = new File(str2).getCanonicalPath();
        Intrinsics.checkNotNullExpressionValue(canonicalPath2, "childFileCanonicalPath");
        Intrinsics.checkNotNullExpressionValue(canonicalPath, "parentCanonicalPath");
        if (StringsKt.startsWith$default(canonicalPath2, canonicalPath, false, 2, (Object) null)) {
            return canonicalPath2;
        }
        throw new IllegalStateException("Invalid file with original path: " + str2 + " with canonical path: " + canonicalPath2 + " does not exist under intended parent with  path: " + str + " and canonical path: " + canonicalPath);
    }
}
