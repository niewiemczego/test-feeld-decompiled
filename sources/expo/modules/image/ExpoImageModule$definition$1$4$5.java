package expo.modules.image;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "view", "Lexpo/modules/image/ExpoImageViewWrapper;", "blurRadius", "", "invoke", "(Lexpo/modules/image/ExpoImageViewWrapper;Ljava/lang/Integer;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoImageModule.kt */
final class ExpoImageModule$definition$1$4$5 extends Lambda implements Function2<ExpoImageViewWrapper, Integer, Unit> {
    public static final ExpoImageModule$definition$1$4$5 INSTANCE = new ExpoImageModule$definition$1$4$5();

    ExpoImageModule$definition$1$4$5() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ExpoImageViewWrapper) obj, (Integer) obj2);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if ((r4.intValue() > 0) != false) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(expo.modules.image.ExpoImageViewWrapper r3, java.lang.Integer r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            if (r4 == 0) goto L_0x0018
            r1 = r4
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            if (r1 <= 0) goto L_0x0014
            r1 = 1
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            if (r1 == 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r4 = r0
        L_0x0019:
            r3.setBlurRadius$expo_image_release(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.image.ExpoImageModule$definition$1$4$5.invoke(expo.modules.image.ExpoImageViewWrapper, java.lang.Integer):void");
    }
}