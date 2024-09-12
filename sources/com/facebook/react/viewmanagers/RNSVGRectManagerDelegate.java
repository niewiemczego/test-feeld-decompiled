package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGRectManagerInterface;

public class RNSVGRectManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGRectManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGRectManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r7, java.lang.String r8, java.lang.Object r9) {
        /*
            r6 = this;
            r8.hashCode()
            int r0 = r8.hashCode()
            r1 = 1
            r2 = 0
            r3 = -1
            switch(r0) {
                case -1267206133: goto L_0x019e;
                case -1221029593: goto L_0x0193;
                case -1081239615: goto L_0x0188;
                case -993894751: goto L_0x017d;
                case -933864895: goto L_0x0172;
                case -933857362: goto L_0x0167;
                case -891980232: goto L_0x015c;
                case -729118945: goto L_0x0151;
                case -416535885: goto L_0x0143;
                case -293492298: goto L_0x0135;
                case -53677816: goto L_0x0127;
                case -44578051: goto L_0x0119;
                case 120: goto L_0x010b;
                case 121: goto L_0x00fd;
                case 3654: goto L_0x00ef;
                case 3655: goto L_0x00e1;
                case 3143043: goto L_0x00d3;
                case 3344108: goto L_0x00c5;
                case 3373707: goto L_0x00b7;
                case 78845486: goto L_0x00a9;
                case 104482996: goto L_0x009b;
                case 113126854: goto L_0x008d;
                case 217109576: goto L_0x007f;
                case 401643183: goto L_0x0071;
                case 917656469: goto L_0x0063;
                case 917735020: goto L_0x0055;
                case 1027575302: goto L_0x0047;
                case 1671764162: goto L_0x0039;
                case 1790285174: goto L_0x002b;
                case 1847674614: goto L_0x001d;
                case 1924065902: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x01a8
        L_0x000f:
            java.lang.String r0 = "strokeWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x01a8
        L_0x0019:
            r3 = 30
            goto L_0x01a8
        L_0x001d:
            java.lang.String r0 = "responsible"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x01a8
        L_0x0027:
            r3 = 29
            goto L_0x01a8
        L_0x002b:
            java.lang.String r0 = "strokeLinejoin"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x01a8
        L_0x0035:
            r3 = 28
            goto L_0x01a8
        L_0x0039:
            java.lang.String r0 = "display"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x01a8
        L_0x0043:
            r3 = 27
            goto L_0x01a8
        L_0x0047:
            java.lang.String r0 = "strokeLinecap"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x01a8
        L_0x0051:
            r3 = 26
            goto L_0x01a8
        L_0x0055:
            java.lang.String r0 = "clipRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x01a8
        L_0x005f:
            r3 = 25
            goto L_0x01a8
        L_0x0063:
            java.lang.String r0 = "clipPath"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x006d
            goto L_0x01a8
        L_0x006d:
            r3 = 24
            goto L_0x01a8
        L_0x0071:
            java.lang.String r0 = "strokeDasharray"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x01a8
        L_0x007b:
            r3 = 23
            goto L_0x01a8
        L_0x007f:
            java.lang.String r0 = "markerStart"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0089
            goto L_0x01a8
        L_0x0089:
            r3 = 22
            goto L_0x01a8
        L_0x008d:
            java.lang.String r0 = "width"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x01a8
        L_0x0097:
            r3 = 21
            goto L_0x01a8
        L_0x009b:
            java.lang.String r0 = "vectorEffect"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x01a8
        L_0x00a5:
            r3 = 20
            goto L_0x01a8
        L_0x00a9:
            java.lang.String r0 = "strokeMiterlimit"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x01a8
        L_0x00b3:
            r3 = 19
            goto L_0x01a8
        L_0x00b7:
            java.lang.String r0 = "name"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x01a8
        L_0x00c1:
            r3 = 18
            goto L_0x01a8
        L_0x00c5:
            java.lang.String r0 = "mask"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x01a8
        L_0x00cf:
            r3 = 17
            goto L_0x01a8
        L_0x00d3:
            java.lang.String r0 = "fill"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x01a8
        L_0x00dd:
            r3 = 16
            goto L_0x01a8
        L_0x00e1:
            java.lang.String r0 = "ry"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x01a8
        L_0x00eb:
            r3 = 15
            goto L_0x01a8
        L_0x00ef:
            java.lang.String r0 = "rx"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x01a8
        L_0x00f9:
            r3 = 14
            goto L_0x01a8
        L_0x00fd:
            java.lang.String r0 = "y"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x01a8
        L_0x0107:
            r3 = 13
            goto L_0x01a8
        L_0x010b:
            java.lang.String r0 = "x"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0115
            goto L_0x01a8
        L_0x0115:
            r3 = 12
            goto L_0x01a8
        L_0x0119:
            java.lang.String r0 = "strokeDashoffset"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0123
            goto L_0x01a8
        L_0x0123:
            r3 = 11
            goto L_0x01a8
        L_0x0127:
            java.lang.String r0 = "fillOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0131
            goto L_0x01a8
        L_0x0131:
            r3 = 10
            goto L_0x01a8
        L_0x0135:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x013f
            goto L_0x01a8
        L_0x013f:
            r3 = 9
            goto L_0x01a8
        L_0x0143:
            java.lang.String r0 = "strokeOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x014d
            goto L_0x01a8
        L_0x014d:
            r3 = 8
            goto L_0x01a8
        L_0x0151:
            java.lang.String r0 = "fillRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x015a
            goto L_0x01a8
        L_0x015a:
            r3 = 7
            goto L_0x01a8
        L_0x015c:
            java.lang.String r0 = "stroke"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0165
            goto L_0x01a8
        L_0x0165:
            r3 = 6
            goto L_0x01a8
        L_0x0167:
            java.lang.String r0 = "markerMid"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0170
            goto L_0x01a8
        L_0x0170:
            r3 = 5
            goto L_0x01a8
        L_0x0172:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x017b
            goto L_0x01a8
        L_0x017b:
            r3 = 4
            goto L_0x01a8
        L_0x017d:
            java.lang.String r0 = "propList"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0186
            goto L_0x01a8
        L_0x0186:
            r3 = 3
            goto L_0x01a8
        L_0x0188:
            java.lang.String r0 = "matrix"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0191
            goto L_0x01a8
        L_0x0191:
            r3 = 2
            goto L_0x01a8
        L_0x0193:
            java.lang.String r0 = "height"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x019c
            goto L_0x01a8
        L_0x019c:
            r3 = r1
            goto L_0x01a8
        L_0x019e:
            java.lang.String r0 = "opacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01a7
            goto L_0x01a8
        L_0x01a7:
            r3 = r2
        L_0x01a8:
            r0 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            switch(r3) {
                case 0: goto L_0x0435;
                case 1: goto L_0x040e;
                case 2: goto L_0x0404;
                case 3: goto L_0x03fa;
                case 4: goto L_0x03ec;
                case 5: goto L_0x03de;
                case 6: goto L_0x03d3;
                case 7: goto L_0x03c1;
                case 8: goto L_0x03af;
                case 9: goto L_0x03a0;
                case 10: goto L_0x038e;
                case 11: goto L_0x037c;
                case 12: goto L_0x0352;
                case 13: goto L_0x0328;
                case 14: goto L_0x02fe;
                case 15: goto L_0x02d4;
                case 16: goto L_0x02c9;
                case 17: goto L_0x02ba;
                case 18: goto L_0x02ab;
                case 19: goto L_0x0299;
                case 20: goto L_0x0287;
                case 21: goto L_0x025d;
                case 22: goto L_0x024e;
                case 23: goto L_0x0243;
                case 24: goto L_0x0234;
                case 25: goto L_0x0222;
                case 26: goto L_0x0210;
                case 27: goto L_0x0201;
                case 28: goto L_0x01ef;
                case 29: goto L_0x01dd;
                case 30: goto L_0x01b4;
                default: goto L_0x01af;
            }
        L_0x01af:
            super.setProperty(r7, r8, r9)
            goto L_0x0443
        L_0x01b4:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x01c3
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setStrokeWidth(r7, (java.lang.String) r9)
            goto L_0x0443
        L_0x01c3:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x01d2
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setStrokeWidth(r7, (java.lang.Double) r9)
            goto L_0x0443
        L_0x01d2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            java.lang.String r9 = "1"
            r8.setStrokeWidth(r7, (java.lang.String) r9)
            goto L_0x0443
        L_0x01dd:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x01e4
            goto L_0x01ea
        L_0x01e4:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x01ea:
            r8.setResponsible(r7, r2)
            goto L_0x0443
        L_0x01ef:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x01f6
            goto L_0x01fc
        L_0x01f6:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x01fc:
            r8.setStrokeLinejoin(r7, r2)
            goto L_0x0443
        L_0x0201:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x0208
            goto L_0x020b
        L_0x0208:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x020b:
            r8.setDisplay(r7, r5)
            goto L_0x0443
        L_0x0210:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x0217
            goto L_0x021d
        L_0x0217:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x021d:
            r8.setStrokeLinecap(r7, r2)
            goto L_0x0443
        L_0x0222:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x0229
            goto L_0x022f
        L_0x0229:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x022f:
            r8.setClipRule(r7, r2)
            goto L_0x0443
        L_0x0234:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x023b
            goto L_0x023e
        L_0x023b:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x023e:
            r8.setClipPath(r7, r5)
            goto L_0x0443
        L_0x0243:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setStrokeDasharray(r7, r9)
            goto L_0x0443
        L_0x024e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x0255
            goto L_0x0258
        L_0x0255:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0258:
            r8.setMarkerStart(r7, r5)
            goto L_0x0443
        L_0x025d:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x026c
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setWidth(r7, (java.lang.String) r9)
            goto L_0x0443
        L_0x026c:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x027b
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setWidth(r7, (java.lang.Double) r9)
            goto L_0x0443
        L_0x027b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setWidth(r7, (java.lang.Double) r5)
            goto L_0x0443
        L_0x0287:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x028e
            goto L_0x0294
        L_0x028e:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0294:
            r8.setVectorEffect(r7, r2)
            goto L_0x0443
        L_0x0299:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x02a0
            goto L_0x02a6
        L_0x02a0:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x02a6:
            r8.setStrokeMiterlimit(r7, r0)
            goto L_0x0443
        L_0x02ab:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x02b2
            goto L_0x02b5
        L_0x02b2:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02b5:
            r8.setName(r7, r5)
            goto L_0x0443
        L_0x02ba:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x02c1
            goto L_0x02c4
        L_0x02c1:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02c4:
            r8.setMask(r7, r5)
            goto L_0x0443
        L_0x02c9:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFill(r7, r9)
            goto L_0x0443
        L_0x02d4:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x02e3
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setRy(r7, (java.lang.String) r9)
            goto L_0x0443
        L_0x02e3:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x02f2
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setRy(r7, (java.lang.Double) r9)
            goto L_0x0443
        L_0x02f2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setRy(r7, (java.lang.Double) r5)
            goto L_0x0443
        L_0x02fe:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x030d
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setRx(r7, (java.lang.String) r9)
            goto L_0x0443
        L_0x030d:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x031c
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setRx(r7, (java.lang.Double) r9)
            goto L_0x0443
        L_0x031c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setRx(r7, (java.lang.Double) r5)
            goto L_0x0443
        L_0x0328:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x0337
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setY(r7, (java.lang.String) r9)
            goto L_0x0443
        L_0x0337:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x0346
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setY(r7, (java.lang.Double) r9)
            goto L_0x0443
        L_0x0346:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setY(r7, (java.lang.Double) r5)
            goto L_0x0443
        L_0x0352:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x0361
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setX(r7, (java.lang.String) r9)
            goto L_0x0443
        L_0x0361:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x0370
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setX(r7, (java.lang.Double) r9)
            goto L_0x0443
        L_0x0370:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setX(r7, (java.lang.Double) r5)
            goto L_0x0443
        L_0x037c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x0383
            goto L_0x0389
        L_0x0383:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x0389:
            r8.setStrokeDashoffset(r7, r0)
            goto L_0x0443
        L_0x038e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x0395
            goto L_0x039b
        L_0x0395:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x039b:
            r8.setFillOpacity(r7, r4)
            goto L_0x0443
        L_0x03a0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x03a7
            goto L_0x03aa
        L_0x03a7:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x03aa:
            r8.setPointerEvents(r7, r5)
            goto L_0x0443
        L_0x03af:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x03b6
            goto L_0x03bc
        L_0x03b6:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x03bc:
            r8.setStrokeOpacity(r7, r4)
            goto L_0x0443
        L_0x03c1:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x03c8
            goto L_0x03ce
        L_0x03c8:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x03ce:
            r8.setFillRule(r7, r1)
            goto L_0x0443
        L_0x03d3:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setStroke(r7, r9)
            goto L_0x0443
        L_0x03de:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x03e5
            goto L_0x03e8
        L_0x03e5:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x03e8:
            r8.setMarkerMid(r7, r5)
            goto L_0x0443
        L_0x03ec:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x03f3
            goto L_0x03f6
        L_0x03f3:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x03f6:
            r8.setMarkerEnd(r7, r5)
            goto L_0x0443
        L_0x03fa:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setPropList(r7, r9)
            goto L_0x0443
        L_0x0404:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setMatrix(r7, r9)
            goto L_0x0443
        L_0x040e:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x041c
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setHeight(r7, (java.lang.String) r9)
            goto L_0x0443
        L_0x041c:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x042a
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setHeight(r7, (java.lang.Double) r9)
            goto L_0x0443
        L_0x042a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setHeight(r7, (java.lang.Double) r5)
            goto L_0x0443
        L_0x0435:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            if (r9 != 0) goto L_0x043a
            goto L_0x0440
        L_0x043a:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0440:
            r8.setOpacity(r7, r4)
        L_0x0443:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGRectManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
