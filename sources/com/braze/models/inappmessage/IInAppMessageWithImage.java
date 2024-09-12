package com.braze.models.inappmessage;

import android.graphics.Bitmap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\bg\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\u0012\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0011X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0013\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u0011X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0017ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001bÀ\u0006\u0001"}, d2 = {"Lcom/braze/models/inappmessage/IInAppMessageWithImage;", "", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "imageDownloadSuccessful", "", "getImageDownloadSuccessful$annotations", "()V", "getImageDownloadSuccessful", "()Z", "setImageDownloadSuccessful", "(Z)V", "imageUrl", "", "getImageUrl", "()Ljava/lang/String;", "localImageUrl", "getLocalImageUrl", "setLocalImageUrl", "(Ljava/lang/String;)V", "remoteImageUrl", "getRemoteImageUrl", "setRemoteImageUrl", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IInAppMessageWithImage {
    static /* synthetic */ void getImageDownloadSuccessful$annotations() {
    }

    Bitmap getBitmap();

    boolean getImageDownloadSuccessful();

    String getImageUrl();

    String getLocalImageUrl();

    String getRemoteImageUrl();

    void setBitmap(Bitmap bitmap);

    void setImageDownloadSuccessful(boolean z);

    void setLocalImageUrl(String str);

    void setRemoteImageUrl(String str);
}
