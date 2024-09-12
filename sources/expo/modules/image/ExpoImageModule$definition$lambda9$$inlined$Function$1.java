package expo.modules.image;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u00012\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "R", "P0", "it", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$Function$5"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: expo.modules.image.ExpoImageModule$definition$lambda-9$$inlined$Function$1  reason: invalid class name */
/* compiled from: ObjectDefinitionBuilder.kt */
public final class ExpoImageModule$definition$lambda9$$inlined$Function$1 extends Lambda implements Function1<Object[], Object> {
    final /* synthetic */ ExpoImageModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpoImageModule$definition$lambda9$$inlined$Function$1(ExpoImageModule expoImageModule) {
        super(1);
        this.this$0 = expoImageModule;
    }

    public final Object invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "it");
        List list = objArr[0];
        if (list != null) {
            List<String> list2 = list;
            Context reactContext = this.this$0.getAppContext().getReactContext();
            if (reactContext != null) {
                for (String glideUrl : list2) {
                    Glide.with(reactContext).download(new GlideUrl(glideUrl)).submit();
                }
            }
            return Unit.INSTANCE;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
    }
}
