package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGMaskManagerInterface;

public class RNSVGMaskManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGMaskManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGMaskManagerDelegate(U u) {
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
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: boolean} */
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
                case -1267206133: goto L_0x01c8;
                case -1221029593: goto L_0x01bd;
                case -1081239615: goto L_0x01b2;
                case -993894751: goto L_0x01a7;
                case -933864895: goto L_0x019c;
                case -933857362: goto L_0x0191;
                case -891980232: goto L_0x0186;
                case -734428249: goto L_0x017b;
                case -729118945: goto L_0x016d;
                case -416535885: goto L_0x015f;
                case -293492298: goto L_0x0151;
                case -61221917: goto L_0x0143;
                case -53677816: goto L_0x0135;
                case -44578051: goto L_0x0127;
                case 120: goto L_0x0119;
                case 121: goto L_0x010b;
                case 3143043: goto L_0x00fd;
                case 3148879: goto L_0x00ef;
                case 3344108: goto L_0x00e1;
                case 3373707: goto L_0x00d3;
                case 78845486: goto L_0x00c5;
                case 104482996: goto L_0x00b7;
                case 113126854: goto L_0x00a9;
                case 217109576: goto L_0x009b;
                case 365601008: goto L_0x008d;
                case 401643183: goto L_0x007f;
                case 917656469: goto L_0x0071;
                case 917735020: goto L_0x0063;
                case 1027575302: goto L_0x0055;
                case 1671764162: goto L_0x0047;
                case 1790285174: goto L_0x0039;
                case 1847674614: goto L_0x002b;
                case 1924065902: goto L_0x001d;
                case 2037673858: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x01d2
        L_0x000f:
            java.lang.String r0 = "maskContentUnits"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x01d2
        L_0x0019:
            r3 = 33
            goto L_0x01d2
        L_0x001d:
            java.lang.String r0 = "strokeWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x01d2
        L_0x0027:
            r3 = 32
            goto L_0x01d2
        L_0x002b:
            java.lang.String r0 = "responsible"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x01d2
        L_0x0035:
            r3 = 31
            goto L_0x01d2
        L_0x0039:
            java.lang.String r0 = "strokeLinejoin"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x01d2
        L_0x0043:
            r3 = 30
            goto L_0x01d2
        L_0x0047:
            java.lang.String r0 = "display"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x01d2
        L_0x0051:
            r3 = 29
            goto L_0x01d2
        L_0x0055:
            java.lang.String r0 = "strokeLinecap"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x01d2
        L_0x005f:
            r3 = 28
            goto L_0x01d2
        L_0x0063:
            java.lang.String r0 = "clipRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x006d
            goto L_0x01d2
        L_0x006d:
            r3 = 27
            goto L_0x01d2
        L_0x0071:
            java.lang.String r0 = "clipPath"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x01d2
        L_0x007b:
            r3 = 26
            goto L_0x01d2
        L_0x007f:
            java.lang.String r0 = "strokeDasharray"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0089
            goto L_0x01d2
        L_0x0089:
            r3 = 25
            goto L_0x01d2
        L_0x008d:
            java.lang.String r0 = "fontSize"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x01d2
        L_0x0097:
            r3 = 24
            goto L_0x01d2
        L_0x009b:
            java.lang.String r0 = "markerStart"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x01d2
        L_0x00a5:
            r3 = 23
            goto L_0x01d2
        L_0x00a9:
            java.lang.String r0 = "width"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x01d2
        L_0x00b3:
            r3 = 22
            goto L_0x01d2
        L_0x00b7:
            java.lang.String r0 = "vectorEffect"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x01d2
        L_0x00c1:
            r3 = 21
            goto L_0x01d2
        L_0x00c5:
            java.lang.String r0 = "strokeMiterlimit"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x01d2
        L_0x00cf:
            r3 = 20
            goto L_0x01d2
        L_0x00d3:
            java.lang.String r0 = "name"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x01d2
        L_0x00dd:
            r3 = 19
            goto L_0x01d2
        L_0x00e1:
            java.lang.String r0 = "mask"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x01d2
        L_0x00eb:
            r3 = 18
            goto L_0x01d2
        L_0x00ef:
            java.lang.String r0 = "font"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x01d2
        L_0x00f9:
            r3 = 17
            goto L_0x01d2
        L_0x00fd:
            java.lang.String r0 = "fill"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x01d2
        L_0x0107:
            r3 = 16
            goto L_0x01d2
        L_0x010b:
            java.lang.String r0 = "y"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0115
            goto L_0x01d2
        L_0x0115:
            r3 = 15
            goto L_0x01d2
        L_0x0119:
            java.lang.String r0 = "x"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0123
            goto L_0x01d2
        L_0x0123:
            r3 = 14
            goto L_0x01d2
        L_0x0127:
            java.lang.String r0 = "strokeDashoffset"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0131
            goto L_0x01d2
        L_0x0131:
            r3 = 13
            goto L_0x01d2
        L_0x0135:
            java.lang.String r0 = "fillOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x013f
            goto L_0x01d2
        L_0x013f:
            r3 = 12
            goto L_0x01d2
        L_0x0143:
            java.lang.String r0 = "maskUnits"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x014d
            goto L_0x01d2
        L_0x014d:
            r3 = 11
            goto L_0x01d2
        L_0x0151:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x015b
            goto L_0x01d2
        L_0x015b:
            r3 = 10
            goto L_0x01d2
        L_0x015f:
            java.lang.String r0 = "strokeOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0169
            goto L_0x01d2
        L_0x0169:
            r3 = 9
            goto L_0x01d2
        L_0x016d:
            java.lang.String r0 = "fillRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0177
            goto L_0x01d2
        L_0x0177:
            r3 = 8
            goto L_0x01d2
        L_0x017b:
            java.lang.String r0 = "fontWeight"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0184
            goto L_0x01d2
        L_0x0184:
            r3 = 7
            goto L_0x01d2
        L_0x0186:
            java.lang.String r0 = "stroke"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x018f
            goto L_0x01d2
        L_0x018f:
            r3 = 6
            goto L_0x01d2
        L_0x0191:
            java.lang.String r0 = "markerMid"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x019a
            goto L_0x01d2
        L_0x019a:
            r3 = 5
            goto L_0x01d2
        L_0x019c:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01a5
            goto L_0x01d2
        L_0x01a5:
            r3 = 4
            goto L_0x01d2
        L_0x01a7:
            java.lang.String r0 = "propList"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01b0
            goto L_0x01d2
        L_0x01b0:
            r3 = 3
            goto L_0x01d2
        L_0x01b2:
            java.lang.String r0 = "matrix"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01bb
            goto L_0x01d2
        L_0x01bb:
            r3 = 2
            goto L_0x01d2
        L_0x01bd:
            java.lang.String r0 = "height"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01c6
            goto L_0x01d2
        L_0x01c6:
            r3 = r1
            goto L_0x01d2
        L_0x01c8:
            java.lang.String r0 = "opacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01d1
            goto L_0x01d2
        L_0x01d1:
            r3 = r2
        L_0x01d2:
            r0 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            switch(r3) {
                case 0: goto L_0x048e;
                case 1: goto L_0x0467;
                case 2: goto L_0x045d;
                case 3: goto L_0x0453;
                case 4: goto L_0x0445;
                case 5: goto L_0x0437;
                case 6: goto L_0x042c;
                case 7: goto L_0x0402;
                case 8: goto L_0x03f0;
                case 9: goto L_0x03de;
                case 10: goto L_0x03cf;
                case 11: goto L_0x03bd;
                case 12: goto L_0x03ab;
                case 13: goto L_0x0399;
                case 14: goto L_0x036f;
                case 15: goto L_0x0345;
                case 16: goto L_0x033a;
                case 17: goto L_0x032f;
                case 18: goto L_0x0320;
                case 19: goto L_0x0311;
                case 20: goto L_0x02ff;
                case 21: goto L_0x02ed;
                case 22: goto L_0x02c3;
                case 23: goto L_0x02b4;
                case 24: goto L_0x028a;
                case 25: goto L_0x027f;
                case 26: goto L_0x0270;
                case 27: goto L_0x025e;
                case 28: goto L_0x024c;
                case 29: goto L_0x023d;
                case 30: goto L_0x022b;
                case 31: goto L_0x0219;
                case 32: goto L_0x01f0;
                case 33: goto L_0x01de;
                default: goto L_0x01d9;
            }
        L_0x01d9:
            super.setProperty(r7, r8, r9)
            goto L_0x049c
        L_0x01de:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x01e5
            goto L_0x01eb
        L_0x01e5:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x01eb:
            r8.setMaskContentUnits(r7, r2)
            goto L_0x049c
        L_0x01f0:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x01ff
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setStrokeWidth(r7, (java.lang.String) r9)
            goto L_0x049c
        L_0x01ff:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x020e
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setStrokeWidth(r7, (java.lang.Double) r9)
            goto L_0x049c
        L_0x020e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            java.lang.String r9 = "1"
            r8.setStrokeWidth(r7, (java.lang.String) r9)
            goto L_0x049c
        L_0x0219:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x0220
            goto L_0x0226
        L_0x0220:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x0226:
            r8.setResponsible(r7, r2)
            goto L_0x049c
        L_0x022b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x0232
            goto L_0x0238
        L_0x0232:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0238:
            r8.setStrokeLinejoin(r7, r2)
            goto L_0x049c
        L_0x023d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x0244
            goto L_0x0247
        L_0x0244:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0247:
            r8.setDisplay(r7, r5)
            goto L_0x049c
        L_0x024c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x0253
            goto L_0x0259
        L_0x0253:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0259:
            r8.setStrokeLinecap(r7, r2)
            goto L_0x049c
        L_0x025e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x0265
            goto L_0x026b
        L_0x0265:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x026b:
            r8.setClipRule(r7, r2)
            goto L_0x049c
        L_0x0270:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x0277
            goto L_0x027a
        L_0x0277:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x027a:
            r8.setClipPath(r7, r5)
            goto L_0x049c
        L_0x027f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setStrokeDasharray(r7, r9)
            goto L_0x049c
        L_0x028a:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x0299
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setFontSize(r7, (java.lang.String) r9)
            goto L_0x049c
        L_0x0299:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x02a8
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontSize(r7, (java.lang.Double) r9)
            goto L_0x049c
        L_0x02a8:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontSize(r7, (java.lang.Double) r5)
            goto L_0x049c
        L_0x02b4:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x02bb
            goto L_0x02be
        L_0x02bb:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02be:
            r8.setMarkerStart(r7, r5)
            goto L_0x049c
        L_0x02c3:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x02d2
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setWidth(r7, (java.lang.String) r9)
            goto L_0x049c
        L_0x02d2:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x02e1
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setWidth(r7, (java.lang.Double) r9)
            goto L_0x049c
        L_0x02e1:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setWidth(r7, (java.lang.Double) r5)
            goto L_0x049c
        L_0x02ed:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x02f4
            goto L_0x02fa
        L_0x02f4:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x02fa:
            r8.setVectorEffect(r7, r2)
            goto L_0x049c
        L_0x02ff:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x0306
            goto L_0x030c
        L_0x0306:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x030c:
            r8.setStrokeMiterlimit(r7, r0)
            goto L_0x049c
        L_0x0311:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x0318
            goto L_0x031b
        L_0x0318:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x031b:
            r8.setName(r7, r5)
            goto L_0x049c
        L_0x0320:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x0327
            goto L_0x032a
        L_0x0327:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x032a:
            r8.setMask(r7, r5)
            goto L_0x049c
        L_0x032f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFont(r7, r9)
            goto L_0x049c
        L_0x033a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFill(r7, r9)
            goto L_0x049c
        L_0x0345:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x0354
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setY(r7, (java.lang.String) r9)
            goto L_0x049c
        L_0x0354:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x0363
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setY(r7, (java.lang.Double) r9)
            goto L_0x049c
        L_0x0363:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setY(r7, (java.lang.Double) r5)
            goto L_0x049c
        L_0x036f:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x037e
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setX(r7, (java.lang.String) r9)
            goto L_0x049c
        L_0x037e:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x038d
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setX(r7, (java.lang.Double) r9)
            goto L_0x049c
        L_0x038d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setX(r7, (java.lang.Double) r5)
            goto L_0x049c
        L_0x0399:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x03a0
            goto L_0x03a6
        L_0x03a0:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x03a6:
            r8.setStrokeDashoffset(r7, r0)
            goto L_0x049c
        L_0x03ab:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x03b2
            goto L_0x03b8
        L_0x03b2:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x03b8:
            r8.setFillOpacity(r7, r4)
            goto L_0x049c
        L_0x03bd:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x03c4
            goto L_0x03ca
        L_0x03c4:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x03ca:
            r8.setMaskUnits(r7, r2)
            goto L_0x049c
        L_0x03cf:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x03d6
            goto L_0x03d9
        L_0x03d6:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x03d9:
            r8.setPointerEvents(r7, r5)
            goto L_0x049c
        L_0x03de:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x03e5
            goto L_0x03eb
        L_0x03e5:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x03eb:
            r8.setStrokeOpacity(r7, r4)
            goto L_0x049c
        L_0x03f0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x03f7
            goto L_0x03fd
        L_0x03f7:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x03fd:
            r8.setFillRule(r7, r1)
            goto L_0x049c
        L_0x0402:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x0411
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setFontWeight(r7, (java.lang.String) r9)
            goto L_0x049c
        L_0x0411:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x0420
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontWeight(r7, (java.lang.Double) r9)
            goto L_0x049c
        L_0x0420:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontWeight(r7, (java.lang.Double) r5)
            goto L_0x049c
        L_0x042c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setStroke(r7, r9)
            goto L_0x049c
        L_0x0437:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x043e
            goto L_0x0441
        L_0x043e:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0441:
            r8.setMarkerMid(r7, r5)
            goto L_0x049c
        L_0x0445:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x044c
            goto L_0x044f
        L_0x044c:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x044f:
            r8.setMarkerEnd(r7, r5)
            goto L_0x049c
        L_0x0453:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setPropList(r7, r9)
            goto L_0x049c
        L_0x045d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setMatrix(r7, r9)
            goto L_0x049c
        L_0x0467:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x0475
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setHeight(r7, (java.lang.String) r9)
            goto L_0x049c
        L_0x0475:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x0483
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setHeight(r7, (java.lang.Double) r9)
            goto L_0x049c
        L_0x0483:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setHeight(r7, (java.lang.Double) r5)
            goto L_0x049c
        L_0x048e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            if (r9 != 0) goto L_0x0493
            goto L_0x0499
        L_0x0493:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0499:
            r8.setOpacity(r7, r4)
        L_0x049c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGMaskManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
