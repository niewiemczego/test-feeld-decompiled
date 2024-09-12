package coil.fetch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.TypedValue;
import android.webkit.MimeTypeMap;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.ImageSource;
import coil.decode.ImageSources;
import coil.decode.ResourceMetadata;
import coil.fetch.Fetcher;
import coil.request.Options;
import coil.util.Contexts;
import coil.util.DrawableUtils;
import coil.util.Utils;
import com.facebook.common.util.UriUtil;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Okio;
import org.apache.commons.io.IOUtils;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0002\f\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcoil/fetch/ResourceUriFetcher;", "Lcoil/fetch/Fetcher;", "data", "Landroid/net/Uri;", "options", "Lcoil/request/Options;", "(Landroid/net/Uri;Lcoil/request/Options;)V", "fetch", "Lcoil/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "throwInvalidUriException", "", "Companion", "Factory", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ResourceUriFetcher.kt */
public final class ResourceUriFetcher implements Fetcher {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String MIME_TYPE_XML = "text/xml";
    private final Uri data;
    private final Options options;

    public ResourceUriFetcher(Uri uri, Options options2) {
        this.data = uri;
        this.options = options2;
    }

    public Object fetch(Continuation<? super FetchResult> continuation) {
        Integer intOrNull;
        Resources resources;
        Drawable drawable;
        String authority = this.data.getAuthority();
        if (authority != null) {
            if (!(!StringsKt.isBlank(authority))) {
                authority = null;
            }
            if (authority != null) {
                String str = (String) CollectionsKt.lastOrNull(this.data.getPathSegments());
                if (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) {
                    throwInvalidUriException(this.data);
                    throw new KotlinNothingValueException();
                }
                int intValue = intOrNull.intValue();
                Context context = this.options.getContext();
                if (Intrinsics.areEqual((Object) authority, (Object) context.getPackageName())) {
                    resources = context.getResources();
                } else {
                    resources = context.getPackageManager().getResourcesForApplication(authority);
                }
                TypedValue typedValue = new TypedValue();
                resources.getValue(intValue, typedValue, true);
                CharSequence charSequence = typedValue.string;
                String mimeTypeFromUrl = Utils.getMimeTypeFromUrl(MimeTypeMap.getSingleton(), charSequence.subSequence(StringsKt.lastIndexOf$default(charSequence, (char) IOUtils.DIR_SEPARATOR_UNIX, 0, false, 6, (Object) null), charSequence.length()).toString());
                if (Intrinsics.areEqual((Object) mimeTypeFromUrl, (Object) MIME_TYPE_XML)) {
                    if (Intrinsics.areEqual((Object) authority, (Object) context.getPackageName())) {
                        drawable = Contexts.getDrawableCompat(context, intValue);
                    } else {
                        drawable = Contexts.getXmlDrawableCompat(context, resources, intValue);
                    }
                    Drawable drawable2 = drawable;
                    boolean isVector = Utils.isVector(drawable2);
                    if (isVector) {
                        drawable2 = new BitmapDrawable(context.getResources(), DrawableUtils.INSTANCE.convertToBitmap(drawable2, this.options.getConfig(), this.options.getSize(), this.options.getScale(), this.options.getAllowInexactSize()));
                    }
                    return new DrawableResult(drawable2, isVector, DataSource.DISK);
                }
                TypedValue typedValue2 = new TypedValue();
                return new SourceResult(ImageSources.create(Okio.buffer(Okio.source(resources.openRawResource(intValue, typedValue2))), context, (ImageSource.Metadata) new ResourceMetadata(authority, intValue, typedValue2.density)), mimeTypeFromUrl, DataSource.DISK);
            }
        }
        throwInvalidUriException(this.data);
        throw new KotlinNothingValueException();
    }

    private final Void throwInvalidUriException(Uri uri) {
        throw new IllegalStateException("Invalid android.resource URI: " + uri);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\r"}, d2 = {"Lcoil/fetch/ResourceUriFetcher$Factory;", "Lcoil/fetch/Fetcher$Factory;", "Landroid/net/Uri;", "()V", "create", "Lcoil/fetch/Fetcher;", "data", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "isApplicable", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ResourceUriFetcher.kt */
    public static final class Factory implements Fetcher.Factory<Uri> {
        public Fetcher create(Uri uri, Options options, ImageLoader imageLoader) {
            if (!isApplicable(uri)) {
                return null;
            }
            return new ResourceUriFetcher(uri, options);
        }

        private final boolean isApplicable(Uri uri) {
            return Intrinsics.areEqual((Object) uri.getScheme(), (Object) UriUtil.QUALIFIED_RESOURCE_SCHEME);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/fetch/ResourceUriFetcher$Companion;", "", "()V", "MIME_TYPE_XML", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ResourceUriFetcher.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
