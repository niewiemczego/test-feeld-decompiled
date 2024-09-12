package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface;

public class RNSVGSvgViewAndroidManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGSvgViewAndroidManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGSvgViewAndroidManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v33, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r8, java.lang.String r9, java.lang.Object r10) {
        /*
            r7 = this;
            r9.hashCode()
            int r0 = r9.hashCode()
            r1 = 0
            r2 = -1
            switch(r0) {
                case -2064426617: goto L_0x0237;
                case -1989576717: goto L_0x022c;
                case -1697814026: goto L_0x0221;
                case -1567958285: goto L_0x0216;
                case -1470826662: goto L_0x020b;
                case -1308858324: goto L_0x0200;
                case -1228066334: goto L_0x01f5;
                case -1141400650: goto L_0x01ea;
                case -1122140597: goto L_0x01dc;
                case -867333731: goto L_0x01ce;
                case -679581037: goto L_0x01c0;
                case -631506969: goto L_0x01b2;
                case -631278772: goto L_0x01a4;
                case -483490364: goto L_0x0196;
                case -329721498: goto L_0x0188;
                case -293492298: goto L_0x017a;
                case -252105751: goto L_0x016c;
                case -242276144: goto L_0x015e;
                case -148030058: goto L_0x0150;
                case -109689771: goto L_0x0142;
                case 3351622: goto L_0x0134;
                case 3351623: goto L_0x0126;
                case 92903173: goto L_0x0118;
                case 94842723: goto L_0x010a;
                case 240482938: goto L_0x00fc;
                case 333432965: goto L_0x00ee;
                case 503397728: goto L_0x00e0;
                case 581268560: goto L_0x00d2;
                case 588239831: goto L_0x00c4;
                case 660795168: goto L_0x00b6;
                case 722830999: goto L_0x00a8;
                case 737768677: goto L_0x009a;
                case 926871597: goto L_0x008c;
                case 1220735892: goto L_0x007e;
                case 1327599912: goto L_0x0070;
                case 1349188574: goto L_0x0062;
                case 1629011506: goto L_0x0054;
                case 1667773924: goto L_0x0046;
                case 1747724810: goto L_0x0038;
                case 1908075304: goto L_0x002a;
                case 1910855543: goto L_0x001c;
                case 2119889261: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0241
        L_0x000e:
            java.lang.String r0 = "borderStartColor"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0018
            goto L_0x0241
        L_0x0018:
            r2 = 41
            goto L_0x0241
        L_0x001c:
            java.lang.String r0 = "nextFocusRight"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0026
            goto L_0x0241
        L_0x0026:
            r2 = 40
            goto L_0x0241
        L_0x002a:
            java.lang.String r0 = "meetOrSlice"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0034
            goto L_0x0241
        L_0x0034:
            r2 = 39
            goto L_0x0241
        L_0x0038:
            java.lang.String r0 = "nativeBackgroundAndroid"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0042
            goto L_0x0241
        L_0x0042:
            r2 = 38
            goto L_0x0241
        L_0x0046:
            java.lang.String r0 = "needsOffscreenAlphaCompositing"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0050
            goto L_0x0241
        L_0x0050:
            r2 = 37
            goto L_0x0241
        L_0x0054:
            java.lang.String r0 = "focusable"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x005e
            goto L_0x0241
        L_0x005e:
            r2 = 36
            goto L_0x0241
        L_0x0062:
            java.lang.String r0 = "borderRadius"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x006c
            goto L_0x0241
        L_0x006c:
            r2 = 35
            goto L_0x0241
        L_0x0070:
            java.lang.String r0 = "tintColor"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x007a
            goto L_0x0241
        L_0x007a:
            r2 = 34
            goto L_0x0241
        L_0x007e:
            java.lang.String r0 = "borderEndColor"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0088
            goto L_0x0241
        L_0x0088:
            r2 = 33
            goto L_0x0241
        L_0x008c:
            java.lang.String r0 = "hitSlop"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0096
            goto L_0x0241
        L_0x0096:
            r2 = 32
            goto L_0x0241
        L_0x009a:
            java.lang.String r0 = "borderStyle"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x00a4
            goto L_0x0241
        L_0x00a4:
            r2 = 31
            goto L_0x0241
        L_0x00a8:
            java.lang.String r0 = "borderColor"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x00b2
            goto L_0x0241
        L_0x00b2:
            r2 = 30
            goto L_0x0241
        L_0x00b6:
            java.lang.String r0 = "nextFocusUp"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x00c0
            goto L_0x0241
        L_0x00c0:
            r2 = 29
            goto L_0x0241
        L_0x00c4:
            java.lang.String r0 = "borderBottomRightRadius"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x00ce
            goto L_0x0241
        L_0x00ce:
            r2 = 28
            goto L_0x0241
        L_0x00d2:
            java.lang.String r0 = "borderBottomLeftRadius"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x00dc
            goto L_0x0241
        L_0x00dc:
            r2 = 27
            goto L_0x0241
        L_0x00e0:
            java.lang.String r0 = "nextFocusForward"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x00ea
            goto L_0x0241
        L_0x00ea:
            r2 = 26
            goto L_0x0241
        L_0x00ee:
            java.lang.String r0 = "borderTopRightRadius"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x00f8
            goto L_0x0241
        L_0x00f8:
            r2 = 25
            goto L_0x0241
        L_0x00fc:
            java.lang.String r0 = "vbWidth"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0106
            goto L_0x0241
        L_0x0106:
            r2 = 24
            goto L_0x0241
        L_0x010a:
            java.lang.String r0 = "color"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0114
            goto L_0x0241
        L_0x0114:
            r2 = 23
            goto L_0x0241
        L_0x0118:
            java.lang.String r0 = "align"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0122
            goto L_0x0241
        L_0x0122:
            r2 = 22
            goto L_0x0241
        L_0x0126:
            java.lang.String r0 = "minY"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0130
            goto L_0x0241
        L_0x0130:
            r2 = 21
            goto L_0x0241
        L_0x0134:
            java.lang.String r0 = "minX"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x013e
            goto L_0x0241
        L_0x013e:
            r2 = 20
            goto L_0x0241
        L_0x0142:
            java.lang.String r0 = "nativeForegroundAndroid"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x014c
            goto L_0x0241
        L_0x014c:
            r2 = 19
            goto L_0x0241
        L_0x0150:
            java.lang.String r0 = "borderBottomEndRadius"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x015a
            goto L_0x0241
        L_0x015a:
            r2 = 18
            goto L_0x0241
        L_0x015e:
            java.lang.String r0 = "borderLeftColor"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0168
            goto L_0x0241
        L_0x0168:
            r2 = 17
            goto L_0x0241
        L_0x016c:
            java.lang.String r0 = "removeClippedSubviews"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0176
            goto L_0x0241
        L_0x0176:
            r2 = 16
            goto L_0x0241
        L_0x017a:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0184
            goto L_0x0241
        L_0x0184:
            r2 = 15
            goto L_0x0241
        L_0x0188:
            java.lang.String r0 = "bbWidth"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0192
            goto L_0x0241
        L_0x0192:
            r2 = 14
            goto L_0x0241
        L_0x0196:
            java.lang.String r0 = "borderTopEndRadius"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x01a0
            goto L_0x0241
        L_0x01a0:
            r2 = 13
            goto L_0x0241
        L_0x01a4:
            java.lang.String r0 = "nextFocusLeft"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x01ae
            goto L_0x0241
        L_0x01ae:
            r2 = 12
            goto L_0x0241
        L_0x01b2:
            java.lang.String r0 = "nextFocusDown"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x01bc
            goto L_0x0241
        L_0x01bc:
            r2 = 11
            goto L_0x0241
        L_0x01c0:
            java.lang.String r0 = "hasTVPreferredFocus"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x01ca
            goto L_0x0241
        L_0x01ca:
            r2 = 10
            goto L_0x0241
        L_0x01ce:
            java.lang.String r0 = "borderBottomStartRadius"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x01d8
            goto L_0x0241
        L_0x01d8:
            r2 = 9
            goto L_0x0241
        L_0x01dc:
            java.lang.String r0 = "borderTopStartRadius"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x01e6
            goto L_0x0241
        L_0x01e6:
            r2 = 8
            goto L_0x0241
        L_0x01ea:
            java.lang.String r0 = "accessible"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x01f3
            goto L_0x0241
        L_0x01f3:
            r2 = 7
            goto L_0x0241
        L_0x01f5:
            java.lang.String r0 = "borderTopLeftRadius"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x01fe
            goto L_0x0241
        L_0x01fe:
            r2 = 6
            goto L_0x0241
        L_0x0200:
            java.lang.String r0 = "borderBottomColor"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0209
            goto L_0x0241
        L_0x0209:
            r2 = 5
            goto L_0x0241
        L_0x020b:
            java.lang.String r0 = "borderTopColor"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0214
            goto L_0x0241
        L_0x0214:
            r2 = 4
            goto L_0x0241
        L_0x0216:
            java.lang.String r0 = "vbHeight"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x021f
            goto L_0x0241
        L_0x021f:
            r2 = 3
            goto L_0x0241
        L_0x0221:
            java.lang.String r0 = "backfaceVisibility"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x022a
            goto L_0x0241
        L_0x022a:
            r2 = 2
            goto L_0x0241
        L_0x022c:
            java.lang.String r0 = "borderRightColor"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0235
            goto L_0x0241
        L_0x0235:
            r2 = 1
            goto L_0x0241
        L_0x0237:
            java.lang.String r0 = "bbHeight"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0240
            goto L_0x0241
        L_0x0240:
            r2 = r1
        L_0x0241:
            r0 = 0
            r3 = 2143289344(0x7fc00000, float:NaN)
            r4 = 0
            r6 = 0
            switch(r2) {
                case 0: goto L_0x051a;
                case 1: goto L_0x050a;
                case 2: goto L_0x04fc;
                case 3: goto L_0x04eb;
                case 4: goto L_0x04db;
                case 5: goto L_0x04cb;
                case 6: goto L_0x04b9;
                case 7: goto L_0x04a7;
                case 8: goto L_0x0495;
                case 9: goto L_0x0483;
                case 10: goto L_0x0471;
                case 11: goto L_0x045f;
                case 12: goto L_0x044d;
                case 13: goto L_0x043b;
                case 14: goto L_0x0411;
                case 15: goto L_0x0402;
                case 16: goto L_0x03f0;
                case 17: goto L_0x03df;
                case 18: goto L_0x03cd;
                case 19: goto L_0x03c2;
                case 20: goto L_0x03b0;
                case 21: goto L_0x039e;
                case 22: goto L_0x038f;
                case 23: goto L_0x037e;
                case 24: goto L_0x036c;
                case 25: goto L_0x035a;
                case 26: goto L_0x0348;
                case 27: goto L_0x0336;
                case 28: goto L_0x0324;
                case 29: goto L_0x0312;
                case 30: goto L_0x0301;
                case 31: goto L_0x02f2;
                case 32: goto L_0x02e7;
                case 33: goto L_0x02d6;
                case 34: goto L_0x02c5;
                case 35: goto L_0x02b3;
                case 36: goto L_0x02a1;
                case 37: goto L_0x028f;
                case 38: goto L_0x0284;
                case 39: goto L_0x0272;
                case 40: goto L_0x0260;
                case 41: goto L_0x024f;
                default: goto L_0x024a;
            }
        L_0x024a:
            super.setProperty(r8, r9, r10)
            goto L_0x0540
        L_0x024f:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            android.content.Context r0 = r8.getContext()
            java.lang.Integer r10 = com.facebook.react.bridge.ColorPropConverter.getColor(r10, r0)
            r9.setBorderStartColor(r8, r10)
            goto L_0x0540
        L_0x0260:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x0267
            goto L_0x026d
        L_0x0267:
            java.lang.Double r10 = (java.lang.Double) r10
            int r1 = r10.intValue()
        L_0x026d:
            r9.setNextFocusRight(r8, r1)
            goto L_0x0540
        L_0x0272:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x0279
            goto L_0x027f
        L_0x0279:
            java.lang.Double r10 = (java.lang.Double) r10
            int r1 = r10.intValue()
        L_0x027f:
            r9.setMeetOrSlice(r8, r1)
            goto L_0x0540
        L_0x0284:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            com.facebook.react.bridge.ReadableMap r10 = (com.facebook.react.bridge.ReadableMap) r10
            r9.setNativeBackgroundAndroid(r8, r10)
            goto L_0x0540
        L_0x028f:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x0296
            goto L_0x029c
        L_0x0296:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r1 = r10.booleanValue()
        L_0x029c:
            r9.setNeedsOffscreenAlphaCompositing(r8, r1)
            goto L_0x0540
        L_0x02a1:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x02a8
            goto L_0x02ae
        L_0x02a8:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r1 = r10.booleanValue()
        L_0x02ae:
            r9.setFocusable(r8, r1)
            goto L_0x0540
        L_0x02b3:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x02ba
            goto L_0x02c0
        L_0x02ba:
            java.lang.Double r10 = (java.lang.Double) r10
            double r4 = r10.doubleValue()
        L_0x02c0:
            r9.setBorderRadius(r8, r4)
            goto L_0x0540
        L_0x02c5:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            android.content.Context r0 = r8.getContext()
            java.lang.Integer r10 = com.facebook.react.bridge.ColorPropConverter.getColor(r10, r0)
            r9.setTintColor(r8, r10)
            goto L_0x0540
        L_0x02d6:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            android.content.Context r0 = r8.getContext()
            java.lang.Integer r10 = com.facebook.react.bridge.ColorPropConverter.getColor(r10, r0)
            r9.setBorderEndColor(r8, r10)
            goto L_0x0540
        L_0x02e7:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            com.facebook.react.bridge.ReadableMap r10 = (com.facebook.react.bridge.ReadableMap) r10
            r9.setHitSlop(r8, r10)
            goto L_0x0540
        L_0x02f2:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x02f9
            goto L_0x02fc
        L_0x02f9:
            r6 = r10
            java.lang.String r6 = (java.lang.String) r6
        L_0x02fc:
            r9.setBorderStyle(r8, r6)
            goto L_0x0540
        L_0x0301:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            android.content.Context r0 = r8.getContext()
            java.lang.Integer r10 = com.facebook.react.bridge.ColorPropConverter.getColor(r10, r0)
            r9.setBorderColor(r8, r10)
            goto L_0x0540
        L_0x0312:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x0319
            goto L_0x031f
        L_0x0319:
            java.lang.Double r10 = (java.lang.Double) r10
            int r1 = r10.intValue()
        L_0x031f:
            r9.setNextFocusUp(r8, r1)
            goto L_0x0540
        L_0x0324:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x032b
            goto L_0x0331
        L_0x032b:
            java.lang.Double r10 = (java.lang.Double) r10
            double r4 = r10.doubleValue()
        L_0x0331:
            r9.setBorderBottomRightRadius(r8, r4)
            goto L_0x0540
        L_0x0336:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x033d
            goto L_0x0343
        L_0x033d:
            java.lang.Double r10 = (java.lang.Double) r10
            double r4 = r10.doubleValue()
        L_0x0343:
            r9.setBorderBottomLeftRadius(r8, r4)
            goto L_0x0540
        L_0x0348:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x034f
            goto L_0x0355
        L_0x034f:
            java.lang.Double r10 = (java.lang.Double) r10
            int r1 = r10.intValue()
        L_0x0355:
            r9.setNextFocusForward(r8, r1)
            goto L_0x0540
        L_0x035a:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x0361
            goto L_0x0367
        L_0x0361:
            java.lang.Double r10 = (java.lang.Double) r10
            double r4 = r10.doubleValue()
        L_0x0367:
            r9.setBorderTopRightRadius(r8, r4)
            goto L_0x0540
        L_0x036c:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x0373
            goto L_0x0379
        L_0x0373:
            java.lang.Double r10 = (java.lang.Double) r10
            float r3 = r10.floatValue()
        L_0x0379:
            r9.setVbWidth(r8, r3)
            goto L_0x0540
        L_0x037e:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            android.content.Context r0 = r8.getContext()
            java.lang.Integer r10 = com.facebook.react.bridge.ColorPropConverter.getColor(r10, r0)
            r9.setColor(r8, r10)
            goto L_0x0540
        L_0x038f:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x0396
            goto L_0x0399
        L_0x0396:
            r6 = r10
            java.lang.String r6 = (java.lang.String) r6
        L_0x0399:
            r9.setAlign(r8, r6)
            goto L_0x0540
        L_0x039e:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x03a5
            goto L_0x03ab
        L_0x03a5:
            java.lang.Double r10 = (java.lang.Double) r10
            float r3 = r10.floatValue()
        L_0x03ab:
            r9.setMinY(r8, r3)
            goto L_0x0540
        L_0x03b0:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x03b7
            goto L_0x03bd
        L_0x03b7:
            java.lang.Double r10 = (java.lang.Double) r10
            float r3 = r10.floatValue()
        L_0x03bd:
            r9.setMinX(r8, r3)
            goto L_0x0540
        L_0x03c2:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            com.facebook.react.bridge.ReadableMap r10 = (com.facebook.react.bridge.ReadableMap) r10
            r9.setNativeForegroundAndroid(r8, r10)
            goto L_0x0540
        L_0x03cd:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x03d4
            goto L_0x03da
        L_0x03d4:
            java.lang.Double r10 = (java.lang.Double) r10
            float r0 = r10.floatValue()
        L_0x03da:
            r9.setBorderBottomEndRadius(r8, r0)
            goto L_0x0540
        L_0x03df:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            android.content.Context r0 = r8.getContext()
            java.lang.Integer r10 = com.facebook.react.bridge.ColorPropConverter.getColor(r10, r0)
            r9.setBorderLeftColor(r8, r10)
            goto L_0x0540
        L_0x03f0:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x03f7
            goto L_0x03fd
        L_0x03f7:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r1 = r10.booleanValue()
        L_0x03fd:
            r9.setRemoveClippedSubviews(r8, r1)
            goto L_0x0540
        L_0x0402:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x0409
            goto L_0x040c
        L_0x0409:
            r6 = r10
            java.lang.String r6 = (java.lang.String) r6
        L_0x040c:
            r9.setPointerEvents(r8, r6)
            goto L_0x0540
        L_0x0411:
            boolean r9 = r10 instanceof java.lang.String
            if (r9 == 0) goto L_0x0420
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            java.lang.String r10 = (java.lang.String) r10
            r9.setBbWidth(r8, (java.lang.String) r10)
            goto L_0x0540
        L_0x0420:
            boolean r9 = r10 instanceof java.lang.Double
            if (r9 == 0) goto L_0x042f
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            java.lang.Double r10 = (java.lang.Double) r10
            r9.setBbWidth(r8, (java.lang.Double) r10)
            goto L_0x0540
        L_0x042f:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            r10 = r6
            java.lang.Double r10 = (java.lang.Double) r10
            r9.setBbWidth(r8, (java.lang.Double) r6)
            goto L_0x0540
        L_0x043b:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x0442
            goto L_0x0448
        L_0x0442:
            java.lang.Double r10 = (java.lang.Double) r10
            float r0 = r10.floatValue()
        L_0x0448:
            r9.setBorderTopEndRadius(r8, r0)
            goto L_0x0540
        L_0x044d:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x0454
            goto L_0x045a
        L_0x0454:
            java.lang.Double r10 = (java.lang.Double) r10
            int r1 = r10.intValue()
        L_0x045a:
            r9.setNextFocusLeft(r8, r1)
            goto L_0x0540
        L_0x045f:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x0466
            goto L_0x046c
        L_0x0466:
            java.lang.Double r10 = (java.lang.Double) r10
            int r1 = r10.intValue()
        L_0x046c:
            r9.setNextFocusDown(r8, r1)
            goto L_0x0540
        L_0x0471:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x0478
            goto L_0x047e
        L_0x0478:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r1 = r10.booleanValue()
        L_0x047e:
            r9.setHasTVPreferredFocus(r8, r1)
            goto L_0x0540
        L_0x0483:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x048a
            goto L_0x0490
        L_0x048a:
            java.lang.Double r10 = (java.lang.Double) r10
            float r0 = r10.floatValue()
        L_0x0490:
            r9.setBorderBottomStartRadius(r8, r0)
            goto L_0x0540
        L_0x0495:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x049c
            goto L_0x04a2
        L_0x049c:
            java.lang.Double r10 = (java.lang.Double) r10
            float r0 = r10.floatValue()
        L_0x04a2:
            r9.setBorderTopStartRadius(r8, r0)
            goto L_0x0540
        L_0x04a7:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x04ae
            goto L_0x04b4
        L_0x04ae:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r1 = r10.booleanValue()
        L_0x04b4:
            r9.setAccessible(r8, r1)
            goto L_0x0540
        L_0x04b9:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x04c0
            goto L_0x04c6
        L_0x04c0:
            java.lang.Double r10 = (java.lang.Double) r10
            double r4 = r10.doubleValue()
        L_0x04c6:
            r9.setBorderTopLeftRadius(r8, r4)
            goto L_0x0540
        L_0x04cb:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            android.content.Context r0 = r8.getContext()
            java.lang.Integer r10 = com.facebook.react.bridge.ColorPropConverter.getColor(r10, r0)
            r9.setBorderBottomColor(r8, r10)
            goto L_0x0540
        L_0x04db:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            android.content.Context r0 = r8.getContext()
            java.lang.Integer r10 = com.facebook.react.bridge.ColorPropConverter.getColor(r10, r0)
            r9.setBorderTopColor(r8, r10)
            goto L_0x0540
        L_0x04eb:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x04f2
            goto L_0x04f8
        L_0x04f2:
            java.lang.Double r10 = (java.lang.Double) r10
            float r3 = r10.floatValue()
        L_0x04f8:
            r9.setVbHeight(r8, r3)
            goto L_0x0540
        L_0x04fc:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            if (r10 != 0) goto L_0x0503
            goto L_0x0506
        L_0x0503:
            r6 = r10
            java.lang.String r6 = (java.lang.String) r6
        L_0x0506:
            r9.setBackfaceVisibility(r8, r6)
            goto L_0x0540
        L_0x050a:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            android.content.Context r0 = r8.getContext()
            java.lang.Integer r10 = com.facebook.react.bridge.ColorPropConverter.getColor(r10, r0)
            r9.setBorderRightColor(r8, r10)
            goto L_0x0540
        L_0x051a:
            boolean r9 = r10 instanceof java.lang.String
            if (r9 == 0) goto L_0x0528
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            java.lang.String r10 = (java.lang.String) r10
            r9.setBbHeight(r8, (java.lang.String) r10)
            goto L_0x0540
        L_0x0528:
            boolean r9 = r10 instanceof java.lang.Double
            if (r9 == 0) goto L_0x0536
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            java.lang.Double r10 = (java.lang.Double) r10
            r9.setBbHeight(r8, (java.lang.Double) r10)
            goto L_0x0540
        L_0x0536:
            com.facebook.react.uimanager.BaseViewManagerInterface r9 = r7.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r9 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r9
            r10 = r6
            java.lang.Double r10 = (java.lang.Double) r10
            r9.setBbHeight(r8, (java.lang.Double) r6)
        L_0x0540:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
