package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import java.io.IOException;

public final class PlaceholderDataSource implements DataSource {
    public static final DataSource.Factory FACTORY = new PlaceholderDataSource$$ExternalSyntheticLambda0();
    public static final PlaceholderDataSource INSTANCE = new PlaceholderDataSource();

    public static /* synthetic */ PlaceholderDataSource $r8$lambda$Qku_15DubQGfyuKLu3QSDqilS4U() {
        return new PlaceholderDataSource();
    }

    public void addTransferListener(TransferListener transferListener) {
    }

    public void close() {
    }

    public Uri getUri() {
        return null;
    }

    private PlaceholderDataSource() {
    }

    public long open(DataSpec dataSpec) throws IOException {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    public int read(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }
}
