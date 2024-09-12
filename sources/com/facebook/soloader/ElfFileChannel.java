package com.facebook.soloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ElfFileChannel implements ElfByteChannel {
    private FileChannel mFc;
    private File mFile;
    private FileInputStream mIs;

    public ElfFileChannel(File file) throws IOException {
        this.mFile = file;
        openChannel();
    }

    public void openChannel() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(this.mFile);
        this.mIs = fileInputStream;
        this.mFc = fileInputStream.getChannel();
    }

    public long position() throws IOException {
        return this.mFc.position();
    }

    public ElfByteChannel position(long j) throws IOException {
        this.mFc.position(j);
        return this;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        return this.mFc.read(byteBuffer);
    }

    public int read(ByteBuffer byteBuffer, long j) throws IOException {
        return this.mFc.read(byteBuffer, j);
    }

    public long size() throws IOException {
        return this.mFc.size();
    }

    public ElfByteChannel truncate(long j) throws IOException {
        this.mFc.truncate(j);
        return this;
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        return this.mFc.write(byteBuffer);
    }

    public void close() throws IOException {
        this.mIs.close();
    }

    public boolean isOpen() {
        return this.mFc.isOpen();
    }
}
