package com.github.penfeizhou.animation.apng.decode;

import android.text.TextUtils;
import com.github.penfeizhou.animation.apng.io.APNGReader;
import java.io.IOException;

class Chunk {
    int crc;
    int fourcc;
    int length;
    int offset;

    /* access modifiers changed from: package-private */
    public void innerParse(APNGReader aPNGReader) throws IOException {
    }

    Chunk() {
    }

    static int fourCCToInt(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return -1159790593;
        }
        return ((str.charAt(3) & 255) << 24) | (str.charAt(0) & 255) | ((str.charAt(1) & 255) << 8) | ((str.charAt(2) & 255) << 16);
    }

    /* access modifiers changed from: package-private */
    public void parse(APNGReader aPNGReader) throws IOException {
        int available = aPNGReader.available();
        innerParse(aPNGReader);
        int available2 = available - aPNGReader.available();
        int i = this.length;
        if (available2 > i) {
            throw new IOException("Out of chunk area");
        } else if (available2 < i) {
            aPNGReader.skip((long) (i - available2));
        }
    }
}
