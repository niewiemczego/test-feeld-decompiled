package expo.modules.image.thumbhash;

import android.graphics.Bitmap;
import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import io.sentry.protocol.SentryThread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0011H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/image/thumbhash/ThumbhashFetcher;", "Lcom/bumptech/glide/load/data/DataFetcher;", "Landroid/graphics/Bitmap;", "thumbhash", "", "(Ljava/lang/String;)V", "cancel", "", "cleanup", "getDataClass", "Ljava/lang/Class;", "getDataSource", "Lcom/bumptech/glide/load/DataSource;", "loadData", "priority", "Lcom/bumptech/glide/Priority;", "callback", "Lcom/bumptech/glide/load/data/DataFetcher$DataCallback;", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ThumbhashFetcher.kt */
public final class ThumbhashFetcher implements DataFetcher<Bitmap> {
    private final String thumbhash;

    public void cancel() {
    }

    public void cleanup() {
    }

    public Class<Bitmap> getDataClass() {
        return Bitmap.class;
    }

    public ThumbhashFetcher(String str) {
        this.thumbhash = str;
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public void loadData(Priority priority, DataFetcher.DataCallback<? super Bitmap> dataCallback) {
        Intrinsics.checkNotNullParameter(priority, SentryThread.JsonKeys.PRIORITY);
        Intrinsics.checkNotNullParameter(dataCallback, "callback");
        try {
            byte[] decode = Base64.decode(this.thumbhash, 0);
            ThumbhashDecoder thumbhashDecoder = ThumbhashDecoder.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(decode, "decodedThumbhash");
            dataCallback.onDataReady(thumbhashDecoder.thumbHashToBitmap(decode));
        } catch (Exception e) {
            dataCallback.onLoadFailed(new ThumbhashDecodingFailure(this.thumbhash, e));
        }
    }
}
