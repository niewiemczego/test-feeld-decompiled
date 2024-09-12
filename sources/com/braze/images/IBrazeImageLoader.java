package com.braze.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import com.braze.enums.BrazeViewBounds;
import com.braze.models.cards.Card;
import com.braze.models.inappmessage.IInAppMessage;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J.\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J2\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J2\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2 = {"Lcom/braze/images/IBrazeImageLoader;", "", "getInAppMessageBitmapFromUrl", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "imageUrl", "", "viewBounds", "Lcom/braze/enums/BrazeViewBounds;", "getPushBitmapFromUrl", "extras", "Landroid/os/Bundle;", "renderUrlIntoCardView", "", "card", "Lcom/braze/models/cards/Card;", "imageView", "Landroid/widget/ImageView;", "renderUrlIntoInAppMessageView", "setOffline", "isOffline", "", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IBrazeImageLoader {
    Bitmap getInAppMessageBitmapFromUrl(Context context, IInAppMessage iInAppMessage, String str, BrazeViewBounds brazeViewBounds);

    Bitmap getPushBitmapFromUrl(Context context, Bundle bundle, String str, BrazeViewBounds brazeViewBounds);

    void renderUrlIntoCardView(Context context, Card card, String str, ImageView imageView, BrazeViewBounds brazeViewBounds);

    void renderUrlIntoInAppMessageView(Context context, IInAppMessage iInAppMessage, String str, ImageView imageView, BrazeViewBounds brazeViewBounds);

    void setOffline(boolean z);
}
