package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface;

public class RNSVGLinearGradientManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGLinearGradientManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGLinearGradientManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r4, java.lang.String r5, java.lang.Object r6) {
        /*
            r3 = this;
            r5.hashCode()
            int r0 = r5.hashCode()
            r1 = 0
            r2 = -1
            switch(r0) {
                case -1932235233: goto L_0x00f5;
                case -1267206133: goto L_0x00ea;
                case -1081239615: goto L_0x00df;
                case -933864895: goto L_0x00d4;
                case -933857362: goto L_0x00c9;
                case -293492298: goto L_0x00be;
                case 3769: goto L_0x00b3;
                case 3770: goto L_0x00a8;
                case 3800: goto L_0x009a;
                case 3801: goto L_0x008c;
                case 3344108: goto L_0x007e;
                case 3373707: goto L_0x0070;
                case 89650992: goto L_0x0062;
                case 217109576: goto L_0x0054;
                case 917656469: goto L_0x0046;
                case 917735020: goto L_0x0038;
                case 1671764162: goto L_0x002a;
                case 1822665244: goto L_0x001c;
                case 1847674614: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x00ff
        L_0x000e:
            java.lang.String r0 = "responsible"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0018
            goto L_0x00ff
        L_0x0018:
            r2 = 18
            goto L_0x00ff
        L_0x001c:
            java.lang.String r0 = "gradientTransform"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0026
            goto L_0x00ff
        L_0x0026:
            r2 = 17
            goto L_0x00ff
        L_0x002a:
            java.lang.String r0 = "display"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0034
            goto L_0x00ff
        L_0x0034:
            r2 = 16
            goto L_0x00ff
        L_0x0038:
            java.lang.String r0 = "clipRule"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0042
            goto L_0x00ff
        L_0x0042:
            r2 = 15
            goto L_0x00ff
        L_0x0046:
            java.lang.String r0 = "clipPath"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0050
            goto L_0x00ff
        L_0x0050:
            r2 = 14
            goto L_0x00ff
        L_0x0054:
            java.lang.String r0 = "markerStart"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x005e
            goto L_0x00ff
        L_0x005e:
            r2 = 13
            goto L_0x00ff
        L_0x0062:
            java.lang.String r0 = "gradient"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x006c
            goto L_0x00ff
        L_0x006c:
            r2 = 12
            goto L_0x00ff
        L_0x0070:
            java.lang.String r0 = "name"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x007a
            goto L_0x00ff
        L_0x007a:
            r2 = 11
            goto L_0x00ff
        L_0x007e:
            java.lang.String r0 = "mask"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0088
            goto L_0x00ff
        L_0x0088:
            r2 = 10
            goto L_0x00ff
        L_0x008c:
            java.lang.String r0 = "y2"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0096
            goto L_0x00ff
        L_0x0096:
            r2 = 9
            goto L_0x00ff
        L_0x009a:
            java.lang.String r0 = "y1"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00a4
            goto L_0x00ff
        L_0x00a4:
            r2 = 8
            goto L_0x00ff
        L_0x00a8:
            java.lang.String r0 = "x2"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00b1
            goto L_0x00ff
        L_0x00b1:
            r2 = 7
            goto L_0x00ff
        L_0x00b3:
            java.lang.String r0 = "x1"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00bc
            goto L_0x00ff
        L_0x00bc:
            r2 = 6
            goto L_0x00ff
        L_0x00be:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00c7
            goto L_0x00ff
        L_0x00c7:
            r2 = 5
            goto L_0x00ff
        L_0x00c9:
            java.lang.String r0 = "markerMid"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00d2
            goto L_0x00ff
        L_0x00d2:
            r2 = 4
            goto L_0x00ff
        L_0x00d4:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x00ff
        L_0x00dd:
            r2 = 3
            goto L_0x00ff
        L_0x00df:
            java.lang.String r0 = "matrix"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00e8
            goto L_0x00ff
        L_0x00e8:
            r2 = 2
            goto L_0x00ff
        L_0x00ea:
            java.lang.String r0 = "opacity"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00f3
            goto L_0x00ff
        L_0x00f3:
            r2 = 1
            goto L_0x00ff
        L_0x00f5:
            java.lang.String r0 = "gradientUnits"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00fe
            goto L_0x00ff
        L_0x00fe:
            r2 = r1
        L_0x00ff:
            r0 = 0
            switch(r2) {
                case 0: goto L_0x0278;
                case 1: goto L_0x0267;
                case 2: goto L_0x025d;
                case 3: goto L_0x024f;
                case 4: goto L_0x0241;
                case 5: goto L_0x0233;
                case 6: goto L_0x020b;
                case 7: goto L_0x01e1;
                case 8: goto L_0x01b7;
                case 9: goto L_0x018d;
                case 10: goto L_0x017e;
                case 11: goto L_0x016f;
                case 12: goto L_0x0164;
                case 13: goto L_0x0155;
                case 14: goto L_0x0146;
                case 15: goto L_0x0134;
                case 16: goto L_0x0125;
                case 17: goto L_0x011a;
                case 18: goto L_0x0108;
                default: goto L_0x0103;
            }
        L_0x0103:
            super.setProperty(r4, r5, r6)
            goto L_0x0288
        L_0x0108:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            if (r6 != 0) goto L_0x010f
            goto L_0x0115
        L_0x010f:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x0115:
            r5.setResponsible(r4, r1)
            goto L_0x0288
        L_0x011a:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            com.facebook.react.bridge.ReadableArray r6 = (com.facebook.react.bridge.ReadableArray) r6
            r5.setGradientTransform(r4, r6)
            goto L_0x0288
        L_0x0125:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            if (r6 != 0) goto L_0x012c
            goto L_0x012f
        L_0x012c:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x012f:
            r5.setDisplay(r4, r0)
            goto L_0x0288
        L_0x0134:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            if (r6 != 0) goto L_0x013b
            goto L_0x0141
        L_0x013b:
            java.lang.Double r6 = (java.lang.Double) r6
            int r1 = r6.intValue()
        L_0x0141:
            r5.setClipRule(r4, r1)
            goto L_0x0288
        L_0x0146:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            if (r6 != 0) goto L_0x014d
            goto L_0x0150
        L_0x014d:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x0150:
            r5.setClipPath(r4, r0)
            goto L_0x0288
        L_0x0155:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            if (r6 != 0) goto L_0x015c
            goto L_0x015f
        L_0x015c:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x015f:
            r5.setMarkerStart(r4, r0)
            goto L_0x0288
        L_0x0164:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            com.facebook.react.bridge.ReadableArray r6 = (com.facebook.react.bridge.ReadableArray) r6
            r5.setGradient(r4, r6)
            goto L_0x0288
        L_0x016f:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            if (r6 != 0) goto L_0x0176
            goto L_0x0179
        L_0x0176:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x0179:
            r5.setName(r4, r0)
            goto L_0x0288
        L_0x017e:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            if (r6 != 0) goto L_0x0185
            goto L_0x0188
        L_0x0185:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x0188:
            r5.setMask(r4, r0)
            goto L_0x0288
        L_0x018d:
            boolean r5 = r6 instanceof java.lang.String
            if (r5 == 0) goto L_0x019c
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            java.lang.String r6 = (java.lang.String) r6
            r5.setY2(r4, (java.lang.String) r6)
            goto L_0x0288
        L_0x019c:
            boolean r5 = r6 instanceof java.lang.Double
            if (r5 == 0) goto L_0x01ab
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            java.lang.Double r6 = (java.lang.Double) r6
            r5.setY2(r4, (java.lang.Double) r6)
            goto L_0x0288
        L_0x01ab:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            r6 = r0
            java.lang.Double r6 = (java.lang.Double) r6
            r5.setY2(r4, (java.lang.Double) r0)
            goto L_0x0288
        L_0x01b7:
            boolean r5 = r6 instanceof java.lang.String
            if (r5 == 0) goto L_0x01c6
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            java.lang.String r6 = (java.lang.String) r6
            r5.setY1(r4, (java.lang.String) r6)
            goto L_0x0288
        L_0x01c6:
            boolean r5 = r6 instanceof java.lang.Double
            if (r5 == 0) goto L_0x01d5
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            java.lang.Double r6 = (java.lang.Double) r6
            r5.setY1(r4, (java.lang.Double) r6)
            goto L_0x0288
        L_0x01d5:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            r6 = r0
            java.lang.Double r6 = (java.lang.Double) r6
            r5.setY1(r4, (java.lang.Double) r0)
            goto L_0x0288
        L_0x01e1:
            boolean r5 = r6 instanceof java.lang.String
            if (r5 == 0) goto L_0x01f0
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            java.lang.String r6 = (java.lang.String) r6
            r5.setX2(r4, (java.lang.String) r6)
            goto L_0x0288
        L_0x01f0:
            boolean r5 = r6 instanceof java.lang.Double
            if (r5 == 0) goto L_0x01ff
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            java.lang.Double r6 = (java.lang.Double) r6
            r5.setX2(r4, (java.lang.Double) r6)
            goto L_0x0288
        L_0x01ff:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            r6 = r0
            java.lang.Double r6 = (java.lang.Double) r6
            r5.setX2(r4, (java.lang.Double) r0)
            goto L_0x0288
        L_0x020b:
            boolean r5 = r6 instanceof java.lang.String
            if (r5 == 0) goto L_0x021a
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            java.lang.String r6 = (java.lang.String) r6
            r5.setX1(r4, (java.lang.String) r6)
            goto L_0x0288
        L_0x021a:
            boolean r5 = r6 instanceof java.lang.Double
            if (r5 == 0) goto L_0x0228
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            java.lang.Double r6 = (java.lang.Double) r6
            r5.setX1(r4, (java.lang.Double) r6)
            goto L_0x0288
        L_0x0228:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            r6 = r0
            java.lang.Double r6 = (java.lang.Double) r6
            r5.setX1(r4, (java.lang.Double) r0)
            goto L_0x0288
        L_0x0233:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            if (r6 != 0) goto L_0x023a
            goto L_0x023d
        L_0x023a:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x023d:
            r5.setPointerEvents(r4, r0)
            goto L_0x0288
        L_0x0241:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            if (r6 != 0) goto L_0x0248
            goto L_0x024b
        L_0x0248:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x024b:
            r5.setMarkerMid(r4, r0)
            goto L_0x0288
        L_0x024f:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            if (r6 != 0) goto L_0x0256
            goto L_0x0259
        L_0x0256:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x0259:
            r5.setMarkerEnd(r4, r0)
            goto L_0x0288
        L_0x025d:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            com.facebook.react.bridge.ReadableArray r6 = (com.facebook.react.bridge.ReadableArray) r6
            r5.setMatrix(r4, r6)
            goto L_0x0288
        L_0x0267:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            if (r6 != 0) goto L_0x026e
            r6 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0274
        L_0x026e:
            java.lang.Double r6 = (java.lang.Double) r6
            float r6 = r6.floatValue()
        L_0x0274:
            r5.setOpacity(r4, r6)
            goto L_0x0288
        L_0x0278:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface) r5
            if (r6 != 0) goto L_0x027f
            goto L_0x0285
        L_0x027f:
            java.lang.Double r6 = (java.lang.Double) r6
            int r1 = r6.intValue()
        L_0x0285:
            r5.setGradientUnits(r4, r1)
        L_0x0288:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGLinearGradientManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
