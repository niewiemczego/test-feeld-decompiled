package expo.modules.kotlin.activityresult;

import androidx.activity.result.ActivityResultCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u00042\u000e\u0010\u0005\u001a\n \u0006*\u0004\u0018\u0001H\u0004H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "I", "Ljava/io/Serializable;", "O", "output", "kotlin.jvm.PlatformType", "onActivityResult", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AppContextActivityResultLauncher.kt */
final class AppContextActivityResultLauncher$launch$2$1<O> implements ActivityResultCallback {
    final /* synthetic */ Continuation<O> $continuation;

    AppContextActivityResultLauncher$launch$2$1(Continuation<? super O> continuation) {
        this.$continuation = continuation;
    }

    public final void onActivityResult(O o) {
        Continuation<O> continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m983constructorimpl(o));
    }
}
