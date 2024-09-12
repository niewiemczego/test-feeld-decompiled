package coil.map;

import android.net.Uri;
import coil.request.Options;
import coil.util.Utils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcoil/map/FileUriMapper;", "Lcoil/map/Mapper;", "Landroid/net/Uri;", "Ljava/io/File;", "()V", "isApplicable", "", "data", "map", "options", "Lcoil/request/Options;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FileUriMapper.kt */
public final class FileUriMapper implements Mapper<Uri, File> {
    public File map(Uri uri, Options options) {
        if (!isApplicable(uri)) {
            return null;
        }
        String path = uri.getPath();
        Intrinsics.checkNotNull(path);
        return new File(path);
    }

    private final boolean isApplicable(Uri uri) {
        if (!Utils.isAssetUri(uri)) {
            String scheme = uri.getScheme();
            if (scheme == null || Intrinsics.areEqual((Object) scheme, (Object) "file")) {
                String path = uri.getPath();
                if (path == null) {
                    path = "";
                }
                if (StringsKt.startsWith$default((CharSequence) path, (char) IOUtils.DIR_SEPARATOR_UNIX, false, 2, (Object) null) && Utils.getFirstPathSegment(uri) != null) {
                    return true;
                }
            }
        }
        return false;
    }
}
