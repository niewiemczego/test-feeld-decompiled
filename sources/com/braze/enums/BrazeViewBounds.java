package com.braze.enums;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/braze/enums/BrazeViewBounds;", "", "widthDp", "", "heightDp", "(Ljava/lang/String;III)V", "getHeightDp", "()I", "getWidthDp", "NOTIFICATION_EXPANDED_IMAGE", "NOTIFICATION_INLINE_PUSH_IMAGE", "NOTIFICATION_LARGE_ICON", "NOTIFICATION_ONE_IMAGE_STORY", "BASE_CARD_VIEW", "IN_APP_MESSAGE_MODAL", "IN_APP_MESSAGE_SLIDEUP", "NO_BOUNDS", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum BrazeViewBounds {
    NOTIFICATION_EXPANDED_IMAGE(478, 256),
    NOTIFICATION_INLINE_PUSH_IMAGE(BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 256),
    NOTIFICATION_LARGE_ICON(64, 64),
    NOTIFICATION_ONE_IMAGE_STORY(256, 128),
    BASE_CARD_VIEW(512, 512),
    IN_APP_MESSAGE_MODAL(580, 580),
    IN_APP_MESSAGE_SLIDEUP(100, 100),
    NO_BOUNDS(0, 0);
    
    private final int heightDp;
    private final int widthDp;

    private BrazeViewBounds(int i, int i2) {
        this.widthDp = i;
        this.heightDp = i2;
    }

    public final int getHeightDp() {
        return this.heightDp;
    }

    public final int getWidthDp() {
        return this.widthDp;
    }
}
