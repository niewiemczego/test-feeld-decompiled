package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;

class BoundedByteString extends LiteralByteString {
    private final int bytesLength;
    private final int bytesOffset;

    BoundedByteString(byte[] bArr, int i, int i2) {
        super(bArr);
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuilder(29).append("Offset too small: ").append(i).toString());
        } else if (i2 < 0) {
            throw new IllegalArgumentException(new StringBuilder(29).append("Length too small: ").append(i).toString());
        } else if (((long) i) + ((long) i2) <= ((long) bArr.length)) {
            this.bytesOffset = i;
            this.bytesLength = i2;
        } else {
            throw new IllegalArgumentException(new StringBuilder(48).append("Offset+Length too large: ").append(i).append("+").append(i2).toString());
        }
    }

    public byte byteAt(int i) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(28).append("Index too small: ").append(i).toString());
        } else if (i < size()) {
            return this.bytes[this.bytesOffset + i];
        } else {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(41).append("Index too large: ").append(i).append(", ").append(size()).toString());
        }
    }

    public int size() {
        return this.bytesLength;
    }

    /* access modifiers changed from: protected */
    public int getOffsetIntoBytes() {
        return this.bytesOffset;
    }

    /* access modifiers changed from: protected */
    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.bytes, getOffsetIntoBytes() + i, bArr, i2, i3);
    }

    public ByteString.ByteIterator iterator() {
        return new BoundedByteIterator();
    }

    private class BoundedByteIterator implements ByteString.ByteIterator {
        private final int limit;
        private int position;

        private BoundedByteIterator() {
            int offsetIntoBytes = BoundedByteString.this.getOffsetIntoBytes();
            this.position = offsetIntoBytes;
            this.limit = offsetIntoBytes + BoundedByteString.this.size();
        }

        public boolean hasNext() {
            return this.position < this.limit;
        }

        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        public byte nextByte() {
            if (this.position < this.limit) {
                byte[] bArr = BoundedByteString.this.bytes;
                int i = this.position;
                this.position = i + 1;
                return bArr[i];
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
