package com.caverock.androidsvg;

class IntegerParser {
    private int pos;
    private long value;

    IntegerParser(long j, int i) {
        this.value = j;
        this.pos = i;
    }

    /* access modifiers changed from: package-private */
    public int getEndPos() {
        return this.pos;
    }

    static IntegerParser parseInt(String str, int i, int i2, boolean z) {
        if (i >= i2) {
            return null;
        }
        boolean z2 = false;
        if (z) {
            char charAt = str.charAt(i);
            if (charAt != '+') {
                if (charAt == '-') {
                    z2 = true;
                }
            }
            i++;
        }
        long j = 0;
        int i3 = i;
        while (i3 < i2) {
            char charAt2 = str.charAt(i3);
            if (charAt2 < '0' || charAt2 > '9') {
                break;
            }
            if (z2) {
                j = (j * 10) - ((long) (charAt2 - '0'));
                if (j < -2147483648L) {
                    return null;
                }
            } else {
                j = (j * 10) + ((long) (charAt2 - '0'));
                if (j > 2147483647L) {
                    return null;
                }
            }
            i3++;
        }
        if (i3 == i) {
            return null;
        }
        return new IntegerParser(j, i3);
    }

    public int value() {
        return (int) this.value;
    }

    static IntegerParser parseHex(String str, int i, int i2) {
        long j;
        int i3;
        if (i >= i2) {
            return null;
        }
        long j2 = 0;
        int i4 = i;
        while (i4 < i2) {
            char charAt = str.charAt(i4);
            if (charAt < '0' || charAt > '9') {
                if (charAt < 'A' || charAt > 'F') {
                    if (charAt < 'a' || charAt > 'f') {
                        break;
                    }
                    j = j2 * 16;
                    i3 = charAt - 'a';
                } else {
                    j = j2 * 16;
                    i3 = charAt - 'A';
                }
                j2 = j + ((long) i3) + 10;
            } else {
                j2 = (j2 * 16) + ((long) (charAt - '0'));
            }
            if (j2 > 4294967295L) {
                return null;
            }
            i4++;
        }
        if (i4 == i) {
            return null;
        }
        return new IntegerParser(j2, i4);
    }
}
