package coil.fetch;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import coil.ImageLoader;
import coil.decode.ContentMetadata;
import coil.decode.DataSource;
import coil.decode.ImageSource;
import coil.decode.ImageSources;
import coil.fetch.Fetcher;
import coil.request.Options;
import coil.size.Dimension;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\b\fJ\u0015\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\b\u000eJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcoil/fetch/ContentUriFetcher;", "Lcoil/fetch/Fetcher;", "data", "Landroid/net/Uri;", "options", "Lcoil/request/Options;", "(Landroid/net/Uri;Lcoil/request/Options;)V", "fetch", "Lcoil/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isContactPhotoUri", "", "isContactPhotoUri$coil_base_release", "isMusicThumbnailUri", "isMusicThumbnailUri$coil_base_release", "newMusicThumbnailSizeOptions", "Landroid/os/Bundle;", "Factory", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ContentUriFetcher.kt */
public final class ContentUriFetcher implements Fetcher {
    private final Uri data;
    private final Options options;

    public ContentUriFetcher(Uri uri, Options options2) {
        this.data = uri;
        this.options = options2;
    }

    public Object fetch(Continuation<? super FetchResult> continuation) {
        InputStream inputStream;
        ContentResolver contentResolver = this.options.getContext().getContentResolver();
        FileInputStream fileInputStream = null;
        if (isContactPhotoUri$coil_base_release(this.data)) {
            AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.data, "r");
            if (openAssetFileDescriptor != null) {
                fileInputStream = openAssetFileDescriptor.createInputStream();
            }
            if (fileInputStream != null) {
                inputStream = fileInputStream;
            } else {
                throw new IllegalStateException(("Unable to find a contact photo associated with '" + this.data + "'.").toString());
            }
        } else if (Build.VERSION.SDK_INT < 29 || !isMusicThumbnailUri$coil_base_release(this.data)) {
            inputStream = contentResolver.openInputStream(this.data);
            if (inputStream == null) {
                throw new IllegalStateException(("Unable to open '" + this.data + "'.").toString());
            }
        } else {
            AssetFileDescriptor openTypedAssetFile = contentResolver.openTypedAssetFile(this.data, "image/*", newMusicThumbnailSizeOptions(), (CancellationSignal) null);
            if (openTypedAssetFile != null) {
                fileInputStream = openTypedAssetFile.createInputStream();
            }
            if (fileInputStream != null) {
                inputStream = fileInputStream;
            } else {
                throw new IllegalStateException(("Unable to find a music thumbnail associated with '" + this.data + "'.").toString());
            }
        }
        return new SourceResult(ImageSources.create(Okio.buffer(Okio.source(inputStream)), this.options.getContext(), (ImageSource.Metadata) new ContentMetadata(this.data)), contentResolver.getType(this.data), DataSource.DISK);
    }

    public final boolean isContactPhotoUri$coil_base_release(Uri uri) {
        return Intrinsics.areEqual((Object) uri.getAuthority(), (Object) "com.android.contacts") && Intrinsics.areEqual((Object) uri.getLastPathSegment(), (Object) "display_photo");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        r5 = r5.getPathSegments();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isMusicThumbnailUri$coil_base_release(android.net.Uri r5) {
        /*
            r4 = this;
            java.lang.String r0 = r5.getAuthority()
            java.lang.String r1 = "media"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            r1 = 0
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.util.List r5 = r5.getPathSegments()
            int r0 = r5.size()
            r2 = 3
            if (r0 < r2) goto L_0x0036
            int r2 = r0 + -3
            java.lang.Object r2 = r5.get(r2)
            java.lang.String r3 = "audio"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0036
            int r0 = r0 + -2
            java.lang.Object r5 = r5.get(r0)
            java.lang.String r0 = "albums"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r0)
            if (r5 == 0) goto L_0x0036
            r1 = 1
        L_0x0036:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.fetch.ContentUriFetcher.isMusicThumbnailUri$coil_base_release(android.net.Uri):boolean");
    }

    private final Bundle newMusicThumbnailSizeOptions() {
        Dimension width = this.options.getSize().getWidth();
        Dimension.Pixels pixels = width instanceof Dimension.Pixels ? (Dimension.Pixels) width : null;
        if (pixels == null) {
            return null;
        }
        int i = pixels.px;
        Dimension height = this.options.getSize().getHeight();
        Dimension.Pixels pixels2 = height instanceof Dimension.Pixels ? (Dimension.Pixels) height : null;
        if (pixels2 == null) {
            return null;
        }
        int i2 = pixels2.px;
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("android.content.extra.SIZE", new Point(i, i2));
        return bundle;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\r"}, d2 = {"Lcoil/fetch/ContentUriFetcher$Factory;", "Lcoil/fetch/Fetcher$Factory;", "Landroid/net/Uri;", "()V", "create", "Lcoil/fetch/Fetcher;", "data", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "isApplicable", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ContentUriFetcher.kt */
    public static final class Factory implements Fetcher.Factory<Uri> {
        public Fetcher create(Uri uri, Options options, ImageLoader imageLoader) {
            if (!isApplicable(uri)) {
                return null;
            }
            return new ContentUriFetcher(uri, options);
        }

        private final boolean isApplicable(Uri uri) {
            return Intrinsics.areEqual((Object) uri.getScheme(), (Object) "content");
        }
    }
}
