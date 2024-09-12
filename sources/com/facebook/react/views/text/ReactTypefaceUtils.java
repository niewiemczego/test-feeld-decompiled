package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.facebook.react.bridge.ReadableArray;
import io.sentry.ProfilingTraceData;
import java.util.ArrayList;
import org.apache.commons.lang3.CharUtils;

public class ReactTypefaceUtils {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int parseFontWeight(java.lang.String r2) {
        /*
            r0 = -1
            if (r2 == 0) goto L_0x00ad
            r2.hashCode()
            int r1 = r2.hashCode()
            switch(r1) {
                case -1039745817: goto L_0x0084;
                case 48625: goto L_0x0079;
                case 49586: goto L_0x006e;
                case 50547: goto L_0x0063;
                case 51508: goto L_0x0058;
                case 52469: goto L_0x004d;
                case 53430: goto L_0x0042;
                case 54391: goto L_0x0037;
                case 55352: goto L_0x002a;
                case 56313: goto L_0x001d;
                case 3029637: goto L_0x0010;
                default: goto L_0x000d;
            }
        L_0x000d:
            r2 = r0
            goto L_0x008e
        L_0x0010:
            java.lang.String r1 = "bold"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0019
            goto L_0x000d
        L_0x0019:
            r2 = 10
            goto L_0x008e
        L_0x001d:
            java.lang.String r1 = "900"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0026
            goto L_0x000d
        L_0x0026:
            r2 = 9
            goto L_0x008e
        L_0x002a:
            java.lang.String r1 = "800"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0033
            goto L_0x000d
        L_0x0033:
            r2 = 8
            goto L_0x008e
        L_0x0037:
            java.lang.String r1 = "700"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0040
            goto L_0x000d
        L_0x0040:
            r2 = 7
            goto L_0x008e
        L_0x0042:
            java.lang.String r1 = "600"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x004b
            goto L_0x000d
        L_0x004b:
            r2 = 6
            goto L_0x008e
        L_0x004d:
            java.lang.String r1 = "500"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0056
            goto L_0x000d
        L_0x0056:
            r2 = 5
            goto L_0x008e
        L_0x0058:
            java.lang.String r1 = "400"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0061
            goto L_0x000d
        L_0x0061:
            r2 = 4
            goto L_0x008e
        L_0x0063:
            java.lang.String r1 = "300"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x006c
            goto L_0x000d
        L_0x006c:
            r2 = 3
            goto L_0x008e
        L_0x006e:
            java.lang.String r1 = "200"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0077
            goto L_0x000d
        L_0x0077:
            r2 = 2
            goto L_0x008e
        L_0x0079:
            java.lang.String r1 = "100"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0082
            goto L_0x000d
        L_0x0082:
            r2 = 1
            goto L_0x008e
        L_0x0084:
            java.lang.String r1 = "normal"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x008d
            goto L_0x000d
        L_0x008d:
            r2 = 0
        L_0x008e:
            switch(r2) {
                case 0: goto L_0x00aa;
                case 1: goto L_0x00a7;
                case 2: goto L_0x00a4;
                case 3: goto L_0x00a1;
                case 4: goto L_0x00aa;
                case 5: goto L_0x009e;
                case 6: goto L_0x009b;
                case 7: goto L_0x0098;
                case 8: goto L_0x0095;
                case 9: goto L_0x0092;
                case 10: goto L_0x0098;
                default: goto L_0x0091;
            }
        L_0x0091:
            goto L_0x00ad
        L_0x0092:
            r2 = 900(0x384, float:1.261E-42)
            return r2
        L_0x0095:
            r2 = 800(0x320, float:1.121E-42)
            return r2
        L_0x0098:
            r2 = 700(0x2bc, float:9.81E-43)
            return r2
        L_0x009b:
            r2 = 600(0x258, float:8.41E-43)
            return r2
        L_0x009e:
            r2 = 500(0x1f4, float:7.0E-43)
            return r2
        L_0x00a1:
            r2 = 300(0x12c, float:4.2E-43)
            return r2
        L_0x00a4:
            r2 = 200(0xc8, float:2.8E-43)
            return r2
        L_0x00a7:
            r2 = 100
            return r2
        L_0x00aa:
            r2 = 400(0x190, float:5.6E-43)
            return r2
        L_0x00ad:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTypefaceUtils.parseFontWeight(java.lang.String):int");
    }

    public static int parseFontStyle(String str) {
        if (str == null) {
            return -1;
        }
        if (TtmlNode.ITALIC.equals(str)) {
            return 2;
        }
        return ProfilingTraceData.TRUNCATION_REASON_NORMAL.equals(str) ? 0 : -1;
    }

    public static String parseFontVariant(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            String string = readableArray.getString(i);
            if (string != null) {
                string.hashCode();
                char c = 65535;
                switch (string.hashCode()) {
                    case -1983120972:
                        if (string.equals("stylistic-thirteen")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1933522176:
                        if (string.equals("stylistic-fifteen")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1534462052:
                        if (string.equals("stylistic-eighteen")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1195362251:
                        if (string.equals("proportional-nums")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1061392823:
                        if (string.equals("lining-nums")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -771984547:
                        if (string.equals("tabular-nums")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -659678800:
                        if (string.equals("oldstyle-nums")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 296506098:
                        if (string.equals("stylistic-eight")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 309330544:
                        if (string.equals("stylistic-seven")) {
                            c = 8;
                            break;
                        }
                        break;
                    case 310339585:
                        if (string.equals("stylistic-three")) {
                            c = 9;
                            break;
                        }
                        break;
                    case 604478526:
                        if (string.equals("stylistic-eleven")) {
                            c = 10;
                            break;
                        }
                        break;
                    case 979426287:
                        if (string.equals("stylistic-five")) {
                            c = 11;
                            break;
                        }
                        break;
                    case 979432035:
                        if (string.equals("stylistic-four")) {
                            c = 12;
                            break;
                        }
                        break;
                    case 979664367:
                        if (string.equals("stylistic-nine")) {
                            c = CharUtils.CR;
                            break;
                        }
                        break;
                    case 1001434505:
                        if (string.equals("stylistic-one")) {
                            c = 14;
                            break;
                        }
                        break;
                    case 1001438213:
                        if (string.equals("stylistic-six")) {
                            c = 15;
                            break;
                        }
                        break;
                    case 1001439040:
                        if (string.equals("stylistic-ten")) {
                            c = 16;
                            break;
                        }
                        break;
                    case 1001439599:
                        if (string.equals("stylistic-two")) {
                            c = 17;
                            break;
                        }
                        break;
                    case 1030714463:
                        if (string.equals("stylistic-sixteen")) {
                            c = 18;
                            break;
                        }
                        break;
                    case 1044065430:
                        if (string.equals("stylistic-twelve")) {
                            c = 19;
                            break;
                        }
                        break;
                    case 1044067310:
                        if (string.equals("stylistic-twenty")) {
                            c = 20;
                            break;
                        }
                        break;
                    case 1183323111:
                        if (string.equals("small-caps")) {
                            c = 21;
                            break;
                        }
                        break;
                    case 1463562569:
                        if (string.equals("stylistic-nineteen")) {
                            c = 22;
                            break;
                        }
                        break;
                    case 1648446397:
                        if (string.equals("stylistic-fourteen")) {
                            c = 23;
                            break;
                        }
                        break;
                    case 2097122634:
                        if (string.equals("stylistic-seventeen")) {
                            c = 24;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        arrayList.add("'ss13'");
                        break;
                    case 1:
                        arrayList.add("'ss15'");
                        break;
                    case 2:
                        arrayList.add("'ss18'");
                        break;
                    case 3:
                        arrayList.add("'pnum'");
                        break;
                    case 4:
                        arrayList.add("'lnum'");
                        break;
                    case 5:
                        arrayList.add("'tnum'");
                        break;
                    case 6:
                        arrayList.add("'onum'");
                        break;
                    case 7:
                        arrayList.add("'ss08'");
                        break;
                    case 8:
                        arrayList.add("'ss07'");
                        break;
                    case 9:
                        arrayList.add("'ss03'");
                        break;
                    case 10:
                        arrayList.add("'ss11'");
                        break;
                    case 11:
                        arrayList.add("'ss05'");
                        break;
                    case 12:
                        arrayList.add("'ss04'");
                        break;
                    case 13:
                        arrayList.add("'ss09'");
                        break;
                    case 14:
                        arrayList.add("'ss01'");
                        break;
                    case 15:
                        arrayList.add("'ss06'");
                        break;
                    case 16:
                        arrayList.add("'ss10'");
                        break;
                    case 17:
                        arrayList.add("'ss02'");
                        break;
                    case 18:
                        arrayList.add("'ss16'");
                        break;
                    case 19:
                        arrayList.add("'ss12'");
                        break;
                    case 20:
                        arrayList.add("'ss20'");
                        break;
                    case 21:
                        arrayList.add("'smcp'");
                        break;
                    case 22:
                        arrayList.add("'ss19'");
                        break;
                    case 23:
                        arrayList.add("'ss14'");
                        break;
                    case 24:
                        arrayList.add("'ss17'");
                        break;
                }
            }
        }
        return TextUtils.join(", ", arrayList);
    }

    public static Typeface applyStyles(Typeface typeface, int i, int i2, String str, AssetManager assetManager) {
        TypefaceStyle typefaceStyle = new TypefaceStyle(i, i2);
        if (str != null) {
            return ReactFontManager.getInstance().getTypeface(str, typefaceStyle, assetManager);
        }
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        return typefaceStyle.apply(typeface);
    }
}
