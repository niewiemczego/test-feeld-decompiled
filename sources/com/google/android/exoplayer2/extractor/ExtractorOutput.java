package com.google.android.exoplayer2.extractor;

public interface ExtractorOutput {
    public static final ExtractorOutput PLACEHOLDER = new ExtractorOutput() {
        public TrackOutput track(int i, int i2) {
            throw new UnsupportedOperationException();
        }

        public void endTracks() {
            throw new UnsupportedOperationException();
        }

        public void seekMap(SeekMap seekMap) {
            throw new UnsupportedOperationException();
        }
    };

    void endTracks();

    void seekMap(SeekMap seekMap);

    TrackOutput track(int i, int i2);
}
