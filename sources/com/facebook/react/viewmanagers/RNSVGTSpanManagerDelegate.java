package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface;

public class RNSVGTSpanManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGTSpanManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGTSpanManagerDelegate(U u) {
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
                case -1603134955: goto L_0x021c;
                case -1267206133: goto L_0x0211;
                case -1171891896: goto L_0x0206;
                case -1139902161: goto L_0x01fb;
                case -1081239615: goto L_0x01f0;
                case -993894751: goto L_0x01e5;
                case -933864895: goto L_0x01da;
                case -933857362: goto L_0x01cf;
                case -925180581: goto L_0x01c1;
                case -891980232: goto L_0x01b3;
                case -734428249: goto L_0x01a5;
                case -729118945: goto L_0x0197;
                case -416535885: goto L_0x0189;
                case -293492298: goto L_0x017b;
                case -53677816: goto L_0x016d;
                case -44578051: goto L_0x015f;
                case 120: goto L_0x0151;
                case 121: goto L_0x0143;
                case 3220: goto L_0x0135;
                case 3221: goto L_0x0127;
                case 3143043: goto L_0x0119;
                case 3148879: goto L_0x010b;
                case 3344108: goto L_0x00fd;
                case 3373707: goto L_0x00ef;
                case 78845486: goto L_0x00e1;
                case 104482996: goto L_0x00d3;
                case 217109576: goto L_0x00c5;
                case 275888445: goto L_0x00b7;
                case 365601008: goto L_0x00a9;
                case 401643183: goto L_0x009b;
                case 778043962: goto L_0x008d;
                case 917656469: goto L_0x007f;
                case 917735020: goto L_0x0071;
                case 951530617: goto L_0x0063;
                case 1027575302: goto L_0x0055;
                case 1637488243: goto L_0x0047;
                case 1671764162: goto L_0x0039;
                case 1790285174: goto L_0x002b;
                case 1847674614: goto L_0x001d;
                case 1924065902: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0226
        L_0x000f:
            java.lang.String r0 = "strokeWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x0226
        L_0x0019:
            r3 = 39
            goto L_0x0226
        L_0x001d:
            java.lang.String r0 = "responsible"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x0226
        L_0x0027:
            r3 = 38
            goto L_0x0226
        L_0x002b:
            java.lang.String r0 = "strokeLinejoin"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x0226
        L_0x0035:
            r3 = 37
            goto L_0x0226
        L_0x0039:
            java.lang.String r0 = "display"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x0226
        L_0x0043:
            r3 = 36
            goto L_0x0226
        L_0x0047:
            java.lang.String r0 = "textLength"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x0226
        L_0x0051:
            r3 = 35
            goto L_0x0226
        L_0x0055:
            java.lang.String r0 = "strokeLinecap"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x0226
        L_0x005f:
            r3 = 34
            goto L_0x0226
        L_0x0063:
            java.lang.String r0 = "content"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x006d
            goto L_0x0226
        L_0x006d:
            r3 = 33
            goto L_0x0226
        L_0x0071:
            java.lang.String r0 = "clipRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x0226
        L_0x007b:
            r3 = 32
            goto L_0x0226
        L_0x007f:
            java.lang.String r0 = "clipPath"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0089
            goto L_0x0226
        L_0x0089:
            r3 = 31
            goto L_0x0226
        L_0x008d:
            java.lang.String r0 = "inlineSize"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x0226
        L_0x0097:
            r3 = 30
            goto L_0x0226
        L_0x009b:
            java.lang.String r0 = "strokeDasharray"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x0226
        L_0x00a5:
            r3 = 29
            goto L_0x0226
        L_0x00a9:
            java.lang.String r0 = "fontSize"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x0226
        L_0x00b3:
            r3 = 28
            goto L_0x0226
        L_0x00b7:
            java.lang.String r0 = "baselineShift"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x0226
        L_0x00c1:
            r3 = 27
            goto L_0x0226
        L_0x00c5:
            java.lang.String r0 = "markerStart"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x0226
        L_0x00cf:
            r3 = 26
            goto L_0x0226
        L_0x00d3:
            java.lang.String r0 = "vectorEffect"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x0226
        L_0x00dd:
            r3 = 25
            goto L_0x0226
        L_0x00e1:
            java.lang.String r0 = "strokeMiterlimit"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x0226
        L_0x00eb:
            r3 = 24
            goto L_0x0226
        L_0x00ef:
            java.lang.String r0 = "name"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x0226
        L_0x00f9:
            r3 = 23
            goto L_0x0226
        L_0x00fd:
            java.lang.String r0 = "mask"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x0226
        L_0x0107:
            r3 = 22
            goto L_0x0226
        L_0x010b:
            java.lang.String r0 = "font"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0115
            goto L_0x0226
        L_0x0115:
            r3 = 21
            goto L_0x0226
        L_0x0119:
            java.lang.String r0 = "fill"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0123
            goto L_0x0226
        L_0x0123:
            r3 = 20
            goto L_0x0226
        L_0x0127:
            java.lang.String r0 = "dy"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0131
            goto L_0x0226
        L_0x0131:
            r3 = 19
            goto L_0x0226
        L_0x0135:
            java.lang.String r0 = "dx"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x013f
            goto L_0x0226
        L_0x013f:
            r3 = 18
            goto L_0x0226
        L_0x0143:
            java.lang.String r0 = "y"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x014d
            goto L_0x0226
        L_0x014d:
            r3 = 17
            goto L_0x0226
        L_0x0151:
            java.lang.String r0 = "x"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x015b
            goto L_0x0226
        L_0x015b:
            r3 = 16
            goto L_0x0226
        L_0x015f:
            java.lang.String r0 = "strokeDashoffset"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0169
            goto L_0x0226
        L_0x0169:
            r3 = 15
            goto L_0x0226
        L_0x016d:
            java.lang.String r0 = "fillOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0177
            goto L_0x0226
        L_0x0177:
            r3 = 14
            goto L_0x0226
        L_0x017b:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0185
            goto L_0x0226
        L_0x0185:
            r3 = 13
            goto L_0x0226
        L_0x0189:
            java.lang.String r0 = "strokeOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0193
            goto L_0x0226
        L_0x0193:
            r3 = 12
            goto L_0x0226
        L_0x0197:
            java.lang.String r0 = "fillRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01a1
            goto L_0x0226
        L_0x01a1:
            r3 = 11
            goto L_0x0226
        L_0x01a5:
            java.lang.String r0 = "fontWeight"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01af
            goto L_0x0226
        L_0x01af:
            r3 = 10
            goto L_0x0226
        L_0x01b3:
            java.lang.String r0 = "stroke"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01bd
            goto L_0x0226
        L_0x01bd:
            r3 = 9
            goto L_0x0226
        L_0x01c1:
            java.lang.String r0 = "rotate"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01cb
            goto L_0x0226
        L_0x01cb:
            r3 = 8
            goto L_0x0226
        L_0x01cf:
            java.lang.String r0 = "markerMid"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01d8
            goto L_0x0226
        L_0x01d8:
            r3 = 7
            goto L_0x0226
        L_0x01da:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01e3
            goto L_0x0226
        L_0x01e3:
            r3 = 6
            goto L_0x0226
        L_0x01e5:
            java.lang.String r0 = "propList"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01ee
            goto L_0x0226
        L_0x01ee:
            r3 = 5
            goto L_0x0226
        L_0x01f0:
            java.lang.String r0 = "matrix"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01f9
            goto L_0x0226
        L_0x01f9:
            r3 = 4
            goto L_0x0226
        L_0x01fb:
            java.lang.String r0 = "verticalAlign"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0204
            goto L_0x0226
        L_0x0204:
            r3 = 3
            goto L_0x0226
        L_0x0206:
            java.lang.String r0 = "alignmentBaseline"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x020f
            goto L_0x0226
        L_0x020f:
            r3 = 2
            goto L_0x0226
        L_0x0211:
            java.lang.String r0 = "opacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x021a
            goto L_0x0226
        L_0x021a:
            r3 = r1
            goto L_0x0226
        L_0x021c:
            java.lang.String r0 = "lengthAdjust"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0225
            goto L_0x0226
        L_0x0225:
            r3 = r2
        L_0x0226:
            r0 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            switch(r3) {
                case 0: goto L_0x0508;
                case 1: goto L_0x04f9;
                case 2: goto L_0x04eb;
                case 3: goto L_0x04dd;
                case 4: goto L_0x04d3;
                case 5: goto L_0x04c9;
                case 6: goto L_0x04bb;
                case 7: goto L_0x04ad;
                case 8: goto L_0x04a2;
                case 9: goto L_0x0497;
                case 10: goto L_0x046d;
                case 11: goto L_0x045b;
                case 12: goto L_0x0449;
                case 13: goto L_0x043a;
                case 14: goto L_0x0428;
                case 15: goto L_0x0416;
                case 16: goto L_0x040b;
                case 17: goto L_0x0400;
                case 18: goto L_0x03f5;
                case 19: goto L_0x03ea;
                case 20: goto L_0x03df;
                case 21: goto L_0x03d4;
                case 22: goto L_0x03c5;
                case 23: goto L_0x03b6;
                case 24: goto L_0x03a4;
                case 25: goto L_0x0392;
                case 26: goto L_0x0383;
                case 27: goto L_0x0359;
                case 28: goto L_0x032f;
                case 29: goto L_0x0324;
                case 30: goto L_0x02fa;
                case 31: goto L_0x02eb;
                case 32: goto L_0x02d9;
                case 33: goto L_0x02ca;
                case 34: goto L_0x02b8;
                case 35: goto L_0x028e;
                case 36: goto L_0x027f;
                case 37: goto L_0x026d;
                case 38: goto L_0x025b;
                case 39: goto L_0x0232;
                default: goto L_0x022d;
            }
        L_0x022d:
            super.setProperty(r7, r8, r9)
            goto L_0x0515
        L_0x0232:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x0241
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setStrokeWidth(r7, (java.lang.String) r9)
            goto L_0x0515
        L_0x0241:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x0250
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setStrokeWidth(r7, (java.lang.Double) r9)
            goto L_0x0515
        L_0x0250:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            java.lang.String r9 = "1"
            r8.setStrokeWidth(r7, (java.lang.String) r9)
            goto L_0x0515
        L_0x025b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x0262
            goto L_0x0268
        L_0x0262:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x0268:
            r8.setResponsible(r7, r2)
            goto L_0x0515
        L_0x026d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x0274
            goto L_0x027a
        L_0x0274:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x027a:
            r8.setStrokeLinejoin(r7, r2)
            goto L_0x0515
        L_0x027f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x0286
            goto L_0x0289
        L_0x0286:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0289:
            r8.setDisplay(r7, r5)
            goto L_0x0515
        L_0x028e:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x029d
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setTextLength(r7, (java.lang.String) r9)
            goto L_0x0515
        L_0x029d:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x02ac
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setTextLength(r7, (java.lang.Double) r9)
            goto L_0x0515
        L_0x02ac:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setTextLength(r7, (java.lang.Double) r5)
            goto L_0x0515
        L_0x02b8:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x02bf
            goto L_0x02c5
        L_0x02bf:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x02c5:
            r8.setStrokeLinecap(r7, r2)
            goto L_0x0515
        L_0x02ca:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x02d1
            goto L_0x02d4
        L_0x02d1:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02d4:
            r8.setContent(r7, r5)
            goto L_0x0515
        L_0x02d9:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x02e0
            goto L_0x02e6
        L_0x02e0:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x02e6:
            r8.setClipRule(r7, r2)
            goto L_0x0515
        L_0x02eb:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x02f2
            goto L_0x02f5
        L_0x02f2:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02f5:
            r8.setClipPath(r7, r5)
            goto L_0x0515
        L_0x02fa:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x0309
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setInlineSize(r7, (java.lang.String) r9)
            goto L_0x0515
        L_0x0309:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x0318
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setInlineSize(r7, (java.lang.Double) r9)
            goto L_0x0515
        L_0x0318:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setInlineSize(r7, (java.lang.Double) r5)
            goto L_0x0515
        L_0x0324:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setStrokeDasharray(r7, r9)
            goto L_0x0515
        L_0x032f:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x033e
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setFontSize(r7, (java.lang.String) r9)
            goto L_0x0515
        L_0x033e:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x034d
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontSize(r7, (java.lang.Double) r9)
            goto L_0x0515
        L_0x034d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontSize(r7, (java.lang.Double) r5)
            goto L_0x0515
        L_0x0359:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x0368
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setBaselineShift(r7, (java.lang.String) r9)
            goto L_0x0515
        L_0x0368:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x0377
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setBaselineShift(r7, (java.lang.Double) r9)
            goto L_0x0515
        L_0x0377:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setBaselineShift(r7, (java.lang.Double) r5)
            goto L_0x0515
        L_0x0383:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x038a
            goto L_0x038d
        L_0x038a:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x038d:
            r8.setMarkerStart(r7, r5)
            goto L_0x0515
        L_0x0392:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x0399
            goto L_0x039f
        L_0x0399:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x039f:
            r8.setVectorEffect(r7, r2)
            goto L_0x0515
        L_0x03a4:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x03ab
            goto L_0x03b1
        L_0x03ab:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x03b1:
            r8.setStrokeMiterlimit(r7, r0)
            goto L_0x0515
        L_0x03b6:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x03bd
            goto L_0x03c0
        L_0x03bd:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x03c0:
            r8.setName(r7, r5)
            goto L_0x0515
        L_0x03c5:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x03cc
            goto L_0x03cf
        L_0x03cc:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x03cf:
            r8.setMask(r7, r5)
            goto L_0x0515
        L_0x03d4:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFont(r7, r9)
            goto L_0x0515
        L_0x03df:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFill(r7, r9)
            goto L_0x0515
        L_0x03ea:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setDy(r7, r9)
            goto L_0x0515
        L_0x03f5:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setDx(r7, r9)
            goto L_0x0515
        L_0x0400:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setY(r7, r9)
            goto L_0x0515
        L_0x040b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setX(r7, r9)
            goto L_0x0515
        L_0x0416:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x041d
            goto L_0x0423
        L_0x041d:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x0423:
            r8.setStrokeDashoffset(r7, r0)
            goto L_0x0515
        L_0x0428:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x042f
            goto L_0x0435
        L_0x042f:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0435:
            r8.setFillOpacity(r7, r4)
            goto L_0x0515
        L_0x043a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x0441
            goto L_0x0444
        L_0x0441:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0444:
            r8.setPointerEvents(r7, r5)
            goto L_0x0515
        L_0x0449:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x0450
            goto L_0x0456
        L_0x0450:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0456:
            r8.setStrokeOpacity(r7, r4)
            goto L_0x0515
        L_0x045b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x0462
            goto L_0x0468
        L_0x0462:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x0468:
            r8.setFillRule(r7, r1)
            goto L_0x0515
        L_0x046d:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x047c
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setFontWeight(r7, (java.lang.String) r9)
            goto L_0x0515
        L_0x047c:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x048b
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontWeight(r7, (java.lang.Double) r9)
            goto L_0x0515
        L_0x048b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontWeight(r7, (java.lang.Double) r5)
            goto L_0x0515
        L_0x0497:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setStroke(r7, r9)
            goto L_0x0515
        L_0x04a2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setRotate(r7, r9)
            goto L_0x0515
        L_0x04ad:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x04b4
            goto L_0x04b7
        L_0x04b4:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x04b7:
            r8.setMarkerMid(r7, r5)
            goto L_0x0515
        L_0x04bb:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x04c2
            goto L_0x04c5
        L_0x04c2:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x04c5:
            r8.setMarkerEnd(r7, r5)
            goto L_0x0515
        L_0x04c9:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setPropList(r7, r9)
            goto L_0x0515
        L_0x04d3:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setMatrix(r7, r9)
            goto L_0x0515
        L_0x04dd:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x04e4
            goto L_0x04e7
        L_0x04e4:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x04e7:
            r8.setVerticalAlign(r7, r5)
            goto L_0x0515
        L_0x04eb:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x04f2
            goto L_0x04f5
        L_0x04f2:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x04f5:
            r8.setAlignmentBaseline(r7, r5)
            goto L_0x0515
        L_0x04f9:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            if (r9 != 0) goto L_0x04fe
            goto L_0x0504
        L_0x04fe:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0504:
            r8.setOpacity(r7, r4)
            goto L_0x0515
        L_0x0508:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x050f
            goto L_0x0512
        L_0x050f:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0512:
            r8.setLengthAdjust(r7, r5)
        L_0x0515:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGTSpanManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
