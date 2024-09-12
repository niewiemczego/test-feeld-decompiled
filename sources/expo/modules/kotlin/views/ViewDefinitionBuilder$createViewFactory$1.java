package expo.modules.kotlin.views;

import android.content.Context;
import android.view.View;
import expo.modules.kotlin.AppContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Landroid/view/View;", "T", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ViewDefinitionBuilder.kt */
final class ViewDefinitionBuilder$createViewFactory$1 extends Lambda implements Function2<Context, AppContext, View> {
    final /* synthetic */ ViewDefinitionBuilder<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewDefinitionBuilder$createViewFactory$1(ViewDefinitionBuilder<T> viewDefinitionBuilder) {
        super(2);
        this.this$0 = viewDefinitionBuilder;
    }

    public final View invoke(Context context, AppContext appContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        KFunction access$getPrimaryConstructor = this.this$0.getPrimaryConstructor();
        ViewDefinitionBuilder<T> viewDefinitionBuilder = this.this$0;
        if (access$getPrimaryConstructor != null) {
            List<KParameter> parameters = access$getPrimaryConstructor.getParameters();
            if (!parameters.isEmpty()) {
                if (!Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Context.class), (Object) ((KParameter) CollectionsKt.first(parameters)).getType().getClassifier())) {
                    throw new IllegalStateException("The type of the first constructor argument has to be `android.content.Context`.");
                } else if (parameters.size() == 1) {
                    try {
                        return (View) access$getPrimaryConstructor.call(context);
                    } catch (Throwable th) {
                        return this.this$0.handleFailureDuringViewCreation(context, appContext, th);
                    }
                } else {
                    if (!Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(AppContext.class), (Object) parameters.get(1).getType().getClassifier())) {
                        throw new IllegalStateException("The type of the second constructor argument has to be `expo.modules.kotlin.AppContext`.");
                    } else if (parameters.size() == 2) {
                        try {
                            return (View) access$getPrimaryConstructor.call(context, appContext);
                        } catch (Throwable th2) {
                            return this.this$0.handleFailureDuringViewCreation(context, appContext, th2);
                        }
                    } else {
                        throw new IllegalStateException("Android view has more constructor arguments than expected.");
                    }
                }
            } else {
                throw new IllegalStateException("Android view has to have a constructor with at least one argument.");
            }
        } else {
            throw new IllegalArgumentException((viewDefinitionBuilder.getViewType() + " doesn't have a primary constructor").toString());
        }
    }
}
