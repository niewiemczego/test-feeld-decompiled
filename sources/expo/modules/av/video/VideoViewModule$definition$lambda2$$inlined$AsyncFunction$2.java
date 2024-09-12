package expo.modules.av.video;

import expo.modules.av.ViewUtils;
import expo.modules.kotlin.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u00012\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007H\n¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "it", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$12"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: expo.modules.av.video.VideoViewModule$definition$lambda-2$$inlined$AsyncFunction$2  reason: invalid class name */
/* compiled from: ObjectDefinitionBuilder.kt */
public final class VideoViewModule$definition$lambda2$$inlined$AsyncFunction$2 extends Lambda implements Function1<Object[], Object> {
    final /* synthetic */ VideoViewModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoViewModule$definition$lambda2$$inlined$AsyncFunction$2(VideoViewModule videoViewModule) {
        super(1);
        this.this$0 = videoViewModule;
    }

    public final Object invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "it");
        Integer num = objArr[0];
        if (num != null) {
            Integer num2 = num;
            Boolean bool = objArr[1];
            if (bool != null) {
                Boolean bool2 = bool;
                Promise promise = objArr[2];
                if (promise != null) {
                    Promise promise2 = promise;
                    boolean booleanValue = bool2.booleanValue();
                    ViewUtils.INSTANCE.tryRunWithVideoView(this.this$0.getAppContext().getLegacyModuleRegistry(), num2.intValue(), (ViewUtils.VideoViewCallback) new VideoViewModule$definition$1$2$1(booleanValue, promise2), promise2);
                    return Unit.INSTANCE;
                }
                throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
