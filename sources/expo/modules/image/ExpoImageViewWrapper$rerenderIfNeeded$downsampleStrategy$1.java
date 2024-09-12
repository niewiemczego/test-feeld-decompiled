package expo.modules.image;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import expo.modules.image.enums.ContentFit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0002J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0010H\u0016J(\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0010H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"expo/modules/image/ExpoImageViewWrapper$rerenderIfNeeded$downsampleStrategy$1", "Lcom/bumptech/glide/load/resource/bitmap/DownsampleStrategy;", "wasTriggered", "", "getWasTriggered", "()Z", "setWasTriggered", "(Z)V", "calculateScaleFactor", "", "sourceWidth", "sourceHeight", "requestedWidth", "requestedHeight", "getSampleSizeRounding", "Lcom/bumptech/glide/load/resource/bitmap/DownsampleStrategy$SampleSizeRounding;", "", "getScaleFactor", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoImageViewWrapper.kt */
public final class ExpoImageViewWrapper$rerenderIfNeeded$downsampleStrategy$1 extends DownsampleStrategy {
    final /* synthetic */ ImageViewWrapperTarget $newTarget;
    final /* synthetic */ ExpoImageViewWrapper this$0;
    private boolean wasTriggered;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ExpoImageViewWrapper.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ContentFit.values().length];
            iArr[ContentFit.Contain.ordinal()] = 1;
            iArr[ContentFit.Cover.ordinal()] = 2;
            iArr[ContentFit.Fill.ordinal()] = 3;
            iArr[ContentFit.None.ordinal()] = 4;
            iArr[ContentFit.ScaleDown.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    ExpoImageViewWrapper$rerenderIfNeeded$downsampleStrategy$1(ImageViewWrapperTarget imageViewWrapperTarget, ExpoImageViewWrapper expoImageViewWrapper) {
        this.$newTarget = imageViewWrapperTarget;
        this.this$0 = expoImageViewWrapper;
    }

    public final boolean getWasTriggered() {
        return this.wasTriggered;
    }

    public final void setWasTriggered(boolean z) {
        this.wasTriggered = z;
    }

    public float getScaleFactor(int i, int i2, int i3, int i4) {
        if (!this.wasTriggered) {
            this.$newTarget.setSourceWidth(i);
            this.$newTarget.setSourceHeight(i2);
            this.wasTriggered = true;
        }
        if (i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE) {
            return 1.0f;
        }
        return Math.min(1.0f, calculateScaleFactor((float) i, (float) i2, (float) i3, (float) i4));
    }

    private final float calculateScaleFactor(float f, float f2, float f3, float f4) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.this$0.getContentFit$expo_image_release().ordinal()];
        if (i == 1) {
            return Math.min(f3 / f, f4 / f2);
        }
        if (i == 2) {
            return Float.max(f3 / f, f4 / f2);
        }
        if (i == 3 || i == 4) {
            return 1.0f;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        } else if (f3 < f || f4 < f2) {
            return Math.min(f3 / f, f4 / f2);
        } else {
            return 1.0f;
        }
    }

    public DownsampleStrategy.SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
        return DownsampleStrategy.SampleSizeRounding.QUALITY;
    }
}
