package zendesk.conversationkit.android.internal.rest;

import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/DefaultRestClientFiles;", "Lzendesk/conversationkit/android/internal/rest/RestClientFiles;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cleanUpUpload", "", "name", "", "clearCache", "getCacheDir", "Ljava/io/File;", "getCacheFile", "getUploadFileForUri", "uri", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RestClientFiles.kt */
public final class DefaultRestClientFiles implements RestClientFiles {
    private final Context context;

    public DefaultRestClientFiles(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public File getUploadFileForUri(String str, String str2) {
        Source source;
        BufferedSource buffer;
        Intrinsics.checkNotNullParameter(str, "uri");
        Intrinsics.checkNotNullParameter(str2, "name");
        try {
            File cacheFile = getCacheFile(str2);
            if (!cacheFile.exists()) {
                File parentFile = cacheFile.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                cacheFile.createNewFile();
                InputStream openInputStream = this.context.getContentResolver().openInputStream(Uri.parse(str));
                if (openInputStream == null || (source = Okio.source(openInputStream)) == null || (buffer = Okio.buffer(source)) == null) {
                    throw new IOException("Content resolver failed to find source for " + str);
                }
                BufferedSink buffer2 = Okio.buffer(Okio__JvmOkioKt.sink$default(cacheFile, false, 1, (Object) null));
                buffer2.writeAll(buffer);
                buffer.close();
                buffer2.close();
            }
            return cacheFile;
        } catch (Exception e) {
            cleanUpUpload(str2);
            throw e;
        }
    }

    public void cleanUpUpload(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        getCacheFile(str).delete();
    }

    public void clearCache() {
        FilesKt.deleteRecursively(getCacheDir());
    }

    private final File getCacheFile(String str) {
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return new File(getCacheDir(), Base64.encodeToString(bytes, 8));
    }

    private final File getCacheDir() {
        return new File(this.context.getCacheDir().getPath() + File.pathSeparator + "upload_cache");
    }
}
