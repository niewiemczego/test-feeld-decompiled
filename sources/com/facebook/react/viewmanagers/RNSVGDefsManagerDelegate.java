package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGDefsManagerInterface;

public class RNSVGDefsManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGDefsManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGDefsManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r4, java.lang.String r5, java.lang.Object r6) {
        /*
            r3 = this;
            r5.hashCode()
            int r0 = r5.hashCode()
            r1 = 0
            r2 = -1
            switch(r0) {
                case -1267206133: goto L_0x0093;
                case -1081239615: goto L_0x0088;
                case -933864895: goto L_0x007d;
                case -933857362: goto L_0x0072;
                case -293492298: goto L_0x0067;
                case 3344108: goto L_0x005c;
                case 3373707: goto L_0x0051;
                case 217109576: goto L_0x0046;
                case 917656469: goto L_0x0038;
                case 917735020: goto L_0x002a;
                case 1671764162: goto L_0x001c;
                case 1847674614: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x009d
        L_0x000e:
            java.lang.String r0 = "responsible"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0018
            goto L_0x009d
        L_0x0018:
            r2 = 11
            goto L_0x009d
        L_0x001c:
            java.lang.String r0 = "display"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0026
            goto L_0x009d
        L_0x0026:
            r2 = 10
            goto L_0x009d
        L_0x002a:
            java.lang.String r0 = "clipRule"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0034
            goto L_0x009d
        L_0x0034:
            r2 = 9
            goto L_0x009d
        L_0x0038:
            java.lang.String r0 = "clipPath"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0042
            goto L_0x009d
        L_0x0042:
            r2 = 8
            goto L_0x009d
        L_0x0046:
            java.lang.String r0 = "markerStart"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x004f
            goto L_0x009d
        L_0x004f:
            r2 = 7
            goto L_0x009d
        L_0x0051:
            java.lang.String r0 = "name"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x005a
            goto L_0x009d
        L_0x005a:
            r2 = 6
            goto L_0x009d
        L_0x005c:
            java.lang.String r0 = "mask"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0065
            goto L_0x009d
        L_0x0065:
            r2 = 5
            goto L_0x009d
        L_0x0067:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0070
            goto L_0x009d
        L_0x0070:
            r2 = 4
            goto L_0x009d
        L_0x0072:
            java.lang.String r0 = "markerMid"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x009d
        L_0x007b:
            r2 = 3
            goto L_0x009d
        L_0x007d:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0086
            goto L_0x009d
        L_0x0086:
            r2 = 2
            goto L_0x009d
        L_0x0088:
            java.lang.String r0 = "matrix"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0091
            goto L_0x009d
        L_0x0091:
            r2 = 1
            goto L_0x009d
        L_0x0093:
            java.lang.String r0 = "opacity"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x009c
            goto L_0x009d
        L_0x009c:
            r2 = r1
        L_0x009d:
            r0 = 0
            switch(r2) {
                case 0: goto L_0x0147;
                case 1: goto L_0x013d;
                case 2: goto L_0x012f;
                case 3: goto L_0x0121;
                case 4: goto L_0x0113;
                case 5: goto L_0x0105;
                case 6: goto L_0x00f7;
                case 7: goto L_0x00e8;
                case 8: goto L_0x00d9;
                case 9: goto L_0x00c7;
                case 10: goto L_0x00b8;
                case 11: goto L_0x00a6;
                default: goto L_0x00a1;
            }
        L_0x00a1:
            super.setProperty(r4, r5, r6)
            goto L_0x0157
        L_0x00a6:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGDefsManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGDefsManagerInterface) r5
            if (r6 != 0) goto L_0x00ad
            goto L_0x00b3
        L_0x00ad:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x00b3:
            r5.setResponsible(r4, r1)
            goto L_0x0157
        L_0x00b8:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGDefsManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGDefsManagerInterface) r5
            if (r6 != 0) goto L_0x00bf
            goto L_0x00c2
        L_0x00bf:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x00c2:
            r5.setDisplay(r4, r0)
            goto L_0x0157
        L_0x00c7:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGDefsManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGDefsManagerInterface) r5
            if (r6 != 0) goto L_0x00ce
            goto L_0x00d4
        L_0x00ce:
            java.lang.Double r6 = (java.lang.Double) r6
            int r1 = r6.intValue()
        L_0x00d4:
            r5.setClipRule(r4, r1)
            goto L_0x0157
        L_0x00d9:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGDefsManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGDefsManagerInterface) r5
            if (r6 != 0) goto L_0x00e0
            goto L_0x00e3
        L_0x00e0:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x00e3:
            r5.setClipPath(r4, r0)
            goto L_0x0157
        L_0x00e8:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGDefsManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGDefsManagerInterface) r5
            if (r6 != 0) goto L_0x00ef
            goto L_0x00f2
        L_0x00ef:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x00f2:
            r5.setMarkerStart(r4, r0)
            goto L_0x0157
        L_0x00f7:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGDefsManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGDefsManagerInterface) r5
            if (r6 != 0) goto L_0x00fe
            goto L_0x0101
        L_0x00fe:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x0101:
            r5.setName(r4, r0)
            goto L_0x0157
        L_0x0105:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGDefsManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGDefsManagerInterface) r5
            if (r6 != 0) goto L_0x010c
            goto L_0x010f
        L_0x010c:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x010f:
            r5.setMask(r4, r0)
            goto L_0x0157
        L_0x0113:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGDefsManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGDefsManagerInterface) r5
            if (r6 != 0) goto L_0x011a
            goto L_0x011d
        L_0x011a:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x011d:
            r5.setPointerEvents(r4, r0)
            goto L_0x0157
        L_0x0121:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGDefsManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGDefsManagerInterface) r5
            if (r6 != 0) goto L_0x0128
            goto L_0x012b
        L_0x0128:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x012b:
            r5.setMarkerMid(r4, r0)
            goto L_0x0157
        L_0x012f:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGDefsManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGDefsManagerInterface) r5
            if (r6 != 0) goto L_0x0136
            goto L_0x0139
        L_0x0136:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x0139:
            r5.setMarkerEnd(r4, r0)
            goto L_0x0157
        L_0x013d:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGDefsManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGDefsManagerInterface) r5
            com.facebook.react.bridge.ReadableArray r6 = (com.facebook.react.bridge.ReadableArray) r6
            r5.setMatrix(r4, r6)
            goto L_0x0157
        L_0x0147:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            if (r6 != 0) goto L_0x014e
            r6 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0154
        L_0x014e:
            java.lang.Double r6 = (java.lang.Double) r6
            float r6 = r6.floatValue()
        L_0x0154:
            r5.setOpacity(r4, r6)
        L_0x0157:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGDefsManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
