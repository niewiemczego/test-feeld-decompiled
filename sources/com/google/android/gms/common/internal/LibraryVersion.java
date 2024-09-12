package com.google.android.gms.common.internal;

import java.util.concurrent.ConcurrentHashMap;

@Deprecated
/* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
public class LibraryVersion {
    private static final GmsLogger zza = new GmsLogger("LibraryVersion", "");
    private static final LibraryVersion zzb = new LibraryVersion();
    private final ConcurrentHashMap zzc = new ConcurrentHashMap();

    protected LibraryVersion() {
    }

    public static LibraryVersion getInstance() {
        return zzb;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00aa  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getVersion(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "Failed to get app version for libraryName: "
            java.lang.String r1 = "LibraryVersion"
            java.lang.String r2 = "Please provide a valid libraryName"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9, r2)
            java.util.concurrent.ConcurrentHashMap r2 = r8.zzc
            boolean r2 = r2.containsKey(r9)
            if (r2 == 0) goto L_0x001a
            java.util.concurrent.ConcurrentHashMap r0 = r8.zzc
            java.lang.Object r9 = r0.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            return r9
        L_0x001a:
            java.util.Properties r2 = new java.util.Properties
            r2.<init>()
            r3 = 0
            java.lang.String r4 = "/%s.properties"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x007b }
            r6 = 0
            r5[r6] = r9     // Catch:{ IOException -> 0x007b }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ IOException -> 0x007b }
            java.lang.Class<com.google.android.gms.common.internal.LibraryVersion> r5 = com.google.android.gms.common.internal.LibraryVersion.class
            java.io.InputStream r4 = r5.getResourceAsStream(r4)     // Catch:{ IOException -> 0x007b }
            if (r4 == 0) goto L_0x0057
            r2.load(r4)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.lang.String r5 = "version"
            java.lang.String r3 = r2.getProperty(r5, r3)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            com.google.android.gms.common.internal.GmsLogger r2 = zza     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r5.<init>()     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r5.append(r9)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.lang.String r6 = " version is "
            r5.append(r6)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r5.append(r3)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r2.v(r1, r5)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            goto L_0x006b
        L_0x0057:
            com.google.android.gms.common.internal.GmsLogger r2 = zza     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r5.<init>()     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r5.append(r0)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r5.append(r9)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r2.w(r1, r5)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
        L_0x006b:
            if (r4 == 0) goto L_0x0097
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r4)
            goto L_0x0097
        L_0x0071:
            r9 = move-exception
            r3 = r4
            goto L_0x00a8
        L_0x0074:
            r2 = move-exception
            r7 = r4
            r4 = r3
            r3 = r7
            goto L_0x007d
        L_0x0079:
            r9 = move-exception
            goto L_0x00a8
        L_0x007b:
            r2 = move-exception
            r4 = r3
        L_0x007d:
            com.google.android.gms.common.internal.GmsLogger r5 = zza     // Catch:{ all -> 0x0079 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
            r6.<init>()     // Catch:{ all -> 0x0079 }
            r6.append(r0)     // Catch:{ all -> 0x0079 }
            r6.append(r9)     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0079 }
            r5.e(r1, r0, r2)     // Catch:{ all -> 0x0079 }
            if (r3 == 0) goto L_0x0096
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r3)
        L_0x0096:
            r3 = r4
        L_0x0097:
            if (r3 != 0) goto L_0x00a2
            com.google.android.gms.common.internal.GmsLogger r0 = zza
            java.lang.String r2 = ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used"
            r0.d(r1, r2)
            java.lang.String r3 = "UNKNOWN"
        L_0x00a2:
            java.util.concurrent.ConcurrentHashMap r0 = r8.zzc
            r0.put(r9, r3)
            return r3
        L_0x00a8:
            if (r3 == 0) goto L_0x00ad
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r3)
        L_0x00ad:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.LibraryVersion.getVersion(java.lang.String):java.lang.String");
    }
}
