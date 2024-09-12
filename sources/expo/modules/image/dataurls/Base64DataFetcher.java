package expo.modules.image.dataurls;

import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import io.sentry.protocol.SentryThread;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lexpo/modules/image/dataurls/Base64DataFetcher;", "Lcom/bumptech/glide/load/data/DataFetcher;", "Ljava/nio/ByteBuffer;", "data", "", "(Ljava/lang/String;)V", "cancel", "", "cleanup", "getBase64Section", "getDataClass", "Ljava/lang/Class;", "getDataSource", "Lcom/bumptech/glide/load/DataSource;", "loadData", "priority", "Lcom/bumptech/glide/Priority;", "callback", "Lcom/bumptech/glide/load/data/DataFetcher$DataCallback;", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Base64DataFetcher.kt */
public final class Base64DataFetcher implements DataFetcher<ByteBuffer> {
    private final String data;

    public void cancel() {
    }

    public void cleanup() {
    }

    public Class<ByteBuffer> getDataClass() {
        return ByteBuffer.class;
    }

    public Base64DataFetcher(String str) {
        Intrinsics.checkNotNullParameter(str, "data");
        this.data = str;
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public void loadData(Priority priority, DataFetcher.DataCallback<? super ByteBuffer> dataCallback) {
        Intrinsics.checkNotNullParameter(priority, SentryThread.JsonKeys.PRIORITY);
        Intrinsics.checkNotNullParameter(dataCallback, "callback");
        dataCallback.onDataReady(ByteBuffer.wrap(Base64.decode(getBase64Section(), 0)));
    }

    private final String getBase64Section() {
        String substring = this.data.substring(StringsKt.indexOf$default((CharSequence) this.data, ',', 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }
}
