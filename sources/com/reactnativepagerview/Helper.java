package com.reactnativepagerview;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.ReactContext;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/reactnativepagerview/Helper;", "", "()V", "Companion", "react-native-pager-view_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Helper.kt */
public final class Helper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/reactnativepagerview/Helper$Companion;", "", "()V", "getReactContext", "Lcom/facebook/react/bridge/ReactContext;", "view", "Landroid/view/View;", "react-native-pager-view_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Helper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReactContext getReactContext(View view) {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.getContext()");
            if (!(context instanceof ReactContext) && (context instanceof ContextWrapper)) {
                context = ((ContextWrapper) context).getBaseContext();
                Intrinsics.checkNotNullExpressionValue(context, "context.baseContext");
            }
            if (context instanceof ReactContext) {
                return (ReactContext) context;
            }
            return null;
        }
    }
}
