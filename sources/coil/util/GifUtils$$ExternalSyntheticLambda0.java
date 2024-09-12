package coil.util;

import android.graphics.Canvas;
import android.graphics.PostProcessor;
import coil.transform.AnimatedTransformation;

/* renamed from: coil.util.-GifUtils$$ExternalSyntheticLambda0  reason: invalid class name */
/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GifUtils$$ExternalSyntheticLambda0 implements PostProcessor {
    public final /* synthetic */ AnimatedTransformation f$0;

    public /* synthetic */ GifUtils$$ExternalSyntheticLambda0(AnimatedTransformation animatedTransformation) {
        this.f$0 = animatedTransformation;
    }

    public final int onPostProcess(Canvas canvas) {
        return GifUtils.m88asPostProcessor$lambda0(this.f$0, canvas);
    }
}
