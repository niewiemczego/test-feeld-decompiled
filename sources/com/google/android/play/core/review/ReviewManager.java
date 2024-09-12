package com.google.android.play.core.review;

import android.app.Activity;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.play:review@@2.0.1 */
public interface ReviewManager {
    Task<Void> launchReviewFlow(Activity activity, ReviewInfo reviewInfo);

    Task<ReviewInfo> requestReviewFlow();
}
