package com.swmansion.rnscreens;

import android.content.Context;
import androidx.appcompat.widget.Toolbar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/swmansion/rnscreens/CustomToolbar;", "Landroidx/appcompat/widget/Toolbar;", "context", "Landroid/content/Context;", "config", "Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "(Landroid/content/Context;Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;)V", "getConfig", "()Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CustomToolbar.kt */
public class CustomToolbar extends Toolbar {
    private final ScreenStackHeaderConfig config;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomToolbar(Context context, ScreenStackHeaderConfig screenStackHeaderConfig) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        this.config = screenStackHeaderConfig;
    }

    public final ScreenStackHeaderConfig getConfig() {
        return this.config;
    }
}
