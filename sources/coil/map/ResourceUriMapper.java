package coil.map;

import android.content.res.Resources;
import android.net.Uri;
import coil.request.Options;
import com.facebook.common.util.UriUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcoil/map/ResourceUriMapper;", "Lcoil/map/Mapper;", "Landroid/net/Uri;", "()V", "isApplicable", "", "data", "map", "options", "Lcoil/request/Options;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ResourceUriMapper.kt */
public final class ResourceUriMapper implements Mapper<Uri, Uri> {
    public Uri map(Uri uri, Options options) {
        if (!isApplicable(uri)) {
            return null;
        }
        String authority = uri.getAuthority();
        if (authority == null) {
            authority = "";
        }
        Resources resourcesForApplication = options.getContext().getPackageManager().getResourcesForApplication(authority);
        List<String> pathSegments = uri.getPathSegments();
        boolean z = false;
        int identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
        if (identifier != 0) {
            z = true;
        }
        if (z) {
            Uri parse = Uri.parse("android.resource://" + authority + IOUtils.DIR_SEPARATOR_UNIX + identifier);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(this)");
            return parse;
        }
        throw new IllegalStateException(("Invalid android.resource URI: " + uri).toString());
    }

    private final boolean isApplicable(Uri uri) {
        if (Intrinsics.areEqual((Object) uri.getScheme(), (Object) UriUtil.QUALIFIED_RESOURCE_SCHEME)) {
            CharSequence authority = uri.getAuthority();
            if (!(authority == null || StringsKt.isBlank(authority)) && uri.getPathSegments().size() == 2) {
                return true;
            }
        }
        return false;
    }
}
