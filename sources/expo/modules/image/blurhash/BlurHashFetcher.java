package expo.modules.image.blurhash;

import android.graphics.Bitmap;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import io.sentry.protocol.SentryThread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0016H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lexpo/modules/image/blurhash/BlurHashFetcher;", "Lcom/bumptech/glide/load/data/DataFetcher;", "Landroid/graphics/Bitmap;", "blurHash", "", "width", "", "height", "punch", "", "(Ljava/lang/String;IIF)V", "cancel", "", "cleanup", "getDataClass", "Ljava/lang/Class;", "getDataSource", "Lcom/bumptech/glide/load/DataSource;", "loadData", "priority", "Lcom/bumptech/glide/Priority;", "callback", "Lcom/bumptech/glide/load/data/DataFetcher$DataCallback;", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BlurHashFetcher.kt */
public final class BlurHashFetcher implements DataFetcher<Bitmap> {
    private final String blurHash;
    private final int height;
    private final float punch;
    private final int width;

    public void cancel() {
    }

    public void cleanup() {
    }

    public Class<Bitmap> getDataClass() {
        return Bitmap.class;
    }

    public BlurHashFetcher(String str, int i, int i2, float f) {
        this.blurHash = str;
        this.width = i;
        this.height = i2;
        this.punch = f;
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public void loadData(Priority priority, DataFetcher.DataCallback<? super Bitmap> dataCallback) {
        Intrinsics.checkNotNullParameter(priority, SentryThread.JsonKeys.PRIORITY);
        Intrinsics.checkNotNullParameter(dataCallback, "callback");
        Bitmap decode$default = BlurhashDecoder.decode$default(BlurhashDecoder.INSTANCE, this.blurHash, this.width, this.height, this.punch, false, 16, (Object) null);
        if (decode$default == null) {
            dataCallback.onLoadFailed(new BlurhashDecodingFailure(this.blurHash));
        } else {
            dataCallback.onDataReady(decode$default);
        }
    }
}
