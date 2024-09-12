package io.sentry.cache;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

final class CacheUtils {
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    CacheUtils() {
    }

    static <T> void store(SentryOptions sentryOptions, T t, String str, String str2) {
        BufferedWriter bufferedWriter;
        File ensureCacheDir = ensureCacheDir(sentryOptions, str);
        if (ensureCacheDir == null) {
            sentryOptions.getLogger().log(SentryLevel.INFO, "Cache dir is not set, cannot store in scope cache", new Object[0]);
            return;
        }
        File file = new File(ensureCacheDir, str2);
        if (file.exists()) {
            sentryOptions.getLogger().log(SentryLevel.DEBUG, "Overwriting %s in scope cache", str2);
            if (!file.delete()) {
                sentryOptions.getLogger().log(SentryLevel.ERROR, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, UTF_8));
                sentryOptions.getSerializer().serialize(t, (Writer) bufferedWriter);
                bufferedWriter.close();
                fileOutputStream.close();
                return;
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, th2, "Error persisting entity: %s", str2);
            return;
        }
        throw th;
    }

    static void delete(SentryOptions sentryOptions, String str, String str2) {
        File ensureCacheDir = ensureCacheDir(sentryOptions, str);
        if (ensureCacheDir == null) {
            sentryOptions.getLogger().log(SentryLevel.INFO, "Cache dir is not set, cannot delete from scope cache", new Object[0]);
            return;
        }
        File file = new File(ensureCacheDir, str2);
        if (file.exists()) {
            sentryOptions.getLogger().log(SentryLevel.DEBUG, "Deleting %s from scope cache", str2);
            if (!file.delete()) {
                sentryOptions.getLogger().log(SentryLevel.ERROR, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [io.sentry.JsonDeserializer, io.sentry.JsonDeserializer<R>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T, R> T read(io.sentry.SentryOptions r6, java.lang.String r7, java.lang.String r8, java.lang.Class<T> r9, io.sentry.JsonDeserializer<R> r10) {
        /*
            java.io.File r7 = ensureCacheDir(r6, r7)
            r0 = 0
            r1 = 0
            if (r7 != 0) goto L_0x0016
            io.sentry.ILogger r6 = r6.getLogger()
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.INFO
            java.lang.Object[] r8 = new java.lang.Object[r1]
            java.lang.String r9 = "Cache dir is not set, cannot read from scope cache"
            r6.log((io.sentry.SentryLevel) r7, (java.lang.String) r9, (java.lang.Object[]) r8)
            return r0
        L_0x0016:
            java.io.File r2 = new java.io.File
            r2.<init>(r7, r8)
            boolean r7 = r2.exists()
            r3 = 1
            if (r7 == 0) goto L_0x0068
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ all -> 0x0057 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x0057 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ all -> 0x0057 }
            r5.<init>(r2)     // Catch:{ all -> 0x0057 }
            java.nio.charset.Charset r2 = UTF_8     // Catch:{ all -> 0x0057 }
            r4.<init>(r5, r2)     // Catch:{ all -> 0x0057 }
            r7.<init>(r4)     // Catch:{ all -> 0x0057 }
            if (r10 != 0) goto L_0x0041
            io.sentry.ISerializer r10 = r6.getSerializer()     // Catch:{ all -> 0x004d }
            java.lang.Object r9 = r10.deserialize(r7, r9)     // Catch:{ all -> 0x004d }
            r7.close()     // Catch:{ all -> 0x0057 }
            return r9
        L_0x0041:
            io.sentry.ISerializer r2 = r6.getSerializer()     // Catch:{ all -> 0x004d }
            java.lang.Object r9 = r2.deserializeCollection(r7, r9, r10)     // Catch:{ all -> 0x004d }
            r7.close()     // Catch:{ all -> 0x0057 }
            return r9
        L_0x004d:
            r9 = move-exception
            r7.close()     // Catch:{ all -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r7 = move-exception
            r9.addSuppressed(r7)     // Catch:{ all -> 0x0057 }
        L_0x0056:
            throw r9     // Catch:{ all -> 0x0057 }
        L_0x0057:
            r7 = move-exception
            io.sentry.ILogger r6 = r6.getLogger()
            io.sentry.SentryLevel r9 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r10 = new java.lang.Object[r3]
            r10[r1] = r8
            java.lang.String r8 = "Error reading entity from scope cache: %s"
            r6.log(r9, r7, r8, r10)
            goto L_0x0077
        L_0x0068:
            io.sentry.ILogger r6 = r6.getLogger()
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r9 = new java.lang.Object[r3]
            r9[r1] = r8
            java.lang.String r8 = "No entry stored for %s"
            r6.log((io.sentry.SentryLevel) r7, (java.lang.String) r8, (java.lang.Object[]) r9)
        L_0x0077:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.cache.CacheUtils.read(io.sentry.SentryOptions, java.lang.String, java.lang.String, java.lang.Class, io.sentry.JsonDeserializer):java.lang.Object");
    }

    private static File ensureCacheDir(SentryOptions sentryOptions, String str) {
        String cacheDirPath = sentryOptions.getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        File file = new File(cacheDirPath, str);
        file.mkdirs();
        return file;
    }
}
