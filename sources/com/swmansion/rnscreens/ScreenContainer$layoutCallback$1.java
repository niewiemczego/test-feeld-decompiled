package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.modules.core.ChoreographerCompat;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/swmansion/rnscreens/ScreenContainer$layoutCallback$1", "Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;", "doFrame", "", "frameTimeNanos", "", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ScreenContainer.kt */
public final class ScreenContainer$layoutCallback$1 extends ChoreographerCompat.FrameCallback {
    final /* synthetic */ ScreenContainer this$0;

    ScreenContainer$layoutCallback$1(ScreenContainer screenContainer) {
        this.this$0 = screenContainer;
    }

    public void doFrame(long j) {
        this.this$0.isLayoutEnqueued = false;
        ScreenContainer screenContainer = this.this$0;
        screenContainer.measure(View.MeasureSpec.makeMeasureSpec(screenContainer.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.this$0.getHeight(), 1073741824));
        ScreenContainer screenContainer2 = this.this$0;
        screenContainer2.layout(screenContainer2.getLeft(), this.this$0.getTop(), this.this$0.getRight(), this.this$0.getBottom());
    }
}
