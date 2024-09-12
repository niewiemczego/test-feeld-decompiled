package expo.modules.kotlin.views;

import android.content.Context;
import android.view.View;
import expo.modules.kotlin.AppContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Landroid/view/View;", "context", "Landroid/content/Context;", "<anonymous parameter 1>", "Lexpo/modules/kotlin/AppContext;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ViewManagerDefinitionBuilder.kt */
final class ViewManagerDefinitionBuilder$build$1 extends Lambda implements Function2<Context, AppContext, View> {
    final /* synthetic */ ViewManagerDefinitionBuilder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewManagerDefinitionBuilder$build$1(ViewManagerDefinitionBuilder viewManagerDefinitionBuilder) {
        super(2);
        this.this$0 = viewManagerDefinitionBuilder;
    }

    public final View invoke(Context context, AppContext appContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "<anonymous parameter 1>");
        Function1<Context, View> viewFactory = this.this$0.getViewFactory();
        if (viewFactory != null) {
            return viewFactory.invoke(context);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
