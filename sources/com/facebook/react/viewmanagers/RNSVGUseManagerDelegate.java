package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGUseManagerInterface;

public class RNSVGUseManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGUseManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGUseManagerDelegate(U u) {
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
                case -1267206133: goto L_0x0190;
                case -1221029593: goto L_0x0185;
                case -1081239615: goto L_0x017a;
                case -993894751: goto L_0x016f;
                case -933864895: goto L_0x0164;
                case -933857362: goto L_0x0159;
                case -891980232: goto L_0x014e;
                case -729118945: goto L_0x0143;
                case -416535885: goto L_0x0135;
                case -293492298: goto L_0x0127;
                case -53677816: goto L_0x0119;
                case -44578051: goto L_0x010b;
                case 120: goto L_0x00fd;
                case 121: goto L_0x00ef;
                case 3143043: goto L_0x00e1;
                case 3211051: goto L_0x00d3;
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
            goto L_0x019a
        L_0x000f:
            java.lang.String r0 = "strokeWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x019a
        L_0x0019:
            r3 = 29
            goto L_0x019a
        L_0x001d:
            java.lang.String r0 = "responsible"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x019a
        L_0x0027:
            r3 = 28
            goto L_0x019a
        L_0x002b:
            java.lang.String r0 = "strokeLinejoin"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x019a
        L_0x0035:
            r3 = 27
            goto L_0x019a
        L_0x0039:
            java.lang.String r0 = "display"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x019a
        L_0x0043:
            r3 = 26
            goto L_0x019a
        L_0x0047:
            java.lang.String r0 = "strokeLinecap"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x019a
        L_0x0051:
            r3 = 25
            goto L_0x019a
        L_0x0055:
            java.lang.String r0 = "clipRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x019a
        L_0x005f:
            r3 = 24
            goto L_0x019a
        L_0x0063:
            java.lang.String r0 = "clipPath"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x006d
            goto L_0x019a
        L_0x006d:
            r3 = 23
            goto L_0x019a
        L_0x0071:
            java.lang.String r0 = "strokeDasharray"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x019a
        L_0x007b:
            r3 = 22
            goto L_0x019a
        L_0x007f:
            java.lang.String r0 = "markerStart"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0089
            goto L_0x019a
        L_0x0089:
            r3 = 21
            goto L_0x019a
        L_0x008d:
            java.lang.String r0 = "width"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x019a
        L_0x0097:
            r3 = 20
            goto L_0x019a
        L_0x009b:
            java.lang.String r0 = "vectorEffect"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x019a
        L_0x00a5:
            r3 = 19
            goto L_0x019a
        L_0x00a9:
            java.lang.String r0 = "strokeMiterlimit"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x019a
        L_0x00b3:
            r3 = 18
            goto L_0x019a
        L_0x00b7:
            java.lang.String r0 = "name"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x019a
        L_0x00c1:
            r3 = 17
            goto L_0x019a
        L_0x00c5:
            java.lang.String r0 = "mask"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x019a
        L_0x00cf:
            r3 = 16
            goto L_0x019a
        L_0x00d3:
            java.lang.String r0 = "href"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x019a
        L_0x00dd:
            r3 = 15
            goto L_0x019a
        L_0x00e1:
            java.lang.String r0 = "fill"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x019a
        L_0x00eb:
            r3 = 14
            goto L_0x019a
        L_0x00ef:
            java.lang.String r0 = "y"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x019a
        L_0x00f9:
            r3 = 13
            goto L_0x019a
        L_0x00fd:
            java.lang.String r0 = "x"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x019a
        L_0x0107:
            r3 = 12
            goto L_0x019a
        L_0x010b:
            java.lang.String r0 = "strokeDashoffset"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0115
            goto L_0x019a
        L_0x0115:
            r3 = 11
            goto L_0x019a
        L_0x0119:
            java.lang.String r0 = "fillOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0123
            goto L_0x019a
        L_0x0123:
            r3 = 10
            goto L_0x019a
        L_0x0127:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0131
            goto L_0x019a
        L_0x0131:
            r3 = 9
            goto L_0x019a
        L_0x0135:
            java.lang.String r0 = "strokeOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x013f
            goto L_0x019a
        L_0x013f:
            r3 = 8
            goto L_0x019a
        L_0x0143:
            java.lang.String r0 = "fillRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x014c
            goto L_0x019a
        L_0x014c:
            r3 = 7
            goto L_0x019a
        L_0x014e:
            java.lang.String r0 = "stroke"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0157
            goto L_0x019a
        L_0x0157:
            r3 = 6
            goto L_0x019a
        L_0x0159:
            java.lang.String r0 = "markerMid"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0162
            goto L_0x019a
        L_0x0162:
            r3 = 5
            goto L_0x019a
        L_0x0164:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x016d
            goto L_0x019a
        L_0x016d:
            r3 = 4
            goto L_0x019a
        L_0x016f:
            java.lang.String r0 = "propList"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0178
            goto L_0x019a
        L_0x0178:
            r3 = 3
            goto L_0x019a
        L_0x017a:
            java.lang.String r0 = "matrix"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0183
            goto L_0x019a
        L_0x0183:
            r3 = 2
            goto L_0x019a
        L_0x0185:
            java.lang.String r0 = "height"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x018e
            goto L_0x019a
        L_0x018e:
            r3 = r1
            goto L_0x019a
        L_0x0190:
            java.lang.String r0 = "opacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0199
            goto L_0x019a
        L_0x0199:
            r3 = r2
        L_0x019a:
            r0 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            switch(r3) {
                case 0: goto L_0x03e2;
                case 1: goto L_0x03bb;
                case 2: goto L_0x03b1;
                case 3: goto L_0x03a7;
                case 4: goto L_0x0399;
                case 5: goto L_0x038b;
                case 6: goto L_0x0380;
                case 7: goto L_0x036e;
                case 8: goto L_0x035c;
                case 9: goto L_0x034d;
                case 10: goto L_0x033b;
                case 11: goto L_0x0329;
                case 12: goto L_0x02ff;
                case 13: goto L_0x02d5;
                case 14: goto L_0x02ca;
                case 15: goto L_0x02bb;
                case 16: goto L_0x02ac;
                case 17: goto L_0x029d;
                case 18: goto L_0x028b;
                case 19: goto L_0x0279;
                case 20: goto L_0x024f;
                case 21: goto L_0x0240;
                case 22: goto L_0x0235;
                case 23: goto L_0x0226;
                case 24: goto L_0x0214;
                case 25: goto L_0x0202;
                case 26: goto L_0x01f3;
                case 27: goto L_0x01e1;
                case 28: goto L_0x01cf;
                case 29: goto L_0x01a6;
                default: goto L_0x01a1;
            }
        L_0x01a1:
            super.setProperty(r7, r8, r9)
            goto L_0x03f0
        L_0x01a6:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x01b5
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setStrokeWidth(r7, (java.lang.String) r9)
            goto L_0x03f0
        L_0x01b5:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x01c4
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setStrokeWidth(r7, (java.lang.Double) r9)
            goto L_0x03f0
        L_0x01c4:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            java.lang.String r9 = "1"
            r8.setStrokeWidth(r7, (java.lang.String) r9)
            goto L_0x03f0
        L_0x01cf:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            if (r9 != 0) goto L_0x01d6
            goto L_0x01dc
        L_0x01d6:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x01dc:
            r8.setResponsible(r7, r2)
            goto L_0x03f0
        L_0x01e1:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            if (r9 != 0) goto L_0x01e8
            goto L_0x01ee
        L_0x01e8:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x01ee:
            r8.setStrokeLinejoin(r7, r2)
            goto L_0x03f0
        L_0x01f3:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            if (r9 != 0) goto L_0x01fa
            goto L_0x01fd
        L_0x01fa:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x01fd:
            r8.setDisplay(r7, r5)
            goto L_0x03f0
        L_0x0202:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            if (r9 != 0) goto L_0x0209
            goto L_0x020f
        L_0x0209:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x020f:
            r8.setStrokeLinecap(r7, r2)
            goto L_0x03f0
        L_0x0214:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            if (r9 != 0) goto L_0x021b
            goto L_0x0221
        L_0x021b:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0221:
            r8.setClipRule(r7, r2)
            goto L_0x03f0
        L_0x0226:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            if (r9 != 0) goto L_0x022d
            goto L_0x0230
        L_0x022d:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0230:
            r8.setClipPath(r7, r5)
            goto L_0x03f0
        L_0x0235:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setStrokeDasharray(r7, r9)
            goto L_0x03f0
        L_0x0240:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            if (r9 != 0) goto L_0x0247
            goto L_0x024a
        L_0x0247:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x024a:
            r8.setMarkerStart(r7, r5)
            goto L_0x03f0
        L_0x024f:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x025e
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setWidth(r7, (java.lang.String) r9)
            goto L_0x03f0
        L_0x025e:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x026d
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setWidth(r7, (java.lang.Double) r9)
            goto L_0x03f0
        L_0x026d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setWidth(r7, (java.lang.Double) r5)
            goto L_0x03f0
        L_0x0279:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            if (r9 != 0) goto L_0x0280
            goto L_0x0286
        L_0x0280:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0286:
            r8.setVectorEffect(r7, r2)
            goto L_0x03f0
        L_0x028b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            if (r9 != 0) goto L_0x0292
            goto L_0x0298
        L_0x0292:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x0298:
            r8.setStrokeMiterlimit(r7, r0)
            goto L_0x03f0
        L_0x029d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            if (r9 != 0) goto L_0x02a4
            goto L_0x02a7
        L_0x02a4:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02a7:
            r8.setName(r7, r5)
            goto L_0x03f0
        L_0x02ac:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            if (r9 != 0) goto L_0x02b3
            goto L_0x02b6
        L_0x02b3:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02b6:
            r8.setMask(r7, r5)
            goto L_0x03f0
        L_0x02bb:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            if (r9 != 0) goto L_0x02c2
            goto L_0x02c5
        L_0x02c2:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02c5:
            r8.setHref(r7, r5)
            goto L_0x03f0
        L_0x02ca:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFill(r7, r9)
            goto L_0x03f0
        L_0x02d5:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x02e4
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setY(r7, (java.lang.String) r9)
            goto L_0x03f0
        L_0x02e4:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x02f3
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setY(r7, (java.lang.Double) r9)
            goto L_0x03f0
        L_0x02f3:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setY(r7, (java.lang.Double) r5)
            goto L_0x03f0
        L_0x02ff:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x030e
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setX(r7, (java.lang.String) r9)
            goto L_0x03f0
        L_0x030e:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x031d
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setX(r7, (java.lang.Double) r9)
            goto L_0x03f0
        L_0x031d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setX(r7, (java.lang.Double) r5)
            goto L_0x03f0
        L_0x0329:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            if (r9 != 0) goto L_0x0330
            goto L_0x0336
        L_0x0330:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x0336:
            r8.setStrokeDashoffset(r7, r0)
            goto L_0x03f0
        L_0x033b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            if (r9 != 0) goto L_0x0342
            goto L_0x0348
        L_0x0342:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0348:
            r8.setFillOpacity(r7, r4)
            goto L_0x03f0
        L_0x034d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            if (r9 != 0) goto L_0x0354
            goto L_0x0357
        L_0x0354:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0357:
            r8.setPointerEvents(r7, r5)
            goto L_0x03f0
        L_0x035c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            if (r9 != 0) goto L_0x0363
            goto L_0x0369
        L_0x0363:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0369:
            r8.setStrokeOpacity(r7, r4)
            goto L_0x03f0
        L_0x036e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            if (r9 != 0) goto L_0x0375
            goto L_0x037b
        L_0x0375:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x037b:
            r8.setFillRule(r7, r1)
            goto L_0x03f0
        L_0x0380:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setStroke(r7, r9)
            goto L_0x03f0
        L_0x038b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            if (r9 != 0) goto L_0x0392
            goto L_0x0395
        L_0x0392:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0395:
            r8.setMarkerMid(r7, r5)
            goto L_0x03f0
        L_0x0399:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            if (r9 != 0) goto L_0x03a0
            goto L_0x03a3
        L_0x03a0:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x03a3:
            r8.setMarkerEnd(r7, r5)
            goto L_0x03f0
        L_0x03a7:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setPropList(r7, r9)
            goto L_0x03f0
        L_0x03b1:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setMatrix(r7, r9)
            goto L_0x03f0
        L_0x03bb:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x03c9
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setHeight(r7, (java.lang.String) r9)
            goto L_0x03f0
        L_0x03c9:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x03d7
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setHeight(r7, (java.lang.Double) r9)
            goto L_0x03f0
        L_0x03d7:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGUseManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGUseManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setHeight(r7, (java.lang.Double) r5)
            goto L_0x03f0
        L_0x03e2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            if (r9 != 0) goto L_0x03e7
            goto L_0x03ed
        L_0x03e7:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x03ed:
            r8.setOpacity(r7, r4)
        L_0x03f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGUseManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
