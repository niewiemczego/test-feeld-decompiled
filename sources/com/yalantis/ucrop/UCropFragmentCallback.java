package com.yalantis.ucrop;

import com.yalantis.ucrop.UCropFragment;

public interface UCropFragmentCallback {
    void loadingProgress(boolean z);

    void onCropFinish(UCropFragment.UCropResult uCropResult);
}
