package com.facebook.gamingservices.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.HttpMethod;
import com.facebook.internal.Utility;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J.\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J.\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/gamingservices/internal/GamingMediaUploader;", "", "()V", "photoUploadEdge", "", "uploadToGamingServices", "Lcom/facebook/GraphRequestAsyncTask;", "caption", "imageBitmap", "Landroid/graphics/Bitmap;", "params", "Landroid/os/Bundle;", "callback", "Lcom/facebook/GraphRequest$Callback;", "imageUri", "Landroid/net/Uri;", "imageFile", "Ljava/io/File;", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GamingMediaUploader.kt */
public final class GamingMediaUploader {
    public static final GamingMediaUploader INSTANCE = new GamingMediaUploader();
    private static final String photoUploadEdge = "me/photos";

    private GamingMediaUploader() {
    }

    @JvmStatic
    public static final GraphRequestAsyncTask uploadToGamingServices(String str, Bitmap bitmap, Bundle bundle, GraphRequest.Callback callback) {
        Intrinsics.checkNotNullParameter(bitmap, "imageBitmap");
        return GraphRequest.Companion.newUploadPhotoRequest(AccessToken.Companion.getCurrentAccessToken(), photoUploadEdge, bitmap, str, bundle, callback).executeAsync();
    }

    @JvmStatic
    public static final GraphRequestAsyncTask uploadToGamingServices(String str, File file, Bundle bundle, GraphRequest.Callback callback) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(file, "imageFile");
        return GraphRequest.Companion.newUploadPhotoRequest(AccessToken.Companion.getCurrentAccessToken(), photoUploadEdge, file, str, bundle, callback).executeAsync();
    }

    @JvmStatic
    public static final GraphRequestAsyncTask uploadToGamingServices(String str, Uri uri, Bundle bundle, GraphRequest.Callback callback) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(uri, "imageUri");
        Utility utility = Utility.INSTANCE;
        if (!Utility.isFileUri(uri)) {
            Utility utility2 = Utility.INSTANCE;
            if (!Utility.isContentUri(uri)) {
                Bundle bundle2 = new Bundle();
                if (bundle != null) {
                    bundle2.putAll(bundle);
                }
                bundle2.putString("url", uri.toString());
                CharSequence charSequence = str;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    bundle2.putString(ShareConstants.FEED_CAPTION_PARAM, str);
                }
                return new GraphRequest(AccessToken.Companion.getCurrentAccessToken(), photoUploadEdge, bundle2, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null).executeAsync();
            }
        }
        return GraphRequest.Companion.newUploadPhotoRequest(AccessToken.Companion.getCurrentAccessToken(), photoUploadEdge, uri, str, bundle, callback).executeAsync();
    }
}
