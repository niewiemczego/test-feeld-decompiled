package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGTextManagerInterface;

public class RNSVGTextManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGTextManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGTextManagerDelegate(U u) {
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
                case -1603134955: goto L_0x020e;
                case -1267206133: goto L_0x0203;
                case -1171891896: goto L_0x01f8;
                case -1139902161: goto L_0x01ed;
                case -1081239615: goto L_0x01e2;
                case -993894751: goto L_0x01d7;
                case -933864895: goto L_0x01cc;
                case -933857362: goto L_0x01c1;
                case -925180581: goto L_0x01b3;
                case -891980232: goto L_0x01a5;
                case -734428249: goto L_0x0197;
                case -729118945: goto L_0x0189;
                case -416535885: goto L_0x017b;
                case -293492298: goto L_0x016d;
                case -53677816: goto L_0x015f;
                case -44578051: goto L_0x0151;
                case 120: goto L_0x0143;
                case 121: goto L_0x0135;
                case 3220: goto L_0x0127;
                case 3221: goto L_0x0119;
                case 3143043: goto L_0x010b;
                case 3148879: goto L_0x00fd;
                case 3344108: goto L_0x00ef;
                case 3373707: goto L_0x00e1;
                case 78845486: goto L_0x00d3;
                case 104482996: goto L_0x00c5;
                case 217109576: goto L_0x00b7;
                case 275888445: goto L_0x00a9;
                case 365601008: goto L_0x009b;
                case 401643183: goto L_0x008d;
                case 778043962: goto L_0x007f;
                case 917656469: goto L_0x0071;
                case 917735020: goto L_0x0063;
                case 1027575302: goto L_0x0055;
                case 1637488243: goto L_0x0047;
                case 1671764162: goto L_0x0039;
                case 1790285174: goto L_0x002b;
                case 1847674614: goto L_0x001d;
                case 1924065902: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0218
        L_0x000f:
            java.lang.String r0 = "strokeWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x0218
        L_0x0019:
            r3 = 38
            goto L_0x0218
        L_0x001d:
            java.lang.String r0 = "responsible"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x0218
        L_0x0027:
            r3 = 37
            goto L_0x0218
        L_0x002b:
            java.lang.String r0 = "strokeLinejoin"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x0218
        L_0x0035:
            r3 = 36
            goto L_0x0218
        L_0x0039:
            java.lang.String r0 = "display"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x0218
        L_0x0043:
            r3 = 35
            goto L_0x0218
        L_0x0047:
            java.lang.String r0 = "textLength"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x0218
        L_0x0051:
            r3 = 34
            goto L_0x0218
        L_0x0055:
            java.lang.String r0 = "strokeLinecap"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x0218
        L_0x005f:
            r3 = 33
            goto L_0x0218
        L_0x0063:
            java.lang.String r0 = "clipRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x006d
            goto L_0x0218
        L_0x006d:
            r3 = 32
            goto L_0x0218
        L_0x0071:
            java.lang.String r0 = "clipPath"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x0218
        L_0x007b:
            r3 = 31
            goto L_0x0218
        L_0x007f:
            java.lang.String r0 = "inlineSize"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0089
            goto L_0x0218
        L_0x0089:
            r3 = 30
            goto L_0x0218
        L_0x008d:
            java.lang.String r0 = "strokeDasharray"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x0218
        L_0x0097:
            r3 = 29
            goto L_0x0218
        L_0x009b:
            java.lang.String r0 = "fontSize"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x0218
        L_0x00a5:
            r3 = 28
            goto L_0x0218
        L_0x00a9:
            java.lang.String r0 = "baselineShift"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x0218
        L_0x00b3:
            r3 = 27
            goto L_0x0218
        L_0x00b7:
            java.lang.String r0 = "markerStart"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x0218
        L_0x00c1:
            r3 = 26
            goto L_0x0218
        L_0x00c5:
            java.lang.String r0 = "vectorEffect"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x0218
        L_0x00cf:
            r3 = 25
            goto L_0x0218
        L_0x00d3:
            java.lang.String r0 = "strokeMiterlimit"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x0218
        L_0x00dd:
            r3 = 24
            goto L_0x0218
        L_0x00e1:
            java.lang.String r0 = "name"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x0218
        L_0x00eb:
            r3 = 23
            goto L_0x0218
        L_0x00ef:
            java.lang.String r0 = "mask"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x0218
        L_0x00f9:
            r3 = 22
            goto L_0x0218
        L_0x00fd:
            java.lang.String r0 = "font"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x0218
        L_0x0107:
            r3 = 21
            goto L_0x0218
        L_0x010b:
            java.lang.String r0 = "fill"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0115
            goto L_0x0218
        L_0x0115:
            r3 = 20
            goto L_0x0218
        L_0x0119:
            java.lang.String r0 = "dy"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0123
            goto L_0x0218
        L_0x0123:
            r3 = 19
            goto L_0x0218
        L_0x0127:
            java.lang.String r0 = "dx"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0131
            goto L_0x0218
        L_0x0131:
            r3 = 18
            goto L_0x0218
        L_0x0135:
            java.lang.String r0 = "y"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x013f
            goto L_0x0218
        L_0x013f:
            r3 = 17
            goto L_0x0218
        L_0x0143:
            java.lang.String r0 = "x"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x014d
            goto L_0x0218
        L_0x014d:
            r3 = 16
            goto L_0x0218
        L_0x0151:
            java.lang.String r0 = "strokeDashoffset"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x015b
            goto L_0x0218
        L_0x015b:
            r3 = 15
            goto L_0x0218
        L_0x015f:
            java.lang.String r0 = "fillOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0169
            goto L_0x0218
        L_0x0169:
            r3 = 14
            goto L_0x0218
        L_0x016d:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0177
            goto L_0x0218
        L_0x0177:
            r3 = 13
            goto L_0x0218
        L_0x017b:
            java.lang.String r0 = "strokeOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0185
            goto L_0x0218
        L_0x0185:
            r3 = 12
            goto L_0x0218
        L_0x0189:
            java.lang.String r0 = "fillRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0193
            goto L_0x0218
        L_0x0193:
            r3 = 11
            goto L_0x0218
        L_0x0197:
            java.lang.String r0 = "fontWeight"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01a1
            goto L_0x0218
        L_0x01a1:
            r3 = 10
            goto L_0x0218
        L_0x01a5:
            java.lang.String r0 = "stroke"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01af
            goto L_0x0218
        L_0x01af:
            r3 = 9
            goto L_0x0218
        L_0x01b3:
            java.lang.String r0 = "rotate"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01bd
            goto L_0x0218
        L_0x01bd:
            r3 = 8
            goto L_0x0218
        L_0x01c1:
            java.lang.String r0 = "markerMid"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01ca
            goto L_0x0218
        L_0x01ca:
            r3 = 7
            goto L_0x0218
        L_0x01cc:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01d5
            goto L_0x0218
        L_0x01d5:
            r3 = 6
            goto L_0x0218
        L_0x01d7:
            java.lang.String r0 = "propList"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01e0
            goto L_0x0218
        L_0x01e0:
            r3 = 5
            goto L_0x0218
        L_0x01e2:
            java.lang.String r0 = "matrix"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01eb
            goto L_0x0218
        L_0x01eb:
            r3 = 4
            goto L_0x0218
        L_0x01ed:
            java.lang.String r0 = "verticalAlign"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01f6
            goto L_0x0218
        L_0x01f6:
            r3 = 3
            goto L_0x0218
        L_0x01f8:
            java.lang.String r0 = "alignmentBaseline"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0201
            goto L_0x0218
        L_0x0201:
            r3 = 2
            goto L_0x0218
        L_0x0203:
            java.lang.String r0 = "opacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x020c
            goto L_0x0218
        L_0x020c:
            r3 = r1
            goto L_0x0218
        L_0x020e:
            java.lang.String r0 = "lengthAdjust"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0217
            goto L_0x0218
        L_0x0217:
            r3 = r2
        L_0x0218:
            r0 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            switch(r3) {
                case 0: goto L_0x04eb;
                case 1: goto L_0x04dc;
                case 2: goto L_0x04ce;
                case 3: goto L_0x04c0;
                case 4: goto L_0x04b6;
                case 5: goto L_0x04ac;
                case 6: goto L_0x049e;
                case 7: goto L_0x0490;
                case 8: goto L_0x0485;
                case 9: goto L_0x047a;
                case 10: goto L_0x0450;
                case 11: goto L_0x043e;
                case 12: goto L_0x042c;
                case 13: goto L_0x041d;
                case 14: goto L_0x040b;
                case 15: goto L_0x03f9;
                case 16: goto L_0x03ee;
                case 17: goto L_0x03e3;
                case 18: goto L_0x03d8;
                case 19: goto L_0x03cd;
                case 20: goto L_0x03c2;
                case 21: goto L_0x03b7;
                case 22: goto L_0x03a8;
                case 23: goto L_0x0399;
                case 24: goto L_0x0387;
                case 25: goto L_0x0375;
                case 26: goto L_0x0366;
                case 27: goto L_0x033c;
                case 28: goto L_0x0312;
                case 29: goto L_0x0307;
                case 30: goto L_0x02dd;
                case 31: goto L_0x02ce;
                case 32: goto L_0x02bc;
                case 33: goto L_0x02aa;
                case 34: goto L_0x0280;
                case 35: goto L_0x0271;
                case 36: goto L_0x025f;
                case 37: goto L_0x024d;
                case 38: goto L_0x0224;
                default: goto L_0x021f;
            }
        L_0x021f:
            super.setProperty(r7, r8, r9)
            goto L_0x04f8
        L_0x0224:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x0233
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setStrokeWidth(r7, (java.lang.String) r9)
            goto L_0x04f8
        L_0x0233:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x0242
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setStrokeWidth(r7, (java.lang.Double) r9)
            goto L_0x04f8
        L_0x0242:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            java.lang.String r9 = "1"
            r8.setStrokeWidth(r7, (java.lang.String) r9)
            goto L_0x04f8
        L_0x024d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0254
            goto L_0x025a
        L_0x0254:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x025a:
            r8.setResponsible(r7, r2)
            goto L_0x04f8
        L_0x025f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0266
            goto L_0x026c
        L_0x0266:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x026c:
            r8.setStrokeLinejoin(r7, r2)
            goto L_0x04f8
        L_0x0271:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0278
            goto L_0x027b
        L_0x0278:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x027b:
            r8.setDisplay(r7, r5)
            goto L_0x04f8
        L_0x0280:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x028f
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setTextLength(r7, (java.lang.String) r9)
            goto L_0x04f8
        L_0x028f:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x029e
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setTextLength(r7, (java.lang.Double) r9)
            goto L_0x04f8
        L_0x029e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setTextLength(r7, (java.lang.Double) r5)
            goto L_0x04f8
        L_0x02aa:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x02b1
            goto L_0x02b7
        L_0x02b1:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x02b7:
            r8.setStrokeLinecap(r7, r2)
            goto L_0x04f8
        L_0x02bc:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x02c3
            goto L_0x02c9
        L_0x02c3:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x02c9:
            r8.setClipRule(r7, r2)
            goto L_0x04f8
        L_0x02ce:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x02d5
            goto L_0x02d8
        L_0x02d5:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02d8:
            r8.setClipPath(r7, r5)
            goto L_0x04f8
        L_0x02dd:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x02ec
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setInlineSize(r7, (java.lang.String) r9)
            goto L_0x04f8
        L_0x02ec:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x02fb
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setInlineSize(r7, (java.lang.Double) r9)
            goto L_0x04f8
        L_0x02fb:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setInlineSize(r7, (java.lang.Double) r5)
            goto L_0x04f8
        L_0x0307:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setStrokeDasharray(r7, r9)
            goto L_0x04f8
        L_0x0312:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x0321
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setFontSize(r7, (java.lang.String) r9)
            goto L_0x04f8
        L_0x0321:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x0330
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontSize(r7, (java.lang.Double) r9)
            goto L_0x04f8
        L_0x0330:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontSize(r7, (java.lang.Double) r5)
            goto L_0x04f8
        L_0x033c:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x034b
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setBaselineShift(r7, (java.lang.String) r9)
            goto L_0x04f8
        L_0x034b:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x035a
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setBaselineShift(r7, (java.lang.Double) r9)
            goto L_0x04f8
        L_0x035a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setBaselineShift(r7, (java.lang.Double) r5)
            goto L_0x04f8
        L_0x0366:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x036d
            goto L_0x0370
        L_0x036d:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0370:
            r8.setMarkerStart(r7, r5)
            goto L_0x04f8
        L_0x0375:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x037c
            goto L_0x0382
        L_0x037c:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0382:
            r8.setVectorEffect(r7, r2)
            goto L_0x04f8
        L_0x0387:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x038e
            goto L_0x0394
        L_0x038e:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x0394:
            r8.setStrokeMiterlimit(r7, r0)
            goto L_0x04f8
        L_0x0399:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x03a0
            goto L_0x03a3
        L_0x03a0:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x03a3:
            r8.setName(r7, r5)
            goto L_0x04f8
        L_0x03a8:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x03af
            goto L_0x03b2
        L_0x03af:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x03b2:
            r8.setMask(r7, r5)
            goto L_0x04f8
        L_0x03b7:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFont(r7, r9)
            goto L_0x04f8
        L_0x03c2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFill(r7, r9)
            goto L_0x04f8
        L_0x03cd:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setDy(r7, r9)
            goto L_0x04f8
        L_0x03d8:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setDx(r7, r9)
            goto L_0x04f8
        L_0x03e3:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setY(r7, r9)
            goto L_0x04f8
        L_0x03ee:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setX(r7, r9)
            goto L_0x04f8
        L_0x03f9:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0400
            goto L_0x0406
        L_0x0400:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x0406:
            r8.setStrokeDashoffset(r7, r0)
            goto L_0x04f8
        L_0x040b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0412
            goto L_0x0418
        L_0x0412:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0418:
            r8.setFillOpacity(r7, r4)
            goto L_0x04f8
        L_0x041d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0424
            goto L_0x0427
        L_0x0424:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0427:
            r8.setPointerEvents(r7, r5)
            goto L_0x04f8
        L_0x042c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0433
            goto L_0x0439
        L_0x0433:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0439:
            r8.setStrokeOpacity(r7, r4)
            goto L_0x04f8
        L_0x043e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0445
            goto L_0x044b
        L_0x0445:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x044b:
            r8.setFillRule(r7, r1)
            goto L_0x04f8
        L_0x0450:
            boolean r8 = r9 instanceof java.lang.String
            if (r8 == 0) goto L_0x045f
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setFontWeight(r7, (java.lang.String) r9)
            goto L_0x04f8
        L_0x045f:
            boolean r8 = r9 instanceof java.lang.Double
            if (r8 == 0) goto L_0x046e
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontWeight(r7, (java.lang.Double) r9)
            goto L_0x04f8
        L_0x046e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            r9 = r5
            java.lang.Double r9 = (java.lang.Double) r9
            r8.setFontWeight(r7, (java.lang.Double) r5)
            goto L_0x04f8
        L_0x047a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setStroke(r7, r9)
            goto L_0x04f8
        L_0x0485:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setRotate(r7, r9)
            goto L_0x04f8
        L_0x0490:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0497
            goto L_0x049a
        L_0x0497:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x049a:
            r8.setMarkerMid(r7, r5)
            goto L_0x04f8
        L_0x049e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x04a5
            goto L_0x04a8
        L_0x04a5:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x04a8:
            r8.setMarkerEnd(r7, r5)
            goto L_0x04f8
        L_0x04ac:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setPropList(r7, r9)
            goto L_0x04f8
        L_0x04b6:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setMatrix(r7, r9)
            goto L_0x04f8
        L_0x04c0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x04c7
            goto L_0x04ca
        L_0x04c7:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x04ca:
            r8.setVerticalAlign(r7, r5)
            goto L_0x04f8
        L_0x04ce:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x04d5
            goto L_0x04d8
        L_0x04d5:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x04d8:
            r8.setAlignmentBaseline(r7, r5)
            goto L_0x04f8
        L_0x04dc:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            if (r9 != 0) goto L_0x04e1
            goto L_0x04e7
        L_0x04e1:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x04e7:
            r8.setOpacity(r7, r4)
            goto L_0x04f8
        L_0x04eb:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x04f2
            goto L_0x04f5
        L_0x04f2:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x04f5:
            r8.setLengthAdjust(r7, r5)
        L_0x04f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGTextManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
