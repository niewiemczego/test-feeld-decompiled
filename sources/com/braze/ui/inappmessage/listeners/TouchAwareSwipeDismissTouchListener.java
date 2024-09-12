package com.braze.ui.inappmessage.listeners;

import android.view.MotionEvent;
import android.view.View;
import com.braze.ui.inappmessage.listeners.SwipeDismissTouchListener;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0013B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/braze/ui/inappmessage/listeners/TouchAwareSwipeDismissTouchListener;", "Lcom/braze/ui/inappmessage/listeners/SwipeDismissTouchListener;", "view", "Landroid/view/View;", "callbacks", "Lcom/braze/ui/inappmessage/listeners/SwipeDismissTouchListener$DismissCallbacks;", "(Landroid/view/View;Lcom/braze/ui/inappmessage/listeners/SwipeDismissTouchListener$DismissCallbacks;)V", "token", "", "(Landroid/view/View;Ljava/lang/Object;Lcom/braze/ui/inappmessage/listeners/SwipeDismissTouchListener$DismissCallbacks;)V", "touchListener", "Lcom/braze/ui/inappmessage/listeners/TouchAwareSwipeDismissTouchListener$ITouchListener;", "onTouch", "", "motionEvent", "Landroid/view/MotionEvent;", "setTouchListener", "", "newTouchListener", "ITouchListener", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TouchAwareSwipeDismissTouchListener.kt */
public final class TouchAwareSwipeDismissTouchListener extends SwipeDismissTouchListener {
    private ITouchListener touchListener;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Lcom/braze/ui/inappmessage/listeners/TouchAwareSwipeDismissTouchListener$ITouchListener;", "", "onTouchEnded", "", "onTouchStartedOrContinued", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TouchAwareSwipeDismissTouchListener.kt */
    public interface ITouchListener {
        void onTouchEnded();

        void onTouchStartedOrContinued();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TouchAwareSwipeDismissTouchListener(View view, Object obj, SwipeDismissTouchListener.DismissCallbacks dismissCallbacks) {
        super(view, obj, dismissCallbacks);
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TouchAwareSwipeDismissTouchListener(View view, SwipeDismissTouchListener.DismissCallbacks dismissCallbacks) {
        this(view, (Object) null, dismissCallbacks);
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
    }

    public final void setTouchListener(ITouchListener iTouchListener) {
        Intrinsics.checkNotNullParameter(iTouchListener, "newTouchListener");
        this.touchListener = iTouchListener;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        ITouchListener iTouchListener;
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        int action = motionEvent.getAction();
        if (action == 0) {
            ITouchListener iTouchListener2 = this.touchListener;
            if (iTouchListener2 != null) {
                iTouchListener2.onTouchStartedOrContinued();
            }
        } else if ((action == 1 || action == 3) && (iTouchListener = this.touchListener) != null) {
            iTouchListener.onTouchEnded();
        }
        return super.onTouch(view, motionEvent);
    }
}
