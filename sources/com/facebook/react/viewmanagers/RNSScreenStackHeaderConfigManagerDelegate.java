package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface;

public class RNSScreenStackHeaderConfigManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSScreenStackHeaderConfigManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSScreenStackHeaderConfigManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v28, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v31, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v34, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v35, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v36, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r4 = this;
            r6.hashCode()
            int r0 = r6.hashCode()
            r1 = 1
            r2 = 0
            r3 = -1
            switch(r0) {
                case -1822687399: goto L_0x0158;
                case -1799367701: goto L_0x014d;
                case -1774658170: goto L_0x0142;
                case -1715368693: goto L_0x0137;
                case -1503810304: goto L_0x012c;
                case -1225100257: goto L_0x0121;
                case -1217487446: goto L_0x0116;
                case -1094575123: goto L_0x010b;
                case -1063138943: goto L_0x00fd;
                case -962590849: goto L_0x00ef;
                case -389245640: goto L_0x00e1;
                case -140063148: goto L_0x00d3;
                case 347216: goto L_0x00c5;
                case 94842723: goto L_0x00b7;
                case 110371416: goto L_0x00a9;
                case 183888321: goto L_0x009b;
                case 243070244: goto L_0x008d;
                case 339462402: goto L_0x007f;
                case 490615652: goto L_0x0071;
                case 1038753243: goto L_0x0063;
                case 1287124693: goto L_0x0055;
                case 1324688817: goto L_0x0047;
                case 1518161768: goto L_0x0039;
                case 1564506303: goto L_0x002b;
                case 2029798365: goto L_0x001d;
                case 2099541337: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0162
        L_0x000f:
            java.lang.String r0 = "topInsetEnabled"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x0162
        L_0x0019:
            r3 = 25
            goto L_0x0162
        L_0x001d:
            java.lang.String r0 = "largeTitle"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x0162
        L_0x0027:
            r3 = 24
            goto L_0x0162
        L_0x002b:
            java.lang.String r0 = "largeTitleHideShadow"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x0162
        L_0x0035:
            r3 = 23
            goto L_0x0162
        L_0x0039:
            java.lang.String r0 = "titleFontSize"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x0162
        L_0x0043:
            r3 = 22
            goto L_0x0162
        L_0x0047:
            java.lang.String r0 = "backTitle"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x0162
        L_0x0051:
            r3 = 21
            goto L_0x0162
        L_0x0055:
            java.lang.String r0 = "backgroundColor"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x0162
        L_0x005f:
            r3 = 20
            goto L_0x0162
        L_0x0063:
            java.lang.String r0 = "hideBackButton"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x006d
            goto L_0x0162
        L_0x006d:
            r3 = 19
            goto L_0x0162
        L_0x0071:
            java.lang.String r0 = "largeTitleFontWeight"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x0162
        L_0x007b:
            r3 = 18
            goto L_0x0162
        L_0x007f:
            java.lang.String r0 = "hideShadow"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0089
            goto L_0x0162
        L_0x0089:
            r3 = 17
            goto L_0x0162
        L_0x008d:
            java.lang.String r0 = "backTitleFontFamily"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x0162
        L_0x0097:
            r3 = 16
            goto L_0x0162
        L_0x009b:
            java.lang.String r0 = "backTitleFontSize"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x0162
        L_0x00a5:
            r3 = 15
            goto L_0x0162
        L_0x00a9:
            java.lang.String r0 = "title"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x0162
        L_0x00b3:
            r3 = 14
            goto L_0x0162
        L_0x00b7:
            java.lang.String r0 = "color"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x0162
        L_0x00c1:
            r3 = 13
            goto L_0x0162
        L_0x00c5:
            java.lang.String r0 = "largeTitleFontFamily"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x0162
        L_0x00cf:
            r3 = 12
            goto L_0x0162
        L_0x00d3:
            java.lang.String r0 = "backButtonInCustomView"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x0162
        L_0x00dd:
            r3 = 11
            goto L_0x0162
        L_0x00e1:
            java.lang.String r0 = "largeTitleBackgroundColor"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x0162
        L_0x00eb:
            r3 = 10
            goto L_0x0162
        L_0x00ef:
            java.lang.String r0 = "direction"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x0162
        L_0x00f9:
            r3 = 9
            goto L_0x0162
        L_0x00fd:
            java.lang.String r0 = "backTitleVisible"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x0162
        L_0x0107:
            r3 = 8
            goto L_0x0162
        L_0x010b:
            java.lang.String r0 = "largeTitleFontSize"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0114
            goto L_0x0162
        L_0x0114:
            r3 = 7
            goto L_0x0162
        L_0x0116:
            java.lang.String r0 = "hidden"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x011f
            goto L_0x0162
        L_0x011f:
            r3 = 6
            goto L_0x0162
        L_0x0121:
            java.lang.String r0 = "titleFontWeight"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x012a
            goto L_0x0162
        L_0x012a:
            r3 = 5
            goto L_0x0162
        L_0x012c:
            java.lang.String r0 = "disableBackButtonMenu"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0135
            goto L_0x0162
        L_0x0135:
            r3 = 4
            goto L_0x0162
        L_0x0137:
            java.lang.String r0 = "titleFontFamily"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0140
            goto L_0x0162
        L_0x0140:
            r3 = 3
            goto L_0x0162
        L_0x0142:
            java.lang.String r0 = "largeTitleColor"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x014b
            goto L_0x0162
        L_0x014b:
            r3 = 2
            goto L_0x0162
        L_0x014d:
            java.lang.String r0 = "titleColor"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0156
            goto L_0x0162
        L_0x0156:
            r3 = r1
            goto L_0x0162
        L_0x0158:
            java.lang.String r0 = "translucent"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0161
            goto L_0x0162
        L_0x0161:
            r3 = r2
        L_0x0162:
            r0 = 0
            switch(r3) {
                case 0: goto L_0x0306;
                case 1: goto L_0x02f6;
                case 2: goto L_0x02e6;
                case 3: goto L_0x02d8;
                case 4: goto L_0x02c7;
                case 5: goto L_0x02b9;
                case 6: goto L_0x02a8;
                case 7: goto L_0x0296;
                case 8: goto L_0x0284;
                case 9: goto L_0x0279;
                case 10: goto L_0x0268;
                case 11: goto L_0x0256;
                case 12: goto L_0x0247;
                case 13: goto L_0x0236;
                case 14: goto L_0x0227;
                case 15: goto L_0x0215;
                case 16: goto L_0x0206;
                case 17: goto L_0x01f4;
                case 18: goto L_0x01e5;
                case 19: goto L_0x01d3;
                case 20: goto L_0x01c2;
                case 21: goto L_0x01b3;
                case 22: goto L_0x01a1;
                case 23: goto L_0x018f;
                case 24: goto L_0x017d;
                case 25: goto L_0x016b;
                default: goto L_0x0166;
            }
        L_0x0166:
            super.setProperty(r5, r6, r7)
            goto L_0x0316
        L_0x016b:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x0172
            goto L_0x0178
        L_0x0172:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x0178:
            r6.setTopInsetEnabled(r5, r2)
            goto L_0x0316
        L_0x017d:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x0184
            goto L_0x018a
        L_0x0184:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x018a:
            r6.setLargeTitle(r5, r2)
            goto L_0x0316
        L_0x018f:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x0196
            goto L_0x019c
        L_0x0196:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x019c:
            r6.setLargeTitleHideShadow(r5, r2)
            goto L_0x0316
        L_0x01a1:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x01a8
            goto L_0x01ae
        L_0x01a8:
            java.lang.Double r7 = (java.lang.Double) r7
            int r2 = r7.intValue()
        L_0x01ae:
            r6.setTitleFontSize(r5, r2)
            goto L_0x0316
        L_0x01b3:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x01ba
            goto L_0x01bd
        L_0x01ba:
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        L_0x01bd:
            r6.setBackTitle(r5, r0)
            goto L_0x0316
        L_0x01c2:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setBackgroundColor(r5, r7)
            goto L_0x0316
        L_0x01d3:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x01da
            goto L_0x01e0
        L_0x01da:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x01e0:
            r6.setHideBackButton(r5, r2)
            goto L_0x0316
        L_0x01e5:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x01ec
            goto L_0x01ef
        L_0x01ec:
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        L_0x01ef:
            r6.setLargeTitleFontWeight(r5, r0)
            goto L_0x0316
        L_0x01f4:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x01fb
            goto L_0x0201
        L_0x01fb:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x0201:
            r6.setHideShadow(r5, r2)
            goto L_0x0316
        L_0x0206:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x020d
            goto L_0x0210
        L_0x020d:
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        L_0x0210:
            r6.setBackTitleFontFamily(r5, r0)
            goto L_0x0316
        L_0x0215:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x021c
            goto L_0x0222
        L_0x021c:
            java.lang.Double r7 = (java.lang.Double) r7
            int r2 = r7.intValue()
        L_0x0222:
            r6.setBackTitleFontSize(r5, r2)
            goto L_0x0316
        L_0x0227:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x022e
            goto L_0x0231
        L_0x022e:
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        L_0x0231:
            r6.setTitle(r5, r0)
            goto L_0x0316
        L_0x0236:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setColor(r5, r7)
            goto L_0x0316
        L_0x0247:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x024e
            goto L_0x0251
        L_0x024e:
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        L_0x0251:
            r6.setLargeTitleFontFamily(r5, r0)
            goto L_0x0316
        L_0x0256:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x025d
            goto L_0x0263
        L_0x025d:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x0263:
            r6.setBackButtonInCustomView(r5, r2)
            goto L_0x0316
        L_0x0268:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setLargeTitleBackgroundColor(r5, r7)
            goto L_0x0316
        L_0x0279:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            java.lang.String r7 = (java.lang.String) r7
            r6.setDirection(r5, r7)
            goto L_0x0316
        L_0x0284:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x028b
            goto L_0x0291
        L_0x028b:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x0291:
            r6.setBackTitleVisible(r5, r1)
            goto L_0x0316
        L_0x0296:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x029d
            goto L_0x02a3
        L_0x029d:
            java.lang.Double r7 = (java.lang.Double) r7
            int r2 = r7.intValue()
        L_0x02a3:
            r6.setLargeTitleFontSize(r5, r2)
            goto L_0x0316
        L_0x02a8:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x02af
            goto L_0x02b5
        L_0x02af:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x02b5:
            r6.setHidden(r5, r2)
            goto L_0x0316
        L_0x02b9:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x02c0
            goto L_0x02c3
        L_0x02c0:
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        L_0x02c3:
            r6.setTitleFontWeight(r5, r0)
            goto L_0x0316
        L_0x02c7:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x02ce
            goto L_0x02d4
        L_0x02ce:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x02d4:
            r6.setDisableBackButtonMenu(r5, r2)
            goto L_0x0316
        L_0x02d8:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x02df
            goto L_0x02e2
        L_0x02df:
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        L_0x02e2:
            r6.setTitleFontFamily(r5, r0)
            goto L_0x0316
        L_0x02e6:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setLargeTitleColor(r5, r7)
            goto L_0x0316
        L_0x02f6:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setTitleColor(r5, r7)
            goto L_0x0316
        L_0x0306:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x030d
            goto L_0x0313
        L_0x030d:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x0313:
            r6.setTranslucent(r5, r2)
        L_0x0316:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
