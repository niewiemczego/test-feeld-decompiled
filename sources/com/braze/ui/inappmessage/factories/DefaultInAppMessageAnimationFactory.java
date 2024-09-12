package com.braze.ui.inappmessage.factories;

import android.content.res.Resources;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.braze.enums.inappmessage.SlideFrom;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageSlideup;
import com.braze.ui.inappmessage.IInAppMessageAnimationFactory;
import com.braze.ui.support.AnimationUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/braze/ui/inappmessage/factories/DefaultInAppMessageAnimationFactory;", "Lcom/braze/ui/inappmessage/IInAppMessageAnimationFactory;", "()V", "shortAnimationDurationMs", "", "getClosingAnimation", "Landroid/view/animation/Animation;", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "getOpeningAnimation", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultInAppMessageAnimationFactory.kt */
public class DefaultInAppMessageAnimationFactory implements IInAppMessageAnimationFactory {
    private final long shortAnimationDurationMs = ((long) Resources.getSystem().getInteger(17694720));

    public Animation getOpeningAnimation(IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        if (!(iInAppMessage instanceof InAppMessageSlideup)) {
            return AnimationUtils.setAnimationParams(new AlphaAnimation(0.0f, 1.0f), this.shortAnimationDurationMs, true);
        }
        if (((InAppMessageSlideup) iInAppMessage).getSlideFrom() == SlideFrom.TOP) {
            return AnimationUtils.createVerticalAnimation(-1.0f, 0.0f, this.shortAnimationDurationMs, false);
        }
        return AnimationUtils.createVerticalAnimation(1.0f, 0.0f, this.shortAnimationDurationMs, false);
    }

    public Animation getClosingAnimation(IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        if (!(iInAppMessage instanceof InAppMessageSlideup)) {
            return AnimationUtils.setAnimationParams(new AlphaAnimation(1.0f, 0.0f), this.shortAnimationDurationMs, false);
        }
        if (((InAppMessageSlideup) iInAppMessage).getSlideFrom() == SlideFrom.TOP) {
            return AnimationUtils.createVerticalAnimation(0.0f, -1.0f, this.shortAnimationDurationMs, false);
        }
        return AnimationUtils.createVerticalAnimation(0.0f, 1.0f, this.shortAnimationDurationMs, false);
    }
}
