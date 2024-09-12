package okhttp3.internal.publicsuffix;

import androidx.webkit.ProxyConfig;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "()V", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "publicSuffixExceptionListBytes", "", "publicSuffixListBytes", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "findMatchingRule", "", "", "domainLabels", "getEffectiveTldPlusOne", "domain", "readTheList", "", "readTheListUninterruptibly", "setListBytes", "splitDomain", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PublicSuffixDatabase.kt */
public final class PublicSuffixDatabase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final char EXCEPTION_MARKER = '!';
    private static final List<String> PREVAILING_RULE = CollectionsKt.listOf(ProxyConfig.MATCH_ALL_SCHEMES);
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private static final byte[] WILDCARD_LABEL = {42};
    /* access modifiers changed from: private */
    public static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    public final String getEffectiveTldPlusOne(String str) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(str, DynamicLink.Builder.KEY_DOMAIN);
        String unicode = IDN.toUnicode(str);
        Intrinsics.checkNotNullExpressionValue(unicode, "unicodeDomain");
        List<String> splitDomain = splitDomain(unicode);
        List<String> findMatchingRule = findMatchingRule(splitDomain);
        if (splitDomain.size() == findMatchingRule.size() && findMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (findMatchingRule.get(0).charAt(0) == '!') {
            i2 = splitDomain.size();
            i = findMatchingRule.size();
        } else {
            i2 = splitDomain.size();
            i = findMatchingRule.size() + 1;
        }
        return SequencesKt.joinToString$default(SequencesKt.drop(CollectionsKt.asSequence(splitDomain(str)), i2 - i), ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    private final List<String> splitDomain(String str) {
        List<String> split$default = StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null);
        return Intrinsics.areEqual(CollectionsKt.last(split$default), (Object) "") ? CollectionsKt.dropLast(split$default, 1) : split$default;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.String> findMatchingRule(java.util.List<java.lang.String> r18) {
        /*
            r17 = this;
            r0 = r17
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.listRead
            boolean r1 = r1.get()
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0018
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.listRead
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x0018
            r17.readTheListUninterruptibly()
            goto L_0x0025
        L_0x0018:
            java.util.concurrent.CountDownLatch r1 = r0.readCompleteLatch     // Catch:{ InterruptedException -> 0x001e }
            r1.await()     // Catch:{ InterruptedException -> 0x001e }
            goto L_0x0025
        L_0x001e:
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
        L_0x0025:
            byte[] r1 = r0.publicSuffixListBytes
            if (r1 == 0) goto L_0x002b
            r1 = r3
            goto L_0x002c
        L_0x002b:
            r1 = r2
        L_0x002c:
            if (r1 == 0) goto L_0x011f
            int r1 = r18.size()
            byte[][] r4 = new byte[r1][]
            r5 = r2
        L_0x0035:
            if (r5 >= r1) goto L_0x0054
            r6 = r18
            java.lang.Object r7 = r6.get(r5)
            java.lang.String r7 = (java.lang.String) r7
            java.nio.charset.Charset r8 = java.nio.charset.StandardCharsets.UTF_8
            java.lang.String r9 = "UTF_8"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            byte[] r7 = r7.getBytes(r8)
            java.lang.String r8 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            r4[r5] = r7
            int r5 = r5 + 1
            goto L_0x0035
        L_0x0054:
            r1 = r4
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            int r5 = r1.length
            r6 = r2
        L_0x0059:
            java.lang.String r7 = "publicSuffixListBytes"
            r8 = 0
            if (r6 >= r5) goto L_0x0073
            int r9 = r6 + 1
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r10 = Companion
            byte[] r11 = r0.publicSuffixListBytes
            if (r11 != 0) goto L_0x006a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r11 = r8
        L_0x006a:
            java.lang.String r6 = r10.binarySearch(r11, r4, r6)
            if (r6 == 0) goto L_0x0071
            goto L_0x0074
        L_0x0071:
            r6 = r9
            goto L_0x0059
        L_0x0073:
            r6 = r8
        L_0x0074:
            int r5 = r1.length
            if (r5 <= r3) goto L_0x009e
            java.lang.Object r5 = r1.clone()
            byte[][] r5 = (byte[][]) r5
            r9 = r5
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            int r9 = r9.length
            int r9 = r9 - r3
            r10 = r2
        L_0x0083:
            if (r10 >= r9) goto L_0x009e
            int r11 = r10 + 1
            byte[] r12 = WILDCARD_LABEL
            r5[r10] = r12
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r12 = Companion
            byte[] r13 = r0.publicSuffixListBytes
            if (r13 != 0) goto L_0x0095
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r13 = r8
        L_0x0095:
            java.lang.String r10 = r12.binarySearch(r13, r5, r10)
            if (r10 == 0) goto L_0x009c
            goto L_0x009f
        L_0x009c:
            r10 = r11
            goto L_0x0083
        L_0x009e:
            r10 = r8
        L_0x009f:
            if (r10 == 0) goto L_0x00bd
            int r1 = r1.length
            int r1 = r1 - r3
            r5 = r2
        L_0x00a4:
            if (r5 >= r1) goto L_0x00bd
            int r7 = r5 + 1
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r9 = Companion
            byte[] r11 = r0.publicSuffixExceptionListBytes
            if (r11 != 0) goto L_0x00b4
            java.lang.String r11 = "publicSuffixExceptionListBytes"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r11 = r8
        L_0x00b4:
            java.lang.String r5 = r9.binarySearch(r11, r4, r5)
            if (r5 == 0) goto L_0x00bb
            goto L_0x00be
        L_0x00bb:
            r5 = r7
            goto L_0x00a4
        L_0x00bd:
            r5 = r8
        L_0x00be:
            r1 = 46
            if (r5 == 0) goto L_0x00d8
            java.lang.String r4 = "!"
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r5)
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            char[] r6 = new char[r3]
            r6[r2] = r1
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            java.util.List r1 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r5, (char[]) r6, (boolean) r7, (int) r8, (int) r9, (java.lang.Object) r10)
            return r1
        L_0x00d8:
            if (r6 != 0) goto L_0x00df
            if (r10 != 0) goto L_0x00df
            java.util.List<java.lang.String> r1 = PREVAILING_RULE
            return r1
        L_0x00df:
            if (r6 != 0) goto L_0x00e3
            r4 = r8
            goto L_0x00f3
        L_0x00e3:
            r11 = r6
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            char[] r12 = new char[r3]
            r12[r2] = r1
            r13 = 0
            r14 = 0
            r15 = 6
            r16 = 0
            java.util.List r4 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r11, (char[]) r12, (boolean) r13, (int) r14, (int) r15, (java.lang.Object) r16)
        L_0x00f3:
            if (r4 != 0) goto L_0x00f9
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00f9:
            if (r10 != 0) goto L_0x00fc
            goto L_0x010c
        L_0x00fc:
            r11 = r10
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            char[] r12 = new char[r3]
            r12[r2] = r1
            r13 = 0
            r14 = 0
            r15 = 6
            r16 = 0
            java.util.List r8 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r11, (char[]) r12, (boolean) r13, (int) r14, (int) r15, (java.lang.Object) r16)
        L_0x010c:
            if (r8 != 0) goto L_0x0112
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0112:
            int r1 = r4.size()
            int r2 = r8.size()
            if (r1 <= r2) goto L_0x011d
            goto L_0x011e
        L_0x011d:
            r4 = r8
        L_0x011e:
            return r4
        L_0x011f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Unable to load publicsuffixes.gz resource from the classpath."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.findMatchingRule(java.util.List):java.util.List");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0029 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readTheListUninterruptibly() {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            r5.readTheList()     // Catch:{ InterruptedIOException -> 0x0029, IOException -> 0x0010 }
            if (r0 == 0) goto L_0x000d
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x000d:
            return
        L_0x000e:
            r1 = move-exception
            goto L_0x002e
        L_0x0010:
            r1 = move-exception
            okhttp3.internal.platform.Platform$Companion r2 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x000e }
            okhttp3.internal.platform.Platform r2 = r2.get()     // Catch:{ all -> 0x000e }
            java.lang.String r3 = "Failed to read public suffix list"
            r4 = 5
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x000e }
            r2.log(r3, r4, r1)     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x0028
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0028:
            return
        L_0x0029:
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x000e }
            r0 = 1
            goto L_0x0001
        L_0x002e:
            if (r0 == 0) goto L_0x0037
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0037:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.readTheListUninterruptibly():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readTheList() throws java.io.IOException {
        /*
            r6 = this;
            java.lang.Class<okhttp3.internal.publicsuffix.PublicSuffixDatabase> r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.class
            java.lang.String r1 = "publicsuffixes.gz"
            java.io.InputStream r0 = r0.getResourceAsStream(r1)
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            okio.GzipSource r1 = new okio.GzipSource
            okio.Source r0 = okio.Okio.source((java.io.InputStream) r0)
            r1.<init>(r0)
            okio.Source r1 = (okio.Source) r1
            okio.BufferedSource r0 = okio.Okio.buffer((okio.Source) r1)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            r2 = r0
            okio.BufferedSource r2 = (okio.BufferedSource) r2     // Catch:{ all -> 0x004e }
            int r3 = r2.readInt()     // Catch:{ all -> 0x004e }
            long r3 = (long) r3     // Catch:{ all -> 0x004e }
            byte[] r3 = r2.readByteArray(r3)     // Catch:{ all -> 0x004e }
            int r4 = r2.readInt()     // Catch:{ all -> 0x004e }
            long r4 = (long) r4     // Catch:{ all -> 0x004e }
            byte[] r2 = r2.readByteArray(r4)     // Catch:{ all -> 0x004e }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004e }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            monitor-enter(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ all -> 0x004b }
            r6.publicSuffixListBytes = r3     // Catch:{ all -> 0x004b }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ all -> 0x004b }
            r6.publicSuffixExceptionListBytes = r2     // Catch:{ all -> 0x004b }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004b }
            monitor-exit(r6)
            java.util.concurrent.CountDownLatch r0 = r6.readCompleteLatch
            r0.countDown()
            return
        L_0x004b:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        L_0x004e:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.readTheList():void");
    }

    public final void setListBytes(byte[] bArr, byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "publicSuffixListBytes");
        Intrinsics.checkNotNullParameter(bArr2, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\fJ)\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", "", "()V", "EXCEPTION_MARKER", "", "PREVAILING_RULE", "", "", "PUBLIC_SUFFIX_RESOURCE", "WILDCARD_LABEL", "", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "get", "binarySearch", "labels", "", "labelIndex", "", "([B[[BI)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PublicSuffixDatabase.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }

        /* access modifiers changed from: private */
        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            boolean z;
            int i3;
            int and;
            byte[] bArr3 = bArr;
            int length = bArr3.length;
            int i4 = 0;
            while (i4 < length) {
                int i5 = (i4 + length) / 2;
                while (i5 > -1 && bArr3[i5] != 10) {
                    i5--;
                }
                int i6 = i5 + 1;
                int i7 = 1;
                while (true) {
                    i2 = i6 + i7;
                    if (bArr3[i2] == 10) {
                        break;
                    }
                    i7++;
                }
                int i8 = i2 - i6;
                int i9 = i;
                boolean z2 = false;
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    if (z2) {
                        i3 = 46;
                        z = false;
                    } else {
                        z = z2;
                        i3 = Util.and(bArr2[i9][i10], 255);
                    }
                    and = i3 - Util.and(bArr3[i6 + i11], 255);
                    if (and == 0) {
                        i11++;
                        i10++;
                        if (i11 == i8) {
                            break;
                        } else if (bArr2[i9].length != i10) {
                            z2 = z;
                        } else if (i9 == ((Object[]) bArr2).length - 1) {
                            break;
                        } else {
                            i9++;
                            i10 = -1;
                            z2 = true;
                        }
                    } else {
                        break;
                    }
                }
                if (and >= 0) {
                    if (and <= 0) {
                        int i12 = i8 - i11;
                        int length2 = bArr2[i9].length - i10;
                        int length3 = ((Object[]) bArr2).length;
                        for (int i13 = i9 + 1; i13 < length3; i13++) {
                            length2 += bArr2[i13].length;
                        }
                        if (length2 >= i12) {
                            if (length2 <= i12) {
                                Charset charset = StandardCharsets.UTF_8;
                                Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
                                return new String(bArr3, i6, i8, charset);
                            }
                        }
                    }
                    i4 = i2 + 1;
                }
                length = i6 - 1;
            }
            return null;
        }
    }
}
