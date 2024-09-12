package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGPathManagerInterface;

public class RNSVGPathManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGPathManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGPathManagerDelegate(U u) {
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
                case -1267206133: goto L_0x0158;
                case -1081239615: goto L_0x014d;
                case -993894751: goto L_0x0142;
                case -933864895: goto L_0x0137;
                case -933857362: goto L_0x012c;
                case -891980232: goto L_0x0121;
                case -729118945: goto L_0x0116;
                case -416535885: goto L_0x010b;
                case -293492298: goto L_0x00fd;
                case -53677816: goto L_0x00ef;
                case -44578051: goto L_0x00e1;
                case 100: goto L_0x00d3;
                case 3143043: goto L_0x00c5;
                case 3344108: goto L_0x00b7;
                case 3373707: goto L_0x00a9;
                case 78845486: goto L_0x009b;
                case 104482996: goto L_0x008d;
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
            goto L_0x0162
        L_0x000f:
            java.lang.String r0 = "strokeWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x0162
        L_0x0019:
            r3 = 25
            goto L_0x0162
        L_0x001d:
            java.lang.String r0 = "responsible"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x0162
        L_0x0027:
            r3 = 24
            goto L_0x0162
        L_0x002b:
            java.lang.String r0 = "strokeLinejoin"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x0162
        L_0x0035:
            r3 = 23
            goto L_0x0162
        L_0x0039:
            java.lang.String r0 = "display"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x0162
        L_0x0043:
            r3 = 22
            goto L_0x0162
        L_0x0047:
            java.lang.String r0 = "strokeLinecap"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x0162
        L_0x0051:
            r3 = 21
            goto L_0x0162
        L_0x0055:
            java.lang.String r0 = "clipRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x0162
        L_0x005f:
            r3 = 20
            goto L_0x0162
        L_0x0063:
            java.lang.String r0 = "clipPath"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x006d
            goto L_0x0162
        L_0x006d:
            r3 = 19
            goto L_0x0162
        L_0x0071:
            java.lang.String r0 = "strokeDasharray"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x0162
        L_0x007b:
            r3 = 18
            goto L_0x0162
        L_0x007f:
            java.lang.String r0 = "markerStart"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0089
            goto L_0x0162
        L_0x0089:
            r3 = 17
            goto L_0x0162
        L_0x008d:
            java.lang.String r0 = "vectorEffect"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x0162
        L_0x0097:
            r3 = 16
            goto L_0x0162
        L_0x009b:
            java.lang.String r0 = "strokeMiterlimit"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x0162
        L_0x00a5:
            r3 = 15
            goto L_0x0162
        L_0x00a9:
            java.lang.String r0 = "name"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x0162
        L_0x00b3:
            r3 = 14
            goto L_0x0162
        L_0x00b7:
            java.lang.String r0 = "mask"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x0162
        L_0x00c1:
            r3 = 13
            goto L_0x0162
        L_0x00c5:
            java.lang.String r0 = "fill"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x0162
        L_0x00cf:
            r3 = 12
            goto L_0x0162
        L_0x00d3:
            java.lang.String r0 = "d"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x0162
        L_0x00dd:
            r3 = 11
            goto L_0x0162
        L_0x00e1:
            java.lang.String r0 = "strokeDashoffset"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x0162
        L_0x00eb:
            r3 = 10
            goto L_0x0162
        L_0x00ef:
            java.lang.String r0 = "fillOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x0162
        L_0x00f9:
            r3 = 9
            goto L_0x0162
        L_0x00fd:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x0162
        L_0x0107:
            r3 = 8
            goto L_0x0162
        L_0x010b:
            java.lang.String r0 = "strokeOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0114
            goto L_0x0162
        L_0x0114:
            r3 = 7
            goto L_0x0162
        L_0x0116:
            java.lang.String r0 = "fillRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x011f
            goto L_0x0162
        L_0x011f:
            r3 = 6
            goto L_0x0162
        L_0x0121:
            java.lang.String r0 = "stroke"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x012a
            goto L_0x0162
        L_0x012a:
            r3 = 5
            goto L_0x0162
        L_0x012c:
            java.lang.String r0 = "markerMid"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0135
            goto L_0x0162
        L_0x0135:
            r3 = 4
            goto L_0x0162
        L_0x0137:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0140
            goto L_0x0162
        L_0x0140:
            r3 = 3
            goto L_0x0162
        L_0x0142:
            java.lang.String r0 = "propList"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x014b
            goto L_0x0162
        L_0x014b:
            r3 = 2
            goto L_0x0162
        L_0x014d:
            java.lang.String r0 = "matrix"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0156
            goto L_0x0162
        L_0x0156:
            r3 = r1
            goto L_0x0162
        L_0x0158:
            java.lang.String r0 = "opacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0161
            goto L_0x0162
        L_0x0161:
            r3 = r2
        L_0x0162:
            r0 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            switch(r3) {
                case 0: goto L_0x0302;
                case 1: goto L_0x02f8;
                case 2: goto L_0x02ee;
                case 3: goto L_0x02e0;
                case 4: goto L_0x02d2;
                case 5: goto L_0x02c8;
                case 6: goto L_0x02b7;
                case 7: goto L_0x02a6;
                case 8: goto L_0x0297;
                case 9: goto L_0x0285;
                case 10: goto L_0x0273;
                case 11: goto L_0x0264;
                case 12: goto L_0x0259;
                case 13: goto L_0x024a;
                case 14: goto L_0x023b;
                case 15: goto L_0x0229;
                case 16: goto L_0x0217;
                case 17: goto L_0x0208;
                case 18: goto L_0x01fd;
                case 19: goto L_0x01ee;
                case 20: goto L_0x01dc;
                case 21: goto L_0x01ca;
                case 22: goto L_0x01bb;
                case 23: goto L_0x01a9;
                case 24: goto L_0x0197;
                case 25: goto L_0x016e;
                default: goto L_0x0169;
            }
        L_0x0169:
            super.setProperty(r7, r8, r9)
            goto L_0x0310
        L_0x016e:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x017d
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setStrokeWidth(r7, (java.lang.String) r9)
            goto L_0x0310
        L_0x017d:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x018c
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setStrokeWidth(r7, (java.lang.Double) r9)
            goto L_0x0310
        L_0x018c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            java.lang.String r9 = "1"
            r8.setStrokeWidth(r7, (java.lang.String) r9)
            goto L_0x0310
        L_0x0197:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x019e
            goto L_0x01a4
        L_0x019e:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x01a4:
            r8.setResponsible(r7, r2)
            goto L_0x0310
        L_0x01a9:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x01b0
            goto L_0x01b6
        L_0x01b0:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x01b6:
            r8.setStrokeLinejoin(r7, r2)
            goto L_0x0310
        L_0x01bb:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x01c2
            goto L_0x01c5
        L_0x01c2:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x01c5:
            r8.setDisplay(r7, r5)
            goto L_0x0310
        L_0x01ca:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x01d1
            goto L_0x01d7
        L_0x01d1:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x01d7:
            r8.setStrokeLinecap(r7, r2)
            goto L_0x0310
        L_0x01dc:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x01e3
            goto L_0x01e9
        L_0x01e3:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x01e9:
            r8.setClipRule(r7, r2)
            goto L_0x0310
        L_0x01ee:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x01f5
            goto L_0x01f8
        L_0x01f5:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x01f8:
            r8.setClipPath(r7, r5)
            goto L_0x0310
        L_0x01fd:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setStrokeDasharray(r7, r9)
            goto L_0x0310
        L_0x0208:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x020f
            goto L_0x0212
        L_0x020f:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0212:
            r8.setMarkerStart(r7, r5)
            goto L_0x0310
        L_0x0217:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x021e
            goto L_0x0224
        L_0x021e:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0224:
            r8.setVectorEffect(r7, r2)
            goto L_0x0310
        L_0x0229:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x0230
            goto L_0x0236
        L_0x0230:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x0236:
            r8.setStrokeMiterlimit(r7, r0)
            goto L_0x0310
        L_0x023b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x0242
            goto L_0x0245
        L_0x0242:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0245:
            r8.setName(r7, r5)
            goto L_0x0310
        L_0x024a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x0251
            goto L_0x0254
        L_0x0251:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0254:
            r8.setMask(r7, r5)
            goto L_0x0310
        L_0x0259:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFill(r7, r9)
            goto L_0x0310
        L_0x0264:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x026b
            goto L_0x026e
        L_0x026b:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x026e:
            r8.setD(r7, r5)
            goto L_0x0310
        L_0x0273:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x027a
            goto L_0x0280
        L_0x027a:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x0280:
            r8.setStrokeDashoffset(r7, r0)
            goto L_0x0310
        L_0x0285:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x028c
            goto L_0x0292
        L_0x028c:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0292:
            r8.setFillOpacity(r7, r4)
            goto L_0x0310
        L_0x0297:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x029e
            goto L_0x02a1
        L_0x029e:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02a1:
            r8.setPointerEvents(r7, r5)
            goto L_0x0310
        L_0x02a6:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x02ad
            goto L_0x02b3
        L_0x02ad:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x02b3:
            r8.setStrokeOpacity(r7, r4)
            goto L_0x0310
        L_0x02b7:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x02be
            goto L_0x02c4
        L_0x02be:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x02c4:
            r8.setFillRule(r7, r1)
            goto L_0x0310
        L_0x02c8:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setStroke(r7, r9)
            goto L_0x0310
        L_0x02d2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x02d9
            goto L_0x02dc
        L_0x02d9:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02dc:
            r8.setMarkerMid(r7, r5)
            goto L_0x0310
        L_0x02e0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x02e7
            goto L_0x02ea
        L_0x02e7:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02ea:
            r8.setMarkerEnd(r7, r5)
            goto L_0x0310
        L_0x02ee:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setPropList(r7, r9)
            goto L_0x0310
        L_0x02f8:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setMatrix(r7, r9)
            goto L_0x0310
        L_0x0302:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            if (r9 != 0) goto L_0x0307
            goto L_0x030d
        L_0x0307:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x030d:
            r8.setOpacity(r7, r4)
        L_0x0310:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGPathManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
