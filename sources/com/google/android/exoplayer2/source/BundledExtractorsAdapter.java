package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public final class BundledExtractorsAdapter implements ProgressiveMediaExtractor {
    private Extractor extractor;
    private ExtractorInput extractorInput;
    private final ExtractorsFactory extractorsFactory;

    public BundledExtractorsAdapter(ExtractorsFactory extractorsFactory2) {
        this.extractorsFactory = extractorsFactory2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
        if (r0.getPosition() != r11) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006d, code lost:
        if (r0.getPosition() != r11) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0070, code lost:
        r1 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(com.google.android.exoplayer2.upstream.DataReader r8, android.net.Uri r9, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r10, long r11, long r13, com.google.android.exoplayer2.extractor.ExtractorOutput r15) throws java.io.IOException {
        /*
            r7 = this;
            com.google.android.exoplayer2.extractor.DefaultExtractorInput r6 = new com.google.android.exoplayer2.extractor.DefaultExtractorInput
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.extractorInput = r6
            com.google.android.exoplayer2.extractor.Extractor r8 = r7.extractor
            if (r8 == 0) goto L_0x0010
            return
        L_0x0010:
            com.google.android.exoplayer2.extractor.ExtractorsFactory r8 = r7.extractorsFactory
            com.google.android.exoplayer2.extractor.Extractor[] r8 = r8.createExtractors(r9, r10)
            int r10 = r8.length
            r13 = 0
            r14 = 1
            if (r10 != r14) goto L_0x0021
            r8 = r8[r13]
            r7.extractor = r8
            goto L_0x0080
        L_0x0021:
            int r10 = r8.length
            r0 = r13
        L_0x0023:
            if (r0 >= r10) goto L_0x007c
            r1 = r8[r0]
            boolean r2 = r1.sniff(r6)     // Catch:{ EOFException -> 0x0063, all -> 0x004e }
            if (r2 == 0) goto L_0x0041
            r7.extractor = r1     // Catch:{ EOFException -> 0x0063, all -> 0x004e }
            if (r1 != 0) goto L_0x0039
            long r0 = r6.getPosition()
            int r10 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r10 != 0) goto L_0x003a
        L_0x0039:
            r13 = r14
        L_0x003a:
            com.google.android.exoplayer2.util.Assertions.checkState(r13)
            r6.resetPeekPosition()
            goto L_0x007c
        L_0x0041:
            com.google.android.exoplayer2.extractor.Extractor r1 = r7.extractor
            if (r1 != 0) goto L_0x0072
            long r1 = r6.getPosition()
            int r1 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r1 != 0) goto L_0x0070
            goto L_0x0072
        L_0x004e:
            r8 = move-exception
            com.google.android.exoplayer2.extractor.Extractor r9 = r7.extractor
            if (r9 != 0) goto L_0x005b
            long r9 = r6.getPosition()
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 != 0) goto L_0x005c
        L_0x005b:
            r13 = r14
        L_0x005c:
            com.google.android.exoplayer2.util.Assertions.checkState(r13)
            r6.resetPeekPosition()
            throw r8
        L_0x0063:
            com.google.android.exoplayer2.extractor.Extractor r1 = r7.extractor
            if (r1 != 0) goto L_0x0072
            long r1 = r6.getPosition()
            int r1 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r1 != 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r1 = r13
            goto L_0x0073
        L_0x0072:
            r1 = r14
        L_0x0073:
            com.google.android.exoplayer2.util.Assertions.checkState(r1)
            r6.resetPeekPosition()
            int r0 = r0 + 1
            goto L_0x0023
        L_0x007c:
            com.google.android.exoplayer2.extractor.Extractor r10 = r7.extractor
            if (r10 == 0) goto L_0x0086
        L_0x0080:
            com.google.android.exoplayer2.extractor.Extractor r8 = r7.extractor
            r8.init(r15)
            return
        L_0x0086:
            com.google.android.exoplayer2.source.UnrecognizedInputFormatException r10 = new com.google.android.exoplayer2.source.UnrecognizedInputFormatException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "None of the available extractors ("
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r8 = com.google.android.exoplayer2.util.Util.getCommaDelimitedSimpleClassNames(r8)
            java.lang.StringBuilder r8 = r11.append(r8)
            java.lang.String r11 = ") could read the stream."
            java.lang.StringBuilder r8 = r8.append(r11)
            java.lang.String r8 = r8.toString()
            java.lang.Object r9 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r9)
            android.net.Uri r9 = (android.net.Uri) r9
            r10.<init>(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.BundledExtractorsAdapter.init(com.google.android.exoplayer2.upstream.DataReader, android.net.Uri, java.util.Map, long, long, com.google.android.exoplayer2.extractor.ExtractorOutput):void");
    }

    public void release() {
        Extractor extractor2 = this.extractor;
        if (extractor2 != null) {
            extractor2.release();
            this.extractor = null;
        }
        this.extractorInput = null;
    }

    public void disableSeekingOnMp3Streams() {
        Extractor extractor2 = this.extractor;
        if (extractor2 instanceof Mp3Extractor) {
            ((Mp3Extractor) extractor2).disableSeeking();
        }
    }

    public long getCurrentInputPosition() {
        ExtractorInput extractorInput2 = this.extractorInput;
        if (extractorInput2 != null) {
            return extractorInput2.getPosition();
        }
        return -1;
    }

    public void seek(long j, long j2) {
        ((Extractor) Assertions.checkNotNull(this.extractor)).seek(j, j2);
    }

    public int read(PositionHolder positionHolder) throws IOException {
        return ((Extractor) Assertions.checkNotNull(this.extractor)).read((ExtractorInput) Assertions.checkNotNull(this.extractorInput), positionHolder);
    }
}
