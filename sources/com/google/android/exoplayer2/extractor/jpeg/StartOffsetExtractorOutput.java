package com.google.android.exoplayer2.extractor.jpeg;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;

public final class StartOffsetExtractorOutput implements ExtractorOutput {
    private final ExtractorOutput extractorOutput;
    /* access modifiers changed from: private */
    public final long startOffset;

    public StartOffsetExtractorOutput(long j, ExtractorOutput extractorOutput2) {
        this.startOffset = j;
        this.extractorOutput = extractorOutput2;
    }

    public TrackOutput track(int i, int i2) {
        return this.extractorOutput.track(i, i2);
    }

    public void endTracks() {
        this.extractorOutput.endTracks();
    }

    public void seekMap(final SeekMap seekMap) {
        this.extractorOutput.seekMap(new SeekMap() {
            public boolean isSeekable() {
                return seekMap.isSeekable();
            }

            public long getDurationUs() {
                return seekMap.getDurationUs();
            }

            public SeekMap.SeekPoints getSeekPoints(long j) {
                SeekMap.SeekPoints seekPoints = seekMap.getSeekPoints(j);
                return new SeekMap.SeekPoints(new SeekPoint(seekPoints.first.timeUs, seekPoints.first.position + StartOffsetExtractorOutput.this.startOffset), new SeekPoint(seekPoints.second.timeUs, seekPoints.second.position + StartOffsetExtractorOutput.this.startOffset));
            }
        });
    }
}
