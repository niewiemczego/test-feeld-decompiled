package com.appsflyer.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.appsflyer.AFLogger;
import com.squareup.moshi.Json;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;

public final class AFa1ySDK {
    private static int AFInAppEventParameterName = 0;
    private static long AFInAppEventType = 0;
    private static int AFKeystoreWrapper = 1;
    private static char[] valueOf;
    private static char values;

    static {
        valueOf();
        TextUtils.lastIndexOf("", '0');
        AudioTrack.getMinVolume();
        Process.getGidForName("");
        View.getDefaultSize(0, 0);
        TextUtils.lastIndexOf("", '0');
        ViewConfiguration.getMaximumDrawingCacheSize();
        Color.argb(0, 0, 0, 0);
        Color.blue(0);
        Color.rgb(0, 0, 0);
        Process.myTid();
        Gravity.getAbsoluteGravity(0, 0);
        int i = AFKeystoreWrapper + 59;
        AFInAppEventParameterName = i % 128;
        if ((i % 2 != 0 ? '<' : ']') == '<') {
            int i2 = 95 / 0;
        }
    }

    static void valueOf() {
        AFInAppEventType = -1190597706970110129L;
        values = 7;
        valueOf = new char[]{13805, 13826, 13774, 13795, 13807, 13810, 13827, 13766, 13818, 13808, 13749, 13783, 13754, 13809, 13794, 13815, 13804, 13830, 13748, 13821, 13744, 13770, 13739, 13819, 13791, 13822, 13800, 13787, 13816, 13728, 13802, 13824, 13801, 13806, 13823, 13811, 13820, 13746, 13817, 13788, 13829, 13785, 13828, 13813, 13831, 13825, 13812, 13747, 13814};
    }

    static String AFKeystoreWrapper(Context context, long j) {
        String str;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        Object[] objArr = new Object[1];
        values("㴴匁椂轴ꕏﭕᇲ㞓䶗揱맍?ਆ‚䙦鰄뉡좥ғ嫱烄雘ꬬ섔㵢區楘辣ꖊﮈ", ExpandableListView.getPackedPositionChild(0) + 55830, objArr);
        if (!(AFInAppEventParameterName(((String) objArr[0]).intern()))) {
            Object[] objArr2 = new Object[1];
            values("", 14736 - TextUtils.lastIndexOf("", '0', 0, 0), objArr2);
            str = ((String) objArr2[0]).intern();
            int i = AFKeystoreWrapper + 79;
            AFInAppEventParameterName = i % 128;
            int i2 = i % 2;
        } else {
            int i3 = AFKeystoreWrapper + 77;
            AFInAppEventParameterName = i3 % 128;
            if (i3 % 2 != 0) {
                Object[] objArr3 = new Object[1];
                AFInAppEventParameterName(1 >>> View.resolveSizeAndState(0, 0, 0), (byte) (ViewConfiguration.getWindowTouchSlop() * 59 * 35), "㗋", objArr3);
                str = ((String) objArr3[0]).intern();
            } else {
                Object[] objArr4 = new Object[1];
                AFInAppEventParameterName(View.resolveSizeAndState(0, 0, 0) + 1, (byte) (32 - (ViewConfiguration.getWindowTouchSlop() >> 8)), "㗋", objArr4);
                str = ((String) objArr4[0]).intern();
            }
        }
        sb2.append(str);
        sb.append(values(context, sb2));
        try {
            long j2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            Object[] objArr5 = new Object[1];
            values("᧟᫤ᮍ᳆ᶏṴἽၣᄚሊጄᗫᛷវ࢛ব੬", KeyEvent.getDeadChar(0, 0) + 65257, objArr5);
            sb.append(new SimpleDateFormat(((String) objArr5[0]).intern(), Locale.US).format(new Date(j2)));
            sb.append(j);
            valueOf(sb3);
            return AFInAppEventType(AFKeystoreWrapper(AFKeystoreWrapper(values(sb.toString()), sb2.toString(), 17), sb3.toString(), 27), Long.valueOf(j));
        } catch (PackageManager.NameNotFoundException e) {
            Object[] objArr6 = new Object[1];
            values("꬙罝Εퟫ鯕⸞蚄䫱Ờꅞ甆㧸췫釓␒볹䃨ᓜ꜔欍㾼쏨韁娏", 19507 - Drawable.resolveOpacity(0, 0), objArr6);
            AFLogger.afErrorLogForExcManagerOnly(((String) objArr6[0]).intern(), e);
            Object[] objArr7 = new Object[1];
            values("犃챷☭놚ୋ敱䨞ꐾ㾸褓绤저≟붫᝔慑ﳽ囿ꀛ㮥间窓퓬⸖릑Ꮶ洸", 38317 - (KeyEvent.getMaxKeyCode() >> 16), objArr7);
            return ((String) objArr7[0]).intern();
        }
    }

    private static String AFInAppEventType(String str, Long l) {
        int i = AFKeystoreWrapper;
        int i2 = i + 15;
        AFInAppEventParameterName = i2 % 128;
        int i3 = i2 % 2;
        if (!(str == null || l == null)) {
            int i4 = i + 73;
            AFInAppEventParameterName = i4 % 128;
            if (!(i4 % 2 == 0) ? str.length() == 116 : str.length() == 32) {
                StringBuilder sb = new StringBuilder(str);
                String obj = l.toString();
                int i5 = 0;
                int i6 = 0;
                while (true) {
                    if (!(i5 < obj.length())) {
                        break;
                    }
                    i6 += Character.getNumericValue(obj.charAt(i5));
                    i5++;
                }
                String hexString = Integer.toHexString(i6);
                sb.replace(7, hexString.length() + 7, hexString);
                int i7 = 0;
                long j = 0;
                while (i7 < sb.length()) {
                    int i8 = AFKeystoreWrapper + 97;
                    AFInAppEventParameterName = i8 % 128;
                    int i9 = i8 % 2;
                    j += (long) Character.getNumericValue(sb.charAt(i7));
                    i7++;
                    int i10 = AFKeystoreWrapper + 41;
                    AFInAppEventParameterName = i10 % 128;
                    int i11 = i10 % 2;
                }
                while (true) {
                    if ((j > 100 ? 18 : '`') != 18) {
                        break;
                    }
                    int i12 = AFInAppEventParameterName + 59;
                    AFKeystoreWrapper = i12 % 128;
                    int i13 = i12 % 2;
                    j %= 100;
                }
                sb.insert(23, (int) j);
                if (j < 10) {
                    Object[] objArr = new Object[1];
                    values("", 14737 - ExpandableListView.getPackedPositionGroup(0), objArr);
                    sb.insert(23, ((String) objArr[0]).intern());
                }
                return sb.toString();
            }
        }
        Object[] objArr2 = new Object[1];
        values("犃챷☭놚ୋ敱䨞ꐾ㾸褓绤저≟붫᝔慑ﳽ囿ꀛ㮥间窓퓬⸖릑Ꮶ洸", 38316 - ImageFormat.getBitsPerPixel(0), objArr2);
        String intern = ((String) objArr2[0]).intern();
        int i14 = AFInAppEventParameterName + 123;
        AFKeystoreWrapper = i14 % 128;
        int i15 = i14 % 2;
        return intern;
    }

