package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorUtil;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;

final class DefaultOggSeeker implements OggSeeker {
    private static final int DEFAULT_OFFSET = 30000;
    private static final int MATCH_BYTE_RANGE = 100000;
    private static final int MATCH_RANGE = 72000;
    private static final int STATE_IDLE = 4;
    private static final int STATE_READ_LAST_PAGE = 1;
    private static final int STATE_SEEK = 2;
    private static final int STATE_SEEK_TO_END = 0;
    private static final int STATE_SKIP = 3;
    private long end;
    private long endGranule;
    private final OggPageHeader pageHeader;
    /* access modifiers changed from: private */
    public final long payloadEndPosition;
    /* access modifiers changed from: private */
    public final long payloadStartPosition;
    private long positionBeforeSeekToEnd;
    private long start;
    private long startGranule;
    private int state;
    /* access modifiers changed from: private */
    public final StreamReader streamReader;
    private long targetGranule;
    /* access modifiers changed from: private */
    public long totalGranules;

    public DefaultOggSeeker(StreamReader streamReader2, long j, long j2, long j3, long j4, boolean z) {
        Assertions.checkArgument(j >= 0 && j2 > j);
        this.streamReader = streamReader2;
        this.payloadStartPosition = j;
        this.payloadEndPosition = j2;
        if (j3 == j2 - j || z) {
            this.totalGranules = j4;
            this.state = 4;
        } else {
            this.state = 0;
        }
        this.pageHeader = new OggPageHeader();
    }

    public long read(ExtractorInput extractorInput) throws IOException {
        int i = this.state;
        if (i == 0) {
            long position = extractorInput.getPosition();
            this.positionBeforeSeekToEnd = position;
            this.state = 1;
            long j = this.payloadEndPosition - 65307;
            if (j > position) {
                return j;
            }
        } else if (i != 1) {
            if (i == 2) {
                long nextSeekPosition = getNextSeekPosition(extractorInput);
                if (nextSeekPosition != -1) {
                    return nextSeekPosition;
                }
                this.state = 3;
            } else if (i != 3) {
                if (i == 4) {
                    return -1;
                }
                throw new IllegalStateException();
            }
            skipToPageOfTargetGranule(extractorInput);
            this.state = 4;
            return -(this.startGranule + 2);
        }
        this.totalGranules = readGranuleOfLastPage(extractorInput);
        this.state = 4;
        return this.positionBeforeSeekToEnd;
    }

    public OggSeekMap createSeekMap() {
        if (this.totalGranules != 0) {
            return new OggSeekMap();
        }
        return null;
    }

    public void startSeek(long j) {
        this.targetGranule = Util.constrainValue(j, 0, this.totalGranules - 1);
        this.state = 2;
        this.start = this.payloadStartPosition;
        this.end = this.payloadEndPosition;
        this.startGranule = 0;
        this.endGranule = this.totalGranules;
    }

    private long getNextSeekPosition(ExtractorInput extractorInput) throws IOException {
        ExtractorInput extractorInput2 = extractorInput;
        if (this.start == this.end) {
            return -1;
        }
        long position = extractorInput.getPosition();
        if (!this.pageHeader.skipToNextPage(extractorInput2, this.end)) {
            long j = this.start;
            if (j != position) {
                return j;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.pageHeader.populate(extractorInput2, false);
        extractorInput.resetPeekPosition();
        long j2 = this.targetGranule - this.pageHeader.granulePosition;
        int i = this.pageHeader.headerSize + this.pageHeader.bodySize;
        if (0 <= j2 && j2 < 72000) {
            return -1;
        }
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 < 0) {
            this.end = position;
            this.endGranule = this.pageHeader.granulePosition;
        } else {
            this.start = extractorInput.getPosition() + ((long) i);
            this.startGranule = this.pageHeader.granulePosition;
        }
        long j3 = this.end;
        long j4 = this.start;
        if (j3 - j4 < 100000) {
            this.end = j4;
            return j4;
        }
        long j5 = (long) i;
        long j6 = i2 <= 0 ? 2 : 1;
        long position2 = extractorInput.getPosition();
        long j7 = this.end;
        long j8 = this.start;
        return Util.constrainValue((position2 - (j5 * j6)) + ((j2 * (j7 - j8)) / (this.endGranule - this.startGranule)), j8, j7 - 1);
    }

    private void skipToPageOfTargetGranule(ExtractorInput extractorInput) throws IOException {
        while (true) {
            this.pageHeader.skipToNextPage(extractorInput);
            this.pageHeader.populate(extractorInput, false);
            if (this.pageHeader.granulePosition > this.targetGranule) {
                extractorInput.resetPeekPosition();
                return;
            }
            extractorInput.skipFully(this.pageHeader.headerSize + this.pageHeader.bodySize);
            this.start = extractorInput.getPosition();
            this.startGranule = this.pageHeader.granulePosition;
        }
    }

    /* access modifiers changed from: package-private */
    public long readGranuleOfLastPage(ExtractorInput extractorInput) throws IOException {
        this.pageHeader.reset();
        if (this.pageHeader.skipToNextPage(extractorInput)) {
            this.pageHeader.populate(extractorInput, false);
            extractorInput.skipFully(this.pageHeader.headerSize + this.pageHeader.bodySize);
            long j = this.pageHeader.granulePosition;
            while ((this.pageHeader.type & 4) != 4 && this.pageHeader.skipToNextPage(extractorInput) && extractorInput.getPosition() < this.payloadEndPosition && this.pageHeader.populate(extractorInput, true) && ExtractorUtil.skipFullyQuietly(extractorInput, this.pageHeader.headerSize + this.pageHeader.bodySize)) {
                j = this.pageHeader.granulePosition;
            }
            return j;
        }
        throw new EOFException();
    }

    private final class OggSeekMap implements SeekMap {
        public boolean isSeekable() {
            return true;
        }

        private OggSeekMap() {
        }

        public SeekMap.SeekPoints getSeekPoints(long j) {
            return new SeekMap.SeekPoints(new SeekPoint(j, Util.constrainValue((DefaultOggSeeker.this.payloadStartPosition + ((DefaultOggSeeker.this.streamReader.convertTimeToGranule(j) * (DefaultOggSeeker.this.payloadEndPosition - DefaultOggSeeker.this.payloadStartPosition)) / DefaultOggSeeker.this.totalGranules)) - 30000, DefaultOggSeeker.this.payloadStartPosition, DefaultOggSeeker.this.payloadEndPosition - 1)));
        }

        public long getDurationUs() {
            return DefaultOggSeeker.this.streamReader.convertGranuleToTime(DefaultOggSeeker.this.totalGranules);
        }
    }
}
