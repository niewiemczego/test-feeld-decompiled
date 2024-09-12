package expo.modules.filesystem;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"expo/modules/filesystem/FileSystemModule$uploadTaskStartAsync$request$1", "Lexpo/modules/filesystem/RequestBodyDecorator;", "decorate", "Lokhttp3/RequestBody;", "requestBody", "expo-file-system_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FileSystemModule.kt */
public final class FileSystemModule$uploadTaskStartAsync$request$1 implements RequestBodyDecorator {
    final /* synthetic */ CountingRequestListener $progressListener;

    FileSystemModule$uploadTaskStartAsync$request$1(CountingRequestListener countingRequestListener) {
        this.$progressListener = countingRequestListener;
    }

    public RequestBody decorate(RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        return new CountingRequestBody(requestBody, this.$progressListener);
    }
}
