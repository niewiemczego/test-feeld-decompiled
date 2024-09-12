package dev.geundung.zendesk.messaging;

import com.facebook.react.bridge.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "responsibility", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ZendeskMessagingModule.kt */
final class ZendeskMessagingModule$handleNotification$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ Promise $promise;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ZendeskMessagingModule$handleNotification$1(Promise promise) {
        super(1);
        this.$promise = promise;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "responsibility");
        this.$promise.resolve(str);
    }
}
