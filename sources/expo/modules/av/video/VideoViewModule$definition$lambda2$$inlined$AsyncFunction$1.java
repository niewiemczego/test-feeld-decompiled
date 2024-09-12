package expo.modules.av.video;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.av.ViewUtils;
import expo.modules.kotlin.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u00012\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "args", "", "", "promise", "Lexpo/modules/kotlin/Promise;", "invoke", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$11"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: expo.modules.av.video.VideoViewModule$definition$lambda-2$$inlined$AsyncFunction$1  reason: invalid class name */
/* compiled from: ObjectDefinitionBuilder.kt */
public final class VideoViewModule$definition$lambda2$$inlined$AsyncFunction$1 extends Lambda implements Function2<Object[], Promise, Unit> {
    final /* synthetic */ VideoViewModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoViewModule$definition$lambda2$$inlined$AsyncFunction$1(VideoViewModule videoViewModule) {
        super(2);
        this.this$0 = videoViewModule;
    }

    public final void invoke(Object[] objArr, Promise promise) {
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Integer num = objArr[0];
        if (num != null) {
            Integer num2 = num;
            Boolean bool = objArr[1];
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                ViewUtils.INSTANCE.tryRunWithVideoView(this.this$0.getAppContext().getLegacyModuleRegistry(), num2.intValue(), (ViewUtils.VideoViewCallback) new VideoViewModule$definition$1$2$1(booleanValue, promise), promise);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Object[]) obj, (Promise) obj2);
        return Unit.INSTANCE;
    }
}
