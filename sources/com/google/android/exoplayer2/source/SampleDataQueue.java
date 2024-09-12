package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.upstream.Allocation;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

class SampleDataQueue {
    private static final int INITIAL_SCRATCH_SIZE = 32;
    private final int allocationLength;
    private final Allocator allocator;
    private AllocationNode firstAllocationNode;
    private AllocationNode readAllocationNode;
    private final ParsableByteArray scratch = new ParsableByteArray(32);
    private long totalBytesWritten;
    private AllocationNode writeAllocationNode;

    public SampleDataQueue(Allocator allocator2) {
        this.allocator = allocator2;
        int individualAllocationLength = allocator2.getIndividualAllocationLength();
        this.allocationLength = individualAllocationLength;
        AllocationNode allocationNode = new AllocationNode(0, individualAllocationLength);
        this.firstAllocationNode = allocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
    }

    public void reset() {
        clearAllocationNodes(this.firstAllocationNode);
        this.firstAllocationNode.reset(0, this.allocationLength);
        AllocationNode allocationNode = this.firstAllocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
        this.totalBytesWritten = 0;
        this.allocator.trim();
    }

    public void discardUpstreamSampleBytes(long j) {
        Assertions.checkArgument(j <= this.totalBytesWritten);
        this.totalBytesWritten = j;
        if (j == 0 || j == this.firstAllocationNode.startPosition) {
            clearAllocationNodes(this.firstAllocationNode);
            AllocationNode allocationNode = new AllocationNode(this.totalBytesWritten, this.allocationLength);
            this.firstAllocationNode = allocationNode;
            this.readAllocationNode = allocationNode;
            this.writeAllocationNode = allocationNode;
            return;
        }
        AllocationNode allocationNode2 = this.firstAllocationNode;
        while (this.totalBytesWritten > allocationNode2.endPosition) {
            allocationNode2 = allocationNode2.next;
        }
        AllocationNode allocationNode3 = (AllocationNode) Assertions.checkNotNull(allocationNode2.next);
        clearAllocationNodes(allocationNode3);
        allocationNode2.next = new AllocationNode(allocationNode2.endPosition, this.allocationLength);
        this.writeAllocationNode = this.totalBytesWritten == allocationNode2.endPosition ? allocationNode2.next : allocationNode2;
        if (this.readAllocationNode == allocationNode3) {
            this.readAllocationNode = allocationNode2.next;
        }
    }

    public void rewind() {
        this.readAllocationNode = this.firstAllocationNode;
    }

    public void readToBuffer(DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder) {
        this.readAllocationNode = readSampleData(this.readAllocationNode, decoderInputBuffer, sampleExtrasHolder, this.scratch);
    }

    public void peekToBuffer(DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder) {
        readSampleData(this.readAllocationNode, decoderInputBuffer, sampleExtrasHolder, this.scratch);
    }

    public void discardDownstreamTo(long j) {
        if (j != -1) {
            while (j >= this.firstAllocationNode.endPosition) {
                this.allocator.release(this.firstAllocationNode.allocation);
                this.firstAllocationNode = this.firstAllocationNode.clear();
            }
            if (this.readAllocationNode.startPosition < this.firstAllocationNode.startPosition) {
                this.readAllocationNode = this.firstAllocationNode;
            }
        }
    }

    public long getTotalBytesWritten() {
        return this.totalBytesWritten;
    }

