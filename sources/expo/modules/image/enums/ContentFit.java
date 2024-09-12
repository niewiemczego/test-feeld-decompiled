package expo.modules.image.enums;

import android.graphics.Matrix;
import android.graphics.RectF;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J-\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lexpo/modules/image/enums/ContentFit;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toMatrix", "Landroid/graphics/Matrix;", "imageRect", "Landroid/graphics/RectF;", "viewRect", "sourceWidth", "", "sourceHeight", "toMatrix$expo_image_release", "Contain", "Cover", "Fill", "None", "ScaleDown", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ContentFit.kt */
public enum ContentFit implements Enumerable {
    Contain("contain"),
    Cover("cover"),
    Fill("fill"),
    None("none"),
    ScaleDown("scale-down");
    
    private final String value;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ContentFit.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

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

    private ContentFit(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final Matrix toMatrix$expo_image_release(RectF rectF, RectF rectF2, int i, int i2) {
        Intrinsics.checkNotNullParameter(rectF, "imageRect");
        Intrinsics.checkNotNullParameter(rectF2, "viewRect");
        Matrix matrix = new Matrix();
        int i3 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i3 == 1) {
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
        } else if (i3 == 2) {
            float width = rectF.width();
            float height = rectF.height();
            float max = Math.max(rectF2.width() / width, rectF2.height() / height);
            matrix.setScale(max, max);
        } else if (i3 == 3) {
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
        } else if (i3 == 5) {
            if (i != -1 && i2 != -1) {
                RectF rectF3 = new RectF(0.0f, 0.0f, (float) i, (float) i2);
                if (rectF3.width() >= rectF2.width() || rectF3.height() >= rectF2.height()) {
                    matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else {
                    matrix.setRectToRect(rectF, rectF3, Matrix.ScaleToFit.START);
                }
            } else if (rectF.width() >= rectF2.width() || rectF.height() >= rectF2.height()) {
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            }
        }
        return matrix;
    }
}
