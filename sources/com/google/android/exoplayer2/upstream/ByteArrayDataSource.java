package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public final class ByteArrayDataSource extends BaseDataSource {
    private int bytesRemaining;
    private final byte[] data;
    private boolean opened;
    private int readPosition;
    private Uri uri;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteArrayDataSource(byte[] bArr) {
        super(false);
        boolean z = false;
        Assertions.checkNotNull(bArr);
        Assertions.checkArgument(bArr.length > 0 ? true : z);
        this.data = bArr;
    }

    public long open(DataSpec dataSpec) throws IOException {
        this.uri = dataSpec.uri;
        transferInitializing(dataSpec);
        if (dataSpec.position <= ((long) this.data.length)) {
            this.readPosition = (int) dataSpec.position;
            this.bytesRemaining = this.data.length - ((int) dataSpec.position);
            if (dataSpec.length != -1) {
                this.bytesRemaining = (int) Math.min((long) this.bytesRemaining, dataSpec.length);
            }
            this.opened = true;
            transferStarted(dataSpec);
            return dataSpec.length != -1 ? dataSpec.length : (long) this.bytesRemaining;
        }
        throw new DataSourceException(2008);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.bytesRemaining;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.data, this.readPosition, bArr, i, min);
        this.readPosition += min;
        this.bytesRemaining -= min;
        bytesTransferred(min);
        return min;
    }

    public Uri getUri() {
        return this.uri;
    }

    public void close() {
        if (this.opened) {
            this.opened = false;
            transferEnded();
        }
        this.uri = null;
    }
}
