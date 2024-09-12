package expo.modules.camera.utils;

import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007¨\u0006\u000b"}, d2 = {"Lexpo/modules/camera/utils/FileSystemUtils;", "", "()V", "ensureDirExists", "Ljava/io/File;", "dir", "generateOutputPath", "", "internalDirectory", "dirName", "extension", "expo-camera_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FileSystemUtils.kt */
public final class FileSystemUtils {
    public static final FileSystemUtils INSTANCE = new FileSystemUtils();

    private FileSystemUtils() {
    }

    public final File ensureDirExists(File file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "dir");
        if (file.isDirectory() || file.mkdirs()) {
            return file;
        }
        throw new IOException("Couldn't create directory '" + file + "'");
    }

    public final String generateOutputPath(File file, String str, String str2) throws IOException {
        Intrinsics.checkNotNullParameter(file, "internalDirectory");
        Intrinsics.checkNotNullParameter(str, "dirName");
        Intrinsics.checkNotNullParameter(str2, ShareConstants.MEDIA_EXTENSION);
        String file2 = file.toString();
        File file3 = new File(file2 + File.separator + str);
        ensureDirExists(file3);
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        String file4 = file3.toString();
        return file4 + File.separator + uuid + str2;
    }
}
