package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerInterface;

public abstract class BaseViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T>> implements ViewManagerDelegate<T> {
    protected final U mViewManager;

    public void receiveCommand(T t, String str, ReadableArray readableArray) {
    }

    public BaseViewManagerDelegate(U u) {
        this.mViewManager = u;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r4 = this;
            r6.hashCode()
            int r0 = r6.hashCode()
            r1 = 0
            r2 = -1
            switch(r0) {
                case -1721943862: goto L_0x0182;
                case -1721943861: goto L_0x0177;
                case -1589741021: goto L_0x016c;
                case -1267206133: goto L_0x0161;
                case -1228066334: goto L_0x0156;
                case -908189618: goto L_0x014b;
                case -908189617: goto L_0x0140;
                case -877170387: goto L_0x0135;
                case -731417480: goto L_0x0126;
                case -101663499: goto L_0x0118;
                case -101359900: goto L_0x010a;
                case -80891667: goto L_0x00fc;
                case -40300674: goto L_0x00ee;
                case -4379043: goto L_0x00e0;
                case 36255470: goto L_0x00d2;
                case 333432965: goto L_0x00c4;
                case 581268560: goto L_0x00b6;
                case 588239831: goto L_0x00a8;
                case 746986311: goto L_0x009a;
                case 1052666732: goto L_0x008c;
                case 1146842694: goto L_0x007e;
                case 1153872867: goto L_0x0070;
                case 1287124693: goto L_0x0062;
                case 1349188574: goto L_0x0054;
                case 1505602511: goto L_0x0046;
                case 1761903244: goto L_0x0038;
                case 1865277756: goto L_0x002a;
                case 1993034687: goto L_0x001c;
                case 2045685618: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x018c
        L_0x000e:
            java.lang.String r0 = "nativeID"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0018
            goto L_0x018c
        L_0x0018:
            r2 = 28
            goto L_0x018c
        L_0x001c:
            java.lang.String r0 = "accessibilityCollectionItem"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0026
            goto L_0x018c
        L_0x0026:
            r2 = 27
            goto L_0x018c
        L_0x002a:
            java.lang.String r0 = "accessibilityLabelledBy"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0034
            goto L_0x018c
        L_0x0034:
            r2 = 26
            goto L_0x018c
        L_0x0038:
            java.lang.String r0 = "accessibilityCollection"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0042
            goto L_0x018c
        L_0x0042:
            r2 = 25
            goto L_0x018c
        L_0x0046:
            java.lang.String r0 = "accessibilityActions"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0050
            goto L_0x018c
        L_0x0050:
            r2 = 24
            goto L_0x018c
        L_0x0054:
            java.lang.String r0 = "borderRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x005e
            goto L_0x018c
        L_0x005e:
            r2 = 23
            goto L_0x018c
        L_0x0062:
            java.lang.String r0 = "backgroundColor"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x006c
            goto L_0x018c
        L_0x006c:
            r2 = 22
            goto L_0x018c
        L_0x0070:
            java.lang.String r0 = "accessibilityState"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x007a
            goto L_0x018c
        L_0x007a:
            r2 = 21
            goto L_0x018c
        L_0x007e:
            java.lang.String r0 = "accessibilityLabel"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0088
            goto L_0x018c
        L_0x0088:
            r2 = 20
            goto L_0x018c
        L_0x008c:
            java.lang.String r0 = "transform"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0096
            goto L_0x018c
        L_0x0096:
            r2 = 19
            goto L_0x018c
        L_0x009a:
            java.lang.String r0 = "importantForAccessibility"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00a4
            goto L_0x018c
        L_0x00a4:
            r2 = 18
            goto L_0x018c
        L_0x00a8:
            java.lang.String r0 = "borderBottomRightRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00b2
            goto L_0x018c
        L_0x00b2:
            r2 = 17
            goto L_0x018c
        L_0x00b6:
            java.lang.String r0 = "borderBottomLeftRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00c0
            goto L_0x018c
        L_0x00c0:
            r2 = 16
            goto L_0x018c
        L_0x00c4:
            java.lang.String r0 = "borderTopRightRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00ce
            goto L_0x018c
        L_0x00ce:
            r2 = 15
            goto L_0x018c
        L_0x00d2:
            java.lang.String r0 = "accessibilityLiveRegion"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00dc
            goto L_0x018c
        L_0x00dc:
            r2 = 14
            goto L_0x018c
        L_0x00e0:
            java.lang.String r0 = "elevation"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00ea
            goto L_0x018c
        L_0x00ea:
            r2 = 13
            goto L_0x018c
        L_0x00ee:
            java.lang.String r0 = "rotation"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00f8
            goto L_0x018c
        L_0x00f8:
            r2 = 12
            goto L_0x018c
        L_0x00fc:
            java.lang.String r0 = "renderToHardwareTextureAndroid"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0106
            goto L_0x018c
        L_0x0106:
            r2 = 11
            goto L_0x018c
        L_0x010a:
            java.lang.String r0 = "accessibilityRole"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0114
            goto L_0x018c
        L_0x0114:
            r2 = 10
            goto L_0x018c
        L_0x0118:
            java.lang.String r0 = "accessibilityHint"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0122
            goto L_0x018c
        L_0x0122:
            r2 = 9
            goto L_0x018c
        L_0x0126:
            java.lang.String r0 = "zIndex"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0131
            goto L_0x018c
        L_0x0131:
            r2 = 8
            goto L_0x018c
        L_0x0135:
            java.lang.String r0 = "testID"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x013e
            goto L_0x018c
        L_0x013e:
            r2 = 7
            goto L_0x018c
        L_0x0140:
            java.lang.String r0 = "scaleY"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0149
            goto L_0x018c
        L_0x0149:
            r2 = 6
            goto L_0x018c
        L_0x014b:
            java.lang.String r0 = "scaleX"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0154
            goto L_0x018c
        L_0x0154:
            r2 = 5
            goto L_0x018c
        L_0x0156:
            java.lang.String r0 = "borderTopLeftRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x015f
            goto L_0x018c
        L_0x015f:
            r2 = 4
            goto L_0x018c
        L_0x0161:
            java.lang.String r0 = "opacity"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x016a
            goto L_0x018c
        L_0x016a:
            r2 = 3
            goto L_0x018c
        L_0x016c:
            java.lang.String r0 = "shadowColor"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0175
            goto L_0x018c
        L_0x0175:
            r2 = 2
            goto L_0x018c
        L_0x0177:
            java.lang.String r0 = "translateY"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0180
            goto L_0x018c
        L_0x0180:
            r2 = 1
            goto L_0x018c
        L_0x0182:
            java.lang.String r0 = "translateX"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x018b
            goto L_0x018c
        L_0x018b:
            r2 = r1
        L_0x018c:
            r6 = 1065353216(0x3f800000, float:1.0)
            r0 = 0
            r3 = 2143289344(0x7fc00000, float:NaN)
            switch(r2) {
                case 0: goto L_0x0304;
                case 1: goto L_0x02f5;
                case 2: goto L_0x02e0;
                case 3: goto L_0x02d1;
                case 4: goto L_0x02c2;
                case 5: goto L_0x02b3;
                case 6: goto L_0x02a4;
                case 7: goto L_0x029b;
                case 8: goto L_0x028b;
                case 9: goto L_0x0282;
                case 10: goto L_0x0279;
                case 11: goto L_0x0269;
                case 12: goto L_0x0259;
                case 13: goto L_0x0249;
                case 14: goto L_0x0240;
                case 15: goto L_0x0230;
                case 16: goto L_0x0220;
                case 17: goto L_0x0210;
                case 18: goto L_0x0207;
                case 19: goto L_0x01fe;
                case 20: goto L_0x01f5;
                case 21: goto L_0x01ec;
                case 22: goto L_0x01d6;
                case 23: goto L_0x01c6;
                case 24: goto L_0x01bd;
                case 25: goto L_0x01b4;
                case 26: goto L_0x01a8;
                case 27: goto L_0x019f;
                case 28: goto L_0x0196;
                default: goto L_0x0194;
            }
        L_0x0194:
            goto L_0x0312
        L_0x0196:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setNativeId(r5, r7)
            goto L_0x0312
        L_0x019f:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableMap r7 = (com.facebook.react.bridge.ReadableMap) r7
            r6.setAccessibilityCollectionItem(r5, r7)
            goto L_0x0312
        L_0x01a8:
            com.facebook.react.bridge.DynamicFromObject r6 = new com.facebook.react.bridge.DynamicFromObject
            r6.<init>(r7)
            U r7 = r4.mViewManager
            r7.setAccessibilityLabelledBy(r5, r6)
            goto L_0x0312
        L_0x01b4:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableMap r7 = (com.facebook.react.bridge.ReadableMap) r7
            r6.setAccessibilityCollection(r5, r7)
            goto L_0x0312
        L_0x01bd:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setAccessibilityActions(r5, r7)
            goto L_0x0312
        L_0x01c6:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01cb
            goto L_0x01d1
        L_0x01cb:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x01d1:
            r6.setBorderRadius(r5, r3)
            goto L_0x0312
        L_0x01d6:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01db
            goto L_0x01e7
        L_0x01db:
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            int r1 = r7.intValue()
        L_0x01e7:
            r6.setBackgroundColor(r5, r1)
            goto L_0x0312
        L_0x01ec:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableMap r7 = (com.facebook.react.bridge.ReadableMap) r7
            r6.setViewState(r5, r7)
            goto L_0x0312
        L_0x01f5:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityLabel(r5, r7)
            goto L_0x0312
        L_0x01fe:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setTransform(r5, r7)
            goto L_0x0312
        L_0x0207:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setImportantForAccessibility(r5, r7)
            goto L_0x0312
        L_0x0210:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0215
            goto L_0x021b
        L_0x0215:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x021b:
            r6.setBorderBottomRightRadius(r5, r3)
            goto L_0x0312
        L_0x0220:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0225
            goto L_0x022b
        L_0x0225:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x022b:
            r6.setBorderBottomLeftRadius(r5, r3)
            goto L_0x0312
        L_0x0230:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0235
            goto L_0x023b
        L_0x0235:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x023b:
            r6.setBorderTopRightRadius(r5, r3)
            goto L_0x0312
        L_0x0240:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityLiveRegion(r5, r7)
            goto L_0x0312
        L_0x0249:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x024e
            goto L_0x0254
        L_0x024e:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x0254:
            r6.setElevation(r5, r0)
            goto L_0x0312
        L_0x0259:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x025e
            goto L_0x0264
        L_0x025e:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x0264:
            r6.setRotation(r5, r0)
            goto L_0x0312
        L_0x0269:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x026e
            goto L_0x0274
        L_0x026e:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x0274:
            r6.setRenderToHardwareTexture(r5, r1)
            goto L_0x0312
        L_0x0279:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityRole(r5, r7)
            goto L_0x0312
        L_0x0282:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityHint(r5, r7)
            goto L_0x0312
        L_0x028b:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0290
            goto L_0x0296
        L_0x0290:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x0296:
            r6.setZIndex(r5, r0)
            goto L_0x0312
        L_0x029b:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setTestId(r5, r7)
            goto L_0x0312
        L_0x02a4:
            U r0 = r4.mViewManager
            if (r7 != 0) goto L_0x02a9
            goto L_0x02af
        L_0x02a9:
            java.lang.Double r7 = (java.lang.Double) r7
            float r6 = r7.floatValue()
        L_0x02af:
            r0.setScaleY(r5, r6)
            goto L_0x0312
        L_0x02b3:
            U r0 = r4.mViewManager
            if (r7 != 0) goto L_0x02b8
            goto L_0x02be
        L_0x02b8:
            java.lang.Double r7 = (java.lang.Double) r7
            float r6 = r7.floatValue()
        L_0x02be:
            r0.setScaleX(r5, r6)
            goto L_0x0312
        L_0x02c2:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x02c7
            goto L_0x02cd
        L_0x02c7:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x02cd:
            r6.setBorderTopLeftRadius(r5, r3)
            goto L_0x0312
        L_0x02d1:
            U r0 = r4.mViewManager
            if (r7 != 0) goto L_0x02d6
            goto L_0x02dc
        L_0x02d6:
            java.lang.Double r7 = (java.lang.Double) r7
            float r6 = r7.floatValue()
        L_0x02dc:
            r0.setOpacity(r5, r6)
            goto L_0x0312
        L_0x02e0:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x02e5
            goto L_0x02f1
        L_0x02e5:
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            int r1 = r7.intValue()
        L_0x02f1:
            r6.setShadowColor(r5, r1)
            goto L_0x0312
        L_0x02f5:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x02fa
            goto L_0x0300
        L_0x02fa:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x0300:
            r6.setTranslateY(r5, r0)
            goto L_0x0312
        L_0x0304:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0309
            goto L_0x030f
        L_0x0309:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x030f:
            r6.setTranslateX(r5, r0)
        L_0x0312:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
