package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGPatternManagerInterface;

public class RNSVGPatternManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGPatternManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGPatternManagerDelegate(U u) {
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
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: boolean} */
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
                case -1567958285: goto L_0x022a;
                case -1267206133: goto L_0x021f;
                case -1221029593: goto L_0x0214;
                case -1081239615: goto L_0x0209;
                case -993894751: goto L_0x01fe;
                case -933864895: goto L_0x01f3;
                case -933857362: goto L_0x01e8;
                case -891980232: goto L_0x01dd;
                case -734428249: goto L_0x01cf;
                case -729118945: goto L_0x01c1;
                case -416535885: goto L_0x01b3;
                case -293492298: goto L_0x01a5;
                case -207800897: goto L_0x0197;
                case -128680410: goto L_0x0189;
                case -53677816: goto L_0x017b;
                case -44578051: goto L_0x016d;
                case 120: goto L_0x015f;
                case 121: goto L_0x0151;
                case 3143043: goto L_0x0143;
                case 3148879: goto L_0x0135;
                case 3344108: goto L_0x0127;
                case 3351622: goto L_0x0119;
                case 3351623: goto L_0x010b;
                case 3373707: goto L_0x00fd;
                case 78845486: goto L_0x00ef;
                case 92903173: goto L_0x00e1;
                case 104482996: goto L_0x00d3;
                case 113126854: goto L_0x00c5;
                case 217109576: goto L_0x00b7;
                case 240482938: goto L_0x00a9;
                case 365601008: goto L_0x009b;
                case 401643183: goto L_0x008d;
                case 746561980: goto L_0x007f;
                case 917656469: goto L_0x0071;
                case 917735020: goto L_0x0063;
                case 1027575302: goto L_0x0055;
                case 1671764162: goto L_0x0047;
                case 1790285174: goto L_0x0039;
                case 1847674614: goto L_0x002b;
                case 1908075304: goto L_0x001d;
                case 1924065902: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0234
        L_0x000f:
            java.lang.String r0 = "strokeWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x0234
        L_0x0019:
            r3 = 40
            goto L_0x0234
        L_0x001d:
            java.lang.String r0 = "meetOrSlice"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x0234
        L_0x0027:
            r3 = 39
            goto L_0x0234
        L_0x002b:
            java.lang.String r0 = "responsible"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x0234
        L_0x0035:
            r3 = 38
            goto L_0x0234
        L_0x0039:
            java.lang.String r0 = "strokeLinejoin"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x0234
        L_0x0043:
            r3 = 37
            goto L_0x0234
        L_0x0047:
            java.lang.String r0 = "display"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x0234
        L_0x0051:
            r3 = 36
            goto L_0x0234
        L_0x0055:
            java.lang.String r0 = "strokeLinecap"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x0234
        L_0x005f:
            r3 = 35
            goto L_0x0234
        L_0x0063:
            java.lang.String r0 = "clipRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x006d
            goto L_0x0234
        L_0x006d:
            r3 = 34
            goto L_0x0234
        L_0x0071:
            java.lang.String r0 = "clipPath"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x0234
        L_0x007b:
            r3 = 33
            goto L_0x0234
        L_0x007f:
            java.lang.String r0 = "patternTransform"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0089
            goto L_0x0234
        L_0x0089:
            r3 = 32
            goto L_0x0234
        L_0x008d:
            java.lang.String r0 = "strokeDasharray"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x0234
        L_0x0097:
            r3 = 31
            goto L_0x0234
        L_0x009b:
            java.lang.String r0 = "fontSize"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x0234
        L_0x00a5:
            r3 = 30
            goto L_0x0234
        L_0x00a9:
            java.lang.String r0 = "vbWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x0234
        L_0x00b3:
            r3 = 29
            goto L_0x0234
        L_0x00b7:
            java.lang.String r0 = "markerStart"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x0234
        L_0x00c1:
            r3 = 28
            goto L_0x0234
        L_0x00c5:
            java.lang.String r0 = "width"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x0234
        L_0x00cf:
            r3 = 27
            goto L_0x0234
        L_0x00d3:
            java.lang.String r0 = "vectorEffect"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x0234
        L_0x00dd:
            r3 = 26
            goto L_0x0234
        L_0x00e1:
            java.lang.String r0 = "align"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x0234
        L_0x00eb:
            r3 = 25
            goto L_0x0234
        L_0x00ef:
            java.lang.String r0 = "strokeMiterlimit"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x0234
        L_0x00f9:
            r3 = 24
            goto L_0x0234
        L_0x00fd:
            java.lang.String r0 = "name"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x0234
        L_0x0107:
            r3 = 23
            goto L_0x0234
        L_0x010b:
            java.lang.String r0 = "minY"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0115
            goto L_0x0234
        L_0x0115:
            r3 = 22
            goto L_0x0234
        L_0x0119:
            java.lang.String r0 = "minX"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0123
            goto L_0x0234
        L_0x0123:
            r3 = 21
            goto L_0x0234
        L_0x0127:
            java.lang.String r0 = "mask"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0131
            goto L_0x0234
        L_0x0131:
            r3 = 20
            goto L_0x0234
        L_0x0135:
            java.lang.String r0 = "font"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x013f
            goto L_0x0234
        L_0x013f:
            r3 = 19
            goto L_0x0234
        L_0x0143:
            java.lang.String r0 = "fill"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x014d
            goto L_0x0234
        L_0x014d:
            r3 = 18
            goto L_0x0234
        L_0x0151:
            java.lang.String r0 = "y"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x015b
            goto L_0x0234
        L_0x015b:
            r3 = 17
            goto L_0x0234
        L_0x015f:
            java.lang.String r0 = "x"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0169
            goto L_0x0234
        L_0x0169:
            r3 = 16
            goto L_0x0234
        L_0x016d:
            java.lang.String r0 = "strokeDashoffset"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0177
            goto L_0x0234
        L_0x0177:
            r3 = 15
            goto L_0x0234
        L_0x017b:
            java.lang.String r0 = "fillOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0185
            goto L_0x0234
        L_0x0185:
            r3 = 14
            goto L_0x0234
        L_0x0189:
            java.lang.String r0 = "patternContentUnits"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0193
            goto L_0x0234
        L_0x0193:
            r3 = 13
            goto L_0x0234
        L_0x0197:
            java.lang.String r0 = "patternUnits"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01a1
            goto L_0x0234
        L_0x01a1:
            r3 = 12
            goto L_0x0234
        L_0x01a5:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01af
            goto L_0x0234
        L_0x01af:
            r3 = 11
            goto L_0x0234
        L_0x01b3:
            java.lang.String r0 = "strokeOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01bd
            goto L_0x0234
        L_0x01bd:
            r3 = 10
            goto L_0x0234
        L_0x01c1:
            java.lang.String r0 = "fillRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01cb
            goto L_0x0234
        L_0x01cb:
            r3 = 9
            goto L_0x0234
        L_0x01cf:
            java.lang.String r0 = "fontWeight"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01d9
            goto L_0x0234
        L_0x01d9:
            r3 = 8
            goto L_0x0234
        L_0x01dd:
            java.lang.String r0 = "stroke"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01e6
            goto L_0x0234
        L_0x01e6:
            r3 = 7
            goto L_0x0234
        L_0x01e8:
            java.lang.String r0 = "markerMid"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01f1
            goto L_0x0234
        L_0x01f1:
            r3 = 6
            goto L_0x0234
        L_0x01f3:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01fc
            goto L_0x0234
        L_0x01fc:
            r3 = 5
            goto L_0x0234
        L_0x01fe:
            java.lang.String r0 = "propList"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0207
            goto L_0x0234
        L_0x0207:
            r3 = 4
            goto L_0x0234
        L_0x0209:
            java.lang.String r0 = "matrix"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0212
            goto L_0x0234
        L_0x0212:
            r3 = 3
            goto L_0x0234
        L_0x0214:
            java.lang.String r0 = "height"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x021d
            goto L_0x0234
        L_0x021d:
            r3 = 2
            goto L_0x0234
        L_0x021f:
            java.lang.String r0 = "opacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0228
            goto L_0x0234
        L_0x0228:
            r3 = r1
            goto L_0x0234
        L_0x022a:
            java.lang.String r0 = "vbHeight"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0233
            goto L_0x0234
        L_0x0233:
            r3 = r2
        L_0x0234:
            r0 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            r5 = 0
            switch(r3) {
                case 0: goto L_0x0562;
                case 1: goto L_0x0553;
                case 2: goto L_0x052c;
                case 3: goto L_0x0522;
                case 4: goto L_0x0518;
                case 5: goto L_0x050a;
                case 6: goto L_0x04fb;
                case 7: goto L_0x04f0;
                case 8: goto L_0x04c6;
                case 9: goto L_0x04b4;
                case 10: goto L_0x04a2;
                case 11: goto L_0x0493;
                case 12: goto L_0x0481;
                case 13: goto L_0x046f;
                case 14: goto L_0x045d;
                case 15: goto L_0x044b;
                case 16: goto L_0x0421;
                case 17: goto L_0x03f7;
                case 18: goto L_0x03ec;
                case 19: goto L_0x03e1;
                case 20: goto L_0x03d2;
                case 21: goto L_0x03c0;
                case 22: goto L_0x03ae;
                case 23: goto L_0x039f;
                case 24: goto L_0x038d;
                case 25: goto L_0x037e;
                case 26: goto L_0x036c;
                case 27: goto L_0x0342;
                case 28: goto L_0x0333;
                case 29: goto L_0x0321;
                case 30: goto L_0x02f7;
                case 31: goto L_0x02ec;
                case 32: goto L_0x02e1;
                case 33: goto L_0x02d2;
                case 34: goto L_0x02c0;
                case 35: goto L_0x02ae;
                case 36: goto L_0x029f;
                case 37: goto L_0x028d;
                case 38: goto L_0x027b;
                case 39: goto L_0x0269;
                case 40: goto L_0x0240;
                default: goto L_0x023b;
            }
        L_0x023b:
            super.setProperty(r7, r8, r9)
            goto L_0x0572
        L_0x0240:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x024f
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setStrokeWidth(r7, (java.lang.String) r9)
            goto L_0x0572
        L_0x024f:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x025e
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setStrokeWidth(r7, (java.lang.Double) r9)
            goto L_0x0572
        L_0x025e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            java.lang.String r9 = "1"
            r8.setStrokeWidth(r7, (java.lang.String) r9)
            goto L_0x0572
        L_0x0269:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x0270
            goto L_0x0276
        L_0x0270:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0276:
            r8.setMeetOrSlice(r7, r2)
            goto L_0x0572
        L_0x027b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x0282
            goto L_0x0288
        L_0x0282:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x0288:
            r8.setResponsible(r7, r2)
            goto L_0x0572
        L_0x028d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x0294
            goto L_0x029a
        L_0x0294:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x029a:
            r8.setStrokeLinejoin(r7, r2)
            goto L_0x0572
        L_0x029f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x02a6
            goto L_0x02a9
        L_0x02a6:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02a9:
            r8.setDisplay(r7, r5)
            goto L_0x0572
        L_0x02ae:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x02b5
            goto L_0x02bb
        L_0x02b5:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x02bb:
            r8.setStrokeLinecap(r7, r2)
            goto L_0x0572
        L_0x02c0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x02c7
            goto L_0x02cd
        L_0x02c7:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x02cd:
            r8.setClipRule(r7, r2)
            goto L_0x0572
        L_0x02d2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x02d9
            goto L_0x02dc
        L_0x02d9:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02dc:
            r8.setClipPath(r7, r5)
            goto L_0x0572
        L_0x02e1:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setPatternTransform(r7, r9)
            goto L_0x0572
        L_0x02ec:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setStrokeDasharray(r7, r9)
            goto L_0x0572
        L_0x02f7:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x0306
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setFontSize(r7, (java.lang.String) r9)
            goto L_0x0572
        L_0x0306:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x0315
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontSize(r7, (java.lang.Double) r9)
            goto L_0x0572
        L_0x0315:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontSize(r7, (java.lang.Double) r5)
            goto L_0x0572
        L_0x0321:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x0328
            goto L_0x032e
        L_0x0328:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x032e:
            r8.setVbWidth(r7, r4)
            goto L_0x0572
        L_0x0333:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x033a
            goto L_0x033d
        L_0x033a:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x033d:
            r8.setMarkerStart(r7, r5)
            goto L_0x0572
        L_0x0342:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x0351
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setWidth(r7, (java.lang.String) r9)
            goto L_0x0572
        L_0x0351:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x0360
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setWidth(r7, (java.lang.Double) r9)
            goto L_0x0572
        L_0x0360:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setWidth(r7, (java.lang.Double) r5)
            goto L_0x0572
        L_0x036c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x0373
            goto L_0x0379
        L_0x0373:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0379:
            r8.setVectorEffect(r7, r2)
            goto L_0x0572
        L_0x037e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x0385
            goto L_0x0388
        L_0x0385:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0388:
            r8.setAlign(r7, r5)
            goto L_0x0572
        L_0x038d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x0394
            goto L_0x039a
        L_0x0394:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x039a:
            r8.setStrokeMiterlimit(r7, r4)
            goto L_0x0572
        L_0x039f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x03a6
            goto L_0x03a9
        L_0x03a6:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x03a9:
            r8.setName(r7, r5)
            goto L_0x0572
        L_0x03ae:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x03b5
            goto L_0x03bb
        L_0x03b5:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x03bb:
            r8.setMinY(r7, r4)
            goto L_0x0572
        L_0x03c0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x03c7
            goto L_0x03cd
        L_0x03c7:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x03cd:
            r8.setMinX(r7, r4)
            goto L_0x0572
        L_0x03d2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x03d9
            goto L_0x03dc
        L_0x03d9:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x03dc:
            r8.setMask(r7, r5)
            goto L_0x0572
        L_0x03e1:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFont(r7, r9)
            goto L_0x0572
        L_0x03ec:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFill(r7, r9)
            goto L_0x0572
        L_0x03f7:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x0406
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setY(r7, (java.lang.String) r9)
            goto L_0x0572
        L_0x0406:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x0415
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setY(r7, (java.lang.Double) r9)
            goto L_0x0572
        L_0x0415:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setY(r7, (java.lang.Double) r5)
            goto L_0x0572
        L_0x0421:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x0430
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setX(r7, (java.lang.String) r9)
            goto L_0x0572
        L_0x0430:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x043f
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setX(r7, (java.lang.Double) r9)
            goto L_0x0572
        L_0x043f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setX(r7, (java.lang.Double) r5)
            goto L_0x0572
        L_0x044b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x0452
            goto L_0x0458
        L_0x0452:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0458:
            r8.setStrokeDashoffset(r7, r4)
            goto L_0x0572
        L_0x045d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x0464
            goto L_0x046a
        L_0x0464:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x046a:
            r8.setFillOpacity(r7, r0)
            goto L_0x0572
        L_0x046f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x0476
            goto L_0x047c
        L_0x0476:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x047c:
            r8.setPatternContentUnits(r7, r2)
            goto L_0x0572
        L_0x0481:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x0488
            goto L_0x048e
        L_0x0488:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x048e:
            r8.setPatternUnits(r7, r2)
            goto L_0x0572
        L_0x0493:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x049a
            goto L_0x049d
        L_0x049a:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x049d:
            r8.setPointerEvents(r7, r5)
            goto L_0x0572
        L_0x04a2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x04a9
            goto L_0x04af
        L_0x04a9:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x04af:
            r8.setStrokeOpacity(r7, r0)
            goto L_0x0572
        L_0x04b4:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x04bb
            goto L_0x04c1
        L_0x04bb:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x04c1:
            r8.setFillRule(r7, r1)
            goto L_0x0572
        L_0x04c6:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x04d5
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setFontWeight(r7, (java.lang.String) r9)
            goto L_0x0572
        L_0x04d5:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x04e4
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontWeight(r7, (java.lang.Double) r9)
            goto L_0x0572
        L_0x04e4:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontWeight(r7, (java.lang.Double) r5)
            goto L_0x0572
        L_0x04f0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setStroke(r7, r9)
            goto L_0x0572
        L_0x04fb:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x0502
            goto L_0x0505
        L_0x0502:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0505:
            r8.setMarkerMid(r7, r5)
            goto L_0x0572
        L_0x050a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x0511
            goto L_0x0514
        L_0x0511:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0514:
            r8.setMarkerEnd(r7, r5)
            goto L_0x0572
        L_0x0518:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setPropList(r7, r9)
            goto L_0x0572
        L_0x0522:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setMatrix(r7, r9)
            goto L_0x0572
        L_0x052c:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x053a
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setHeight(r7, (java.lang.String) r9)
            goto L_0x0572
        L_0x053a:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x0548
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setHeight(r7, (java.lang.Double) r9)
            goto L_0x0572
        L_0x0548:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setHeight(r7, (java.lang.Double) r5)
            goto L_0x0572
        L_0x0553:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            if (r9 != 0) goto L_0x0558
            goto L_0x055e
        L_0x0558:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x055e:
            r8.setOpacity(r7, r0)
            goto L_0x0572
        L_0x0562:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPatternManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPatternManagerInterface) r8
            if (r9 != 0) goto L_0x0569
            goto L_0x056f
        L_0x0569:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x056f:
            r8.setVbHeight(r7, r4)
        L_0x0572:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGPatternManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
