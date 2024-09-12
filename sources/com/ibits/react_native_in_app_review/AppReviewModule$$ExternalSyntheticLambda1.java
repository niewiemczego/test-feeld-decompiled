package com.ibits.react_native_in_app_review;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AppReviewModule$$ExternalSyntheticLambda1 implements OnCompleteListener {
    public final /* synthetic */ AppReviewModule f$0;
    public final /* synthetic */ ReviewManager f$1;

    public /* synthetic */ AppReviewModule$$ExternalSyntheticLambda1(AppReviewModule appReviewModule, ReviewManager reviewManager) {
        this.f$0 = appReviewModule;
        this.f$1 = reviewManager;
    }

    public final void onComplete(Task task) {
        this.f$0.m604lambda$show$1$comibitsreact_native_in_app_reviewAppReviewModule(this.f$1, task);
    }
}
