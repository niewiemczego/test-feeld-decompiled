package com.appsflyer.internal;

public class AFa1vSDK {
    public static int AppsFlyer2dXConversionCallback = 988066554;
    public static byte[] afErrorLogForExcManagerOnly = null;
    public static long init = -7937889260936542951L;
    private static int onAppOpenAttribution = 1;
    private static Object onAppOpenAttributionNative;
    public static byte[] onAttributionFailureNative = {-52, -124, 37, -55, -13, -73, Byte.MIN_VALUE, 118};
    public static final byte[] onConversionDataSuccess = null;
    public static int onDeepLinkingNative = 3;
    public static byte[] onInstallConversionDataLoadedNative;
    private static Object onInstallConversionFailureNative;
    private static int onResponseErrorNative;
    public static final int onResponseNative = 0;

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if ((r9 == null ? 'D' : 'Z') != 'Z') goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        r0 = r11;
        r6 = 0;
        r4 = r3;
        r11 = r10;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        if ((r9 == null) != false) goto L_0x0055;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String $$c(short r9, short r10, byte r11) {
        /*
            int r0 = onResponseErrorNative
            int r0 = r0 + 81
            int r1 = r0 % 128
            onAppOpenAttribution = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0010
            r0 = r1
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            if (r0 == r2) goto L_0x0033
            r0 = r11 ^ 88
            r11 = r11 & 88
            int r11 = r11 << r2
            int r0 = r0 + r11
            r11 = 15054(0x3ace, float:2.1095E-41)
            int r11 = r11 % r10
            r10 = r9 | 70
            int r10 = r10 << r2
            r9 = r9 ^ 70
            int r10 = r10 - r9
            int r10 = r10 + 50
            int r10 = r10 - r2
            byte[] r9 = onConversionDataSuccess
            byte[] r3 = new byte[r10]
            if (r9 != 0) goto L_0x002d
            r4 = r2
            goto L_0x002e
        L_0x002d:
            r4 = r1
        L_0x002e:
            if (r4 == 0) goto L_0x0031
            goto L_0x0055
        L_0x0031:
            r4 = r1
            goto L_0x005b
        L_0x0033:
            int r11 = r11 + 42
            int r0 = r11 + -1
            int r10 = -r10
            r11 = r10 | 989(0x3dd, float:1.386E-42)
            int r11 = r11 << r2
            r10 = r10 ^ 989(0x3dd, float:1.386E-42)
            int r11 = r11 - r10
            int r9 = r9 + 10
            int r9 = r9 - r2
            r10 = r9 ^ -8
            r9 = r9 & -8
            int r9 = r9 << r2
            int r10 = r10 + r9
            byte[] r9 = onConversionDataSuccess
            byte[] r3 = new byte[r10]
            r4 = 90
            if (r9 != 0) goto L_0x0052
            r5 = 68
            goto L_0x0053
        L_0x0052:
            r5 = r4
        L_0x0053:
            if (r5 == r4) goto L_0x0031
        L_0x0055:
            r0 = r11
            r6 = r1
            r4 = r3
            r11 = r10
            r3 = r0
            goto L_0x0094
        L_0x005b:
            r5 = r4 ^ -36
            r6 = r4 & -36
            int r6 = r6 << r2
            int r5 = r5 + r6
            r6 = r5 ^ 37
            r5 = r5 & 37
            int r5 = r5 << r2
            int r6 = r6 + r5
            int r11 = r11 + 49
            int r11 = r11 - r2
            int r11 = r11 + -46
            int r11 = r11 - r2
            byte r5 = (byte) r0
            r3[r4] = r5
            if (r6 != r10) goto L_0x0083
            java.lang.String r9 = new java.lang.String
            r9.<init>(r3, r1)
            int r10 = onAppOpenAttribution
            int r10 = r10 + 20
            int r10 = r10 - r2
            int r11 = r10 % 128
            onResponseErrorNative = r11
            int r10 = r10 % 2
            return r9
        L_0x0083:
            byte r4 = r9[r11]
            int r5 = onResponseErrorNative
            int r5 = r5 + 101
            int r7 = r5 % 128
            onAppOpenAttribution = r7
            int r5 = r5 % 2
            r8 = r11
            r11 = r10
            r10 = r4
            r4 = r3
            r3 = r8
        L_0x0094:
            int r10 = -r10
            int r10 = -r10
            r5 = r0 | r10
            int r5 = r5 << r2
            r10 = r10 ^ r0
            int r5 = r5 - r10
            int r5 = r5 + -2
            int r0 = r5 + -1
            r10 = r11
            r11 = r3
            r3 = r4
            r4 = r6
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1vSDK.$$c(short, short, byte):java.lang.String");
    }

    public static int AFInAppEventParameterName(int i) {
        int i2 = onAppOpenAttribution + 53;
        int i3 = i2 % 128;
        onResponseErrorNative = i3;
        Throwable th = null;
        if ((i2 % 2 != 0 ? '#' : 'B') != '#') {
            Object obj = onInstallConversionFailureNative;
            int i4 = (i3 & 113) + (i3 | 113);
            onAppOpenAttribution = i4 % 128;
            int i5 = i4 % 2;
            boolean z = true;
            int i6 = (i3 ^ 107) + ((i3 & 107) << 1);
            onAppOpenAttribution = i6 % 128;
            int i7 = i6 % 2;
            try {
                Object[] objArr = {Integer.valueOf(i)};
                byte[] bArr = onConversionDataSuccess;
                int intValue = ((Integer) Class.forName($$c((byte) bArr[546], (short) (onResponseNative | 850), (byte) bArr[135]), true, (ClassLoader) onAppOpenAttributionNative).getMethod($$c((byte) bArr[4], (short) 620, (byte) bArr[37]), new Class[]{Integer.TYPE}).invoke(obj, objArr)).intValue();
                int i8 = onResponseErrorNative;
                int i9 = (i8 ^ 59) + ((i8 & 59) << 1);
                onAppOpenAttribution = i9 % 128;
                if (i9 % 2 == 0) {
                    z = false;
                }
                if (z) {
                    return intValue;
                }
                throw th;
            } catch (Throwable th2) {
                Throwable cause = th2.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th2;
            }
        } else {
            super.hashCode();
            throw th;
        }
    }

    public static int AFInAppEventParameterName(Object obj) {
        int i = onResponseErrorNative;
        int i2 = (i & 115) + (i | 115);
        int i3 = i2 % 128;
        onAppOpenAttribution = i3;
        if ((i2 % 2 == 0 ? '-' : 'A') == 'A') {
            Object obj2 = onInstallConversionFailureNative;
            int i4 = i3 + 27;
            onResponseErrorNative = i4 % 128;
            int i5 = i4 % 2;
            try {
                Object[] objArr = {obj};
                byte[] bArr = onConversionDataSuccess;
                int i6 = onResponseNative;
                int intValue = ((Integer) Class.forName($$c((byte) bArr[546], (short) ((i6 & 850) | (i6 ^ 850)), (byte) bArr[135]), true, (ClassLoader) onAppOpenAttributionNative).getMethod($$c((byte) bArr[4], (short) 620, (byte) bArr[37]), new Class[]{Object.class}).invoke(obj2, objArr)).intValue();
                int i7 = onAppOpenAttribution;
                int i8 = (i7 ^ 117) + ((i7 & 117) << 1);
                onResponseErrorNative = i8 % 128;
                int i9 = i8 % 2;
                return intValue;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } else {
            Throwable th2 = null;
            super.hashCode();
            throw th2;
        }
    }

    public static Object AFInAppEventParameterName(char c, int i, int i2) {
        int i3 = onAppOpenAttribution;
        int i4 = ((i3 | 97) << 1) - (i3 ^ 97);
        onResponseErrorNative = i4 % 128;
        int i5 = i4 % 2;
        Object obj = onInstallConversionFailureNative;
        int i6 = (i3 & 33) + (i3 | 33);
        int i7 = i6 % 128;
        onResponseErrorNative = i7;
        int i8 = i6 % 2;
        int i9 = ((i7 | 91) << 1) - (i7 ^ 91);
        onAppOpenAttribution = i9 % 128;
        int i10 = i9 % 2;
        try {
            Object[] objArr = new Object[3];
            objArr[2] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i);
            objArr[0] = Character.valueOf(c);
            byte[] bArr = onConversionDataSuccess;
            int i11 = onResponseNative;
            Class<?> cls = Class.forName($$c((byte) bArr[546], (short) ((i11 & 850) | (i11 ^ 850)), (byte) bArr[135]), true, (ClassLoader) onAppOpenAttributionNative);
            byte b = bArr[37];
            byte b2 = (byte) b;
            Object invoke = cls.getMethod($$c(b2, (short) ((b2 ^ 544) | (b2 & 544)), (byte) b), new Class[]{Character.TYPE, Integer.TYPE, Integer.TYPE}).invoke(obj, objArr);
            int i12 = onResponseErrorNative;
            int i13 = (i12 & 99) + (i12 | 99);
            onAppOpenAttribution = i13 % 128;
            int i14 = i13 % 2;
            return invoke;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    static void init$0() {
        int i = onAppOpenAttribution + 27;
        onResponseErrorNative = i % 128;
        int i2 = i % 2;
        byte[] bArr = new byte[1008];
        System.arraycopy("!\u0019ò\u000f\u0001Ä6\u0012\u0003\u0006ö\t\u0010ï\u0010¿>\b\tô\u0010ÿö\u000eÅ\u0016\b\u001eÓJÞô\nÜ\u0003ú\u0018îÐ>\tÂ\u00176ô\u0003\u0002\u0010ö\u0002è(\u0005\b\u0002â$\u0001öÿ\u000f\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\u0015\b\u001eÓHàô\nÜHú\u0018îÐAø\u0010üÊ()ý\u0004ô\u000b\u0015\u0000\u0003ö\f\tÐ2\u0003ÿ\u0000ý\u0001\u0016ø\t\u0002ú\u0018îÐCþ\tÂ\u0017:þôà6ô\u0003\u0002\u0010\u0010ù\u0011\u0000ýþÍD\u0007¾\u00176÷\u0006ûÃ5ò\u0010\u0004ù\t\u0002ú\u0018îÐ>\tÂ\u0017:þôß4\u0003ò\u001bÓ(\u0005\b\u0002â$\u0001öÿ\u000f\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u001e(â\u001b\u000b\u0005\u0006\nÎ$\u0016Î,ø\u0015\u0003Ü&õ\u0006\u0004\u0010\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\u0015\b\u001eÓJÞô\nÜ\u0003öÿ\u0006å2ú\u0003\u0010\u0001\u0012Õ&\u0006ü\u0011Ô(\fþú\u000eô\u0001\u0012Ò!\u0005\b\u0000â(\föÿ\u0006\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u0019$\u0016Ñ&\u0006ü\u000fø\u0004ý\u0007\u0001\u0005\b\u0000\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u0017\"\u0015õâ$\u0016Î,ø\u0015\u0003Ü&õ\u0006\u0004\u0010\u0001\u0012Ò/ø\u0004á!\u0005\b\u0000â(\f\b\u0006(Ö2\u0003Ø4ò\f\tã(úø\tøøî\nì\u000bI\u0004´Iþ\u000e\u0003ù\u0002\u0005\u000b\u000b°Oü\u0004\u0011¸î\tí\u000bî\u0007ï\u000bî\u000bë\u000b\b\u0006(Ö2\u0003Ø4ò\f\tß\u0014\u0014ò\u000fû\u0012ô\u0010ß\u0016\u000fûú\u0018îÐAø\u0010üÊ\u0018,ø\u0015\u0003Ü&õ\u0006\u0004\u0010\u0010ù\u0011\u0000ýþÍ6\u0012\u0003Á\u00162\u0003Ú(\u0006ö\u0002\u000e\n\u0001\u0012Ô6ÿô\u0010ÿö\u000eê$þ\u0006ò\t\u0001â(\fö\u0001\u0014þ\u0006\n7\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ6Îú\u0018îÐ>\tÂ\u0019 \u0016ðë(\u0005\b\u0002â$\u0001öÿ\u000f\u0006õ\u0006ã$\u0016ú\u0018îÐ>\tÂ\u0017:þôß4\u0003ò\u001bÙ)\u0002ÿ\b\u0002â$\u0001öÿ\u000f\u0010ù\u0011\u0000ýþÍD\u0007¾\u001a,\u000bö\f\u0000\u0002\u0002û\f\tû\u0001\n\u0001\u0012Ò,ø\u0015\u0003Ü&õ\u0006\u0004\u00108\u0000\u0016ðÑ8\u0000\u0016ðÑ\u0004\nü\u0012ô\u0001\u0012Õ\u0001ô\n\u0017í\b\tö\u0016ø\u0010òê ü\u0013ò\u0014\nÚ\u0014\u0016÷à*ü\u000bû\f\t\u0002\f\u0006\u0007õ7\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ5Ïú\u0018îÐ>\tÂIü\u0006÷\b\f\u0001\u0012ß%\u0000\u0004ø\u0010\u0005\b\u0001\u0012Ð$\u0014ÿ\u0000\f\u0002ôî\u0014\u0016÷\u0010ù\u0011\u0000ýþÍ6\u0012\u0003Á\u0016%\u0014ø\u0010ö\u000e\bÞ\u0017\röÿ\u0006ú\u0018îÐ>\tÂ\u001b&\u0006üí)\u0002ÿ\b\u0002â$\u0001öÿ\u000f\u0001\u0010ì\u001eú\u000eôú\u0018îÐ>\tÂ\u001e\tù6î\u0005\u000e\u0007ø\t\u0002\u0010ù\u0011\u0000ýþÍIô\u0016ÿ½)\u0014\u0016ÿä\"ø\u0006\nô\u0016÷ç \r\u0004\u0001\u0012Ø(þ\u000eøû\u000eØ2\u0003ÿ\u0000ý\u0001\u0016ø\t\u0002ú\u0018îÐ>\tÂ\u001b&\u0006üî\u0006ð\u000b\u0001\u0012ã!ú\u0007\u0003û\u0002ë\u001c\fü\u0010÷\u0015\u0000\u0003ö\f\tã\u0018\u0007ûë\u001f\u0006\u0003\u0000\rú\u0018îÐ>\tÂ\u001b&\u0006üâ$\u0011ó\u0012ú\n\u0007þ\u0006þÖ:þôß4\u0003ò\u001b\u0006õ\u0006â,ø\u0015\u0003\u000f\u0001Ä6\u0012\u0003\u0006ö\t\u0010ï\u0010þò\u0012ö\u0016ø\u0010òê ü\u0013ò\u0014\nÎ(\fö\u0001\u0014þ\u0006úÿ\u0011ú\u0018îÐ>\tÂ\u001e(\u0005\b\u0002â$\u0001öÿ\u000f".getBytes("ISO-8859-1"), 0, bArr, 0, 1008);
        onConversionDataSuccess = bArr;
        onResponseNative = 136;
        int i3 = onResponseErrorNative;
        int i4 = ((i3 | 119) << 1) - (i3 ^ 119);
        onAppOpenAttribution = i4 % 128;
        if (!(i4 % 2 != 0)) {
            int i5 = 72 / 0;
        }
    }

    private AFa1vSDK() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v32, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v43, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v49, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v47, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v168, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v178, resolved type: com.appsflyer.internal.AFg1wSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v42, resolved type: com.appsflyer.internal.AFg1wSDK} */
    /* JADX WARNING: type inference failed for: r19v1 */
    /* JADX WARNING: type inference failed for: r19v11 */
    /* JADX WARNING: type inference failed for: r19v20 */
    /* JADX WARNING: type inference failed for: r19v22 */
    /* JADX WARNING: type inference failed for: r10v44, types: [java.lang.Object, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r19v33 */
    /* JADX WARNING: type inference failed for: r19v34 */
    /* JADX WARNING: type inference failed for: r19v46 */
    /* JADX WARNING: type inference failed for: r19v47 */
    /* JADX WARNING: type inference failed for: r19v48 */
    /* JADX WARNING: type inference failed for: r19v49 */
    /* JADX WARNING: type inference failed for: r19v51 */
    /* JADX WARNING: type inference failed for: r19v57 */
    /* JADX WARNING: type inference failed for: r19v58 */
    /* JADX WARNING: type inference failed for: r19v59 */
    /* JADX WARNING: type inference failed for: r19v60 */
    /* JADX WARNING: type inference failed for: r19v61 */
    /* JADX WARNING: type inference failed for: r19v62 */
    /* JADX WARNING: type inference failed for: r19v63 */
    /* JADX WARNING: type inference failed for: r19v77 */
    /* JADX WARNING: type inference failed for: r19v79 */
    /* JADX WARNING: type inference failed for: r19v80 */
    /* JADX WARNING: type inference failed for: r19v81 */
    /* JADX WARNING: type inference failed for: r19v94 */
    /* JADX WARNING: type inference failed for: r19v128 */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0086, code lost:
        if (r4 != null) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x042f, code lost:
        if (((java.lang.Boolean) java.lang.Class.forName($$c(r10, (short) (r10 | 112), (byte) r26[r14])).getMethod($$c((byte) r26[152(0x98, float:2.13E-43)], (short) 196, (byte) r26[135(0x87, float:1.89E-43)]), (java.lang.Class[]) null).invoke(r9, (java.lang.Object[]) null)).booleanValue() == false) goto L_0x043c;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:647:0x123d */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0398 A[Catch:{ ClassNotFoundException -> 0x03d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x03a0  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x03b7  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x03bd  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x03ca  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x03d2 A[Catch:{ ClassNotFoundException -> 0x03d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x03d4 A[Catch:{ ClassNotFoundException -> 0x03d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x03dd  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c5 A[SYNTHETIC, Splitter:B:20:0x00c5] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x05b3 A[Catch:{ all -> 0x0614, all -> 0x05b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x05b4 A[Catch:{ all -> 0x0614, all -> 0x05b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x078e A[Catch:{ all -> 0x0870, all -> 0x07f5, all -> 0x0884, all -> 0x0778 }] */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x078f A[Catch:{ all -> 0x0870, all -> 0x07f5, all -> 0x0884, all -> 0x0778 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f1 A[SYNTHETIC, Splitter:B:28:0x00f1] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x011d A[SYNTHETIC, Splitter:B:36:0x011d] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:546:0x0fab A[Catch:{ all -> 0x0f91, all -> 0x0f09, all -> 0x0eff, all -> 0x0ef5, all -> 0x0eeb, all -> 0x0ee1, all -> 0x0fc1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:547:0x0fac A[Catch:{ all -> 0x0f91, all -> 0x0f09, all -> 0x0eff, all -> 0x0ef5, all -> 0x0eeb, all -> 0x0ee1, all -> 0x0fc1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01a5 A[SYNTHETIC, Splitter:B:56:0x01a5] */
    /* JADX WARNING: Removed duplicated region for block: B:598:0x10c6 A[Catch:{ all -> 0x1766, all -> 0x173f, all -> 0x1735, all -> 0x1659, all -> 0x164d, all -> 0x10b0, all -> 0x0ed7, all -> 0x0ecd, all -> 0x0ebb, all -> 0x10c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:599:0x10c7 A[Catch:{ all -> 0x1766, all -> 0x173f, all -> 0x1735, all -> 0x1659, all -> 0x164d, all -> 0x10b0, all -> 0x0ed7, all -> 0x0ecd, all -> 0x0ebb, all -> 0x10c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:756:0x164b A[Catch:{ all -> 0x1766, all -> 0x173f, all -> 0x1735, all -> 0x1659, all -> 0x164d, all -> 0x10b0, all -> 0x0ed7, all -> 0x0ecd, all -> 0x0ebb, all -> 0x10c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:757:0x164c A[Catch:{ all -> 0x1766, all -> 0x173f, all -> 0x1735, all -> 0x1659, all -> 0x164d, all -> 0x10b0, all -> 0x0ed7, all -> 0x0ecd, all -> 0x0ebb, all -> 0x10c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:782:0x16b9 A[Catch:{ all -> 0x1766, all -> 0x173f, all -> 0x1735, all -> 0x1659, all -> 0x164d, all -> 0x10b0, all -> 0x0ed7, all -> 0x0ecd, all -> 0x0ebb, all -> 0x10c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:783:0x16ba A[Catch:{ all -> 0x1766, all -> 0x173f, all -> 0x1735, all -> 0x1659, all -> 0x164d, all -> 0x10b0, all -> 0x0ed7, all -> 0x0ecd, all -> 0x0ebb, all -> 0x10c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:812:0x1764 A[Catch:{ all -> 0x1766, all -> 0x173f, all -> 0x1735, all -> 0x1659, all -> 0x164d, all -> 0x10b0, all -> 0x0ed7, all -> 0x0ecd, all -> 0x0ebb, all -> 0x10c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:813:0x1765 A[Catch:{ all -> 0x1766, all -> 0x173f, all -> 0x1735, all -> 0x1659, all -> 0x164d, all -> 0x10b0, all -> 0x0ed7, all -> 0x0ecd, all -> 0x0ebb, all -> 0x10c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:837:0x17ee A[Catch:{ all -> 0x1885, all -> 0x1876, all -> 0x1867, all -> 0x1840, all -> 0x1814, all -> 0x1806, all -> 0x17fb, all -> 0x17f0, all -> 0x1865 }] */
    /* JADX WARNING: Removed duplicated region for block: B:838:0x17ef A[Catch:{ all -> 0x1885, all -> 0x1876, all -> 0x1867, all -> 0x1840, all -> 0x1814, all -> 0x1806, all -> 0x17fb, all -> 0x17f0, all -> 0x1865 }] */
    /* JADX WARNING: Removed duplicated region for block: B:869:0x183e A[Catch:{ all -> 0x1885, all -> 0x1876, all -> 0x1867, all -> 0x1840, all -> 0x1814, all -> 0x1806, all -> 0x17fb, all -> 0x17f0, all -> 0x1865 }] */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x183f A[Catch:{ all -> 0x1885, all -> 0x1876, all -> 0x1867, all -> 0x1840, all -> 0x1814, all -> 0x1806, all -> 0x17fb, all -> 0x17f0, all -> 0x1865 }] */
    /* JADX WARNING: Removed duplicated region for block: B:882:0x1863 A[Catch:{ all -> 0x1885, all -> 0x1876, all -> 0x1867, all -> 0x1840, all -> 0x1814, all -> 0x1806, all -> 0x17fb, all -> 0x17f0, all -> 0x1865 }] */
    /* JADX WARNING: Removed duplicated region for block: B:883:0x1864 A[Catch:{ all -> 0x1885, all -> 0x1876, all -> 0x1867, all -> 0x1840, all -> 0x1814, all -> 0x1806, all -> 0x17fb, all -> 0x17f0, all -> 0x1865 }] */
    /* JADX WARNING: Removed duplicated region for block: B:911:0x18b4 A[SYNTHETIC, Splitter:B:911:0x18b4] */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x18c9 A[Catch:{ all -> 0x1993, all -> 0x1989, all -> 0x197f, all -> 0x1975, all -> 0x1930, all -> 0x0290, Exception -> 0x199d }] */
    /* JADX WARNING: Removed duplicated region for block: B:923:0x18cc A[Catch:{ all -> 0x1993, all -> 0x1989, all -> 0x197f, all -> 0x1975, all -> 0x1930, all -> 0x0290, Exception -> 0x199d }] */
    /* JADX WARNING: Removed duplicated region for block: B:926:0x18d2 A[Catch:{ all -> 0x1993, all -> 0x1989, all -> 0x197f, all -> 0x1975, all -> 0x1930, all -> 0x0290, Exception -> 0x199d }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0388 A[Catch:{ ClassNotFoundException -> 0x03d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0389 A[Catch:{ ClassNotFoundException -> 0x03d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:964:0x18e1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x18c6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0396 A[Catch:{ ClassNotFoundException -> 0x03d9 }] */
    static {
        /*
            java.lang.Class<byte[]> r1 = byte[].class
            init$0()
            r2 = 3
            onDeepLinkingNative = r2
            r3 = 8
            byte[] r4 = new byte[r3]
            r4 = {-52, -124, 37, -55, -13, -73, -128, 118} // fill-array
            onAttributionFailureNative = r4
            r4 = 988066554(0x3ae4b2fa, float:0.0017448359)
            AppsFlyer2dXConversionCallback = r4
            r4 = -7937889260936542951(0x91d6f3c61f7d4519, double:-9.921294222566781E-223)
            init = r4
            byte[] r4 = onConversionDataSuccess     // Catch:{ Exception -> 0x199d }
            r5 = 546(0x222, float:7.65E-43)
            byte r5 = r4[r5]     // Catch:{ Exception -> 0x199d }
            byte r5 = (byte) r5     // Catch:{ Exception -> 0x199d }
            r6 = r5 | 729(0x2d9, float:1.022E-42)
            short r6 = (short) r6     // Catch:{ Exception -> 0x199d }
            r7 = 135(0x87, float:1.89E-43)
            byte r8 = r4[r7]     // Catch:{ Exception -> 0x199d }
            byte r8 = (byte) r8     // Catch:{ Exception -> 0x199d }
            java.lang.String r5 = $$c(r5, r6, r8)     // Catch:{ Exception -> 0x199d }
            java.lang.Object r6 = onInstallConversionFailureNative     // Catch:{ Exception -> 0x199d }
            r8 = 26
            if (r6 != 0) goto L_0x0039
            r6 = 61
            goto L_0x003a
        L_0x0039:
            r6 = r8
        L_0x003a:
            r9 = 0
            if (r6 == r8) goto L_0x004f
            r6 = 113(0x71, float:1.58E-43)
            byte r6 = r4[r6]     // Catch:{ Exception -> 0x199d }
            byte r6 = (byte) r6     // Catch:{ Exception -> 0x199d }
            r10 = 224(0xe0, float:3.14E-43)
            byte r10 = r4[r10]     // Catch:{ Exception -> 0x199d }
            short r10 = (short) r10     // Catch:{ Exception -> 0x199d }
            byte r11 = r4[r7]     // Catch:{ Exception -> 0x199d }
            byte r11 = (byte) r11     // Catch:{ Exception -> 0x199d }
            java.lang.String r6 = $$c(r6, r10, r11)     // Catch:{ Exception -> 0x199d }
            goto L_0x0050
        L_0x004f:
            r6 = r9
        L_0x0050:
            r10 = 17
            r11 = 0
            r12 = 1
            byte r13 = r4[r12]     // Catch:{ Exception -> 0x0089 }
            byte r13 = (byte) r13     // Catch:{ Exception -> 0x0089 }
            r14 = 244(0xf4, float:3.42E-43)
            short r14 = (short) r14     // Catch:{ Exception -> 0x0089 }
            r15 = 631(0x277, float:8.84E-43)
            byte r15 = r4[r15]     // Catch:{ Exception -> 0x0089 }
            byte r15 = (byte) r15     // Catch:{ Exception -> 0x0089 }
            java.lang.String r13 = $$c(r13, r14, r15)     // Catch:{ Exception -> 0x0089 }
            java.lang.Class r13 = java.lang.Class.forName(r13)     // Catch:{ Exception -> 0x0089 }
            r14 = 146(0x92, float:2.05E-43)
            byte r14 = r4[r14]     // Catch:{ Exception -> 0x0089 }
            byte r14 = (byte) r14     // Catch:{ Exception -> 0x0089 }
            r15 = r14 ^ 864(0x360, float:1.211E-42)
            r8 = r14 & 864(0x360, float:1.211E-42)
            r8 = r8 | r15
            short r8 = (short) r8     // Catch:{ Exception -> 0x0089 }
            byte r4 = r4[r7]     // Catch:{ Exception -> 0x0089 }
            byte r4 = (byte) r4     // Catch:{ Exception -> 0x0089 }
            java.lang.String r4 = $$c(r14, r8, r4)     // Catch:{ Exception -> 0x0089 }
            java.lang.Class[] r8 = new java.lang.Class[r11]     // Catch:{ Exception -> 0x0089 }
            java.lang.reflect.Method r4 = r13.getMethod(r4, r8)     // Catch:{ Exception -> 0x0089 }
            r8 = r9
            java.lang.Object[] r8 = (java.lang.Object[]) r8     // Catch:{ Exception -> 0x0089 }
            java.lang.Object r4 = r4.invoke(r9, r9)     // Catch:{ Exception -> 0x0089 }
            if (r4 == 0) goto L_0x008a
            goto L_0x00c3
        L_0x0089:
            r4 = r9
        L_0x008a:
            byte[] r8 = onConversionDataSuccess     // Catch:{ Exception -> 0x00c3 }
            r13 = 84
            byte r13 = r8[r13]     // Catch:{ Exception -> 0x00c3 }
            byte r13 = (byte) r13     // Catch:{ Exception -> 0x00c3 }
            r14 = 524(0x20c, float:7.34E-43)
            short r14 = (short) r14     // Catch:{ Exception -> 0x00c3 }
            r15 = 631(0x277, float:8.84E-43)
            byte r15 = r8[r15]     // Catch:{ Exception -> 0x00c3 }
            byte r15 = (byte) r15     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r13 = $$c(r13, r14, r15)     // Catch:{ Exception -> 0x00c3 }
            java.lang.Class r13 = java.lang.Class.forName(r13)     // Catch:{ Exception -> 0x00c3 }
            r14 = 434(0x1b2, float:6.08E-43)
            byte r14 = r8[r14]     // Catch:{ Exception -> 0x00c3 }
            byte r14 = (byte) r14     // Catch:{ Exception -> 0x00c3 }
            int r15 = onResponseNative     // Catch:{ Exception -> 0x00c3 }
            r16 = r15 ^ 7
            r15 = r15 & 7
            r15 = r16 | r15
            short r15 = (short) r15     // Catch:{ Exception -> 0x00c3 }
            byte r8 = r8[r10]     // Catch:{ Exception -> 0x00c3 }
            byte r8 = (byte) r8     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r8 = $$c(r14, r15, r8)     // Catch:{ Exception -> 0x00c3 }
            java.lang.Class[] r14 = new java.lang.Class[r11]     // Catch:{ Exception -> 0x00c3 }
            java.lang.reflect.Method r8 = r13.getMethod(r8, r14)     // Catch:{ Exception -> 0x00c3 }
            r13 = r9
            java.lang.Object[] r13 = (java.lang.Object[]) r13     // Catch:{ Exception -> 0x00c3 }
            java.lang.Object r4 = r8.invoke(r9, r9)     // Catch:{ Exception -> 0x00c3 }
        L_0x00c3:
            if (r4 == 0) goto L_0x00e9
            java.lang.Class r8 = r4.getClass()     // Catch:{ Exception -> 0x00e9 }
            byte[] r13 = onConversionDataSuccess     // Catch:{ Exception -> 0x00e9 }
            r14 = 33
            byte r14 = r13[r14]     // Catch:{ Exception -> 0x00e9 }
            byte r14 = (byte) r14     // Catch:{ Exception -> 0x00e9 }
            r15 = 721(0x2d1, float:1.01E-42)
            short r15 = (short) r15     // Catch:{ Exception -> 0x00e9 }
            byte r13 = r13[r10]     // Catch:{ Exception -> 0x00e9 }
            byte r13 = (byte) r13     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r13 = $$c(r14, r15, r13)     // Catch:{ Exception -> 0x00e9 }
            r14 = r9
            java.lang.Class[] r14 = (java.lang.Class[]) r14     // Catch:{ Exception -> 0x00e9 }
            java.lang.reflect.Method r8 = r8.getMethod(r13, r9)     // Catch:{ Exception -> 0x00e9 }
            r13 = r9
            java.lang.Object[] r13 = (java.lang.Object[]) r13     // Catch:{ Exception -> 0x00e9 }
            java.lang.Object r8 = r8.invoke(r4, r9)     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00ea
        L_0x00e9:
            r8 = r9
        L_0x00ea:
            if (r4 == 0) goto L_0x00ee
            r13 = r12
            goto L_0x00ef
        L_0x00ee:
            r13 = r11
        L_0x00ef:
            if (r13 == 0) goto L_0x0115
            java.lang.Class r13 = r4.getClass()     // Catch:{ Exception -> 0x0115 }
            byte[] r14 = onConversionDataSuccess     // Catch:{ Exception -> 0x0115 }
            r15 = 24
            byte r15 = r14[r15]     // Catch:{ Exception -> 0x0115 }
            byte r15 = (byte) r15     // Catch:{ Exception -> 0x0115 }
            r3 = 634(0x27a, float:8.88E-43)
            short r3 = (short) r3     // Catch:{ Exception -> 0x0115 }
            byte r14 = r14[r10]     // Catch:{ Exception -> 0x0115 }
            byte r14 = (byte) r14     // Catch:{ Exception -> 0x0115 }
            java.lang.String r3 = $$c(r15, r3, r14)     // Catch:{ Exception -> 0x0115 }
            r14 = r9
            java.lang.Class[] r14 = (java.lang.Class[]) r14     // Catch:{ Exception -> 0x0115 }
            java.lang.reflect.Method r3 = r13.getMethod(r3, r9)     // Catch:{ Exception -> 0x0115 }
            r13 = r9
            java.lang.Object[] r13 = (java.lang.Object[]) r13     // Catch:{ Exception -> 0x0115 }
            java.lang.Object r3 = r3.invoke(r4, r9)     // Catch:{ Exception -> 0x0115 }
            goto L_0x0116
        L_0x0115:
            r3 = r9
        L_0x0116:
            if (r4 == 0) goto L_0x011a
            r13 = r11
            goto L_0x011b
        L_0x011a:
            r13 = r12
        L_0x011b:
            if (r13 == r12) goto L_0x0141
            java.lang.Class r13 = r4.getClass()     // Catch:{ Exception -> 0x0141 }
            byte[] r14 = onConversionDataSuccess     // Catch:{ Exception -> 0x0141 }
            r15 = 33
            byte r15 = r14[r15]     // Catch:{ Exception -> 0x0141 }
            byte r15 = (byte) r15     // Catch:{ Exception -> 0x0141 }
            r2 = 707(0x2c3, float:9.91E-43)
            short r2 = (short) r2     // Catch:{ Exception -> 0x0141 }
            byte r14 = r14[r10]     // Catch:{ Exception -> 0x0141 }
            byte r14 = (byte) r14     // Catch:{ Exception -> 0x0141 }
            java.lang.String r2 = $$c(r15, r2, r14)     // Catch:{ Exception -> 0x0141 }
            r14 = r9
            java.lang.Class[] r14 = (java.lang.Class[]) r14     // Catch:{ Exception -> 0x0141 }
            java.lang.reflect.Method r2 = r13.getMethod(r2, r9)     // Catch:{ Exception -> 0x0141 }
            r13 = r9
            java.lang.Object[] r13 = (java.lang.Object[]) r13     // Catch:{ Exception -> 0x0141 }
            java.lang.Object r2 = r2.invoke(r4, r9)     // Catch:{ Exception -> 0x0141 }
            goto L_0x0142
        L_0x0141:
            r2 = r9
        L_0x0142:
            if (r8 == 0) goto L_0x0146
            r4 = r12
            goto L_0x0147
        L_0x0146:
            r4 = r11
        L_0x0147:
            r13 = 108(0x6c, float:1.51E-43)
            r14 = 98
            if (r4 == 0) goto L_0x014e
            goto L_0x01a1
        L_0x014e:
            if (r6 != 0) goto L_0x0152
            r4 = r11
            goto L_0x0153
        L_0x0152:
            r4 = r12
        L_0x0153:
            if (r4 == r12) goto L_0x0157
            r8 = r9
            goto L_0x01a1
        L_0x0157:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x199d }
            r4.<init>()     // Catch:{ Exception -> 0x199d }
            byte[] r8 = onConversionDataSuccess     // Catch:{ Exception -> 0x199d }
            r15 = 33
            byte r15 = r8[r15]     // Catch:{ Exception -> 0x199d }
            byte r15 = (byte) r15     // Catch:{ Exception -> 0x199d }
            r7 = 359(0x167, float:5.03E-43)
            short r7 = (short) r7     // Catch:{ Exception -> 0x199d }
            r19 = 10
            byte r9 = r8[r19]     // Catch:{ Exception -> 0x199d }
            byte r9 = (byte) r9     // Catch:{ Exception -> 0x199d }
            java.lang.String r7 = $$c(r15, r7, r9)     // Catch:{ Exception -> 0x199d }
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch:{ Exception -> 0x199d }
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch:{ Exception -> 0x199d }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x199d }
            java.lang.Object[] r6 = new java.lang.Object[r12]     // Catch:{ all -> 0x1993 }
            r6[r11] = r4     // Catch:{ all -> 0x1993 }
            byte r4 = r8[r13]     // Catch:{ all -> 0x1993 }
            byte r4 = (byte) r4     // Catch:{ all -> 0x1993 }
            r7 = r4 ^ 112(0x70, float:1.57E-43)
            r9 = r4 & 112(0x70, float:1.57E-43)
            r7 = r7 | r9
            short r7 = (short) r7     // Catch:{ all -> 0x1993 }
            byte r8 = r8[r14]     // Catch:{ all -> 0x1993 }
            byte r8 = (byte) r8     // Catch:{ all -> 0x1993 }
            java.lang.String r4 = $$c(r4, r7, r8)     // Catch:{ all -> 0x1993 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x1993 }
            java.lang.Class[] r7 = new java.lang.Class[r12]     // Catch:{ all -> 0x1993 }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r7[r11] = r8     // Catch:{ all -> 0x1993 }
            java.lang.reflect.Constructor r4 = r4.getDeclaredConstructor(r7)     // Catch:{ all -> 0x1993 }
            java.lang.Object r8 = r4.newInstance(r6)     // Catch:{ all -> 0x1993 }
        L_0x01a1:
            r4 = 4
            if (r2 == 0) goto L_0x01a5
            goto L_0x020f
        L_0x01a5:
            byte[] r2 = onConversionDataSuccess     // Catch:{ Exception -> 0x199d }
            r6 = 196(0xc4, float:2.75E-43)
            byte r6 = r2[r6]     // Catch:{ Exception -> 0x199d }
            byte r6 = (byte) r6     // Catch:{ Exception -> 0x199d }
            r7 = 281(0x119, float:3.94E-43)
            short r7 = (short) r7     // Catch:{ Exception -> 0x199d }
            byte r9 = r2[r14]     // Catch:{ Exception -> 0x199d }
            byte r9 = (byte) r9     // Catch:{ Exception -> 0x199d }
            java.lang.String r6 = $$c(r6, r7, r9)     // Catch:{ Exception -> 0x199d }
            java.lang.Object[] r7 = new java.lang.Object[r12]     // Catch:{ all -> 0x1989 }
            r7[r11] = r6     // Catch:{ all -> 0x1989 }
            byte r6 = r2[r4]     // Catch:{ all -> 0x1989 }
            byte r6 = (byte) r6     // Catch:{ all -> 0x1989 }
            r9 = 896(0x380, float:1.256E-42)
            short r9 = (short) r9     // Catch:{ all -> 0x1989 }
            byte r15 = r2[r14]     // Catch:{ all -> 0x1989 }
            byte r15 = (byte) r15     // Catch:{ all -> 0x1989 }
            java.lang.String r6 = $$c(r6, r9, r15)     // Catch:{ all -> 0x1989 }
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x1989 }
            r9 = 33
            byte r9 = r2[r9]     // Catch:{ all -> 0x1989 }
            byte r9 = (byte) r9     // Catch:{ all -> 0x1989 }
            r15 = 268(0x10c, float:3.76E-43)
            short r15 = (short) r15     // Catch:{ all -> 0x1989 }
            byte r4 = r2[r10]     // Catch:{ all -> 0x1989 }
            byte r4 = (byte) r4     // Catch:{ all -> 0x1989 }
            java.lang.String r4 = $$c(r9, r15, r4)     // Catch:{ all -> 0x1989 }
            java.lang.Class[] r9 = new java.lang.Class[r12]     // Catch:{ all -> 0x1989 }
            java.lang.Class<java.lang.String> r15 = java.lang.String.class
            r9[r11] = r15     // Catch:{ all -> 0x1989 }
            java.lang.reflect.Method r4 = r6.getMethod(r4, r9)     // Catch:{ all -> 0x1989 }
            r6 = 0
            java.lang.Object r4 = r4.invoke(r6, r7)     // Catch:{ all -> 0x1989 }
            java.lang.Object[] r6 = new java.lang.Object[r12]     // Catch:{ all -> 0x197f }
            r6[r11] = r4     // Catch:{ all -> 0x197f }
            byte r4 = r2[r13]     // Catch:{ all -> 0x197f }
            byte r4 = (byte) r4     // Catch:{ all -> 0x197f }
            r7 = r4 ^ 112(0x70, float:1.57E-43)
            r9 = r4 & 112(0x70, float:1.57E-43)
            r7 = r7 | r9
            short r7 = (short) r7     // Catch:{ all -> 0x197f }
            byte r2 = r2[r14]     // Catch:{ all -> 0x197f }
            byte r2 = (byte) r2     // Catch:{ all -> 0x197f }
            java.lang.String r2 = $$c(r4, r7, r2)     // Catch:{ all -> 0x197f }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x197f }
            java.lang.Class[] r4 = new java.lang.Class[r12]     // Catch:{ all -> 0x197f }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r4[r11] = r7     // Catch:{ all -> 0x197f }
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r4)     // Catch:{ all -> 0x197f }
            java.lang.Object r2 = r2.newInstance(r6)     // Catch:{ all -> 0x197f }
        L_0x020f:
            if (r3 != 0) goto L_0x0213
            r4 = r12
            goto L_0x0214
        L_0x0213:
            r4 = r11
        L_0x0214:
            r6 = 2
            if (r4 == 0) goto L_0x029a
            int r4 = onAppOpenAttribution
            r7 = r4 & 17
            r9 = r4 | 17
            int r7 = r7 + r9
            int r9 = r7 % 128
            onResponseErrorNative = r9
            int r7 = r7 % r6
            if (r8 == 0) goto L_0x029a
            int r4 = r4 + 49
            int r3 = r4 % 128
            onResponseErrorNative = r3
            int r4 = r4 % r6
            if (r4 == 0) goto L_0x0242
            byte[] r3 = onConversionDataSuccess     // Catch:{ Exception -> 0x199d }
            r4 = 52
            byte r4 = r3[r4]     // Catch:{ Exception -> 0x199d }
            byte r4 = (byte) r4     // Catch:{ Exception -> 0x199d }
            r7 = 16500(0x4074, float:2.3121E-41)
            short r7 = (short) r7     // Catch:{ Exception -> 0x199d }
            r9 = 26197(0x6655, float:3.671E-41)
            byte r3 = r3[r9]     // Catch:{ Exception -> 0x199d }
        L_0x023c:
            byte r3 = (byte) r3     // Catch:{ Exception -> 0x199d }
            java.lang.String r3 = $$c(r4, r7, r3)     // Catch:{ Exception -> 0x199d }
            goto L_0x0251
        L_0x0242:
            byte[] r3 = onConversionDataSuccess     // Catch:{ Exception -> 0x199d }
            r4 = 12
            byte r4 = r3[r4]     // Catch:{ Exception -> 0x199d }
            byte r4 = (byte) r4     // Catch:{ Exception -> 0x199d }
            r7 = 674(0x2a2, float:9.44E-43)
            short r7 = (short) r7     // Catch:{ Exception -> 0x199d }
            r9 = 135(0x87, float:1.89E-43)
            byte r3 = r3[r9]     // Catch:{ Exception -> 0x199d }
            goto L_0x023c
        L_0x0251:
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch:{ all -> 0x0290 }
            r4[r12] = r3     // Catch:{ all -> 0x0290 }
            r4[r11] = r8     // Catch:{ all -> 0x0290 }
            byte[] r3 = onConversionDataSuccess     // Catch:{ all -> 0x0290 }
            byte r7 = r3[r13]     // Catch:{ all -> 0x0290 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x0290 }
            r9 = r7 | 112(0x70, float:1.57E-43)
            short r9 = (short) r9     // Catch:{ all -> 0x0290 }
            byte r15 = r3[r14]     // Catch:{ all -> 0x0290 }
            byte r15 = (byte) r15     // Catch:{ all -> 0x0290 }
            java.lang.String r7 = $$c(r7, r9, r15)     // Catch:{ all -> 0x0290 }
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x0290 }
            java.lang.Class[] r9 = new java.lang.Class[r6]     // Catch:{ all -> 0x0290 }
            byte r15 = r3[r13]     // Catch:{ all -> 0x0290 }
            byte r15 = (byte) r15     // Catch:{ all -> 0x0290 }
            r20 = r15 ^ 112(0x70, float:1.57E-43)
            r21 = r15 & 112(0x70, float:1.57E-43)
            r6 = r20 | r21
            short r6 = (short) r6     // Catch:{ all -> 0x0290 }
            byte r3 = r3[r14]     // Catch:{ all -> 0x0290 }
            byte r3 = (byte) r3     // Catch:{ all -> 0x0290 }
            java.lang.String r3 = $$c(r15, r6, r3)     // Catch:{ all -> 0x0290 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x0290 }
            r9[r11] = r3     // Catch:{ all -> 0x0290 }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r9[r12] = r3     // Catch:{ all -> 0x0290 }
            java.lang.reflect.Constructor r3 = r7.getDeclaredConstructor(r9)     // Catch:{ all -> 0x0290 }
            java.lang.Object r3 = r3.newInstance(r4)     // Catch:{ all -> 0x0290 }
            goto L_0x029a
        L_0x0290:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x199d }
            if (r2 == 0) goto L_0x0299
            throw r2     // Catch:{ Exception -> 0x199d }
        L_0x0299:
            throw r1     // Catch:{ Exception -> 0x199d }
        L_0x029a:
            byte[] r4 = onConversionDataSuccess     // Catch:{ all -> 0x1975 }
            r6 = 84
            byte r6 = r4[r6]     // Catch:{ all -> 0x1975 }
            byte r6 = (byte) r6     // Catch:{ all -> 0x1975 }
            int r7 = onResponseNative     // Catch:{ all -> 0x1975 }
            r7 = r7 | 260(0x104, float:3.64E-43)
            short r7 = (short) r7     // Catch:{ all -> 0x1975 }
            r9 = 631(0x277, float:8.84E-43)
            byte r9 = r4[r9]     // Catch:{ all -> 0x1975 }
            byte r9 = (byte) r9     // Catch:{ all -> 0x1975 }
            java.lang.String r6 = $$c(r6, r7, r9)     // Catch:{ all -> 0x1975 }
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x1975 }
            r7 = 604(0x25c, float:8.46E-43)
            byte r7 = r4[r7]     // Catch:{ all -> 0x1975 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x1975 }
            r9 = 503(0x1f7, float:7.05E-43)
            short r9 = (short) r9     // Catch:{ all -> 0x1975 }
            byte r15 = r4[r10]     // Catch:{ all -> 0x1975 }
            byte r15 = (byte) r15     // Catch:{ all -> 0x1975 }
            java.lang.String r7 = $$c(r7, r9, r15)     // Catch:{ all -> 0x1975 }
            r9 = 0
            java.lang.reflect.Method r6 = r6.getMethod(r7, r9)     // Catch:{ all -> 0x1975 }
            java.lang.Object r6 = r6.invoke(r9, r9)     // Catch:{ all -> 0x1975 }
            byte r7 = r4[r13]     // Catch:{ Exception -> 0x199d }
            byte r7 = (byte) r7     // Catch:{ Exception -> 0x199d }
            r9 = r7 ^ 112(0x70, float:1.57E-43)
            r15 = r7 & 112(0x70, float:1.57E-43)
            r9 = r9 | r15
            short r9 = (short) r9     // Catch:{ Exception -> 0x199d }
            byte r15 = r4[r14]     // Catch:{ Exception -> 0x199d }
            byte r15 = (byte) r15     // Catch:{ Exception -> 0x199d }
            java.lang.String r7 = $$c(r7, r9, r15)     // Catch:{ Exception -> 0x199d }
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ Exception -> 0x199d }
            r9 = 9
            java.lang.Object r7 = java.lang.reflect.Array.newInstance(r7, r9)     // Catch:{ Exception -> 0x199d }
            java.lang.Object[] r7 = (java.lang.Object[]) r7     // Catch:{ Exception -> 0x199d }
            r15 = 0
            r7[r11] = r15     // Catch:{ Exception -> 0x199d }
            r7[r12] = r3     // Catch:{ Exception -> 0x199d }
            r15 = 2
            r7[r15] = r8     // Catch:{ Exception -> 0x199d }
            r15 = 3
            r7[r15] = r2     // Catch:{ Exception -> 0x199d }
            r15 = 4
            r7[r15] = r6     // Catch:{ Exception -> 0x199d }
            r15 = 5
            r7[r15] = r3     // Catch:{ Exception -> 0x199d }
            r3 = 6
            r7[r3] = r8     // Catch:{ Exception -> 0x199d }
            r3 = 7
            r7[r3] = r2     // Catch:{ Exception -> 0x199d }
            r2 = 8
            r7[r2] = r6     // Catch:{ Exception -> 0x199d }
            boolean[] r2 = new boolean[r9]     // Catch:{ Exception -> 0x199d }
            r2[r11] = r11     // Catch:{ Exception -> 0x199d }
            r2[r12] = r12     // Catch:{ Exception -> 0x199d }
            r3 = 2
            r2[r3] = r12     // Catch:{ Exception -> 0x199d }
            r3 = 3
            r2[r3] = r12     // Catch:{ Exception -> 0x199d }
            r3 = 4
            r2[r3] = r12     // Catch:{ Exception -> 0x199d }
            r3 = 5
            r2[r3] = r12     // Catch:{ Exception -> 0x199d }
            r3 = 6
            r2[r3] = r12     // Catch:{ Exception -> 0x199d }
            r3 = 7
            r2[r3] = r12     // Catch:{ Exception -> 0x199d }
            r3 = 8
            r2[r3] = r12     // Catch:{ Exception -> 0x199d }
            boolean[] r3 = new boolean[r9]     // Catch:{ Exception -> 0x199d }
            r3[r11] = r11     // Catch:{ Exception -> 0x199d }
            r3[r12] = r11     // Catch:{ Exception -> 0x199d }
            r6 = 2
            r3[r6] = r11     // Catch:{ Exception -> 0x199d }
            r6 = 3
            r3[r6] = r11     // Catch:{ Exception -> 0x199d }
            r6 = 4
            r3[r6] = r11     // Catch:{ Exception -> 0x199d }
            r6 = 5
            r3[r6] = r12     // Catch:{ Exception -> 0x199d }
            r6 = 6
            r3[r6] = r12     // Catch:{ Exception -> 0x199d }
            r6 = 7
            r3[r6] = r12     // Catch:{ Exception -> 0x199d }
            r6 = 8
            r3[r6] = r12     // Catch:{ Exception -> 0x199d }
            boolean[] r6 = new boolean[r9]     // Catch:{ Exception -> 0x199d }
            r6[r11] = r11     // Catch:{ Exception -> 0x199d }
            r6[r12] = r11     // Catch:{ Exception -> 0x199d }
            r8 = 2
            r6[r8] = r12     // Catch:{ Exception -> 0x199d }
            r8 = 3
            r6[r8] = r12     // Catch:{ Exception -> 0x199d }
            r8 = 4
            r6[r8] = r11     // Catch:{ Exception -> 0x199d }
            r8 = 5
            r6[r8] = r11     // Catch:{ Exception -> 0x199d }
            r8 = 6
            r6[r8] = r12     // Catch:{ Exception -> 0x199d }
            r8 = 7
            r6[r8] = r12     // Catch:{ Exception -> 0x199d }
            r8 = 8
            r6[r8] = r11     // Catch:{ Exception -> 0x199d }
            r8 = 43
            byte r15 = r4[r8]     // Catch:{ ClassNotFoundException -> 0x03d9 }
            byte r15 = (byte) r15     // Catch:{ ClassNotFoundException -> 0x03d9 }
            r10 = 846(0x34e, float:1.185E-42)
            short r10 = (short) r10     // Catch:{ ClassNotFoundException -> 0x03d9 }
            r21 = 631(0x277, float:8.84E-43)
            byte r8 = r4[r21]     // Catch:{ ClassNotFoundException -> 0x03d9 }
            byte r8 = (byte) r8     // Catch:{ ClassNotFoundException -> 0x03d9 }
            java.lang.String r8 = $$c(r15, r10, r8)     // Catch:{ ClassNotFoundException -> 0x03d9 }
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException -> 0x03d9 }
            r10 = 10
            byte r10 = r4[r10]     // Catch:{ ClassNotFoundException -> 0x03d9 }
            byte r10 = (byte) r10     // Catch:{ ClassNotFoundException -> 0x03d9 }
            r15 = 340(0x154, float:4.76E-43)
            short r15 = (short) r15     // Catch:{ ClassNotFoundException -> 0x03d9 }
            r21 = 673(0x2a1, float:9.43E-43)
            byte r4 = r4[r21]     // Catch:{ ClassNotFoundException -> 0x03d9 }
            byte r4 = (byte) r4     // Catch:{ ClassNotFoundException -> 0x03d9 }
            java.lang.String r4 = $$c(r10, r15, r4)     // Catch:{ ClassNotFoundException -> 0x03d9 }
            java.lang.reflect.Field r4 = r8.getDeclaredField(r4)     // Catch:{ ClassNotFoundException -> 0x03d9 }
            int r4 = r4.getInt(r8)     // Catch:{ ClassNotFoundException -> 0x03d9 }
            r8 = 29
            if (r4 != r8) goto L_0x0389
            goto L_0x038f
        L_0x0389:
            r8 = 26
            if (r4 < r8) goto L_0x038f
            r8 = r12
            goto L_0x0390
        L_0x038f:
            r8 = r11
        L_0x0390:
            r6[r11] = r8     // Catch:{ ClassNotFoundException -> 0x03d9 }
            r8 = 21
            if (r4 < r8) goto L_0x0398
            r8 = r12
            goto L_0x0399
        L_0x0398:
            r8 = r11
        L_0x0399:
            r6[r12] = r8     // Catch:{ ClassNotFoundException -> 0x03d9 }
            r8 = 5
            r10 = 21
            if (r4 < r10) goto L_0x03b0
            int r10 = onAppOpenAttribution
            r15 = r10 | 75
            int r15 = r15 << r12
            r10 = r10 ^ 75
            int r15 = r15 - r10
            int r10 = r15 % 128
            onResponseErrorNative = r10
            r10 = 2
            int r15 = r15 % r10
            r10 = r12
            goto L_0x03b1
        L_0x03b0:
            r10 = r11
        L_0x03b1:
            r6[r8] = r10     // Catch:{ ClassNotFoundException -> 0x03d9 }
            r8 = 16
            if (r4 >= r8) goto L_0x03ba
            r8 = 50
            goto L_0x03bb
        L_0x03ba:
            r8 = r12
        L_0x03bb:
            if (r8 == r12) goto L_0x03ca
            int r8 = onResponseErrorNative
            int r8 = r8 + 42
            int r8 = r8 - r12
            int r10 = r8 % 128
            onAppOpenAttribution = r10
            r10 = 2
            int r8 = r8 % r10
            r8 = r12
            goto L_0x03cb
        L_0x03ca:
            r8 = r11
        L_0x03cb:
            r10 = 4
            r6[r10] = r8     // Catch:{ ClassNotFoundException -> 0x03d9 }
            r8 = 16
            if (r4 >= r8) goto L_0x03d4
            r4 = r12
            goto L_0x03d5
        L_0x03d4:
            r4 = r11
        L_0x03d5:
            r8 = 8
            r6[r8] = r4     // Catch:{ ClassNotFoundException -> 0x03d9 }
        L_0x03d9:
            r4 = r11
            r8 = r4
        L_0x03db:
            if (r4 != 0) goto L_0x1974
            if (r8 >= r9) goto L_0x03e2
            r10 = 27
            goto L_0x03e4
        L_0x03e2:
            r10 = 54
        L_0x03e4:
            r15 = 54
            if (r10 == r15) goto L_0x1974
            boolean r10 = r6[r8]     // Catch:{ Exception -> 0x199d }
            if (r10 == 0) goto L_0x193a
            r15 = 892(0x37c, float:1.25E-42)
            boolean r21 = r2[r8]     // Catch:{ all -> 0x1898 }
            r9 = r7[r8]     // Catch:{ all -> 0x1898 }
            boolean r23 = r3[r8]     // Catch:{ all -> 0x1898 }
            r24 = 110(0x6e, float:1.54E-43)
            r25 = 106(0x6a, float:1.49E-43)
            if (r21 == 0) goto L_0x04ba
            if (r9 == 0) goto L_0x043c
            byte[] r26 = onConversionDataSuccess     // Catch:{ all -> 0x0432 }
            byte r10 = r26[r13]     // Catch:{ all -> 0x0432 }
            byte r10 = (byte) r10     // Catch:{ all -> 0x0432 }
            r13 = r10 | 112(0x70, float:1.57E-43)
            short r13 = (short) r13     // Catch:{ all -> 0x0432 }
            byte r11 = r26[r14]     // Catch:{ all -> 0x0432 }
            byte r11 = (byte) r11     // Catch:{ all -> 0x0432 }
            java.lang.String r10 = $$c(r10, r13, r11)     // Catch:{ all -> 0x0432 }
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch:{ all -> 0x0432 }
            r11 = 152(0x98, float:2.13E-43)
            byte r11 = r26[r11]     // Catch:{ all -> 0x0432 }
            byte r11 = (byte) r11     // Catch:{ all -> 0x0432 }
            r13 = 196(0xc4, float:2.75E-43)
            short r13 = (short) r13     // Catch:{ all -> 0x0432 }
            r18 = 135(0x87, float:1.89E-43)
            byte r14 = r26[r18]     // Catch:{ all -> 0x0432 }
            byte r14 = (byte) r14     // Catch:{ all -> 0x0432 }
            java.lang.String r11 = $$c(r11, r13, r14)     // Catch:{ all -> 0x0432 }
            r13 = 0
            java.lang.reflect.Method r10 = r10.getMethod(r11, r13)     // Catch:{ all -> 0x0432 }
            java.lang.Object r10 = r10.invoke(r9, r13)     // Catch:{ all -> 0x0432 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x0432 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x0432 }
            if (r10 != 0) goto L_0x04ba
            goto L_0x043c
        L_0x0432:
            r0 = move-exception
            r9 = r0
            java.lang.Throwable r10 = r9.getCause()     // Catch:{ all -> 0x1898 }
            if (r10 == 0) goto L_0x043b
            throw r10     // Catch:{ all -> 0x1898 }
        L_0x043b:
            throw r9     // Catch:{ all -> 0x1898 }
        L_0x043c:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x1898 }
            r10.<init>()     // Catch:{ all -> 0x1898 }
            byte[] r11 = onConversionDataSuccess     // Catch:{ all -> 0x1898 }
            byte r13 = r11[r25]     // Catch:{ all -> 0x1898 }
            byte r13 = (byte) r13     // Catch:{ all -> 0x1898 }
            r14 = r13 ^ 576(0x240, float:8.07E-43)
            r12 = r13 & 576(0x240, float:8.07E-43)
            r12 = r12 | r14
            short r12 = (short) r12     // Catch:{ all -> 0x1898 }
            byte r14 = r11[r15]     // Catch:{ all -> 0x1898 }
            byte r14 = (byte) r14     // Catch:{ all -> 0x1898 }
            java.lang.String r12 = $$c(r13, r12, r14)     // Catch:{ all -> 0x1898 }
            java.lang.StringBuilder r10 = r10.append(r12)     // Catch:{ all -> 0x1898 }
            java.lang.StringBuilder r9 = r10.append(r9)     // Catch:{ all -> 0x1898 }
            byte r10 = r11[r24]     // Catch:{ all -> 0x1898 }
            byte r12 = (byte) r10     // Catch:{ all -> 0x1898 }
            r13 = r12 ^ 694(0x2b6, float:9.73E-43)
            r14 = r12 & 694(0x2b6, float:9.73E-43)
            r13 = r13 | r14
            short r13 = (short) r13     // Catch:{ all -> 0x1898 }
            byte r10 = (byte) r10     // Catch:{ all -> 0x1898 }
            java.lang.String r10 = $$c(r12, r13, r10)     // Catch:{ all -> 0x1898 }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x1898 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x1898 }
            int r10 = onAppOpenAttribution
            int r10 = r10 + 42
            r12 = 1
            int r10 = r10 - r12
            int r13 = r10 % 128
            onResponseErrorNative = r13
            r13 = 2
            int r10 = r10 % r13
            java.lang.Object[] r10 = new java.lang.Object[r12]     // Catch:{ all -> 0x04b0 }
            r12 = 0
            r10[r12] = r9     // Catch:{ all -> 0x04b0 }
            r9 = 8
            byte r12 = r11[r9]     // Catch:{ all -> 0x04b0 }
            byte r9 = (byte) r12     // Catch:{ all -> 0x04b0 }
            int r12 = onResponseNative     // Catch:{ all -> 0x04b0 }
            r13 = r12 ^ 53
            r14 = 53
            r12 = r12 & r14
            r12 = r12 | r13
            short r12 = (short) r12     // Catch:{ all -> 0x04b0 }
            r13 = 98
            byte r11 = r11[r13]     // Catch:{ all -> 0x04b0 }
            byte r11 = (byte) r11     // Catch:{ all -> 0x04b0 }
            java.lang.String r9 = $$c(r9, r12, r11)     // Catch:{ all -> 0x04b0 }
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ all -> 0x04b0 }
            r11 = 1
            java.lang.Class[] r12 = new java.lang.Class[r11]     // Catch:{ all -> 0x04b0 }
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            r13 = 0
            r12[r13] = r11     // Catch:{ all -> 0x04b0 }
            java.lang.reflect.Constructor r9 = r9.getDeclaredConstructor(r12)     // Catch:{ all -> 0x04b0 }
            java.lang.Object r9 = r9.newInstance(r10)     // Catch:{ all -> 0x04b0 }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ all -> 0x04b0 }
            throw r9     // Catch:{ all -> 0x04b0 }
        L_0x04b0:
            r0 = move-exception
            r9 = r0
            java.lang.Throwable r10 = r9.getCause()     // Catch:{ all -> 0x1898 }
            if (r10 == 0) goto L_0x04b9
            throw r10     // Catch:{ all -> 0x1898 }
        L_0x04b9:
            throw r9     // Catch:{ all -> 0x1898 }
        L_0x04ba:
            if (r21 == 0) goto L_0x0899
            java.util.Random r10 = new java.util.Random     // Catch:{ all -> 0x0886 }
            r10.<init>()     // Catch:{ all -> 0x0886 }
            int r11 = onAppOpenAttribution
            r12 = r11 & 83
            r11 = r11 | 83
            int r12 = r12 + r11
            int r11 = r12 % 128
            onResponseErrorNative = r11
            r11 = 2
            int r12 = r12 % r11
            byte[] r11 = onConversionDataSuccess     // Catch:{ all -> 0x0870 }
            r12 = 4
            byte r13 = r11[r12]     // Catch:{ all -> 0x0870 }
            byte r12 = (byte) r13     // Catch:{ all -> 0x0870 }
            r13 = 896(0x380, float:1.256E-42)
            short r13 = (short) r13     // Catch:{ all -> 0x0870 }
            r14 = 98
            byte r15 = r11[r14]     // Catch:{ all -> 0x0870 }
            byte r14 = (byte) r15     // Catch:{ all -> 0x0870 }
            java.lang.String r12 = $$c(r12, r13, r14)     // Catch:{ all -> 0x0870 }
            java.lang.Class r12 = java.lang.Class.forName(r12)     // Catch:{ all -> 0x0870 }
            r13 = 13
            byte r13 = r11[r13]     // Catch:{ all -> 0x0870 }
            byte r13 = (byte) r13     // Catch:{ all -> 0x0870 }
            r14 = r13 ^ 77
            r15 = r13 & 77
            r14 = r14 | r15
            short r14 = (short) r14     // Catch:{ all -> 0x0870 }
            r15 = 135(0x87, float:1.89E-43)
            byte r11 = r11[r15]     // Catch:{ all -> 0x0870 }
            byte r11 = (byte) r11     // Catch:{ all -> 0x0870 }
            java.lang.String r11 = $$c(r13, r14, r11)     // Catch:{ all -> 0x0870 }
            r13 = 0
            java.lang.reflect.Method r11 = r12.getMethod(r11, r13)     // Catch:{ all -> 0x0870 }
            java.lang.Object r11 = r11.invoke(r13, r13)     // Catch:{ all -> 0x0870 }
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0870 }
            long r11 = r11.longValue()     // Catch:{ all -> 0x0870 }
            r13 = -1617135332(0xffffffff9f9c791c, double:NaN)
            long r11 = r11 ^ r13
            r10.setSeed(r11)     // Catch:{ all -> 0x0886 }
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x0512:
            if (r11 != 0) goto L_0x0861
            if (r12 != 0) goto L_0x0519
            r15 = 62
            goto L_0x051b
        L_0x0519:
            r15 = 46
        L_0x051b:
            r28 = r2
            r2 = 62
            if (r15 == r2) goto L_0x052b
            if (r13 != 0) goto L_0x0525
            r2 = 5
            goto L_0x052c
        L_0x0525:
            if (r14 != 0) goto L_0x0529
            r2 = 4
            goto L_0x052c
        L_0x0529:
            r2 = 3
            goto L_0x052c
        L_0x052b:
            r2 = 6
        L_0x052c:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x085f }
            int r29 = r2 + 2
            r30 = r3
            r26 = 1
            int r3 = r29 + -1
            r15.<init>(r3)     // Catch:{ all -> 0x085d }
            r3 = 46
            r15.append(r3)     // Catch:{ all -> 0x085d }
            r3 = 0
        L_0x053f:
            if (r3 >= r2) goto L_0x0544
            r29 = 0
            goto L_0x0546
        L_0x0544:
            r29 = 1
        L_0x0546:
            if (r29 == 0) goto L_0x07ff
            java.lang.String r2 = r15.toString()     // Catch:{ all -> 0x085d }
            if (r12 != 0) goto L_0x05bd
            r3 = 2
            java.lang.Object[] r12 = new java.lang.Object[r3]     // Catch:{ all -> 0x05a7 }
            r3 = 1
            r12[r3] = r2     // Catch:{ all -> 0x05a7 }
            r2 = 0
            r12[r2] = r9     // Catch:{ all -> 0x05a7 }
            byte[] r2 = onConversionDataSuccess     // Catch:{ all -> 0x05a7 }
            r3 = 108(0x6c, float:1.51E-43)
            byte r15 = r2[r3]     // Catch:{ all -> 0x05a7 }
            byte r3 = (byte) r15
            r15 = r3 ^ 112(0x70, float:1.57E-43)
            r29 = r3 & 112(0x70, float:1.57E-43)
            r15 = r15 | r29
            short r15 = (short) r15
            r29 = r4
            r27 = 98
            byte r4 = r2[r27]     // Catch:{ all -> 0x05a5 }
            byte r4 = (byte) r4     // Catch:{ all -> 0x05a5 }
            java.lang.String r3 = $$c(r3, r15, r4)     // Catch:{ all -> 0x05a5 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x05a5 }
            r4 = 2
            java.lang.Class[] r15 = new java.lang.Class[r4]     // Catch:{ all -> 0x05a5 }
            r31 = r5
            r4 = 108(0x6c, float:1.51E-43)
            byte r5 = r2[r4]     // Catch:{ all -> 0x05a3 }
            byte r4 = (byte) r5     // Catch:{ all -> 0x05a3 }
            r5 = r4 | 112(0x70, float:1.57E-43)
            short r5 = (short) r5     // Catch:{ all -> 0x05a3 }
            r27 = 98
            byte r2 = r2[r27]     // Catch:{ all -> 0x05a3 }
            byte r2 = (byte) r2     // Catch:{ all -> 0x05a3 }
            java.lang.String r2 = $$c(r4, r5, r2)     // Catch:{ all -> 0x05a3 }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x05a3 }
            r4 = 0
            r15[r4] = r2     // Catch:{ all -> 0x05a3 }
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            r4 = 1
            r15[r4] = r2     // Catch:{ all -> 0x05a3 }
            java.lang.reflect.Constructor r2 = r3.getDeclaredConstructor(r15)     // Catch:{ all -> 0x05a3 }
            java.lang.Object r2 = r2.newInstance(r12)     // Catch:{ all -> 0x05a3 }
            r12 = r2
        L_0x059f:
            r32 = r7
            goto L_0x07e9
        L_0x05a3:
            r0 = move-exception
            goto L_0x05ac
        L_0x05a5:
            r0 = move-exception
            goto L_0x05aa
        L_0x05a7:
            r0 = move-exception
            r29 = r4
        L_0x05aa:
            r31 = r5
        L_0x05ac:
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x05b5 }
            if (r3 == 0) goto L_0x05b4
            throw r3     // Catch:{ all -> 0x05b5 }
        L_0x05b4:
            throw r2     // Catch:{ all -> 0x05b5 }
        L_0x05b5:
            r0 = move-exception
            r2 = r0
            r19 = r6
            r32 = r7
            goto L_0x0894
        L_0x05bd:
            r29 = r4
            r31 = r5
            if (r13 != 0) goto L_0x061e
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0614 }
            r3 = 1
            r4[r3] = r2     // Catch:{ all -> 0x0614 }
            r2 = 0
            r4[r2] = r9     // Catch:{ all -> 0x0614 }
            byte[] r2 = onConversionDataSuccess     // Catch:{ all -> 0x0614 }
            r3 = 108(0x6c, float:1.51E-43)
            byte r5 = r2[r3]     // Catch:{ all -> 0x0614 }
            byte r3 = (byte) r5     // Catch:{ all -> 0x0614 }
            r5 = r3 ^ 112(0x70, float:1.57E-43)
            r13 = r3 & 112(0x70, float:1.57E-43)
            r5 = r5 | r13
            short r5 = (short) r5     // Catch:{ all -> 0x0614 }
            r13 = 98
            byte r15 = r2[r13]     // Catch:{ all -> 0x0614 }
            byte r13 = (byte) r15     // Catch:{ all -> 0x0614 }
            java.lang.String r3 = $$c(r3, r5, r13)     // Catch:{ all -> 0x0614 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x0614 }
            r5 = 2
            java.lang.Class[] r13 = new java.lang.Class[r5]     // Catch:{ all -> 0x0614 }
            r5 = 108(0x6c, float:1.51E-43)
            byte r15 = r2[r5]     // Catch:{ all -> 0x0614 }
            byte r5 = (byte) r15     // Catch:{ all -> 0x0614 }
            r15 = r5 ^ 112(0x70, float:1.57E-43)
            r32 = r5 & 112(0x70, float:1.57E-43)
            r15 = r15 | r32
            short r15 = (short) r15     // Catch:{ all -> 0x0614 }
            r27 = 98
            byte r2 = r2[r27]     // Catch:{ all -> 0x0614 }
            byte r2 = (byte) r2     // Catch:{ all -> 0x0614 }
            java.lang.String r2 = $$c(r5, r15, r2)     // Catch:{ all -> 0x0614 }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0614 }
            r5 = 0
            r13[r5] = r2     // Catch:{ all -> 0x0614 }
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            r5 = 1
            r13[r5] = r2     // Catch:{ all -> 0x0614 }
            java.lang.reflect.Constructor r2 = r3.getDeclaredConstructor(r13)     // Catch:{ all -> 0x0614 }
            java.lang.Object r2 = r2.newInstance(r4)     // Catch:{ all -> 0x0614 }
            r13 = r2
            goto L_0x059f
        L_0x0614:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x05b5 }
            if (r3 == 0) goto L_0x061d
            throw r3     // Catch:{ all -> 0x05b5 }
        L_0x061d:
            throw r2     // Catch:{ all -> 0x05b5 }
        L_0x061e:
            if (r14 != 0) goto L_0x0623
            r3 = 15
            goto L_0x0625
        L_0x0623:
            r3 = 59
        L_0x0625:
            r4 = 15
            if (r3 == r4) goto L_0x0790
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0784 }
            r3 = 1
            r4[r3] = r2     // Catch:{ all -> 0x0784 }
            r2 = 0
            r4[r2] = r9     // Catch:{ all -> 0x0784 }
            byte[] r2 = onConversionDataSuccess     // Catch:{ all -> 0x0784 }
            r3 = 108(0x6c, float:1.51E-43)
            byte r5 = r2[r3]     // Catch:{ all -> 0x0784 }
            byte r3 = (byte) r5     // Catch:{ all -> 0x0784 }
            r5 = r3 ^ 112(0x70, float:1.57E-43)
            r11 = r3 & 112(0x70, float:1.57E-43)
            r5 = r5 | r11
            short r5 = (short) r5     // Catch:{ all -> 0x0784 }
            r11 = 98
            byte r15 = r2[r11]     // Catch:{ all -> 0x0784 }
            byte r11 = (byte) r15     // Catch:{ all -> 0x0784 }
            java.lang.String r3 = $$c(r3, r5, r11)     // Catch:{ all -> 0x0784 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x0784 }
            r5 = 2
            java.lang.Class[] r11 = new java.lang.Class[r5]     // Catch:{ all -> 0x0784 }
            r5 = 108(0x6c, float:1.51E-43)
            byte r15 = r2[r5]     // Catch:{ all -> 0x0784 }
            byte r5 = (byte) r15
            r15 = r5 ^ 112(0x70, float:1.57E-43)
            r32 = r5 & 112(0x70, float:1.57E-43)
            r15 = r15 | r32
            short r15 = (short) r15
            r32 = r7
            r27 = 98
            byte r7 = r2[r27]     // Catch:{ all -> 0x0782 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x0782 }
            java.lang.String r5 = $$c(r5, r15, r7)     // Catch:{ all -> 0x0782 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x0782 }
            r7 = 0
            r11[r7] = r5     // Catch:{ all -> 0x0782 }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r7 = 1
            r11[r7] = r5     // Catch:{ all -> 0x0782 }
            java.lang.reflect.Constructor r3 = r3.getDeclaredConstructor(r11)     // Catch:{ all -> 0x0782 }
            java.lang.Object r3 = r3.newInstance(r4)     // Catch:{ all -> 0x0782 }
            java.lang.Object[] r4 = new java.lang.Object[r7]     // Catch:{ all -> 0x06fc }
            r5 = 0
            r4[r5] = r3     // Catch:{ all -> 0x06fc }
            r5 = 43
            byte r7 = r2[r5]     // Catch:{ all -> 0x06fc }
            byte r5 = (byte) r7     // Catch:{ all -> 0x06fc }
            int r7 = onResponseNative     // Catch:{ all -> 0x06fc }
            r11 = r7 ^ 83
            r15 = r7 & 83
            r11 = r11 | r15
            short r11 = (short) r11     // Catch:{ all -> 0x06fc }
            r33 = r12
            r15 = 98
            byte r12 = r2[r15]     // Catch:{ all -> 0x06fc }
            byte r12 = (byte) r12     // Catch:{ all -> 0x06fc }
            java.lang.String r5 = $$c(r5, r11, r12)     // Catch:{ all -> 0x06fc }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x06fc }
            r11 = 1
            java.lang.Class[] r12 = new java.lang.Class[r11]     // Catch:{ all -> 0x06fc }
            r11 = 108(0x6c, float:1.51E-43)
            byte r15 = r2[r11]     // Catch:{ all -> 0x06fc }
            byte r11 = (byte) r15     // Catch:{ all -> 0x06fc }
            r15 = r11 | 112(0x70, float:1.57E-43)
            short r15 = (short) r15     // Catch:{ all -> 0x06fc }
            r34 = r13
            r27 = 98
            byte r13 = r2[r27]     // Catch:{ all -> 0x06fc }
            byte r13 = (byte) r13     // Catch:{ all -> 0x06fc }
            java.lang.String r11 = $$c(r11, r15, r13)     // Catch:{ all -> 0x06fc }
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch:{ all -> 0x06fc }
            r13 = 0
            r12[r13] = r11     // Catch:{ all -> 0x06fc }
            java.lang.reflect.Constructor r5 = r5.getDeclaredConstructor(r12)     // Catch:{ all -> 0x06fc }
            java.lang.Object r4 = r5.newInstance(r4)     // Catch:{ all -> 0x06fc }
            r5 = 43
            byte r11 = r2[r5]     // Catch:{ all -> 0x06f2 }
            byte r5 = (byte) r11     // Catch:{ all -> 0x06f2 }
            r11 = r7 ^ 83
            r7 = r7 & 83
            r7 = r7 | r11
            short r7 = (short) r7     // Catch:{ all -> 0x06f2 }
            r11 = 98
            byte r12 = r2[r11]     // Catch:{ all -> 0x06f2 }
            byte r11 = (byte) r12     // Catch:{ all -> 0x06f2 }
            java.lang.String r5 = $$c(r5, r7, r11)     // Catch:{ all -> 0x06f2 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x06f2 }
            byte r7 = r2[r25]     // Catch:{ all -> 0x06f2 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x06f2 }
            r11 = r7 | 306(0x132, float:4.29E-43)
            short r11 = (short) r11     // Catch:{ all -> 0x06f2 }
            r12 = 135(0x87, float:1.89E-43)
            byte r2 = r2[r12]     // Catch:{ all -> 0x06f2 }
            byte r2 = (byte) r2     // Catch:{ all -> 0x06f2 }
            java.lang.String r2 = $$c(r7, r11, r2)     // Catch:{ all -> 0x06f2 }
            r7 = 0
            java.lang.reflect.Method r2 = r5.getMethod(r2, r7)     // Catch:{ all -> 0x06f2 }
            r2.invoke(r4, r7)     // Catch:{ all -> 0x06f2 }
            r11 = r3
            goto L_0x07e5
        L_0x06f2:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r4 = r2.getCause()     // Catch:{ Exception -> 0x0706 }
            if (r4 == 0) goto L_0x06fb
            throw r4     // Catch:{ Exception -> 0x0706 }
        L_0x06fb:
            throw r2     // Catch:{ Exception -> 0x0706 }
        L_0x06fc:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r4 = r2.getCause()     // Catch:{ Exception -> 0x0706 }
            if (r4 == 0) goto L_0x0705
            throw r4     // Catch:{ Exception -> 0x0706 }
        L_0x0705:
            throw r2     // Catch:{ Exception -> 0x0706 }
        L_0x0706:
            r0 = move-exception
            r2 = r0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0884 }
            r4.<init>()     // Catch:{ all -> 0x0884 }
            byte[] r5 = onConversionDataSuccess     // Catch:{ all -> 0x0884 }
            byte r7 = r5[r25]     // Catch:{ all -> 0x0884 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x0884 }
            r9 = 112(0x70, float:1.57E-43)
            short r9 = (short) r9     // Catch:{ all -> 0x0884 }
            r10 = 892(0x37c, float:1.25E-42)
            byte r11 = r5[r10]     // Catch:{ all -> 0x0884 }
            byte r10 = (byte) r11     // Catch:{ all -> 0x0884 }
            java.lang.String r7 = $$c(r7, r9, r10)     // Catch:{ all -> 0x0884 }
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch:{ all -> 0x0884 }
            java.lang.StringBuilder r3 = r4.append(r3)     // Catch:{ all -> 0x0884 }
            byte r4 = r5[r24]     // Catch:{ all -> 0x0884 }
            byte r7 = (byte) r4     // Catch:{ all -> 0x0884 }
            r9 = r7 ^ 694(0x2b6, float:9.73E-43)
            r10 = r7 & 694(0x2b6, float:9.73E-43)
            r9 = r9 | r10
            short r9 = (short) r9     // Catch:{ all -> 0x0884 }
            byte r4 = (byte) r4     // Catch:{ all -> 0x0884 }
            java.lang.String r4 = $$c(r7, r9, r4)     // Catch:{ all -> 0x0884 }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0884 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0884 }
            r4 = 2
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ all -> 0x0778 }
            r4 = 1
            r7[r4] = r2     // Catch:{ all -> 0x0778 }
            r2 = 0
            r7[r2] = r3     // Catch:{ all -> 0x0778 }
            r2 = 8
            byte r3 = r5[r2]     // Catch:{ all -> 0x0778 }
            byte r2 = (byte) r3     // Catch:{ all -> 0x0778 }
            int r3 = onResponseNative     // Catch:{ all -> 0x0778 }
            r4 = r3 ^ 53
            r9 = 53
            r3 = r3 & r9
            r3 = r3 | r4
            short r3 = (short) r3     // Catch:{ all -> 0x0778 }
            r4 = 98
            byte r5 = r5[r4]     // Catch:{ all -> 0x0778 }
            byte r4 = (byte) r5     // Catch:{ all -> 0x0778 }
            java.lang.String r2 = $$c(r2, r3, r4)     // Catch:{ all -> 0x0778 }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0778 }
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0778 }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r5 = 0
            r4[r5] = r3     // Catch:{ all -> 0x0778 }
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            r5 = 1
            r4[r5] = r3     // Catch:{ all -> 0x0778 }
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r4)     // Catch:{ all -> 0x0778 }
            java.lang.Object r2 = r2.newInstance(r7)     // Catch:{ all -> 0x0778 }
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x0778 }
            throw r2     // Catch:{ all -> 0x0778 }
        L_0x0778:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0884 }
            if (r3 == 0) goto L_0x0781
            throw r3     // Catch:{ all -> 0x0884 }
        L_0x0781:
            throw r2     // Catch:{ all -> 0x0884 }
        L_0x0782:
            r0 = move-exception
            goto L_0x0787
        L_0x0784:
            r0 = move-exception
            r32 = r7
        L_0x0787:
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0884 }
            if (r3 == 0) goto L_0x078f
            throw r3     // Catch:{ all -> 0x0884 }
        L_0x078f:
            throw r2     // Catch:{ all -> 0x0884 }
        L_0x0790:
            r32 = r7
            r33 = r12
            r34 = r13
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x07f5 }
            r3 = 1
            r4[r3] = r2     // Catch:{ all -> 0x07f5 }
            r2 = 0
            r4[r2] = r9     // Catch:{ all -> 0x07f5 }
            byte[] r2 = onConversionDataSuccess     // Catch:{ all -> 0x07f5 }
            r3 = 108(0x6c, float:1.51E-43)
            byte r5 = r2[r3]     // Catch:{ all -> 0x07f5 }
            byte r3 = (byte) r5     // Catch:{ all -> 0x07f5 }
            r5 = r3 ^ 112(0x70, float:1.57E-43)
            r7 = r3 & 112(0x70, float:1.57E-43)
            r5 = r5 | r7
            short r5 = (short) r5     // Catch:{ all -> 0x07f5 }
            r7 = 98
            byte r12 = r2[r7]     // Catch:{ all -> 0x07f5 }
            byte r7 = (byte) r12     // Catch:{ all -> 0x07f5 }
            java.lang.String r3 = $$c(r3, r5, r7)     // Catch:{ all -> 0x07f5 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x07f5 }
            r5 = 2
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ all -> 0x07f5 }
            r5 = 108(0x6c, float:1.51E-43)
            byte r12 = r2[r5]     // Catch:{ all -> 0x07f5 }
            byte r5 = (byte) r12     // Catch:{ all -> 0x07f5 }
            r12 = r5 ^ 112(0x70, float:1.57E-43)
            r13 = r5 & 112(0x70, float:1.57E-43)
            r12 = r12 | r13
            short r12 = (short) r12     // Catch:{ all -> 0x07f5 }
            r13 = 98
            byte r2 = r2[r13]     // Catch:{ all -> 0x07f5 }
            byte r2 = (byte) r2     // Catch:{ all -> 0x07f5 }
            java.lang.String r2 = $$c(r5, r12, r2)     // Catch:{ all -> 0x07f5 }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x07f5 }
            r5 = 0
            r7[r5] = r2     // Catch:{ all -> 0x07f5 }
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            r5 = 1
            r7[r5] = r2     // Catch:{ all -> 0x07f5 }
            java.lang.reflect.Constructor r2 = r3.getDeclaredConstructor(r7)     // Catch:{ all -> 0x07f5 }
            java.lang.Object r2 = r2.newInstance(r4)     // Catch:{ all -> 0x07f5 }
            r14 = r2
        L_0x07e5:
            r12 = r33
            r13 = r34
        L_0x07e9:
            r2 = r28
            r4 = r29
            r3 = r30
            r5 = r31
            r7 = r32
            goto L_0x0512
        L_0x07f5:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0884 }
            if (r3 == 0) goto L_0x07fe
            throw r3     // Catch:{ all -> 0x0884 }
        L_0x07fe:
            throw r2     // Catch:{ all -> 0x0884 }
        L_0x07ff:
            r29 = r4
            r31 = r5
            r32 = r7
            r33 = r12
            r34 = r13
            if (r23 == 0) goto L_0x0835
            r4 = 26
            int r5 = r10.nextInt(r4)     // Catch:{ all -> 0x0884 }
            boolean r4 = r10.nextBoolean()     // Catch:{ all -> 0x0884 }
            if (r4 == 0) goto L_0x081a
            r4 = 56
            goto L_0x081c
        L_0x081a:
            r4 = 35
        L_0x081c:
            r7 = 35
            if (r4 == r7) goto L_0x0828
            r4 = r5 | 65
            r7 = 1
            int r4 = r4 << r7
            r5 = r5 ^ 65
            int r4 = r4 - r5
            goto L_0x082f
        L_0x0828:
            r7 = 1
            r4 = r5 ^ 96
            r5 = r5 & 96
            int r5 = r5 << r7
            int r4 = r4 + r5
        L_0x082f:
            char r4 = (char) r4     // Catch:{ all -> 0x0884 }
            r15.append(r4)     // Catch:{ all -> 0x0884 }
            r7 = 1
            goto L_0x0846
        L_0x0835:
            r4 = 12
            int r4 = r10.nextInt(r4)     // Catch:{ all -> 0x0884 }
            r5 = r4 | 8192(0x2000, float:1.14794E-41)
            r7 = 1
            int r5 = r5 << r7
            r4 = r4 ^ 8192(0x2000, float:1.14794E-41)
            int r5 = r5 - r4
            char r4 = (char) r5     // Catch:{ all -> 0x0884 }
            r15.append(r4)     // Catch:{ all -> 0x0884 }
        L_0x0846:
            r4 = r3 | -89
            int r4 = r4 << r7
            r3 = r3 ^ -89
            int r4 = r4 - r3
            r3 = r4 & 90
            r4 = r4 | 90
            int r3 = r3 + r4
            r4 = r29
            r5 = r31
            r7 = r32
            r12 = r33
            r13 = r34
            goto L_0x053f
        L_0x085d:
            r0 = move-exception
            goto L_0x088b
        L_0x085f:
            r0 = move-exception
            goto L_0x0889
        L_0x0861:
            r28 = r2
            r30 = r3
            r29 = r4
            r31 = r5
            r32 = r7
            r33 = r12
            r34 = r13
            goto L_0x08a9
        L_0x0870:
            r0 = move-exception
            r28 = r2
            r30 = r3
            r29 = r4
            r31 = r5
            r32 = r7
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0884 }
            if (r3 == 0) goto L_0x0883
            throw r3     // Catch:{ all -> 0x0884 }
        L_0x0883:
            throw r2     // Catch:{ all -> 0x0884 }
        L_0x0884:
            r0 = move-exception
            goto L_0x0891
        L_0x0886:
            r0 = move-exception
            r28 = r2
        L_0x0889:
            r30 = r3
        L_0x088b:
            r29 = r4
            r31 = r5
            r32 = r7
        L_0x0891:
            r2 = r0
            r19 = r6
        L_0x0894:
            r35 = r8
        L_0x0896:
            r12 = 3
            goto L_0x18a9
        L_0x0899:
            r28 = r2
            r30 = r3
            r29 = r4
            r31 = r5
            r32 = r7
            r11 = 0
            r14 = 0
            r33 = 0
            r34 = 0
        L_0x08a9:
            r2 = 7712(0x1e20, float:1.0807E-41)
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x1894 }
            java.lang.Class<com.appsflyer.internal.AFa1vSDK> r3 = com.appsflyer.internal.AFa1vSDK.class
            byte[] r4 = onConversionDataSuccess     // Catch:{ all -> 0x1894 }
            r5 = 1
            byte r7 = r4[r5]     // Catch:{ all -> 0x1894 }
            byte r5 = (byte) r7     // Catch:{ all -> 0x1894 }
            r7 = 306(0x132, float:4.29E-43)
            short r7 = (short) r7     // Catch:{ all -> 0x1894 }
            r9 = 10
            byte r9 = r4[r9]     // Catch:{ all -> 0x1894 }
            byte r9 = (byte) r9     // Catch:{ all -> 0x1894 }
            java.lang.String r5 = $$c(r5, r7, r9)     // Catch:{ all -> 0x1894 }
            java.io.InputStream r3 = r3.getResourceAsStream(r5)     // Catch:{ all -> 0x1894 }
            int r5 = onAppOpenAttribution
            int r5 = r5 + 100
            r7 = 1
            int r5 = r5 - r7
            int r9 = r5 % 128
            onResponseErrorNative = r9
            r9 = 2
            int r5 = r5 % r9
            java.lang.Object[] r5 = new java.lang.Object[r7]     // Catch:{ all -> 0x1885 }
            r7 = 0
            r5[r7] = r3     // Catch:{ all -> 0x1885 }
            r3 = 26
            byte r7 = r4[r3]     // Catch:{ all -> 0x1885 }
            byte r3 = (byte) r7     // Catch:{ all -> 0x1885 }
            r7 = 452(0x1c4, float:6.33E-43)
            short r7 = (short) r7     // Catch:{ all -> 0x1885 }
            r9 = 98
            byte r10 = r4[r9]     // Catch:{ all -> 0x1885 }
            byte r9 = (byte) r10     // Catch:{ all -> 0x1885 }
            java.lang.String r3 = $$c(r3, r7, r9)     // Catch:{ all -> 0x1885 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x1885 }
            r9 = 1
            java.lang.Class[] r10 = new java.lang.Class[r9]     // Catch:{ all -> 0x1885 }
            r9 = 8
            byte r12 = r4[r9]     // Catch:{ all -> 0x1885 }
            byte r9 = (byte) r12     // Catch:{ all -> 0x1885 }
            byte r12 = r4[r24]     // Catch:{ all -> 0x1885 }
            short r12 = (short) r12     // Catch:{ all -> 0x1885 }
            r13 = 98
            byte r15 = r4[r13]     // Catch:{ all -> 0x1885 }
            byte r13 = (byte) r15     // Catch:{ all -> 0x1885 }
            java.lang.String r9 = $$c(r9, r12, r13)     // Catch:{ all -> 0x1885 }
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ all -> 0x1885 }
            r12 = 0
            r10[r12] = r9     // Catch:{ all -> 0x1885 }
            java.lang.reflect.Constructor r3 = r3.getDeclaredConstructor(r10)     // Catch:{ all -> 0x1885 }
            java.lang.Object r3 = r3.newInstance(r5)     // Catch:{ all -> 0x1885 }
            r5 = 1
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ all -> 0x1876 }
            r9[r12] = r2     // Catch:{ all -> 0x1876 }
            r5 = 26
            byte r10 = r4[r5]     // Catch:{ all -> 0x1876 }
            byte r5 = (byte) r10     // Catch:{ all -> 0x1876 }
            r10 = 98
            byte r12 = r4[r10]     // Catch:{ all -> 0x1876 }
            byte r10 = (byte) r12     // Catch:{ all -> 0x1876 }
            java.lang.String r5 = $$c(r5, r7, r10)     // Catch:{ all -> 0x1876 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x1876 }
            r10 = 18
            byte r10 = r4[r10]     // Catch:{ all -> 0x1876 }
            byte r10 = (byte) r10     // Catch:{ all -> 0x1876 }
            r12 = r10 ^ 721(0x2d1, float:1.01E-42)
            r13 = r10 & 721(0x2d1, float:1.01E-42)
            r12 = r12 | r13
            short r12 = (short) r12     // Catch:{ all -> 0x1876 }
            r13 = 392(0x188, float:5.5E-43)
            byte r13 = r4[r13]     // Catch:{ all -> 0x1876 }
            byte r13 = (byte) r13     // Catch:{ all -> 0x1876 }
            java.lang.String r10 = $$c(r10, r12, r13)     // Catch:{ all -> 0x1876 }
            r12 = 1
            java.lang.Class[] r13 = new java.lang.Class[r12]     // Catch:{ all -> 0x1876 }
            r12 = 0
            r13[r12] = r1     // Catch:{ all -> 0x1876 }
            java.lang.reflect.Method r5 = r5.getMethod(r10, r13)     // Catch:{ all -> 0x1876 }
            r5.invoke(r3, r9)     // Catch:{ all -> 0x1876 }
            int r5 = onResponseErrorNative
            r9 = r5 ^ 77
            r5 = r5 & 77
            r10 = 1
            int r5 = r5 << r10
            int r9 = r9 + r5
            int r5 = r9 % 128
            onAppOpenAttribution = r5
            r5 = 2
            int r9 = r9 % r5
            r5 = 26
            byte r9 = r4[r5]     // Catch:{ all -> 0x1867 }
            byte r5 = (byte) r9     // Catch:{ all -> 0x1867 }
            r9 = 98
            byte r10 = r4[r9]     // Catch:{ all -> 0x1867 }
            byte r9 = (byte) r10     // Catch:{ all -> 0x1867 }
            java.lang.String r5 = $$c(r5, r7, r9)     // Catch:{ all -> 0x1867 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x1867 }
            byte r7 = r4[r25]     // Catch:{ all -> 0x1867 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x1867 }
            r9 = r7 ^ 306(0x132, float:4.29E-43)
            r10 = r7 & 306(0x132, float:4.29E-43)
            r9 = r9 | r10
            short r9 = (short) r9     // Catch:{ all -> 0x1867 }
            r10 = 135(0x87, float:1.89E-43)
            byte r4 = r4[r10]     // Catch:{ all -> 0x1867 }
            byte r4 = (byte) r4     // Catch:{ all -> 0x1867 }
            java.lang.String r4 = $$c(r7, r9, r4)     // Catch:{ all -> 0x1867 }
            r7 = 0
            java.lang.reflect.Method r4 = r5.getMethod(r4, r7)     // Catch:{ all -> 0x1867 }
            r4.invoke(r3, r7)     // Catch:{ all -> 0x1867 }
            r3 = 16
            r5 = 7672(0x1df8, float:1.0751E-41)
            r9 = r31
            r7 = 0
        L_0x0988:
            int r10 = r3 + 181
            r12 = 1
            int r10 = r10 - r12
            int r13 = r3 + 7695
            byte r13 = r2[r13]     // Catch:{ all -> 0x1894 }
            r15 = r13 ^ -66
            r13 = r13 & -66
            int r13 = r13 << r12
            int r15 = r15 + r13
            byte r12 = (byte) r15     // Catch:{ all -> 0x1894 }
            r2[r10] = r12     // Catch:{ all -> 0x1894 }
            int r10 = r2.length     // Catch:{ all -> 0x1894 }
            int r12 = -r3
            r13 = r10 & r12
            r10 = r10 | r12
            int r13 = r13 + r10
            r10 = 3
            java.lang.Object[] r12 = new java.lang.Object[r10]     // Catch:{ all -> 0x1856 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x184f }
            r13 = 2
            r12[r13] = r10     // Catch:{ all -> 0x184f }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x184f }
            r13 = 1
            r12[r13] = r10     // Catch:{ all -> 0x184f }
            r10 = 0
            r12[r10] = r2     // Catch:{ all -> 0x184f }
            byte[] r2 = onConversionDataSuccess     // Catch:{ all -> 0x184f }
            r10 = 182(0xb6, float:2.55E-43)
            byte r10 = r2[r10]     // Catch:{ all -> 0x184f }
            byte r10 = (byte) r10     // Catch:{ all -> 0x184f }
            r13 = 823(0x337, float:1.153E-42)
            short r13 = (short) r13     // Catch:{ all -> 0x184f }
            r15 = 98
            byte r4 = r2[r15]     // Catch:{ all -> 0x184f }
            byte r4 = (byte) r4     // Catch:{ all -> 0x184f }
            java.lang.String r4 = $$c(r10, r13, r4)     // Catch:{ all -> 0x184f }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x184f }
            r10 = 3
            java.lang.Class[] r13 = new java.lang.Class[r10]     // Catch:{ all -> 0x1856 }
            r10 = 0
            r13[r10] = r1     // Catch:{ all -> 0x184f }
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch:{ all -> 0x184f }
            r15 = 1
            r13[r15] = r10     // Catch:{ all -> 0x184f }
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch:{ all -> 0x184f }
            r15 = 2
            r13[r15] = r10     // Catch:{ all -> 0x184f }
            java.lang.reflect.Constructor r4 = r4.getDeclaredConstructor(r13)     // Catch:{ all -> 0x184f }
            java.lang.Object r4 = r4.newInstance(r12)     // Catch:{ all -> 0x184f }
            r36 = r4
            java.io.InputStream r36 = (java.io.InputStream) r36     // Catch:{ all -> 0x184f }
            java.lang.Object r4 = onInstallConversionFailureNative     // Catch:{ all -> 0x1894 }
            if (r4 != 0) goto L_0x0a37
            r4 = 991521728(0x3b196bc0, float:0.0023410171)
            float r10 = android.view.ViewConfiguration.getScrollFriction()     // Catch:{ all -> 0x0884 }
            r12 = 0
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            r12 = r10 ^ r4
            r4 = r4 & r10
            r10 = 1
            int r4 = r4 << r10
            int r12 = r12 + r4
            float r4 = android.media.AudioTrack.getMaxVolume()     // Catch:{ all -> 0x0884 }
            r13 = 0
            int r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            r13 = r4 ^ 4
            r15 = 4
            r4 = r4 & r15
            int r4 = r4 << r10
            int r13 = r13 + r4
            short r4 = (short) r13     // Catch:{ all -> 0x0884 }
            r10 = 2
            int[] r13 = new int[r10]     // Catch:{ all -> 0x0884 }
            r15 = r11
            long r10 = init     // Catch:{ all -> 0x0884 }
            r35 = 32
            r42 = r14
            r43 = r15
            long r14 = r10 >>> r35
            int r14 = (int) r14     // Catch:{ all -> 0x0884 }
            r14 = r14 ^ r12
            r15 = 0
            r13[r15] = r14     // Catch:{ all -> 0x0884 }
            int r10 = (int) r10     // Catch:{ all -> 0x0884 }
            r10 = r10 ^ r12
            r11 = 1
            r13[r11] = r10     // Catch:{ all -> 0x0884 }
            com.appsflyer.internal.AFg1wSDK r10 = new com.appsflyer.internal.AFg1wSDK     // Catch:{ all -> 0x0884 }
            int r38 = AppsFlyer2dXConversionCallback     // Catch:{ all -> 0x0884 }
            byte[] r39 = onAttributionFailureNative     // Catch:{ all -> 0x0884 }
            int r41 = onDeepLinkingNative     // Catch:{ all -> 0x0884 }
            r35 = r10
            r37 = r13
            r40 = r4
            r35.<init>(r36, r37, r38, r39, r40, r41)     // Catch:{ all -> 0x0884 }
            r35 = r5
        L_0x0a33:
            r4 = 16
            goto L_0x0b12
        L_0x0a37:
            r43 = r11
            r42 = r14
            java.lang.String r10 = ""
            r11 = 1
            java.lang.Object[] r12 = new java.lang.Object[r11]     // Catch:{ all -> 0x1840 }
            r11 = 0
            r12[r11] = r10     // Catch:{ all -> 0x1840 }
            r10 = 84
            byte r10 = r2[r10]     // Catch:{ all -> 0x1840 }
            byte r10 = (byte) r10     // Catch:{ all -> 0x1840 }
            int r11 = onResponseNative     // Catch:{ all -> 0x1840 }
            r13 = r11 ^ 35
            r14 = r11 & 35
            r13 = r13 | r14
            short r13 = (short) r13     // Catch:{ all -> 0x1840 }
            r14 = 631(0x277, float:8.84E-43)
            byte r14 = r2[r14]     // Catch:{ all -> 0x1840 }
            byte r14 = (byte) r14     // Catch:{ all -> 0x1840 }
            java.lang.String r10 = $$c(r10, r13, r14)     // Catch:{ all -> 0x1840 }
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch:{ all -> 0x1840 }
            r13 = 4
            byte r14 = r2[r13]     // Catch:{ all -> 0x1840 }
            byte r13 = (byte) r14     // Catch:{ all -> 0x1840 }
            r14 = 108(0x6c, float:1.51E-43)
            short r15 = (short) r14     // Catch:{ all -> 0x1840 }
            r35 = r5
            r14 = 17
            byte r5 = r2[r14]     // Catch:{ all -> 0x1840 }
            byte r5 = (byte) r5     // Catch:{ all -> 0x1840 }
            java.lang.String r5 = $$c(r13, r15, r5)     // Catch:{ all -> 0x1840 }
            r13 = 1
            java.lang.Class[] r14 = new java.lang.Class[r13]     // Catch:{ all -> 0x1840 }
            java.lang.Class<java.lang.CharSequence> r13 = java.lang.CharSequence.class
            r15 = 0
            r14[r15] = r13     // Catch:{ all -> 0x1840 }
            java.lang.reflect.Method r5 = r10.getMethod(r5, r14)     // Catch:{ all -> 0x1840 }
            r10 = 0
            java.lang.Object r5 = r5.invoke(r10, r12)     // Catch:{ all -> 0x1840 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ all -> 0x1840 }
            int r5 = r5.intValue()     // Catch:{ all -> 0x1840 }
            int r5 = -r5
            int r5 = ~r5
            r10 = 1
            int r12 = 1 - r5
            int r12 = r12 - r10
            r5 = -1587066680(0xffffffffa16748c8, float:-7.836217E-19)
            float r13 = android.media.AudioTrack.getMinVolume()     // Catch:{ all -> 0x1894 }
            r14 = 0
            int r13 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            r14 = r13 | r5
            int r14 = r14 << r10
            r5 = r5 ^ r13
            int r14 = r14 - r5
            r5 = 4
            java.lang.Object[] r10 = new java.lang.Object[r5]     // Catch:{ all -> 0x1831 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x1831 }
            r13 = 3
            r10[r13] = r5     // Catch:{ all -> 0x182a }
            r5 = 2
            r13 = 0
            r10[r5] = r13     // Catch:{ all -> 0x1831 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x1831 }
            r12 = 1
            r10[r12] = r5     // Catch:{ all -> 0x1831 }
            r5 = 0
            r10[r5] = r36     // Catch:{ all -> 0x1831 }
            r5 = 546(0x222, float:7.65E-43)
            byte r5 = r2[r5]     // Catch:{ all -> 0x1831 }
            byte r5 = (byte) r5     // Catch:{ all -> 0x1831 }
            r11 = r11 | 850(0x352, float:1.191E-42)
            short r11 = (short) r11     // Catch:{ all -> 0x1831 }
            r12 = 135(0x87, float:1.89E-43)
            byte r13 = r2[r12]     // Catch:{ all -> 0x1831 }
            byte r12 = (byte) r13     // Catch:{ all -> 0x1831 }
            java.lang.String r5 = $$c(r5, r11, r12)     // Catch:{ all -> 0x1831 }
            java.lang.Object r11 = onAppOpenAttributionNative     // Catch:{ all -> 0x1831 }
            java.lang.ClassLoader r11 = (java.lang.ClassLoader) r11     // Catch:{ all -> 0x1831 }
            r12 = 1
            java.lang.Class r5 = java.lang.Class.forName(r5, r12, r11)     // Catch:{ all -> 0x1831 }
            r11 = 4
            byte r12 = r2[r11]     // Catch:{ all -> 0x1831 }
            byte r11 = (byte) r12     // Catch:{ all -> 0x1831 }
            r12 = 620(0x26c, float:8.69E-43)
            short r12 = (short) r12     // Catch:{ all -> 0x1831 }
            r13 = 37
            byte r13 = r2[r13]     // Catch:{ all -> 0x1831 }
            byte r13 = (byte) r13     // Catch:{ all -> 0x1831 }
            java.lang.String r11 = $$c(r11, r12, r13)     // Catch:{ all -> 0x1831 }
            r12 = 4
            java.lang.Class[] r13 = new java.lang.Class[r12]     // Catch:{ all -> 0x1831 }
            r14 = 8
            byte r15 = r2[r14]     // Catch:{ all -> 0x1831 }
            byte r14 = (byte) r15     // Catch:{ all -> 0x1831 }
            byte r15 = r2[r24]     // Catch:{ all -> 0x1831 }
            short r15 = (short) r15     // Catch:{ all -> 0x1831 }
            r19 = 98
            byte r12 = r2[r19]     // Catch:{ all -> 0x1831 }
            byte r12 = (byte) r12     // Catch:{ all -> 0x1831 }
            java.lang.String r12 = $$c(r14, r15, r12)     // Catch:{ all -> 0x1831 }
            java.lang.Class r12 = java.lang.Class.forName(r12)     // Catch:{ all -> 0x1831 }
            r14 = 0
            r13[r14] = r12     // Catch:{ all -> 0x1831 }
            java.lang.Class r12 = java.lang.Integer.TYPE     // Catch:{ all -> 0x1831 }
            r14 = 1
            r13[r14] = r12     // Catch:{ all -> 0x1831 }
            r12 = 2
            r13[r12] = r1     // Catch:{ all -> 0x1831 }
            java.lang.Class r12 = java.lang.Integer.TYPE     // Catch:{ all -> 0x1831 }
            r14 = 3
            r13[r14] = r12     // Catch:{ all -> 0x1823 }
            java.lang.reflect.Method r5 = r5.getMethod(r11, r13)     // Catch:{ all -> 0x1831 }
            java.lang.Object r4 = r5.invoke(r4, r10)     // Catch:{ all -> 0x1831 }
            r10 = r4
            java.io.InputStream r10 = (java.io.InputStream) r10     // Catch:{ all -> 0x1831 }
            goto L_0x0a33
        L_0x0b12:
            long r11 = (long) r4
            r5 = 1
            java.lang.Object[] r13 = new java.lang.Object[r5]     // Catch:{ all -> 0x1814 }
            java.lang.Long r5 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x1814 }
            r11 = 0
            r13[r11] = r5     // Catch:{ all -> 0x1814 }
            r5 = 8
            byte r11 = r2[r5]     // Catch:{ all -> 0x1814 }
            byte r5 = (byte) r11     // Catch:{ all -> 0x1814 }
            byte r11 = r2[r24]     // Catch:{ all -> 0x1814 }
            short r11 = (short) r11     // Catch:{ all -> 0x1814 }
            r12 = 98
            byte r14 = r2[r12]     // Catch:{ all -> 0x1814 }
            byte r12 = (byte) r14     // Catch:{ all -> 0x1814 }
            java.lang.String r5 = $$c(r5, r11, r12)     // Catch:{ all -> 0x1814 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x1814 }
            r11 = 9
            byte r12 = r2[r11]     // Catch:{ all -> 0x1814 }
            byte r11 = (byte) r12     // Catch:{ all -> 0x1814 }
            r12 = r11 ^ 372(0x174, float:5.21E-43)
            r14 = r11 & 372(0x174, float:5.21E-43)
            r12 = r12 | r14
            short r12 = (short) r12     // Catch:{ all -> 0x1814 }
            r14 = 30
            byte r14 = r2[r14]     // Catch:{ all -> 0x1814 }
            byte r14 = (byte) r14     // Catch:{ all -> 0x1814 }
            java.lang.String r11 = $$c(r11, r12, r14)     // Catch:{ all -> 0x1814 }
            r12 = 1
            java.lang.Class[] r14 = new java.lang.Class[r12]     // Catch:{ all -> 0x1814 }
            java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ all -> 0x1814 }
            r15 = 0
            r14[r15] = r12     // Catch:{ all -> 0x1814 }
            java.lang.reflect.Method r5 = r5.getMethod(r11, r14)     // Catch:{ all -> 0x1814 }
            java.lang.Object r5 = r5.invoke(r10, r13)     // Catch:{ all -> 0x1814 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x1814 }
            r5.longValue()     // Catch:{ all -> 0x1814 }
            if (r21 == 0) goto L_0x10d2
            java.lang.Object r5 = onInstallConversionFailureNative     // Catch:{ all -> 0x10ca }
            if (r5 != 0) goto L_0x0b63
            r11 = 1
            goto L_0x0b64
        L_0x0b63:
            r11 = 0
        L_0x0b64:
            if (r11 == 0) goto L_0x0b73
            int r11 = onResponseErrorNative
            int r11 = r11 + 71
            int r12 = r11 % 128
            onAppOpenAttribution = r12
            r12 = 2
            int r11 = r11 % r12
            r11 = r33
            goto L_0x0b75
        L_0x0b73:
            r11 = r34
        L_0x0b75:
            if (r5 != 0) goto L_0x0b7a
            r5 = r42
            goto L_0x0b7c
        L_0x0b7a:
            r5 = r43
        L_0x0b7c:
            r12 = 1
            java.lang.Object[] r13 = new java.lang.Object[r12]     // Catch:{ all -> 0x0fb3 }
            r12 = 0
            r13[r12] = r11     // Catch:{ all -> 0x0fb3 }
            r12 = 43
            byte r14 = r2[r12]     // Catch:{ all -> 0x0fb3 }
            byte r12 = (byte) r14     // Catch:{ all -> 0x0fb3 }
            int r14 = onResponseNative     // Catch:{ all -> 0x0fb3 }
            r15 = r14 ^ 83
            r14 = r14 & 83
            r14 = r14 | r15
            short r14 = (short) r14     // Catch:{ all -> 0x0fb3 }
            r15 = 98
            byte r4 = r2[r15]     // Catch:{ all -> 0x0fb3 }
            byte r4 = (byte) r4     // Catch:{ all -> 0x0fb3 }
            java.lang.String r4 = $$c(r12, r14, r4)     // Catch:{ all -> 0x0fb3 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x0fb3 }
            r12 = 1
            java.lang.Class[] r14 = new java.lang.Class[r12]     // Catch:{ all -> 0x0fb3 }
            r12 = 108(0x6c, float:1.51E-43)
            byte r15 = r2[r12]     // Catch:{ all -> 0x0fb3 }
            byte r12 = (byte) r15     // Catch:{ all -> 0x0fb3 }
            r15 = r12 | 112(0x70, float:1.57E-43)
            short r15 = (short) r15     // Catch:{ all -> 0x0fb3 }
            r19 = 98
            byte r2 = r2[r19]     // Catch:{ all -> 0x0fb3 }
            byte r2 = (byte) r2     // Catch:{ all -> 0x0fb3 }
            java.lang.String r2 = $$c(r12, r15, r2)     // Catch:{ all -> 0x0fb3 }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0fb3 }
            r12 = 0
            r14[r12] = r2     // Catch:{ all -> 0x0fb3 }
            java.lang.reflect.Constructor r2 = r4.getDeclaredConstructor(r14)     // Catch:{ all -> 0x0fb3 }
            java.lang.Object r2 = r2.newInstance(r13)     // Catch:{ all -> 0x0fb3 }
            int r4 = onResponseErrorNative
            r12 = r4 ^ 123(0x7b, float:1.72E-43)
            r4 = r4 & 123(0x7b, float:1.72E-43)
            r13 = 1
            int r4 = r4 << r13
            int r12 = r12 + r4
            int r4 = r12 % 128
            onAppOpenAttribution = r4
            r4 = 2
            int r12 = r12 % r4
            if (r12 != 0) goto L_0x0bdd
            r4 = 17193(0x4329, float:2.4093E-41)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0bd5 }
            goto L_0x0be1
        L_0x0bd5:
            r0 = move-exception
            r2 = r0
            r19 = r6
            r35 = r8
            goto L_0x103a
        L_0x0bdd:
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0fad }
        L_0x0be1:
            r12 = r35
        L_0x0be3:
            if (r12 <= 0) goto L_0x0be8
            r13 = 17
            goto L_0x0bea
        L_0x0be8:
            r13 = 28
        L_0x0bea:
            r14 = 17
            if (r13 == r14) goto L_0x0bf8
            r38 = r3
            r19 = r6
            r37 = r7
            r35 = r8
            goto L_0x0c70
        L_0x0bf8:
            int r13 = r4.length     // Catch:{ all -> 0x0fad }
            int r13 = java.lang.Math.min(r13, r12)     // Catch:{ all -> 0x0fad }
            r14 = 3
            java.lang.Object[] r15 = new java.lang.Object[r14]     // Catch:{ all -> 0x0f9f }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0f9f }
            r14 = 2
            r15[r14] = r13     // Catch:{ all -> 0x0f9f }
            r13 = 0
            java.lang.Integer r14 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0f9f }
            r19 = 1
            r15[r19] = r14     // Catch:{ all -> 0x0f9f }
            r15[r13] = r4     // Catch:{ all -> 0x0f9f }
            byte[] r13 = onConversionDataSuccess     // Catch:{ all -> 0x0f9f }
            r19 = r6
            r14 = 8
            byte r6 = r13[r14]     // Catch:{ all -> 0x0f9d }
            byte r6 = (byte) r6     // Catch:{ all -> 0x0f9d }
            byte r14 = r13[r24]     // Catch:{ all -> 0x0f9d }
            short r14 = (short) r14
            r35 = r8
            r27 = 98
            byte r8 = r13[r27]     // Catch:{ all -> 0x0f9b }
            byte r8 = (byte) r8     // Catch:{ all -> 0x0f9b }
            java.lang.String r6 = $$c(r6, r14, r8)     // Catch:{ all -> 0x0f9b }
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x0f9b }
            r8 = 9
            byte r14 = r13[r8]     // Catch:{ all -> 0x0f9b }
            byte r8 = (byte) r14     // Catch:{ all -> 0x0f9b }
            int r14 = onResponseNative     // Catch:{ all -> 0x0f9b }
            r37 = r7
            r7 = r14 ^ 561(0x231, float:7.86E-43)
            r38 = r3
            r3 = r14 & 561(0x231, float:7.86E-43)
            r3 = r3 | r7
            short r3 = (short) r3     // Catch:{ all -> 0x0f9b }
            r7 = 392(0x188, float:5.5E-43)
            byte r7 = r13[r7]     // Catch:{ all -> 0x0f9b }
            byte r7 = (byte) r7     // Catch:{ all -> 0x0f9b }
            java.lang.String r3 = $$c(r8, r3, r7)     // Catch:{ all -> 0x0f9b }
            r7 = 3
            java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch:{ all -> 0x0f9b }
            r7 = 0
            r8[r7] = r1     // Catch:{ all -> 0x0f9b }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0f9b }
            r26 = 1
            r8[r26] = r7     // Catch:{ all -> 0x0f9b }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0f9b }
            r22 = 2
            r8[r22] = r7     // Catch:{ all -> 0x0f9b }
            java.lang.reflect.Method r3 = r6.getMethod(r3, r8)     // Catch:{ all -> 0x0f9b }
            java.lang.Object r3 = r3.invoke(r10, r15)     // Catch:{ all -> 0x0f9b }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x0f9b }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0f9b }
            r6 = -1
            if (r3 == r6) goto L_0x0c6c
            r6 = 1
            goto L_0x0c6d
        L_0x0c6c:
            r6 = 0
        L_0x0c6d:
            r7 = 1
            if (r6 == r7) goto L_0x0f13
        L_0x0c70:
            int r3 = onAppOpenAttribution
            r4 = r3 & 77
            r3 = r3 | 77
            int r4 = r4 + r3
            int r3 = r4 % 128
            onResponseErrorNative = r3
            r3 = 2
            int r4 = r4 % r3
            byte[] r3 = onConversionDataSuccess     // Catch:{ all -> 0x0f09 }
            r4 = 43
            byte r6 = r3[r4]     // Catch:{ all -> 0x0f09 }
            byte r4 = (byte) r6     // Catch:{ all -> 0x0f09 }
            int r6 = onResponseNative     // Catch:{ all -> 0x0f09 }
            r7 = r6 ^ 83
            r8 = r6 & 83
            r7 = r7 | r8
            short r7 = (short) r7     // Catch:{ all -> 0x0f09 }
            r8 = 98
            byte r10 = r3[r8]     // Catch:{ all -> 0x0f09 }
            byte r8 = (byte) r10     // Catch:{ all -> 0x0f09 }
            java.lang.String r4 = $$c(r4, r7, r8)     // Catch:{ all -> 0x0f09 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x0f09 }
            byte r7 = r3[r25]     // Catch:{ all -> 0x0f09 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x0f09 }
            r8 = 344(0x158, float:4.82E-43)
            short r8 = (short) r8     // Catch:{ all -> 0x0f09 }
            r10 = 17
            byte r12 = r3[r10]     // Catch:{ all -> 0x0f09 }
            byte r10 = (byte) r12     // Catch:{ all -> 0x0f09 }
            java.lang.String r7 = $$c(r7, r8, r10)     // Catch:{ all -> 0x0f09 }
            r8 = 0
            java.lang.reflect.Method r4 = r4.getMethod(r7, r8)     // Catch:{ all -> 0x0f09 }
            java.lang.Object r4 = r4.invoke(r2, r8)     // Catch:{ all -> 0x0f09 }
            int r7 = onResponseErrorNative
            r8 = r7 & 119(0x77, float:1.67E-43)
            r7 = r7 | 119(0x77, float:1.67E-43)
            int r8 = r8 + r7
            int r7 = r8 % 128
            onAppOpenAttribution = r7
            r7 = 2
            int r8 = r8 % r7
            r7 = 84
            byte r7 = r3[r7]     // Catch:{ all -> 0x0eff }
            byte r7 = (byte) r7     // Catch:{ all -> 0x0eff }
            r8 = 77
            short r8 = (short) r8     // Catch:{ all -> 0x0eff }
            r10 = 98
            byte r12 = r3[r10]     // Catch:{ all -> 0x0eff }
            byte r10 = (byte) r12     // Catch:{ all -> 0x0eff }
            java.lang.String r7 = $$c(r7, r8, r10)     // Catch:{ all -> 0x0eff }
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x0eff }
            r8 = 9
            byte r10 = r3[r8]     // Catch:{ all -> 0x0eff }
            byte r8 = (byte) r10     // Catch:{ all -> 0x0eff }
            r10 = 605(0x25d, float:8.48E-43)
            short r10 = (short) r10     // Catch:{ all -> 0x0eff }
            r12 = 30
            byte r12 = r3[r12]     // Catch:{ all -> 0x0eff }
            byte r12 = (byte) r12     // Catch:{ all -> 0x0eff }
            java.lang.String r8 = $$c(r8, r10, r12)     // Catch:{ all -> 0x0eff }
            r10 = 0
            java.lang.reflect.Method r7 = r7.getMethod(r8, r10)     // Catch:{ all -> 0x0eff }
            r7.invoke(r4, r10)     // Catch:{ all -> 0x0eff }
            int r4 = onAppOpenAttribution
            r7 = r4 | 79
            r8 = 1
            int r7 = r7 << r8
            r4 = r4 ^ 79
            int r7 = r7 - r4
            int r4 = r7 % 128
            onResponseErrorNative = r4
            r4 = 2
            int r7 = r7 % r4
            r4 = 43
            byte r7 = r3[r4]     // Catch:{ all -> 0x0ef5 }
            byte r4 = (byte) r7     // Catch:{ all -> 0x0ef5 }
            r6 = r6 | 83
            short r6 = (short) r6     // Catch:{ all -> 0x0ef5 }
            r7 = 98
            byte r8 = r3[r7]     // Catch:{ all -> 0x0ef5 }
            byte r7 = (byte) r8     // Catch:{ all -> 0x0ef5 }
            java.lang.String r4 = $$c(r4, r6, r7)     // Catch:{ all -> 0x0ef5 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x0ef5 }
            byte r6 = r3[r25]     // Catch:{ all -> 0x0ef5 }
            byte r6 = (byte) r6     // Catch:{ all -> 0x0ef5 }
            r7 = r6 | 306(0x132, float:4.29E-43)
            short r7 = (short) r7     // Catch:{ all -> 0x0ef5 }
            r8 = 135(0x87, float:1.89E-43)
            byte r10 = r3[r8]     // Catch:{ all -> 0x0ef5 }
            byte r8 = (byte) r10     // Catch:{ all -> 0x0ef5 }
            java.lang.String r6 = $$c(r6, r7, r8)     // Catch:{ all -> 0x0ef5 }
            r7 = 0
            java.lang.reflect.Method r4 = r4.getMethod(r6, r7)     // Catch:{ all -> 0x0ef5 }
            r4.invoke(r2, r7)     // Catch:{ all -> 0x0ef5 }
            r2 = 434(0x1b2, float:6.08E-43)
            byte r2 = r3[r2]     // Catch:{ all -> 0x0fc1 }
            byte r2 = (byte) r2     // Catch:{ all -> 0x0fc1 }
            r4 = r2 ^ 674(0x2a2, float:9.44E-43)
            r6 = r2 & 674(0x2a2, float:9.44E-43)
            r4 = r4 | r6
            short r4 = (short) r4     // Catch:{ all -> 0x0fc1 }
            r6 = 25
            byte r6 = r3[r6]     // Catch:{ all -> 0x0fc1 }
            int r6 = -r6
            byte r6 = (byte) r6     // Catch:{ all -> 0x0fc1 }
            java.lang.String r2 = $$c(r2, r4, r6)     // Catch:{ all -> 0x0fc1 }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0fc1 }
            r4 = 10
            byte r4 = r3[r4]     // Catch:{ all -> 0x0fc1 }
            byte r4 = (byte) r4     // Catch:{ all -> 0x0fc1 }
            r6 = r4 ^ 424(0x1a8, float:5.94E-43)
            r7 = r4 & 424(0x1a8, float:5.94E-43)
            r6 = r6 | r7
            short r6 = (short) r6     // Catch:{ all -> 0x0fc1 }
            r7 = 130(0x82, float:1.82E-43)
            byte r7 = r3[r7]     // Catch:{ all -> 0x0fc1 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x0fc1 }
            java.lang.String r4 = $$c(r4, r6, r7)     // Catch:{ all -> 0x0fc1 }
            r6 = 3
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch:{ all -> 0x0fc1 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r8 = 0
            r7[r8] = r6     // Catch:{ all -> 0x0fc1 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r8 = 1
            r7[r8] = r6     // Catch:{ all -> 0x0fc1 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0fc1 }
            r8 = 2
            r7[r8] = r6     // Catch:{ all -> 0x0fc1 }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r4, r7)     // Catch:{ all -> 0x0fc1 }
            r4 = 3
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x0fc1 }
            int r4 = onResponseErrorNative
            r7 = r4 | 5
            r8 = 1
            int r7 = r7 << r8
            r4 = r4 ^ 5
            int r7 = r7 - r4
            int r4 = r7 % 128
            onAppOpenAttribution = r4
            r4 = 2
            int r7 = r7 % r4
            r4 = 108(0x6c, float:1.51E-43)
            byte r7 = r3[r4]     // Catch:{ all -> 0x0eeb }
            byte r4 = (byte) r7     // Catch:{ all -> 0x0eeb }
            r7 = r4 ^ 112(0x70, float:1.57E-43)
            r8 = r4 & 112(0x70, float:1.57E-43)
            r7 = r7 | r8
            short r7 = (short) r7     // Catch:{ all -> 0x0eeb }
            r8 = 98
            byte r10 = r3[r8]     // Catch:{ all -> 0x0eeb }
            byte r8 = (byte) r10     // Catch:{ all -> 0x0eeb }
            java.lang.String r4 = $$c(r4, r7, r8)     // Catch:{ all -> 0x0eeb }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x0eeb }
            r7 = 24
            byte r7 = r3[r7]     // Catch:{ all -> 0x0eeb }
            byte r7 = (byte) r7     // Catch:{ all -> 0x0eeb }
            r8 = 258(0x102, float:3.62E-43)
            short r8 = (short) r8     // Catch:{ all -> 0x0eeb }
            r10 = 17
            byte r12 = r3[r10]     // Catch:{ all -> 0x0eeb }
            byte r10 = (byte) r12     // Catch:{ all -> 0x0eeb }
            java.lang.String r7 = $$c(r7, r8, r10)     // Catch:{ all -> 0x0eeb }
            r10 = 0
            java.lang.reflect.Method r4 = r4.getMethod(r7, r10)     // Catch:{ all -> 0x0eeb }
            java.lang.Object r4 = r4.invoke(r11, r10)     // Catch:{ all -> 0x0eeb }
            r7 = 0
            r6[r7] = r4     // Catch:{ all -> 0x0fc1 }
            r4 = 108(0x6c, float:1.51E-43)
            byte r7 = r3[r4]     // Catch:{ all -> 0x0ee1 }
            byte r4 = (byte) r7     // Catch:{ all -> 0x0ee1 }
            r7 = r4 ^ 112(0x70, float:1.57E-43)
            r10 = r4 & 112(0x70, float:1.57E-43)
            r7 = r7 | r10
            short r7 = (short) r7     // Catch:{ all -> 0x0ee1 }
            r10 = 98
            byte r12 = r3[r10]     // Catch:{ all -> 0x0ee1 }
            byte r10 = (byte) r12     // Catch:{ all -> 0x0ee1 }
            java.lang.String r4 = $$c(r4, r7, r10)     // Catch:{ all -> 0x0ee1 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x0ee1 }
            r7 = 24
            byte r7 = r3[r7]     // Catch:{ all -> 0x0ee1 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x0ee1 }
            r10 = 17
            byte r12 = r3[r10]     // Catch:{ all -> 0x0ee1 }
            byte r10 = (byte) r12     // Catch:{ all -> 0x0ee1 }
            java.lang.String r7 = $$c(r7, r8, r10)     // Catch:{ all -> 0x0ee1 }
            r8 = 0
            java.lang.reflect.Method r4 = r4.getMethod(r7, r8)     // Catch:{ all -> 0x0ee1 }
            java.lang.Object r4 = r4.invoke(r5, r8)     // Catch:{ all -> 0x0ee1 }
            r7 = 1
            r6[r7] = r4     // Catch:{ all -> 0x0fc1 }
            r4 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0fc1 }
            r4 = 2
            r6[r4] = r7     // Catch:{ all -> 0x0fc1 }
            java.lang.Object r2 = r2.invoke(r8, r6)     // Catch:{ all -> 0x0fc1 }
            r4 = 108(0x6c, float:1.51E-43)
            byte r6 = r3[r4]     // Catch:{ all -> 0x0ed7 }
            byte r4 = (byte) r6     // Catch:{ all -> 0x0ed7 }
            r6 = r4 ^ 112(0x70, float:1.57E-43)
            r7 = r4 & 112(0x70, float:1.57E-43)
            r6 = r6 | r7
            short r6 = (short) r6     // Catch:{ all -> 0x0ed7 }
            r7 = 98
            byte r8 = r3[r7]     // Catch:{ all -> 0x0ed7 }
            byte r7 = (byte) r8     // Catch:{ all -> 0x0ed7 }
            java.lang.String r4 = $$c(r4, r6, r7)     // Catch:{ all -> 0x0ed7 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x0ed7 }
            r6 = 53
            byte r7 = r3[r6]     // Catch:{ all -> 0x0ed7 }
            byte r6 = (byte) r7     // Catch:{ all -> 0x0ed7 }
            r7 = r6 ^ 344(0x158, float:4.82E-43)
            r8 = r6 & 344(0x158, float:4.82E-43)
            r7 = r7 | r8
            short r7 = (short) r7     // Catch:{ all -> 0x0ed7 }
            r8 = 25
            byte r8 = r3[r8]     // Catch:{ all -> 0x0ed7 }
            int r8 = -r8
            byte r8 = (byte) r8     // Catch:{ all -> 0x0ed7 }
            java.lang.String r6 = $$c(r6, r7, r8)     // Catch:{ all -> 0x0ed7 }
            r7 = 0
            java.lang.reflect.Method r4 = r4.getMethod(r6, r7)     // Catch:{ all -> 0x0ed7 }
            java.lang.Object r4 = r4.invoke(r11, r7)     // Catch:{ all -> 0x0ed7 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x0ed7 }
            r4.booleanValue()     // Catch:{ all -> 0x0ed7 }
            int r4 = onAppOpenAttribution
            r6 = r4 & 33
            r4 = r4 | 33
            int r6 = r6 + r4
            int r4 = r6 % 128
            onResponseErrorNative = r4
            r4 = 2
            int r6 = r6 % r4
            r4 = 108(0x6c, float:1.51E-43)
            byte r6 = r3[r4]     // Catch:{ all -> 0x0ecd }
            byte r4 = (byte) r6     // Catch:{ all -> 0x0ecd }
            r6 = r4 ^ 112(0x70, float:1.57E-43)
            r7 = r4 & 112(0x70, float:1.57E-43)
            r6 = r6 | r7
            short r6 = (short) r6     // Catch:{ all -> 0x0ecd }
            r7 = 98
            byte r8 = r3[r7]     // Catch:{ all -> 0x0ecd }
            byte r7 = (byte) r8     // Catch:{ all -> 0x0ecd }
            java.lang.String r4 = $$c(r4, r6, r7)     // Catch:{ all -> 0x0ecd }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x0ecd }
            r6 = 53
            byte r7 = r3[r6]     // Catch:{ all -> 0x0ecd }
            byte r6 = (byte) r7     // Catch:{ all -> 0x0ecd }
            r7 = r6 ^ 344(0x158, float:4.82E-43)
            r8 = r6 & 344(0x158, float:4.82E-43)
            r7 = r7 | r8
            short r7 = (short) r7     // Catch:{ all -> 0x0ecd }
            r8 = 25
            byte r8 = r3[r8]     // Catch:{ all -> 0x0ecd }
            int r8 = -r8
            byte r8 = (byte) r8     // Catch:{ all -> 0x0ecd }
            java.lang.String r6 = $$c(r6, r7, r8)     // Catch:{ all -> 0x0ecd }
            r7 = 0
            java.lang.reflect.Method r4 = r4.getMethod(r6, r7)     // Catch:{ all -> 0x0ecd }
            java.lang.Object r4 = r4.invoke(r5, r7)     // Catch:{ all -> 0x0ecd }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x0ecd }
            r4.booleanValue()     // Catch:{ all -> 0x0ecd }
            java.lang.Object r4 = onAppOpenAttributionNative     // Catch:{ all -> 0x10c8 }
            if (r4 != 0) goto L_0x0ec7
            int r4 = onAppOpenAttribution
            r5 = r4 | 9
            r6 = 1
            int r5 = r5 << r6
            r6 = 9
            r4 = r4 ^ r6
            int r5 = r5 - r4
            int r4 = r5 % 128
            onResponseErrorNative = r4
            r4 = 2
            int r5 = r5 % r4
            if (r5 == 0) goto L_0x0e8a
            r4 = 0
            goto L_0x0e8b
        L_0x0e8a:
            r4 = 1
        L_0x0e8b:
            r5 = 1
            if (r4 != r5) goto L_0x0ec5
            java.lang.Class<com.appsflyer.internal.AFa1vSDK> r4 = com.appsflyer.internal.AFa1vSDK.class
            java.lang.Class<java.lang.Class> r5 = java.lang.Class.class
            r6 = 196(0xc4, float:2.75E-43)
            byte r6 = r3[r6]     // Catch:{ all -> 0x0ebb }
            byte r6 = (byte) r6     // Catch:{ all -> 0x0ebb }
            r7 = 372(0x174, float:5.21E-43)
            short r7 = (short) r7     // Catch:{ all -> 0x0ebb }
            r8 = 17
            byte r3 = r3[r8]     // Catch:{ all -> 0x0ebb }
            byte r3 = (byte) r3     // Catch:{ all -> 0x0ebb }
            java.lang.String r3 = $$c(r6, r7, r3)     // Catch:{ all -> 0x0ebb }
            r6 = 0
            java.lang.reflect.Method r3 = r5.getMethod(r3, r6)     // Catch:{ all -> 0x0ebb }
            java.lang.Object r3 = r3.invoke(r4, r6)     // Catch:{ all -> 0x0ebb }
            onAppOpenAttributionNative = r3     // Catch:{ all -> 0x10c8 }
            int r3 = onAppOpenAttribution
            int r3 = r3 + 86
            r4 = 1
            int r3 = r3 - r4
            int r4 = r3 % 128
            onResponseErrorNative = r4
            r4 = 2
            int r3 = r3 % r4
            goto L_0x0ec7
        L_0x0ebb:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x10c8 }
            if (r3 == 0) goto L_0x0ec4
            throw r3     // Catch:{ all -> 0x10c8 }
        L_0x0ec4:
            throw r2     // Catch:{ all -> 0x10c8 }
        L_0x0ec5:
            r2 = 0
            throw r2     // Catch:{ all -> 0x10c8 }
        L_0x0ec7:
            r4 = 108(0x6c, float:1.51E-43)
            r11 = 43
            goto L_0x1412
        L_0x0ecd:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x10c8 }
            if (r3 == 0) goto L_0x0ed6
            throw r3     // Catch:{ all -> 0x10c8 }
        L_0x0ed6:
            throw r2     // Catch:{ all -> 0x10c8 }
        L_0x0ed7:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x10c8 }
            if (r3 == 0) goto L_0x0ee0
            throw r3     // Catch:{ all -> 0x10c8 }
        L_0x0ee0:
            throw r2     // Catch:{ all -> 0x10c8 }
        L_0x0ee1:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0fc1 }
            if (r3 == 0) goto L_0x0eea
            throw r3     // Catch:{ all -> 0x0fc1 }
        L_0x0eea:
            throw r2     // Catch:{ all -> 0x0fc1 }
        L_0x0eeb:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0fc1 }
            if (r3 == 0) goto L_0x0ef4
            throw r3     // Catch:{ all -> 0x0fc1 }
        L_0x0ef4:
            throw r2     // Catch:{ all -> 0x0fc1 }
        L_0x0ef5:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0fc1 }
            if (r3 == 0) goto L_0x0efe
            throw r3     // Catch:{ all -> 0x0fc1 }
        L_0x0efe:
            throw r2     // Catch:{ all -> 0x0fc1 }
        L_0x0eff:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0fc1 }
            if (r3 == 0) goto L_0x0f08
            throw r3     // Catch:{ all -> 0x0fc1 }
        L_0x0f08:
            throw r2     // Catch:{ all -> 0x0fc1 }
        L_0x0f09:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0fc1 }
            if (r3 == 0) goto L_0x0f12
            throw r3     // Catch:{ all -> 0x0fc1 }
        L_0x0f12:
            throw r2     // Catch:{ all -> 0x0fc1 }
        L_0x0f13:
            int r6 = onResponseErrorNative
            int r6 = r6 + 81
            int r7 = r6 % 128
            onAppOpenAttribution = r7
            r8 = 2
            int r6 = r6 % r8
            r6 = r7 | 1
            r8 = 1
            int r6 = r6 << r8
            r7 = r7 ^ 1
            int r6 = r6 - r7
            int r7 = r6 % 128
            onResponseErrorNative = r7
            r7 = 2
            int r6 = r6 % r7
            r6 = 3
            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ all -> 0x0f91 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0f91 }
            r8[r7] = r6     // Catch:{ all -> 0x0f91 }
            r6 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0f91 }
            r15 = 1
            r8[r15] = r7     // Catch:{ all -> 0x0f91 }
            r8[r6] = r4     // Catch:{ all -> 0x0f91 }
            r6 = 43
            byte r7 = r13[r6]     // Catch:{ all -> 0x0f91 }
            byte r6 = (byte) r7     // Catch:{ all -> 0x0f91 }
            r7 = r14 ^ 83
            r14 = r14 & 83
            r7 = r7 | r14
            short r7 = (short) r7     // Catch:{ all -> 0x0f91 }
            r14 = 98
            byte r15 = r13[r14]     // Catch:{ all -> 0x0f91 }
            byte r14 = (byte) r15     // Catch:{ all -> 0x0f91 }
            java.lang.String r6 = $$c(r6, r7, r14)     // Catch:{ all -> 0x0f91 }
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x0f91 }
            byte r7 = r13[r25]     // Catch:{ all -> 0x0f91 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x0f91 }
            r14 = r7 ^ 707(0x2c3, float:9.91E-43)
            r15 = r7 & 707(0x2c3, float:9.91E-43)
            r14 = r14 | r15
            short r14 = (short) r14     // Catch:{ all -> 0x0f91 }
            r15 = 405(0x195, float:5.68E-43)
            byte r13 = r13[r15]     // Catch:{ all -> 0x0f91 }
            r15 = 0
            int r13 = r13 - r15
            r26 = 1
            int r13 = r13 + -1
            byte r13 = (byte) r13     // Catch:{ all -> 0x0f91 }
            java.lang.String r7 = $$c(r7, r14, r13)     // Catch:{ all -> 0x0f91 }
            r13 = 3
            java.lang.Class[] r14 = new java.lang.Class[r13]     // Catch:{ all -> 0x0f91 }
            r14[r15] = r1     // Catch:{ all -> 0x0f91 }
            java.lang.Class r13 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0f91 }
            r14[r26] = r13     // Catch:{ all -> 0x0f91 }
            java.lang.Class r13 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0f91 }
            r15 = 2
            r14[r15] = r13     // Catch:{ all -> 0x0f91 }
            java.lang.reflect.Method r6 = r6.getMethod(r7, r14)     // Catch:{ all -> 0x0f91 }
            r6.invoke(r2, r8)     // Catch:{ all -> 0x0f91 }
            int r3 = -r3
            int r3 = ~r3
            int r12 = r12 - r3
            r3 = 1
            int r12 = r12 - r3
            r6 = r19
            r8 = r35
            r7 = r37
            r3 = r38
            goto L_0x0be3
        L_0x0f91:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0fc1 }
            if (r3 == 0) goto L_0x0f9a
            throw r3     // Catch:{ all -> 0x0fc1 }
        L_0x0f9a:
            throw r2     // Catch:{ all -> 0x0fc1 }
        L_0x0f9b:
            r0 = move-exception
            goto L_0x0fa4
        L_0x0f9d:
            r0 = move-exception
            goto L_0x0fa2
        L_0x0f9f:
            r0 = move-exception
            r19 = r6
        L_0x0fa2:
            r35 = r8
        L_0x0fa4:
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0fc1 }
            if (r3 == 0) goto L_0x0fac
            throw r3     // Catch:{ all -> 0x0fc1 }
        L_0x0fac:
            throw r2     // Catch:{ all -> 0x0fc1 }
        L_0x0fad:
            r0 = move-exception
            r19 = r6
            r35 = r8
            goto L_0x0fc2
        L_0x0fb3:
            r0 = move-exception
            r19 = r6
            r35 = r8
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ Exception -> 0x0fc4 }
            if (r3 == 0) goto L_0x0fc0
            throw r3     // Catch:{ Exception -> 0x0fc4 }
        L_0x0fc0:
            throw r2     // Catch:{ Exception -> 0x0fc4 }
        L_0x0fc1:
            r0 = move-exception
        L_0x0fc2:
            r2 = r0
            goto L_0x103a
        L_0x0fc4:
            r0 = move-exception
            r2 = r0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0fc1 }
            r3.<init>()     // Catch:{ all -> 0x0fc1 }
            byte[] r4 = onConversionDataSuccess     // Catch:{ all -> 0x0fc1 }
            byte r6 = r4[r25]     // Catch:{ all -> 0x0fc1 }
            byte r6 = (byte) r6     // Catch:{ all -> 0x0fc1 }
            r7 = 576(0x240, float:8.07E-43)
            short r7 = (short) r7     // Catch:{ all -> 0x0fc1 }
            r8 = 892(0x37c, float:1.25E-42)
            byte r9 = r4[r8]     // Catch:{ all -> 0x0fc1 }
            byte r8 = (byte) r9     // Catch:{ all -> 0x0fc1 }
            java.lang.String r6 = $$c(r6, r7, r8)     // Catch:{ all -> 0x0fc1 }
            java.lang.StringBuilder r3 = r3.append(r6)     // Catch:{ all -> 0x0fc1 }
            java.lang.StringBuilder r3 = r3.append(r11)     // Catch:{ all -> 0x0fc1 }
            byte r6 = r4[r24]     // Catch:{ all -> 0x0fc1 }
            byte r7 = (byte) r6     // Catch:{ all -> 0x0fc1 }
            r8 = r7 | 694(0x2b6, float:9.73E-43)
            short r8 = (short) r8     // Catch:{ all -> 0x0fc1 }
            byte r6 = (byte) r6     // Catch:{ all -> 0x0fc1 }
            java.lang.String r6 = $$c(r7, r8, r6)     // Catch:{ all -> 0x0fc1 }
            java.lang.StringBuilder r3 = r3.append(r6)     // Catch:{ all -> 0x0fc1 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0fc1 }
            r6 = 2
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x1030 }
            r6 = 1
            r7[r6] = r2     // Catch:{ all -> 0x1030 }
            r2 = 0
            r7[r2] = r3     // Catch:{ all -> 0x1030 }
            r2 = 8
            byte r3 = r4[r2]     // Catch:{ all -> 0x1030 }
            byte r2 = (byte) r3     // Catch:{ all -> 0x1030 }
            int r3 = onResponseNative     // Catch:{ all -> 0x1030 }
            r6 = 53
            r3 = r3 | r6
            short r3 = (short) r3     // Catch:{ all -> 0x1030 }
            r6 = 98
            byte r4 = r4[r6]     // Catch:{ all -> 0x1030 }
            byte r4 = (byte) r4     // Catch:{ all -> 0x1030 }
            java.lang.String r2 = $$c(r2, r3, r4)     // Catch:{ all -> 0x1030 }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x1030 }
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x1030 }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r6 = 0
            r4[r6] = r3     // Catch:{ all -> 0x1030 }
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            r6 = 1
            r4[r6] = r3     // Catch:{ all -> 0x1030 }
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r4)     // Catch:{ all -> 0x1030 }
            java.lang.Object r2 = r2.newInstance(r7)     // Catch:{ all -> 0x1030 }
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x1030 }
            throw r2     // Catch:{ all -> 0x1030 }
        L_0x1030:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0fc1 }
            if (r3 == 0) goto L_0x1039
            throw r3     // Catch:{ all -> 0x0fc1 }
        L_0x1039:
            throw r2     // Catch:{ all -> 0x0fc1 }
        L_0x103a:
            byte[] r3 = onConversionDataSuccess     // Catch:{ all -> 0x10bc }
            r4 = 108(0x6c, float:1.51E-43)
            byte r6 = r3[r4]     // Catch:{ all -> 0x10ba }
            byte r4 = (byte) r6
            r6 = r4 ^ 112(0x70, float:1.57E-43)
            r7 = r4 & 112(0x70, float:1.57E-43)
            r6 = r6 | r7
            short r6 = (short) r6
            r7 = 98
            byte r8 = r3[r7]     // Catch:{ all -> 0x10bc }
            byte r7 = (byte) r8     // Catch:{ all -> 0x10bc }
            java.lang.String r4 = $$c(r4, r6, r7)     // Catch:{ all -> 0x10bc }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x10bc }
            r6 = 53
            byte r7 = r3[r6]     // Catch:{ all -> 0x10bc }
            byte r6 = (byte) r7     // Catch:{ all -> 0x10bc }
            r7 = r6 ^ 344(0x158, float:4.82E-43)
            r8 = r6 & 344(0x158, float:4.82E-43)
            r7 = r7 | r8
            short r7 = (short) r7     // Catch:{ all -> 0x10bc }
            r8 = 25
            byte r8 = r3[r8]     // Catch:{ all -> 0x10bc }
            int r8 = -r8
            byte r8 = (byte) r8     // Catch:{ all -> 0x10bc }
            java.lang.String r6 = $$c(r6, r7, r8)     // Catch:{ all -> 0x10bc }
            r7 = 0
            java.lang.reflect.Method r4 = r4.getMethod(r6, r7)     // Catch:{ all -> 0x10bc }
            java.lang.Object r4 = r4.invoke(r11, r7)     // Catch:{ all -> 0x10bc }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x10bc }
            r4.booleanValue()     // Catch:{ all -> 0x10bc }
            r4 = 108(0x6c, float:1.51E-43)
            byte r6 = r3[r4]     // Catch:{ all -> 0x10b0 }
            byte r6 = (byte) r6     // Catch:{ all -> 0x10b0 }
            r7 = r6 ^ 112(0x70, float:1.57E-43)
            r8 = r6 & 112(0x70, float:1.57E-43)
            r7 = r7 | r8
            short r7 = (short) r7     // Catch:{ all -> 0x10b0 }
            r8 = 98
            byte r9 = r3[r8]     // Catch:{ all -> 0x10b0 }
            byte r8 = (byte) r9     // Catch:{ all -> 0x10b0 }
            java.lang.String r6 = $$c(r6, r7, r8)     // Catch:{ all -> 0x10b0 }
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x10b0 }
            r7 = 53
            byte r8 = r3[r7]     // Catch:{ all -> 0x10b0 }
            byte r7 = (byte) r8     // Catch:{ all -> 0x10b0 }
            r8 = r7 | 344(0x158, float:4.82E-43)
            short r8 = (short) r8     // Catch:{ all -> 0x10b0 }
            r9 = 25
            byte r3 = r3[r9]     // Catch:{ all -> 0x10b0 }
            int r3 = -r3
            byte r3 = (byte) r3     // Catch:{ all -> 0x10b0 }
            java.lang.String r3 = $$c(r7, r8, r3)     // Catch:{ all -> 0x10b0 }
            r7 = 0
            java.lang.reflect.Method r3 = r6.getMethod(r3, r7)     // Catch:{ all -> 0x10b0 }
            java.lang.Object r3 = r3.invoke(r5, r7)     // Catch:{ all -> 0x10b0 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x10b0 }
            r3.booleanValue()     // Catch:{ all -> 0x10b0 }
            throw r2     // Catch:{ all -> 0x10c8 }
        L_0x10b0:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x10c8 }
            if (r3 == 0) goto L_0x10b9
            throw r3     // Catch:{ all -> 0x10c8 }
        L_0x10b9:
            throw r2     // Catch:{ all -> 0x10c8 }
        L_0x10ba:
            r0 = move-exception
            goto L_0x10bf
        L_0x10bc:
            r0 = move-exception
            r4 = 108(0x6c, float:1.51E-43)
        L_0x10bf:
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x10c8 }
            if (r3 == 0) goto L_0x10c7
            throw r3     // Catch:{ all -> 0x10c8 }
        L_0x10c7:
            throw r2     // Catch:{ all -> 0x10c8 }
        L_0x10c8:
            r0 = move-exception
            goto L_0x10cf
        L_0x10ca:
            r0 = move-exception
            r19 = r6
            r35 = r8
        L_0x10cf:
            r2 = r0
            goto L_0x0896
        L_0x10d2:
            r38 = r3
            r19 = r6
            r37 = r7
            r35 = r8
            r4 = 108(0x6c, float:1.51E-43)
            java.util.zip.ZipInputStream r3 = new java.util.zip.ZipInputStream     // Catch:{ all -> 0x1811 }
            r3.<init>(r10)     // Catch:{ all -> 0x1811 }
            java.util.zip.ZipEntry r5 = r3.getNextEntry()     // Catch:{ all -> 0x1811 }
            int r6 = onResponseErrorNative
            r7 = r6 ^ 27
            r6 = r6 & 27
            r8 = 1
            int r6 = r6 << r8
            int r7 = r7 + r6
            int r6 = r7 % 128
            onAppOpenAttribution = r6
            r6 = 2
            int r7 = r7 % r6
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ all -> 0x1806 }
            r7 = 0
            r6[r7] = r3     // Catch:{ all -> 0x1806 }
            r3 = 604(0x25c, float:8.46E-43)
            byte r3 = r2[r3]     // Catch:{ all -> 0x1806 }
            byte r3 = (byte) r3     // Catch:{ all -> 0x1806 }
            r7 = r3 | 928(0x3a0, float:1.3E-42)
            short r7 = (short) r7     // Catch:{ all -> 0x1806 }
            r8 = 98
            byte r10 = r2[r8]     // Catch:{ all -> 0x1806 }
            byte r8 = (byte) r10     // Catch:{ all -> 0x1806 }
            java.lang.String r3 = $$c(r3, r7, r8)     // Catch:{ all -> 0x1806 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x1806 }
            r7 = 1
            java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch:{ all -> 0x1806 }
            r7 = 8
            byte r10 = r2[r7]     // Catch:{ all -> 0x1806 }
            byte r7 = (byte) r10     // Catch:{ all -> 0x1806 }
            byte r10 = r2[r24]     // Catch:{ all -> 0x1806 }
            short r10 = (short) r10     // Catch:{ all -> 0x1806 }
            r11 = 98
            byte r12 = r2[r11]     // Catch:{ all -> 0x1806 }
            byte r11 = (byte) r12     // Catch:{ all -> 0x1806 }
            java.lang.String r7 = $$c(r7, r10, r11)     // Catch:{ all -> 0x1806 }
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x1806 }
            r10 = 0
            r8[r10] = r7     // Catch:{ all -> 0x1806 }
            java.lang.reflect.Constructor r3 = r3.getDeclaredConstructor(r8)     // Catch:{ all -> 0x1806 }
            java.lang.Object r3 = r3.newInstance(r6)     // Catch:{ all -> 0x1806 }
            int r6 = onResponseErrorNative
            r7 = r6 | 97
            r8 = 1
            int r7 = r7 << r8
            r6 = r6 ^ 97
            int r7 = r7 - r6
            int r6 = r7 % 128
            onAppOpenAttribution = r6
            r6 = 2
            int r7 = r7 % r6
            r6 = 892(0x37c, float:1.25E-42)
            byte r7 = r2[r6]     // Catch:{ all -> 0x17fb }
            byte r6 = (byte) r7     // Catch:{ all -> 0x17fb }
            int r7 = onResponseNative     // Catch:{ all -> 0x17fb }
            r7 = r7 | 288(0x120, float:4.04E-43)
            short r7 = (short) r7     // Catch:{ all -> 0x17fb }
            r8 = 98
            byte r2 = r2[r8]     // Catch:{ all -> 0x17fb }
            byte r2 = (byte) r2     // Catch:{ all -> 0x17fb }
            java.lang.String r2 = $$c(r6, r7, r2)     // Catch:{ all -> 0x17fb }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x17fb }
            r6 = 0
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r6)     // Catch:{ all -> 0x17fb }
            java.lang.Object r2 = r2.newInstance(r6)     // Catch:{ all -> 0x17fb }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x1811 }
            r7 = 0
        L_0x1165:
            r8 = 1
            java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ all -> 0x17f0 }
            r8 = 0
            r10[r8] = r6     // Catch:{ all -> 0x17f0 }
            byte[] r8 = onConversionDataSuccess     // Catch:{ all -> 0x17f0 }
            r11 = 604(0x25c, float:8.46E-43)
            byte r11 = r8[r11]     // Catch:{ all -> 0x17f0 }
            byte r11 = (byte) r11     // Catch:{ all -> 0x17f0 }
            r12 = r11 ^ 928(0x3a0, float:1.3E-42)
            r13 = r11 & 928(0x3a0, float:1.3E-42)
            r12 = r12 | r13
            short r12 = (short) r12     // Catch:{ all -> 0x17f0 }
            r13 = 98
            byte r14 = r8[r13]     // Catch:{ all -> 0x17f0 }
            byte r13 = (byte) r14     // Catch:{ all -> 0x17f0 }
            java.lang.String r11 = $$c(r11, r12, r13)     // Catch:{ all -> 0x17f0 }
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch:{ all -> 0x17f0 }
            r12 = 9
            byte r13 = r8[r12]     // Catch:{ all -> 0x17f0 }
            byte r12 = (byte) r13     // Catch:{ all -> 0x17f0 }
            int r13 = onResponseNative     // Catch:{ all -> 0x17f0 }
            r14 = r13 ^ 561(0x231, float:7.86E-43)
            r15 = r13 & 561(0x231, float:7.86E-43)
            r14 = r14 | r15
            short r14 = (short) r14     // Catch:{ all -> 0x17f0 }
            r15 = 392(0x188, float:5.5E-43)
            byte r15 = r8[r15]     // Catch:{ all -> 0x17f0 }
            byte r15 = (byte) r15     // Catch:{ all -> 0x17f0 }
            java.lang.String r12 = $$c(r12, r14, r15)     // Catch:{ all -> 0x17f0 }
            r14 = 1
            java.lang.Class[] r15 = new java.lang.Class[r14]     // Catch:{ all -> 0x17f0 }
            r14 = 0
            r15[r14] = r1     // Catch:{ all -> 0x17f0 }
            java.lang.reflect.Method r11 = r11.getMethod(r12, r15)     // Catch:{ all -> 0x17f0 }
            java.lang.Object r10 = r11.invoke(r3, r10)     // Catch:{ all -> 0x17f0 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x17f0 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x17f0 }
            if (r10 <= 0) goto L_0x11b3
            r11 = 1
            goto L_0x11b4
        L_0x11b3:
            r11 = 0
        L_0x11b4:
            r12 = 1
            if (r11 == r12) goto L_0x11b8
            goto L_0x11ca
        L_0x11b8:
            long r11 = (long) r7
            long r14 = r5.getSize()     // Catch:{ all -> 0x1811 }
            int r11 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r11 >= 0) goto L_0x11c4
            r11 = 88
            goto L_0x11c6
        L_0x11c4:
            r11 = 51
        L_0x11c6:
            r12 = 88
            if (r11 == r12) goto L_0x1776
        L_0x11ca:
            r5 = 892(0x37c, float:1.25E-42)
            byte r6 = r8[r5]     // Catch:{ all -> 0x1766 }
            byte r5 = (byte) r6     // Catch:{ all -> 0x1766 }
            r6 = r13 | 288(0x120, float:4.04E-43)
            short r6 = (short) r6     // Catch:{ all -> 0x1766 }
            r7 = 98
            byte r10 = r8[r7]     // Catch:{ all -> 0x1766 }
            byte r7 = (byte) r10     // Catch:{ all -> 0x1766 }
            java.lang.String r5 = $$c(r5, r6, r7)     // Catch:{ all -> 0x1766 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x1766 }
            r6 = 33
            byte r6 = r8[r6]     // Catch:{ all -> 0x1766 }
            byte r6 = (byte) r6     // Catch:{ all -> 0x1766 }
            r7 = 631(0x277, float:8.84E-43)
            byte r7 = r8[r7]     // Catch:{ all -> 0x1766 }
            short r7 = (short) r7     // Catch:{ all -> 0x1766 }
            r10 = 30
            byte r10 = r8[r10]     // Catch:{ all -> 0x1766 }
            r11 = r10 & 1
            r12 = 1
            r10 = r10 | r12
            int r11 = r11 + r10
            byte r10 = (byte) r11     // Catch:{ all -> 0x1766 }
            java.lang.String r6 = $$c(r6, r7, r10)     // Catch:{ all -> 0x1766 }
            r7 = 0
            java.lang.reflect.Method r5 = r5.getMethod(r6, r7)     // Catch:{ all -> 0x1766 }
            java.lang.Object r5 = r5.invoke(r2, r7)     // Catch:{ all -> 0x1766 }
            r6 = 604(0x25c, float:8.46E-43)
            byte r6 = r8[r6]     // Catch:{ all -> 0x1233 }
            byte r6 = (byte) r6     // Catch:{ all -> 0x1233 }
            r7 = r6 ^ 928(0x3a0, float:1.3E-42)
            r10 = r6 & 928(0x3a0, float:1.3E-42)
            r7 = r7 | r10
            short r7 = (short) r7     // Catch:{ all -> 0x1233 }
            r10 = 98
            byte r11 = r8[r10]     // Catch:{ all -> 0x1233 }
            byte r10 = (byte) r11     // Catch:{ all -> 0x1233 }
            java.lang.String r6 = $$c(r6, r7, r10)     // Catch:{ all -> 0x1233 }
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x1233 }
            byte r7 = r8[r25]     // Catch:{ all -> 0x1233 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x1233 }
            r10 = r7 ^ 306(0x132, float:4.29E-43)
            r11 = r7 & 306(0x132, float:4.29E-43)
            r10 = r10 | r11
            short r10 = (short) r10     // Catch:{ all -> 0x1233 }
            r11 = 135(0x87, float:1.89E-43)
            byte r8 = r8[r11]     // Catch:{ all -> 0x1233 }
            byte r8 = (byte) r8     // Catch:{ all -> 0x1233 }
            java.lang.String r7 = $$c(r7, r10, r8)     // Catch:{ all -> 0x1233 }
            r8 = 0
            java.lang.reflect.Method r6 = r6.getMethod(r7, r8)     // Catch:{ all -> 0x1233 }
            r6.invoke(r3, r8)     // Catch:{ all -> 0x1233 }
            goto L_0x123d
        L_0x1233:
            r0 = move-exception
            r3 = r0
            java.lang.Throwable r6 = r3.getCause()     // Catch:{ IOException -> 0x123d }
            if (r6 == 0) goto L_0x123c
            throw r6     // Catch:{ IOException -> 0x123d }
        L_0x123c:
            throw r3     // Catch:{ IOException -> 0x123d }
        L_0x123d:
            byte[] r3 = onConversionDataSuccess     // Catch:{ all -> 0x1274 }
            r6 = 892(0x37c, float:1.25E-42)
            byte r7 = r3[r6]     // Catch:{ all -> 0x1274 }
            byte r6 = (byte) r7     // Catch:{ all -> 0x1274 }
            int r7 = onResponseNative     // Catch:{ all -> 0x1274 }
            r8 = r7 ^ 288(0x120, float:4.04E-43)
            r7 = r7 & 288(0x120, float:4.04E-43)
            r7 = r7 | r8
            short r7 = (short) r7     // Catch:{ all -> 0x1274 }
            r8 = 98
            byte r10 = r3[r8]     // Catch:{ all -> 0x1274 }
            byte r8 = (byte) r10     // Catch:{ all -> 0x1274 }
            java.lang.String r6 = $$c(r6, r7, r8)     // Catch:{ all -> 0x1274 }
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x1274 }
            byte r7 = r3[r25]     // Catch:{ all -> 0x1274 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x1274 }
            r8 = r7 ^ 306(0x132, float:4.29E-43)
            r10 = r7 & 306(0x132, float:4.29E-43)
            r8 = r8 | r10
            short r8 = (short) r8     // Catch:{ all -> 0x1274 }
            r10 = 135(0x87, float:1.89E-43)
            byte r3 = r3[r10]     // Catch:{ all -> 0x1274 }
            byte r3 = (byte) r3     // Catch:{ all -> 0x1274 }
            java.lang.String r3 = $$c(r7, r8, r3)     // Catch:{ all -> 0x1274 }
            r7 = 0
            java.lang.reflect.Method r3 = r6.getMethod(r3, r7)     // Catch:{ all -> 0x1274 }
            r3.invoke(r2, r7)     // Catch:{ all -> 0x1274 }
            goto L_0x127e
        L_0x1274:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ IOException -> 0x127e }
            if (r3 == 0) goto L_0x127d
            throw r3     // Catch:{ IOException -> 0x127e }
        L_0x127d:
            throw r2     // Catch:{ IOException -> 0x127e }
        L_0x127e:
            java.lang.Class<com.appsflyer.internal.AFa1vSDK> r2 = com.appsflyer.internal.AFa1vSDK.class
            int r3 = onAppOpenAttribution
            int r3 = r3 + 36
            r6 = 1
            int r3 = r3 - r6
            int r6 = r3 % 128
            onResponseErrorNative = r6
            r6 = 2
            int r3 = r3 % r6
            java.lang.Class<java.lang.Class> r3 = java.lang.Class.class
            byte[] r6 = onConversionDataSuccess     // Catch:{ all -> 0x1756 }
            r7 = 196(0xc4, float:2.75E-43)
            byte r7 = r6[r7]     // Catch:{ all -> 0x1756 }
            byte r7 = (byte) r7
            r8 = 372(0x174, float:5.21E-43)
            short r8 = (short) r8
            r10 = 17
            byte r11 = r6[r10]     // Catch:{ all -> 0x174f }
            byte r10 = (byte) r11
            java.lang.String r7 = $$c(r7, r8, r10)     // Catch:{ all -> 0x1756 }
            r8 = 0
            java.lang.reflect.Method r3 = r3.getMethod(r7, r8)     // Catch:{ all -> 0x1756 }
            java.lang.Object r2 = r3.invoke(r2, r8)     // Catch:{ all -> 0x1756 }
            r3 = 57
            byte r3 = r6[r3]     // Catch:{ all -> 0x10c8 }
            r7 = r3 | -1
            r8 = 1
            int r7 = r7 << r8
            r3 = r3 ^ -1
            int r7 = r7 - r3
            byte r3 = (byte) r7     // Catch:{ all -> 0x10c8 }
            r7 = 796(0x31c, float:1.115E-42)
            short r7 = (short) r7     // Catch:{ all -> 0x10c8 }
            r8 = 25
            byte r8 = r6[r8]     // Catch:{ all -> 0x10c8 }
            int r8 = -r8
            byte r8 = (byte) r8     // Catch:{ all -> 0x10c8 }
            java.lang.String r3 = $$c(r3, r7, r8)     // Catch:{ all -> 0x10c8 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x10c8 }
            r7 = 2
            java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch:{ all -> 0x10c8 }
            r7 = 8
            byte r10 = r6[r7]     // Catch:{ all -> 0x10c8 }
            byte r7 = (byte) r10     // Catch:{ all -> 0x10c8 }
            r10 = 864(0x360, float:1.211E-42)
            short r10 = (short) r10     // Catch:{ all -> 0x10c8 }
            r11 = 98
            byte r12 = r6[r11]     // Catch:{ all -> 0x10c8 }
            byte r11 = (byte) r12     // Catch:{ all -> 0x10c8 }
            java.lang.String r7 = $$c(r7, r10, r11)     // Catch:{ all -> 0x10c8 }
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x10c8 }
            r11 = 0
            r8[r11] = r7     // Catch:{ all -> 0x10c8 }
            r7 = 434(0x1b2, float:6.08E-43)
            byte r7 = r6[r7]     // Catch:{ all -> 0x10c8 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x10c8 }
            int r11 = onResponseNative     // Catch:{ all -> 0x10c8 }
            int r12 = r11 << 2
            short r12 = (short) r12     // Catch:{ all -> 0x10c8 }
            r13 = 98
            byte r14 = r6[r13]     // Catch:{ all -> 0x10c8 }
            byte r13 = (byte) r14     // Catch:{ all -> 0x10c8 }
            java.lang.String r7 = $$c(r7, r12, r13)     // Catch:{ all -> 0x10c8 }
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x10c8 }
            r12 = 1
            r8[r12] = r7     // Catch:{ all -> 0x10c8 }
            java.lang.reflect.Constructor r3 = r3.getDeclaredConstructor(r8)     // Catch:{ all -> 0x10c8 }
            r7 = 2
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ all -> 0x10c8 }
            java.lang.Object[] r7 = new java.lang.Object[r12]     // Catch:{ all -> 0x173f }
            r12 = 0
            r7[r12] = r5     // Catch:{ all -> 0x173f }
            r5 = 8
            byte r12 = r6[r5]     // Catch:{ all -> 0x173f }
            byte r5 = (byte) r12     // Catch:{ all -> 0x173f }
            r12 = 98
            byte r13 = r6[r12]     // Catch:{ all -> 0x173f }
            byte r12 = (byte) r13     // Catch:{ all -> 0x173f }
            java.lang.String r5 = $$c(r5, r10, r12)     // Catch:{ all -> 0x173f }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x173f }
            r10 = 9
            byte r12 = r6[r10]     // Catch:{ all -> 0x173f }
            byte r10 = (byte) r12     // Catch:{ all -> 0x173f }
            r12 = 604(0x25c, float:8.46E-43)
            byte r12 = r6[r12]     // Catch:{ all -> 0x173f }
            short r12 = (short) r12     // Catch:{ all -> 0x173f }
            r13 = 405(0x195, float:5.68E-43)
            byte r13 = r6[r13]     // Catch:{ all -> 0x173f }
            r14 = 0
            int r13 = r13 - r14
            r15 = 1
            int r13 = r13 - r15
            byte r13 = (byte) r13     // Catch:{ all -> 0x173f }
            java.lang.String r10 = $$c(r10, r12, r13)     // Catch:{ all -> 0x173f }
            java.lang.Class[] r12 = new java.lang.Class[r15]     // Catch:{ all -> 0x173f }
            r12[r14] = r1     // Catch:{ all -> 0x173f }
            java.lang.reflect.Method r5 = r5.getMethod(r10, r12)     // Catch:{ all -> 0x173f }
            r10 = 0
            java.lang.Object r5 = r5.invoke(r10, r7)     // Catch:{ all -> 0x173f }
            r8[r14] = r5     // Catch:{ all -> 0x10c8 }
            r8[r15] = r2     // Catch:{ all -> 0x10c8 }
            java.lang.Object r3 = r3.newInstance(r8)     // Catch:{ all -> 0x10c8 }
            r5 = 908(0x38c, float:1.272E-42)
            byte r5 = r6[r5]     // Catch:{ Exception -> 0x16bd }
            byte r5 = (byte) r5     // Catch:{ Exception -> 0x16bd }
            r7 = r11 ^ 529(0x211, float:7.41E-43)
            r8 = r11 & 529(0x211, float:7.41E-43)
            r7 = r7 | r8
            short r7 = (short) r7     // Catch:{ Exception -> 0x16bd }
            r8 = 25
            byte r8 = r6[r8]     // Catch:{ Exception -> 0x16bd }
            int r8 = -r8
            byte r8 = (byte) r8     // Catch:{ Exception -> 0x16bd }
            java.lang.String r5 = $$c(r5, r7, r8)     // Catch:{ Exception -> 0x16bd }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ Exception -> 0x16bd }
            r7 = 152(0x98, float:2.13E-43)
            byte r7 = r6[r7]     // Catch:{ Exception -> 0x16bd }
            byte r7 = (byte) r7     // Catch:{ Exception -> 0x16bd }
            r8 = 150(0x96, float:2.1E-43)
            short r8 = (short) r8     // Catch:{ Exception -> 0x16bd }
            r10 = 88
            byte r10 = r6[r10]     // Catch:{ Exception -> 0x16bd }
            r11 = r10 | -1
            r12 = 1
            int r11 = r11 << r12
            r10 = r10 ^ -1
            int r11 = r11 - r10
            byte r10 = (byte) r11     // Catch:{ Exception -> 0x16bd }
            java.lang.String r7 = $$c(r7, r8, r10)     // Catch:{ Exception -> 0x16bd }
            java.lang.reflect.Field r5 = r5.getDeclaredField(r7)     // Catch:{ Exception -> 0x16bd }
            r5.setAccessible(r12)     // Catch:{ Exception -> 0x16bd }
            java.lang.Object r7 = r5.get(r2)     // Catch:{ Exception -> 0x16bd }
            java.lang.Class r8 = r7.getClass()     // Catch:{ Exception -> 0x16bd }
            r11 = 43
            byte r10 = r6[r11]     // Catch:{ Exception -> 0x16bb }
            byte r10 = (byte) r10     // Catch:{ Exception -> 0x16bb }
            short r12 = (short) r10     // Catch:{ Exception -> 0x16bb }
            r13 = 151(0x97, float:2.12E-43)
            byte r13 = r6[r13]     // Catch:{ Exception -> 0x16bb }
            int r13 = r13 + 2
            r14 = 1
            int r13 = r13 - r14
            byte r13 = (byte) r13     // Catch:{ Exception -> 0x16bb }
            java.lang.String r10 = $$c(r10, r12, r13)     // Catch:{ Exception -> 0x16bb }
            java.lang.reflect.Field r10 = r8.getDeclaredField(r10)     // Catch:{ Exception -> 0x16bb }
            r10.setAccessible(r14)     // Catch:{ Exception -> 0x16bb }
            r12 = 37
            byte r12 = r6[r12]     // Catch:{ Exception -> 0x16bb }
            byte r12 = (byte) r12     // Catch:{ Exception -> 0x16bb }
            r13 = 334(0x14e, float:4.68E-43)
            short r13 = (short) r13     // Catch:{ Exception -> 0x16bb }
            r14 = 151(0x97, float:2.12E-43)
            byte r6 = r6[r14]     // Catch:{ Exception -> 0x16bb }
            r14 = r6 | 1
            r15 = 1
            int r14 = r14 << r15
            r6 = r6 ^ r15
            int r14 = r14 - r6
            byte r6 = (byte) r14     // Catch:{ Exception -> 0x16bb }
            java.lang.String r6 = $$c(r12, r13, r6)     // Catch:{ Exception -> 0x16bb }
            java.lang.reflect.Field r6 = r8.getDeclaredField(r6)     // Catch:{ Exception -> 0x16bb }
            r6.setAccessible(r15)     // Catch:{ Exception -> 0x16bb }
            java.lang.Object r8 = r10.get(r7)     // Catch:{ Exception -> 0x16bb }
            java.lang.Object r7 = r6.get(r7)     // Catch:{ Exception -> 0x16bb }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ Exception -> 0x16bb }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ Exception -> 0x16bb }
            java.util.List r8 = (java.util.List) r8     // Catch:{ Exception -> 0x16bb }
            r12.<init>(r8)     // Catch:{ Exception -> 0x16bb }
            java.lang.Class r8 = r7.getClass()     // Catch:{ Exception -> 0x16bb }
            java.lang.Class r8 = r8.getComponentType()     // Catch:{ Exception -> 0x16bb }
            int r13 = java.lang.reflect.Array.getLength(r7)     // Catch:{ Exception -> 0x16bb }
            java.lang.Object r8 = java.lang.reflect.Array.newInstance(r8, r13)     // Catch:{ Exception -> 0x16bb }
            r14 = 0
        L_0x13e2:
            if (r14 >= r13) goto L_0x13f8
            java.lang.Object r15 = java.lang.reflect.Array.get(r7, r14)     // Catch:{ Exception -> 0x13f0 }
            java.lang.reflect.Array.set(r8, r14, r15)     // Catch:{ Exception -> 0x13f0 }
            int r14 = r14 + 2
            r15 = 1
            int r14 = r14 - r15
            goto L_0x13e2
        L_0x13f0:
            r0 = move-exception
            r3 = r0
            r12 = 135(0x87, float:1.89E-43)
            r14 = 17
            goto L_0x16c5
        L_0x13f8:
            r10.set(r5, r12)     // Catch:{ Exception -> 0x16bb }
            r6.set(r5, r8)     // Catch:{ Exception -> 0x16bb }
            int r2 = onResponseErrorNative
            r5 = r2 & 47
            r2 = r2 | 47
            int r5 = r5 + r2
            int r2 = r5 % 128
            onAppOpenAttribution = r2
            r2 = 2
            int r5 = r5 % r2
            java.lang.Object r2 = onAppOpenAttributionNative     // Catch:{ all -> 0x10c8 }
            if (r2 != 0) goto L_0x1411
            onAppOpenAttributionNative = r3     // Catch:{ all -> 0x10c8 }
        L_0x1411:
            r2 = r3
        L_0x1412:
            if (r21 == 0) goto L_0x1416
            r3 = 1
            goto L_0x1418
        L_0x1416:
            r3 = 70
        L_0x1418:
            r5 = 1
            if (r3 == r5) goto L_0x146b
            byte[] r3 = onConversionDataSuccess     // Catch:{ all -> 0x10c8 }
            r5 = 434(0x1b2, float:6.08E-43)
            byte r5 = r3[r5]     // Catch:{ all -> 0x10c8 }
            byte r5 = (byte) r5     // Catch:{ all -> 0x10c8 }
            int r6 = onResponseNative     // Catch:{ all -> 0x10c8 }
            r7 = 2
            int r6 = r6 << r7
            short r6 = (short) r6     // Catch:{ all -> 0x10c8 }
            r7 = 98
            byte r8 = r3[r7]     // Catch:{ all -> 0x10c8 }
            byte r7 = (byte) r8     // Catch:{ all -> 0x10c8 }
            java.lang.String r5 = $$c(r5, r6, r7)     // Catch:{ all -> 0x10c8 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x10c8 }
            r6 = 18
            byte r6 = r3[r6]     // Catch:{ all -> 0x10c8 }
            byte r6 = (byte) r6     // Catch:{ all -> 0x10c8 }
            r7 = 285(0x11d, float:4.0E-43)
            byte r7 = r3[r7]     // Catch:{ all -> 0x10c8 }
            int r7 = -r7
            short r7 = (short) r7     // Catch:{ all -> 0x10c8 }
            r8 = 130(0x82, float:1.82E-43)
            byte r3 = r3[r8]     // Catch:{ all -> 0x10c8 }
            byte r3 = (byte) r3     // Catch:{ all -> 0x10c8 }
            java.lang.String r3 = $$c(r6, r7, r3)     // Catch:{ all -> 0x10c8 }
            r6 = 1
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch:{ all -> 0x10c8 }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r10 = 0
            r7[r10] = r8     // Catch:{ all -> 0x10c8 }
            java.lang.reflect.Method r3 = r5.getDeclaredMethod(r3, r7)     // Catch:{ all -> 0x10c8 }
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch:{ InvocationTargetException -> 0x1460 }
            r5[r10] = r9     // Catch:{ InvocationTargetException -> 0x1460 }
            java.lang.Object r3 = r3.invoke(r2, r5)     // Catch:{ InvocationTargetException -> 0x1460 }
        L_0x145c:
            r14 = 17
            goto L_0x1519
        L_0x1460:
            r0 = move-exception
            r3 = r0
            java.lang.Throwable r3 = r3.getCause()     // Catch:{ ClassNotFoundException -> 0x1469 }
            java.lang.Exception r3 = (java.lang.Exception) r3     // Catch:{ ClassNotFoundException -> 0x1469 }
            throw r3     // Catch:{ ClassNotFoundException -> 0x1469 }
        L_0x1469:
            r3 = 0
            goto L_0x145c
        L_0x146b:
            int r3 = onResponseErrorNative
            r5 = r3 & 107(0x6b, float:1.5E-43)
            r3 = r3 | 107(0x6b, float:1.5E-43)
            int r5 = r5 + r3
            int r3 = r5 % 128
            onAppOpenAttribution = r3
            r3 = 2
            int r5 = r5 % r3
            byte[] r3 = onConversionDataSuccess     // Catch:{ all -> 0x10c8 }
            r5 = 434(0x1b2, float:6.08E-43)
            byte r5 = r3[r5]     // Catch:{ all -> 0x10c8 }
            byte r5 = (byte) r5     // Catch:{ all -> 0x10c8 }
            r6 = r5 ^ 674(0x2a2, float:9.44E-43)
            r7 = r5 & 674(0x2a2, float:9.44E-43)
            r6 = r6 | r7
            short r6 = (short) r6     // Catch:{ all -> 0x10c8 }
            r7 = 25
            byte r7 = r3[r7]     // Catch:{ all -> 0x10c8 }
            int r7 = -r7
            byte r7 = (byte) r7     // Catch:{ all -> 0x10c8 }
            java.lang.String r5 = $$c(r5, r6, r7)     // Catch:{ all -> 0x10c8 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x10c8 }
            r6 = 18
            byte r6 = r3[r6]     // Catch:{ all -> 0x10c8 }
            byte r6 = (byte) r6     // Catch:{ all -> 0x10c8 }
            r7 = 285(0x11d, float:4.0E-43)
            byte r7 = r3[r7]     // Catch:{ all -> 0x10c8 }
            int r7 = -r7
            short r7 = (short) r7     // Catch:{ all -> 0x10c8 }
            r8 = 130(0x82, float:1.82E-43)
            byte r8 = r3[r8]     // Catch:{ all -> 0x10c8 }
            byte r8 = (byte) r8     // Catch:{ all -> 0x10c8 }
            java.lang.String r6 = $$c(r6, r7, r8)     // Catch:{ all -> 0x10c8 }
            r7 = 2
            java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch:{ all -> 0x10c8 }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r10 = 0
            r8[r10] = r7     // Catch:{ all -> 0x10c8 }
            r7 = 434(0x1b2, float:6.08E-43)
            byte r7 = r3[r7]     // Catch:{ all -> 0x10c8 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x10c8 }
            int r10 = onResponseNative     // Catch:{ all -> 0x10c8 }
            r12 = 2
            int r10 = r10 << r12
            short r10 = (short) r10     // Catch:{ all -> 0x10c8 }
            r12 = 98
            byte r13 = r3[r12]     // Catch:{ all -> 0x10c8 }
            byte r12 = (byte) r13     // Catch:{ all -> 0x10c8 }
            java.lang.String r7 = $$c(r7, r10, r12)     // Catch:{ all -> 0x10c8 }
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x10c8 }
            r10 = 1
            r8[r10] = r7     // Catch:{ all -> 0x10c8 }
            java.lang.reflect.Method r6 = r5.getDeclaredMethod(r6, r8)     // Catch:{ all -> 0x10c8 }
            r7 = 2
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ all -> 0x10c8 }
            r7 = 0
            r8[r7] = r9     // Catch:{ all -> 0x10c8 }
            java.lang.Class<com.appsflyer.internal.AFa1vSDK> r7 = com.appsflyer.internal.AFa1vSDK.class
            java.lang.Class<java.lang.Class> r9 = java.lang.Class.class
            r10 = 196(0xc4, float:2.75E-43)
            byte r10 = r3[r10]     // Catch:{ all -> 0x16ad }
            byte r10 = (byte) r10
            r12 = 372(0x174, float:5.21E-43)
            short r12 = (short) r12
            r14 = 17
            byte r13 = r3[r14]     // Catch:{ all -> 0x16a9 }
            byte r13 = (byte) r13     // Catch:{ all -> 0x16a9 }
            java.lang.String r10 = $$c(r10, r12, r13)     // Catch:{ all -> 0x16a9 }
            r12 = 0
            java.lang.reflect.Method r9 = r9.getMethod(r10, r12)     // Catch:{ all -> 0x16a9 }
            java.lang.Object r7 = r9.invoke(r7, r12)     // Catch:{ all -> 0x16a9 }
            r9 = 1
            r8[r9] = r7     // Catch:{ all -> 0x10c8 }
            java.lang.Object r6 = r6.invoke(r2, r8)     // Catch:{ all -> 0x10c8 }
            if (r6 == 0) goto L_0x1518
            byte r7 = r3[r25]     // Catch:{ all -> 0x10c8 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x10c8 }
            r8 = r7 ^ 306(0x132, float:4.29E-43)
            r9 = r7 & 306(0x132, float:4.29E-43)
            r8 = r8 | r9
            short r8 = (short) r8     // Catch:{ all -> 0x10c8 }
            r9 = 135(0x87, float:1.89E-43)
            byte r3 = r3[r9]     // Catch:{ all -> 0x10c8 }
            byte r3 = (byte) r3     // Catch:{ all -> 0x10c8 }
            java.lang.String r3 = $$c(r7, r8, r3)     // Catch:{ all -> 0x10c8 }
            r7 = 0
            java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch:{ all -> 0x10c8 }
            java.lang.reflect.Method r3 = r5.getDeclaredMethod(r3, r8)     // Catch:{ all -> 0x10c8 }
            java.lang.Object[] r5 = new java.lang.Object[r7]     // Catch:{ all -> 0x10c8 }
            r3.invoke(r2, r5)     // Catch:{ all -> 0x10c8 }
        L_0x1518:
            r3 = r6
        L_0x1519:
            if (r3 == 0) goto L_0x1665
            r7 = r3
            java.lang.Class r7 = (java.lang.Class) r7     // Catch:{ all -> 0x10c8 }
            byte[] r3 = onConversionDataSuccess     // Catch:{ all -> 0x10c8 }
            r5 = 546(0x222, float:7.65E-43)
            byte r5 = r3[r5]     // Catch:{ all -> 0x10c8 }
            byte r5 = (byte) r5     // Catch:{ all -> 0x10c8 }
            r6 = r5 ^ 896(0x380, float:1.256E-42)
            r8 = r5 & 896(0x380, float:1.256E-42)
            r6 = r6 | r8
            short r6 = (short) r6     // Catch:{ all -> 0x10c8 }
            r8 = 135(0x87, float:1.89E-43)
            byte r9 = r3[r8]     // Catch:{ all -> 0x10c8 }
            byte r8 = (byte) r9     // Catch:{ all -> 0x10c8 }
            java.lang.String r9 = $$c(r5, r6, r8)     // Catch:{ all -> 0x10c8 }
            r5 = 2
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ all -> 0x10c8 }
            java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
            r8 = 0
            r6[r8] = r5     // Catch:{ all -> 0x10c8 }
            java.lang.Class r5 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x10c8 }
            r8 = 1
            r6[r8] = r5     // Catch:{ all -> 0x10c8 }
            java.lang.reflect.Constructor r5 = r7.getDeclaredConstructor(r6)     // Catch:{ all -> 0x10c8 }
            r5.setAccessible(r8)     // Catch:{ all -> 0x10c8 }
            r6 = 2
            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ all -> 0x10c8 }
            r6 = 0
            r8[r6] = r2     // Catch:{ all -> 0x10c8 }
            if (r21 != 0) goto L_0x1553
            r2 = 45
            goto L_0x1555
        L_0x1553:
            r2 = 27
        L_0x1555:
            r6 = 45
            if (r2 == r6) goto L_0x155b
            r2 = 0
            goto L_0x1569
        L_0x155b:
            int r2 = onAppOpenAttribution
            r6 = r2 & 81
            r2 = r2 | 81
            int r6 = r6 + r2
            int r2 = r6 % 128
            onResponseErrorNative = r2
            r2 = 2
            int r6 = r6 % r2
            r2 = 1
        L_0x1569:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x10c8 }
            r6 = 1
            r8[r6] = r2     // Catch:{ all -> 0x10c8 }
            java.lang.Object r2 = r5.newInstance(r8)     // Catch:{ all -> 0x10c8 }
            onInstallConversionFailureNative = r2     // Catch:{ all -> 0x10c8 }
            r5 = 13424(0x3470, float:1.8811E-41)
            r2 = 13464(0x3498, float:1.8867E-41)
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x10c8 }
            java.lang.Class<com.appsflyer.internal.AFa1vSDK> r6 = com.appsflyer.internal.AFa1vSDK.class
            r8 = 1
            byte r10 = r3[r8]     // Catch:{ all -> 0x10c8 }
            byte r8 = (byte) r10     // Catch:{ all -> 0x10c8 }
            r10 = r8 | 452(0x1c4, float:6.33E-43)
            short r10 = (short) r10     // Catch:{ all -> 0x10c8 }
            r12 = 10
            byte r12 = r3[r12]     // Catch:{ all -> 0x10c8 }
            byte r12 = (byte) r12     // Catch:{ all -> 0x10c8 }
            java.lang.String r8 = $$c(r8, r10, r12)     // Catch:{ all -> 0x10c8 }
            java.io.InputStream r6 = r6.getResourceAsStream(r8)     // Catch:{ all -> 0x10c8 }
            r8 = 1
            java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ all -> 0x1659 }
            r8 = 0
            r10[r8] = r6     // Catch:{ all -> 0x1659 }
            r6 = 26
            byte r8 = r3[r6]     // Catch:{ all -> 0x1659 }
            byte r6 = (byte) r8     // Catch:{ all -> 0x1659 }
            r8 = 452(0x1c4, float:6.33E-43)
            short r8 = (short) r8     // Catch:{ all -> 0x1659 }
            r12 = 98
            byte r13 = r3[r12]     // Catch:{ all -> 0x1659 }
            byte r12 = (byte) r13     // Catch:{ all -> 0x1659 }
            java.lang.String r6 = $$c(r6, r8, r12)     // Catch:{ all -> 0x1659 }
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x1659 }
            r12 = 1
            java.lang.Class[] r13 = new java.lang.Class[r12]     // Catch:{ all -> 0x1659 }
            r12 = 8
            byte r15 = r3[r12]     // Catch:{ all -> 0x1659 }
            byte r12 = (byte) r15     // Catch:{ all -> 0x1659 }
            byte r15 = r3[r24]     // Catch:{ all -> 0x1659 }
            short r15 = (short) r15     // Catch:{ all -> 0x1659 }
            r20 = 98
            byte r4 = r3[r20]     // Catch:{ all -> 0x1659 }
            byte r4 = (byte) r4     // Catch:{ all -> 0x1659 }
            java.lang.String r4 = $$c(r12, r15, r4)     // Catch:{ all -> 0x1659 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x1659 }
            r12 = 0
            r13[r12] = r4     // Catch:{ all -> 0x1659 }
            java.lang.reflect.Constructor r4 = r6.getDeclaredConstructor(r13)     // Catch:{ all -> 0x1659 }
            java.lang.Object r4 = r4.newInstance(r10)     // Catch:{ all -> 0x1659 }
            r6 = 1
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ all -> 0x164d }
            r10[r12] = r2     // Catch:{ all -> 0x164d }
            r6 = 26
            byte r12 = r3[r6]     // Catch:{ all -> 0x164d }
            byte r6 = (byte) r12     // Catch:{ all -> 0x164d }
            r12 = 98
            byte r13 = r3[r12]     // Catch:{ all -> 0x164d }
            byte r12 = (byte) r13     // Catch:{ all -> 0x164d }
            java.lang.String r6 = $$c(r6, r8, r12)     // Catch:{ all -> 0x164d }
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x164d }
            r12 = 18
            byte r12 = r3[r12]     // Catch:{ all -> 0x164d }
            byte r12 = (byte) r12     // Catch:{ all -> 0x164d }
            r13 = r12 | 721(0x2d1, float:1.01E-42)
            short r13 = (short) r13     // Catch:{ all -> 0x164d }
            r15 = 392(0x188, float:5.5E-43)
            byte r15 = r3[r15]     // Catch:{ all -> 0x164d }
            byte r15 = (byte) r15     // Catch:{ all -> 0x164d }
            java.lang.String r12 = $$c(r12, r13, r15)     // Catch:{ all -> 0x164d }
            r13 = 1
            java.lang.Class[] r15 = new java.lang.Class[r13]     // Catch:{ all -> 0x164d }
            r13 = 0
            r15[r13] = r1     // Catch:{ all -> 0x164d }
            java.lang.reflect.Method r6 = r6.getMethod(r12, r15)     // Catch:{ all -> 0x164d }
            r6.invoke(r4, r10)     // Catch:{ all -> 0x164d }
            r6 = 26
            byte r10 = r3[r6]     // Catch:{ all -> 0x1641 }
            byte r6 = (byte) r10     // Catch:{ all -> 0x1641 }
            r10 = 98
            byte r12 = r3[r10]     // Catch:{ all -> 0x1641 }
            byte r10 = (byte) r12     // Catch:{ all -> 0x1641 }
            java.lang.String r6 = $$c(r6, r8, r10)     // Catch:{ all -> 0x1641 }
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x1641 }
            byte r8 = r3[r25]     // Catch:{ all -> 0x1641 }
            byte r8 = (byte) r8
            r10 = r8 ^ 306(0x132, float:4.29E-43)
            r12 = r8 & 306(0x132, float:4.29E-43)
            r10 = r10 | r12
            short r10 = (short) r10
            r12 = 135(0x87, float:1.89E-43)
            byte r3 = r3[r12]     // Catch:{ all -> 0x163f }
            byte r3 = (byte) r3     // Catch:{ all -> 0x163f }
            java.lang.String r3 = $$c(r8, r10, r3)     // Catch:{ all -> 0x163f }
            r8 = 0
            java.lang.reflect.Method r3 = r6.getMethod(r3, r8)     // Catch:{ all -> 0x163f }
            r3.invoke(r4, r8)     // Catch:{ all -> 0x163f }
            int r3 = java.lang.Math.abs(r38)     // Catch:{ all -> 0x10c8 }
            r6 = r19
            r8 = r35
            r14 = r42
            r11 = r43
            goto L_0x0988
        L_0x163f:
            r0 = move-exception
            goto L_0x1644
        L_0x1641:
            r0 = move-exception
            r12 = 135(0x87, float:1.89E-43)
        L_0x1644:
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x10c8 }
            if (r3 == 0) goto L_0x164c
            throw r3     // Catch:{ all -> 0x10c8 }
        L_0x164c:
            throw r2     // Catch:{ all -> 0x10c8 }
        L_0x164d:
            r0 = move-exception
            r12 = 135(0x87, float:1.89E-43)
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x10c8 }
            if (r3 == 0) goto L_0x1658
            throw r3     // Catch:{ all -> 0x10c8 }
        L_0x1658:
            throw r2     // Catch:{ all -> 0x10c8 }
        L_0x1659:
            r0 = move-exception
            r12 = 135(0x87, float:1.89E-43)
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x10c8 }
            if (r3 == 0) goto L_0x1664
            throw r3     // Catch:{ all -> 0x10c8 }
        L_0x1664:
            throw r2     // Catch:{ all -> 0x10c8 }
        L_0x1665:
            r12 = 135(0x87, float:1.89E-43)
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x10c8 }
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            r5 = 0
            r4[r5] = r3     // Catch:{ all -> 0x10c8 }
            java.lang.Class r3 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x10c8 }
            r5 = 1
            r4[r5] = r3     // Catch:{ all -> 0x10c8 }
            r15 = r37
            java.lang.reflect.Constructor r3 = r15.getDeclaredConstructor(r4)     // Catch:{ all -> 0x10c8 }
            r3.setAccessible(r5)     // Catch:{ all -> 0x10c8 }
            r4 = 2
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x10c8 }
            r4 = 0
            r6[r4] = r2     // Catch:{ all -> 0x10c8 }
            if (r21 != 0) goto L_0x1687
            r2 = 0
            goto L_0x1688
        L_0x1687:
            r2 = r5
        L_0x1688:
            if (r2 == r5) goto L_0x168c
            r2 = r5
            goto L_0x168d
        L_0x168c:
            r2 = 0
        L_0x168d:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x10c8 }
            r6[r5] = r2     // Catch:{ all -> 0x10c8 }
            java.lang.Object r2 = r3.newInstance(r6)     // Catch:{ all -> 0x10c8 }
            onInstallConversionFailureNative = r2     // Catch:{ all -> 0x10c8 }
            r2 = 8
            r3 = 0
            r4 = 9
            r5 = 26
            r6 = 98
            r7 = 2
            r8 = 0
            r12 = 3
            r29 = 1
            goto L_0x1952
        L_0x16a9:
            r0 = move-exception
            r12 = 135(0x87, float:1.89E-43)
            goto L_0x16b2
        L_0x16ad:
            r0 = move-exception
            r12 = 135(0x87, float:1.89E-43)
            r14 = 17
        L_0x16b2:
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x10c8 }
            if (r3 == 0) goto L_0x16ba
            throw r3     // Catch:{ all -> 0x10c8 }
        L_0x16ba:
            throw r2     // Catch:{ all -> 0x10c8 }
        L_0x16bb:
            r0 = move-exception
            goto L_0x16c0
        L_0x16bd:
            r0 = move-exception
            r11 = 43
        L_0x16c0:
            r12 = 135(0x87, float:1.89E-43)
            r14 = 17
            r3 = r0
        L_0x16c5:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x10c8 }
            r4.<init>()     // Catch:{ all -> 0x10c8 }
            byte[] r5 = onConversionDataSuccess     // Catch:{ all -> 0x10c8 }
            byte r6 = r5[r25]     // Catch:{ all -> 0x10c8 }
            byte r6 = (byte) r6     // Catch:{ all -> 0x10c8 }
            r7 = r6 | 568(0x238, float:7.96E-43)
            short r7 = (short) r7     // Catch:{ all -> 0x10c8 }
            r8 = 892(0x37c, float:1.25E-42)
            byte r9 = r5[r8]     // Catch:{ all -> 0x10c8 }
            byte r8 = (byte) r9     // Catch:{ all -> 0x10c8 }
            java.lang.String r6 = $$c(r6, r7, r8)     // Catch:{ all -> 0x10c8 }
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch:{ all -> 0x10c8 }
            java.lang.StringBuilder r2 = r4.append(r2)     // Catch:{ all -> 0x10c8 }
            byte r4 = r5[r24]     // Catch:{ all -> 0x10c8 }
            byte r6 = (byte) r4     // Catch:{ all -> 0x10c8 }
            r7 = r6 ^ 694(0x2b6, float:9.73E-43)
            r8 = r6 & 694(0x2b6, float:9.73E-43)
            r7 = r7 | r8
            short r7 = (short) r7     // Catch:{ all -> 0x10c8 }
            byte r4 = (byte) r4     // Catch:{ all -> 0x10c8 }
            java.lang.String r4 = $$c(r6, r7, r4)     // Catch:{ all -> 0x10c8 }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ all -> 0x10c8 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x10c8 }
            r4 = 2
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x1735 }
            r4 = 1
            r6[r4] = r3     // Catch:{ all -> 0x1735 }
            r3 = 0
            r6[r3] = r2     // Catch:{ all -> 0x1735 }
            r2 = 8
            byte r3 = r5[r2]     // Catch:{ all -> 0x1735 }
            byte r2 = (byte) r3     // Catch:{ all -> 0x1735 }
            int r3 = onResponseNative     // Catch:{ all -> 0x1735 }
            r4 = r3 ^ 53
            r7 = 53
            r3 = r3 & r7
            r3 = r3 | r4
            short r3 = (short) r3     // Catch:{ all -> 0x1735 }
            r4 = 98
            byte r5 = r5[r4]     // Catch:{ all -> 0x1735 }
            byte r4 = (byte) r5     // Catch:{ all -> 0x1735 }
            java.lang.String r2 = $$c(r2, r3, r4)     // Catch:{ all -> 0x1735 }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x1735 }
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x1735 }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r5 = 0
            r4[r5] = r3     // Catch:{ all -> 0x1735 }
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            r5 = 1
            r4[r5] = r3     // Catch:{ all -> 0x1735 }
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r4)     // Catch:{ all -> 0x1735 }
            java.lang.Object r2 = r2.newInstance(r6)     // Catch:{ all -> 0x1735 }
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x1735 }
            throw r2     // Catch:{ all -> 0x1735 }
        L_0x1735:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x10c8 }
            if (r3 == 0) goto L_0x173e
            throw r3     // Catch:{ all -> 0x10c8 }
        L_0x173e:
            throw r2     // Catch:{ all -> 0x10c8 }
        L_0x173f:
            r0 = move-exception
            r11 = 43
            r12 = 135(0x87, float:1.89E-43)
            r14 = 17
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x10c8 }
            if (r3 == 0) goto L_0x174e
            throw r3     // Catch:{ all -> 0x10c8 }
        L_0x174e:
            throw r2     // Catch:{ all -> 0x10c8 }
        L_0x174f:
            r0 = move-exception
            r14 = r10
            r11 = 43
            r12 = 135(0x87, float:1.89E-43)
            goto L_0x175d
        L_0x1756:
            r0 = move-exception
            r11 = 43
            r12 = 135(0x87, float:1.89E-43)
            r14 = 17
        L_0x175d:
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x10c8 }
            if (r3 == 0) goto L_0x1765
            throw r3     // Catch:{ all -> 0x10c8 }
        L_0x1765:
            throw r2     // Catch:{ all -> 0x10c8 }
        L_0x1766:
            r0 = move-exception
            r11 = 43
            r12 = 135(0x87, float:1.89E-43)
            r14 = 17
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x10c8 }
            if (r3 == 0) goto L_0x1775
            throw r3     // Catch:{ all -> 0x10c8 }
        L_0x1775:
            throw r2     // Catch:{ all -> 0x10c8 }
        L_0x1776:
            r15 = r37
            r12 = 135(0x87, float:1.89E-43)
            r14 = 17
            r4 = 3
            java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ all -> 0x17e5 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x17e2 }
            r18 = 2
            r11[r18] = r4     // Catch:{ all -> 0x17e2 }
            r4 = 0
            java.lang.Integer r18 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x17e2 }
            r20 = 1
            r11[r20] = r18     // Catch:{ all -> 0x17e2 }
            r11[r4] = r6     // Catch:{ all -> 0x17e2 }
            r4 = 892(0x37c, float:1.25E-42)
            byte r12 = r8[r4]     // Catch:{ all -> 0x17e2 }
            byte r4 = (byte) r12     // Catch:{ all -> 0x17e2 }
            r12 = r13 ^ 288(0x120, float:4.04E-43)
            r13 = r13 & 288(0x120, float:4.04E-43)
            r12 = r12 | r13
            short r12 = (short) r12     // Catch:{ all -> 0x17e2 }
            r13 = 98
            byte r14 = r8[r13]     // Catch:{ all -> 0x17e2 }
            byte r13 = (byte) r14     // Catch:{ all -> 0x17e2 }
            java.lang.String r4 = $$c(r4, r12, r13)     // Catch:{ all -> 0x17e2 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x17e2 }
            byte r12 = r8[r25]     // Catch:{ all -> 0x17e2 }
            byte r12 = (byte) r12     // Catch:{ all -> 0x17e2 }
            r13 = r12 | 707(0x2c3, float:9.91E-43)
            short r13 = (short) r13     // Catch:{ all -> 0x17e2 }
            r14 = 405(0x195, float:5.68E-43)
            byte r8 = r8[r14]     // Catch:{ all -> 0x17e2 }
            r14 = 1
            int r8 = r8 - r14
            byte r8 = (byte) r8     // Catch:{ all -> 0x17e2 }
            java.lang.String r8 = $$c(r12, r13, r8)     // Catch:{ all -> 0x17e2 }
            r12 = 3
            java.lang.Class[] r13 = new java.lang.Class[r12]     // Catch:{ all -> 0x17e0 }
            r17 = 0
            r13[r17] = r1     // Catch:{ all -> 0x17e0 }
            java.lang.Class r17 = java.lang.Integer.TYPE     // Catch:{ all -> 0x17e0 }
            r13[r14] = r17     // Catch:{ all -> 0x17e0 }
            java.lang.Class r14 = java.lang.Integer.TYPE     // Catch:{ all -> 0x17e0 }
            r17 = 2
            r13[r17] = r14     // Catch:{ all -> 0x17e0 }
            java.lang.reflect.Method r4 = r4.getMethod(r8, r13)     // Catch:{ all -> 0x17e0 }
            r4.invoke(r2, r11)     // Catch:{ all -> 0x17e0 }
            int r4 = -r10
            int r4 = -r4
            r8 = r7 & r4
            r4 = r4 | r7
            int r7 = r8 + r4
            r37 = r15
            r4 = 108(0x6c, float:1.51E-43)
            goto L_0x1165
        L_0x17e0:
            r0 = move-exception
            goto L_0x17e7
        L_0x17e2:
            r0 = move-exception
            r12 = 3
            goto L_0x17e7
        L_0x17e5:
            r0 = move-exception
            r12 = r4
        L_0x17e7:
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x1865 }
            if (r3 == 0) goto L_0x17ef
            throw r3     // Catch:{ all -> 0x1865 }
        L_0x17ef:
            throw r2     // Catch:{ all -> 0x1865 }
        L_0x17f0:
            r0 = move-exception
            r12 = 3
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x1865 }
            if (r3 == 0) goto L_0x17fa
            throw r3     // Catch:{ all -> 0x1865 }
        L_0x17fa:
            throw r2     // Catch:{ all -> 0x1865 }
        L_0x17fb:
            r0 = move-exception
            r12 = 3
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x1865 }
            if (r3 == 0) goto L_0x1805
            throw r3     // Catch:{ all -> 0x1865 }
        L_0x1805:
            throw r2     // Catch:{ all -> 0x1865 }
        L_0x1806:
            r0 = move-exception
            r12 = 3
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x1865 }
            if (r3 == 0) goto L_0x1810
            throw r3     // Catch:{ all -> 0x1865 }
        L_0x1810:
            throw r2     // Catch:{ all -> 0x1865 }
        L_0x1811:
            r0 = move-exception
            goto L_0x18a7
        L_0x1814:
            r0 = move-exception
            r19 = r6
            r35 = r8
            r12 = 3
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x1865 }
            if (r3 == 0) goto L_0x1822
            throw r3     // Catch:{ all -> 0x1865 }
        L_0x1822:
            throw r2     // Catch:{ all -> 0x1865 }
        L_0x1823:
            r0 = move-exception
            r19 = r6
            r35 = r8
            r12 = r14
            goto L_0x1837
        L_0x182a:
            r0 = move-exception
            r19 = r6
            r35 = r8
            r12 = r13
            goto L_0x1837
        L_0x1831:
            r0 = move-exception
            r19 = r6
            r35 = r8
            r12 = 3
        L_0x1837:
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x1865 }
            if (r3 == 0) goto L_0x183f
            throw r3     // Catch:{ all -> 0x1865 }
        L_0x183f:
            throw r2     // Catch:{ all -> 0x1865 }
        L_0x1840:
            r0 = move-exception
            r19 = r6
            r35 = r8
            r12 = 3
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x1865 }
            if (r3 == 0) goto L_0x184e
            throw r3     // Catch:{ all -> 0x1865 }
        L_0x184e:
            throw r2     // Catch:{ all -> 0x1865 }
        L_0x184f:
            r0 = move-exception
            r19 = r6
            r35 = r8
            r12 = 3
            goto L_0x185c
        L_0x1856:
            r0 = move-exception
            r19 = r6
            r35 = r8
            r12 = r10
        L_0x185c:
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x1865 }
            if (r3 == 0) goto L_0x1864
            throw r3     // Catch:{ all -> 0x1865 }
        L_0x1864:
            throw r2     // Catch:{ all -> 0x1865 }
        L_0x1865:
            r0 = move-exception
            goto L_0x18a8
        L_0x1867:
            r0 = move-exception
            r19 = r6
            r35 = r8
            r12 = 3
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x1865 }
            if (r3 == 0) goto L_0x1875
            throw r3     // Catch:{ all -> 0x1865 }
        L_0x1875:
            throw r2     // Catch:{ all -> 0x1865 }
        L_0x1876:
            r0 = move-exception
            r19 = r6
            r35 = r8
            r12 = 3
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x1865 }
            if (r3 == 0) goto L_0x1884
            throw r3     // Catch:{ all -> 0x1865 }
        L_0x1884:
            throw r2     // Catch:{ all -> 0x1865 }
        L_0x1885:
            r0 = move-exception
            r19 = r6
            r35 = r8
            r12 = 3
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x1865 }
            if (r3 == 0) goto L_0x1893
            throw r3     // Catch:{ all -> 0x1865 }
        L_0x1893:
            throw r2     // Catch:{ all -> 0x1865 }
        L_0x1894:
            r0 = move-exception
            r19 = r6
            goto L_0x18a5
        L_0x1898:
            r0 = move-exception
            r28 = r2
            r30 = r3
            r29 = r4
            r31 = r5
            r19 = r6
            r32 = r7
        L_0x18a5:
            r35 = r8
        L_0x18a7:
            r12 = 3
        L_0x18a8:
            r2 = r0
        L_0x18a9:
            r3 = r35 ^ 1
            r4 = r35 & 1
            r5 = 1
            int r4 = r4 << r5
            int r3 = r3 + r4
        L_0x18b0:
            r4 = 9
            if (r3 >= r4) goto L_0x18c6
            boolean r5 = r19[r3]     // Catch:{ Exception -> 0x199d }
            if (r5 == 0) goto L_0x18bb
            r5 = 92
            goto L_0x18bd
        L_0x18bb:
            r5 = 44
        L_0x18bd:
            r6 = 92
            if (r5 == r6) goto L_0x18c4
            int r3 = r3 + 1
            goto L_0x18b0
        L_0x18c4:
            r3 = 1
            goto L_0x18c7
        L_0x18c6:
            r3 = 0
        L_0x18c7:
            if (r3 != 0) goto L_0x18cc
            r3 = 87
            goto L_0x18ce
        L_0x18cc:
            r3 = 24
        L_0x18ce:
            r5 = 87
            if (r3 == r5) goto L_0x18e1
            r3 = 0
            onInstallConversionFailureNative = r3     // Catch:{ Exception -> 0x199d }
            onAppOpenAttributionNative = r3     // Catch:{ Exception -> 0x199d }
            r2 = 8
            r5 = 26
            r6 = 98
            r7 = 2
            r8 = 0
            goto L_0x1952
        L_0x18e1:
            byte[] r1 = onConversionDataSuccess     // Catch:{ Exception -> 0x199d }
            r5 = 26
            byte r3 = r1[r5]     // Catch:{ Exception -> 0x199d }
            byte r3 = (byte) r3     // Catch:{ Exception -> 0x199d }
            r4 = 602(0x25a, float:8.44E-43)
            short r4 = (short) r4     // Catch:{ Exception -> 0x199d }
            r5 = 892(0x37c, float:1.25E-42)
            byte r5 = r1[r5]     // Catch:{ Exception -> 0x199d }
            byte r5 = (byte) r5     // Catch:{ Exception -> 0x199d }
            java.lang.String r3 = $$c(r3, r4, r5)     // Catch:{ Exception -> 0x199d }
            r4 = 2
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x1930 }
            r4 = 1
            r5[r4] = r2     // Catch:{ all -> 0x1930 }
            r2 = 0
            r5[r2] = r3     // Catch:{ all -> 0x1930 }
            r2 = 8
            byte r2 = r1[r2]     // Catch:{ all -> 0x1930 }
            byte r2 = (byte) r2     // Catch:{ all -> 0x1930 }
            int r3 = onResponseNative     // Catch:{ all -> 0x1930 }
            r4 = r3 ^ 53
            r6 = 53
            r3 = r3 & r6
            r3 = r3 | r4
            short r3 = (short) r3     // Catch:{ all -> 0x1930 }
            r6 = 98
            byte r1 = r1[r6]     // Catch:{ all -> 0x1930 }
            byte r1 = (byte) r1     // Catch:{ all -> 0x1930 }
            java.lang.String r1 = $$c(r2, r3, r1)     // Catch:{ all -> 0x1930 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x1930 }
            r7 = 2
            java.lang.Class[] r2 = new java.lang.Class[r7]     // Catch:{ all -> 0x1930 }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r8 = 0
            r2[r8] = r3     // Catch:{ all -> 0x1930 }
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            r4 = 1
            r2[r4] = r3     // Catch:{ all -> 0x1930 }
            java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r2)     // Catch:{ all -> 0x1930 }
            java.lang.Object r1 = r1.newInstance(r5)     // Catch:{ all -> 0x1930 }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x1930 }
            throw r1     // Catch:{ all -> 0x1930 }
        L_0x1930:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x199d }
            if (r2 == 0) goto L_0x1939
            throw r2     // Catch:{ Exception -> 0x199d }
        L_0x1939:
            throw r1     // Catch:{ Exception -> 0x199d }
        L_0x193a:
            r28 = r2
            r30 = r3
            r29 = r4
            r31 = r5
            r19 = r6
            r32 = r7
            r35 = r8
            r4 = r9
            r8 = r11
            r6 = r14
            r2 = 8
            r3 = 0
            r5 = 26
            r7 = 2
            r12 = 3
        L_0x1952:
            r9 = r35 | -47
            r10 = 1
            int r9 = r9 << r10
            r11 = r35 ^ -47
            int r9 = r9 - r11
            r11 = r9 ^ 48
            r9 = r9 & 48
            int r9 = r9 << r10
            int r9 = r9 + r11
            r14 = r6
            r11 = r8
            r8 = r9
            r12 = r10
            r6 = r19
            r2 = r28
            r3 = r30
            r5 = r31
            r7 = r32
            r13 = 108(0x6c, float:1.51E-43)
            r9 = r4
            r4 = r29
            goto L_0x03db
        L_0x1974:
            return
        L_0x1975:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x199d }
            if (r2 == 0) goto L_0x197e
            throw r2     // Catch:{ Exception -> 0x199d }
        L_0x197e:
            throw r1     // Catch:{ Exception -> 0x199d }
        L_0x197f:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x199d }
            if (r2 == 0) goto L_0x1988
            throw r2     // Catch:{ Exception -> 0x199d }
        L_0x1988:
            throw r1     // Catch:{ Exception -> 0x199d }
        L_0x1989:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x199d }
            if (r2 == 0) goto L_0x1992
            throw r2     // Catch:{ Exception -> 0x199d }
        L_0x1992:
            throw r1     // Catch:{ Exception -> 0x199d }
        L_0x1993:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x199d }
            if (r2 == 0) goto L_0x199c
            throw r2     // Catch:{ Exception -> 0x199d }
        L_0x199c:
            throw r1     // Catch:{ Exception -> 0x199d }
        L_0x199d:
            r0 = move-exception
            r1 = r0
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1vSDK.<clinit>():void");
    }
}
