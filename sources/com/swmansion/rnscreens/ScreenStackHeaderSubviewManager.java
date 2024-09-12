package com.swmansion.rnscreens;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenStackHeaderSubviewManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenStackHeaderSubviewManagerInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0014J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0017R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackHeaderSubviewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/ScreenStackHeaderSubview;", "Lcom/facebook/react/viewmanagers/RNSScreenStackHeaderSubviewManagerInterface;", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getDelegate", "getName", "", "setType", "", "view", "type", "Companion", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ReactModule(name = "RNSScreenStackHeaderSubview")
/* compiled from: ScreenStackHeaderSubviewManager.kt */
public final class ScreenStackHeaderSubviewManager extends ViewGroupManager<ScreenStackHeaderSubview> implements RNSScreenStackHeaderSubviewManagerInterface<ScreenStackHeaderSubview> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNSScreenStackHeaderSubview";
    private final ViewManagerDelegate<ScreenStackHeaderSubview> delegate = new RNSScreenStackHeaderSubviewManagerDelegate(this);

    public String getName() {
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    public ScreenStackHeaderSubview createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        return new ScreenStackHeaderSubview(themedReactContext);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        r3.setType(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        return;
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "type")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setType(com.swmansion.rnscreens.ScreenStackHeaderSubview r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            if (r4 == 0) goto L_0x0049
            int r0 = r4.hashCode()
            switch(r0) {
                case -1364013995: goto L_0x003b;
                case 3015911: goto L_0x0030;
                case 3317767: goto L_0x0025;
                case 108511772: goto L_0x001a;
                case 1778179403: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0049
        L_0x000f:
            java.lang.String r0 = "searchBar"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0049
            com.swmansion.rnscreens.ScreenStackHeaderSubview$Type r4 = com.swmansion.rnscreens.ScreenStackHeaderSubview.Type.SEARCH_BAR
            goto L_0x0045
        L_0x001a:
            java.lang.String r0 = "right"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0049
            com.swmansion.rnscreens.ScreenStackHeaderSubview$Type r4 = com.swmansion.rnscreens.ScreenStackHeaderSubview.Type.RIGHT
            goto L_0x0045
        L_0x0025:
            java.lang.String r0 = "left"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0049
            com.swmansion.rnscreens.ScreenStackHeaderSubview$Type r4 = com.swmansion.rnscreens.ScreenStackHeaderSubview.Type.LEFT
            goto L_0x0045
        L_0x0030:
            java.lang.String r0 = "back"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0049
            com.swmansion.rnscreens.ScreenStackHeaderSubview$Type r4 = com.swmansion.rnscreens.ScreenStackHeaderSubview.Type.BACK
            goto L_0x0045
        L_0x003b:
            java.lang.String r0 = "center"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0049
            com.swmansion.rnscreens.ScreenStackHeaderSubview$Type r4 = com.swmansion.rnscreens.ScreenStackHeaderSubview.Type.CENTER
        L_0x0045:
            r3.setType(r4)
            return
        L_0x0049:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r3 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown type "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r4 = r0.append(r4)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenStackHeaderSubviewManager.setType(com.swmansion.rnscreens.ScreenStackHeaderSubview, java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public ViewManagerDelegate<ScreenStackHeaderSubview> getDelegate() {
        return this.delegate;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackHeaderSubviewManager$Companion;", "", "()V", "REACT_CLASS", "", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ScreenStackHeaderSubviewManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