    private static boolean AFInAppEventParameterName(String str) {
        int i = AFKeystoreWrapper + 81;
        AFInAppEventParameterName = i % 128;
        if (i % 2 != 0) {
        }
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e) {
            Object[] objArr = new Object[1];
            values("䘭ꔮА捪쉩⅚耘件궋ಛ毷쪲⧇裟唀됙", TextUtils.getTrimmedLength("") + 41233, objArr);
            AFLogger.afErrorLogForExcManagerOnly(((String) objArr[0]).intern(), e);
            return false;
        }
    }

    private static String AFKeystoreWrapper(String str, String str2, int i) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, AFInAppEventType(str2).charAt(0));
        String obj = sb.toString();
        int i2 = AFKeystoreWrapper + 3;
        AFInAppEventParameterName = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return obj;
        }
        int i3 = 98 / 0;
        return obj;
    }

    private static String AFInAppEventType(String str) {
        int i = AFInAppEventParameterName + 69;
        AFKeystoreWrapper = i % 128;
        int i2 = i % 2;
        String num = Integer.toString(Integer.parseInt(str, 2), 16);
        int i3 = AFKeystoreWrapper + 19;
        AFInAppEventParameterName = i3 % 128;
        int i4 = i3 % 2;
        return num;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x017a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void valueOf(java.lang.StringBuilder r10) {
        /*
            r0 = 63277(0xf72d, float:8.867E-41)
            int r1 = android.view.ViewConfiguration.getPressedStateDuration()
            int r1 = r1 >> 16
            int r0 = r0 - r1
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "ဌॱʺ㮔㓇Ⱕ╚幈垩䂣秢焲橲捍鲉闭軋蘨뽹ꢥꆟ?툡쬅"
            values(r3, r0, r2)
            r0 = 0
            r2 = r2[r0]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            boolean r2 = AFInAppEventParameterName(r2)
            java.lang.String r3 = ""
            java.lang.String r4 = "㗋"
            if (r2 == 0) goto L_0x004e
            int r2 = AFKeystoreWrapper
            int r2 = r2 + 125
            int r5 = r2 % 128
            AFInAppEventParameterName = r5
            int r2 = r2 % 2
            long r5 = android.os.SystemClock.elapsedRealtime()
            r7 = 0
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            int r5 = android.view.ViewConfiguration.getScrollBarSize()
            int r5 = r5 >> 8
            int r5 = 32 - r5
            byte r5 = (byte) r5
            java.lang.Object[] r6 = new java.lang.Object[r1]
            AFInAppEventParameterName(r2, r5, r4, r6)
            r2 = r6[r0]
        L_0x0047:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            goto L_0x005e
        L_0x004e:
            int r2 = android.os.Process.myPid()
            int r2 = r2 >> 22
            int r2 = 14737 - r2
            java.lang.Object[] r5 = new java.lang.Object[r1]
            values(r3, r2, r5)
            r2 = r5[r0]
            goto L_0x0047
        L_0x005e:
            r10.append(r2)
            r2 = 48
            java.lang.String r5 = ""
            int r2 = android.text.TextUtils.lastIndexOf(r5, r2, r0)
            int r2 = 28018 - r2
            java.lang.Object[] r6 = new java.lang.Object[r1]
            java.lang.String r7 = "詒㷍꽤勬쐙瞙᥄貿㸥ꅃ哚왜槹᭷躗けꎿ唼毀ᵏ胟"
            values(r7, r2, r6)
            r2 = r6[r0]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            boolean r2 = AFInAppEventParameterName(r2)
            if (r2 == 0) goto L_0x00c6
            int r2 = AFKeystoreWrapper
            int r2 = r2 + 83
            int r6 = r2 % 128
            AFInAppEventParameterName = r6
            int r2 = r2 % 2
            if (r2 == 0) goto L_0x008e
            r2 = r1
            goto L_0x008f
        L_0x008e:
            r2 = r0
        L_0x008f:
            if (r2 == 0) goto L_0x00af
            int r2 = android.view.ViewConfiguration.getLongPressTimeout()
            int r2 = r2 >> 37
            int r2 = r0 >>> r2
            r6 = 127(0x7f, float:1.78E-43)
            int r7 = android.view.KeyEvent.keyCodeFromString(r5)
            int r6 = r6 % r7
            byte r6 = (byte) r6
            java.lang.Object[] r7 = new java.lang.Object[r1]
            AFInAppEventParameterName(r2, r6, r4, r7)
            r2 = r7[r0]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            goto L_0x00db
        L_0x00af:
            int r2 = android.view.ViewConfiguration.getLongPressTimeout()
            int r2 = r2 >> 16
            int r2 = 1 - r2
            int r6 = android.view.KeyEvent.keyCodeFromString(r5)
            int r6 = 32 - r6
            byte r6 = (byte) r6
            java.lang.Object[] r7 = new java.lang.Object[r1]
            AFInAppEventParameterName(r2, r6, r4, r7)
            r2 = r7[r0]
            goto L_0x00d5
        L_0x00c6:
            int r2 = android.view.ViewConfiguration.getEdgeSlop()
            int r2 = r2 >> 16
            int r2 = 14737 - r2
            java.lang.Object[] r6 = new java.lang.Object[r1]
            values(r3, r2, r6)
            r2 = r6[r0]
        L_0x00d5:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
        L_0x00db:
            r10.append(r2)
            int r2 = android.graphics.drawable.Drawable.resolveOpacity(r0, r0)
            int r2 = r2 + 20
            int r6 = android.view.ViewConfiguration.getKeyRepeatTimeout()
            int r6 = r6 >> 16
            int r6 = 74 - r6
            byte r6 = (byte) r6
            java.lang.Object[] r7 = new java.lang.Object[r1]
            java.lang.String r8 = "\u0019,\u001a\u001b*$ \u0019.\u001d\u0014\u0019\u001f\u0004-'\t\u001e\"\u000b"
            AFInAppEventParameterName(r2, r6, r8, r7)
            r2 = r7[r0]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            boolean r2 = AFInAppEventParameterName(r2)
            if (r2 == 0) goto L_0x0104
            r2 = r1
            goto L_0x0105
        L_0x0104:
            r2 = r0
        L_0x0105:
            if (r2 == 0) goto L_0x012c
            int r2 = AFInAppEventParameterName
            int r2 = r2 + 31
            int r6 = r2 % 128
            AFKeystoreWrapper = r6
            int r2 = r2 % 2
            int r2 = android.view.ViewConfiguration.getKeyRepeatTimeout()
            int r2 = r2 >> 16
            int r2 = 1 - r2
            long r6 = android.os.SystemClock.currentThreadTimeMillis()
            r8 = -1
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            int r6 = 33 - r6
            byte r6 = (byte) r6
            java.lang.Object[] r7 = new java.lang.Object[r1]
            AFInAppEventParameterName(r2, r6, r4, r7)
            r2 = r7[r0]
            goto L_0x013a
        L_0x012c:
            int r2 = android.view.KeyEvent.getModifierMetaStateMask()
            byte r2 = (byte) r2
            int r2 = 14736 - r2
            java.lang.Object[] r6 = new java.lang.Object[r1]
            values(r3, r2, r6)
            r2 = r6[r0]
        L_0x013a:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            r10.append(r2)
            r2 = 55511(0xd8d7, float:7.7787E-41)
            int r6 = android.view.View.getDefaultSize(r0, r0)
            int r2 = r2 - r6
            java.lang.Object[] r6 = new java.lang.Object[r1]
            java.lang.String r7 = "㿶嚅涸葼?઀↙碥齝뙜촎㳤"
            values(r7, r2, r6)
            r2 = r6[r0]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            boolean r2 = AFInAppEventParameterName(r2)
            if (r2 == 0) goto L_0x017a
            int r2 = android.view.ViewConfiguration.getDoubleTapTimeout()
            int r2 = r2 >> 16
            int r2 = 1 - r2
            float r3 = android.media.AudioTrack.getMaxVolume()
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            int r3 = r3 + 31
            byte r3 = (byte) r3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            AFInAppEventParameterName(r2, r3, r4, r1)
            r0 = r1[r0]
            goto L_0x0187
        L_0x017a:
            int r2 = android.os.Process.getGidForName(r5)
            int r2 = 14736 - r2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            values(r3, r2, r1)
            r0 = r1[r0]
        L_0x0187:
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            r10.append(r0)
            int r10 = AFKeystoreWrapper
            int r10 = r10 + 19
            int r0 = r10 % 128
            AFInAppEventParameterName = r0
            int r10 = r10 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1ySDK.valueOf(java.lang.StringBuilder):void");
    }

    private static String values(String str) {
        int i = AFInAppEventParameterName + 115;
        AFKeystoreWrapper = i % 128;
        if ((i % 2 == 0 ? (char) 28 : 21) == 21) {
            return AFb1ySDK.AFInAppEventType(AFb1ySDK.AFKeystoreWrapper(str));
        }
        AFb1ySDK.AFInAppEventType(AFb1ySDK.AFKeystoreWrapper(str));
        throw null;
    }

    private static String AFKeystoreWrapper(String str) {
        Object[] objArr = new Object[1];
        values("", 58476 - Process.getGidForName(""), objArr);
        if (!str.contains(((String) objArr[0]).intern())) {
            return str;
        }
        Object[] objArr2 = new Object[1];
        values("ၨ", KeyEvent.keyCodeFromString("") + 63241, objArr2);
        String[] split = str.split(((String) objArr2[0]).intern());
        int length = split.length;
        StringBuilder sb = new StringBuilder();
        int i = length - 1;
        StringBuilder append = sb.append(split[i]);
        Object[] objArr3 = new Object[1];
        values("", (ViewConfiguration.getPressedStateDuration() >> 16) + 58477, objArr3);
        append.append(((String) objArr3[0]).intern());
        int i2 = 1;
        while (true) {
            if (!(i2 < i)) {
                sb.append(split[0]);
                return sb.toString();
            }
            int i3 = AFInAppEventParameterName + 17;
            AFKeystoreWrapper = i3 % 128;
            int i4 = i3 % 2;
            StringBuilder append2 = sb.append(split[i2]);
            Object[] objArr4 = new Object[1];
            values("", (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 58477, objArr4);
            append2.append(((String) objArr4[0]).intern());
            i2++;
            int i5 = AFInAppEventParameterName + 25;
            AFKeystoreWrapper = i5 % 128;
            int i6 = i5 % 2;
        }
    }

    private static String valueOf(Context context) {
        int i = AFInAppEventParameterName + 93;
        AFKeystoreWrapper = i % 128;
        int i2 = i % 2;
        Properties properties = System.getProperties();
        Object[] objArr = new Object[1];
        AFInAppEventParameterName(14 - TextUtils.getOffsetBefore("", 0), (byte) (47 - (ViewConfiguration.getPressedStateDuration() >> 16)), "\u0010\u001e\u0017\u001e\u000e'.\u000f\u001d\u0013 \u0017(\u0015", objArr);
        String str = null;
        if (properties.containsKey(((String) objArr[0]).intern())) {
            try {
                String path = context.getCacheDir().getPath();
                Object[] objArr2 = new Object[1];
                AFInAppEventParameterName((ViewConfiguration.getScrollDefaultDelay() >> 16) + 6, (byte) (-16777201 - Color.rgb(0, 0, 0)), "\u0011-\u0018%\u0006!", objArr2);
                String replace = path.replace(((String) objArr2[0]).intern(), "");
                Object[] objArr3 = new Object[1];
                AFInAppEventParameterName((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 10, (byte) (TextUtils.getOffsetBefore("", 0) + 57), "\u0013\u000e\u000b\b\"\u0012'\u0010\u00130", objArr3);
                Matcher matcher = Pattern.compile(((String) objArr3[0]).intern()).matcher(replace);
                if ((matcher.find() ? 'W' : '(') == 'W') {
                    str = matcher.group(1);
                    int i3 = AFInAppEventParameterName + 41;
                    AFKeystoreWrapper = i3 % 128;
                    int i4 = i3 % 2;
                }
                int i5 = AFKeystoreWrapper + 5;
                AFInAppEventParameterName = i5 % 128;
                int i6 = i5 % 2;
            } catch (Exception e) {
                Object[] objArr4 = new Object[1];
                values("ࣵ㢐⢲塆䡬硍槆駸觜릦ꥃ?쥰𥳐᪜બ㩌⨮娣䯙篩殊", 61403 - TextUtils.indexOf("", "", 0, 0), objArr4);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr4[0]).intern(), e);
                AFb1sSDK AFVersionDeclaration = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().AFVersionDeclaration();
                Object[] objArr5 = new Object[1];
                AFInAppEventParameterName(17 - ((Process.getThreadPriority(0) + 20) >> 6), (byte) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 92), "(\u0006\u001f)\u000b\"\u0001\u0012\u0015\u0011)\u001f\u001f\"$*㙑", objArr5);
                String intern = ((String) objArr5[0]).intern();
                StringBuilder sb = new StringBuilder();
                Object[] objArr6 = new Object[1];
                AFInAppEventParameterName(ExpandableListView.getPackedPositionChild(0) + 42, (byte) (12 - Color.red(0)), "%\u0019)* \u001b\u0013(/\b\u0014!(\u0013%\u0018(\u0003!\r%\u001e(\f\u0007\u0005(\u001c\f\u0013\u001c\u0014)\u001f\u001f\"$*+ 㗆", objArr6);
                AFVersionDeclaration.values(intern, sb.append(((String) objArr6[0]).intern()).append(e).toString());
            }
        }
        return str;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Throwable, java.lang.Object, java.lang.String] */
    private static String values(Context context) {
        PackageInfo packageInfo;
        int i = AFKeystoreWrapper + 57;
        AFInAppEventParameterName = i % 128;
        ? r2 = 0;
        if ((i % 2 != 0 ? 6 : 'S') != 6) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                Object[] objArr = new Object[1];
                AFInAppEventParameterName(28 - TextUtils.lastIndexOf("", '0', 0), (byte) (14 - Color.argb(0, 0, 0, 0)), "\u0016\u0018)\n\u001a\u0010 )\u0016/\u0012\b\u0019,$%\u001c!(\u0013/,(\u0013+\u0001\u000b\u0004㘌", objArr);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr[0]).intern(), e);
                return r2;
            }
        } else {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        }
        String str = packageInfo.packageName;
        int i2 = AFInAppEventParameterName + 9;
        AFKeystoreWrapper = i2 % 128;
        if ((i2 % 2 == 0 ? Typography.quote : 'D') == 'D') {
            return str;
        }
        super.hashCode();
        throw r2;
    }

    private static String values(Context context, StringBuilder sb) {
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        String packageName = context.getPackageName();
        String AFKeystoreWrapper2 = AFKeystoreWrapper(packageName);
        Object[] objArr = new Object[1];
        AFInAppEventParameterName(View.combineMeasuredStates(0, 0) + 1, (byte) (TextUtils.indexOf("", '0', 0) + 33), "㗋", objArr);
        sb.append(((String) objArr[0]).intern());
        sb2.append(AFKeystoreWrapper2);
        if (valueOf(context) == null) {
            int i = AFKeystoreWrapper + 41;
            AFInAppEventParameterName = i % 128;
            if (i % 2 != 0) {
                Object[] objArr2 = new Object[1];
                values("", 17796 >> TextUtils.getOffsetAfter("", 1), objArr2);
                obj = objArr2[0];
            } else {
                Object[] objArr3 = new Object[1];
                values("", TextUtils.getOffsetAfter("", 0) + 14737, objArr3);
                obj = objArr3[0];
            }
            sb.append(((String) obj).intern());
            sb2.append(packageName);
            int i2 = AFInAppEventParameterName + 77;
            AFKeystoreWrapper = i2 % 128;
            int i3 = i2 % 2;
        } else {
            Object[] objArr4 = new Object[1];
            AFInAppEventParameterName(ExpandableListView.getPackedPositionType(0) + 1, (byte) (ExpandableListView.getPackedPositionType(0) + 32), "㗋", objArr4);
            sb.append(((String) objArr4[0]).intern());
            sb2.append(packageName);
        }
        String values2 = values(context);
        if ((values2 == null ? (char) 30 : 10) != 10) {
            Object[] objArr5 = new Object[1];
            values("", 14736 - TextUtils.indexOf("", '0', 0), objArr5);
            sb.append(((String) objArr5[0]).intern());
            sb2.append(packageName);
            int i4 = AFKeystoreWrapper + 25;
            AFInAppEventParameterName = i4 % 128;
            int i5 = i4 % 2;
        } else {
            Object[] objArr6 = new Object[1];
            AFInAppEventParameterName((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (byte) (31 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0 ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0 ? 0 : -1))), "㗋", objArr6);
            sb.append(((String) objArr6[0]).intern());
            sb2.append(values2);
        }
        sb2.append(Boolean.TRUE.toString());
        String obj2 = sb2.toString();
        int i6 = AFInAppEventParameterName + 117;
        AFKeystoreWrapper = i6 % 128;
        int i7 = i6 % 2;
        return obj2;
    }

    public static class AFa1xSDK extends HashMap<String, Object> {
        private static long AFInAppEventParameterName = 0;
        private static int AFKeystoreWrapper = 0;
        private static int afRDLog = 1;
        private static char[] valueOf;
        private final Context AFInAppEventType;
        private final Map<String, Object> values;

        static {
            valueOf();
            View.combineMeasuredStates(0, 0);
            TextUtils.lastIndexOf("", '0', 0, 0);
            View.MeasureSpec.makeMeasureSpec(0, 0);
            Color.blue(0);
            int i = afRDLog + 99;
            AFKeystoreWrapper = i % 128;
            if ((i % 2 != 0 ? (char) 7 : 13) != 13) {
                Throwable th = null;
                super.hashCode();
                throw th;
            }
        }

        static void valueOf() {
            valueOf = new char[]{'4', 'n', 'i', 'b', 'c', 'h', 'n', 'g', 'j', 's', 'l', 'i', '2', 'i', 'i', 'f', 'C', 'B', 'd', 'h', 'j', 'e', 'c', 'C', 'L', 'o', 'X', Typography.greater, 'D', 'e', 'l', 'f', 'C', 'D', 'n', 'n', 'p', 'K', 'L', 'o', 'h', 'E', 'C', 'e', 'h', 'E', 'C', 'j', 'k', 'n', 'j', 'i', 'b', 194, 196, 201, 199, 195, 161, Typography.cent, 197, 200, 200, 202, 200, 201, 205, 202, 201, Typography.cent, 164, 199, 196, Typography.cent, 164, 199, 206, 171, 170, 207, 205, 205, Typography.pound, 161, 205, 204, 195, 201, 209, 205, 203, 205, 179, 140, '5', 'h', 'e', 'O', '9', '9', '9', '6', 'f', 'k', 'K', 'C', 'e', 'h', 'E', 'C', 'j', 'k', 'n', 'j', 'i', 'k', 'i', 'i', 'f', 'C', 'B', 'd', 'h', 'j', 'e', 'c', 'C', 'B', 'm', 'p', 'f', '[', 'D', 'D', 'e', 'l', 'f', 'f', 'm', '1', 'U', 'k', 139, 141, 146, 144, 140, 'j', 'k', 142, 145, 145, 147, 145, 146, 150, 147, 146, 'k', 'm', 144, 141, 'k', 's', 147, 142, 152, 149, 'j', 's', 152, 150, 150, 'l', 'j', 150, 149, 140, 146, 154, 150, 148, 150, 'm', 218, 218, 220, 220, 220, 195, 171, 173, 171, 195, 199, Typography.registered, 196, 197, 170, Typography.copyright, 173, Typography.greater, 130, 138, 139, 129, 128, 130, 129, 133, 128, 131, 141, 250, 218, '1', Typography.less, 'O', '_', 228, '3', 'f', 'l', 'e', 'D', 'D', '[', 'f', 'p', 'm', 'B', 'B', 'k', 'r', 'p', 'p', ':', 'Y', '^', '^', '^', '_', '^', '^', '^', '_', '@', 'X', 's', '|', 'x', 'u'};
            AFInAppEventParameterName = -4977443077071593302L;
        }

        public AFa1xSDK(Map<String, Object> map, Context context) {
            this.values = map;
            this.AFInAppEventType = context;
            put(AFInAppEventType(), AFKeystoreWrapper());
        }

        private static StringBuilder valueOf(String... strArr) throws Exception {
            ArrayList arrayList = new ArrayList();
            int length = strArr.length;
            int i = 0;
            while (true) {
                if ((i < 3 ? '!' : 23) != '!') {
                    break;
                }
                arrayList.add(Integer.valueOf(strArr[i].length()));
                i++;
            }
            Collections.sort(arrayList);
            int intValue = ((Integer) arrayList.get(0)).intValue();
            StringBuilder sb = new StringBuilder();
            int i2 = AFKeystoreWrapper + 33;
            afRDLog = i2 % 128;
            int i3 = i2 % 2;
            int i4 = 0;
            while (true) {
                if ((i4 < intValue ? 18 : 'Z') == 'Z') {
                    return sb;
                }
                Integer num = null;
                int length2 = strArr.length;
                int i5 = 0;
                while (i5 < 3) {
                    char charAt = strArr[i5].charAt(i4);
                    if ((num == null ? Typography.greater : 'K') == 'K') {
                        charAt ^= num.intValue();
                    }
                    num = Integer.valueOf(charAt);
                    i5++;
                    int i6 = afRDLog + 71;
                    AFKeystoreWrapper = i6 % 128;
                    int i7 = i6 % 2;
                }
                sb.append(Integer.toHexString(num.intValue()));
                i4++;
            }
        }

        private String AFInAppEventType() {
            try {
                String num = Integer.toString(Build.VERSION.SDK_INT);
                Map<String, Object> map = this.values;
                Object[] objArr = new Object[1];
                AFInAppEventType("\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0000", new int[]{0, 12, 0, 5}, true, objArr);
                String obj = map.get(((String) objArr[0]).intern()).toString();
                Map<String, Object> map2 = this.values;
                Object[] objArr2 = new Object[1];
                values("ꃈ෽ꌕ甆", 22171 - View.resolveSizeAndState(0, 0, 0), objArr2);
                String obj2 = map2.get(((String) objArr2[0]).intern()).toString();
                if (obj2 == null) {
                    Object[] objArr3 = new Object[1];
                    values("ꃤ涆㨳죁镴ꈄ炶㵛", (SystemClock.uptimeMillis() > 0 ? 1 : (SystemClock.uptimeMillis() == 0 ? 0 : -1)) + 52578, objArr3);
                    obj2 = ((String) objArr3[0]).intern();
                    int i = AFKeystoreWrapper + 25;
                    afRDLog = i % 128;
                    int i2 = i % 2;
                }
                StringBuilder sb = new StringBuilder(obj);
                sb.reverse();
                StringBuilder valueOf2 = valueOf(num, obj2, sb.toString());
                int length = valueOf2.length();
                if (!(length > 4 ? true : true)) {
                    valueOf2.delete(4, length);
                } else {
                    while (true) {
                        if ((length < 4 ? (char) 17 : 28) != 17) {
                            break;
                        }
                        int i3 = AFKeystoreWrapper + 75;
                        afRDLog = i3 % 128;
                        int i4 = i3 % 2;
                        length++;
                        valueOf2.append('1');
                    }
                }
                Object[] objArr4 = new Object[1];
                values("ꃁ㡰醲", 39103 - KeyEvent.keyCodeFromString(""), objArr4);
                valueOf2.insert(0, ((String) objArr4[0]).intern());
                return valueOf2.toString();
            } catch (Exception e) {
                Object[] objArr5 = new Object[1];
                AFInAppEventType("\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001", new int[]{12, 40, 0, 21}, true, objArr5);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr5[0]).intern(), e);
                StringBuilder sb2 = new StringBuilder();
                Object[] objArr6 = new Object[1];
                AFInAppEventType("\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0000", new int[]{52, 42, 95, 0}, false, objArr6);
                AFLogger.afRDLog(sb2.append(((String) objArr6[0]).intern()).append(e).toString());
                Object[] objArr7 = new Object[1];
                AFInAppEventType("\u0001\u0000\u0001\u0001\u0000\u0000\u0000", new int[]{94, 7, 0, 0}, false, objArr7);
                return ((String) objArr7[0]).intern();
            }
        }

        private String AFKeystoreWrapper() {
            String str;
            int i;
            try {
                Map<String, Object> map = this.values;
                Object[] objArr = new Object[1];
                AFInAppEventType("\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0000", new int[]{0, 12, 0, 5}, true, objArr);
                String obj = map.get(((String) objArr[0]).intern()).toString();
                Map<String, Object> map2 = this.values;
                Object[] objArr2 = new Object[1];
                values("ꃌዮ쒂뙞桪?跅翤ㆬ唀܁𧻓겗ẹ", 45613 - View.MeasureSpec.makeMeasureSpec(0, 0), objArr2);
                String obj2 = map2.get(((String) objArr2[0]).intern()).toString();
                Object[] objArr3 = new Object[1];
                values("ꂜ잵滹锉㱀ꍬ", (ViewConfiguration.getPressedStateDuration() >> 16) + 26417, objArr3);
                String intern = ((String) objArr3[0]).intern();
                Object[] objArr4 = new Object[1];
                values("ꂇ?傟젅䀬", 30764 - (SystemClock.elapsedRealtime() > 0 ? 1 : (SystemClock.elapsedRealtime() == 0 ? 0 : -1)), objArr4);
                str = new StringBuilder().append("").append(AFb1ySDK.AFKeystoreWrapper(new StringBuilder().append(obj).append(obj2).append(intern.replaceAll(((String) objArr4[0]).intern(), "")).toString()).substring(0, 16)).toString();
            } catch (Exception e) {
                Object[] objArr5 = new Object[1];
                AFInAppEventType("\u0000\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0000\u0000\u0000", new int[]{101, 38, 0, 36}, true, objArr5);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr5[0]).intern(), e);
                StringBuilder sb = new StringBuilder();
                Object[] objArr6 = new Object[1];
                AFInAppEventType("\u0000\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001", new int[]{139, 44, 40, 2}, false, objArr6);
                AFLogger.afRDLog(sb.append(((String) objArr6[0]).intern()).append(e).toString());
                StringBuilder append = new StringBuilder().append("");
                Object[] objArr7 = new Object[1];
                AFInAppEventType("\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0001", new int[]{183, 18, 121, 0}, false, objArr7);
                str = append.append(((String) objArr7[0]).intern()).toString();
            }
            String str2 = str;
            try {
                Context context = this.AFInAppEventType;
                Object[] objArr8 = new Object[1];
                values("ꃋ⯃뛀Ǎ賙០涵䏻캘如⒐꾅㫦薢Ⴙ鮩暽籈윗割?ꡖ㍑빙ॅ鐷Ἶ画쀋䬃혃ꄚⰒ", 35591 - TextUtils.getOffsetBefore("", 0), objArr8);
                Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter(((String) objArr8[0]).intern()));
                int i2 = -2700;
                if ((registerReceiver != null ? '/' : 'c') != '/') {
                    int i3 = afRDLog + 27;
                    AFKeystoreWrapper = i3 % 128;
                    int i4 = i3 % 2;
                } else {
                    int i5 = AFKeystoreWrapper + 1;
                    afRDLog = i5 % 128;
                    int i6 = i5 % 2;
                    Object[] objArr9 = new Object[1];
                    AFInAppEventType("\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001", new int[]{201, 11, 23, 0}, true, objArr9);
                    i2 = registerReceiver.getIntExtra(((String) objArr9[0]).intern(), -2700);
                }
                String str3 = this.AFInAppEventType.getApplicationInfo().nativeLibraryDir;
                if (str3 != null) {
                    Object[] objArr10 = new Object[1];
                    AFInAppEventType("\u0001\u0000\u0000", new int[]{212, 3, 163, 1}, true, objArr10);
                    if (str3.contains(((String) objArr10[0]).intern())) {
                        i = 1;
                        Context context2 = this.AFInAppEventType;
                        Object[] objArr11 = new Object[1];
                        values("ꃙ⺂疰뱉썷", 18211 - (ViewConfiguration.getDoubleTapTimeout() >> 16), objArr11);
                        int size = ((SensorManager) context2.getSystemService(((String) objArr11[0]).intern())).getSensorList(-1).size();
                        StringBuilder sb2 = new StringBuilder();
                        Object[] objArr12 = new Object[1];
                        AFInAppEventType(Json.UNSET_NAME, new int[]{215, 1, 0, 1}, false, objArr12);
                        StringBuilder append2 = sb2.append(((String) objArr12[0]).intern()).append(i2);
                        Object[] objArr13 = new Object[1];
                        AFInAppEventType("\u0000\u0000", new int[]{216, 2, 0, 0}, true, objArr13);
                        StringBuilder append3 = append2.append(((String) objArr13[0]).intern()).append(i);
                        Object[] objArr14 = new Object[1];
                        AFInAppEventType("\u0000\u0001", new int[]{218, 2, 152, 0}, false, objArr14);
                        StringBuilder append4 = append3.append(((String) objArr14[0]).intern()).append(size);
                        Object[] objArr15 = new Object[1];
                        values("ꂌ껡", 3643 - Gravity.getAbsoluteGravity(0, 0), objArr15);
                        return new StringBuilder().append(str2).append(C0026AFa1ySDK.values(append4.append(((String) objArr15[0]).intern()).append(this.values.size()).toString())).toString();
                    }
                }
                i = 0;
                Context context22 = this.AFInAppEventType;
                Object[] objArr112 = new Object[1];
                values("ꃙ⺂疰뱉썷", 18211 - (ViewConfiguration.getDoubleTapTimeout() >> 16), objArr112);
                int size2 = ((SensorManager) context22.getSystemService(((String) objArr112[0]).intern())).getSensorList(-1).size();
                StringBuilder sb22 = new StringBuilder();
                Object[] objArr122 = new Object[1];
                AFInAppEventType(Json.UNSET_NAME, new int[]{215, 1, 0, 1}, false, objArr122);
                StringBuilder append22 = sb22.append(((String) objArr122[0]).intern()).append(i2);
                Object[] objArr132 = new Object[1];
                AFInAppEventType("\u0000\u0000", new int[]{216, 2, 0, 0}, true, objArr132);
                StringBuilder append32 = append22.append(((String) objArr132[0]).intern()).append(i);
                Object[] objArr142 = new Object[1];
                AFInAppEventType("\u0000\u0001", new int[]{218, 2, 152, 0}, false, objArr142);
                StringBuilder append42 = append32.append(((String) objArr142[0]).intern()).append(size2);
                Object[] objArr152 = new Object[1];
                values("ꂌ껡", 3643 - Gravity.getAbsoluteGravity(0, 0), objArr152);
                return new StringBuilder().append(str2).append(C0026AFa1ySDK.values(append42.append(((String) objArr152[0]).intern()).append(this.values.size()).toString())).toString();
            } catch (Exception e2) {
                Object[] objArr16 = new Object[1];
                AFInAppEventType("\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001", new int[]{220, 16, 0, 0}, false, objArr16);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr16[0]).intern(), e2);
                StringBuilder sb3 = new StringBuilder();
                Object[] objArr17 = new Object[1];
                AFInAppEventType("\u0000\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001", new int[]{139, 44, 40, 2}, false, objArr17);
                AFLogger.afRDLog(sb3.append(((String) objArr17[0]).intern()).append(e2).toString());
                StringBuilder append5 = new StringBuilder().append(str2);
                Object[] objArr18 = new Object[1];
                AFInAppEventType("\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000", new int[]{236, 16, 14, 0}, false, objArr18);
                return append5.append(((String) objArr18[0]).intern()).toString();
            }
        }

        /* renamed from: com.appsflyer.internal.AFa1ySDK$AFa1xSDK$AFa1ySDK  reason: collision with other inner class name */
        static class C0026AFa1ySDK {
            private static char[] AFInAppEventParameterName = {13738};
            private static int AFInAppEventType = 0;
            private static char AFKeystoreWrapper = '\u0001';
            private static int values = 1;

            C0026AFa1ySDK() {
            }

            static String values(String str) throws Exception {
                int i = values + 13;
                AFInAppEventType = i % 128;
                int i2 = i % 2;
                String AFInAppEventParameterName2 = AFInAppEventParameterName(AFInAppEventType(AFKeystoreWrapper(str)));
                int i3 = values + 125;
                AFInAppEventType = i3 % 128;
                int i4 = i3 % 2;
                return AFInAppEventParameterName2;
            }

            private static byte[] AFKeystoreWrapper(String str) throws Exception {
                int i = values + 77;
                AFInAppEventType = i % 128;
                int i2 = i % 2;
                byte[] bytes = str.getBytes();
                int i3 = AFInAppEventType + 119;
                values = i3 % 128;
                if ((i3 % 2 == 0 ? 25 : '%') != 25) {
                    return bytes;
                }
                int i4 = 65 / 0;
                return bytes;
            }

            private static byte[] AFInAppEventType(byte[] bArr) throws Exception {
                int i = values + 19;
                AFInAppEventType = i % 128;
                int i2 = i % 2;
                int i3 = 0;
                while (true) {
                    if (!(i3 < bArr.length)) {
                        break;
                    }
                    bArr[i3] = (byte) (bArr[i3] ^ ((i3 % 2) + 42));
                    i3++;
                }
                int i4 = AFInAppEventType + 65;
                values = i4 % 128;
                if (i4 % 2 != 0) {
                    return bArr;
                }
                throw null;
            }

            private static String AFInAppEventParameterName(byte[] bArr) throws Exception {
                StringBuilder sb = new StringBuilder();
                int length = bArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        return sb.toString();
                    }
                    int i2 = AFInAppEventType + 95;
                    values = i2 % 128;
                    int i3 = i2 % 2;
                    String hexString = Integer.toHexString(bArr[i]);
                    if (hexString.length() == 1) {
                        StringBuilder sb2 = new StringBuilder();
                        Object[] objArr = new Object[1];
                        AFKeystoreWrapper((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1, "㗙", (byte) (47 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), objArr);
                        hexString = sb2.append(((String) objArr[0]).intern()).append(hexString).toString();
                    }
                    sb.append(hexString);
                    i++;
                    int i4 = values + 37;
                    AFInAppEventType = i4 % 128;
                    int i5 = i4 % 2;
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: char[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: java.lang.String} */
            /* JADX WARNING: Failed to insert additional move for type inference */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private static void AFKeystoreWrapper(int r10, java.lang.String r11, byte r12, java.lang.Object[] r13) {
                /*
                    if (r11 == 0) goto L_0x0006
                    char[] r11 = r11.toCharArray()
                L_0x0006:
                    char[] r11 = (char[]) r11
                    java.lang.Object r0 = com.appsflyer.internal.AFg1uSDK.afErrorLog
                    monitor-enter(r0)
                    char[] r1 = AFInAppEventParameterName     // Catch:{ all -> 0x00f6 }
                    char r2 = AFKeystoreWrapper     // Catch:{ all -> 0x00f6 }
                    char[] r3 = new char[r10]     // Catch:{ all -> 0x00f6 }
                    int r4 = r10 % 2
                    if (r4 == 0) goto L_0x001e
                    int r4 = r10 + -1
                    char r5 = r11[r4]     // Catch:{ all -> 0x00f6 }
                    int r5 = r5 - r12
                    char r5 = (char) r5     // Catch:{ all -> 0x00f6 }
                    r3[r4] = r5     // Catch:{ all -> 0x00f6 }
                    goto L_0x001f
                L_0x001e:
                    r4 = r10
                L_0x001f:
                    r5 = 0
                    r6 = 1
                    if (r4 <= r6) goto L_0x00e0
                    com.appsflyer.internal.AFg1uSDK.values = r5     // Catch:{ all -> 0x00f6 }
                L_0x0025:
                    int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
                    if (r7 >= r4) goto L_0x00e0
                    int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
                    char r7 = r11[r7]     // Catch:{ all -> 0x00f6 }
                    com.appsflyer.internal.AFg1uSDK.AFInAppEventType = r7     // Catch:{ all -> 0x00f6 }
                    int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 + r6
                    char r7 = r11[r7]     // Catch:{ all -> 0x00f6 }
                    com.appsflyer.internal.AFg1uSDK.AFKeystoreWrapper = r7     // Catch:{ all -> 0x00f6 }
                    char r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventType     // Catch:{ all -> 0x00f6 }
                    char r8 = com.appsflyer.internal.AFg1uSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00f6 }
                    if (r7 != r8) goto L_0x004f
                    int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
                    char r8 = com.appsflyer.internal.AFg1uSDK.AFInAppEventType     // Catch:{ all -> 0x00f6 }
                    int r8 = r8 - r12
                    char r8 = (char) r8     // Catch:{ all -> 0x00f6 }
                    r3[r7] = r8     // Catch:{ all -> 0x00f6 }
                    int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 + r6
                    char r8 = com.appsflyer.internal.AFg1uSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00f6 }
                    int r8 = r8 - r12
                    char r8 = (char) r8     // Catch:{ all -> 0x00f6 }
                    r3[r7] = r8     // Catch:{ all -> 0x00f6 }
                    goto L_0x00d8
                L_0x004f:
                    char r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventType     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 / r2
                    com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName = r7     // Catch:{ all -> 0x00f6 }
                    char r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventType     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 % r2
                    com.appsflyer.internal.AFg1uSDK.AFLogger = r7     // Catch:{ all -> 0x00f6 }
                    char r7 = com.appsflyer.internal.AFg1uSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 / r2
                    com.appsflyer.internal.AFg1uSDK.valueOf = r7     // Catch:{ all -> 0x00f6 }
                    char r7 = com.appsflyer.internal.AFg1uSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 % r2
                    com.appsflyer.internal.AFg1uSDK.afDebugLog = r7     // Catch:{ all -> 0x00f6 }
                    int r7 = com.appsflyer.internal.AFg1uSDK.AFLogger     // Catch:{ all -> 0x00f6 }
                    int r8 = com.appsflyer.internal.AFg1uSDK.afDebugLog     // Catch:{ all -> 0x00f6 }
                    if (r7 != r8) goto L_0x0091
                    int r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 + r2
                    int r7 = r7 - r6
                    int r7 = r7 % r2
                    com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName = r7     // Catch:{ all -> 0x00f6 }
                    int r7 = com.appsflyer.internal.AFg1uSDK.valueOf     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 + r2
                    int r7 = r7 - r6
                    int r7 = r7 % r2
                    com.appsflyer.internal.AFg1uSDK.valueOf = r7     // Catch:{ all -> 0x00f6 }
                    int r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 * r2
                    int r8 = com.appsflyer.internal.AFg1uSDK.AFLogger     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 + r8
                    int r8 = com.appsflyer.internal.AFg1uSDK.valueOf     // Catch:{ all -> 0x00f6 }
                    int r8 = r8 * r2
                    int r9 = com.appsflyer.internal.AFg1uSDK.afDebugLog     // Catch:{ all -> 0x00f6 }
                    int r8 = r8 + r9
                    int r9 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
                    char r7 = r1[r7]     // Catch:{ all -> 0x00f6 }
                    r3[r9] = r7     // Catch:{ all -> 0x00f6 }
                    int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 + r6
                    char r8 = r1[r8]     // Catch:{ all -> 0x00f6 }
                    r3[r7] = r8     // Catch:{ all -> 0x00f6 }
                    goto L_0x00d8
                L_0x0091:
                    int r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f6 }
                    int r8 = com.appsflyer.internal.AFg1uSDK.valueOf     // Catch:{ all -> 0x00f6 }
                    if (r7 != r8) goto L_0x00bf
                    int r7 = com.appsflyer.internal.AFg1uSDK.AFLogger     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 + r2
                    int r7 = r7 - r6
                    int r7 = r7 % r2
                    com.appsflyer.internal.AFg1uSDK.AFLogger = r7     // Catch:{ all -> 0x00f6 }
                    int r7 = com.appsflyer.internal.AFg1uSDK.afDebugLog     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 + r2
                    int r7 = r7 - r6
                    int r7 = r7 % r2
                    com.appsflyer.internal.AFg1uSDK.afDebugLog = r7     // Catch:{ all -> 0x00f6 }
                    int r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 * r2
                    int r8 = com.appsflyer.internal.AFg1uSDK.AFLogger     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 + r8
                    int r8 = com.appsflyer.internal.AFg1uSDK.valueOf     // Catch:{ all -> 0x00f6 }
                    int r8 = r8 * r2
                    int r9 = com.appsflyer.internal.AFg1uSDK.afDebugLog     // Catch:{ all -> 0x00f6 }
                    int r8 = r8 + r9
                    int r9 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
                    char r7 = r1[r7]     // Catch:{ all -> 0x00f6 }
                    r3[r9] = r7     // Catch:{ all -> 0x00f6 }
                    int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 + r6
                    char r8 = r1[r8]     // Catch:{ all -> 0x00f6 }
                    r3[r7] = r8     // Catch:{ all -> 0x00f6 }
                    goto L_0x00d8
                L_0x00bf:
                    int r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 * r2
                    int r8 = com.appsflyer.internal.AFg1uSDK.afDebugLog     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 + r8
                    int r8 = com.appsflyer.internal.AFg1uSDK.valueOf     // Catch:{ all -> 0x00f6 }
                    int r8 = r8 * r2
                    int r9 = com.appsflyer.internal.AFg1uSDK.AFLogger     // Catch:{ all -> 0x00f6 }
                    int r8 = r8 + r9
                    int r9 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
                    char r7 = r1[r7]     // Catch:{ all -> 0x00f6 }
                    r3[r9] = r7     // Catch:{ all -> 0x00f6 }
                    int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 + r6
                    char r8 = r1[r8]     // Catch:{ all -> 0x00f6 }
                    r3[r7] = r8     // Catch:{ all -> 0x00f6 }
                L_0x00d8:
                    int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
                    int r7 = r7 + 2
                    com.appsflyer.internal.AFg1uSDK.values = r7     // Catch:{ all -> 0x00f6 }
                    goto L_0x0025
                L_0x00e0:
                    r11 = r5
                L_0x00e1:
                    if (r11 >= r10) goto L_0x00ed
                    char r12 = r3[r11]     // Catch:{ all -> 0x00f6 }
                    r12 = r12 ^ 13722(0x359a, float:1.9229E-41)
                    char r12 = (char) r12     // Catch:{ all -> 0x00f6 }
                    r3[r11] = r12     // Catch:{ all -> 0x00f6 }
                    int r11 = r11 + 1
                    goto L_0x00e1
                L_0x00ed:
                    java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x00f6 }
                    r10.<init>(r3)     // Catch:{ all -> 0x00f6 }
                    monitor-exit(r0)     // Catch:{ all -> 0x00f6 }
                    r13[r5] = r10
                    return
                L_0x00f6:
                    r10 = move-exception
                    monitor-exit(r0)
                    throw r10
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1ySDK.AFa1xSDK.C0026AFa1ySDK.AFKeystoreWrapper(int, java.lang.String, byte, java.lang.Object[]):void");
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: byte[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: java.lang.String} */
        /* JADX WARNING: Failed to insert additional move for type inference */
        /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r8v4, types: [char] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void AFInAppEventType(java.lang.String r12, int[] r13, boolean r14, java.lang.Object[] r15) {
            /*
                if (r12 == 0) goto L_0x0008
                java.lang.String r0 = "ISO-8859-1"
                byte[] r12 = r12.getBytes(r0)
            L_0x0008:
                byte[] r12 = (byte[]) r12
                java.lang.Object r0 = com.appsflyer.internal.AFg1vSDK.AFInAppEventParameterName
                monitor-enter(r0)
                r1 = 0
                r2 = r13[r1]     // Catch:{ all -> 0x00a2 }
                r3 = 1
                r4 = r13[r3]     // Catch:{ all -> 0x00a2 }
                r5 = 2
                r6 = r13[r5]     // Catch:{ all -> 0x00a2 }
                r7 = 3
                r7 = r13[r7]     // Catch:{ all -> 0x00a2 }
                char[] r8 = valueOf     // Catch:{ all -> 0x00a2 }
                char[] r9 = new char[r4]     // Catch:{ all -> 0x00a2 }
                java.lang.System.arraycopy(r8, r2, r9, r1, r4)     // Catch:{ all -> 0x00a2 }
                if (r12 == 0) goto L_0x0054
                char[] r2 = new char[r4]     // Catch:{ all -> 0x00a2 }
                com.appsflyer.internal.AFg1vSDK.AFInAppEventType = r1     // Catch:{ all -> 0x00a2 }
                r8 = r1
            L_0x0027:
                int r10 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
                if (r10 >= r4) goto L_0x0053
                int r10 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
                byte r10 = r12[r10]     // Catch:{ all -> 0x00a2 }
                if (r10 != r3) goto L_0x003e
                int r10 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
                int r11 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
                char r11 = r9[r11]     // Catch:{ all -> 0x00a2 }
                int r11 = r11 << r3
                int r11 = r11 + r3
                int r11 = r11 - r8
                char r8 = (char) r11     // Catch:{ all -> 0x00a2 }
                r2[r10] = r8     // Catch:{ all -> 0x00a2 }
                goto L_0x0049
            L_0x003e:
                int r10 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
                int r11 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
                char r11 = r9[r11]     // Catch:{ all -> 0x00a2 }
                int r11 = r11 << r3
                int r11 = r11 - r8
                char r8 = (char) r11     // Catch:{ all -> 0x00a2 }
                r2[r10] = r8     // Catch:{ all -> 0x00a2 }
            L_0x0049:
                int r8 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
                char r8 = r2[r8]     // Catch:{ all -> 0x00a2 }
                int r10 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
                int r10 = r10 + r3
                com.appsflyer.internal.AFg1vSDK.AFInAppEventType = r10     // Catch:{ all -> 0x00a2 }
                goto L_0x0027
            L_0x0053:
                r9 = r2
            L_0x0054:
                if (r7 <= 0) goto L_0x0063
                char[] r12 = new char[r4]     // Catch:{ all -> 0x00a2 }
                java.lang.System.arraycopy(r9, r1, r12, r1, r4)     // Catch:{ all -> 0x00a2 }
                int r2 = r4 - r7
                java.lang.System.arraycopy(r12, r1, r9, r2, r7)     // Catch:{ all -> 0x00a2 }
                java.lang.System.arraycopy(r12, r7, r9, r1, r2)     // Catch:{ all -> 0x00a2 }
            L_0x0063:
                if (r14 == 0) goto L_0x007f
                char[] r12 = new char[r4]     // Catch:{ all -> 0x00a2 }
                com.appsflyer.internal.AFg1vSDK.AFInAppEventType = r1     // Catch:{ all -> 0x00a2 }
            L_0x0069:
                int r14 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
                if (r14 >= r4) goto L_0x007e
                int r14 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
                int r2 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
                int r2 = r4 - r2
                int r2 = r2 - r3
                char r2 = r9[r2]     // Catch:{ all -> 0x00a2 }
                r12[r14] = r2     // Catch:{ all -> 0x00a2 }
                int r14 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
                int r14 = r14 + r3
                com.appsflyer.internal.AFg1vSDK.AFInAppEventType = r14     // Catch:{ all -> 0x00a2 }
                goto L_0x0069
            L_0x007e:
                r9 = r12
            L_0x007f:
                if (r6 <= 0) goto L_0x0099
                com.appsflyer.internal.AFg1vSDK.AFInAppEventType = r1     // Catch:{ all -> 0x00a2 }
            L_0x0083:
                int r12 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
                if (r12 >= r4) goto L_0x0099
                int r12 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
                int r14 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
                char r14 = r9[r14]     // Catch:{ all -> 0x00a2 }
                r2 = r13[r5]     // Catch:{ all -> 0x00a2 }
                int r14 = r14 - r2
                char r14 = (char) r14     // Catch:{ all -> 0x00a2 }
                r9[r12] = r14     // Catch:{ all -> 0x00a2 }
                int r12 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
                int r12 = r12 + r3
                com.appsflyer.internal.AFg1vSDK.AFInAppEventType = r12     // Catch:{ all -> 0x00a2 }
                goto L_0x0083
            L_0x0099:
                java.lang.String r12 = new java.lang.String     // Catch:{ all -> 0x00a2 }
                r12.<init>(r9)     // Catch:{ all -> 0x00a2 }
                monitor-exit(r0)     // Catch:{ all -> 0x00a2 }
                r15[r1] = r12
                return
            L_0x00a2:
                r12 = move-exception
                monitor-exit(r0)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1ySDK.AFa1xSDK.AFInAppEventType(java.lang.String, int[], boolean, java.lang.Object[]):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: char[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.lang.String} */
        /* JADX WARNING: Failed to insert additional move for type inference */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void values(java.lang.String r7, int r8, java.lang.Object[] r9) {
            /*
                if (r7 == 0) goto L_0x0006
                char[] r7 = r7.toCharArray()
            L_0x0006:
                char[] r7 = (char[]) r7
                java.lang.Object r0 = com.appsflyer.internal.AFg1tSDK.values
                monitor-enter(r0)
                com.appsflyer.internal.AFg1tSDK.valueOf = r8     // Catch:{ all -> 0x003c }
                int r8 = r7.length     // Catch:{ all -> 0x003c }
                char[] r8 = new char[r8]     // Catch:{ all -> 0x003c }
                r1 = 0
                com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper = r1     // Catch:{ all -> 0x003c }
            L_0x0013:
                int r2 = com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper     // Catch:{ all -> 0x003c }
                int r3 = r7.length     // Catch:{ all -> 0x003c }
                if (r2 >= r3) goto L_0x0033
                int r2 = com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper     // Catch:{ all -> 0x003c }
                int r3 = com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper     // Catch:{ all -> 0x003c }
                char r3 = r7[r3]     // Catch:{ all -> 0x003c }
                int r4 = com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper     // Catch:{ all -> 0x003c }
                int r5 = com.appsflyer.internal.AFg1tSDK.valueOf     // Catch:{ all -> 0x003c }
                int r4 = r4 * r5
                r3 = r3 ^ r4
                long r3 = (long) r3     // Catch:{ all -> 0x003c }
                long r5 = AFInAppEventParameterName     // Catch:{ all -> 0x003c }
                long r3 = r3 ^ r5
                int r3 = (int) r3     // Catch:{ all -> 0x003c }
                char r3 = (char) r3     // Catch:{ all -> 0x003c }
                r8[r2] = r3     // Catch:{ all -> 0x003c }
                int r2 = com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper     // Catch:{ all -> 0x003c }
                int r2 = r2 + 1
                com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper = r2     // Catch:{ all -> 0x003c }
                goto L_0x0013
            L_0x0033:
                java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x003c }
                r7.<init>(r8)     // Catch:{ all -> 0x003c }
                monitor-exit(r0)     // Catch:{ all -> 0x003c }
                r9[r1] = r7
                return
            L_0x003c:
                r7 = move-exception
                monitor-exit(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1ySDK.AFa1xSDK.values(java.lang.String, int, java.lang.Object[]):void");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void values(java.lang.String r7, int r8, java.lang.Object[] r9) {
        /*
            if (r7 == 0) goto L_0x0006
            char[] r7 = r7.toCharArray()
        L_0x0006:
            char[] r7 = (char[]) r7
            java.lang.Object r0 = com.appsflyer.internal.AFg1tSDK.values
            monitor-enter(r0)
            com.appsflyer.internal.AFg1tSDK.valueOf = r8     // Catch:{ all -> 0x003c }
            int r8 = r7.length     // Catch:{ all -> 0x003c }
            char[] r8 = new char[r8]     // Catch:{ all -> 0x003c }
            r1 = 0
            com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper = r1     // Catch:{ all -> 0x003c }
        L_0x0013:
            int r2 = com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper     // Catch:{ all -> 0x003c }
            int r3 = r7.length     // Catch:{ all -> 0x003c }
            if (r2 >= r3) goto L_0x0033
            int r2 = com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper     // Catch:{ all -> 0x003c }
            int r3 = com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper     // Catch:{ all -> 0x003c }
            char r3 = r7[r3]     // Catch:{ all -> 0x003c }
            int r4 = com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper     // Catch:{ all -> 0x003c }
            int r5 = com.appsflyer.internal.AFg1tSDK.valueOf     // Catch:{ all -> 0x003c }
            int r4 = r4 * r5
            r3 = r3 ^ r4
            long r3 = (long) r3     // Catch:{ all -> 0x003c }
            long r5 = AFInAppEventType     // Catch:{ all -> 0x003c }
            long r3 = r3 ^ r5
            int r3 = (int) r3     // Catch:{ all -> 0x003c }
            char r3 = (char) r3     // Catch:{ all -> 0x003c }
            r8[r2] = r3     // Catch:{ all -> 0x003c }
            int r2 = com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper     // Catch:{ all -> 0x003c }
            int r2 = r2 + 1
            com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper = r2     // Catch:{ all -> 0x003c }
            goto L_0x0013
        L_0x0033:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x003c }
            r7.<init>(r8)     // Catch:{ all -> 0x003c }
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            r9[r1] = r7
            return
        L_0x003c:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1ySDK.values(java.lang.String, int, java.lang.Object[]):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void AFInAppEventParameterName(int r10, byte r11, java.lang.String r12, java.lang.Object[] r13) {
        /*
            if (r12 == 0) goto L_0x0006
            char[] r12 = r12.toCharArray()
        L_0x0006:
            char[] r12 = (char[]) r12
            java.lang.Object r0 = com.appsflyer.internal.AFg1uSDK.afErrorLog
            monitor-enter(r0)
            char[] r1 = valueOf     // Catch:{ all -> 0x00f6 }
            char r2 = values     // Catch:{ all -> 0x00f6 }
            char[] r3 = new char[r10]     // Catch:{ all -> 0x00f6 }
            int r4 = r10 % 2
            if (r4 == 0) goto L_0x001e
            int r4 = r10 + -1
            char r5 = r12[r4]     // Catch:{ all -> 0x00f6 }
            int r5 = r5 - r11
            char r5 = (char) r5     // Catch:{ all -> 0x00f6 }
            r3[r4] = r5     // Catch:{ all -> 0x00f6 }
            goto L_0x001f
        L_0x001e:
            r4 = r10
        L_0x001f:
            r5 = 0
            r6 = 1
            if (r4 <= r6) goto L_0x00e0
            com.appsflyer.internal.AFg1uSDK.values = r5     // Catch:{ all -> 0x00f6 }
        L_0x0025:
            int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            if (r7 >= r4) goto L_0x00e0
            int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            char r7 = r12[r7]     // Catch:{ all -> 0x00f6 }
            com.appsflyer.internal.AFg1uSDK.AFInAppEventType = r7     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r6
            char r7 = r12[r7]     // Catch:{ all -> 0x00f6 }
            com.appsflyer.internal.AFg1uSDK.AFKeystoreWrapper = r7     // Catch:{ all -> 0x00f6 }
            char r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventType     // Catch:{ all -> 0x00f6 }
            char r8 = com.appsflyer.internal.AFg1uSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00f6 }
            if (r7 != r8) goto L_0x004f
            int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            char r8 = com.appsflyer.internal.AFg1uSDK.AFInAppEventType     // Catch:{ all -> 0x00f6 }
            int r8 = r8 - r11
            char r8 = (char) r8     // Catch:{ all -> 0x00f6 }
            r3[r7] = r8     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r6
            char r8 = com.appsflyer.internal.AFg1uSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00f6 }
            int r8 = r8 - r11
            char r8 = (char) r8     // Catch:{ all -> 0x00f6 }
            r3[r7] = r8     // Catch:{ all -> 0x00f6 }
            goto L_0x00d8
        L_0x004f:
            char r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventType     // Catch:{ all -> 0x00f6 }
            int r7 = r7 / r2
            com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName = r7     // Catch:{ all -> 0x00f6 }
            char r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventType     // Catch:{ all -> 0x00f6 }
            int r7 = r7 % r2
            com.appsflyer.internal.AFg1uSDK.AFLogger = r7     // Catch:{ all -> 0x00f6 }
            char r7 = com.appsflyer.internal.AFg1uSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00f6 }
            int r7 = r7 / r2
            com.appsflyer.internal.AFg1uSDK.valueOf = r7     // Catch:{ all -> 0x00f6 }
            char r7 = com.appsflyer.internal.AFg1uSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00f6 }
            int r7 = r7 % r2
            com.appsflyer.internal.AFg1uSDK.afDebugLog = r7     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.AFLogger     // Catch:{ all -> 0x00f6 }
            int r8 = com.appsflyer.internal.AFg1uSDK.afDebugLog     // Catch:{ all -> 0x00f6 }
            if (r7 != r8) goto L_0x0091
            int r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r2
            int r7 = r7 - r6
            int r7 = r7 % r2
            com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName = r7     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.valueOf     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r2
            int r7 = r7 - r6
            int r7 = r7 % r2
            com.appsflyer.internal.AFg1uSDK.valueOf = r7     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f6 }
            int r7 = r7 * r2
            int r8 = com.appsflyer.internal.AFg1uSDK.AFLogger     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r8
            int r8 = com.appsflyer.internal.AFg1uSDK.valueOf     // Catch:{ all -> 0x00f6 }
            int r8 = r8 * r2
            int r9 = com.appsflyer.internal.AFg1uSDK.afDebugLog     // Catch:{ all -> 0x00f6 }
            int r8 = r8 + r9
            int r9 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            char r7 = r1[r7]     // Catch:{ all -> 0x00f6 }
            r3[r9] = r7     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r6
            char r8 = r1[r8]     // Catch:{ all -> 0x00f6 }
            r3[r7] = r8     // Catch:{ all -> 0x00f6 }
            goto L_0x00d8
        L_0x0091:
            int r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f6 }
            int r8 = com.appsflyer.internal.AFg1uSDK.valueOf     // Catch:{ all -> 0x00f6 }
            if (r7 != r8) goto L_0x00bf
            int r7 = com.appsflyer.internal.AFg1uSDK.AFLogger     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r2
            int r7 = r7 - r6
            int r7 = r7 % r2
            com.appsflyer.internal.AFg1uSDK.AFLogger = r7     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.afDebugLog     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r2
            int r7 = r7 - r6
            int r7 = r7 % r2
            com.appsflyer.internal.AFg1uSDK.afDebugLog = r7     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f6 }
            int r7 = r7 * r2
            int r8 = com.appsflyer.internal.AFg1uSDK.AFLogger     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r8
            int r8 = com.appsflyer.internal.AFg1uSDK.valueOf     // Catch:{ all -> 0x00f6 }
            int r8 = r8 * r2
            int r9 = com.appsflyer.internal.AFg1uSDK.afDebugLog     // Catch:{ all -> 0x00f6 }
            int r8 = r8 + r9
            int r9 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            char r7 = r1[r7]     // Catch:{ all -> 0x00f6 }
            r3[r9] = r7     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r6
            char r8 = r1[r8]     // Catch:{ all -> 0x00f6 }
            r3[r7] = r8     // Catch:{ all -> 0x00f6 }
            goto L_0x00d8
        L_0x00bf:
            int r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f6 }
            int r7 = r7 * r2
            int r8 = com.appsflyer.internal.AFg1uSDK.afDebugLog     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r8
            int r8 = com.appsflyer.internal.AFg1uSDK.valueOf     // Catch:{ all -> 0x00f6 }
            int r8 = r8 * r2
            int r9 = com.appsflyer.internal.AFg1uSDK.AFLogger     // Catch:{ all -> 0x00f6 }
            int r8 = r8 + r9
            int r9 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            char r7 = r1[r7]     // Catch:{ all -> 0x00f6 }
            r3[r9] = r7     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r6
            char r8 = r1[r8]     // Catch:{ all -> 0x00f6 }
            r3[r7] = r8     // Catch:{ all -> 0x00f6 }
        L_0x00d8:
            int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + 2
            com.appsflyer.internal.AFg1uSDK.values = r7     // Catch:{ all -> 0x00f6 }
            goto L_0x0025
        L_0x00e0:
            r11 = r5
        L_0x00e1:
            if (r11 >= r10) goto L_0x00ed
            char r12 = r3[r11]     // Catch:{ all -> 0x00f6 }
            r12 = r12 ^ 13722(0x359a, float:1.9229E-41)
            char r12 = (char) r12     // Catch:{ all -> 0x00f6 }
            r3[r11] = r12     // Catch:{ all -> 0x00f6 }
            int r11 = r11 + 1
            goto L_0x00e1
        L_0x00ed:
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x00f6 }
            r10.<init>(r3)     // Catch:{ all -> 0x00f6 }
            monitor-exit(r0)     // Catch:{ all -> 0x00f6 }
            r13[r5] = r10
            return
        L_0x00f6:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1ySDK.AFInAppEventParameterName(int, byte, java.lang.String, java.lang.Object[]):void");
    }
}
