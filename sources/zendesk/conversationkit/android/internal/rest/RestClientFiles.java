package zendesk.conversationkit.android.internal.rest;

import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/RestClientFiles;", "", "cleanUpUpload", "", "name", "", "clearCache", "getUploadFileForUri", "Ljava/io/File;", "uri", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RestClientFiles.kt */
public interface RestClientFiles {
    void cleanUpUpload(String str);

    void clearCache();

    File getUploadFileForUri(String str, String str2);
}
