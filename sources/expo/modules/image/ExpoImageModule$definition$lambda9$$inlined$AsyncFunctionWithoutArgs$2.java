package expo.modules.image;

import android.app.Activity;
import com.bumptech.glide.Glide;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: expo.modules.image.ExpoImageModule$definition$lambda-9$$inlined$AsyncFunctionWithoutArgs$2  reason: invalid class name */
/* compiled from: ObjectDefinitionBuilder.kt */
public final class ExpoImageModule$definition$lambda9$$inlined$AsyncFunctionWithoutArgs$2 extends Lambda implements Function1<Object[], Object> {
    final /* synthetic */ ExpoImageModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpoImageModule$definition$lambda9$$inlined$AsyncFunctionWithoutArgs$2(ExpoImageModule expoImageModule) {
        super(1);
        this.this$0 = expoImageModule;
    }

    public final Object invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "it");
        Activity currentActivity = this.this$0.getAppContext().getCurrentActivity();
        if (currentActivity == null) {
            return false;
        }
        Glide.get(currentActivity).clearDiskCache();
        return true;
    }
}
