package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.io.IOException;

public final class BundledHlsMediaChunkExtractor implements HlsMediaChunkExtractor {
    private static final PositionHolder POSITION_HOLDER = new PositionHolder();
    final Extractor extractor;
    private final Format multivariantPlaylistFormat;
    private final TimestampAdjuster timestampAdjuster;

    public BundledHlsMediaChunkExtractor(Extractor extractor2, Format format, TimestampAdjuster timestampAdjuster2) {
        this.extractor = extractor2;
        this.multivariantPlaylistFormat = format;
        this.timestampAdjuster = timestampAdjuster2;
    }

    public void init(ExtractorOutput extractorOutput) {
        this.extractor.init(extractorOutput);
    }

    public boolean read(ExtractorInput extractorInput) throws IOException {
        return this.extractor.read(extractorInput, POSITION_HOLDER) == 0;
    }

    public boolean isPackedAudioExtractor() {
        Extractor extractor2 = this.extractor;
        return (extractor2 instanceof AdtsExtractor) || (extractor2 instanceof Ac3Extractor) || (extractor2 instanceof Ac4Extractor) || (extractor2 instanceof Mp3Extractor);
    }

    public boolean isReusable() {
        Extractor extractor2 = this.extractor;
        return (extractor2 instanceof TsExtractor) || (extractor2 instanceof FragmentedMp4Extractor);
    }

    public HlsMediaChunkExtractor recreate() {
        Extractor extractor2;
        Assertions.checkState(!isReusable());
        Extractor extractor3 = this.extractor;
        if (extractor3 instanceof WebvttExtractor) {
            extractor2 = new WebvttExtractor(this.multivariantPlaylistFormat.language, this.timestampAdjuster);
        } else if (extractor3 instanceof AdtsExtractor) {
            extractor2 = new AdtsExtractor();
        } else if (extractor3 instanceof Ac3Extractor) {
            extractor2 = new Ac3Extractor();
        } else if (extractor3 instanceof Ac4Extractor) {
            extractor2 = new Ac4Extractor();
        } else if (extractor3 instanceof Mp3Extractor) {
            extractor2 = new Mp3Extractor();
        } else {
            throw new IllegalStateException("Unexpected extractor type for recreation: " + this.extractor.getClass().getSimpleName());
        }
        return new BundledHlsMediaChunkExtractor(extractor2, this.multivariantPlaylistFormat, this.timestampAdjuster);
    }

    public void onTruncatedSegmentParsed() {
        this.extractor.seek(0, 0);
    }
}