    public int sampleData(DataReader dataReader, int i, boolean z) throws IOException {
        int read = dataReader.read(this.writeAllocationNode.allocation.data, this.writeAllocationNode.translateOffset(this.totalBytesWritten), preAppend(i));
        if (read != -1) {
            postAppend(read);
            return read;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public void sampleData(ParsableByteArray parsableByteArray, int i) {
        while (i > 0) {
            int preAppend = preAppend(i);
            parsableByteArray.readBytes(this.writeAllocationNode.allocation.data, this.writeAllocationNode.translateOffset(this.totalBytesWritten), preAppend);
            i -= preAppend;
            postAppend(preAppend);
        }
    }

    private void clearAllocationNodes(AllocationNode allocationNode) {
        if (allocationNode.allocation != null) {
            this.allocator.release((Allocator.AllocationNode) allocationNode);
            allocationNode.clear();
        }
    }

    private int preAppend(int i) {
        if (this.writeAllocationNode.allocation == null) {
            this.writeAllocationNode.initialize(this.allocator.allocate(), new AllocationNode(this.writeAllocationNode.endPosition, this.allocationLength));
        }
        return Math.min(i, (int) (this.writeAllocationNode.endPosition - this.totalBytesWritten));
    }

    private void postAppend(int i) {
        long j = this.totalBytesWritten + ((long) i);
        this.totalBytesWritten = j;
        if (j == this.writeAllocationNode.endPosition) {
            this.writeAllocationNode = this.writeAllocationNode.next;
        }
    }

    private static AllocationNode readSampleData(AllocationNode allocationNode, DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder, ParsableByteArray parsableByteArray) {
        if (decoderInputBuffer.isEncrypted()) {
            allocationNode = readEncryptionData(allocationNode, decoderInputBuffer, sampleExtrasHolder, parsableByteArray);
        }
        if (decoderInputBuffer.hasSupplementalData()) {
            parsableByteArray.reset(4);
            AllocationNode readData = readData(allocationNode, sampleExtrasHolder.offset, parsableByteArray.getData(), 4);
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            sampleExtrasHolder.offset += 4;
            sampleExtrasHolder.size -= 4;
            decoderInputBuffer.ensureSpaceForWrite(readUnsignedIntToInt);
            AllocationNode readData2 = readData(readData, sampleExtrasHolder.offset, decoderInputBuffer.data, readUnsignedIntToInt);
            sampleExtrasHolder.offset += (long) readUnsignedIntToInt;
            sampleExtrasHolder.size -= readUnsignedIntToInt;
            decoderInputBuffer.resetSupplementalData(sampleExtrasHolder.size);
            return readData(readData2, sampleExtrasHolder.offset, decoderInputBuffer.supplementalData, sampleExtrasHolder.size);
        }
        decoderInputBuffer.ensureSpaceForWrite(sampleExtrasHolder.size);
        return readData(allocationNode, sampleExtrasHolder.offset, decoderInputBuffer.data, sampleExtrasHolder.size);
    }

    private static AllocationNode readEncryptionData(AllocationNode allocationNode, DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder, ParsableByteArray parsableByteArray) {
        SampleQueue.SampleExtrasHolder sampleExtrasHolder2 = sampleExtrasHolder;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        long j = sampleExtrasHolder2.offset;
        int i = 1;
        parsableByteArray2.reset(1);
        AllocationNode readData = readData(allocationNode, j, parsableByteArray.getData(), 1);
        long j2 = j + 1;
        byte b = parsableByteArray.getData()[0];
        boolean z = (b & 128) != 0;
        byte b2 = b & Byte.MAX_VALUE;
        CryptoInfo cryptoInfo = decoderInputBuffer.cryptoInfo;
        if (cryptoInfo.iv == null) {
            cryptoInfo.iv = new byte[16];
        } else {
            Arrays.fill(cryptoInfo.iv, (byte) 0);
        }
        AllocationNode readData2 = readData(readData, j2, cryptoInfo.iv, (int) b2);
        long j3 = j2 + ((long) b2);
        if (z) {
            parsableByteArray2.reset(2);
            readData2 = readData(readData2, j3, parsableByteArray.getData(), 2);
            j3 += 2;
            i = parsableByteArray.readUnsignedShort();
        }
        int i2 = i;
        int[] iArr = cryptoInfo.numBytesOfClearData;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cryptoInfo.numBytesOfEncryptedData;
        if (iArr3 == null || iArr3.length < i2) {
            iArr3 = new int[i2];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i3 = i2 * 6;
            parsableByteArray2.reset(i3);
            readData2 = readData(readData2, j3, parsableByteArray.getData(), i3);
            j3 += (long) i3;
            parsableByteArray2.setPosition(0);
            for (int i4 = 0; i4 < i2; i4++) {
                iArr2[i4] = parsableByteArray.readUnsignedShort();
                iArr4[i4] = parsableByteArray.readUnsignedIntToInt();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = sampleExtrasHolder2.size - ((int) (j3 - sampleExtrasHolder2.offset));
        }
        TrackOutput.CryptoData cryptoData = (TrackOutput.CryptoData) Util.castNonNull(sampleExtrasHolder2.cryptoData);
        cryptoInfo.set(i2, iArr2, iArr4, cryptoData.encryptionKey, cryptoInfo.iv, cryptoData.cryptoMode, cryptoData.encryptedBlocks, cryptoData.clearBlocks);
        int i5 = (int) (j3 - sampleExtrasHolder2.offset);
        sampleExtrasHolder2.offset += (long) i5;
        sampleExtrasHolder2.size -= i5;
        return readData2;
    }

    private static AllocationNode readData(AllocationNode allocationNode, long j, ByteBuffer byteBuffer, int i) {
        AllocationNode nodeContainingPosition = getNodeContainingPosition(allocationNode, j);
        while (i > 0) {
            int min = Math.min(i, (int) (nodeContainingPosition.endPosition - j));
            byteBuffer.put(nodeContainingPosition.allocation.data, nodeContainingPosition.translateOffset(j), min);
            i -= min;
            j += (long) min;
            if (j == nodeContainingPosition.endPosition) {
                nodeContainingPosition = nodeContainingPosition.next;
            }
        }
        return nodeContainingPosition;
    }

    private static AllocationNode readData(AllocationNode allocationNode, long j, byte[] bArr, int i) {
        AllocationNode nodeContainingPosition = getNodeContainingPosition(allocationNode, j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (nodeContainingPosition.endPosition - j));
            System.arraycopy(nodeContainingPosition.allocation.data, nodeContainingPosition.translateOffset(j), bArr, i - i2, min);
            i2 -= min;
            j += (long) min;
            if (j == nodeContainingPosition.endPosition) {
                nodeContainingPosition = nodeContainingPosition.next;
            }
        }
        return nodeContainingPosition;
    }

    private static AllocationNode getNodeContainingPosition(AllocationNode allocationNode, long j) {
        while (j >= allocationNode.endPosition) {
            allocationNode = allocationNode.next;
        }
        return allocationNode;
    }

    private static final class AllocationNode implements Allocator.AllocationNode {
        public Allocation allocation;
        public long endPosition;
        public AllocationNode next;
        public long startPosition;

        public AllocationNode(long j, int i) {
            reset(j, i);
        }

        public void reset(long j, int i) {
            Assertions.checkState(this.allocation == null);
            this.startPosition = j;
            this.endPosition = j + ((long) i);
        }

        public void initialize(Allocation allocation2, AllocationNode allocationNode) {
            this.allocation = allocation2;
            this.next = allocationNode;
        }

        public int translateOffset(long j) {
            return ((int) (j - this.startPosition)) + this.allocation.offset;
        }

        public AllocationNode clear() {
            this.allocation = null;
            AllocationNode allocationNode = this.next;
            this.next = null;
            return allocationNode;
        }

        public Allocation getAllocation() {
            return (Allocation) Assertions.checkNotNull(this.allocation);
        }

        public Allocator.AllocationNode next() {
            AllocationNode allocationNode = this.next;
            if (allocationNode == null || allocationNode.allocation == null) {
                return null;
            }
            return allocationNode;
        }
    }
}
