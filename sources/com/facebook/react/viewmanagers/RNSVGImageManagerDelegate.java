package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGImageManagerInterface;

public class RNSVGImageManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGImageManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGImageManagerDelegate(U u) {
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
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: boolean} */
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
                case -1267206133: goto L_0x01ac;
                case -1221029593: goto L_0x01a1;
                case -1081239615: goto L_0x0196;
                case -993894751: goto L_0x018b;
                case -933864895: goto L_0x0180;
                case -933857362: goto L_0x0175;
                case -891980232: goto L_0x016a;
                case -729118945: goto L_0x015f;
                case -416535885: goto L_0x0151;
                case -293492298: goto L_0x0143;
                case -53677816: goto L_0x0135;
                case -44578051: goto L_0x0127;
                case 120: goto L_0x0119;
                case 121: goto L_0x010b;
                case 114148: goto L_0x00fd;
                case 3143043: goto L_0x00ef;
                case 3344108: goto L_0x00e1;
                case 3373707: goto L_0x00d3;
                case 78845486: goto L_0x00c5;
                case 92903173: goto L_0x00b7;
                case 104482996: goto L_0x00a9;
                case 113126854: goto L_0x009b;
                case 217109576: goto L_0x008d;
                case 401643183: goto L_0x007f;
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
            goto L_0x01b6
        L_0x000f:
            java.lang.String r0 = "strokeWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x01b6
        L_0x0019:
            r3 = 31
            goto L_0x01b6
        L_0x001d:
            java.lang.String r0 = "meetOrSlice"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x01b6
        L_0x0027:
            r3 = 30
            goto L_0x01b6
        L_0x002b:
            java.lang.String r0 = "responsible"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x01b6
        L_0x0035:
            r3 = 29
            goto L_0x01b6
        L_0x0039:
            java.lang.String r0 = "strokeLinejoin"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x01b6
        L_0x0043:
            r3 = 28
            goto L_0x01b6
        L_0x0047:
            java.lang.String r0 = "display"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x01b6
        L_0x0051:
            r3 = 27
            goto L_0x01b6
        L_0x0055:
            java.lang.String r0 = "strokeLinecap"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x01b6
        L_0x005f:
            r3 = 26
            goto L_0x01b6
        L_0x0063:
            java.lang.String r0 = "clipRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x006d
            goto L_0x01b6
        L_0x006d:
            r3 = 25
            goto L_0x01b6
        L_0x0071:
            java.lang.String r0 = "clipPath"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x01b6
        L_0x007b:
            r3 = 24
            goto L_0x01b6
        L_0x007f:
            java.lang.String r0 = "strokeDasharray"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0089
            goto L_0x01b6
        L_0x0089:
            r3 = 23
            goto L_0x01b6
        L_0x008d:
            java.lang.String r0 = "markerStart"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x01b6
        L_0x0097:
            r3 = 22
            goto L_0x01b6
        L_0x009b:
            java.lang.String r0 = "width"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x01b6
        L_0x00a5:
            r3 = 21
            goto L_0x01b6
        L_0x00a9:
            java.lang.String r0 = "vectorEffect"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x01b6
        L_0x00b3:
            r3 = 20
            goto L_0x01b6
        L_0x00b7:
            java.lang.String r0 = "align"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x01b6
        L_0x00c1:
            r3 = 19
            goto L_0x01b6
        L_0x00c5:
            java.lang.String r0 = "strokeMiterlimit"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x01b6
        L_0x00cf:
            r3 = 18
            goto L_0x01b6
        L_0x00d3:
            java.lang.String r0 = "name"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x01b6
        L_0x00dd:
            r3 = 17
            goto L_0x01b6
        L_0x00e1:
            java.lang.String r0 = "mask"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x01b6
        L_0x00eb:
            r3 = 16
            goto L_0x01b6
        L_0x00ef:
            java.lang.String r0 = "fill"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x01b6
        L_0x00f9:
            r3 = 15
            goto L_0x01b6
        L_0x00fd:
            java.lang.String r0 = "src"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x01b6
        L_0x0107:
            r3 = 14
            goto L_0x01b6
        L_0x010b:
            java.lang.String r0 = "y"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0115
            goto L_0x01b6
        L_0x0115:
            r3 = 13
            goto L_0x01b6
        L_0x0119:
            java.lang.String r0 = "x"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0123
            goto L_0x01b6
        L_0x0123:
            r3 = 12
            goto L_0x01b6
        L_0x0127:
            java.lang.String r0 = "strokeDashoffset"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0131
            goto L_0x01b6
        L_0x0131:
            r3 = 11
            goto L_0x01b6
        L_0x0135:
            java.lang.String r0 = "fillOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x013f
            goto L_0x01b6
        L_0x013f:
            r3 = 10
            goto L_0x01b6
        L_0x0143:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x014d
            goto L_0x01b6
        L_0x014d:
            r3 = 9
            goto L_0x01b6
        L_0x0151:
            java.lang.String r0 = "strokeOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x015b
            goto L_0x01b6
        L_0x015b:
            r3 = 8
            goto L_0x01b6
        L_0x015f:
            java.lang.String r0 = "fillRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0168
            goto L_0x01b6
        L_0x0168:
            r3 = 7
            goto L_0x01b6
        L_0x016a:
            java.lang.String r0 = "stroke"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0173
            goto L_0x01b6
        L_0x0173:
            r3 = 6
            goto L_0x01b6
        L_0x0175:
            java.lang.String r0 = "markerMid"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x017e
            goto L_0x01b6
        L_0x017e:
            r3 = 5
            goto L_0x01b6
        L_0x0180:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0189
            goto L_0x01b6
        L_0x0189:
            r3 = 4
            goto L_0x01b6
        L_0x018b:
            java.lang.String r0 = "propList"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0194
            goto L_0x01b6
        L_0x0194:
            r3 = 3
            goto L_0x01b6
        L_0x0196:
            java.lang.String r0 = "matrix"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x019f
            goto L_0x01b6
        L_0x019f:
            r3 = 2
            goto L_0x01b6
        L_0x01a1:
            java.lang.String r0 = "height"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01aa
            goto L_0x01b6
        L_0x01aa:
            r3 = r1
            goto L_0x01b6
        L_0x01ac:
            java.lang.String r0 = "opacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01b5
            goto L_0x01b6
        L_0x01b5:
            r3 = r2
        L_0x01b6:
            r0 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            switch(r3) {
                case 0: goto L_0x041b;
                case 1: goto L_0x03f4;
                case 2: goto L_0x03ea;
                case 3: goto L_0x03e0;
                case 4: goto L_0x03d2;
                case 5: goto L_0x03c4;
                case 6: goto L_0x03b9;
                case 7: goto L_0x03a7;
                case 8: goto L_0x0395;
                case 9: goto L_0x0386;
                case 10: goto L_0x0374;
                case 11: goto L_0x0362;
                case 12: goto L_0x0338;
                case 13: goto L_0x030e;
                case 14: goto L_0x0303;
                case 15: goto L_0x02f8;
                case 16: goto L_0x02e9;
                case 17: goto L_0x02da;
                case 18: goto L_0x02c8;
                case 19: goto L_0x02b9;
                case 20: goto L_0x02a7;
                case 21: goto L_0x027d;
                case 22: goto L_0x026e;
                case 23: goto L_0x0263;
                case 24: goto L_0x0254;
                case 25: goto L_0x0242;
                case 26: goto L_0x0230;
                case 27: goto L_0x0221;
                case 28: goto L_0x020f;
                case 29: goto L_0x01fd;
                case 30: goto L_0x01eb;
                case 31: goto L_0x01c2;
                default: goto L_0x01bd;
            }
        L_0x01bd:
            super.setProperty(r7, r8, r9)
            goto L_0x0429
        L_0x01c2:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x01d1
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setStrokeWidth(r7, (java.lang.String) r9)
            goto L_0x0429
        L_0x01d1:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x01e0
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setStrokeWidth(r7, (java.lang.Double) r9)
            goto L_0x0429
        L_0x01e0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            java.lang.String r9 = "1"
            r8.setStrokeWidth(r7, (java.lang.String) r9)
            goto L_0x0429
        L_0x01eb:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x01f2
            goto L_0x01f8
        L_0x01f2:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x01f8:
            r8.setMeetOrSlice(r7, r2)
            goto L_0x0429
        L_0x01fd:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x0204
            goto L_0x020a
        L_0x0204:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x020a:
            r8.setResponsible(r7, r2)
            goto L_0x0429
        L_0x020f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x0216
            goto L_0x021c
        L_0x0216:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x021c:
            r8.setStrokeLinejoin(r7, r2)
            goto L_0x0429
        L_0x0221:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x0228
            goto L_0x022b
        L_0x0228:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x022b:
            r8.setDisplay(r7, r5)
            goto L_0x0429
        L_0x0230:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x0237
            goto L_0x023d
        L_0x0237:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x023d:
            r8.setStrokeLinecap(r7, r2)
            goto L_0x0429
        L_0x0242:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x0249
            goto L_0x024f
        L_0x0249:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x024f:
            r8.setClipRule(r7, r2)
            goto L_0x0429
        L_0x0254:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x025b
            goto L_0x025e
        L_0x025b:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x025e:
            r8.setClipPath(r7, r5)
            goto L_0x0429
        L_0x0263:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setStrokeDasharray(r7, r9)
            goto L_0x0429
        L_0x026e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x0275
            goto L_0x0278
        L_0x0275:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0278:
            r8.setMarkerStart(r7, r5)
            goto L_0x0429
        L_0x027d:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x028c
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setWidth(r7, (java.lang.String) r9)
            goto L_0x0429
        L_0x028c:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x029b
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setWidth(r7, (java.lang.Double) r9)
            goto L_0x0429
        L_0x029b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setWidth(r7, (java.lang.Double) r5)
            goto L_0x0429
        L_0x02a7:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x02ae
            goto L_0x02b4
        L_0x02ae:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x02b4:
            r8.setVectorEffect(r7, r2)
            goto L_0x0429
        L_0x02b9:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x02c0
            goto L_0x02c3
        L_0x02c0:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02c3:
            r8.setAlign(r7, r5)
            goto L_0x0429
        L_0x02c8:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x02cf
            goto L_0x02d5
        L_0x02cf:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x02d5:
            r8.setStrokeMiterlimit(r7, r0)
            goto L_0x0429
        L_0x02da:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x02e1
            goto L_0x02e4
        L_0x02e1:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02e4:
            r8.setName(r7, r5)
            goto L_0x0429
        L_0x02e9:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x02f0
            goto L_0x02f3
        L_0x02f0:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02f3:
            r8.setMask(r7, r5)
            goto L_0x0429
        L_0x02f8:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFill(r7, r9)
            goto L_0x0429
        L_0x0303:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setSrc(r7, r9)
            goto L_0x0429
        L_0x030e:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x031d
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setY(r7, (java.lang.String) r9)
            goto L_0x0429
        L_0x031d:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x032c
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setY(r7, (java.lang.Double) r9)
            goto L_0x0429
        L_0x032c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setY(r7, (java.lang.Double) r5)
            goto L_0x0429
        L_0x0338:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x0347
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setX(r7, (java.lang.String) r9)
            goto L_0x0429
        L_0x0347:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x0356
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setX(r7, (java.lang.Double) r9)
            goto L_0x0429
        L_0x0356:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setX(r7, (java.lang.Double) r5)
            goto L_0x0429
        L_0x0362:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x0369
            goto L_0x036f
        L_0x0369:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x036f:
            r8.setStrokeDashoffset(r7, r0)
            goto L_0x0429
        L_0x0374:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x037b
            goto L_0x0381
        L_0x037b:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0381:
            r8.setFillOpacity(r7, r4)
            goto L_0x0429
        L_0x0386:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x038d
            goto L_0x0390
        L_0x038d:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0390:
            r8.setPointerEvents(r7, r5)
            goto L_0x0429
        L_0x0395:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x039c
            goto L_0x03a2
        L_0x039c:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x03a2:
            r8.setStrokeOpacity(r7, r4)
            goto L_0x0429
        L_0x03a7:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x03ae
            goto L_0x03b4
        L_0x03ae:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x03b4:
            r8.setFillRule(r7, r1)
            goto L_0x0429
        L_0x03b9:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setStroke(r7, r9)
            goto L_0x0429
        L_0x03c4:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x03cb
            goto L_0x03ce
        L_0x03cb:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x03ce:
            r8.setMarkerMid(r7, r5)
            goto L_0x0429
        L_0x03d2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            if (r9 != 0) goto L_0x03d9
            goto L_0x03dc
        L_0x03d9:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x03dc:
            r8.setMarkerEnd(r7, r5)
            goto L_0x0429
        L_0x03e0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setPropList(r7, r9)
            goto L_0x0429
        L_0x03ea:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setMatrix(r7, r9)
            goto L_0x0429
        L_0x03f4:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x0402
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setHeight(r7, (java.lang.String) r9)
            goto L_0x0429
        L_0x0402:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x0410
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setHeight(r7, (java.lang.Double) r9)
            goto L_0x0429
        L_0x0410:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGImageManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGImageManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setHeight(r7, (java.lang.Double) r5)
            goto L_0x0429
        L_0x041b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            if (r9 != 0) goto L_0x0420
            goto L_0x0426
        L_0x0420:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0426:
            r8.setOpacity(r7, r4)
        L_0x0429:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGImageManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
