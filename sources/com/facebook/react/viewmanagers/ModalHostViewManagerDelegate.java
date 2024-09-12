package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.ModalHostViewManagerInterface;

public class ModalHostViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & ModalHostViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public ModalHostViewManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: boolean} */
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
                case -1851617609: goto L_0x006a;
                case -1850124175: goto L_0x005f;
                case -1726194350: goto L_0x0054;
                case -1618432855: goto L_0x0049;
                case -1156137512: goto L_0x003e;
                case -795203165: goto L_0x0033;
                case 466743410: goto L_0x0027;
                case 1195991583: goto L_0x001c;
                case 2031205598: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0074
        L_0x000e:
            java.lang.String r0 = "animationType"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0018
            goto L_0x0074
        L_0x0018:
            r2 = 8
            goto L_0x0074
        L_0x001c:
            java.lang.String r0 = "hardwareAccelerated"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0025
            goto L_0x0074
        L_0x0025:
            r2 = 7
            goto L_0x0074
        L_0x0027:
            java.lang.String r0 = "visible"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0031
            goto L_0x0074
        L_0x0031:
            r2 = 6
            goto L_0x0074
        L_0x0033:
            java.lang.String r0 = "animated"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x003c
            goto L_0x0074
        L_0x003c:
            r2 = 5
            goto L_0x0074
        L_0x003e:
            java.lang.String r0 = "statusBarTranslucent"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0047
            goto L_0x0074
        L_0x0047:
            r2 = 4
            goto L_0x0074
        L_0x0049:
            java.lang.String r0 = "identifier"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0052
            goto L_0x0074
        L_0x0052:
            r2 = 3
            goto L_0x0074
        L_0x0054:
            java.lang.String r0 = "transparent"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x005d
            goto L_0x0074
        L_0x005d:
            r2 = 2
            goto L_0x0074
        L_0x005f:
            java.lang.String r0 = "supportedOrientations"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0068
            goto L_0x0074
        L_0x0068:
            r2 = 1
            goto L_0x0074
        L_0x006a:
            java.lang.String r0 = "presentationStyle"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0073
            goto L_0x0074
        L_0x0073:
            r2 = r1
        L_0x0074:
            switch(r2) {
                case 0: goto L_0x00f8;
                case 1: goto L_0x00ee;
                case 2: goto L_0x00dd;
                case 3: goto L_0x00cc;
                case 4: goto L_0x00bb;
                case 5: goto L_0x00aa;
                case 6: goto L_0x0099;
                case 7: goto L_0x0087;
                case 8: goto L_0x007c;
                default: goto L_0x0077;
            }
        L_0x0077:
            super.setProperty(r4, r5, r6)
            goto L_0x0101
        L_0x007c:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            java.lang.String r6 = (java.lang.String) r6
            r5.setAnimationType(r4, r6)
            goto L_0x0101
        L_0x0087:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x008e
            goto L_0x0094
        L_0x008e:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x0094:
            r5.setHardwareAccelerated(r4, r1)
            goto L_0x0101
        L_0x0099:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x00a0
            goto L_0x00a6
        L_0x00a0:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x00a6:
            r5.setVisible(r4, r1)
            goto L_0x0101
        L_0x00aa:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x00b1
            goto L_0x00b7
        L_0x00b1:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x00b7:
            r5.setAnimated(r4, r1)
            goto L_0x0101
        L_0x00bb:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x00c2
            goto L_0x00c8
        L_0x00c2:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x00c8:
            r5.setStatusBarTranslucent(r4, r1)
            goto L_0x0101
        L_0x00cc:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x00d3
            goto L_0x00d9
        L_0x00d3:
            java.lang.Double r6 = (java.lang.Double) r6
            int r1 = r6.intValue()
        L_0x00d9:
            r5.setIdentifier(r4, r1)
            goto L_0x0101
        L_0x00dd:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x00e4
            goto L_0x00ea
        L_0x00e4:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x00ea:
            r5.setTransparent(r4, r1)
            goto L_0x0101
        L_0x00ee:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            com.facebook.react.bridge.ReadableArray r6 = (com.facebook.react.bridge.ReadableArray) r6
            r5.setSupportedOrientations(r4, r6)
            goto L_0x0101
        L_0x00f8:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            java.lang.String r6 = (java.lang.String) r6
            r5.setPresentationStyle(r4, r6)
        L_0x0101:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.ModalHostViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
