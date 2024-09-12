package expo.modules.filesystem;

import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import expo.modules.core.Promise;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"expo/modules/filesystem/FileSystemModule$uploadTaskStartAsync$1", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "expo-file-system_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FileSystemModule.kt */
public final class FileSystemModule$uploadTaskStartAsync$1 implements Callback {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ FileSystemModule this$0;

    FileSystemModule$uploadTaskStartAsync$1(Promise promise, FileSystemModule fileSystemModule) {
        this.$promise = promise;
        this.this$0 = fileSystemModule;
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(iOException, "e");
        if (call.isCanceled()) {
            this.$promise.resolve((Object) null);
            return;
        }
        Log.e(FileSystemModuleKt.TAG, String.valueOf(iOException.getMessage()));
        this.$promise.reject(iOException);
    }

    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, io.sentry.protocol.Response.TYPE);
        Bundle bundle = new Bundle();
        ResponseBody body = response.body();
        FileSystemModule fileSystemModule = this.this$0;
        bundle.putString("body", body != null ? body.string() : null);
        bundle.putInt("status", response.code());
        bundle.putBundle("headers", fileSystemModule.translateHeaders(response.headers()));
        response.close();
        this.$promise.resolve(bundle);
    }
}
