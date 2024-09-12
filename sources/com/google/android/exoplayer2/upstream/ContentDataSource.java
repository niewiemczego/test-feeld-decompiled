package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.util.Util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class ContentDataSource extends BaseDataSource {
    private AssetFileDescriptor assetFileDescriptor;
    private long bytesRemaining;
    private FileInputStream inputStream;
    private boolean opened;
    private final ContentResolver resolver;
    private Uri uri;

    public static class ContentDataSourceException extends DataSourceException {
        @Deprecated
        public ContentDataSourceException(IOException iOException) {
            this(iOException, 2000);
        }

        public ContentDataSourceException(IOException iOException, int i) {
            super((Throwable) iOException, i);
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.resolver = context.getContentResolver();
    }

    public long open(DataSpec dataSpec) throws ContentDataSourceException {
        AssetFileDescriptor assetFileDescriptor2;
        DataSpec dataSpec2 = dataSpec;
        int i = 2000;
        try {
            Uri uri2 = dataSpec2.uri;
            this.uri = uri2;
            transferInitializing(dataSpec);
            if ("content".equals(dataSpec2.uri.getScheme())) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                assetFileDescriptor2 = this.resolver.openTypedAssetFileDescriptor(uri2, "*/*", bundle);
            } else {
                assetFileDescriptor2 = this.resolver.openAssetFileDescriptor(uri2, "r");
            }
            this.assetFileDescriptor = assetFileDescriptor2;
            if (assetFileDescriptor2 != null) {
                long length = assetFileDescriptor2.getLength();
                FileInputStream fileInputStream = new FileInputStream(assetFileDescriptor2.getFileDescriptor());
                this.inputStream = fileInputStream;
                int i2 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
                if (i2 != 0) {
                    if (dataSpec2.position > length) {
                        throw new ContentDataSourceException((IOException) null, 2008);
                    }
                }
                long startOffset = assetFileDescriptor2.getStartOffset();
                long j = length;
                long skip = fileInputStream.skip(dataSpec2.position + startOffset) - startOffset;
                if (skip == dataSpec2.position) {
                    if (i2 == 0) {
                        FileChannel channel = fileInputStream.getChannel();
                        long size = channel.size();
                        if (size == 0) {
                            this.bytesRemaining = -1;
                        } else {
                            long position = size - channel.position();
                            this.bytesRemaining = position;
                            if (position < 0) {
                                throw new ContentDataSourceException((IOException) null, 2008);
                            }
                        }
                    } else {
                        long j2 = j - skip;
                        this.bytesRemaining = j2;
                        if (j2 < 0) {
                            throw new ContentDataSourceException((IOException) null, 2008);
                        }
                    }
                    if (dataSpec2.length != -1) {
                        long j3 = this.bytesRemaining;
                        this.bytesRemaining = j3 == -1 ? dataSpec2.length : Math.min(j3, dataSpec2.length);
                    }
                    this.opened = true;
                    transferStarted(dataSpec);
                    return dataSpec2.length != -1 ? dataSpec2.length : this.bytesRemaining;
                }
                throw new ContentDataSourceException((IOException) null, 2008);
            }
            throw new ContentDataSourceException(new IOException("Could not open file descriptor for: " + uri2), 2000);
        } catch (ContentDataSourceException e) {
            throw e;
        } catch (IOException e2) {
            if (e2 instanceof FileNotFoundException) {
                i = PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND;
            }
            throw new ContentDataSourceException(e2, i);
        }
    }

    public int read(byte[] bArr, int i, int i2) throws ContentDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.bytesRemaining;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e) {
                throw new ContentDataSourceException(e, 2000);
            }
        }
        int read = ((FileInputStream) Util.castNonNull(this.inputStream)).read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.bytesRemaining;
        if (j2 != -1) {
            this.bytesRemaining = j2 - ((long) read);
        }
        bytesTransferred(read);
        return read;
    }

    public Uri getUri() {
        return this.uri;
    }

    public void close() throws ContentDataSourceException {
        this.uri = null;
        try {
            FileInputStream fileInputStream = this.inputStream;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.inputStream = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.assetFileDescriptor;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
            } catch (IOException e) {
                throw new ContentDataSourceException(e, 2000);
            } catch (Throwable th) {
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
                throw th;
            }
        } catch (IOException e2) {
            throw new ContentDataSourceException(e2, 2000);
        } catch (Throwable th2) {
            this.inputStream = null;
            try {
                AssetFileDescriptor assetFileDescriptor3 = this.assetFileDescriptor;
                if (assetFileDescriptor3 != null) {
                    assetFileDescriptor3.close();
                }
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
                throw th2;
            } catch (IOException e3) {
                throw new ContentDataSourceException(e3, 2000);
            } catch (Throwable th3) {
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
                throw th3;
            }
        }
    }
}
