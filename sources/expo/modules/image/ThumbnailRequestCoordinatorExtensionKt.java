package expo.modules.image;

import android.util.Log;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a!\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0005\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u0002¨\u0006\b"}, d2 = {"getPrivateField", "T", "Lcom/bumptech/glide/request/ThumbnailRequestCoordinator;", "name", "", "(Lcom/bumptech/glide/request/ThumbnailRequestCoordinator;Ljava/lang/String;)Ljava/lang/Object;", "getPrivateFullRequest", "Lcom/bumptech/glide/request/Request;", "expo-image_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ThumbnailRequestCoordinatorExtension.kt */
public final class ThumbnailRequestCoordinatorExtensionKt {
    public static final Request getPrivateFullRequest(ThumbnailRequestCoordinator thumbnailRequestCoordinator) {
        Intrinsics.checkNotNullParameter(thumbnailRequestCoordinator, "<this>");
        return (Request) getPrivateField(thumbnailRequestCoordinator, "full");
    }

    private static final <T> T getPrivateField(ThumbnailRequestCoordinator thumbnailRequestCoordinator, String str) {
        try {
            Field declaredField = thumbnailRequestCoordinator.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(thumbnailRequestCoordinator);
        } catch (Throwable th) {
            Log.e("ExpoImage", "Couldn't receive the `" + str + "` field", th);
            return null;
        }
    }
}
