package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface;

public class RNSVGTextPathManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGTextPathManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGTextPathManagerDelegate(U u) {
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
                case -2012158909: goto L_0x0262;
                case -1993948267: goto L_0x0257;
                case -1603134955: goto L_0x024c;
                case -1267206133: goto L_0x0241;
                case -1171891896: goto L_0x0236;
                case -1139902161: goto L_0x022b;
                case -1081239615: goto L_0x0220;
                case -1077554975: goto L_0x0215;
                case -993894751: goto L_0x0207;
                case -933864895: goto L_0x01f9;
                case -933857362: goto L_0x01eb;
                case -925180581: goto L_0x01dd;
                case -891980232: goto L_0x01cf;
                case -734428249: goto L_0x01c1;
                case -729118945: goto L_0x01b3;
                case -416535885: goto L_0x01a5;
                case -293492298: goto L_0x0197;
                case -53677816: goto L_0x0189;
                case -44578051: goto L_0x017b;
                case 120: goto L_0x016d;
                case 121: goto L_0x015f;
                case 3220: goto L_0x0151;
                case 3221: goto L_0x0143;
                case 3143043: goto L_0x0135;
                case 3148879: goto L_0x0127;
                case 3211051: goto L_0x0119;
                case 3344108: goto L_0x010b;
                case 3373707: goto L_0x00fd;
                case 3530071: goto L_0x00ef;
                case 78845486: goto L_0x00e1;
                case 104482996: goto L_0x00d3;
                case 217109576: goto L_0x00c5;
                case 275888445: goto L_0x00b7;
                case 365601008: goto L_0x00a9;
                case 401643183: goto L_0x009b;
                case 778043962: goto L_0x008d;
                case 917656469: goto L_0x007f;
                case 917735020: goto L_0x0071;
                case 1027575302: goto L_0x0063;
                case 1054434908: goto L_0x0055;
                case 1637488243: goto L_0x0047;
                case 1671764162: goto L_0x0039;
                case 1790285174: goto L_0x002b;
                case 1847674614: goto L_0x001d;
                case 1924065902: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x026c
        L_0x000f:
            java.lang.String r0 = "strokeWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x026c
        L_0x0019:
            r3 = 44
            goto L_0x026c
        L_0x001d:
            java.lang.String r0 = "responsible"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x026c
        L_0x0027:
            r3 = 43
            goto L_0x026c
        L_0x002b:
            java.lang.String r0 = "strokeLinejoin"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x026c
        L_0x0035:
            r3 = 42
            goto L_0x026c
        L_0x0039:
            java.lang.String r0 = "display"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x026c
        L_0x0043:
            r3 = 41
            goto L_0x026c
        L_0x0047:
            java.lang.String r0 = "textLength"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x026c
        L_0x0051:
            r3 = 40
            goto L_0x026c
        L_0x0055:
            java.lang.String r0 = "midLine"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x026c
        L_0x005f:
            r3 = 39
            goto L_0x026c
        L_0x0063:
            java.lang.String r0 = "strokeLinecap"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x006d
            goto L_0x026c
        L_0x006d:
            r3 = 38
            goto L_0x026c
        L_0x0071:
            java.lang.String r0 = "clipRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x026c
        L_0x007b:
            r3 = 37
            goto L_0x026c
        L_0x007f:
            java.lang.String r0 = "clipPath"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0089
            goto L_0x026c
        L_0x0089:
            r3 = 36
            goto L_0x026c
        L_0x008d:
            java.lang.String r0 = "inlineSize"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x026c
        L_0x0097:
            r3 = 35
            goto L_0x026c
        L_0x009b:
            java.lang.String r0 = "strokeDasharray"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x026c
        L_0x00a5:
            r3 = 34
            goto L_0x026c
        L_0x00a9:
            java.lang.String r0 = "fontSize"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x026c
        L_0x00b3:
            r3 = 33
            goto L_0x026c
        L_0x00b7:
            java.lang.String r0 = "baselineShift"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x026c
        L_0x00c1:
            r3 = 32
            goto L_0x026c
        L_0x00c5:
            java.lang.String r0 = "markerStart"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x026c
        L_0x00cf:
            r3 = 31
            goto L_0x026c
        L_0x00d3:
            java.lang.String r0 = "vectorEffect"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x026c
        L_0x00dd:
            r3 = 30
            goto L_0x026c
        L_0x00e1:
            java.lang.String r0 = "strokeMiterlimit"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x026c
        L_0x00eb:
            r3 = 29
            goto L_0x026c
        L_0x00ef:
            java.lang.String r0 = "side"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x026c
        L_0x00f9:
            r3 = 28
            goto L_0x026c
        L_0x00fd:
            java.lang.String r0 = "name"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x026c
        L_0x0107:
            r3 = 27
            goto L_0x026c
        L_0x010b:
            java.lang.String r0 = "mask"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0115
            goto L_0x026c
        L_0x0115:
            r3 = 26
            goto L_0x026c
        L_0x0119:
            java.lang.String r0 = "href"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0123
            goto L_0x026c
        L_0x0123:
            r3 = 25
            goto L_0x026c
        L_0x0127:
            java.lang.String r0 = "font"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0131
            goto L_0x026c
        L_0x0131:
            r3 = 24
            goto L_0x026c
        L_0x0135:
            java.lang.String r0 = "fill"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x013f
            goto L_0x026c
        L_0x013f:
            r3 = 23
            goto L_0x026c
        L_0x0143:
            java.lang.String r0 = "dy"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x014d
            goto L_0x026c
        L_0x014d:
            r3 = 22
            goto L_0x026c
        L_0x0151:
            java.lang.String r0 = "dx"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x015b
            goto L_0x026c
        L_0x015b:
            r3 = 21
            goto L_0x026c
        L_0x015f:
            java.lang.String r0 = "y"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0169
            goto L_0x026c
        L_0x0169:
            r3 = 20
            goto L_0x026c
        L_0x016d:
            java.lang.String r0 = "x"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0177
            goto L_0x026c
        L_0x0177:
            r3 = 19
            goto L_0x026c
        L_0x017b:
            java.lang.String r0 = "strokeDashoffset"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0185
            goto L_0x026c
        L_0x0185:
            r3 = 18
            goto L_0x026c
        L_0x0189:
            java.lang.String r0 = "fillOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0193
            goto L_0x026c
        L_0x0193:
            r3 = 17
            goto L_0x026c
        L_0x0197:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01a1
            goto L_0x026c
        L_0x01a1:
            r3 = 16
            goto L_0x026c
        L_0x01a5:
            java.lang.String r0 = "strokeOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01af
            goto L_0x026c
        L_0x01af:
            r3 = 15
            goto L_0x026c
        L_0x01b3:
            java.lang.String r0 = "fillRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01bd
            goto L_0x026c
        L_0x01bd:
            r3 = 14
            goto L_0x026c
        L_0x01c1:
            java.lang.String r0 = "fontWeight"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01cb
            goto L_0x026c
        L_0x01cb:
            r3 = 13
            goto L_0x026c
        L_0x01cf:
            java.lang.String r0 = "stroke"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01d9
            goto L_0x026c
        L_0x01d9:
            r3 = 12
            goto L_0x026c
        L_0x01dd:
            java.lang.String r0 = "rotate"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01e7
            goto L_0x026c
        L_0x01e7:
            r3 = 11
            goto L_0x026c
        L_0x01eb:
            java.lang.String r0 = "markerMid"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01f5
            goto L_0x026c
        L_0x01f5:
            r3 = 10
            goto L_0x026c
        L_0x01f9:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0203
            goto L_0x026c
        L_0x0203:
            r3 = 9
            goto L_0x026c
        L_0x0207:
            java.lang.String r0 = "propList"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0211
            goto L_0x026c
        L_0x0211:
            r3 = 8
            goto L_0x026c
        L_0x0215:
            java.lang.String r0 = "method"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x021e
            goto L_0x026c
        L_0x021e:
            r3 = 7
            goto L_0x026c
        L_0x0220:
            java.lang.String r0 = "matrix"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0229
            goto L_0x026c
        L_0x0229:
            r3 = 6
            goto L_0x026c
        L_0x022b:
            java.lang.String r0 = "verticalAlign"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0234
            goto L_0x026c
        L_0x0234:
            r3 = 5
            goto L_0x026c
        L_0x0236:
            java.lang.String r0 = "alignmentBaseline"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x023f
            goto L_0x026c
        L_0x023f:
            r3 = 4
            goto L_0x026c
        L_0x0241:
            java.lang.String r0 = "opacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x024a
            goto L_0x026c
        L_0x024a:
            r3 = 3
            goto L_0x026c
        L_0x024c:
            java.lang.String r0 = "lengthAdjust"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0255
            goto L_0x026c
        L_0x0255:
            r3 = 2
            goto L_0x026c
        L_0x0257:
            java.lang.String r0 = "startOffset"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0260
            goto L_0x026c
        L_0x0260:
            r3 = r1
            goto L_0x026c
        L_0x0262:
            java.lang.String r0 = "spacing"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x026b
            goto L_0x026c
        L_0x026b:
            r3 = r2
        L_0x026c:
            r0 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            switch(r3) {
                case 0: goto L_0x05b4;
                case 1: goto L_0x058d;
                case 2: goto L_0x057f;
                case 3: goto L_0x0570;
                case 4: goto L_0x0562;
                case 5: goto L_0x0554;
                case 6: goto L_0x0549;
                case 7: goto L_0x053a;
                case 8: goto L_0x052f;
                case 9: goto L_0x0520;
                case 10: goto L_0x0511;
                case 11: goto L_0x0506;
                case 12: goto L_0x04fb;
                case 13: goto L_0x04d1;
                case 14: goto L_0x04bf;
                case 15: goto L_0x04ad;
                case 16: goto L_0x049e;
                case 17: goto L_0x048c;
                case 18: goto L_0x047a;
                case 19: goto L_0x046f;
                case 20: goto L_0x0464;
                case 21: goto L_0x0459;
                case 22: goto L_0x044e;
                case 23: goto L_0x0443;
                case 24: goto L_0x0438;
                case 25: goto L_0x0429;
                case 26: goto L_0x041a;
                case 27: goto L_0x040b;
                case 28: goto L_0x03fc;
                case 29: goto L_0x03ea;
                case 30: goto L_0x03d8;
                case 31: goto L_0x03c9;
                case 32: goto L_0x039f;
                case 33: goto L_0x0375;
                case 34: goto L_0x036a;
                case 35: goto L_0x0340;
                case 36: goto L_0x0331;
                case 37: goto L_0x031f;
                case 38: goto L_0x030d;
                case 39: goto L_0x02fe;
                case 40: goto L_0x02d4;
                case 41: goto L_0x02c5;
                case 42: goto L_0x02b3;
                case 43: goto L_0x02a1;
                case 44: goto L_0x0278;
                default: goto L_0x0273;
            }
        L_0x0273:
            super.setProperty(r7, r8, r9)
            goto L_0x05c1
        L_0x0278:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x0287
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setStrokeWidth(r7, (java.lang.String) r9)
            goto L_0x05c1
        L_0x0287:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x0296
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setStrokeWidth(r7, (java.lang.Double) r9)
            goto L_0x05c1
        L_0x0296:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            java.lang.String r9 = "1"
            r8.setStrokeWidth(r7, (java.lang.String) r9)
            goto L_0x05c1
        L_0x02a1:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x02a8
            goto L_0x02ae
        L_0x02a8:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x02ae:
            r8.setResponsible(r7, r2)
            goto L_0x05c1
        L_0x02b3:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x02ba
            goto L_0x02c0
        L_0x02ba:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x02c0:
            r8.setStrokeLinejoin(r7, r2)
            goto L_0x05c1
        L_0x02c5:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x02cc
            goto L_0x02cf
        L_0x02cc:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02cf:
            r8.setDisplay(r7, r5)
            goto L_0x05c1
        L_0x02d4:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x02e3
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setTextLength(r7, (java.lang.String) r9)
            goto L_0x05c1
        L_0x02e3:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x02f2
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setTextLength(r7, (java.lang.Double) r9)
            goto L_0x05c1
        L_0x02f2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setTextLength(r7, (java.lang.Double) r5)
            goto L_0x05c1
        L_0x02fe:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x0305
            goto L_0x0308
        L_0x0305:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0308:
            r8.setMidLine(r7, r5)
            goto L_0x05c1
        L_0x030d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x0314
            goto L_0x031a
        L_0x0314:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x031a:
            r8.setStrokeLinecap(r7, r2)
            goto L_0x05c1
        L_0x031f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x0326
            goto L_0x032c
        L_0x0326:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x032c:
            r8.setClipRule(r7, r2)
            goto L_0x05c1
        L_0x0331:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x0338
            goto L_0x033b
        L_0x0338:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x033b:
            r8.setClipPath(r7, r5)
            goto L_0x05c1
        L_0x0340:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x034f
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setInlineSize(r7, (java.lang.String) r9)
            goto L_0x05c1
        L_0x034f:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x035e
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setInlineSize(r7, (java.lang.Double) r9)
            goto L_0x05c1
        L_0x035e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setInlineSize(r7, (java.lang.Double) r5)
            goto L_0x05c1
        L_0x036a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setStrokeDasharray(r7, r9)
            goto L_0x05c1
        L_0x0375:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x0384
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setFontSize(r7, (java.lang.String) r9)
            goto L_0x05c1
        L_0x0384:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x0393
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontSize(r7, (java.lang.Double) r9)
            goto L_0x05c1
        L_0x0393:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontSize(r7, (java.lang.Double) r5)
            goto L_0x05c1
        L_0x039f:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x03ae
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setBaselineShift(r7, (java.lang.String) r9)
            goto L_0x05c1
        L_0x03ae:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x03bd
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setBaselineShift(r7, (java.lang.Double) r9)
            goto L_0x05c1
        L_0x03bd:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setBaselineShift(r7, (java.lang.Double) r5)
            goto L_0x05c1
        L_0x03c9:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x03d0
            goto L_0x03d3
        L_0x03d0:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x03d3:
            r8.setMarkerStart(r7, r5)
            goto L_0x05c1
        L_0x03d8:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x03df
            goto L_0x03e5
        L_0x03df:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x03e5:
            r8.setVectorEffect(r7, r2)
            goto L_0x05c1
        L_0x03ea:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x03f1
            goto L_0x03f7
        L_0x03f1:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x03f7:
            r8.setStrokeMiterlimit(r7, r0)
            goto L_0x05c1
        L_0x03fc:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x0403
            goto L_0x0406
        L_0x0403:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0406:
            r8.setSide(r7, r5)
            goto L_0x05c1
        L_0x040b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x0412
            goto L_0x0415
        L_0x0412:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0415:
            r8.setName(r7, r5)
            goto L_0x05c1
        L_0x041a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x0421
            goto L_0x0424
        L_0x0421:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0424:
            r8.setMask(r7, r5)
            goto L_0x05c1
        L_0x0429:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x0430
            goto L_0x0433
        L_0x0430:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0433:
            r8.setHref(r7, r5)
            goto L_0x05c1
        L_0x0438:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFont(r7, r9)
            goto L_0x05c1
        L_0x0443:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFill(r7, r9)
            goto L_0x05c1
        L_0x044e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setDy(r7, r9)
            goto L_0x05c1
        L_0x0459:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setDx(r7, r9)
            goto L_0x05c1
        L_0x0464:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setY(r7, r9)
            goto L_0x05c1
        L_0x046f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setX(r7, r9)
            goto L_0x05c1
        L_0x047a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x0481
            goto L_0x0487
        L_0x0481:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x0487:
            r8.setStrokeDashoffset(r7, r0)
            goto L_0x05c1
        L_0x048c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x0493
            goto L_0x0499
        L_0x0493:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0499:
            r8.setFillOpacity(r7, r4)
            goto L_0x05c1
        L_0x049e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x04a5
            goto L_0x04a8
        L_0x04a5:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x04a8:
            r8.setPointerEvents(r7, r5)
            goto L_0x05c1
        L_0x04ad:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x04b4
            goto L_0x04ba
        L_0x04b4:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x04ba:
            r8.setStrokeOpacity(r7, r4)
            goto L_0x05c1
        L_0x04bf:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x04c6
            goto L_0x04cc
        L_0x04c6:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x04cc:
            r8.setFillRule(r7, r1)
            goto L_0x05c1
        L_0x04d1:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x04e0
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setFontWeight(r7, (java.lang.String) r9)
            goto L_0x05c1
        L_0x04e0:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x04ef
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontWeight(r7, (java.lang.Double) r9)
            goto L_0x05c1
        L_0x04ef:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontWeight(r7, (java.lang.Double) r5)
            goto L_0x05c1
        L_0x04fb:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setStroke(r7, r9)
            goto L_0x05c1
        L_0x0506:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setRotate(r7, r9)
            goto L_0x05c1
        L_0x0511:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x0518
            goto L_0x051b
        L_0x0518:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x051b:
            r8.setMarkerMid(r7, r5)
            goto L_0x05c1
        L_0x0520:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x0527
            goto L_0x052a
        L_0x0527:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x052a:
            r8.setMarkerEnd(r7, r5)
            goto L_0x05c1
        L_0x052f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setPropList(r7, r9)
            goto L_0x05c1
        L_0x053a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x0541
            goto L_0x0544
        L_0x0541:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0544:
            r8.setMethod(r7, r5)
            goto L_0x05c1
        L_0x0549:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setMatrix(r7, r9)
            goto L_0x05c1
        L_0x0554:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x055b
            goto L_0x055e
        L_0x055b:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x055e:
            r8.setVerticalAlign(r7, r5)
            goto L_0x05c1
        L_0x0562:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x0569
            goto L_0x056c
        L_0x0569:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x056c:
            r8.setAlignmentBaseline(r7, r5)
            goto L_0x05c1
        L_0x0570:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            if (r9 != 0) goto L_0x0575
            goto L_0x057b
        L_0x0575:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x057b:
            r8.setOpacity(r7, r4)
            goto L_0x05c1
        L_0x057f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x0586
            goto L_0x0589
        L_0x0586:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0589:
            r8.setLengthAdjust(r7, r5)
            goto L_0x05c1
        L_0x058d:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x059b
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setStartOffset(r7, (java.lang.String) r9)
            goto L_0x05c1
        L_0x059b:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x05a9
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setStartOffset(r7, (java.lang.Double) r9)
            goto L_0x05c1
        L_0x05a9:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setStartOffset(r7, (java.lang.Double) r5)
            goto L_0x05c1
        L_0x05b4:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface) r8
            if (r9 != 0) goto L_0x05bb
            goto L_0x05be
        L_0x05bb:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x05be:
            r8.setSpacing(r7, r5)
        L_0x05c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGTextPathManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
