package expo.modules.kotlin.views;

import android.content.Context;
import android.widget.LinearLayout;
import expo.modules.kotlin.AppContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lexpo/modules/kotlin/views/ExpoView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "getAppContext", "()Lexpo/modules/kotlin/AppContext;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoView.kt */
public abstract class ExpoView extends LinearLayout {
    private final AppContext appContext;

    public final AppContext getAppContext() {
        return this.appContext;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpoView(Context context, AppContext appContext2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext2, "appContext");
        this.appContext = appContext2;
    }
}
