package com.facebook.imagepipeline.common;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.HashCodeUtil;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public class BytesRange {
    public static final int TO_END_OF_CONTENT = Integer.MAX_VALUE;
    @Nullable
    private static Pattern sHeaderParsingRegEx;
    public final int from;
    public final int to;

    public BytesRange(int i, int i2) {
        this.from = i;
        this.to = i2;
    }

    public String toHttpRangeHeaderValue() {
        Locale locale = null;
        return String.format((Locale) null, "bytes=%s-%s", new Object[]{valueOrEmpty(this.from), valueOrEmpty(this.to)});
    }

    public boolean contains(@Nullable BytesRange bytesRange) {
        return bytesRange != null && this.from <= bytesRange.from && this.to >= bytesRange.to;
    }

    public String toString() {
        Locale locale = null;
        return String.format((Locale) null, "%s-%s", new Object[]{valueOrEmpty(this.from), valueOrEmpty(this.to)});
    }

    private static String valueOrEmpty(int i) {
        return i == Integer.MAX_VALUE ? "" : Integer.toString(i);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BytesRange)) {
            return false;
        }
        BytesRange bytesRange = (BytesRange) obj;
        if (this.from == bytesRange.from && this.to == bytesRange.to) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return HashCodeUtil.hashCode(this.from, this.to);
    }

    public static BytesRange from(int i) {
        Preconditions.checkArgument(Boolean.valueOf(i >= 0));
        return new BytesRange(i, Integer.MAX_VALUE);
    }

    public static BytesRange toMax(int i) {
        Preconditions.checkArgument(Boolean.valueOf(i > 0));
        return new BytesRange(0, i);
    }

    @Nullable
    public static BytesRange fromContentRangeHeader(@Nullable String str) throws IllegalArgumentException {
        if (str == null) {
            return null;
        }
        if (sHeaderParsingRegEx == null) {
            sHeaderParsingRegEx = Pattern.compile("[-/ ]");
        }
        try {
            String[] split = sHeaderParsingRegEx.split(str);
            Preconditions.checkArgument(Boolean.valueOf(split.length == 4));
            Preconditions.checkArgument(Boolean.valueOf(split[0].equals("bytes")));
            int parseInt = Integer.parseInt(split[1]);
            int parseInt2 = Integer.parseInt(split[2]);
            int parseInt3 = Integer.parseInt(split[3]);
            Preconditions.checkArgument(Boolean.valueOf(parseInt2 > parseInt));
            Preconditions.checkArgument(Boolean.valueOf(parseInt3 > parseInt2));
            if (parseInt2 < parseInt3 - 1) {
                return new BytesRange(parseInt, parseInt2);
            }
            return new BytesRange(parseInt, Integer.MAX_VALUE);
        } catch (IllegalArgumentException e) {
            Locale locale = null;
            throw new IllegalArgumentException(String.format((Locale) null, "Invalid Content-Range header value: \"%s\"", new Object[]{str}), e);
        }
    }
}
