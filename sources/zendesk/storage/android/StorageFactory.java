package zendesk.storage.android;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.IOUtils;
import zendesk.storage.android.StorageType;
import zendesk.storage.android.internal.BasicStorage;
import zendesk.storage.android.internal.ComplexStorage;
import zendesk.storage.android.internal.FileOperators;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\r¨\u0006\u000e"}, d2 = {"Lzendesk/storage/android/StorageFactory;", "", "()V", "create", "Lzendesk/storage/android/Storage;", "namespace", "", "context", "Landroid/content/Context;", "type", "Lzendesk/storage/android/StorageType;", "getDirectory", "Ljava/io/File;", "getDirectory$zendesk_storage_storage_android", "zendesk.storage_storage-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StorageFactory.kt */
public final class StorageFactory {
    public static final StorageFactory INSTANCE = new StorageFactory();

    private StorageFactory() {
    }

    public final Storage create(String str, Context context, StorageType storageType) {
        Intrinsics.checkNotNullParameter(str, "namespace");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageType, "type");
        if (storageType instanceof StorageType.Basic) {
            return new BasicStorage(str, context);
        }
        if (storageType instanceof StorageType.Complex) {
            return new ComplexStorage(str, getDirectory$zendesk_storage_storage_android(str, context), ((StorageType.Complex) storageType).getSerializer(), new FileOperators());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final File getDirectory$zendesk_storage_storage_android(String str, Context context) {
        Intrinsics.checkNotNullParameter(str, "namespace");
        Intrinsics.checkNotNullParameter(context, "context");
        return new File(context.getCacheDir().getPath() + IOUtils.DIR_SEPARATOR_UNIX + str);
    }
}
