package expo.modules.image.enums;

import com.bumptech.glide.load.DataSource;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u001b\b\u0002\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0018\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lexpo/modules/image/enums/ImageCacheType;", "", "dataSources", "", "Lcom/bumptech/glide/load/DataSource;", "(Ljava/lang/String;I[Lcom/bumptech/glide/load/DataSource;)V", "[Lcom/bumptech/glide/load/DataSource;", "NONE", "DISK", "MEMORY", "Companion", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageCacheType.kt */
public enum ImageCacheType {
    NONE(DataSource.LOCAL, DataSource.REMOTE),
    DISK(DataSource.DATA_DISK_CACHE, DataSource.RESOURCE_DISK_CACHE),
    MEMORY(DataSource.MEMORY_CACHE);
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public final DataSource[] dataSources;

    private ImageCacheType(DataSource... dataSourceArr) {
        this.dataSources = dataSourceArr;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/image/enums/ImageCacheType$Companion;", "", "()V", "fromNativeValue", "Lexpo/modules/image/enums/ImageCacheType;", "value", "Lcom/bumptech/glide/load/DataSource;", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ImageCacheType.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImageCacheType fromNativeValue(DataSource dataSource) {
            ImageCacheType imageCacheType;
            Intrinsics.checkNotNullParameter(dataSource, "value");
            ImageCacheType[] values = ImageCacheType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    imageCacheType = null;
                    break;
                }
                imageCacheType = values[i];
                if (ArraysKt.contains((T[]) imageCacheType.dataSources, dataSource)) {
                    break;
                }
                i++;
            }
            return imageCacheType == null ? ImageCacheType.NONE : imageCacheType;
        }
    }
}
