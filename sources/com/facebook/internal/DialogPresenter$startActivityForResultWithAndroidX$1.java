package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00030\u0001J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"com/facebook/internal/DialogPresenter$startActivityForResultWithAndroidX$1", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/content/Intent;", "Landroid/util/Pair;", "", "createIntent", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "intent", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: DialogPresenter.kt */
public final class DialogPresenter$startActivityForResultWithAndroidX$1 extends ActivityResultContract<Intent, Pair<Integer, Intent>> {
    public Intent createIntent(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "input");
        return intent;
    }

    DialogPresenter$startActivityForResultWithAndroidX$1() {
    }

    public Pair<Integer, Intent> parseResult(int i, Intent intent) {
        Pair<Integer, Intent> create = Pair.create(Integer.valueOf(i), intent);
        Intrinsics.checkNotNullExpressionValue(create, "create(resultCode, intent)");
        return create;
    }
}
